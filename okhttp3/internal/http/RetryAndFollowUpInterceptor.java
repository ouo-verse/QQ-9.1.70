package okhttp3.internal.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J(\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lokhttp3/internal/http/RetryAndFollowUpInterceptor;", "Lokhttp3/Interceptor;", "client", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "buildRedirectRequest", "Lokhttp3/Request;", "userResponse", "Lokhttp3/Response;", "method", "", "followUpRequest", "exchange", "Lokhttp3/internal/connection/Exchange;", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "isRecoverable", "", "e", "Ljava/io/IOException;", "requestSendStarted", "recover", "call", "Lokhttp3/internal/connection/RealCall;", "userRequest", "requestIsOneShot", "retryAfter", "", "defaultDelay", "Companion", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    private static final int MAX_FOLLOW_UPS = 20;
    private final OkHttpClient client;

    public RetryAndFollowUpInterceptor(@NotNull OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    private final Request buildRedirectRequest(Response userResponse, String method) {
        String header$default;
        HttpUrl resolve;
        boolean z16;
        RequestBody requestBody = null;
        if (!this.client.followRedirects() || (header$default = Response.header$default(userResponse, "Location", null, 2, null)) == null || (resolve = userResponse.request().url().resolve(header$default)) == null) {
            return null;
        }
        if (!Intrinsics.areEqual(resolve.scheme(), userResponse.request().url().scheme()) && !this.client.followSslRedirects()) {
            return null;
        }
        Request.Builder newBuilder = userResponse.request().newBuilder();
        if (HttpMethod.permitsRequestBody(method)) {
            int code = userResponse.code();
            HttpMethod httpMethod = HttpMethod.INSTANCE;
            if (!httpMethod.redirectsWithBody(method) && code != 308 && code != 307) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (httpMethod.redirectsToGet(method) && code != 308 && code != 307) {
                newBuilder.method("GET", null);
            } else {
                if (z16) {
                    requestBody = userResponse.request().body();
                }
                newBuilder.method(method, requestBody);
            }
            if (!z16) {
                newBuilder.removeHeader("Transfer-Encoding");
                newBuilder.removeHeader("Content-Length");
                newBuilder.removeHeader("Content-Type");
            }
        }
        if (!Util.canReuseConnectionFor(userResponse.request().url(), resolve)) {
            newBuilder.removeHeader("Authorization");
        }
        return newBuilder.url(resolve).build();
    }

    private final Request followUpRequest(Response userResponse, Exchange exchange) throws IOException {
        Route route;
        RealConnection connection;
        if (exchange != null && (connection = exchange.getConnection()) != null) {
            route = connection.getRoute();
        } else {
            route = null;
        }
        int code = userResponse.code();
        String method = userResponse.request().method();
        if (code != 307 && code != 308) {
            if (code != 401) {
                if (code != 421) {
                    if (code != 503) {
                        if (code != 407) {
                            if (code != 408) {
                                switch (code) {
                                    case 300:
                                    case 301:
                                    case 302:
                                    case 303:
                                        break;
                                    default:
                                        return null;
                                }
                            } else {
                                if (!this.client.retryOnConnectionFailure()) {
                                    return null;
                                }
                                RequestBody body = userResponse.request().body();
                                if (body != null && body.isOneShot()) {
                                    return null;
                                }
                                Response priorResponse = userResponse.priorResponse();
                                if ((priorResponse != null && priorResponse.code() == 408) || retryAfter(userResponse, 0) > 0) {
                                    return null;
                                }
                                return userResponse.request();
                            }
                        } else {
                            Intrinsics.checkNotNull(route);
                            if (route.proxy().type() == Proxy.Type.HTTP) {
                                return this.client.proxyAuthenticator().authenticate(route, userResponse);
                            }
                            throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                        }
                    } else {
                        Response priorResponse2 = userResponse.priorResponse();
                        if ((priorResponse2 != null && priorResponse2.code() == 503) || retryAfter(userResponse, Integer.MAX_VALUE) != 0) {
                            return null;
                        }
                        return userResponse.request();
                    }
                } else {
                    RequestBody body2 = userResponse.request().body();
                    if ((body2 != null && body2.isOneShot()) || exchange == null || !exchange.isCoalescedConnection$okhttp()) {
                        return null;
                    }
                    exchange.getConnection().noCoalescedConnections$okhttp();
                    return userResponse.request();
                }
            } else {
                return this.client.authenticator().authenticate(route, userResponse);
            }
        }
        return buildRedirectRequest(userResponse, method);
    }

    private final boolean isRecoverable(IOException e16, boolean requestSendStarted) {
        if (e16 instanceof ProtocolException) {
            return false;
        }
        if (e16 instanceof InterruptedIOException) {
            if (!(e16 instanceof SocketTimeoutException) || requestSendStarted) {
                return false;
            }
            return true;
        }
        if (((e16 instanceof SSLHandshakeException) && (e16.getCause() instanceof CertificateException)) || (e16 instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return true;
    }

    private final boolean recover(IOException e16, RealCall call, Request userRequest, boolean requestSendStarted) {
        if (!this.client.retryOnConnectionFailure()) {
            return false;
        }
        if ((requestSendStarted && requestIsOneShot(e16, userRequest)) || !isRecoverable(e16, requestSendStarted) || !call.retryAfterFailure()) {
            return false;
        }
        return true;
    }

    private final boolean requestIsOneShot(IOException e16, Request userRequest) {
        RequestBody body = userRequest.body();
        if ((body != null && body.isOneShot()) || (e16 instanceof FileNotFoundException)) {
            return true;
        }
        return false;
    }

    private final int retryAfter(Response userResponse, int defaultDelay) {
        String header$default = Response.header$default(userResponse, "Retry-After", null, 2, null);
        if (header$default != null) {
            if (new Regex("\\d+").matches(header$default)) {
                Integer valueOf = Integer.valueOf(header$default);
                Intrinsics.checkNotNullExpressionValue(valueOf, "Integer.valueOf(header)");
                return valueOf.intValue();
            }
            return Integer.MAX_VALUE;
        }
        return defaultDelay;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        if (r7 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        r0 = r0.newBuilder().priorResponse(r7.newBuilder().body(null).build()).build();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
    
        r7 = r0;
        r0 = r1.getInterceptorScopedExchange();
        r6 = followUpRequest(r7, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
    
        if (r6 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005b, code lost:
    
        r0 = r6.body();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005f, code lost:
    
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0065, code lost:
    
        if (r0.isOneShot() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0067, code lost:
    
        r1.exitNetworkInterceptorExchange$okhttp(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006a, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006b, code lost:
    
        r0 = r7.body();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
    
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
    
        okhttp3.internal.Util.closeQuietly(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0074, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0078, code lost:
    
        if (r8 > 20) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0096, code lost:
    
        throw new java.net.ProtocolException("Too many follow-up requests: " + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004c, code lost:
    
        if (r0 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0052, code lost:
    
        if (r0.getIsDuplex() == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0054, code lost:
    
        r1.timeoutEarlyExit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0057, code lost:
    
        r1.exitNetworkInterceptorExchange$okhttp(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005a, code lost:
    
        return r7;
     */
    @Override // okhttp3.Interceptor
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        List emptyList;
        boolean z16;
        Request followUpRequest;
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = realInterceptorChain.getRequest();
        RealCall call = realInterceptorChain.getCall();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        int i3 = 0;
        Response response = null;
        while (true) {
            boolean z17 = true;
            while (true) {
                call.enterNetworkInterceptorExchange(request, z17);
                try {
                    if (!call.getCanceled()) {
                        try {
                            Response proceed = realInterceptorChain.proceed(request);
                            break;
                        } catch (IOException e16) {
                            if (!(e16 instanceof ConnectionShutdownException)) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (recover(e16, call, request, z16)) {
                                emptyList = CollectionsKt___CollectionsKt.plus((Collection<? extends IOException>) ((Collection<? extends Object>) emptyList), e16);
                            } else {
                                throw Util.withSuppressed(e16, emptyList);
                            }
                        } catch (RouteException e17) {
                            if (recover(e17.getLastConnectException(), call, request, false)) {
                                emptyList = CollectionsKt___CollectionsKt.plus((Collection<? extends IOException>) ((Collection<? extends Object>) emptyList), e17.getFirstConnectException());
                            } else {
                                throw Util.withSuppressed(e17.getFirstConnectException(), emptyList);
                            }
                        }
                    } else {
                        throw new IOException("Canceled");
                    }
                    call.exitNetworkInterceptorExchange$okhttp(true);
                    z17 = false;
                } catch (Throwable th5) {
                    call.exitNetworkInterceptorExchange$okhttp(true);
                    throw th5;
                }
            }
            call.exitNetworkInterceptorExchange$okhttp(true);
            request = followUpRequest;
        }
    }
}
