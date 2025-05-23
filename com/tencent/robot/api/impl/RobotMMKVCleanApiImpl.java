package com.tencent.robot.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.robot.aio.background.api.IRobotBackgroundService;
import com.tencent.robot.api.IRobotInputStyleConfigApi;
import com.tencent.robot.api.IRobotMMKVCleanApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/api/impl/RobotMMKVCleanApiImpl;", "Lcom/tencent/robot/api/IRobotMMKVCleanApi;", "()V", "cleanRobotMMKV", "", "robotUin", "", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RobotMMKVCleanApiImpl implements IRobotMMKVCleanApi {
    @Override // com.tencent.robot.api.IRobotMMKVCleanApi
    public void cleanRobotMMKV(@NotNull String robotUin) {
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotBackgroundService.class, "");
        } else {
            iRuntimeService = null;
        }
        IRobotBackgroundService iRobotBackgroundService = (IRobotBackgroundService) iRuntimeService;
        if (iRobotBackgroundService != null) {
            iRobotBackgroundService.cleanRobotBackground(robotUin);
        }
        ((IRobotInputStyleConfigApi) QRoute.api(IRobotInputStyleConfigApi.class)).deleteInputStyleConfigFromMMKV(robotUin);
    }
}
