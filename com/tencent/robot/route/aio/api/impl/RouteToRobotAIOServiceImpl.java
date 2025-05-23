package com.tencent.robot.route.aio.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.robot.route.aio.api.IRouteToRobotAIOService;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016R2\u0010\u0003\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/route/aio/api/impl/RouteToRobotAIOServiceImpl;", "Lcom/tencent/robot/route/aio/api/IRouteToRobotAIOService;", "()V", "fetchedRobotUinSet", "", "", "kotlin.jvm.PlatformType", "", "addFetchedRobotUinToCache", "", "robotUin", "isFetchedForRouteToAIO", "", "onCreate", "appRuntime", "Lmqq/app/AppRuntime;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RouteToRobotAIOServiceImpl implements IRouteToRobotAIOService {
    private final Set<String> fetchedRobotUinSet = Collections.synchronizedSet(new HashSet());

    @Override // com.tencent.robot.route.aio.api.IRouteToRobotAIOService
    public void addFetchedRobotUinToCache(@Nullable String robotUin) {
        boolean z16;
        if (robotUin != null && robotUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        this.fetchedRobotUinSet.add(robotUin);
    }

    @Override // com.tencent.robot.route.aio.api.IRouteToRobotAIOService
    public boolean isFetchedForRouteToAIO(@Nullable String robotUin) {
        boolean z16;
        if (robotUin != null && robotUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || !this.fetchedRobotUinSet.contains(robotUin)) {
            return false;
        }
        return true;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        this.fetchedRobotUinSet.clear();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.fetchedRobotUinSet.clear();
    }
}
