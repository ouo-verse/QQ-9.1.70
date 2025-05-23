package com.tencent.biz.richframework.download;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWOkHttpClientFactory {
    public static int DEFAULT_CONNECT_POOL = 5;
    public static int DEFAULT_MAX_REQUEST = 64;
    public static int DEFAULT_MAX_REQUEST_PEER_HOST = 5;

    @NonNull
    public static OkHttpClient createDeFaultOKHttpClient() {
        return createOkHttpClient(DEFAULT_CONNECT_POOL, DEFAULT_MAX_REQUEST, DEFAULT_MAX_REQUEST_PEER_HOST);
    }

    @NonNull
    public static OkHttpClient createOkHttpClient(int i3, int i16, int i17) {
        return createOkHttpClient(i3, i16, i17, null);
    }

    @NonNull
    public static OkHttpClient createDeFaultOKHttpClient(@Nullable EventListener eventListener) {
        return createDeFaultOKHttpClient(eventListener, null);
    }

    @NonNull
    public static OkHttpClient createOkHttpClient(int i3, int i16, int i17, @Nullable EventListener eventListener) {
        return createOkHttpClient(i3, i16, i17, eventListener, null);
    }

    @NonNull
    public static OkHttpClient createDeFaultOKHttpClient(@Nullable EventListener eventListener, List<Interceptor> list) {
        return createOkHttpClient(DEFAULT_CONNECT_POOL, DEFAULT_MAX_REQUEST, DEFAULT_MAX_REQUEST_PEER_HOST, eventListener, list);
    }

    @NonNull
    public static OkHttpClient createOkHttpClient(int i3, int i16, int i17, @Nullable EventListener eventListener, List<Interceptor> list) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ConnectionPool connectionPool = new ConnectionPool(i3, 600L, timeUnit);
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(i16);
        dispatcher.setMaxRequestsPerHost(i17);
        OkHttpClient.Builder protocols = new OkHttpClient().newBuilder().dispatcher(dispatcher).callTimeout(120L, timeUnit).readTimeout(120L, timeUnit).connectionPool(connectionPool).writeTimeout(120L, timeUnit).protocols(Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1));
        if (eventListener != null) {
            protocols.eventListener(eventListener);
        }
        if (list != null && list.size() > 0) {
            Iterator<Interceptor> it = list.iterator();
            while (it.hasNext()) {
                protocols.addInterceptor(it.next());
            }
        }
        return protocols.build();
    }
}
