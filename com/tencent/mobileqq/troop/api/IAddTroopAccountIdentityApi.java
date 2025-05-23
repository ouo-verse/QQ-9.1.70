package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface IAddTroopAccountIdentityApi extends QRouteApi {
    void initRobotConfig(AppRuntime appRuntime);

    boolean isNeedAccountIdentity(int i3);
}
