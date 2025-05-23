package com.tencent.troopguild.api.impl;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.guild.temp.api.ITroopGuildTempApi;
import com.tencent.mobileqq.imcore.message.QQMessageFacadeStub;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import com.tencent.troopguild.api.ITroopGuildApi;
import com.tencent.troopguild.api.ITroopGuildRecentService;
import com.tencent.troopguild.api.ITroopGuildUnreadCntService;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\u0004H\u0016R\u0016\u0010$\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010,R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00068"}, d2 = {"Lcom/tencent/troopguild/api/impl/TroopGuildRecentServiceImpl;", "Lcom/tencent/troopguild/api/ITroopGuildRecentService;", "Luo4/f;", "troopGuildUnreadCntInfo", "", "handleUnreadCntInfoChanged", "", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;", "unreadCntInfo", "tryToUpdateInRecentList", "Lcom/tencent/mobileqq/data/RecentUser;", "recentUser", "", "isNeedDeleteRecentUser", "isCanAddTroopToRecentList", "addTroopToRecentUser", "Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;", "getRecentUserProxy", "refreshRecentListGlobal", "", "type", "refreshRecentListSingleItem", "tryToUpdateInTroopAssistantList", "refreshTroopAssistantList", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Luo4/c;", "callback", "setRecentListRefreshCallback", "unSetRecentListRefreshCallback", "Luo4/d;", "setTroopAssistantRefreshCallback", "unSetTroopAssistantRefreshCallback", "mAppRuntime", "Lmqq/app/AppRuntime;", "mRecentListRefreshCallback", "Luo4/c;", "mTroopAssistantListRefreshCallback", "Luo4/d;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mRefreshRecentListGlobalFlag", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mRefreshTroopAssistantListFlag", "", "mLastShowTimeForTroopAssistant", "J", "Ljava/util/Observer;", "mUnreadCntObserver", "Ljava/util/Observer;", "<init>", "()V", "Companion", "a", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class TroopGuildRecentServiceImpl implements ITroopGuildRecentService {

    @NotNull
    private static final String LAST_SHOW_TIME_FOR_TROOP_ASSISTANT = "last_time_for_troop_assistant";
    private static final long REFRESH_INTERVAL_TIME = 1500;

    @NotNull
    private static final String TAG = "TroopGuildRecentServiceImpl";
    private AppRuntime mAppRuntime;
    private long mLastShowTimeForTroopAssistant;

    @Nullable
    private uo4.c mRecentListRefreshCallback;

    @Nullable
    private uo4.d mTroopAssistantListRefreshCallback;

    @NotNull
    private AtomicBoolean mRefreshRecentListGlobalFlag = new AtomicBoolean(false);

    @NotNull
    private AtomicBoolean mRefreshTroopAssistantListFlag = new AtomicBoolean(false);

    @NotNull
    private final Observer mUnreadCntObserver = new Observer() { // from class: com.tencent.troopguild.api.impl.h
        @Override // java.util.Observer
        public final void update(Observable observable, Object obj) {
            TroopGuildRecentServiceImpl.mUnreadCntObserver$lambda$1(TroopGuildRecentServiceImpl.this, observable, obj);
        }
    };

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f381238a;

        static {
            int[] iArr = new int[GroupMsgMask.values().length];
            try {
                iArr[GroupMsgMask.ASSISTANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GroupMsgMask.SHIELD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f381238a = iArr;
        }
    }

    private final void addTroopToRecentUser(String troopUin) {
        RecentUser recentUser = new RecentUser(troopUin, 1);
        AppRuntime appRuntime = this.mAppRuntime;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
            appRuntime = null;
        }
        IRuntimeService runtimeService = appRuntime.getRuntimeService(IMessageFacade.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "mAppRuntime.getRuntimeSe\u2026va, ProcessConstant.MAIN)");
        IMessageFacade iMessageFacade = (IMessageFacade) runtimeService;
        if (iMessageFacade.getQQMessageFacadeStub() instanceof QQMessageFacadeStub) {
            Object qQMessageFacadeStub = iMessageFacade.getQQMessageFacadeStub();
            Intrinsics.checkNotNull(qQMessageFacadeStub, "null cannot be cast to non-null type com.tencent.mobileqq.imcore.message.QQMessageFacadeStub");
            Message lastMessage = ((QQMessageFacadeStub) qQMessageFacadeStub).getLastMessage(troopUin, 1);
            if (lastMessage != null) {
                recentUser.lastmsgtime = lastMessage.time;
            }
        }
        QLog.d(TAG, 1, "addTroopToRecentUser troopUin = " + troopUin);
        getRecentUserProxy().saveRecentUser(recentUser);
    }

    private final RecentUserProxy getRecentUserProxy() {
        AppRuntime appRuntime = this.mAppRuntime;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
            appRuntime = null;
        }
        RecentUserProxy recentUserCache = ((IRecentUserProxyService) appRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
        Intrinsics.checkNotNullExpressionValue(recentUserCache, "mAppRuntime.getRuntimeSe\u2026        ).recentUserCache");
        return recentUserCache;
    }

    private final void handleUnreadCntInfoChanged(uo4.f troopGuildUnreadCntInfo) {
        String troopUin = troopGuildUnreadCntInfo.getUnreadCntInfo().peer.peerUid;
        if (TextUtils.isEmpty(troopUin)) {
            QLog.d(TAG, 1, "handleUnreadCntInfoChanged troopUin isEmpty");
            return;
        }
        if (!((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).isTroopGuild(troopUin)) {
            QLog.d(TAG, 1, "handleUnreadCntInfoChanged not troopGuild, return.");
            return;
        }
        UnreadCntInfo unreadCntInfo = troopGuildUnreadCntInfo.getUnreadCntInfo();
        Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
        tryToUpdateInRecentList(troopUin, unreadCntInfo);
        tryToUpdateInTroopAssistantList(troopUin, unreadCntInfo);
    }

    private final boolean isCanAddTroopToRecentList(String troopUin, UnreadCntInfo unreadCntInfo) {
        int i3;
        ITroopUtilsApi iTroopUtilsApi = (ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class);
        AppRuntime appRuntime = this.mAppRuntime;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
            appRuntime = null;
        }
        GroupMsgMask troopMask = iTroopUtilsApi.getTroopMask(appRuntime, troopUin);
        if (troopMask == null) {
            i3 = -1;
        } else {
            i3 = b.f381238a[troopMask.ordinal()];
        }
        if (i3 != 1) {
            if (i3 == 2) {
                return false;
            }
            if (unreadCntInfo.lastRelatedToFeedType.ordinal() <= 0 && unreadCntInfo.atmeUnreadCnt.cnt <= 0) {
                return false;
            }
        } else if (unreadCntInfo.lastRelatedToFeedType.ordinal() <= 0) {
            return false;
        }
        return true;
    }

    private final boolean isNeedDeleteRecentUser(String troopUin, UnreadCntInfo unreadCntInfo, RecentUser recentUser) {
        ITroopUtilsApi iTroopUtilsApi = (ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class);
        AppRuntime appRuntime = this.mAppRuntime;
        AppRuntime appRuntime2 = null;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
            appRuntime = null;
        }
        if (iTroopUtilsApi.getTroopMask(appRuntime, troopUin) != GroupMsgMask.ASSISTANT || unreadCntInfo.lastRelatedToFeedType.ordinal() > 0) {
            return false;
        }
        ITroopGuildTempApi iTroopGuildTempApi = (ITroopGuildTempApi) QRoute.api(ITroopGuildTempApi.class);
        AppRuntime appRuntime3 = this.mAppRuntime;
        if (appRuntime3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
        } else {
            appRuntime2 = appRuntime3;
        }
        if (iTroopGuildTempApi.shouldShowInRecentList(appRuntime2, recentUser)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mUnreadCntObserver$lambda$1(final TroopGuildRecentServiceImpl this$0, Observable observable, final Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (obj instanceof uo4.f) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.troopguild.api.impl.i
                @Override // java.lang.Runnable
                public final void run() {
                    TroopGuildRecentServiceImpl.mUnreadCntObserver$lambda$1$lambda$0(TroopGuildRecentServiceImpl.this, obj);
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mUnreadCntObserver$lambda$1$lambda$0(TroopGuildRecentServiceImpl this$0, Object arg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(arg, "arg");
        this$0.handleUnreadCntInfoChanged((uo4.f) arg);
    }

    private final void refreshRecentListGlobal() {
        QLog.d(TAG, 1, "refreshRecentListFull");
        QLog.d(TAG, 1, "refreshRecentListFull mRecentListRefreshCallback null");
    }

    private static final void refreshRecentListGlobal$lambda$3(TroopGuildRecentServiceImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(TAG, 1, "refreshRecentListFull mRecentListRefreshCallback.onRefreshRecentListGlobal()");
        this$0.getClass();
        this$0.mRefreshRecentListGlobalFlag.set(false);
    }

    private final void refreshRecentListSingleItem(final String troopUin, final int type) {
        QLog.d(TAG, 1, "refreshRecentListSingleItem troopUin = " + troopUin);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.troopguild.api.impl.j
            @Override // java.lang.Runnable
            public final void run() {
                TroopGuildRecentServiceImpl.refreshRecentListSingleItem$lambda$4(TroopGuildRecentServiceImpl.this, troopUin, type);
            }
        });
    }

    static /* synthetic */ void refreshRecentListSingleItem$default(TroopGuildRecentServiceImpl troopGuildRecentServiceImpl, String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        troopGuildRecentServiceImpl.refreshRecentListSingleItem(str, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshRecentListSingleItem$lambda$4(TroopGuildRecentServiceImpl this$0, String troopUin, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        this$0.getClass();
    }

    private final void refreshTroopAssistantList() {
        QLog.d(TAG, 1, "refreshTroopAssistantList");
        QLog.d(TAG, 1, "refreshTroopAssistantList mTroopAssistantListRefreshCallback null");
    }

    private static final void refreshTroopAssistantList$lambda$5(TroopGuildRecentServiceImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(TAG, 1, "refreshTroopAssistantList run");
        this$0.getClass();
        this$0.mRefreshTroopAssistantListFlag.set(false);
    }

    private final void tryToUpdateInRecentList(String troopUin, UnreadCntInfo unreadCntInfo) {
        QLog.d(TAG, 1, "tryToUpdateInRecentList false mRecentListRefreshCallback null");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void tryToUpdateInTroopAssistantList(String troopUin, UnreadCntInfo unreadCntInfo) {
        boolean z16;
        AppRuntime appRuntime;
        AppRuntime appRuntime2;
        ITroopUtilsApi iTroopUtilsApi = (ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class);
        AppRuntime appRuntime3 = this.mAppRuntime;
        AppRuntime appRuntime4 = null;
        if (appRuntime3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
            appRuntime3 = null;
        }
        GroupMsgMask troopMask = iTroopUtilsApi.getTroopMask(appRuntime3, troopUin);
        if (troopMask != GroupMsgMask.ASSISTANT) {
            QLog.d(TAG, 1, "tryToUpdateInTroopAssistantList false troopMask = " + troopMask);
            return;
        }
        if (!((ITroopGuildTempApi) QRoute.api(ITroopGuildTempApi.class)).isTroopAssistantInitData()) {
            QLog.d(TAG, 1, "tryToUpdateInTroopAssistantList isTroopAssistantInitData false");
            return;
        }
        QRouteApi api = QRoute.api(ITroopGuildTempApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopGuildTempApi::class.java)");
        ITroopGuildTempApi iTroopGuildTempApi = (ITroopGuildTempApi) api;
        if (unreadCntInfo.lastRelatedToFeedType.ordinal() > 0) {
            long j3 = unreadCntInfo.relatedToMeStringTime;
            if (j3 > this.mLastShowTimeForTroopAssistant) {
                this.mLastShowTimeForTroopAssistant = j3;
                MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
                from.encodeLong(LAST_SHOW_TIME_FOR_TROOP_ASSISTANT, this.mLastShowTimeForTroopAssistant);
                AppRuntime appRuntime5 = this.mAppRuntime;
                if (appRuntime5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
                    appRuntime5 = null;
                }
                z16 = iTroopGuildTempApi.tryToShowTroopAssistantForTroopGuild(appRuntime5, troopUin);
                appRuntime = this.mAppRuntime;
                if (appRuntime == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
                    appRuntime = null;
                }
                boolean updateTroopAssistantNewMsgSet = iTroopGuildTempApi.updateTroopAssistantNewMsgSet(appRuntime, unreadCntInfo, troopUin);
                if (!z16 || updateTroopAssistantNewMsgSet) {
                    refreshRecentListGlobal();
                }
                if (!iTroopGuildTempApi.isInTroopAssistantList(troopUin) && (unreadCntInfo.lastRelatedToFeedType.ordinal() > 0 || unreadCntInfo.atmeUnreadCnt.cnt > 0)) {
                    QLog.d(TAG, 1, "tryToUpdateInTroopAssistantList isInTroopAssistantList true");
                    appRuntime2 = this.mAppRuntime;
                    if (appRuntime2 != null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
                    } else {
                        appRuntime4 = appRuntime2;
                    }
                    iTroopGuildTempApi.addTroopToTroopAssistantList(appRuntime4, troopUin);
                }
                refreshTroopAssistantList();
            }
        }
        z16 = false;
        appRuntime = this.mAppRuntime;
        if (appRuntime == null) {
        }
        boolean updateTroopAssistantNewMsgSet2 = iTroopGuildTempApi.updateTroopAssistantNewMsgSet(appRuntime, unreadCntInfo, troopUin);
        if (!z16) {
        }
        refreshRecentListGlobal();
        if (!iTroopGuildTempApi.isInTroopAssistantList(troopUin)) {
            QLog.d(TAG, 1, "tryToUpdateInTroopAssistantList isInTroopAssistantList true");
            appRuntime2 = this.mAppRuntime;
            if (appRuntime2 != null) {
            }
            iTroopGuildTempApi.addTroopToTroopAssistantList(appRuntime4, troopUin);
        }
        refreshTroopAssistantList();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        QLog.d(TAG, 1, "onCreate");
        this.mAppRuntime = appRuntime;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
            appRuntime = null;
        }
        ((ITroopGuildUnreadCntService) appRuntime.getRuntimeService(ITroopGuildUnreadCntService.class, "")).addUnreadCntInfoObserver(this.mUnreadCntObserver);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        this.mLastShowTimeForTroopAssistant = from.decodeLong(LAST_SHOW_TIME_FOR_TROOP_ASSISTANT, 0L);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.d(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        AppRuntime appRuntime = this.mAppRuntime;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
            appRuntime = null;
        }
        ((ITroopGuildUnreadCntService) appRuntime.getRuntimeService(ITroopGuildUnreadCntService.class, "")).deleteUnreadCntInfoObserver(this.mUnreadCntObserver);
    }

    @Override // com.tencent.troopguild.api.ITroopGuildRecentService
    public void setRecentListRefreshCallback(@NotNull uo4.c callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d(TAG, 1, "setRecentListRefreshCallback");
    }

    @Override // com.tencent.troopguild.api.ITroopGuildRecentService
    public void setTroopAssistantRefreshCallback(@NotNull uo4.d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.troopguild.api.ITroopGuildRecentService
    public void unSetRecentListRefreshCallback() {
        QLog.d(TAG, 1, "unSetRecentListRefreshCallback");
    }

    @Override // com.tencent.troopguild.api.ITroopGuildRecentService
    public void unSetTroopAssistantRefreshCallback() {
    }
}
