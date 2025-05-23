package com.tencent.qqlive.tvkplayer.tools.http.okhttp.interceptor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.http.okhttp.TVKOKHttpDnsImpl;
import com.tencent.qqlive.tvkplayer.tools.http.okhttp.TVKOKHttpEventListener;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKRetryWithBackupHostInterceptor extends TVKRetryInterceptorBase {
    private static final String REQUEST_TAG = "RetryWithBackupHost";
    private static final long RETRY_CALL_TIMEOUT_MS = 10000;
    private static final long RETRY_CONNECT_TIMEOUT_MS = 5000;
    private static final long RETRY_DNS_TIMEOUT_MS = 2000;
    private static final String TAG = "TVKRetryWithBackupHostInterceptor";
    private static final OkHttpClient sOKHttpClient;
    private final List<String> mBackupHostNameList;

    static {
        OkHttpClient.Builder connectionPool = new OkHttpClient.Builder().dns(new TVKOKHttpDnsImpl.Builder().dnsTimeoutMs(2000L).httpDns(true).build()).addInterceptor(new TVKInvalidRespTransToExInterceptor()).addInterceptor(new TVKRetryWithRandomIPInterceptor()).addInterceptor(new TVKRetryWithCellularNetworkInterceptor()).connectionPool(new ConnectionPool(10, 5L, TimeUnit.MINUTES));
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        sOKHttpClient = connectionPool.connectTimeout(5000L, timeUnit).callTimeout(10000L, timeUnit).build();
    }

    public TVKRetryWithBackupHostInterceptor(@NonNull List<String> list) {
        this.mBackupHostNameList = list;
        this.mLogTag = TAG;
    }

    private boolean isNeedRetryWithBackupHost() {
        if (this.mBackupHostNameList.isEmpty()) {
            return false;
        }
        return TVKMediaPlayerConfig.PlayerConfig.retry_with_back_up_host;
    }

    @Nullable
    private Response retryWithBackupHost(Call call) {
        Request request = call.request();
        for (String str : this.mBackupHostNameList) {
            HttpUrl url = request.url();
            if (!str.equals(url.host())) {
                Request build = request.newBuilder().tag("RetryWithBackupHost_" + str + "_" + request.tag()).url(url.newBuilder().host(str).build()).header(TVKCommonParamEnum.RequestHeaders.HOST, str).build();
                TVKLogUtil.i(TAG, "retryWithBackupHost, reqTag=" + request.tag() + ", url=" + build.url());
                try {
                    return sOKHttpClient.newBuilder().eventListener(new TVKOKHttpEventListener()).build().newCall(build).execute().newBuilder().addHeader("host", str).build();
                } catch (Exception unused) {
                    continue;
                }
            }
        }
        return null;
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.http.okhttp.interceptor.TVKRetryInterceptorBase
    @NonNull
    public Response executeWithRetry(@NonNull Interceptor.Chain chain, IOException iOException) throws IOException {
        if (isNeedRetryWithBackupHost()) {
            Response retryWithBackupHost = retryWithBackupHost(chain.call());
            if (retryWithBackupHost != null) {
                return retryWithBackupHost;
            }
            throw iOException;
        }
        throw iOException;
    }
}
