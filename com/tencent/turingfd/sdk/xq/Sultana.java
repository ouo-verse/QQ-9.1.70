package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Sultana implements Gemini {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    public static final byte[] f383112j;

    /* renamed from: a, reason: collision with root package name */
    public final String f383113a;

    /* renamed from: b, reason: collision with root package name */
    public final long f383114b;

    /* renamed from: c, reason: collision with root package name */
    public final int f383115c;

    /* renamed from: d, reason: collision with root package name */
    public final String f383116d;

    /* renamed from: e, reason: collision with root package name */
    public final String f383117e;

    /* renamed from: f, reason: collision with root package name */
    public final String f383118f;

    /* renamed from: g, reason: collision with root package name */
    public final String f383119g;

    /* renamed from: h, reason: collision with root package name */
    public int f383120h;

    /* renamed from: i, reason: collision with root package name */
    public int f383121i;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Sultana$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static final class Cdo {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f383122a;

        /* renamed from: b, reason: collision with root package name */
        public long f383123b;

        /* renamed from: c, reason: collision with root package name */
        public int f383124c;

        /* renamed from: d, reason: collision with root package name */
        public String f383125d;

        /* renamed from: e, reason: collision with root package name */
        public String f383126e;

        /* renamed from: f, reason: collision with root package name */
        public String f383127f;

        /* renamed from: g, reason: collision with root package name */
        public String f383128g;

        public Cdo(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.f383124c = i3;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12797);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f383112j = new byte[0];
        }
    }

    public Sultana(int i3, byte[] bArr, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), bArr, Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f383113a = "";
        this.f383114b = 0L;
        this.f383115c = i3;
        this.f383116d = "";
        this.f383117e = "";
        this.f383118f = "";
        this.f383119g = "";
        this.f383120h = i16;
        this.f383121i = i17;
    }

    public static Sultana a(int i3) {
        return new Sultana(i3, f383112j, 0, 0);
    }

    public Sultana(Cdo cdo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cdo);
            return;
        }
        this.f383120h = 0;
        this.f383121i = 0;
        this.f383113a = cdo.f383122a;
        this.f383114b = cdo.f383123b;
        this.f383115c = cdo.f383124c;
        this.f383116d = cdo.f383125d;
        this.f383117e = cdo.f383126e;
        this.f383118f = cdo.f383127f;
        this.f383119g = cdo.f383128g;
    }
}
