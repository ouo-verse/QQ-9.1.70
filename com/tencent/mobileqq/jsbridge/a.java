package com.tencent.mobileqq.jsbridge;

import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProSourceInfoBid;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
@Deprecated
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    HashMap<String, b> f238545a;

    /* renamed from: b, reason: collision with root package name */
    AuthorizeConfig f238546b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.jsbridge.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C7950a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<WebView> f238547a;

        /* renamed from: b, reason: collision with root package name */
        long f238548b;

        /* renamed from: c, reason: collision with root package name */
        String f238549c;

        public C7950a(WebView webView, long j3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, webView, Long.valueOf(j3), str);
                return;
            }
            this.f238547a = new WeakReference<>(webView);
            this.f238548b = j3;
            this.f238549c = str;
        }

        public void a(Object obj) {
            String obj2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, obj);
                return;
            }
            WebView webView = this.f238547a.get();
            if (webView == null) {
                return;
            }
            if (obj == null) {
                webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f238548b + ",{'r':0});");
                return;
            }
            if (!(obj instanceof Number) && !(obj instanceof Boolean) && !(obj instanceof JSONObject)) {
                obj2 = "'" + obj.toString().replace("\\", "\\\\").replace("'", "\\'") + "'";
            } else {
                obj2 = obj.toString();
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f238548b + ",{'r':0,'result':" + obj2 + "});");
        }

        public void b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
                return;
            }
            WebView webView = this.f238547a.get();
            if (webView != null) {
                webView.loadUrl(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + str);
            }
        }

        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d(GGProSourceInfoBid.JB, 4, "onNoMatchMethod");
            }
            WebView webView = this.f238547a.get();
            if (webView == null) {
                return;
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f238548b + ",{'r':1,'result':'no such method'})");
        }

        public void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d(GGProSourceInfoBid.JB, 4, "onPermissionDenied");
            }
            WebView webView = this.f238547a.get();
            if (webView != null) {
                webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f238548b + ",{'r':2,'result':'Permission denied'})");
            }
        }
    }

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x0078, code lost:
        
            r11.a(null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void call(String str, List<String> list, C7950a c7950a) {
            Method method;
            Object invoke;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, list, c7950a);
                return;
            }
            Method[] declaredMethods = getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    method = declaredMethods[i3];
                    if (method.getName().equals(str) && method.getParameterTypes().length == list.size()) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    method = null;
                    break;
                }
            }
            if (method != null) {
                try {
                    if (list.size() == 0) {
                        invoke = method.invoke(this, new Object[0]);
                    } else {
                        invoke = method.invoke(this, list.toArray());
                    }
                    Class<?> returnType = method.getReturnType();
                    if (returnType != Void.TYPE && returnType != Void.class) {
                        if (c7950a != null) {
                            if (customCallback()) {
                                c7950a.b(invoke.toString());
                                return;
                            } else {
                                c7950a.a(invoke);
                                return;
                            }
                        }
                        return;
                    }
                    return;
                } catch (IllegalAccessException unused) {
                    if (c7950a != null) {
                        c7950a.c();
                    }
                } catch (IllegalArgumentException unused2) {
                    if (c7950a != null) {
                        c7950a.c();
                    }
                } catch (InvocationTargetException unused3) {
                    if (c7950a != null) {
                        c7950a.c();
                    }
                } catch (Exception unused4) {
                    if (c7950a != null) {
                        c7950a.c();
                    }
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d(GGProSourceInfoBid.JB, 4, "cannot found match method,maybe your method using args type is NO String? request method:class:" + getClass().getSimpleName() + str + " args:" + list);
            }
            if (c7950a != null) {
                c7950a.c();
            }
        }

        public boolean customCallback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f238545a = new HashMap<>();
        }
    }

    public boolean a(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) webView, (Object) str)).booleanValue();
        }
        if (str == null || !str.startsWith("jsbridge://")) {
            return false;
        }
        List asList = Arrays.asList((str + "/#").split("/"));
        if (asList.size() < 6) {
            return false;
        }
        String str2 = (String) asList.get(2);
        String str3 = (String) asList.get(3);
        try {
            long parseLong = Long.parseLong((String) asList.get(4));
            List<String> subList = asList.subList(5, asList.size() - 1);
            if (QLog.isDevelopLevel()) {
                QLog.d(GGProSourceInfoBid.JB, 4, "calling " + str2 + "." + str3);
            }
            C7950a c7950a = new C7950a(webView, parseLong, str);
            String url = webView.getUrl();
            if (this.f238546b == null) {
                this.f238546b = AuthorizeConfig.y();
            }
            if (this.f238546b.F(url, str2 + "." + str3)) {
                b(str2, str3, subList, c7950a);
            } else {
                QLog.e("JsBridge", 1, "JS API no auth url = " + k.f(url, new String[0]) + " objectName = " + str2 + " methodName = " + str3);
                c7950a.d();
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void b(String str, String str2, List<String> list, C7950a c7950a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, list, c7950a);
            return;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            try {
                list.set(i3, URLDecoder.decode(list.get(i3), "UTF-8"));
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
                if (QLog.isDevelopLevel()) {
                    QLog.i(GGProSourceInfoBid.JB, 4, "decode failed: " + list.get(i3));
                }
            } catch (Exception e17) {
                e17.printStackTrace();
                if (QLog.isDevelopLevel()) {
                    QLog.i(GGProSourceInfoBid.JB, 4, "decode failed, exception: " + list.get(i3));
                }
            }
        }
        b bVar = this.f238545a.get(str);
        if (bVar != null) {
            bVar.call(str2, list, c7950a);
        } else if (c7950a != null) {
            c7950a.c();
        }
    }

    public void c(b bVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, (Object) str);
        } else {
            this.f238545a.put(str, bVar);
        }
    }

    public void d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else if (str == null) {
            this.f238545a.clear();
        } else {
            this.f238545a.remove(str);
        }
    }
}
