package com.tencent.qqnt.emotion.stickerrecommended.impl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.aio.data.AIOContact;
import com.tencent.ark.ark;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.BloomFilter;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCacheEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendSortEntity;
import com.tencent.mobileqq.aio.api.IQQTabApi;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.temp.report.StatisticCollector;
import com.tencent.mobileqq.transfile.ProtoServlet;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.PkgTools;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOIceBreakApi;
import com.tencent.qqnt.emoticon.api.IEmoticonApi;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;
import com.tencent.qqnt.emotion.api.IFavroamingDBManagerService;
import com.tencent.qqnt.emotion.protocol.PicSearchSvr$EmotionInfo;
import com.tencent.qqnt.emotion.protocol.PicSearchSvr$ImgInfo;
import com.tencent.qqnt.emotion.protocol.PicSearchSvr$ReqBody;
import com.tencent.qqnt.emotion.protocol.PicSearchSvr$RspBody;
import com.tencent.qqnt.emotion.protocol.PicSearchWordsSvr$ReqBody;
import com.tencent.qqnt.emotion.protocol.PicSearchWordsSvr$RspBody;
import com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager;
import com.tencent.qqnt.emotion.stickerrecommended.InputMaterialCacheKeyParser;
import com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.StickerRecKeywordFrom;
import com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.f;
import com.tencent.qqnt.emotion.stickerrecommended.config.StickerRecConfigManager;
import com.tencent.qqnt.emotion.stickerrecommended.g;
import com.tencent.qqnt.emotion.stickerrecommended.h;
import com.tencent.qqnt.emotion.stickerrecommended.i;
import com.tencent.qqnt.emotion.stickerrecommended.l;
import com.tencent.qqnt.emotion.stickerrecommended.n;
import com.tencent.qqnt.emotion.stickerrecommended.o;
import com.tencent.qqnt.emotion.stickerrecommended.r;
import com.tencent.qqnt.emotion.stickerrecommended.s;
import com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.IScenesRecommendManager;
import com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.c;
import com.tencent.qqnt.emotion.stickerrecommended.t;
import com.tencent.qqnt.emotion.stickerrecommended.u;
import com.tencent.qqnt.emotion.stickerrecommended.v;
import com.tencent.qqnt.emotion.stickerrecommended.w;
import com.tencent.qqnt.emotion.stickerrecommended.y;
import com.tencent.qqnt.emotion.stickerrecommended.z;
import com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanAdapterApi;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.b;
import com.tencent.qqnt.http.api.m;
import com.tencent.qqnt.util.b;
import com.tencent.util.ThrowablesUtils;
import com.tencent.util.k;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes24.dex */
public class StickerRecManagerImpl implements IStickerRecManager {
    static IPatchRedirector $redirector_ = null;
    private static final String CMD_PULL_PICS = "PicSearchSvr.PullPics";
    private static final String CMD_PULL_WORDS = "PicSearchWordsSvr.PullWords";
    private static final String CMD_SCENES_PULL_PICS = "SceneFaceRec.PullFaces";
    private static final String ENCODED_BLOOM_NAME = "encodedBloom.bin";
    private static final String LOCAL_WORDS_FILE_NAME = "local_words.bin";
    public static final String MOBILEQQ_RECOMMENDED_STICKER_CONFIG = "MOBILEQQ_RECOMMENDED_STICKER_CONFIG";
    public static final String RECOMMENDED_STICKER_MAX_MATCH_LENGTH = "RECOMMENDED_STICKER_MAX_MATCH_LENGTH";
    public static final String RECOMMENDED_STICKER_SWITCH = "RECOMMENDED_STICKER_SWITCH";
    public static final String RECOMMENDED_STICKER_VERSION = "RECOMMENDED_STICKER_VERSION";
    public static final String REPORT_TAG_SUCC = "param_succ_flag";
    private static final String REQUEST_AIO_TYPE = "request_aio_type";
    private static final String REQUEST_SCENES_ID_KEY = "REQUEST_SCENES_ID";
    private static final long SMALL_EMOJI_ENTRANCE = 1003;
    private static final String SSO_CMD_REPORT_NEW = "MQInference.CommonReport";
    private static final String STICKER_REC_KEYWORD_FROM = "StickerRecKeywordFrom";
    public static final String TAG = "StickerRecManager";
    private static final String USER_KEYWORD_KEY = "USER_KEYWORD";
    private static final String WORDS_FILE_NAME = "words.json";
    private static final String WORDS_VERSION_KEY = "words_version_key805_gray_one";
    private static final String WORDS_ZIP_FILE_NAME = "words.zip";
    private static Integer sMaxMatchLength;
    private static Boolean sRecStickerSwitch;
    private BloomFilter bloomFilter;
    private IEmoticonManagerService emoticonManager;
    private boolean emotionRecSettingSwitch;
    private com.tencent.qqnt.emotion.db.a entityManager;
    private boolean hasFilteredZPlanMeme;
    private volatile boolean hasInit;
    private IStickerRecManager.a imgUpdateListener;
    private final boolean isSupportMallEmoticon;
    private long mCacheTime;
    private Long mCurrentLoginAccountLongUin;
    private String mCurrentLoginAccountUin;
    private volatile String mCurrentText;
    private MqqHandler mDbHandler;
    private File mDownloadFile;
    private File mEncodedBloomFile;
    private s mFavEmoticonHandleListener;
    private boolean mForbidInsertOtherEmotion;
    private boolean mForceUpdateCache;
    private boolean mHasPullWords;
    private HashSet<String> mLocalKeywordsSet;
    private File mLocalWordsFile;
    private IQQTabApi.a mQQTabEntity;
    private String mSessionId;
    private List<h> mStickerRecLocalEmoticonChangeListeners;
    private List<z> mStickerReportItems;
    private File mWordsFile;
    private int maxMatchLength;
    public List<g> stickerRecDataLocalList;
    private int zPlanIndex;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45620);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 45)) {
            redirector.redirect((short) 45);
        } else {
            sRecStickerSwitch = null;
            sMaxMatchLength = null;
        }
    }

    public StickerRecManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.hasInit = false;
        this.maxMatchLength = 6;
        this.entityManager = null;
        this.emoticonManager = null;
        this.mStickerReportItems = new ArrayList();
        this.mCurrentText = "";
        this.mLocalKeywordsSet = null;
        this.stickerRecDataLocalList = new CopyOnWriteArrayList();
        this.mForceUpdateCache = false;
        this.mForbidInsertOtherEmotion = false;
        this.mSessionId = "";
        this.emotionRecSettingSwitch = true;
        this.mDbHandler = ThreadManager.getFileThreadHandler();
        this.zPlanIndex = -1;
        this.hasFilteredZPlanMeme = false;
        this.mHasPullWords = false;
        this.mQQTabEntity = null;
        this.mCacheTime = 86400000L;
        this.bloomFilter = null;
        boolean isSwitchOn = FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("emoticon_sticker_rec_support_mall_124908873", true);
        this.isSupportMallEmoticon = isSwitchOn;
        QLog.i("StickerRecManager", 1, "emoticon_sticker_rec_support_mall_124908873" + isSwitchOn);
    }

    private void cacheResInDb(byte[] bArr, String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "cache pics in DB");
        }
        if (this.entityManager != null) {
            StickerRecommendEntity stickerRecommendEntity = new StickerRecommendEntity();
            stickerRecommendEntity.usrMessage = str;
            stickerRecommendEntity.recList = Base64.encodeToString(bArr, 0);
            stickerRecommendEntity.cachedTime = System.currentTimeMillis();
            stickerRecommendEntity.recommendType = i3;
            this.mDbHandler.post(new Runnable(stickerRecommendEntity) { // from class: com.tencent.qqnt.emotion.stickerrecommended.impl.StickerRecManagerImpl.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ StickerRecommendEntity f356540d;

                {
                    this.f356540d = stickerRecommendEntity;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) StickerRecManagerImpl.this, (Object) stickerRecommendEntity);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        StickerRecManagerImpl.this.entityManager.g(this.f356540d);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int convertAIOType(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 == 3) {
            return 3;
        }
        return 4;
    }

    @NotNull
    private List<g> fillData(int i3, PicSearchSvr$RspBody picSearchSvr$RspBody, List<PicSearchSvr$ImgInfo> list) {
        String str;
        if (picSearchSvr$RspBody.bytes_rsp_other.has()) {
            str = picSearchSvr$RspBody.bytes_rsp_other.get().toStringUtf8();
        } else {
            str = null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < list.size(); i16++) {
            PicSearchSvr$ImgInfo picSearchSvr$ImgInfo = list.get(i16);
            o oVar = new o();
            oVar.N(i16);
            oVar.I(picSearchSvr$ImgInfo.uint64_img_size.get());
            oVar.M(picSearchSvr$ImgInfo.uint32_img_width.get());
            oVar.J(picSearchSvr$ImgInfo.uint32_img_height.get());
            oVar.K(picSearchSvr$ImgInfo.bytes_img_md5.get().toStringUtf8());
            oVar.L(picSearchSvr$ImgInfo.bytes_img_down_url.get().toStringUtf8());
            oVar.V(picSearchSvr$ImgInfo.uint64_thumb_size.get());
            oVar.W(picSearchSvr$ImgInfo.uint32_thumb_img_height.get());
            oVar.Z(picSearchSvr$ImgInfo.uint32_thumb_img_width.get());
            oVar.Y(picSearchSvr$ImgInfo.bytes_thumb_down_url.get().toStringUtf8());
            oVar.X(picSearchSvr$ImgInfo.bytes_thumb_img_md5.get().toStringUtf8());
            oVar.G(picSearchSvr$ImgInfo.uint32_src_type.get());
            oVar.U(picSearchSvr$ImgInfo.bytes_src_desc.get().toStringUtf8());
            oVar.a0(picSearchSvr$ImgInfo.bytes_web_url.get().toStringUtf8());
            oVar.H("");
            oVar.R(picSearchSvr$ImgInfo.bytes_pack_name.get().toStringUtf8());
            oVar.E(picSearchSvr$ImgInfo.uint32_pack_id.get());
            if (picSearchSvr$ImgInfo.bytes_img_other.has()) {
                oVar.C(picSearchSvr$ImgInfo.bytes_img_other.get().toStringUtf8());
            }
            oVar.T(str);
            oVar.S(i3);
            if (picSearchSvr$ImgInfo.msg_emotion_info.has()) {
                PicSearchSvr$EmotionInfo picSearchSvr$EmotionInfo = picSearchSvr$ImgInfo.msg_emotion_info;
                if (picSearchSvr$EmotionInfo.bytes_url.has()) {
                    oVar.b0(picSearchSvr$EmotionInfo.bytes_url.get().toStringUtf8());
                }
            }
            if (oVar.k() == 3 && QLog.isColorLevel()) {
                QLog.i("StickerRecManager", 2, "receive ZPlanEmo from:" + oVar.k() + ", ZPlanInfo:" + k.f(oVar.z(), Arrays.asList("zh_name")));
            }
            if (picSearchSvr$ImgInfo.mall_emoji_info.get() != null) {
                o.a aVar = new o.a();
                aVar.f356620a = picSearchSvr$ImgInfo.mall_emoji_info.get().mall_emoji_pack_id.get();
                aVar.f356621b = picSearchSvr$ImgInfo.mall_emoji_info.get().mall_emoji_pic_id.get();
                oVar.Q(aVar);
            }
            arrayList.add(oVar);
        }
        return arrayList;
    }

    private List<g> filterData(List<g> list) {
        o oVar;
        String z16;
        boolean z17;
        ArrayList arrayList = new ArrayList(list);
        for (int i3 = 0; i3 < list.size(); i3++) {
            if ((list.get(i3) instanceof o) && (z16 = (oVar = (o) list.get(i3)).z()) != null) {
                try {
                    JSONObject jSONObject = new JSONObject(z16);
                    if (jSONObject.optInt("iszplan") == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        this.zPlanIndex = oVar.n();
                        String currentUin = getCurrentUin();
                        int portraitIdFromJson = getPortraitIdFromJson(jSONObject);
                        if (!TextUtils.isEmpty(currentUin) && isZPlanMemeRecordCompleted(portraitIdFromJson, currentUin, jSONObject)) {
                            this.hasFilteredZPlanMeme = false;
                            return arrayList;
                        }
                        arrayList.remove(i3);
                        this.hasFilteredZPlanMeme = true;
                        QLog.i("StickerRecManager", 1, "zplan meme has been filtered");
                        recordEmoticon(portraitIdFromJson, currentUin, jSONObject);
                        return arrayList;
                    }
                } catch (JSONException e16) {
                    QLog.e("StickerRecManager", 1, "filterData has exception:", e16);
                }
            }
        }
        return arrayList;
    }

    private void filterDuplicateMallEmoticons(List<g> list, List<g> list2) {
        String a16;
        String str;
        for (g gVar : list) {
            if (!(gVar instanceof t) && !(gVar instanceof r)) {
                str = null;
                a16 = null;
            } else {
                String g16 = gVar.g();
                a16 = gVar.a();
                str = g16;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(a16)) {
                Iterator<g> it = list2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        g next = it.next();
                        if (next instanceof o) {
                            o oVar = (o) next;
                            if (oVar.q() != null) {
                                o.a q16 = oVar.q();
                                if (TextUtils.equals(String.valueOf(q16.f356620a), str) && TextUtils.equals(q16.f356621b, a16)) {
                                    QLog.i("StickerRecManager", 1, "filterDuplicateMallEmoticons  epId:" + str + ", eId:" + a16);
                                    it.remove();
                                    break;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
            }
        }
    }

    public static IStickerRecManager get() {
        return get(MobileQQ.sMobileQQ.peekAppRuntime());
    }

    private String getCurrentUin() {
        return this.mCurrentLoginAccountUin;
    }

    private String getDataDir() {
        StringBuilder sb5 = new StringBuilder(BaseApplication.getContext().getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb5.append(str);
        sb5.append(this.mCurrentLoginAccountUin);
        sb5.append(str);
        sb5.append("qstorage");
        sb5.append(str);
        sb5.append("objs");
        sb5.append(str);
        sb5.append("sticker_recommend");
        return sb5.toString();
    }

    public static File getDiskFile(String str) {
        try {
            return new File(n.f356597a + Utils.Crc64String(str));
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static boolean getEmotionRecSettingSwitch(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("emotion_rec_setting_switch_" + str, true);
    }

    private StickerRecKeywordFrom getFrom(Intent intent) {
        return f.a(intent.getIntExtra(STICKER_REC_KEYWORD_FROM, -1));
    }

    public static long getLastTimeRemoveEmoticonPackage(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sticker_remove_emoticon_package_time_" + str, 0L);
    }

    public static int getMaxMatchLength(Context context, String str, int i3) {
        if (sMaxMatchLength == null) {
            sMaxMatchLength = Integer.valueOf(context.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).getInt("RECOMMENDED_STICKER_MAX_MATCH_LENGTH" + str, i3));
            return 6;
        }
        return 6;
    }

    private int getPortraitIdFromJson(JSONObject jSONObject) {
        int intValue;
        if (jSONObject == null) {
            return -1;
        }
        try {
            if (jSONObject.has(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID)) {
                intValue = ((Integer) jSONObject.get(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID)).intValue();
            } else if (jSONObject.has("actionId")) {
                intValue = ((Integer) jSONObject.get("actionId")).intValue();
            } else {
                if (!jSONObject.has("id")) {
                    return -1;
                }
                intValue = ((Integer) jSONObject.get("id")).intValue();
            }
            return intValue;
        } catch (JSONException e16) {
            QLog.e("StickerRecManager", 1, "getPortraitIdFromJson has exception:", e16);
            return -1;
        }
    }

    private String getPullPicsExtInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (isZPlanEnable()) {
                jSONObject.put("type", "zplan");
                jSONObject.put("ue_engine_version", ((INTZPlanAdapterApi) com.tencent.qqnt.aio.adapter.a.b(INTZPlanAdapterApi.class)).getZPlanVersion());
            } else {
                jSONObject.put("type", "cmshow");
            }
        } catch (JSONException e16) {
            QLog.w("StickerRecManager", 1, "getPullPicsExtInfo", e16);
        }
        return jSONObject.toString();
    }

    private synchronized PicSearchSvr$ReqBody getPullPicsRequestBody(String str, String str2, int i3, int i16, String str3, List<String> list) {
        PicSearchSvr$ReqBody picSearchSvr$ReqBody;
        picSearchSvr$ReqBody = new PicSearchSvr$ReqBody();
        picSearchSvr$ReqBody.setHasFlag(true);
        int i17 = getcmShowIsEnable();
        this.mSessionId = str;
        picSearchSvr$ReqBody.bytes_session_id.set(ByteStringMicro.copyFromUtf8(str));
        picSearchSvr$ReqBody.uint64_src_uin.set(Long.parseLong(str2));
        picSearchSvr$ReqBody.uint32_src_term.set(i3);
        picSearchSvr$ReqBody.uint32_aio_type.set(i16);
        picSearchSvr$ReqBody.uint64_to_uin.set(Long.parseLong(str3));
        picSearchSvr$ReqBody.uint32_open_emotion.set(i17);
        picSearchSvr$ReqBody.bytes_app_qua.set(ByteStringMicro.copyFromUtf8(b.f362976b.getQUA()));
        picSearchSvr$ReqBody.uint32_support_emotion.set(1);
        picSearchSvr$ReqBody.bytes_ext_info.set(ByteStringMicro.copyFromUtf8(getPullPicsExtInfo()));
        picSearchSvr$ReqBody.is_support_mall.set(this.isSupportMallEmoticon);
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ByteStringMicro.copyFromUtf8(it.next()));
            }
            picSearchSvr$ReqBody.bytes_key_word.set(arrayList);
        }
        return picSearchSvr$ReqBody;
    }

    public static boolean getRecStickerSwitch(Context context, String str, boolean z16) {
        if (sRecStickerSwitch == null) {
            sRecStickerSwitch = Boolean.valueOf(context.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).getBoolean("RECOMMENDED_STICKER_SWITCH" + str, z16));
        }
        return sRecStickerSwitch.booleanValue();
    }

    public static String getStickerRecVersion(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str2 + "_" + str, "");
    }

    private int getcmShowIsEnable() {
        boolean isCmShowKeywordAssociationEnabled = ((INTZPlanAdapterApi) com.tencent.qqnt.aio.adapter.a.b(INTZPlanAdapterApi.class)).isCmShowKeywordAssociationEnabled();
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "getcmShowIsEnable iscmsEnable : " + isCmShowKeywordAssociationEnabled);
        }
        return isCmShowKeywordAssociationEnabled ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleConfigPics(String str, boolean z16, int i3, StickerRecKeywordFrom stickerRecKeywordFrom) {
        List<g> sortDataOnlyByClick;
        List<g> list;
        StickerRecConfigManager.Companion companion = StickerRecConfigManager.INSTANCE;
        if (companion.a().o()) {
            if (QLog.isColorLevel()) {
                QLog.i("StickerRecManager", 2, "handleConfigPics is clean config");
            }
            com.tencent.qqnt.emotion.db.a aVar = this.entityManager;
            if (aVar != null) {
                aVar.b(StickerRecommendEntity.class.getSimpleName(), "recommendType!=1", new String[0]);
                this.entityManager.b(StickerRecommendSortEntity.class.getSimpleName(), "recommendType!=1", new String[0]);
            }
            companion.a().i();
            companion.a().y();
            return false;
        }
        companion.a().y();
        if (companion.a().n()) {
            if (QLog.isColorLevel()) {
                QLog.i("StickerRecManager", 2, "handleConfigPics config is expired");
            }
            companion.a().r();
            return false;
        }
        List<g> s16 = companion.a().s(str);
        if (s16 != null && !s16.isEmpty()) {
            StickerRecommendSortEntity stickerRecommendSortEntity = (StickerRecommendSortEntity) this.entityManager.e(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType!=1", new String[]{str});
            if (stickerRecommendSortEntity != null) {
                stickerRecommendSortEntity.convertToList();
            }
            if (!FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("emotion_8983_885194939", true)) {
                sortDataOnlyByClick = sortData(s16, stickerRecommendSortEntity);
            } else if (this.mQQTabEntity.isExperiment("exp_layer_through_B")) {
                sortDataOnlyByClick = sortData(s16, stickerRecommendSortEntity);
            } else {
                sortDataOnlyByClick = sortDataOnlyByClick(s16, str, i3);
            }
            if (sortDataOnlyByClick != null) {
                list = sortDataOnlyByClick;
            } else {
                list = s16;
            }
            if (!list.isEmpty()) {
                onImgUpdated(str, z16, i3, list, String.valueOf(list.size()), stickerRecKeywordFrom);
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.i("StickerRecManager", 2, "handleConfigPics dataList is empty");
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("StickerRecManager", 2, "handleConfigPics query dataList is null or empty");
        }
        return false;
    }

    private void handleEntity(StickerRecommendSortEntity stickerRecommendSortEntity) {
        List<Integer> list = stickerRecommendSortEntity.noExposeList;
        if (list == null) {
            return;
        }
        boolean z16 = false;
        if (list.size() == 1 && stickerRecommendSortEntity.noExposeList.get(0).intValue() == this.zPlanIndex) {
            z16 = true;
        }
        if (stickerRecommendSortEntity.noExposeList.size() == 0 || z16) {
            if (stickerRecommendSortEntity.exposedList.contains(Integer.valueOf(this.zPlanIndex))) {
                stickerRecommendSortEntity.exposedList.remove(Integer.valueOf(this.zPlanIndex));
                stickerRecommendSortEntity.noExposeList.add(Integer.valueOf(this.zPlanIndex));
            }
            stickerRecommendSortEntity.noExposeList.addAll(stickerRecommendSortEntity.exposedList);
            stickerRecommendSortEntity.exposedList.clear();
        }
    }

    private void handleLocalEmoticon(boolean z16, String str) {
        List<? extends g> b16;
        this.stickerRecDataLocalList.clear();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof BaseQQAppInterface)) {
            QLog.d("StickerRecManager", 1, "[handleLocalEmoticon] error, app is null!");
            return;
        }
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        ArrayList arrayList = new ArrayList();
        if (z16 && this.mStickerRecLocalEmoticonChangeListeners != null) {
            long currentTimeMillis = System.currentTimeMillis();
            for (h hVar : this.mStickerRecLocalEmoticonChangeListeners) {
                if (hVar.a(baseQQAppInterface, str) && (b16 = hVar.b(str)) != null && !b16.isEmpty()) {
                    arrayList.addAll(b16);
                }
            }
            List c16 = i.c(baseQQAppInterface, arrayList);
            if (c16 != null && !c16.isEmpty()) {
                this.stickerRecDataLocalList.addAll(c16);
            }
            for (int i3 = 0; i3 < this.stickerRecDataLocalList.size(); i3++) {
                this.stickerRecDataLocalList.get(i3).onEmoticonWillShow(baseQQAppInterface, i3);
            }
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecManager", 2, "handleLocalEmoticon time = " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePullPics(byte[] bArr, String str, String str2, boolean z16, StickerRecommendSortEntity stickerRecommendSortEntity, int i3, int i16, StickerRecKeywordFrom stickerRecKeywordFrom) {
        List<g> sortDataOnlyByClick;
        List<g> list;
        String str3;
        try {
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecManager", 2, "handlePullPics from : " + str2 + " | RecType=" + i3 + " | aiotype = " + i16);
            }
            PicSearchSvr$RspBody picSearchSvr$RspBody = new PicSearchSvr$RspBody();
            picSearchSvr$RspBody.mergeFrom(bArr);
            if (picSearchSvr$RspBody.int32_result.get() != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("StickerRecManager", 2, "handleResponse response code error,result:" + picSearchSvr$RspBody.int32_result.get() + " message : " + picSearchSvr$RspBody.bytes_fail_msg.get().toStringUtf8());
                    return;
                }
                return;
            }
            List<PicSearchSvr$ImgInfo> handleSearchEmptyImg = handleSearchEmptyImg(str, str2, i3, picSearchSvr$RspBody);
            if (handleSearchEmptyImg == null) {
                return;
            }
            List<g> fillData = fillData(i3, picSearchSvr$RspBody, handleSearchEmptyImg);
            if (this.mQQTabEntity == null) {
                this.mQQTabEntity = ((IQQTabApi) com.tencent.qqnt.aio.adapter.a.b(IQQTabApi.class)).getExpEntity("exp_layer_through", true);
            }
            StringBuilder sb5 = new StringBuilder("handlePullPics ");
            if (!FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("emotion_8983_885194939", true)) {
                sortDataOnlyByClick = sortData(fillData, stickerRecommendSortEntity);
                sb5.append(" freesia switch off");
            } else if (this.mQQTabEntity.isExperiment("exp_layer_through_B")) {
                sortDataOnlyByClick = sortData(fillData, stickerRecommendSortEntity);
                sb5.append(" ExperimentB");
            } else {
                sortDataOnlyByClick = sortDataOnlyByClick(fillData, str, i3);
                sb5.append(" ExperimentA");
            }
            if (sortDataOnlyByClick != null) {
                sb5.append(" sorted");
                fillData = sortDataOnlyByClick;
            }
            List<g> zplanEmoticonSort = zplanEmoticonSort(fillData, str2);
            List<g> perkData = perkData(zplanEmoticonSort, i16, z16, ((INTZPlanAdapterApi) com.tencent.qqnt.aio.adapter.a.b(INTZPlanAdapterApi.class)).isCmShowKeywordAssociationEnabled());
            if (perkData != null) {
                sb5.append(" perked");
                zplanEmoticonSort = perkData;
            }
            List<g> filterData = filterData(zplanEmoticonSort);
            List<g> list2 = this.stickerRecDataLocalList;
            if (list2 != null && !list2.isEmpty()) {
                filterDuplicateMallEmoticons(this.stickerRecDataLocalList, filterData);
                ArrayList arrayList = new ArrayList(filterData);
                arrayList.addAll(0, this.stickerRecDataLocalList);
                this.stickerRecDataLocalList.clear();
                list = arrayList;
            } else {
                list = filterData;
            }
            if ("network".equals(str2)) {
                str3 = picSearchSvr$RspBody.bytes_rsp_other.get().toStringUtf8();
            } else {
                str3 = "999";
            }
            onImgUpdated(str, z16, i3, list, str3, stickerRecKeywordFrom);
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecManager", 2, sb5.toString());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecManager", 2, ThrowablesUtils.getStackTraceAsString(e16));
            }
        }
    }

    private void handlePullWords(byte[] bArr) {
        try {
            PicSearchWordsSvr$RspBody picSearchWordsSvr$RspBody = new PicSearchWordsSvr$RspBody();
            picSearchWordsSvr$RspBody.mergeFrom(bArr);
            if (picSearchWordsSvr$RspBody.int32_result.get() != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("StickerRecManager", 2, "handlePullWords response code error,result:" + picSearchWordsSvr$RspBody.int32_result.get() + " message : " + picSearchWordsSvr$RspBody.bytes_fail_msg.get());
                    return;
                }
                return;
            }
            String stringUtf8 = picSearchWordsSvr$RspBody.words_msg.bytes_words_version.get().toStringUtf8();
            String stringUtf82 = picSearchWordsSvr$RspBody.words_msg.bytes_words_md5.get().toStringUtf8();
            String stringUtf83 = picSearchWordsSvr$RspBody.words_msg.bytes_words_url.get().toStringUtf8();
            int i3 = picSearchWordsSvr$RspBody.words_msg.uint32_words_type.get();
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecManager", 2, "pull words resp:version=" + stringUtf8 + " wordsMd5=" + stringUtf82 + " wordsUrl=" + stringUtf83 + " wordsType=" + i3);
            }
            String stickerRecVersion = getStickerRecVersion(BaseApplication.getContext(), WORDS_VERSION_KEY, this.mCurrentLoginAccountUin);
            if (stickerRecVersion.equals(stringUtf8) && this.mEncodedBloomFile.exists()) {
                if (QLog.isColorLevel()) {
                    QLog.d("StickerRecManager", 2, "not need pull words: localVersion=" + stickerRecVersion + " server version=" + stringUtf8);
                    return;
                }
                return;
            }
            updateWords(stringUtf83, stringUtf82, i3, stringUtf8);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecManager", 2, ThrowablesUtils.getStackTraceAsString(e16));
            }
        }
    }

    @Nullable
    private List<PicSearchSvr$ImgInfo> handleSearchEmptyImg(String str, String str2, int i3, PicSearchSvr$RspBody picSearchSvr$RspBody) {
        List<PicSearchSvr$ImgInfo> list = picSearchSvr$RspBody.rpt_msg_img_info.get();
        if (list != null && !list.isEmpty()) {
            return list;
        }
        if ("network".equals(str2)) {
            reportEmptyImg();
        }
        if (this.entityManager != null) {
            this.mDbHandler.post(new Runnable(i3, str) { // from class: com.tencent.qqnt.emotion.stickerrecommended.impl.StickerRecManagerImpl.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f356541d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f356542e;

                {
                    this.f356541d = i3;
                    this.f356542e = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, StickerRecManagerImpl.this, Integer.valueOf(i3), str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (this.f356541d == 1) {
                        StickerRecManagerImpl.this.entityManager.b(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType==1", new String[]{this.f356542e});
                    } else {
                        StickerRecManagerImpl.this.entityManager.b(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType!=1", new String[]{this.f356542e});
                    }
                }
            });
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "handleResponse imgInfos is null or empty");
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCacheValid(StickerRecommendEntity stickerRecommendEntity) {
        if (this.mForceUpdateCache || System.currentTimeMillis() - stickerRecommendEntity.cachedTime >= this.mCacheTime) {
            return false;
        }
        return true;
    }

    public static boolean isStickerRecFromLocal(g gVar) {
        return gVar.isStickerRecFromLocal();
    }

    public static boolean isStickerRecFromRemote(g gVar) {
        return !isStickerRecFromLocal(gVar);
    }

    private boolean isZPlanEnable() {
        return ((INTZPlanAdapterApi) com.tencent.qqnt.aio.adapter.a.b(INTZPlanAdapterApi.class)).isZPlanAccessible(1003L, this.mCurrentLoginAccountLongUin.longValue());
    }

    private boolean isZPlanMemeRecordCompleted(int i3, String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && i3 != -1) {
            return ((INTZPlanAdapterApi) com.tencent.qqnt.aio.adapter.a.b(INTZPlanAdapterApi.class)).isEmoticonPicRecorded(i3, str, jSONObject);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$analyze$0(String str, StickerRecKeywordFrom stickerRecKeywordFrom) {
        showLocalEmo(str, true, stickerRecKeywordFrom);
    }

    private void onImgUpdated(String str, boolean z16, int i3, List<g> list, String str2, StickerRecKeywordFrom stickerRecKeywordFrom) {
        String str3;
        c findScenesRecItemByID;
        IStickerRecManager.a aVar;
        if (z16 && (aVar = this.imgUpdateListener) != null) {
            aVar.a(list, str, str2, 0, null, stickerRecKeywordFrom);
            return;
        }
        if (this.imgUpdateListener != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (i3 == 1 && peekAppRuntime != null && (findScenesRecItemByID = ((IScenesRecommendManager) peekAppRuntime.getRuntimeService(IScenesRecommendManager.class, "")).findScenesRecItemByID(str)) != null) {
                str3 = findScenesRecItemByID.e();
            } else {
                str3 = null;
            }
            this.imgUpdateListener.a(list, str, str2, i3, str3, stickerRecKeywordFrom);
        }
    }

    private void putZplanEmoticonToFirst(List<g> list) {
        g gVar = list.get(0);
        if ((gVar instanceof o) && ((o) gVar).B()) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 < list.size()) {
                g gVar2 = list.get(i3);
                if ((gVar2 instanceof o) && ((o) gVar2).B()) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 > 0) {
            g gVar3 = list.get(i3);
            list.remove(i3);
            list.add(0, gVar3);
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x003b: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:60), block:B:44:0x003b */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Object readObjectAbsPath(String str) {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2;
        ObjectInputStream objectInputStream3 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            try {
                objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(str)));
            } catch (Exception e16) {
                e = e16;
                objectInputStream = null;
            } catch (OutOfMemoryError unused) {
                objectInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (objectInputStream3 != null) {
                }
                throw th;
            }
            try {
                Object readObject = objectInputStream.readObject();
                try {
                    objectInputStream.close();
                } catch (IOException unused2) {
                }
                return readObject;
            } catch (Exception e17) {
                e = e17;
                boolean z16 = false;
                QLog.e("StickerRecManager", 1, "FileUtils.readObjectAbs throw an Exception. fileName=", str, ", Exception=", QLog.getStackTraceString(e));
                if ((e instanceof InvalidClassException) || (e instanceof ClassNotFoundException) || (e instanceof ClassCastException)) {
                    z16 = true;
                }
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                if (z16) {
                    updateStickerRecVersion(BaseApplication.getContext(), WORDS_VERSION_KEY, this.mCurrentLoginAccountUin, "0");
                    FileUtils.deleteFile(str);
                }
                return null;
            } catch (OutOfMemoryError unused4) {
                if (QLog.isColorLevel()) {
                    QLog.i("StickerRecManager", 2, "readObject out of memory");
                }
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            objectInputStream3 = objectInputStream2;
            if (objectInputStream3 != null) {
                try {
                    objectInputStream3.close();
                } catch (IOException unused6) {
                }
            }
            throw th;
        }
    }

    private void recordEmoticon(int i3, String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && i3 != -1 && jSONObject != null) {
            ((INTZPlanAdapterApi) com.tencent.qqnt.aio.adapter.a.b(INTZPlanAdapterApi.class)).recordEmoticonFromRecommend(i3, str, jSONObject);
        }
    }

    private void renameFile(File file, File file2) {
        if (file2.exists()) {
            file2.delete();
        }
        if (!file.renameTo(file2)) {
            FileUtils.copyFile(file, file2);
            file.delete();
        }
    }

    private void reportEmptyImg() {
        StatisticCollector.d(BaseApplication.getContext()).c(null, "StickerRecEmptyImg", false, 0L, 0L, null, "");
    }

    private void reportInitCost(boolean z16, long j3) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("param_succ_flag", str);
        hashMap.put("initTimeCost", j3 + "");
        StatisticCollector.d(BaseApplication.getContext()).c(null, "StickerRecInitCost", z16, 0L, 0L, hashMap, "");
    }

    public static void setMaxMatchLength(Context context, String str, int i3) {
        sMaxMatchLength = Integer.valueOf(i3);
        context.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).edit().putInt("RECOMMENDED_STICKER_MAX_MATCH_LENGTH" + str, i3).apply();
    }

    public static void setRecStickerSwitch(AppInterface appInterface, boolean z16) {
        BaseApplication context = BaseApplication.getContext();
        String currentUin = appInterface.getCurrentUin();
        sRecStickerSwitch = Boolean.valueOf(z16);
        context.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).edit().putBoolean("RECOMMENDED_STICKER_SWITCH" + currentUin, z16).apply();
    }

    public static void setUserConfigVersion(AppInterface appInterface, int i3) {
        appInterface.getApp().getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).edit().putInt("RECOMMENDED_STICKER_VERSION" + appInterface.getCurrentAccountUin(), i3).apply();
    }

    private void showEmoticon(String str, int i3, String str2, boolean z16, boolean z17, String str3, StickerRecKeywordFrom stickerRecKeywordFrom) {
        this.mDbHandler.post(new Runnable(str, z17, stickerRecKeywordFrom, z16, str3, i3, str2) { // from class: com.tencent.qqnt.emotion.stickerrecommended.impl.StickerRecManagerImpl.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String C;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f356530d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f356531e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ StickerRecKeywordFrom f356532f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ boolean f356533h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ String f356534i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ int f356535m;

            {
                this.f356530d = str;
                this.f356531e = z17;
                this.f356532f = stickerRecKeywordFrom;
                this.f356533h = z16;
                this.f356534i = str3;
                this.f356535m = i3;
                this.C = str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, StickerRecManagerImpl.this, str, Boolean.valueOf(z17), stickerRecKeywordFrom, Boolean.valueOf(z16), str3, Integer.valueOf(i3), str2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (StickerRecManagerImpl.this.entityManager != null) {
                    try {
                        if (!StickerRecManagerImpl.this.mForbidInsertOtherEmotion) {
                            StickerRecManagerImpl.this.showLocalEmo(this.f356530d, this.f356531e, this.f356532f);
                        }
                        if (StickerRecConfigManager.p() && StickerRecManagerImpl.this.handleConfigPics(this.f356530d, this.f356533h, 0, this.f356532f)) {
                            return;
                        }
                        StickerRecommendEntity stickerRecommendEntity = (StickerRecommendEntity) StickerRecManagerImpl.this.entityManager.e(StickerRecommendEntity.class, "usrMessage=? AND recommendType!=1", new String[]{this.f356534i});
                        if (stickerRecommendEntity == null) {
                            if (QLog.isColorLevel()) {
                                QLog.d("StickerRecManager", 2, "entity is null, mForbidInsertOtherEmotion:" + StickerRecManagerImpl.this.mForbidInsertOtherEmotion);
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.d("StickerRecManager", 2, "cache Time : " + (System.currentTimeMillis() - stickerRecommendEntity.cachedTime) + ", mForbidInsertOtherEmotion:" + StickerRecManagerImpl.this.mForbidInsertOtherEmotion);
                        }
                        int convertAIOType = StickerRecManagerImpl.this.convertAIOType(this.f356535m);
                        if (stickerRecommendEntity != null && StickerRecManagerImpl.this.isCacheValid(stickerRecommendEntity)) {
                            byte[] decode = Base64.decode(stickerRecommendEntity.recList, 0);
                            StickerRecommendSortEntity stickerRecommendSortEntity = (StickerRecommendSortEntity) StickerRecManagerImpl.this.entityManager.e(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType!=1", new String[]{this.f356534i});
                            if (stickerRecommendSortEntity != null) {
                                stickerRecommendSortEntity.convertToList();
                            }
                            StickerRecManagerImpl.this.handlePullPics(decode, this.f356534i, "cache", this.f356533h, stickerRecommendSortEntity, 0, convertAIOType, this.f356532f);
                            return;
                        }
                        StickerRecManagerImpl.this.entityManager.b(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType!=1", new String[]{this.f356534i});
                        StickerRecManagerImpl.this.entityManager.b(StickerRecommendSortEntity.class.getSimpleName(), "usrMessage=? AND recommendType!=1", new String[]{this.f356534i});
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.f356534i);
                        StickerRecManagerImpl stickerRecManagerImpl = StickerRecManagerImpl.this;
                        String str4 = stickerRecManagerImpl.mCurrentLoginAccountUin;
                        if (this.f356533h) {
                            i16 = 4;
                        } else {
                            i16 = 3;
                        }
                        stickerRecManagerImpl.sendPullPicsRequest(str4, i16, convertAIOType, this.C, arrayList, this.f356532f);
                        if (StickerRecConfigManager.p()) {
                            StickerRecConfigManager.INSTANCE.a().r();
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("StickerRecManager", 2, ThrowablesUtils.getStackTraceAsString(e16));
                        }
                    }
                }
            }
        });
    }

    private List<g> sortData(List<g> list, StickerRecommendSortEntity stickerRecommendSortEntity) {
        int i3;
        int i16;
        int i17;
        if (stickerRecommendSortEntity != null) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.i("StickerRecManager", 2, "sortData clicked=" + stickerRecommendSortEntity.clicked + " exposed=" + stickerRecommendSortEntity.exposed + " noExpose=" + stickerRecommendSortEntity.noExpose);
                }
                List<Integer> list2 = stickerRecommendSortEntity.clickedList;
                if (list2 != null) {
                    i3 = list2.size();
                } else {
                    i3 = 0;
                }
                List<Integer> list3 = stickerRecommendSortEntity.noExposeList;
                if (list3 != null) {
                    i16 = list3.size();
                } else {
                    i16 = 0;
                }
                List<Integer> list4 = stickerRecommendSortEntity.exposedList;
                if (list4 != null) {
                    i17 = list4.size();
                } else {
                    i17 = 0;
                }
                int size = list.size();
                int i18 = i3 + i16 + i17;
                if (size != i18) {
                    if (QLog.isColorLevel()) {
                        QLog.i("StickerRecManager", 2, "sort data:length is not equals. size=" + size + " sortSize=" + i18);
                    }
                    return null;
                }
                g[] gVarArr = new g[size];
                int i19 = 0;
                for (int i26 = 0; i26 < i3; i26++) {
                    int intValue = stickerRecommendSortEntity.clickedList.get(i26).intValue();
                    if (intValue < size && i19 < size) {
                        gVarArr[i19] = list.get(intValue);
                        i19++;
                    }
                }
                for (int i27 = 0; i27 < i16; i27++) {
                    int intValue2 = stickerRecommendSortEntity.noExposeList.get(i27).intValue();
                    if (intValue2 < size && i19 < size) {
                        gVarArr[i19] = list.get(intValue2);
                        i19++;
                    }
                }
                for (int i28 = 0; i28 < i17; i28++) {
                    int intValue3 = stickerRecommendSortEntity.exposedList.get(i28).intValue();
                    if (intValue3 < size && i19 < size) {
                        gVarArr[i19] = list.get(intValue3);
                        i19++;
                    }
                }
                return Arrays.asList(gVarArr);
            } catch (Throwable th5) {
                QLog.e("StickerRecManager", 1, "sortData:", th5);
            }
        }
        return null;
    }

    private List<g> sortDataOnlyByClick(List<g> list, String str, int i3) {
        StickerRecommendSortEntity stickerRecommendSortEntity;
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    if (i3 == 0) {
                        stickerRecommendSortEntity = (StickerRecommendSortEntity) this.entityManager.e(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType!=1", new String[]{str});
                    } else if (i3 == 1) {
                        stickerRecommendSortEntity = (StickerRecommendSortEntity) this.entityManager.e(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType==1", new String[]{str});
                    } else {
                        stickerRecommendSortEntity = null;
                    }
                    if (stickerRecommendSortEntity == null) {
                        if (QLog.isColorLevel()) {
                            QLog.i("StickerRecManager", 2, "sortDataOnlyByClick sortEntity is null");
                        }
                        return null;
                    }
                    if (stickerRecommendSortEntity.clickCountList == null) {
                        if (QLog.isColorLevel()) {
                            QLog.i("StickerRecManager", 2, "sortDataOnlyByClick not clicked list");
                        }
                        return null;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("StickerRecManager", 2, "sortDataOnlyByClick clicked=" + stickerRecommendSortEntity.clicked);
                    }
                    stickerRecommendSortEntity.convertToList();
                    ArrayList arrayList = new ArrayList();
                    int size = list.size();
                    Collections.sort(stickerRecommendSortEntity.clickCountList);
                    Iterator<com.tencent.mobileqq.activity.aio.stickerrecommended.c> it = stickerRecommendSortEntity.clickCountList.iterator();
                    while (it.hasNext()) {
                        int i16 = it.next().f179908d;
                        if (i16 < size) {
                            arrayList.add(list.get(i16));
                        }
                    }
                    for (g gVar : list) {
                        if (!arrayList.contains(gVar)) {
                            arrayList.add(gVar);
                        }
                    }
                    return arrayList;
                }
            } catch (Throwable th5) {
                QLog.e("StickerRecManager", 1, "sortDataOnlyByClick:", th5);
                return null;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("StickerRecManager", 2, "sortDataOnlyByClick dataList is null or empty");
        }
        return null;
    }

    public static String stringToUnicode(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < str.length(); i3++) {
            stringBuffer.append("\\u" + Integer.toHexString(str.charAt(i3)));
        }
        return stringBuffer.toString();
    }

    private boolean unzip(File file, File file2) {
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(file2.getParent());
            String str = File.separator;
            sb5.append(str);
            sb5.append(FaceUtil.IMG_TEMP);
            File file3 = new File(sb5.toString());
            com.tencent.qqnt.emotion.utils.t.a(file, file3.getAbsolutePath() + str);
            File[] listFiles = file3.listFiles();
            int length = listFiles.length;
            for (int i3 = 0; i3 < length; i3++) {
                File file4 = listFiles[i3];
                String name = file4.getName();
                if (file4.isFile() && name.endsWith(ark.ARKMETADATA_JSON)) {
                    renameFile(file4, file2);
                }
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("StickerRecManager", 2, "uncompress template zip file error", e16);
            }
            return false;
        }
    }

    public static void updateEmotionRecSettingSwitch(Context context, String str, boolean z16) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("emotion_rec_setting_switch_" + str, z16);
        edit.commit();
    }

    public static void updateStickerRecVersion(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(str2 + "_" + str, str3);
        edit.commit();
    }

    private void updateWords(String str, String str2, int i3, String str3) {
        boolean z16;
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecManager", 2, "updateWords fail: url is null.");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "start download words");
        }
        if (i3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        File parentFile = this.mWordsFile.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        ThreadManagerV2.excute(new Runnable(str, str2, z16, str3) { // from class: com.tencent.qqnt.emotion.stickerrecommended.impl.StickerRecManagerImpl.6
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f356543d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f356544e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f356545f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f356546h;

            {
                this.f356543d = str;
                this.f356544e = str2;
                this.f356545f = z16;
                this.f356546h = str3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, StickerRecManagerImpl.this, str, str2, Boolean.valueOf(z16), str3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                long j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                m syncExecute = ((IHttpService) QRoute.api(IHttpService.class)).syncExecute(new b.a("StickerRec", this.f356543d, StickerRecManagerImpl.this.mDownloadFile).c());
                if (QLog.isColorLevel()) {
                    QLog.i("StickerRecManager", 2, "start download words, url: " + this.f356543d);
                }
                int a16 = syncExecute.a();
                if (QLog.isColorLevel()) {
                    QLog.i("StickerRecManager", 2, "onResp resultcode: " + a16);
                }
                if (syncExecute.e()) {
                    StickerRecManagerImpl stickerRecManagerImpl = StickerRecManagerImpl.this;
                    if (stickerRecManagerImpl.validateAndUnzip(stickerRecManagerImpl.mDownloadFile, StickerRecManagerImpl.this.mWordsFile, this.f356544e, this.f356545f)) {
                        if (StickerRecManagerImpl.this.mWordsFile.exists()) {
                            if (QLog.isColorLevel()) {
                                QLog.d("StickerRecManager", 2, "pull words success");
                            }
                            try {
                                j3 = SystemClock.elapsedRealtime();
                            } catch (Exception unused) {
                                j3 = 0;
                            }
                            try {
                                JSONObject jSONObject = new JSONObject(FileUtils.readFileToString(StickerRecManagerImpl.this.mWordsFile));
                                String optString = jSONObject.optString("version", null);
                                JSONArray optJSONArray = jSONObject.optJSONArray("words");
                                BloomFilter bloomFilter = new BloomFilter();
                                bloomFilter.version = optString;
                                for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                                    String optString2 = optJSONArray.optString(i16);
                                    if (!TextUtils.isEmpty(optString2)) {
                                        bloomFilter.add(optString2);
                                    }
                                }
                                FileUtils.deleteFile(StickerRecManagerImpl.this.mEncodedBloomFile.getAbsolutePath());
                                StickerRecManagerImpl stickerRecManagerImpl2 = StickerRecManagerImpl.this;
                                stickerRecManagerImpl2.writeObjectAbsPath(stickerRecManagerImpl2.mEncodedBloomFile.getAbsolutePath(), bloomFilter);
                                FileUtils.deleteFile(StickerRecManagerImpl.this.mWordsFile.getAbsolutePath());
                                StickerRecManagerImpl.updateStickerRecVersion(BaseApplication.getContext(), StickerRecManagerImpl.WORDS_VERSION_KEY, StickerRecManagerImpl.this.mCurrentLoginAccountUin, this.f356546h);
                                StickerRecManagerImpl.this.unInit();
                                StickerRecManagerImpl.this.init();
                                if (QLog.isColorLevel()) {
                                    QLog.d("StickerRecManager", 2, "generate encode table time cost : " + (SystemClock.elapsedRealtime() - j3));
                                    return;
                                }
                                return;
                            } catch (Exception unused2) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("StickerRecManager", 2, "generate encode table time error cost : " + (SystemClock.elapsedRealtime() - j3));
                                    if (QLog.isColorLevel()) {
                                        QLog.d("StickerRecManager", 2, "build EncodeTable error !");
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("StickerRecManager", 2, "updateWords fail: words file is not exist.");
                        }
                    }
                }
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validateAndUnzip(File file, File file2, String str, boolean z16) {
        if (validateDownloadFile(file, str)) {
            if (z16) {
                if (unzip(file, file2)) {
                    file.delete();
                    return true;
                }
                return false;
            }
            renameFile(file, file2);
            return true;
        }
        file.delete();
        if (QLog.isColorLevel()) {
            QLog.e("StickerRecManager", 2, "downloadFile zip md5 is wrong");
            return false;
        }
        return false;
    }

    private boolean validateDownloadFile(File file, String str) {
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.w("StickerRecManager", 2, "downloadFile zip file not exists");
            }
            return false;
        }
        try {
            String calcMd5 = FileUtils.calcMd5(file.getPath());
            if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase(calcMd5)) {
                return false;
            }
            return true;
        } catch (UnsatisfiedLinkError e16) {
            if (QLog.isColorLevel()) {
                QLog.e("StickerRecManager", 1, "calculate follow capture template zip md5 error", e16);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeObjectAbsPath(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
                    try {
                        objectOutputStream2.writeObject(obj);
                        objectOutputStream2.flush();
                        objectOutputStream2.close();
                    } catch (Exception e16) {
                        e = e16;
                        objectOutputStream = objectOutputStream2;
                        QLog.e("StickerRecManager", 1, "FileUtils.writeObjectAbs throw an Exception. fileName=", str, ", Exception=", QLog.getStackTraceString(e));
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        objectOutputStream = objectOutputStream2;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e18) {
                e = e18;
            }
        } catch (IOException e19) {
            e19.printStackTrace();
        }
    }

    private List<g> zplanEmoticonSort(List<g> list, String str) {
        ArrayList arrayList = new ArrayList(list);
        if (((INTZPlanAdapterApi) com.tencent.qqnt.aio.adapter.a.b(INTZPlanAdapterApi.class)).hasCustomDressUp(this.mCurrentLoginAccountUin)) {
            if (xw3.a.c()) {
                putZplanEmoticonToFirst(arrayList);
                xw3.a.a();
            } else if (xw3.a.d()) {
                if ("network".equals(str)) {
                    putZplanEmoticonToFirst(arrayList);
                    xw3.a.a();
                } else {
                    int i3 = 0;
                    int i16 = 0;
                    while (true) {
                        if (i16 >= list.size()) {
                            break;
                        }
                        g gVar = list.get(i16);
                        if ((gVar instanceof o) && ((o) gVar).B()) {
                            i3 = i16;
                            break;
                        }
                        i16++;
                    }
                    if (i3 > 4) {
                        g gVar2 = list.get(i3);
                        arrayList.remove(i3);
                        arrayList.add(4, gVar2);
                    }
                    xw3.a.a();
                }
            } else if (xw3.a.e()) {
                if ("network".equals(str)) {
                    putZplanEmoticonToFirst(arrayList);
                }
                xw3.a.a();
            } else if (xw3.a.b()) {
                xw3.a.a();
            }
        } else if (xw3.b.b()) {
            if ("network".equals(str)) {
                putZplanEmoticonToFirst(arrayList);
            }
            xw3.b.a();
        } else if (xw3.b.c()) {
            xw3.b.a();
        }
        return arrayList;
    }

    public void addStickerRecLocalEmoticonChangeListener(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) hVar);
            return;
        }
        if (hVar == null) {
            return;
        }
        if (this.mStickerRecLocalEmoticonChangeListeners == null) {
            this.mStickerRecLocalEmoticonChangeListeners = new ArrayList();
        }
        if (!this.mStickerRecLocalEmoticonChangeListeners.contains(hVar)) {
            this.mStickerRecLocalEmoticonChangeListeners.add(hVar);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public boolean analyze(String str, int i3, String str2, StickerRecKeywordFrom stickerRecKeywordFrom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, str, Integer.valueOf(i3), str2, stickerRecKeywordFrom)).booleanValue();
        }
        if (i3 > 0 && !TextUtils.isEmpty(str2)) {
            return analyze(str, i3, str2, false, true, stickerRecKeywordFrom);
        }
        QLog.e("StickerRecManager", 1, "[analyze] invalidate aio params!");
        return false;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public boolean analyzeForScenesMode(c cVar, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, cVar, Integer.valueOf(i3), str)).booleanValue();
        }
        if (!hasInit()) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecManager", 2, "can't analyzeForScenesMode, has not init");
            }
            return false;
        }
        if (cVar != null) {
            try {
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("StickerRecManager", 2, ThrowablesUtils.getStackTraceAsString(e16));
                }
            }
            if (cVar.a() != null && !StringUtil.isEmpty(cVar.c())) {
                this.mDbHandler.post(new Runnable(cVar.c(), i3, str, cVar) { // from class: com.tencent.qqnt.emotion.stickerrecommended.impl.StickerRecManagerImpl.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f356536d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f356537e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ String f356538f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ c f356539h;

                    {
                        this.f356536d = r6;
                        this.f356537e = i3;
                        this.f356538f = str;
                        this.f356539h = cVar;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, StickerRecManagerImpl.this, r6, Integer.valueOf(i3), str, cVar);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (StickerRecManagerImpl.this.entityManager != null) {
                            StickerRecommendEntity stickerRecommendEntity = (StickerRecommendEntity) StickerRecManagerImpl.this.entityManager.e(StickerRecommendEntity.class, "usrMessage=? AND recommendType==1", new String[]{this.f356536d});
                            if (stickerRecommendEntity == null) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("StickerRecManager", 2, "scene entity is null");
                                }
                            } else if (QLog.isColorLevel()) {
                                QLog.d("StickerRecManager", 2, "scene cache Time : " + (System.currentTimeMillis() - stickerRecommendEntity.cachedTime));
                            }
                            int convertAIOType = StickerRecManagerImpl.this.convertAIOType(this.f356537e);
                            if (stickerRecommendEntity != null && StickerRecManagerImpl.this.isCacheValid(stickerRecommendEntity)) {
                                byte[] decode = Base64.decode(stickerRecommendEntity.recList, 0);
                                StickerRecommendSortEntity stickerRecommendSortEntity = (StickerRecommendSortEntity) StickerRecManagerImpl.this.entityManager.e(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType==1", new String[]{this.f356536d});
                                if (stickerRecommendSortEntity != null) {
                                    stickerRecommendSortEntity.convertToList();
                                }
                                StickerRecManagerImpl.this.handlePullPics(decode, this.f356536d, "cache", false, stickerRecommendSortEntity, 1, convertAIOType, StickerRecKeywordFrom.INPUT);
                                return;
                            }
                            StickerRecManagerImpl.this.entityManager.b(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType==1", new String[]{this.f356536d});
                            StickerRecManagerImpl.this.entityManager.b(StickerRecommendSortEntity.class.getSimpleName(), "usrMessage=? AND recommendType=1", new String[]{this.f356536d});
                            StickerRecManagerImpl stickerRecManagerImpl = StickerRecManagerImpl.this;
                            stickerRecManagerImpl.sendScenesPullPicsRequest(stickerRecManagerImpl.mCurrentLoginAccountUin, 3, convertAIOType, this.f356538f, this.f356539h);
                        }
                    }
                });
                return true;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "analyzeForScenesMode data is empty");
        }
        return false;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public boolean analyzeFromQzone(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), str2)).booleanValue();
        }
        return analyze(str, i3, str2, true, false, StickerRecKeywordFrom.QZONE);
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public void clearOverdueStickerCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            if (this.entityManager == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecManager", 2, "clearOverdueStickerCache");
            }
            this.mDbHandler.post(new Runnable() { // from class: com.tencent.qqnt.emotion.stickerrecommended.impl.StickerRecManagerImpl.8
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StickerRecManagerImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    File[] listFiles = new File(n.f356597a).listFiles();
                    long j3 = 0;
                    if (listFiles != null && listFiles.length > 0) {
                        for (File file : listFiles) {
                            j3 += file.length();
                        }
                    }
                    if (j3 < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                        if (QLog.isColorLevel()) {
                            QLog.d("StickerRecManager", 2, "current cache length:" + j3 + ", not need delete cache");
                            return;
                        }
                        return;
                    }
                    try {
                        String[] strArr = {String.valueOf(System.currentTimeMillis() - StickerRecManagerImpl.this.mCacheTime)};
                        Iterator<? extends Entity> it = StickerRecManagerImpl.this.entityManager.h(StickerRecCacheEntity.class, StickerRecCacheEntity.class.getSimpleName(), false, "lastTime<?", strArr, "", "", "", "").iterator();
                        while (it.hasNext()) {
                            StickerRecCacheEntity stickerRecCacheEntity = (StickerRecCacheEntity) it.next();
                            if (QLog.isColorLevel()) {
                                QLog.d("StickerRecManager", 2, "Overdue cache:", "fileName=" + stickerRecCacheEntity.filePath + " md5=" + stickerRecCacheEntity.md5);
                            }
                            if (!TextUtils.isEmpty(stickerRecCacheEntity.filePath)) {
                                new File(stickerRecCacheEntity.filePath).delete();
                            }
                        }
                        StickerRecManagerImpl.this.entityManager.b(StickerRecCacheEntity.class.getSimpleName(), "lastTime<?", strArr);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("StickerRecManager", 2, "clearOverdueStickerCache error", e16);
                        }
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public void collectReportData(List<g> list, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, list, str, str2, Integer.valueOf(i3));
            return;
        }
        if (list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (g gVar : list) {
                if (gVar != null) {
                    if (gVar.isExposed()) {
                        arrayList.add(gVar);
                    } else {
                        arrayList2.add(gVar);
                    }
                }
            }
            z zVar = new z();
            zVar.f356673b = str;
            zVar.f356674c = str2;
            zVar.f356675d = arrayList;
            zVar.f356676e = arrayList2;
            zVar.f356672a = i3;
            this.mStickerReportItems.add(zVar);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public void deletePicCache() {
        File[] listFiles;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        File file = new File(n.f356597a);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public synchronized String getCurrentText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mCurrentText;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public int getUserConfigVersion(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this, (Object) appInterface)).intValue();
        }
        return appInterface.getApp().getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).getInt("RECOMMENDED_STICKER_VERSION" + this.mCurrentLoginAccountUin, 0);
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public void handleRecommendedStickerConfig(AppInterface appInterface, ConfigurationService$Config configurationService$Config, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, appInterface, configurationService$Config, Integer.valueOf(i3));
            return;
        }
        int i16 = configurationService$Config.version.get();
        BaseApplication context = BaseApplication.getContext();
        String str = this.mCurrentLoginAccountUin;
        int userConfigVersion = getUserConfigVersion(appInterface);
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "RecommendedSticker received Config remote version:" + i16 + " localVersion= " + userConfigVersion);
        }
        if (i16 != userConfigVersion) {
            String b16 = com.tencent.qqnt.emotion.utils.n.b(configurationService$Config, userConfigVersion, i3);
            if (!TextUtils.isEmpty(b16)) {
                try {
                    JSONObject jSONObject = new JSONObject(b16);
                    if (jSONObject.has("useRecommendedSticker") && jSONObject.has("maxMatchLength")) {
                        setRecStickerSwitch(appInterface, jSONObject.getBoolean("useRecommendedSticker"));
                        setMaxMatchLength(context, str, jSONObject.getInt("maxMatchLength"));
                    } else {
                        setRecStickerSwitch(appInterface, false);
                    }
                } catch (Exception e16) {
                    setRecStickerSwitch(appInterface, false);
                    if (QLog.isColorLevel()) {
                        QLog.d("StickerRecManager", 2, e16.getMessage());
                    }
                }
            }
            setUserConfigVersion(appInterface, i16);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public synchronized void handleResponse(Intent intent, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (intent != null && fromServiceMsg != null) {
            if (fromServiceMsg.getResultCode() == 1000) {
                int length = fromServiceMsg.getWupBuffer().length - 4;
                byte[] bArr = new byte[length];
                PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
                fromServiceMsg.putWupBuffer(bArr);
                String serviceCmd = fromServiceMsg.getServiceCmd();
                String stringExtra = intent.getStringExtra(USER_KEYWORD_KEY);
                int intExtra = intent.getIntExtra(REQUEST_AIO_TYPE, 4);
                try {
                    byte[] wupBuffer = fromServiceMsg.getWupBuffer();
                    if (wupBuffer == null) {
                        return;
                    }
                    if (CMD_PULL_WORDS.equals(serviceCmd)) {
                        handlePullWords(wupBuffer);
                    } else if (CMD_PULL_PICS.equals(serviceCmd)) {
                        cacheResInDb(wupBuffer, stringExtra, 0);
                        handlePullPics(wupBuffer, stringExtra, "network", intent.getBooleanExtra("fromQzone", false), null, 0, intExtra, getFrom(intent));
                    } else if (CMD_SCENES_PULL_PICS.equals(serviceCmd)) {
                        cacheResInDb(wupBuffer, stringExtra, 1);
                        handlePullPics(wupBuffer, stringExtra, "network", intent.getBooleanExtra("fromQzone", false), null, 1, intExtra, getFrom(intent));
                    } else {
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        if (peekAppRuntime == null) {
                            QLog.d("StickerRecManager", 1, "[handleResponse] handleGetIceBreakHotPicResponse error, app is null!");
                            return;
                        }
                        ((IAIOIceBreakApi) com.tencent.qqnt.aio.adapter.a.b(IAIOIceBreakApi.class)).handleGetIceBreakHotPicResponse(peekAppRuntime, wupBuffer, serviceCmd);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("StickerRecManager", 2, ThrowablesUtils.getStackTraceAsString(e16));
                    }
                }
            } else {
                QLog.d("StickerRecManager", 1, String.format("result_code = %s, cmd = %s", Integer.valueOf(fromServiceMsg.getResultCode()), fromServiceMsg.getServiceCmd()));
            }
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public synchronized boolean hasInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.hasInit;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0165 A[Catch: Exception -> 0x0189, TryCatch #1 {Exception -> 0x0189, blocks: (B:28:0x0082, B:30:0x0097, B:32:0x009f, B:33:0x00a8, B:37:0x00c2, B:40:0x00ce, B:42:0x00de, B:43:0x0148, B:45:0x0165, B:46:0x0185, B:49:0x00e8, B:51:0x0104, B:52:0x0108, B:54:0x010e, B:65:0x011a, B:57:0x0120, B:60:0x0128, B:68:0x012e, B:70:0x0134, B:71:0x0146), top: B:27:0x0082 }] */
    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (hasInit()) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecManager", 2, "init has executed");
                return;
            }
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!FileUtils.fileExists(this.mEncodedBloomFile.getAbsolutePath())) {
            this.hasInit = false;
            QLog.e("StickerRecManager", 1, "init failed, words file not exist");
            return;
        }
        try {
            BloomFilter bloomFilter = (BloomFilter) readObjectAbsPath(this.mEncodedBloomFile.getAbsolutePath());
            this.bloomFilter = bloomFilter;
            if (bloomFilter == null) {
                this.hasInit = false;
                FileUtils.deleteFile(this.mEncodedBloomFile.getAbsolutePath());
                QLog.e("StickerRecManager", 1, "init failed, bloomFilter is null!");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecManager", 2, "init bloomFilter, version : " + this.bloomFilter.version);
            }
            try {
                InputMaterialCacheKeyParser.b bVar = (InputMaterialCacheKeyParser.b) ((IEmoticonApi) com.tencent.qqnt.aio.adapter.a.b(IEmoticonApi.class)).loadConfig("InputMaterialCacheKey");
                if (bVar != null && bVar.a() >= 0) {
                    this.mCacheTime = bVar.a() * 1000;
                }
                long lastTimeRemoveEmoticonPackage = getLastTimeRemoveEmoticonPackage(BaseApplication.getContext(), this.mCurrentLoginAccountUin);
                if (FileUtils.fileExists(this.mLocalWordsFile.getAbsolutePath()) && (lastTimeRemoveEmoticonPackage == 0 || System.currentTimeMillis() - lastTimeRemoveEmoticonPackage < this.mCacheTime)) {
                    HashSet<String> hashSet = (HashSet) readObjectAbsPath(this.mLocalWordsFile.getAbsolutePath());
                    this.mLocalKeywordsSet = hashSet;
                    if (hashSet == null) {
                        FileUtils.deleteFile(this.mLocalWordsFile.getAbsolutePath());
                    }
                    updateKeywordForFavEmotion();
                    this.maxMatchLength = getMaxMatchLength(BaseApplication.getContext(), this.mCurrentLoginAccountUin, 6);
                    this.hasInit = true;
                    long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                    if (QLog.isColorLevel()) {
                        QLog.d("StickerRecManager", 2, "StickerRecManager init time cost : " + elapsedRealtime2 + ", mCache:" + this.mCacheTime);
                    }
                    reportInitCost(true, elapsedRealtime2);
                }
                com.tencent.qqnt.emotion.utils.g.a(BaseApplication.getContext(), this.mCurrentLoginAccountUin, 0L);
                HashSet<String> hashSet2 = new HashSet<>();
                List<Emoticon> queryBigEmoticonsFromDB = this.emoticonManager.queryBigEmoticonsFromDB();
                List<String> tabCache = this.emoticonManager.getTabCache();
                if (queryBigEmoticonsFromDB != null) {
                    for (Emoticon emoticon : queryBigEmoticonsFromDB) {
                        if (tabCache.isEmpty()) {
                            hashSet2.add(emoticon.name);
                        } else if (tabCache.contains(emoticon.epId)) {
                            hashSet2.add(emoticon.name);
                        }
                    }
                }
                if (!hashSet2.isEmpty()) {
                    FileUtils.deleteFile(this.mLocalWordsFile.getAbsolutePath());
                    writeObjectAbsPath(this.mLocalWordsFile.getAbsolutePath(), hashSet2);
                }
                this.mLocalKeywordsSet = hashSet2;
                updateKeywordForFavEmotion();
                this.maxMatchLength = getMaxMatchLength(BaseApplication.getContext(), this.mCurrentLoginAccountUin, 6);
                this.hasInit = true;
                long elapsedRealtime22 = SystemClock.elapsedRealtime() - elapsedRealtime;
                if (QLog.isColorLevel()) {
                }
                reportInitCost(true, elapsedRealtime22);
            } catch (Exception e16) {
                this.hasInit = false;
                if (QLog.isColorLevel()) {
                    QLog.d("StickerRecManager", 2, ThrowablesUtils.getStackTraceAsString(e16));
                    if (QLog.isColorLevel()) {
                        QLog.d("StickerRecManager", 2, "StickerRecManager error init time cost : " + (SystemClock.elapsedRealtime() - elapsedRealtime));
                    }
                }
                reportInitCost(false, SystemClock.elapsedRealtime() - elapsedRealtime);
            }
        } catch (Throwable th5) {
            this.hasInit = false;
            FileUtils.deleteFile(this.mEncodedBloomFile.getAbsolutePath());
            QLog.d("StickerRecManager", 1, "init failed, ", th5);
        }
    }

    public void initDir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        try {
            File file = new File(getDataDir(), "words");
            this.mDownloadFile = new File(getDataDir(), WORDS_ZIP_FILE_NAME);
            this.mWordsFile = new File(file, WORDS_FILE_NAME);
            this.mEncodedBloomFile = new File(file, ENCODED_BLOOM_NAME);
            this.mLocalWordsFile = new File(file, LOCAL_WORDS_FILE_NAME);
        } catch (NullPointerException e16) {
            QLog.d("StickerRecManager", 1, "[initDir] error.", e16);
        }
    }

    protected void initRecSwitch(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) context, (Object) str);
            return;
        }
        try {
            this.emotionRecSettingSwitch = getEmotionRecSettingSwitch(context, str);
        } catch (NullPointerException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public boolean isEmotionRecSettingOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        return this.emotionRecSettingSwitch;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public boolean isForbidInsertOtherEmotion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        return this.mForbidInsertOtherEmotion;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public boolean isForceUpdateCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        return this.mForceUpdateCache;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public boolean isHandleKeyword(String str) {
        HashSet<String> hashSet;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this, (Object) str)).booleanValue();
        }
        if (str != null && (hashSet = this.mLocalKeywordsSet) != null) {
            return hashSet.contains(str);
        }
        return false;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public Collection<String> loadKeywordForCameraEmotion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (Collection) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        HashSet hashSet = new HashSet();
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "loadKeywordForCameraEmotion size: " + hashSet.size());
        }
        return hashSet;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public Collection<String> loadKeywordForFavEmotion() {
        Emoticon syncFindEmoticonById;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (Collection) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        HashSet hashSet = new HashSet();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("StickerRecManager", 1, "[reportEvent] error, app is null!");
            return hashSet;
        }
        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) peekAppRuntime.getRuntimeService(IEmoticonManagerService.class, "");
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) peekAppRuntime.getRuntimeService(IFavroamingDBManagerService.class, "");
        List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
        if (emoticonDataList != null) {
            List<CustomEmotionData> lottieEmoticonDataList = iFavroamingDBManagerService.getLottieEmoticonDataList();
            if (lottieEmoticonDataList != null) {
                emoticonDataList.addAll(lottieEmoticonDataList);
            }
            for (CustomEmotionData customEmotionData : emoticonDataList) {
                if ("isUpdate".equals(customEmotionData.RomaingType) || FavEmoConstant.ROAMING_TYPE_PANEL.equals(customEmotionData.RomaingType) || "overflow".equals(customEmotionData.RomaingType) || FavEmoConstant.ROAMING_TYPE_OVERFLOW_DOWNLOADED.equals(customEmotionData.RomaingType)) {
                    if (!TextUtils.isEmpty(customEmotionData.modifyWord)) {
                        hashSet.add(preProcessUsrTextUseLocalSearch(customEmotionData.modifyWord));
                    } else if (!TextUtils.isEmpty(customEmotionData.ocrWord)) {
                        hashSet.add(preProcessUsrTextUseLocalSearch(customEmotionData.ocrWord));
                    } else if (customEmotionData.isMarkFace && (syncFindEmoticonById = iEmoticonManagerService.syncFindEmoticonById(customEmotionData.emoPath, customEmotionData.eId)) != null && !TextUtils.isEmpty(syncFindEmoticonById.name)) {
                        hashSet.add(syncFindEmoticonById.name);
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "loadKeywordForFavEmotion size: " + hashSet.size());
        }
        return hashSet;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) appRuntime);
            return;
        }
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) appRuntime;
        this.mCurrentLoginAccountUin = baseQQAppInterface.getCurrentAccountUin();
        this.mCurrentLoginAccountLongUin = Long.valueOf(baseQQAppInterface.getLongAccountUin());
        this.entityManager = com.tencent.qqnt.emotion.db.b.f356229a.a(baseQQAppInterface);
        this.emoticonManager = (IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class, "");
        initRecSwitch(BaseApplication.getContext(), this.mCurrentLoginAccountUin);
        initDir();
        List<h> list = this.mStickerRecLocalEmoticonChangeListeners;
        if (list != null) {
            list.clear();
        }
        addStickerRecLocalEmoticonChangeListener(new u(baseQQAppInterface));
        s sVar = new s(baseQQAppInterface);
        this.mFavEmoticonHandleListener = sVar;
        addStickerRecLocalEmoticonChangeListener(sVar);
        addStickerRecLocalEmoticonChangeListener(new com.tencent.qqnt.emotion.stickerrecommended.ad.f(baseQQAppInterface));
        addStickerRecLocalEmoticonChangeListener(new l(baseQQAppInterface));
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        boolean isSwitchOn = FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("emoticon_sticker_rec_134826005", true);
        QLog.i("StickerRecManager", 1, "onDestroy  switchOn:" + isSwitchOn);
        if (isSwitchOn) {
            this.mFavEmoticonHandleListener = null;
            this.mStickerRecLocalEmoticonChangeListeners.clear();
        }
    }

    public List<g> perkData(List<g> list, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (List) iPatchRedirector.redirect((short) 22, this, list, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
        if (list != null) {
            try {
                if (list.size() != 0) {
                    list.size();
                    ArrayList arrayList = new ArrayList();
                    for (g gVar : list) {
                        if (!(gVar instanceof o) || ((o) gVar).k() != 3 || (z17 && !z16 && i3 != 4)) {
                            arrayList.add(gVar);
                        }
                    }
                    return arrayList;
                }
            } catch (Exception e16) {
                QLog.e("StickerRecManager", 1, "perkData has exception:", e16);
            }
        }
        return null;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public String preProcessUsrText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        return com.tencent.qqnt.emotion.utils.s.a(StringUtil.toSemiAngleString(com.tencent.qqnt.emotion.utils.s.c(str)).toLowerCase());
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public String preProcessUsrTextUseLocalSearch(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return com.tencent.qqnt.emotion.utils.s.a(StringUtil.toSemiAngleString(com.tencent.qqnt.emotion.utils.s.c(str)));
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public void pullWords() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            if (this.mHasPullWords) {
                return;
            }
            this.mHasPullWords = true;
            initDir();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.emotion.stickerrecommended.impl.StickerRecManagerImpl.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StickerRecManagerImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("StickerRecManager", 2, "start pull words");
                    }
                    StickerRecManagerImpl stickerRecManagerImpl = StickerRecManagerImpl.this;
                    stickerRecManagerImpl.sendPullWordsRequest(stickerRecManagerImpl.mCurrentLoginAccountUin, 3, 255, 0);
                }
            }, 128, null, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public void reportEvent(List<z> list, boolean z16, int i3, String str) {
        String str2;
        w wVar;
        String str3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 3;
        int i18 = 2;
        int i19 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, list, Boolean.valueOf(z16), Integer.valueOf(i3), str);
            return;
        }
        if (list != null && list.size() != 0) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String str4 = "StickerRecManager";
            if (peekAppRuntime == null) {
                QLog.d("StickerRecManager", 1, "[reportEvent] error, app is null!");
                return;
            }
            for (z zVar : list) {
                if (zVar != null) {
                    String str5 = zVar.f356673b;
                    List<? extends g> list2 = zVar.f356675d;
                    StringBuilder sb5 = new StringBuilder();
                    StringBuilder sb6 = new StringBuilder();
                    if (z16) {
                        if (i3 == i19) {
                            str2 = "c2c";
                        } else if (i3 == i18) {
                            str2 = VipFunCallConstants.KEY_GROUP;
                        } else if (i3 == i17) {
                            str2 = "discuss";
                        } else {
                            str2 = "other";
                        }
                    } else {
                        str2 = "";
                    }
                    g gVar = null;
                    for (g gVar2 : list2) {
                        String str6 = str4;
                        gVar2.endExposed(System.currentTimeMillis());
                        if (gVar2.getImgMd5() == null) {
                            str4 = str6;
                            i19 = 1;
                        } else {
                            String reportEventPrefix = gVar2.getReportEventPrefix();
                            if (!TextUtils.isEmpty(reportEventPrefix)) {
                                sb5.append(reportEventPrefix);
                            }
                            sb5.append(gVar2.getImgMd5());
                            sb5.append(";");
                            if (gVar2.getImgUrl() != null) {
                                sb6.append(gVar2.getImgUrl());
                                sb6.append(";");
                            }
                            if (gVar2.isClicked()) {
                                gVar = gVar2;
                            }
                            if (gVar2.exposedTime() != 0) {
                                i19 = 1;
                                v.d(true, str5, i3, str, gVar2);
                            } else {
                                i19 = 1;
                            }
                            str4 = str6;
                        }
                    }
                    String str7 = str4;
                    String sb7 = sb5.toString();
                    String sb8 = sb6.toString();
                    long longValue = Long.valueOf(this.mCurrentLoginAccountUin).longValue();
                    if (zVar.f356672a == i19) {
                        com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.b bVar = new com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.b();
                        bVar.f356671i = "dc05550";
                        bVar.f356630l = str5;
                        bVar.f356628j = String.valueOf(longValue);
                        bVar.f356629k = str;
                        bVar.f356631m = str2;
                        wVar = bVar;
                    } else {
                        w wVar2 = new w();
                        wVar2.f356671i = "dc04577";
                        wVar2.f356660k = str5;
                        if (QLog.isColorLevel()) {
                            wVar2.f356660k = stringToUnicode(wVar2.f356660k);
                        }
                        wVar2.f356659j = String.valueOf(longValue);
                        wVar2.f356662m = str;
                        wVar2.f356661l = str2;
                        wVar = wVar2;
                    }
                    wVar.f356670h = this.mSessionId;
                    wVar.f356669g = zVar.f356674c;
                    wVar.f356663a = String.valueOf(com.tencent.qqnt.util.b.f362976b.getAppId());
                    if (gVar != null) {
                        String imgMd5 = gVar.getImgMd5();
                        String reportEventPrefix2 = gVar.getReportEventPrefix();
                        if (!TextUtils.isEmpty(reportEventPrefix2)) {
                            imgMd5 = reportEventPrefix2 + imgMd5;
                        }
                        wVar.f356666d = imgMd5;
                        wVar.f356667e = gVar.getImgUrl();
                        v.d(false, str5, i3, str, gVar);
                    }
                    wVar.f356664b = sb7;
                    wVar.f356665c = sb8;
                    wVar.f356668f = "android";
                    JSONObject a16 = wVar.a();
                    NewIntent newIntent = new NewIntent(BaseApplication.getContext(), y.class);
                    newIntent.putExtra("key_cmd", SSO_CMD_REPORT_NEW);
                    newIntent.putExtra(ProtoServlet.KEY_BODY, fh.b(a16.toString().getBytes()));
                    if (QLog.isColorLevel()) {
                        str3 = str7;
                        i16 = 2;
                        QLog.d(str3, 2, "report StickerRecReport content:" + wVar.a().toString());
                    } else {
                        str3 = str7;
                        i16 = 2;
                    }
                    peekAppRuntime.startServlet(newIntent);
                    i18 = i16;
                    i17 = 3;
                    str4 = str3;
                    i19 = 1;
                }
            }
        }
    }

    public synchronized void sendPullPicsRequest(String str, int i3, int i16, String str2, List<String> list, StickerRecKeywordFrom stickerRecKeywordFrom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, list, stickerRecKeywordFrom);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d("StickerRecManager", 1, "[sendPullPicsRequest] error, app is null!");
            return;
        }
        String str3 = str + SystemClock.uptimeMillis();
        byte[] byteArray = getPullPicsRequestBody(str3, str, i3, i16, str2, list).toByteArray();
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
        allocate.putInt(byteArray.length + 4).put(byteArray);
        byte[] array = allocate.array();
        NewIntent newIntent = new NewIntent(BaseApplication.getContext(), y.class);
        newIntent.putExtra(ProtoServlet.KEY_BODY, array);
        newIntent.putExtra("key_cmd", CMD_PULL_PICS);
        String str4 = list.get(0);
        newIntent.putExtra(USER_KEYWORD_KEY, str4);
        if (i3 == 4) {
            z16 = true;
        }
        newIntent.putExtra("fromQzone", z16);
        newIntent.putExtra(REQUEST_AIO_TYPE, i16);
        newIntent.putExtra(STICKER_REC_KEYWORD_FROM, stickerRecKeywordFrom.ordinal());
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "send pull pics args. sessionId = " + str3 + " uin=" + str + " termType=" + i3 + " aioType : " + i16 + " toUin : " + str2 + " keyword: " + stringToUnicode(str4));
        }
        peekAppRuntime.startServlet(newIntent);
    }

    public synchronized void sendPullWordsRequest(String str, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d("StickerRecManager", 1, "[sendPullWordsRequest] error, app is null!");
            return;
        }
        if (!StringUtil.isValideUin(str)) {
            if (QLog.isColorLevel()) {
                QLog.e("StickerRecManager", 2, " fromUin is invalid!!");
            }
            return;
        }
        PicSearchWordsSvr$ReqBody picSearchWordsSvr$ReqBody = new PicSearchWordsSvr$ReqBody();
        picSearchWordsSvr$ReqBody.setHasFlag(true);
        String str2 = str + SystemClock.uptimeMillis();
        String valueOf = String.valueOf(com.tencent.qqnt.util.b.f362976b.getAppId());
        String c16 = com.tencent.mobileqq.cooperation.a.c(BaseApplication.getContext());
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "pull words args:sessionId = " + str2 + " uin=" + str + " termType=" + i3 + " appId=" + valueOf + " appVersion=" + c16 + " gender=" + i16);
        }
        picSearchWordsSvr$ReqBody.bytes_session_id.set(ByteStringMicro.copyFromUtf8(str2));
        picSearchWordsSvr$ReqBody.uint64_src_uin.set(Long.parseLong(str));
        picSearchWordsSvr$ReqBody.uint32_src_term.set(i3);
        picSearchWordsSvr$ReqBody.bytes_appid.set(ByteStringMicro.copyFromUtf8(valueOf));
        picSearchWordsSvr$ReqBody.bytes_version.set(ByteStringMicro.copyFromUtf8(c16));
        picSearchWordsSvr$ReqBody.uin32_gender.set(i16);
        picSearchWordsSvr$ReqBody.uint32_age.set(i17);
        byte[] byteArray = picSearchWordsSvr$ReqBody.toByteArray();
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
        allocate.putInt(byteArray.length + 4).put(byteArray);
        byte[] array = allocate.array();
        NewIntent newIntent = new NewIntent(BaseApplication.getContext(), y.class);
        newIntent.putExtra(ProtoServlet.KEY_BODY, array);
        newIntent.putExtra("key_cmd", CMD_PULL_WORDS);
        peekAppRuntime.startServlet(newIntent);
    }

    public synchronized void sendScenesPullPicsRequest(String str, int i3, int i16, String str2, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, cVar);
            return;
        }
        if (cVar != null && cVar.c() != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.d("StickerRecManager", 1, "[sendScenesPullPicsRequest] error, app is null!");
                return;
            }
            String str3 = str + SystemClock.uptimeMillis();
            byte[] byteArray = getPullPicsRequestBody(str3, str, i3, i16, str2, cVar.a()).toByteArray();
            ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
            allocate.putInt(byteArray.length + 4).put(byteArray);
            byte[] array = allocate.array();
            NewIntent newIntent = new NewIntent(BaseApplication.getContext(), y.class);
            newIntent.putExtra(ProtoServlet.KEY_BODY, array);
            newIntent.putExtra("key_cmd", CMD_SCENES_PULL_PICS);
            String c16 = cVar.c();
            newIntent.putExtra(REQUEST_SCENES_ID_KEY, c16);
            newIntent.putExtra(USER_KEYWORD_KEY, c16);
            if (i3 != 4) {
                z16 = false;
            }
            newIntent.putExtra("fromQzone", z16);
            newIntent.putExtra(REQUEST_AIO_TYPE, i16);
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecManager", 2, "send pull scenes pics args. sessionId = " + str3 + " uin=" + str + " termType=" + i3 + " aioType : " + i16 + " toUin : " + str2 + " scenesID: " + c16);
            }
            peekAppRuntime.startServlet(newIntent);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public synchronized void setCurrentText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.mCurrentText = str;
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public void setForbidInsertOtherEmotion(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, z16);
        } else {
            this.mForbidInsertOtherEmotion = z16;
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public void setForceUpdateCache(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, z16);
        } else {
            this.mForceUpdateCache = z16;
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public void setImgUpdateListener(IStickerRecManager.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.imgUpdateListener = aVar;
        }
    }

    public void showLocalEmo(String str, boolean z16, StickerRecKeywordFrom stickerRecKeywordFrom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, Boolean.valueOf(z16), stickerRecKeywordFrom);
            return;
        }
        String preProcessUsrTextUseLocalSearch = preProcessUsrTextUseLocalSearch(str);
        handleLocalEmoticon(z16, preProcessUsrTextUseLocalSearch);
        if (this.imgUpdateListener != null && !this.stickerRecDataLocalList.isEmpty()) {
            this.imgUpdateListener.a(this.stickerRecDataLocalList, preProcessUsrTextUseLocalSearch, "999", 0, null, stickerRecKeywordFrom);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public void syncAddLocalEmoticonKeywords(Collection<String> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) collection);
            return;
        }
        if (collection != null && !collection.isEmpty() && this.mLocalKeywordsSet != null) {
            synchronized (StickerRecManagerImpl.class) {
                this.mLocalKeywordsSet.addAll(collection);
                writeObjectAbsPath(this.mLocalWordsFile.getAbsolutePath(), this.mLocalKeywordsSet);
            }
        }
    }

    public void unInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "unInit executed");
        }
        this.bloomFilter = null;
        this.maxMatchLength = 6;
        this.hasInit = false;
        this.mLocalKeywordsSet = null;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public void updateEmotionRecSetting(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
        } else {
            this.emotionRecSettingSwitch = z16;
            updateEmotionRecSettingSwitch(BaseApplication.getContext(), this.mCurrentLoginAccountUin, z16);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public void updateKeywordForFavEmotion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
            return;
        }
        s sVar = this.mFavEmoticonHandleListener;
        if (sVar == null) {
            return;
        }
        sVar.c();
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public void updateSort(AIOContact aIOContact) {
        StickerRecommendSortEntity stickerRecommendSortEntity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) aIOContact);
            return;
        }
        ArrayList arrayList = new ArrayList(this.mStickerReportItems);
        if (aIOContact == null) {
            reportEvent(arrayList, false, 0, null);
        } else {
            reportEvent(arrayList, true, aIOContact.e(), aIOContact.j());
        }
        for (z zVar : arrayList) {
            if (zVar != null) {
                String str = zVar.f356673b;
                int i3 = zVar.f356672a;
                if (i3 == 1) {
                    stickerRecommendSortEntity = (StickerRecommendSortEntity) this.entityManager.e(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType==1", new String[]{str});
                } else {
                    stickerRecommendSortEntity = (StickerRecommendSortEntity) this.entityManager.e(StickerRecommendSortEntity.class, "usrMessage=? AND recommendType!=1", new String[]{str});
                }
                if (stickerRecommendSortEntity != null) {
                    stickerRecommendSortEntity.convertToList();
                    for (g gVar : zVar.f356675d) {
                        if (!gVar.isStickerRecFromLocal()) {
                            o oVar = (o) gVar;
                            Integer valueOf = Integer.valueOf(oVar.n());
                            if (oVar.isClicked()) {
                                if (stickerRecommendSortEntity.clickedList.contains(valueOf)) {
                                    stickerRecommendSortEntity.removeClicked(valueOf);
                                }
                                stickerRecommendSortEntity.addClicked(valueOf);
                                stickerRecommendSortEntity.updateClicked(valueOf);
                            } else if (!stickerRecommendSortEntity.exposedList.contains(valueOf)) {
                                stickerRecommendSortEntity.addExposed(valueOf);
                            }
                            stickerRecommendSortEntity.removeNoExpose(valueOf);
                        }
                    }
                    stickerRecommendSortEntity.exposedList.removeAll(stickerRecommendSortEntity.clickedList);
                    handleEntity(stickerRecommendSortEntity);
                    stickerRecommendSortEntity.convertToString();
                    if (QLog.isColorLevel()) {
                        QLog.i("StickerRecManager", 2, "updateSort clicked=" + stickerRecommendSortEntity.clicked + " exposed=" + stickerRecommendSortEntity.exposed + " noExpose=" + stickerRecommendSortEntity.noExpose);
                    }
                    stickerRecommendSortEntity.recommendType = i3;
                    this.entityManager.j(stickerRecommendSortEntity);
                } else {
                    StickerRecommendSortEntity stickerRecommendSortEntity2 = new StickerRecommendSortEntity(str);
                    if (this.hasFilteredZPlanMeme) {
                        stickerRecommendSortEntity2.noExposeList.add(Integer.valueOf(this.zPlanIndex));
                        this.hasFilteredZPlanMeme = false;
                    }
                    for (g gVar2 : zVar.f356675d) {
                        if (!gVar2.isStickerRecFromLocal()) {
                            o oVar2 = (o) gVar2;
                            if (oVar2.isClicked()) {
                                stickerRecommendSortEntity2.addClicked(Integer.valueOf(oVar2.n()));
                                stickerRecommendSortEntity2.updateClicked(Integer.valueOf(oVar2.n()));
                            } else {
                                stickerRecommendSortEntity2.addExposed(Integer.valueOf(oVar2.n()));
                            }
                        }
                    }
                    for (g gVar3 : zVar.f356676e) {
                        if (!gVar3.isStickerRecFromLocal()) {
                            stickerRecommendSortEntity2.addNoExpose(Integer.valueOf(((o) gVar3).n()));
                        }
                    }
                    handleEntity(stickerRecommendSortEntity2);
                    stickerRecommendSortEntity2.convertToString();
                    if (QLog.isColorLevel()) {
                        QLog.i("StickerRecManager", 2, "updateSort new SortEntity clicked=" + stickerRecommendSortEntity2.clicked + " exposed=" + stickerRecommendSortEntity2.exposed + " noExpose=" + stickerRecommendSortEntity2.noExpose);
                    }
                    stickerRecommendSortEntity2.recommendType = i3;
                    this.entityManager.g(stickerRecommendSortEntity2);
                }
            }
        }
        this.mStickerReportItems.clear();
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager
    public void updateStickerLastTime(List<StickerRecCacheEntity> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) list);
        } else {
            if (this.entityManager == null) {
                return;
            }
            this.mDbHandler.post(new Runnable(list) { // from class: com.tencent.qqnt.emotion.stickerrecommended.impl.StickerRecManagerImpl.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ List f356547d;

                {
                    this.f356547d = list;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StickerRecManagerImpl.this, (Object) list);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    for (StickerRecCacheEntity stickerRecCacheEntity : this.f356547d) {
                        StickerRecCacheEntity stickerRecCacheEntity2 = (StickerRecCacheEntity) StickerRecManagerImpl.this.entityManager.e(StickerRecCacheEntity.class, "md5=?", new String[]{stickerRecCacheEntity.md5});
                        if (stickerRecCacheEntity2 != null) {
                            if (QLog.isColorLevel()) {
                                QLog.d("StickerRecManager", 2, "old exist: fileName=" + stickerRecCacheEntity2.md5 + " lastTime=" + stickerRecCacheEntity2.lastTime);
                            }
                            stickerRecCacheEntity2.lastTime = stickerRecCacheEntity.lastTime;
                            StickerRecManagerImpl.this.entityManager.j(stickerRecCacheEntity2);
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("StickerRecManager", 2, "old not exist: fileName=" + stickerRecCacheEntity.md5 + " lastTime=" + stickerRecCacheEntity.lastTime);
                            }
                            StickerRecManagerImpl.this.entityManager.g(stickerRecCacheEntity);
                        }
                    }
                }
            });
        }
    }

    public static IStickerRecManager get(AppRuntime appRuntime) {
        if (appRuntime == null) {
            QLog.e("StickerRecManager", 1, "get StickerRecManagerImpl error, app is null!");
            return null;
        }
        return (IStickerRecManager) appRuntime.getRuntimeService(IStickerRecManager.class, "");
    }

    public boolean analyze(final String str, int i3, String str2, boolean z16, boolean z17, final StickerRecKeywordFrom stickerRecKeywordFrom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, str, Integer.valueOf(i3), str2, Boolean.valueOf(z16), Boolean.valueOf(z17), stickerRecKeywordFrom)).booleanValue();
        }
        if (!hasInit()) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecManager", 2, "can't analyze, has not init");
            }
            return false;
        }
        try {
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("StickerRecManager", 2, ThrowablesUtils.getStackTraceAsString(e16));
            }
        }
        if (!TextUtils.isEmpty(str) && str.length() <= this.maxMatchLength) {
            boolean contains = this.bloomFilter.contains(str);
            String stringToUnicode = stringToUnicode(str);
            if (!contains) {
                if (QLog.isColorLevel()) {
                    QLog.d("StickerRecManager", 2, "word : " + stringToUnicode + " miss dict");
                }
                if (!z17 || this.imgUpdateListener == null) {
                    return false;
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.emotion.stickerrecommended.impl.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        StickerRecManagerImpl.this.lambda$analyze$0(str, stickerRecKeywordFrom);
                    }
                }, 16, null, true);
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecManager", 2, "word : " + stringToUnicode + " in dict");
            }
            showEmoticon(str, i3, str2, z16, z17, str, stickerRecKeywordFrom);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "userTxt over maxMatchLength or empty");
        }
        return false;
    }
}
