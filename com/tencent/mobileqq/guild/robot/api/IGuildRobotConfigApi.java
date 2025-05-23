package com.tencent.mobileqq.guild.robot.api;

import com.tencent.mobileqq.guild.api.f;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildRobotConfigApi extends QRouteApi {
    void checkRobotStatusInGuild(String str, String str2, f fVar);

    String getMsgFromRobotFlag();

    String getPushMsgSettingLink();

    String getRobotActiveMsgFlag();

    int getRobotArkPermissionCacheTime();

    int getRobotCmdSortGuildLimit(int i3);

    int getRobotCmdSortRobotLimit(int i3);

    int getRobotInitiativeMsgNum(int i3);
}
