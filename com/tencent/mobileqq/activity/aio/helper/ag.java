package com.tencent.mobileqq.activity.aio.helper;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopExtDBInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.troopidentity.api.ITroopIdentityApi;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.aio.nick.AIONickMsgIntent;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\b*\u0001\"\b\u0007\u0018\u0000 \r2\u00020\u00012\u00020\u0002:\u0001(B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J(\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/helper/ag;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "g", "", "troopUin", "memberUin", "", "isShowLevel", "isShowRank", tl.h.F, DomainData.DOMAIN_NAME, "k", "", "getId", "getTag", "state", "onMoveToState", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "e", "Ljava/lang/String;", "mTroopUin", "com/tencent/mobileqq/activity/aio/helper/ag$b", "f", "Lcom/tencent/mobileqq/activity/aio/helper/ag$b;", "mAction", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class ag implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mTroopUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/activity/aio/helper/ag$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            ag.this.g(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(MsgIntent msgIntent) {
        if (msgIntent instanceof AIONickMsgIntent.MemberLevelClickMsgIntent) {
            AIONickMsgIntent.MemberLevelClickMsgIntent memberLevelClickMsgIntent = (AIONickMsgIntent.MemberLevelClickMsgIntent) msgIntent;
            h(memberLevelClickMsgIntent.b(), memberLevelClickMsgIntent.a(), memberLevelClickMsgIntent.c(), memberLevelClickMsgIntent.d());
        }
    }

    private final void h(final String troopUin, final String memberUin, final boolean isShowLevel, final boolean isShowRank) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.ae
            @Override // java.lang.Runnable
            public final void run() {
                ag.i(troopUin, this, memberUin, isShowLevel, isShowRank);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final String troopUin, final ag this$0, final String memberUin, final boolean z16, final boolean z17) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(memberUin, "$memberUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        TroopInfo troopInfo = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(ITroopInfoService.class, "");
        } else {
            iRuntimeService = null;
        }
        ITroopInfoService iTroopInfoService = (ITroopInfoService) iRuntimeService;
        if (iTroopInfoService != null) {
            troopInfo = iTroopInfoService.findTroopInfo(troopUin);
        }
        if (troopInfo != null && !troopInfo.isQidianPrivateTroop() && !troopInfo.isPassiveExit()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.af
                @Override // java.lang.Runnable
                public final void run() {
                    ag.j(troopUin, this$0, memberUin, z16, z17);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(String troopUin, ag this$0, String memberUin, boolean z16, boolean z17) {
        FragmentActivity activity;
        AppInterface appInterface;
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(memberUin, "$memberUin");
        String str = this$0.mTroopUin;
        IRuntimeService iRuntimeService = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
            str = null;
        }
        if (Intrinsics.areEqual(troopUin, str)) {
            com.tencent.aio.api.runtime.a aVar = this$0.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            Fragment c16 = aVar.c();
            if (c16 != null && (activity = c16.getActivity()) != null) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime instanceof AppInterface) {
                    appInterface = (AppInterface) peekAppRuntime;
                } else {
                    appInterface = null;
                }
                if (appInterface != null) {
                    iRuntimeService = appInterface.getRuntimeService(ITroopRobotService.class, "");
                }
                ITroopRobotService iTroopRobotService = (ITroopRobotService) iRuntimeService;
                boolean z18 = false;
                if (iTroopRobotService != null && iTroopRobotService.checkAndProcessJumpRobotPage(activity, troopUin, Long.parseLong(memberUin))) {
                    z18 = true;
                }
                if (z18) {
                    return;
                }
                QRouteApi api = QRoute.api(ITroopIdentityApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(ITroopIdentityApi::class.java)");
                ITroopIdentityApi.a.a((ITroopIdentityApi) api, activity, troopUin, memberUin, null, 8, null);
                this$0.n(z16, z17);
            }
        }
    }

    private final void k() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.ad
            @Override // java.lang.Runnable
            public final void run() {
                ag.m(ag.this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ag this$0) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        TroopInfo troopInfo;
        byte b16;
        boolean z16;
        byte b17;
        TroopExtDBInfo troopExtDBInfo;
        TroopExtDBInfo troopExtDBInfo2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean simpleUISwitch = SimpleUIUtil.getSimpleUISwitch();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Boolean bool = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(ITroopInfoService.class, "");
        } else {
            iRuntimeService = null;
        }
        ITroopInfoService iTroopInfoService = (ITroopInfoService) iRuntimeService;
        if (iTroopInfoService != null) {
            String str = this$0.mTroopUin;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
                str = null;
            }
            troopInfo = iTroopInfoService.findTroopInfo(str);
        } else {
            troopInfo = null;
        }
        boolean z17 = false;
        if (troopInfo != null && (troopExtDBInfo2 = troopInfo.extDBInfo) != null) {
            b16 = troopExtDBInfo2.cGroupRankUserFlag;
        } else {
            b16 = 0;
        }
        if (b16 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (troopInfo != null && (troopExtDBInfo = troopInfo.extDBInfo) != null) {
            b17 = troopExtDBInfo.cNewGroupRankUserFlag;
        } else {
            b17 = 1;
        }
        if (b17 == 0) {
            z17 = true;
        }
        if (troopInfo != null) {
            bool = Boolean.valueOf(troopInfo.isTroopHonorOpen());
        }
        QLog.i("TroopAIONickIconHelper", 1, "[logTroopNickIconRelatedInfo] isSimpleUI:" + simpleUISwitch + ", showUserRankFlag:" + z16 + ", troopHonorSwitch:" + bool + ", showUserLevelFlag:" + z17 + ", ");
    }

    private final void n(boolean isShowLevel, boolean isShowRank) {
        int i3;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (isShowLevel && isShowRank) {
            i3 = 3;
        } else if (isShowLevel) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800B200", "0X800B200", i3, 0, "", "", "", "");
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350671s0;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.aio.nick.AIONickMsgIntent.MemberLevelClickMsgIntent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "TroopAIONickIconHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{1};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        com.tencent.aio.api.runtime.a aVar = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        this.mTroopUin = a16.g().r().c().j();
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar2;
        }
        aVar.e().f(this, this.mAction);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().i(this, this.mAction);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 1) {
            k();
        }
    }
}
