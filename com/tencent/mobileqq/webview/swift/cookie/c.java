package com.tencent.mobileqq.webview.swift.cookie;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.webview.injector.r;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.util.n;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile int f314561a;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/Webview/Inject_DPCApi.yml", version = 1)
    static com.tencent.mobileqq.webprocess.a f314562b;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList f314563c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49305);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f314563c = arrayList;
        arrayList.add(r.class);
        f314561a = 0;
    }

    private static void a(String str) {
        QLog.w("LastCookieController", 1, "clearLastUin: " + str);
        t.j().l(c(3, str));
        t.j().l(c(2, str));
    }

    private static String b(int i3) {
        return c(i3, MobileQQ.getProcessSuffix(BaseApplication.processName, MobileQQ.PACKAGE_NAME));
    }

    private static String c(int i3, String str) {
        String str2 = "cookie_last_uin_" + str + "_" + i3;
        if (((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
            QLog.d("LastCookieController", 1, "getLastUinKey: " + str2);
        }
        return str2;
    }

    @QAutoInitMethod
    static void d() {
        f314562b = (com.tencent.mobileqq.webprocess.a) com.tencent.mobileqq.qroute.utils.b.a(f314563c);
        if (QLog.isColorLevel()) {
            n.a("LastCookieController", f314562b);
        }
    }

    public static boolean e(String str, int i3) {
        if ((f314561a & i3) != i3 && !t.j().c(b(i3), "").equals(str)) {
            return true;
        }
        return false;
    }

    private static void f(String str) {
        if (TextUtils.isEmpty(str)) {
            t.j().l(b(3));
            t.j().l(b(2));
        } else {
            t.j().e(b(3), str);
            t.j().e(b(2), str);
        }
        t.j().a();
    }

    public static void g() {
        SwiftBrowserCookieMonster.H();
        a("");
        a("tool");
    }

    public static void h(int i3) {
        String str;
        int i16;
        String str2;
        boolean z16;
        if (f314562b == null) {
            d();
        }
        com.tencent.mobileqq.webprocess.a aVar = f314562b;
        if (aVar != null) {
            str = aVar.d();
        } else {
            str = "";
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[WebInject]  auto inject:");
            if (f314562b != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("LastCookieController", 2, sb5.toString());
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                i16 = Integer.parseInt(str);
            } else {
                i16 = 15;
            }
            if ((i16 & i3) == i3) {
                if (1 == i3) {
                    CookieManager.getInstance().removeAllCookies(null);
                } else if (2 == i3) {
                    CookieManager.getInstance().removeSessionCookies(null);
                }
                Object[] objArr = new Object[1];
                if (1 == i3) {
                    str2 = "all";
                } else {
                    str2 = SessionDbHelper.SESSION_ID;
                }
                objArr[0] = str2;
                QLog.e("LastCookieController", 1, String.format("Remove %s cookies", objArr));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("LastCookieController", 2, "Not required remove cookies");
            }
        } catch (Exception e16) {
            QLog.e("LastCookieController", 1, "Remove all cookies failed", e16);
        }
    }

    public static synchronized void i(String str, int i3) {
        synchronized (c.class) {
            String c16 = t.j().c(b(i3), "");
            boolean e16 = e(str, i3);
            if (QLog.isColorLevel()) {
                QLog.i("LastCookieController", 2, "removeLastUinCookies needClear=" + e16 + ", flg=" + i3 + ", lUin=" + c16 + ", cUin=" + str);
            }
            if (e16) {
                long currentTimeMillis = System.currentTimeMillis();
                h(1);
                if (!TextUtils.isEmpty(str)) {
                    if ((i3 & 3) == 3) {
                        f(str);
                    } else {
                        t.j().e(b(i3), str).a();
                    }
                }
                f314561a |= i3;
                QLog.e("LastCookieController", 1, "User account changed, remove all cookies. sFlg=" + f314561a + ", cost=" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public static void j() {
        f314561a = 0;
    }
}
