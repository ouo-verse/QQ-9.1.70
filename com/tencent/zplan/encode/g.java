package com.tencent.zplan.encode;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.zplan.encode.utils.MediaCodecEncodeType;
import com.tencent.zplan.encode.utils.d;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes38.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private int f385388a;

    /* renamed from: b, reason: collision with root package name */
    private String f385389b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.zplan.encode.f f385390c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.zplan.encode.encode.c f385391d;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.zplan.encode.encode.d f385393f;

    /* renamed from: h, reason: collision with root package name */
    private MediaFormat f385395h;

    /* renamed from: i, reason: collision with root package name */
    private MediaFormat f385396i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.zplan.encode.utils.c f385397j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f385398k;

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f385399l;

    /* renamed from: o, reason: collision with root package name */
    private final C10056g f385402o;

    /* renamed from: p, reason: collision with root package name */
    private int f385403p;

    /* renamed from: q, reason: collision with root package name */
    private ByteArrayOutputStream f385404q;

    /* renamed from: r, reason: collision with root package name */
    private int f385405r;

    /* renamed from: s, reason: collision with root package name */
    private com.tencent.zplan.encode.c f385406s;

    /* renamed from: t, reason: collision with root package name */
    private com.tencent.zplan.encode.b f385407t;

    /* renamed from: u, reason: collision with root package name */
    private com.tencent.zplan.encode.b f385408u;

    /* renamed from: e, reason: collision with root package name */
    private boolean f385392e = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f385394g = true;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f385400m = false;

    /* renamed from: n, reason: collision with root package name */
    private volatile boolean f385401n = false;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements com.tencent.zplan.encode.c {
        a() {
        }

        @Override // com.tencent.zplan.encode.c
        public void a(String str) {
            if (com.tencent.zplan.encode.d.f()) {
                com.tencent.zplan.encode.d.a("SR_MP4_Task", 1, "muxer listener, onRelease:" + str);
            }
            g.this.i(0);
        }

        @Override // com.tencent.zplan.encode.c
        public void onError(int i3, String str) {
            if (com.tencent.zplan.encode.d.f()) {
                com.tencent.zplan.encode.d.a("SR_MP4_Task", 1, "muxer listener, onError:" + i3 + ", " + str);
            }
            g.this.q(i3, 2);
        }

        @Override // com.tencent.zplan.encode.c
        public void onStart() {
            if (com.tencent.zplan.encode.d.f()) {
                com.tencent.zplan.encode.d.a("SR_MP4_Task", 1, "muxer listener, onStart");
            }
            g.this.f385402o.S = System.currentTimeMillis();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class b implements com.tencent.zplan.encode.b {
        b() {
        }

        @Override // com.tencent.zplan.encode.b
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            if (com.tencent.zplan.encode.d.f()) {
                com.tencent.zplan.encode.d.a("SR_MP4_Task", 1, "videoEncode listener, onEncodedByteOutput");
            }
            if (g.this.f385402o.f385439m == 0) {
                g.this.f385402o.f385439m = System.currentTimeMillis();
            }
            g.this.f385402o.H++;
            com.tencent.zplan.encode.f fVar = g.this.f385390c;
            if (fVar != null) {
                fVar.j(byteBuffer, bufferInfo);
            }
        }

        @Override // com.tencent.zplan.encode.b
        public void b(int i3) {
            if (com.tencent.zplan.encode.d.f()) {
                com.tencent.zplan.encode.d.a("SR_MP4_Task", 1, "videoEncode listener, onEncodeFinish:" + i3);
            }
            g.this.f385402o.F = System.currentTimeMillis();
            g.this.f385399l = true;
            g.this.s();
        }

        @Override // com.tencent.zplan.encode.b
        public void c(int i3, String str) {
            if (com.tencent.zplan.encode.d.f()) {
                com.tencent.zplan.encode.d.a("SR_MP4_Task", 1, "videoEncode listener, onEncodeError\uff1a" + i3 + ", " + str);
            }
            g.this.q(i3, 0);
        }

        @Override // com.tencent.zplan.encode.b
        public void d() {
            if (com.tencent.zplan.encode.d.f()) {
                com.tencent.zplan.encode.d.a("SR_MP4_Task", 1, "videoEncode listener, onEncodeCancel");
            }
        }

        @Override // com.tencent.zplan.encode.b
        public void e(MediaFormat mediaFormat, boolean z16) {
            if (com.tencent.zplan.encode.d.f()) {
                com.tencent.zplan.encode.d.a("SR_MP4_Task", 1, "videoEncode listener, onMediaFormatChange:" + mediaFormat.toString());
            }
            if (g.this.f385402o.C == 0) {
                g.this.f385402o.C = System.currentTimeMillis();
            }
            com.tencent.zplan.encode.f fVar = g.this.f385390c;
            if (fVar != null) {
                fVar.a(mediaFormat, z16);
            }
        }

        @Override // com.tencent.zplan.encode.b
        public void onEncodeStart() {
            if (com.tencent.zplan.encode.d.f()) {
                com.tencent.zplan.encode.d.a("SR_MP4_Task", 1, "videoEncode listener, onEncodeStart");
            }
            g.this.f385402o.f385437h = System.currentTimeMillis();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class c implements com.tencent.zplan.encode.b {
        c() {
        }

        @Override // com.tencent.zplan.encode.b
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            if (com.tencent.zplan.encode.d.f()) {
                com.tencent.zplan.encode.d.a("SR_MP4_Task", 1, "audioEncode listener, onEncodedByteOutput");
            }
            if (g.this.f385402o.K == 0) {
                g.this.f385402o.K = System.currentTimeMillis();
            }
            g.this.f385402o.R++;
            com.tencent.zplan.encode.f fVar = g.this.f385390c;
            if (fVar != null) {
                fVar.h(byteBuffer, bufferInfo);
            }
        }

        @Override // com.tencent.zplan.encode.b
        public void b(int i3) {
            if (com.tencent.zplan.encode.d.f()) {
                com.tencent.zplan.encode.d.a("SR_MP4_Task", 1, "audioEncode listener, onEncodeFinish:" + i3);
            }
            g.this.f385402o.P = System.currentTimeMillis();
            g.this.f385398k = true;
            g.this.s();
        }

        @Override // com.tencent.zplan.encode.b
        public void c(int i3, String str) {
            if (com.tencent.zplan.encode.d.f()) {
                com.tencent.zplan.encode.d.a("SR_MP4_Task", 1, "audioEncode listener, onEncodeError: " + i3 + ", " + str);
            }
            g.this.q(i3, 1);
        }

        @Override // com.tencent.zplan.encode.b
        public void d() {
            if (com.tencent.zplan.encode.d.f()) {
                com.tencent.zplan.encode.d.a("SR_MP4_Task", 1, "audioEncode listener, onEncodeCancel");
            }
        }

        @Override // com.tencent.zplan.encode.b
        public void e(MediaFormat mediaFormat, boolean z16) {
            if (com.tencent.zplan.encode.d.f()) {
                com.tencent.zplan.encode.d.a("SR_MP4_Task", 1, "audioEncode listener, onMediaFormatChange: " + mediaFormat.toString());
            }
            if (g.this.f385402o.L == 0) {
                g.this.f385402o.L = System.currentTimeMillis();
            }
            com.tencent.zplan.encode.f fVar = g.this.f385390c;
            if (fVar != null) {
                fVar.a(mediaFormat, z16);
            }
        }

        @Override // com.tencent.zplan.encode.b
        public void onEncodeStart() {
            if (com.tencent.zplan.encode.d.f()) {
                com.tencent.zplan.encode.d.a("SR_MP4_Task", 1, "audioEncode listener, onEncodeStart");
            }
            g.this.f385402o.I = System.currentTimeMillis();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int f385412a = -1;

        /* renamed from: b, reason: collision with root package name */
        public int f385413b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f385414c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f385415d = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f385416e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f385417f = -1;
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public String f385418a;

        /* renamed from: b, reason: collision with root package name */
        public String f385419b;

        /* renamed from: c, reason: collision with root package name */
        public f f385420c;

        /* renamed from: d, reason: collision with root package name */
        public d f385421d;
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public int f385422a = -1;

        /* renamed from: b, reason: collision with root package name */
        public int f385423b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f385424c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f385425d = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f385426e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f385427f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f385428g = -1;

        /* renamed from: h, reason: collision with root package name */
        public boolean f385429h = true;

        /* renamed from: i, reason: collision with root package name */
        public d.i f385430i;

        /* renamed from: j, reason: collision with root package name */
        public int f385431j;

        /* renamed from: k, reason: collision with root package name */
        public int f385432k;

        /* renamed from: l, reason: collision with root package name */
        public MediaCodecEncodeType f385433l;
    }

    public g(int i3, e eVar, com.tencent.zplan.encode.utils.c cVar) {
        C10056g c10056g = new C10056g();
        this.f385402o = c10056g;
        this.f385403p = 0;
        this.f385404q = null;
        this.f385405r = 0;
        this.f385406s = new a();
        this.f385407t = new b();
        this.f385408u = new c();
        c10056g.f385434d = System.currentTimeMillis();
        this.f385388a = i3;
        this.f385389b = eVar.f385418a;
        this.f385397j = cVar;
        if (n(eVar) && l(eVar)) {
            m();
            try {
                this.f385390c = new com.tencent.zplan.encode.f(eVar.f385418a, 0, this.f385406s, Boolean.valueOf(eVar.f385420c != null), Boolean.valueOf(eVar.f385421d != null));
            } catch (Throwable th5) {
                com.tencent.zplan.encode.d.c("SR_MP4_Task", 1, "create muxer err, ", th5);
                this.f385390c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i3) {
        if (this.f385401n) {
            return;
        }
        this.f385401n = true;
        this.f385402o.f385436f = System.currentTimeMillis();
        com.tencent.zplan.encode.utils.c cVar = this.f385397j;
        if (cVar != null) {
            cVar.a(this.f385388a, i3);
        }
    }

    private boolean l(e eVar) {
        d dVar = eVar.f385421d;
        if (dVar == null) {
            this.f385394g = false;
            return true;
        }
        this.f385403p = dVar.f385417f * dVar.f385412a * 2;
        this.f385404q = new ByteArrayOutputStream(this.f385403p);
        try {
            MediaCodec a16 = com.tencent.zplan.encode.e.c().b(dVar.f385414c).c(dVar.f385412a).e("audio/mp4a-latm").f(dVar.f385415d).g(dVar.f385413b).d(dVar.f385416e).a();
            if (a16 == null) {
                return false;
            }
            this.f385396i = a16.getInputFormat();
            com.tencent.zplan.encode.utils.a aVar = new com.tencent.zplan.encode.utils.a();
            aVar.f385463a = false;
            aVar.f385472j = dVar.f385413b;
            aVar.f385473k = dVar.f385417f;
            aVar.f385474l = dVar.f385412a;
            this.f385393f = new com.tencent.zplan.encode.encode.d(a16, aVar, this.f385408u, "");
            return true;
        } catch (Throwable th5) {
            com.tencent.zplan.encode.d.c("SR_MP4_Task", 1, "initAudioEncoder error, ", th5);
            return false;
        }
    }

    private boolean n(e eVar) {
        int i3;
        f fVar = eVar.f385420c;
        if (fVar == null) {
            this.f385392e = false;
            return true;
        }
        try {
            if (fVar.f385432k == 1) {
                i3 = (fVar.f385427f / 16) * 16 * 2;
            } else {
                i3 = (fVar.f385427f / 16) * 16;
            }
            int i16 = (fVar.f385428g / 16) * 16;
            MediaCodec a16 = com.tencent.zplan.encode.e.d().i("video/avc").e(fVar.f385422a).b(fVar.f385423b).c(fVar.f385424c).g(fVar.f385425d).j(i3).f(i16).h(fVar.f385426e).d(fVar.f385433l).a();
            if (a16 == null) {
                return false;
            }
            this.f385395h = a16.getInputFormat();
            com.tencent.zplan.encode.utils.a aVar = new com.tencent.zplan.encode.utils.a();
            aVar.f385463a = true;
            if (this.f385395h.containsKey("color-format")) {
                aVar.f385465c = this.f385395h.getInteger("color-format");
            }
            aVar.f385464b = fVar.f385429h;
            aVar.f385470h = fVar.f385422a;
            aVar.f385476n = fVar.f385432k;
            aVar.f385466d = fVar.f385427f;
            aVar.f385467e = fVar.f385428g;
            aVar.f385468f = i3;
            aVar.f385469g = i16;
            aVar.f385471i = fVar.f385430i;
            aVar.f385475m = fVar.f385431j;
            MediaCodecEncodeType mediaCodecEncodeType = fVar.f385433l;
            aVar.f385477o = mediaCodecEncodeType;
            if (mediaCodecEncodeType == MediaCodecEncodeType.BUFFER) {
                this.f385391d = new com.tencent.zplan.encode.encode.d(a16, aVar, this.f385407t, eVar.f385419b);
            } else {
                this.f385391d = new com.tencent.zplan.encode.encode.e(a16, aVar, this.f385407t, eVar.f385419b);
            }
            return true;
        } catch (Throwable th5) {
            com.tencent.zplan.encode.d.c("SR_MP4_Task", 1, "initVideoEncoder, error, ", th5);
            return false;
        }
    }

    private void p(int i3) {
        com.tencent.zplan.encode.utils.c cVar = this.f385397j;
        if (cVar != null) {
            cVar.a(this.f385388a, i3);
        }
    }

    private void r() {
        com.tencent.zplan.encode.f fVar = this.f385390c;
        if (fVar != null) {
            fVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (!this.f385392e || this.f385399l) {
            if (!this.f385394g || this.f385398k) {
                r();
            }
        }
    }

    public void h() {
        com.tencent.zplan.encode.encode.d dVar;
        C10056g c10056g = this.f385402o;
        if (c10056g.N == 0) {
            c10056g.N = System.currentTimeMillis();
        }
        if (this.f385400m || (dVar = this.f385393f) == null) {
            return;
        }
        dVar.y();
    }

    public C10056g j() {
        return new C10056g(this.f385402o);
    }

    public String k() {
        return this.f385389b;
    }

    public void o(byte[] bArr, int i3, int i16) {
        com.tencent.zplan.encode.encode.c cVar;
        C10056g c10056g = this.f385402o;
        if (c10056g.f385438i == 0) {
            c10056g.f385438i = System.currentTimeMillis();
        }
        C10056g c10056g2 = this.f385402o;
        c10056g2.G++;
        c10056g2.D = i16;
        if (this.f385400m || (cVar = this.f385391d) == null) {
            return;
        }
        cVar.z(bArr, i3, i16);
    }

    public void t() {
        this.f385402o.f385435e = System.currentTimeMillis();
        if (this.f385400m) {
            return;
        }
        com.tencent.zplan.encode.encode.c cVar = this.f385391d;
        com.tencent.zplan.encode.encode.d dVar = this.f385393f;
        com.tencent.zplan.encode.f fVar = this.f385390c;
        if (this.f385392e && cVar == null) {
            p(-1202);
            return;
        }
        if (this.f385394g && dVar == null) {
            p(-1203);
            return;
        }
        if (fVar == null) {
            p(-1201);
            return;
        }
        fVar.g();
        if (this.f385392e) {
            cVar.D();
        }
        if (this.f385394g) {
            dVar.D();
        }
    }

    public void u() {
        com.tencent.zplan.encode.encode.c cVar;
        C10056g c10056g = this.f385402o;
        if (c10056g.E == 0) {
            c10056g.E = System.currentTimeMillis();
        }
        if (this.f385400m || (cVar = this.f385391d) == null) {
            return;
        }
        cVar.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i3, int i16) {
        com.tencent.zplan.encode.f fVar;
        com.tencent.zplan.encode.encode.c cVar;
        com.tencent.zplan.encode.encode.d dVar;
        this.f385400m = true;
        if (i16 != 1 && (dVar = this.f385393f) != null) {
            dVar.v();
        }
        if (i16 != 0 && (cVar = this.f385391d) != null) {
            cVar.v();
        }
        if (i16 != 2 && (fVar = this.f385390c) != null) {
            fVar.c();
        }
        i(i3);
    }

    private void m() {
    }

    /* compiled from: P */
    /* renamed from: com.tencent.zplan.encode.g$g, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static class C10056g implements Cloneable {
        public long C;
        public long D;
        public long E;
        public long F;
        public long G;
        public long H;
        public long I;
        public long J;
        public long K;
        public long L;
        public long M;
        public long N;
        public long P;
        public long Q;
        public long R;
        public long S;

        /* renamed from: d, reason: collision with root package name */
        public long f385434d;

        /* renamed from: e, reason: collision with root package name */
        public long f385435e;

        /* renamed from: f, reason: collision with root package name */
        public long f385436f;

        /* renamed from: h, reason: collision with root package name */
        public long f385437h;

        /* renamed from: i, reason: collision with root package name */
        public long f385438i;

        /* renamed from: m, reason: collision with root package name */
        public long f385439m;

        public C10056g() {
            this.f385434d = 0L;
            this.f385435e = 0L;
            this.f385436f = 0L;
            this.f385437h = 0L;
            this.f385438i = 0L;
            this.f385439m = 0L;
            this.C = 0L;
            this.D = 0L;
            this.E = 0L;
            this.F = 0L;
            this.G = 0L;
            this.H = 0L;
            this.I = 0L;
            this.J = 0L;
            this.K = 0L;
            this.L = 0L;
            this.M = 0L;
            this.N = 0L;
            this.P = 0L;
            this.Q = 0L;
            this.R = 0L;
            this.S = 0L;
        }

        public String toString() {
            return "ReportInfo{taskTotalTime=" + (this.f385436f - this.f385435e) + ", taskCreateTime=" + this.f385434d + ", taskStartTime=" + this.f385435e + ", taskEndTime=" + this.f385436f + ", videoEncodeStartTime=" + this.f385437h + ", videoFirstQueueDataTime=" + this.f385438i + ", videoFirstEncodOutputTime=" + this.f385439m + ", videoFirstFormatChangeTime=" + this.C + ", videoFinalQueuePts=" + this.D + ", videoQueueDataCompleteTime=" + this.E + ", videoEncodeFinishTime=" + this.F + ", videoEncodeQueueDataTimes=" + this.G + ", videoEncodeOutputTimes=" + this.H + ", audioEncodeStartTime=" + this.I + ", audioFirstQueueDataTime=" + this.J + ", audioFirstEncodOutputTime=" + this.K + ", audioFirstFormatChangeTime=" + this.L + ", audioFinalQueuePts=" + this.M + ", audioQueueDataCompleteTime=" + this.N + ", audioEncodeFinishTime=" + this.P + ", audioEncodeQueueDataTimes=" + this.Q + ", audioEncodeOutputTimes=" + this.R + ", muxerStartTime=" + this.S + '}';
        }

        public C10056g(C10056g c10056g) {
            this.f385434d = 0L;
            this.f385435e = 0L;
            this.f385436f = 0L;
            this.f385437h = 0L;
            this.f385438i = 0L;
            this.f385439m = 0L;
            this.C = 0L;
            this.D = 0L;
            this.E = 0L;
            this.F = 0L;
            this.G = 0L;
            this.H = 0L;
            this.I = 0L;
            this.J = 0L;
            this.K = 0L;
            this.L = 0L;
            this.M = 0L;
            this.N = 0L;
            this.P = 0L;
            this.Q = 0L;
            this.R = 0L;
            this.S = 0L;
            this.f385434d = c10056g.f385434d;
            this.f385435e = c10056g.f385435e;
            this.f385436f = c10056g.f385436f;
            this.f385437h = c10056g.f385437h;
            this.f385438i = c10056g.f385438i;
            this.f385439m = c10056g.f385439m;
            this.C = c10056g.C;
            this.D = c10056g.D;
            this.E = c10056g.E;
            this.F = c10056g.F;
            this.G = c10056g.G;
            this.H = c10056g.H;
            this.I = c10056g.I;
            this.J = c10056g.J;
            this.K = c10056g.K;
            this.L = c10056g.L;
            this.M = c10056g.M;
            this.N = c10056g.N;
            this.P = c10056g.P;
            this.Q = c10056g.N;
            this.R = c10056g.R;
            this.S = c10056g.S;
        }
    }
}
