package com.tencent.mobileqq.videocodec.mediacodec.recorder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.app.bd;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.audio.AudioCapture;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes20.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    b f312591a;

    /* renamed from: b, reason: collision with root package name */
    private bd f312592b;

    /* renamed from: c, reason: collision with root package name */
    private bc f312593c;

    /* renamed from: d, reason: collision with root package name */
    private MediaFormat f312594d;

    /* renamed from: e, reason: collision with root package name */
    private MediaCodec f312595e;

    /* renamed from: f, reason: collision with root package name */
    private MediaMuxer f312596f;

    /* renamed from: g, reason: collision with root package name */
    private MediaCodec.BufferInfo f312597g;

    /* renamed from: h, reason: collision with root package name */
    private long f312598h;

    /* renamed from: i, reason: collision with root package name */
    private int f312599i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f312600j;

    /* renamed from: k, reason: collision with root package name */
    private String f312601k;

    /* renamed from: l, reason: collision with root package name */
    private int f312602l;

    /* renamed from: m, reason: collision with root package name */
    private double f312603m;

    /* renamed from: n, reason: collision with root package name */
    private long f312604n;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.videocodec.mediacodec.recorder.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    class C8955a implements Handler.Callback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        protected WeakReference<a> f312605d;

        public C8955a(a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) aVar);
            } else {
                this.f312605d = new WeakReference<>(aVar);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            a aVar = this.f312605d.get();
            if (aVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.w("HWAudioEncoder", 2, "AudioEncodeHandler.handleMessage: encoder is null");
                }
                return false;
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            a.this.j();
                        } else {
                            throw new RuntimeException("Unhandled msg what=" + i3);
                        }
                    } else {
                        try {
                            a.this.d((String) message.obj);
                        } catch (Exception e16) {
                            QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler start fail.", e16);
                            a.this.g();
                        }
                    }
                } else {
                    a.this.e();
                }
            } else {
                Object[] objArr = (Object[]) message.obj;
                try {
                    aVar.c((byte[]) objArr[0], ((Long) objArr[1]).longValue(), false);
                } catch (Exception e17) {
                    QLog.e("HWAudioEncoder", 1, "AudioEncodeHandler encode audio fail.", e17);
                    a.this.g();
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void a();

        void b();
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f312597g = new MediaCodec.BufferInfo();
        bd newHandlerRecycleThread = ThreadManagerV2.newHandlerRecycleThread("HWAudioEncoder", 0);
        this.f312592b = newHandlerRecycleThread;
        this.f312593c = newHandlerRecycleThread.a(new C8955a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) throws IOException {
        int i3;
        this.f312601k = str;
        MediaFormat mediaFormat = new MediaFormat();
        this.f312594d = mediaFormat;
        mediaFormat.setString("mime", "audio/mp4a-latm");
        int i16 = 16;
        if (CodecParam.mAudioChannel == 16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        this.f312594d.setInteger("channel-count", i3);
        this.f312594d.setInteger("sample-rate", this.f312602l);
        this.f312594d.setInteger("aac-profile", 2);
        this.f312594d.setInteger("bitrate", CodecParam.mDstAudioEncBitrate);
        this.f312594d.setInteger("max-input-size", AudioCapture.E);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("audio/mp4a-latm");
        this.f312595e = createEncoderByType;
        createEncoderByType.configure(this.f312594d, (Surface) null, (MediaCrypto) null, 1);
        this.f312595e.start();
        File file = new File(this.f312601k);
        if (!file.exists()) {
            FileUtils.createFileIfNotExits(file.getAbsolutePath());
        }
        this.f312596f = new MediaMuxer(this.f312601k, 0);
        this.f312599i = 0;
        this.f312600j = false;
        this.f312598h = 0L;
        this.f312597g = new MediaCodec.BufferInfo();
        this.f312604n = 0L;
        if (CodecParam.mAudioFormat != 2) {
            i16 = 8;
        }
        this.f312603m = (((this.f312602l * i16) * i3) / 8) / Math.pow(10.0d, 6.0d);
    }

    public void c(byte[] bArr, long j3, boolean z16) {
        long j16;
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        char c16 = 1;
        int i18 = 2;
        int i19 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bArr, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int length = (int) (bArr.length / this.f312603m);
        this.f312604n += length;
        if (QLog.isColorLevel()) {
            QLog.d("HWAudioEncoder", 2, String.format("handleAudioFrame audioData=%s mAudioDataSize=%s frameTime=%s mLastAudioFrameTime=%s timestampNanos=%s endOfStream=&s", Integer.valueOf(bArr.length), Double.valueOf(this.f312603m), Integer.valueOf(length), Long.valueOf(this.f312604n), Long.valueOf(j3), Boolean.valueOf(z16)));
        }
        ByteBuffer[] inputBuffers = this.f312595e.getInputBuffers();
        int i26 = 0;
        while (true) {
            j16 = 10000;
            int dequeueInputBuffer = this.f312595e.dequeueInputBuffer(10000L);
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[i18];
                objArr[i19] = Integer.valueOf(dequeueInputBuffer);
                objArr[c16] = Integer.valueOf(i26);
                QLog.d("HWAudioEncoder", i18, String.format("handleAudioFrame inputIndex=%s endTryTimes=%s", objArr));
            }
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(bArr);
                this.f312595e.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, this.f312604n, 0);
                i3 = -1;
                break;
            }
            i3 = -1;
            if (dequeueInputBuffer == -1 && (!z16 || (i26 = i26 + 1) > 10)) {
                break;
            }
            i19 = i19;
            c16 = 1;
            i18 = i18;
        }
        ByteBuffer[] outputBuffers = this.f312595e.getOutputBuffers();
        int i27 = i19;
        while (true) {
            int dequeueOutputBuffer = this.f312595e.dequeueOutputBuffer(this.f312597g, j16);
            if (QLog.isColorLevel()) {
                Object[] objArr2 = new Object[i18];
                objArr2[i19] = Integer.valueOf(dequeueOutputBuffer);
                objArr2[1] = Integer.valueOf(i27);
                QLog.d("HWAudioEncoder", i18, String.format("handleAudioFrame outputIndex=%s endTryTimes=%s", objArr2));
            }
            if (dequeueOutputBuffer == i3) {
                if (!z16) {
                    break;
                }
                i27++;
                if (i27 > 10) {
                    break;
                }
                i16 = i19;
                i17 = i18;
            } else {
                if (dequeueOutputBuffer == -2) {
                    this.f312599i = this.f312596f.addTrack(this.f312595e.getOutputFormat());
                    if (!this.f312600j) {
                        this.f312596f.start();
                        this.f312600j = true;
                    }
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.f312595e.getOutputBuffers();
                } else if (dequeueOutputBuffer >= 0) {
                    ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                    MediaCodec.BufferInfo bufferInfo = this.f312597g;
                    if ((bufferInfo.flags & i18) != 0) {
                        bufferInfo.size = i19;
                    }
                    if (bufferInfo.size != 0 && this.f312600j) {
                        byteBuffer2.position(bufferInfo.offset);
                        MediaCodec.BufferInfo bufferInfo2 = this.f312597g;
                        byteBuffer2.limit(bufferInfo2.offset + bufferInfo2.size);
                        if (QLog.isColorLevel()) {
                            Object[] objArr3 = new Object[1];
                            objArr3[i19] = Long.valueOf(this.f312597g.presentationTimeUs);
                            QLog.d("HWAudioEncoder", i18, String.format("handleAudioFrame presentationTimeUs=%s", objArr3));
                        }
                        MediaCodec.BufferInfo bufferInfo3 = this.f312597g;
                        if (bufferInfo3.presentationTimeUs >= this.f312598h) {
                            this.f312596f.writeSampleData(this.f312599i, byteBuffer2, bufferInfo3);
                            this.f312598h = this.f312597g.presentationTimeUs;
                        } else {
                            QLog.e("HWAudioEncoder", 1, "handleAudioFrame audio timestamp revert? throw this frame.");
                        }
                    }
                    this.f312595e.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.f312597g.flags & 4) != 0) {
                        break;
                    }
                    i16 = 0;
                    i17 = 2;
                    i27 = 0;
                }
                i16 = i19;
                i17 = i18;
            }
            i18 = i17;
            i3 = -1;
            j16 = 10000;
            i19 = i16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HWAudioEncoder", 2, String.format("handleAudioFrame time cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        }
    }

    void e() {
        bc bcVar = this.f312593c;
        if (bcVar != null) {
            bcVar.removeCallbacksAndMessages(null);
        }
        if (this.f312595e != null) {
            c(new byte[0], SystemClock.elapsedRealtimeNanos(), true);
            this.f312595e.stop();
            this.f312595e.release();
            this.f312595e = null;
        }
        MediaMuxer mediaMuxer = this.f312596f;
        if (mediaMuxer != null && this.f312600j) {
            this.f312600j = false;
            try {
                try {
                    mediaMuxer.release();
                    if (QLog.isColorLevel()) {
                        QLog.d("HWAudioEncoder", 2, "MediaMuxer stop.");
                    }
                    b bVar = this.f312591a;
                    if (bVar != null) {
                        bVar.b();
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    b bVar2 = this.f312591a;
                    if (bVar2 != null) {
                        bVar2.a();
                    }
                }
            } finally {
                this.f312596f = null;
            }
        }
    }

    public void f(byte[] bArr, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, bArr, Long.valueOf(j3));
        } else if (this.f312593c != null) {
            this.f312593c.obtainMessage(1, new Object[]{bArr, Long.valueOf(SystemClock.elapsedRealtimeNanos())}).sendToTarget();
        }
    }

    public void h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        bc bcVar = this.f312593c;
        if (bcVar != null) {
            bcVar.obtainMessage(3, str).sendToTarget();
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        bc bcVar = this.f312593c;
        if (bcVar != null) {
            bcVar.obtainMessage(2).sendToTarget();
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        bc bcVar = this.f312593c;
        if (bcVar != null) {
            bcVar.removeCallbacksAndMessages(null);
            this.f312593c = null;
        }
        if (this.f312592b != null) {
            this.f312592b = null;
            this.f312593c = null;
        }
    }

    public void k(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else {
            this.f312591a = bVar;
        }
    }

    public void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.f312602l = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
    }
}
