package com.tencent.mobileqq.videocodec.mediacodec.encoder;

import android.opengl.EGLContext;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.g;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public EGLContext f312556a;

    /* renamed from: b, reason: collision with root package name */
    public int f312557b;

    /* renamed from: c, reason: collision with root package name */
    public String f312558c;

    /* renamed from: d, reason: collision with root package name */
    public int f312559d;

    /* renamed from: e, reason: collision with root package name */
    public int f312560e;

    /* renamed from: f, reason: collision with root package name */
    public int f312561f;

    /* renamed from: g, reason: collision with root package name */
    public int f312562g;

    /* renamed from: h, reason: collision with root package name */
    public int f312563h;

    /* renamed from: i, reason: collision with root package name */
    public int f312564i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f312565j;

    /* renamed from: k, reason: collision with root package name */
    public String f312566k;

    /* renamed from: l, reason: collision with root package name */
    public String f312567l;

    /* renamed from: m, reason: collision with root package name */
    public int f312568m;

    /* renamed from: n, reason: collision with root package name */
    public int f312569n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f312570o;

    /* renamed from: p, reason: collision with root package name */
    public String f312571p;

    /* renamed from: q, reason: collision with root package name */
    public int f312572q;

    /* renamed from: r, reason: collision with root package name */
    public int f312573r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f312574s;

    /* renamed from: t, reason: collision with root package name */
    public g f312575t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f312576u;

    public c(String str, int i3, int i16, int i17, int i18, boolean z16, int i19) {
        this(str, i3, i16, i17, i18, 30, 0, z16, i19, null, null, null, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), Integer.valueOf(i19));
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f312557b;
    }

    public EGLContext b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (EGLContext) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f312556a;
    }

    public void c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f312557b = i3;
        }
    }

    public void d(EGLContext eGLContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) eGLContext);
        } else {
            this.f312556a = eGLContext;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "EncodeConfig{sharedContext=" + this.f312556a + ", outputFilePath='" + this.f312558c + "', width='" + this.f312559d + "', height='" + this.f312560e + "', bitRate='" + this.f312561f + "', frameRate='" + this.f312562g + "', iFrameInterval='" + this.f312563h + "', filterType=" + this.f312564i + ", needGenerateThumb=" + this.f312565j + ", watermarkPath='" + this.f312566k + "', mosaicPath='" + this.f312567l + "', orientation=" + this.f312568m + ", adjustRotation=" + this.f312569n + '}';
    }

    public c(String str, int i3, int i16, int i17, int i18, int i19, int i26, boolean z16, int i27, String str2, String str3, String str4, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Boolean.valueOf(z16), Integer.valueOf(i27), str2, str3, str4, Boolean.valueOf(z17));
            return;
        }
        this.f312569n = 0;
        this.f312570o = false;
        this.f312572q = -1;
        this.f312573r = -1;
        this.f312576u = true;
        this.f312558c = str;
        this.f312559d = i3;
        this.f312560e = i16;
        this.f312561f = i17;
        this.f312563h = i18;
        this.f312564i = i26;
        this.f312565j = z16;
        this.f312566k = str2;
        this.f312567l = str3;
        this.f312562g = i19;
        this.f312568m = i27;
        this.f312571p = str4;
    }
}
