package com.tencent.robot.api.impl;

import com.tencent.robot.api.IRobotDiscoveryApi;
import com.tencent.robot.discoveryv2.troop.fragment.TroopRobotFragment;
import com.tencent.robot.troop.discovery.TroopRobotDiscoveryLaunchArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/api/impl/RobotDiscoveryApiImpl;", "Lcom/tencent/robot/api/IRobotDiscoveryApi;", "Lcom/tencent/robot/troop/discovery/a;", "launchArgs", "", "launchTroopRobotDiscoveryPage", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotDiscoveryApiImpl implements IRobotDiscoveryApi {
    @Override // com.tencent.robot.api.IRobotDiscoveryApi
    public void launchTroopRobotDiscoveryPage(@NotNull TroopRobotDiscoveryLaunchArgs launchArgs) {
        Intrinsics.checkNotNullParameter(launchArgs, "launchArgs");
        TroopRobotFragment.INSTANCE.a(launchArgs);
    }
}
