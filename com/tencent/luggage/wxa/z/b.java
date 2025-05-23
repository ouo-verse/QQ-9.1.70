package com.tencent.luggage.wxa.z;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import com.tencent.luggage.wxa.m.j;
import com.tencent.luggage.wxa.m.k;
import com.tencent.luggage.wxa.n0.t;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.luggage.wxa.z.d;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class b extends com.tencent.luggage.wxa.m.a {

    /* renamed from: g0, reason: collision with root package name */
    public static final byte[] f146146g0 = v.a("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    public final List C;
    public final MediaCodec.BufferInfo D;
    public j E;
    public MediaCodec F;
    public com.tencent.luggage.wxa.z.a G;
    public int H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public ByteBuffer[] Q;
    public ByteBuffer[] R;
    public long S;
    public int T;
    public int U;
    public boolean V;
    public boolean W;
    public int X;
    public int Y;
    public boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f146147a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f146148b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f146149c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f146150d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f146151e0;

    /* renamed from: f0, reason: collision with root package name */
    public com.tencent.luggage.wxa.o.c f146152f0;

    /* renamed from: i, reason: collision with root package name */
    public final c f146153i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f146154j;

    /* renamed from: k, reason: collision with root package name */
    public final com.tencent.luggage.wxa.o.d f146155k;

    /* renamed from: l, reason: collision with root package name */
    public final com.tencent.luggage.wxa.o.d f146156l;

    /* renamed from: m, reason: collision with root package name */
    public final k f146157m;

    public b(int i3, c cVar, com.tencent.luggage.wxa.p.b bVar, boolean z16) {
        super(i3);
        boolean z17;
        if (v.f135103a >= 16) {
            z17 = true;
        } else {
            z17 = false;
        }
        com.tencent.luggage.wxa.n0.a.b(z17);
        this.f146153i = (c) com.tencent.luggage.wxa.n0.a.a(cVar);
        this.f146154j = z16;
        this.f146155k = new com.tencent.luggage.wxa.o.d(0);
        this.f146156l = com.tencent.luggage.wxa.o.d.h();
        this.f146157m = new k();
        this.C = new ArrayList();
        this.D = new MediaCodec.BufferInfo();
        this.X = 0;
        this.Y = 0;
    }

    public static boolean e(String str) {
        int i3 = v.f135103a;
        if (i3 >= 18 && ((i3 != 18 || (!"OMX.SEC.avc.dec".equals(str) && !"OMX.SEC.avc.dec.secure".equals(str))) && (i3 != 19 || !v.f135106d.startsWith("SM-G800") || (!"OMX.Exynos.avc.dec".equals(str) && !"OMX.Exynos.avc.dec.secure".equals(str))))) {
            return false;
        }
        return true;
    }

    public final void A() {
        this.R = this.F.getOutputBuffers();
    }

    public final void B() {
        MediaFormat outputFormat = this.F.getOutputFormat();
        if (this.H != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.P = true;
            return;
        }
        if (this.N) {
            outputFormat.setInteger("channel-count", 1);
        }
        a(this.F, outputFormat);
    }

    public void C() {
        this.S = -9223372036854775807L;
        this.T = -1;
        this.U = -1;
        this.f146150d0 = false;
        this.V = false;
        this.C.clear();
        this.Q = null;
        this.R = null;
        this.G = null;
        this.W = false;
        this.Z = false;
        this.I = false;
        this.J = false;
        this.H = 0;
        this.K = false;
        this.L = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.f146147a0 = false;
        this.X = 0;
        this.Y = 0;
        this.f146155k.f135956c = null;
        MediaCodec mediaCodec = this.F;
        if (mediaCodec != null) {
            this.f146152f0.f135949b++;
            try {
                mediaCodec.stop();
                try {
                    this.F.release();
                } finally {
                }
            } catch (Throwable th5) {
                try {
                    this.F.release();
                    throw th5;
                } finally {
                }
            }
        }
    }

    public abstract int a(c cVar, j jVar);

    public abstract void a(MediaCodec mediaCodec, MediaFormat mediaFormat);

    public void a(com.tencent.luggage.wxa.o.d dVar) {
    }

    public abstract void a(com.tencent.luggage.wxa.z.a aVar, MediaCodec mediaCodec, j jVar, MediaCrypto mediaCrypto);

    public abstract void a(String str, long j3, long j16);

    public abstract boolean a(long j3, long j16, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i3, int i16, long j17, boolean z16);

    public final boolean b(boolean z16) {
        return false;
    }

    public void c(long j3) {
    }

    public final boolean d(long j3) {
        int size = this.C.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((Long) this.C.get(i3)).longValue() == j3) {
                this.C.remove(i3);
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.m.r
    public boolean isReady() {
        if (this.E != null && !this.f146150d0 && (p() || this.U >= 0 || (this.S != -9223372036854775807L && SystemClock.elapsedRealtime() < this.S))) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.m.s
    public final int k() {
        return 8;
    }

    @Override // com.tencent.luggage.wxa.m.a
    public void q() {
        this.E = null;
        C();
    }

    public final boolean t() {
        int position;
        int a16;
        MediaCodec mediaCodec = this.F;
        if (mediaCodec == null || this.Y == 2 || this.f146148b0) {
            return false;
        }
        if (this.T < 0) {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L);
            this.T = dequeueInputBuffer;
            if (dequeueInputBuffer < 0) {
                return false;
            }
            com.tencent.luggage.wxa.o.d dVar = this.f146155k;
            dVar.f135956c = this.Q[dequeueInputBuffer];
            dVar.a();
        }
        if (this.Y == 1) {
            if (!this.K) {
                this.f146147a0 = true;
                this.F.queueInputBuffer(this.T, 0, 0, 0L, 4);
                this.T = -1;
            }
            this.Y = 2;
            return false;
        }
        if (this.O) {
            this.O = false;
            ByteBuffer byteBuffer = this.f146155k.f135956c;
            byte[] bArr = f146146g0;
            byteBuffer.put(bArr);
            this.F.queueInputBuffer(this.T, 0, bArr.length, 0L, 0);
            this.T = -1;
            this.Z = true;
            return true;
        }
        if (this.f146150d0) {
            a16 = -4;
            position = 0;
        } else {
            if (this.X == 1) {
                for (int i3 = 0; i3 < this.E.f133898h.size(); i3++) {
                    this.f146155k.f135956c.put((byte[]) this.E.f133898h.get(i3));
                }
                this.X = 2;
            }
            position = this.f146155k.f135956c.position();
            a16 = a(this.f146157m, this.f146155k, false);
        }
        if (a16 == -3) {
            return false;
        }
        if (a16 == -5) {
            if (this.X == 2) {
                this.f146155k.a();
                this.X = 1;
            }
            b(this.f146157m.f133904a);
            return true;
        }
        if (this.f146155k.c()) {
            if (this.X == 2) {
                this.f146155k.a();
                this.X = 1;
            }
            this.f146148b0 = true;
            if (!this.Z) {
                z();
                return false;
            }
            try {
                if (!this.K) {
                    this.f146147a0 = true;
                    this.F.queueInputBuffer(this.T, 0, 0, 0L, 4);
                    this.T = -1;
                }
                return false;
            } catch (MediaCodec.CryptoException e16) {
                throw com.tencent.luggage.wxa.m.d.a(e16, o());
            }
        }
        if (this.f146151e0 && !this.f146155k.d()) {
            this.f146155k.a();
            if (this.X == 2) {
                this.X = 1;
            }
            return true;
        }
        this.f146151e0 = false;
        boolean f16 = this.f146155k.f();
        boolean b16 = b(f16);
        this.f146150d0 = b16;
        if (b16) {
            return false;
        }
        if (this.I && !f16) {
            com.tencent.luggage.wxa.n0.j.a(this.f146155k.f135956c);
            if (this.f146155k.f135956c.position() == 0) {
                return true;
            }
            this.I = false;
        }
        try {
            com.tencent.luggage.wxa.o.d dVar2 = this.f146155k;
            long j3 = dVar2.f135957d;
            if (dVar2.b()) {
                this.C.add(Long.valueOf(j3));
            }
            this.f146155k.e();
            a(this.f146155k);
            if (f16) {
                this.F.queueSecureInputBuffer(this.T, 0, a(this.f146155k, position), j3, 0);
            } else {
                this.F.queueInputBuffer(this.T, 0, this.f146155k.f135956c.limit(), j3, 0);
            }
            this.T = -1;
            this.Z = true;
            this.X = 0;
            this.f146152f0.f135950c++;
            return true;
        } catch (MediaCodec.CryptoException e17) {
            throw com.tencent.luggage.wxa.m.d.a(e17, o());
        }
    }

    public void u() {
        this.S = -9223372036854775807L;
        this.T = -1;
        this.U = -1;
        this.f146151e0 = true;
        this.f146150d0 = false;
        this.V = false;
        this.C.clear();
        this.O = false;
        this.P = false;
        if (!this.J && (!this.L || !this.f146147a0)) {
            if (this.Y != 0) {
                C();
                y();
            } else {
                this.F.flush();
                this.Z = false;
            }
        } else {
            C();
            y();
        }
        if (this.W && this.E != null) {
            this.X = 1;
        }
    }

    public final MediaCodec v() {
        return this.F;
    }

    public final com.tencent.luggage.wxa.z.a w() {
        return this.G;
    }

    public long x() {
        return 0L;
    }

    public final void y() {
        j jVar;
        long j3;
        if (this.F == null && (jVar = this.E) != null) {
            if (this.G == null) {
                try {
                    this.G = a(this.f146153i, jVar, false);
                } catch (d.c e16) {
                    a(new a(this.E, (Throwable) e16, false, -49998));
                }
                if (this.G == null) {
                    a(new a(this.E, (Throwable) null, false, -49999));
                }
            }
            if (!a(this.G)) {
                return;
            }
            String str = this.G.f146140a;
            this.H = a(str);
            this.I = a(str, this.E);
            this.J = e(str);
            this.K = d(str);
            this.L = b(str);
            this.M = c(str);
            this.N = b(str, this.E);
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                t.a("createCodec:" + str);
                this.F = MediaCodec.createByCodecName(str);
                t.a();
                t.a("configureCodec");
                a(this.G, this.F, this.E, (MediaCrypto) null);
                t.a();
                t.a("startCodec");
                this.F.start();
                t.a();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                a(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.Q = this.F.getInputBuffers();
                this.R = this.F.getOutputBuffers();
            } catch (Exception e17) {
                a(new a(this.E, (Throwable) e17, false, str));
            }
            if (getState() == 2) {
                j3 = SystemClock.elapsedRealtime() + 1000;
            } else {
                j3 = -9223372036854775807L;
            }
            this.S = j3;
            this.T = -1;
            this.U = -1;
            this.f146151e0 = true;
            this.f146152f0.f135948a++;
        }
    }

    public final void z() {
        if (this.Y == 2) {
            C();
            y();
        } else {
            this.f146149c0 = true;
            D();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public final String f146158a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f146159b;

        /* renamed from: c, reason: collision with root package name */
        public final String f146160c;

        /* renamed from: d, reason: collision with root package name */
        public final String f146161d;

        public a(j jVar, Throwable th5, boolean z16, int i3) {
            super("Decoder init failed: [" + i3 + "], " + jVar, th5);
            this.f146158a = jVar.f133896f;
            this.f146159b = z16;
            this.f146160c = null;
            this.f146161d = a(i3);
        }

        public static String a(Throwable th5) {
            if (th5 instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th5).getDiagnosticInfo();
            }
            return null;
        }

        public static String a(int i3) {
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i3 < 0 ? "neg_" : "") + Math.abs(i3);
        }

        public a(j jVar, Throwable th5, boolean z16, String str) {
            super("Decoder init failed: " + str + ", " + jVar, th5);
            this.f146158a = jVar.f133896f;
            this.f146159b = z16;
            this.f146160c = str;
            this.f146161d = v.f135103a >= 21 ? a(th5) : null;
        }
    }

    public static boolean c(String str) {
        return v.f135103a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    public boolean a(MediaCodec mediaCodec, boolean z16, j jVar, j jVar2) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
    
        if (r5.f133901k == r0.f133901k) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(j jVar) {
        j jVar2 = this.E;
        this.E = jVar;
        boolean z16 = true;
        if ((!v.a(jVar.f133899i, jVar2 == null ? null : jVar2.f133899i)) && this.E.f133899i != null) {
            throw com.tencent.luggage.wxa.m.d.a(new IllegalStateException("Media requires a DrmSessionManager"), o());
        }
        MediaCodec mediaCodec = this.F;
        if (mediaCodec != null && a(mediaCodec, this.G.f146141b, jVar2, this.E)) {
            this.W = true;
            this.X = 1;
            int i3 = this.H;
            if (i3 != 2) {
                if (i3 == 1) {
                    j jVar3 = this.E;
                    if (jVar3.f133900j == jVar2.f133900j) {
                    }
                }
                z16 = false;
            }
            this.O = z16;
            return;
        }
        if (this.Z) {
            this.Y = 1;
        } else {
            C();
            y();
        }
    }

    public boolean a(com.tencent.luggage.wxa.z.a aVar) {
        return true;
    }

    public static boolean d(String str) {
        return v.f135103a <= 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str));
    }

    @Override // com.tencent.luggage.wxa.m.s
    public final int a(j jVar) {
        try {
            int a16 = a(this.f146153i, jVar);
            return (a16 & 7) > 2 ? !a((com.tencent.luggage.wxa.p.b) null, jVar.f133899i) ? (a16 & (-8)) | 2 : a16 : a16;
        } catch (d.c e16) {
            throw com.tencent.luggage.wxa.m.d.a(e16, o());
        }
    }

    public com.tencent.luggage.wxa.z.a a(c cVar, j jVar, boolean z16) {
        return cVar.a(jVar.f133896f, z16);
    }

    public final void a(a aVar) {
        throw com.tencent.luggage.wxa.m.d.a(aVar, o());
    }

    @Override // com.tencent.luggage.wxa.m.a
    public void a(boolean z16) {
        this.f146152f0 = new com.tencent.luggage.wxa.o.c();
    }

    @Override // com.tencent.luggage.wxa.m.a
    public void a(long j3, boolean z16) {
        this.f146148b0 = false;
        this.f146149c0 = false;
        if (this.F != null) {
            u();
        }
    }

    @Override // com.tencent.luggage.wxa.m.r
    public void a(long j3, long j16) {
        if (this.f146149c0) {
            D();
            return;
        }
        if (this.E == null) {
            this.f146156l.a();
            int a16 = a(this.f146157m, this.f146156l, true);
            if (a16 != -5) {
                if (a16 == -4) {
                    com.tencent.luggage.wxa.n0.a.b(this.f146156l.c());
                    this.f146148b0 = true;
                    z();
                    return;
                }
                return;
            }
            b(this.f146157m.f133904a);
        }
        y();
        if (this.F != null) {
            t.a("drainAndFeed");
            do {
            } while (b(j3, j16));
            do {
            } while (t());
            t.a();
        } else {
            b(j3);
            this.f146156l.a();
            int a17 = a(this.f146157m, this.f146156l, false);
            if (a17 == -5) {
                b(this.f146157m.f133904a);
            } else if (a17 == -4) {
                com.tencent.luggage.wxa.n0.a.b(this.f146156l.c());
                this.f146148b0 = true;
                z();
            }
        }
        this.f146152f0.a();
    }

    @Override // com.tencent.luggage.wxa.m.r
    public boolean b() {
        return this.f146149c0;
    }

    public final boolean b(long j3, long j16) {
        boolean a16;
        if (this.U < 0) {
            if (this.M && this.f146147a0) {
                try {
                    this.U = this.F.dequeueOutputBuffer(this.D, x());
                } catch (IllegalStateException unused) {
                    z();
                    if (this.f146149c0) {
                        C();
                    }
                    return false;
                }
            } else {
                this.U = this.F.dequeueOutputBuffer(this.D, x());
            }
            int i3 = this.U;
            if (i3 < 0) {
                if (i3 == -2) {
                    B();
                    return true;
                }
                if (i3 == -3) {
                    A();
                    return true;
                }
                if (this.K && (this.f146148b0 || this.Y == 2)) {
                    z();
                }
                return false;
            }
            if (this.P) {
                this.P = false;
                this.F.releaseOutputBuffer(i3, false);
                this.U = -1;
                return true;
            }
            MediaCodec.BufferInfo bufferInfo = this.D;
            if ((bufferInfo.flags & 4) != 0) {
                z();
                this.U = -1;
                return false;
            }
            ByteBuffer byteBuffer = this.R[i3];
            if (byteBuffer != null) {
                byteBuffer.position(bufferInfo.offset);
                MediaCodec.BufferInfo bufferInfo2 = this.D;
                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
            }
            this.V = d(this.D.presentationTimeUs);
        }
        if (this.M && this.f146147a0) {
            try {
                MediaCodec mediaCodec = this.F;
                ByteBuffer[] byteBufferArr = this.R;
                int i16 = this.U;
                ByteBuffer byteBuffer2 = byteBufferArr[i16];
                MediaCodec.BufferInfo bufferInfo3 = this.D;
                a16 = a(j3, j16, mediaCodec, byteBuffer2, i16, bufferInfo3.flags, bufferInfo3.presentationTimeUs, this.V);
            } catch (IllegalStateException unused2) {
                z();
                if (this.f146149c0) {
                    C();
                }
                return false;
            }
        } else {
            MediaCodec mediaCodec2 = this.F;
            ByteBuffer[] byteBufferArr2 = this.R;
            int i17 = this.U;
            ByteBuffer byteBuffer3 = byteBufferArr2[i17];
            MediaCodec.BufferInfo bufferInfo4 = this.D;
            a16 = a(j3, j16, mediaCodec2, byteBuffer3, i17, bufferInfo4.flags, bufferInfo4.presentationTimeUs, this.V);
        }
        if (!a16) {
            return false;
        }
        c(this.D.presentationTimeUs);
        this.U = -1;
        return true;
    }

    public void D() {
    }

    @Override // com.tencent.luggage.wxa.m.a
    public void r() {
    }

    @Override // com.tencent.luggage.wxa.m.a
    public void s() {
    }

    public static MediaCodec.CryptoInfo a(com.tencent.luggage.wxa.o.d dVar, int i3) {
        MediaCodec.CryptoInfo a16 = dVar.f135955b.a();
        if (i3 == 0) {
            return a16;
        }
        if (a16.numBytesOfClearData == null) {
            a16.numBytesOfClearData = new int[1];
        }
        int[] iArr = a16.numBytesOfClearData;
        iArr[0] = iArr[0] + i3;
        return a16;
    }

    public static boolean a(com.tencent.luggage.wxa.p.b bVar, com.tencent.luggage.wxa.p.a aVar) {
        if (aVar == null) {
            return true;
        }
        if (bVar == null) {
            return false;
        }
        return bVar.a(aVar);
    }

    public final int a(String str) {
        int i3 = v.f135103a;
        if (i3 <= 24 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = v.f135106d;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A520")) {
                return 2;
            }
        }
        if (i3 >= 24) {
            return 0;
        }
        if (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) {
            return 0;
        }
        String str3 = v.f135104b;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    public static boolean a(String str, j jVar) {
        return v.f135103a < 21 && jVar.f133898h.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    public static boolean b(String str) {
        int i3 = v.f135103a;
        return (i3 <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (i3 <= 19 && "hb2000".equals(v.f135104b) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str)));
    }

    public static boolean b(String str, j jVar) {
        return v.f135103a <= 18 && jVar.G == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }
}
