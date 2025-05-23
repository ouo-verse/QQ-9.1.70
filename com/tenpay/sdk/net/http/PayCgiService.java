package com.tenpay.sdk.net.http;

import android.content.Context;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.base.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tenpay.sdk.net.callback.CallbackThreadEnum;
import com.tenpay.sdk.net.callback.PayCallbackCenter;
import com.tenpay.sdk.net.callback.ThreadCallback;
import com.tenpay.sdk.net.core.callback.NetCallback;
import com.tenpay.sdk.net.core.task.base.Task;
import com.tenpay.sdk.net.http.common.HttpOptions;
import com.tenpay.sdk.net.http.cookie.PayCookieJar;
import com.tenpay.sdk.net.http.dns.PayCustomDns;
import com.tenpay.sdk.net.http.interceptor.EncryptInterceptor;
import com.tenpay.sdk.net.http.interceptor.GtkInterceptor;
import com.tenpay.sdk.net.http.interceptor.PsKeyInterceptor;
import com.tenpay.sdk.net.http.request.CgiBizData;
import com.tenpay.sdk.net.http.request.PayCgiRequest;
import com.tenpay.sdk.net.http.result.HttpResult;
import com.tenpay.sdk.net.http.tls.PayTrustManager;
import com.tenpay.sdk.net.utils.ThreadUtils;
import com.tenpay.sdk.paynet.TenpayCertificate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JL\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0007JV\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0007J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u001b"}, d2 = {"Lcom/tenpay/sdk/net/http/PayCgiService;", "", "()V", "TAG", "", "httpClient", "Lcom/tenpay/sdk/net/http/PayHttpClient;", "getHttpClient", "()Lcom/tenpay/sdk/net/http/PayHttpClient;", "httpClient$delegate", "Lkotlin/Lazy;", "sendRequest", "Lcom/tenpay/sdk/net/core/task/base/Task;", "context", "Landroid/content/Context;", "baseUrl", "paramMap", "", "callbackOnThread", "Lcom/tenpay/sdk/net/callback/CallbackThreadEnum;", "callback", "Lcom/tenpay/sdk/net/core/callback/NetCallback;", "Lcom/tenpay/sdk/net/http/result/HttpResult;", "bizData", "Lcom/tenpay/sdk/net/http/request/CgiBizData;", Const.BUNDLE_KEY_REQUEST, "Lcom/tenpay/sdk/net/http/request/PayCgiRequest;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PayCgiService {

    @NotNull
    public static final PayCgiService INSTANCE = new PayCgiService();

    @NotNull
    public static final String TAG = "QWalletHttp-PayCgiService";

    /* renamed from: httpClient$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy httpClient;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PayHttpClient>() { // from class: com.tenpay.sdk.net.http.PayCgiService$httpClient$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PayHttpClient invoke() {
                List<? extends Protocol> listOf;
                List listOf2;
                CookieJar cookieJar;
                PayHttpClient payHttpClient = new PayHttpClient();
                String str = ":" + MobileQQ.sProcessId;
                HttpOptions httpOptions = new HttpOptions();
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
                httpOptions.setSupportProtocol(listOf);
                X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
                Intrinsics.checkNotNullExpressionValue(STRICT_HOSTNAME_VERIFIER, "STRICT_HOSTNAME_VERIFIER");
                httpOptions.setHostNameVerifier(STRICT_HOSTNAME_VERIFIER);
                httpOptions.setMaxConnection(4);
                httpOptions.setMaxConnectionPerRoute(4);
                listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Interceptor[]{new PsKeyInterceptor(), new GtkInterceptor(), new EncryptInterceptor()});
                ThreadPoolExecutor createDefaultThreadPool = ThreadUtils.INSTANCE.createDefaultThreadPool("QWThread");
                PayTrustManager payTrustManager = new PayTrustManager(TenpayCertificate.getCA());
                if (((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_COOKIE_JAR_ENABLE, false)) {
                    cookieJar = new PayCookieJar();
                } else {
                    cookieJar = CookieJar.NO_COOKIES;
                }
                return PayHttpClient.newInstance$qwallet_impl_release$default(payHttpClient, str, httpOptions, listOf2, createDefaultThreadPool, cookieJar, null, new PayCustomDns(), payTrustManager, null, 288, null);
            }
        });
        httpClient = lazy;
    }

    PayCgiService() {
    }

    private final PayHttpClient getHttpClient() {
        return (PayHttpClient) httpClient.getValue();
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Task sendRequest(@Nullable Context context, @NotNull String baseUrl, @Nullable Map<String, String> map, @Nullable NetCallback<HttpResult> netCallback) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        return sendRequest$default(context, baseUrl, map, null, netCallback, 8, null);
    }

    public static /* synthetic */ Task sendRequest$default(Context context, String str, Map map, CgiBizData cgiBizData, CallbackThreadEnum callbackThreadEnum, NetCallback netCallback, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            callbackThreadEnum = CallbackThreadEnum.MAIN;
        }
        return sendRequest(context, str, map, cgiBizData, callbackThreadEnum, netCallback);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Task sendRequest(@Nullable Context context, @NotNull String baseUrl, @Nullable Map<String, String> map, @Nullable CgiBizData cgiBizData, @Nullable NetCallback<HttpResult> netCallback) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        return sendRequest$default(context, baseUrl, map, cgiBizData, null, netCallback, 16, null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Task sendRequest(@Nullable Context context, @NotNull String baseUrl, @Nullable Map<String, String> paramMap, @Nullable CgiBizData bizData, @NotNull CallbackThreadEnum callbackOnThread, @Nullable NetCallback<HttpResult> callback) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(callbackOnThread, "callbackOnThread");
        PayCgiRequest payCgiRequest = new PayCgiRequest(baseUrl, null, paramMap, bizData, new ThreadCallback(callbackOnThread, callback), new WeakReference(context), 2, null);
        payCgiRequest.setNetCallback(PayCallbackCenter.INSTANCE);
        return INSTANCE.sendRequest(payCgiRequest);
    }

    public static /* synthetic */ Task sendRequest$default(Context context, String str, Map map, CallbackThreadEnum callbackThreadEnum, NetCallback netCallback, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            callbackThreadEnum = CallbackThreadEnum.MAIN;
        }
        return sendRequest(context, str, (Map<String, String>) map, callbackThreadEnum, (NetCallback<HttpResult>) netCallback);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Task sendRequest(@Nullable Context context, @NotNull String baseUrl, @Nullable Map<String, String> paramMap, @NotNull CallbackThreadEnum callbackOnThread, @Nullable NetCallback<HttpResult> callback) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(callbackOnThread, "callbackOnThread");
        PayCgiRequest payCgiRequest = new PayCgiRequest(baseUrl, null, paramMap, new CgiBizData(a.c(), true, true, null, paramMap == null ? new LinkedHashMap() : paramMap, null, null, 104, null), new ThreadCallback(callbackOnThread, callback), new WeakReference(context), 2, null);
        payCgiRequest.setNetCallback(PayCallbackCenter.INSTANCE);
        return INSTANCE.sendRequest(payCgiRequest);
    }

    @NotNull
    public final Task sendRequest(@NotNull PayCgiRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return getHttpClient().send(request);
    }
}
