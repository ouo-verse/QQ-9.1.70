package com.tencent.mobileqq.zplan.meme.mp4;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes34.dex */
public class Mp4MediaEncoder {

    /* renamed from: q, reason: collision with root package name */
    private static final a f334069q = new a();

    /* renamed from: a, reason: collision with root package name */
    private MediaCodec f334070a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.zplan.meme.mp4.a f334071b;

    /* renamed from: h, reason: collision with root package name */
    private b f334077h;

    /* renamed from: o, reason: collision with root package name */
    private int f334084o;

    /* renamed from: p, reason: collision with root package name */
    private int f334085p;

    /* renamed from: c, reason: collision with root package name */
    private final Queue<c> f334072c = new ConcurrentLinkedQueue();

    /* renamed from: d, reason: collision with root package name */
    private EncodeState f334073d = EncodeState.NONE;

    /* renamed from: e, reason: collision with root package name */
    private boolean f334074e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f334075f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f334076g = false;

    /* renamed from: i, reason: collision with root package name */
    private long f334078i = 0;

    /* renamed from: j, reason: collision with root package name */
    private boolean f334079j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f334080k = false;

    /* renamed from: l, reason: collision with root package name */
    private int f334081l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f334082m = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f334083n = 0;

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public enum EncodeState {
        NONE,
        INIT,
        START,
        IDLE,
        RUNNING,
        CANCEL,
        ERROR,
        INTERRUPT,
        FINISH
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public ByteBuffer f334086a;

        /* renamed from: b, reason: collision with root package name */
        public int f334087b;

        /* renamed from: c, reason: collision with root package name */
        public MediaCodec.BufferInfo f334088c;
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f334089a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f334090b = true;

        /* renamed from: c, reason: collision with root package name */
        public int f334091c;

        /* renamed from: d, reason: collision with root package name */
        public int f334092d;

        /* renamed from: e, reason: collision with root package name */
        public int f334093e;

        /* renamed from: f, reason: collision with root package name */
        public int f334094f;

        /* renamed from: g, reason: collision with root package name */
        public int f334095g;

        /* renamed from: h, reason: collision with root package name */
        public int f334096h;

        /* renamed from: i, reason: collision with root package name */
        public int f334097i;

        /* renamed from: j, reason: collision with root package name */
        public int f334098j;

        /* renamed from: k, reason: collision with root package name */
        public int f334099k;

        public String toString() {
            return "EncodeConfigInfo{isVideoEncode=" + this.f334089a + ", videoFlipVertical=" + this.f334090b + ", videoColorFormat=" + this.f334091c + ", videoOriginWidth=" + this.f334092d + ", videoOriginHeight=" + this.f334093e + ", videoFrameRate=" + this.f334096h + ", audioSampleRate=" + this.f334097i + ", audioSampleCountPerFrame=" + this.f334098j + ", audioChannelCount=" + this.f334099k + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f334100a;

        /* renamed from: b, reason: collision with root package name */
        public int f334101b;

        /* renamed from: c, reason: collision with root package name */
        public long f334102c;

        /* renamed from: d, reason: collision with root package name */
        public long f334103d;

        public c(byte[] bArr, int i3, long j3, long j16) {
            this.f334100a = bArr;
            this.f334101b = i3;
            this.f334102c = j3;
            this.f334103d = j16;
        }
    }

    public Mp4MediaEncoder(MediaCodec mediaCodec, b bVar, com.tencent.mobileqq.zplan.meme.mp4.a aVar) {
        this.f334084o = 2;
        this.f334085p = 0;
        if (mediaCodec != null) {
            this.f334070a = mediaCodec;
            this.f334071b = aVar;
            this.f334077h = bVar;
            this.f334084o = c(bVar);
            this.f334085p = b(bVar);
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Encoder", 1, bVar.f334089a + ", init, " + this.f334084o + ", " + this.f334085p);
            }
            g();
            e(EncodeState.INIT);
            return;
        }
        throw new IllegalArgumentException("mediaCodec can't be null");
    }

    private void C() {
        if (this.f334073d != EncodeState.START) {
            return;
        }
        e(EncodeState.IDLE);
        ThreadManagerV2.newFreeThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.mp4.d
            @Override // java.lang.Runnable
            public final void run() {
                Mp4MediaEncoder.this.t();
            }
        }, "Mp4MediaEncoder", 5).start();
    }

    private int b(b bVar) {
        if (bVar.f334089a) {
            return bVar.f334092d * bVar.f334093e * 4;
        }
        return bVar.f334098j * 2 * bVar.f334099k;
    }

    private int c(b bVar) {
        if (bVar.f334089a) {
            int i3 = 16588800 / ((bVar.f334092d * bVar.f334093e) * 4);
            if (i3 <= 0) {
                return 2;
            }
            return i3;
        }
        int i16 = 376832 / ((bVar.f334098j * 2) * bVar.f334099k);
        if (i16 <= 0) {
            return 50;
        }
        return i16;
    }

    private boolean d() {
        return (this.f334074e || this.f334075f) ? false : true;
    }

    private void e(EncodeState encodeState) {
        if (this.f334073d == encodeState) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SR_MP4_Encoder", 1, this.f334077h.f334089a + ", changeState, old:" + this.f334073d.name() + ", new:" + encodeState.name());
        }
        this.f334073d = encodeState;
    }

    private void g() {
        try {
            this.f334072c.clear();
        } catch (Throwable th5) {
            QLog.e("SR_MP4_Encoder", 1, "clearQueue err, ", th5);
        }
    }

    private boolean h(MediaCodec mediaCodec, boolean z16) {
        a n3;
        do {
            if (!d() || (n3 = n(mediaCodec, z16)) == f334069q) {
                return false;
            }
            if (n3 == null) {
                return true;
            }
            MediaCodec.BufferInfo bufferInfo = n3.f334088c;
            if (bufferInfo == null) {
                return false;
            }
            if ((bufferInfo.flags & 2) != 0) {
                bufferInfo.size = 0;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Encoder", 1, "queueOutput, isVideo:" + this.f334077h.f334089a + ", pts:" + n3.f334088c.presentationTimeUs + ", size:" + n3.f334088c.size + ", isConfig:" + (n3.f334088c.flags & 2) + ", isEnd:" + (n3.f334088c.flags & 4));
            }
            try {
                MediaCodec.BufferInfo bufferInfo2 = n3.f334088c;
                if (bufferInfo2.size != 0) {
                    n3.f334086a.position(bufferInfo2.offset);
                    ByteBuffer byteBuffer = n3.f334086a;
                    MediaCodec.BufferInfo bufferInfo3 = n3.f334088c;
                    byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                    com.tencent.mobileqq.zplan.meme.mp4.a aVar = this.f334071b;
                    if (aVar != null) {
                        aVar.a(n3.f334086a, n3.f334088c);
                    }
                }
            } catch (Throwable th5) {
                QLog.e("SR_MP4_Encoder", 1, "dataOutputFromCodec fill data err, ", th5);
            }
            try {
                mediaCodec.releaseOutputBuffer(n3.f334087b, false);
            } catch (Throwable th6) {
                QLog.e("SR_MP4_Encoder", 1, "dataOutputFromCodec releaseOutputBuffer err, ", th6);
            }
        } while ((n3.f334088c.flags & 4) == 0);
        j(z16 ? 0 : -1001);
        return true;
    }

    private void i() {
        e(EncodeState.CANCEL);
        com.tencent.mobileqq.zplan.meme.mp4.a aVar = this.f334071b;
        if (aVar != null) {
            aVar.d();
        }
        y();
    }

    private void j(int i3) {
        e(EncodeState.FINISH);
        com.tencent.mobileqq.zplan.meme.mp4.a aVar = this.f334071b;
        if (aVar != null) {
            aVar.b(i3);
        }
        y();
    }

    private void k() {
        e(EncodeState.INTERRUPT);
        y();
    }

    private void l(long j3) {
        try {
            LockMethodProxy.sleep(j3);
        } catch (InterruptedException e16) {
            QLog.e("SR_MP4_Encoder", 1, "sleep error: ", e16);
        }
    }

    private a n(MediaCodec mediaCodec, boolean z16) {
        ByteBuffer outputBuffer;
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        try {
            int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 5000L);
            if (dequeueOutputBuffer == -2) {
                u(mediaCodec);
                return null;
            }
            if (dequeueOutputBuffer == -3) {
                if (!QLog.isColorLevel()) {
                    return null;
                }
                QLog.d("SR_MP4_Encoder", 1, this.f334077h.f334089a + ", INFO_OUTPUT_BUFFERS_CHANGED");
                return null;
            }
            if (dequeueOutputBuffer < 0 || (outputBuffer = mediaCodec.getOutputBuffer(dequeueOutputBuffer)) == null) {
                return null;
            }
            a aVar = new a();
            aVar.f334086a = outputBuffer;
            aVar.f334087b = dequeueOutputBuffer;
            aVar.f334088c = bufferInfo;
            return aVar;
        } catch (Throwable th5) {
            QLog.e("SR_MP4_Encoder", 1, "getAvailableOutputByteBuffer error, ", th5);
            return f334069q;
        }
    }

    private void o(c cVar) {
        MediaCodec mediaCodec = this.f334070a;
        if (mediaCodec == null) {
            return;
        }
        try {
            if (!this.f334080k) {
                boolean q16 = q(mediaCodec, cVar);
                if (cVar == null) {
                    this.f334080k = true;
                }
                f(true, !q16);
            }
        } catch (Throwable th5) {
            QLog.e("SR_MP4_Encoder", 1, "inputDataIntoCodec error:", th5);
        }
        if (this.f334073d == EncodeState.ERROR) {
            return;
        }
        try {
            f(false, !h(mediaCodec, cVar == null));
        } catch (Throwable th6) {
            QLog.e("SR_MP4_Encoder", 1, "dataOutputFromCodec error:", th6);
        }
    }

    private boolean p() {
        return this.f334073d.ordinal() >= EncodeState.CANCEL.ordinal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        while (!p()) {
            if (this.f334074e) {
                i();
                return;
            }
            if (this.f334075f) {
                k();
                return;
            }
            c z16 = z();
            if (A(z16)) {
                e(EncodeState.IDLE);
                l(50L);
            } else {
                e(EncodeState.RUNNING);
                o(z16);
            }
        }
    }

    private void u(MediaCodec mediaCodec) {
        if (QLog.isColorLevel()) {
            QLog.d("SR_MP4_Encoder", 1, "notifyFormatChange, isVideo:" + this.f334077h.f334089a + ", alreadyNotify:" + this.f334079j);
        }
        if (this.f334079j) {
            return;
        }
        MediaFormat outputFormat = mediaCodec.getOutputFormat();
        com.tencent.mobileqq.zplan.meme.mp4.a aVar = this.f334071b;
        if (aVar != null) {
            aVar.e(outputFormat, this.f334077h.f334089a);
            this.f334079j = true;
        }
    }

    private void v(int i3, String str) {
        e(EncodeState.ERROR);
        com.tencent.mobileqq.zplan.meme.mp4.a aVar = this.f334071b;
        if (aVar != null) {
            aVar.c(i3, str);
        }
        y();
    }

    private void y() {
        g();
        MediaCodec mediaCodec = this.f334070a;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                mediaCodec.release();
            } catch (Throwable th5) {
                QLog.e("SR_MP4_Encoder", 1, "release error, " + this.f334077h.f334089a, th5);
            }
        }
        this.f334070a = null;
    }

    private c z() {
        try {
            return this.f334072c.poll();
        } catch (Throwable th5) {
            QLog.e("SR_MP4_Encoder", 1, "safelyPollElement, err, ", th5);
            return null;
        }
    }

    public void B() {
        if (this.f334073d != EncodeState.INIT) {
            return;
        }
        try {
            this.f334070a.start();
            e(EncodeState.START);
            com.tencent.mobileqq.zplan.meme.mp4.a aVar = this.f334071b;
            if (aVar != null) {
                aVar.onEncodeStart();
            }
            C();
        } catch (Throwable th5) {
            QLog.e("SR_MP4_Encoder", 1, this.f334077h.f334089a + ", start error:", th5);
            v(-1000, "start error: " + th5.getMessage());
        }
    }

    public void r() {
        this.f334075f = true;
    }

    public void w() {
        this.f334076g = true;
    }

    private boolean A(c cVar) {
        return cVar == null && !this.f334076g;
    }

    private a m(MediaCodec mediaCodec) {
        ByteBuffer inputBuffer;
        try {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(5000L);
            if (dequeueInputBuffer < 0 || (inputBuffer = mediaCodec.getInputBuffer(dequeueInputBuffer)) == null) {
                return null;
            }
            a aVar = new a();
            aVar.f334086a = inputBuffer;
            aVar.f334087b = dequeueInputBuffer;
            return aVar;
        } catch (Throwable th5) {
            QLog.e("SR_MP4_Encoder", 1, "getAvailableInputByteBuffer error, ", th5);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v3, types: [boolean] */
    private boolean q(MediaCodec mediaCodec, c cVar) {
        int i3;
        int i16;
        long j3;
        Object obj;
        a m3 = m(mediaCodec);
        if (m3 == null) {
            return false;
        }
        b bVar = this.f334077h;
        if (bVar.f334089a && cVar != null) {
            byte[] c16 = h.c(bVar, cVar.f334100a);
            cVar.f334100a = c16;
            if (c16 == null) {
                QLog.e("SR_MP4_Encoder", 1, "covert error, skip, " + cVar.f334103d);
                return false;
            }
            cVar.f334101b = c16.length;
        }
        m3.f334086a.clear();
        String str = ", ";
        if (QLog.isColorLevel() && this.f334077h.f334089a && cVar != null) {
            QLog.d("SR_MP4_Encoder", 1, "videoBuffer, " + cVar.f334100a.length + ", " + m3.f334086a.capacity() + ", " + m3.f334086a.limit() + ", " + m3.f334086a.position());
        }
        try {
            if (cVar != null) {
                m3.f334086a.put(cVar.f334100a);
                long j16 = cVar.f334102c;
                this.f334078i = j16;
                i16 = cVar.f334101b;
                j3 = j16;
                i3 = 0;
            } else {
                i3 = 4;
                i16 = 0;
                j3 = this.f334078i;
            }
            str = QLog.isColorLevel();
            if (str != 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("queueInput, isVideo:");
                sb5.append(this.f334077h.f334089a);
                sb5.append(", pts:");
                sb5.append(j3);
                sb5.append(", index:");
                if (cVar != null) {
                    obj = Long.valueOf(cVar.f334103d);
                } else {
                    obj = "-1";
                }
                sb5.append(obj);
                sb5.append(", size:");
                sb5.append(i16);
                sb5.append(", endFlag:");
                sb5.append(i3);
                sb5.append(", config:");
                sb5.append(this.f334077h.toString());
                QLog.d("SR_MP4_Encoder", 1, sb5.toString());
            }
            try {
                mediaCodec.queueInputBuffer(m3.f334087b, 0, i16, j3, i3);
                return true;
            } catch (Throwable th5) {
                QLog.e("SR_MP4_Encoder", 1, "queueInputBuffer error: ", th5);
                return false;
            }
        } catch (Throwable unused) {
            if (cVar != null) {
                QLog.e("SR_MP4_Encoder", 1, "error: " + this.f334077h.f334089a + str + cVar.f334100a.length + str + m3.f334086a.limit() + str + m3.f334086a.position());
            }
            return false;
        }
    }

    private void f(boolean z16, boolean z17) {
        if (z16) {
            this.f334081l = z17 ? this.f334081l + 1 : 0;
        } else {
            this.f334082m = z17 ? this.f334082m + 1 : 0;
        }
        if (z16 && this.f334081l >= 10) {
            v(-1002, "continue err");
        } else {
            if (z16 || this.f334082m < 10) {
                return;
            }
            v(-1003, "continue err");
        }
    }

    public void x(byte[] bArr, int i3, long j3) {
        float f16;
        Object valueOf;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("queueData, isVideo:");
            sb5.append(this.f334077h.f334089a);
            sb5.append(", dataSize:");
            sb5.append(i3);
            sb5.append(", data.size:");
            if (bArr == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(bArr.length);
            }
            sb5.append(valueOf);
            sb5.append(", pts:");
            sb5.append(j3);
            sb5.append(", queue.size:");
            sb5.append(this.f334072c.size());
            sb5.append(", cancel:");
            sb5.append(this.f334074e);
            sb5.append(", end:");
            sb5.append(this.f334076g);
            sb5.append(", state:");
            sb5.append(this.f334073d.name());
            QLog.d("SR_MP4_Encoder", 1, sb5.toString());
        }
        if (this.f334073d.ordinal() <= EncodeState.START.ordinal() || this.f334073d.ordinal() >= EncodeState.CANCEL.ordinal() || this.f334076g || !d()) {
            return;
        }
        if (s(bArr, i3, j3)) {
            int i16 = this.f334083n + 1;
            this.f334083n = i16;
            if (i16 >= 10) {
                r();
                v(-1004, "continue queue err");
            }
            QLog.e("SR_MP4_Encoder", 1, this.f334077h.f334089a + ", queueData, error data, ignore");
            return;
        }
        this.f334083n = 0;
        if (this.f334072c.size() > this.f334084o) {
            QLog.e("SR_MP4_Encoder", 1, this.f334077h.f334089a + ", queueData, queue max, ignore");
            return;
        }
        if (!this.f334077h.f334089a) {
            f16 = ((float) j3) * (1000000.0f / r2.f334097i) * (i3 / (r2.f334099k * 2));
        } else {
            f16 = ((float) j3) * (1000000.0f / r2.f334096h);
        }
        try {
            this.f334072c.offer(new c(bArr, i3, (int) f16, j3));
        } catch (Throwable th5) {
            QLog.e("SR_MP4_Encoder", 1, "offer error: ", th5);
        }
    }

    private boolean s(byte[] bArr, int i3, long j3) {
        return j3 < 0 || bArr == null || bArr.length != i3 || i3 != this.f334085p;
    }
}
