package com.tencent.avcore.camera.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f77428a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f77429b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f77430c;

    /* renamed from: d, reason: collision with root package name */
    public int f77431d;

    /* renamed from: e, reason: collision with root package name */
    public int f77432e;

    /* renamed from: f, reason: collision with root package name */
    public int f77433f;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
