package com.tencent.mobileqq.webview.swift;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class q {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f314615b;

    /* renamed from: c, reason: collision with root package name */
    static Set<String> f314616c;

    /* renamed from: a, reason: collision with root package name */
    QQCustomDialog f314617a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48518);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f314616c = new HashSet();
        }
    }

    public q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f314617a = null;
        }
    }

    @NonNull
    static <T> String b(Collection<T> collection, String str) {
        if (collection != null && collection.size() != 0) {
            Object[] array = collection.toArray();
            StringBuilder sb5 = new StringBuilder(1024);
            for (int i3 = 0; i3 < array.length; i3++) {
                sb5.append(array[i3]);
                if (i3 < array.length - 1) {
                    sb5.append(str);
                }
            }
            return sb5.toString();
        }
        return "";
    }

    static boolean c() {
        if (f314615b == null) {
            f314615b = Boolean.valueOf(((com.tencent.mobileqq.webview.swift.injector.c) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).m());
        }
        return f314615b.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(boolean z16, boolean z17, boolean z18, int i3, boolean z19, String str, String str2, String str3, SslError sslError) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        HashMap hashMap = new HashMap();
        String str4 = "1";
        if (z16) {
            obj = "1";
        } else {
            obj = "0";
        }
        hashMap.put("inUse", obj);
        if (z17) {
            obj2 = "1";
        } else {
            obj2 = "0";
        }
        hashMap.put("isX5", obj2);
        if (z18) {
            obj3 = "1";
        } else {
            obj3 = "0";
        }
        hashMap.put(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, obj3);
        if (i3 > 0) {
            obj4 = "1";
        } else {
            obj4 = "0";
        }
        hashMap.put("hasIps", obj4);
        if (!z19) {
            str4 = "0";
        }
        hashMap.put("useDnsMapping", str4);
        hashMap.put("errHost", str);
        hashMap.put("pageHost", str2 + "");
        SwiftBrowserStatistics.U(str3, sslError, hashMap);
    }

    public static boolean f(WebView webView, SslErrorHandler sslErrorHandler, final SslError sslError) {
        boolean z16;
        String url = sslError.getUrl();
        final String url2 = webView.getUrl();
        final String f16 = com.tencent.mobileqq.webview.util.s.f(url);
        final String f17 = com.tencent.mobileqq.webview.util.s.f(url2);
        if (TextUtils.isEmpty(f16)) {
            return false;
        }
        final boolean contains = f314616c.contains(f16);
        final boolean k3 = com.tencent.mobileqq.webview.util.s.k(webView);
        final boolean c16 = c();
        final int size = ((com.tencent.mobileqq.webview.swift.injector.c) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).e(f16).size();
        if (!contains && k3 && c16 && size > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        final boolean z17 = z16;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.p
            @Override // java.lang.Runnable
            public final void run() {
                q.d(contains, k3, c16, size, z17, f16, f17, url2, sslError);
            }
        }, 128, null, true);
        QLog.d("WebLog_WebViewWrapper", 1, String.format("shouldInterceptSslError useDnsMapping: %b inUse: %b isX5: %b switch: %b ipCount: %d host:%s", Boolean.valueOf(z16), Boolean.valueOf(contains), Boolean.valueOf(k3), Boolean.valueOf(c16), Integer.valueOf(size), f16));
        if (z16) {
            f314616c.add(f16);
            QbSdk.setNewDnsHostList(b(f314616c, ";"));
            sslErrorHandler.cancel();
            webView.reload();
            return true;
        }
        return false;
    }

    public void e(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, webView, sslErrorHandler, sslError);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.isLogin() && ((com.tencent.mobileqq.webview.swift.injector.c) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).a()) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = z16;
        if (com.tencent.mobileqq.webview.swift.utils.d.f314744a && com.tencent.mobileqq.webview.swift.utils.d.f314745b.equals(sslError.getUrl())) {
            if (z17) {
                sslErrorHandler.proceed();
                return;
            } else {
                sslErrorHandler.cancel();
                return;
            }
        }
        QQCustomDialog qQCustomDialog = this.f314617a;
        if (qQCustomDialog == null) {
            QQCustomDialog a16 = com.tencent.mobileqq.webview.swift.utils.d.a(webView.getContext().getResources().getString(R.string.f181263da), webView.getContext().getResources().getString(R.string.f181253d_), sslErrorHandler, webView.getContext(), sslError.getUrl(), z17);
            this.f314617a = a16;
            com.tencent.mobileqq.webview.swift.utils.d.d(sslErrorHandler, a16);
        } else if (!qQCustomDialog.isShowing()) {
            sslErrorHandler.cancel();
        }
    }
}
