package com.tencent.luggage.wxa.n;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.luggage.wxa.m.p;
import com.tencent.luggage.wxa.n.d;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f {

    /* renamed from: f0, reason: collision with root package name */
    public static boolean f134931f0 = false;

    /* renamed from: g0, reason: collision with root package name */
    public static boolean f134932g0 = false;
    public int A;
    public long B;
    public long C;
    public boolean D;
    public long E;
    public Method F;
    public int G;
    public long H;
    public long I;
    public int J;
    public long K;
    public long L;
    public int M;
    public int N;
    public long O;
    public long P;
    public long Q;
    public float R;
    public com.tencent.luggage.wxa.n.d[] S;
    public ByteBuffer[] T;
    public ByteBuffer U;
    public ByteBuffer V;
    public byte[] W;
    public int X;
    public int Y;
    public boolean Z;

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n.c f134933a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f134934a0;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n.g f134935b;

    /* renamed from: b0, reason: collision with root package name */
    public int f134936b0;

    /* renamed from: c, reason: collision with root package name */
    public final l f134937c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f134938c0;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n.d[] f134939d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f134940d0;

    /* renamed from: e, reason: collision with root package name */
    public final h f134941e;

    /* renamed from: e0, reason: collision with root package name */
    public long f134942e0;

    /* renamed from: f, reason: collision with root package name */
    public final ConditionVariable f134943f = new ConditionVariable(true);

    /* renamed from: g, reason: collision with root package name */
    public final long[] f134944g;

    /* renamed from: h, reason: collision with root package name */
    public final c f134945h;

    /* renamed from: i, reason: collision with root package name */
    public final LinkedList f134946i;

    /* renamed from: j, reason: collision with root package name */
    public AudioTrack f134947j;

    /* renamed from: k, reason: collision with root package name */
    public AudioTrack f134948k;

    /* renamed from: l, reason: collision with root package name */
    public int f134949l;

    /* renamed from: m, reason: collision with root package name */
    public int f134950m;

    /* renamed from: n, reason: collision with root package name */
    public int f134951n;

    /* renamed from: o, reason: collision with root package name */
    public int f134952o;

    /* renamed from: p, reason: collision with root package name */
    public com.tencent.luggage.wxa.n.b f134953p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f134954q;

    /* renamed from: r, reason: collision with root package name */
    public int f134955r;

    /* renamed from: s, reason: collision with root package name */
    public long f134956s;

    /* renamed from: t, reason: collision with root package name */
    public p f134957t;

    /* renamed from: u, reason: collision with root package name */
    public p f134958u;

    /* renamed from: v, reason: collision with root package name */
    public long f134959v;

    /* renamed from: w, reason: collision with root package name */
    public long f134960w;

    /* renamed from: x, reason: collision with root package name */
    public ByteBuffer f134961x;

    /* renamed from: y, reason: collision with root package name */
    public int f134962y;

    /* renamed from: z, reason: collision with root package name */
    public int f134963z;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends BaseThread {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioTrack f134964a;

        public a(AudioTrack audioTrack) {
            this.f134964a = audioTrack;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.f134964a.flush();
                this.f134964a.release();
            } finally {
                f.this.f134943f.open();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends BaseThread {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioTrack f134966a;

        public b(AudioTrack audioTrack) {
            this.f134966a = audioTrack;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f134966a.release();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d extends c {

        /* renamed from: j, reason: collision with root package name */
        public final AudioTimestamp f134977j;

        /* renamed from: k, reason: collision with root package name */
        public long f134978k;

        /* renamed from: l, reason: collision with root package name */
        public long f134979l;

        /* renamed from: m, reason: collision with root package name */
        public long f134980m;

        public d() {
            super(null);
            this.f134977j = new AudioTimestamp();
        }

        @Override // com.tencent.luggage.wxa.n.f.c
        public void a(AudioTrack audioTrack, boolean z16) {
            super.a(audioTrack, z16);
            this.f134978k = 0L;
            this.f134979l = 0L;
            this.f134980m = 0L;
        }

        @Override // com.tencent.luggage.wxa.n.f.c
        public long c() {
            return this.f134980m;
        }

        @Override // com.tencent.luggage.wxa.n.f.c
        public long d() {
            return this.f134977j.nanoTime;
        }

        @Override // com.tencent.luggage.wxa.n.f.c
        public boolean f() {
            boolean timestamp = this.f134968a.getTimestamp(this.f134977j);
            if (timestamp) {
                long j3 = this.f134977j.framePosition;
                if (this.f134979l > j3) {
                    this.f134978k++;
                }
                this.f134979l = j3;
                this.f134980m = j3 + (this.f134978k << 32);
            }
            return timestamp;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends Exception {
        public e(Throwable th5) {
            super(th5);
        }

        public e(String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.n.f$f, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6492f extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public final int f134981a;

        public C6492f(int i3, int i16, int i17, int i18) {
            super("AudioTrack init failed: " + i3 + ", Config(" + i16 + ", " + i17 + ", " + i18 + ")");
            this.f134981a = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends RuntimeException {
        public g(String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface h {
        void a();

        void a(int i3);

        void a(int i3, long j3, long j16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i {

        /* renamed from: a, reason: collision with root package name */
        public final p f134982a;

        /* renamed from: b, reason: collision with root package name */
        public final long f134983b;

        /* renamed from: c, reason: collision with root package name */
        public final long f134984c;

        public /* synthetic */ i(p pVar, long j3, long j16, a aVar) {
            this(pVar, j3, j16);
        }

        public i(p pVar, long j3, long j16) {
            this.f134982a = pVar;
            this.f134983b = j3;
            this.f134984c = j16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public final int f134985a;

        public j(int i3) {
            super("AudioTrack write failed: " + i3);
            this.f134985a = i3;
        }
    }

    public f(com.tencent.luggage.wxa.n.c cVar, com.tencent.luggage.wxa.n.d[] dVarArr, h hVar) {
        this.f134933a = cVar;
        this.f134941e = hVar;
        a aVar = null;
        if (v.f135103a >= 18) {
            try {
                this.F = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (v.f135103a >= 19) {
            this.f134945h = new d();
        } else {
            this.f134945h = new c(aVar);
        }
        com.tencent.luggage.wxa.n.g gVar = new com.tencent.luggage.wxa.n.g();
        this.f134935b = gVar;
        l lVar = new l();
        this.f134937c = lVar;
        com.tencent.luggage.wxa.n.d[] dVarArr2 = new com.tencent.luggage.wxa.n.d[dVarArr.length + 3];
        this.f134939d = dVarArr2;
        dVarArr2[0] = new com.tencent.luggage.wxa.n.j();
        dVarArr2[1] = gVar;
        System.arraycopy(dVarArr, 0, dVarArr2, 2, dVarArr.length);
        dVarArr2[dVarArr.length + 2] = lVar;
        this.f134944g = new long[10];
        this.R = 1.0f;
        this.N = 0;
        this.f134953p = com.tencent.luggage.wxa.n.b.f134901e;
        this.f134936b0 = 0;
        this.f134958u = p.f133919d;
        this.Y = -1;
        this.S = new com.tencent.luggage.wxa.n.d[0];
        this.T = new ByteBuffer[0];
        this.f134946i = new LinkedList();
    }

    public boolean b(String str) {
        com.tencent.luggage.wxa.n.c cVar = this.f134933a;
        return cVar != null && cVar.a(a(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0032 -> B:7:0x0012). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c() {
        boolean z16;
        int i3;
        com.tencent.luggage.wxa.n.d[] dVarArr;
        if (this.Y == -1) {
            this.Y = this.f134954q ? this.S.length : 0;
            z16 = true;
            i3 = this.Y;
            dVarArr = this.S;
            if (i3 < dVarArr.length) {
                com.tencent.luggage.wxa.n.d dVar = dVarArr[i3];
                if (z16) {
                    dVar.e();
                }
                d(-9223372036854775807L);
                if (!dVar.b()) {
                    return false;
                }
                this.Y++;
                z16 = true;
                i3 = this.Y;
                dVarArr = this.S;
                if (i3 < dVarArr.length) {
                    ByteBuffer byteBuffer = this.V;
                    if (byteBuffer != null) {
                        b(byteBuffer, -9223372036854775807L);
                        if (this.V != null) {
                            return false;
                        }
                    }
                    this.Y = -1;
                    return true;
                }
            }
        } else {
            z16 = false;
            i3 = this.Y;
            dVarArr = this.S;
            if (i3 < dVarArr.length) {
            }
        }
    }

    public final void d(long j3) {
        ByteBuffer byteBuffer;
        int length = this.S.length;
        int i3 = length;
        while (i3 >= 0) {
            if (i3 > 0) {
                byteBuffer = this.T[i3 - 1];
            } else {
                byteBuffer = this.U;
                if (byteBuffer == null) {
                    byteBuffer = com.tencent.luggage.wxa.n.d.f134912a;
                }
            }
            if (i3 == length) {
                b(byteBuffer, j3);
            } else {
                com.tencent.luggage.wxa.n.d dVar = this.S[i3];
                dVar.a(byteBuffer);
                ByteBuffer a16 = dVar.a();
                this.T[i3] = a16;
                if (a16.hasRemaining()) {
                    i3++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i3--;
            }
        }
    }

    public final long e() {
        if (this.f134954q) {
            return this.I;
        }
        return this.H / this.G;
    }

    public final long f() {
        if (this.f134954q) {
            return this.L;
        }
        return this.K / this.J;
    }

    public void g() {
        if (this.N == 1) {
            this.N = 2;
        }
    }

    public final boolean h() {
        if (m() && this.N != 0) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (m() && (f() > this.f134945h.a() || p())) {
            return true;
        }
        return false;
    }

    public final void j() {
        this.f134943f.block();
        AudioTrack k3 = k();
        this.f134948k = k3;
        int audioSessionId = k3.getAudioSessionId();
        if (f134931f0 && v.f135103a < 21) {
            AudioTrack audioTrack = this.f134947j;
            if (audioTrack != null && audioSessionId != audioTrack.getAudioSessionId()) {
                u();
            }
            if (this.f134947j == null) {
                this.f134947j = b(audioSessionId);
            }
        }
        if (this.f134936b0 != audioSessionId) {
            this.f134936b0 = audioSessionId;
            this.f134941e.a(audioSessionId);
        }
        this.f134945h.a(this.f134948k, o());
        y();
        this.f134940d0 = false;
    }

    public final AudioTrack k() {
        AudioTrack audioTrack;
        if (v.f135103a >= 21) {
            audioTrack = a();
        } else {
            int c16 = v.c(this.f134953p.f134904c);
            if (this.f134936b0 == 0) {
                audioTrack = new AudioTrack(c16, this.f134949l, this.f134950m, this.f134952o, this.f134955r, 1);
            } else {
                audioTrack = new AudioTrack(c16, this.f134949l, this.f134950m, this.f134952o, this.f134955r, 1, this.f134936b0);
            }
        }
        int state = audioTrack.getState();
        if (state == 1) {
            return audioTrack;
        }
        try {
            audioTrack.release();
        } catch (Exception unused) {
        }
        throw new C6492f(state, this.f134949l, this.f134950m, this.f134955r);
    }

    public boolean l() {
        if (m() && (!this.Z || i())) {
            return false;
        }
        return true;
    }

    public final boolean m() {
        if (this.f134948k != null) {
            return true;
        }
        return false;
    }

    public final void n() {
        long b16 = this.f134945h.b();
        if (b16 == 0) {
            return;
        }
        long nanoTime = System.nanoTime() / 1000;
        if (nanoTime - this.C >= 30000) {
            long[] jArr = this.f134944g;
            int i3 = this.f134963z;
            jArr[i3] = b16 - nanoTime;
            this.f134963z = (i3 + 1) % 10;
            int i16 = this.A;
            if (i16 < 10) {
                this.A = i16 + 1;
            }
            this.C = nanoTime;
            this.B = 0L;
            int i17 = 0;
            while (true) {
                int i18 = this.A;
                if (i17 >= i18) {
                    break;
                }
                this.B += this.f134944g[i17] / i18;
                i17++;
            }
        }
        if (!o() && nanoTime - this.E >= 500000) {
            boolean f16 = this.f134945h.f();
            this.D = f16;
            if (f16) {
                long d16 = this.f134945h.d() / 1000;
                long c16 = this.f134945h.c();
                if (d16 < this.P) {
                    this.D = false;
                } else if (Math.abs(d16 - nanoTime) > 5000000) {
                    String str = "Spurious audio timestamp (system clock mismatch): " + c16 + ", " + d16 + ", " + nanoTime + ", " + b16 + ", " + e() + ", " + f();
                    if (!f134932g0) {
                        Log.w("AudioTrack", str);
                        this.D = false;
                    } else {
                        throw new g(str);
                    }
                } else if (Math.abs(c(c16) - b16) > 5000000) {
                    String str2 = "Spurious audio timestamp (frame position mismatch): " + c16 + ", " + d16 + ", " + nanoTime + ", " + b16 + ", " + e() + ", " + f();
                    if (!f134932g0) {
                        Log.w("AudioTrack", str2);
                        this.D = false;
                    } else {
                        throw new g(str2);
                    }
                }
            }
            if (this.F != null && !this.f134954q) {
                try {
                    long intValue = (((Integer) r1.invoke(this.f134948k, null)).intValue() * 1000) - this.f134956s;
                    this.Q = intValue;
                    long max = Math.max(intValue, 0L);
                    this.Q = max;
                    if (max > 5000000) {
                        Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + this.Q);
                        this.Q = 0L;
                    }
                } catch (Exception unused) {
                    this.F = null;
                }
            }
            this.E = nanoTime;
        }
    }

    public final boolean o() {
        int i3;
        if (v.f135103a < 23 && ((i3 = this.f134952o) == 5 || i3 == 6)) {
            return true;
        }
        return false;
    }

    public final boolean p() {
        if (o() && this.f134948k.getPlayState() == 2 && this.f134948k.getPlaybackHeadPosition() == 0) {
            return true;
        }
        return false;
    }

    public void q() {
        this.f134934a0 = false;
        if (m()) {
            x();
            this.f134945h.e();
        }
    }

    public void r() {
        this.f134934a0 = true;
        if (m()) {
            this.P = System.nanoTime() / 1000;
            this.f134948k.play();
        }
    }

    public void s() {
        if (!this.Z && m() && c()) {
            this.f134945h.a(f());
            this.f134962y = 0;
            this.Z = true;
        }
    }

    public void t() {
        v();
        u();
        for (com.tencent.luggage.wxa.n.d dVar : this.f134939d) {
            dVar.reset();
        }
        this.f134936b0 = 0;
        this.f134934a0 = false;
    }

    public final void u() {
        AudioTrack audioTrack = this.f134947j;
        if (audioTrack == null) {
            return;
        }
        this.f134947j = null;
        new b(audioTrack).start();
    }

    public void v() {
        if (m()) {
            this.H = 0L;
            this.I = 0L;
            this.K = 0L;
            this.L = 0L;
            this.M = 0;
            p pVar = this.f134957t;
            if (pVar != null) {
                this.f134958u = pVar;
                this.f134957t = null;
            } else if (!this.f134946i.isEmpty()) {
                this.f134958u = ((i) this.f134946i.getLast()).f134982a;
            }
            this.f134946i.clear();
            this.f134959v = 0L;
            this.f134960w = 0L;
            this.U = null;
            this.V = null;
            int i3 = 0;
            while (true) {
                com.tencent.luggage.wxa.n.d[] dVarArr = this.S;
                if (i3 >= dVarArr.length) {
                    break;
                }
                com.tencent.luggage.wxa.n.d dVar = dVarArr[i3];
                dVar.flush();
                this.T[i3] = dVar.a();
                i3++;
            }
            this.Z = false;
            this.Y = -1;
            this.f134961x = null;
            this.f134962y = 0;
            this.N = 0;
            this.Q = 0L;
            x();
            if (this.f134948k.getPlayState() == 3) {
                this.f134948k.pause();
            }
            AudioTrack audioTrack = this.f134948k;
            this.f134948k = null;
            this.f134945h.a(null, false);
            this.f134943f.close();
            new a(audioTrack).start();
        }
    }

    public final void w() {
        ArrayList arrayList = new ArrayList();
        for (com.tencent.luggage.wxa.n.d dVar : this.f134939d) {
            if (dVar.isActive()) {
                arrayList.add(dVar);
            } else {
                dVar.flush();
            }
        }
        int size = arrayList.size();
        this.S = (com.tencent.luggage.wxa.n.d[]) arrayList.toArray(new com.tencent.luggage.wxa.n.d[size]);
        this.T = new ByteBuffer[size];
        for (int i3 = 0; i3 < size; i3++) {
            com.tencent.luggage.wxa.n.d dVar2 = this.S[i3];
            dVar2.flush();
            this.T[i3] = dVar2.a();
        }
    }

    public final void x() {
        this.B = 0L;
        this.A = 0;
        this.f134963z = 0;
        this.C = 0L;
        this.D = false;
        this.E = 0L;
    }

    public final void y() {
        if (m()) {
            if (v.f135103a >= 21) {
                a(this.f134948k, this.R);
            } else {
                b(this.f134948k, this.R);
            }
        }
    }

    public long a(boolean z16) {
        long j3;
        if (!h()) {
            return Long.MIN_VALUE;
        }
        if (this.f134948k.getPlayState() == 3) {
            n();
        }
        long nanoTime = System.nanoTime() / 1000;
        if (this.D) {
            j3 = c(this.f134945h.c() + b(nanoTime - (this.f134945h.d() / 1000)));
        } else {
            if (this.A == 0) {
                j3 = this.f134945h.b();
            } else {
                j3 = nanoTime + this.B;
            }
            if (!z16) {
                j3 -= this.Q;
            }
        }
        return this.O + a(j3);
    }

    public final boolean b(ByteBuffer byteBuffer, long j3) {
        int a16;
        if (!byteBuffer.hasRemaining()) {
            return true;
        }
        ByteBuffer byteBuffer2 = this.V;
        if (byteBuffer2 != null) {
            com.tencent.luggage.wxa.n0.a.a(byteBuffer2 == byteBuffer);
        } else {
            this.V = byteBuffer;
            if (v.f135103a < 21) {
                int remaining = byteBuffer.remaining();
                byte[] bArr = this.W;
                if (bArr == null || bArr.length < remaining) {
                    this.W = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.W, 0, remaining);
                byteBuffer.position(position);
                this.X = 0;
            }
        }
        int remaining2 = byteBuffer.remaining();
        if (v.f135103a < 21) {
            int a17 = this.f134955r - ((int) (this.K - (this.f134945h.a() * this.J)));
            if (a17 > 0) {
                a16 = this.f134948k.write(this.W, this.X, Math.min(remaining2, a17));
                if (a16 > 0) {
                    this.X += a16;
                    byteBuffer.position(byteBuffer.position() + a16);
                }
            } else {
                a16 = 0;
            }
        } else if (this.f134938c0) {
            com.tencent.luggage.wxa.n0.a.b(j3 != -9223372036854775807L);
            a16 = a(this.f134948k, byteBuffer, remaining2, j3);
        } else {
            a16 = a(this.f134948k, byteBuffer, remaining2);
        }
        this.f134942e0 = SystemClock.elapsedRealtime();
        if (a16 >= 0) {
            boolean z16 = this.f134954q;
            if (!z16) {
                this.K += a16;
            }
            if (a16 != remaining2) {
                return false;
            }
            if (z16) {
                this.L += this.M;
            }
            this.V = null;
            return true;
        }
        throw new j(a16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public AudioTrack f134968a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f134969b;

        /* renamed from: c, reason: collision with root package name */
        public int f134970c;

        /* renamed from: d, reason: collision with root package name */
        public long f134971d;

        /* renamed from: e, reason: collision with root package name */
        public long f134972e;

        /* renamed from: f, reason: collision with root package name */
        public long f134973f;

        /* renamed from: g, reason: collision with root package name */
        public long f134974g;

        /* renamed from: h, reason: collision with root package name */
        public long f134975h;

        /* renamed from: i, reason: collision with root package name */
        public long f134976i;

        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        public void a(AudioTrack audioTrack, boolean z16) {
            this.f134968a = audioTrack;
            this.f134969b = z16;
            this.f134974g = -9223372036854775807L;
            this.f134971d = 0L;
            this.f134972e = 0L;
            this.f134973f = 0L;
            if (audioTrack != null) {
                this.f134970c = audioTrack.getSampleRate();
            }
        }

        public long b() {
            return (a() * 1000000) / this.f134970c;
        }

        public long c() {
            throw new UnsupportedOperationException();
        }

        public long d() {
            throw new UnsupportedOperationException();
        }

        public void e() {
            if (this.f134974g != -9223372036854775807L) {
                return;
            }
            this.f134968a.pause();
        }

        public boolean f() {
            return false;
        }

        public void a(long j3) {
            this.f134975h = a();
            this.f134974g = SystemClock.elapsedRealtime() * 1000;
            this.f134976i = j3;
            this.f134968a.stop();
        }

        public long a() {
            if (this.f134974g != -9223372036854775807L) {
                return Math.min(this.f134976i, this.f134975h + ((((SystemClock.elapsedRealtime() * 1000) - this.f134974g) * this.f134970c) / 1000000));
            }
            int playState = this.f134968a.getPlayState();
            if (playState == 1) {
                return 0L;
            }
            long playbackHeadPosition = this.f134968a.getPlaybackHeadPosition() & 4294967295L;
            if (this.f134969b) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.f134973f = this.f134971d;
                }
                playbackHeadPosition += this.f134973f;
            }
            if (this.f134971d > playbackHeadPosition) {
                this.f134972e++;
            }
            this.f134971d = playbackHeadPosition;
            return playbackHeadPosition + (this.f134972e << 32);
        }
    }

    public p d() {
        return this.f134958u;
    }

    public final long c(long j3) {
        return (j3 * 1000000) / this.f134949l;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, int i3, int i16, int i17, int i18, int[] iArr) {
        boolean z16;
        int i19;
        int i26;
        boolean z17 = !"audio/raw".equals(str);
        int a16 = z17 ? a(str) : i17;
        if (z17) {
            z16 = false;
        } else {
            this.G = v.b(i17, i3);
            this.f134935b.a(iArr);
            z16 = false;
            for (com.tencent.luggage.wxa.n.d dVar : this.f134939d) {
                try {
                    z16 |= dVar.a(i16, i3, a16);
                    if (dVar.isActive()) {
                        i3 = dVar.c();
                        a16 = dVar.d();
                    }
                } catch (d.a e16) {
                    throw new e(e16);
                }
            }
            if (z16) {
                w();
            }
        }
        int i27 = 252;
        switch (i3) {
            case 1:
                i19 = 4;
                break;
            case 2:
                i19 = 12;
                break;
            case 3:
                i19 = 28;
                break;
            case 4:
                i19 = 204;
                break;
            case 5:
                i19 = 220;
                break;
            case 6:
                i19 = 252;
                break;
            case 7:
                i19 = 1276;
                break;
            case 8:
                i19 = com.tencent.luggage.wxa.m.b.f133805a;
                break;
            default:
                throw new e("Unsupported channel count: " + i3);
        }
        int i28 = v.f135103a;
        if (i28 <= 23 && "foster".equals(v.f135104b) && "NVIDIA".equals(v.f135105c)) {
            if (i3 != 3 && i3 != 5) {
                if (i3 == 7) {
                    i27 = com.tencent.luggage.wxa.m.b.f133805a;
                }
            }
            i26 = (i28 > 25 && "fugu".equals(v.f135104b) && z17 && i3 == 1) ? 12 : i27;
            if (z16 && m() && this.f134951n == a16 && this.f134949l == i16 && this.f134950m == i26) {
                return;
            }
            v();
            this.f134951n = a16;
            this.f134954q = z17;
            this.f134949l = i16;
            this.f134950m = i26;
            if (!z17) {
                a16 = 2;
            }
            this.f134952o = a16;
            this.J = v.b(2, i3);
            if (i18 == 0) {
                this.f134955r = i18;
            } else if (z17) {
                int i29 = this.f134952o;
                if (i29 != 5 && i29 != 6) {
                    this.f134955r = 49152;
                } else {
                    this.f134955r = 20480;
                }
            } else {
                int minBufferSize = AudioTrack.getMinBufferSize(i16, i26, this.f134952o);
                com.tencent.luggage.wxa.n0.a.b(minBufferSize != -2);
                int i36 = minBufferSize * 4;
                int b16 = ((int) b(250000L)) * this.J;
                int max = (int) Math.max(minBufferSize, b(750000L) * this.J);
                if (i36 < b16) {
                    i36 = b16;
                } else if (i36 > max) {
                    i36 = max;
                }
                this.f134955r = i36;
            }
            this.f134956s = !z17 ? -9223372036854775807L : c(this.f134955r / this.J);
            a(this.f134958u);
        }
        i27 = i19;
        if (i28 > 25) {
        }
        if (z16) {
        }
        v();
        this.f134951n = a16;
        this.f134954q = z17;
        this.f134949l = i16;
        this.f134950m = i26;
        if (!z17) {
        }
        this.f134952o = a16;
        this.J = v.b(2, i3);
        if (i18 == 0) {
        }
        this.f134956s = !z17 ? -9223372036854775807L : c(this.f134955r / this.J);
        a(this.f134958u);
    }

    public void b() {
        if (this.f134938c0) {
            this.f134938c0 = false;
            this.f134936b0 = 0;
            v();
        }
    }

    public final long b(long j3) {
        return (j3 * this.f134949l) / 1000000;
    }

    public final AudioTrack b(int i3) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, i3);
    }

    public static void b(AudioTrack audioTrack, float f16) {
        audioTrack.setStereoVolume(f16, f16);
    }

    public boolean a(ByteBuffer byteBuffer, long j3) {
        int i3;
        ByteBuffer byteBuffer2 = this.U;
        com.tencent.luggage.wxa.n0.a.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (!m()) {
            j();
            if (this.f134934a0) {
                r();
            }
        }
        if (o()) {
            if (this.f134948k.getPlayState() == 2) {
                this.f134940d0 = false;
                return false;
            }
            if (this.f134948k.getPlayState() == 1 && this.f134945h.a() != 0) {
                return false;
            }
        }
        boolean z16 = this.f134940d0;
        boolean i16 = i();
        this.f134940d0 = i16;
        if (z16 && !i16 && this.f134948k.getPlayState() != 1) {
            this.f134941e.a(this.f134955r, com.tencent.luggage.wxa.m.b.b(this.f134956s), SystemClock.elapsedRealtime() - this.f134942e0);
        }
        if (this.U == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.f134954q && this.M == 0) {
                this.M = a(this.f134952o, byteBuffer);
            }
            if (this.f134957t != null) {
                if (!c()) {
                    return false;
                }
                this.f134946i.add(new i(this.f134957t, Math.max(0L, j3), c(f()), null));
                this.f134957t = null;
                w();
            }
            if (this.N == 0) {
                this.O = Math.max(0L, j3);
                this.N = 1;
            } else {
                long c16 = this.O + c(e());
                if (this.N != 1 || Math.abs(c16 - j3) <= 200000) {
                    i3 = 2;
                } else {
                    Log.e("AudioTrack", "Discontinuity detected [expected " + c16 + ", got " + j3 + "]");
                    i3 = 2;
                    this.N = 2;
                }
                if (this.N == i3) {
                    this.O += j3 - c16;
                    this.N = 1;
                    this.f134941e.a();
                }
            }
            if (this.f134954q) {
                this.I += this.M;
            } else {
                this.H += byteBuffer.remaining();
            }
            this.U = byteBuffer;
        }
        if (this.f134954q) {
            b(this.U, j3);
        } else {
            d(j3);
        }
        if (this.U.hasRemaining()) {
            return false;
        }
        this.U = null;
        return true;
    }

    public p a(p pVar) {
        if (this.f134954q) {
            p pVar2 = p.f133919d;
            this.f134958u = pVar2;
            return pVar2;
        }
        p pVar3 = new p(this.f134937c.b(pVar.f133920a), this.f134937c.a(pVar.f133921b));
        p pVar4 = this.f134957t;
        if (pVar4 == null) {
            pVar4 = !this.f134946i.isEmpty() ? ((i) this.f134946i.getLast()).f134982a : this.f134958u;
        }
        if (!pVar3.equals(pVar4)) {
            if (m()) {
                this.f134957t = pVar3;
            } else {
                this.f134958u = pVar3;
            }
        }
        return this.f134958u;
    }

    public void a(com.tencent.luggage.wxa.n.b bVar) {
        if (this.f134953p.equals(bVar)) {
            return;
        }
        this.f134953p = bVar;
        if (this.f134938c0) {
            return;
        }
        v();
        this.f134936b0 = 0;
    }

    public void a(int i3) {
        com.tencent.luggage.wxa.n0.a.b(v.f135103a >= 21);
        if (this.f134938c0 && this.f134936b0 == i3) {
            return;
        }
        this.f134938c0 = true;
        this.f134936b0 = i3;
        v();
    }

    public void a(float f16) {
        if (this.R != f16) {
            this.R = f16;
            y();
        }
    }

    public final long a(long j3) {
        long j16;
        long j17;
        while (!this.f134946i.isEmpty() && j3 >= ((i) this.f134946i.getFirst()).f134984c) {
            i iVar = (i) this.f134946i.remove();
            this.f134958u = iVar.f134982a;
            this.f134960w = iVar.f134984c;
            this.f134959v = iVar.f134983b - this.O;
        }
        if (this.f134958u.f133920a == 1.0f) {
            return (j3 + this.f134959v) - this.f134960w;
        }
        if (this.f134946i.isEmpty() && this.f134937c.g() >= 1024) {
            j16 = this.f134959v;
            j17 = v.b(j3 - this.f134960w, this.f134937c.f(), this.f134937c.g());
        } else {
            j16 = this.f134959v;
            j17 = (long) (this.f134958u.f133920a * (j3 - this.f134960w));
        }
        return j16 + j17;
    }

    public final AudioTrack a() {
        AudioAttributes a16;
        if (this.f134938c0) {
            a16 = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        } else {
            a16 = this.f134953p.a();
        }
        AudioAttributes audioAttributes = a16;
        AudioFormat build = new AudioFormat.Builder().setChannelMask(this.f134950m).setEncoding(this.f134952o).setSampleRate(this.f134949l).build();
        int i3 = this.f134936b0;
        if (i3 == 0) {
            i3 = 0;
        }
        return new AudioTrack(audioAttributes, build, this.f134955r, 1, i3);
    }

    public static int a(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    c16 = 0;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c16 = 1;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c16 = 2;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    c16 = 3;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return 7;
            case 1:
                return 5;
            case 2:
                return 6;
            case 3:
                return 8;
            default:
                return 0;
        }
    }

    public static int a(int i3, ByteBuffer byteBuffer) {
        if (i3 == 7 || i3 == 8) {
            return com.tencent.luggage.wxa.n.h.a(byteBuffer);
        }
        if (i3 == 5) {
            return com.tencent.luggage.wxa.n.a.a();
        }
        if (i3 == 6) {
            return com.tencent.luggage.wxa.n.a.a(byteBuffer);
        }
        throw new IllegalStateException("Unexpected audio encoding: " + i3);
    }

    public static int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i3) {
        return audioTrack.write(byteBuffer, i3, 1);
    }

    public final int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i3, long j3) {
        if (this.f134961x == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.f134961x = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.f134961x.putInt(1431633921);
        }
        if (this.f134962y == 0) {
            this.f134961x.putInt(4, i3);
            this.f134961x.putLong(8, j3 * 1000);
            this.f134961x.position(0);
            this.f134962y = i3;
        }
        int remaining = this.f134961x.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.f134961x, remaining, 1);
            if (write < 0) {
                this.f134962y = 0;
                return write;
            }
            if (write < remaining) {
                return 0;
            }
        }
        int a16 = a(audioTrack, byteBuffer, i3);
        if (a16 < 0) {
            this.f134962y = 0;
            return a16;
        }
        this.f134962y -= a16;
        return a16;
    }

    public static void a(AudioTrack audioTrack, float f16) {
        audioTrack.setVolume(f16);
    }
}
