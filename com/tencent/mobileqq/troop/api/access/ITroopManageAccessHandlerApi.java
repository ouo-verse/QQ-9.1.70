package com.tencent.mobileqq.troop.api.access;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cs2.a;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopManageAccessHandlerApi extends QRouteApi {
    void getFlameSwitchStatus(long j3, a aVar);

    void setFlameSwitch(long j3, int i3);
}
