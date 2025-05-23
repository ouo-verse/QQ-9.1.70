package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IBeaconConfig extends QRouteApi {
    boolean getUseSocket();
}
