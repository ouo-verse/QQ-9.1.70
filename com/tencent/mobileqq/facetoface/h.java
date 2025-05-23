package com.tencent.mobileqq.facetoface;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public float f205763a;

    /* renamed from: b, reason: collision with root package name */
    public float f205764b;

    /* renamed from: c, reason: collision with root package name */
    public float f205765c;

    /* renamed from: d, reason: collision with root package name */
    public float f205766d;

    /* renamed from: e, reason: collision with root package name */
    public float f205767e;

    /* renamed from: f, reason: collision with root package name */
    public int f205768f;

    /* renamed from: g, reason: collision with root package name */
    public float f205769g;

    public h(int i3, int i16, float f16, float f17, int i17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i17), Float.valueOf(f18));
            return;
        }
        this.f205763a = i3;
        this.f205764b = i16;
        this.f205765c = f16;
        this.f205766d = f17;
        this.f205768f = i17;
        this.f205769g = f18;
        this.f205767e = 0.0f;
    }
}
