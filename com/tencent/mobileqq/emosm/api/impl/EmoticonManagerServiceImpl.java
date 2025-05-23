package com.tencent.mobileqq.emosm.api.impl;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.google.gson.stream.JsonReader;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.collection.QQConcurrentHashMap;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.im.msg.hummer.resv12.MarketFaceExtPb$ResvAttr;
import com.tencent.im.msg.hummer.resv12.MarketFaceExtPb$SupportSize;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.activity.aio.stickerrecommended.l;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.ao;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonKeywords;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.data.EmotionKeyword;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.PromotionEmoticonPkg;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmoticonManagerConstants;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.BasePanelView;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonTabNtUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.emoticonview.QueryTask;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.persistence.transaction.FindTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.RemoveTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.aw;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.v;
import com.tencent.pb.emosm.EmosmPb$STAIOFixRecommend;
import com.tencent.pb.emosm.EmosmPb$STRecommendTabInfo;
import com.tencent.pb.emosm.EmosmPb$SubCmd0x5RspBQRecommend;
import com.tencent.pb.emosm.EmosmPb$SupportSize;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager;
import com.tencent.qqnt.kernel.nativeinterface.CommonTabEmojiInfo;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class EmoticonManagerServiceImpl implements IEmoticonManagerService {
    private static final String KEY_EMOTICON_TAB_CACHE = "emoticon_tab_cache";
    public static final String TAG = "EmoticonManager";
    public static HashMap<Double, Integer> betterDisplaySize = new HashMap<>();
    public Handler dbThreadHandler;

    /* renamed from: em, reason: collision with root package name */
    public EntityManager f204149em;
    public com.tencent.cache.api.collection.a<String, Emoticon> emoticonCache;
    public Map<String, CopyOnWriteArrayList<EmotionKeyword>> emotionKeywordCache;
    public Handler fileThreadHandler;
    private SharedPreferences fixRecommendExposSp;
    public Map<String, Integer> fixRecommendExposeCount;
    public Map<String, Integer> hotWords;
    public com.tencent.cache.api.collection.a<String, List<Emoticon>> keywordEmoticonsCache;
    private Map<String, EmoticonKeywords> keywordReqTimeInfo;
    private String mCurrentAccountUin;
    private volatile boolean mHasFetchEmoticonPackages;
    private v mResConfig;
    public double mScreenInch;
    protected SVIPObserver mVipStatusObserver;
    public List<EmotionKeyword> needToDBEmotionKeyword;
    public List<RecentEmotion> needToDBRecentEmotion;
    public com.tencent.cache.api.collection.a<String, EmoticonPackage> pkgCache;
    public Map<String, CopyOnWriteArrayList<RecentEmotion>> recentEmotionData;
    public Map<String, Integer> recommendExposeCount;
    private SharedPreferences recommendExposeSp;
    public SparseArray<List<PromotionEmoticonPkg>> recommendPanelShowInfoMap;
    public SparseArray<EmosmPb$SubCmd0x5RspBQRecommend> recommendRspMap;
    public com.tencent.cache.api.collection.a<String, List<Emoticon>> subEmoticonsCache;
    public Handler uiHandler;

    @NonNull
    private final CopyOnWriteArrayList<CommonTabEmojiInfo> ntCommonTabEmojiInfoList = new CopyOnWriteArrayList<>();
    public List<String> tabCache = new CopyOnWriteArrayList();
    public List<String> kanDianTabCache = new CopyOnWriteArrayList();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements QueryTask.Query<Integer, List<CommonTabEmojiInfo>> {
        a() {
        }

        @Override // com.tencent.mobileqq.emoticonview.QueryTask.Query
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<CommonTabEmojiInfo> query(Integer num) {
            if (com.tencent.mobileqq.emosm.h.a()) {
                return EmoticonManagerServiceImpl.this.getNtCommonTabEmojiInfoList();
            }
            ArrayList arrayList = new ArrayList();
            Iterator<EmoticonPackage> it = EmoticonManagerServiceImpl.this.syncGetTabEmoticonPackages(num.intValue()).iterator();
            while (it.hasNext()) {
                arrayList.add(EmoticonTabNtUtils.INSTANCE.convertEmoticonPackageCommonEmojiInfo(it.next()));
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements QueryTask.Query<MarkFaceMessage, PicEmoticonInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MarkFaceMessage f204179a;

        b(MarkFaceMessage markFaceMessage) {
            this.f204179a = markFaceMessage;
        }

        @Override // com.tencent.mobileqq.emoticonview.QueryTask.Query
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PicEmoticonInfo query(MarkFaceMessage markFaceMessage) {
            return EmoticonManagerServiceImpl.this.syncGetEmoticonInfo(this.f204179a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class c implements QueryTask.Query<Pair<String, Integer>, EmoticonPackage> {
        c() {
        }

        @Override // com.tencent.mobileqq.emoticonview.QueryTask.Query
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EmoticonPackage query(Pair<String, Integer> pair) {
            return EmoticonManagerServiceImpl.this.syncFindTabEmoticonPackageById((String) pair.first, ((Integer) pair.second).intValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class d implements QueryCallback<PicEmoticonInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f204182a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ p f204183b;

        d(boolean z16, p pVar) {
            this.f204182a = z16;
            this.f204183b = pVar;
        }

        @Override // com.tencent.mobileqq.emoticonview.QueryCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void postQuery(PicEmoticonInfo picEmoticonInfo) {
            if (picEmoticonInfo != null && picEmoticonInfo.emoticon != null) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (this.f204182a) {
                    EmoticonOperateReport.reportNewSoundEvent(peekAppRuntime, "0X800A937", this.f204183b.f179555d, picEmoticonInfo.emoticon.epId);
                } else {
                    EmoticonOperateReport.reportNewSoundEvent(peekAppRuntime, "0X800A936", this.f204183b.f179555d, picEmoticonInfo.emoticon.epId);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class e extends SVIPObserver {
        e() {
        }

        @Override // com.tencent.mobileqq.app.SVIPObserver
        public void onVipStatusChanged() {
            if (QLog.isColorLevel()) {
                QLog.d(EmoticonManagerServiceImpl.TAG, 2, "mVipStatusObserver vip change");
            }
            super.onVipStatusChanged();
            EmoticonManagerServiceImpl.this.parseCloudKeywordsJson();
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class f implements QueryTask.Query<Pair<String, String>, Emoticon> {
        f() {
        }

        @Override // com.tencent.mobileqq.emoticonview.QueryTask.Query
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Emoticon query(Pair<String, String> pair) {
            return EmoticonManagerServiceImpl.this.syncFindEmoticonById((String) pair.first, (String) pair.second);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class g implements QueryTask.Query<Pair<String, Integer>, EmoticonPackage> {
        g() {
        }

        @Override // com.tencent.mobileqq.emoticonview.QueryTask.Query
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EmoticonPackage query(Pair<String, Integer> pair) {
            return EmoticonManagerServiceImpl.this.syncFindEmoticonPackageById((String) pair.first, ((Integer) pair.second).intValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class h implements QueryTask.Query<Integer, List<EmoticonPackage>> {
        h() {
        }

        @Override // com.tencent.mobileqq.emoticonview.QueryTask.Query
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<EmoticonPackage> query(Integer num) {
            return EmoticonManagerServiceImpl.this.syncGetTabEmoticonPackages(num.intValue());
        }
    }

    public EmoticonManagerServiceImpl() {
        Business business = Business.AIO;
        this.pkgCache = new com.tencent.cache.api.collection.a<>(business, "EmoticonPackage", 100);
        this.emoticonCache = new com.tencent.cache.api.collection.a<>(business, "Emoticon", 400);
        this.subEmoticonsCache = new com.tencent.cache.api.collection.a<>(business, "subEmoticon", 50);
        this.keywordEmoticonsCache = new com.tencent.cache.api.collection.a<>(business, "keywordEmoticons", 50);
        this.hotWords = new HashMap();
        this.needToDBEmotionKeyword = new CopyOnWriteArrayList();
        this.keywordReqTimeInfo = new ConcurrentHashMap(40);
        this.recommendRspMap = new SparseArray<>();
        this.recommendExposeCount = new HashMap();
        this.fixRecommendExposeCount = new HashMap();
        this.recommendPanelShowInfoMap = new SparseArray<>();
        this.needToDBRecentEmotion = new CopyOnWriteArrayList();
        this.recentEmotionData = new QQConcurrentHashMap(business, "RecentEmotion");
        this.mScreenInch = 0.0d;
        this.mVipStatusObserver = new e();
    }

    private void addCommonTabEmojiInfoCache(CommonTabEmojiInfo commonTabEmojiInfo) {
        if (commonTabEmojiInfo == null) {
            return;
        }
        if (!EmoticonTabNtUtils.INSTANCE.isMarketFace(commonTabEmojiInfo)) {
            this.ntCommonTabEmojiInfoList.add(commonTabEmojiInfo);
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 < this.ntCommonTabEmojiInfoList.size()) {
                if (EmoticonTabNtUtils.INSTANCE.isMarketFace(this.ntCommonTabEmojiInfoList.get(i3))) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 >= 0 && i3 < this.ntCommonTabEmojiInfoList.size()) {
            this.ntCommonTabEmojiInfoList.add(i3, commonTabEmojiInfo);
        } else {
            this.ntCommonTabEmojiInfoList.add(commonTabEmojiInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEntityToTransaction(List<BaseTransaction> list, Entity entity) {
        if (entity.getStatus() == 1000) {
            list.add(new PersistOrReplaceTransaction(entity));
        } else if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
            list.add(new UpdateTransaction(entity));
        }
    }

    private boolean checkLocalEmoticonPackage(EmoticonPackage emoticonPackage, EmoticonPackage emoticonPackage2) {
        if (emoticonPackage2 != null && ((emoticonPackage2.valid != emoticonPackage.valid || emoticonPackage2.wordingId != emoticonPackage.wordingId || emoticonPackage2.expiretime != emoticonPackage.expiretime || emoticonPackage2.jobType != emoticonPackage.jobType || emoticonPackage.aio || emoticonPackage.kandian) && !TextUtils.isEmpty(emoticonPackage2.name))) {
            return true;
        }
        return false;
    }

    private void clearFixRecommendExposeNum() {
        QLog.d(TAG, 1, "clearFixRecommendExposeNum");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d(TAG, 1, "clearFixRecommendExposeNum error, app is null!");
            return;
        }
        peekAppRuntime.getApplication().getSharedPreferences(EmoticonManagerConstants.RECOMMEND_FIX_EXPOSE_COUNT_SP_FILE_ + peekAppRuntime.getCurrentAccountUin(), 0).edit().clear().apply();
        this.fixRecommendExposeCount.clear();
    }

    private void clearNotFixRecommendExposeNum() {
        QLog.d(TAG, 1, "clearNotFixRecommendExposeNum");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d(TAG, 1, "clearNotFixRecommendExposeNum error, app is null!");
            return;
        }
        peekAppRuntime.getApplication().getSharedPreferences(EmoticonManagerConstants.RECOMMEND_EXPOSE_COUNT_SP_FILE_ + peekAppRuntime.getCurrentAccountUin(), 0).edit().clear().apply();
        this.recommendExposeCount.clear();
    }

    private double fetchScreenInch() {
        double d16 = this.mScreenInch;
        double d17 = 0.0d;
        if (d16 != 0.0d) {
            return d16;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) BaseApplication.getContext().getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        if (displayMetrics.xdpi != 0.0f && displayMetrics.ydpi != 0.0f) {
            d17 = Math.round(Math.sqrt(Math.pow(displayMetrics.widthPixels / r1, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d)) * 100.0d) / 100.0d;
        }
        if (d17 >= 4.6d && displayMetrics.widthPixels >= 720 && displayMetrics.heightPixels >= 1280) {
            this.mScreenInch = 4.7d;
        } else {
            this.mScreenInch = -1.0d;
        }
        QLog.d("screenInch", 1, "screen inches-> screenInch: " + d17 + ", formatInch: " + this.mScreenInch + ", widthPixels: " + displayMetrics.widthPixels + " ,heightPixels: " + displayMetrics.heightPixels + " , xdpi: " + displayMetrics.xdpi + " , ydpi: " + displayMetrics.ydpi + ", densityDpi: " + displayMetrics.densityDpi + " , density: " + displayMetrics.density);
        return this.mScreenInch;
    }

    private CopyOnWriteArrayList<EmotionKeyword> getEmotionKeywordData(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.emotionKeywordCache.containsKey(str)) {
            return this.emotionKeywordCache.get(str);
        }
        List<? extends Entity> query = this.f204149em.query(EmotionKeyword.class, false, "keyword=?", new String[]{str}, null, null, null, null);
        if (query == null) {
            return null;
        }
        CopyOnWriteArrayList<EmotionKeyword> copyOnWriteArrayList = new CopyOnWriteArrayList<>(query);
        this.emotionKeywordCache.put(str, copyOnWriteArrayList);
        return copyOnWriteArrayList;
    }

    private List<EmotionKeyword> getEmotionKeywordDataFromCache(String str) {
        if (TextUtils.isEmpty(str) || !this.emotionKeywordCache.containsKey(str)) {
            return null;
        }
        return new ArrayList(this.emotionKeywordCache.get(str));
    }

    @NonNull
    private SparseArray<PromotionEmoticonPkg> getFixRecommendTabList(int i3) {
        EmosmPb$SubCmd0x5RspBQRecommend emosmPb$SubCmd0x5RspBQRecommend;
        if (i3 != 0) {
            if (i3 == 1 && this.recommendRspMap.indexOfKey(1) >= 0) {
                emosmPb$SubCmd0x5RspBQRecommend = this.recommendRspMap.get(i3);
            }
            emosmPb$SubCmd0x5RspBQRecommend = null;
        } else {
            if (this.recommendRspMap.indexOfKey(0) >= 0) {
                emosmPb$SubCmd0x5RspBQRecommend = this.recommendRspMap.get(i3);
            }
            emosmPb$SubCmd0x5RspBQRecommend = null;
        }
        if (emosmPb$SubCmd0x5RspBQRecommend == null) {
            return new SparseArray<>();
        }
        List<EmoticonPackage> syncGetTabEmoticonPackages = syncGetTabEmoticonPackages(i3);
        List<EmosmPb$STAIOFixRecommend> list = emosmPb$SubCmd0x5RspBQRecommend.st_fixinfo.get();
        SparseArray<PromotionEmoticonPkg> sparseArray = new SparseArray<>();
        if (list != null && list.size() > 0) {
            for (int i16 = 0; i16 < list.size(); i16++) {
                EmosmPb$STAIOFixRecommend emosmPb$STAIOFixRecommend = list.get(i16);
                int i17 = emosmPb$STAIOFixRecommend.u32_pos.get();
                List<EmosmPb$STRecommendTabInfo> list2 = emosmPb$STAIOFixRecommend.rpt_list.get();
                PromotionEmoticonPkg fixRecommendTadInfo = getFixRecommendTadInfo(list2, syncGetTabEmoticonPackages);
                if (fixRecommendTadInfo != null) {
                    sparseArray.put(i17 - 1, fixRecommendTadInfo);
                } else {
                    clearFixRecommendExposeNum();
                    PromotionEmoticonPkg fixRecommendTadInfo2 = getFixRecommendTadInfo(list2, syncGetTabEmoticonPackages);
                    if (fixRecommendTadInfo2 != null) {
                        sparseArray.put(i17 - 1, fixRecommendTadInfo2);
                    } else {
                        QLog.e(TAG, 1, "getFixRecommendTabList : fix emotion error, index = " + i17);
                    }
                }
            }
        }
        return sparseArray;
    }

    private PromotionEmoticonPkg getFixRecommendTadInfo(List<EmosmPb$STRecommendTabInfo> list, List<EmoticonPackage> list2) {
        if (list != null && list.size() >= 1) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                PromotionEmoticonPkg recommendPkg = getRecommendPkg(list.get(i3), list2, true);
                if (recommendPkg != null) {
                    return recommendPkg;
                }
            }
        }
        return null;
    }

    @NonNull
    private List<PromotionEmoticonPkg> getKanDianRecommendList() {
        EmosmPb$SubCmd0x5RspBQRecommend emosmPb$SubCmd0x5RspBQRecommend;
        if (this.recommendRspMap.indexOfKey(1) >= 0) {
            emosmPb$SubCmd0x5RspBQRecommend = this.recommendRspMap.get(1);
        } else {
            emosmPb$SubCmd0x5RspBQRecommend = null;
        }
        if (emosmPb$SubCmd0x5RspBQRecommend == null) {
            return new ArrayList();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getNotFixRecommendList");
        }
        ArrayList arrayList = new ArrayList();
        List<EmoticonPackage> syncGetTabEmoticonPackages = syncGetTabEmoticonPackages(1);
        List<EmosmPb$STRecommendTabInfo> list = emosmPb$SubCmd0x5RspBQRecommend.st_new_tab_info.get();
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                PromotionEmoticonPkg recommendPkg = getRecommendPkg(list.get(i3), syncGetTabEmoticonPackages, false, 1);
                if (recommendPkg != null) {
                    arrayList.add(recommendPkg);
                }
            }
        }
        return arrayList;
    }

    private String getKeyEmoticonTabCacheKey() {
        return KEY_EMOTICON_TAB_CACHE + this.mCurrentAccountUin;
    }

    @NonNull
    private List<PromotionEmoticonPkg> getNotFixRecommendList(int i3, int i16) {
        List<PromotionEmoticonPkg> notFixRecommendListWithExposeNum = getNotFixRecommendListWithExposeNum(i3, i16);
        if (notFixRecommendListWithExposeNum.size() < 1) {
            clearNotFixRecommendExposeNum();
            notFixRecommendListWithExposeNum = getNotFixRecommendListWithExposeNum(i3, i16);
            if (notFixRecommendListWithExposeNum.size() < 1) {
                QLog.e(TAG, 1, "getNotFixRecommendList error data = null");
            }
        }
        return notFixRecommendListWithExposeNum;
    }

    @NonNull
    private List<PromotionEmoticonPkg> getNotFixRecommendListWithExposeNum(int i3, int i16) {
        EmosmPb$SubCmd0x5RspBQRecommend emosmPb$SubCmd0x5RspBQRecommend;
        if (i16 != 0) {
            if (i16 == 1 && this.recommendRspMap.indexOfKey(1) >= 0) {
                emosmPb$SubCmd0x5RspBQRecommend = this.recommendRspMap.get(i16);
            }
            emosmPb$SubCmd0x5RspBQRecommend = null;
        } else {
            if (this.recommendRspMap.indexOfKey(0) >= 0) {
                emosmPb$SubCmd0x5RspBQRecommend = this.recommendRspMap.get(i16);
            }
            emosmPb$SubCmd0x5RspBQRecommend = null;
        }
        if (emosmPb$SubCmd0x5RspBQRecommend == null) {
            return new ArrayList();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getNotFixRecommendList");
        }
        ArrayList arrayList = new ArrayList();
        List<EmoticonPackage> syncGetTabEmoticonPackages = syncGetTabEmoticonPackages(i16);
        List<EmosmPb$STRecommendTabInfo> list = emosmPb$SubCmd0x5RspBQRecommend.st_new_tab_info.get();
        if (list != null && list.size() > 0) {
            int i17 = 0;
            for (int i18 = 0; i18 < list.size() && i17 < EmoticonManagerConstants.RECOMMEND_SHOW_NUM_MAX - i3; i18++) {
                PromotionEmoticonPkg recommendPkg = getRecommendPkg(list.get(i18), syncGetTabEmoticonPackages, false);
                if (recommendPkg != null) {
                    arrayList.add(recommendPkg);
                    i17++;
                }
            }
        }
        return arrayList;
    }

    @NotNull
    private List<PromotionEmoticonPkg> getPromotionEmoticonPkgs(int i3, EmosmPb$SubCmd0x5RspBQRecommend emosmPb$SubCmd0x5RspBQRecommend) {
        ArrayList arrayList = new ArrayList();
        if (emosmPb$SubCmd0x5RspBQRecommend != null) {
            if (i3 == 1) {
                return getKanDianRecommendList();
            }
            int i16 = emosmPb$SubCmd0x5RspBQRecommend.int32_show_num.get();
            if (i16 > 0) {
                EmoticonManagerConstants.RECOMMEND_SHOW_NUM_MAX = i16;
            }
            int i17 = emosmPb$SubCmd0x5RspBQRecommend.int32_exposure_num.get();
            if (i17 > 0) {
                EmoticonManagerConstants.RECOMMEND_EXPOSE_MAX = i17;
            }
            SparseArray<PromotionEmoticonPkg> fixRecommendTabList = getFixRecommendTabList(i3);
            int size = fixRecommendTabList.size();
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "getProEmoticonPkgs showNum = " + i16 + ",fixRecommendSize = " + size);
            }
            List<PromotionEmoticonPkg> notFixRecommendList = getNotFixRecommendList(size, i3);
            if (size > 0) {
                for (int i18 = 0; i18 < size; i18++) {
                    PromotionEmoticonPkg valueAt = fixRecommendTabList.valueAt(i18);
                    int keyAt = fixRecommendTabList.keyAt(i18);
                    if (keyAt < 0) {
                        keyAt = 0;
                    }
                    if (keyAt > notFixRecommendList.size()) {
                        notFixRecommendList.add(notFixRecommendList.size(), valueAt);
                    } else {
                        notFixRecommendList.add(keyAt, valueAt);
                    }
                }
            }
            QLog.d(TAG, 2, "getProEmoticonPkgs data size = " + notFixRecommendList.size());
            return notFixRecommendList;
        }
        QLog.d(TAG, 1, "getProEmoticonPkgs recommendRsp == NULL");
        if (i3 == 0) {
            writeRecommendInfoFromFileToCache();
            return arrayList;
        }
        if (i3 == 1) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (!(peekAppRuntime instanceof BaseQQAppInterface)) {
                QLog.e(TAG, 1, "saveKandianRecommendEmoticon error, app is null!");
                return arrayList;
            }
            EmoticonHandler emoticonHandler = (EmoticonHandler) ((BaseQQAppInterface) peekAppRuntime).getBusinessHandler(EmoticonHandler.F);
            if (emoticonHandler != null) {
                emoticonHandler.k();
                return arrayList;
            }
            return arrayList;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CopyOnWriteArrayList<RecentEmotion> getRecentEmotionData(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.recentEmotionData.containsKey(str)) {
            return this.recentEmotionData.get(str);
        }
        List<? extends Entity> query = this.f204149em.query(RecentEmotion.class, false, "keyword=?", new String[]{str}, null, null, null, null);
        if (query == null) {
            return null;
        }
        CopyOnWriteArrayList<RecentEmotion> copyOnWriteArrayList = new CopyOnWriteArrayList<>(query);
        this.recentEmotionData.put(str, copyOnWriteArrayList);
        return copyOnWriteArrayList;
    }

    private CopyOnWriteArrayList<RecentEmotion> getRecentEmotionDataFromCache(String str) {
        if (TextUtils.isEmpty(str) || !this.recentEmotionData.containsKey(str)) {
            return null;
        }
        return this.recentEmotionData.get(str);
    }

    private int getRecommendExposeNum(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (z16) {
            if (this.fixRecommendExposeCount.containsKey(str)) {
                return this.fixRecommendExposeCount.get(str).intValue();
            }
            return this.recommendExposeSp.getInt(str, 0);
        }
        if (this.recommendExposeCount.containsKey(str)) {
            return this.recommendExposeCount.get(str).intValue();
        }
        return this.recommendExposeSp.getInt(str, 0);
    }

    private PromotionEmoticonPkg getRecommendPkg(EmosmPb$STRecommendTabInfo emosmPb$STRecommendTabInfo, List<EmoticonPackage> list, boolean z16) {
        return getRecommendPkg(emosmPb$STRecommendTabInfo, list, z16, 0);
    }

    private void initTabCacheFromMMKV() {
        String[] split;
        long currentTimeMillis = System.currentTimeMillis();
        String decodeString = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").decodeString(getKeyEmoticonTabCacheKey(), null);
        if (!TextUtils.isEmpty(decodeString) && (split = decodeString.split("\\|")) != null && split.length >= 1) {
            try {
                ArrayList arrayList = new ArrayList();
                for (String str : split) {
                    String[] split2 = str.split("-");
                    if (split2.length >= 3) {
                        CommonTabEmojiInfo commonTabEmojiInfo = new CommonTabEmojiInfo();
                        commonTabEmojiInfo.bottomEmojitabType = Integer.parseInt(split2[0]);
                        commonTabEmojiInfo.epId = Integer.parseInt(split2[1]);
                        commonTabEmojiInfo.isHide = "1".equals(split2[2]);
                        if (commonTabEmojiInfo.bottomEmojitabType == 6) {
                            commonTabEmojiInfo.tabName = EmoticonTabNtUtils.INSTANCE.getDefaultOfficialEmojiTabName(commonTabEmojiInfo.epId);
                        }
                        arrayList.add(commonTabEmojiInfo);
                    }
                }
                updateNtCommonTabEmojiInfoList(arrayList, false);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "initTabCacheFromMMKV end, ntCommonTabEmojiInfoList.size:", Integer.valueOf(this.ntCommonTabEmojiInfoList.size()), ", costTime:" + (System.currentTimeMillis() - currentTimeMillis));
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "initTabCacheFromMMKV error. stack=", th5);
            }
        }
    }

    private void initTabs() {
        EmoticonPackage syncFindEmoticonPackageById;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initTabs begins");
        }
        Iterator<CommonTabEmojiInfo> it = this.ntCommonTabEmojiInfoList.iterator();
        while (it.hasNext()) {
            CommonTabEmojiInfo next = it.next();
            if (TextUtils.isEmpty(next.tabName) && EmoticonTabNtUtils.INSTANCE.isMarketFace(next) && (syncFindEmoticonPackageById = syncFindEmoticonPackageById(String.valueOf(next.epId))) != null) {
                next.tabName = syncFindEmoticonPackageById.name;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = (ArrayList) this.f204149em.query(EmoticonTab.class, false, null, null, null, null, null, null);
        this.tabCache.clear();
        this.kanDianTabCache.clear();
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                EmoticonTab emoticonTab = (EmoticonTab) it5.next();
                if (emoticonTab != null) {
                    if (emoticonTab.aioHave) {
                        this.tabCache.add(emoticonTab.epId);
                    }
                    if (emoticonTab.kandianHave) {
                        this.kanDianTabCache.add(emoticonTab.epId);
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initTabs ends, tabCache.size:" + this.tabCache.size() + ", kanDianCache.size = " + this.kanDianTabCache.size() + ",time:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        preloadOtherEmotionData();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (BasePanelView.needRequestRecommendData(peekAppRuntime)) {
            EmotionUtils.d(new QQEmoticonMainPanelApp(peekAppRuntime), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertOrUpdateEmoticonTab(ArrayList<BaseTransaction> arrayList, String str, boolean z16, boolean z17) {
        EmoticonTab emoticonTab = (EmoticonTab) this.f204149em.doFindOperateByTransaction(new FindTransaction((Class<? extends Entity>) EmoticonTab.class, str));
        if (emoticonTab != null) {
            if (z16) {
                emoticonTab.aioHave = true;
            }
            if (z17) {
                emoticonTab.kandianHave = true;
            }
        } else {
            emoticonTab = new EmoticonTab();
            emoticonTab.setStatus(1000);
            emoticonTab.epId = str;
            emoticonTab.aioHave = z16;
            emoticonTab.kandianHave = z17;
        }
        addEntityToTransaction(arrayList, emoticonTab);
    }

    private boolean isEmoticonMagic(EmoticonPackage emoticonPackage) {
        int i3;
        if (emoticonPackage != null && ((i3 = emoticonPackage.jobType) == 5 || i3 == 3)) {
            return true;
        }
        return false;
    }

    private boolean isKeywordEmotionValid(String str) {
        EmoticonPackage syncFindEmoticonPackageById;
        if (TextUtils.isEmpty(str) || (syncFindEmoticonPackageById = syncFindEmoticonPackageById(str)) == null) {
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof BaseQQAppInterface)) {
            QLog.e(TAG, 1, "isKeywordEmotionValid error, app is null!");
            return false;
        }
        int currentUserVipType = ((ISVIPHandler) ((BaseQQAppInterface) peekAppRuntime).getBusinessHandler(((ISVIPHandlerProxy) QRoute.api(ISVIPHandlerProxy.class)).getImplClassName())).getCurrentUserVipType();
        int i3 = syncFindEmoticonPackageById.mobileFeetype;
        if (i3 == 1) {
            return true;
        }
        if (i3 == 4) {
            if (currentUserVipType != 1 && currentUserVipType != 3) {
                return false;
            }
            return true;
        }
        if (i3 == 5) {
            if (currentUserVipType != 3) {
                return false;
            }
            return true;
        }
        QLog.d(TAG, 1, "isKeywordEmotionValid isActivity or other epId = " + str);
        return false;
    }

    private boolean isRecommendRedpointEffective(int i3) {
        EmosmPb$SubCmd0x5RspBQRecommend emosmPb$SubCmd0x5RspBQRecommend;
        boolean z16;
        if (i3 != 0) {
            if (i3 == 1 && this.recommendRspMap.indexOfKey(1) >= 0) {
                emosmPb$SubCmd0x5RspBQRecommend = this.recommendRspMap.get(i3);
            }
            emosmPb$SubCmd0x5RspBQRecommend = null;
        } else {
            if (this.recommendRspMap.indexOfKey(0) >= 0) {
                emosmPb$SubCmd0x5RspBQRecommend = this.recommendRspMap.get(i3);
            }
            emosmPb$SubCmd0x5RspBQRecommend = null;
        }
        if (emosmPb$SubCmd0x5RspBQRecommend == null) {
            QLog.d(TAG, 1, "isRecommendRedpointEffective recommendRsp is null");
            writeRecommendInfoFromFileToCache();
            return false;
        }
        if (emosmPb$SubCmd0x5RspBQRecommend.int32_red_point_flag.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "isRecommendRedpointEffective is not white num");
            }
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d(TAG, 1, "isRecommendRedpointEffective error, app is null!");
            return false;
        }
        if (System.currentTimeMillis() - peekAppRuntime.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getLong("recommendRedpointStartTime", 0L) > emosmPb$SubCmd0x5RspBQRecommend.int32_light_out_interval.get() * 1000) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "isRecommendRedpointEffective redpoint is overtime");
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "isRecommendRedpointEffective show redpoint");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0() {
        initTabs();
        syncGetTabEmoticonPackages();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateKeywordReqTimeToDB$1(EmoticonKeywords emoticonKeywords) {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        addEntityToTransaction(arrayList, emoticonKeywords);
        if (!this.f204149em.doMultiDBOperateByTransaction(arrayList)) {
            QLog.w(TAG, 1, "updateKeywordReqTimeToDB, fail");
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveKeywordReqTimeToDB cost : " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private void preloadOtherEmotionData() {
        writeRecommendInfoFromFileToCache();
        parseCloudKeywordsJson();
    }

    private void pushFixRecommendExposeInfoToSP() {
        int intValue;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "pushNotFixRecommendExposeInfoToSP");
        }
        SharedPreferences.Editor edit = this.fixRecommendExposSp.edit();
        for (Map.Entry<String, Integer> entry : this.fixRecommendExposeCount.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key) && (intValue = entry.getValue().intValue()) > 0) {
                edit.putInt(key, intValue);
            }
        }
        edit.apply();
    }

    private void pushNotFixRecommendExposeInfoToSP() {
        int intValue;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "pushNotFixRecommendExposeInfoToSP");
        }
        SharedPreferences.Editor edit = this.recommendExposeSp.edit();
        for (Map.Entry<String, Integer> entry : this.recommendExposeCount.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key) && (intValue = entry.getValue().intValue()) > 0) {
                edit.putInt(key, intValue);
            }
        }
        edit.apply();
    }

    private ArrayList<Emoticon> queryEmoticonsByKeyWordFromDB(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<Emoticon> arrayList = (ArrayList) this.f204149em.query(Emoticon.class, false, "name=? and jobType= ?", new String[]{str, "0"}, null, null, null, null);
        if (arrayList != null) {
            synchronized (this.keywordEmoticonsCache) {
                this.keywordEmoticonsCache.f(str, arrayList);
                Iterator<Emoticon> it = arrayList.iterator();
                while (it.hasNext()) {
                    Emoticon next = it.next();
                    this.emoticonCache.f(next.getMapKey(), next);
                }
            }
            return arrayList;
        }
        QLog.e(TAG, 1, "queryEmoticonsByKeyWordFromDB data is null , keyWord = " + str);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, " queryEmoticonsByKeyWordFromDB keywordEmoticonsCache.size:" + this.keywordEmoticonsCache.h() + ",keyWord:" + str);
        }
        return null;
    }

    private ArrayList<Emoticon> queryEmoticonsByPackageIdFromDB(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<Emoticon> arrayList = (ArrayList) this.f204149em.query(Emoticon.class, false, "epId=?", new String[]{str}, null, null, null, null);
        synchronized (this.subEmoticonsCache) {
            if (arrayList != null) {
                this.subEmoticonsCache.f(str, arrayList);
                Iterator<Emoticon> it = arrayList.iterator();
                while (it.hasNext()) {
                    Emoticon next = it.next();
                    this.emoticonCache.f(next.getMapKey(), next);
                }
            } else {
                QLog.e(TAG, 1, "queryEmoticonsByPackageIdFromDB data is null , epId = " + str);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, " queryEmoticonsByPackageIdFromDB subEmoticonsCache.size:" + this.subEmoticonsCache.h() + ",epId:" + str);
        }
        return arrayList;
    }

    private void removeKeywordEmoticonCache(Emoticon emoticon) {
        List<Emoticon> e16 = this.keywordEmoticonsCache.e(emoticon.name);
        if (e16 != null && e16.contains(emoticon)) {
            synchronized (this.keywordEmoticonsCache) {
                e16.remove(emoticon);
                this.keywordEmoticonsCache.f(emoticon.name, e16);
            }
        }
    }

    private void runInCurrentThread(Runnable runnable, int i3) {
        if (runnable != null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                runnable.run();
            } else {
                ThreadManagerV2.post(runnable, i3, null, true);
            }
        }
    }

    private void saveRecommendEpInfoFromCacheToFile(final int i3) {
        final EmosmPb$SubCmd0x5RspBQRecommend emosmPb$SubCmd0x5RspBQRecommend;
        if (i3 != 0) {
            if (i3 == 1 && this.recommendRspMap.indexOfKey(1) >= 0) {
                emosmPb$SubCmd0x5RspBQRecommend = this.recommendRspMap.get(i3);
            }
            emosmPb$SubCmd0x5RspBQRecommend = null;
        } else {
            if (this.recommendRspMap.indexOfKey(0) >= 0) {
                emosmPb$SubCmd0x5RspBQRecommend = this.recommendRspMap.get(i3);
            }
            emosmPb$SubCmd0x5RspBQRecommend = null;
        }
        if (emosmPb$SubCmd0x5RspBQRecommend == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveRecommendEpInfoToFile businessType = " + i3);
        }
        Handler handler = this.fileThreadHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.25
                @Override // java.lang.Runnable
                public void run() {
                    FileUtils.pushData2File(new File(BaseApplication.getContext().getFilesDir(), "recommemd_emotion_file__" + i3 + EmoticonManagerServiceImpl.this.mCurrentAccountUin).getAbsolutePath(), emosmPb$SubCmd0x5RspBQRecommend.toByteArray(), false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveTabCacheToMMKV() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        Iterator<CommonTabEmojiInfo> it = this.ntCommonTabEmojiInfoList.iterator();
        while (it.hasNext()) {
            CommonTabEmojiInfo next = it.next();
            sb5.append(next.bottomEmojitabType);
            sb5.append("-");
            sb5.append(next.epId);
            sb5.append("-");
            if (next.isHide) {
                str = "1";
            } else {
                str = "0";
            }
            sb5.append(str);
            sb5.append("|");
        }
        QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").encodeString(getKeyEmoticonTabCacheKey(), sb5.toString());
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveTabCacheToMMKV end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEmoticonCache(Emoticon emoticon) {
        if (TextUtils.isEmpty(emoticon.encryptKey)) {
            Emoticon e16 = this.emoticonCache.e(emoticon.getMapKey());
            if (e16 == null || TextUtils.isEmpty(e16.encryptKey)) {
                e16 = (Emoticon) DBMethodProxy.find(this.f204149em, Emoticon.class, "epId=? and eId=?", new String[]{emoticon.epId, emoticon.eId});
            }
            if (e16 != null && !TextUtils.isEmpty(e16.encryptKey)) {
                emoticon.encryptKey = e16.encryptKey;
            }
        }
        this.emoticonCache.f(emoticon.getMapKey(), emoticon);
        synchronized (this.subEmoticonsCache) {
            List<Emoticon> e17 = this.subEmoticonsCache.e(emoticon.epId);
            if (e17 != null) {
                Iterator<Emoticon> it = e17.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Emoticon next = it.next();
                    if (emoticon.eId.equals(next.eId)) {
                        e17.remove(next);
                        e17.add(emoticon);
                        break;
                    }
                }
                this.subEmoticonsCache.f(emoticon.epId, e17);
            }
        }
        updateKeywordEmoticonsCache(emoticon);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public HashSet<String> updateEmotionsToDB(List<Emoticon> list) {
        HashSet<String> hashSet = new HashSet<>();
        ArrayList arrayList = new ArrayList();
        for (Emoticon emoticon : list) {
            if (emoticon != null) {
                hashSet.add(emoticon.name);
                addEntityToTransaction(arrayList, emoticon);
            }
        }
        if (!arrayList.isEmpty() && !this.f204149em.doMultiDBOperateByTransaction(arrayList)) {
            QLog.e(TAG, 1, "saveEmoticons error");
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateEntity(Entity entity) {
        if (entity.getStatus() == 1000) {
            this.f204149em.persistOrReplace(entity);
            if (entity.getStatus() != 1001) {
                return false;
            }
            return true;
        }
        if (entity.getStatus() != 1001 && entity.getStatus() != 1002) {
            return false;
        }
        return this.f204149em.update(entity);
    }

    private void updateExtensionSize(String str, Emoticon emoticon, byte[] bArr, Integer num) {
        boolean z16;
        MarketFaceExtPb$ResvAttr marketFaceExtPb$ResvAttr = new MarketFaceExtPb$ResvAttr();
        try {
            marketFaceExtPb$ResvAttr.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        int i3 = 0;
        if (marketFaceExtPb$ResvAttr.uint32_emoji_type.has() && marketFaceExtPb$ResvAttr.uint32_emoji_type.get() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (marketFaceExtPb$ResvAttr.rpt_apng_support_size != null && emoticon.extensionWidth == 0 && emoticon.extensionHeight == 0) {
                while (i3 < marketFaceExtPb$ResvAttr.rpt_apng_support_size.size()) {
                    MarketFaceExtPb$SupportSize marketFaceExtPb$SupportSize = marketFaceExtPb$ResvAttr.rpt_apng_support_size.get(i3);
                    int i16 = marketFaceExtPb$SupportSize.uint32_width.get();
                    int i17 = marketFaceExtPb$SupportSize.uint32_height.get();
                    if (i16 == num.intValue() && i17 == num.intValue()) {
                        emoticon.extensionWidth = num.intValue();
                        emoticon.extensionHeight = num.intValue();
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "get apng support size from resvAttr, betterSize: " + num + ", epId: " + str + " , eId: " + emoticon.eId);
                            return;
                        }
                        return;
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        if (marketFaceExtPb$ResvAttr.rpt_support_size != null && emoticon.extensionHeight == 0 && emoticon.extensionWidth == 0) {
            while (i3 < marketFaceExtPb$ResvAttr.rpt_support_size.size()) {
                MarketFaceExtPb$SupportSize marketFaceExtPb$SupportSize2 = marketFaceExtPb$ResvAttr.rpt_support_size.get(i3);
                int i18 = marketFaceExtPb$SupportSize2.uint32_width.get();
                int i19 = marketFaceExtPb$SupportSize2.uint32_height.get();
                if (i18 == num.intValue() && i19 == num.intValue()) {
                    emoticon.extensionWidth = num.intValue();
                    emoticon.extensionHeight = num.intValue();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "get support size from resvAttr, betterSize: " + num + ", epId: " + str + " , eId: " + emoticon.eId);
                        return;
                    }
                    return;
                }
                i3++;
            }
        }
    }

    private void updateKeywordEmoticonsCache(Emoticon emoticon) {
        synchronized (this.keywordEmoticonsCache) {
            List<Emoticon> e16 = this.keywordEmoticonsCache.e(emoticon.name);
            if (e16 != null) {
                Iterator<Emoticon> it = e16.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Emoticon next = it.next();
                    if (emoticon.eId.equals(next.eId)) {
                        e16.remove(next);
                        e16.add(emoticon);
                        break;
                    }
                }
                this.keywordEmoticonsCache.f(emoticon.name, e16);
            }
        }
    }

    private void updateKeywordReqTimeToDB(final EmoticonKeywords emoticonKeywords) {
        if (emoticonKeywords == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveKeywordReqTimeToDB");
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                EmoticonManagerServiceImpl.this.lambda$updateKeywordReqTimeToDB$1(emoticonKeywords);
            }
        }, 32, null, true);
    }

    private void writeRecommendInfoFromFileToCache(final int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "writeRecommendInfoFromFileToCache businessType = " + i3);
        }
        Handler handler = this.fileThreadHandler;
        if (handler == null) {
            QLog.e(TAG, 1, "writeRecommendInfoFromFileToCache fileThreadHandler == null");
        } else {
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.24
                @Override // java.lang.Runnable
                public void run() {
                    File file = new File(BaseApplication.getContext().getFilesDir(), "recommemd_emotion_file__" + i3 + EmoticonManagerServiceImpl.this.mCurrentAccountUin);
                    if (!file.exists()) {
                        try {
                            if (!file.createNewFile()) {
                                QLog.e(EmoticonManagerServiceImpl.TAG, 1, "writeRecommendInfoFromFileToCache, create file fail");
                                return;
                            }
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                    }
                    byte[] fileToBytes = FileUtils.fileToBytes(file);
                    final EmosmPb$SubCmd0x5RspBQRecommend emosmPb$SubCmd0x5RspBQRecommend = new EmosmPb$SubCmd0x5RspBQRecommend();
                    if (fileToBytes != null) {
                        try {
                            emosmPb$SubCmd0x5RspBQRecommend.mergeFrom(fileToBytes);
                        } catch (Exception e17) {
                            e17.printStackTrace();
                            emosmPb$SubCmd0x5RspBQRecommend = null;
                        }
                        if (emosmPb$SubCmd0x5RspBQRecommend != null) {
                            if (QLog.isColorLevel()) {
                                QLog.d(EmoticonManagerServiceImpl.TAG, 2, "writeRecommendInfoFromFileToCache post to uithread");
                            }
                            EmoticonManagerServiceImpl.this.uiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.24.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass24 anonymousClass24 = AnonymousClass24.this;
                                    EmoticonManagerServiceImpl.this.recommendRspMap.put(i3, emosmPb$SubCmd0x5RspBQRecommend);
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void addEmotionKeywordExpose(EmotionKeyword emotionKeyword, boolean z16) {
        if (emotionKeyword != null && !TextUtils.isEmpty(emotionKeyword.keyword)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "addEmotionKeywordExpose emotion keyword = " + emotionKeyword + ",isReset = " + z16);
            }
            List<EmotionKeyword> emotionKeywordDataFromCache = getEmotionKeywordDataFromCache(emotionKeyword.keyword);
            if (emotionKeywordDataFromCache != null) {
                for (EmotionKeyword emotionKeyword2 : emotionKeywordDataFromCache) {
                    if (emotionKeyword.equals(emotionKeyword2)) {
                        if (z16) {
                            emotionKeyword2.exposeNum = 0;
                        } else {
                            emotionKeyword2.exposeNum++;
                        }
                        this.needToDBEmotionKeyword.remove(emotionKeyword);
                        this.needToDBEmotionKeyword.add(emotionKeyword2);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void addEmotionKeywordToCache(EmotionKeyword emotionKeyword) {
        EmotionKeyword emotionKeyword2;
        if (emotionKeyword == null) {
            return;
        }
        String str = emotionKeyword.keyword;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addEmotionKeywordToCache emotionKeyword = " + emotionKeyword);
        }
        CopyOnWriteArrayList<EmotionKeyword> emotionKeywordData = getEmotionKeywordData(str);
        if (emotionKeywordData != null) {
            Iterator<EmotionKeyword> it = emotionKeywordData.iterator();
            while (true) {
                if (it.hasNext()) {
                    emotionKeyword2 = it.next();
                    if (emotionKeyword.equals(emotionKeyword2)) {
                        break;
                    }
                } else {
                    emotionKeyword2 = null;
                    break;
                }
            }
            if (emotionKeyword2 != null) {
                emotionKeyword2.replace(emotionKeyword);
                emotionKeyword = emotionKeyword2;
            } else {
                emotionKeywordData.add(emotionKeyword);
            }
        } else {
            CopyOnWriteArrayList<EmotionKeyword> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.add(emotionKeyword);
            this.emotionKeywordCache.put(str, copyOnWriteArrayList);
        }
        this.needToDBEmotionKeyword.remove(emotionKeyword);
        this.needToDBEmotionKeyword.add(emotionKeyword);
    }

    public void addExtensionSizeByScreenSize(String str, Emoticon emoticon, byte[] bArr) {
        Integer num = betterDisplaySize.get(Double.valueOf(fetchScreenInch()));
        if (num != null && num.intValue() != 0) {
            if (str != null && emoticon.extensionHeight == 0 && emoticon.extensionWidth == 0) {
                int extensionSizeByScreenSize = getExtensionSizeByScreenSize(str);
                if (extensionSizeByScreenSize != -1) {
                    emoticon.extensionHeight = extensionSizeByScreenSize;
                    emoticon.extensionWidth = extensionSizeByScreenSize;
                    return;
                }
                return;
            }
            if (bArr != null) {
                updateExtensionSize(str, emoticon, bArr, num);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "get support size " + num + ", epId: " + str + " , eId: " + emoticon.eId + ", height: " + emoticon.extensionHeight + ", width: " + emoticon.extensionWidth);
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void addExtensionSizeByScreenSizeFromKeyword(String str, Emoticon emoticon, List<EmosmPb$SupportSize> list) {
        Integer num;
        if (list != null && emoticon != null && (num = betterDisplaySize.get(Double.valueOf(fetchScreenInch()))) != null && num.intValue() != 0) {
            if (syncFindEmoticonPackageById(str) != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "get support size from cloud: local exists, better size" + num + ", epId: " + str + " , eId: " + emoticon.eId);
                }
                addExtensionSizeByScreenSize(str, emoticon, null);
                return;
            }
            for (EmosmPb$SupportSize emosmPb$SupportSize : list) {
                int i3 = emosmPb$SupportSize.u32_Width.get();
                int i16 = emosmPb$SupportSize.u32_height.get();
                if (i3 == num.intValue() && i16 == num.intValue()) {
                    emoticon.extensionWidth = num.intValue();
                    emoticon.extensionHeight = num.intValue();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "get support size from cloud: , better size" + num + ", epId: " + str + " , eId: " + emoticon.eId);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void addKeywordEmoticonsCache(String str) {
        List<Emoticon> syncGetSubEmoticonsByPackageId = syncGetSubEmoticonsByPackageId(str);
        if (syncGetSubEmoticonsByPackageId == null) {
            return;
        }
        synchronized (this.keywordEmoticonsCache) {
            for (Emoticon emoticon : syncGetSubEmoticonsByPackageId) {
                List<Emoticon> e16 = this.keywordEmoticonsCache.e(emoticon.name);
                if (e16 != null && !e16.contains(emoticon)) {
                    e16.add(emoticon);
                    this.keywordEmoticonsCache.f(emoticon.name, e16);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void addRecentEmotionExposeNum(EmotionKeyword emotionKeyword, boolean z16) {
        if (emotionKeyword != null && !TextUtils.isEmpty(emotionKeyword.keyword) && !TextUtils.isEmpty(emotionKeyword.epId) && !TextUtils.isEmpty(emotionKeyword.eId)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "addRecentEmotionExposeNum emotion keyword = " + emotionKeyword);
            }
            CopyOnWriteArrayList<RecentEmotion> recentEmotionDataFromCache = getRecentEmotionDataFromCache(emotionKeyword.keyword);
            if (recentEmotionDataFromCache != null) {
                for (RecentEmotion recentEmotion : recentEmotionDataFromCache) {
                    if (emotionKeyword.keyword.equals(recentEmotion.keyword) && emotionKeyword.epId.equals(recentEmotion.epId) && emotionKeyword.eId.equals(recentEmotion.eId)) {
                        if (z16) {
                            recentEmotion.exposeNum = 0;
                        } else {
                            recentEmotion.exposeNum++;
                        }
                        this.needToDBRecentEmotion.remove(recentEmotion);
                        this.needToDBRecentEmotion.add(0, recentEmotion);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void addRecentEmotionToCache(final RecentEmotion recentEmotion) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.18
            @Override // java.lang.Runnable
            public void run() {
                if (recentEmotion == null) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(EmoticonManagerServiceImpl.TAG, 2, "addRecentEmotionToCache key = " + recentEmotion);
                }
                String str = recentEmotion.keyword;
                if (TextUtils.isEmpty(str)) {
                    QLog.e(EmoticonManagerServiceImpl.TAG, 1, "addRecentEmotionToCache keyword empty");
                    return;
                }
                RecentEmotion recentEmotion2 = recentEmotion;
                CopyOnWriteArrayList recentEmotionData = EmoticonManagerServiceImpl.this.getRecentEmotionData(str);
                if (recentEmotionData != null) {
                    int indexOf = recentEmotionData.indexOf(recentEmotion);
                    if (indexOf > -1) {
                        recentEmotion2 = (RecentEmotion) recentEmotionData.get(indexOf);
                        recentEmotion2.replace(recentEmotion);
                    } else {
                        recentEmotionData.add(recentEmotion);
                    }
                } else {
                    CopyOnWriteArrayList<RecentEmotion> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                    copyOnWriteArrayList.add(recentEmotion);
                    EmoticonManagerServiceImpl.this.recentEmotionData.put(str, copyOnWriteArrayList);
                }
                EmoticonManagerServiceImpl.this.needToDBRecentEmotion.remove(recentEmotion2);
                EmoticonManagerServiceImpl.this.needToDBRecentEmotion.add(0, recentEmotion2);
            }
        }, 5, null, true);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void addTabEmoticonPackage(@NonNull EmoticonPackage emoticonPackage, int i3) {
        final String str = emoticonPackage.epId;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "addTabEmoticonPackage, emoticonTabId = " + str + " businessType = " + i3);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof BaseQQAppInterface)) {
            QLog.e(TAG, 1, "addTabEmoticonPackage error, app is null!");
            return;
        }
        if (com.tencent.mobileqq.emosm.h.a() && !this.tabCache.contains(str)) {
            addCommonTabEmojiInfoCache(EmoticonTabNtUtils.INSTANCE.convertEmoticonPackageCommonEmojiInfo(emoticonPackage));
        }
        final BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        ((com.tencent.qqnt.emotion.api.IEmoticonManagerService) baseQQAppInterface.getRuntimeService(com.tencent.qqnt.emotion.api.IEmoticonManagerService.class)).addTabEmoticonPackage(str, i3);
        if (i3 != 1) {
            this.tabCache.remove(str);
            this.tabCache.add(0, str);
        } else {
            this.kanDianTabCache.remove(str);
            this.kanDianTabCache.add(0, str);
        }
        runInCurrentThread(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.17
            @Override // java.lang.Runnable
            public void run() {
                synchronized (EmoticonManagerServiceImpl.this) {
                    EmoticonManagerServiceImpl.this.f204149em.drop(EmoticonTab.class.getSimpleName());
                    ArrayList arrayList = new ArrayList();
                    Iterator<String> it = EmoticonManagerServiceImpl.this.tabCache.iterator();
                    while (it.hasNext()) {
                        EmoticonManagerServiceImpl.this.insertOrUpdateEmoticonTab(arrayList, it.next(), true, false);
                    }
                    Iterator<String> it5 = EmoticonManagerServiceImpl.this.kanDianTabCache.iterator();
                    while (it5.hasNext()) {
                        EmoticonManagerServiceImpl.this.insertOrUpdateEmoticonTab(arrayList, it5.next(), false, true);
                    }
                    if (!arrayList.isEmpty() && !EmoticonManagerServiceImpl.this.f204149em.doMultiDBOperateByTransaction(arrayList)) {
                        QLog.i(EmoticonManagerServiceImpl.TAG, 1, "addTabEmoticonPackage, FAIL");
                    }
                }
                List<Emoticon> syncGetSubEmoticonsByPackageId = EmoticonManagerServiceImpl.this.syncGetSubEmoticonsByPackageId(str);
                if (syncGetSubEmoticonsByPackageId == null) {
                    return;
                }
                HashSet hashSet = new HashSet();
                Iterator<Emoticon> it6 = syncGetSubEmoticonsByPackageId.iterator();
                while (it6.hasNext()) {
                    String str2 = it6.next().name;
                    if (str2 != null) {
                        hashSet.add(str2);
                    }
                }
                StickerRecManagerImpl.get(baseQQAppInterface).syncAddLocalEmoticonKeywords(hashSet);
                EmoticonManagerServiceImpl.this.addKeywordEmoticonsCache(str);
                EmoticonManagerServiceImpl.this.saveTabCacheToMMKV();
            }
        }, 5);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void asyncFindEmoticon(String str, String str2, QueryCallback<Emoticon> queryCallback) {
        new QueryTask(new f(), queryCallback).execute(new Pair(str, str2));
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void asyncFindEmoticonPackage(String str, QueryCallback<EmoticonPackage> queryCallback) {
        asyncFindEmoticonPackage(str, 0, queryCallback);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void asyncFindTabEmoticonPackageById(String str, QueryCallback<EmoticonPackage> queryCallback) {
        asyncFindTabEmoticonPackageById(str, 0, queryCallback);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void asyncGetCommonTabEmojiInfoList(int i3, QueryCallback<List<CommonTabEmojiInfo>> queryCallback) {
        new QueryTask(new a(), queryCallback).execute(Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void asyncGetEmoticonInfo(MarkFaceMessage markFaceMessage, QueryCallback queryCallback) {
        new QueryTask(new b(markFaceMessage), queryCallback).execute(markFaceMessage);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void asyncGetTabEmoticonPackages(int i3, QueryCallback<List<EmoticonPackage>> queryCallback) {
        new QueryTask(new h(), queryCallback).execute(Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void asyncIncreaseEmotionClickNum(Emoticon emoticon) {
        if (emoticon == null) {
            return;
        }
        List<Emoticon> e16 = this.keywordEmoticonsCache.e(emoticon.name);
        if (e16 == null) {
            emoticon.increaseExposeNum();
            this.emoticonCache.f(emoticon.getMapKey(), emoticon);
            this.f204149em.update(emoticon);
            return;
        }
        for (final Emoticon emoticon2 : e16) {
            if (emoticon2 != null && emoticon.getMapKey().equals(emoticon2.getMapKey())) {
                emoticon2.increaseClickNum();
                this.emoticonCache.f(emoticon2.getMapKey(), emoticon2);
                this.dbThreadHandler.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.26
                    @Override // java.lang.Runnable
                    public void run() {
                        EmoticonManagerServiceImpl.this.f204149em.update(emoticon2);
                    }
                });
                return;
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void clearAllRecommendExposeNum() {
        clearFixRecommendExposeNum();
        clearNotFixRecommendExposeNum();
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void clearCache() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "clearCache begins");
        }
        this.ntCommonTabEmojiInfoList.clear();
        this.tabCache.clear();
        this.kanDianTabCache.clear();
        this.pkgCache.d();
        this.emoticonCache.d();
        this.subEmoticonsCache.d();
        this.keywordEmoticonsCache.d();
        Map<String, Integer> map = this.hotWords;
        if (map != null) {
            map.clear();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "clearCache ends");
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void clearEmotionKeyword(String str) {
        EmotionKeyword emotionKeyword;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "resetEmotionKeyword keyword = " + str);
        }
        CopyOnWriteArrayList<EmotionKeyword> emotionKeywordData = getEmotionKeywordData(str);
        if (emotionKeywordData == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("clearEmotionKeyword :");
        ArrayList<EmotionKeyword> arrayList = new ArrayList();
        for (EmotionKeyword emotionKeyword2 : emotionKeywordData) {
            if (emotionKeyword2 != null && emotionKeyword2.exposeNum >= 3) {
                this.needToDBEmotionKeyword.remove(emotionKeyword2);
                arrayList.add(emotionKeyword2);
                sb5.append(emotionKeyword2);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, sb5.toString());
        }
        if (arrayList.size() > 0) {
            emotionKeywordData.removeAll(arrayList);
            ArrayList arrayList2 = new ArrayList();
            for (EmotionKeyword emotionKeyword3 : arrayList) {
                if (emotionKeyword3 != null && (emotionKeyword = (EmotionKeyword) this.f204149em.doFindOperateByTransaction(new FindTransaction(EmotionKeyword.class, "epId=? and eId=? and keyword=?", new String[]{emotionKeyword3.epId, emotionKeyword3.eId, emotionKeyword3.keyword}))) != null) {
                    arrayList2.add(new RemoveTransaction(emotionKeyword));
                }
            }
            if (!arrayList2.isEmpty() && !this.f204149em.doMultiDBOperateByTransaction(arrayList2)) {
                QLog.i(TAG, 1, "clearEmotionKeyword, FAIL");
            }
        }
    }

    protected void downloadPackageUncomplete(int i3, IEmojiManagerService iEmojiManagerService, EmoticonPackage emoticonPackage, boolean z16) {
        if (z16) {
            saveEmoticonPackage(emoticonPackage);
            if (4 == emoticonPackage.jobType) {
                iEmojiManagerService.startDownloadEmosmJson(emoticonPackage.epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL, null, true, i3);
            } else {
                iEmojiManagerService.startDownloadEmosmJson(emoticonPackage.epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL, null, false, i3);
            }
            int i16 = emoticonPackage.jobType;
            if (i16 != 0 && 4 != i16) {
                String p16 = com.tencent.mobileqq.emosm.e.p(2, emoticonPackage.epId);
                File file = new File(com.tencent.mobileqq.emosm.e.n(2, emoticonPackage.epId));
                if (!file.exists()) {
                    ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(1).startDownload(new com.tencent.mobileqq.vip.g(p16, file), null, null);
                    return;
                }
                return;
            }
            iEmojiManagerService.startCoverDownload(emoticonPackage);
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public EmoticonTab findEmoticonTabById(String str) {
        return (EmoticonTab) DBMethodProxy.find(this.f204149em, (Class<? extends Entity>) EmoticonTab.class, str);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public List<Emoticon> findKeywordEmotion(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "findKeywordEmotion");
        }
        ArrayList arrayList = new ArrayList();
        Emoticon recentEmotionByKeyword = getRecentEmotionByKeyword(str);
        if (recentEmotionByKeyword != null) {
            arrayList.add(recentEmotionByKeyword);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("findKeywordEmotion, find from local:");
        CopyOnWriteArrayList<EmotionKeyword> emotionKeywordData = getEmotionKeywordData(str);
        if (emotionKeywordData != null) {
            for (EmotionKeyword emotionKeyword : emotionKeywordData) {
                if (emotionKeyword != null && emotionKeyword.exposeNum < 3) {
                    Emoticon syncFindEmoticonById = syncFindEmoticonById(emotionKeyword.epId, emotionKeyword.eId);
                    if (syncFindEmoticonById == null) {
                        QLog.e(TAG, 1, "findKeywordEmotion emoticon = null, epId = " + emotionKeyword.epId + ",eId = " + emotionKeyword.eId);
                    }
                    if (syncFindEmoticonById != null && !arrayList.contains(syncFindEmoticonById) && isKeywordEmotionValid(syncFindEmoticonById.epId)) {
                        arrayList.add(syncFindEmoticonById);
                        sb5.append(syncFindEmoticonById.eId);
                        sb5.append(",");
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, sb5.toString());
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040 A[EXC_TOP_SPLITTER, LOOP:0: B:14:0x0040->B:29:0x008e, LOOP_START, PHI: r4
  0x0040: PHI (r4v1 int) = (r4v0 int), (r4v2 int) binds: [B:11:0x003d, B:29:0x008e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getExtensionSizeByScreenSize(String str) {
        JSONArray jSONArray;
        Integer num = betterDisplaySize.get(Double.valueOf(fetchScreenInch()));
        if (num != null && num.intValue() != 0) {
            EmoticonPackage syncFindEmoticonPackageById = syncFindEmoticonPackageById(str);
            if (syncFindEmoticonPackageById != null && !TextUtils.isEmpty(syncFindEmoticonPackageById.supportSize)) {
                try {
                    jSONArray = new JSONArray(syncFindEmoticonPackageById.supportSize);
                } catch (JSONException e16) {
                    QLog.e(TAG, 1, e16, new Object[0]);
                }
                if (jSONArray != null) {
                    return -1;
                }
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    try {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        int i16 = jSONObject.getInt("Width");
                        int i17 = jSONObject.getInt("Height");
                        if (i16 == num.intValue() && i17 == num.intValue()) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "get support size from db, betterSize " + num + ", epId: " + str);
                            }
                            return num.intValue();
                        }
                    } catch (JSONException e17) {
                        e17.printStackTrace();
                    }
                }
            }
            jSONArray = null;
            if (jSONArray != null) {
            }
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public VipIPSiteInfo getIPSiteInfoFromBytes(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            VipIPSiteInfo createFromParcel = VipIPSiteInfo.CREATOR.createFromParcel(obtain);
            OaidMonitor.parcelRecycle(obtain);
            return createFromParcel;
        }
        QLog.e(TAG, 1, "getIPSiteInfoFromBytes, error data = " + bArr);
        return null;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public long getKeywordLastReqTime(String str) {
        long j3 = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        if (this.keywordReqTimeInfo.containsKey(str)) {
            EmoticonKeywords emoticonKeywords = this.keywordReqTimeInfo.get(str);
            if (emoticonKeywords != null) {
                j3 = emoticonKeywords.lastReqTime;
            }
        } else {
            EmoticonKeywords emoticonKeywords2 = (EmoticonKeywords) DBMethodProxy.find(this.f204149em, EmoticonKeywords.class, "keyword=?", new String[]{str});
            if (emoticonKeywords2 != null) {
                j3 = emoticonKeywords2.lastReqTime;
                this.keywordReqTimeInfo.put(str, emoticonKeywords2);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getKeywordLastReqTime keyword = " + str + ", lastReqTime = " + j3);
        }
        return j3;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public int getKeywordTotalCount(String str) {
        Integer num;
        if (!TextUtils.isEmpty(str) && (num = this.hotWords.get(str)) != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public List<String> getKeywordsByEmoticon(Emoticon emoticon) {
        JSONArray jSONArray;
        if (emoticon == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            String str = emoticon.keywords;
            if (str != null) {
                jSONArray = new JSONArray(str);
            } else {
                jSONArray = new JSONArray();
            }
            if (jSONArray.length() > 0) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    String string = jSONArray.getString(i3);
                    if (!TextUtils.isEmpty(string)) {
                        arrayList.add(string);
                    }
                }
            }
            return arrayList;
        } catch (Exception e16) {
            QLog.e(TAG, 2, "getKeywordsByEmoticon exception e = " + e16.getMessage());
            return null;
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public List<String> getLocalExposeNumFullKeyword(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getLocalExposeNumFullKeyword : ids,");
        CopyOnWriteArrayList<EmotionKeyword> emotionKeywordData = getEmotionKeywordData(str);
        if (emotionKeywordData != null) {
            for (EmotionKeyword emotionKeyword : emotionKeywordData) {
                if (emotionKeyword != null && emotionKeyword.exposeNum >= 3) {
                    String str2 = emotionKeyword.eId;
                    if (!TextUtils.isEmpty(str2) && !arrayList.contains(str2)) {
                        arrayList.add(str2);
                        sb5.append(",eId=");
                        sb5.append(str2);
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, sb5.toString());
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public List<EmoticonInfo> getMagicEmoticonInfoList(int i3) {
        ArrayList arrayList = new ArrayList();
        List<EmoticonPackage> syncGetTabEmoticonPackages = syncGetTabEmoticonPackages(i3);
        ArrayList<EmoticonPackage> arrayList2 = new ArrayList();
        if (syncGetTabEmoticonPackages != null) {
            for (int i16 = 0; i16 < syncGetTabEmoticonPackages.size(); i16++) {
                EmoticonPackage emoticonPackage = syncGetTabEmoticonPackages.get(i16);
                int i17 = emoticonPackage.jobType;
                if (3 == i17 || 5 == i17) {
                    arrayList2.add(emoticonPackage);
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int i18 = 0;
        for (EmoticonPackage emoticonPackage2 : arrayList2) {
            List<Emoticon> syncGetSubEmoticonsByPackageId = syncGetSubEmoticonsByPackageId(emoticonPackage2.epId, false);
            if (syncGetSubEmoticonsByPackageId != null) {
                for (Emoticon emoticon : syncGetSubEmoticonsByPackageId) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "try to get pack data, id:" + emoticonPackage2.epId + ",valid:" + emoticonPackage2.valid + ",status:" + emoticonPackage2.status);
                    }
                    int i19 = emoticonPackage2.jobType;
                    if (i19 == 3) {
                        emoticon.jobType = 2;
                    } else if (i19 == 5) {
                        emoticon.jobType = 4;
                    }
                    if (!TextUtils.isEmpty(emoticonPackage2.name)) {
                        emoticon.name = emoticonPackage2.name;
                    }
                    emoticon.value = emoticonPackage2.valid;
                    PicEmoticonInfo picEmoticonInfo = new PicEmoticonInfo(this.mCurrentAccountUin);
                    picEmoticonInfo.type = 9;
                    picEmoticonInfo.emoticon = emoticon;
                    arrayList.add(picEmoticonInfo);
                    if (emoticonPackage2.valid && emoticonPackage2.status == 2) {
                        arrayList3.add(Integer.valueOf(i18));
                    } else {
                        arrayList4.add(Integer.valueOf(i18));
                    }
                    i18++;
                }
            } else {
                QLog.e(TAG, 1, "getMagicEmoticonInfoList, emoticons is null, epId = " + emoticonPackage2.epId);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "comp size:" + arrayList3.size() + ",inComp size:" + arrayList4.size());
        }
        if (arrayList3.size() > 0 && arrayList4.size() > 0 && ((Integer) arrayList3.get(arrayList3.size() - 1)).intValue() > ((Integer) arrayList4.get(0)).intValue()) {
            ArrayList arrayList5 = new ArrayList();
            for (int i26 = 0; i26 < arrayList3.size(); i26++) {
                arrayList5.add((EmoticonInfo) arrayList.get(((Integer) arrayList3.get(i26)).intValue()));
            }
            for (int i27 = 0; i27 < arrayList4.size(); i27++) {
                arrayList5.add((EmoticonInfo) arrayList.get(((Integer) arrayList4.get(i27)).intValue()));
            }
            arrayList = arrayList5;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "final size:" + arrayList.size() + ",inComp size:" + arrayList4.size());
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public List<CommonTabEmojiInfo> getNtCommonTabEmojiInfoList() {
        return new ArrayList(this.ntCommonTabEmojiInfoList);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public CommonTabEmojiInfo getNtOfficialCommonTabEmojiInfo(int i3) {
        int convertEmoticonPanelTypeToNTOfficialTabType = EmoticonTabNtUtils.INSTANCE.convertEmoticonPanelTypeToNTOfficialTabType(i3);
        Iterator<CommonTabEmojiInfo> it = this.ntCommonTabEmojiInfoList.iterator();
        while (it.hasNext()) {
            CommonTabEmojiInfo next = it.next();
            if (next.epId == convertEmoticonPanelTypeToNTOfficialTabType) {
                return next;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public com.tencent.cache.api.collection.a<String, EmoticonPackage> getPkgCache() {
        return this.pkgCache;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x005a  */
    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<PromotionEmoticonPkg> getProEmoticonPkgs(boolean z16, int i3, boolean z17) {
        EmosmPb$SubCmd0x5RspBQRecommend emosmPb$SubCmd0x5RspBQRecommend;
        boolean z18;
        boolean z19;
        List<PromotionEmoticonPkg> list;
        boolean z26;
        boolean z27;
        List<PromotionEmoticonPkg> list2 = null;
        EmosmPb$SubCmd0x5RspBQRecommend emosmPb$SubCmd0x5RspBQRecommend2 = null;
        list2 = null;
        if (i3 != 0) {
            if (i3 != 1) {
                list = null;
                z27 = false;
                z26 = false;
                if (!z16) {
                    if (z17 && list != null) {
                        ArrayList arrayList = new ArrayList();
                        for (PromotionEmoticonPkg promotionEmoticonPkg : list) {
                            if (promotionEmoticonPkg.type == 6) {
                                arrayList.add(promotionEmoticonPkg);
                            }
                        }
                        return arrayList;
                    }
                    return list;
                }
                List<PromotionEmoticonPkg> promotionEmoticonPkgs = getPromotionEmoticonPkgs(i3, emosmPb$SubCmd0x5RspBQRecommend2);
                if (z27) {
                    this.recommendPanelShowInfoMap.put(0, promotionEmoticonPkgs);
                } else if (z26) {
                    this.recommendPanelShowInfoMap.put(1, promotionEmoticonPkgs);
                }
                if (z17) {
                    ArrayList arrayList2 = new ArrayList();
                    for (PromotionEmoticonPkg promotionEmoticonPkg2 : promotionEmoticonPkgs) {
                        if (promotionEmoticonPkg2.type == 6) {
                            arrayList2.add(promotionEmoticonPkg2);
                        }
                    }
                    return arrayList2;
                }
                return promotionEmoticonPkgs;
            }
            if (this.recommendRspMap.indexOfKey(1) >= 0) {
                emosmPb$SubCmd0x5RspBQRecommend = this.recommendRspMap.get(i3);
            } else {
                emosmPb$SubCmd0x5RspBQRecommend = null;
            }
            if (this.recommendPanelShowInfoMap.indexOfKey(1) >= 0) {
                list2 = this.recommendPanelShowInfoMap.get(i3);
            }
            z19 = true;
            z18 = false;
        } else {
            if (this.recommendRspMap.indexOfKey(0) >= 0) {
                emosmPb$SubCmd0x5RspBQRecommend = this.recommendRspMap.get(i3);
            } else {
                emosmPb$SubCmd0x5RspBQRecommend = null;
            }
            if (this.recommendPanelShowInfoMap.indexOfKey(0) >= 0) {
                list2 = this.recommendPanelShowInfoMap.get(i3);
            }
            z18 = true;
            z19 = false;
        }
        EmosmPb$SubCmd0x5RspBQRecommend emosmPb$SubCmd0x5RspBQRecommend3 = emosmPb$SubCmd0x5RspBQRecommend;
        list = list2;
        emosmPb$SubCmd0x5RspBQRecommend2 = emosmPb$SubCmd0x5RspBQRecommend3;
        z27 = z18;
        z26 = z19;
        if (!z16) {
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public Emoticon getRecentEmotionByKeyword(String str) {
        Emoticon syncFindEmoticonById;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getRecentEmotionByKeyword, keyword = " + str);
        }
        CopyOnWriteArrayList<RecentEmotion> recentEmotionData = getRecentEmotionData(str);
        if (recentEmotionData != null && recentEmotionData.size() > 0) {
            for (int i3 = 0; i3 < recentEmotionData.size(); i3++) {
                RecentEmotion recentEmotion = recentEmotionData.get(i3);
                if (recentEmotion != null && recentEmotion.exposeNum < 3 && (syncFindEmoticonById = syncFindEmoticonById(recentEmotion.epId, recentEmotion.eId)) != null && isKeywordEmotionValid(syncFindEmoticonById.epId)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getRecentEmotionByKeyword, keyword = " + str + ", emoticon = " + syncFindEmoticonById.getMapKey());
                    }
                    return syncFindEmoticonById;
                }
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public String getSmallEmoticonDescription(final String str, final String str2) {
        Emoticon e16 = this.emoticonCache.e(str + "_" + str2);
        if (e16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "can not find small emotion in cache, but pkg in cache: epId = " + str + ", eId = " + str2);
            }
            runInCurrentThread(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    Emoticon emoticon = (Emoticon) DBMethodProxy.find(EmoticonManagerServiceImpl.this.f204149em, Emoticon.class, "epId=? and eId=?", new String[]{str, str2});
                    if (emoticon != null) {
                        EmoticonManagerServiceImpl.this.emoticonCache.f(emoticon.getMapKey(), emoticon);
                        if (QLog.isColorLevel()) {
                            QLog.d(EmoticonManagerServiceImpl.TAG, 2, "hit db, put into cache");
                        }
                    }
                }
            }, 5);
            return "";
        }
        return e16.character;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public List<String> getTabCache() {
        return this.tabCache;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public boolean handleFetchEmoticonPackagesResp(boolean z16, int i3, EmoticonResp emoticonResp, int i16) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        List<CommonTabEmojiInfo> list;
        boolean z27;
        boolean z28;
        List<Emoticon> syncGetSubEmoticonsByPackageId;
        boolean z29 = true;
        if (!z16) {
            QLog.i(TAG, 1, "handleFetchEmoticonPackagesResp isSuccess = false, businessType = " + i16);
        }
        boolean z36 = false;
        if (i3 == 2 && z16) {
            ArrayList arrayList = new ArrayList();
            List list2 = emoticonResp.data;
            if (list2 != null) {
                arrayList.addAll(list2);
            }
            List<EmoticonPackage> list3 = emoticonResp.magicData;
            if (list3 != null) {
                arrayList.addAll(list3);
            }
            List<EmoticonPackage> list4 = emoticonResp.smallEmoticonData;
            if (list4 != null) {
                arrayList.addAll(list4);
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleFetchEmoticonPackagesResp, big emoticon list=" + emoticonResp.data + "magic emoticon list=" + emoticonResp.magicData + "small emoticon list=" + emoticonResp.smallEmoticonData + "emoticon tab order list=" + emoticonResp.tabOrderList + "roaming emoji size:" + arrayList.size());
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (!(peekAppRuntime instanceof BaseQQAppInterface)) {
                QLog.e(TAG, 1, "handleFetchEmoticonPackagesResp error, app is null!");
                return false;
            }
            IEmojiManagerService iEmojiManagerService = (IEmojiManagerService) ((BaseQQAppInterface) peekAppRuntime).getRuntimeService(IEmojiManagerService.class);
            try {
                ArrayList arrayList2 = new ArrayList();
                int i17 = 0;
                z19 = false;
                z18 = false;
                while (i17 < arrayList.size()) {
                    try {
                        EmoticonPackage emoticonPackage = arrayList.get(i17);
                        EmoticonPackage syncFindEmoticonPackageById = syncFindEmoticonPackageById(emoticonPackage.epId, -1);
                        if (syncFindEmoticonPackageById == null) {
                            z27 = z29;
                        } else {
                            z27 = z36;
                        }
                        if (isEmoticonMagic(syncFindEmoticonPackageById) && ((syncGetSubEmoticonsByPackageId = syncGetSubEmoticonsByPackageId(syncFindEmoticonPackageById.epId, z36)) == null || syncGetSubEmoticonsByPackageId.size() == 0)) {
                            z27 = true;
                        }
                        if (checkLocalEmoticonPackage(emoticonPackage, syncFindEmoticonPackageById)) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "handleFetchEmoticonPackagesResp : updateLocalep epDb = " + syncFindEmoticonPackageById + ";ep = " + emoticonPackage);
                            }
                            syncFindEmoticonPackageById.expiretime = emoticonPackage.expiretime;
                            syncFindEmoticonPackageById.valid = emoticonPackage.valid;
                            syncFindEmoticonPackageById.wordingId = emoticonPackage.wordingId;
                            syncFindEmoticonPackageById.jobType = emoticonPackage.jobType;
                            if (emoticonPackage.aio) {
                                z28 = true;
                                syncFindEmoticonPackageById.aio = true;
                            } else {
                                z28 = true;
                            }
                            if (emoticonPackage.kandian) {
                                syncFindEmoticonPackageById.kandian = z28;
                            }
                            arrayList2.add(syncFindEmoticonPackageById);
                            try {
                                int i18 = emoticonPackage.jobType;
                                if (i18 != 3 && i18 != 5) {
                                    z19 = true;
                                } else {
                                    z19 = true;
                                    z18 = true;
                                }
                            } catch (Exception e16) {
                                e = e16;
                                z17 = true;
                                QLog.e(TAG, 1, "handleFetchEmoticonPackagesResp", e);
                                z19 = z17;
                                z26 = z18;
                                updateEmoticonOrder(emoticonResp, i16, z19, arrayList);
                                list = emoticonResp.emojiNewTabs;
                                return list == null ? z26 : z26;
                            }
                        }
                        downloadPackageUncomplete(i16, iEmojiManagerService, emoticonPackage, z27);
                        i17++;
                        z29 = true;
                        z36 = false;
                    } catch (Exception e17) {
                        e = e17;
                        z17 = z19;
                    }
                }
                saveEmoticonPackages(arrayList2);
            } catch (Exception e18) {
                e = e18;
                z17 = false;
                z18 = false;
            }
            z26 = z18;
            updateEmoticonOrder(emoticonResp, i16, z19, arrayList);
            list = emoticonResp.emojiNewTabs;
            if (list == null && list.size() > 0) {
                Collections.reverse(emoticonResp.emojiNewTabs);
                updateNtCommonTabEmojiInfoList(emoticonResp.emojiNewTabs);
                return z26;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public boolean isEpidInTabcache(String str) {
        return this.tabCache.contains(str);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public boolean isKeywordsInHotWordList(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isKeywordsInHotWordList keyword: " + aw.a(str));
        }
        if (!TextUtils.isEmpty(str) && this.hotWords.get(str) != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public boolean isShowFavTabRedPoint(int i3) {
        if (i3 == 6) {
            return ud2.a.f438849a.d();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public boolean isShowRecommendTabRedPoint(int i3) {
        EmosmPb$SubCmd0x5RspBQRecommend emosmPb$SubCmd0x5RspBQRecommend;
        if (!isRecommendRedpointEffective(i3)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "isShowRecommendRedPoint red isRedEffective");
            }
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d(TAG, 1, "isShowRecommendRedPoint error, app is null!");
            return false;
        }
        if (peekAppRuntime.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getBoolean("isClickRecommendRedpoint", false)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "isShowRecommendRedPoint is click");
            }
            return false;
        }
        if (i3 != 0) {
            if (i3 == 1 && this.recommendRspMap.indexOfKey(1) >= 0) {
                emosmPb$SubCmd0x5RspBQRecommend = this.recommendRspMap.get(i3);
            }
            emosmPb$SubCmd0x5RspBQRecommend = null;
        } else {
            if (this.recommendRspMap.indexOfKey(0) >= 0) {
                emosmPb$SubCmd0x5RspBQRecommend = this.recommendRspMap.get(i3);
            }
            emosmPb$SubCmd0x5RspBQRecommend = null;
        }
        if (emosmPb$SubCmd0x5RspBQRecommend == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "isShowRecommendTabRedPoint recommendRsp == null, businessType = " + i3);
            }
            return false;
        }
        List<EmosmPb$STRecommendTabInfo> list = emosmPb$SubCmd0x5RspBQRecommend.st_new_tab_info.get();
        if (list != null && list.size() > 0) {
            int i16 = 0;
            for (EmosmPb$STRecommendTabInfo emosmPb$STRecommendTabInfo : list) {
                String valueOf = String.valueOf(emosmPb$STRecommendTabInfo.u32_tab_id.get());
                if (!TextUtils.isEmpty(valueOf)) {
                    if (emosmPb$STRecommendTabInfo.int32_red_point_flag.get() == 1 && (!this.recommendExposeCount.containsKey(valueOf) || this.recommendExposeCount.get(valueOf).intValue() < EmoticonManagerConstants.RECOMMEND_EXPOSE_MAX)) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "isShowRecommendRedPoint showRedpoint");
                        }
                        return true;
                    }
                    i16++;
                    if (i16 >= 2) {
                        break;
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isShowRecommendRedPoint not show");
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public boolean isWifiOrG3OrG4() {
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isWifiOrG3OrG4 netType = " + systemNetwork);
        }
        if (systemNetwork == 1 || systemNetwork == 3 || systemNetwork == 4 || systemNetwork == 6) {
            return true;
        }
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) appRuntime;
        this.mCurrentAccountUin = baseQQAppInterface.getCurrentAccountUin();
        this.f204149em = baseQQAppInterface.getEntityManagerFactory().createEntityManager();
        betterDisplaySize.put(Double.valueOf(4.7d), 300);
        this.recommendExposeSp = new ao(appRuntime.getApplicationContext(), EmoticonManagerConstants.RECOMMEND_EXPOSE_COUNT_SP_FILE_ + baseQQAppInterface.getCurrentAccountUin());
        this.fixRecommendExposSp = new ao(appRuntime.getApplicationContext(), EmoticonManagerConstants.RECOMMEND_FIX_EXPOSE_COUNT_SP_FILE_ + baseQQAppInterface.getCurrentAccountUin());
        this.uiHandler = new Handler(Looper.getMainLooper());
        Looper fileThreadLooper = ThreadManagerV2.getFileThreadLooper();
        if (fileThreadLooper != null) {
            this.fileThreadHandler = new Handler(fileThreadLooper);
        }
        if (fileThreadLooper != null) {
            this.dbThreadHandler = new Handler(fileThreadLooper);
        }
        baseQQAppInterface.addObserver(this.mVipStatusObserver);
        this.emotionKeywordCache = new QQConcurrentHashMap(Business.AIO, "EmotionKeywordHashMap");
        if (com.tencent.mobileqq.emosm.h.a()) {
            initTabCacheFromMMKV();
            if (this.ntCommonTabEmojiInfoList.isEmpty()) {
                this.ntCommonTabEmojiInfoList.addAll(EmoticonTabNtUtils.INSTANCE.getDefaultNTOfficialTabEmojiInfoList());
            }
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                EmoticonManagerServiceImpl.this.lambda$onCreate$0();
            }
        }, 32, null, true);
        this.mResConfig = new com.tencent.mobileqq.vas.toggle.b("vas_json_res_keyword_list_config");
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof BaseQQAppInterface)) {
            QLog.e(TAG, 1, "onDestroy error, app is null!");
        } else {
            ((BaseQQAppInterface) peekAppRuntime).removeObserver(this.mVipStatusObserver);
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void parseCloudKeywordsJson() {
        if (VasNormalToggle.VAS_KEY_WORD_DELIST.isEnable(true)) {
            QLog.d(TAG, 1, "delist keywords config");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof BaseQQAppInterface)) {
            QLog.e(TAG, 1, "parseCloudKeywordsJson error, app is null!");
            return;
        }
        final BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        final int currentUserVipType = ((ISVIPHandler) baseQQAppInterface.getBusinessHandler(((ISVIPHandlerProxy) QRoute.api(ISVIPHandlerProxy.class)).getImplClassName())).getCurrentUserVipType();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "parseCloudKeywordsJson user vip type = " + currentUserVipType);
        }
        Handler handler = this.fileThreadHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.22
                /* JADX WARN: Removed duplicated region for block: B:106:0x010e A[Catch: all -> 0x013c, TRY_LEAVE, TryCatch #11 {all -> 0x013c, blocks: (B:104:0x0108, B:106:0x010e), top: B:103:0x0108 }] */
                /* JADX WARN: Removed duplicated region for block: B:110:0x0133 A[Catch: IOException -> 0x0137, TRY_ENTER, TRY_LEAVE, TryCatch #3 {IOException -> 0x0137, blocks: (B:73:0x0100, B:110:0x0133), top: B:2:0x0005 }] */
                /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:112:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:17:0x0073  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x007f A[Catch: all -> 0x0104, TryCatch #4 {all -> 0x0104, blocks: (B:14:0x003e, B:84:0x0054, B:18:0x0074, B:19:0x0079, B:21:0x007f, B:28:0x008c, B:29:0x008f, B:31:0x0095, B:34:0x009f, B:35:0x00a3, B:37:0x00a9, B:39:0x00af, B:41:0x00ba, B:44:0x00bd, B:46:0x00c1, B:24:0x00c6, B:49:0x00ca, B:51:0x00cf, B:67:0x00e8, B:69:0x00ee), top: B:13:0x003e }] */
                /* JADX WARN: Removed duplicated region for block: B:51:0x00cf A[Catch: all -> 0x0104, TRY_LEAVE, TryCatch #4 {all -> 0x0104, blocks: (B:14:0x003e, B:84:0x0054, B:18:0x0074, B:19:0x0079, B:21:0x007f, B:28:0x008c, B:29:0x008f, B:31:0x0095, B:34:0x009f, B:35:0x00a3, B:37:0x00a9, B:39:0x00af, B:41:0x00ba, B:44:0x00bd, B:46:0x00c1, B:24:0x00c6, B:49:0x00ca, B:51:0x00cf, B:67:0x00e8, B:69:0x00ee), top: B:13:0x003e }] */
                /* JADX WARN: Removed duplicated region for block: B:67:0x00e8 A[Catch: all -> 0x0104, TRY_ENTER, TryCatch #4 {all -> 0x0104, blocks: (B:14:0x003e, B:84:0x0054, B:18:0x0074, B:19:0x0079, B:21:0x007f, B:28:0x008c, B:29:0x008f, B:31:0x0095, B:34:0x009f, B:35:0x00a3, B:37:0x00a9, B:39:0x00af, B:41:0x00ba, B:44:0x00bd, B:46:0x00c1, B:24:0x00c6, B:49:0x00ca, B:51:0x00cf, B:67:0x00e8, B:69:0x00ee), top: B:13:0x003e }] */
                /* JADX WARN: Removed duplicated region for block: B:81:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    FileReader fileReader;
                    final HashMap hashMap;
                    JsonReader jsonReader;
                    JsonReader jSONFromLocalByStreamRead;
                    boolean z16;
                    JsonReader jsonReader2 = null;
                    try {
                        try {
                            if (QLog.isColorLevel()) {
                                QLog.d(EmoticonManagerServiceImpl.TAG, 2, "parseCloudKeywordsJson:");
                            }
                            hashMap = new HashMap();
                        } catch (Throwable th5) {
                            th = th5;
                            fileReader = null;
                        }
                        if (EmoticonManagerServiceImpl.this.mResConfig != null) {
                            String a16 = EmoticonManagerServiceImpl.this.mResConfig.a();
                            if (!TextUtils.isEmpty(a16) && new File(a16).exists()) {
                                fileReader = new FileReader(a16);
                                try {
                                    jsonReader = new JsonReader(fileReader);
                                    if (jsonReader != null) {
                                        try {
                                            jSONFromLocalByStreamRead = VasUpdateUtil.getJSONFromLocalByStreamRead(baseQQAppInterface, VasUpdateConstants.SCID_EMOJI_KEYWORD, true, null);
                                            if (jSONFromLocalByStreamRead == null) {
                                                QLog.d(EmoticonManagerServiceImpl.TAG, 1, "parseCloudKeywordsJson json file not");
                                                if (jSONFromLocalByStreamRead != null) {
                                                    try {
                                                        jSONFromLocalByStreamRead.close();
                                                    } catch (IOException e16) {
                                                        e16.printStackTrace();
                                                    }
                                                }
                                                if (fileReader != null) {
                                                    try {
                                                        fileReader.close();
                                                        return;
                                                    } catch (IOException e17) {
                                                        e17.printStackTrace();
                                                        return;
                                                    }
                                                }
                                                return;
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            jsonReader2 = jsonReader;
                                            try {
                                                if (QLog.isColorLevel()) {
                                                }
                                                if (jsonReader2 != null) {
                                                }
                                                if (fileReader == null) {
                                                }
                                            } finally {
                                            }
                                        }
                                    } else {
                                        jSONFromLocalByStreamRead = jsonReader;
                                    }
                                    jSONFromLocalByStreamRead.beginObject();
                                    z16 = false;
                                    while (jSONFromLocalByStreamRead.hasNext()) {
                                        if ("keywords".equals(jSONFromLocalByStreamRead.nextName())) {
                                            jSONFromLocalByStreamRead.beginObject();
                                            while (jSONFromLocalByStreamRead.hasNext()) {
                                                String nextName = jSONFromLocalByStreamRead.nextName();
                                                int i3 = currentUserVipType;
                                                if (i3 == 3) {
                                                    i3 = 2;
                                                }
                                                jSONFromLocalByStreamRead.beginArray();
                                                int i16 = 0;
                                                while (jSONFromLocalByStreamRead.hasNext()) {
                                                    int nextInt = jSONFromLocalByStreamRead.nextInt();
                                                    if (i16 == i3) {
                                                        hashMap.put(nextName.toLowerCase(), Integer.valueOf(nextInt));
                                                    }
                                                    i16++;
                                                }
                                                jSONFromLocalByStreamRead.endArray();
                                            }
                                            jSONFromLocalByStreamRead.endObject();
                                            z16 = true;
                                        } else {
                                            jSONFromLocalByStreamRead.skipValue();
                                        }
                                    }
                                    jSONFromLocalByStreamRead.endObject();
                                } catch (Throwable th7) {
                                    th = th7;
                                    if (QLog.isColorLevel()) {
                                        QLog.e(EmoticonManagerServiceImpl.TAG, 2, "parseCloudKeywordsJson error ,e = " + th.getMessage());
                                    }
                                    if (jsonReader2 != null) {
                                        try {
                                            jsonReader2.close();
                                        } catch (IOException e18) {
                                            e18.printStackTrace();
                                        }
                                    }
                                    if (fileReader == null) {
                                        fileReader.close();
                                        return;
                                    }
                                    return;
                                }
                                if (z16) {
                                    QLog.d(EmoticonManagerServiceImpl.TAG, 1, "parseCloudKeywordsJson json file keywords not exist");
                                    try {
                                        jSONFromLocalByStreamRead.close();
                                    } catch (IOException e19) {
                                        e19.printStackTrace();
                                    }
                                    if (fileReader != null) {
                                        try {
                                            fileReader.close();
                                            return;
                                        } catch (IOException e26) {
                                            e26.printStackTrace();
                                            return;
                                        }
                                    }
                                    return;
                                }
                                Handler handler2 = EmoticonManagerServiceImpl.this.uiHandler;
                                if (handler2 != null) {
                                    handler2.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.22.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            EmoticonManagerServiceImpl.this.hotWords = hashMap;
                                        }
                                    });
                                }
                                try {
                                    jSONFromLocalByStreamRead.close();
                                } catch (IOException e27) {
                                    e27.printStackTrace();
                                }
                                if (fileReader != null) {
                                    fileReader.close();
                                    return;
                                }
                                return;
                            }
                        }
                        jsonReader = null;
                        fileReader = null;
                        if (jsonReader != null) {
                        }
                        jSONFromLocalByStreamRead.beginObject();
                        z16 = false;
                        while (jSONFromLocalByStreamRead.hasNext()) {
                        }
                        jSONFromLocalByStreamRead.endObject();
                        if (z16) {
                        }
                    } catch (IOException e28) {
                        e28.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public byte[] parseIPSiteInfoToBytes(VipIPSiteInfo vipIPSiteInfo) {
        if (vipIPSiteInfo == null) {
            QLog.e(TAG, 1, "parseIPSiteInfoToBytes, error vipSiteInfo == null");
            return null;
        }
        Parcel obtain = Parcel.obtain();
        vipIPSiteInfo.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        return marshall;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void pushRecommendExposeInfoToSP() {
        pushFixRecommendExposeInfoToSP();
        pushNotFixRecommendExposeInfoToSP();
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public List<Emoticon> queryBigEmoticonsFromDB() {
        return this.f204149em.query(Emoticon.class, false, "jobType= ?", new String[]{"0"}, null, null, null, null);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void reconstructAllTabEmoticonPackage(List<String> list, int i3) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof BaseQQAppInterface)) {
            QLog.e(TAG, 1, "reconstructAllTabEmoticonPackage error, app is null!");
            return;
        }
        ((com.tencent.qqnt.emotion.api.IEmoticonManagerService) ((BaseQQAppInterface) peekAppRuntime).getRuntimeService(com.tencent.qqnt.emotion.api.IEmoticonManagerService.class)).reconstructAllTabEmoticonPackage(list, i3);
        int i16 = 0;
        if (i3 != 1) {
            this.tabCache.clear();
            int size = list.size();
            while (i16 < size) {
                String str = list.get(i16);
                if (!this.tabCache.contains(str)) {
                    this.tabCache.add(str);
                }
                i16++;
            }
        } else {
            this.kanDianTabCache.clear();
            int size2 = list.size();
            while (i16 < size2) {
                String str2 = list.get(i16);
                if (!this.kanDianTabCache.contains(str2)) {
                    this.kanDianTabCache.add(str2);
                }
                i16++;
            }
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.16
            @Override // java.lang.Runnable
            public void run() {
                synchronized (EmoticonManagerServiceImpl.this) {
                    EmoticonManagerServiceImpl.this.f204149em.drop(EmoticonTab.class.getSimpleName());
                    ArrayList arrayList = new ArrayList();
                    Iterator<String> it = EmoticonManagerServiceImpl.this.tabCache.iterator();
                    while (it.hasNext()) {
                        EmoticonManagerServiceImpl.this.insertOrUpdateEmoticonTab(arrayList, it.next(), true, false);
                    }
                    Iterator<String> it5 = EmoticonManagerServiceImpl.this.kanDianTabCache.iterator();
                    while (it5.hasNext()) {
                        EmoticonManagerServiceImpl.this.insertOrUpdateEmoticonTab(arrayList, it5.next(), false, true);
                    }
                    if (!arrayList.isEmpty() && !EmoticonManagerServiceImpl.this.f204149em.doMultiDBOperateByTransaction(arrayList)) {
                        QLog.i(EmoticonManagerServiceImpl.TAG, 1, "reconstructAllTabEmoticonPackage, FAIL");
                    }
                }
            }
        }, 32, null, true);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void reconstructEmoticonPackage(String str, List<Emoticon> list) {
        ArrayList arrayList = (ArrayList) syncGetSubEmoticonsByPackageId(str);
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Emoticon emoticon = (Emoticon) it.next();
                this.emoticonCache.g(emoticon.getMapKey());
                emoticon.setStatus(1001);
                arrayList2.add(new RemoveTransaction(emoticon));
                removeKeywordEmoticonCache(emoticon);
            }
            arrayList.clear();
            this.subEmoticonsCache.f(str, arrayList);
        }
        if (list != null && list.size() > 0) {
            this.subEmoticonsCache.f(str, list);
            for (Emoticon emoticon2 : list) {
                emoticon2.setStatus(1000);
                addEntityToTransaction(arrayList2, emoticon2);
                this.emoticonCache.f(emoticon2.getMapKey(), emoticon2);
            }
        }
        if (!arrayList2.isEmpty() && !this.f204149em.doMultiDBOperateByTransaction(arrayList2)) {
            QLog.i(TAG, 1, "reconstructEmoticonPackage FAIL");
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void recordRecommendEpExpose(PromotionEmoticonPkg promotionEmoticonPkg) {
        if (promotionEmoticonPkg != null && !TextUtils.isEmpty(promotionEmoticonPkg.f203111id)) {
            int recommendExposeNum = getRecommendExposeNum(promotionEmoticonPkg.f203111id, promotionEmoticonPkg.isFixedEmoticon);
            if (promotionEmoticonPkg.isFixedEmoticon) {
                this.fixRecommendExposeCount.put(promotionEmoticonPkg.f203111id, Integer.valueOf(recommendExposeNum + 1));
            } else {
                this.recommendExposeCount.put(promotionEmoticonPkg.f203111id, Integer.valueOf(recommendExposeNum + 1));
            }
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "recordRecommendEpExpose epid = " + promotionEmoticonPkg.f203111id + ";exposeNum = " + (recommendExposeNum + 1));
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public boolean removeEmoticonPackage(EmoticonPackage emoticonPackage) {
        emoticonPackage.setStatus(1001);
        this.f204149em.remove(emoticonPackage);
        this.pkgCache.g(emoticonPackage.epId);
        return true;
    }

    public void removeKeywordEmoticonsCache(String str) {
        List<Emoticon> syncGetSubEmoticonsByPackageId = syncGetSubEmoticonsByPackageId(str);
        if (syncGetSubEmoticonsByPackageId == null) {
            return;
        }
        synchronized (this.keywordEmoticonsCache) {
            for (Emoticon emoticon : syncGetSubEmoticonsByPackageId) {
                List<Emoticon> e16 = this.keywordEmoticonsCache.e(emoticon.name);
                if (e16 != null && e16.contains(emoticon)) {
                    e16.remove(emoticon);
                    this.keywordEmoticonsCache.f(emoticon.name, e16);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void removeTabEmoticonPackage(final String str, int i3) {
        final boolean z16;
        final boolean z17 = false;
        if (i3 != 1) {
            this.tabCache.remove(str);
            z16 = false;
            z17 = true;
        } else {
            this.kanDianTabCache.remove(str);
            z16 = true;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.15
            @Override // java.lang.Runnable
            public void run() {
                EmoticonTab emoticonTab = (EmoticonTab) DBMethodProxy.find(EmoticonManagerServiceImpl.this.f204149em, (Class<? extends Entity>) EmoticonTab.class, str);
                if (emoticonTab != null) {
                    if (z17) {
                        emoticonTab.aioHave = false;
                    }
                    if (z16) {
                        emoticonTab.kandianHave = false;
                    }
                    if (emoticonTab.aioHave || emoticonTab.kandianHave) {
                        EmoticonManagerServiceImpl.this.updateEntity(emoticonTab);
                    } else {
                        EmoticonManagerServiceImpl.this.f204149em.remove(emoticonTab);
                    }
                    EmoticonManagerServiceImpl.this.removeKeywordEmoticonsCache(str);
                    com.tencent.mobileqq.core.util.b.f(BaseApplication.getContext(), EmoticonManagerServiceImpl.this.mCurrentAccountUin, System.currentTimeMillis());
                    EmoticonManagerServiceImpl.this.saveTabCacheToMMKV();
                }
            }
        }, 5, null, true);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void reportSwitchSpeakerPhoneClick(ChatMessage chatMessage, p pVar, boolean z16) {
        if (chatMessage instanceof MessageForMarketFace) {
            MessageForMarketFace messageForMarketFace = (MessageForMarketFace) chatMessage;
            if (messageForMarketFace.isNewSoundType()) {
                asyncGetEmoticonInfo(messageForMarketFace.mMarkFaceMessage, new d(z16, pVar));
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void saveAndUpdateRecommendEmosInfo(final EmosmPb$SubCmd0x5RspBQRecommend emosmPb$SubCmd0x5RspBQRecommend, final int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "saveAndUpdateRecommendEmosInfo");
        }
        this.uiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.23
            @Override // java.lang.Runnable
            public void run() {
                EmosmPb$SubCmd0x5RspBQRecommend emosmPb$SubCmd0x5RspBQRecommend2 = emosmPb$SubCmd0x5RspBQRecommend;
                if (emosmPb$SubCmd0x5RspBQRecommend2 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(EmoticonManagerServiceImpl.TAG, 2, "recommendresp is null");
                        return;
                    }
                    return;
                }
                EmoticonManagerServiceImpl.this.recommendRspMap.put(i3, emosmPb$SubCmd0x5RspBQRecommend2);
                int i16 = emosmPb$SubCmd0x5RspBQRecommend.int32_exposure_num.get();
                if (i16 > 0) {
                    EmoticonManagerConstants.RECOMMEND_EXPOSE_MAX = i16;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d(EmoticonManagerServiceImpl.TAG, 4, "saveAndUpdateRecommendEmosInfo maxexposenum = " + EmoticonManagerConstants.RECOMMEND_EXPOSE_MAX);
                }
                List<EmosmPb$STRecommendTabInfo> list = emosmPb$SubCmd0x5RspBQRecommend.st_new_tab_info.get();
                if (list != null && QLog.isDevelopLevel()) {
                    QLog.d(EmoticonManagerServiceImpl.TAG, 4, "saveAndUpdateRecommendEmosInfo recommend emotion num = " + list.size());
                }
                EmoticonManagerServiceImpl.this.saveRecommendEpInfoFromCacheToFile();
            }
        });
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void saveEmoticon(final Emoticon emoticon) {
        if (emoticon == null) {
            return;
        }
        runInCurrentThread(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.7
            @Override // java.lang.Runnable
            public void run() {
                EmoticonManagerServiceImpl.this.updateEmoticonCache(emoticon);
                if (!EmoticonManagerServiceImpl.this.updateEntity(emoticon)) {
                    QLog.e(EmoticonManagerServiceImpl.TAG, 1, "saveEmoticon fail epId = " + emoticon.epId + ", eId = " + emoticon.eId);
                }
            }
        }, 8);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void saveEmoticonPackage(final EmoticonPackage emoticonPackage) {
        if (emoticonPackage != null) {
            this.pkgCache.f(emoticonPackage.epId, emoticonPackage);
            runInCurrentThread(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    if (!EmoticonManagerServiceImpl.this.updateEntity(emoticonPackage)) {
                        QLog.e(EmoticonManagerServiceImpl.TAG, 1, "saveEmoticonPackage fail epId = " + emoticonPackage.epId);
                    }
                }
            }, 8);
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void saveEmoticonPackageKeywordJson(String str, int i3, String str2, int i16, int i17) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "saveEmoticonPackageKeywordJson epId = " + str + " businessType = " + i17);
        }
        EmoticonPackage syncFindTabEmoticonPackageById = syncFindTabEmoticonPackageById(str, i17);
        if (syncFindTabEmoticonPackageById == null) {
            return;
        }
        syncFindTabEmoticonPackageById.jsonVersion = i3;
        saveEmoticonPackage(syncFindTabEmoticonPackageById);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, i3 + "==========KeywordJsonUpdate============" + str);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof BaseQQAppInterface)) {
            QLog.e(TAG, 1, "saveEmoticonPackageKeywordJson error, app is null!");
        } else {
            ((IEmojiManagerService) ((BaseQQAppInterface) peekAppRuntime).getRuntimeService(IEmojiManagerService.class)).startDownloadEmosmJson(syncFindTabEmoticonPackageById.epId, EmojiManagerServiceConstant.JSON_EMOSM_KEYWORD, i17);
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void saveEmoticonPackages(final List<EmoticonPackage> list) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof BaseQQAppInterface)) {
            QLog.e(TAG, 1, "saveEmoticonPackages error, app is null!");
            return;
        }
        ((com.tencent.qqnt.emotion.api.IEmoticonManagerService) ((BaseQQAppInterface) peekAppRuntime).getRuntimeService(com.tencent.qqnt.emotion.api.IEmoticonManagerService.class)).saveEmoticonPackages(list);
        if (list != null && !list.isEmpty()) {
            for (EmoticonPackage emoticonPackage : list) {
                if (emoticonPackage != null) {
                    this.pkgCache.f(emoticonPackage.epId, emoticonPackage);
                }
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList arrayList = new ArrayList();
                    for (EmoticonPackage emoticonPackage2 : list) {
                        if (emoticonPackage2 != null) {
                            EmoticonManagerServiceImpl.this.addEntityToTransaction(arrayList, emoticonPackage2);
                        }
                    }
                    if (!arrayList.isEmpty() && !EmoticonManagerServiceImpl.this.f204149em.doMultiDBOperateByTransaction(arrayList)) {
                        QLog.w(EmoticonManagerServiceImpl.TAG, 1, "saveEmoticonPackages, FAIL");
                    }
                }
            }, 32, null, true);
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void saveEmoticonPkgUpdateStatus(String str, int i3, String str2, int i16, int i17) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "saveEmoticonPkgUpdateStatus epId = " + str + " businessType = " + i17);
        }
        EmoticonPackage syncFindTabEmoticonPackageById = syncFindTabEmoticonPackageById(str, i17);
        if (syncFindTabEmoticonPackageById != null) {
            int i18 = syncFindTabEmoticonPackageById.latestVersion;
            syncFindTabEmoticonPackageById.updateFlag = i16;
            syncFindTabEmoticonPackageById.updateTip = str2;
            syncFindTabEmoticonPackageById.latestVersion = i3;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "epId=" + str + " localVersion=" + syncFindTabEmoticonPackageById.localVersion + " version=" + i3 + " updateFlag: " + i16 + " latestVersion= " + i18);
            }
            if (com.tencent.mobileqq.core.util.a.h(i16) && i18 < i3) {
                syncFindTabEmoticonPackageById.hasReadUpdatePage = false;
                saveEmoticonPackage(syncFindTabEmoticonPackageById);
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void saveEmoticons(final List<Emoticon> list) {
        if (list == null) {
            return;
        }
        runInCurrentThread(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.8
            @Override // java.lang.Runnable
            public void run() {
                HashSet updateEmotionsToDB = EmoticonManagerServiceImpl.this.updateEmotionsToDB(list);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    EmoticonManagerServiceImpl.this.updateEmoticonCache((Emoticon) it.next());
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (!(peekAppRuntime instanceof BaseQQAppInterface)) {
                    QLog.e(EmoticonManagerServiceImpl.TAG, 1, "saveEmoticons error, app is null!");
                    return;
                }
                BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
                StickerRecManagerImpl.get(baseQQAppInterface).syncAddLocalEmoticonKeywords(updateEmotionsToDB);
                ((IStickerRecManager) baseQQAppInterface.getRuntimeService(IStickerRecManager.class)).syncAddLocalEmoticonKeywords(updateEmotionsToDB);
            }
        }, 8);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void saveEmotionKeywordToDB() {
        Handler handler;
        if (this.needToDBEmotionKeyword.size() < 1) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveEmotionKeywordToDB");
        }
        final List<EmotionKeyword> list = this.needToDBEmotionKeyword;
        if (list.size() > 0 && (handler = this.dbThreadHandler) != null) {
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.20
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    ArrayList arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        EmoticonManagerServiceImpl.this.addEntityToTransaction(arrayList, (EmotionKeyword) it.next());
                    }
                    if (!EmoticonManagerServiceImpl.this.f204149em.doMultiDBOperateByTransaction(arrayList)) {
                        QLog.w(EmoticonManagerServiceImpl.TAG, 1, "saveEmotionKeywordToDB failed");
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(EmoticonManagerServiceImpl.TAG, 2, "saveRecentEmotionToDB_KeywordToDBTime: " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void saveRecentEmotionToDB() {
        Handler handler;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveRecentEmotionToDB start");
        }
        if (this.needToDBRecentEmotion.size() < 1) {
            return;
        }
        final ArrayList arrayList = new ArrayList(this.needToDBRecentEmotion);
        this.needToDBRecentEmotion.clear();
        if (arrayList.size() > 0 && (handler = this.dbThreadHandler) != null) {
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.19
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    ArrayList arrayList2 = new ArrayList();
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        RecentEmotion recentEmotion = (RecentEmotion) arrayList.get(size);
                        if (recentEmotion != null) {
                            String str = recentEmotion.epId;
                            String str2 = recentEmotion.eId;
                            String str3 = recentEmotion.keyword;
                            recentEmotion.toString();
                            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                                RecentEmotion recentEmotion2 = (RecentEmotion) EmoticonManagerServiceImpl.this.f204149em.doFindOperateByTransaction(new FindTransaction(RecentEmotion.class, "epId=? and eId=? and keyword=?", new String[]{str, str2, str3}));
                                if (recentEmotion2 != null) {
                                    arrayList2.add(new RemoveTransaction(recentEmotion2));
                                }
                                RecentEmotion recentEmotion3 = new RecentEmotion();
                                recentEmotion3.epId = str;
                                recentEmotion3.eId = str2;
                                recentEmotion3.keyword = str3;
                                recentEmotion3.exposeNum = recentEmotion.exposeNum;
                                recentEmotion3.setStatus(1000);
                                EmoticonManagerServiceImpl.this.addEntityToTransaction(arrayList2, recentEmotion3);
                            }
                        }
                    }
                    if (!arrayList2.isEmpty() && !EmoticonManagerServiceImpl.this.f204149em.doMultiDBOperateByTransaction(arrayList2)) {
                        QLog.e(EmoticonManagerServiceImpl.TAG, 2, "saveRecentEmotionToDB FAIL");
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(EmoticonManagerServiceImpl.TAG, 2, "saveRecentEmotionToDB_Time: " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                }
            });
        }
    }

    public void setHasReadUpdatePage(String str, Boolean bool, int i3) {
        EmoticonPackage syncFindTabEmoticonPackageById = syncFindTabEmoticonPackageById(str, i3);
        if (syncFindTabEmoticonPackageById != null && syncFindTabEmoticonPackageById.hasReadUpdatePage != bool.booleanValue()) {
            syncFindTabEmoticonPackageById.hasReadUpdatePage = bool.booleanValue();
            saveEmoticonPackage(syncFindTabEmoticonPackageById);
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void setRecommendEpRedFlag(String str, int i3) {
        EmosmPb$SubCmd0x5RspBQRecommend emosmPb$SubCmd0x5RspBQRecommend;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (i3 != 0) {
            if (i3 == 1 && this.recommendRspMap.indexOfKey(1) >= 0) {
                emosmPb$SubCmd0x5RspBQRecommend = this.recommendRspMap.get(i3);
            }
            emosmPb$SubCmd0x5RspBQRecommend = null;
        } else {
            if (this.recommendRspMap.indexOfKey(0) >= 0) {
                emosmPb$SubCmd0x5RspBQRecommend = this.recommendRspMap.get(i3);
            }
            emosmPb$SubCmd0x5RspBQRecommend = null;
        }
        if (emosmPb$SubCmd0x5RspBQRecommend == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setRecommendEpRedFlag epid = " + str);
        }
        List<EmosmPb$STRecommendTabInfo> list = emosmPb$SubCmd0x5RspBQRecommend.st_new_tab_info.get();
        if (list != null && list.size() > 0) {
            Iterator<EmosmPb$STRecommendTabInfo> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                EmosmPb$STRecommendTabInfo next = it.next();
                if (str.equals(String.valueOf(next.u32_tab_id.get()))) {
                    next.int32_red_point_flag.set(0);
                    break;
                }
            }
        }
        emosmPb$SubCmd0x5RspBQRecommend.st_new_tab_info.set(list);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void syncEmoticonPackageById(String str) {
        syncFindEmoticonPackageById(str);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public Emoticon syncFindEmoticonById(String str, String str2) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "syncFindEmoticonById epId = " + str + ", eId = " + str2);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Emoticon e16 = this.emoticonCache.e(str + "_" + str2);
            if (e16 == null && (e16 = (Emoticon) DBMethodProxy.find(this.f204149em, Emoticon.class, "epId=? and eId=?", new String[]{str, str2})) != null) {
                this.emoticonCache.f(e16.getMapKey(), e16);
            }
            return e16;
        }
        QLog.e(TAG, 1, "syncFindEmoticonById error epId = " + str + ",eId = " + str2);
        return null;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public EmoticonPackage syncFindEmoticonPackageById(String str) {
        return syncFindEmoticonPackageById(str, 0);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public EmoticonPackage syncFindEmoticonPackageInCache(String str, int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "syncFindEmoticonPackageInCache epId = " + str + ", type = " + i3);
        }
        EmoticonPackage e16 = this.pkgCache.e(str);
        if (e16 != null) {
            if (i3 == -1) {
                return e16;
            }
            if (i3 == 0) {
                if (!e16.aio) {
                    return null;
                }
                return e16;
            }
            if (i3 == 1 && !e16.kandian) {
                return null;
            }
            return e16;
        }
        return e16;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public EmoticonPackage syncFindTabEmoticonPackageById(String str) {
        return syncFindTabEmoticonPackageById(str, 0);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public List<Emoticon> syncGetEmoticonsByKeyword(String str, boolean z16) {
        if (str == null) {
            return null;
        }
        ArrayList<Emoticon> arrayList = (ArrayList) this.keywordEmoticonsCache.e(str);
        if (arrayList == null) {
            arrayList = queryEmoticonsByKeyWordFromDB(str);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "syncGetEmoticonsByKeyword from cache arrEmoticon.size:" + arrayList.size() + ",keyWord: " + aw.a(str));
        }
        if (z16 && arrayList != null && !arrayList.isEmpty()) {
            return (List) arrayList.clone();
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public List<Emoticon> syncGetSubEmoticonsByPackageId(String str) {
        return syncGetSubEmoticonsByPackageId(str, false);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public List<EmoticonPackage> syncGetTabEmoticonPackages() {
        return syncGetTabEmoticonPackages(0);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void syncIncreaseEmoticonExposeNum(IStickerRecEmoticon iStickerRecEmoticon) {
        Emoticon emoticon;
        if ((iStickerRecEmoticon instanceof l) && (emoticon = ((l) iStickerRecEmoticon).f179944b) != null) {
            List<Emoticon> e16 = this.keywordEmoticonsCache.e(emoticon.name);
            if (e16 == null) {
                emoticon.increaseExposeNum();
                this.emoticonCache.f(emoticon.getMapKey(), emoticon);
                this.f204149em.update(emoticon);
                return;
            }
            for (Emoticon emoticon2 : e16) {
                if (emoticon2 != null && emoticon.getMapKey().equals(emoticon2.getMapKey())) {
                    emoticon2.increaseExposeNum();
                    this.emoticonCache.f(emoticon2.getMapKey(), emoticon2);
                    this.f204149em.update(emoticon2);
                    return;
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void syncPcTabEmoticonPackage(final String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "syncPcTabEmoticonPackage epId = " + str + " businessType = " + i3);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof BaseQQAppInterface)) {
            QLog.e(TAG, 1, "syncPcTabEmoticonPackage error, app is null!");
            return;
        }
        ((com.tencent.qqnt.emotion.api.IEmoticonManagerService) ((BaseQQAppInterface) peekAppRuntime).getRuntimeService(com.tencent.qqnt.emotion.api.IEmoticonManagerService.class)).syncPcTabEmoticonPackage(str, i3);
        if (str == null) {
            return;
        }
        if (i3 != 1) {
            if (!this.tabCache.contains(str)) {
                this.tabCache.add(0, str);
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.13
                    @Override // java.lang.Runnable
                    public void run() {
                        EmoticonTab emoticonTab = (EmoticonTab) DBMethodProxy.find(EmoticonManagerServiceImpl.this.f204149em, (Class<? extends Entity>) EmoticonTab.class, str);
                        if (emoticonTab != null) {
                            emoticonTab.aioHave = true;
                        } else {
                            emoticonTab = new EmoticonTab();
                            emoticonTab.epId = str;
                            emoticonTab.aioHave = true;
                        }
                        EmoticonManagerServiceImpl.this.updateEntity(emoticonTab);
                    }
                }, 5, null, true);
                return;
            }
            return;
        }
        if (!this.kanDianTabCache.contains(str)) {
            this.kanDianTabCache.add(0, str);
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.12
                @Override // java.lang.Runnable
                public void run() {
                    EmoticonTab emoticonTab = (EmoticonTab) DBMethodProxy.find(EmoticonManagerServiceImpl.this.f204149em, (Class<? extends Entity>) EmoticonTab.class, str);
                    if (emoticonTab != null) {
                        emoticonTab.kandianHave = true;
                    } else {
                        emoticonTab = new EmoticonTab();
                        emoticonTab.epId = str;
                        emoticonTab.kandianHave = true;
                    }
                    EmoticonManagerServiceImpl.this.updateEntity(emoticonTab);
                }
            }, 5, null, true);
        }
    }

    protected void updateEmoticonOrder(EmoticonResp emoticonResp, int i3, boolean z16, List<EmoticonPackage> list) {
        List<String> list2;
        if (list.size() > 0 && emoticonResp.tabOrderList.size() == 0) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "handleFetchEmoticonPackagesResp, svr data wrong, no order list, but allEpList.size()=" + list.size());
            }
            list2 = new ArrayList<>();
            for (int size = emoticonResp.data.size() - 1; size >= 0; size--) {
                EmoticonPackage emoticonPackage = (EmoticonPackage) emoticonResp.data.get(size);
                if (emoticonPackage != null) {
                    list2.add(emoticonPackage.epId);
                }
            }
            for (int size2 = emoticonResp.magicData.size() - 1; size2 >= 0; size2--) {
                EmoticonPackage emoticonPackage2 = emoticonResp.magicData.get(size2);
                if (emoticonPackage2 != null) {
                    list2.add(emoticonPackage2.epId);
                }
            }
            for (int size3 = emoticonResp.smallEmoticonData.size() - 1; size3 >= 0; size3--) {
                EmoticonPackage emoticonPackage3 = emoticonResp.smallEmoticonData.get(size3);
                if (emoticonPackage3 != null) {
                    list2.add(emoticonPackage3.epId);
                }
            }
        } else {
            list2 = emoticonResp.tabOrderList;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateEmoticonOrder, save order, orderList=" + list2 + ",dataChanged: " + z16);
        }
        reconstructAllTabEmoticonPackage(list2, i3);
        if (z16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.e(TAG, 1, "updateEmoticonOrder error, app is null!");
            } else {
                com.tencent.mobileqq.core.util.b.f(peekAppRuntime.getApp(), peekAppRuntime.getCurrentUin(), System.currentTimeMillis());
            }
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void updateKeywordReqTime(EmoticonKeywords emoticonKeywords) {
        if (emoticonKeywords == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateKeywordReqTime, emoticonKeywords = " + emoticonKeywords);
        }
        String lowerCase = emoticonKeywords.keyword.toLowerCase();
        EmoticonKeywords emoticonKeywords2 = this.keywordReqTimeInfo.get(lowerCase);
        if (emoticonKeywords2 != null) {
            emoticonKeywords2.lastReqTime = emoticonKeywords.lastReqTime;
            updateKeywordReqTimeToDB(emoticonKeywords2);
        } else {
            this.keywordReqTimeInfo.put(lowerCase, emoticonKeywords);
            updateKeywordReqTimeToDB(emoticonKeywords);
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void updateNtCommonTabEmojiInfoList(List<CommonTabEmojiInfo> list) {
        updateNtCommonTabEmojiInfoList(list, true);
    }

    private PromotionEmoticonPkg getRecommendPkg(EmosmPb$STRecommendTabInfo emosmPb$STRecommendTabInfo, List<EmoticonPackage> list, boolean z16, int i3) {
        int recommendExposeNum;
        if (emosmPb$STRecommendTabInfo == null) {
            return null;
        }
        String valueOf = String.valueOf(emosmPb$STRecommendTabInfo.u32_tab_id.get());
        if (i3 == 0 && (recommendExposeNum = getRecommendExposeNum(valueOf, z16)) >= EmoticonManagerConstants.RECOMMEND_EXPOSE_MAX) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "getProEmoticonPkgs exposeNum > max ; epId = " + valueOf + ",isFixEmoticon = " + z16 + ", exposeNum = " + recommendExposeNum);
            }
            return null;
        }
        if (list != null && list.size() > 0) {
            for (int i16 = 0; i16 < list.size(); i16++) {
                if (list.get(i16).epId.equals(valueOf)) {
                    return null;
                }
            }
        }
        PromotionEmoticonPkg promotionEmoticonPkg = new PromotionEmoticonPkg();
        promotionEmoticonPkg.f203111id = valueOf;
        promotionEmoticonPkg.pkgDesc = emosmPb$STRecommendTabInfo.str_tab_name.get();
        promotionEmoticonPkg.type = emosmPb$STRecommendTabInfo.i32_tab_type.get();
        promotionEmoticonPkg.feeType = emosmPb$STRecommendTabInfo.i32_feetype.get();
        promotionEmoticonPkg.imgUrl = emosmPb$STRecommendTabInfo.str_thumb_nail_url.get();
        promotionEmoticonPkg.titleColor = emosmPb$STRecommendTabInfo.str_title_color.get();
        promotionEmoticonPkg.bgColor = emosmPb$STRecommendTabInfo.str_bg_color.get();
        promotionEmoticonPkg.price = emosmPb$STRecommendTabInfo.i32_price.get();
        promotionEmoticonPkg.recommendType = emosmPb$STRecommendTabInfo.i32_recommend_mode.get();
        promotionEmoticonPkg.redpointFlag = emosmPb$STRecommendTabInfo.int32_red_point_flag.get();
        promotionEmoticonPkg.detailUrl = emosmPb$STRecommendTabInfo.str_button_url.get();
        String qqStr = HardCodeUtil.qqStr(R.string.f209355f7);
        int i17 = promotionEmoticonPkg.feeType;
        if (i17 == 6) {
            qqStr = HardCodeUtil.qqStr(R.string.m6p);
        } else if (i17 == 1) {
            qqStr = HardCodeUtil.qqStr(R.string.m7u);
        } else if (i17 == 4) {
            qqStr = b8.a.f28043VIP;
        } else if (i17 == 5) {
            qqStr = "SVIP";
        } else if (i17 == 2) {
            int i18 = promotionEmoticonPkg.price;
            if (i18 == PromotionEmoticonPkg.PAY_LIMIT_FREE) {
                qqStr = HardCodeUtil.qqStr(R.string.m6v);
            } else if (i18 == PromotionEmoticonPkg.PAY_1_YUAN) {
                qqStr = "\uffe51.00";
            } else if (i18 == PromotionEmoticonPkg.PAY_6_YUAN) {
                qqStr = "\uffe56.00";
            }
        }
        promotionEmoticonPkg.btnDesc = qqStr;
        promotionEmoticonPkg.isFixedEmoticon = z16;
        int i19 = promotionEmoticonPkg.type;
        if (i19 == PromotionEmoticonPkg.SMALL) {
            promotionEmoticonPkg.type = 4;
        } else if (i19 == PromotionEmoticonPkg.MAGIC) {
            promotionEmoticonPkg.type = 3;
        } else if (i19 != PromotionEmoticonPkg.GIF && i19 != PromotionEmoticonPkg.PNG) {
            if (i19 == PromotionEmoticonPkg.H5MAGIC) {
                promotionEmoticonPkg.type = 5;
            }
        } else {
            promotionEmoticonPkg.type = 0;
        }
        return promotionEmoticonPkg;
    }

    private void updateNtCommonTabEmojiInfoList(List<CommonTabEmojiInfo> list, boolean z16) {
        boolean z17;
        if (list == null || list.size() < 0) {
            return;
        }
        Iterator<CommonTabEmojiInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z17 = false;
                break;
            } else if (it.next().bottomEmojitabType == 6) {
                z17 = true;
                break;
            }
        }
        if (z17) {
            this.ntCommonTabEmojiInfoList.clear();
            this.ntCommonTabEmojiInfoList.addAll(list);
        } else {
            ArrayList arrayList = new ArrayList(EmoticonTabNtUtils.INSTANCE.getDefaultNTOfficialTabEmojiInfoList());
            arrayList.addAll(list);
            this.ntCommonTabEmojiInfoList.clear();
            this.ntCommonTabEmojiInfoList.addAll(arrayList);
        }
        if (z16) {
            saveTabCacheToMMKV();
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void asyncFindEmoticonPackage(String str, int i3, QueryCallback<EmoticonPackage> queryCallback) {
        new QueryTask(new g(), queryCallback).execute(new Pair(str, Integer.valueOf(i3)));
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public void asyncFindTabEmoticonPackageById(String str, int i3, QueryCallback<EmoticonPackage> queryCallback) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "asyncFindTabEmoticonPackageById epId = " + str + " businessType = " + i3);
        }
        new QueryTask(new c(), queryCallback).execute(new Pair(str, Integer.valueOf(i3)));
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public EmoticonPackage syncFindEmoticonPackageById(String str, int i3) {
        EmoticonPackage e16 = this.pkgCache.e(str);
        if (e16 == null && (e16 = (EmoticonPackage) DBMethodProxy.find(this.f204149em, (Class<? extends Entity>) EmoticonPackage.class, str)) != null) {
            this.pkgCache.f(str, e16);
        }
        if (e16 == null || i3 == -1) {
            return e16;
        }
        if (i3 == 0) {
            if (e16.aio) {
                return e16;
            }
            return null;
        }
        if (i3 != 1 || e16.kandian) {
            return e16;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public EmoticonPackage syncFindTabEmoticonPackageById(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "syncFindTabEmoticonPackageById epId = " + str + " businessType = " + i3);
        }
        if (str == null) {
            return null;
        }
        if (i3 != 1) {
            if (this.tabCache.contains(str)) {
                return syncFindEmoticonPackageById(str, i3);
            }
        } else if (this.kanDianTabCache.contains(str)) {
            return syncFindEmoticonPackageById(str, i3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public PicEmoticonInfo syncGetEmoticonInfo(MarkFaceMessage markFaceMessage) {
        String a16;
        if (markFaceMessage == null || (a16 = com.tencent.mobileqq.emosm.e.a(markFaceMessage.sbufID, markFaceMessage.mediaType)) == null) {
            return null;
        }
        String valueOf = String.valueOf(markFaceMessage.dwTabID);
        int i3 = markFaceMessage.imageWidth;
        int i16 = markFaceMessage.imageHeight;
        Emoticon syncFindEmoticonById = syncFindEmoticonById(valueOf, a16);
        if (syncFindEmoticonById != null) {
            PicEmoticonInfo picEmoticonInfo = new PicEmoticonInfo(this.mCurrentAccountUin);
            picEmoticonInfo.type = 6;
            picEmoticonInfo.emoticon = syncFindEmoticonById;
            picEmoticonInfo.isAPNG = markFaceMessage.isAPNG;
            byte[] bArr = markFaceMessage.sbfKey;
            if (bArr != null && bArr.length > 0) {
                syncFindEmoticonById.encryptKey = new String(bArr);
            } else {
                syncFindEmoticonById.encryptKey = "";
            }
            if (syncFindEmoticonById.width == 0) {
                syncFindEmoticonById.width = i3;
            }
            if (syncFindEmoticonById.height == 0) {
                syncFindEmoticonById.height = i16;
            }
            byte[] bArr2 = markFaceMessage.mobileparam;
            if (bArr2 != null && bArr2.length > 0) {
                syncFindEmoticonById.jobType = 2;
                syncFindEmoticonById.magicValue = new String(bArr2);
            }
            if (markFaceMessage.mediaType == 3) {
                syncFindEmoticonById.jobType = 4;
            }
            if (syncFindEmoticonById.parseSoundPrintString() == null || syncFindEmoticonById.parseSoundPrintString().isEmpty()) {
                syncFindEmoticonById.voicePrintItems = markFaceMessage.voicePrintItems;
                syncFindEmoticonById.voicePrint = syncFindEmoticonById.toSoundPrintString();
            }
            if (TextUtils.isEmpty(syncFindEmoticonById.backColor)) {
                syncFindEmoticonById.backColor = markFaceMessage.backColor;
            }
            if (TextUtils.isEmpty(syncFindEmoticonById.volumeColor)) {
                syncFindEmoticonById.volumeColor = markFaceMessage.volumeColor;
            }
            picEmoticonInfo.imageType = markFaceMessage.cSubType;
            addExtensionSizeByScreenSize(valueOf, syncFindEmoticonById, markFaceMessage.resvAttr);
            return picEmoticonInfo;
        }
        PicEmoticonInfo picEmoticonInfo2 = new PicEmoticonInfo(this.mCurrentAccountUin);
        picEmoticonInfo2.type = 6;
        picEmoticonInfo2.isAPNG = markFaceMessage.isAPNG;
        Emoticon emoticon = new Emoticon();
        int i17 = markFaceMessage.mediaType;
        if (i17 == 1) {
            emoticon.isSound = true;
        } else if (i17 == 2) {
            emoticon.jobType = 1;
        } else if (i17 == 3) {
            emoticon.jobType = 4;
        }
        byte[] bArr3 = markFaceMessage.mobileparam;
        if (bArr3 != null && bArr3.length > 0) {
            emoticon.jobType = 2;
            emoticon.magicValue = new String(bArr3);
        }
        emoticon.epId = valueOf;
        emoticon.eId = a16;
        byte[] bArr4 = markFaceMessage.sbfKey;
        if (bArr4 != null && bArr4.length > 0) {
            emoticon.encryptKey = new String(bArr4);
        } else {
            emoticon.encryptKey = "";
        }
        emoticon.width = i3;
        emoticon.height = i16;
        emoticon.name = markFaceMessage.faceName;
        emoticon.volumeColor = markFaceMessage.volumeColor;
        emoticon.backColor = markFaceMessage.backColor;
        emoticon.voicePrintItems = markFaceMessage.voicePrintItems;
        emoticon.voicePrint = emoticon.toSoundPrintString();
        picEmoticonInfo2.emoticon = emoticon;
        picEmoticonInfo2.imageType = markFaceMessage.cSubType;
        addExtensionSizeByScreenSize(null, emoticon, markFaceMessage.resvAttr);
        return picEmoticonInfo2;
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public List<Emoticon> syncGetSubEmoticonsByPackageId(String str, boolean z16) {
        if (str == null) {
            return null;
        }
        ArrayList<Emoticon> arrayList = (ArrayList) this.subEmoticonsCache.e(str);
        if (arrayList == null) {
            arrayList = queryEmoticonsByPackageIdFromDB(str);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "syncGetSubEmoticonsByPackageId from cache subEmoticonsCache.size:" + this.subEmoticonsCache.h() + ",epId:" + str);
        }
        return (arrayList == null || !z16) ? arrayList : (List) arrayList.clone();
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonManagerService
    public List<EmoticonPackage> syncGetTabEmoticonPackages(int i3) {
        EmoticonPackage syncFindEmoticonPackageById;
        EmoticonPackage syncFindEmoticonPackageById2;
        ArrayList arrayList = new ArrayList();
        if (i3 != 1) {
            for (String str : this.tabCache) {
                if (str != null && (syncFindEmoticonPackageById2 = syncFindEmoticonPackageById(str, i3)) != null) {
                    arrayList.add(syncFindEmoticonPackageById2);
                }
            }
        } else {
            for (String str2 : this.kanDianTabCache) {
                if (str2 != null && (syncFindEmoticonPackageById = syncFindEmoticonPackageById(str2, i3)) != null) {
                    arrayList.add(syncFindEmoticonPackageById);
                }
            }
        }
        return arrayList;
    }

    private void writeRecommendInfoFromFileToCache() {
        writeRecommendInfoFromFileToCache(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveRecommendEpInfoFromCacheToFile() {
        saveRecommendEpInfoFromCacheToFile(0);
    }
}
