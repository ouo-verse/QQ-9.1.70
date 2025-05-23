package com.tencent.troopguild.api.impl;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.df;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GuildGroupSceneType;
import com.tencent.qqnt.troop.ITroopExtInfoDBApi;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.troopguild.api.ITroopGuildApi;
import com.tencent.troopguild.api.ITroopGuildInfoService;
import com.tencent.troopguild.api.ITroopGuildUnreadCntService;
import com.tencent.xweb.FileReaderHelper;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.v;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 52\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016JD\u0010\u001b\u001a\u00020\u00072:\u0010\u001a\u001a6\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u0015j\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016`\u0019H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0002H\u0016R\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R0\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0015j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-RJ\u0010.\u001a6\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u0015j\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016`\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010#R\u0016\u0010/\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010'R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/troopguild/api/impl/TroopGuildInfoServiceImpl;", "Lcom/tencent/troopguild/api/ITroopGuildInfoService;", "", "guildId", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "check", "", "initCommonPriorityHandler", "verifyTroopInfoGuildId", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lvh2/v;", "cb", "fetchGuildInfo", "isTroopGuildSwitchOpen", "onTroopGuildAioEntered", "onTroopGuildAioExisted", "onReconnect", "Ljava/util/HashMap;", "Lkotlin/Pair;", "", "", "Lkotlin/collections/HashMap;", "troopGuildIds", "handleRegisterProxyGuildId", "troopUin", "onGetTroopList", "getCurrentAioTroopGuildSwitch", "Lmqq/util/WeakReference;", "mWeakApp", "Lmqq/util/WeakReference;", "mFetchChannelInfoMap", "Ljava/util/HashMap;", "mCurrentTroopGuildAio", "Ljava/lang/String;", "mIsCurrentAioTroopSwitchOpen", "Z", "Ljava/lang/Object;", "initHandlerLock", "Ljava/lang/Object;", "Landroid/os/Handler;", "commonPriorityHandler", "Landroid/os/Handler;", "troopGuildIdsRegisterProxy", "onGetTroopListFin", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "mGpsObserver", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "<init>", "()V", "Companion", "a", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class TroopGuildInfoServiceImpl implements ITroopGuildInfoService {

    @NotNull
    public static final String TAG = "TroopGuildInfoServiceImpl";

    @Nullable
    private Handler commonPriorityHandler;
    private WeakReference<AppRuntime> mWeakApp;
    private boolean onGetTroopListFin;

    @NotNull
    private final HashMap<String, Boolean> mFetchChannelInfoMap = new HashMap<>();

    @NotNull
    private String mCurrentTroopGuildAio = "";
    private boolean mIsCurrentAioTroopSwitchOpen = true;

    @NotNull
    private Object initHandlerLock = new Object();

    @NotNull
    private HashMap<String, Pair<Long, Integer>> troopGuildIdsRegisterProxy = new HashMap<>();

    @NotNull
    private final GPServiceObserver mGpsObserver = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0014\u00a8\u0006\r"}, d2 = {"com/tencent/troopguild/api/impl/TroopGuildInfoServiceImpl$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", "b", "", "guildId", "onChannelListUpdated", "channelUin", "onChannelInfoUpdated", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final void b(IGProChannelInfo channelInfo, TroopInfo troopInfo) {
            WeakReference weakReference = TroopGuildInfoServiceImpl.this.mWeakApp;
            if (weakReference == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWeakApp");
                weakReference = null;
            }
            AppRuntime appRuntime = (AppRuntime) weakReference.get();
            if (appRuntime != null && channelInfo != null && troopInfo != null) {
                Iterator<df> it = channelInfo.getAuthControlStatusList().iterator();
                while (it.hasNext()) {
                    df next = it.next();
                    if (next.getAuthControlKey() == 14) {
                        boolean z16 = false;
                        if (next.getAuthControlValue() == 1) {
                            ITroopGuildUnreadCntService iTroopGuildUnreadCntService = (ITroopGuildUnreadCntService) appRuntime.getRuntimeService(ITroopGuildUnreadCntService.class, "");
                            String str = troopInfo.troopuin;
                            Intrinsics.checkNotNullExpressionValue(str, "troopInfo.troopuin");
                            iTroopGuildUnreadCntService.setTroopGuildMsgRead(str, GuildGroupSceneType.KALL, false);
                        }
                        if (troopInfo.extDBInfo.troopGuildSwitchOpen != next.getAuthControlValue()) {
                            z16 = true;
                        }
                        QLog.i(TroopGuildInfoServiceImpl.TAG, 1, "[updateTroopGuildSwitch], guildId: " + troopInfo.getTroopGuildId() + ", troopUin:: " + troopInfo.troopuin + ", oldSwitch: " + troopInfo.extDBInfo.troopGuildSwitchOpen + ", newSwitchVal: " + next.getAuthControlValue() + ", needSave: " + z16);
                        ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateGuildSwitchOpen(troopInfo.troopuin, next.getAuthControlValue());
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@Nullable String channelUin) {
            IGProChannelInfo channelInfo;
            IGProGuildInfo guildInfo;
            Long l3;
            boolean z16;
            if (channelUin != null) {
                WeakReference weakReference = TroopGuildInfoServiceImpl.this.mWeakApp;
                String str = null;
                if (weakReference == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mWeakApp");
                    weakReference = null;
                }
                AppRuntime appRuntime = (AppRuntime) weakReference.get();
                if (appRuntime != null && (channelInfo = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getChannelInfo(channelUin)) != null && (guildInfo = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getGuildInfo(channelInfo.getGuildId())) != null && guildInfo.getGroupId() != 0) {
                    TroopInfo findTroopInfo = ((ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(guildInfo.getGroupId()));
                    if (findTroopInfo != null) {
                        l3 = Long.valueOf(findTroopInfo.getTroopGuildId());
                    } else {
                        l3 = null;
                    }
                    if (findTroopInfo != null) {
                        str = findTroopInfo.troopuin;
                    }
                    if (findTroopInfo != null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    QLog.i(TroopGuildInfoServiceImpl.TAG, 1, "[onChannelInfoUpdated], guildId: " + l3 + ", troopUin:: " + str + ", findTroopInfo: " + z16);
                    b(channelInfo, findTroopInfo);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(@Nullable String guildId) {
            IGProGuildInfo guildInfo;
            Long l3;
            boolean z16;
            if (guildId != null) {
                WeakReference weakReference = TroopGuildInfoServiceImpl.this.mWeakApp;
                String str = null;
                if (weakReference == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mWeakApp");
                    weakReference = null;
                }
                AppRuntime appRuntime = (AppRuntime) weakReference.get();
                if (appRuntime != null && (guildInfo = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getGuildInfo(guildId)) != null && guildInfo.getGroupId() != 0) {
                    TroopInfo findTroopInfo = ((ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(guildInfo.getGroupId()));
                    IGProChannelInfo troopFeedChannelInfo = ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getTroopFeedChannelInfo(guildId);
                    if (findTroopInfo != null) {
                        l3 = Long.valueOf(findTroopInfo.getTroopGuildId());
                    } else {
                        l3 = null;
                    }
                    if (findTroopInfo != null) {
                        str = findTroopInfo.troopuin;
                    }
                    boolean z17 = false;
                    if (findTroopInfo != null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (troopFeedChannelInfo != null) {
                        z17 = true;
                    }
                    QLog.i(TroopGuildInfoServiceImpl.TAG, 1, "[onChannelListUpdated], guildId: " + l3 + ", troopUin:: " + str + ", findTroopInfo: " + z16 + ", findChannelInfo: " + z17);
                    b(troopFeedChannelInfo, findTroopInfo);
                }
            }
        }
    }

    private final boolean check(String guildId, boolean force) {
        if (!force && this.mFetchChannelInfoMap.containsKey(guildId) && Intrinsics.areEqual(this.mFetchChannelInfoMap.get(guildId), Boolean.TRUE)) {
            return false;
        }
        return true;
    }

    private final void initCommonPriorityHandler() {
        Handler handler;
        synchronized (this.initHandlerLock) {
            if (this.commonPriorityHandler == null) {
                try {
                    handler = new Handler(ThreadManagerV2.getMSFCommonPriorityThread().getLooper());
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "initCommonPriorityHandler e: " + e16);
                    handler = null;
                }
                this.commonPriorityHandler = handler;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onReconnect$lambda$0(int i3, String str, IGProGuildInfo iGProGuildInfo) {
        QLog.i(TAG, 1, "[onFetchGuildInfo] result:" + i3 + ", errMsg:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void verifyTroopInfoGuildId$lambda$2(String troopUin, String guildId) {
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).updateTroopGuildId(troopUin, Long.parseLong(guildId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void verifyTroopInfoGuildId$lambda$4(TroopGuildInfoServiceImpl this$0) {
        boolean z16;
        Long l3;
        long j3;
        Long l16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        for (TroopInfo troopInfo : ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getJoinedTroopInfoFromCache()) {
            if ((troopInfo instanceof TroopInfo) && this$0.troopGuildIdsRegisterProxy.containsKey(troopInfo.getTroopUin())) {
                Pair<Long, Integer> pair = this$0.troopGuildIdsRegisterProxy.get(troopInfo.getTroopUin());
                Integer num = null;
                if (!troopInfo.isTroopGuild()) {
                    ITroopOperationRepoApi iTroopOperationRepoApi = (ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class);
                    String str = troopInfo.troopuin;
                    if (pair != null) {
                        j3 = pair.getFirst().longValue();
                    } else {
                        j3 = 0;
                    }
                    iTroopOperationRepoApi.updateTroopGuildId(str, j3);
                    String troopUin = troopInfo.getTroopUin();
                    if (pair != null) {
                        l16 = pair.getFirst();
                    } else {
                        l16 = null;
                    }
                    QLog.i(TAG, 1, "[verifyTroopInfoGuildId] troopUin:" + troopUin + " guildId:" + l16);
                }
                int i3 = 0;
                if (pair != null && pair.getSecond().intValue() == -1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (pair != null && pair.getSecond().intValue() == 1) {
                        i3 = 1;
                    }
                    if (i3 != troopInfo.extDBInfo.troopGuildSwitchOpen) {
                        String troopUin2 = troopInfo.getTroopUin();
                        if (pair != null) {
                            l3 = pair.getFirst();
                        } else {
                            l3 = null;
                        }
                        int i16 = troopInfo.extDBInfo.troopGuildSwitchOpen;
                        if (pair != null) {
                            num = pair.getSecond();
                        }
                        QLog.i(TAG, 1, "[verifyTroopInfoGuildId] troopUin:" + troopUin2 + " guildId:" + l3 + ", oldSwitch: " + i16 + ", newVal: " + num + ", newSwitch: " + i3);
                        ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateGuildSwitchOpen(troopInfo.troopuin, i3);
                    }
                }
            }
        }
    }

    @Override // com.tencent.troopguild.api.ITroopGuildInfoService
    public void fetchGuildInfo(@NotNull String guildId, boolean force, @NotNull v cb5) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        if (!check(guildId, force)) {
            QLog.i(TAG, 1, "[refreshGuildInfo] has refreshed once. Do nothing. guildId: " + guildId);
            return;
        }
        WeakReference<AppRuntime> weakReference = this.mWeakApp;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWeakApp");
            weakReference = null;
        }
        AppRuntime appRuntime = weakReference.get();
        if (appRuntime == null) {
            return;
        }
        QLog.i(TAG, 1, "[refreshGuildInfo] guildId: " + guildId + ", force: " + force);
        this.mFetchChannelInfoMap.put(guildId, Boolean.TRUE);
        IRuntimeService runtimeService = appRuntime.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        ((IGPSService) runtimeService).fetchGuildInfoWithSource(guildId, 105, cb5);
    }

    @Override // com.tencent.troopguild.api.ITroopGuildInfoService
    public boolean getCurrentAioTroopGuildSwitch(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).isTroopGuildSwitchOpen(troopUin);
    }

    @Override // com.tencent.troopguild.api.ITroopGuildInfoService
    public void handleRegisterProxyGuildId(@NotNull HashMap<String, Pair<Long, Integer>> troopGuildIds) {
        Intrinsics.checkNotNullParameter(troopGuildIds, "troopGuildIds");
        QLog.i(TAG, 1, "handleRegisterProxyGuildId: " + troopGuildIds);
        this.troopGuildIdsRegisterProxy = troopGuildIds;
        verifyTroopInfoGuildId();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        this.mWeakApp = new WeakReference<>(appRuntime);
        this.mCurrentTroopGuildAio = "";
        this.mFetchChannelInfoMap.clear();
        if (!appRuntime.isRunning()) {
            return;
        }
        ((IGProGlobalService) appRuntime.getRuntimeService(IGProGlobalService.class, "")).addObserver(this.mGpsObserver);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.mFetchChannelInfoMap.clear();
        this.mCurrentTroopGuildAio = "";
        WeakReference<AppRuntime> weakReference = this.mWeakApp;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWeakApp");
            weakReference = null;
        }
        AppRuntime appRuntime = weakReference.get();
        if (appRuntime == null) {
            return;
        }
        ((IGProGlobalService) appRuntime.getRuntimeService(IGProGlobalService.class, "")).deleteObserver(this.mGpsObserver);
    }

    @Override // com.tencent.troopguild.api.ITroopGuildInfoService
    public void onGetTroopList() {
        this.onGetTroopListFin = true;
        verifyTroopInfoGuildId();
    }

    @Override // com.tencent.troopguild.api.ITroopGuildInfoService
    public void onReconnect() {
        QLog.i(TAG, 1, "[onReconnect] mCurrentTroopGuildAio: " + this.mCurrentTroopGuildAio);
        this.mFetchChannelInfoMap.clear();
        if (!TextUtils.isEmpty(this.mCurrentTroopGuildAio)) {
            fetchGuildInfo(this.mCurrentTroopGuildAio, false, new v() { // from class: com.tencent.troopguild.api.impl.c
                @Override // vh2.v
                public final void a(int i3, String str, IGProGuildInfo iGProGuildInfo) {
                    TroopGuildInfoServiceImpl.onReconnect$lambda$0(i3, str, iGProGuildInfo);
                }
            });
        }
    }

    @Override // com.tencent.troopguild.api.ITroopGuildInfoService
    public void onTroopGuildAioEntered(@NotNull String guildId, boolean isTroopGuildSwitchOpen) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        QLog.i(TAG, 1, "[onTroopGuildAioEntered] guildId: " + guildId + ", isTroopGuildSwitchOpen: " + isTroopGuildSwitchOpen);
        this.mCurrentTroopGuildAio = guildId;
        this.mIsCurrentAioTroopSwitchOpen = isTroopGuildSwitchOpen;
    }

    @Override // com.tencent.troopguild.api.ITroopGuildInfoService
    public void onTroopGuildAioExisted() {
        QLog.i(TAG, 1, "[onTroopGuildAioExisted] guildId: " + this.mCurrentTroopGuildAio);
        this.mCurrentTroopGuildAio = "";
        this.mIsCurrentAioTroopSwitchOpen = true;
    }

    @Override // com.tencent.troopguild.api.ITroopGuildInfoService
    public void verifyTroopInfoGuildId(@NotNull final String troopUin, @NotNull final String guildId) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (troopUin.length() == 0) {
            return;
        }
        if (guildId.length() == 0) {
            return;
        }
        initCommonPriorityHandler();
        Handler handler = this.commonPriorityHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.troopguild.api.impl.d
                @Override // java.lang.Runnable
                public final void run() {
                    TroopGuildInfoServiceImpl.verifyTroopInfoGuildId$lambda$2(troopUin, guildId);
                }
            });
        }
    }

    private final void verifyTroopInfoGuildId() {
        QLog.i(TAG, 1, "verifyTroopInfoGuildId troopGuildIds isEmpty:" + this.troopGuildIdsRegisterProxy.isEmpty() + " onGetTroopListFin:" + this.onGetTroopListFin);
        if (this.troopGuildIdsRegisterProxy.isEmpty() || !this.onGetTroopListFin) {
            return;
        }
        WeakReference<AppRuntime> weakReference = this.mWeakApp;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWeakApp");
            weakReference = null;
        }
        if (weakReference.get() == null) {
            return;
        }
        initCommonPriorityHandler();
        Handler handler = this.commonPriorityHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.troopguild.api.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    TroopGuildInfoServiceImpl.verifyTroopInfoGuildId$lambda$4(TroopGuildInfoServiceImpl.this);
                }
            });
        }
    }
}
