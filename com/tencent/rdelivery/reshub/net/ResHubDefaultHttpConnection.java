package com.tencent.rdelivery.reshub.net;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.raft.standard.net.IRNetwork;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import jz3.d;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b(\u0010)Jx\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\b26\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\nH\u0002JS\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022%\u0010\u0018\u001a!\u0012\u0017\u0012\u00150\u0015j\u0002`\u0016\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00110\u00142\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00110\u0014H\u0002J$\u0010\u001a\u001a\u00020\u00112\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001a\u0010\u001b\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001e\u0010\u001c\u001a\u00020\u00112\n\u0010\u0017\u001a\u00060\u0015j\u0002`\u00162\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002JP\u0010$\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b26\u0010\u0012\u001a2\u0012\u0013\u0012\u00110 \u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\"\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00110\nR\u0014\u0010'\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/rdelivery/reshub/net/ResHubDefaultHttpConnection;", "", "", "method", "urlString", "", "headers", "payload", "Lcom/tencent/rdelivery/reshub/net/b;", "failCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", AdMetricTag.RESPONSE_CODE, "Ljava/net/HttpURLConnection;", "conn", "", "action", "i", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "exceptionHandler", h.F, "k", "l", "f", "resHttpCode", "g", "url", "", "contentLength", "Ljava/io/InputStream;", "inputStream", "j", "a", "Ljava/lang/String;", "TAG", "<init>", "()V", "reshub-net_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class ResHubDefaultHttpConnection {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "ResHubDefaultHttpConnection";

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(Exception e16, b failCallback) {
        if (failCallback != null) {
            String message = e16.getMessage();
            if (message == null) {
                message = "";
            }
            failCallback.onError(2002, message, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(int resHttpCode, b failCallback) {
        if (failCallback != null) {
            failCallback.onError(resHttpCode, "Bad Http Response Code " + resHttpCode, true);
        }
    }

    private final void h(String urlString, String method, Function1<? super Exception, Unit> exceptionHandler, Function1<? super HttpURLConnection, Unit> action) {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                URLConnection openConnection = new URL(urlString).openConnection();
                if (openConnection != null) {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) openConnection;
                    try {
                        httpURLConnection2.setRequestMethod(method);
                        httpURLConnection2.setConnectTimeout(10000);
                        httpURLConnection2.setDoInput(true);
                        httpURLConnection2.setDoOutput(false);
                        action.invoke(httpURLConnection2);
                        httpURLConnection2.disconnect();
                        return;
                    } catch (Exception e16) {
                        e = e16;
                        httpURLConnection = httpURLConnection2;
                        exceptionHandler.invoke(e);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            return;
                        }
                        return;
                    } catch (Throwable th5) {
                        th = th5;
                        httpURLConnection = httpURLConnection2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                throw new TypeCastException("null cannot be cast to non-null type java.net.HttpURLConnection");
            } catch (Exception e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private final void i(String method, String urlString, final Map<String, String> headers, final Object payload, final b failCallback, final Function2<? super Integer, ? super HttpURLConnection, Unit> action) {
        String str = this.TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Http Request(");
        sb5.append(method);
        sb5.append("): ");
        sb5.append(urlString);
        sb5.append(" (thread: ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        sb5.append(currentThread.getId());
        sb5.append(')');
        d.a(str, sb5.toString());
        h(urlString, method, new Function1<Exception, Unit>() { // from class: com.tencent.rdelivery.reshub.net.ResHubDefaultHttpConnection$request$exceptionHandler$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Exception it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                ResHubDefaultHttpConnection.this.f(it, failCallback);
            }
        }, new Function1<HttpURLConnection, Unit>() { // from class: com.tencent.rdelivery.reshub.net.ResHubDefaultHttpConnection$request$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpURLConnection httpURLConnection) {
                invoke2(httpURLConnection);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull HttpURLConnection conn) {
                String str2;
                Intrinsics.checkParameterIsNotNull(conn, "conn");
                ResHubDefaultHttpConnection.this.k(headers, conn);
                ResHubDefaultHttpConnection.this.l(payload, conn);
                int responseCode = conn.getResponseCode();
                str2 = ResHubDefaultHttpConnection.this.TAG;
                d.a(str2, "Http Response Code = " + responseCode);
                action.invoke(Integer.valueOf(responseCode), conn);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Map<String, String> headers, HttpURLConnection conn) {
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            conn.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(Object payload, HttpURLConnection conn) {
        if (payload != null) {
            conn.setDoOutput(true);
            DataOutputStream dataOutputStream = new DataOutputStream(conn.getOutputStream());
            String obj = payload.toString();
            Charset charset = StandardCharsets.UTF_8;
            Intrinsics.checkExpressionValueIsNotNull(charset, "StandardCharsets.UTF_8");
            if (obj != null) {
                byte[] bytes = obj.getBytes(charset);
                Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                dataOutputStream.write(bytes);
                dataOutputStream.flush();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
    }

    public final void j(@NotNull String url, @Nullable final b failCallback, @NotNull final Function2<? super Long, ? super InputStream, Unit> action) {
        Map<String, String> mapOf;
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(action, "action");
        String name = IRNetwork.HttpMethod.GET.name();
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("Accept-Encoding", "identity"));
        i(name, url, mapOf, null, failCallback, new Function2<Integer, HttpURLConnection, Unit>() { // from class: com.tencent.rdelivery.reshub.net.ResHubDefaultHttpConnection$requestFileStream$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, HttpURLConnection httpURLConnection) {
                invoke(num.intValue(), httpURLConnection);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull HttpURLConnection conn) {
                Intrinsics.checkParameterIsNotNull(conn, "conn");
                if (i3 != 200) {
                    ResHubDefaultHttpConnection.this.g(i3, failCallback);
                    return;
                }
                Function2 function2 = action;
                Long valueOf = Long.valueOf(conn.getContentLength());
                InputStream inputStream = conn.getInputStream();
                Intrinsics.checkExpressionValueIsNotNull(inputStream, "conn.inputStream");
                function2.invoke(valueOf, inputStream);
            }
        });
    }
}
