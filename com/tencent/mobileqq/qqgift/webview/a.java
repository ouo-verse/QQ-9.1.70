package com.tencent.mobileqq.qqgift.webview;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static a f265050a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqgift.webview.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    class C8341a implements sd2.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap f265051a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppRuntime f265052b;

        C8341a(HashMap hashMap, AppRuntime appRuntime) {
            this.f265051a = hashMap;
            this.f265052b = appRuntime;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, hashMap, appRuntime);
            }
        }

        @Override // sd2.a
        public void onFail(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                QLog.e("QQGiftCookieManager", 1, "asyncTicket failed:", str);
            }
        }

        @Override // sd2.a
        public void onSuccess(@NonNull Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) map);
                return;
            }
            this.f265051a.putAll(map);
            String str = map.get(QQLiveCookieConstants.QQ_LIVE_DOMAIN);
            if (QLog.isColorLevel()) {
                QLog.e("QQGiftCookieManager", 1, "psKey:", str);
            }
            a.a().c(this.f265052b.getApplicationContext(), str);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30811);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f265050a = new a();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a a() {
        return f265050a;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQGiftCookieManager", 2, "getPsKey");
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        IPskeyManager iPskeyManager = (IPskeyManager) waitAppRuntime.getRuntimeService(IPskeyManager.class, "all");
        HashMap hashMap = new HashMap();
        iPskeyManager.getPskey(new String[]{QQLiveCookieConstants.QQ_LIVE_DOMAIN}, new C8341a(hashMap, waitAppRuntime));
        String str = (String) hashMap.get(QQLiveCookieConstants.QQ_LIVE_DOMAIN);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        QLog.d("QQGiftCookieManager", 1, "getPsKey pskey:" + str);
        return str;
    }

    public void c(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) str);
            return;
        }
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setCookie(QQLiveCookieConstants.QQ_LIVE_DOMAIN, String.format(Locale.ENGLISH, "%s=%s%s", "p_skey", str, ";Domain=qlive.qq.com;Path=/;Max-Age=21600;"));
        cookieManager.removeExpiredCookie();
        CookieSyncManager.getInstance().sync();
    }
}
