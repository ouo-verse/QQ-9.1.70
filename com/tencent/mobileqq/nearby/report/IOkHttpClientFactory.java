package com.tencent.mobileqq.nearby.report;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import okhttp3.OkHttpClient;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IOkHttpClientFactory extends QRouteApi {
    OkHttpClient getRequestClient();
}
