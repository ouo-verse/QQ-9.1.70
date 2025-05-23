package com.tencent.qqlive.tvkplayer.tools.http.okhttp;

import android.net.Network;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.config.TVKUrlConfig;
import com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpDownloader;
import com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor;
import com.tencent.qqlive.tvkplayer.tools.http.okhttp.TVKOKHttpDnsImpl;
import com.tencent.qqlive.tvkplayer.tools.http.okhttp.interceptor.TVKInvalidRespTransToExInterceptor;
import com.tencent.qqlive.tvkplayer.tools.http.okhttp.interceptor.TVKRetryWithBackupHostInterceptor;
import com.tencent.qqlive.tvkplayer.tools.http.okhttp.interceptor.TVKRetryWithCellularNetworkInterceptor;
import com.tencent.qqlive.tvkplayer.tools.http.okhttp.interceptor.TVKRetryWithRandomIPInterceptor;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKGlobalEventNotifier;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKNetworkConnectionListener;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKNetworkUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.connection.RealConnectionPool;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKOKHttpClient implements ITVKHttpProcessor, ITVKHttpDownloader {
    private static final int RACE_TO_CONNECT_DELAY_MS = 3000;
    private static final String TAG = "TVKPlayer[TVKOKHttpClient]";
    private static final TVKHappyEyeballsV2ConnectionRace mConnectionRace;
    private static final OkHttpClient sOKHttpClient;
    private static final TVKOKHttpClient sOKHttpClientInstance;
    private volatile boolean mIsRacingToConnect = false;
    private static final MediaType MEDIA_TYPE_DEFAULT = MediaType.parse(ITVKHttpProcessor.HTTP_REQUEST_CONTENT_TYPE_VALUE_FORM);
    private static long sDefaultConnectionKeepAliveDurationMinute = 5;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.qqlive.tvkplayer.tools.http.okhttp.TVKOKHttpClient$2, reason: invalid class name */
    /* loaded from: classes23.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$qqlive$tvkplayer$tools$http$api$ITVKHttpProcessor$TVKHttpRequest$HttpMethod;

        static {
            int[] iArr = new int[ITVKHttpProcessor.TVKHttpRequest.HttpMethod.values().length];
            $SwitchMap$com$tencent$qqlive$tvkplayer$tools$http$api$ITVKHttpProcessor$TVKHttpRequest$HttpMethod = iArr;
            try {
                iArr[ITVKHttpProcessor.TVKHttpRequest.HttpMethod.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$qqlive$tvkplayer$tools$http$api$ITVKHttpProcessor$TVKHttpRequest$HttpMethod[ITVKHttpProcessor.TVKHttpRequest.HttpMethod.POST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$qqlive$tvkplayer$tools$http$api$ITVKHttpProcessor$TVKHttpRequest$HttpMethod[ITVKHttpProcessor.TVKHttpRequest.HttpMethod.PUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$qqlive$tvkplayer$tools$http$api$ITVKHttpProcessor$TVKHttpRequest$HttpMethod[ITVKHttpProcessor.TVKHttpRequest.HttpMethod.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class TVKOKHttpCallback implements Callback {
        private static final int FAILURE = -1;
        private static final int IDLE = 0;
        private static final int SUCCESS = 1;

        @NonNull
        private final ITVKHttpProcessor.ITVKHttpCallback mCallback;
        private final boolean mEnableRacingRequest;
        private volatile int mResponseResult = 0;

        public TVKOKHttpCallback(@NonNull ITVKHttpProcessor.ITVKHttpCallback iTVKHttpCallback, boolean z16) {
            this.mCallback = iTVKHttpCallback;
            this.mEnableRacingRequest = z16;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
            if (this.mEnableRacingRequest) {
                synchronized (this) {
                    if (this.mResponseResult == 1) {
                        return;
                    }
                    if (this.mResponseResult == 0) {
                        this.mResponseResult = -1;
                        return;
                    }
                }
            }
            this.mCallback.onFailure(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(@NonNull Call call, @NonNull Response response) {
            byte[] bArr;
            if (this.mEnableRacingRequest) {
                synchronized (this) {
                    if (this.mResponseResult == 1) {
                        return;
                    } else {
                        this.mResponseResult = 1;
                    }
                }
            }
            try {
                ResponseBody body = response.body();
                Headers headers = response.headers();
                if (TextUtils.equals("1", call.request().headers().get(ITVKHttpProcessor.HTTP_REQUEST_NETWORK_INTERFACE_SPECIFIER))) {
                    headers = headers.newBuilder().add(ITVKHttpProcessor.HTTP_REQUEST_NETWORK_INTERFACE_SPECIFIER, "1").build();
                }
                Map<String, List<String>> multimap = headers.toMultimap();
                if (body != null) {
                    bArr = body.bytes();
                } else {
                    bArr = null;
                }
                this.mCallback.onSuccess(new ITVKHttpProcessor.TVKHttpResponse(multimap, bArr));
            } catch (IOException e16) {
                TVKLogUtil.e(TVKOKHttpClient.TAG, e16, "[onResponse] IOException encountered while getting response content: ");
                this.mCallback.onFailure(e16);
            }
        }
    }

    static {
        OkHttpClient build = new OkHttpClient.Builder().addInterceptor(new TVKInvalidRespTransToExInterceptor()).connectionPool(new ConnectionPool(10, sDefaultConnectionKeepAliveDurationMinute, TimeUnit.MINUTES)).build();
        sOKHttpClient = build;
        mConnectionRace = new TVKHappyEyeballsV2ConnectionRace(build);
        sOKHttpClientInstance = new TVKOKHttpClient();
    }

    TVKOKHttpClient() {
        TVKGlobalEventNotifier.getInstance().addEventListener(new TVKGlobalEventNotifier.OnGlobalEventChangeListener() { // from class: com.tencent.qqlive.tvkplayer.tools.http.okhttp.l
            @Override // com.tencent.qqlive.tvkplayer.tools.utils.TVKGlobalEventNotifier.OnGlobalEventChangeListener
            public final void onEvent(int i3, int i16, int i17, Object obj) {
                TVKOKHttpClient.this.lambda$new$0(i3, i16, i17, obj);
            }
        });
    }

    private Request buildOKHttpRequest(@NonNull ITVKHttpProcessor.TVKHttpRequest tVKHttpRequest) throws IllegalArgumentException {
        Headers build;
        byte[] body;
        if (tVKHttpRequest.getHeaders() != null && !tVKHttpRequest.getHeaders().isEmpty()) {
            build = Headers.of(tVKHttpRequest.getHeaders());
        } else {
            build = new Headers.Builder().build();
        }
        if (tVKHttpRequest.getBody() == null) {
            body = new byte[0];
        } else {
            body = tVKHttpRequest.getBody();
        }
        Request.Builder headers = new Request.Builder().tag(tVKHttpRequest.getReqTag()).url(tVKHttpRequest.getUrl()).headers(build);
        int i3 = AnonymousClass2.$SwitchMap$com$tencent$qqlive$tvkplayer$tools$http$api$ITVKHttpProcessor$TVKHttpRequest$HttpMethod[tVKHttpRequest.getHttpMethod().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        return headers.delete().build();
                    }
                    throw new IllegalArgumentException("Unknown request method: " + tVKHttpRequest.getHttpMethod() + ", not in (GET, POST, PUT, DELETE)");
                }
                return headers.put(RequestBody.create(body, getMediaTypeFromHeaders(build))).build();
            }
            return headers.post(RequestBody.create(body, getMediaTypeFromHeaders(build))).build();
        }
        return headers.build();
    }

    private void changeConnectionKeepAliveDurationIfNeeded() {
        if (TVKMediaPlayerConfig.PlayerConfig.okhttp_connection_keep_alive_duration_minute == sDefaultConnectionKeepAliveDurationMinute) {
            return;
        }
        synchronized (this) {
            if (TVKMediaPlayerConfig.PlayerConfig.okhttp_connection_keep_alive_duration_minute == sDefaultConnectionKeepAliveDurationMinute) {
                return;
            }
            try {
                ConnectionPool connectionPool = sOKHttpClient.connectionPool();
                Field declaredField = connectionPool.getClass().getDeclaredField("delegate");
                declaredField.setAccessible(true);
                RealConnectionPool realConnectionPool = (RealConnectionPool) declaredField.get(connectionPool);
                RealConnectionPool.Companion companion = RealConnectionPool.INSTANCE;
                Field declaredField2 = RealConnectionPool.class.getDeclaredField("keepAliveDurationNs");
                declaredField2.setAccessible(true);
                declaredField2.set(realConnectionPool, Long.valueOf(TimeUnit.MINUTES.toNanos(TVKMediaPlayerConfig.PlayerConfig.okhttp_connection_keep_alive_duration_minute)));
                TVKLogUtil.i(TAG, "set keepAliveDurationNs=" + declaredField2.get(realConnectionPool));
                sDefaultConnectionKeepAliveDurationMinute = TVKMediaPlayerConfig.PlayerConfig.okhttp_connection_keep_alive_duration_minute;
            } catch (Exception e16) {
                TVKLogUtil.e(TAG, e16);
            }
        }
    }

    private void clearConnectionCache() {
        sOKHttpClient.connectionPool().evictAll();
    }

    public static TVKOKHttpClient getInstance() {
        return sOKHttpClientInstance;
    }

    private MediaType getMediaTypeFromHeaders(Headers headers) {
        String str;
        if (headers != null) {
            str = headers.get("Content-Type");
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return MEDIA_TYPE_DEFAULT;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(int i3, int i16, int i17, Object obj) {
        if (i3 == 100003) {
            clearConnectionCache();
            preConnectAsync();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$preConnectAsync$1() {
        ITVKHttpProcessor.TVKHttpRequest.HttpMethod httpMethod = ITVKHttpProcessor.TVKHttpRequest.HttpMethod.GET;
        raceToConnectAsync(new ITVKHttpProcessor.TVKHttpRequest.Builder(httpMethod, TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_VINFO_CGI_DUALSTACK_HOST)).build());
        raceToConnectAsync(new ITVKHttpProcessor.TVKHttpRequest.Builder(httpMethod, TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_VINFO_CGI_V4ONLY_HOST)).build());
        raceToConnectAsync(new ITVKHttpProcessor.TVKHttpRequest.Builder(httpMethod, TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_LIVE_DUALSTACK_CGI_HOST)).build());
        this.mIsRacingToConnect = false;
    }

    private void preConnectAsync() {
        if (this.mIsRacingToConnect) {
            return;
        }
        this.mIsRacingToConnect = true;
        TVKThreadPool.getInstance().obtainScheduledExecutorService().schedule(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.tools.http.okhttp.m
            @Override // java.lang.Runnable
            public final void run() {
                TVKOKHttpClient.this.lambda$preConnectAsync$1();
            }
        }, 3000L, TimeUnit.MILLISECONDS);
    }

    private void raceToConnectAsync(@NonNull ITVKHttpProcessor.TVKHttpRequest tVKHttpRequest) {
        mConnectionRace.raceToConnectAsync(sOKHttpClient.newCall(buildOKHttpRequest(tVKHttpRequest)));
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor
    public void cancelRequest(String str) {
        if (TextUtils.isEmpty(str)) {
            TVKLogUtil.w(TAG, "cancel request failed, reqTag is " + str);
            return;
        }
        TVKLogUtil.d(TAG, "cancel request task: " + str);
        OkHttpClient build = new OkHttpClient.Builder().build();
        for (Call call : build.dispatcher().queuedCalls()) {
            if (TextUtils.equals((String) call.request().tag(), str)) {
                call.cancel();
            }
        }
        for (Call call2 : build.dispatcher().runningCalls()) {
            if (TextUtils.equals((String) call2.request().tag(), str)) {
                call2.cancel();
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor
    public ITVKHttpProcessor.TVKHttpResponse execute(@NonNull ITVKHttpProcessor.TVKHttpRequest tVKHttpRequest) throws IOException {
        OkHttpClient build;
        changeConnectionKeepAliveDurationIfNeeded();
        OkHttpClient.Builder addInterceptor = sOKHttpClient.newBuilder().dns(new TVKOKHttpDnsImpl.Builder().dnsTimeoutMs(tVKHttpRequest.getDnsTimeoutMs()).shuffle(true).httpDns(tVKHttpRequest.useHttpDns()).build()).eventListener(new TVKOKHttpEventListener()).addInterceptor(new TVKRetryWithRandomIPInterceptor()).addInterceptor(new TVKRetryWithBackupHostInterceptor(tVKHttpRequest.getBackHosts()));
        long connectTimeoutMs = tVKHttpRequest.getConnectTimeoutMs();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient.Builder callTimeout = addInterceptor.connectTimeout(connectTimeoutMs, timeUnit).callTimeout(tVKHttpRequest.getCallTimeoutMs(), timeUnit);
        if (tVKHttpRequest.retryCellularOnWifiFailure()) {
            build = callTimeout.addInterceptor(new TVKRetryWithCellularNetworkInterceptor()).build();
        } else {
            build = callTimeout.build();
        }
        Response execute = build.newCall(buildOKHttpRequest(tVKHttpRequest)).execute();
        ResponseBody body = execute.body();
        return new ITVKHttpProcessor.TVKHttpResponse(execute.headers().toMultimap(), body == null ? null : body.bytes());
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor
    public void executeAsync(@NonNull ITVKHttpProcessor.TVKHttpRequest tVKHttpRequest, @NonNull ITVKHttpProcessor.ITVKHttpCallback iTVKHttpCallback) {
        OkHttpClient build;
        if (iTVKHttpCallback == null) {
            return;
        }
        changeConnectionKeepAliveDurationIfNeeded();
        boolean z16 = tVKHttpRequest.retryCellularOnWifiFailure() && !TVKNetworkUtils.isCurrentNetworkOnline(TVKCommParams.getApplicationContext()) && !TVKNetworkUtils.isNetworkTypeMobile() && TVKMediaPlayerConfig.PlayerConfig.enable_cellular_network_race_when_disconnected;
        Network availableCellularNetwork = TVKNetworkConnectionListener.getInstance().getAvailableCellularNetwork();
        boolean z17 = z16 && availableCellularNetwork != null;
        TVKOKHttpCallback tVKOKHttpCallback = new TVKOKHttpCallback(iTVKHttpCallback, z17);
        Request buildOKHttpRequest = buildOKHttpRequest(tVKHttpRequest);
        if (z17) {
            TVKLogUtil.i(TAG, "enableRequestRacing");
            OkHttpClient.Builder eventListener = sOKHttpClient.newBuilder().dns(new TVKOKHttpDnsImpl.Builder().dnsTimeoutMs(tVKHttpRequest.getDnsTimeoutMs()).networkInterface(availableCellularNetwork).httpDns(tVKHttpRequest.useHttpDns()).build()).socketFactory(availableCellularNetwork.getSocketFactory()).eventListener(new TVKOKHttpEventListener());
            long connectTimeoutMs = tVKHttpRequest.getConnectTimeoutMs();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            eventListener.connectTimeout(connectTimeoutMs, timeUnit).callTimeout(tVKHttpRequest.getCallTimeoutMs(), timeUnit).build().newCall(buildOKHttpRequest.newBuilder().tag("" + buildOKHttpRequest.tag() + "_cellularNetwork").addHeader(ITVKHttpProcessor.HTTP_REQUEST_NETWORK_INTERFACE_SPECIFIER, "1").build()).enqueue(tVKOKHttpCallback);
        }
        OkHttpClient.Builder addInterceptor = sOKHttpClient.newBuilder().dns(new TVKOKHttpDnsImpl.Builder().dnsTimeoutMs(tVKHttpRequest.getDnsTimeoutMs()).httpDns(tVKHttpRequest.useHttpDns()).build()).eventListener(new TVKOKHttpEventListener()).addInterceptor(new TVKRetryWithRandomIPInterceptor()).addInterceptor(new TVKRetryWithBackupHostInterceptor(tVKHttpRequest.getBackHosts()));
        long connectTimeoutMs2 = tVKHttpRequest.getConnectTimeoutMs();
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        OkHttpClient.Builder callTimeout = addInterceptor.connectTimeout(connectTimeoutMs2, timeUnit2).callTimeout(tVKHttpRequest.getCallTimeoutMs(), timeUnit2);
        if (tVKHttpRequest.retryCellularOnWifiFailure()) {
            build = callTimeout.addInterceptor(new TVKRetryWithCellularNetworkInterceptor()).build();
        } else {
            build = callTimeout.build();
        }
        raceToConnectAsync(tVKHttpRequest);
        build.newCall(buildOKHttpRequest).enqueue(tVKOKHttpCallback);
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpDownloader
    public void execute(@NonNull ITVKHttpProcessor.TVKHttpRequest tVKHttpRequest, @NonNull ITVKHttpDownloader.ITVKDownloadCallback iTVKDownloadCallback) throws IOException {
        if (iTVKDownloadCallback == null) {
            return;
        }
        changeConnectionKeepAliveDurationIfNeeded();
        OkHttpClient.Builder addInterceptor = sOKHttpClient.newBuilder().dns(new TVKOKHttpDnsImpl.Builder().dnsTimeoutMs(tVKHttpRequest.getDnsTimeoutMs()).httpDns(tVKHttpRequest.useHttpDns()).build()).eventListener(new TVKOKHttpEventListener()).addInterceptor(new TVKRetryWithRandomIPInterceptor()).addInterceptor(new TVKRetryWithBackupHostInterceptor(tVKHttpRequest.getBackHosts()));
        long connectTimeoutMs = tVKHttpRequest.getConnectTimeoutMs();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Response execute = addInterceptor.connectTimeout(connectTimeoutMs, timeUnit).callTimeout(tVKHttpRequest.getCallTimeoutMs(), timeUnit).build().newCall(buildOKHttpRequest(tVKHttpRequest)).execute();
        Map<String, List<String>> multimap = execute.headers().toMultimap();
        ResponseBody body = execute.body();
        if (body != null) {
            InputStream byteStream = body.byteStream();
            try {
                try {
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = byteStream.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                iTVKDownloadCallback.onDataReceived(multimap, bArr, read);
                            }
                        }
                        iTVKDownloadCallback.onFinished();
                        byteStream.close();
                    } catch (IOException e16) {
                        iTVKDownloadCallback.onFailure(e16);
                        if (byteStream == null) {
                            return;
                        } else {
                            byteStream.close();
                        }
                    }
                    return;
                } catch (Throwable th5) {
                    if (byteStream != null) {
                        try {
                            byteStream.close();
                        } catch (IOException e17) {
                            TVKLogUtil.e(TAG, e17);
                        }
                    }
                    throw th5;
                }
            } catch (IOException e18) {
                TVKLogUtil.e(TAG, e18);
                return;
            }
        }
        throw new IOException("response body is null");
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpDownloader
    public void executeAsync(@NonNull ITVKHttpProcessor.TVKHttpRequest tVKHttpRequest, @NonNull final ITVKHttpDownloader.ITVKDownloadCallback iTVKDownloadCallback) {
        if (iTVKDownloadCallback == null) {
            return;
        }
        changeConnectionKeepAliveDurationIfNeeded();
        OkHttpClient.Builder addInterceptor = sOKHttpClient.newBuilder().dns(new TVKOKHttpDnsImpl.Builder().dnsTimeoutMs(tVKHttpRequest.getDnsTimeoutMs()).httpDns(tVKHttpRequest.useHttpDns()).build()).eventListener(new TVKOKHttpEventListener()).addInterceptor(new TVKRetryWithRandomIPInterceptor()).addInterceptor(new TVKRetryWithBackupHostInterceptor(tVKHttpRequest.getBackHosts()));
        long connectTimeoutMs = tVKHttpRequest.getConnectTimeoutMs();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        addInterceptor.connectTimeout(connectTimeoutMs, timeUnit).callTimeout(tVKHttpRequest.getCallTimeoutMs(), timeUnit).build().newCall(buildOKHttpRequest(tVKHttpRequest)).enqueue(new Callback() { // from class: com.tencent.qqlive.tvkplayer.tools.http.okhttp.TVKOKHttpClient.1
            @Override // okhttp3.Callback
            public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
                iTVKDownloadCallback.onFailure(iOException);
            }

            @Override // okhttp3.Callback
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Map<String, List<String>> multimap = response.headers().toMultimap();
                ResponseBody body = response.body();
                if (body == null) {
                    iTVKDownloadCallback.onFailure(new IOException("Response body is null"));
                    return;
                }
                InputStream byteStream = body.byteStream();
                try {
                    try {
                        try {
                            byte[] bArr = new byte[2048];
                            while (true) {
                                int read = byteStream.read(bArr);
                                if (read == -1) {
                                    break;
                                } else {
                                    iTVKDownloadCallback.onDataReceived(multimap, bArr, read);
                                }
                            }
                            iTVKDownloadCallback.onFinished();
                            byteStream.close();
                        } catch (IOException e16) {
                            iTVKDownloadCallback.onFailure(e16);
                            if (byteStream != null) {
                                byteStream.close();
                            }
                        }
                    } catch (Throwable th5) {
                        if (byteStream != null) {
                            try {
                                byteStream.close();
                            } catch (IOException e17) {
                                TVKLogUtil.e(TVKOKHttpClient.TAG, e17);
                            }
                        }
                        throw th5;
                    }
                } catch (IOException e18) {
                    TVKLogUtil.e(TVKOKHttpClient.TAG, e18);
                }
            }
        });
    }
}
