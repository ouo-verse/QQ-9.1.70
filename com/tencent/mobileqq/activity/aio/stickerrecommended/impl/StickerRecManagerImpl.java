package com.tencent.mobileqq.activity.aio.stickerrecommended.impl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.ark.ark;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.activity.aio.stickerrecommended.BloomFilter;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCacheEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecData;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendSortEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.d;
import com.tencent.mobileqq.activity.aio.stickerrecommended.e;
import com.tencent.mobileqq.activity.aio.stickerrecommended.g;
import com.tencent.mobileqq.activity.aio.stickerrecommended.h;
import com.tencent.mobileqq.activity.aio.stickerrecommended.k;
import com.tencent.mobileqq.activity.aio.stickerrecommended.m;
import com.tencent.mobileqq.activity.aio.stickerrecommended.n;
import com.tencent.mobileqq.activity.aio.stickerrecommended.o;
import com.tencent.mobileqq.activity.aio.stickerrecommended.r;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.b;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.impl.ScenesRecommendManagerImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IIceBreakingMsg;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.ProtoServlet;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.cq;
import com.tencent.mobileqq.util.cr;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.pb.emosm.PicSearchSvr$EmotionInfo;
import com.tencent.pb.emosm.PicSearchSvr$ImgInfo;
import com.tencent.pb.emosm.PicSearchSvr$ReqBody;
import com.tencent.pb.emosm.PicSearchSvr$RspBody;
import com.tencent.pb.emosm.PicSearchWordsSvr$ReqBody;
import com.tencent.pb.emosm.PicSearchWordsSvr$RspBody;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.util.ThrowablesUtils;
import cooperation.qzone.QUA;
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
/* loaded from: classes10.dex */
public class StickerRecManagerImpl implements IStickerRecManager {
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
    private static final String SSO_CMD_REPORT_NEW = "MQInference.CommonReport";
    public static final String TAG = "StickerRecManager";
    private static final String USER_KEYWORD_KEY = "USER_KEYWORD";
    private static final String WORDS_FILE_NAME = "words.json";
    private static final String WORDS_VERSION_KEY = "words_version_key805_gray_one";
    private static final String WORDS_ZIP_FILE_NAME = "words.zip";
    private static Integer sMaxMatchLength;
    private static Boolean sRecStickerSwitch;
    private IStickerRecManager.ImgUpdateListener imgUpdateListener;
    private BaseQQAppInterface mApp;
    private g mCameraEmoticonHandleListener;
    private File mDownloadFile;
    private File mEncodedBloomFile;
    private k mFavEmoticonHandleListener;
    private File mLocalWordsFile;
    private List<d> mStickerRecLocalEmoticonChangeListeners;
    private File mWordsFile;
    private volatile boolean hasInit = false;
    private int maxMatchLength = 6;
    private EntityManager entityManager = null;
    private List<r> mStickerReportItems = new ArrayList();
    private volatile String mCurrentText = "";
    private HashSet<String> mLocalKeywordsSet = null;
    public List<IStickerRecEmoticon> stickerRecDataLocalList = new CopyOnWriteArrayList();
    private boolean mForceUpdateCache = false;
    private Card mCard = null;
    private String mSessionId = "";
    private boolean emotionRecSettingSwitch = true;
    private MqqHandler mDbHandler = ThreadManager.getFileThreadHandler();
    private int zPlanIndex = -1;
    private boolean hasFilteredZPlanMeme = false;
    private BloomFilter bloomFilter = null;

    private void cacheResInDb(byte[] bArr, String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "cache pics in DB");
        }
        if (this.entityManager != null) {
            final StickerRecommendEntity stickerRecommendEntity = new StickerRecommendEntity();
            stickerRecommendEntity.usrMessage = str;
            stickerRecommendEntity.recList = Base64.encodeToString(bArr, 0);
            stickerRecommendEntity.cachedTime = System.currentTimeMillis();
            stickerRecommendEntity.recommendType = i3;
            this.mDbHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    StickerRecManagerImpl.this.entityManager.persistOrReplace(stickerRecommendEntity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int convertAIOType(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 != 1) {
            if (i3 != 3000) {
                return 4;
            }
            return 3;
        }
        return 2;
    }

    @NotNull
    private List<IStickerRecEmoticon> fillData(int i3, PicSearchSvr$RspBody picSearchSvr$RspBody, List<PicSearchSvr$ImgInfo> list) {
        String str;
        if (picSearchSvr$RspBody.bytes_rsp_other.has()) {
            str = picSearchSvr$RspBody.bytes_rsp_other.get().toStringUtf8();
        } else {
            str = null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < list.size(); i16++) {
            PicSearchSvr$ImgInfo picSearchSvr$ImgInfo = list.get(i16);
            StickerRecData stickerRecData = new StickerRecData();
            stickerRecData.setIndex(i16);
            stickerRecData.setImgFileSize(picSearchSvr$ImgInfo.uint64_img_size.get());
            stickerRecData.setImgWidth(picSearchSvr$ImgInfo.uint32_img_width.get());
            stickerRecData.setImgHeight(picSearchSvr$ImgInfo.uint32_img_height.get());
            stickerRecData.setImgMd5(picSearchSvr$ImgInfo.bytes_img_md5.get().toStringUtf8());
            stickerRecData.setImgUrl(picSearchSvr$ImgInfo.bytes_img_down_url.get().toStringUtf8());
            stickerRecData.setThumbFileSize(picSearchSvr$ImgInfo.uint64_thumb_size.get());
            stickerRecData.setThumbHeight(picSearchSvr$ImgInfo.uint32_thumb_img_height.get());
            stickerRecData.setThumbWidth(picSearchSvr$ImgInfo.uint32_thumb_img_width.get());
            stickerRecData.setThumbUrl(picSearchSvr$ImgInfo.bytes_thumb_down_url.get().toStringUtf8());
            stickerRecData.setThumbMd5(picSearchSvr$ImgInfo.bytes_thumb_img_md5.get().toStringUtf8());
            stickerRecData.setFromType(picSearchSvr$ImgInfo.uint32_src_type.get());
            stickerRecData.setSource(picSearchSvr$ImgInfo.bytes_src_desc.get().toStringUtf8());
            stickerRecData.setWebUrl(picSearchSvr$ImgInfo.bytes_web_url.get().toStringUtf8());
            stickerRecData.setIconUrl("");
            stickerRecData.setPackageName(picSearchSvr$ImgInfo.bytes_pack_name.get().toStringUtf8());
            stickerRecData.setEpId(picSearchSvr$ImgInfo.uint32_pack_id.get());
            if (picSearchSvr$ImgInfo.bytes_img_other.has()) {
                stickerRecData.setAlgoInfo(picSearchSvr$ImgInfo.bytes_img_other.get().toStringUtf8());
            }
            stickerRecData.setRecomTransfer(str);
            stickerRecData.setRecType(i3);
            if (picSearchSvr$ImgInfo.msg_emotion_info.has()) {
                PicSearchSvr$EmotionInfo picSearchSvr$EmotionInfo = picSearchSvr$ImgInfo.msg_emotion_info;
                if (picSearchSvr$EmotionInfo.bytes_url.has()) {
                    stickerRecData.setZPlanInfo(picSearchSvr$EmotionInfo.bytes_url.get().toStringUtf8());
                }
            }
            if (stickerRecData.getFromType() == 3 && QLog.isColorLevel()) {
                QLog.i("StickerRecManager", 2, "receive ZPlanEmo from:" + stickerRecData.getFromType() + ", ZPlanInfo:" + com.tencent.util.k.f(stickerRecData.getZPlanInfo(), Arrays.asList("zh_name")));
            }
            arrayList.add(stickerRecData);
        }
        return arrayList;
    }

    private List<IStickerRecEmoticon> filterData(List<IStickerRecEmoticon> list) {
        StickerRecData stickerRecData;
        String zPlanInfo;
        boolean z16;
        ArrayList arrayList = new ArrayList(list);
        for (int i3 = 0; i3 < list.size(); i3++) {
            if ((list.get(i3) instanceof StickerRecData) && (zPlanInfo = (stickerRecData = (StickerRecData) list.get(i3)).getZPlanInfo()) != null) {
                try {
                    JSONObject jSONObject = new JSONObject(zPlanInfo);
                    if (jSONObject.optInt("iszplan") == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        this.zPlanIndex = stickerRecData.getIndex();
                        if (!isZPlanMemeRecordCompleted(jSONObject)) {
                            arrayList.remove(i3);
                            this.hasFilteredZPlanMeme = true;
                            QLog.i("StickerRecManager", 1, "zplan meme has been filtered");
                        } else {
                            this.hasFilteredZPlanMeme = false;
                        }
                        return arrayList;
                    }
                } catch (JSONException e16) {
                    QLog.e("StickerRecManager", 1, "filterData has exception:", e16);
                }
            }
        }
        return arrayList;
    }

    public static StickerRecManagerImpl get(AppInterface appInterface) {
        return (StickerRecManagerImpl) appInterface.getRuntimeService(IStickerRecManager.class, "");
    }

    private String getDataDir() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.mApp.getApp().getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb5.append(str);
        sb5.append(this.mApp.getCurrentUin());
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
            return new File(h.f179915a + Utils.Crc64String(str));
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static boolean getEmotionRecSettingSwitch(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("emotion_rec_setting_switch_" + str, true);
    }

    public static long getLastTimeRemoveEmoticonPackage(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sticker_remove_emoticon_package_time_" + str, 0L);
    }

    public static int getMaxMatchLength() {
        return 15;
    }

    private String getPullPicsExtInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (isZPlanEnable()) {
                jSONObject.put("type", "zplan");
                jSONObject.put("ue_engine_version", ((IZPlanApi) QRoute.api(IZPlanApi.class)).getZPlanVersion());
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
        picSearchSvr$ReqBody.bytes_app_qua.set(ByteStringMicro.copyFromUtf8(QUA.getQUA3()));
        picSearchSvr$ReqBody.uint32_support_emotion.set(1);
        picSearchSvr$ReqBody.bytes_ext_info.set(ByteStringMicro.copyFromUtf8(getPullPicsExtInfo()));
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ByteStringMicro.copyFromUtf8(it.next()));
            }
            picSearchSvr$ReqBody.bytes_key_word.set(arrayList);
        }
        Card card = this.mCard;
        if (card != null) {
            picSearchSvr$ReqBody.uint32_age.set(card.age);
        } else {
            picSearchSvr$ReqBody.uint32_age.set(0);
        }
        return picSearchSvr$ReqBody;
    }

    public static String getStickerRecVersion(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str2 + "_" + str, "");
    }

    private int getcmShowIsEnable() {
        boolean isCmShowKeywordAssociationEnabled = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).isCmShowKeywordAssociationEnabled();
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "getcmShowIsEnable iscmsEnable : " + isCmShowKeywordAssociationEnabled);
        }
        return isCmShowKeywordAssociationEnabled ? 1 : 0;
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

    private void handleLocalEmoticon(boolean z16, String str, p pVar) {
        List<? extends IStickerRecEmoticon> b16;
        this.stickerRecDataLocalList.clear();
        ArrayList arrayList = new ArrayList();
        if (z16 && this.mStickerRecLocalEmoticonChangeListeners != null) {
            long currentTimeMillis = System.currentTimeMillis();
            for (d dVar : this.mStickerRecLocalEmoticonChangeListeners) {
                if (dVar.a(this.mApp, str) && (b16 = dVar.b(str, pVar)) != null && !b16.isEmpty()) {
                    arrayList.addAll(b16);
                }
            }
            List c16 = e.c(this.mApp, arrayList);
            if (c16 != null && !c16.isEmpty()) {
                this.stickerRecDataLocalList.addAll(c16);
            }
            for (int i3 = 0; i3 < this.stickerRecDataLocalList.size(); i3++) {
                this.stickerRecDataLocalList.get(i3).onEmoticonWillShow(this.mApp, i3);
            }
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecManager", 2, "handleLocalEmoticon time = " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePullPics(byte[] bArr, String str, String str2, boolean z16, StickerRecommendSortEntity stickerRecommendSortEntity, int i3, int i16) {
        List<IStickerRecEmoticon> list;
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
            List<IStickerRecEmoticon> fillData = fillData(i3, picSearchSvr$RspBody, handleSearchEmptyImg);
            List<IStickerRecEmoticon> sortData = sortData(fillData, stickerRecommendSortEntity);
            if (sortData != null) {
                fillData = sortData;
            }
            List<IStickerRecEmoticon> zplanEmoticonSort = zplanEmoticonSort(fillData, str2);
            List<IStickerRecEmoticon> perkData = perkData(zplanEmoticonSort, i16, z16, ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).isCmShowKeywordAssociationEnabled());
            if (perkData != null) {
                zplanEmoticonSort = perkData;
            }
            List<IStickerRecEmoticon> filterData = filterData(zplanEmoticonSort);
            List<IStickerRecEmoticon> list2 = this.stickerRecDataLocalList;
            if (list2 != null && !list2.isEmpty()) {
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
            onImgUpdated(str, z16, i3, list, str3);
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
            String stickerRecVersion = getStickerRecVersion(this.mApp.getApp(), WORDS_VERSION_KEY, this.mApp.getCurrentUin());
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
    private List<PicSearchSvr$ImgInfo> handleSearchEmptyImg(final String str, String str2, final int i3, PicSearchSvr$RspBody picSearchSvr$RspBody) {
        List<PicSearchSvr$ImgInfo> list = picSearchSvr$RspBody.rpt_msg_img_info.get();
        if (list != null && !list.isEmpty()) {
            return list;
        }
        if ("network".equals(str2)) {
            reportEmptyImg();
        }
        if (this.entityManager != null) {
            this.mDbHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == 1) {
                        StickerRecManagerImpl.this.entityManager.delete(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType==1", new String[]{str});
                    } else {
                        StickerRecManagerImpl.this.entityManager.delete(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType!=1", new String[]{str});
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
        if (this.mForceUpdateCache || System.currentTimeMillis() - stickerRecommendEntity.cachedTime >= 86400000) {
            return false;
        }
        return true;
    }

    public static boolean isStickerPics(MessageForPic messageForPic) {
        PicMessageExtraData picMessageExtraData;
        if (messageForPic != null && (picMessageExtraData = messageForPic.picExtraData) != null && (picMessageExtraData.isStickerPics() || messageForPic.picExtraData.isStickerAdPic())) {
            return true;
        }
        return false;
    }

    public static boolean isStickerRecFromLocal(IStickerRecEmoticon iStickerRecEmoticon) {
        return iStickerRecEmoticon.isStickerRecFromLocal();
    }

    public static boolean isStickerRecFromRemote(IStickerRecEmoticon iStickerRecEmoticon) {
        return !isStickerRecFromLocal(iStickerRecEmoticon);
    }

    private boolean isZPlanEnable() {
        return ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(Constant.FROM_ID_START_ACTIVITY, this.mApp.getLongAccountUin());
    }

    private boolean isZPlanMemeRecordCompleted(JSONObject jSONObject) {
        int i3;
        try {
            if (jSONObject.has(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID)) {
                i3 = ((Integer) jSONObject.get(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID)).intValue();
            } else if (jSONObject.has("actionId")) {
                i3 = ((Integer) jSONObject.get("actionId")).intValue();
            } else if (jSONObject.has("id")) {
                i3 = ((Integer) jSONObject.get("id")).intValue();
            } else {
                i3 = -1;
            }
            if (i3 == -1) {
                return false;
            }
            return ((IZPlanApi) QRoute.api(IZPlanApi.class)).isEmoticonPicRecorded(i3, this.mApp.getCurrentUin(), jSONObject);
        } catch (JSONException e16) {
            QLog.e("StickerRecManager", 1, "isRecordCompleted has exception:", e16);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$analyze$0(String str, p pVar) {
        showLocalEmo(str, true, pVar);
    }

    private void onImgUpdated(String str, boolean z16, int i3, List<IStickerRecEmoticon> list, String str2) {
        String str3;
        BaseQQAppInterface baseQQAppInterface;
        b findScenesRecItemByID;
        IStickerRecManager.ImgUpdateListener imgUpdateListener;
        if (z16 && (imgUpdateListener = this.imgUpdateListener) != null) {
            imgUpdateListener.onImgUpdated(list, str, str2, 0, null);
            return;
        }
        if (this.imgUpdateListener != null) {
            if (i3 == 1 && (baseQQAppInterface = this.mApp) != null && (findScenesRecItemByID = ScenesRecommendManagerImpl.get(baseQQAppInterface).findScenesRecItemByID(str)) != null) {
                str3 = findScenesRecItemByID.d();
            } else {
                str3 = null;
            }
            this.imgUpdateListener.onImgUpdated(list, str, str2, i3, str3);
        }
    }

    private void putZplanEmoticonToFirst(List<IStickerRecEmoticon> list) {
        IStickerRecEmoticon iStickerRecEmoticon = list.get(0);
        if ((iStickerRecEmoticon instanceof StickerRecData) && ((StickerRecData) iStickerRecEmoticon).isZPlanData()) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 < list.size()) {
                IStickerRecEmoticon iStickerRecEmoticon2 = list.get(i3);
                if ((iStickerRecEmoticon2 instanceof StickerRecData) && ((StickerRecData) iStickerRecEmoticon2).isZPlanData()) {
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
            IStickerRecEmoticon iStickerRecEmoticon3 = list.get(i3);
            list.remove(i3);
            list.add(0, iStickerRecEmoticon3);
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0072: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:115), block:B:40:0x0072 */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                if (QLog.isColorLevel()) {
                    QLog.i("StickerRecManager", 2, "FileUtils.readObjectAbs throw an Exception. fileName=" + str + ", Exception=" + e.toString());
                }
                boolean z16 = e instanceof InvalidClassException;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                if (z16) {
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
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecEmptyImg", false, 0L, 0L, null, "");
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
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecInitCost", z16, 0L, 0L, hashMap, "");
    }

    private void showEmoticon(final String str, final int i3, final String str2, final boolean z16, final boolean z17, final p pVar, final String str3) {
        this.mDbHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                int i16;
                if (StickerRecManagerImpl.this.entityManager != null) {
                    try {
                        StickerRecManagerImpl.this.showLocalEmo(str, z17, pVar);
                        StickerRecommendEntity stickerRecommendEntity = (StickerRecommendEntity) DBMethodProxy.find(StickerRecManagerImpl.this.entityManager, StickerRecommendEntity.class, "usrMessage=? AND recommendType!=1", new String[]{str3});
                        if (stickerRecommendEntity == null) {
                            if (QLog.isColorLevel()) {
                                QLog.d("StickerRecManager", 2, "entity is null");
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.d("StickerRecManager", 2, "cache Time : " + (System.currentTimeMillis() - stickerRecommendEntity.cachedTime));
                        }
                        int convertAIOType = StickerRecManagerImpl.this.convertAIOType(i3);
                        if (stickerRecommendEntity != null && StickerRecManagerImpl.this.isCacheValid(stickerRecommendEntity)) {
                            byte[] decode = Base64.decode(stickerRecommendEntity.recList, 0);
                            StickerRecommendSortEntity stickerRecommendSortEntity = (StickerRecommendSortEntity) DBMethodProxy.find(StickerRecManagerImpl.this.entityManager, StickerRecommendSortEntity.class, "usrMessage=? AND recommendType!=1", new String[]{str3});
                            if (stickerRecommendSortEntity != null) {
                                stickerRecommendSortEntity.convertToList();
                            }
                            StickerRecManagerImpl.this.handlePullPics(decode, str3, "cache", z16, stickerRecommendSortEntity, 0, convertAIOType);
                            return;
                        }
                        StickerRecManagerImpl.this.entityManager.delete(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType!=1", new String[]{str3});
                        StickerRecManagerImpl.this.entityManager.delete(StickerRecommendSortEntity.class.getSimpleName(), "usrMessage=? AND recommendType!=1", new String[]{str3});
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str3);
                        StickerRecManagerImpl stickerRecManagerImpl = StickerRecManagerImpl.this;
                        String currentUin = stickerRecManagerImpl.mApp.getCurrentUin();
                        if (z16) {
                            i16 = 4;
                        } else {
                            i16 = 3;
                        }
                        stickerRecManagerImpl.sendPullPicsRequest(currentUin, i16, convertAIOType, str2, arrayList);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("StickerRecManager", 2, ThrowablesUtils.getStackTraceAsString(e16));
                        }
                    }
                }
            }
        });
    }

    private List<IStickerRecEmoticon> sortData(List<IStickerRecEmoticon> list, StickerRecommendSortEntity stickerRecommendSortEntity) {
        int i3;
        int i16;
        int i17;
        if (stickerRecommendSortEntity != null) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.i("StickerRecManager", 2, "updateSort clicked=" + stickerRecommendSortEntity.clicked + " exposed=" + stickerRecommendSortEntity.exposed + " noExpose=" + stickerRecommendSortEntity.noExpose);
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
                IStickerRecEmoticon[] iStickerRecEmoticonArr = new IStickerRecEmoticon[size];
                int i19 = 0;
                for (int i26 = 0; i26 < i3; i26++) {
                    int intValue = stickerRecommendSortEntity.clickedList.get(i26).intValue();
                    if (intValue < size && i19 < size) {
                        iStickerRecEmoticonArr[i19] = list.get(intValue);
                        i19++;
                    }
                }
                for (int i27 = 0; i27 < i16; i27++) {
                    int intValue2 = stickerRecommendSortEntity.noExposeList.get(i27).intValue();
                    if (intValue2 < size && i19 < size) {
                        iStickerRecEmoticonArr[i19] = list.get(intValue2);
                        i19++;
                    }
                }
                for (int i28 = 0; i28 < i17; i28++) {
                    int intValue3 = stickerRecommendSortEntity.exposedList.get(i28).intValue();
                    if (intValue3 < size && i19 < size) {
                        iStickerRecEmoticonArr[i19] = list.get(intValue3);
                        i19++;
                    }
                }
                return Arrays.asList(iStickerRecEmoticonArr);
            } catch (Throwable th5) {
                QLog.e("StickerRecManager", 1, "sortData:", th5);
            }
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
            ZipUtils.unZipFile(file, file3.getAbsolutePath() + str);
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
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = new a(str2, z16, str3);
        httpNetReq.mReqUrl = str;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = this.mDownloadFile.getAbsolutePath();
        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        try {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (AppInterface.class.isInstance(waitAppRuntime)) {
                ((IHttpEngineService) ((AppInterface) waitAppRuntime).getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
                if (QLog.isColorLevel()) {
                    QLog.i("StickerRecManager", 2, "start download words, url: " + str);
                }
            }
        } catch (Exception e16) {
            QLog.e("StickerRecManager", 1, "download follow words error", e16);
        }
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
                        if (QLog.isColorLevel()) {
                            QLog.i("StickerRecManager", 2, "FileUtils.writeObjectAbs throw an Exception. fileName=" + str + ", Exception=" + e.toString());
                        }
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

    private List<IStickerRecEmoticon> zplanEmoticonSort(List<IStickerRecEmoticon> list, String str) {
        boolean hasCustomDressUp = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(this.mApp.getCurrentUin()).hasCustomDressUp();
        ArrayList arrayList = new ArrayList(list);
        if (hasCustomDressUp) {
            if (cq.c()) {
                putZplanEmoticonToFirst(arrayList);
                cq.a();
            } else if (cq.d()) {
                if ("network".equals(str)) {
                    putZplanEmoticonToFirst(arrayList);
                    cq.a();
                } else {
                    int i3 = 0;
                    int i16 = 0;
                    while (true) {
                        if (i16 >= list.size()) {
                            break;
                        }
                        IStickerRecEmoticon iStickerRecEmoticon = list.get(i16);
                        if ((iStickerRecEmoticon instanceof StickerRecData) && ((StickerRecData) iStickerRecEmoticon).isZPlanData()) {
                            i3 = i16;
                            break;
                        }
                        i16++;
                    }
                    if (i3 > 4) {
                        IStickerRecEmoticon iStickerRecEmoticon2 = list.get(i3);
                        arrayList.remove(i3);
                        arrayList.add(4, iStickerRecEmoticon2);
                    }
                    cq.a();
                }
            } else if (cq.e()) {
                if ("network".equals(str)) {
                    putZplanEmoticonToFirst(arrayList);
                }
                cq.a();
            } else if (cq.b()) {
                cq.a();
            }
        } else if (cr.b()) {
            if ("network".equals(str)) {
                putZplanEmoticonToFirst(arrayList);
            }
            cr.a();
        } else if (cr.c()) {
            cr.a();
        }
        return arrayList;
    }

    public void addStickerRecLocalEmoticonChangeListener(d dVar) {
        if (dVar == null) {
            return;
        }
        if (this.mStickerRecLocalEmoticonChangeListeners == null) {
            this.mStickerRecLocalEmoticonChangeListeners = new ArrayList();
        }
        if (!this.mStickerRecLocalEmoticonChangeListeners.contains(dVar)) {
            this.mStickerRecLocalEmoticonChangeListeners.add(dVar);
        }
    }

    public boolean analyze(String str, p pVar) {
        if (pVar != null) {
            return analyze(str, pVar.f179555d, pVar.f179557e, false, true, pVar);
        }
        return false;
    }

    public boolean analyzeForScenesMode(final b bVar, final int i3, final String str) {
        if (!hasInit()) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecManager", 2, "can't analyzeForScenesMode, has not init");
            }
            return false;
        }
        if (bVar != null) {
            try {
                if (bVar.a() != null && !StringUtil.isEmpty(bVar.b())) {
                    final String b16 = bVar.b();
                    this.mDbHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (StickerRecManagerImpl.this.entityManager != null) {
                                StickerRecommendEntity stickerRecommendEntity = (StickerRecommendEntity) DBMethodProxy.find(StickerRecManagerImpl.this.entityManager, StickerRecommendEntity.class, "usrMessage=? AND recommendType==1", new String[]{b16});
                                if (stickerRecommendEntity == null) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("StickerRecManager", 2, "scene entity is null");
                                    }
                                } else if (QLog.isColorLevel()) {
                                    QLog.d("StickerRecManager", 2, "scene cache Time : " + (System.currentTimeMillis() - stickerRecommendEntity.cachedTime));
                                }
                                int convertAIOType = StickerRecManagerImpl.this.convertAIOType(i3);
                                if (stickerRecommendEntity != null && StickerRecManagerImpl.this.isCacheValid(stickerRecommendEntity)) {
                                    byte[] decode = Base64.decode(stickerRecommendEntity.recList, 0);
                                    StickerRecommendSortEntity stickerRecommendSortEntity = (StickerRecommendSortEntity) DBMethodProxy.find(StickerRecManagerImpl.this.entityManager, StickerRecommendSortEntity.class, "usrMessage=? AND recommendType==1", new String[]{b16});
                                    if (stickerRecommendSortEntity != null) {
                                        stickerRecommendSortEntity.convertToList();
                                    }
                                    StickerRecManagerImpl.this.handlePullPics(decode, b16, "cache", false, stickerRecommendSortEntity, 1, convertAIOType);
                                    return;
                                }
                                StickerRecManagerImpl.this.entityManager.delete(StickerRecommendEntity.class.getSimpleName(), "usrMessage=? AND recommendType==1", new String[]{b16});
                                StickerRecManagerImpl.this.entityManager.delete(StickerRecommendSortEntity.class.getSimpleName(), "usrMessage=? AND recommendType=1", new String[]{b16});
                                StickerRecManagerImpl stickerRecManagerImpl = StickerRecManagerImpl.this;
                                stickerRecManagerImpl.sendScenesPullPicsRequest(stickerRecManagerImpl.mApp.getCurrentUin(), 3, convertAIOType, str, bVar);
                            }
                        }
                    });
                    return true;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("StickerRecManager", 2, ThrowablesUtils.getStackTraceAsString(e16));
                    return true;
                }
                return true;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "analyzeForScenesMode data is empty");
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager
    public boolean analyzeFromQCircle(String str, int i3, String str2) {
        return analyze(str, i3, str2, false, false, null);
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager
    public boolean analyzeFromQzone(String str, int i3, String str2) {
        return analyze(str, i3, str2, true, false, null);
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager
    public void clearOverdueStickerCache() {
        if (this.entityManager == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "clearOverdueStickerCache");
        }
        this.mDbHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl.8
            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles = new File(h.f179915a).listFiles();
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
                    String[] strArr = {String.valueOf(System.currentTimeMillis() - 86400000)};
                    Iterator<? extends Entity> it = StickerRecManagerImpl.this.entityManager.query(StickerRecCacheEntity.class, StickerRecCacheEntity.class.getSimpleName(), false, "lastTime<?", strArr, "", "", "", "").iterator();
                    while (it.hasNext()) {
                        StickerRecCacheEntity stickerRecCacheEntity = (StickerRecCacheEntity) it.next();
                        if (QLog.isColorLevel()) {
                            QLog.d("StickerRecManager", 2, "Overdue cache:", "fileName=" + stickerRecCacheEntity.filePath + " md5=" + stickerRecCacheEntity.md5);
                        }
                        if (!TextUtils.isEmpty(stickerRecCacheEntity.filePath)) {
                            new File(stickerRecCacheEntity.filePath).delete();
                        }
                    }
                    StickerRecManagerImpl.this.entityManager.delete(StickerRecCacheEntity.class.getSimpleName(), "lastTime<?", strArr);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("StickerRecManager", 2, "clearOverdueStickerCache error", e16);
                    }
                }
            }
        });
    }

    public void collectReportData(List<IStickerRecEmoticon> list, String str, String str2, int i3) {
        if (list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (IStickerRecEmoticon iStickerRecEmoticon : list) {
                if (iStickerRecEmoticon != null) {
                    if (iStickerRecEmoticon.isExposed()) {
                        arrayList.add(iStickerRecEmoticon);
                    } else {
                        arrayList2.add(iStickerRecEmoticon);
                    }
                }
            }
            r rVar = new r();
            rVar.f179975b = str;
            rVar.f179976c = str2;
            rVar.f179977d = arrayList;
            rVar.f179978e = arrayList2;
            rVar.f179974a = i3;
            this.mStickerReportItems.add(rVar);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager
    public void deletePicCache() {
        File[] listFiles;
        File file = new File(h.f179915a);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager
    public synchronized String getCurrentText() {
        return this.mCurrentText;
    }

    public synchronized void handleDebugDataResponse(byte[] bArr, String str, int i3) {
        cacheResInDb(bArr, str, i3);
        handlePullPics(bArr, str, "network", false, null, i3, 1);
    }

    public synchronized void handleResponse(Intent intent, FromServiceMsg fromServiceMsg) {
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
                        handlePullPics(wupBuffer, stringExtra, "network", intent.getBooleanExtra("fromQzone", false), null, 0, intExtra);
                    } else if (CMD_SCENES_PULL_PICS.equals(serviceCmd)) {
                        cacheResInDb(wupBuffer, stringExtra, 1);
                        handlePullPics(wupBuffer, stringExtra, "network", intent.getBooleanExtra("fromQzone", false), null, 1, intExtra);
                    } else {
                        ((IIceBreakingMsg) QRoute.api(IIceBreakingMsg.class)).handleGetIceBreakHotPicResponse(this.mApp, wupBuffer, serviceCmd);
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

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager
    public synchronized boolean hasInit() {
        return this.hasInit;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0138 A[Catch: Exception -> 0x0163, TryCatch #1 {Exception -> 0x0163, blocks: (B:14:0x001d, B:16:0x0029, B:18:0x0039, B:20:0x003f, B:21:0x0058, B:25:0x0078, B:28:0x0085, B:30:0x0095, B:31:0x010e, B:33:0x0138, B:34:0x014d, B:36:0x009f, B:38:0x00ca, B:39:0x00ce, B:41:0x00d4, B:52:0x00e0, B:44:0x00e6, B:47:0x00ee, B:55:0x00f4, B:57:0x00fa, B:58:0x010c, B:59:0x0151, B:60:0x0159, B:61:0x015a, B:62:0x0162), top: B:13:0x001d }] */
    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void init() {
        if (hasInit()) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecManager", 2, "init has executed");
                return;
            }
            return;
        }
        long j3 = 0;
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                if (FileUtils.fileExists(this.mEncodedBloomFile.getAbsolutePath())) {
                    BloomFilter bloomFilter = (BloomFilter) readObjectAbsPath(this.mEncodedBloomFile.getAbsolutePath());
                    this.bloomFilter = bloomFilter;
                    if (bloomFilter != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("StickerRecManager", 2, "init bloomFilter, version : " + this.bloomFilter.version);
                        }
                        long lastTimeRemoveEmoticonPackage = getLastTimeRemoveEmoticonPackage(this.mApp.getApp(), this.mApp.getCurrentUin());
                        if (FileUtils.fileExists(this.mLocalWordsFile.getAbsolutePath()) && (lastTimeRemoveEmoticonPackage == 0 || System.currentTimeMillis() - lastTimeRemoveEmoticonPackage < 86400000)) {
                            HashSet<String> hashSet = (HashSet) readObjectAbsPath(this.mLocalWordsFile.getAbsolutePath());
                            this.mLocalKeywordsSet = hashSet;
                            if (hashSet == null) {
                                q.d(this.mLocalWordsFile.getAbsolutePath());
                            }
                            updateKeywordForCameraEmotion();
                            updateKeywordForFavEmotion();
                            this.maxMatchLength = getMaxMatchLength();
                            this.mCard = ((IProfileCardUtil) QRoute.api(IProfileCardUtil.class)).findFriendCardByUin(this.mApp);
                            this.hasInit = true;
                            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                            if (QLog.isColorLevel()) {
                                QLog.d("StickerRecManager", 2, "StickerRecManager init time cost : " + elapsedRealtime2);
                            }
                            reportInitCost(true, elapsedRealtime2);
                            return;
                        }
                        com.tencent.mobileqq.core.util.b.f(this.mApp.getApp(), this.mApp.getCurrentUin(), 0L);
                        HashSet<String> hashSet2 = new HashSet<>();
                        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) this.mApp.getRuntimeService(IEmoticonManagerService.class, "");
                        List<Emoticon> queryBigEmoticonsFromDB = iEmoticonManagerService.queryBigEmoticonsFromDB();
                        List<String> tabCache = iEmoticonManagerService.getTabCache();
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
                            q.d(this.mLocalWordsFile.getAbsolutePath());
                            writeObjectAbsPath(this.mLocalWordsFile.getAbsolutePath(), hashSet2);
                        }
                        this.mLocalKeywordsSet = hashSet2;
                        updateKeywordForCameraEmotion();
                        updateKeywordForFavEmotion();
                        this.maxMatchLength = getMaxMatchLength();
                        this.mCard = ((IProfileCardUtil) QRoute.api(IProfileCardUtil.class)).findFriendCardByUin(this.mApp);
                        this.hasInit = true;
                        long elapsedRealtime22 = SystemClock.elapsedRealtime() - elapsedRealtime;
                        if (QLog.isColorLevel()) {
                        }
                        reportInitCost(true, elapsedRealtime22);
                        return;
                    }
                    throw new IllegalStateException("words file read error");
                }
                throw new IllegalStateException("words file not exist");
            } catch (Exception e16) {
                e = e16;
                j3 = elapsedRealtime;
                this.hasInit = false;
                if (QLog.isColorLevel()) {
                    QLog.d("StickerRecManager", 2, ThrowablesUtils.getStackTraceAsString(e));
                    QLog.d("StickerRecManager", 2, "StickerRecManager error init time cost : " + (SystemClock.elapsedRealtime() - j3));
                }
                reportInitCost(false, SystemClock.elapsedRealtime() - j3);
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public void initDir() {
        try {
            File file = new File(getDataDir(), "words");
            this.mDownloadFile = new File(getDataDir(), WORDS_ZIP_FILE_NAME);
            this.mWordsFile = new File(file, WORDS_FILE_NAME);
            this.mEncodedBloomFile = new File(file, ENCODED_BLOOM_NAME);
            this.mLocalWordsFile = new File(file, LOCAL_WORDS_FILE_NAME);
        } catch (NullPointerException e16) {
            e16.printStackTrace();
        }
    }

    protected void initRecSwitch(Context context, String str) {
        try {
            this.emotionRecSettingSwitch = getEmotionRecSettingSwitch(context, str);
        } catch (NullPointerException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager
    public boolean isEmotionRecSettingOpen() {
        return this.emotionRecSettingSwitch;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager
    public boolean isForceUpdateCache() {
        return this.mForceUpdateCache;
    }

    public boolean isHandleKeyword(String str) {
        HashSet<String> hashSet;
        if (str != null && (hashSet = this.mLocalKeywordsSet) != null) {
            return hashSet.contains(str);
        }
        return false;
    }

    public Collection<String> loadKeywordForCameraEmotion() {
        HashSet hashSet = new HashSet();
        List<CameraEmotionData> emoticonDataList = ((ICameraEmotionRoamingDBManagerService) this.mApp.getRuntimeService(ICameraEmotionRoamingDBManagerService.class, "")).getEmoticonDataList();
        if (emoticonDataList != null) {
            for (CameraEmotionData cameraEmotionData : emoticonDataList) {
                if ("normal".equals(cameraEmotionData.RomaingType) && !TextUtils.isEmpty(cameraEmotionData.strContext)) {
                    hashSet.add(preProcessUsrTextUseLocalSearch(cameraEmotionData.strContext));
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "loadKeywordForCameraEmotion size: " + hashSet.size());
        }
        return hashSet;
    }

    public Collection<String> loadKeywordForFavEmotion() {
        Emoticon syncFindEmoticonById;
        HashSet hashSet = new HashSet();
        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) this.mApp.getRuntimeService(IEmoticonManagerService.class, "");
        List<CustomEmotionData> emoticonDataList = ((IFavroamingDBManagerService) this.mApp.getRuntimeService(IFavroamingDBManagerService.class, "")).getEmoticonDataList();
        if (emoticonDataList != null) {
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
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) appRuntime;
        this.mApp = baseQQAppInterface;
        this.entityManager = baseQQAppInterface.getEntityManagerFactory().createEntityManager();
        initRecSwitch(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
        initDir();
        List<d> list = this.mStickerRecLocalEmoticonChangeListeners;
        if (list != null) {
            list.clear();
        }
        addStickerRecLocalEmoticonChangeListener(new m(this.mApp));
        g gVar = new g(this.mApp);
        this.mCameraEmoticonHandleListener = gVar;
        addStickerRecLocalEmoticonChangeListener(gVar);
        k kVar = new k(this.mApp);
        this.mFavEmoticonHandleListener = kVar;
        addStickerRecLocalEmoticonChangeListener(kVar);
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101531");
        addStickerRecLocalEmoticonChangeListener(new x61.h(this.mApp));
    }

    public List<IStickerRecEmoticon> perkData(List<IStickerRecEmoticon> list, int i3, boolean z16, boolean z17) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    list.size();
                    ArrayList arrayList = new ArrayList();
                    for (IStickerRecEmoticon iStickerRecEmoticon : list) {
                        if (!(iStickerRecEmoticon instanceof StickerRecData) || ((StickerRecData) iStickerRecEmoticon).getFromType() != 3 || (z17 && !z16 && i3 != 4)) {
                            arrayList.add(iStickerRecEmoticon);
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

    public String preProcessUsrText(String str) {
        return com.tencent.mobileqq.text.TextUtils.cToe(StringUtil.toSemiAngleString(com.tencent.mobileqq.text.TextUtils.emoticonToTextWithoutSysEmotion(str)).toLowerCase());
    }

    public String preProcessUsrTextUseLocalSearch(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return com.tencent.mobileqq.text.TextUtils.cToe(StringUtil.toSemiAngleString(com.tencent.mobileqq.text.TextUtils.emoticonToTextWithoutSysEmotion(str)));
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager
    public void pullWords() {
        initDir();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d("StickerRecManager", 2, "start pull words");
                }
                Card findFriendCardByUin = ((IProfileCardUtil) QRoute.api(IProfileCardUtil.class)).findFriendCardByUin(StickerRecManagerImpl.this.mApp);
                byte b16 = 0;
                byte b17 = 255;
                if (findFriendCardByUin != null) {
                    short s16 = findFriendCardByUin.shGender;
                    if (s16 == 1) {
                        b16 = 1;
                    } else if (s16 != 0) {
                        b16 = 255;
                    }
                    b17 = b16;
                    b16 = findFriendCardByUin.age;
                }
                StickerRecManagerImpl stickerRecManagerImpl = StickerRecManagerImpl.this;
                stickerRecManagerImpl.sendPullWordsRequest(stickerRecManagerImpl.mApp.getCurrentUin(), 3, b17, b16);
            }
        }, 128, null, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager
    public void reportEvent(List<r> list, boolean z16, int i3, String str) {
        String str2;
        o oVar;
        if (list != null && list.size() != 0) {
            for (r rVar : list) {
                if (rVar != null) {
                    String str3 = rVar.f179975b;
                    List<? extends IStickerRecEmoticon> list2 = rVar.f179977d;
                    StringBuilder sb5 = new StringBuilder();
                    StringBuilder sb6 = new StringBuilder();
                    if (z16) {
                        if (i3 == 0) {
                            str2 = "c2c";
                        } else if (i3 == 1) {
                            str2 = VipFunCallConstants.KEY_GROUP;
                        } else if (i3 == 3000) {
                            str2 = "discuss";
                        } else if (i3 == 11000) {
                            str2 = "qzone";
                        } else {
                            str2 = "other";
                        }
                    } else {
                        str2 = "";
                    }
                    IStickerRecEmoticon iStickerRecEmoticon = null;
                    for (IStickerRecEmoticon iStickerRecEmoticon2 : list2) {
                        iStickerRecEmoticon2.endExposed(System.currentTimeMillis());
                        if (iStickerRecEmoticon2.getImgMd5() != null) {
                            String reportEventPrefix = iStickerRecEmoticon2.getReportEventPrefix();
                            if (!TextUtils.isEmpty(reportEventPrefix)) {
                                sb5.append(reportEventPrefix);
                            }
                            sb5.append(iStickerRecEmoticon2.getImgMd5());
                            sb5.append(";");
                            if (iStickerRecEmoticon2.getImgUrl() != null) {
                                sb6.append(iStickerRecEmoticon2.getImgUrl());
                                sb6.append(";");
                            }
                            if (iStickerRecEmoticon2.isClicked()) {
                                iStickerRecEmoticon = iStickerRecEmoticon2;
                            }
                            if (iStickerRecEmoticon2.exposedTime() != 0) {
                                n.d(true, str3, i3, str, iStickerRecEmoticon2);
                            }
                        }
                    }
                    String sb7 = sb5.toString();
                    String sb8 = sb6.toString();
                    long longValue = Long.valueOf(this.mApp.getCurrentAccountUin()).longValue();
                    if (rVar.f179974a == 1) {
                        com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.a aVar = new com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.a();
                        aVar.f179973i = "dc05550";
                        aVar.f179982l = str3;
                        aVar.f179980j = String.valueOf(longValue);
                        aVar.f179981k = str;
                        aVar.f179983m = str2;
                        oVar = aVar;
                    } else {
                        o oVar2 = new o();
                        oVar2.f179973i = "dc04577";
                        oVar2.f179962k = str3;
                        if (QLog.isColorLevel()) {
                            oVar2.f179962k = stringToUnicode(oVar2.f179962k);
                        }
                        oVar2.f179961j = String.valueOf(longValue);
                        oVar2.f179964m = str;
                        oVar2.f179963l = str2;
                        oVar = oVar2;
                    }
                    oVar.f179972h = this.mSessionId;
                    oVar.f179971g = rVar.f179976c;
                    oVar.f179965a = String.valueOf(AppSetting.f());
                    if (iStickerRecEmoticon != null) {
                        String imgMd5 = iStickerRecEmoticon.getImgMd5();
                        String reportEventPrefix2 = iStickerRecEmoticon.getReportEventPrefix();
                        if (!TextUtils.isEmpty(reportEventPrefix2)) {
                            imgMd5 = reportEventPrefix2 + imgMd5;
                        }
                        oVar.f179968d = imgMd5;
                        oVar.f179969e = iStickerRecEmoticon.getImgUrl();
                        n.d(false, str3, i3, str, iStickerRecEmoticon);
                    }
                    oVar.f179966b = sb7;
                    oVar.f179967c = sb8;
                    oVar.f179970f = "android";
                    JSONObject a16 = oVar.a();
                    NewIntent newIntent = new NewIntent(this.mApp.getApp(), com.tencent.mobileqq.activity.aio.stickerrecommended.q.class);
                    newIntent.putExtra("key_cmd", SSO_CMD_REPORT_NEW);
                    newIntent.putExtra(ProtoServlet.KEY_BODY, fh.b(a16.toString().getBytes()));
                    if (QLog.isColorLevel()) {
                        QLog.d("StickerRecManager", 2, "report StickerRecReport content:" + oVar.a().toString());
                    }
                    this.mApp.startServlet(newIntent);
                }
            }
        }
    }

    public synchronized void sendPullPicsRequest(String str, int i3, int i16, String str2, List<String> list) {
        String str3 = str + SystemClock.uptimeMillis();
        byte[] byteArray = getPullPicsRequestBody(str3, str, i3, i16, str2, list).toByteArray();
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
        allocate.putInt(byteArray.length + 4).put(byteArray);
        byte[] array = allocate.array();
        NewIntent newIntent = new NewIntent(this.mApp.getApp(), com.tencent.mobileqq.activity.aio.stickerrecommended.q.class);
        newIntent.putExtra(ProtoServlet.KEY_BODY, array);
        newIntent.putExtra("key_cmd", CMD_PULL_PICS);
        boolean z16 = false;
        String str4 = list.get(0);
        newIntent.putExtra(USER_KEYWORD_KEY, str4);
        if (i3 == 4) {
            z16 = true;
        }
        newIntent.putExtra("fromQzone", z16);
        newIntent.putExtra(REQUEST_AIO_TYPE, i16);
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "send pull pics args:sessionId = " + str3 + " uin=" + str + " termType=" + i3 + " aioType : " + i16 + " toUin : " + str2 + "  keyword: " + stringToUnicode(str4));
        }
        this.mApp.startServlet(newIntent);
    }

    public synchronized void sendPullWordsRequest(String str, int i3, int i16, int i17) {
        if (this.mApp == null) {
            return;
        }
        if (!StringUtil.isValideUin(str)) {
            QLog.e("StickerRecManager", 2, " fromUin is invalid!!");
            return;
        }
        PicSearchWordsSvr$ReqBody picSearchWordsSvr$ReqBody = new PicSearchWordsSvr$ReqBody();
        picSearchWordsSvr$ReqBody.setHasFlag(true);
        String str2 = str + SystemClock.uptimeMillis();
        String valueOf = String.valueOf(AppSetting.f());
        String c16 = com.tencent.mobileqq.cooperation.a.c(this.mApp.getApp());
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
        NewIntent newIntent = new NewIntent(this.mApp.getApp(), com.tencent.mobileqq.activity.aio.stickerrecommended.q.class);
        newIntent.putExtra(ProtoServlet.KEY_BODY, array);
        newIntent.putExtra("key_cmd", CMD_PULL_WORDS);
        this.mApp.startServlet(newIntent);
    }

    public synchronized void sendScenesPullPicsRequest(String str, int i3, int i16, String str2, b bVar) {
        boolean z16;
        if (bVar != null) {
            if (bVar.b() != null) {
                String str3 = str + SystemClock.uptimeMillis();
                byte[] byteArray = getPullPicsRequestBody(str3, str, i3, i16, str2, bVar.a()).toByteArray();
                ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
                allocate.putInt(byteArray.length + 4).put(byteArray);
                byte[] array = allocate.array();
                NewIntent newIntent = new NewIntent(this.mApp.getApp(), com.tencent.mobileqq.activity.aio.stickerrecommended.q.class);
                newIntent.putExtra(ProtoServlet.KEY_BODY, array);
                newIntent.putExtra("key_cmd", CMD_SCENES_PULL_PICS);
                String b16 = bVar.b();
                newIntent.putExtra(REQUEST_SCENES_ID_KEY, b16);
                newIntent.putExtra(USER_KEYWORD_KEY, b16);
                if (i3 == 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                newIntent.putExtra("fromQzone", z16);
                newIntent.putExtra(REQUEST_AIO_TYPE, i16);
                if (QLog.isColorLevel()) {
                    QLog.d("StickerRecManager", 2, "send pull scenes pics args:sessionId = " + str3 + " uin=" + str + " termType=" + i3 + " aioType : " + i16 + " toUin : " + str2 + "  scenesID: " + b16);
                }
                this.mApp.startServlet(newIntent);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager
    public synchronized void setCurrentText(String str) {
        this.mCurrentText = str;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager
    public void setForceUpdateCache(boolean z16) {
        this.mForceUpdateCache = z16;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager
    public void setImgUpdateListener(IStickerRecManager.ImgUpdateListener imgUpdateListener) {
        this.imgUpdateListener = imgUpdateListener;
    }

    public void showLocalEmo(String str, boolean z16, p pVar) {
        String preProcessUsrTextUseLocalSearch = preProcessUsrTextUseLocalSearch(str);
        handleLocalEmoticon(z16, preProcessUsrTextUseLocalSearch, pVar);
        if (this.imgUpdateListener != null && !this.stickerRecDataLocalList.isEmpty()) {
            this.imgUpdateListener.onImgUpdated(this.stickerRecDataLocalList, preProcessUsrTextUseLocalSearch, "999", 0, null);
        }
    }

    public void syncAddLocalEmoticonKeywords(Collection<String> collection) {
        if (collection != null && !collection.isEmpty() && this.mLocalKeywordsSet != null) {
            synchronized (StickerRecManagerImpl.class) {
                this.mLocalKeywordsSet.addAll(collection);
                writeObjectAbsPath(this.mLocalWordsFile.getAbsolutePath(), this.mLocalKeywordsSet);
            }
        }
    }

    public void unInit() {
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "unInit executed");
        }
        this.bloomFilter = null;
        this.maxMatchLength = 6;
        this.mCard = null;
        this.hasInit = false;
        this.mLocalKeywordsSet = null;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager
    public void updateEmotionRecSetting(boolean z16) {
        this.emotionRecSettingSwitch = z16;
        updateEmotionRecSettingSwitch(BaseApplication.getContext(), this.mApp.getCurrentUin(), z16);
    }

    public void updateKeywordForCameraEmotion() {
        g gVar = this.mCameraEmoticonHandleListener;
        if (gVar == null) {
            return;
        }
        gVar.e();
    }

    public void updateKeywordForFavEmotion() {
        k kVar = this.mFavEmoticonHandleListener;
        if (kVar == null) {
            return;
        }
        kVar.d();
    }

    public void updateSort(p pVar) {
        StickerRecommendSortEntity stickerRecommendSortEntity;
        ArrayList arrayList = new ArrayList(this.mStickerReportItems);
        if (pVar == null) {
            reportEvent(arrayList, false, 0, null);
        } else {
            reportEvent(arrayList, true, pVar.f179555d, pVar.f179557e);
        }
        for (r rVar : arrayList) {
            if (rVar != null) {
                String str = rVar.f179975b;
                int i3 = rVar.f179974a;
                if (i3 == 1) {
                    stickerRecommendSortEntity = (StickerRecommendSortEntity) DBMethodProxy.find(this.entityManager, StickerRecommendSortEntity.class, "usrMessage=? AND recommendType==1", new String[]{str});
                } else {
                    stickerRecommendSortEntity = (StickerRecommendSortEntity) DBMethodProxy.find(this.entityManager, StickerRecommendSortEntity.class, "usrMessage=? AND recommendType!=1", new String[]{str});
                }
                if (stickerRecommendSortEntity != null) {
                    stickerRecommendSortEntity.convertToList();
                    for (IStickerRecEmoticon iStickerRecEmoticon : rVar.f179977d) {
                        if (!iStickerRecEmoticon.isStickerRecFromLocal()) {
                            StickerRecData stickerRecData = (StickerRecData) iStickerRecEmoticon;
                            Integer valueOf = Integer.valueOf(stickerRecData.getIndex());
                            if (stickerRecData.isClicked()) {
                                if (stickerRecommendSortEntity.clickedList.contains(valueOf)) {
                                    stickerRecommendSortEntity.removeClicked(valueOf);
                                }
                                stickerRecommendSortEntity.addClicked(valueOf);
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
                    this.entityManager.update(stickerRecommendSortEntity);
                } else {
                    StickerRecommendSortEntity stickerRecommendSortEntity2 = new StickerRecommendSortEntity(str);
                    if (this.hasFilteredZPlanMeme) {
                        stickerRecommendSortEntity2.noExposeList.add(Integer.valueOf(this.zPlanIndex));
                        this.hasFilteredZPlanMeme = false;
                    }
                    for (IStickerRecEmoticon iStickerRecEmoticon2 : rVar.f179977d) {
                        if (!iStickerRecEmoticon2.isStickerRecFromLocal()) {
                            StickerRecData stickerRecData2 = (StickerRecData) iStickerRecEmoticon2;
                            if (stickerRecData2.isClicked()) {
                                stickerRecommendSortEntity2.addClicked(Integer.valueOf(stickerRecData2.getIndex()));
                            } else {
                                stickerRecommendSortEntity2.addExposed(Integer.valueOf(stickerRecData2.getIndex()));
                            }
                        }
                    }
                    for (IStickerRecEmoticon iStickerRecEmoticon3 : rVar.f179978e) {
                        if (!iStickerRecEmoticon3.isStickerRecFromLocal()) {
                            stickerRecommendSortEntity2.addNoExpose(Integer.valueOf(((StickerRecData) iStickerRecEmoticon3).getIndex()));
                        }
                    }
                    handleEntity(stickerRecommendSortEntity2);
                    stickerRecommendSortEntity2.convertToString();
                    if (QLog.isColorLevel()) {
                        QLog.i("StickerRecManager", 2, "updateSort new SortEntity clicked=" + stickerRecommendSortEntity2.clicked + " exposed=" + stickerRecommendSortEntity2.exposed + " noExpose=" + stickerRecommendSortEntity2.noExpose);
                    }
                    stickerRecommendSortEntity2.recommendType = i3;
                    this.entityManager.persistOrReplace(stickerRecommendSortEntity2);
                }
            }
        }
        this.mStickerReportItems.clear();
    }

    public void updateStickerLastTime(final List<StickerRecCacheEntity> list) {
        if (this.entityManager == null) {
            return;
        }
        this.mDbHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl.7
            @Override // java.lang.Runnable
            public void run() {
                for (StickerRecCacheEntity stickerRecCacheEntity : list) {
                    StickerRecCacheEntity stickerRecCacheEntity2 = (StickerRecCacheEntity) DBMethodProxy.find(StickerRecManagerImpl.this.entityManager, StickerRecCacheEntity.class, "md5=?", new String[]{stickerRecCacheEntity.md5});
                    if (stickerRecCacheEntity2 != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("StickerRecManager", 2, "old exist: fileName=" + stickerRecCacheEntity2.md5 + " lastTime=" + stickerRecCacheEntity2.lastTime);
                        }
                        stickerRecCacheEntity2.lastTime = stickerRecCacheEntity.lastTime;
                        StickerRecManagerImpl.this.entityManager.update(stickerRecCacheEntity2);
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("StickerRecManager", 2, "old not exist: fileName=" + stickerRecCacheEntity.md5 + " lastTime=" + stickerRecCacheEntity.lastTime);
                        }
                        StickerRecManagerImpl.this.entityManager.persistOrReplace(stickerRecCacheEntity);
                    }
                }
            }
        });
    }

    public boolean analyze(final String str, int i3, String str2, boolean z16, boolean z17, final p pVar) {
        String preProcessUsrText;
        if (!hasInit()) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecManager", 2, "can't analyze, has not init");
            }
            return false;
        }
        try {
            preProcessUsrText = preProcessUsrText(str);
        } catch (Exception e16) {
            QLog.w("StickerRecManager", 2, ThrowablesUtils.getStackTraceAsString(e16));
        }
        if (!TextUtils.isEmpty(preProcessUsrText) && preProcessUsrText.length() <= this.maxMatchLength) {
            boolean contains = this.bloomFilter.contains(preProcessUsrText);
            String stringToUnicode = stringToUnicode(preProcessUsrText);
            if (!contains) {
                if (QLog.isColorLevel()) {
                    QLog.d("StickerRecManager", 2, "word : " + stringToUnicode + " miss dict");
                }
                if (!z17 || this.imgUpdateListener == null) {
                    return false;
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.stickerrecommended.impl.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        StickerRecManagerImpl.this.lambda$analyze$0(str, pVar);
                    }
                }, 16, null, true);
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecManager", 2, "word : " + stringToUnicode + " in dict");
            }
            showEmoticon(str, i3, str2, z16, z17, pVar, preProcessUsrText);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecManager", 2, "userTxt over maxMatchLength or empty");
        }
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f179933d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f179934e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f179935f;

        a(String str, boolean z16, String str2) {
            this.f179933d = str;
            this.f179934e = z16;
            this.f179935f = str2;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            long j3;
            if (QLog.isColorLevel()) {
                QLog.i("StickerRecManager", 2, "onResp resultcode: " + netResp.mHttpCode + " threadid=" + Thread.currentThread().getId());
            }
            if (netResp.mHttpCode == 200) {
                StickerRecManagerImpl stickerRecManagerImpl = StickerRecManagerImpl.this;
                if (stickerRecManagerImpl.validateAndUnzip(stickerRecManagerImpl.mDownloadFile, StickerRecManagerImpl.this.mWordsFile, this.f179933d, this.f179934e)) {
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
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                String optString2 = optJSONArray.optString(i3);
                                if (!TextUtils.isEmpty(optString2)) {
                                    bloomFilter.add(optString2);
                                }
                            }
                            FileUtils.deleteFile(StickerRecManagerImpl.this.mEncodedBloomFile.getAbsolutePath());
                            StickerRecManagerImpl stickerRecManagerImpl2 = StickerRecManagerImpl.this;
                            stickerRecManagerImpl2.writeObjectAbsPath(stickerRecManagerImpl2.mEncodedBloomFile.getAbsolutePath(), bloomFilter);
                            FileUtils.deleteFile(StickerRecManagerImpl.this.mWordsFile.getAbsolutePath());
                            StickerRecManagerImpl.updateStickerRecVersion(StickerRecManagerImpl.this.mApp.getApp(), StickerRecManagerImpl.WORDS_VERSION_KEY, StickerRecManagerImpl.this.mApp.getCurrentUin(), this.f179935f);
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
                                QLog.d("StickerRecManager", 2, "build EncodeTable error !");
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

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        }
    }
}
