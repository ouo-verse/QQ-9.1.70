package com.tencent.mobileqq.soload.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISoLoaderCrashService extends QRouteApi {
    void handleCrash(String str, String str2);
}
