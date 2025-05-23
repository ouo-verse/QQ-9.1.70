package com.tencent.mobileqq.miniapp.util;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.miniapp.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.miniapp.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C8063a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f246823a;

        /* renamed from: b, reason: collision with root package name */
        String f246824b;

        /* renamed from: c, reason: collision with root package name */
        String f246825c;

        /* renamed from: d, reason: collision with root package name */
        JSONObject f246826d;

        /* renamed from: e, reason: collision with root package name */
        int f246827e;

        public C8063a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public static boolean a(Activity activity, C8063a c8063a, Bundle bundle) {
        int i3;
        if (c8063a == null || (i3 = c8063a.f246823a) == 4 || i3 != 3) {
            return false;
        }
        g.t(activity, c8063a.f246824b, i3, null);
        return true;
    }

    public static boolean b(Activity activity, String str, Bundle bundle) {
        return a(activity, c(str), bundle);
    }

    public static C8063a c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        if (!parse.isHierarchical()) {
            return null;
        }
        String queryParameter = parse.getQueryParameter("_appinfo");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                byte[] decode = Base64.decode(queryParameter, 10);
                if (decode == null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("miniAppJump", 2, "appinfo decode error 2");
                    }
                    return null;
                }
                JSONObject jSONObject = new JSONObject(new String(decode, "UTF-8"));
                C8063a c8063a = new C8063a();
                c8063a.f246823a = jSONObject.getInt("type");
                c8063a.f246824b = jSONObject.getString("appid");
                c8063a.f246825c = jSONObject.optString("pageName");
                c8063a.f246827e = jSONObject.optInt("from");
                c8063a.f246826d = jSONObject.optJSONObject("param");
                return c8063a;
            } catch (Exception e16) {
                QLog.e("miniAppJump", 1, "parse miniapp jump url error", e16);
            }
        }
        return null;
    }
}
