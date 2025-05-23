package com.tencent.qimei.x;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f343420a;

    /* renamed from: b, reason: collision with root package name */
    public int f343421b;

    /* renamed from: c, reason: collision with root package name */
    public String f343422c;

    /* renamed from: d, reason: collision with root package name */
    public String f343423d;

    /* renamed from: e, reason: collision with root package name */
    public String f343424e;

    /* renamed from: f, reason: collision with root package name */
    public int f343425f;

    /* renamed from: g, reason: collision with root package name */
    public String f343426g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f343427h;

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f343421b = -1;
        this.f343420a = -1;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i3 = jSONObject.getInt("error");
            if (i3 == 0) {
                String string = jSONObject.getString("body");
                this.f343423d = string;
            } else {
                this.f343422c = jSONObject.getString("type");
                a(jSONObject.getString("msg"));
            }
            this.f343420a = 0;
            this.f343421b = i3;
        } catch (JSONException unused) {
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? TextUtils.isEmpty(this.f343423d) ? "" : this.f343423d : (String) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (c() || TextUtils.isEmpty(this.f343422c)) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(this.f343422c, String.valueOf(this.f343421b));
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.f343420a == 0 && this.f343421b == 0) {
            return true;
        }
        return false;
    }

    public final void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f343427h = false;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f343424e = jSONObject.getString("ic");
            this.f343425f = jSONObject.getInt("rc");
            this.f343426g = jSONObject.getString("em");
            this.f343427h = true;
        } catch (JSONException unused) {
            this.f343427h = false;
        }
    }
}
