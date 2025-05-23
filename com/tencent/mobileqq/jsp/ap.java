package com.tencent.mobileqq.jsp;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;
import com.tencent.qqmini.miniapp.task.ServiceCreateTask;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ap extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f238852d;

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f238853e;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f238854a;

        /* renamed from: b, reason: collision with root package name */
        String f238855b;

        /* renamed from: c, reason: collision with root package name */
        boolean f238856c;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public ap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void q(WebView webView, a aVar) {
        this.f238852d.put(aVar.f238854a, aVar);
        SwiftBrowserTBSHandler.s(aVar.f238854a, webView);
    }

    private void r() {
        if (this.f238852d == null) {
            this.f238852d = new ConcurrentHashMap<>();
        }
        if (this.f238853e == null) {
            this.f238853e = new ConcurrentHashMap<>();
        }
    }

    private int y(Context context, String str) {
        if (com.tencent.mobileqq.webview.swift.utils.i.p()) {
            if (!TextUtils.isEmpty(str) && com.tencent.mobileqq.webview.swift.utils.i.q(str) && !str.contains("asyncMode=3") && !str.contains("sonic=1")) {
                if (context != null && QbSdk.getTbsVersion(context) >= 43810) {
                    return 4;
                }
                return 3;
            }
            return 2;
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return ServiceCreateTask.SERVICE_TYPE_X5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        if (!ServiceCreateTask.SERVICE_TYPE_X5.equals(str2)) {
            return false;
        }
        if ("preload".equals(str3) && strArr != null && strArr.length > 0) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                a aVar = new a();
                aVar.f238854a = jSONObject.optString("url");
                aVar.f238855b = jSONObject.optString("callback");
                aVar.f238856c = jSONObject.optBoolean("doWhenPageFinish", false);
                r();
                if (aVar.f238856c) {
                    if (s()) {
                        x(this.mRuntime.a(), this.mRuntime.e(), aVar);
                    } else {
                        v(aVar);
                    }
                } else {
                    x(this.mRuntime.a(), this.mRuntime.e(), aVar);
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return true;
    }

    protected void p(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", i3);
                callJs(str, jSONObject.toString());
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    protected boolean s() {
        SwiftBrowserStatistics swiftBrowserStatistics;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        WebViewProvider f16 = this.mRuntime.f();
        if (f16 == null || (swiftBrowserStatistics = (SwiftBrowserStatistics) f16.getComponentProvider().a(-2)) == null || swiftBrowserStatistics.f314381y0) {
            return false;
        }
        return true;
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            w(true);
        }
    }

    public void u(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) str);
        } else if (i3 == 0) {
            if (this.f238852d.containsKey(str)) {
                p(0, this.f238852d.remove(str).f238855b);
            }
            w(s());
        }
    }

    protected void v(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            this.f238853e.put(aVar.f238854a, aVar);
            p(5, aVar.f238855b);
        }
    }

    protected void w(boolean z16) {
        ConcurrentHashMap<String, a> concurrentHashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        if (z16 && (concurrentHashMap = this.f238853e) != null && this.f238852d != null) {
            Iterator<a> it = concurrentHashMap.values().iterator();
            if (it.hasNext()) {
                a next = it.next();
                this.f238853e.remove(next.f238854a);
                this.f238852d.put(next.f238854a, next);
                q(this.mRuntime.e(), next);
                p(4, next.f238855b);
            }
        }
    }

    protected void x(Context context, WebView webView, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, webView, aVar);
            return;
        }
        int y16 = y(context, aVar.f238854a);
        if (y16 == 4) {
            q(webView, aVar);
        }
        p(y16, aVar.f238855b);
    }
}
