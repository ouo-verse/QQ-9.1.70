package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.ark.secure.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IArkSecure extends QRouteApi {
    void checkShareUrl(String str, String str2, String str3, String str4, b bVar);
}
