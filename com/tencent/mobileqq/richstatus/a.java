package com.tencent.mobileqq.richstatus;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f282294a;

    /* renamed from: b, reason: collision with root package name */
    public int f282295b;

    /* renamed from: c, reason: collision with root package name */
    public String f282296c;

    /* renamed from: d, reason: collision with root package name */
    public String f282297d;

    /* renamed from: e, reason: collision with root package name */
    public String f282298e;

    /* renamed from: f, reason: collision with root package name */
    public String f282299f;

    /* renamed from: g, reason: collision with root package name */
    public int f282300g;

    /* renamed from: h, reason: collision with root package name */
    public String f282301h;

    /* renamed from: i, reason: collision with root package name */
    public String f282302i;

    /* renamed from: j, reason: collision with root package name */
    public String f282303j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList<a> f282304k;

    /* renamed from: l, reason: collision with root package name */
    public String f282305l;

    /* renamed from: m, reason: collision with root package name */
    public String f282306m;

    /* renamed from: n, reason: collision with root package name */
    public String f282307n;

    /* renamed from: o, reason: collision with root package name */
    public String f282308o;

    public a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.f282294a = true;
        this.f282300g = 1;
        this.f282295b = i3;
    }
}
