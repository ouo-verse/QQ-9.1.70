package com.tencent.avcore.camera.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final int f77425a;

    /* renamed from: b, reason: collision with root package name */
    public final int f77426b;

    /* renamed from: c, reason: collision with root package name */
    public final int f77427c;

    public a(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f77425a = i3;
        this.f77426b = i16;
        this.f77427c = i17;
    }
}
