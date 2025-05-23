package com.tencent.mobileqq.webview.swift.component;

import android.content.ComponentCallbacks2;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import wns_proxy.HttpRsp;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c extends b.C8976b {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f314442i;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList<a> f314443e;

    /* renamed from: f, reason: collision with root package name */
    private int f314444f;

    /* renamed from: h, reason: collision with root package name */
    private int f314445h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f314446a;

        /* renamed from: b, reason: collision with root package name */
        public String f314447b;

        /* renamed from: c, reason: collision with root package name */
        public String f314448c;

        /* renamed from: d, reason: collision with root package name */
        public String f314449d;

        a(String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, str, str2, str3);
                return;
            }
            this.f314447b = str;
            this.f314448c = str2;
            this.f314449d = str3;
            this.f314446a = System.currentTimeMillis();
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new SimpleDateFormat("HH:mm:ss").format(new Date(this.f314446a)) + " " + this.f314447b + "." + this.f314448c + ":" + this.f314449d;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49198);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f314442i = false;
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f314443e = new ArrayList<>(10);
        this.f314444f = -1;
        this.f314445h = -1;
    }

    public static c h(WebViewPluginEngine webViewPluginEngine) {
        ComponentCallbacks2 componentCallbacks2 = webViewPluginEngine.f314119i;
        if (componentCallbacks2 instanceof b.f) {
            return (c) ((b.f) componentCallbacks2).getComponentProvider().a(-3);
        }
        WebViewProvider webViewProvider = webViewPluginEngine.C;
        if (webViewProvider != null) {
            return (c) webViewProvider.getComponentProvider().a(-3);
        }
        return null;
    }

    private boolean i() {
        if (-1 == this.f314444f) {
            this.f314444f = this.f314441d.getActivity().getSharedPreferences(MiniConst.EnvSwitchActivityConst.KEY_ENV_SWITCH, 4).getBoolean("webview_jsapi_trace_switch", false) ? 1 : 0;
        }
        if (1 != this.f314444f) {
            return false;
        }
        return true;
    }

    private boolean j() {
        if (-1 == this.f314445h) {
            this.f314445h = this.f314441d.getActivity().getSharedPreferences(MiniConst.EnvSwitchActivityConst.KEY_ENV_SWITCH, 4).getBoolean("webview_cost_statistics_switch", false) ? 1 : 0;
        }
        if (1 != this.f314445h) {
            return false;
        }
        return true;
    }

    private void l(String str, int i3) {
        ((com.tencent.mobileqq.webview.swift.injector.e) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.e.class)).a(this.f314441d.getActivity(), str, i3);
    }

    private void m() {
        if (i()) {
            StringBuilder sb5 = new StringBuilder("\u9875\u9762\u5730\u5740:\r\n" + this.f314441d.getWebView().getUrl() + HttpRsp.HTTP_HEADER_END);
            sb5.append("\u767d\u540d\u5355\u53d1\u5e03\u7248\u672c\u53f7:");
            sb5.append(AuthorizeConfig.y().E());
            sb5.append(HttpRsp.HTTP_HEADER_END);
            sb5.append("JsAPI\u8c03\u7528\u8bb0\u5f55:\r\n");
            Iterator<a> it = this.f314443e.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().toString());
                sb5.append("\r\n");
            }
            l(sb5.toString(), R.string.f214375sq);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.C8976b
    public void f(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bundle);
        } else if (8 == i3) {
            m();
            k();
        }
    }

    public void g(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, str3);
        } else if (i()) {
            this.f314443e.add(new a(str, str2, str3));
        }
    }

    public void k() {
        int i3;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (j()) {
            SwiftBrowserStatistics swiftBrowserStatistics = (SwiftBrowserStatistics) this.f314441d.getProvider().a(-2);
            StringBuilder sb5 = new StringBuilder("\u9875\u9762\u5730\u5740:\r\n" + this.f314441d.getWebView().getUrl() + "\r\n\r\n\u5173\u952e\u6b65\u9aa4\u8017\u65f6\u7edf\u8ba1\u8bb0\u5f55:\r\n");
            Resources resources = this.f314441d.getActivity().getResources();
            if (swiftBrowserStatistics.G0) {
                i3 = R.string.f214405st;
            } else if (SwiftBrowserStatistics.f314343h1) {
                i3 = R.string.f214365sp;
            } else {
                i3 = R.string.f214335sm;
            }
            String string = resources.getString(i3);
            sb5.append("\u52a0\u8f7d\u6a21\u5f0f:");
            sb5.append(string);
            sb5.append("\r\n");
            String str3 = "\u662f";
            if (!swiftBrowserStatistics.G0 && SwiftBrowserStatistics.f314344i1) {
                sb5.append("\u662f\u5426\u5b8c\u5168\u9884\u52a0\u8f7d:");
                if (SwiftBrowserStatistics.f314344i1) {
                    str2 = "\u662f";
                } else {
                    str2 = "\u5426";
                }
                sb5.append(str2);
                sb5.append("\r\n");
            }
            sb5.append("\u662f\u5426\u547d\u4e2dWebView\u7f13\u5b58:");
            if (swiftBrowserStatistics.E0) {
                str = "\u662f";
            } else {
                str = "\u5426";
            }
            sb5.append(str);
            sb5.append("\r\n");
            sb5.append("\u662f\u5426\u547d\u4e2dBrowserView\u7f13\u5b58:");
            if (!swiftBrowserStatistics.F0) {
                str3 = "\u5426";
            }
            sb5.append(str3);
            sb5.append("\r\n");
            if (!swiftBrowserStatistics.G0 && SwiftBrowserStatistics.f314343h1) {
                sb5.append("\u9884\u52a0\u8f7d\u8fdb\u7a0b\u54cd\u5e94\u8017\u65f6:");
                sb5.append(SwiftBrowserStatistics.Z0);
                sb5.append("ms.\r\n");
                sb5.append("\u9884\u52a0\u8f7d\u9ed8\u8ba4\u5904\u7406\u8017\u65f6:");
                sb5.append(SwiftBrowserStatistics.f314336a1);
                sb5.append("ms.\r\n");
                sb5.append("\u9884\u52a0\u8f7d\u5b8c\u5168\u5904\u7406\u8017\u65f6:");
                sb5.append(SwiftBrowserStatistics.f314337b1);
                sb5.append("ms.\r\n");
                sb5.append("\u9884\u52a0\u8f7dX5\u73af\u5883\u5904\u7406\u8017\u65f6:");
                sb5.append(SwiftBrowserStatistics.f314338c1);
                sb5.append("ms.\r\n");
                sb5.append("\u9884\u521b\u5efaWebView\u5904\u7406\u8017\u65f6:");
                sb5.append(SwiftBrowserStatistics.f314339d1);
                sb5.append("ms.\r\n");
                sb5.append("\u9884\u70edWebView\u5904\u7406\u8017\u65f6:");
                sb5.append(SwiftBrowserStatistics.f314340e1);
                sb5.append("ms.\r\n");
                sb5.append("\u9884\u521b\u5efaBrowserView\u5904\u7406\u8017\u65f6:");
                sb5.append(SwiftBrowserStatistics.f314341f1);
                sb5.append("ms.\r\n");
            }
            sb5.append("\u70b9\u51fb\u54cd\u5e94\u6253\u70b9:");
            sb5.append(swiftBrowserStatistics.f314361h - swiftBrowserStatistics.f314358f);
            sb5.append("ms.\r\n");
            sb5.append("\u7ec8\u7aef\u5904\u7406\u6253\u70b9:");
            sb5.append(swiftBrowserStatistics.R - swiftBrowserStatistics.f314358f);
            sb5.append("ms.\r\n");
            sb5.append("\u8d44\u6e90\u52a0\u8f7d\u6253\u70b9:");
            sb5.append(swiftBrowserStatistics.f314370n0);
            sb5.append("ms.\r\n");
            sb5.append("\u4e3b\u8d44\u6e90\u9996\u884c\u6253\u70b9:");
            sb5.append(swiftBrowserStatistics.f314371o0);
            sb5.append("ms.\r\n");
            sb5.append("\u9996\u5c4f\u53ef\u89c1\u6253\u70b9:");
            sb5.append(swiftBrowserStatistics.f314372p0);
            sb5.append("ms.\r\n");
            sb5.append("\u9996\u5c4f\u53ef\u4ea4\u4e92\u6253\u70b9:");
            sb5.append(swiftBrowserStatistics.f314373q0);
            sb5.append("ms.\r\n");
            l(sb5.toString(), R.string.f214325sl);
        }
    }
}
