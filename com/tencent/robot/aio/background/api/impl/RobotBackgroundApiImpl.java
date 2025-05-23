package com.tencent.robot.aio.background.api.impl;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotBaseInfo;
import com.tencent.robot.aio.background.api.IRobotBackgroundApi;
import com.tencent.robot.aio.background.api.IRobotBackgroundService;
import com.tencent.robot.aio.background.api.impl.RobotBackgroundApiImpl;
import com.tencent.robot.api.IRobotIdentityApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u001a\u0010\u0010\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u001a\u0010\u0010\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\u0006H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/robot/aio/background/api/impl/RobotBackgroundApiImpl;", "Lcom/tencent/robot/aio/background/api/IRobotBackgroundApi;", "", "uin", "", "chatType", "", "checkImmersiveAIO", "(Ljava/lang/String;Ljava/lang/Integer;)Z", "Landroid/graphics/drawable/Drawable;", "getDefaultBackgroundDrawable", "backgroundUrl", "decodeFile", "", "preloadRobotBackgroundUrl", "robotUin", "preloadRobotBackground", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "<init>", "()V", "Companion", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotBackgroundApiImpl implements IRobotBackgroundApi {

    @NotNull
    private static final String TAG = "RobotBackgroundApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preloadRobotBackground$lambda$0(String backgroundUrl, RobotBackgroundApiImpl this$0, boolean z16, String profileBackgroundUrl, int i3, String str, GroupRobotProfile groupRobotProfile) {
        String str2;
        boolean z17;
        String str3;
        Intrinsics.checkNotNullParameter(backgroundUrl, "$backgroundUrl");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(profileBackgroundUrl, "$profileBackgroundUrl");
        if (QQTheme.isNowThemeIsNight()) {
            if (groupRobotProfile != null) {
                str2 = groupRobotProfile.c2cNightBackground;
            }
            str2 = null;
        } else {
            if (groupRobotProfile != null) {
                str2 = groupRobotProfile.c2cDayBackground;
            }
            str2 = null;
        }
        boolean z18 = true;
        if (str2 != null && str2.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17 && !Intrinsics.areEqual(str2, backgroundUrl)) {
            this$0.preloadRobotBackgroundUrl(str2, z16);
        }
        if (QQTheme.isNowThemeIsNight()) {
            str3 = groupRobotProfile.infoBg.nightPic;
        } else {
            str3 = groupRobotProfile.infoBg.dayPic;
        }
        if (str3 != null && str3.length() != 0) {
            z18 = false;
        }
        if (!z18 && !Intrinsics.areEqual(str3, profileBackgroundUrl)) {
            IRobotBackgroundApi.a.b(this$0, str3, false, 2, null);
        }
    }

    @Override // com.tencent.robot.aio.background.api.IRobotBackgroundApi
    public boolean checkImmersiveAIO(@Nullable String uin, @Nullable Integer chatType) {
        boolean z16;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("robot_9050_116824078", true)) {
            return false;
        }
        if (uin != null && uin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && chatType != null) {
            QRouteApi api = QRoute.api(IRobotIdentityApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IRobotIdentityApi::class.java)");
            IRobotIdentityApi iRobotIdentityApi = (IRobotIdentityApi) api;
            if (iRobotIdentityApi.isMatchRobotChatType(chatType) && iRobotIdentityApi.isRobotUin(uin)) {
                return true;
            }
            return false;
        }
        QLog.i(TAG, 1, "checkImmersiveAIO false args error");
        return false;
    }

    @Override // com.tencent.robot.aio.background.api.IRobotBackgroundApi
    @NotNull
    public Drawable getDefaultBackgroundDrawable() {
        return new ColorDrawable(ContextCompat.getColor(BaseApplication.getContext(), R.color.qui_common_bg_aio_01));
    }

    @Override // com.tencent.robot.aio.background.api.IRobotBackgroundApi
    public void preloadRobotBackground(@Nullable String robotUin, final boolean decodeFile) {
        final String str;
        final String str2;
        if (robotUin == null || robotUin.length() == 0) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRobotBackgroundService iRobotBackgroundService = (IRobotBackgroundService) (peekAppRuntime != null ? peekAppRuntime.getRuntimeService(IRobotBackgroundService.class, "") : null);
        if (iRobotBackgroundService == null || (str = IRobotBackgroundService.a.a(iRobotBackgroundService, robotUin, null, false, 6, null)) == null) {
            str = "";
        }
        if (str.length() > 0) {
            preloadRobotBackgroundUrl(str, decodeFile);
        }
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        IRobotBackgroundService iRobotBackgroundService2 = (IRobotBackgroundService) (peekAppRuntime2 != null ? peekAppRuntime2.getRuntimeService(IRobotBackgroundService.class, "") : null);
        if (iRobotBackgroundService2 == null || (str2 = IRobotBackgroundService.a.a(iRobotBackgroundService2, robotUin, null, true, 2, null)) == null) {
            str2 = "";
        }
        if (str2.length() > 0) {
            preloadRobotBackgroundUrl(str2, decodeFile);
        }
        AppRuntime peekAppRuntime3 = MobileQQ.sMobileQQ.peekAppRuntime();
        IRobotBackgroundService iRobotBackgroundService3 = (IRobotBackgroundService) (peekAppRuntime3 != null ? peekAppRuntime3.getRuntimeService(IRobotBackgroundService.class, "") : null);
        if (iRobotBackgroundService3 != null) {
            iRobotBackgroundService3.loadBackgroundAsync(robotUin, null, new IGetGroupRobotProfileCallback() { // from class: f24.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
                public final void onResult(int i3, String str3, GroupRobotProfile groupRobotProfile) {
                    RobotBackgroundApiImpl.preloadRobotBackground$lambda$0(str, this, decodeFile, str2, i3, str3, groupRobotProfile);
                }
            });
        }
    }

    @Override // com.tencent.robot.aio.background.api.IRobotBackgroundApi
    public void preloadRobotBackgroundUrl(@Nullable String backgroundUrl, boolean decodeFile) {
        boolean z16;
        if (backgroundUrl != null && backgroundUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Drawable defaultBackgroundDrawable = getDefaultBackgroundDrawable();
        Option url = Option.obtain().setUrl(backgroundUrl);
        url.setLoadingDrawable(defaultBackgroundDrawable);
        url.setFailedDrawable(defaultBackgroundDrawable);
        QQPicLoader.f201806a.d().download(url, null);
    }

    @Override // com.tencent.robot.aio.background.api.IRobotBackgroundApi
    public void preloadRobotBackground(@Nullable GroupRobotProfile robotProfile, boolean decodeFile) {
        String str;
        String str2;
        RobotBaseInfo robotBaseInfo;
        String l3 = (robotProfile == null || (robotBaseInfo = robotProfile.robotData) == null) ? null : Long.valueOf(robotBaseInfo.robotUin).toString();
        if (l3 == null || l3.length() == 0) {
            return;
        }
        if (QQTheme.isNowThemeIsNight()) {
            str = robotProfile.c2cNightBackground;
        } else {
            str = robotProfile.c2cDayBackground;
        }
        if (!(!(str == null || str.length() == 0))) {
            str = null;
        }
        if (str != null) {
            preloadRobotBackgroundUrl(str, decodeFile);
        }
        if (QQTheme.isNowThemeIsNight()) {
            str2 = robotProfile.infoBg.nightPic;
        } else {
            str2 = robotProfile.infoBg.dayPic;
        }
        String str3 = (str2 == null || str2.length() == 0) ^ true ? str2 : null;
        if (str3 != null) {
            preloadRobotBackgroundUrl(str3, decodeFile);
        }
    }
}
