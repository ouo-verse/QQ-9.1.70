package com.tencent.kuikly.core.render.android.expand.module;

import com.tencent.kuikly.core.render.android.expand.module.KRNetworkModule;
import com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import d01.w;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 )2\u00020\u0001:\u0001\u0016B4\u0012+\u0010&\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001fj\u0004\u0018\u0001`#\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J:\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0002R\u0017\u0010\u001a\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR;\u0010&\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001fj\u0004\u0018\u0001`#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/KRHttpEventStreamRequestSession;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "", "errorMsg", "j", "data", "l", "i", "method", "url", "Lorg/json/JSONObject;", "param", "header", "", "timeoutS", "cookie", "o", "g", tl.h.F, "a", "Ljava/lang/String;", DomainData.DOMAIN_NAME, "()Ljava/lang/String;", "sessionId", "", "b", "Z", "isCancel", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "c", "Lkotlin/jvm/functions/Function1;", "callback", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "e", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRHttpEventStreamRequestSession {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String sessionId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isCancel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> callback;

    /* renamed from: d, reason: collision with root package name */
    private static int f118015d = 1;

    public KRHttpEventStreamRequestSession(@Nullable Function1<Object, Unit> function1) {
        this.callback = function1;
        int i3 = f118015d;
        f118015d = i3 + 1;
        this.sessionId = String.valueOf(i3);
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        KuiklyRenderThreadManager.f118203b.j(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRHttpEventStreamRequestSession$fireEventStreamClose$1
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
                Function1 function1;
                Map mapOf;
                function1 = KRHttpEventStreamRequestSession.this.callback;
                if (function1 != null) {
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("eventType", 3));
                }
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(final String errorMsg) {
        KuiklyRenderThreadManager.f118203b.j(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRHttpEventStreamRequestSession$fireEventStreamFailure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Function1 function1;
                Map mapOf;
                function1 = KRHttpEventStreamRequestSession.this.callback;
                if (function1 != null) {
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("eventType", 4), TuplesKt.to("errorMsg", errorMsg));
                }
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        KuiklyRenderThreadManager.f118203b.j(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRHttpEventStreamRequestSession$fireEventStreamOpen$1
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
                Function1 function1;
                Map mapOf;
                function1 = KRHttpEventStreamRequestSession.this.callback;
                if (function1 != null) {
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("eventType", 2));
                }
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(final String data) {
        KuiklyRenderThreadManager.f118203b.j(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRHttpEventStreamRequestSession$fireEventStreamReceive$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Function1 function1;
                Map mapOf;
                function1 = KRHttpEventStreamRequestSession.this.callback;
                if (function1 != null) {
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("eventType", 5), TuplesKt.to("data", data));
                }
            }
        }, false);
    }

    private final void m() {
        KuiklyRenderThreadManager.f118203b.j(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRHttpEventStreamRequestSession$fireEventStreamSessionId$1
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
                Function1 function1;
                Map mapOf;
                function1 = KRHttpEventStreamRequestSession.this.callback;
                if (function1 != null) {
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("eventType", 1), TuplesKt.to("eventStreamSessionId", KRHttpEventStreamRequestSession.this.getSessionId()));
                }
            }
        }, false);
    }

    public final void g() {
        this.isCancel = true;
    }

    public final void h() {
        g();
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public final void o(@NotNull final String method, @NotNull final String url, @Nullable final JSONObject param, @Nullable final JSONObject header, final int timeoutS, @NotNull final String cookie) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        d01.n k3 = d01.u.f392615m.k();
        if (k3 != null) {
            k3.a(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRHttpEventStreamRequestSession$start$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Incorrect condition in loop: B:72:0x0068 */
                /* JADX WARN: Removed duplicated region for block: B:16:0x009c A[Catch: IOException -> 0x0098, TryCatch #2 {IOException -> 0x0098, blocks: (B:29:0x0092, B:16:0x009c, B:18:0x00a1, B:19:0x00a4), top: B:28:0x0092 }] */
                /* JADX WARN: Removed duplicated region for block: B:18:0x00a1 A[Catch: IOException -> 0x0098, TryCatch #2 {IOException -> 0x0098, blocks: (B:29:0x0092, B:16:0x009c, B:18:0x00a1, B:19:0x00a4), top: B:28:0x0092 }] */
                /* JADX WARN: Removed duplicated region for block: B:28:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:35:0x0109  */
                /* JADX WARN: Removed duplicated region for block: B:39:0x011a A[Catch: IOException -> 0x0116, TryCatch #5 {IOException -> 0x0116, blocks: (B:49:0x0112, B:39:0x011a, B:41:0x011f), top: B:48:0x0112 }] */
                /* JADX WARN: Removed duplicated region for block: B:41:0x011f A[Catch: IOException -> 0x0116, TRY_LEAVE, TryCatch #5 {IOException -> 0x0116, blocks: (B:49:0x0112, B:39:0x011a, B:41:0x011f), top: B:48:0x0112 }] */
                /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:48:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:50:0x010a  */
                /* JADX WARN: Removed duplicated region for block: B:54:0x013c A[Catch: IOException -> 0x0138, TryCatch #1 {IOException -> 0x0138, blocks: (B:65:0x0132, B:54:0x013c, B:56:0x0141, B:58:0x0146), top: B:64:0x0132 }] */
                /* JADX WARN: Removed duplicated region for block: B:56:0x0141 A[Catch: IOException -> 0x0138, TryCatch #1 {IOException -> 0x0138, blocks: (B:65:0x0132, B:54:0x013c, B:56:0x0141, B:58:0x0146), top: B:64:0x0132 }] */
                /* JADX WARN: Removed duplicated region for block: B:58:0x0146 A[Catch: IOException -> 0x0138, TRY_LEAVE, TryCatch #1 {IOException -> 0x0138, blocks: (B:65:0x0132, B:54:0x013c, B:56:0x0141, B:58:0x0146), top: B:64:0x0132 }] */
                /* JADX WARN: Removed duplicated region for block: B:64:0x0132 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2() {
                    HttpURLConnection httpURLConnection;
                    InputStream inputStream;
                    boolean z16;
                    String message;
                    w wVar;
                    StringBuilder sb5;
                    int responseCode;
                    boolean z17;
                    String readLine;
                    boolean z18 = true;
                    InputStream inputStream2 = null;
                    boolean z19 = false;
                    try {
                        try {
                            KRNetworkModule.Companion companion = KRNetworkModule.INSTANCE;
                            URLConnection f16 = companion.f(url, method, param);
                            if (f16 != null) {
                                httpURLConnection = (HttpURLConnection) f16;
                                try {
                                    httpURLConnection.setConnectTimeout(timeoutS * 1000);
                                    httpURLConnection.setReadTimeout(timeoutS * 1000);
                                    httpURLConnection.setUseCaches(false);
                                    httpURLConnection.setDoInput(true);
                                    companion.b(httpURLConnection, header, cookie);
                                    companion.a(httpURLConnection, method, header, param);
                                    companion.h(httpURLConnection, method);
                                    responseCode = httpURLConnection.getResponseCode();
                                } catch (Exception e16) {
                                    e = e16;
                                    inputStream = null;
                                } catch (Throwable th5) {
                                    th = th5;
                                    inputStream = null;
                                }
                                try {
                                    try {
                                        if (200 <= responseCode && 299 >= responseCode) {
                                            InputStream inputStream3 = httpURLConnection.getInputStream();
                                            try {
                                                KRHttpEventStreamRequestSession.this.k();
                                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream3));
                                                while (!z17 && (readLine = bufferedReader.readLine()) != null) {
                                                    KRHttpEventStreamRequestSession.this.l(readLine);
                                                }
                                                inputStream = null;
                                                z18 = false;
                                                inputStream2 = inputStream3;
                                                if (!z18) {
                                                    try {
                                                        KRHttpEventStreamRequestSession.this.i();
                                                    } catch (IOException e17) {
                                                        e = e17;
                                                        wVar = w.f392617a;
                                                        sb5 = new StringBuilder();
                                                        sb5.append("Network module close error: ");
                                                        sb5.append(e);
                                                        wVar.b("KRHttpEventStreamRequestSession", sb5.toString());
                                                        return;
                                                    }
                                                }
                                                if (inputStream2 != null) {
                                                    inputStream2.close();
                                                }
                                                if (inputStream != null) {
                                                    inputStream.close();
                                                }
                                                httpURLConnection.disconnect();
                                                return;
                                            } catch (Exception e18) {
                                                e = e18;
                                                inputStream = null;
                                                inputStream2 = inputStream3;
                                                w wVar2 = w.f392617a;
                                                StringBuilder sb6 = new StringBuilder();
                                                sb6.append("Network module startHttpEventStreamRequest error: ");
                                                sb6.append(e);
                                                sb6.append(", ");
                                                z16 = KRHttpEventStreamRequestSession.this.isCancel;
                                                sb6.append(z16);
                                                wVar2.b("KRHttpEventStreamRequestSession", sb6.toString());
                                                KRHttpEventStreamRequestSession kRHttpEventStreamRequestSession = KRHttpEventStreamRequestSession.this;
                                                message = e.getMessage();
                                                if (message != null) {
                                                }
                                                kRHttpEventStreamRequestSession.j(message);
                                                if (inputStream2 != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (httpURLConnection == null) {
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                                inputStream = null;
                                                inputStream2 = inputStream3;
                                                if (!z19) {
                                                }
                                                if (inputStream2 != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (httpURLConnection != null) {
                                                }
                                                throw th;
                                            }
                                        }
                                        KRHttpEventStreamRequestSession.this.j(companion.g(inputStream));
                                        if (!z18) {
                                        }
                                        if (inputStream2 != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        httpURLConnection.disconnect();
                                        return;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        if (!z19) {
                                            try {
                                                KRHttpEventStreamRequestSession.this.i();
                                            } catch (IOException e19) {
                                                w.f392617a.b("KRHttpEventStreamRequestSession", "Network module close error: " + e19);
                                                throw th;
                                            }
                                        }
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        throw th;
                                    }
                                } catch (Exception e26) {
                                    e = e26;
                                    w wVar22 = w.f392617a;
                                    StringBuilder sb62 = new StringBuilder();
                                    sb62.append("Network module startHttpEventStreamRequest error: ");
                                    sb62.append(e);
                                    sb62.append(", ");
                                    z16 = KRHttpEventStreamRequestSession.this.isCancel;
                                    sb62.append(z16);
                                    wVar22.b("KRHttpEventStreamRequestSession", sb62.toString());
                                    KRHttpEventStreamRequestSession kRHttpEventStreamRequestSession2 = KRHttpEventStreamRequestSession.this;
                                    message = e.getMessage();
                                    if (message != null) {
                                        message = "io exception";
                                    }
                                    kRHttpEventStreamRequestSession2.j(message);
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (IOException e27) {
                                            e = e27;
                                            wVar = w.f392617a;
                                            sb5 = new StringBuilder();
                                            sb5.append("Network module close error: ");
                                            sb5.append(e);
                                            wVar.b("KRHttpEventStreamRequestSession", sb5.toString());
                                            return;
                                        }
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (httpURLConnection == null) {
                                        httpURLConnection.disconnect();
                                        return;
                                    }
                                    return;
                                }
                                inputStream = httpURLConnection.getErrorStream();
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
                            }
                        } catch (Exception e28) {
                            e = e28;
                            httpURLConnection = null;
                            inputStream = null;
                        } catch (Throwable th8) {
                            th = th8;
                            httpURLConnection = null;
                            inputStream = null;
                        }
                    } catch (Throwable th9) {
                        z19 = true;
                        th = th9;
                    }
                }
            });
        }
    }
}
