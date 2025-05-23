package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopTrpcHandlerService extends QRouteApi {
    void sendRequest(String str, String str2, byte[] bArr, int i3, String str3, f fVar);
}
