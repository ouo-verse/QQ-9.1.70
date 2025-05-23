package com.tencent.mobileqq.olympic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f255100a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f255101b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f255102c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f255103d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f255104e;

    /* renamed from: f, reason: collision with root package name */
    public int f255105f;

    /* renamed from: g, reason: collision with root package name */
    public int f255106g;

    /* renamed from: h, reason: collision with root package name */
    public int f255107h;

    /* renamed from: i, reason: collision with root package name */
    public int f255108i;

    /* renamed from: j, reason: collision with root package name */
    public int f255109j;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f255105f = 0;
        this.f255106g = 3;
        this.f255107h = 1000;
        this.f255108i = 1;
        this.f255109j = 1;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(256);
        sb5.append("allUseInSimple_2=");
        sb5.append(this.f255102c);
        sb5.append(", bgUseInSimple_2=");
        sb5.append(this.f255103d);
        sb5.append(", cfgUse_argb8888=");
        sb5.append(this.f255104e);
        sb5.append(", networkControl=");
        sb5.append(this.f255105f);
        sb5.append(", dailyRetryTimes=");
        sb5.append(this.f255106g);
        sb5.append(", countRetryTimes=");
        sb5.append(this.f255107h);
        sb5.append(", entranceControl=");
        sb5.append(this.f255108i);
        sb5.append(", autoPreDownload=");
        sb5.append(this.f255109j);
        return sb5.toString();
    }
}
