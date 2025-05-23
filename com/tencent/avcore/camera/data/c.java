package com.tencent.avcore.camera.data;

import android.graphics.SurfaceTexture;
import android.os.SystemClock;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {
    static IPatchRedirector $redirector_;
    static long A;

    /* renamed from: t, reason: collision with root package name */
    private static final Object f77434t;

    /* renamed from: u, reason: collision with root package name */
    private static c f77435u;

    /* renamed from: v, reason: collision with root package name */
    private static int f77436v;

    /* renamed from: w, reason: collision with root package name */
    private static String f77437w;

    /* renamed from: x, reason: collision with root package name */
    private static int f77438x;

    /* renamed from: y, reason: collision with root package name */
    private static long f77439y;

    /* renamed from: z, reason: collision with root package name */
    static long f77440z;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f77441a;

    /* renamed from: b, reason: collision with root package name */
    public int f77442b;

    /* renamed from: c, reason: collision with root package name */
    public int f77443c;

    /* renamed from: d, reason: collision with root package name */
    public int f77444d;

    /* renamed from: e, reason: collision with root package name */
    public int f77445e;

    /* renamed from: f, reason: collision with root package name */
    public int f77446f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f77447g;

    /* renamed from: h, reason: collision with root package name */
    public long f77448h;

    /* renamed from: i, reason: collision with root package name */
    public long f77449i;

    /* renamed from: j, reason: collision with root package name */
    public long f77450j;

    /* renamed from: k, reason: collision with root package name */
    public int f77451k;

    /* renamed from: l, reason: collision with root package name */
    public Object f77452l;

    /* renamed from: m, reason: collision with root package name */
    public int f77453m;

    /* renamed from: n, reason: collision with root package name */
    public int f77454n;

    /* renamed from: o, reason: collision with root package name */
    public SurfaceTexture f77455o;

    /* renamed from: p, reason: collision with root package name */
    private long f77456p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f77457q;

    /* renamed from: r, reason: collision with root package name */
    private c f77458r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f77459s;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13370);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f77434t = new Object();
        f77436v = 0;
        f77437w = "";
        f77438x = 0;
        f77439y = 0L;
        f77440z = 0L;
        A = 0L;
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f77441a = null;
        this.f77442b = 0;
        this.f77443c = 0;
        this.f77455o = null;
        this.f77456p = 0L;
        this.f77457q = false;
        this.f77459s = false;
    }

    public static boolean b(SurfaceTexture surfaceTexture) {
        boolean z16;
        if (f77440z == A) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i("SurfaceTag", "checkFrameDealRight, count[" + f77440z + "," + A + "], surfaceTexture[" + surfaceTexture + "]");
        }
        return z16;
    }

    public static void c(SurfaceTexture surfaceTexture) {
        f77440z = 0L;
        A = 0L;
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i("SurfaceTag", "clearFrameCount, count[" + f77440z + "," + A + "], surfaceTexture[" + surfaceTexture + "]");
        }
    }

    public static void d(SurfaceTexture surfaceTexture) {
        f77440z++;
    }

    public static void e(SurfaceTexture surfaceTexture) {
        A++;
    }

    public static c k() {
        synchronized (f77434t) {
            c cVar = f77435u;
            if (cVar != null) {
                f77435u = cVar.f77458r;
                cVar.f77458r = null;
                f77436v--;
                cVar.f77459s = false;
                return cVar;
            }
            return new c();
        }
    }

    public static void m(String str) {
        f77437w = str;
        f77438x = 0;
        f77439y = 0L;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.f77455o != null && !this.f77457q) {
            try {
                n(null);
            } catch (Throwable th5) {
                AVCoreLog.e("SurfaceTag", "checkAfterFilterRender", th5);
            }
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.i("SurfaceTag", "checkAfterFilterRender, not deal by filter render.");
            }
        }
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        byte[] bArr = this.f77441a;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public void g(long j3, SurfaceTexture surfaceTexture, int i3, int i16, int i17, int i18, int i19, boolean z16, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Boolean.valueOf(z16), Long.valueOf(j16), Long.valueOf(j17));
            return;
        }
        this.f77455o = surfaceTexture;
        this.f77441a = null;
        this.f77442b = i3;
        this.f77443c = i16;
        this.f77444d = i17;
        this.f77445e = i18;
        this.f77446f = i19;
        this.f77447g = z16;
        this.f77448h = j16;
        this.f77449i = j17;
        this.f77450j = j3;
        this.f77453m = 0;
        this.f77454n = 0;
        this.f77456p = SystemClock.elapsedRealtime();
        this.f77457q = false;
    }

    public void h(long j3, byte[] bArr, int i3, int i16, int i17, int i18, int i19, boolean z16, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Boolean.valueOf(z16), Long.valueOf(j16), Long.valueOf(j17));
            return;
        }
        this.f77441a = bArr;
        this.f77455o = null;
        this.f77442b = i3;
        this.f77443c = i16;
        this.f77444d = i17;
        this.f77445e = i18;
        this.f77446f = i19;
        this.f77447g = z16;
        this.f77448h = j16;
        this.f77449i = j17;
        this.f77450j = j3;
        this.f77453m = 0;
        this.f77454n = 0;
        this.f77456p = SystemClock.elapsedRealtime();
        this.f77457q = false;
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f77441a != null && this.f77455o == null) {
            return true;
        }
        return false;
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.f77441a == null && this.f77455o == null) {
            return true;
        }
        return false;
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (AVCoreLog.isDevelopLevel() && this.f77456p != 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f77456p;
            int i3 = f77438x + 1;
            f77438x = i3;
            if (i3 == 1) {
                f77439y = elapsedRealtime;
            } else {
                f77439y = (f77439y + elapsedRealtime) / 2;
            }
        }
        if (this.f77455o != null && !this.f77457q && AVCoreLog.isColorLevel()) {
            AVCoreLog.i("SurfaceTag", "recycle when tex not updated.");
        }
        this.f77441a = null;
        this.f77455o = null;
        this.f77442b = 0;
        this.f77443c = 0;
        this.f77450j = 0L;
        this.f77448h = 0L;
        this.f77456p = 0L;
        this.f77457q = false;
        this.f77451k = 0;
        synchronized (f77434t) {
            if (this.f77459s) {
                AVCoreLog.i("SurfaceTag", "recycle, error.");
            } else {
                this.f77459s = true;
                int i16 = f77436v;
                if (i16 < 4) {
                    this.f77458r = f77435u;
                    f77435u = this;
                    f77436v = i16 + 1;
                }
            }
        }
    }

    public void n(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) fArr);
            return;
        }
        SurfaceTexture surfaceTexture = this.f77455o;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
            if (fArr != null) {
                this.f77455o.getTransformMatrix(fArr);
            }
            this.f77457q = true;
            e(this.f77455o);
        }
    }
}
