package com.tencent.mobileqq.avifcodec.decoder;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f200177a;

    /* renamed from: b, reason: collision with root package name */
    public int f200178b;

    /* renamed from: c, reason: collision with root package name */
    public int f200179c;

    public b(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f200177a = i3;
        this.f200178b = i16;
        this.f200179c = i17;
    }
}
