package com.tencent.trackrecordlib.b;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private int f380944b;

    public c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.f380944b = i3;
        }
    }

    @Override // com.tencent.trackrecordlib.b.a
    public JSONObject a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            this.f380941a.put("duration", this.f380944b);
            return this.f380941a;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }
}
