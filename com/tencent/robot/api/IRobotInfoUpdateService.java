package com.tencent.robot.api;

import bt2.d;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import java.util.List;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&J\u0016\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\u001e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/api/IRobotInfoUpdateService;", "Lmqq/app/api/IRuntimeService;", "", "initUpdateListener", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "onFetchRobotProfile", "", "robotUin", "onFetchRobotAvatar", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberInfoList", "onEnterTroopMemberList", "troopUin", "Lbt2/d;", "troopRobotList", "onEnterTroopRobotManagePage", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface IRobotInfoUpdateService extends IRuntimeService {
    void initUpdateListener();

    void onEnterTroopMemberList(@NotNull List<? extends TroopMemberInfo> troopMemberInfoList);

    void onEnterTroopRobotManagePage(@NotNull String troopUin, @NotNull List<? extends d> troopRobotList);

    void onFetchRobotAvatar(@NotNull String robotUin);

    void onFetchRobotProfile(@NotNull GroupRobotProfile robotProfile);
}
