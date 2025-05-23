package com.tencent.mobileqq.guild.robot.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;
import vw1.c;
import xw1.b;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildRobotDataApi extends QRouteApi {
    void getRobotCommonGuilds(AppRuntime appRuntime, String str, c<b> cVar);
}
