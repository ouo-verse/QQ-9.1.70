package com.tencent.qqnt.doutu.combo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes24.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f356080a;

    /* renamed from: b, reason: collision with root package name */
    public int f356081b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f356082c;

    /* renamed from: d, reason: collision with root package name */
    public Long f356083d;

    public a(String str, int i3, boolean z16, Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), l3);
            return;
        }
        this.f356080a = str;
        this.f356081b = i3;
        this.f356082c = z16;
        this.f356083d = l3;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer("ComboObject:");
        stringBuffer.append(this.f356080a);
        stringBuffer.append(',');
        stringBuffer.append(this.f356081b);
        stringBuffer.append(',');
        stringBuffer.append(this.f356082c);
        return stringBuffer.toString();
    }

    public a(String str, Long l3, int i3) {
        this(str, i3, true, l3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, l3, Integer.valueOf(i3));
    }
}
