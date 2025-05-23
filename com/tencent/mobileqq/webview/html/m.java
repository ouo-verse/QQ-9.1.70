package com.tencent.mobileqq.webview.html;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b;\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 O2\u00020\u0001:\u0001\nB'\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010 \u001a\u00020\u0006\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010,\u001a\u00020\u0004\u00a2\u0006\u0004\bR\u0010SJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u000fJ\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u0014\u001a\u00020\u000fJ\b\u0010\u0015\u001a\u00020\u000fH\u0016R\"\u0010\u0010\u001a\u00020\u000f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010 \u001a\u00020\u00068\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010,\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010/\u001a\u0004\u0018\u00010\u000f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001aR\"\u00105\u001a\u00020\b8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b0\u00102\"\u0004\b3\u00104R\"\u0010;\u001a\u00020\f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b6\u00108\"\u0004\b9\u0010:R\"\u0010>\u001a\u00020\b8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u00101\u001a\u0004\b<\u00102\"\u0004\b=\u00104R$\u0010A\u001a\u0004\u0018\u00010\u000f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b?\u0010\u0018\"\u0004\b@\u0010\u001aR\"\u0010D\u001a\u00020\u000f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0016\u001a\u0004\bB\u0010\u0018\"\u0004\bC\u0010\u001aR\"\u0010G\u001a\u00020\f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u00107\u001a\u0004\bE\u00108\"\u0004\bF\u0010:R\"\u0010J\u001a\u00020\f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u00107\u001a\u0004\bH\u00108\"\u0004\bI\u0010:R$\u0010Q\u001a\u0004\u0018\u00010K8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/webview/html/m;", "", "Lcom/tencent/mobileqq/webview/html/k;", tl.h.F, "Lcom/tencent/mobileqq/webview/html/h;", "c", "Lcom/tencent/mobileqq/webview/html/l;", "i", "", "u", "a", "v", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "", "url", "d", "l", "j", "e", "toString", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "setUrl$webview_kit_release", "(Ljava/lang/String;)V", "Lcom/tencent/mobileqq/webview/html/l;", "getSessionClient$webview_kit_release", "()Lcom/tencent/mobileqq/webview/html/l;", "setSessionClient$webview_kit_release", "(Lcom/tencent/mobileqq/webview/html/l;)V", "sessionClient", "Lcom/tencent/mobileqq/webview/html/k;", "getReqHandler$webview_kit_release", "()Lcom/tencent/mobileqq/webview/html/k;", "setReqHandler$webview_kit_release", "(Lcom/tencent/mobileqq/webview/html/k;)V", "reqHandler", "Lcom/tencent/mobileqq/webview/html/h;", "getCacheHandler$webview_kit_release", "()Lcom/tencent/mobileqq/webview/html/h;", "setCacheHandler$webview_kit_release", "(Lcom/tencent/mobileqq/webview/html/h;)V", "cacheHandler", "getHost$webview_kit_release", "setHost$webview_kit_release", "host", "f", "Z", "()Z", "o", "(Z)V", "noCache", "g", "I", "()I", "p", "(I)V", "redirectType", "getSupportSslRedirect$webview_kit_release", ReportConstant.COSTREPORT_PREFIX, "supportSslRedirect", "getSessionKeyMark$webview_kit_release", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "sessionKeyMark", "getUserAgent$webview_kit_release", "t", "userAgent", "getSessionTimeoutSeconds$webview_kit_release", "r", "sessionTimeoutSeconds", "getConnectTimeoutSeconds$webview_kit_release", "setConnectTimeoutSeconds$webview_kit_release", "connectTimeoutSeconds", "Lcom/tencent/mobileqq/webview/html/i;", "Lcom/tencent/mobileqq/webview/html/i;", "getCookieFetcher$webview_kit_release", "()Lcom/tencent/mobileqq/webview/html/i;", DomainData.DOMAIN_NAME, "(Lcom/tencent/mobileqq/webview/html/i;)V", "cookieFetcher", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/webview/html/l;Lcom/tencent/mobileqq/webview/html/k;Lcom/tencent/mobileqq/webview/html/h;)V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class m {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private l sessionClient;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private k reqHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private h cacheHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String host;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean noCache;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int redirectType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean supportSslRedirect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String sessionKeyMark;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String userAgent;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int sessionTimeoutSeconds;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int connectTimeoutSeconds;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private i cookieFetcher;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/webview/html/m$a;", "", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.webview.html.m$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40147);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 41)) {
            redirector.redirect((short) 41);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public m(@NotNull String url, @NotNull l sessionClient, @NotNull k reqHandler, @NotNull h cacheHandler) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(sessionClient, "sessionClient");
        Intrinsics.checkNotNullParameter(reqHandler, "reqHandler");
        Intrinsics.checkNotNullParameter(cacheHandler, "cacheHandler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, url, sessionClient, reqHandler, cacheHandler);
            return;
        }
        this.url = url;
        this.sessionClient = sessionClient;
        this.reqHandler = reqHandler;
        this.cacheHandler = cacheHandler;
        this.supportSslRedirect = true;
        this.userAgent = "";
        this.sessionTimeoutSeconds = 15;
        this.connectTimeoutSeconds = 15;
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this)).booleanValue();
        }
        if ((this.redirectType & 2) == 2) {
            return true;
        }
        return false;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        return this.connectTimeoutSeconds;
    }

    @NotNull
    public final h c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (h) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return this.cacheHandler;
    }

    @Nullable
    public final String d(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (String) iPatchRedirector.redirect((short) 36, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        i iVar = this.cookieFetcher;
        if (iVar != null) {
            return iVar.a(url);
        }
        return null;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (String) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        if (this.host == null) {
            this.host = new URI(this.url).getHost();
        }
        String str = this.host;
        Intrinsics.checkNotNull(str);
        return str;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.noCache;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.redirectType;
    }

    @NotNull
    public final k h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (k) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.reqHandler;
    }

    @NotNull
    public final l i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (l) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.sessionClient;
    }

    @Nullable
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (String) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        return this.sessionKeyMark;
    }

    @NotNull
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.url;
    }

    @NotNull
    public final String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.userAgent;
    }

    public final int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this)).intValue();
        }
        return this.sessionTimeoutSeconds;
    }

    public final void n(@Nullable i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) iVar);
        } else {
            this.cookieFetcher = iVar;
        }
    }

    public final void o(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.noCache = z16;
        }
    }

    public final void p(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.redirectType = i3;
        }
    }

    public final void q(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            this.sessionKeyMark = str;
        }
    }

    public final void r(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            this.sessionTimeoutSeconds = i3;
        }
    }

    public final void s(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.supportSslRedirect = z16;
        }
    }

    public final void t(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.userAgent = str;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (String) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        return "SessionConfig[noCache:" + this.noCache + ", redirectType:" + this.redirectType + ", supportSslRedirect:" + this.supportSslRedirect + ", sessionKeyMark:" + this.sessionKeyMark + ", sessionTimeoutSeconds:" + this.sessionTimeoutSeconds + ", connectTimeoutSeconds:" + this.connectTimeoutSeconds + ", sessionClient:" + this.sessionClient + ", reqHandler:" + this.reqHandler + ", url:" + this.url + "]";
    }

    public final boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
        }
        if ((this.redirectType & 1) == 1) {
            return true;
        }
        return false;
    }

    public final boolean v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        return this.supportSslRedirect;
    }
}
