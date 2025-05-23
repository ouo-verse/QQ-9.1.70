package com.tencent.trackrecordlib.b;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private String f380942b;

    /* renamed from: c, reason: collision with root package name */
    private String f380943c;

    public b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
        } else {
            this.f380942b = str;
            this.f380943c = str2;
        }
    }

    @Override // com.tencent.trackrecordlib.b.a
    public JSONObject a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            this.f380941a.put("p0", this.f380942b);
            this.f380941a.put("p1", this.f380943c);
            return this.f380941a;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }
}
