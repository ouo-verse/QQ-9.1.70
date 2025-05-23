package c54;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsBaseCollector;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotBaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.robot.aio.background.api.IRobotBackgroundApi;
import com.tencent.robot.aio.share.event.CloseSpecifiedRobotSplashAIOEvent;
import com.tencent.robot.api.IRobotProfileInfoApi;
import com.tencent.robot.api.RobotAIORouteArgs;
import com.tencent.robot.api.RouteFailedReason;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import com.tencent.robot.route.aio.api.IRouteToRobotAIOService;
import h44.OpenRobotProfileCardArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010$\u001a\u00020!\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0006\u0010 \u001a\u00020\u0002R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Lc54/g;", "", "", "o", "", "result", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "", "g", "", "errorMsg", ReportConstant.COSTREPORT_PREFIX, "j", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", h.F, "t", HippyTKDListViewAdapter.X, "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "coreInfo", "v", "u", "w", "Landroid/os/Bundle;", DomainData.DOMAIN_NAME, "isSuccess", "Lcom/tencent/robot/api/RouteFailedReason;", "failedReason", "i", "y", "Lcom/tencent/robot/api/c;", "a", "Lcom/tencent/robot/api/c;", "robotAIORouteArgs", "b", "Z", "hasDoCallback", "c", "isCanShowLoadingDialog", "Landroid/app/Dialog;", "d", "Landroid/app/Dialog;", "loadingDialog", "<init>", "(Lcom/tencent/robot/api/c;)V", "e", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotAIORouteArgs robotAIORouteArgs;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean hasDoCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isCanShowLoadingDialog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    public g(@NotNull RobotAIORouteArgs robotAIORouteArgs) {
        Intrinsics.checkNotNullParameter(robotAIORouteArgs, "robotAIORouteArgs");
        this.robotAIORouteArgs = robotAIORouteArgs;
        this.isCanShowLoadingDialog = true;
    }

    private final void A() {
        QQToast.makeText(BaseApplication.getContext(), R.string.f222356da, 0).show();
    }

    private final void B() {
        Activity activity = this.robotAIORouteArgs.getActivity();
        if (((activity instanceof Activity) && activity.isFinishing()) || !this.isCanShowLoadingDialog) {
            QLog.i("FetchAndJumpRobotAIORouter", 1, "showLoadingDialog return. robotUin = " + this.robotAIORouteArgs.getRobotUin());
            return;
        }
        this.isCanShowLoadingDialog = false;
        Dialog showLoadingDialog = DialogUtil.showLoadingDialog(activity, "\u52a0\u8f7d\u4e2d", true);
        this.loadingDialog = showLoadingDialog;
        Intrinsics.checkNotNull(showLoadingDialog);
        showLoadingDialog.show();
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: c54.d
            @Override // java.lang.Runnable
            public final void run() {
                g.C(g.this);
            }
        }, 5000L, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dialog dialog = this$0.loadingDialog;
        boolean z16 = false;
        if (dialog != null && dialog.isShowing()) {
            z16 = true;
        }
        if (z16) {
            this$0.A();
            this$0.h();
        }
    }

    private final boolean g(int result, GroupRobotProfile robotProfile) {
        long j3;
        String str;
        boolean z16;
        if (result == 0 && robotProfile != null) {
            RobotBaseInfo robotBaseInfo = robotProfile.robotData;
            if (robotBaseInfo != null) {
                j3 = robotBaseInfo.robotUin;
            } else {
                j3 = 0;
            }
            String str2 = null;
            if (robotBaseInfo == null || (str = robotBaseInfo.robotUid) == null) {
                str = null;
            }
            if (robotBaseInfo != null) {
                str2 = robotBaseInfo.name;
            }
            if (str2 == null) {
                str2 = "";
            }
            if (j3 != 0) {
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    return true;
                }
            }
            QLog.e("FetchAndJumpRobotAIORouter", 1, "checkRobotProfile false, robotUin = " + j3 + " robotUid = " + str + " robotName = " + str2);
        }
        return false;
    }

    private final void h() {
        this.isCanShowLoadingDialog = false;
        Dialog dialog = this.loadingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private final void i(boolean isSuccess, RouteFailedReason failedReason) {
        if (this.hasDoCallback) {
            return;
        }
        this.hasDoCallback = true;
        com.tencent.robot.api.a callback = this.robotAIORouteArgs.getCallback();
        if (callback != null) {
            callback.a(isSuccess, failedReason);
        }
    }

    private final void j(GroupRobotProfile robotProfile) {
        if (!Intrinsics.areEqual(this.robotAIORouteArgs.getOpenSource(), "0") && !t(robotProfile)) {
            w(robotProfile);
        } else {
            x(robotProfile);
            u(robotProfile);
        }
        i(true, RouteFailedReason.REASON_NONE);
    }

    private final void k() {
        if (!NetworkUtil.isNetSupport(this.robotAIORouteArgs.getActivity())) {
            QLog.i("FetchAndJumpRobotAIORouter", 1, "isNetSupport false return.");
            h();
            A();
            i(false, RouteFailedReason.REASON_NET_ERROR);
            return;
        }
        QLog.i("FetchAndJumpRobotAIORouter", 1, "fetchRobotProfileInfoFromServer robotUin = " + this.robotAIORouteArgs.getRobotUin());
        ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).fetchRobotProfileInfoFromServer(this.robotAIORouteArgs.getRobotUin(), this.robotAIORouteArgs.getTroopUin(), new IGetGroupRobotProfileCallback() { // from class: c54.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
            public final void onResult(int i3, String str, GroupRobotProfile groupRobotProfile) {
                g.l(g.this, i3, str, groupRobotProfile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final g this$0, final int i3, final String str, final GroupRobotProfile groupRobotProfile) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: c54.f
            @Override // java.lang.Runnable
            public final void run() {
                g.m(g.this, i3, str, groupRobotProfile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(g this$0, int i3, String str, GroupRobotProfile robotProfile) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(robotProfile, "robotProfile");
        this$0.s(i3, str, robotProfile);
    }

    private final Bundle n(GroupRobotProfile robotProfile) {
        boolean z16;
        Bundle bundle = this.robotAIORouteArgs.getBundle();
        bundle.putLong("key_peerUin", robotProfile.robotData.robotUin);
        bundle.putString("key_robot_aio_scene", this.robotAIORouteArgs.getScene());
        bundle.putString("key_robot_callback_data", this.robotAIORouteArgs.getCallbackData());
        bundle.putString("key_from", this.robotAIORouteArgs.getOpenSource());
        bundle.putString(WSStatisticsBaseCollector.KEY_REF_PAGE_ID, "");
        bundle.putString("key_day_color", robotProfile.dayColor);
        bundle.putString("key_night_color", robotProfile.nightColor);
        bundle.putString("key_avatar_dominantColor", robotProfile.avatarDominantColor);
        bundle.putString("key_day_bg", robotProfile.c2cDayBackground);
        bundle.putString("key_night_bg", robotProfile.c2cNightBackground);
        bundle.putString("key_day_dynamic_bg", robotProfile.dayDynamicPic);
        bundle.putString("key_night_dynamic_bg", robotProfile.nightDynamicPic);
        if (robotProfile.aioConfig.supportHalfScreenSwitch != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        bundle.putBoolean("key_support_half_screen", z16);
        bundle.putBoolean("key_support_tts", u64.d.d(robotProfile));
        bundle.putBoolean("key_support_auto_tts", u64.d.b(robotProfile));
        bundle.putBoolean("key_support_wide_sceen", u64.d.e(robotProfile));
        return bundle;
    }

    private final void o() {
        QLog.i("FetchAndJumpRobotAIORouter", 1, "getRobotProfileInfoFromLocal robotUin = " + this.robotAIORouteArgs.getRobotUin());
        ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).getRobotProfileInfoFromLocal(this.robotAIORouteArgs.getRobotUin(), null, new IGetGroupRobotProfileCallback() { // from class: c54.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
            public final void onResult(int i3, String str, GroupRobotProfile groupRobotProfile) {
                g.p(g.this, i3, str, groupRobotProfile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(g this$0, int i3, String str, GroupRobotProfile groupRobotProfile) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q(i3, groupRobotProfile);
    }

    private final void q(int result, final GroupRobotProfile robotProfile) {
        QLog.i("FetchAndJumpRobotAIORouter", 1, "handleGetRobotProfileInfoFromLocal robotUin = " + this.robotAIORouteArgs.getRobotUin());
        if (g(result, robotProfile)) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: c54.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.r(g.this, robotProfile);
                }
            });
        } else {
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(g this$0, GroupRobotProfile groupRobotProfile) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h();
        Intrinsics.checkNotNull(groupRobotProfile);
        this$0.j(groupRobotProfile);
    }

    private final void s(int result, String errorMsg, GroupRobotProfile robotProfile) {
        IRuntimeService iRuntimeService;
        QLog.i("FetchAndJumpRobotAIORouter", 1, "handleGetRobotProfileRsp result = " + result + " errorMsg = " + errorMsg);
        h();
        if (g(result, robotProfile)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                iRuntimeService = peekAppRuntime.getRuntimeService(IRouteToRobotAIOService.class, "");
            } else {
                iRuntimeService = null;
            }
            IRouteToRobotAIOService iRouteToRobotAIOService = (IRouteToRobotAIOService) iRuntimeService;
            if (iRouteToRobotAIOService != null) {
                iRouteToRobotAIOService.addFetchedRobotUinToCache(this.robotAIORouteArgs.getRobotUin());
            }
            j(robotProfile);
            return;
        }
        A();
        i(false, RouteFailedReason.REASON_NET_ERROR);
    }

    private final boolean t(GroupRobotProfile robotProfile) {
        RobotBaseInfo robotBaseInfo = robotProfile.robotData;
        if (robotBaseInfo != null) {
            return robotBaseInfo.allowedAddC2C;
        }
        return false;
    }

    private final void u(GroupRobotProfile robotProfile) {
        String str;
        String str2;
        QLog.i("FetchAndJumpRobotAIORouter", 1, "navigateToAIO robotUin = " + robotProfile.robotData.robotUin + ", scaleAIO = " + this.robotAIORouteArgs.getIsOpenScaleAIO());
        if (this.robotAIORouteArgs.getIsOpenScaleAIO()) {
            IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
            Activity activity = this.robotAIORouteArgs.getActivity();
            String str3 = robotProfile.robotData.robotUid;
            Intrinsics.checkNotNullExpressionValue(str3, "robotProfile.robotData.robotUid");
            String str4 = robotProfile.robotData.name;
            if (str4 == null) {
                str2 = "";
            } else {
                str2 = str4;
            }
            iAIOStarterApi.navigateToScaleAIO(activity, 1, str3, str2, n(robotProfile));
            return;
        }
        IAIOStarterApi iAIOStarterApi2 = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
        Activity activity2 = this.robotAIORouteArgs.getActivity();
        RobotBaseInfo robotBaseInfo = robotProfile.robotData;
        String robotUid = robotBaseInfo.robotUid;
        String str5 = robotBaseInfo.name;
        if (str5 == null) {
            str = "";
        } else {
            str = str5;
        }
        long j3 = robotBaseInfo.robotUin;
        Bundle n3 = n(robotProfile);
        Intrinsics.checkNotNullExpressionValue(robotUid, "robotUid");
        iAIOStarterApi2.navigateToAIOActivity(activity2, 1, robotUid, str, 67108864, j3, n3);
        SimpleEventBus.getInstance().dispatchEvent(new CloseSpecifiedRobotSplashAIOEvent(robotProfile.robotData.robotUin));
    }

    private final void v(RobotCoreInfo coreInfo) {
        String str;
        String str2;
        QLog.i("FetchAndJumpRobotAIORouter", 1, "navigateToAIO robotUin = " + coreInfo.robotUin + ", scaleAIO = " + this.robotAIORouteArgs.getIsOpenScaleAIO());
        Bundle bundle = this.robotAIORouteArgs.getBundle();
        bundle.putLong("key_peerUin", coreInfo.robotUin);
        bundle.putString("key_robot_aio_scene", this.robotAIORouteArgs.getScene());
        bundle.putString("key_robot_callback_data", this.robotAIORouteArgs.getCallbackData());
        bundle.putString("key_from", this.robotAIORouteArgs.getOpenSource());
        if (this.robotAIORouteArgs.getIsOpenScaleAIO()) {
            IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
            Activity activity = this.robotAIORouteArgs.getActivity();
            String str3 = coreInfo.uid;
            Intrinsics.checkNotNullExpressionValue(str3, "coreInfo.uid");
            String str4 = coreInfo.name;
            if (str4 == null) {
                str2 = "";
            } else {
                str2 = str4;
            }
            iAIOStarterApi.navigateToScaleAIO(activity, 1, str3, str2, bundle);
            return;
        }
        IAIOStarterApi iAIOStarterApi2 = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
        Activity activity2 = this.robotAIORouteArgs.getActivity();
        String uid = coreInfo.uid;
        String str5 = coreInfo.name;
        if (str5 == null) {
            str = "";
        } else {
            str = str5;
        }
        long j3 = coreInfo.robotUin;
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        iAIOStarterApi2.navigateToAIOActivity(activity2, 1, uid, str, 67108864, j3, bundle);
        SimpleEventBus.getInstance().dispatchEvent(new CloseSpecifiedRobotSplashAIOEvent(coreInfo.robotUin));
    }

    private final void w(GroupRobotProfile robotProfile) {
        QLog.i("FetchAndJumpRobotAIORouter", 1, "openRobotProfileCard robotUin = " + this.robotAIORouteArgs.getRobotUin());
        IRobotProfileCardApi iRobotProfileCardApi = (IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class);
        Activity activity = this.robotAIORouteArgs.getActivity();
        String robotUin = this.robotAIORouteArgs.getRobotUin();
        String troopUin = this.robotAIORouteArgs.getTroopUin();
        Bundle bundle = new Bundle();
        bundle.putString("key_day_color", com.tencent.robot.profile.utils.a.k(robotProfile, true));
        bundle.putString("key_night_color", com.tencent.robot.profile.utils.a.r(robotProfile, true));
        bundle.putString("key_avatar_dominantColor", robotProfile.avatarDominantColor);
        bundle.putString("key_day_bg", com.tencent.robot.profile.utils.a.i(robotProfile, true));
        bundle.putString("key_night_bg", com.tencent.robot.profile.utils.a.p(robotProfile, true));
        bundle.putString("key_day_dynamic_bg", com.tencent.robot.profile.utils.a.m(robotProfile, true));
        bundle.putString("key_night_dynamic_bg", com.tencent.robot.profile.utils.a.t(robotProfile, true));
        Unit unit = Unit.INSTANCE;
        iRobotProfileCardApi.openRobotProfileCard(new OpenRobotProfileCardArgs(activity, robotUin, troopUin, 0, 0, bundle, 24, null));
    }

    private final void x(GroupRobotProfile robotProfile) {
        ((IRobotBackgroundApi) QRoute.api(IRobotBackgroundApi.class)).preloadRobotBackground(robotProfile, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B();
    }

    public final void y() {
        boolean z16;
        IRuntimeService iRuntimeService;
        boolean z17 = false;
        if (FastClickUtils.isFastDoubleClick("FetchAndJumpRobotAIORouter", 500L)) {
            QLog.i("FetchAndJumpRobotAIORouter", 1, "isFastDoubleClick return. robotUin = " + this.robotAIORouteArgs.getRobotUin());
            i(false, RouteFailedReason.REASON_FREQUENCY);
            return;
        }
        if (this.robotAIORouteArgs.getRobotUin().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("FetchAndJumpRobotAIORouter", 1, "fetchAndJumpToRobotAIO args error!");
            i(false, RouteFailedReason.REASON_ARGS_ERROR);
            return;
        }
        RobotCoreInfo robotCoreInfoFromFriendsCache = ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).getRobotCoreInfoFromFriendsCache(this.robotAIORouteArgs.getRobotUin());
        if (robotCoreInfoFromFriendsCache != null && robotCoreInfoFromFriendsCache.robotUin != 0) {
            v(robotCoreInfoFromFriendsCache);
            i(true, RouteFailedReason.REASON_NONE);
            return;
        }
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: c54.a
            @Override // java.lang.Runnable
            public final void run() {
                g.z(g.this);
            }
        }, 300L, true);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRouteToRobotAIOService.class, "");
        } else {
            iRuntimeService = null;
        }
        IRouteToRobotAIOService iRouteToRobotAIOService = (IRouteToRobotAIOService) iRuntimeService;
        if (iRouteToRobotAIOService != null && iRouteToRobotAIOService.isFetchedForRouteToAIO(this.robotAIORouteArgs.getRobotUin())) {
            z17 = true;
        }
        if (!z17 && !Intrinsics.areEqual(this.robotAIORouteArgs.getOpenSource(), "0") && NetworkUtil.isNetSupport(this.robotAIORouteArgs.getActivity())) {
            k();
        } else {
            o();
        }
    }
}
