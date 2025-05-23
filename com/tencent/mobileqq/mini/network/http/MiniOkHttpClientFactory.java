package com.tencent.mobileqq.mini.network.http;

import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniOkHttpClientFactory {
    public static final int DEFAULT_DOWNLOAD_TIMEOUT = 60000;
    public static final int DEFAULT_REQUEST_TIMEOUT = 60000;
    public static final int DEFAULT_UPLOAD_TIMEOUT = 60000;
    private static final long HTTP_CACHE_SIZE = 10485760;
    public static final String TAG = "MiniOkHttpClientFactory";
    private static volatile OkHttpClient downloadClient;
    private static volatile OkHttpClient downloadClientWithCache;
    private static final ConnectionPool mConnectionPool = new ConnectionPool(10, 60, TimeUnit.SECONDS);
    private static final Dispatcher mDispatcher;
    private static volatile OkHttpClient requestClient;
    private static volatile OkHttpClient uploadClient;

    static {
        Dispatcher dispatcher = new Dispatcher();
        mDispatcher = dispatcher;
        dispatcher.setMaxRequests(64);
        dispatcher.setMaxRequestsPerHost(8);
        init(60000L, 60000L, 60000L);
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

    public static OkHttpClient getDownloadClient(boolean z16) {
        if (downloadClient == null) {
            throw new RuntimeException("client has not been initialized");
        }
        if (!z16) {
            return downloadClient;
        }
        return downloadClientWithCache;
    }

    public static OkHttpClient getRequestClient() {
        if (requestClient != null) {
            return requestClient;
        }
        throw new RuntimeException("client has not been initialized");
    }

    public static OkHttpClient getRequestClientWithSpecialTimeout(int i3) {
        if (requestClient != null) {
            if (requestClient.connectTimeoutMillis() == i3 && requestClient.readTimeoutMillis() == i3 && requestClient.writeTimeoutMillis() == i3) {
                return requestClient;
            }
            OkHttpClient.Builder newBuilder = requestClient.newBuilder();
            long j3 = i3;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            return newBuilder.connectTimeout(j3, timeUnit).readTimeout(j3, timeUnit).writeTimeout(j3, timeUnit).build();
        }
        throw new RuntimeException("client has not been initialized");
    }

    public static OkHttpClient getUploadClient() {
        if (uploadClient != null) {
            return uploadClient;
        }
        throw new RuntimeException("client has not been initialized");
    }

    public static void init(long j3, long j16, long j17) {
        boolean enableHttp2 = GameWnsUtils.enableHttp2();
        QLog.e(TAG, 1, "MiniOkHttpClientFactory init requestTimeOut:" + j3 + " uploadTimeOut:" + j16 + " downloadTimeout:" + j17);
        try {
            requestClient = createClientWithTimeout(j3, enableHttp2).build();
            uploadClient = createClientWithTimeout(j16, enableHttp2).build();
            downloadClient = createClientWithTimeout(j17, enableHttp2).build();
            downloadClientWithCache = createClientWithTimeout(j17, enableHttp2).cache(new Cache(new File(MiniAppGlobal.getMiniCacheFilePath(), "http_cache"), HTTP_CACHE_SIZE)).build();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "MiniOkHttpClientFactory init failed", e16);
        }
    }
}
