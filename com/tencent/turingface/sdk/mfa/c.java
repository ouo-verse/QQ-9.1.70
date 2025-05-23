package com.tencent.turingface.sdk.mfa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingcam.NbXuL;
import com.tencent.turingcam.UMDtK;

/* compiled from: P */
/* loaded from: classes27.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final int f382496a;

    /* renamed from: b, reason: collision with root package name */
    public final int f382497b;

    /* renamed from: c, reason: collision with root package name */
    public final a f382498c;

    /* renamed from: d, reason: collision with root package name */
    public final UMDtK f382499d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f382500e;

    /* renamed from: f, reason: collision with root package name */
    public final UMDtK f382501f;

    /* renamed from: g, reason: collision with root package name */
    public final NbXuL f382502g;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public a f382503a;

        /* renamed from: b, reason: collision with root package name */
        public final int f382504b;

        /* renamed from: c, reason: collision with root package name */
        public final int f382505c;

        /* renamed from: d, reason: collision with root package name */
        public UMDtK f382506d;

        /* renamed from: e, reason: collision with root package name */
        public byte[] f382507e;

        /* renamed from: f, reason: collision with root package name */
        public UMDtK f382508f;

        /* renamed from: g, reason: collision with root package name */
        public NbXuL f382509g;

        public b(int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            this.f382506d = null;
            this.f382507e = null;
            this.f382508f = null;
            this.f382509g = null;
            this.f382504b = i3;
            this.f382505c = i16;
        }
    }

    public c(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        this.f382496a = bVar.f382504b;
        this.f382497b = bVar.f382505c;
        this.f382498c = bVar.f382503a;
        this.f382499d = bVar.f382506d;
        this.f382500e = bVar.f382507e;
        this.f382501f = bVar.f382508f;
        this.f382502g = bVar.f382509g;
    }
}
