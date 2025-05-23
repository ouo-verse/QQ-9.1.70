package com.tencent.robot.aio.background.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.robot.aio.background.api.IRobotBackgroundService;
import com.tencent.robot.aio.background.api.impl.RobotBackgroundServiceImpl;
import com.tencent.robot.api.IRobotProfileInfoApi;
import com.tencent.robot.profile.utils.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J$\u0010\u0010\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\"\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/robot/aio/background/api/impl/RobotBackgroundServiceImpl;", "Lcom/tencent/robot/aio/background/api/IRobotBackgroundService;", "", "robotUin", "url", "", "setNormalBackgroundUrlToMMKV", "setNightBackgroundUrlToMMKV", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "robotCoreInfo", "", "isProfile", "getBackgroundUrlFromCache", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupRobotProfileCallback;", "callback", "loadBackgroundAsync", "cleanRobotBackground", "<init>", "()V", "Companion", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotBackgroundServiceImpl implements IRobotBackgroundService {

    @NotNull
    private static final String KEY_NIGHT_BACKGROUND = "_key_night_background_";

    @NotNull
    private static final String KEY_NORMAL_BACKGROUND = "_key_normal_background_";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadBackgroundAsync$lambda$1(final IGetGroupRobotProfileCallback callback, final int i3, final String str, final GroupRobotProfile groupRobotProfile) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: f24.c
            @Override // java.lang.Runnable
            public final void run() {
                RobotBackgroundServiceImpl.loadBackgroundAsync$lambda$1$lambda$0(IGetGroupRobotProfileCallback.this, i3, str, groupRobotProfile);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadBackgroundAsync$lambda$1$lambda$0(IGetGroupRobotProfileCallback callback, int i3, String str, GroupRobotProfile groupRobotProfile) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.onResult(i3, str, groupRobotProfile);
    }

    private final void setNightBackgroundUrlToMMKV(String robotUin, String url) {
        boolean z16;
        String str;
        boolean z17 = false;
        if (robotUin != null && robotUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        if (url == null || url.length() == 0) {
            z17 = true;
        }
        if (z17) {
            from.removeKey(str + KEY_NIGHT_BACKGROUND + robotUin);
            return;
        }
        from.encodeString(str + KEY_NIGHT_BACKGROUND + robotUin, url);
    }

    private final void setNormalBackgroundUrlToMMKV(String robotUin, String url) {
        boolean z16;
        String str;
        boolean z17 = false;
        if (robotUin != null && robotUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        if (url == null || url.length() == 0) {
            z17 = true;
        }
        if (z17) {
            from.removeKey(str + KEY_NORMAL_BACKGROUND + robotUin);
            return;
        }
        from.encodeString(str + KEY_NORMAL_BACKGROUND + robotUin, url);
    }

    @Override // com.tencent.robot.aio.background.api.IRobotBackgroundService
    public void cleanRobotBackground(@Nullable String robotUin) {
        boolean z16;
        if (robotUin != null && robotUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        setNormalBackgroundUrlToMMKV(robotUin, null);
        setNightBackgroundUrlToMMKV(robotUin, null);
    }

    @Override // com.tencent.robot.aio.background.api.IRobotBackgroundService
    @NotNull
    public String getBackgroundUrlFromCache(@Nullable String robotUin, @Nullable RobotCoreInfo robotCoreInfo, boolean isProfile) {
        boolean z16;
        if (robotUin != null && robotUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return "";
        }
        if (robotCoreInfo == null && (robotCoreInfo = ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).getRobotCoreInfoFromFriendsCache(robotUin)) == null) {
            return "";
        }
        if (QQTheme.isNowThemeIsNight()) {
            return a.q(robotCoreInfo, isProfile);
        }
        return a.j(robotCoreInfo, isProfile);
    }

    @Override // com.tencent.robot.aio.background.api.IRobotBackgroundService
    public void loadBackgroundAsync(@NotNull String robotUin, @Nullable String troopUin, @NotNull final IGetGroupRobotProfileCallback callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (robotUin.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).getRobotProfileInfoFromLocal(robotUin, troopUin, new IGetGroupRobotProfileCallback() { // from class: f24.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
            public final void onResult(int i3, String str, GroupRobotProfile groupRobotProfile) {
                RobotBackgroundServiceImpl.loadBackgroundAsync$lambda$1(IGetGroupRobotProfileCallback.this, i3, str, groupRobotProfile);
            }
        });
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
