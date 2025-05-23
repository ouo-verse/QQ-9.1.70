package com.tencent.mobileqq.zplan.meme.mp4;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.mobileqq.zplan.meme.mp4.Mp4MediaEncoder;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes34.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private int f334129a;

    /* renamed from: b, reason: collision with root package name */
    private String f334130b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.mobileqq.zplan.meme.mp4.e f334131c;

    /* renamed from: d, reason: collision with root package name */
    private Mp4MediaEncoder f334132d;

    /* renamed from: e, reason: collision with root package name */
    private Mp4MediaEncoder f334133e;

    /* renamed from: f, reason: collision with root package name */
    private MediaFormat f334134f;

    /* renamed from: g, reason: collision with root package name */
    private MediaFormat f334135g;

    /* renamed from: h, reason: collision with root package name */
    private d f334136h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f334137i;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f334138j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f334139k = false;

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f334140l = false;

    /* renamed from: m, reason: collision with root package name */
    private final C9184f f334141m;

    /* renamed from: n, reason: collision with root package name */
    private int f334142n;

    /* renamed from: o, reason: collision with root package name */
    private ByteArrayOutputStream f334143o;

    /* renamed from: p, reason: collision with root package name */
    private int f334144p;

    /* renamed from: q, reason: collision with root package name */
    private com.tencent.mobileqq.zplan.meme.mp4.b f334145q;

    /* renamed from: r, reason: collision with root package name */
    private com.tencent.mobileqq.zplan.meme.mp4.a f334146r;

    /* renamed from: s, reason: collision with root package name */
    private com.tencent.mobileqq.zplan.meme.mp4.a f334147s;

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements com.tencent.mobileqq.zplan.meme.mp4.b {
        a() {
        }

        @Override // com.tencent.mobileqq.zplan.meme.mp4.b
        public void a(String str) {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Task", 1, "muxer listener, onRelease:" + str);
            }
            f.this.i(0);
        }

        @Override // com.tencent.mobileqq.zplan.meme.mp4.b
        public void onError(int i3, String str) {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Task", 1, "muxer listener, onError:" + i3 + ", " + str);
            }
            f.this.r(i3, 2);
        }

        @Override // com.tencent.mobileqq.zplan.meme.mp4.b
        public void onStart() {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Task", 1, "muxer listener, onStart");
            }
            f.this.f334141m.S = System.currentTimeMillis();
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class b implements com.tencent.mobileqq.zplan.meme.mp4.a {
        b() {
        }

        @Override // com.tencent.mobileqq.zplan.meme.mp4.a
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Task", 1, "videoEncode listener, onEncodedByteOutput");
            }
            if (f.this.f334141m.f334169m == 0) {
                f.this.f334141m.f334169m = System.currentTimeMillis();
            }
            f.this.f334141m.H++;
            com.tencent.mobileqq.zplan.meme.mp4.e eVar = f.this.f334131c;
            if (eVar != null) {
                eVar.j(byteBuffer, bufferInfo);
            }
        }

        @Override // com.tencent.mobileqq.zplan.meme.mp4.a
        public void b(int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Task", 1, "videoEncode listener, onEncodeFinish:" + i3);
            }
            f.this.f334141m.F = System.currentTimeMillis();
            f.this.f334138j = true;
            f.this.t();
        }

        @Override // com.tencent.mobileqq.zplan.meme.mp4.a
        public void c(int i3, String str) {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Task", 1, "videoEncode listener, onEncodeError\uff1a" + i3 + ", " + str);
            }
            f.this.r(i3, 0);
        }

        @Override // com.tencent.mobileqq.zplan.meme.mp4.a
        public void d() {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Task", 1, "videoEncode listener, onEncodeCancel");
            }
        }

        @Override // com.tencent.mobileqq.zplan.meme.mp4.a
        public void e(MediaFormat mediaFormat, boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Task", 1, "videoEncode listener, onMediaFormatChange:" + mediaFormat.toString());
            }
            if (f.this.f334141m.C == 0) {
                f.this.f334141m.C = System.currentTimeMillis();
            }
            com.tencent.mobileqq.zplan.meme.mp4.e eVar = f.this.f334131c;
            if (eVar != null) {
                eVar.a(mediaFormat, z16);
            }
        }

        @Override // com.tencent.mobileqq.zplan.meme.mp4.a
        public void onEncodeStart() {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Task", 1, "videoEncode listener, onEncodeStart");
            }
            f.this.f334141m.f334167h = System.currentTimeMillis();
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class c implements com.tencent.mobileqq.zplan.meme.mp4.a {
        c() {
        }

        @Override // com.tencent.mobileqq.zplan.meme.mp4.a
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Task", 1, "audioEncode listener, onEncodedByteOutput");
            }
            if (f.this.f334141m.K == 0) {
                f.this.f334141m.K = System.currentTimeMillis();
            }
            f.this.f334141m.R++;
            com.tencent.mobileqq.zplan.meme.mp4.e eVar = f.this.f334131c;
            if (eVar != null) {
                eVar.h(byteBuffer, bufferInfo);
            }
        }

        @Override // com.tencent.mobileqq.zplan.meme.mp4.a
        public void b(int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Task", 1, "audioEncode listener, onEncodeFinish:" + i3);
            }
            f.this.f334141m.P = System.currentTimeMillis();
            f.this.f334137i = true;
            f.this.t();
        }

        @Override // com.tencent.mobileqq.zplan.meme.mp4.a
        public void c(int i3, String str) {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Task", 1, "audioEncode listener, onEncodeError: " + i3 + ", " + str);
            }
            f.this.r(i3, 1);
        }

        @Override // com.tencent.mobileqq.zplan.meme.mp4.a
        public void d() {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Task", 1, "audioEncode listener, onEncodeCancel");
            }
        }

        @Override // com.tencent.mobileqq.zplan.meme.mp4.a
        public void e(MediaFormat mediaFormat, boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Task", 1, "audioEncode listener, onMediaFormatChange: " + mediaFormat.toString());
            }
            if (f.this.f334141m.L == 0) {
                f.this.f334141m.L = System.currentTimeMillis();
            }
            com.tencent.mobileqq.zplan.meme.mp4.e eVar = f.this.f334131c;
            if (eVar != null) {
                eVar.a(mediaFormat, z16);
            }
        }

        @Override // com.tencent.mobileqq.zplan.meme.mp4.a
        public void onEncodeStart() {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Task", 1, "audioEncode listener, onEncodeStart");
            }
            f.this.f334141m.I = System.currentTimeMillis();
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public interface d {
        void a(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public String f334151a;

        /* renamed from: b, reason: collision with root package name */
        public int f334152b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f334153c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f334154d = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f334155e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f334156f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f334157g = -1;

        /* renamed from: h, reason: collision with root package name */
        public int f334158h = -1;

        /* renamed from: i, reason: collision with root package name */
        public int f334159i = -1;

        /* renamed from: j, reason: collision with root package name */
        public int f334160j = -1;

        /* renamed from: k, reason: collision with root package name */
        public int f334161k = -1;

        /* renamed from: l, reason: collision with root package name */
        public int f334162l = -1;

        /* renamed from: m, reason: collision with root package name */
        public int f334163m = -1;
    }

    public f(int i3, e eVar, d dVar) {
        C9184f c9184f = new C9184f();
        this.f334141m = c9184f;
        this.f334142n = 0;
        this.f334143o = null;
        this.f334144p = 0;
        this.f334145q = new a();
        this.f334146r = new b();
        this.f334147s = new c();
        c9184f.f334164d = System.currentTimeMillis();
        this.f334129a = i3;
        this.f334130b = eVar.f334151a;
        this.f334136h = dVar;
        if (n(eVar) && l(eVar)) {
            m();
            try {
                this.f334131c = new com.tencent.mobileqq.zplan.meme.mp4.e(eVar.f334151a, 0, this.f334145q);
            } catch (Throwable th5) {
                QLog.e("SR_MP4_Task", 1, "create muxer err, ", th5);
                this.f334131c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i3) {
        if (this.f334140l) {
            return;
        }
        this.f334140l = true;
        this.f334141m.f334166f = System.currentTimeMillis();
        d dVar = this.f334136h;
        if (dVar != null) {
            dVar.a(this.f334129a, i3);
        }
    }

    private boolean l(e eVar) {
        this.f334142n = eVar.f334163m * eVar.f334158h * 2;
        this.f334143o = new ByteArrayOutputStream(this.f334142n);
        try {
            MediaCodec a16 = com.tencent.mobileqq.zplan.meme.mp4.c.c().b(eVar.f334160j).c(eVar.f334158h).e("audio/mp4a-latm").f(eVar.f334161k).g(eVar.f334159i).d(eVar.f334162l).a();
            if (a16 == null) {
                return false;
            }
            this.f334135g = a16.getInputFormat();
            Mp4MediaEncoder.b bVar = new Mp4MediaEncoder.b();
            bVar.f334089a = false;
            bVar.f334097i = eVar.f334159i;
            bVar.f334098j = eVar.f334163m;
            bVar.f334099k = eVar.f334158h;
            this.f334133e = new Mp4MediaEncoder(a16, bVar, this.f334147s);
            return true;
        } catch (Throwable th5) {
            QLog.e("SR_MP4_Task", 1, "initAudioEncoder error, ", th5);
            return false;
        }
    }

    private boolean n(e eVar) {
        try {
            int i3 = (eVar.f334156f / 16) * 16;
            int i16 = (eVar.f334157g / 16) * 16;
            MediaCodec a16 = com.tencent.mobileqq.zplan.meme.mp4.c.d().g("video/avc").c(eVar.f334152b).b(eVar.f334153c).e(eVar.f334154d).h(i3).d(i16).f(eVar.f334155e).a();
            if (a16 == null) {
                return false;
            }
            this.f334134f = a16.getInputFormat();
            Mp4MediaEncoder.b bVar = new Mp4MediaEncoder.b();
            bVar.f334089a = true;
            if (this.f334134f.containsKey("color-format")) {
                bVar.f334091c = this.f334134f.getInteger("color-format");
            }
            bVar.f334090b = true;
            bVar.f334096h = eVar.f334152b;
            bVar.f334092d = eVar.f334156f;
            bVar.f334093e = eVar.f334157g;
            bVar.f334094f = i3;
            bVar.f334095g = i16;
            this.f334132d = new Mp4MediaEncoder(a16, bVar, this.f334146r);
            return true;
        } catch (Throwable th5) {
            QLog.e("SR_MP4_Task", 1, "initVideoEncoder, error, ", th5);
            return false;
        }
    }

    private void q(int i3) {
        d dVar = this.f334136h;
        if (dVar != null) {
            dVar.a(this.f334129a, i3);
        }
    }

    private void s() {
        com.tencent.mobileqq.zplan.meme.mp4.e eVar = this.f334131c;
        if (eVar != null) {
            eVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.f334138j && this.f334137i) {
            s();
        }
    }

    public void h() {
        Mp4MediaEncoder mp4MediaEncoder;
        C9184f c9184f = this.f334141m;
        if (c9184f.N == 0) {
            c9184f.N = System.currentTimeMillis();
        }
        if (this.f334139k || (mp4MediaEncoder = this.f334133e) == null) {
            return;
        }
        mp4MediaEncoder.w();
    }

    public C9184f j() {
        return new C9184f(this.f334141m);
    }

    public String k() {
        return this.f334130b;
    }

    public void o(byte[] bArr, int i3, long j3) {
        Mp4MediaEncoder mp4MediaEncoder;
        C9184f c9184f = this.f334141m;
        if (c9184f.J == 0) {
            c9184f.J = System.currentTimeMillis();
        }
        C9184f c9184f2 = this.f334141m;
        c9184f2.Q++;
        c9184f2.M = j3;
        if (this.f334139k || (mp4MediaEncoder = this.f334133e) == null) {
            return;
        }
        int length = bArr.length - 1;
        int i16 = 0;
        do {
            try {
                int size = this.f334143o.size();
                int i17 = (length - i16) + 1;
                int i18 = size + i17;
                int i19 = this.f334142n;
                if (i18 <= i19) {
                    this.f334143o.write(bArr, i16, i17);
                    i16 = length;
                } else {
                    this.f334143o.write(bArr, i16, i19 - size);
                    i16 += this.f334142n - size;
                }
                if (this.f334143o.size() == this.f334142n) {
                    mp4MediaEncoder.x(this.f334143o.toByteArray(), this.f334142n, this.f334144p);
                    this.f334144p++;
                    this.f334143o.reset();
                }
            } catch (Throwable th5) {
                QLog.e("SR_MP4_Task", 1, "inputAudioData err, ", th5);
                return;
            }
        } while (i16 < length);
    }

    public void p(byte[] bArr, int i3, long j3) {
        Mp4MediaEncoder mp4MediaEncoder;
        C9184f c9184f = this.f334141m;
        if (c9184f.f334168i == 0) {
            c9184f.f334168i = System.currentTimeMillis();
        }
        C9184f c9184f2 = this.f334141m;
        c9184f2.G++;
        c9184f2.D = j3;
        if (this.f334139k || (mp4MediaEncoder = this.f334132d) == null) {
            return;
        }
        mp4MediaEncoder.x(bArr, i3, j3);
    }

    public void u() {
        this.f334141m.f334165e = System.currentTimeMillis();
        if (this.f334139k) {
            return;
        }
        Mp4MediaEncoder mp4MediaEncoder = this.f334132d;
        Mp4MediaEncoder mp4MediaEncoder2 = this.f334133e;
        com.tencent.mobileqq.zplan.meme.mp4.e eVar = this.f334131c;
        if (mp4MediaEncoder == null) {
            q(-1202);
            return;
        }
        if (mp4MediaEncoder2 == null) {
            q(-1203);
        } else {
            if (eVar == null) {
                q(-1201);
                return;
            }
            eVar.g();
            mp4MediaEncoder.B();
            mp4MediaEncoder2.B();
        }
    }

    public void v() {
        Mp4MediaEncoder mp4MediaEncoder;
        C9184f c9184f = this.f334141m;
        if (c9184f.E == 0) {
            c9184f.E = System.currentTimeMillis();
        }
        if (this.f334139k || (mp4MediaEncoder = this.f334132d) == null) {
            return;
        }
        mp4MediaEncoder.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i3, int i16) {
        com.tencent.mobileqq.zplan.meme.mp4.e eVar;
        Mp4MediaEncoder mp4MediaEncoder;
        Mp4MediaEncoder mp4MediaEncoder2;
        this.f334139k = true;
        if (i16 != 1 && (mp4MediaEncoder2 = this.f334133e) != null) {
            mp4MediaEncoder2.r();
        }
        if (i16 != 0 && (mp4MediaEncoder = this.f334132d) != null) {
            mp4MediaEncoder.r();
        }
        if (i16 != 2 && (eVar = this.f334131c) != null) {
            eVar.c();
        }
        i(i3);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.zplan.meme.mp4.f$f, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public static class C9184f implements Cloneable {
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
        public long f334164d;

        /* renamed from: e, reason: collision with root package name */
        public long f334165e;

        /* renamed from: f, reason: collision with root package name */
        public long f334166f;

        /* renamed from: h, reason: collision with root package name */
        public long f334167h;

        /* renamed from: i, reason: collision with root package name */
        public long f334168i;

        /* renamed from: m, reason: collision with root package name */
        public long f334169m;

        public C9184f() {
            this.f334164d = 0L;
            this.f334165e = 0L;
            this.f334166f = 0L;
            this.f334167h = 0L;
            this.f334168i = 0L;
            this.f334169m = 0L;
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
            return "ReportInfo{taskTotalTime=" + (this.f334166f - this.f334165e) + ", taskCreateTime=" + this.f334164d + ", taskStartTime=" + this.f334165e + ", taskEndTime=" + this.f334166f + ", videoEncodeStartTime=" + this.f334167h + ", videoFirstQueueDataTime=" + this.f334168i + ", videoFirstEncodOutputTime=" + this.f334169m + ", videoFirstFormatChangeTime=" + this.C + ", videoFinalQueuePts=" + this.D + ", videoQueueDataCompleteTime=" + this.E + ", videoEncodeFinishTime=" + this.F + ", videoEncodeQueueDataTimes=" + this.G + ", videoEncodeOutputTimes=" + this.H + ", audioEncodeStartTime=" + this.I + ", audioFirstQueueDataTime=" + this.J + ", audioFirstEncodOutputTime=" + this.K + ", audioFirstFormatChangeTime=" + this.L + ", audioFinalQueuePts=" + this.M + ", audioQueueDataCompleteTime=" + this.N + ", audioEncodeFinishTime=" + this.P + ", audioEncodeQueueDataTimes=" + this.Q + ", audioEncodeOutputTimes=" + this.R + ", muxerStartTime=" + this.S + '}';
        }

        public C9184f(C9184f c9184f) {
            this.f334164d = 0L;
            this.f334165e = 0L;
            this.f334166f = 0L;
            this.f334167h = 0L;
            this.f334168i = 0L;
            this.f334169m = 0L;
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
            this.f334164d = c9184f.f334164d;
            this.f334165e = c9184f.f334165e;
            this.f334166f = c9184f.f334166f;
            this.f334167h = c9184f.f334167h;
            this.f334168i = c9184f.f334168i;
            this.f334169m = c9184f.f334169m;
            this.C = c9184f.C;
            this.D = c9184f.D;
            this.E = c9184f.E;
            this.F = c9184f.F;
            this.G = c9184f.G;
            this.H = c9184f.H;
            this.I = c9184f.I;
            this.J = c9184f.J;
            this.K = c9184f.K;
            this.L = c9184f.L;
            this.M = c9184f.M;
            this.N = c9184f.N;
            this.P = c9184f.P;
            this.Q = c9184f.N;
            this.R = c9184f.R;
            this.S = c9184f.S;
        }
    }

    private void m() {
    }
}
