package com.tencent.mobileqq.fts.v2.tokenizer;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    String f211790a;

    /* renamed from: b, reason: collision with root package name */
    int f211791b;

    /* renamed from: c, reason: collision with root package name */
    int f211792c;

    /* renamed from: d, reason: collision with root package name */
    String f211793d;

    /* renamed from: e, reason: collision with root package name */
    private int f211794e;

    public a(String str, int i3, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
            return;
        }
        this.f211794e = 1;
        this.f211790a = str;
        this.f211791b = i3;
        this.f211792c = i16;
        this.f211793d = str2;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f211792c;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f211791b;
    }

    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f211790a;
    }

    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f211793d;
    }

    public final String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(" + this.f211790a + "," + this.f211791b + "," + this.f211792c);
        if (!this.f211793d.equals("word")) {
            stringBuffer.append(",type=" + this.f211793d);
        }
        if (this.f211794e != 1) {
            stringBuffer.append(",posIncr=" + this.f211794e);
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }
}
