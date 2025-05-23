package com.tencent.robot.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotFeatureFetchType;
import com.tencent.qqnt.kernel.nativeinterface.RobotFeatureReq;
import com.tencent.robot.api.IRobotPersonalInfoApi;
import com.tencent.robot.api.IRobotProfileInfoApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/robot/api/impl/RobotPersonalInfoApiImpl;", "Lcom/tencent/robot/api/IRobotPersonalInfoApi;", "()V", "fetchRobotPersonalInfoFromServer", "", "robotUid", "", "callback", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupRobotProfileCallback;", "getRobotPersonalInfoFromLocal", "robotUin", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RobotPersonalInfoApiImpl implements IRobotPersonalInfoApi {
    @Override // com.tencent.robot.api.IRobotPersonalInfoApi
    public void fetchRobotPersonalInfoFromServer(@NotNull String robotUid, @NotNull IGetGroupRobotProfileCallback callback) {
        Intrinsics.checkNotNullParameter(robotUid, "robotUid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        RobotFeatureReq robotFeatureReq = new RobotFeatureReq();
        robotFeatureReq.robotUid = robotUid;
        robotFeatureReq.fetchType = RobotFeatureFetchType.KSERVER;
        ac a16 = u64.h.a();
        if (a16 != null) {
            a16.fetchRobotFeatureWithReq(robotFeatureReq, callback);
        }
    }

    @Override // com.tencent.robot.api.IRobotPersonalInfoApi
    public void getRobotPersonalInfoFromLocal(@NotNull String robotUin, @NotNull IGetGroupRobotProfileCallback callback) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).getRobotProfileInfoFromLocal(robotUin, null, callback);
    }
}
