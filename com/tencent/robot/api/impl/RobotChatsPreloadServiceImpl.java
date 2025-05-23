package com.tencent.robot.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.robot.aio.background.api.IRobotBackgroundApi;
import com.tencent.robot.api.IRobotChatsPreloadService;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0016R2\u0010\u0003\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/api/impl/RobotChatsPreloadServiceImpl;", "Lcom/tencent/robot/api/IRobotChatsPreloadService;", "()V", "preloadBackgroundSet", "", "", "kotlin.jvm.PlatformType", "", "onCreate", "", "appRuntime", "Lmqq/app/AppRuntime;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "preloadRobotBackgroundForChats", "robotUin", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RobotChatsPreloadServiceImpl implements IRobotChatsPreloadService {
    private final Set<String> preloadBackgroundSet = Collections.synchronizedSet(new HashSet());

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.preloadBackgroundSet.clear();
    }

    @Override // com.tencent.robot.api.IRobotChatsPreloadService
    public void preloadRobotBackgroundForChats(@Nullable String robotUin) {
        boolean z16;
        if (robotUin != null && robotUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !this.preloadBackgroundSet.contains(robotUin)) {
            this.preloadBackgroundSet.add(robotUin);
            QRouteApi api = QRoute.api(IRobotBackgroundApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IRobotBackgroundApi::class.java)");
            IRobotBackgroundApi.a.a((IRobotBackgroundApi) api, robotUin, false, 2, null);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
    }
}
