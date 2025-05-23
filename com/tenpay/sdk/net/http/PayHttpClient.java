package com.tenpay.sdk.net.http;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tenpay.sdk.net.core.callback.NetCallback;
import com.tenpay.sdk.net.core.client.INetClient;
import com.tenpay.sdk.net.core.dispatcher.TaskDispatcher;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import com.tenpay.sdk.net.core.result.NetResult;
import com.tenpay.sdk.net.core.statistic.StatisticHandler;
import com.tenpay.sdk.net.core.statistic.StatisticInfo;
import com.tenpay.sdk.net.core.task.base.Task;
import com.tenpay.sdk.net.http.client.HttpNetClient;
import com.tenpay.sdk.net.http.common.HttpOptions;
import com.tenpay.sdk.net.http.request.HttpRequest;
import com.tenpay.sdk.net.http.response.PayCgiRspProcessor;
import com.tenpay.sdk.net.http.result.HttpResult;
import com.tenpay.sdk.net.http.statisitc.HttpStatisticMonitor;
import com.tenpay.sdk.net.http.task.HttpTask;
import java.net.ProxySelector;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CookieJar;
import okhttp3.Dns;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005\u00a2\u0006\u0002\u0010\u0002Js\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000\u00a2\u0006\u0002\b\u001fJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u001a\u0010$\u001a\u00020%2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010&\u001a\u00020%H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/tenpay/sdk/net/http/PayHttpClient;", "", "()V", "dispatcher", "Lcom/tenpay/sdk/net/core/dispatcher/TaskDispatcher;", "globalStatistic", "Lcom/tenpay/sdk/net/core/statistic/StatisticHandler;", "netClient", "Lcom/tenpay/sdk/net/core/client/INetClient;", "Lcom/tenpay/sdk/net/http/task/HttpTask;", "Lcom/tenpay/sdk/net/http/result/HttpResult;", "okHttpClient", "Lokhttp3/OkHttpClient;", "newInstance", "aliasName", "", "options", "Lcom/tenpay/sdk/net/http/common/HttpOptions;", "interceptors", "", "Lokhttp3/Interceptor;", "threadPoolExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "customCookieJar", "Lokhttp3/CookieJar;", "customProxySelector", "Ljava/net/ProxySelector;", "customDns", "Lokhttp3/Dns;", "customTrustManager", "Ljavax/net/ssl/X509TrustManager;", "newInstance$qwallet_impl_release", "send", "Lcom/tenpay/sdk/net/core/task/base/Task;", Const.BUNDLE_KEY_REQUEST, "Lcom/tenpay/sdk/net/http/request/HttpRequest;", "setSSLSocketFactory", "Lokhttp3/OkHttpClient$Builder;", "builder", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PayHttpClient {

    @NotNull
    public static final String TAG = "PayHttpClient";
    private TaskDispatcher dispatcher;

    @Nullable
    private StatisticHandler globalStatistic;
    private INetClient<HttpTask, HttpResult> netClient;
    private OkHttpClient okHttpClient;

    public static /* synthetic */ PayHttpClient newInstance$qwallet_impl_release$default(PayHttpClient payHttpClient, String str, HttpOptions httpOptions, List list, ThreadPoolExecutor threadPoolExecutor, CookieJar cookieJar, ProxySelector proxySelector, Dns dns, X509TrustManager x509TrustManager, StatisticHandler statisticHandler, int i3, Object obj) {
        List list2;
        CookieJar cookieJar2;
        ProxySelector proxySelector2;
        Dns dns2;
        X509TrustManager x509TrustManager2;
        StatisticHandler statisticHandler2;
        if ((i3 & 4) != 0) {
            list2 = null;
        } else {
            list2 = list;
        }
        if ((i3 & 16) != 0) {
            cookieJar2 = null;
        } else {
            cookieJar2 = cookieJar;
        }
        if ((i3 & 32) != 0) {
            proxySelector2 = null;
        } else {
            proxySelector2 = proxySelector;
        }
        if ((i3 & 64) != 0) {
            dns2 = null;
        } else {
            dns2 = dns;
        }
        if ((i3 & 128) != 0) {
            x509TrustManager2 = null;
        } else {
            x509TrustManager2 = x509TrustManager;
        }
        if ((i3 & 256) != 0) {
            statisticHandler2 = null;
        } else {
            statisticHandler2 = statisticHandler;
        }
        return payHttpClient.newInstance$qwallet_impl_release(str, httpOptions, list2, threadPoolExecutor, cookieJar2, proxySelector2, dns2, x509TrustManager2, statisticHandler2);
    }

    @NotNull
    public final PayHttpClient newInstance$qwallet_impl_release(@NotNull String aliasName, @NotNull HttpOptions options, @Nullable List<? extends Interceptor> interceptors, @NotNull ThreadPoolExecutor threadPoolExecutor, @Nullable CookieJar customCookieJar, @Nullable ProxySelector customProxySelector, @Nullable Dns customDns, @Nullable X509TrustManager customTrustManager, @Nullable StatisticHandler globalStatistic) {
        Intrinsics.checkNotNullParameter(aliasName, "aliasName");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(threadPoolExecutor, "threadPoolExecutor");
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        long connTimeout = options.getConnTimeout();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.connectTimeout(connTimeout, timeUnit);
        builder.writeTimeout(options.getSoTimeout(), timeUnit);
        builder.readTimeout(options.getSoTimeout(), timeUnit);
        builder.protocols(options.getSupportProtocol());
        builder.hostnameVerifier(options.getHostNameVerifier());
        builder.eventListenerFactory(new HttpStatisticMonitor.Factory());
        setSSLSocketFactory(customTrustManager, builder);
        if (customCookieJar != null) {
            builder.cookieJar(customCookieJar);
        }
        if (interceptors != null) {
            Iterator<T> it = interceptors.iterator();
            while (it.hasNext()) {
                builder.addInterceptor((Interceptor) it.next());
            }
        }
        if (customDns != null) {
            builder.dns(customDns);
        }
        if (customProxySelector != null) {
            builder.proxySelector(customProxySelector);
        }
        OkHttpClient build = builder.build();
        this.okHttpClient = build;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("okHttpClient");
            build = null;
        }
        this.netClient = new HttpNetClient(build);
        this.dispatcher = new TaskDispatcher(aliasName, options.getMaxConnection(), options.getMaxConnectionPerRoute(), threadPoolExecutor);
        this.globalStatistic = globalStatistic;
        return this;
    }

    @NotNull
    public final Task send(@NotNull HttpRequest r85) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(r85, "request");
        ILogAgent.DefaultImpls.i$default(DLog.INSTANCE, TAG, "send " + r85, null, 4, null);
        INetClient<HttpTask, HttpResult> iNetClient = this.netClient;
        TaskDispatcher taskDispatcher = null;
        if (iNetClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("netClient");
            iNetClient = null;
        }
        PayCgiRspProcessor payCgiRspProcessor = new PayCgiRspProcessor();
        StatisticHandler requestStatistic = r85.getRequestStatistic();
        if (requestStatistic == null) {
            requestStatistic = this.globalStatistic;
        }
        HttpTask httpTask = new HttpTask(iNetClient, r85, payCgiRspProcessor, requestStatistic);
        StatisticInfo statisticInfo = httpTask.getStatisticInfo();
        TaskDispatcher taskDispatcher2 = this.dispatcher;
        if (taskDispatcher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dispatcher");
            taskDispatcher2 = null;
        }
        statisticInfo.setConcurrentCount(taskDispatcher2.runningCallsCount());
        try {
            TaskDispatcher taskDispatcher3 = this.dispatcher;
            if (taskDispatcher3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dispatcher");
            } else {
                taskDispatcher = taskDispatcher3;
            }
            taskDispatcher.enqueue(httpTask);
        } catch (RejectedExecutionException e16) {
            DLog.INSTANCE.e(TAG, "send error: ", e16);
            NetCallback<NetResult> netCallback = r85.getNetCallback();
            if (netCallback != null) {
                netCallback.onNetFailed(r85.getOriginUrl(), httpTask.buildResult());
            }
        }
        return httpTask;
    }

    private final OkHttpClient.Builder setSSLSocketFactory(X509TrustManager customTrustManager, OkHttpClient.Builder builder) {
        return builder;
    }
}
