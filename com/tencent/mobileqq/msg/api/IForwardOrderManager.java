package com.tencent.mobileqq.msg.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IForwardOrderManager extends QRouteApi {
    void mapUniSeqId(long j3, long j16, int i3);
}
