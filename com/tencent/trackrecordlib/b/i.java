package com.tencent.trackrecordlib.b;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class i extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private String f380955b;

    /* renamed from: c, reason: collision with root package name */
    private String f380956c;

    /* renamed from: d, reason: collision with root package name */
    private String f380957d;

    /* renamed from: e, reason: collision with root package name */
    private String f380958e;

    public i(String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4);
            return;
        }
        this.f380955b = str;
        this.f380956c = str2;
        this.f380957d = str3;
        this.f380958e = str4;
    }

    @Override // com.tencent.trackrecordlib.b.a
    public JSONObject a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            this.f380941a.put("p0", this.f380955b);
            this.f380941a.put("p1", this.f380956c);
            this.f380941a.put("p2", this.f380957d);
            this.f380941a.put("p3", this.f380958e);
            return this.f380941a;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }
}
