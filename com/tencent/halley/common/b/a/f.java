package com.tencent.halley.common.b.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f113322a;

    /* renamed from: b, reason: collision with root package name */
    public String f113323b;

    /* renamed from: c, reason: collision with root package name */
    public int f113324c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f113325d;

    /* renamed from: e, reason: collision with root package name */
    Map<String, String> f113326e;

    public f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f113322a = 0;
        this.f113323b = str;
        this.f113324c = 0;
    }

    public final void a(Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
            return;
        }
        this.f113326e = new HashMap();
        if (map.size() > 0) {
            for (String str : map.keySet()) {
                this.f113326e.put(str.toLowerCase(), map.get(str));
            }
        }
    }

    public final String toString() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder("errorCode:");
        sb5.append(this.f113322a);
        sb5.append(",errorInfo:");
        sb5.append(this.f113323b);
        sb5.append(",httpStatus:");
        sb5.append(this.f113324c);
        sb5.append(",headers:");
        sb5.append(this.f113326e);
        sb5.append(",body:");
        byte[] bArr = this.f113325d;
        if (bArr != null) {
            obj = Integer.valueOf(bArr.length);
        } else {
            obj = "null";
        }
        sb5.append(obj);
        return sb5.toString();
    }
}
