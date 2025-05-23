package com.tencent.mobileqq.splashad.config;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f288764a;

    /* renamed from: b, reason: collision with root package name */
    public String f288765b;

    /* renamed from: c, reason: collision with root package name */
    public String f288766c;

    /* renamed from: d, reason: collision with root package name */
    public String f288767d;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            b bVar = new b();
            JSONObject jSONObject = new JSONObject(str);
            bVar.f288764a = jSONObject.optString("splashUrl");
            bVar.f288765b = jSONObject.optString("splashBigUrl");
            bVar.f288766c = jSONObject.optString("splashLogoUrl");
            bVar.f288767d = jSONObject.optString("splashLogoBigUrl");
            return bVar;
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("ThemeSplashDataItem", 2, "parse fail: ", e16);
            }
            return null;
        }
    }
}
