package com.tencent.mobileqq.qqlive.widget;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi;
import com.tencent.mobileqq.qqlive.api.verified.IQQLiveDataStore;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static a f273493b;

    /* renamed from: a, reason: collision with root package name */
    private IAegisLogApi f273494a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38239);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f273493b = new a();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f273494a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        }
    }

    public static List<String> a(String str, LoginInfo loginInfo, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(c(str, loginInfo, str2));
        arrayList.addAll(c(str, loginInfo, "https://ilive.qq.com/"));
        arrayList.addAll(c(str, loginInfo, "https://qlive.qq.com/"));
        arrayList.addAll(c(str, loginInfo, "*.qlive.qq.com"));
        return arrayList;
    }

    public static a b() {
        return f273493b;
    }

    public static List<String> c(String str, LoginInfo loginInfo, String str2) {
        ArrayList arrayList = new ArrayList();
        String str3 = ";Domain=" + d(str2, 2).toLowerCase() + ";Path=/;";
        if (!TextUtils.isEmpty(loginInfo.f271214a2)) {
            Locale locale = Locale.ENGLISH;
            arrayList.add(String.format(locale, "%s=%s%s", "qq_live_app_id", str, str3));
            arrayList.add(String.format(locale, "%s=%s%s", "__client_type", Integer.valueOf(loginInfo.clientType), str3));
            arrayList.add(String.format(locale, "%s=%s%s", "ilive_uin", Long.valueOf(loginInfo.uid), str3));
            arrayList.add(String.format(locale, "%s=%s%s", "ilive_tinyid", Long.valueOf(loginInfo.tinyid), str3));
            arrayList.add(String.format(locale, "%s=%s%s", "ilive_a2", loginInfo.f271214a2, str3));
            arrayList.add(String.format(locale, "%s=%d%s", "ilive_uid_type", Integer.valueOf(loginInfo.loginType), str3));
            arrayList.add(String.format(locale, "%s=%s%s", "original_key", loginInfo.accessToken, str3));
            arrayList.add(String.format(locale, "%s=%s%s", "original_id", loginInfo.openId, str3));
            arrayList.add(String.format(locale, "%s=%d%s", "original_id_type", 1, str3));
            arrayList.add(String.format(locale, "%s=%d%s", "original_key_type", 37, str3));
        }
        return arrayList;
    }

    public static String d(String str, int i3) {
        String host;
        if (TextUtils.isEmpty(str) || i3 <= 0) {
            return "";
        }
        if (str.startsWith("*.")) {
            return str.substring(1);
        }
        try {
            Uri parse = Uri.parse(str);
            if (!parse.isHierarchical() || (host = parse.getHost()) == null) {
                return "";
            }
            String[] split = host.split("\\.");
            if (split.length <= 0) {
                return "";
            }
            int max = Math.max(0, split.length - (i3 + 1));
            StringBuilder sb5 = new StringBuilder(256);
            sb5.append(split[max]);
            for (int i16 = max + 1; i16 < split.length; i16++) {
                sb5.append('.');
                sb5.append(split[i16]);
            }
            return sb5.toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    private void e(Context context, String str, String str2) {
        try {
            CookieSyncManager.createInstance(context);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (TextUtils.isEmpty(str)) {
                str = ((IQQLiveDataStore) QRoute.api(IQQLiveDataStore.class)).getAppId();
            }
            LoginInfo loginInfo = new LoginInfo(((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).getLoginInfo(str, waitAppRuntime.getCurrentUin()));
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveCookieManager", 2, "[plant] loginInfo=" + loginInfo);
            }
            Iterator<String> it = c(str, loginInfo, str2).iterator();
            while (it.hasNext()) {
                cookieManager.setCookie(str2, it.next());
            }
            cookieManager.removeExpiredCookie();
            CookieSyncManager.getInstance().sync();
        } catch (Exception e16) {
            this.f273494a.e("QQLiveCookieManager", 1, "plant throw exception:" + e16.getMessage());
        }
    }

    public void f(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) str);
            return;
        }
        e(context, str, "https://ilive.qq.com/");
        e(context, str, "https://qlive.qq.com/");
        e(context, str, "*.qlive.qq.com");
    }

    public void g(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, str, str2);
        } else {
            e(context, str, str2);
            f(context, str);
        }
    }
}
