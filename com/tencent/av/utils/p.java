package com.tencent.av.utils;

import android.annotation.TargetApi;
import android.os.SystemClock;
import com.tencent.avcore.util.AVCoreLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;

/* compiled from: P */
@TargetApi(17)
/* loaded from: classes3.dex */
public class p {
    private static long D;

    /* renamed from: x, reason: collision with root package name */
    private final long f77158x;

    /* renamed from: y, reason: collision with root package name */
    public p f77159y;

    /* renamed from: a, reason: collision with root package name */
    private long f77135a = 0;

    /* renamed from: b, reason: collision with root package name */
    private long f77136b = 0;

    /* renamed from: c, reason: collision with root package name */
    private long f77137c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f77138d = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f77139e = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f77140f = 0;

    /* renamed from: g, reason: collision with root package name */
    private long f77141g = 0;

    /* renamed from: h, reason: collision with root package name */
    private long f77142h = 0;

    /* renamed from: i, reason: collision with root package name */
    private long f77143i = 0;

    /* renamed from: j, reason: collision with root package name */
    private long f77144j = 0;

    /* renamed from: k, reason: collision with root package name */
    private long f77145k = 0;

    /* renamed from: l, reason: collision with root package name */
    private long f77146l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f77147m = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f77148n = 0;

    /* renamed from: o, reason: collision with root package name */
    private int f77149o = 0;

    /* renamed from: p, reason: collision with root package name */
    private int f77150p = 0;

    /* renamed from: q, reason: collision with root package name */
    private int f77151q = 0;

    /* renamed from: r, reason: collision with root package name */
    private int f77152r = 0;

    /* renamed from: s, reason: collision with root package name */
    private int f77153s = 0;

    /* renamed from: t, reason: collision with root package name */
    private int f77154t = 0;

    /* renamed from: u, reason: collision with root package name */
    private long f77155u = 0;

    /* renamed from: v, reason: collision with root package name */
    private boolean f77156v = true;

    /* renamed from: w, reason: collision with root package name */
    private boolean f77157w = false;

    /* renamed from: z, reason: collision with root package name */
    private float f77160z = 0.0f;
    private float A = 0.0f;
    boolean B = false;
    boolean C = false;

    public p(p pVar, long j3) {
        this.f77158x = j3;
        this.f77159y = pVar;
    }

    static float a(float f16, long j3) {
        if (f16 == 0.0f) {
            return (float) j3;
        }
        if (j3 == 0) {
            return f16;
        }
        return (f16 * 0.98f) + (((float) j3) * 0.02f);
    }

    private void e(String str) {
        b();
        k(str);
        this.f77159y = null;
    }

    public static boolean f() {
        return true;
    }

    public static boolean g() {
        return AVCoreLog.isColorLevel();
    }

    static int i(float f16) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((1000000.0f / f16) * 100.0f);
    }

    static long j(long j3, long j16) {
        if (j3 == 0 || j16 == 0) {
            return 0L;
        }
        return j3 - j16;
    }

    private void k(String str) {
        String str2;
        boolean c16 = c();
        if (c16) {
            String str3 = "frameIndex[" + this.f77159y + "->" + this.f77158x + "], dataLen[" + this.f77148n + "], width[" + this.f77149o + "], height[" + this.f77150p + "], format[" + this.f77151q + "], CamAngle[" + this.f77152r + "], FinalAngle[" + this.f77154t + "], CamFPS[" + this.f77155u + "], PreviewDataFPS[" + i(this.f77160z) + "], SendFPS[" + i(this.A) + "], isFront[" + this.f77156v + "], effect[" + this.f77157w + "], business[" + String.format("%08x", Integer.valueOf(this.f77147m)) + "]";
            if (g()) {
                str2 = ", intervalPreviewData[" + this.f77136b + "], intervalSendCameraFrame2Native[" + this.f77146l + "], render[" + j(this.f77144j, this.f77137c) + "], CheckLowligh[" + j(this.f77138d, this.f77137c) + "], Beauty2[" + j(this.f77139e, this.f77138d) + "], DenoiseRender[" + j(this.f77140f, this.f77139e) + "], LowLightRender[" + j(this.f77141g, this.f77140f) + "], Beauty3[" + j(this.f77142h, this.f77141g) + "], RenderChain[" + j(this.f77143i, this.f77142h) + "], post[" + j(this.f77144j, this.f77143i) + "], buildExtInfo[" + j(this.f77145k, this.f77144j) + "]";
            } else {
                str2 = null;
            }
            String str4 = ("PerfLog, " + str3 + str2) + ", onPreviewData[" + this.f77135a + "], renderBegin[" + this.f77137c + "], afterCheckLowligh[" + this.f77138d + "], afterDenoiseRender[" + this.f77140f + "], afterLowLightRender[" + this.f77141g + "], afterBeautyRender[" + this.f77142h + "], afterRenderChain[" + this.f77143i + "], renderEnd[" + this.f77144j + "], sendCameraFrame2Native[" + this.f77145k + "]";
            if (c16) {
                AVCoreLog.printAllUserLog("FramePerfDataK_" + this.C, str4);
                return;
            }
            AVCoreLog.d("FramePerfData_" + this.C, str4);
        }
    }

    void b() {
        float f16;
        p pVar = this.f77159y;
        while (pVar != null && !pVar.B) {
            pVar.C = true;
            pVar = pVar.f77159y;
        }
        this.f77159y = pVar;
        if (pVar != null) {
            long j3 = pVar.f77135a;
            if (j3 != 0) {
                this.f77136b = this.f77135a - j3;
            }
            long j16 = pVar.f77145k;
            if (j16 != 0) {
                this.f77146l = this.f77145k - j16;
            }
        }
        float f17 = 0.0f;
        if (pVar == null) {
            f16 = 0.0f;
        } else {
            f16 = pVar.f77160z;
        }
        this.f77160z = a(f16, this.f77136b / 1000);
        if (pVar != null) {
            f17 = pVar.A;
        }
        this.A = a(f17, this.f77146l / 1000);
    }

    boolean c() {
        if (System.currentTimeMillis() - D >= 4000) {
            D = System.currentTimeMillis();
            return true;
        }
        p pVar = this.f77159y;
        if (pVar != null) {
            if (pVar.f77148n == this.f77148n && pVar.f77149o == this.f77149o && pVar.f77150p == this.f77150p && pVar.f77151q == this.f77151q && pVar.f77152r == this.f77152r && pVar.f77153s == this.f77153s && pVar.f77155u == this.f77155u && pVar.f77156v == this.f77156v && pVar.f77157w == this.f77157w && pVar.f77154t == this.f77154t && pVar.f77147m == this.f77147m && pVar.f77158x + 1 == this.f77158x) {
                return false;
            }
            D = System.currentTimeMillis();
            return true;
        }
        D = System.currentTimeMillis();
        return true;
    }

    public boolean d() {
        if (this.B) {
            return true;
        }
        this.B = true;
        e(QCircleLpReportDc05507.KEY_CLEAR);
        return false;
    }

    public void h() {
        this.B = true;
        if (g()) {
            this.f77145k = SystemClock.elapsedRealtimeNanos();
        }
        e("finish");
    }

    public void l(boolean z16, boolean z17, boolean z18, boolean z19) {
        if (g()) {
            this.f77143i = SystemClock.elapsedRealtimeNanos();
            if (z16) {
                this.f77147m |= 32;
            }
            if (z17) {
                this.f77147m |= 16;
            }
            if (z18) {
                this.f77147m |= 64;
            }
            if (z19) {
                this.f77147m |= 128;
            }
        }
    }

    public void m() {
        if (g()) {
            this.f77135a = SystemClock.elapsedRealtimeNanos();
        }
    }

    public void n() {
        if (g()) {
            this.f77137c = SystemClock.elapsedRealtimeNanos();
        }
    }

    public void o() {
        if (g()) {
            this.f77144j = SystemClock.elapsedRealtimeNanos();
        }
    }

    public void p(int i3, int i16, int i17, int i18, int i19, int i26, long j3, boolean z16, boolean z17) {
        this.f77148n = i3;
        this.f77149o = i16;
        this.f77150p = i17;
        this.f77151q = i18;
        this.f77152r = i19;
        this.f77153s = i26;
        this.f77155u = j3;
        this.f77156v = z16;
        this.f77157w = z17;
    }

    public void q(int i3) {
        this.f77154t = i3;
    }

    public String toString() {
        return this.f77158x + "";
    }
}
