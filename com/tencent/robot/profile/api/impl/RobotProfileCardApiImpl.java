package com.tencent.robot.profile.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.profile.RobotProfileFragment;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import com.tencent.robot.profile.utils.RobotProfileUtils;
import h44.OpenRobotProfileCardArgs;
import k44.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u64.a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0016J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\f\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/robot/profile/api/impl/RobotProfileCardApiImpl;", "Lcom/tencent/robot/profile/api/IRobotProfileCardApi;", "Lh44/a;", "profileCardArgs", "", "openRobotProfileCard", "", "robotUin", "troopUin", "getWebRobotProfileUrl", "Landroid/content/Context;", "context", "url", "", "shouldInterceptForRobotProfile", "Lkotlin/Function0;", "exitFunc", "shouldInterceptForRobotProfileNotOpen", "useNativeProfile", "Ljava/lang/Class;", "getRobotProfileCardJumpClass", "<init>", "()V", "Companion", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotProfileCardApiImpl implements IRobotProfileCardApi {

    @NotNull
    private static final String TAG = "robot.profile.RobotProfileApiImpl";

    @Override // com.tencent.robot.profile.api.IRobotProfileCardApi
    @NotNull
    public Class<?> getRobotProfileCardJumpClass() {
        return b.class;
    }

    @Override // com.tencent.robot.profile.api.IRobotProfileCardApi
    @NotNull
    public String getWebRobotProfileUrl(@Nullable String robotUin, @Nullable String troopUin) {
        return RobotProfileUtils.f368193a.m(robotUin, troopUin);
    }

    @Override // com.tencent.robot.profile.api.IRobotProfileCardApi
    public void openRobotProfileCard(@NotNull OpenRobotProfileCardArgs profileCardArgs) {
        boolean z16;
        View currentFocus;
        IBinder windowToken;
        Intrinsics.checkNotNullParameter(profileCardArgs, "profileCardArgs");
        String robotUin = profileCardArgs.getRobotUin();
        if (robotUin != null && robotUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e(TAG, 1, new IllegalArgumentException("robotUin is null"), new Object[0]);
            return;
        }
        if (profileCardArgs.getContext() instanceof Activity) {
            Context context = profileCardArgs.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            Window window = ((Activity) context).getWindow();
            if (window != null && (currentFocus = window.getCurrentFocus()) != null && (windowToken = currentFocus.getWindowToken()) != null) {
                Object systemService = profileCardArgs.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                ((InputMethodManager) systemService).hideSoftInputFromWindow(windowToken, 0);
            }
        }
        if (useNativeProfile()) {
            RobotProfileFragment.INSTANCE.b(profileCardArgs.getContext(), profileCardArgs.getTroopUin(), profileCardArgs.getRobotUin(), profileCardArgs.getSource(), !(profileCardArgs.getContext() instanceof Activity), profileCardArgs.getExposureId(), profileCardArgs.getBundle());
            return;
        }
        RobotProfileUtils robotProfileUtils = RobotProfileUtils.f368193a;
        Context context2 = profileCardArgs.getContext();
        String robotUin2 = profileCardArgs.getRobotUin();
        String troopUin = profileCardArgs.getTroopUin();
        if (troopUin == null) {
            troopUin = "";
        }
        robotProfileUtils.u(context2, robotUin2, troopUin);
    }

    @Override // com.tencent.robot.profile.api.IRobotProfileCardApi
    public boolean shouldInterceptForRobotProfile(@NotNull Context context, @NotNull String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        return RobotProfileUtils.E(RobotProfileUtils.f368193a, context, url, null, 4, null);
    }

    @Override // com.tencent.robot.profile.api.IRobotProfileCardApi
    public boolean shouldInterceptForRobotProfileNotOpen(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return RobotProfileUtils.f368193a.C(url).getFirst().booleanValue();
    }

    @Override // com.tencent.robot.profile.api.IRobotProfileCardApi
    public boolean useNativeProfile() {
        return a.b();
    }

    @Override // com.tencent.robot.profile.api.IRobotProfileCardApi
    public boolean shouldInterceptForRobotProfile(@NotNull Context context, @NotNull String url, @NotNull Function0<Unit> exitFunc) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(exitFunc, "exitFunc");
        return RobotProfileUtils.f368193a.D(context, url, exitFunc);
    }
}
