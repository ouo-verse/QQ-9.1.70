package com.tencent.mobileqq.mini.entry.newdesktop.repository;

import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.RecommendAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppRedDotEntity;
import com.tencent.mobileqq.mini.entry.MiniAppSettingSwitchInfoEntity;
import com.tencent.mobileqq.mini.entry.desktop.item.DeskTopAppEntity;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopSearchInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.bean.PositionItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartHost;
import com.tencent.mobileqq.mini.entry.newdesktop.repository.MiniAppDesktopLocalDataHelper;
import com.tencent.mobileqq.mini.utils.MiniAppMMKVUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Regex;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u000223B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\u0018\u0010\u001e\u001a\u00020\u001b2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0002J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u001bH\u0002J\u000e\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(J\b\u0010)\u001a\u00020\u001bH\u0002J\b\u0010*\u001a\u00020\u001bH\u0002J\u0012\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eH\u0002J\u0016\u0010/\u001a\u00020\u001b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u001e\u00100\u001a\u00020\u001b2\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0017j\b\u0012\u0004\u0012\u00020\u0013`\u0018R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R6\u0010\u000b\u001a*\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\fj\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e`\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\r0\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0017j\b\u0012\u0004\u0012\u00020\u0013`\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/MiniAppDesktopLocalDataHelper;", "", "()V", "entity", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "getEntity", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "setEntity", "(Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;)V", "hasPullSearchData", "", "mMiniAppUIDataMap", "Ljava/util/HashMap;", "", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "Lkotlin/collections/HashMap;", "mPushRedDotMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "mRecommendExposureList", "Lcom/tencent/mobileqq/mini/apkg/RecommendAppInfo;", "mRecommendListFixAppIdSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "mRedDataState", "addDefaultRecommendData", "", "checkRedDotSwitch", "deleteErrorSpFile", "deleteOldEntity", "entityList", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DeskTopAppEntity;", "getMiniAppInfoFromDbAndSp", "app", "Lcom/tencent/common/app/AppInterface;", "getpskey", "initLocalDesktopData", "localDataCallback", "Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/MiniAppDesktopLocalDataHelper$MiniAppLocalDataCallback;", "initLocalRedDotAppData", "initMiniAppLocalData", "isFixApp", "miniAppInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "parseRecommendExposureFromSp", "resetMiniAppInfoToMap", "setRecommendListFixAppIdSet", "fixAppSet", "Companion", "MiniAppLocalDataCallback", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppDesktopLocalDataHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DESKTOP_APP_NAME = "mini_app_desktop";
    private static final String MMKV_KEY_RECOMMEND_EXPOSURE = "desktop_app_recommend_exposure";
    private static final String SP_DIRECTORY = "/data/data/com.tencent.mobileqq/shared_prefs/";
    private static final String TAG = "MiniAppDesktopLocalDataManager";
    private static MiniAppDesktopLocalDataHelper mInstance;
    private MMKVOptionEntity entity;
    private volatile boolean hasPullSearchData;
    private volatile int mRedDataState = -1;
    private final HashMap<Integer, List<DesktopItemInfo>> mMiniAppUIDataMap = new HashMap<>();
    private final HashSet<String> mRecommendListFixAppIdSet = new HashSet<>();
    private List<RecommendAppInfo> mRecommendExposureList = new ArrayList();
    private final ConcurrentHashMap<String, Integer> mPushRedDotMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/MiniAppDesktopLocalDataHelper$Companion;", "", "()V", "DESKTOP_APP_NAME", "", "MMKV_KEY_RECOMMEND_EXPOSURE", "SP_DIRECTORY", "TAG", "mInstance", "Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/MiniAppDesktopLocalDataHelper;", "getInstance", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MiniAppDesktopLocalDataHelper getInstance() {
            if (MiniAppDesktopLocalDataHelper.mInstance == null) {
                MiniAppDesktopLocalDataHelper.mInstance = new MiniAppDesktopLocalDataHelper();
            }
            MiniAppDesktopLocalDataHelper miniAppDesktopLocalDataHelper = MiniAppDesktopLocalDataHelper.mInstance;
            Intrinsics.checkNotNull(miniAppDesktopLocalDataHelper, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.repository.MiniAppDesktopLocalDataHelper");
            return miniAppDesktopLocalDataHelper;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J8\u0010\u0006\u001a\u00020\u00032.\u0010\u0007\u001a*\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bj\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n`\fH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/MiniAppDesktopLocalDataHelper$MiniAppLocalDataCallback;", "", "getLocalDataFailed", "", "errorMsg", "", "getLocalDataSuccess", "miniAppUIDataMap", "Ljava/util/HashMap;", "", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "Lkotlin/collections/HashMap;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public interface MiniAppLocalDataCallback {
        void getLocalDataFailed(String errorMsg);

        void getLocalDataSuccess(HashMap<Integer, List<DesktopItemInfo>> miniAppUIDataMap);
    }

    public MiniAppDesktopLocalDataHelper() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP)");
        this.entity = from;
    }

    private final void addDefaultRecommendData() {
        try {
            String config = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_DROP_DOWN_DEFAULT_RECOMMEND_APPS, QzoneConfig.DEFAULT_DROP_DOWN_DEFAULT_RECOMMEND_APPS);
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = new JSONArray(config);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                MiniAppInfo from = MiniAppInfo.from((INTERFACE$StApiAppInfo) INTERFACE$StApiAppInfo.class.cast(GdtJsonPbUtil.pbFromJson(new INTERFACE$StApiAppInfo(), jSONArray.optJSONObject(i3))));
                DesktopAppInfo desktopAppInfo = new DesktopAppInfo(2, from);
                desktopAppInfo.fromBackup = 1;
                arrayList.add(desktopAppInfo);
                String str = from.name;
            }
            if ((!arrayList.isEmpty()) && this.mMiniAppUIDataMap.isEmpty()) {
                this.mMiniAppUIDataMap.put(2, arrayList);
            }
            QLog.e(TAG, 1, "useLocalDataIfRequestFailed, backupList size: " + arrayList.size());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "useLocalDataIfRequestFailed, exception: " + Log.getStackTraceString(e16));
        }
    }

    private final void checkRedDotSwitch() {
        if (!MiniAppConfProcessor.o()) {
            QLog.i(TAG, 1, "needShowSettingButton is false!");
            return;
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime().getEntityManagerFactory() != null && MobileQQ.sMobileQQ.peekAppRuntime().getEntityManagerFactory().createEntityManager() != null) {
            List<? extends Entity> query = MobileQQ.sMobileQQ.peekAppRuntime().getEntityManagerFactory().createEntityManager().query(MiniAppSettingSwitchInfoEntity.class, MiniAppSettingSwitchInfoEntity.class.getSimpleName(), false, "key = ?", new String[]{"redDot"}, (String) null, (String) null, (String) null, (String) null);
            if (query != null && !query.isEmpty()) {
                Entity entity = query.get(0);
                Intrinsics.checkNotNull(entity, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.MiniAppSettingSwitchInfoEntity");
                MiniAppSettingSwitchInfoEntity miniAppSettingSwitchInfoEntity = (MiniAppSettingSwitchInfoEntity) entity;
                if (Intrinsics.areEqual("redDot", miniAppSettingSwitchInfoEntity.key)) {
                    this.mRedDataState = miniAppSettingSwitchInfoEntity.value;
                    Bundle bundle = new Bundle();
                    bundle.putInt(miniAppSettingSwitchInfoEntity.key, miniAppSettingSwitchInfoEntity.value);
                    bundle.putBoolean("refreshUI", false);
                    BaseApplicationImpl.getApplication().getRuntime().notifyObservers(MiniAppDesktopPartHost.class, 102, true, bundle);
                    QLog.e(TAG, 1, "initLocalDataRunnable, redDot switch: " + this.mRedDataState);
                    return;
                }
                return;
            }
            QLog.i(TAG, 1, "tempList  is null or empty!");
            return;
        }
        QLog.i(TAG, 1, "entityManagerFactory createEntityManager is null!");
    }

    private final void deleteErrorSpFile() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.repository.g
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppDesktopLocalDataHelper.deleteErrorSpFile$lambda$8();
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteErrorSpFile$lambda$8() {
        String account = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
        if (TextUtils.isEmpty(account)) {
            return;
        }
        String str = SP_DIRECTORY + account + "_mini_app_recommend_exposure.xml";
        if (FileUtils.deleteFile(str) && QLog.isColorLevel()) {
            QLog.d(TAG, 2, "delete : " + str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<DesktopItemInfo> getMiniAppInfoFromDbAndSp(AppInterface app) {
        DesktopItemInfo desktopItemInfo;
        EntityManager createEntityManager = app.getEntityManagerFactory().createEntityManager();
        ArrayList arrayList = new ArrayList();
        if (createEntityManager == null) {
            QLog.i(TAG, 1, "entityManager is null!");
            return arrayList;
        }
        List<? extends Entity> query = createEntityManager.query(DeskTopAppEntity.class, DeskTopAppEntity.class.getSimpleName(), false, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
        if (query == null) {
            QLog.i(TAG, 1, "tempList is null!");
            return arrayList;
        }
        List<PositionItemInfo> miniAppPositionInMmkv = new DesktopLocalMmkvRepository().getMiniAppPositionInMmkv();
        StringBuilder sb5 = new StringBuilder();
        int size = query.size();
        HashMap hashMap = new HashMap();
        for (DeskTopAppEntity deskTopAppEntity : TypeIntrinsics.asMutableList(query)) {
            if (!TextUtils.isEmpty(deskTopAppEntity.appId)) {
                String str = deskTopAppEntity.appId;
                Intrinsics.checkNotNullExpressionValue(str, "it.appId");
                hashMap.put(str, deskTopAppEntity);
            }
        }
        Iterator<? extends Entity> it = query.iterator();
        while (it.hasNext()) {
            DeskTopAppEntity deskTopAppEntity2 = (DeskTopAppEntity) it.next();
            if (!TextUtils.isEmpty(deskTopAppEntity2.appId)) {
                String str2 = deskTopAppEntity2.appId;
                Intrinsics.checkNotNullExpressionValue(str2, "entity.appId");
                hashMap.put(str2, deskTopAppEntity2);
            }
        }
        for (PositionItemInfo positionItemInfo : miniAppPositionInMmkv) {
            if (!TextUtils.isEmpty(positionItemInfo.getAppId())) {
                DeskTopAppEntity deskTopAppEntity3 = (DeskTopAppEntity) hashMap.get(positionItemInfo.getAppId());
                MiniAppInfo createAppInfoFromBuffer = (deskTopAppEntity3 != null ? deskTopAppEntity3.appInfo : null) != null ? deskTopAppEntity3.createAppInfoFromBuffer(deskTopAppEntity3.appInfo) : null;
                if (createAppInfoFromBuffer != null) {
                    TypeIntrinsics.asMutableCollection(query).remove(deskTopAppEntity3);
                    if (positionItemInfo.getModuleType() == 15) {
                        desktopItemInfo = new DesktopSearchInfo(createAppInfoFromBuffer, new ArrayList(), 15);
                        desktopItemInfo.deleteEnable = false;
                        desktopItemInfo.dragEnable = false;
                        desktopItemInfo.dropEnable = false;
                        this.hasPullSearchData = true;
                    } else {
                        DesktopItemInfo desktopAppInfo = new DesktopAppInfo(positionItemInfo.getModuleType(), createAppInfoFromBuffer);
                        if (isFixApp(createAppInfoFromBuffer)) {
                            desktopAppInfo.setIsFixApp(true);
                            desktopAppInfo.deleteEnable = false;
                            desktopAppInfo.dragEnable = false;
                            desktopAppInfo.dropEnable = false;
                        }
                        desktopItemInfo = desktopAppInfo;
                    }
                    arrayList.add(desktopItemInfo);
                    sb5.append(createAppInfoFromBuffer.name);
                    sb5.append(":");
                    sb5.append(createAppInfoFromBuffer.appId);
                    sb5.append(", ");
                } else {
                    QLog.w(TAG, 1, "createAppInfoFromBuffer null, from: " + positionItemInfo.getAppId());
                }
            } else if (!TextUtils.isEmpty(positionItemInfo.getModuleTitle()) && positionItemInfo.getModuleType() != 6) {
                arrayList.add(new DesktopAppModuleInfo(positionItemInfo.getModuleType(), positionItemInfo.getModuleTitle()));
            }
        }
        QLog.i(TAG, 1, "query, before size=" + size + ", after size = " + query.size() + ", DB cache app List = [" + ((Object) sb5) + "]");
        StringBuilder sb6 = new StringBuilder();
        sb6.append("getMiniAppInfoFromDbAndSp, itemInfoList:");
        sb6.append(arrayList);
        QLog.i(TAG, 1, sb6.toString());
        if (!query.isEmpty()) {
            deleteOldEntity(query);
        }
        return arrayList;
    }

    private final void getpskey() {
        List emptyList;
        String pskeyDomain = MiniAppConfProcessor.g(QzoneConfig.SECONDARY_KEY_MINI_APP_GET_PSKEY_DOMAIN, "qzone.qq.com");
        Intrinsics.checkNotNullExpressionValue(pskeyDomain, "pskeyDomain");
        if (pskeyDomain.length() == 0) {
            QLog.i(TAG, 1, "getPskeyDomain : " + pskeyDomain);
            return;
        }
        List<String> split = new Regex(",").split(pskeyDomain, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (!(listIterator.previous().length() == 0)) {
                    emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Object[] array = emptyList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        if (strArr.length == 0) {
            QLog.i(TAG, 1, "domains is empty!");
            return;
        }
        IRuntimeService runtimeService = BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IPskeyManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "getApplication().runtime\u2026va, ProcessConstant.MAIN)");
        ((IPskeyManager) runtimeService).getPskey(strArr, new sd2.a() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.repository.MiniAppDesktopLocalDataHelper$getpskey$1
            @Override // sd2.a
            public void onFail(String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QLog.e("MiniAppDesktopLocalDataManager", 1, "getPskey Failed," + errMsg);
            }

            @Override // sd2.a
            public void onSuccess(Map<String, String> domainToKeyMap) {
                Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
                StringBuilder sb5 = new StringBuilder();
                Iterator<T> it = domainToKeyMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    QLog.i("MiniAppDesktopLocalDataManager", 1, "getpskey key:" + entry.getKey() + " value: " + entry.getValue());
                    sb5.append((String) entry.getKey());
                    sb5.append(MsgSummary.STR_COLON);
                    sb5.append(((String) entry.getValue()).subSequence(0, 2));
                    sb5.append(APLogFileUtil.SEPARATOR_LOG);
                }
                QLog.i("MiniAppDesktopLocalDataManager", 1, "getPskey onSuccess result = " + ((Object) sb5));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLocalDesktopData$lambda$1(final MiniAppDesktopLocalDataHelper this$0, final MiniAppLocalDataCallback localDataCallback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(localDataCallback, "$localDataCallback");
        try {
            this$0.initMiniAppLocalData();
            this$0.initLocalRedDotAppData();
            this$0.getpskey();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
            BaseBusinessHandler businessHandler = qQAppInterface != null ? qQAppInterface.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER) : null;
            AppletsHandler appletsHandler = businessHandler instanceof AppletsHandler ? (AppletsHandler) businessHandler : null;
            if (appletsHandler != null) {
                appletsHandler.R2();
            }
            this$0.addDefaultRecommendData();
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.repository.h
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppDesktopLocalDataHelper.initLocalDesktopData$lambda$1$lambda$0(MiniAppDesktopLocalDataHelper.MiniAppLocalDataCallback.this, this$0);
                }
            });
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "initLocalDataRunnable error,", th5);
            localDataCallback.getLocalDataFailed(th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLocalDesktopData$lambda$1$lambda$0(MiniAppLocalDataCallback localDataCallback, MiniAppDesktopLocalDataHelper this$0) {
        Intrinsics.checkNotNullParameter(localDataCallback, "$localDataCallback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        localDataCallback.getLocalDataSuccess(this$0.mMiniAppUIDataMap);
    }

    private final void initLocalRedDotAppData() {
        List<? extends Entity> query = MobileQQ.sMobileQQ.peekAppRuntime().getEntityManagerFactory().createEntityManager().query(MiniAppRedDotEntity.class, MiniAppRedDotEntity.class.getSimpleName(), false, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
        if (query != null && !query.isEmpty()) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                MiniAppRedDotEntity miniAppRedDotEntity = (MiniAppRedDotEntity) it.next();
                if (!TextUtils.isEmpty(miniAppRedDotEntity.appId)) {
                    ConcurrentHashMap<String, Integer> concurrentHashMap = this.mPushRedDotMap;
                    String str = miniAppRedDotEntity.appId;
                    Intrinsics.checkNotNullExpressionValue(str, "data.appId");
                    concurrentHashMap.put(str, Integer.valueOf(miniAppRedDotEntity.wnsPushRedDotNum));
                }
            }
            checkRedDotSwitch();
            return;
        }
        QLog.i(TAG, 1, "redDotDataList is null or empty!");
    }

    private final void initMiniAppLocalData() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        resetMiniAppInfoToMap(getMiniAppInfoFromDbAndSp((QQAppInterface) peekAppRuntime));
        this.mRecommendExposureList.clear();
        this.mRecommendExposureList = parseRecommendExposureFromSp();
    }

    private final List<RecommendAppInfo> parseRecommendExposureFromSp() {
        List emptyList;
        List emptyList2;
        ArrayList arrayList = new ArrayList();
        try {
            String string = MiniAppMMKVUtils.getString(MMKV_KEY_RECOMMEND_EXPOSURE, null);
            if (string != null) {
                List<String> split = new Regex(";").split(string, 0);
                if (!split.isEmpty()) {
                    ListIterator<String> listIterator = split.listIterator(split.size());
                    while (listIterator.hasPrevious()) {
                        if (!(listIterator.previous().length() == 0)) {
                            emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                Object[] array = emptyList.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                if (!(strArr.length == 0)) {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            List<String> split2 = new Regex("_").split(str, 0);
                            if (!split2.isEmpty()) {
                                ListIterator<String> listIterator2 = split2.listIterator(split2.size());
                                while (listIterator2.hasPrevious()) {
                                    if (!(listIterator2.previous().length() == 0)) {
                                        emptyList2 = CollectionsKt___CollectionsKt.take(split2, listIterator2.nextIndex() + 1);
                                        break;
                                    }
                                }
                            }
                            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                            Object[] array2 = emptyList2.toArray(new String[0]);
                            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                            String[] strArr2 = (String[]) array2;
                            if (strArr2.length == 3) {
                                arrayList.add(new RecommendAppInfo(strArr2[0], Integer.parseInt(strArr2[1]), Long.parseLong(strArr2[2])));
                            }
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "parseRecommendExposureFromSp error.", th5);
            MiniAppMMKVUtils.removeValue(MMKV_KEY_RECOMMEND_EXPOSURE);
        }
        return arrayList;
    }

    private final void resetMiniAppInfoToMap(List<DesktopItemInfo> miniAppInfo) {
        List<DesktopItemInfo> mutableList;
        List<DesktopItemInfo> mutableList2;
        List<DesktopItemInfo> mutableList3;
        List<DesktopItemInfo> mutableList4;
        int coerceAtMost;
        List<DesktopItemInfo> mutableList5;
        if (miniAppInfo.isEmpty()) {
            QLog.i(TAG, 1, "miniAppInfo is empty!");
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (DesktopItemInfo desktopItemInfo : miniAppInfo) {
            int i3 = desktopItemInfo.mModuleType;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 14) {
                            arrayList2.add(desktopItemInfo);
                        }
                    } else if (desktopItemInfo instanceof DesktopAppInfo) {
                        arrayList4.add(desktopItemInfo);
                    } else if (desktopItemInfo instanceof DesktopAppModuleInfo) {
                        arrayList.add(desktopItemInfo);
                    }
                } else if (desktopItemInfo instanceof DesktopAppInfo) {
                    arrayList5.add(desktopItemInfo);
                }
            } else if (desktopItemInfo instanceof DesktopAppInfo) {
                arrayList3.add(desktopItemInfo);
            } else if (desktopItemInfo instanceof DesktopAppModuleInfo) {
                arrayList.add(desktopItemInfo);
            }
        }
        HashMap<Integer, List<DesktopItemInfo>> hashMap = this.mMiniAppUIDataMap;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        hashMap.put(16, mutableList);
        HashMap<Integer, List<DesktopItemInfo>> hashMap2 = this.mMiniAppUIDataMap;
        mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        hashMap2.put(14, mutableList2);
        HashMap<Integer, List<DesktopItemInfo>> hashMap3 = this.mMiniAppUIDataMap;
        mutableList3 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList3);
        hashMap3.put(1, mutableList3);
        HashMap<Integer, List<DesktopItemInfo>> hashMap4 = this.mMiniAppUIDataMap;
        mutableList4 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList4);
        hashMap4.put(3, mutableList4);
        HashMap<Integer, List<DesktopItemInfo>> hashMap5 = this.mMiniAppUIDataMap;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(10, arrayList5.size());
        mutableList5 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList5.subList(0, coerceAtMost));
        hashMap5.put(2, mutableList5);
    }

    public final MMKVOptionEntity getEntity() {
        return this.entity;
    }

    public final void initLocalDesktopData(final MiniAppLocalDataCallback localDataCallback) {
        Intrinsics.checkNotNullParameter(localDataCallback, "localDataCallback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.repository.i
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppDesktopLocalDataHelper.initLocalDesktopData$lambda$1(MiniAppDesktopLocalDataHelper.this, localDataCallback);
            }
        }, 32, null, false);
        deleteErrorSpFile();
    }

    public final void setEntity(MMKVOptionEntity mMKVOptionEntity) {
        Intrinsics.checkNotNullParameter(mMKVOptionEntity, "<set-?>");
        this.entity = mMKVOptionEntity;
    }

    public final void setRecommendListFixAppIdSet(HashSet<String> fixAppSet) {
        Intrinsics.checkNotNullParameter(fixAppSet, "fixAppSet");
        this.mRecommendListFixAppIdSet.clear();
        this.mRecommendListFixAppIdSet.addAll(fixAppSet);
    }

    private final void deleteOldEntity(List<? extends DeskTopAppEntity> entityList) {
        List<? extends DeskTopAppEntity> list = entityList;
        if (list == null || list.isEmpty()) {
            QLog.i(TAG, 1, "entityList is null or empty!");
            return;
        }
        EntityManager createEntityManager = MobileQQ.sMobileQQ.peekAppRuntime().getEntityManagerFactory().createEntityManager();
        if (createEntityManager == null) {
            QLog.i(TAG, 1, "entityManager is null!");
            return;
        }
        try {
            StringBuilder sb5 = new StringBuilder();
            int size = entityList.size();
            for (int i3 = 0; i3 < size; i3++) {
                DeskTopAppEntity deskTopAppEntity = entityList.get(i3);
                deskTopAppEntity.setStatus(1001);
                if (createEntityManager.remove(deskTopAppEntity, "uniqueId=?", new String[]{deskTopAppEntity.uniqueId})) {
                    sb5.append(deskTopAppEntity.name);
                    sb5.append("_0, ");
                } else {
                    sb5.append(deskTopAppEntity.name);
                    sb5.append("_1, ");
                }
            }
            QLog.e(TAG, 2, "deleteOldEntity, " + ((Object) sb5));
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "deleteOldEntity, Exception: " + Log.getStackTraceString(th5));
        }
    }

    private final boolean isFixApp(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null || TextUtils.isEmpty(miniAppInfo.appId)) {
            return false;
        }
        if (miniAppInfo.isSpecialMiniApp()) {
            return true;
        }
        return this.mRecommendListFixAppIdSet.contains(miniAppInfo.appId);
    }
}
