package com.tencent.mobileqq.leba.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public long f240740h;

    /* renamed from: i, reason: collision with root package name */
    public String f240741i;

    /* renamed from: j, reason: collision with root package name */
    public String f240742j;

    /* renamed from: k, reason: collision with root package name */
    public String f240743k;

    /* renamed from: l, reason: collision with root package name */
    public String f240744l;

    /* renamed from: m, reason: collision with root package name */
    public String f240745m;

    /* renamed from: n, reason: collision with root package name */
    public String f240746n;

    /* renamed from: o, reason: collision with root package name */
    public String f240747o;

    /* renamed from: p, reason: collision with root package name */
    public String f240748p;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f240740h = 0L;
        this.f240741i = "";
        this.f240742j = "";
        this.f240743k = "";
        this.f240744l = "";
        this.f240745m = "";
        this.f240746n = "";
        this.f240747o = "";
        this.f240748p = "";
    }

    @Override // com.tencent.mobileqq.leba.report.b
    public String a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        StringBuilder sb5 = new StringBuilder(64);
        sb5.append(this.f240749a);
        sb5.append("|");
        sb5.append(this.f240750b);
        sb5.append("|");
        sb5.append(this.f240751c);
        sb5.append("|");
        sb5.append(this.f240752d);
        sb5.append("|");
        sb5.append(this.f240753e);
        sb5.append("|");
        sb5.append(this.f240754f);
        sb5.append("|");
        if (i3 == 0) {
            sb5.append("${count_unknown}");
            sb5.append("|");
        } else {
            sb5.append(this.f240755g);
            sb5.append("|");
        }
        sb5.append(this.f240740h);
        sb5.append("|");
        sb5.append(this.f240741i);
        sb5.append("|");
        sb5.append(this.f240742j);
        sb5.append("|");
        sb5.append(this.f240743k);
        sb5.append("|");
        sb5.append(this.f240744l);
        sb5.append("|");
        sb5.append(this.f240745m);
        sb5.append("|");
        sb5.append(this.f240746n);
        sb5.append("|");
        sb5.append(this.f240747o);
        sb5.append("|");
        sb5.append(this.f240748p);
        sb5.append("|");
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.leba.report.b
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(this.f240749a);
        stringBuffer.append("|");
        stringBuffer.append(this.f240750b);
        stringBuffer.append("|");
        stringBuffer.append(this.f240751c);
        stringBuffer.append("|");
        stringBuffer.append(this.f240752d);
        stringBuffer.append("|");
        stringBuffer.append(this.f240753e);
        stringBuffer.append("|");
        stringBuffer.append(this.f240754f);
        stringBuffer.append("|");
        stringBuffer.append(this.f240755g);
        stringBuffer.append("|");
        stringBuffer.append(this.f240740h);
        stringBuffer.append("|");
        stringBuffer.append(this.f240741i);
        stringBuffer.append("|");
        stringBuffer.append(this.f240742j);
        stringBuffer.append("|");
        stringBuffer.append(this.f240743k);
        stringBuffer.append("|");
        stringBuffer.append(this.f240744l);
        stringBuffer.append("|");
        stringBuffer.append(this.f240745m);
        stringBuffer.append("|");
        stringBuffer.append(this.f240746n);
        stringBuffer.append("|");
        stringBuffer.append(this.f240747o);
        stringBuffer.append("|");
        stringBuffer.append(this.f240748p);
        stringBuffer.append("|");
        return stringBuffer.toString();
    }
}
