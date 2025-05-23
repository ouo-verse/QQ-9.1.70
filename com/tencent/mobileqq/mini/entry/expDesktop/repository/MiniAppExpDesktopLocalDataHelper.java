package com.tencent.mobileqq.mini.entry.expDesktop.repository;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.TagInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppEntityV3;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopRankSubTabAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopRankTabAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.repository.MiniAppExpDesktopLocalDataHelper;
import com.tencent.mobileqq.mini.entry.newdesktop.bean.PositionItemInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Regex;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0002J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eJ\u0018\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u0014H\u0002J\u0080\u0001\u0010$\u001a\u00020\u00142\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020&0\u000ej\b\u0012\u0004\u0012\u00020&`\u00102\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020&0\u000ej\b\u0012\u0004\u0012\u00020&`\u00102\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020&0\u000ej\b\u0012\u0004\u0012\u00020&`\u00102\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020&0\u000ej\b\u0012\u0004\u0012\u00020&`\u00102\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020&0\u000ej\b\u0012\u0004\u0012\u00020&`\u0010H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u000ej\b\u0012\u0004\u0012\u00020\u0012`\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/MiniAppExpDesktopLocalDataHelper;", "", "()V", "entity", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "getEntity", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "setEntity", "(Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;)V", "mPersonalModuleMap", "", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "mRankModules", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopRankTabAppInfo;", "Lkotlin/collections/ArrayList;", "mRecommendModules", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopGroupAppInfo;", "deleteErrorSpFile", "", "deleteOldEntity", "entityList", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppEntityV3;", "getMiniAppInfoFromDbAndSp", "", "getpskey", "initLocalDesktopData", "localDataCallback", "Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/MiniAppExpDesktopLocalDataHelper$MiniAppLocalDataCallback;", "resetDataByModuleType", "moduleType", "appInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "setLocalMiniAppInfo", "setLocalMiniAppInfoToList", "recentMiniApp", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "mineMiniApp", "dailyRecommendMiniApp", "friendPlayingMiniApp", "gameRecommendRankMiniApp", "Companion", "MiniAppLocalDataCallback", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopLocalDataHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DAILY_RECOMMEND_MINIAPP_SUB_PAGE_VIA = "3401_4_level2";
    private static final String DAILY_RECOMMEND_MINIAPP_VIA = "3401_4";
    private static final String FRIEND_PLAYING_MINIAPP_SUB_PAGE_VIA = "3401_5_level2";
    private static final String FRIEND_PLAYING_MINIAPP_VIA = "3401_5";
    private static final String MINE_MINIAPP_HOST_SCENE = "20001002";
    private static final String MINE_MINIAPP_SUB_PAGE_HOST_SCENE = "20003001";
    private static final String MINE_MINIAPP_SUB_PAGE_VIA = "3401_2_level2";
    private static final String MINE_MINIAPP_VIA = "3401_2";
    private static final String RANK_GAME_NEW_MINIAPP_SUB_PAGE_VIA = "3401_9_level2";
    private static final String RANK_GAME_NEW_MINIAPP_VIA = "3401_9";
    private static final String RANK_GAME_PLAY_MINIAPP_SUB_PAGE_VIA = "3401_8_level2";
    private static final String RANK_GAME_PLAY_MINIAPP_VIA = "3401_8";
    private static final String RANK_GAME_RECOMMEND_MINIAPP_SUB_PAGE_VIA = "3401_6_level2";
    private static final String RANK_GAME_RECOMMEND_MINIAPP_VIA = "3401_6";
    private static final String RANK_GAME_SELL_MINIAPP_SUB_PAGE_VIA = "3401_7_level2";
    private static final String RANK_GAME_SELL_MINIAPP_VIA = "3401_7";
    private static final String RECENT_PLAY_MINIAPP_HOST_SCENE = "20001001";
    private static final String RECENT_PLAY_MINIAPP_SUB_PAGE_HOST_SCENE = "20002001";
    private static final String RECENT_PLAY_MINIAPP_SUB_PAGE_VIA = "3401_1_level2";
    private static final String RECENT_PLAY_MINIAPP_VIA = "3401_1";
    private static final String SP_DIRECTORY = "/data/data/com.tencent.mobileqq/shared_prefs/";
    private static final String TAG = "MiniAppExpDesktopLocalDataHelper";
    private static MiniAppExpDesktopLocalDataHelper mInstance;
    private MMKVOptionEntity entity;
    private Map<Integer, DesktopItemInfo> mPersonalModuleMap;
    private ArrayList<ExpDesktopRankTabAppInfo> mRankModules;
    private ArrayList<ExpDesktopGroupAppInfo> mRecommendModules;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/MiniAppExpDesktopLocalDataHelper$Companion;", "", "()V", "DAILY_RECOMMEND_MINIAPP_SUB_PAGE_VIA", "", "DAILY_RECOMMEND_MINIAPP_VIA", "FRIEND_PLAYING_MINIAPP_SUB_PAGE_VIA", "FRIEND_PLAYING_MINIAPP_VIA", "MINE_MINIAPP_HOST_SCENE", "MINE_MINIAPP_SUB_PAGE_HOST_SCENE", "MINE_MINIAPP_SUB_PAGE_VIA", "MINE_MINIAPP_VIA", "RANK_GAME_NEW_MINIAPP_SUB_PAGE_VIA", "RANK_GAME_NEW_MINIAPP_VIA", "RANK_GAME_PLAY_MINIAPP_SUB_PAGE_VIA", "RANK_GAME_PLAY_MINIAPP_VIA", "RANK_GAME_RECOMMEND_MINIAPP_SUB_PAGE_VIA", "RANK_GAME_RECOMMEND_MINIAPP_VIA", "RANK_GAME_SELL_MINIAPP_SUB_PAGE_VIA", "RANK_GAME_SELL_MINIAPP_VIA", "RECENT_PLAY_MINIAPP_HOST_SCENE", "RECENT_PLAY_MINIAPP_SUB_PAGE_HOST_SCENE", "RECENT_PLAY_MINIAPP_SUB_PAGE_VIA", "RECENT_PLAY_MINIAPP_VIA", "SP_DIRECTORY", "TAG", "mInstance", "Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/MiniAppExpDesktopLocalDataHelper;", "getInstance", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MiniAppExpDesktopLocalDataHelper getInstance() {
            if (MiniAppExpDesktopLocalDataHelper.mInstance == null) {
                MiniAppExpDesktopLocalDataHelper.mInstance = new MiniAppExpDesktopLocalDataHelper();
            }
            MiniAppExpDesktopLocalDataHelper miniAppExpDesktopLocalDataHelper = MiniAppExpDesktopLocalDataHelper.mInstance;
            Intrinsics.checkNotNull(miniAppExpDesktopLocalDataHelper, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.repository.MiniAppExpDesktopLocalDataHelper");
            return miniAppExpDesktopLocalDataHelper;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J8\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/MiniAppExpDesktopLocalDataHelper$MiniAppLocalDataCallback;", "", "getLocalDataFailed", "", "errorMsg", "", "getLocalDataSuccess", "personalModuleMap", "", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "recommendModules", "", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopGroupAppInfo;", "rankModules", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopRankTabAppInfo;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public interface MiniAppLocalDataCallback {
        void getLocalDataFailed(String errorMsg);

        void getLocalDataSuccess(Map<Integer, DesktopItemInfo> personalModuleMap, List<ExpDesktopGroupAppInfo> recommendModules, List<ExpDesktopRankTabAppInfo> rankModules);
    }

    public MiniAppExpDesktopLocalDataHelper() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP)");
        this.entity = from;
        this.mPersonalModuleMap = new LinkedHashMap();
        this.mRecommendModules = new ArrayList<>();
        this.mRankModules = new ArrayList<>();
    }

    private final void deleteErrorSpFile() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.repository.i
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppExpDesktopLocalDataHelper.deleteErrorSpFile$lambda$10();
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteErrorSpFile$lambda$10() {
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
    private final List<DesktopItemInfo> getMiniAppInfoFromDbAndSp() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        EntityManager createEntityManager = ((QQAppInterface) peekAppRuntime).getEntityManagerFactory().createEntityManager();
        ArrayList arrayList = new ArrayList();
        if (createEntityManager == null) {
            QLog.i(TAG, 1, "entityManager is null!");
            return arrayList;
        }
        List<? extends Entity> query = createEntityManager.query(DesktopAppEntityV3.class, DesktopAppEntityV3.class.getSimpleName(), false, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
        if (query == null) {
            QLog.i(TAG, 1, "tempList is null!");
            return arrayList;
        }
        List<PositionItemInfo> miniAppPositionInMmkv = new ExpDesktopLocalMmkvRepository().getMiniAppPositionInMmkv();
        StringBuilder sb5 = new StringBuilder();
        int size = query.size();
        HashMap hashMap = new HashMap();
        for (DesktopAppEntityV3 desktopAppEntityV3 : TypeIntrinsics.asMutableList(query)) {
            if (!TextUtils.isEmpty(desktopAppEntityV3.appId)) {
                String str = desktopAppEntityV3.appId;
                Intrinsics.checkNotNullExpressionValue(str, "it.appId");
                hashMap.put(str, desktopAppEntityV3);
            }
        }
        Iterator<? extends Entity> it = query.iterator();
        while (it.hasNext()) {
            DesktopAppEntityV3 desktopAppEntityV32 = (DesktopAppEntityV3) it.next();
            if (!TextUtils.isEmpty(desktopAppEntityV32.appId)) {
                String str2 = desktopAppEntityV32.appId;
                Intrinsics.checkNotNullExpressionValue(str2, "entity.appId");
                hashMap.put(str2, desktopAppEntityV32);
            }
        }
        for (PositionItemInfo positionItemInfo : miniAppPositionInMmkv) {
            if (!TextUtils.isEmpty(positionItemInfo.getAppId())) {
                DesktopAppEntityV3 desktopAppEntityV33 = (DesktopAppEntityV3) hashMap.get(positionItemInfo.getAppId());
                MiniAppInfo createAppInfoFromBuffer = (desktopAppEntityV33 != null ? desktopAppEntityV33.appInfo : null) != null ? desktopAppEntityV33.createAppInfoFromBuffer(desktopAppEntityV33.appInfo) : null;
                if (createAppInfoFromBuffer != null) {
                    TypeIntrinsics.asMutableCollection(query).remove(desktopAppEntityV33);
                    MiniAppInfo newMiniAppInfo = MiniAppInfo.copy(createAppInfoFromBuffer);
                    int moduleType = positionItemInfo.getModuleType();
                    Intrinsics.checkNotNullExpressionValue(newMiniAppInfo, "newMiniAppInfo");
                    resetDataByModuleType(moduleType, newMiniAppInfo);
                    arrayList.add(new DesktopAppInfo(positionItemInfo.getModuleType(), newMiniAppInfo));
                    sb5.append(createAppInfoFromBuffer.name);
                    sb5.append(":");
                    sb5.append(createAppInfoFromBuffer.appId);
                    sb5.append(", ");
                }
            }
        }
        QLog.i(TAG, 1, "query, before size=" + size + ", after size = " + query.size() + ", DB cache app List = [" + ((Object) sb5) + "]");
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
        ((IPskeyManager) runtimeService).getPskey(strArr, new sd2.a() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.repository.MiniAppExpDesktopLocalDataHelper$getpskey$1
            @Override // sd2.a
            public void onFail(String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QLog.e("MiniAppExpDesktopLocalDataHelper", 1, "getPskey Failed," + errMsg);
            }

            @Override // sd2.a
            public void onSuccess(Map<String, String> domainToKeyMap) {
                Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
                StringBuilder sb5 = new StringBuilder();
                Iterator<T> it = domainToKeyMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    QLog.i("MiniAppExpDesktopLocalDataHelper", 1, "getpskey key:" + entry.getKey() + " value: " + entry.getValue());
                    sb5.append((String) entry.getKey());
                    sb5.append(MsgSummary.STR_COLON);
                    sb5.append(((String) entry.getValue()).subSequence(0, 2));
                    sb5.append(APLogFileUtil.SEPARATOR_LOG);
                }
                QLog.i("MiniAppExpDesktopLocalDataHelper", 1, "getPskey onSuccess result = " + ((Object) sb5));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLocalDesktopData$lambda$1(final MiniAppExpDesktopLocalDataHelper this$0, final MiniAppLocalDataCallback localDataCallback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(localDataCallback, "$localDataCallback");
        try {
            this$0.setLocalMiniAppInfo();
            this$0.getpskey();
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.repository.j
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppExpDesktopLocalDataHelper.initLocalDesktopData$lambda$1$lambda$0(MiniAppExpDesktopLocalDataHelper.MiniAppLocalDataCallback.this, this$0);
                }
            });
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "initLocalDataRunnable error,", th5);
            localDataCallback.getLocalDataFailed(th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLocalDesktopData$lambda$1$lambda$0(MiniAppLocalDataCallback localDataCallback, MiniAppExpDesktopLocalDataHelper this$0) {
        Intrinsics.checkNotNullParameter(localDataCallback, "$localDataCallback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        localDataCallback.getLocalDataSuccess(this$0.mPersonalModuleMap, this$0.mRecommendModules, this$0.mRankModules);
    }

    private final void resetDataByModuleType(int moduleType, MiniAppInfo appInfo) {
        TagInfo tagInfo = appInfo.moduleTagMap.get(Integer.valueOf(moduleType));
        if (tagInfo != null) {
            appInfo.tagInfo = tagInfo;
        }
        String str = appInfo.moduleViaMap.get(Integer.valueOf(moduleType));
        if (str != null) {
            appInfo.via = str;
        }
        String str2 = appInfo.moduleReportDataMap.get(Integer.valueOf(moduleType));
        if (str2 != null) {
            appInfo.reportData = str2;
        }
        Integer num = appInfo.moduleTianShuAdIdMap.get(Integer.valueOf(moduleType));
        if (num != null) {
            appInfo.tianshuAdId = num.intValue();
        }
    }

    public final MMKVOptionEntity getEntity() {
        return this.entity;
    }

    public final void initLocalDesktopData(final MiniAppLocalDataCallback localDataCallback) {
        Intrinsics.checkNotNullParameter(localDataCallback, "localDataCallback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.repository.h
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppExpDesktopLocalDataHelper.initLocalDesktopData$lambda$1(MiniAppExpDesktopLocalDataHelper.this, localDataCallback);
            }
        }, 32, null, false);
        deleteErrorSpFile();
    }

    public final void setEntity(MMKVOptionEntity mMKVOptionEntity) {
        Intrinsics.checkNotNullParameter(mMKVOptionEntity, "<set-?>");
        this.entity = mMKVOptionEntity;
    }

    private final void deleteOldEntity(List<? extends DesktopAppEntityV3> entityList) {
        List<? extends DesktopAppEntityV3> list = entityList;
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
                DesktopAppEntityV3 desktopAppEntityV3 = entityList.get(i3);
                desktopAppEntityV3.setStatus(1001);
                if (createEntityManager.remove(desktopAppEntityV3, "uniqueId=?", new String[]{desktopAppEntityV3.uniqueId})) {
                    sb5.append(desktopAppEntityV3.name);
                    sb5.append("_0, ");
                } else {
                    sb5.append(desktopAppEntityV3.name);
                    sb5.append("_1, ");
                }
            }
            QLog.e(TAG, 2, "deleteOldEntity, " + ((Object) sb5));
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "deleteOldEntity, Exception: " + Log.getStackTraceString(th5));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setLocalMiniAppInfo() {
        ArrayList arrayListOf;
        ArrayList arrayListOf2;
        ArrayList arrayListOf3;
        ArrayList arrayListOf4;
        this.mPersonalModuleMap.clear();
        this.mRecommendModules.clear();
        this.mRankModules.clear();
        Map<Integer, DesktopItemInfo> map = this.mPersonalModuleMap;
        String string = BaseApplicationImpl.getApplication().getString(R.string.f169847xy0);
        Intrinsics.checkNotNullExpressionValue(string, "getApplication().getStri\u2026tring.min_app_recent_use)");
        ArrayList arrayList = new ArrayList();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(RECENT_PLAY_MINIAPP_VIA, RECENT_PLAY_MINIAPP_SUB_PAGE_VIA);
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf("20001001", "20002001");
        boolean z16 = false;
        int i3 = 32;
        DefaultConstructorMarker defaultConstructorMarker = null;
        map.put(1, new ExpDesktopGroupAppInfo(string, 1, arrayList, arrayListOf, arrayListOf2, z16, i3, defaultConstructorMarker));
        Map<Integer, DesktopItemInfo> map2 = this.mPersonalModuleMap;
        String string2 = BaseApplicationImpl.getApplication().getString(R.string.xxt);
        Intrinsics.checkNotNullExpressionValue(string2, "getApplication().getStri\u2026string.min_app_mine_play)");
        ArrayList arrayList2 = new ArrayList();
        arrayListOf3 = CollectionsKt__CollectionsKt.arrayListOf(MINE_MINIAPP_VIA, MINE_MINIAPP_SUB_PAGE_VIA);
        arrayListOf4 = CollectionsKt__CollectionsKt.arrayListOf("20001002", "20003001");
        map2.put(3, new ExpDesktopGroupAppInfo(string2, 3, arrayList2, arrayListOf3, arrayListOf4, z16, i3, defaultConstructorMarker));
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        List<DesktopItemInfo> miniAppInfoFromDbAndSp = getMiniAppInfoFromDbAndSp();
        if (!miniAppInfoFromDbAndSp.isEmpty()) {
            for (DesktopItemInfo desktopItemInfo : miniAppInfoFromDbAndSp) {
                if (QLog.isDevelopLevel() && (desktopItemInfo instanceof DesktopAppInfo)) {
                    int i16 = desktopItemInfo.mModuleType;
                    MiniAppInfo miniAppInfo = ((DesktopAppInfo) desktopItemInfo).mMiniAppInfo;
                    QLog.i(TAG, 4, "mModuleType:" + i16 + ": name:" + miniAppInfo.name + ": reportData:" + miniAppInfo.reportData);
                }
                boolean z17 = desktopItemInfo instanceof DesktopAppInfo;
                if (z17 && desktopItemInfo.mModuleType == 1) {
                    arrayList3.add(desktopItemInfo);
                } else if (z17 && desktopItemInfo.mModuleType == 3) {
                    arrayList4.add(desktopItemInfo);
                } else if (z17 && desktopItemInfo.mModuleType == 23) {
                    arrayList5.add(desktopItemInfo);
                } else if (z17 && desktopItemInfo.mModuleType == 17) {
                    arrayList6.add(desktopItemInfo);
                } else if (z17 && desktopItemInfo.mModuleType == 18) {
                    arrayList7.add(desktopItemInfo);
                }
            }
        }
        setLocalMiniAppInfoToList(arrayList3, arrayList4, arrayList5, arrayList6, arrayList7);
    }

    private final void setLocalMiniAppInfoToList(ArrayList<DesktopAppInfo> recentMiniApp, ArrayList<DesktopAppInfo> mineMiniApp, ArrayList<DesktopAppInfo> dailyRecommendMiniApp, ArrayList<DesktopAppInfo> friendPlayingMiniApp, ArrayList<DesktopAppInfo> gameRecommendRankMiniApp) {
        ArrayList arrayListOf;
        ArrayList arrayListOf2;
        ArrayList arrayListOf3;
        ArrayList arrayListOf4;
        ArrayList arrayListOf5;
        ArrayList arrayListOf6;
        ArrayList arrayListOf7;
        if (!recentMiniApp.isEmpty()) {
            DesktopItemInfo desktopItemInfo = this.mPersonalModuleMap.get(1);
            Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
            ((ExpDesktopGroupAppInfo) desktopItemInfo).getGroupAppInfo().addAll(recentMiniApp);
        }
        if (!mineMiniApp.isEmpty()) {
            DesktopItemInfo desktopItemInfo2 = this.mPersonalModuleMap.get(3);
            Intrinsics.checkNotNull(desktopItemInfo2, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
            ((ExpDesktopGroupAppInfo) desktopItemInfo2).getGroupAppInfo().addAll(mineMiniApp);
        }
        if (!dailyRecommendMiniApp.isEmpty()) {
            String string = BaseApplicationImpl.getApplication().getString(R.string.f169849xy2);
            Intrinsics.checkNotNullExpressionValue(string, "getApplication().getStri\u2026string.min_app_today_use)");
            arrayListOf7 = CollectionsKt__CollectionsKt.arrayListOf(DAILY_RECOMMEND_MINIAPP_VIA, DAILY_RECOMMEND_MINIAPP_SUB_PAGE_VIA);
            this.mRecommendModules.add(new ExpDesktopGroupAppInfo(string, 23, dailyRecommendMiniApp, arrayListOf7, null, false, 48, null));
        }
        if (!friendPlayingMiniApp.isEmpty()) {
            String string2 = BaseApplicationImpl.getApplication().getString(R.string.xxs);
            Intrinsics.checkNotNullExpressionValue(string2, "getApplication().getStri\u2026g.min_app_friend_playing)");
            arrayListOf6 = CollectionsKt__CollectionsKt.arrayListOf(FRIEND_PLAYING_MINIAPP_VIA, FRIEND_PLAYING_MINIAPP_SUB_PAGE_VIA);
            this.mRecommendModules.add(new ExpDesktopGroupAppInfo(string2, 17, friendPlayingMiniApp, arrayListOf6, null, false, 48, null));
        }
        if (!gameRecommendRankMiniApp.isEmpty()) {
            String string3 = BaseApplicationImpl.getApplication().getString(R.string.f169848xy1);
            Intrinsics.checkNotNullExpressionValue(string3, "getApplication().getStri\u2026g.min_app_recommend_list)");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(RANK_GAME_RECOMMEND_MINIAPP_VIA, RANK_GAME_RECOMMEND_MINIAPP_SUB_PAGE_VIA);
            ArrayList arrayList = null;
            boolean z16 = false;
            int i3 = 48;
            DefaultConstructorMarker defaultConstructorMarker = null;
            ExpDesktopRankSubTabAppInfo expDesktopRankSubTabAppInfo = new ExpDesktopRankSubTabAppInfo(string3, 18, gameRecommendRankMiniApp, arrayListOf, arrayList, z16, i3, defaultConstructorMarker);
            String string4 = BaseApplicationImpl.getApplication().getString(R.string.xxu);
            Intrinsics.checkNotNullExpressionValue(string4, "getApplication().getStri\u2026ng.min_app_more_bug_list)");
            ArrayList arrayList2 = new ArrayList();
            arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(RANK_GAME_SELL_MINIAPP_VIA, RANK_GAME_SELL_MINIAPP_SUB_PAGE_VIA);
            ExpDesktopRankSubTabAppInfo expDesktopRankSubTabAppInfo2 = new ExpDesktopRankSubTabAppInfo(string4, 19, arrayList2, arrayListOf2, null, false, 48, null);
            String string5 = BaseApplicationImpl.getApplication().getString(R.string.xxy);
            Intrinsics.checkNotNullExpressionValue(string5, "getApplication().getStri\u2026string.min_app_play_list)");
            ArrayList arrayList3 = new ArrayList();
            arrayListOf3 = CollectionsKt__CollectionsKt.arrayListOf(RANK_GAME_PLAY_MINIAPP_VIA, RANK_GAME_PLAY_MINIAPP_SUB_PAGE_VIA);
            ExpDesktopRankSubTabAppInfo expDesktopRankSubTabAppInfo3 = new ExpDesktopRankSubTabAppInfo(string5, 20, arrayList3, arrayListOf3, arrayList, z16, i3, defaultConstructorMarker);
            String string6 = BaseApplicationImpl.getApplication().getString(R.string.xxv);
            Intrinsics.checkNotNullExpressionValue(string6, "getApplication().getStri\u2026ng.min_app_new_game_list)");
            ArrayList arrayList4 = new ArrayList();
            arrayListOf4 = CollectionsKt__CollectionsKt.arrayListOf(RANK_GAME_NEW_MINIAPP_VIA, RANK_GAME_NEW_MINIAPP_SUB_PAGE_VIA);
            ExpDesktopRankSubTabAppInfo expDesktopRankSubTabAppInfo4 = new ExpDesktopRankSubTabAppInfo(string6, 21, arrayList4, arrayListOf4, null, false, 48, null);
            String string7 = BaseApplicationImpl.getApplication().getString(R.string.xyv);
            Intrinsics.checkNotNullExpressionValue(string7, "getApplication().getStri\u2026R.string.mini_game_title)");
            arrayListOf5 = CollectionsKt__CollectionsKt.arrayListOf(expDesktopRankSubTabAppInfo, expDesktopRankSubTabAppInfo2, expDesktopRankSubTabAppInfo3, expDesktopRankSubTabAppInfo4);
            this.mRankModules.add(new ExpDesktopRankTabAppInfo(string7, arrayListOf5));
        }
    }
}
