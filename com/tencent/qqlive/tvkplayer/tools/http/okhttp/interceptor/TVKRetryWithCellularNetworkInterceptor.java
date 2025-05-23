package com.tencent.qqlive.tvkplayer.tools.http.okhttp.interceptor;

import android.net.Network;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor;
import com.tencent.qqlive.tvkplayer.tools.http.okhttp.TVKOKHttpDnsImpl;
import com.tencent.qqlive.tvkplayer.tools.http.okhttp.TVKOKHttpEventListener;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKNetworkConnectionListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKRetryWithCellularNetworkInterceptor extends TVKRetryInterceptorBase {
    private static final String REQUEST_TAG = "RetryWithCellularNetwork";
    private static final long RETRY_CALL_TIMEOUT_MS = 10000;
    private static final long RETRY_CONNECT_TIMEOUT_MS = 5000;
    private static final String TAG = "TVKRetryWithCellularNetworkInterceptor";
    private static final OkHttpClient sOKHttpClient;

    static {
        OkHttpClient.Builder addInterceptor = new OkHttpClient.Builder().addInterceptor(new TVKInvalidRespTransToExInterceptor());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        sOKHttpClient = addInterceptor.connectTimeout(5000L, timeUnit).callTimeout(10000L, timeUnit).build();
    }

    public TVKRetryWithCellularNetworkInterceptor() {
        this.mLogTag = TAG;
    }

    private boolean isNeedRetryWithCellularNetwork(IOException iOException) {
        if (!TVKMediaPlayerConfig.PlayerConfig.use_cellular_network_retry_when_wifi_request_failed) {
            return false;
        }
        return !(iOException instanceof ITVKHttpProcessor.InvalidResponseCodeException);
    }

    @Nullable
    private Response retryWithCellularNetwork(Call call) throws IOException {
        Network availableCellularNetwork = TVKNetworkConnectionListener.getInstance().getAvailableCellularNetwork();
        if (availableCellularNetwork == null) {
            TVKLogUtil.w(TAG, "currentCellularNetwork is null, can not retryWithCellularNetwork");
            return null;
        }
        Request request = call.request();
        TVKLogUtil.i(TAG, "retryWithCellularNetwork, reqTag=" + request.tag() + ", url=" + request.url());
        return sOKHttpClient.newBuilder().eventListener(new TVKOKHttpEventListener()).dns(new TVKOKHttpDnsImpl.Builder().networkInterface(availableCellularNetwork).remoteDns(false).build()).socketFactory(availableCellularNetwork.getSocketFactory()).build().newCall(request.newBuilder().tag("RetryWithCellularNetwork_" + request.tag()).build()).execute().newBuilder().addHeader(ITVKHttpProcessor.HTTP_REQUEST_NETWORK_INTERFACE_SPECIFIER, "1").build();
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.http.okhttp.interceptor.TVKRetryInterceptorBase
    @NonNull
    public Response executeWithRetry(@NonNull Interceptor.Chain chain, IOException iOException) throws IOException {
        if (isNeedRetryWithCellularNetwork(iOException)) {
            Response retryWithCellularNetwork = retryWithCellularNetwork(chain.call());
            if (retryWithCellularNetwork != null) {
                return retryWithCellularNetwork;
            }
            throw iOException;
        }
        throw iOException;
    }
}
