package com.tencent.mobileqq.utils.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface ISecurityUtile extends QRouteApi {
    String encode(String str);

    byte[] encode(byte[] bArr);
}
