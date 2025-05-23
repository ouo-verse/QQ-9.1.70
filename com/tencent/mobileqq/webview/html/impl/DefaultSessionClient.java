package com.tencent.mobileqq.webview.html.impl;

import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.webview.html.HtmlSession;
import com.tencent.mobileqq.webview.html.c;
import com.tencent.mobileqq.webview.html.d;
import com.tencent.mobileqq.webview.html.l;
import com.tencent.mobileqq.webview.html.o;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0017\u0018\u0000 \u001c2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016Jb\u0010\u0017\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\t2&\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0015H\u0016J\"\u0010\u001c\u001a\u00020\u001b2\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00190\u0018H\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/webview/html/impl/DefaultSessionClient;", "Lcom/tencent/mobileqq/webview/html/l;", "Lcom/tencent/mobileqq/webview/html/HtmlSession;", SessionDbHelper.SESSION_ID, "", "f", "Lcom/tencent/biz/pubaccount/CustomWebView;", "webView", "d", "", "url", "b", "Landroid/os/Bundle;", "bundle", "a", "baseUrl", "data", "mimeType", "encoding", "historyUrl", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "headers", "g", "", "", "rspHeaders", "", "c", "Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;", "i", "newUrl", h.F, "destroy", "Lcom/tencent/mobileqq/webview/html/o;", "e", "Lcom/tencent/mobileqq/webview/html/HtmlSession;", "getSession", "()Lcom/tencent/mobileqq/webview/html/HtmlSession;", "setSession", "(Lcom/tencent/mobileqq/webview/html/HtmlSession;)V", "Lcom/tencent/biz/pubaccount/CustomWebView;", "getWebView", "()Lcom/tencent/biz/pubaccount/CustomWebView;", "setWebView", "(Lcom/tencent/biz/pubaccount/CustomWebView;)V", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class DefaultSessionClient implements l {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private HtmlSession session;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CustomWebView webView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/webview/html/impl/DefaultSessionClient$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.webview.html.impl.DefaultSessionClient$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40861);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public DefaultSessionClient() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webview.html.l
    public void a(@Nullable String url, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) url, (Object) bundle);
            return;
        }
        c.g(c.f313882a, "htmlAgent_DefaultSessionClient", 3, "loadUrl()", null, 8, null);
        CustomWebView customWebView = this.webView;
        if (customWebView != null) {
            customWebView.setForceLoadUrl(true);
            customWebView.loadUrlOriginal(url);
            customWebView.setForceLoadUrl(false);
        }
    }

    @Override // com.tencent.mobileqq.webview.html.l
    public void b(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        HtmlSession htmlSession = this.session;
        if (htmlSession != null) {
            htmlSession.t(url);
        }
    }

    @Override // com.tencent.mobileqq.webview.html.l
    public boolean c(@NotNull Map<String, ? extends List<String>> rspHeaders) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) rspHeaders)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(rspHeaders, "rspHeaders");
        d e16 = c.f313882a.e();
        if (e16 == null || !e16.h(rspHeaders)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.webview.html.l
    public void d(@NotNull CustomWebView webView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) webView);
            return;
        }
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.webView = webView;
        webView.setHtmlSessionClient(this);
    }

    @Override // com.tencent.mobileqq.webview.html.l
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        CustomWebView customWebView = this.webView;
        if (customWebView != null) {
            customWebView.setHtmlSessionClient(null);
        }
        c.g(c.f313882a, "htmlAgent_DefaultSessionClient", 4, "destroy()", null, 8, null);
        HtmlSession htmlSession = this.session;
        if (htmlSession != null) {
            htmlSession.f();
        }
    }

    @Override // com.tencent.mobileqq.webview.html.l
    @Nullable
    public o e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (o) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        HtmlSession htmlSession = this.session;
        if (htmlSession != null) {
            return htmlSession.l();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webview.html.l
    public void f(@NotNull HtmlSession session) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) session);
        } else {
            Intrinsics.checkNotNullParameter(session, "session");
            this.session = session;
        }
    }

    @Override // com.tencent.mobileqq.webview.html.l
    public void g(@Nullable String baseUrl, @Nullable String data, @Nullable String mimeType, @Nullable String encoding, @Nullable String historyUrl, @Nullable HashMap<String, String> headers) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, baseUrl, data, mimeType, encoding, historyUrl, headers);
            return;
        }
        boolean booleanValue = ((Boolean) t.INSTANCE.a().b("debug_enable_verbose_log", Boolean.FALSE)).booleanValue();
        c cVar = c.f313882a;
        if (booleanValue) {
            str = String.valueOf(headers);
        } else {
            str = "";
        }
        c.g(cVar, "htmlAgent_DefaultSessionClient", 5, "loadDataWithBaseURLAndHeader() mimeType:" + mimeType + " encoding:" + encoding + " " + str, null, 8, null);
        CustomWebView customWebView = this.webView;
        if (customWebView != null) {
            customWebView.loadDataWithBaseURLAndHeader(baseUrl, data, mimeType, encoding, historyUrl, headers);
        }
    }

    @Override // com.tencent.mobileqq.webview.html.l
    public void h(@NotNull String newUrl) {
        Boolean bool;
        WebViewClient webViewClient;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) newUrl);
            return;
        }
        Intrinsics.checkNotNullParameter(newUrl, "newUrl");
        c.g(c.f313882a, "htmlAgent_DefaultSessionClient", 5, "onUrlChange() newUrl=" + newUrl, null, 8, null);
        CustomWebView customWebView = this.webView;
        if (customWebView != null && (webViewClient = customWebView.getWebViewClient()) != null) {
            bool = Boolean.valueOf(webViewClient.shouldOverrideUrlLoading(this.webView, newUrl));
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            a(newUrl, null);
        }
    }

    @Override // com.tencent.mobileqq.webview.html.l
    @Nullable
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public WebResourceResponse shouldInterceptRequest(@NotNull String url) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (WebResourceResponse) iPatchRedirector.redirect((short) 13, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        HtmlSession htmlSession = this.session;
        if (htmlSession != null) {
            obj = htmlSession.A(url);
        } else {
            obj = null;
        }
        if (!(obj instanceof WebResourceResponse)) {
            return null;
        }
        return (WebResourceResponse) obj;
    }
}
