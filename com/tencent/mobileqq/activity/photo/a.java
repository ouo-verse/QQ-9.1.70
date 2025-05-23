package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;
    public String C;
    public int D;
    public boolean E;

    /* renamed from: d, reason: collision with root package name */
    public boolean f184134d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f184135e;

    /* renamed from: f, reason: collision with root package name */
    public String f184136f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f184137h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f184138i;

    /* renamed from: m, reason: collision with root package name */
    public String f184139m;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.E = true;
        }
    }
}
