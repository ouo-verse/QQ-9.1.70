package iq;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.h;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e implements com.tencent.mobileqq.videocodec.mediacodec.recorder.g {

    /* renamed from: b, reason: collision with root package name */
    private final MediaMuxer f408187b;

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.mobileqq.videocodec.mediacodec.recorder.c f408188c;

    /* renamed from: d, reason: collision with root package name */
    private final String f408189d;

    /* renamed from: e, reason: collision with root package name */
    private MediaFormat f408190e;

    /* renamed from: f, reason: collision with root package name */
    private MediaFormat f408191f;

    /* renamed from: g, reason: collision with root package name */
    private int f408192g;

    /* renamed from: h, reason: collision with root package name */
    private int f408193h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f408194i;

    /* renamed from: l, reason: collision with root package name */
    private ByteBuffer f408197l;

    /* renamed from: j, reason: collision with root package name */
    private volatile int f408195j = 0;

    /* renamed from: m, reason: collision with root package name */
    private final Object f408198m = new Object();

    /* renamed from: k, reason: collision with root package name */
    private final List<h.a> f408196k = new ArrayList();

    public e(String str, com.tencent.mobileqq.videocodec.mediacodec.recorder.c cVar) throws IOException {
        this.f408188c = cVar;
        this.f408189d = str;
        this.f408187b = new MediaMuxer(str, 0);
        ms.a.f("CaptureMediaMuxerWrapper", "CaptureMediaMuxerWrapper init outputPath = " + str);
    }

    private void c(int i3, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        try {
            ms.a.f("CaptureMediaMuxerWrapper", "writeSampleData addToCache = " + i3 + ", bufferSize:" + bufferInfo.size);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            byteBuffer.position(bufferInfo.offset);
            if (this.f408197l == null) {
                this.f408197l = ByteBuffer.allocateDirect(d.f408183a.g() * 1048576).order(ByteOrder.nativeOrder());
            }
            this.f408197l.put(byteBuffer);
            this.f408196k.add(new h.a(i3, bufferInfo.size, bufferInfo));
        } catch (Exception e16) {
            ms.a.d("CaptureMediaMuxerWrapper", "addToCache error sampleType = " + i3 + " size = " + bufferInfo.size + " ts = " + bufferInfo.presentationTimeUs, e16);
        }
    }

    private void e() {
        MediaFormat mediaFormat = this.f408190e;
        if (mediaFormat == null || this.f408191f == null) {
            return;
        }
        this.f408192g = this.f408187b.addTrack(mediaFormat);
        this.f408195j++;
        ms.a.f("CaptureMediaMuxerWrapper", "Added track #" + this.f408192g + " with " + this.f408190e.getString("mime") + " to muxer");
        if (this.f408191f != null) {
            this.f408195j++;
            this.f408193h = this.f408187b.addTrack(this.f408191f);
            ms.a.f("CaptureMediaMuxerWrapper", "Added track #" + this.f408193h + " with " + this.f408191f.getString("mime") + " to muxer");
        }
        this.f408187b.start();
        this.f408194i = true;
        g();
    }

    private void g() {
        synchronized (this.f408198m) {
            int i3 = 0;
            if (this.f408197l == null) {
                this.f408197l = ByteBuffer.allocate(0);
            }
            this.f408197l.flip();
            ms.a.a("CaptureMediaMuxerWrapper", "rewrite  = " + this.f408196k.size() + " samples " + this.f408197l.limit() + " bytes to muxer");
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            for (h.a aVar : this.f408196k) {
                aVar.a(bufferInfo, i3);
                ms.a.f("CaptureMediaMuxerWrapper", "rewrite  = " + aVar.f312666a + " size " + bufferInfo.size + " ts " + bufferInfo.presentationTimeUs);
                this.f408187b.writeSampleData(d(aVar.f312666a), this.f408197l, bufferInfo);
                i3 += aVar.f312667b;
            }
            this.f408196k.clear();
            this.f408197l = null;
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.g
    public MediaMuxer a() {
        return this.f408187b;
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.g
    public void b(int i3, MediaFormat mediaFormat) {
        ms.a.f("CaptureMediaMuxerWrapper", "setOutputFormat " + i3);
        if (i3 == 0) {
            this.f408190e = mediaFormat;
        } else if (i3 == 1) {
            this.f408191f = mediaFormat;
        } else {
            throw new AssertionError();
        }
        e();
    }

    public synchronized void f(int i3, Throwable th5) {
        ms.a.f("CaptureMediaMuxerWrapper", "releaseWithError errorCode = " + i3);
        try {
            if (this.f408194i) {
                this.f408194i = false;
                this.f408187b.stop();
                this.f408187b.release();
            }
        } finally {
            com.tencent.mobileqq.videocodec.mediacodec.recorder.c cVar = this.f408188c;
            if (cVar != null) {
                cVar.onEncodeError(i3, th5);
            }
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.g
    public synchronized void release() {
        ms.a.f("CaptureMediaMuxerWrapper", "release mStarted = " + this.f408194i + " mStartedCount = " + this.f408195j);
        this.f408195j = this.f408195j - 1;
        try {
        } catch (Exception e16) {
            ms.a.d("CaptureMediaMuxerWrapper", "release error, ", e16);
            f(2, e16);
        }
        if (this.f408194i && this.f408195j == 0) {
            ms.a.f("CaptureMediaMuxerWrapper", "release");
            this.f408194i = false;
            this.f408187b.stop();
            this.f408187b.release();
            com.tencent.mobileqq.videocodec.mediacodec.recorder.c cVar = this.f408188c;
            if (cVar != null) {
                cVar.onEncodeFinish(this.f408189d);
            }
            return;
        }
        if (!this.f408194i && this.f408195j < 0) {
            f(1, new Exception("stop too fast"));
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.g
    public void writeSampleData(int i3, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        try {
            synchronized (this.f408198m) {
                if (this.f408194i) {
                    this.f408187b.writeSampleData(d(i3), byteBuffer, bufferInfo);
                } else {
                    c(i3, byteBuffer, bufferInfo);
                }
            }
        } catch (Exception e16) {
            ms.a.d("CaptureMediaMuxerWrapper", "writeSampleData error, sampleType = " + i3 + " mBufferInfo.size = " + bufferInfo.size + " ts = " + bufferInfo.presentationTimeUs, e16);
            e16.printStackTrace();
            f(2, e16);
        }
    }

    private int d(int i3) {
        if (i3 == 0) {
            return this.f408192g;
        }
        if (i3 == 1) {
            return this.f408193h;
        }
        throw new AssertionError();
    }
}
