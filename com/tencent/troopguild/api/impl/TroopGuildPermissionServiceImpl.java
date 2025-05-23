package com.tencent.troopguild.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.troopgag.api.ITroopGagService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GuildGroupSceneType;
import com.tencent.qqnt.troop.ITroopExtInfoDBApi;
import com.tencent.troopguild.api.ITroopGuildApi;
import com.tencent.troopguild.api.ITroopGuildInfoService;
import com.tencent.troopguild.api.ITroopGuildPermissionService;
import com.tencent.troopguild.api.ITroopGuildUnreadCntService;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.cd;
import vh2.v;
import wh2.dv;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J;\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00102!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00040\u0013H\u0016JC\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000e2!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00040\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0002H\u0016R\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R&\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\n0$j\b\u0012\u0004\u0012\u00020\n`%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R&\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00020$j\b\u0012\u0004\u0012\u00020\u0002`%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010'R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00060"}, d2 = {"Lcom/tencent/troopguild/api/impl/TroopGuildPermissionServiceImpl;", "Lcom/tencent/troopguild/api/ITroopGuildPermissionService;", "", "guildId", "", "refreshGuildInfo", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Luo4/e;", "observer", "addObserver", "removeObserver", "", "forceRefresh", "", "getTroopFeedTalkPermission", QCircleDaTongConstant.ElementParamValue.PERMISSION, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "callback", "setTroopFeedTalkPermission", "troopUin", "switchOpen", "setTroopFeedSwitch", "", "getMuteAllTime", "getMuteSelfTime", "isMute", "onMuteStateChanged", "isAdmin", "mAppRuntime", "Lmqq/app/AppRuntime;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "mObservers", "Ljava/util/HashSet;", "mChannelsInterestedIn", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "mGpServiceObserver", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "<init>", "()V", "Companion", "a", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class TroopGuildPermissionServiceImpl implements ITroopGuildPermissionService {

    @NotNull
    public static final String TAG = "TroopGuildPermissionServiceImpl";
    public static final int TROOP_GUILD_AUTH_TYPE = 14;
    private AppRuntime mAppRuntime;

    @NotNull
    private HashSet<uo4.e> mObservers = new HashSet<>();

    @NotNull
    private HashSet<String> mChannelsInterestedIn = new HashSet<>();

    @NotNull
    private final GPServiceObserver mGpServiceObserver = new b();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/troopguild/api/impl/TroopGuildPermissionServiceImpl$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "channelUin", "", "onChannelInfoUpdated", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@Nullable String channelUin) {
            if (channelUin != null && !TroopGuildPermissionServiceImpl.this.mObservers.isEmpty() && !TroopGuildPermissionServiceImpl.this.mChannelsInterestedIn.isEmpty() && TroopGuildPermissionServiceImpl.this.mChannelsInterestedIn.contains(channelUin)) {
                TroopGuildPermissionServiceImpl.this.mChannelsInterestedIn.remove(channelUin);
                AppRuntime appRuntime = TroopGuildPermissionServiceImpl.this.mAppRuntime;
                if (appRuntime == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
                    appRuntime = null;
                }
                String guildId = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getGuildIdOf(channelUin);
                QLog.i(TroopGuildPermissionServiceImpl.TAG, 1, "[onChannelInfoUpdated], refreshChannelInfo. guildId: " + guildId + ", channelId: " + channelUin);
                TroopGuildPermissionServiceImpl troopGuildPermissionServiceImpl = TroopGuildPermissionServiceImpl.this;
                Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
                int troopFeedTalkPermission = troopGuildPermissionServiceImpl.getTroopFeedTalkPermission(guildId, false);
                Iterator it = TroopGuildPermissionServiceImpl.this.mObservers.iterator();
                while (it.hasNext()) {
                    ((uo4.e) it.next()).a(guildId, troopFeedTalkPermission);
                }
            }
        }
    }

    private final void refreshGuildInfo(final String guildId) {
        AppRuntime appRuntime = this.mAppRuntime;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
            appRuntime = null;
        }
        ((ITroopGuildInfoService) appRuntime.getRuntimeService(ITroopGuildInfoService.class, "")).fetchGuildInfo(guildId, true, new v() { // from class: com.tencent.troopguild.api.impl.e
            @Override // vh2.v
            public final void a(int i3, String str, IGProGuildInfo iGProGuildInfo) {
                TroopGuildPermissionServiceImpl.refreshGuildInfo$lambda$0(guildId, i3, str, iGProGuildInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshGuildInfo$lambda$0(String guildId, int i3, String str, IGProGuildInfo iGProGuildInfo) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        QLog.i(TAG, 1, "[refreshGuildInfo] result:" + i3 + ", errMsg:" + str + ", guildId: " + guildId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTroopFeedSwitch$lambda$4$lambda$3(boolean z16, String guildId, String channelId, String troopUin, TroopGuildPermissionServiceImpl this$0, int i3, Function1 callback, int i16, String str, IGProSecurityResult iGProSecurityResult) {
        boolean z17;
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        boolean z18 = true;
        QLog.i(TAG, 1, "[setTroopFeedSwitch] switchOpen: " + z16 + ", guildId: " + guildId + ", channelId: " + channelId + ", troopUin: " + troopUin + ", result: " + i16 + ", errMsg: " + str);
        if (i16 == 0) {
            AppRuntime appRuntime = null;
            if (!z16) {
                AppRuntime appRuntime2 = this$0.mAppRuntime;
                if (appRuntime2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
                    appRuntime2 = null;
                }
                ((ITroopGuildUnreadCntService) appRuntime2.getRuntimeService(ITroopGuildUnreadCntService.class, "")).setTroopGuildMsgRead(troopUin, GuildGroupSceneType.KALL, false);
            }
            AppRuntime appRuntime3 = this$0.mAppRuntime;
            if (appRuntime3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
            } else {
                appRuntime = appRuntime3;
            }
            TroopInfo findTroopInfo = ((ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(troopUin);
            if (findTroopInfo != null) {
                int i17 = findTroopInfo.extDBInfo.troopGuildSwitchOpen;
                if (i17 != i3) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                QLog.i(TAG, 1, "[setTroopFeedSwitch] Update TroopInfo. oldSwitch: " + i17 + ", newSwitch: " + i3 + ", needSave: " + z17);
                ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateGuildSwitchOpen(findTroopInfo.troopuin, i3);
            } else {
                QLog.i(TAG, 1, "[setTroopFeedSwitch] Fail to get TroopInfo.");
            }
        }
        if (i16 != 0) {
            z18 = false;
        }
        callback.invoke(Boolean.valueOf(z18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTroopFeedTalkPermission$lambda$2$lambda$1(int i3, String guildId, Function1 callback, int i16, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        boolean z16 = true;
        QLog.i(TAG, 1, "[setTroopFeedTalkPermission] result: " + i16 + ", error: " + i16 + ", errMsg: " + str + ", permission: " + i3 + ", guildId: " + guildId);
        if (i16 != 0) {
            z16 = false;
        }
        callback.invoke(Boolean.valueOf(z16));
    }

    @Override // com.tencent.troopguild.api.ITroopGuildPermissionService
    public void addObserver(@NotNull uo4.e observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        AppRuntime appRuntime = this.mAppRuntime;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
            appRuntime = null;
        }
        ((IGProGlobalService) appRuntime.getRuntimeService(IGProGlobalService.class, "")).addObserver(this.mGpServiceObserver);
        this.mObservers.add(observer);
    }

    @Override // com.tencent.troopguild.api.ITroopGuildPermissionService
    public long getMuteAllTime(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        if (((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).isTroopGuild(troopUin)) {
            AppRuntime appRuntime = this.mAppRuntime;
            if (appRuntime == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
                appRuntime = null;
            }
            TroopInfo troopInfo = ((ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(troopUin);
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 4, "[getMuteAllTime], troopUin: " + troopUin + ", muteAll: " + troopInfo.dwGagTimeStamp);
            }
            return troopInfo.dwGagTimeStamp;
        }
        return 0L;
    }

    @Override // com.tencent.troopguild.api.ITroopGuildPermissionService
    public long getMuteSelfTime(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        if (((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).isTroopGuild(troopUin)) {
            AppRuntime appRuntime = this.mAppRuntime;
            if (appRuntime == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
                appRuntime = null;
            }
            TroopInfo troopInfo = ((ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(troopUin);
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 4, "[getMuteSelfTime], troopUin: " + troopUin + ", muteMe: " + troopInfo.dwGagTimeStamp_me);
            }
            return troopInfo.dwGagTimeStamp_me;
        }
        return 0L;
    }

    @Override // com.tencent.troopguild.api.ITroopGuildPermissionService
    public int getTroopFeedTalkPermission(@NotNull String guildId, boolean forceRefresh) {
        int i3;
        boolean z16;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        IGProChannelInfo troopFeedChannelInfo = ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getTroopFeedChannelInfo(guildId);
        if (troopFeedChannelInfo != null) {
            i3 = troopFeedChannelInfo.getTalkPermission();
            z16 = false;
            if (i3 == 0) {
                QLog.i(TAG, 1, "[getTroopFeedTalkPermission] error. Permission is INVALID. return default. guildId: " + guildId);
                i3 = 1;
            }
        } else {
            i3 = 1;
            z16 = true;
        }
        if (z16 && forceRefresh) {
            QLog.i(TAG, 1, "[getTroopFeedTalkPermission] failed! force get GuildInfo. guildId: " + guildId);
            refreshGuildInfo(guildId);
        }
        QLog.i(TAG, 1, "[getTroopFeedTalkPermission], refreshChannelInfo. guildId: " + guildId + ", permission: " + i3);
        return i3;
    }

    @Override // com.tencent.troopguild.api.ITroopGuildPermissionService
    public boolean isAdmin(@NotNull String troopUin) {
        boolean z16;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        AppRuntime appRuntime = this.mAppRuntime;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
            appRuntime = null;
        }
        TroopInfo troopInfo = ((ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(troopUin);
        if (troopInfo != null) {
            z16 = troopInfo.isOwnerOrAdmin();
        } else {
            z16 = false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "[isAdmin], troopUin: " + troopUin + ", isAdmin: " + z16);
        }
        return z16;
    }

    @Override // com.tencent.troopguild.api.ITroopGuildPermissionService
    public boolean isMute(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        AppRuntime appRuntime = this.mAppRuntime;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
            appRuntime = null;
        }
        com.tencent.mobileqq.troop.troopgag.data.d selfGagInfo = ((ITroopGagService) appRuntime.getRuntimeService(ITroopGagService.class, "")).getSelfGagInfo(troopUin, false);
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "[isMute], troopUin: " + troopUin + ", isMute: " + selfGagInfo.f300235b);
        }
        return selfGagInfo.f300235b;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        this.mAppRuntime = appRuntime;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        AppRuntime appRuntime = this.mAppRuntime;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
            appRuntime = null;
        }
        ((IGProGlobalService) appRuntime.getRuntimeService(IGProGlobalService.class, "")).deleteObserver(this.mGpServiceObserver);
        this.mObservers.clear();
    }

    @Override // com.tencent.troopguild.api.ITroopGuildPermissionService
    public void onMuteStateChanged(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        if (!((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).isTroopGuildSwitchOpen(troopUin) || this.mObservers.isEmpty()) {
            return;
        }
        QLog.i(TAG, 1, "[onMuteStateChanged], troopUin: " + troopUin);
        Iterator<uo4.e> it = this.mObservers.iterator();
        while (it.hasNext()) {
            it.next().b(troopUin);
        }
    }

    @Override // com.tencent.troopguild.api.ITroopGuildPermissionService
    public void removeObserver(@NotNull uo4.e observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mObservers.remove(observer);
        if (this.mObservers.isEmpty()) {
            AppRuntime appRuntime = this.mAppRuntime;
            if (appRuntime == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
                appRuntime = null;
            }
            ((IGProGlobalService) appRuntime.getRuntimeService(IGProGlobalService.class, "")).deleteObserver(this.mGpServiceObserver);
        }
    }

    @Override // com.tencent.troopguild.api.ITroopGuildPermissionService
    public void setTroopFeedSwitch(@NotNull final String guildId, @NotNull final String troopUin, final boolean switchOpen, @NotNull final Function1<? super Boolean, Unit> callback) {
        TroopGuildPermissionServiceImpl troopGuildPermissionServiceImpl;
        int i3;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i(TAG, 1, "[setTroopFeedSwitch] switchOpen: " + switchOpen + ", guildId: " + guildId + ", troopUin: " + troopUin);
        final String troopFeedChannelId = ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getTroopFeedChannelId(guildId);
        if (troopFeedChannelId != null) {
            if (switchOpen) {
                troopGuildPermissionServiceImpl = this;
                i3 = 0;
            } else {
                troopGuildPermissionServiceImpl = this;
                i3 = 1;
            }
            try {
                AppRuntime appRuntime = troopGuildPermissionServiceImpl.mAppRuntime;
                if (appRuntime == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
                    appRuntime = null;
                }
                final int i16 = i3;
                ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).setChannelAuthControl(Long.parseLong(guildId), Long.parseLong(troopFeedChannelId), 14, i3, new dv() { // from class: com.tencent.troopguild.api.impl.f
                    @Override // wh2.dv
                    public final void a(int i17, String str, IGProSecurityResult iGProSecurityResult) {
                        TroopGuildPermissionServiceImpl.setTroopFeedSwitch$lambda$4$lambda$3(switchOpen, guildId, troopFeedChannelId, troopUin, this, i16, callback, i17, str, iGProSecurityResult);
                    }
                });
            } catch (Exception e16) {
                QLog.i(TAG, 1, "[setTroopFeedSwitch] exception: " + e16.getMessage());
            }
        }
    }

    @Override // com.tencent.troopguild.api.ITroopGuildPermissionService
    public void setTroopFeedTalkPermission(@NotNull final String guildId, final int permission, @NotNull final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i(TAG, 1, "[setTroopFeedTalkPermission] permission: " + permission + ", guildId: " + guildId);
        String troopFeedChannelId = ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getTroopFeedChannelId(guildId);
        if (troopFeedChannelId != null) {
            AppRuntime appRuntime = this.mAppRuntime;
            if (appRuntime == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
                appRuntime = null;
            }
            ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).setChannelSpeakable(guildId, troopFeedChannelId, permission, new cd() { // from class: com.tencent.troopguild.api.impl.g
                @Override // vh2.cd
                public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                    TroopGuildPermissionServiceImpl.setTroopFeedTalkPermission$lambda$2$lambda$1(permission, guildId, callback, i3, str, iGProSecurityResult);
                }
            });
        }
    }
}
