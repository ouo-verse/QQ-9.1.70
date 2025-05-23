package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okio.BufferedSink;
import okio.Okio;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "forWebSocket", "", "(Z)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z16) {
        this.forWebSocket = z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0140, code lost:
    
        if (r1 != false) goto L42;
     */
    @Override // okhttp3.Interceptor
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        boolean z16;
        Response.Builder builder;
        Response build;
        boolean equals;
        long j3;
        boolean equals2;
        boolean equals3;
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Exchange exchange = realInterceptorChain.getExchange();
        Intrinsics.checkNotNull(exchange);
        Request request = realInterceptorChain.getRequest();
        RequestBody body = request.body();
        long currentTimeMillis = System.currentTimeMillis();
        exchange.writeRequestHeaders(request);
        Long l3 = null;
        if (HttpMethod.permitsRequestBody(request.method()) && body != null) {
            equals3 = StringsKt__StringsJVMKt.equals("100-continue", request.header("Expect"), true);
            if (equals3) {
                exchange.flushRequest();
                builder = exchange.readResponseHeaders(true);
                exchange.responseHeadersStart();
                z16 = false;
            } else {
                z16 = true;
                builder = null;
            }
            if (builder == null) {
                if (body.isDuplex()) {
                    exchange.flushRequest();
                    body.writeTo(Okio.buffer(exchange.createRequestBody(request, true)));
                } else {
                    BufferedSink buffer = Okio.buffer(exchange.createRequestBody(request, false));
                    body.writeTo(buffer);
                    buffer.close();
                }
            } else {
                exchange.noRequestBody();
                if (!exchange.getConnection().isMultiplexed$okhttp()) {
                    exchange.noNewExchangesOnConnection();
                }
            }
        } else {
            exchange.noRequestBody();
            z16 = true;
            builder = null;
        }
        if (body == null || !body.isDuplex()) {
            exchange.finishRequest();
        }
        if (builder == null) {
            builder = exchange.readResponseHeaders(false);
            Intrinsics.checkNotNull(builder);
            if (z16) {
                exchange.responseHeadersStart();
                z16 = false;
            }
        }
        Response build2 = builder.request(request).handshake(exchange.getConnection().getHandshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int code = build2.code();
        if (code == 100) {
            Response.Builder readResponseHeaders = exchange.readResponseHeaders(false);
            Intrinsics.checkNotNull(readResponseHeaders);
            if (z16) {
                exchange.responseHeadersStart();
            }
            build2 = readResponseHeaders.request(request).handshake(exchange.getConnection().getHandshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            code = build2.code();
        }
        exchange.responseHeadersEnd(build2);
        if (this.forWebSocket && code == 101) {
            build = build2.newBuilder().body(Util.EMPTY_RESPONSE).build();
        } else {
            build = build2.newBuilder().body(exchange.openResponseBody(build2)).build();
        }
        equals = StringsKt__StringsJVMKt.equals("close", build.request().header("Connection"), true);
        if (!equals) {
            equals2 = StringsKt__StringsJVMKt.equals("close", Response.header$default(build, "Connection", null, 2, null), true);
        }
        exchange.noNewExchangesOnConnection();
        if (code == 204 || code == 205) {
            ResponseBody body2 = build.body();
            if (body2 != null) {
                j3 = body2.getContentLength();
            } else {
                j3 = -1;
            }
            if (j3 > 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("HTTP ");
                sb5.append(code);
                sb5.append(" had non-zero Content-Length: ");
                ResponseBody body3 = build.body();
                if (body3 != null) {
                    l3 = Long.valueOf(body3.getContentLength());
                }
                sb5.append(l3);
                throw new ProtocolException(sb5.toString());
            }
        }
        return build;
    }
}
