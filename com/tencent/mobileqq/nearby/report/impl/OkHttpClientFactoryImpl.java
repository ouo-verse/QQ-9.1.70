package com.tencent.mobileqq.nearby.report.impl;

import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.nearby.report.IOkHttpClientFactory;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/* compiled from: P */
/* loaded from: classes33.dex */
public class OkHttpClientFactoryImpl implements IOkHttpClientFactory {
    private static final ConnectionPool mConnectionPool = new ConnectionPool(10, 60, TimeUnit.SECONDS);
    private static final Dispatcher mDispatcher;
    private static volatile OkHttpClient requestClient;

    static {
        Dispatcher dispatcher = new Dispatcher();
        mDispatcher = dispatcher;
        dispatcher.setMaxRequests(64);
        dispatcher.setMaxRequestsPerHost(8);
        init(30000L);
    }

    private static OkHttpClient.Builder createClientWithTimeout(long j3, boolean z16) {
        List<? extends Protocol> asList;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (z16) {
            asList = Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1);
        } else {
            asList = Arrays.asList(Protocol.HTTP_1_1);
        }
        OkHttpClient.Builder protocols = builder.protocols(asList);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return protocols.connectTimeout(j3, timeUnit).readTimeout(j3, timeUnit).writeTimeout(j3, timeUnit).connectionPool(mConnectionPool).dispatcher(mDispatcher);
    }

    private static void init(long j3) {
        requestClient = createClientWithTimeout(j3, ((IMiniAppService) QRoute.api(IMiniAppService.class)).enableHttp2()).build();
    }

    @Override // com.tencent.mobileqq.nearby.report.IOkHttpClientFactory
    public OkHttpClient getRequestClient() {
        if (requestClient == null) {
            init(30000L);
        }
        return requestClient;
    }
}
