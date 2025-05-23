package com.tencent.mobileqq.guild.robot.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildRobotJumpParserFactory extends QRouteApi {
    Class<?> getGuildRobotJumpParseClass();
}
