package com.tencent.qqnt.http.api.impl;

import android.os.SystemClock;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.dns.NtDnsManager;
import com.tencent.qqnt.http.api.n;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J&\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J*\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J2\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0016\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/http/api/impl/d;", "Lokhttp3/EventListener;", "Lokhttp3/Call;", "call", "", "callStart", "", "domainName", "dnsStart", "", "Ljava/net/InetAddress;", "inetAddressList", "dnsEnd", "Ljava/net/InetSocketAddress;", "inetSocketAddress", "Ljava/net/Proxy;", "proxy", "connectStart", "secureConnectStart", "Lokhttp3/Handshake;", "handshake", "secureConnectEnd", "Lokhttp3/Protocol;", AudienceReportConst.PROTOCOL, "connectEnd", "Ljava/io/IOException;", "ioe", "connectFailed", "callEnd", "callFailed", "requestHeadersStart", "Lokhttp3/Response;", "response", "responseHeadersEnd", "", "byteCount", "responseBodyEnd", "<init>", "()V", "a", "http_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class d extends EventListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/http/api/impl/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "http_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.http.api.impl.d$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/http/api/impl/d$b", "Lcom/tencent/qqnt/http/api/f;", "", "contentLength", "()Ljava/lang/Long;", "", "", "headers", "", "a", "http_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements com.tencent.qqnt.http.api.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Long f357016a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map<String, String> f357017b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Response f357018c;

        b(Long l3, Map<String, String> map, Response response) {
            this.f357016a = l3;
            this.f357017b = map;
            this.f357018c = response;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, l3, map, response);
            }
        }

        @Override // com.tencent.qqnt.http.api.f
        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.f357018c.code();
        }

        @Override // com.tencent.qqnt.http.api.f
        @Nullable
        public Long contentLength() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Long) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f357016a;
        }

        @Override // com.tencent.qqnt.http.api.f
        @Nullable
        public Map<String, String> headers() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f357017b;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31508);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // okhttp3.EventListener
    public void callEnd(@NotNull Call call) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) call);
            return;
        }
        Intrinsics.checkNotNullParameter(call, "call");
        super.callEnd(call);
        c a16 = com.tencent.qqnt.http.okhttp3.c.a(call);
        if (a16 != null) {
            a16.d(Long.valueOf(SystemClock.uptimeMillis()));
        }
    }

    @Override // okhttp3.EventListener
    public void callFailed(@NotNull Call call, @NotNull IOException ioe) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) call, (Object) ioe);
            return;
        }
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        super.callFailed(call, ioe);
        c a16 = com.tencent.qqnt.http.okhttp3.c.a(call);
        if (a16 != null) {
            a16.d(Long.valueOf(SystemClock.uptimeMillis()));
        }
    }

    @Override // okhttp3.EventListener
    public void callStart(@NotNull Call call) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) call);
            return;
        }
        Intrinsics.checkNotNullParameter(call, "call");
        super.callStart(call);
        long uptimeMillis = SystemClock.uptimeMillis();
        com.tencent.qqnt.http.api.b b16 = com.tencent.qqnt.http.okhttp3.c.b(call);
        if (b16 != null) {
            com.tencent.qqnt.http.api.e g16 = b16.g();
            if (g16 != null) {
                g16.onStart(b16);
            }
            b16.s().h(Long.valueOf(uptimeMillis));
        }
        c a16 = com.tencent.qqnt.http.okhttp3.c.a(call);
        if (a16 != null) {
            a16.e(uptimeMillis);
        }
    }

    @Override // okhttp3.EventListener
    public void connectEnd(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol2) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, call, inetSocketAddress, proxy, protocol2);
            return;
        }
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        super.connectEnd(call, inetSocketAddress, proxy, protocol2);
        com.tencent.qqnt.http.api.b b16 = com.tencent.qqnt.http.okhttp3.c.b(call);
        if (b16 != null) {
            num = Integer.valueOf(b16.u());
        } else {
            num = null;
        }
        QLog.i("NTHttp.EventManager", 1, "task:" + num + " connectEnd address:" + inetSocketAddress + " proxy:" + proxy + " protocol:" + protocol2);
        c a16 = com.tencent.qqnt.http.okhttp3.c.a(call);
        if (a16 != null) {
            a16.f(Long.valueOf(SystemClock.uptimeMillis()));
        }
    }

    @Override // okhttp3.EventListener
    public void connectFailed(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol2, @NotNull IOException ioe) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, call, inetSocketAddress, proxy, protocol2, ioe);
            return;
        }
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        super.connectFailed(call, inetSocketAddress, proxy, protocol2, ioe);
        if (QLog.isDevelopLevel()) {
            com.tencent.qqnt.http.api.b b16 = com.tencent.qqnt.http.okhttp3.c.b(call);
            if (b16 != null) {
                num = Integer.valueOf(b16.u());
            } else {
                num = null;
            }
            QLog.w("NTHttp.EventManager", 1, "task:" + num + " connectFailed address:" + inetSocketAddress + " proxy:" + proxy + " protocol:" + protocol2 + "\n error " + ioe.getMessage());
        }
        c a16 = com.tencent.qqnt.http.okhttp3.c.a(call);
        if (a16 != null) {
            a16.f(Long.valueOf(SystemClock.uptimeMillis()));
        }
        NtDnsManager.f355947a.a().g(inetSocketAddress.getAddress().getHostName(), inetSocketAddress.getAddress().getHostAddress(), -1001);
    }

    @Override // okhttp3.EventListener
    public void connectStart(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, call, inetSocketAddress, proxy);
            return;
        }
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        super.connectStart(call, inetSocketAddress, proxy);
        c a16 = com.tencent.qqnt.http.okhttp3.c.a(call);
        if (a16 != null) {
            a16.g(Long.valueOf(SystemClock.uptimeMillis()));
        }
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(@NotNull Call call, @NotNull String domainName, @NotNull List<? extends InetAddress> inetAddressList) {
        com.tencent.qqnt.http.api.e g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, call, domainName, inetAddressList);
            return;
        }
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(domainName, "domainName");
        Intrinsics.checkNotNullParameter(inetAddressList, "inetAddressList");
        super.dnsEnd(call, domainName, inetAddressList);
        c a16 = com.tencent.qqnt.http.okhttp3.c.a(call);
        if (a16 != null) {
            a16.h(Long.valueOf(SystemClock.uptimeMillis()));
        }
        com.tencent.qqnt.http.api.b b16 = com.tencent.qqnt.http.okhttp3.c.b(call);
        if (b16 != null && (g16 = b16.g()) != null) {
            g16.onDnsEnd(com.tencent.qqnt.http.okhttp3.c.b(call));
        }
    }

    @Override // okhttp3.EventListener
    public void dnsStart(@NotNull Call call, @NotNull String domainName) {
        com.tencent.qqnt.http.api.e g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) call, (Object) domainName);
            return;
        }
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(domainName, "domainName");
        super.dnsStart(call, domainName);
        c a16 = com.tencent.qqnt.http.okhttp3.c.a(call);
        if (a16 != null) {
            a16.i(Long.valueOf(SystemClock.uptimeMillis()));
        }
        com.tencent.qqnt.http.api.b b16 = com.tencent.qqnt.http.okhttp3.c.b(call);
        if (b16 != null && (g16 = b16.g()) != null) {
            g16.onDnsStart(com.tencent.qqnt.http.okhttp3.c.b(call));
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(@NotNull Call call) {
        Integer num;
        String joinToString$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) call);
            return;
        }
        Intrinsics.checkNotNullParameter(call, "call");
        super.requestHeadersStart(call);
        Headers headers = call.request().headers();
        if (headers.size() > 0) {
            com.tencent.qqnt.http.api.b b16 = com.tencent.qqnt.http.okhttp3.c.b(call);
            if (b16 != null) {
                num = Integer.valueOf(b16.u());
            } else {
                num = null;
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(headers, null, null, null, 0, null, null, 63, null);
            QLog.i("NTHttp.EventManager", 1, "task:" + num + " requestHeadersStart header:" + joinToString$default);
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(@NotNull Call call, long byteCount) {
        com.tencent.qqnt.http.api.e g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, call, Long.valueOf(byteCount));
            return;
        }
        Intrinsics.checkNotNullParameter(call, "call");
        super.responseBodyEnd(call, byteCount);
        com.tencent.qqnt.http.api.b b16 = com.tencent.qqnt.http.okhttp3.c.b(call);
        if (b16 != null && (g16 = b16.g()) != null) {
            g16.onBodyCompleted(b16);
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(@NotNull Call call, @NotNull Response response) {
        Map map;
        Long l3;
        long j3;
        int lastIndexOf$default;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) call, (Object) response);
            return;
        }
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        super.responseHeadersEnd(call, response);
        com.tencent.qqnt.http.api.b b16 = com.tencent.qqnt.http.okhttp3.c.b(call);
        if (b16 != null) {
            Headers headers = response.headers();
            String str2 = null;
            if (headers != null) {
                map = MapsKt__MapsKt.toMap(headers);
            } else {
                map = null;
            }
            if (map != null && (str = (String) map.get("Content-Length")) != null) {
                l3 = Long.valueOf(Long.parseLong(str));
            } else {
                l3 = null;
            }
            com.tencent.qqnt.http.api.e g16 = b16.g();
            if (g16 != null) {
                g16.onGetHeader(b16, new b(l3, map, response));
            }
            com.tencent.qqnt.http.api.e g17 = b16.g();
            if (g17 != null) {
                g17.onResponseURL(response.request().url().url());
            }
            if (map != null) {
                str2 = (String) map.get("Content-Range");
            }
            long j16 = 0;
            if (str2 != null) {
                lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str2, "/", 0, false, 6, (Object) null);
                try {
                    String substring = str2.substring(lastIndexOf$default + 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    b16.s().j(Long.parseLong(substring));
                } catch (Exception e16) {
                    QLog.e("NTHttp.EventManager", 1, "responseHeadersEnd", e16);
                }
            } else {
                n s16 = b16.s();
                if (l3 != null) {
                    j3 = l3.longValue();
                } else {
                    j3 = 0;
                }
                s16.j(j3);
            }
            n s17 = b16.s();
            if (l3 != null) {
                j16 = l3.longValue();
            }
            s17.i(j16);
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(@NotNull Call call, @Nullable Handshake handshake) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) call, (Object) handshake);
            return;
        }
        Intrinsics.checkNotNullParameter(call, "call");
        super.secureConnectEnd(call, handshake);
        c a16 = com.tencent.qqnt.http.okhttp3.c.a(call);
        if (a16 != null) {
            a16.j(Long.valueOf(SystemClock.uptimeMillis()));
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(@NotNull Call call) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) call);
            return;
        }
        Intrinsics.checkNotNullParameter(call, "call");
        super.secureConnectStart(call);
        c a16 = com.tencent.qqnt.http.okhttp3.c.a(call);
        if (a16 != null) {
            a16.k(Long.valueOf(SystemClock.uptimeMillis()));
        }
    }
}
