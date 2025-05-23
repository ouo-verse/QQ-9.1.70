package org.libpag;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import org.libpag.d;

/* compiled from: P */
/* loaded from: classes29.dex */
class HardwareEncoder {

    /* renamed from: j, reason: collision with root package name */
    private static final AtomicInteger f423685j = new AtomicInteger();

    /* renamed from: a, reason: collision with root package name */
    private MediaCodec f423686a;

    /* renamed from: d, reason: collision with root package name */
    private Surface f423689d;

    /* renamed from: b, reason: collision with root package name */
    private MediaCodec.BufferInfo f423687b = new MediaCodec.BufferInfo();

    /* renamed from: c, reason: collision with root package name */
    private boolean f423688c = false;

    /* renamed from: e, reason: collision with root package name */
    private e f423690e = null;

    /* renamed from: f, reason: collision with root package name */
    private d f423691f = null;

    /* renamed from: g, reason: collision with root package name */
    private volatile MediaFormat f423692g = null;

    /* renamed from: h, reason: collision with root package name */
    private boolean f423693h = false;

    /* renamed from: i, reason: collision with root package name */
    int f423694i = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class a implements d.b {

        /* renamed from: a, reason: collision with root package name */
        private MediaCodec f423695a;

        /* renamed from: b, reason: collision with root package name */
        private long f423696b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MediaFormat f423697c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MediaCodec[] f423698d;

        a(MediaFormat mediaFormat, MediaCodec[] mediaCodecArr) {
            this.f423697c = mediaFormat;
            this.f423698d = mediaCodecArr;
        }

        @Override // org.libpag.d.b
        public void a(boolean z16) {
            if (z16 && this.f423695a != null) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.f423696b;
                try {
                    this.f423695a.stop();
                } catch (Exception e16) {
                    Log.w("HardwareEncoder", "afterRun: encoder.stop() fail", e16);
                }
                try {
                    Log.d("HardwareEncoder", "afterRun: encoder.release()");
                    this.f423695a.release();
                } catch (Exception e17) {
                    Log.w("HardwareEncoder", "afterRun: encoder.release() fail", e17);
                }
                this.f423695a = null;
                Log.e("HardwareEncoder", "afterRun: ", new RuntimeException("init encoder timeout. cost: " + uptimeMillis + "ms"));
            }
            if (!z16) {
                this.f423698d[0] = this.f423695a;
            }
            HardwareEncoder.f423685j.getAndDecrement();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f423696b = SystemClock.uptimeMillis();
            try {
                MediaCodec createEncoderByType = MediaCodec.createEncoderByType(this.f423697c.getString("mime"));
                this.f423695a = createEncoderByType;
                createEncoderByType.configure(this.f423697c, (Surface) null, (MediaCrypto) null, 1);
                Log.d("HardwareEncoder", "initEncoder: createEncoderByType, name = " + this.f423695a.getName());
                HardwareEncoder.this.f423689d = this.f423695a.createInputSurface();
                this.f423695a.start();
            } catch (Exception e16) {
                Log.e("HardwareEncoder", "initEncoder: initEncoder fail", e16);
                MediaCodec mediaCodec = this.f423695a;
                if (mediaCodec != null) {
                    mediaCodec.release();
                    this.f423695a = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HardwareEncoder.this.f423686a.stop();
            } catch (Exception e16) {
                Log.w("HardwareEncoder", "releaseEncoder: encoder.stop() fail", e16);
            }
            try {
                HardwareEncoder.this.f423686a.release();
                Log.d("HardwareEncoder", "releaseEncoder: encoder.release()");
            } catch (Exception e17) {
                Log.w("HardwareEncoder", "releaseEncoder: encoder.release() fail", e17);
            }
            HardwareEncoder.this.f423686a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f423701a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ HandlerThread f423702b;

        /* compiled from: P */
        /* loaded from: classes29.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f423702b.quitSafely();
            }
        }

        c(Runnable runnable, HandlerThread handlerThread) {
            this.f423701a = runnable;
            this.f423702b = handlerThread;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f423701a.run();
            HardwareEncoder.f423685j.getAndDecrement();
            new Handler(Looper.getMainLooper()).post(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        ByteBuffer f423712a;

        /* renamed from: b, reason: collision with root package name */
        int f423713b;

        /* renamed from: c, reason: collision with root package name */
        int f423714c;

        e() {
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    HardwareEncoder() {
    }

    private static HardwareEncoder Create() {
        if (forceSoftwareEncoder()) {
            return null;
        }
        return new HardwareEncoder();
    }

    private void addEncodeData(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        d dVar = this.f423691f;
        dVar.f423709e = true;
        long j3 = bufferInfo.presentationTimeUs;
        if (j3 <= 10000) {
            j3 = 0;
        }
        dVar.f423705a = j3;
        dVar.f423706b = j3;
        dVar.f423707c = bufferInfo.flags;
        dVar.f423711g = bufferInfo.offset;
        dVar.f423710f = bufferInfo.size;
        dVar.f423708d = byteBuffer;
    }

    private int dequeueOutputBuffer() {
        try {
            return this.f423686a.dequeueOutputBuffer(this.f423687b, 1000L);
        } catch (Exception e16) {
            Log.e("HardwareEncoder", "dequeueOutputBuffer: ", e16);
            return -1;
        }
    }

    private int drainEncoder() {
        boolean z16;
        int i3 = this.f423694i;
        if (i3 >= 0) {
            releaseOutputBuffer(this.f423686a, i3, false);
            this.f423694i = -1;
        }
        this.f423691f.f423709e = false;
        while (true) {
            int dequeueOutputBuffer = dequeueOutputBuffer();
            this.f423694i = dequeueOutputBuffer;
            if (dequeueOutputBuffer == -1) {
                return -1;
            }
            if (dequeueOutputBuffer == -2) {
                this.f423692g = this.f423686a.getOutputFormat();
            } else if (dequeueOutputBuffer >= 0) {
                ByteBuffer outputBuffer = getOutputBuffer(this.f423686a, dequeueOutputBuffer);
                MediaCodec.BufferInfo bufferInfo = this.f423687b;
                int i16 = bufferInfo.flags;
                if ((i16 & 2) != 0) {
                    e eVar = this.f423690e;
                    eVar.f423712a = outputBuffer;
                    eVar.f423714c = bufferInfo.offset;
                    eVar.f423713b = bufferInfo.size;
                    z16 = true;
                } else {
                    if ((i16 & 4) != 0) {
                        return -3;
                    }
                    addEncodeData(outputBuffer, bufferInfo);
                    z16 = false;
                }
                if (!z16) {
                    return 0;
                }
                return 1;
            }
        }
    }

    private static boolean forceSoftwareEncoder() {
        return false;
    }

    private ByteBuffer getEncodeData() {
        return this.f423691f.f423708d;
    }

    private int getEncodeDataOffset() {
        return this.f423691f.f423711g;
    }

    private int getEncodeDataSize() {
        return this.f423691f.f423710f;
    }

    private ByteBuffer getExtraData() {
        return this.f423690e.f423712a;
    }

    private int getExtraDataOffset() {
        return this.f423690e.f423714c;
    }

    private int getExtraDataSize() {
        return this.f423690e.f423713b;
    }

    private Surface getInputSurface() {
        Surface surface = this.f423689d;
        if (surface != null && surface.isValid()) {
            return this.f423689d;
        }
        return null;
    }

    private ByteBuffer getOutputBuffer(MediaCodec mediaCodec, int i3) {
        return mediaCodec.getOutputBuffer(i3);
    }

    private long getPts() {
        return this.f423691f.f423705a;
    }

    private boolean initEncoder(MediaFormat mediaFormat) {
        if (f423685j.get() >= 10) {
            return false;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("tavmedia_HardwareEncoder_init_encoder");
        baseHandlerThread.start();
        a aVar = null;
        MediaCodec[] mediaCodecArr = {null};
        boolean a16 = new org.libpag.d(baseHandlerThread.getLooper()).a(new a(mediaFormat, mediaCodecArr), 2000L);
        baseHandlerThread.quitSafely();
        this.f423691f = new d(aVar);
        this.f423690e = new e(aVar);
        if (!a16) {
            return false;
        }
        MediaCodec mediaCodec = mediaCodecArr[0];
        this.f423686a = mediaCodec;
        if (mediaCodec == null) {
            return false;
        }
        return true;
    }

    private boolean isKeyFrame() {
        if (this.f423691f.f423707c == 1) {
            return true;
        }
        return false;
    }

    private boolean onConfigure(MediaFormat mediaFormat) {
        mediaFormat.setInteger("i-frame-interval", 1);
        mediaFormat.setInteger("bitrate-mode", 1);
        mediaFormat.setInteger("color-format", 2130708361);
        this.f423692g = mediaFormat;
        return initEncoder(this.f423692g);
    }

    private int onEncodeData() {
        int i3;
        int drainEncoder = drainEncoder();
        if (drainEncoder == 0) {
            d dVar = this.f423691f;
            if (dVar.f423709e) {
                i3 = dVar.f423710f;
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                Log.e("HardwareEncoder", "onEncodeData: length == 0");
                return -2;
            }
            return drainEncoder;
        }
        return drainEncoder;
    }

    private int onEndOfStream() {
        signalEndOfInputStream();
        return 0;
    }

    private void onRelease() {
        if (this.f423688c) {
            return;
        }
        this.f423688c = true;
        releaseEncoder();
    }

    private int onSendData(ByteBuffer byteBuffer, long j3) {
        return 0;
    }

    private void releaseAsync(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        f423685j.getAndIncrement();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("libpag_HardwareEncoder_release_encoder");
        baseHandlerThread.start();
        new Handler(baseHandlerThread.getLooper()).post(new c(runnable, baseHandlerThread));
    }

    private void releaseEncoder() {
        if (this.f423686a == null) {
            return;
        }
        releaseAsync(new b());
    }

    private void releaseOutputBuffer(MediaCodec mediaCodec, int i3, boolean z16) {
        try {
            mediaCodec.releaseOutputBuffer(i3, z16);
        } catch (Exception e16) {
            Log.e("HardwareEncoder", "releaseOutputBuffer: codec.releaseOutputBuffer fail.", e16);
        }
    }

    private synchronized void signalEndOfInputStream() {
        if (this.f423693h) {
            return;
        }
        try {
            this.f423686a.signalEndOfInputStream();
        } catch (Exception e16) {
            Log.e("HardwareEncoder", "signalEndOfInputStream: call encoder.signalEndOfInputStream fail.", e16);
        }
        this.f423693h = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public long f423705a;

        /* renamed from: b, reason: collision with root package name */
        public long f423706b;

        /* renamed from: c, reason: collision with root package name */
        public int f423707c;

        /* renamed from: d, reason: collision with root package name */
        ByteBuffer f423708d;

        /* renamed from: e, reason: collision with root package name */
        boolean f423709e;

        /* renamed from: f, reason: collision with root package name */
        int f423710f;

        /* renamed from: g, reason: collision with root package name */
        int f423711g;

        d() {
            this.f423705a = 0L;
            this.f423706b = 0L;
            this.f423709e = false;
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }
}
