package com.tencent.mobileqq.ar.ARRecord;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.mobileqq.ar.ARRecord.d;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes11.dex */
public class VideoEncoderCore {

    /* renamed from: x, reason: collision with root package name */
    private static final Object f197020x = new Object();

    /* renamed from: y, reason: collision with root package name */
    private static final Object f197021y = new Object();

    /* renamed from: a, reason: collision with root package name */
    private d.a f197022a;

    /* renamed from: b, reason: collision with root package name */
    private MediaFormat f197023b;

    /* renamed from: c, reason: collision with root package name */
    private MediaCodec f197024c;

    /* renamed from: d, reason: collision with root package name */
    private Surface f197025d;

    /* renamed from: f, reason: collision with root package name */
    private Thread f197027f;

    /* renamed from: g, reason: collision with root package name */
    private long f197028g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f197029h;

    /* renamed from: i, reason: collision with root package name */
    private MediaFormat f197030i;

    /* renamed from: j, reason: collision with root package name */
    private MediaCodec f197031j;

    /* renamed from: l, reason: collision with root package name */
    private long f197033l;

    /* renamed from: m, reason: collision with root package name */
    private HandlerThread f197034m;

    /* renamed from: n, reason: collision with root package name */
    private Handler f197035n;

    /* renamed from: o, reason: collision with root package name */
    private long f197036o;

    /* renamed from: p, reason: collision with root package name */
    private MediaMuxer f197037p;

    /* renamed from: q, reason: collision with root package name */
    private int f197038q;

    /* renamed from: r, reason: collision with root package name */
    private int f197039r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f197040s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f197041t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f197042u;

    /* renamed from: v, reason: collision with root package name */
    private long f197043v;

    /* renamed from: w, reason: collision with root package name */
    private int f197044w;

    /* renamed from: e, reason: collision with root package name */
    private MediaCodec.BufferInfo f197026e = new MediaCodec.BufferInfo();

    /* renamed from: k, reason: collision with root package name */
    private MediaCodec.BufferInfo f197032k = new MediaCodec.BufferInfo();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class VideoEncodeThread extends BaseThread {
        public VideoEncodeThread() {
            super("VideoEncodeThread");
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                synchronized (VideoEncoderCore.f197020x) {
                    if (VideoEncoderCore.this.f197029h) {
                        QLog.d("VideoEncoderCore", 1, "VideoEncodeThread thread exit.");
                        return;
                    } else if (VideoEncoderCore.this.f197028g == 0) {
                        try {
                            LockMethodProxy.wait(VideoEncoderCore.f197020x);
                        } catch (Exception e16) {
                            QLog.e("VideoEncoderCore", 1, "VideoEncodeThread wait exception?", e16);
                        }
                    }
                }
                if (VideoEncoderCore.this.f197028g != 0) {
                    try {
                        VideoEncoderCore videoEncoderCore = VideoEncoderCore.this;
                        videoEncoderCore.k(videoEncoderCore.f197028g, false);
                    } catch (Exception e17) {
                        QLog.e("VideoEncoderCore", 1, "VideoEncodeThread encode video fail.", e17);
                        if (VideoEncoderCore.this.f197022a != null) {
                            VideoEncoderCore.this.f197022a.g(4);
                        }
                    }
                    VideoEncoderCore.this.f197028g = 0L;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<VideoEncoderCore> f197045a;

        public a(Looper looper, VideoEncoderCore videoEncoderCore) {
            super(looper);
            this.f197045a = new WeakReference<>(videoEncoderCore);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            VideoEncoderCore videoEncoderCore;
            WeakReference<VideoEncoderCore> weakReference = this.f197045a;
            if (weakReference != null) {
                videoEncoderCore = weakReference.get();
            } else {
                videoEncoderCore = null;
            }
            if (message.what == 1 && videoEncoderCore != null) {
                Object[] objArr = (Object[]) message.obj;
                try {
                    videoEncoderCore.j((byte[]) objArr[0], ((Long) objArr[1]).longValue(), false);
                } catch (Exception e16) {
                    QLog.e("VideoEncoderCore", 1, "AudioEncodeHandler encode audio fail.", e16);
                    if (videoEncoderCore.f197022a != null) {
                        videoEncoderCore.f197022a.g(3);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(byte[] bArr, long j3, boolean z16) {
        long j16;
        int i3;
        int i16;
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("VideoEncoderCore", 2, String.format("handleAudioFrame audioFrame=%s timestampNanos=%s endOfStream=%s", bArr, Long.valueOf(j3), Boolean.valueOf(z16)));
        }
        ByteBuffer[] inputBuffers = this.f197031j.getInputBuffers();
        int i17 = 0;
        while (true) {
            j16 = 10000;
            int dequeueInputBuffer = this.f197031j.dequeueInputBuffer(10000L);
            if (QLog.isColorLevel()) {
                QLog.d("VideoEncoderCore", 2, String.format("handleAudioFrame inputIndex=%s endTryTimes=%s", Integer.valueOf(dequeueInputBuffer), Integer.valueOf(i17)));
            }
            i3 = 10;
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(bArr);
                this.f197031j.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j3 / 1000, 0);
                i16 = -1;
                break;
            }
            i16 = -1;
            if (dequeueInputBuffer == -1 && (!z16 || (i17 = i17 + 1) > 10)) {
                break;
            }
        }
        ByteBuffer[] outputBuffers = this.f197031j.getOutputBuffers();
        int i18 = 0;
        while (true) {
            int dequeueOutputBuffer = this.f197031j.dequeueOutputBuffer(this.f197032k, j16);
            if (QLog.isColorLevel()) {
                QLog.d("VideoEncoderCore", 2, String.format("handleAudioFrame outputIndex=%s endTryTimes=%s", Integer.valueOf(dequeueOutputBuffer), Integer.valueOf(i18)));
            }
            if (dequeueOutputBuffer == i16) {
                if (z16 && (i18 = i18 + 1) <= i3) {
                    i3 = 10;
                    j16 = 10000;
                }
            } else if (dequeueOutputBuffer == -2) {
                synchronized (f197021y) {
                    this.f197039r = this.f197037p.addTrack(this.f197031j.getOutputFormat());
                    this.f197041t = true;
                    if (!this.f197042u && this.f197040s) {
                        this.f197037p.start();
                        this.f197042u = true;
                        d.a aVar = this.f197022a;
                        if (aVar != null) {
                            aVar.a();
                        }
                    }
                }
                i3 = 10;
                j16 = 10000;
            } else {
                if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.f197031j.getOutputBuffers();
                } else if (dequeueOutputBuffer >= 0) {
                    ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                    MediaCodec.BufferInfo bufferInfo = this.f197032k;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    if (bufferInfo.size != 0 && this.f197042u) {
                        byteBuffer2.position(bufferInfo.offset);
                        MediaCodec.BufferInfo bufferInfo2 = this.f197032k;
                        byteBuffer2.limit(bufferInfo2.offset + bufferInfo2.size);
                        if (QLog.isColorLevel()) {
                            QLog.d("VideoEncoderCore", 2, String.format("handleAudioFrame presentationTimeUs=%s", Long.valueOf(this.f197032k.presentationTimeUs)));
                        }
                        if (this.f197032k.presentationTimeUs >= this.f197033l) {
                            synchronized (f197021y) {
                                this.f197037p.writeSampleData(this.f197039r, byteBuffer2, this.f197032k);
                            }
                            this.f197033l = this.f197032k.presentationTimeUs;
                        } else {
                            QLog.e("VideoEncoderCore", 1, "handleAudioFrame audio timestamp revert? throw this frame.");
                        }
                    }
                    this.f197031j.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.f197032k.flags & 4) != 0) {
                        break;
                    } else {
                        i18 = 0;
                    }
                } else {
                    continue;
                }
                i3 = 10;
                j16 = 10000;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("VideoEncoderCore", 2, String.format("handleAudioFrame time cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b8, code lost:
    
        r7 = r0[r8];
        r9 = r16.f197026e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00bf, code lost:
    
        if ((r9.flags & 2) == 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c1, code lost:
    
        r9.size = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c5, code lost:
    
        if (r9.size == 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c9, code lost:
    
        if (r16.f197042u == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00cb, code lost:
    
        r7.position(r9.offset);
        r9 = r16.f197026e;
        r7.limit(r9.offset + r9.size);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00de, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00e0, code lost:
    
        com.tencent.qphone.base.util.QLog.d("VideoEncoderCore", 2, java.lang.String.format("handleVideoFrame1 presentationTimeUs=%s, duration=%s", java.lang.Long.valueOf(r16.f197026e.presentationTimeUs), java.lang.Long.valueOf(((r16.f197026e.presentationTimeUs * 1000) - r17) / 1000000)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x010c, code lost:
    
        r9 = r16.f197026e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0114, code lost:
    
        if (r9.presentationTimeUs < r16.f197036o) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0116, code lost:
    
        r9.flags = 1;
        r9 = com.tencent.mobileqq.ar.ARRecord.VideoEncoderCore.f197021y;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x011a, code lost:
    
        monitor-enter(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x011b, code lost:
    
        r16.f197037p.writeSampleData(r16.f197038q, r7, r16.f197026e);
        r16.f197044w++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0129, code lost:
    
        monitor-exit(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x012a, code lost:
    
        r16.f197036o = r16.f197026e.presentationTimeUs;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0134, code lost:
    
        com.tencent.qphone.base.util.QLog.e("VideoEncoderCore", 1, "handleVideoFrame video timestamp revert? throw this frame.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x013d, code lost:
    
        r16.f197024c.releaseOutputBuffer(r8, false);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void k(long j3, boolean z16) {
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("VideoEncoderCore", 2, String.format("handleVideoFrame1 timestampNanos=%s endOfStream=%s", Long.valueOf(j3), Boolean.valueOf(z16)));
        }
        if (z16) {
            this.f197024c.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.f197024c.getOutputBuffers();
        loop0: do {
            int i3 = 0;
            while (true) {
                int dequeueOutputBuffer = this.f197024c.dequeueOutputBuffer(this.f197026e, 10000L);
                if (QLog.isColorLevel()) {
                    QLog.d("VideoEncoderCore", 2, String.format("handleVideoFrame outputIndex=%s endTryTimes=%s", Integer.valueOf(dequeueOutputBuffer), Integer.valueOf(i3)));
                }
                if (dequeueOutputBuffer == -1) {
                    if (!z16) {
                        break loop0;
                    }
                    i3++;
                    if (i3 > 100) {
                        throw new RuntimeException("encoder has not output the last frame.");
                    }
                } else if (dequeueOutputBuffer == -2) {
                    synchronized (f197021y) {
                        this.f197038q = this.f197037p.addTrack(this.f197024c.getOutputFormat());
                        this.f197040s = true;
                        if (!this.f197042u && this.f197041t) {
                            this.f197037p.start();
                            this.f197042u = true;
                            d.a aVar = this.f197022a;
                            if (aVar != null) {
                                aVar.a();
                            }
                        }
                    }
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.f197024c.getOutputBuffers();
                } else if (dequeueOutputBuffer >= 0) {
                    break;
                }
            }
        } while ((this.f197026e.flags & 4) == 0);
        if (QLog.isColorLevel()) {
            QLog.d("VideoEncoderCore", 2, String.format("handleVideoFrame time cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        }
    }

    private void l() {
        int i3;
        if (QLog.isColorLevel()) {
            int currentTimeMillis = (int) ((System.currentTimeMillis() - this.f197043v) / 1000);
            if (currentTimeMillis > 0) {
                i3 = this.f197044w / currentTimeMillis;
            } else {
                i3 = -1;
            }
            QLog.d("VideoEncoderCore", 2, String.format("release video fps:%s", Integer.valueOf(i3)));
        }
        if (this.f197027f != null) {
            Object obj = f197020x;
            synchronized (obj) {
                this.f197029h = true;
                this.f197027f = null;
                obj.notify();
            }
        }
        HandlerThread handlerThread = this.f197034m;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f197034m = null;
            this.f197035n = null;
        }
        MediaCodec mediaCodec = this.f197031j;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f197031j.release();
            this.f197031j = null;
        }
        MediaCodec mediaCodec2 = this.f197024c;
        if (mediaCodec2 != null) {
            mediaCodec2.stop();
            this.f197024c.release();
            this.f197024c = null;
        }
        MediaMuxer mediaMuxer = this.f197037p;
        if (mediaMuxer != null) {
            mediaMuxer.stop();
            this.f197037p.release();
            this.f197037p = null;
        }
    }

    public void h(byte[] bArr, long j3) {
        if (this.f197035n != null) {
            this.f197035n.obtainMessage(1, new Object[]{bArr, Long.valueOf(j3)}).sendToTarget();
        }
    }

    public Surface i() {
        return this.f197025d;
    }

    public void m(com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar, d.a aVar) throws IOException {
        this.f197022a = aVar;
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", cVar.f312559d, cVar.f312560e);
        this.f197023b = createVideoFormat;
        createVideoFormat.setInteger("color-format", 2130708361);
        this.f197023b.setInteger("bitrate", cVar.f312561f);
        this.f197023b.setInteger("frame-rate", cVar.f312562g);
        this.f197023b.setInteger("i-frame-interval", cVar.f312563h);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.f197024c = createEncoderByType;
        createEncoderByType.configure(this.f197023b, (Surface) null, (MediaCrypto) null, 1);
        this.f197025d = this.f197024c.createInputSurface();
        this.f197024c.start();
        VideoEncodeThread videoEncodeThread = new VideoEncodeThread();
        this.f197027f = videoEncodeThread;
        videoEncodeThread.start();
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
        this.f197030i = createAudioFormat;
        createAudioFormat.setInteger("aac-profile", 2);
        this.f197030i.setInteger("channel-mask", 12);
        this.f197030i.setInteger("bitrate", EncoderWriter.OUTPUT_AUDIO_BIT_RATE);
        this.f197030i.setInteger("max-input-size", 20480);
        MediaCodec createEncoderByType2 = MediaCodec.createEncoderByType("audio/mp4a-latm");
        this.f197031j = createEncoderByType2;
        createEncoderByType2.configure(this.f197030i, (Surface) null, (MediaCrypto) null, 1);
        this.f197031j.start();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("VideoEncodeThread");
        this.f197034m = baseHandlerThread;
        baseHandlerThread.start();
        this.f197035n = new a(this.f197034m.getLooper(), this);
        File file = new File(cVar.f312558c);
        if (!file.exists()) {
            FileUtils.createFileIfNotExits(file.getAbsolutePath());
        }
        MediaMuxer mediaMuxer = new MediaMuxer(cVar.f312558c, 0);
        this.f197037p = mediaMuxer;
        mediaMuxer.setOrientationHint(cVar.f312568m);
        this.f197038q = -1;
        this.f197039r = -1;
        this.f197040s = false;
        this.f197041t = false;
        this.f197042u = false;
        this.f197043v = System.currentTimeMillis();
        this.f197044w = 0;
    }

    public void n() {
        Handler handler = this.f197035n;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        j(new byte[0], elapsedRealtimeNanos, true);
        k(elapsedRealtimeNanos, true);
        l();
    }

    public void o(long j3) {
        if (this.f197027f != null) {
            Object obj = f197020x;
            synchronized (obj) {
                this.f197028g = j3;
                obj.notify();
            }
        }
    }
}
