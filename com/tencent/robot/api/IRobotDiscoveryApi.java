package com.tencent.robot.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.robot.troop.discovery.TroopRobotDiscoveryLaunchArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/robot/api/IRobotDiscoveryApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/robot/troop/discovery/a;", "launchArgs", "", "launchTroopRobotDiscoveryPage", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes25.dex */
public interface IRobotDiscoveryApi extends QRouteApi {
    void launchTroopRobotDiscoveryPage(@NotNull TroopRobotDiscoveryLaunchArgs launchArgs);
}
