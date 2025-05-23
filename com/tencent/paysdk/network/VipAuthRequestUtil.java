package com.tencent.paysdk.network;

import androidx.annotation.RestrictTo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.paysdk.api.k;
import com.tencent.paysdk.api.m;
import com.tencent.paysdk.network.RequestWrapper;
import com.tencent.paysdk.report.InternalReport;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/paysdk/network/VipAuthRequestUtil;", "", "f", "Companion", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes22.dex */
public final class VipAuthRequestUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public static String f342035a;

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public static String f342036b;

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    @NotNull
    public static String f342037c;

    /* renamed from: d, reason: collision with root package name */
    private static k f342038d;

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicInteger f342039e;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fR\u0016\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0016\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0010R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/paysdk/network/VipAuthRequestUtil$Companion;", "", "", "c", "", "b", "Lcom/tencent/paysdk/api/k;", "vipHttpClient", "", "e", "Lcom/tencent/paysdk/network/RequestWrapper;", "requestWrapper", "Lcom/tencent/paysdk/network/c;", "responseCallback", "d", "DEFINITION_AUTH_URL", "Ljava/lang/String;", "DEFINITION_AUTH_URL_CONST", "DOMAIN", "HTTPS", "LIVE_AUTH_URL", "LIVE_AUTH_URL_CONST", "TAG", "TEST_DOMAIN", "VIDEO_AUTH_URL", "VIDEO_AUTH_URL_CONST", "Ljava/util/concurrent/atomic/AtomicInteger;", "sRequestId", "Ljava/util/concurrent/atomic/AtomicInteger;", "sVipHttpClient", "Lcom/tencent/paysdk/api/k;", "<init>", "()V", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b() {
            StringBuilder sb5 = new StringBuilder();
            com.tencent.paysdk.a.l();
            List<String> o16 = com.tencent.paysdk.a.o();
            int size = o16.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (i3 > 0) {
                    sb5.append(";");
                }
                sb5.append(o16.get(i3));
            }
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "buffer.toString()");
            return sb6;
        }

        private final int c() {
            int incrementAndGet;
            do {
                incrementAndGet = VipAuthRequestUtil.f342039e.incrementAndGet();
                if (incrementAndGet > 0) {
                    return incrementAndGet;
                }
            } while (!VipAuthRequestUtil.f342039e.compareAndSet(incrementAndGet, 1));
            return 1;
        }

        public final int d(@NotNull final RequestWrapper requestWrapper, @NotNull final c responseCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) requestWrapper, (Object) responseCallback)).intValue();
            }
            Intrinsics.checkNotNullParameter(requestWrapper, "requestWrapper");
            Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
            final int c16 = c();
            d.a(new Runnable(responseCallback, c16) { // from class: com.tencent.paysdk.network.VipAuthRequestUtil$Companion$request$1
                static IPatchRedirector $redirector_;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ c f342042e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f342043f;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f342042e = responseCallback;
                    this.f342043f = c16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, RequestWrapper.this, responseCallback, Integer.valueOf(c16));
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    k kVar;
                    String b16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                        return;
                    }
                    InternalReport.Companion companion = InternalReport.INSTANCE;
                    companion.i(companion.c());
                    try {
                        kVar = VipAuthRequestUtil.f342038d;
                        m a16 = kVar.a();
                        String c17 = RequestWrapper.this.c();
                        Intrinsics.checkNotNullExpressionValue(c17, "requestWrapper.url");
                        a16.b(c17);
                        a16.a("Custom-Devices", " guid=" + com.tencent.paysdk.a.l().getDeviceInfo().getGuid());
                        RequestWrapper.RequestType b17 = RequestWrapper.this.b();
                        Intrinsics.checkNotNull(b17);
                        a16.e(b17);
                        a16.f("Referer", "https://m.film.qq.com/player/payview/?from=tva");
                        b16 = VipAuthRequestUtil.INSTANCE.b();
                        a16.c("Cookie", b16);
                        String b18 = com.tencent.paysdk.util.d.b(RequestWrapper.this.a());
                        Intrinsics.checkNotNullExpressionValue(b18, "GsonUtil.toJson(requestWrapper.iRequestData)");
                        a16.d("application/json;charset=utf-8", b18);
                        this.f342042e.a(this.f342043f, a16.request());
                    } catch (Exception e16) {
                        this.f342042e.onFailed(this.f342043f);
                        com.tencent.paysdk.log.c.a("VipAuthRequestUtil", e16.toString());
                    }
                }
            });
            return c16;
        }

        public final void e(@Nullable k vipHttpClient) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) vipHttpClient);
            } else if (vipHttpClient != null) {
                VipAuthRequestUtil.f342038d = vipHttpClient;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12962);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        INSTANCE = new Companion(null);
        f342035a = VipAuthRequestUtil$Companion$VIDEO_AUTH_URL$1.INSTANCE.invoke();
        f342036b = VipAuthRequestUtil$Companion$LIVE_AUTH_URL$1.INSTANCE.invoke();
        f342037c = VipAuthRequestUtil$Companion$DEFINITION_AUTH_URL$1.INSTANCE.invoke();
        f342038d = new b();
        f342039e = new AtomicInteger();
    }
}
