package com.tencent.mobileqq.activity.contact.phonecontact;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f181303a;

    /* renamed from: b, reason: collision with root package name */
    public long f181304b;

    /* renamed from: c, reason: collision with root package name */
    public int f181305c;

    /* renamed from: d, reason: collision with root package name */
    public long f181306d;

    /* renamed from: e, reason: collision with root package name */
    public long f181307e;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f181303a = -1;
        }
    }

    public static b a(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f181303a = jSONObject.optInt("version", -1);
            bVar.f181304b = jSONObject.optLong("showDate", 0L);
            bVar.f181306d = jSONObject.optInt("leftShowNum", 0);
            bVar.f181305c = jSONObject.optInt("showCountEveryDay", 0);
            bVar.f181307e = jSONObject.optInt("leftLoginNum", 0);
        } catch (Exception unused) {
            bVar.f181303a = -1;
        }
        return bVar;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.f181303a);
            jSONObject.put("showDate", this.f181304b);
            jSONObject.put("leftShowNum", this.f181306d);
            jSONObject.put("showCountEveryDay", this.f181305c);
            jSONObject.put("leftLoginNum", this.f181307e);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "MobileUnityVersionInfo [version=" + this.f181303a + ", showDate=" + this.f181304b + ", leftShowNum=" + this.f181306d + ", leftLoginNum = " + this.f181307e + ", showCountEveryDay=" + this.f181305c + "]";
    }
}
