package com.tencent.luggage.wxa.o0;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.tencent.avcore.jni.codec.NativeCodec;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.m.j;
import com.tencent.luggage.wxa.n0.i;
import com.tencent.luggage.wxa.n0.t;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.luggage.wxa.o0.g;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.z.b {
    public static final int[] O0 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    public float A0;
    public int B0;
    public int C0;
    public int D0;
    public float E0;
    public int F0;
    public int G0;
    public int H0;
    public float I0;
    public boolean J0;
    public int K0;
    public c L0;
    public long M0;
    public int N0;

    /* renamed from: h0, reason: collision with root package name */
    public final Context f135985h0;

    /* renamed from: i0, reason: collision with root package name */
    public final f f135986i0;

    /* renamed from: j0, reason: collision with root package name */
    public final g.a f135987j0;

    /* renamed from: k0, reason: collision with root package name */
    public final long f135988k0;

    /* renamed from: l0, reason: collision with root package name */
    public final int f135989l0;

    /* renamed from: m0, reason: collision with root package name */
    public final boolean f135990m0;

    /* renamed from: n0, reason: collision with root package name */
    public final long[] f135991n0;

    /* renamed from: o0, reason: collision with root package name */
    public j[] f135992o0;

    /* renamed from: p0, reason: collision with root package name */
    public b f135993p0;

    /* renamed from: q0, reason: collision with root package name */
    public boolean f135994q0;

    /* renamed from: r0, reason: collision with root package name */
    public Surface f135995r0;

    /* renamed from: s0, reason: collision with root package name */
    public Surface f135996s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f135997t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f135998u0;

    /* renamed from: v0, reason: collision with root package name */
    public long f135999v0;

    /* renamed from: w0, reason: collision with root package name */
    public long f136000w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f136001x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f136002y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f136003z0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f136004a;

        /* renamed from: b, reason: collision with root package name */
        public final int f136005b;

        /* renamed from: c, reason: collision with root package name */
        public final int f136006c;

        public b(int i3, int i16, int i17) {
            this.f136004a = i3;
            this.f136005b = i16;
            this.f136006c = i17;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class c implements MediaCodec.OnFrameRenderedListener {
        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(MediaCodec mediaCodec, long j3, long j16) {
            e eVar = e.this;
            if (this != eVar.L0) {
                return;
            }
            eVar.I();
        }

        public c(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }
    }

    public e(Context context, com.tencent.luggage.wxa.z.c cVar, long j3, com.tencent.luggage.wxa.p.b bVar, boolean z16, Handler handler, g gVar, int i3) {
        super(2, cVar, bVar, z16);
        this.f135988k0 = j3;
        this.f135989l0 = i3;
        this.f135985h0 = context.getApplicationContext();
        this.f135986i0 = new f(context);
        this.f135987j0 = new g.a(handler, gVar);
        this.f135990m0 = G();
        this.f135991n0 = new long[10];
        this.M0 = -9223372036854775807L;
        this.f135999v0 = -9223372036854775807L;
        this.B0 = -1;
        this.C0 = -1;
        this.E0 = -1.0f;
        this.A0 = -1.0f;
        this.f135997t0 = 1;
        F();
    }

    public static boolean G() {
        if (v.f135103a <= 22 && "foster".equals(v.f135104b) && "NVIDIA".equals(v.f135105c)) {
            return true;
        }
        return false;
    }

    public static float d(j jVar) {
        float f16 = jVar.C;
        if (f16 == -1.0f) {
            return 1.0f;
        }
        return f16;
    }

    public static boolean e(long j3) {
        return j3 < -30000;
    }

    public static boolean f(String str) {
        String str2 = v.f135104b;
        if (((!"deb".equals(str2) && !"flo".equals(str2)) || !"OMX.qcom.video.decoder.avc".equals(str)) && (!"tcl_eu".equals(str2) || !"OMX.MTK.VIDEO.DECODER.AVC".equals(str))) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.z.b
    public void C() {
        try {
            super.C();
            Surface surface = this.f135996s0;
            if (surface != null) {
                if (this.f135995r0 == surface) {
                    this.f135995r0 = null;
                }
                surface.release();
                this.f135996s0 = null;
            }
        } catch (Throwable th5) {
            if (this.f135996s0 != null) {
                Surface surface2 = this.f135995r0;
                Surface surface3 = this.f135996s0;
                if (surface2 == surface3) {
                    this.f135995r0 = null;
                }
                surface3.release();
                this.f135996s0 = null;
            }
            throw th5;
        }
    }

    public final void E() {
        MediaCodec v3;
        this.f135998u0 = false;
        if (v.f135103a >= 23 && this.J0 && (v3 = v()) != null) {
            this.L0 = new c(v3);
        }
    }

    public final void F() {
        this.F0 = -1;
        this.G0 = -1;
        this.I0 = -1.0f;
        this.H0 = -1;
    }

    public final void H() {
        if (this.f136001x0 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f135987j0.a(this.f136001x0, elapsedRealtime - this.f136000w0);
            this.f136001x0 = 0;
            this.f136000w0 = elapsedRealtime;
        }
    }

    public void I() {
        if (!this.f135998u0) {
            this.f135998u0 = true;
            this.f135987j0.a(this.f135995r0);
        }
    }

    public final void J() {
        int i3 = this.B0;
        if (i3 != -1 || this.C0 != -1) {
            if (this.F0 != i3 || this.G0 != this.C0 || this.H0 != this.D0 || this.I0 != this.E0) {
                this.f135987j0.a(i3, this.C0, this.D0, this.E0);
                this.F0 = this.B0;
                this.G0 = this.C0;
                this.H0 = this.D0;
                this.I0 = this.E0;
            }
        }
    }

    public final void K() {
        if (this.f135998u0) {
            this.f135987j0.a(this.f135995r0);
        }
    }

    public final void L() {
        int i3 = this.F0;
        if (i3 != -1 || this.G0 != -1) {
            this.f135987j0.a(i3, this.G0, this.H0, this.I0);
        }
    }

    public final void M() {
        long j3;
        if (this.f135988k0 > 0) {
            j3 = SystemClock.elapsedRealtime() + this.f135988k0;
        } else {
            j3 = -9223372036854775807L;
        }
        this.f135999v0 = j3;
    }

    @Override // com.tencent.luggage.wxa.z.b
    public int a(com.tencent.luggage.wxa.z.c cVar, j jVar) {
        boolean z16;
        int i3;
        int i16;
        String str = jVar.f133896f;
        if (!i.i(str)) {
            return 0;
        }
        com.tencent.luggage.wxa.p.a aVar = jVar.f133899i;
        if (aVar != null) {
            z16 = false;
            for (int i17 = 0; i17 < aVar.f137092c; i17++) {
                z16 |= aVar.a(i17).f137098f;
            }
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.z.a a16 = cVar.a(str, z16);
        if (a16 == null) {
            return 1;
        }
        boolean a17 = a16.a(jVar.f133893c);
        if (a17 && (i3 = jVar.f133900j) > 0 && (i16 = jVar.f133901k) > 0) {
            if (v.f135103a >= 21) {
                a17 = a16.a(i3, i16, jVar.f133902l);
            } else {
                boolean z17 = i3 * i16 <= com.tencent.luggage.wxa.z.d.b();
                if (!z17) {
                    Log.d("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + jVar.f133900j + HippyTKDListViewAdapter.X + jVar.f133901k + "] [" + v.f135107e + "]");
                }
                a17 = z17;
            }
        }
        return (a17 ? 4 : 3) | (a16.f146141b ? 16 : 8) | (a16.f146142c ? 32 : 0);
    }

    @Override // com.tencent.luggage.wxa.z.b
    public void b(j jVar) {
        super.b(jVar);
        this.f135987j0.a(jVar);
        this.A0 = d(jVar);
        this.f136003z0 = e(jVar);
    }

    public boolean c(long j3, long j16) {
        return e(j3);
    }

    @Override // com.tencent.luggage.wxa.z.b, com.tencent.luggage.wxa.m.r
    public boolean isReady() {
        Surface surface;
        if (super.isReady() && (this.f135998u0 || (((surface = this.f135996s0) != null && this.f135995r0 == surface) || v() == null || this.J0))) {
            this.f135999v0 = -9223372036854775807L;
            return true;
        }
        if (this.f135999v0 == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.f135999v0) {
            return true;
        }
        this.f135999v0 = -9223372036854775807L;
        return false;
    }

    @Override // com.tencent.luggage.wxa.z.b, com.tencent.luggage.wxa.m.a
    public void q() {
        this.B0 = -1;
        this.C0 = -1;
        this.E0 = -1.0f;
        this.A0 = -1.0f;
        this.M0 = -9223372036854775807L;
        this.N0 = 0;
        F();
        E();
        this.f135986i0.a();
        this.L0 = null;
        this.J0 = false;
        try {
            super.q();
        } finally {
            this.f146152f0.a();
            this.f135987j0.a(this.f146152f0);
        }
    }

    @Override // com.tencent.luggage.wxa.z.b, com.tencent.luggage.wxa.m.a
    public void r() {
        super.r();
        this.f136001x0 = 0;
        this.f136000w0 = SystemClock.elapsedRealtime();
    }

    @Override // com.tencent.luggage.wxa.z.b, com.tencent.luggage.wxa.m.a
    public void s() {
        this.f135999v0 = -9223372036854775807L;
        H();
        super.s();
    }

    public static int e(j jVar) {
        int i3 = jVar.f133903m;
        if (i3 == -1) {
            return 0;
        }
        return i3;
    }

    public void c(MediaCodec mediaCodec, int i3, long j3) {
        t.a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i3, false);
        t.a();
        this.f146152f0.f135952e++;
    }

    public void b(MediaCodec mediaCodec, int i3, long j3) {
        J();
        t.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i3, true);
        t.a();
        this.f146152f0.f135951d++;
        this.f136002y0 = 0;
        I();
    }

    public final boolean c(boolean z16) {
        return v.f135103a >= 23 && !this.J0 && (!z16 || com.tencent.luggage.wxa.o0.c.b(this.f135985h0));
    }

    public static int c(j jVar) {
        if (jVar.f133897g != -1) {
            int size = jVar.f133898h.size();
            int i3 = 0;
            for (int i16 = 0; i16 < size; i16++) {
                i3 += ((byte[]) jVar.f133898h.get(i16)).length;
            }
            return jVar.f133897g + i3;
        }
        return a(jVar.f133896f, jVar.f133900j, jVar.f133901k);
    }

    @Override // com.tencent.luggage.wxa.z.b, com.tencent.luggage.wxa.m.a
    public void a(boolean z16) {
        super.a(z16);
        int i3 = n().f133924a;
        this.K0 = i3;
        this.J0 = i3 != 0;
        this.f135987j0.b(this.f146152f0);
        this.f135986i0.b();
    }

    @Override // com.tencent.luggage.wxa.m.a
    public void a(j[] jVarArr, long j3) {
        this.f135992o0 = jVarArr;
        if (this.M0 == -9223372036854775807L) {
            this.M0 = j3;
        } else {
            int i3 = this.N0;
            if (i3 == this.f135991n0.length) {
                Log.w("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + this.f135991n0[this.N0 - 1]);
            } else {
                this.N0 = i3 + 1;
            }
            this.f135991n0[this.N0 - 1] = j3;
        }
        super.a(jVarArr, j3);
    }

    @Override // com.tencent.luggage.wxa.z.b, com.tencent.luggage.wxa.m.a
    public void a(long j3, boolean z16) {
        super.a(j3, z16);
        E();
        this.f136002y0 = 0;
        int i3 = this.N0;
        if (i3 != 0) {
            this.M0 = this.f135991n0[i3 - 1];
            this.N0 = 0;
        }
        if (z16) {
            M();
        } else {
            this.f135999v0 = -9223372036854775807L;
        }
    }

    @Override // com.tencent.luggage.wxa.m.a, com.tencent.luggage.wxa.m.e.b
    public void a(int i3, Object obj) {
        if (i3 == 1) {
            a((Surface) obj);
            return;
        }
        if (i3 == 4) {
            this.f135997t0 = ((Integer) obj).intValue();
            MediaCodec v3 = v();
            if (v3 != null) {
                a(v3, this.f135997t0);
                return;
            }
            return;
        }
        super.a(i3, obj);
    }

    public final void a(Surface surface) {
        if (surface == null) {
            Surface surface2 = this.f135996s0;
            if (surface2 != null) {
                surface = surface2;
            } else {
                com.tencent.luggage.wxa.z.a w3 = w();
                if (w3 != null && c(w3.f146143d)) {
                    surface = com.tencent.luggage.wxa.o0.c.a(this.f135985h0, w3.f146143d);
                    this.f135996s0 = surface;
                }
            }
        }
        if (this.f135995r0 != surface) {
            this.f135995r0 = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                MediaCodec v3 = v();
                if (v.f135103a >= 23 && v3 != null && surface != null && !this.f135994q0) {
                    a(v3, surface);
                } else {
                    C();
                    y();
                }
            }
            if (surface != null && surface != this.f135996s0) {
                L();
                E();
                if (state == 2) {
                    M();
                    return;
                }
                return;
            }
            F();
            E();
            return;
        }
        if (surface == null || surface == this.f135996s0) {
            return;
        }
        L();
        K();
    }

    @Override // com.tencent.luggage.wxa.z.b
    public boolean a(com.tencent.luggage.wxa.z.a aVar) {
        return this.f135995r0 != null || c(aVar.f146143d);
    }

    @Override // com.tencent.luggage.wxa.z.b
    public void a(com.tencent.luggage.wxa.z.a aVar, MediaCodec mediaCodec, j jVar, MediaCrypto mediaCrypto) {
        b a16 = a(aVar, jVar, this.f135992o0);
        this.f135993p0 = a16;
        MediaFormat a17 = a(jVar, a16, this.f135990m0, this.K0);
        if (this.f135995r0 == null) {
            com.tencent.luggage.wxa.n0.a.b(c(aVar.f146143d));
            if (this.f135996s0 == null) {
                this.f135996s0 = com.tencent.luggage.wxa.o0.c.a(this.f135985h0, aVar.f146143d);
            }
            this.f135995r0 = this.f135996s0;
        }
        mediaCodec.configure(a17, this.f135995r0, mediaCrypto, 0);
        if (v.f135103a < 23 || !this.J0) {
            return;
        }
        this.L0 = new c(mediaCodec);
    }

    @Override // com.tencent.luggage.wxa.z.b
    public void a(String str, long j3, long j16) {
        this.f135987j0.a(str, j3, j16);
        this.f135994q0 = f(str);
    }

    @Override // com.tencent.luggage.wxa.z.b
    public void a(com.tencent.luggage.wxa.o.d dVar) {
        if (v.f135103a >= 23 || !this.J0) {
            return;
        }
        I();
    }

    @Override // com.tencent.luggage.wxa.z.b
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        boolean z16 = mediaFormat.containsKey(NativeCodec.RIGHT) && mediaFormat.containsKey(NativeCodec.LEFT) && mediaFormat.containsKey(NativeCodec.BOTTOM) && mediaFormat.containsKey(NativeCodec.TOP);
        if (z16) {
            integer = (mediaFormat.getInteger(NativeCodec.RIGHT) - mediaFormat.getInteger(NativeCodec.LEFT)) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.B0 = integer;
        if (z16) {
            integer2 = (mediaFormat.getInteger(NativeCodec.BOTTOM) - mediaFormat.getInteger(NativeCodec.TOP)) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.C0 = integer2;
        float f16 = this.A0;
        this.E0 = f16;
        if (v.f135103a >= 21) {
            int i3 = this.f136003z0;
            if (i3 == 90 || i3 == 270) {
                int i16 = this.B0;
                this.B0 = integer2;
                this.C0 = i16;
                this.E0 = 1.0f / f16;
            }
        } else {
            this.D0 = this.f136003z0;
        }
        a(mediaCodec, this.f135997t0);
    }

    @Override // com.tencent.luggage.wxa.z.b
    public boolean a(MediaCodec mediaCodec, boolean z16, j jVar, j jVar2) {
        if (a(z16, jVar, jVar2)) {
            int i3 = jVar2.f133900j;
            b bVar = this.f135993p0;
            if (i3 <= bVar.f136004a && jVar2.f133901k <= bVar.f136005b && c(jVar2) <= this.f135993p0.f136006c) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.z.b
    public boolean a(long j3, long j16, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i3, int i16, long j17, boolean z16) {
        while (true) {
            int i17 = this.N0;
            if (i17 == 0) {
                break;
            }
            long[] jArr = this.f135991n0;
            long j18 = jArr[0];
            if (j17 < j18) {
                break;
            }
            this.M0 = j18;
            int i18 = i17 - 1;
            this.N0 = i18;
            System.arraycopy(jArr, 1, jArr, 0, i18);
        }
        long j19 = j17 - this.M0;
        if (z16) {
            c(mediaCodec, i3, j19);
            return true;
        }
        long j26 = j17 - j3;
        if (this.f135995r0 == this.f135996s0) {
            if (!e(j26)) {
                return false;
            }
            c(mediaCodec, i3, j19);
            return true;
        }
        if (!this.f135998u0) {
            if (v.f135103a >= 21) {
                a(mediaCodec, i3, j19, System.nanoTime());
            } else {
                b(mediaCodec, i3, j19);
            }
            return true;
        }
        if (getState() != 2) {
            return false;
        }
        long elapsedRealtime = j26 - ((SystemClock.elapsedRealtime() * 1000) - j16);
        long nanoTime = System.nanoTime();
        long a16 = this.f135986i0.a(j17, (elapsedRealtime * 1000) + nanoTime);
        long j27 = (a16 - nanoTime) / 1000;
        if (c(j27, j16)) {
            a(mediaCodec, i3, j19);
            return true;
        }
        if (v.f135103a >= 21) {
            if (j27 < 50000) {
                a(mediaCodec, i3, j19, a16);
                return true;
            }
        } else if (j27 < 30000) {
            if (j27 > 11000) {
                try {
                    LockMethodProxy.sleep((j27 - 10000) / 1000);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
            b(mediaCodec, i3, j19);
            return true;
        }
        return false;
    }

    public void a(MediaCodec mediaCodec, int i3, long j3) {
        t.a("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i3, false);
        t.a();
        com.tencent.luggage.wxa.o.c cVar = this.f146152f0;
        cVar.f135953f++;
        this.f136001x0++;
        int i16 = this.f136002y0 + 1;
        this.f136002y0 = i16;
        cVar.f135954g = Math.max(i16, cVar.f135954g);
        if (this.f136001x0 == this.f135989l0) {
            H();
        }
    }

    public void a(MediaCodec mediaCodec, int i3, long j3, long j16) {
        J();
        t.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i3, j16);
        t.a();
        this.f146152f0.f135951d++;
        this.f136002y0 = 0;
        I();
    }

    public static void a(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    public static void a(MediaFormat mediaFormat, int i3) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i3);
    }

    public b a(com.tencent.luggage.wxa.z.a aVar, j jVar, j[] jVarArr) {
        int i3 = jVar.f133900j;
        int i16 = jVar.f133901k;
        int c16 = c(jVar);
        if (jVarArr.length == 1) {
            return new b(i3, i16, c16);
        }
        boolean z16 = false;
        for (j jVar2 : jVarArr) {
            if (a(aVar.f146141b, jVar, jVar2)) {
                int i17 = jVar2.f133900j;
                z16 |= i17 == -1 || jVar2.f133901k == -1;
                i3 = Math.max(i3, i17);
                i16 = Math.max(i16, jVar2.f133901k);
                c16 = Math.max(c16, c(jVar2));
            }
        }
        if (z16) {
            Log.w("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i3 + HippyTKDListViewAdapter.X + i16);
            Point a16 = a(aVar, jVar);
            if (a16 != null) {
                i3 = Math.max(i3, a16.x);
                i16 = Math.max(i16, a16.y);
                c16 = Math.max(c16, a(jVar.f133896f, i3, i16));
                Log.w("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i3 + HippyTKDListViewAdapter.X + i16);
            }
        }
        return new b(i3, i16, c16);
    }

    public MediaFormat a(j jVar, b bVar, boolean z16, int i3) {
        MediaFormat a16 = jVar.a();
        a16.setInteger("max-width", bVar.f136004a);
        a16.setInteger("max-height", bVar.f136005b);
        int i16 = bVar.f136006c;
        if (i16 != -1) {
            a16.setInteger("max-input-size", i16);
        }
        if (z16) {
            a16.setInteger("auto-frc", 0);
        }
        if (i3 != 0) {
            a(a16, i3);
        }
        return a16;
    }

    public static Point a(com.tencent.luggage.wxa.z.a aVar, j jVar) {
        int i3 = jVar.f133901k;
        int i16 = jVar.f133900j;
        boolean z16 = i3 > i16;
        int i17 = z16 ? i3 : i16;
        if (z16) {
            i3 = i16;
        }
        float f16 = i3 / i17;
        for (int i18 : O0) {
            int i19 = (int) (i18 * f16);
            if (i18 <= i17 || i19 <= i3) {
                break;
            }
            if (v.f135103a >= 21) {
                int i26 = z16 ? i19 : i18;
                if (!z16) {
                    i18 = i19;
                }
                Point a16 = aVar.a(i26, i18);
                if (aVar.a(a16.x, a16.y, jVar.f133902l)) {
                    return a16;
                }
            } else {
                int a17 = v.a(i18, 16) * 16;
                int a18 = v.a(i19, 16) * 16;
                if (a17 * a18 <= com.tencent.luggage.wxa.z.d.b()) {
                    int i27 = z16 ? a18 : a17;
                    if (!z16) {
                        a17 = a18;
                    }
                    return new Point(i27, a17);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x005d. Please report as an issue. */
    public static int a(String str, int i3, int i16) {
        char c16;
        int i17;
        if (i3 == -1 || i16 == -1) {
            return -1;
        }
        str.hashCode();
        int i18 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c16 = 4;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c16 = 5;
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
            case 2:
            case 4:
                i17 = i3 * i16;
                i18 = 2;
                return (i17 * 3) / (i18 * 2);
            case 1:
            case 5:
                i17 = i3 * i16;
                return (i17 * 3) / (i18 * 2);
            case 3:
                if ("BRAVIA 4K 2015".equals(v.f135106d)) {
                    return -1;
                }
                i17 = v.a(i3, 16) * v.a(i16, 16) * 16 * 16;
                i18 = 2;
                return (i17 * 3) / (i18 * 2);
            default:
                return -1;
        }
    }

    public static void a(MediaCodec mediaCodec, int i3) {
        mediaCodec.setVideoScalingMode(i3);
    }

    public static boolean a(boolean z16, j jVar, j jVar2) {
        return jVar.f133896f.equals(jVar2.f133896f) && e(jVar) == e(jVar2) && (z16 || (jVar.f133900j == jVar2.f133900j && jVar.f133901k == jVar2.f133901k));
    }
}
