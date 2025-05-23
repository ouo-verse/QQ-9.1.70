package com.tencent.biz.videostory.video;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes5.dex */
public class MediaCodecGLFrameFetcher {

    /* renamed from: a, reason: collision with root package name */
    private int f97146a;

    /* renamed from: b, reason: collision with root package name */
    private int f97147b;

    /* renamed from: c, reason: collision with root package name */
    private String f97148c;

    /* renamed from: d, reason: collision with root package name */
    private MediaExtractor f97149d;

    /* renamed from: e, reason: collision with root package name */
    private MediaFormat f97150e;

    /* renamed from: f, reason: collision with root package name */
    private MediaCodec f97151f;

    /* renamed from: g, reason: collision with root package name */
    private ByteBuffer[] f97152g;

    /* renamed from: h, reason: collision with root package name */
    private MediaCodec.BufferInfo f97153h;

    /* renamed from: i, reason: collision with root package name */
    private int f97154i;

    /* renamed from: j, reason: collision with root package name */
    private int f97155j;

    /* renamed from: m, reason: collision with root package name */
    private SimpleGLThread f97158m;

    /* renamed from: n, reason: collision with root package name */
    private volatile SurfaceTexture f97159n;

    /* renamed from: p, reason: collision with root package name */
    private Surface f97161p;

    /* renamed from: r, reason: collision with root package name */
    private volatile Bitmap f97163r;

    /* renamed from: w, reason: collision with root package name */
    private b f97168w;

    /* renamed from: x, reason: collision with root package name */
    private int f97169x;

    /* renamed from: k, reason: collision with root package name */
    private boolean f97156k = false;

    /* renamed from: l, reason: collision with root package name */
    private long f97157l = -1;

    /* renamed from: o, reason: collision with root package name */
    private final Object f97160o = new Object();

    /* renamed from: q, reason: collision with root package name */
    private float[] f97162q = new float[16];

    /* renamed from: s, reason: collision with root package name */
    private final AtomicBoolean f97164s = new AtomicBoolean(false);

    /* renamed from: t, reason: collision with root package name */
    private int f97165t = 0;

    /* renamed from: u, reason: collision with root package name */
    private long f97166u = -1;

    /* renamed from: v, reason: collision with root package name */
    private boolean f97167v = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements SurfaceTexture.OnFrameAvailableListener {
        a() {
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            MediaCodecGLFrameFetcher.this.s();
        }
    }

    public MediaCodecGLFrameFetcher(long j3, long j16) {
        this.f97146a = (int) j3;
        this.f97147b = (int) j16;
    }

    @TargetApi(16)
    private void k() {
        QLog.i("MediaCodecGLFrameFetcher", 3, "cleanUp");
        this.f97152g = null;
        this.f97166u = -1L;
        if (this.f97163r != null && !this.f97163r.isRecycled()) {
            this.f97163r.recycle();
            this.f97163r = null;
        }
        try {
            try {
                MediaExtractor mediaExtractor = this.f97149d;
                if (mediaExtractor != null) {
                    mediaExtractor.release();
                }
            } finally {
                this.f97149d = null;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        Surface surface = this.f97161p;
        if (surface != null) {
            try {
                try {
                    surface.release();
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            } finally {
                this.f97161p = null;
            }
        }
        try {
            try {
                MediaCodec mediaCodec = this.f97151f;
                if (mediaCodec != null) {
                    mediaCodec.release();
                }
            } catch (Exception e18) {
                e18.printStackTrace();
            }
        } finally {
            this.f97151f = null;
        }
    }

    @TargetApi(16)
    private boolean l(long j3) {
        if (this.f97156k) {
            return false;
        }
        while (true) {
            try {
                int dequeueInputBuffer = this.f97151f.dequeueInputBuffer(0L);
                if (dequeueInputBuffer >= 0) {
                    int readSampleData = this.f97149d.readSampleData(this.f97152g[dequeueInputBuffer], 0);
                    long sampleTime = this.f97149d.getSampleTime();
                    if (readSampleData > 0) {
                        this.f97149d.advance();
                        this.f97151f.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, 0);
                    } else {
                        QLog.i("MediaCodecGLFrameFetcher", 3, "decodeGOP: end of extractor");
                        this.f97149d.release();
                        this.f97156k = true;
                        return false;
                    }
                }
                int dequeueOutputBuffer = this.f97151f.dequeueOutputBuffer(this.f97153h, 0L);
                if (dequeueOutputBuffer != -3) {
                    if (dequeueOutputBuffer == -2) {
                        this.f97150e = this.f97151f.getOutputFormat();
                    } else if (dequeueOutputBuffer < 0) {
                        continue;
                    } else {
                        if (this.f97153h.presentationTimeUs >= j3) {
                            this.f97151f.releaseOutputBuffer(dequeueOutputBuffer, true);
                            return true;
                        }
                        this.f97151f.releaseOutputBuffer(dequeueOutputBuffer, false);
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                this.f97156k = true;
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        QLog.i("MediaCodecGLFrameFetcher", 3, "finitRender: " + hashCode());
        this.f97159n.release();
        com.tencent.biz.videostory.video.a.a(this.f97169x);
    }

    @TargetApi(16)
    private MediaFormat p() {
        for (int i3 = 0; i3 < this.f97149d.getTrackCount(); i3++) {
            MediaFormat trackFormat = this.f97149d.getTrackFormat(i3);
            if (trackFormat.getString("mime").startsWith("video/")) {
                this.f97149d.selectTrack(i3);
                return trackFormat;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        QLog.i("MediaCodecGLFrameFetcher", 3, "initRender: " + hashCode());
        b bVar = new b();
        this.f97168w = bVar;
        bVar.d(true);
        this.f97168w.g();
        this.f97159n = new SurfaceTexture(this.f97168w.e());
        this.f97169x = com.tencent.biz.videostory.video.a.b(this.f97154i, this.f97155j);
    }

    @TargetApi(16)
    private boolean r() {
        MediaFormat mediaFormat = this.f97150e;
        if (mediaFormat == null) {
            return false;
        }
        this.f97154i = mediaFormat.getInteger("width");
        int integer = this.f97150e.getInteger("height");
        this.f97155j = integer;
        int i3 = this.f97154i;
        float f16 = integer / i3;
        int i16 = this.f97147b;
        int i17 = this.f97146a;
        if (i16 / i17 != f16) {
            float max = Math.max(i17 / i3, i16 / integer);
            this.f97146a = (int) (this.f97154i * max);
            this.f97147b = (int) (this.f97155j * max);
        }
        int i18 = this.f97165t;
        if (i18 == 270 || i18 == 90) {
            int i19 = this.f97146a;
            int i26 = this.f97147b;
            int i27 = i19 ^ i26;
            int i28 = i26 ^ i27;
            this.f97147b = i28;
            this.f97146a = i27 ^ i28;
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        synchronized (this.f97164s) {
            QLog.i("MediaCodecGLFrameFetcher", 3, "notifyFrame");
            this.f97164s.set(true);
            this.f97164s.notifyAll();
        }
    }

    @TargetApi(16)
    private boolean t() {
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.f97149d = mediaExtractor;
            mediaExtractor.setDataSource(this.f97148c);
            MediaFormat p16 = p();
            this.f97150e = p16;
            if (p16 != null) {
                try {
                    this.f97165t = p16.getInteger("rotation-degrees");
                } catch (Exception unused) {
                    this.f97165t = 0;
                }
            }
            if (!r()) {
                k();
                return false;
            }
            SimpleGLThread simpleGLThread = new SimpleGLThread(null, "MediaCodecGLFrameFetcher");
            this.f97158m = simpleGLThread;
            simpleGLThread.h(new Runnable() { // from class: com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher.2
                @Override // java.lang.Runnable
                public void run() {
                    MediaCodecGLFrameFetcher.this.q();
                }
            });
            if (this.f97159n == null) {
                QLog.i("MediaCodecGLFrameFetcher", 3, "prepare: surface texture is null");
                return false;
            }
            u();
            this.f97153h = new MediaCodec.BufferInfo();
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            k();
            return false;
        }
    }

    @TargetApi(16)
    private void u() throws IOException {
        this.f97161p = new Surface(this.f97159n);
        this.f97159n.setOnFrameAvailableListener(new a());
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(this.f97150e.getString("mime"));
        this.f97151f = createDecoderByType;
        createDecoderByType.configure(this.f97150e, this.f97161p, (MediaCrypto) null, 0);
        this.f97151f.start();
        this.f97152g = this.f97151f.getInputBuffers();
    }

    private void w() {
        y();
        this.f97158m.h(new Runnable() { // from class: com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher.3
            @Override // java.lang.Runnable
            public void run() {
                if (MediaCodecGLFrameFetcher.this.f97159n == null) {
                    return;
                }
                MediaCodecGLFrameFetcher.this.f97159n.updateTexImage();
                GLES20.glViewport(0, 0, MediaCodecGLFrameFetcher.this.f97146a, MediaCodecGLFrameFetcher.this.f97147b);
                MediaCodecGLFrameFetcher.this.f97168w.c(MediaCodecGLFrameFetcher.this.f97159n, MediaCodecGLFrameFetcher.this.f97169x);
                if (MediaCodecGLFrameFetcher.this.f97163r != null && !MediaCodecGLFrameFetcher.this.f97163r.isRecycled()) {
                    MediaCodecGLFrameFetcher.this.f97163r.recycle();
                }
                MediaCodecGLFrameFetcher mediaCodecGLFrameFetcher = MediaCodecGLFrameFetcher.this;
                mediaCodecGLFrameFetcher.f97163r = com.tencent.biz.videostory.video.a.c(mediaCodecGLFrameFetcher.f97169x, MediaCodecGLFrameFetcher.this.f97146a, MediaCodecGLFrameFetcher.this.f97147b);
            }
        });
    }

    private void y() {
        synchronized (this.f97164s) {
            if (!this.f97164s.get()) {
                try {
                    LockMethodProxy.wait(this.f97164s);
                    QLog.i("MediaCodecGLFrameFetcher", 3, "waitFrame: done");
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
            this.f97164s.set(false);
        }
    }

    public Bitmap n(long j3) {
        return o(j3, Bitmap.Config.ARGB_8888);
    }

    @TargetApi(16)
    public Bitmap o(long j3, Bitmap.Config config) {
        long j16 = j3 * 1000;
        if (this.f97166u == -1) {
            this.f97166u = this.f97150e.getLong("durationUs");
        }
        if (j16 > this.f97166u) {
            QLog.w("MediaCodecGLFrameFetcher", 3, "prepareSeek: pos=" + j16 + ", du=" + this.f97166u);
            j16 = this.f97166u;
        }
        this.f97149d.seekTo(j16, 2);
        long sampleTime = this.f97149d.getSampleTime();
        if (!l(sampleTime)) {
            QLog.e("MediaCodecGLFrameFetcher", 1, "getFrame: decode error, ts " + sampleTime);
            return null;
        }
        w();
        this.f97157l = sampleTime;
        if (this.f97163r == null) {
            return null;
        }
        return this.f97163r.copy(config, true);
    }

    public void v() {
        QLog.d("MediaCodecGLFrameFetcher", 3, "release: " + hashCode());
        SimpleGLThread simpleGLThread = this.f97158m;
        if (simpleGLThread != null) {
            simpleGLThread.h(new Runnable() { // from class: com.tencent.biz.videostory.video.MediaCodecGLFrameFetcher.1
                @Override // java.lang.Runnable
                public void run() {
                    MediaCodecGLFrameFetcher.this.m();
                }
            });
            this.f97158m.f();
            this.f97158m = null;
        }
        k();
        this.f97167v = true;
    }

    public boolean x(String str) {
        if (!this.f97167v) {
            this.f97148c = str;
            return t();
        }
        throw new RuntimeException("should not reuse!");
    }
}
