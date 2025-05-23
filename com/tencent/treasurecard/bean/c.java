package com.tencent.treasurecard.bean;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f381159a;

    /* renamed from: b, reason: collision with root package name */
    public String f381160b;

    /* renamed from: c, reason: collision with root package name */
    public String f381161c;

    /* renamed from: d, reason: collision with root package name */
    public String f381162d;

    /* renamed from: e, reason: collision with root package name */
    public String f381163e;

    /* renamed from: f, reason: collision with root package name */
    public String f381164f;

    /* renamed from: g, reason: collision with root package name */
    public List<Map<String, Object>> f381165g;

    /* renamed from: h, reason: collision with root package name */
    public String f381166h;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f381163e = String.valueOf(1003);
            this.f381166h = "";
        }
    }

    public c a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f381159a = jSONObject.optString("msgId", "");
            this.f381160b = jSONObject.optString("systemTime", "");
            this.f381161c = jSONObject.optString("message", "");
            this.f381162d = jSONObject.optString("expandParams", "");
            this.f381163e = jSONObject.optString("resultcode", "");
            this.f381164f = jSONObject.optString("desc", "");
            this.f381166h = jSONObject.optString("pcId", "");
            this.f381165g = com.tencent.treasurecard.util.c.a(jSONObject.optString("orderStatus", ""));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return this;
    }
}
