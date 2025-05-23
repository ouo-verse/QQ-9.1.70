package com.tencent.robot.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/api/IRobotPersonalInfoApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "fetchRobotPersonalInfoFromServer", "", "robotUid", "", "callback", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupRobotProfileCallback;", "getRobotPersonalInfoFromLocal", "robotUin", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes25.dex */
public interface IRobotPersonalInfoApi extends QRouteApi {
    void fetchRobotPersonalInfoFromServer(@NotNull String robotUid, @NotNull IGetGroupRobotProfileCallback callback);

    void getRobotPersonalInfoFromLocal(@NotNull String robotUin, @NotNull IGetGroupRobotProfileCallback callback);
}
