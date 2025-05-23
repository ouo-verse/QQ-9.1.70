package com.tencent.qqlive.tvkplayer.tools.http.okhttp.interceptor;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.http.okhttp.TVKOKHttpDnsImpl;
import com.tencent.qqlive.tvkplayer.tools.http.okhttp.TVKOKHttpEventListener;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKHttpUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes23.dex */
public class TVKRetryWithRandomIPInterceptor extends TVKRetryInterceptorBase {
    private static final String REQUEST_TAG = "RetryWithRandomIP";
    private static final long RETRY_CALL_TIMEOUT_MS = 10000;
    private static final long RETRY_CONNECT_TIMEOUT_MS = 5000;
    private static final String TAG = "TVKRetryWithRandomIPInterceptor";
    private static final OkHttpClient sOKHttpClient;

    static {
        OkHttpClient.Builder connectionPool = new OkHttpClient.Builder().retryOnConnectionFailure(false).addInterceptor(new TVKInvalidRespTransToExInterceptor()).connectionPool(new ConnectionPool(0, 1L, TimeUnit.MINUTES));
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        sOKHttpClient = connectionPool.connectTimeout(5000L, timeUnit).callTimeout(10000L, timeUnit).build();
    }

    public TVKRetryWithRandomIPInterceptor() {
        this.mLogTag = TAG;
    }

    private boolean isNeedRetryWithRandomIP(@NonNull String str, IOException iOException) {
        if (!TVKMediaPlayerConfig.PlayerConfig.retry_when_socket_connect_failed || TVKHttpUtils.isIpAddress(str)) {
            return false;
        }
        if (!(iOException instanceof SocketException) && !(iOException instanceof InterruptedIOException)) {
            return false;
        }
        return true;
    }

    @NonNull
    private Response retryWithRandomIP(Call call) throws IOException {
        Request request = call.request();
        TVKLogUtil.i(TAG, "retryWithRandomIP, reqTag=" + request.tag() + ", url=" + request.url());
        return sOKHttpClient.newBuilder().dns(new TVKOKHttpDnsImpl.Builder().dnsPreferred(1).httpDns(true).disableIpv6(true).build()).eventListener(new TVKOKHttpEventListener()).build().newCall(request.newBuilder().tag("RetryWithRandomIP_" + request.tag()).build()).execute();
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.http.okhttp.interceptor.TVKRetryInterceptorBase
    @NonNull
    public Response executeWithRetry(@NonNull Interceptor.Chain chain, IOException iOException) throws IOException {
        if (isNeedRetryWithRandomIP(chain.request().url().host(), iOException)) {
            return retryWithRandomIP(chain.call());
        }
        throw iOException;
    }
}
