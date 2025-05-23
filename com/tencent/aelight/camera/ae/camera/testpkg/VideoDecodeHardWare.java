package com.tencent.aelight.camera.ae.camera.testpkg;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.tencent.aelight.camera.ae.camera.testpkg.VideoCameraProxy;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes32.dex */
public class VideoDecodeHardWare {

    /* renamed from: a, reason: collision with root package name */
    private MediaExtractor f62293a;

    /* renamed from: b, reason: collision with root package name */
    private MediaCodec f62294b;

    /* renamed from: c, reason: collision with root package name */
    protected Surface f62295c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f62296d;

    /* renamed from: e, reason: collision with root package name */
    private VideoCameraProxy.c f62297e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f62298f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f62299g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f62300h = false;

    /* renamed from: i, reason: collision with root package name */
    long f62301i = 0;

    /* renamed from: j, reason: collision with root package name */
    boolean f62302j = true;

    /* renamed from: k, reason: collision with root package name */
    boolean f62303k = false;

    /* renamed from: l, reason: collision with root package name */
    MediaCodec.BufferInfo f62304l = null;

    /* renamed from: m, reason: collision with root package name */
    ByteBuffer[] f62305m = null;

    /* renamed from: n, reason: collision with root package name */
    int f62306n = 0;

    /* renamed from: o, reason: collision with root package name */
    private Runnable f62307o = new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.testpkg.VideoDecodeHardWare.1

        /* renamed from: d, reason: collision with root package name */
        long f62308d = 0;

        private void e() {
            int dequeueOutputBuffer = VideoDecodeHardWare.this.f62294b.dequeueOutputBuffer(VideoDecodeHardWare.this.f62304l, 10000L);
            if (dequeueOutputBuffer == -3) {
                QLog.d("VideoDecoder", 4, "INFO_OUTPUT_BUFFERS_CHANGED");
                VideoDecodeHardWare.this.f62294b.getOutputBuffers();
                return;
            }
            if (dequeueOutputBuffer == -2) {
                QLog.d("VideoDecoder", 4, "INFO_OUTPUT_FORMAT_CHANGED format : " + VideoDecodeHardWare.this.f62294b.getOutputFormat());
                return;
            }
            if (dequeueOutputBuffer != -1) {
                VideoDecodeHardWare videoDecodeHardWare = VideoDecodeHardWare.this;
                if (!videoDecodeHardWare.f62300h) {
                    videoDecodeHardWare.f62301i = System.currentTimeMillis();
                    VideoDecodeHardWare.this.f62300h = true;
                }
                VideoDecodeHardWare videoDecodeHardWare2 = VideoDecodeHardWare.this;
                if (videoDecodeHardWare2.f62302j && this.f62308d > videoDecodeHardWare2.f62304l.presentationTimeUs && videoDecodeHardWare2.f62297e != null) {
                    VideoDecodeHardWare.this.f62297e.c();
                    VideoDecodeHardWare.this.f62302j = false;
                }
                long j3 = VideoDecodeHardWare.this.f62304l.presentationTimeUs;
                this.f62308d = j3;
                try {
                    long currentTimeMillis = (j3 / 1000) - (System.currentTimeMillis() - VideoDecodeHardWare.this.f62301i);
                    if (currentTimeMillis > 0) {
                        LockMethodProxy.sleep(currentTimeMillis);
                    }
                } catch (InterruptedException e16) {
                    QLog.d("VideoDecoder", 4, "InterruptedException : " + e16.getMessage());
                    e16.printStackTrace();
                }
                VideoDecodeHardWare.this.f62294b.releaseOutputBuffer(dequeueOutputBuffer, true);
                return;
            }
            QLog.d("VideoDecoder", 4, "INFO_TRY_AGAIN_LATER");
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VideoDecodeHardWare.this.f62296d) {
                return;
            }
            VideoDecodeHardWare videoDecodeHardWare = VideoDecodeHardWare.this;
            if (!videoDecodeHardWare.f62303k) {
                videoDecodeHardWare.f62304l = new MediaCodec.BufferInfo();
                VideoDecodeHardWare videoDecodeHardWare2 = VideoDecodeHardWare.this;
                videoDecodeHardWare2.f62305m = videoDecodeHardWare2.f62294b.getInputBuffers();
                VideoDecodeHardWare.this.f62294b.getOutputBuffers();
                VideoDecodeHardWare.this.f62303k = true;
            }
            while (!VideoDecodeHardWare.this.f62296d) {
                int dequeueInputBuffer = VideoDecodeHardWare.this.f62294b.dequeueInputBuffer(10000L);
                if (dequeueInputBuffer >= 0) {
                    VideoDecodeHardWare videoDecodeHardWare3 = VideoDecodeHardWare.this;
                    videoDecodeHardWare3.f62306n = 0;
                    int readSampleData = videoDecodeHardWare3.f62293a.readSampleData(videoDecodeHardWare3.f62305m[dequeueInputBuffer], 0);
                    if (!VideoDecodeHardWare.this.f62293a.advance() || readSampleData <= 0) {
                        if (VideoDecodeHardWare.this.f62297e != null) {
                            VideoDecodeHardWare videoDecodeHardWare4 = VideoDecodeHardWare.this;
                            if (!videoDecodeHardWare4.f62299g) {
                                videoDecodeHardWare4.f62297e.a();
                            }
                        }
                        VideoDecodeHardWare videoDecodeHardWare5 = VideoDecodeHardWare.this;
                        if (videoDecodeHardWare5.f62299g) {
                            videoDecodeHardWare5.f62293a.seekTo(0L, 2);
                            VideoDecodeHardWare.this.f62294b.flush();
                            VideoDecodeHardWare.this.f();
                            QLog.d("VideoDecoder", 4, "InputBuffer BUFFER_FLAG_END_OF_STREAM");
                            return;
                        }
                        return;
                    }
                    VideoDecodeHardWare.this.f62294b.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, VideoDecodeHardWare.this.f62293a.getSampleTime(), 0);
                } else {
                    VideoDecodeHardWare videoDecodeHardWare6 = VideoDecodeHardWare.this;
                    int i3 = videoDecodeHardWare6.f62306n + 1;
                    videoDecodeHardWare6.f62306n = i3;
                    if (i3 >= 4) {
                        videoDecodeHardWare6.f62294b.flush();
                    }
                }
                if (!VideoDecodeHardWare.this.f62296d) {
                    QLog.d("VideoDecoder", 4, "decode()");
                    e();
                    if ((VideoDecodeHardWare.this.f62304l.flags & 4) != 0) {
                        QLog.d("VideoDecoder", 4, "OutputBuffer BUFFER_FLAG_END_OF_STREAM");
                    }
                }
            }
        }
    };

    public void e() {
        if (this.f62296d) {
            return;
        }
        this.f62296d = true;
        Handler handler = this.f62298f;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.testpkg.VideoDecodeHardWare.2
            @Override // java.lang.Runnable
            public void run() {
                VideoDecodeHardWare.this.f62294b.stop();
                VideoDecodeHardWare.this.f62294b.release();
                VideoDecodeHardWare.this.f62293a.release();
            }
        });
        this.f62296d = true;
        try {
            try {
                QLog.d("VideoDecoder", 4, "will release all.");
                this.f62298f.getLooper().quitSafely();
                this.f62294b.flush();
                this.f62294b.stop();
                this.f62294b.release();
                this.f62294b = null;
            } catch (Exception e16) {
                QLog.d("VideoDecoder", 4, "released all.Exception:" + e16.getMessage());
            }
        } finally {
            this.f62293a.release();
            this.f62293a = null;
            QLog.d("VideoDecoder", 4, "released all.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0075, code lost:
    
        r6.f62293a.selectTrack(r1);
        r6.f62294b = android.media.MediaCodec.createDecoderByType(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0080, code lost:
    
        com.tencent.qphone.base.util.QLog.i("VideoDecoder", 4, "format : " + r3);
        r6.f62294b.configure(r3, r7, (android.media.MediaCrypto) null, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x009b, code lost:
    
        r6.f62294b.start();
        h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a4, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a5, code lost:
    
        com.tencent.qphone.base.util.QLog.i("VideoDecoder", 4, "codec '" + r4 + "' failed configuration. " + r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00c3, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g(Surface surface, DecodeConfig decodeConfig, boolean z16) {
        this.f62299g = z16;
        this.f62296d = false;
        try {
            this.f62295c = surface;
            this.f62293a = new MediaExtractor();
            QLog.i("VideoDecoder", 4, "init:  inputFilePath " + decodeConfig.inputFilePath + " duration " + decodeConfig.endTimeMillSecond);
            this.f62293a.setDataSource(decodeConfig.inputFilePath);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getTrackCount: ");
            sb5.append(this.f62293a.getTrackCount());
            QLog.i("VideoDecoder", 4, sb5.toString());
            int i3 = 0;
            while (true) {
                if (i3 >= this.f62293a.getTrackCount()) {
                    break;
                }
                MediaFormat trackFormat = this.f62293a.getTrackFormat(i3);
                String string = trackFormat.getString("mime");
                if (string.startsWith("video/")) {
                    break;
                }
                i3++;
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        this.f62297e.b(decodeConfig);
        return true;
    }

    void h() {
        if (this.f62298f != null) {
            return;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("testDecode");
        baseHandlerThread.start();
        this.f62298f = new Handler(baseHandlerThread.getLooper());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0059, code lost:
    
        com.tencent.qphone.base.util.QLog.d("VideoDecoder", 4, "switchRecord init next.");
        r8.f62300h = false;
        r8.f62301i = 0;
        r8.f62302j = true;
        r8.f62303k = false;
        r8.f62304l = null;
        r8.f62305m = null;
        r8.f62306n = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0070, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0051, code lost:
    
        r5.release();
        r8.f62293a = null;
        com.tencent.qphone.base.util.QLog.d("VideoDecoder", 4, "switchRecord mExtractor released all.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
    
        if (r5 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002e, code lost:
    
        if (r5 != null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i() {
        MediaExtractor mediaExtractor;
        if (this.f62296d) {
            return;
        }
        this.f62296d = true;
        try {
            try {
                this.f62298f.removeCallbacks(this.f62307o);
                QLog.d("VideoDecoder", 4, "switchRecord mDecoder will release all.");
                this.f62294b.flush();
                this.f62294b.stop();
                this.f62294b.release();
                mediaExtractor = this.f62293a;
            } catch (Exception e16) {
                QLog.d("VideoDecoder", 4, "switchRecord mDecoder released all.Exception:" + e16.getMessage());
                mediaExtractor = this.f62293a;
            }
        } catch (Throwable th5) {
            MediaExtractor mediaExtractor2 = this.f62293a;
            if (mediaExtractor2 != null) {
                mediaExtractor2.release();
                this.f62293a = null;
                QLog.d("VideoDecoder", 4, "switchRecord mExtractor released all.");
            }
            throw th5;
        }
    }

    public void j(VideoCameraProxy.c cVar) {
        this.f62297e = cVar;
    }

    public void k() {
        Handler handler = this.f62298f;
        if (handler == null) {
            return;
        }
        handler.post(this.f62307o);
    }

    public void f() {
        this.f62300h = false;
        this.f62301i = 0L;
        this.f62302j = true;
        this.f62303k = false;
        this.f62304l = null;
        this.f62305m = null;
        this.f62306n = 0;
        k();
    }
}
