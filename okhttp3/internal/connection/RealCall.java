package okhttp3.internal.connection;

import android.net.http.Headers;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CertificatePinner;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00b7\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001.\b\u0016\u0018\u00002\u00020\u0001:\u0002klB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u00101\u001a\u0002022\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u00103\u001a\u0002022\f\u00104\u001a\b\u0012\u0004\u0012\u00020205H\u0016J\u0016\u00106\u001a\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u00020:09H\u0014J\u000e\u0010;\u001a\b\u0012\u0004\u0012\u00020:0<H\u0014J!\u0010=\u001a\u0002H>\"\n\b\u0000\u0010>*\u0004\u0018\u00010?2\u0006\u0010@\u001a\u0002H>H\u0002\u00a2\u0006\u0002\u0010AJ\b\u0010B\u001a\u000202H\u0002J\b\u0010C\u001a\u000202H\u0016J\b\u0010D\u001a\u00020\u0000H\u0016J\u0010\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0005H\u0014J\u0010\u0010H\u001a\u0002022\u0006\u0010I\u001a\u00020JH\u0016J\u0016\u0010K\u001a\u0002022\u0006\u0010G\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u0007J\b\u0010M\u001a\u00020NH\u0016J\u0015\u0010O\u001a\u0002022\u0006\u0010P\u001a\u00020\u0007H\u0000\u00a2\u0006\u0002\bQJ\r\u0010R\u001a\u00020NH\u0000\u00a2\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020\u001e2\u0006\u0010U\u001a\u000207H\u0000\u00a2\u0006\u0002\bVJ\b\u0010W\u001a\u00020\u0007H\u0016J\b\u0010X\u001a\u00020\u0007H\u0016J;\u0010Y\u001a\u0002H>\"\n\b\u0000\u0010>*\u0004\u0018\u00010?2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010Z\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u00072\u0006\u0010@\u001a\u0002H>H\u0000\u00a2\u0006\u0004\b\\\u0010]J\u0019\u0010^\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010?H\u0000\u00a2\u0006\u0002\b_J\r\u0010`\u001a\u00020aH\u0000\u00a2\u0006\u0002\bbJ\u000f\u0010c\u001a\u0004\u0018\u00010dH\u0000\u00a2\u0006\u0002\beJ\b\u0010G\u001a\u00020\u0005H\u0016J\u0006\u0010f\u001a\u00020\u0007J\b\u0010-\u001a\u00020gH\u0016J\u0006\u00100\u001a\u000202J!\u0010h\u001a\u0002H>\"\n\b\u0000\u0010>*\u0004\u0018\u00010?2\u0006\u0010i\u001a\u0002H>H\u0002\u00a2\u0006\u0002\u0010AJ\b\u0010j\u001a\u00020aH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\"\u0010&\u001a\u0004\u0018\u00010\u001e2\b\u0010\u000e\u001a\u0004\u0018\u00010\u001e@BX\u0080\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020.X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010/R\u000e\u00100\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006m"}, d2 = {"Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Call;", "client", "Lokhttp3/OkHttpClient;", "originalRequest", "Lokhttp3/Request;", "forWebSocket", "", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Z)V", "callStackTrace", "", "canceled", "getClient", "()Lokhttp3/OkHttpClient;", "<set-?>", "Lokhttp3/internal/connection/RealConnection;", Headers.CONN_DIRECTIVE, "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionToCancel", "getConnectionToCancel", "setConnectionToCancel", "(Lokhttp3/internal/connection/RealConnection;)V", "eventListener", "Lokhttp3/EventListener;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "exchange", "Lokhttp3/internal/connection/Exchange;", "exchangeFinder", "Lokhttp3/internal/connection/ExchangeFinder;", "executed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "expectMoreExchanges", "getForWebSocket", "()Z", "interceptorScopedExchange", "getInterceptorScopedExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "getOriginalRequest", "()Lokhttp3/Request;", "requestBodyOpen", "responseBodyOpen", "timeout", "okhttp3/internal/connection/RealCall$timeout$1", "Lokhttp3/internal/connection/RealCall$timeout$1;", "timeoutEarlyExit", "acquireConnectionNoEvents", "", "asyncCallScope", "block", "Lkotlin/Function0;", "buildInterceptorChain", "Lokhttp3/internal/http/RealInterceptorChain;", "interceptors", "", "Lokhttp3/Interceptor;", "buildInterceptors", "", "callDone", "E", "Ljava/io/IOException;", "e", "(Ljava/io/IOException;)Ljava/io/IOException;", "callStart", "cancel", "clone", "createAddress", "Lokhttp3/Address;", Const.BUNDLE_KEY_REQUEST, "enqueue", "responseCallback", "Lokhttp3/Callback;", "enterNetworkInterceptorExchange", "newExchangeFinder", "execute", "Lokhttp3/Response;", "exitNetworkInterceptorExchange", "closeExchange", "exitNetworkInterceptorExchange$okhttp", "getResponseWithInterceptorChain", "getResponseWithInterceptorChain$okhttp", "initExchange", "chain", "initExchange$okhttp", "isCanceled", "isExecuted", "messageDone", "requestDone", "responseDone", "messageDone$okhttp", "(Lokhttp3/internal/connection/Exchange;ZZLjava/io/IOException;)Ljava/io/IOException;", "noMoreExchanges", "noMoreExchanges$okhttp", "redactedUrl", "", "redactedUrl$okhttp", "releaseConnectionNoEvents", "Ljava/net/Socket;", "releaseConnectionNoEvents$okhttp", "retryAfterFailure", "Lokio/AsyncTimeout;", "timeoutExit", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "toLoggableString", "AsyncCall", "CallReference", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public class RealCall implements Call {
    private Object callStackTrace;
    private volatile boolean canceled;

    @NotNull
    private final OkHttpClient client;

    @Nullable
    private RealConnection connection;
    private final RealConnectionPool connectionPool;

    @Nullable
    private volatile RealConnection connectionToCancel;

    @NotNull
    private final EventListener eventListener;
    private volatile Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private final AtomicBoolean executed;
    private boolean expectMoreExchanges;
    private final boolean forWebSocket;

    @Nullable
    private Exchange interceptorScopedExchange;

    @NotNull
    private final Request originalRequest;
    private boolean requestBodyOpen;
    private boolean responseBodyOpen;
    private final RealCall$timeout$1 timeout;
    private boolean timeoutEarlyExit;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u00020\u00172\n\u0010\u001b\u001a\u00060\u0000R\u00020\u0006J\b\u0010\u001c\u001a\u00020\u0017H\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lokhttp3/internal/connection/RealCall$AsyncCall;", "Ljava/lang/Runnable;", "responseCallback", "Lokhttp3/Callback;", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/Callback;)V", "call", "Lokhttp3/internal/connection/RealCall;", "getCall", "()Lokhttp3/internal/connection/RealCall;", "<set-?>", "Ljava/util/concurrent/atomic/AtomicInteger;", "callsPerHost", "getCallsPerHost", "()Ljava/util/concurrent/atomic/AtomicInteger;", "host", "", "getHost", "()Ljava/lang/String;", Const.BUNDLE_KEY_REQUEST, "Lokhttp3/Request;", "getRequest", "()Lokhttp3/Request;", "executeOn", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "reuseCallsPerHostFrom", "other", TencentLocation.RUN_MODE, "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public final class AsyncCall implements Runnable {

        @NotNull
        private volatile AtomicInteger callsPerHost;
        private final Callback responseCallback;
        final /* synthetic */ RealCall this$0;

        public AsyncCall(@NotNull RealCall realCall, Callback responseCallback) {
            Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
            this.this$0 = realCall;
            this.responseCallback = responseCallback;
            this.callsPerHost = new AtomicInteger(0);
        }

        public final void executeOn(@NotNull ExecutorService executorService) {
            Intrinsics.checkNotNullParameter(executorService, "executorService");
            Dispatcher dispatcher = this.this$0.getClient().dispatcher();
            if (Util.assertionsEnabled && Thread.holdsLock(dispatcher)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Thread ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                sb5.append(currentThread.getName());
                sb5.append(" MUST NOT hold lock on ");
                sb5.append(dispatcher);
                throw new AssertionError(sb5.toString());
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e16) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e16);
                    this.this$0.noMoreExchanges$okhttp(interruptedIOException);
                    this.responseCallback.onFailure(this.this$0, interruptedIOException);
                    this.this$0.getClient().dispatcher().finished$okhttp(this);
                }
            } catch (Throwable th5) {
                this.this$0.getClient().dispatcher().finished$okhttp(this);
                throw th5;
            }
        }

        @NotNull
        /* renamed from: getCall, reason: from getter */
        public final RealCall getThis$0() {
            return this.this$0;
        }

        @NotNull
        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        @NotNull
        public final String getHost() {
            return this.this$0.getOriginalRequest().url().host();
        }

        @NotNull
        public final Request getRequest() {
            return this.this$0.getOriginalRequest();
        }

        public final void reuseCallsPerHostFrom(@NotNull AsyncCall other) {
            Intrinsics.checkNotNullParameter(other, "other");
            this.callsPerHost = other.callsPerHost;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.asyncCallScope(new Function0<Unit>() { // from class: okhttp3.internal.connection.RealCall$AsyncCall$run$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    RealCall$timeout$1 realCall$timeout$1;
                    boolean z16;
                    Throwable th5;
                    IOException e16;
                    Callback callback;
                    Callback callback2;
                    String loggableString;
                    Response responseWithInterceptorChain$okhttp;
                    Callback callback3;
                    realCall$timeout$1 = RealCall.AsyncCall.this.this$0.timeout;
                    realCall$timeout$1.enter();
                    try {
                        try {
                            responseWithInterceptorChain$okhttp = RealCall.AsyncCall.this.this$0.getResponseWithInterceptorChain$okhttp();
                            z16 = true;
                        } catch (IOException e17) {
                            z16 = false;
                            e16 = e17;
                        } catch (Throwable th6) {
                            z16 = false;
                            th5 = th6;
                        }
                        try {
                            callback3 = RealCall.AsyncCall.this.responseCallback;
                            callback3.onResponse(RealCall.AsyncCall.this.this$0, responseWithInterceptorChain$okhttp);
                        } catch (IOException e18) {
                            e16 = e18;
                            if (!z16) {
                                callback2 = RealCall.AsyncCall.this.responseCallback;
                                callback2.onFailure(RealCall.AsyncCall.this.this$0, e16);
                            } else {
                                Platform platform = Platform.INSTANCE.get();
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("Callback failure for ");
                                loggableString = RealCall.AsyncCall.this.this$0.toLoggableString();
                                sb5.append(loggableString);
                                platform.log(sb5.toString(), 4, e16);
                            }
                            RealCall.AsyncCall.this.this$0.getClient().dispatcher().finished$okhttp(RealCall.AsyncCall.this);
                        } catch (Throwable th7) {
                            th5 = th7;
                            RealCall.AsyncCall.this.this$0.cancel();
                            if (!z16) {
                                IOException iOException = new IOException("canceled due to " + th5);
                                ExceptionsKt__ExceptionsKt.addSuppressed(iOException, th5);
                                callback = RealCall.AsyncCall.this.responseCallback;
                                callback.onFailure(RealCall.AsyncCall.this.this$0, iOException);
                            }
                            throw th5;
                        }
                        RealCall.AsyncCall.this.this$0.getClient().dispatcher().finished$okhttp(RealCall.AsyncCall.this);
                    } catch (Throwable th8) {
                        RealCall.AsyncCall.this.this$0.getClient().dispatcher().finished$okhttp(RealCall.AsyncCall.this);
                        throw th8;
                    }
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lokhttp3/internal/connection/RealCall$CallReference;", "Ljava/lang/ref/WeakReference;", "Lokhttp3/internal/connection/RealCall;", "referent", "callStackTrace", "", "(Lokhttp3/internal/connection/RealCall;Ljava/lang/Object;)V", "getCallStackTrace", "()Ljava/lang/Object;", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public static final class CallReference extends WeakReference<RealCall> {

        @Nullable
        private final Object callStackTrace;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CallReference(@NotNull RealCall referent, @Nullable Object obj) {
            super(referent);
            Intrinsics.checkNotNullParameter(referent, "referent");
            this.callStackTrace = obj;
        }

        @Nullable
        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [okio.Timeout, okhttp3.internal.connection.RealCall$timeout$1] */
    public RealCall(@NotNull OkHttpClient client, @NotNull Request originalRequest, boolean z16) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        this.client = client;
        this.originalRequest = originalRequest;
        this.forWebSocket = z16;
        this.connectionPool = client.connectionPool().getDelegate();
        this.eventListener = client.eventListenerFactory().create(this);
        ?? r46 = new AsyncTimeout() { // from class: okhttp3.internal.connection.RealCall$timeout$1
            @Override // okio.AsyncTimeout
            protected void timedOut() {
                RealCall.this.cancel();
            }
        };
        r46.timeout(client.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        Unit unit = Unit.INSTANCE;
        this.timeout = r46;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
    }

    private final <E extends IOException> E callDone(E e16) {
        Socket releaseConnectionNoEvents$okhttp;
        boolean z16;
        boolean z17 = Util.assertionsEnabled;
        if (z17 && Thread.holdsLock(this)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb5.append(currentThread.getName());
            sb5.append(" MUST NOT hold lock on ");
            sb5.append(this);
            throw new AssertionError(sb5.toString());
        }
        RealConnection realConnection = this.connection;
        if (realConnection != null) {
            if (z17 && Thread.holdsLock(realConnection)) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Thread ");
                Thread currentThread2 = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread2, "Thread.currentThread()");
                sb6.append(currentThread2.getName());
                sb6.append(" MUST NOT hold lock on ");
                sb6.append(realConnection);
                throw new AssertionError(sb6.toString());
            }
            synchronized (realConnection) {
                releaseConnectionNoEvents$okhttp = releaseConnectionNoEvents$okhttp();
            }
            if (this.connection == null) {
                if (releaseConnectionNoEvents$okhttp != null) {
                    Util.closeQuietly(releaseConnectionNoEvents$okhttp);
                }
                this.eventListener.connectionReleased(this, realConnection);
            } else {
                if (releaseConnectionNoEvents$okhttp == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        E e17 = (E) timeoutExit(e16);
        if (e16 != null) {
            EventListener eventListener = this.eventListener;
            Intrinsics.checkNotNull(e17);
            eventListener.callFailed(this, e17);
        } else {
            this.eventListener.callEnd(this);
        }
        return e17;
    }

    private final void callStart() {
        this.callStackTrace = Platform.INSTANCE.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this);
    }

    private final <E extends IOException> E timeoutExit(E cause) {
        if (this.timeoutEarlyExit) {
            return cause;
        }
        if (!exit()) {
            return cause;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (cause != null) {
            interruptedIOException.initCause(cause);
        }
        return interruptedIOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toLoggableString() {
        String str;
        String str2;
        StringBuilder sb5 = new StringBuilder();
        if (getCanceled()) {
            str = "canceled ";
        } else {
            str = "";
        }
        sb5.append(str);
        if (this.forWebSocket) {
            str2 = "web socket";
        } else {
            str2 = "call";
        }
        sb5.append(str2);
        sb5.append(" to ");
        sb5.append(redactedUrl$okhttp());
        return sb5.toString();
    }

    public final void acquireConnectionNoEvents(@NotNull RealConnection connection) {
        boolean z16;
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (Util.assertionsEnabled && !Thread.holdsLock(connection)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb5.append(currentThread.getName());
            sb5.append(" MUST hold lock on ");
            sb5.append(connection);
            throw new AssertionError(sb5.toString());
        }
        if (this.connection == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.connection = connection;
            connection.getCalls().add(new CallReference(this, this.callStackTrace));
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public void asyncCallScope(@NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        String str = "OkHttp " + redactedUrl$okhttp();
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "currentThread");
        String name = currentThread.getName();
        currentThread.setName(str);
        try {
            block.invoke();
        } finally {
            currentThread.setName(name);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public RealInterceptorChain buildInterceptorChain(@NotNull List<? extends Interceptor> interceptors) {
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        return new RealInterceptorChain(this, interceptors, 0, null, this.originalRequest, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public List<Interceptor> buildInterceptors() {
        ArrayList arrayList = new ArrayList();
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, this.client.interceptors());
        arrayList.add(new RetryAndFollowUpInterceptor(this.client));
        arrayList.add(new BridgeInterceptor(this.client.cookieJar()));
        arrayList.add(new CacheInterceptor(this.client.cache()));
        arrayList.add(ConnectInterceptor.INSTANCE);
        if (!this.forWebSocket) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, this.client.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.forWebSocket));
        return arrayList;
    }

    @Override // okhttp3.Call
    public void cancel() {
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            exchange.cancel();
        }
        RealConnection realConnection = this.connectionToCancel;
        if (realConnection != null) {
            realConnection.cancel();
        }
        this.eventListener.canceled(this);
    }

    @NotNull
    protected Address createAddress(@NotNull Request request) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        Intrinsics.checkNotNullParameter(request, "request");
        HttpUrl url = request.url();
        if (url.getIsHttps()) {
            sSLSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(url.host(), url.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    @Override // okhttp3.Call
    public void enqueue(@NotNull Callback responseCallback) {
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        if (this.executed.compareAndSet(false, true)) {
            callStart();
            this.client.dispatcher().enqueue$okhttp(new AsyncCall(this, responseCallback));
            return;
        }
        throw new IllegalStateException("Already Executed".toString());
    }

    public final void enterNetworkInterceptorExchange(@NotNull Request request, boolean newExchangeFinder) {
        boolean z16;
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.interceptorScopedExchange == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            synchronized (this) {
                if (!this.responseBodyOpen) {
                    if (!this.requestBodyOpen) {
                        Unit unit = Unit.INSTANCE;
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else {
                    throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
                }
            }
            if (newExchangeFinder) {
                this.exchangeFinder = new ExchangeFinder(this.connectionPool, createAddress(request), this, this.eventListener);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // okhttp3.Call
    @NotNull
    public Response execute() {
        if (this.executed.compareAndSet(false, true)) {
            enter();
            callStart();
            try {
                this.client.dispatcher().executed$okhttp(this);
                return getResponseWithInterceptorChain$okhttp();
            } finally {
                this.client.dispatcher().finished$okhttp(this);
            }
        }
        throw new IllegalStateException("Already Executed".toString());
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean closeExchange) {
        Exchange exchange;
        synchronized (this) {
            if (this.expectMoreExchanges) {
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("released".toString());
            }
        }
        if (closeExchange && (exchange = this.exchange) != null) {
            exchange.detachWithViolence();
        }
        this.interceptorScopedExchange = null;
    }

    @NotNull
    public final OkHttpClient getClient() {
        return this.client;
    }

    @Nullable
    public final RealConnection getConnection() {
        return this.connection;
    }

    @Nullable
    public final RealConnection getConnectionToCancel() {
        return this.connectionToCancel;
    }

    @NotNull
    /* renamed from: getEventListener$okhttp, reason: from getter */
    public final EventListener getEventListener() {
        return this.eventListener;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    @Nullable
    /* renamed from: getInterceptorScopedExchange$okhttp, reason: from getter */
    public final Exchange getInterceptorScopedExchange() {
        return this.interceptorScopedExchange;
    }

    @NotNull
    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    @NotNull
    public final Response getResponseWithInterceptorChain$okhttp() throws IOException {
        try {
            try {
                Response proceed = buildInterceptorChain(buildInterceptors()).proceed(this.originalRequest);
                if (!getCanceled()) {
                    noMoreExchanges$okhttp(null);
                    return proceed;
                }
                Util.closeQuietly(proceed);
                throw new IOException("Canceled");
            } catch (IOException e16) {
                IOException noMoreExchanges$okhttp = noMoreExchanges$okhttp(e16);
                if (noMoreExchanges$okhttp == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
                throw noMoreExchanges$okhttp;
            }
        } catch (Throwable th5) {
            if (0 == 0) {
                noMoreExchanges$okhttp(null);
            }
            throw th5;
        }
    }

    @NotNull
    public final Exchange initExchange$okhttp(@NotNull RealInterceptorChain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        synchronized (this) {
            if (this.expectMoreExchanges) {
                if (!this.responseBodyOpen) {
                    if (!this.requestBodyOpen) {
                        Unit unit = Unit.INSTANCE;
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                throw new IllegalStateException("released".toString());
            }
        }
        ExchangeFinder exchangeFinder = this.exchangeFinder;
        Intrinsics.checkNotNull(exchangeFinder);
        Exchange exchange = new Exchange(this, this.eventListener, exchangeFinder, exchangeFinder.find(this.client, chain));
        this.interceptorScopedExchange = exchange;
        this.exchange = exchange;
        synchronized (this) {
            this.requestBodyOpen = true;
            this.responseBodyOpen = true;
        }
        if (!this.canceled) {
            return exchange;
        }
        throw new IOException("Canceled");
    }

    @Override // okhttp3.Call
    /* renamed from: isCanceled, reason: from getter */
    public boolean getCanceled() {
        return this.canceled;
    }

    @Override // okhttp3.Call
    public boolean isExecuted() {
        return this.executed.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024 A[Catch: all -> 0x001a, TryCatch #0 {all -> 0x001a, blocks: (B:45:0x0015, B:12:0x0024, B:14:0x0028, B:15:0x002a, B:17:0x002e, B:21:0x0037, B:23:0x003b, B:27:0x0044, B:9:0x001e), top: B:44:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[Catch: all -> 0x001a, TryCatch #0 {all -> 0x001a, blocks: (B:45:0x0015, B:12:0x0024, B:14:0x0028, B:15:0x002a, B:17:0x002e, B:21:0x0037, B:23:0x003b, B:27:0x0044, B:9:0x001e), top: B:44:0x0015 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <E extends IOException> E messageDone$okhttp(@NotNull Exchange exchange, boolean requestDone, boolean responseDone, E e16) {
        boolean z16;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        boolean z19 = true;
        if (!Intrinsics.areEqual(exchange, this.exchange)) {
            return e16;
        }
        synchronized (this) {
            z16 = false;
            if (requestDone) {
                try {
                    if (!this.requestBodyOpen) {
                    }
                    if (requestDone) {
                        this.requestBodyOpen = false;
                    }
                    if (responseDone) {
                        this.responseBodyOpen = false;
                    }
                    z17 = this.requestBodyOpen;
                    if (z17 && !this.responseBodyOpen) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (!z17 || this.responseBodyOpen || this.expectMoreExchanges) {
                        z19 = false;
                    }
                    z16 = z18;
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th5) {
                    throw th5;
                }
            }
            if (!responseDone || !this.responseBodyOpen) {
                z19 = false;
                Unit unit2 = Unit.INSTANCE;
            }
            if (requestDone) {
            }
            if (responseDone) {
            }
            z17 = this.requestBodyOpen;
            if (z17) {
            }
            z18 = false;
            if (!z17) {
            }
            z19 = false;
            z16 = z18;
            Unit unit22 = Unit.INSTANCE;
        }
        if (z16) {
            this.exchange = null;
            RealConnection realConnection = this.connection;
            if (realConnection != null) {
                realConnection.incrementSuccessCount$okhttp();
            }
        }
        if (z19) {
            return (E) callDone(e16);
        }
        return e16;
    }

    @Nullable
    public final IOException noMoreExchanges$okhttp(@Nullable IOException e16) {
        boolean z16;
        synchronized (this) {
            z16 = false;
            if (this.expectMoreExchanges) {
                this.expectMoreExchanges = false;
                if (!this.requestBodyOpen && !this.responseBodyOpen) {
                    z16 = true;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z16) {
            return callDone(e16);
        }
        return e16;
    }

    @NotNull
    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }

    @Nullable
    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection realConnection = this.connection;
        Intrinsics.checkNotNull(realConnection);
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb5.append(currentThread.getName());
            sb5.append(" MUST hold lock on ");
            sb5.append(realConnection);
            throw new AssertionError(sb5.toString());
        }
        List<Reference<RealCall>> calls = realConnection.getCalls();
        Iterator<Reference<RealCall>> it = calls.iterator();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().get(), this)) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            z16 = true;
        }
        if (z16) {
            calls.remove(i3);
            this.connection = null;
            if (calls.isEmpty()) {
                realConnection.setIdleAtNs$okhttp(System.nanoTime());
                if (this.connectionPool.connectionBecameIdle(realConnection)) {
                    return realConnection.socket();
                }
            }
            return null;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // okhttp3.Call
    @NotNull
    public Request request() {
        return this.originalRequest;
    }

    public final boolean retryAfterFailure() {
        ExchangeFinder exchangeFinder = this.exchangeFinder;
        Intrinsics.checkNotNull(exchangeFinder);
        return exchangeFinder.retryAfterFailure();
    }

    public final void setConnectionToCancel(@Nullable RealConnection realConnection) {
        this.connectionToCancel = realConnection;
    }

    public final void timeoutEarlyExit() {
        if (!this.timeoutEarlyExit) {
            this.timeoutEarlyExit = true;
            exit();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // okhttp3.Call
    @NotNull
    public AsyncTimeout timeout() {
        return this.timeout;
    }

    @Override // okhttp3.Call
    @NotNull
    public RealCall clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }
}
