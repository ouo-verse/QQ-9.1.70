package com.tencent.robot.profile.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import h44.OpenRobotProfileCardArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001c\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H&J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H&J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH&J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H&J\b\u0010\u0012\u001a\u00020\rH&J\f\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0013H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/profile/api/IRobotProfileCardApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lh44/a;", "profileCardArgs", "", "openRobotProfileCard", "", "robotUin", "troopUin", "getWebRobotProfileUrl", "Landroid/content/Context;", "context", "url", "", "shouldInterceptForRobotProfile", "Lkotlin/Function0;", "exitFunc", "shouldInterceptForRobotProfileNotOpen", "useNativeProfile", "Ljava/lang/Class;", "getRobotProfileCardJumpClass", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRobotProfileCardApi extends QRouteApi {
    @NotNull
    Class<?> getRobotProfileCardJumpClass();

    @NotNull
    String getWebRobotProfileUrl(@Nullable String robotUin, @Nullable String troopUin);

    void openRobotProfileCard(@NotNull OpenRobotProfileCardArgs profileCardArgs);

    boolean shouldInterceptForRobotProfile(@NotNull Context context, @NotNull String url);

    boolean shouldInterceptForRobotProfile(@NotNull Context context, @NotNull String url, @NotNull Function0<Unit> exitFunc);

    boolean shouldInterceptForRobotProfileNotOpen(@NotNull String url);

    boolean useNativeProfile();
}
