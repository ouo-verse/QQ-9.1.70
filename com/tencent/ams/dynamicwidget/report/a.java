package com.tencent.ams.dynamicwidget.report;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f70211a;

    /* renamed from: b, reason: collision with root package name */
    public String f70212b;

    /* renamed from: c, reason: collision with root package name */
    public int f70213c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f70214d;

    public a(String str) {
        this(str, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("url")) {
                return null;
            }
            a aVar = new a(jSONObject.getString("url"));
            if (jSONObject.has("body")) {
                aVar.f70212b = jSONObject.getString("body");
            }
            if (jSONObject.has("gzip")) {
                boolean z16 = true;
                if (jSONObject.getInt("gzip") != 1) {
                    z16 = false;
                }
                aVar.f70214d = z16;
            }
            return aVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f70211a)) {
                jSONObject.put("url", this.f70211a);
            }
            if (!TextUtils.isEmpty(this.f70212b)) {
                jSONObject.put("body", this.f70212b);
            }
            if (this.f70214d) {
                jSONObject.put("gzip", 1);
            } else {
                jSONObject.put("gzip", 0);
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public a(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        } else {
            this.f70211a = str;
            this.f70213c = i3;
        }
    }
}
