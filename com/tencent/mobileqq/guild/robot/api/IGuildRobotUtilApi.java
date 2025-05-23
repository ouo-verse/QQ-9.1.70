package com.tencent.mobileqq.guild.robot.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotClientInfo;
import xw1.c;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildRobotUtilApi extends QRouteApi {
    boolean canUserAddRobotInGuild(String str);

    GProGuildRobotClientInfo getGuildRobotClientInfo();

    c getRobotConfig();

    boolean isNameMatched(String str, String str2);

    String toJson(Object obj);

    <T> T toObject(String str, Class<T> cls);
}
