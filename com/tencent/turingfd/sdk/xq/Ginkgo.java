package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Ginkgo {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final int f382780a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f382781b;

    /* renamed from: c, reason: collision with root package name */
    public final String f382782c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f382783d;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Ginkgo$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static class Cdo {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f382784a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f382785b;

        /* renamed from: c, reason: collision with root package name */
        public String f382786c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f382787d;

        public Cdo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f382784a = 200;
                this.f382787d = false;
            }
        }
    }

    public Ginkgo(Cdo cdo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cdo);
            return;
        }
        this.f382780a = cdo.f382784a;
        this.f382781b = cdo.f382785b;
        this.f382782c = cdo.f382786c;
        this.f382783d = cdo.f382787d;
    }
}
