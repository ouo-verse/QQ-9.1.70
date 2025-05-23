package com.tencent.mobileqq.videocodec.mediacodec.encoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.g;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes20.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Surface f312582a;

    /* renamed from: b, reason: collision with root package name */
    private MediaMuxer f312583b;

    /* renamed from: c, reason: collision with root package name */
    private g f312584c;

    /* renamed from: d, reason: collision with root package name */
    private MediaCodec f312585d;

    /* renamed from: e, reason: collision with root package name */
    private MediaCodec.BufferInfo f312586e;

    /* renamed from: f, reason: collision with root package name */
    private String f312587f;

    /* renamed from: g, reason: collision with root package name */
    private int f312588g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f312589h;

    /* renamed from: i, reason: collision with root package name */
    public MediaFormat f312590i;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f312586e = new MediaCodec.BufferInfo();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c8, code lost:
    
        r4 = r0[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ca, code lost:
    
        if (r4 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00d1, code lost:
    
        if ((r9.f312586e.flags & 2) == 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d7, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d9, code lost:
    
        com.tencent.qphone.base.util.QLog.d("HWVideoEncoder", 2, "ignoring BUFFER_FLAG_CODEC_CONFIG");
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00df, code lost:
    
        r9.f312586e.size = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e3, code lost:
    
        r6 = r9.f312586e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00e7, code lost:
    
        if (r6.size == 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e9, code lost:
    
        h(r4, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ec, code lost:
    
        r9.f312585d.releaseOutputBuffer(r5, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x012c, code lost:
    
        throw new java.lang.RuntimeException("encoderOutputBuffer " + r5 + " was null");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("HWVideoEncoder", 2, "drainEncoder(" + z16 + ")");
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("HWVideoEncoder", 2, "sending EOS to encoder");
            }
            this.f312585d.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.f312585d.getOutputBuffers();
        do {
            int i3 = 0;
            while (true) {
                int dequeueOutputBuffer = this.f312585d.dequeueOutputBuffer(this.f312586e, 10000L);
                if (dequeueOutputBuffer == -1) {
                    if (!z16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("HWVideoEncoder", 2, "no output available yet");
                            return;
                        }
                        return;
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("HWVideoEncoder", 2, "no output available, spinning to await EOS");
                        }
                        i3++;
                        if (i3 > 100) {
                            throw new RuntimeException("Encoder is not stopped after dequeue 100 times.");
                        }
                    }
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.f312585d.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.f312585d.getOutputFormat();
                    this.f312590i = outputFormat;
                    e(outputFormat);
                    if (QLog.isColorLevel()) {
                        QLog.d("HWVideoEncoder", 2, "encoder output format changed: " + this.f312590i);
                    }
                } else {
                    if (dequeueOutputBuffer >= 0) {
                        break;
                    }
                    QLog.w("HWVideoEncoder", 2, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                }
            }
        } while ((this.f312586e.flags & 4) == 0);
        if (!z16) {
            QLog.w("HWVideoEncoder", 2, "reached end of stream unexpectedly");
        } else if (QLog.isColorLevel()) {
            QLog.d("HWVideoEncoder", 2, "end of stream reached");
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            a(false);
        }
    }

    public Surface c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Surface) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f312582a;
    }

    public void d() {
        MediaMuxer mediaMuxer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HWVideoEncoder", 2, "HWVideoEncoder release.");
        }
        MediaCodec mediaCodec = this.f312585d;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                if (QLog.isColorLevel()) {
                    QLog.d("HWVideoEncoder", 2, "MediaCodec stop.");
                }
            } catch (Exception e16) {
                QLog.w("HWVideoEncoder", 2, "mEncoder stop exception:" + e16);
            }
            try {
                this.f312585d.release();
                if (QLog.isColorLevel()) {
                    QLog.d("HWVideoEncoder", 2, "MediaCodec release.");
                }
            } catch (Exception e17) {
                QLog.w("HWVideoEncoder", 2, "mEncoder release exception:" + e17);
            }
            this.f312585d = null;
        }
        g gVar = this.f312584c;
        if (gVar == null && (mediaMuxer = this.f312583b) != null) {
            try {
                if (this.f312589h) {
                    this.f312589h = false;
                    mediaMuxer.stop();
                    if (QLog.isColorLevel()) {
                        QLog.d("HWVideoEncoder", 2, "MediaMuxer stop.");
                    }
                }
                this.f312583b.release();
                if (QLog.isColorLevel()) {
                    QLog.d("HWVideoEncoder", 2, "MediaMuxer release.");
                }
            } catch (Exception e18) {
                QLog.w("HWVideoEncoder", 2, "Muxer stop exception:" + e18);
            }
            this.f312583b = null;
            return;
        }
        if (gVar != null) {
            QLog.d("HWVideoEncoder", 1, "HWVideoEncoder release");
            this.f312584c.release();
        }
    }

    public void e(MediaFormat mediaFormat) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) mediaFormat);
            return;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            objArr[0] = "setOutputFormat, ";
            if (this.f312584c == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            objArr[1] = Boolean.valueOf(z16);
            QLog.d("HWVideoEncoder", 2, objArr);
        }
        g gVar = this.f312584c;
        if (gVar == null) {
            if (!this.f312589h) {
                this.f312588g = this.f312583b.addTrack(this.f312590i);
                this.f312583b.start();
                this.f312589h = true;
                return;
            }
            throw new RuntimeException("format changed twice");
        }
        gVar.b(0, mediaFormat);
    }

    public void f(c cVar) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
            return;
        }
        this.f312587f = cVar.f312558c;
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", cVar.f312559d, cVar.f312560e);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", cVar.f312561f);
        createVideoFormat.setInteger("frame-rate", cVar.f312562g);
        createVideoFormat.setInteger("i-frame-interval", cVar.f312563h);
        int i3 = cVar.f312572q;
        if (i3 != -1) {
            createVideoFormat.setInteger("bitrate-mode", i3);
        }
        if (cVar.f312573r != -1) {
            createVideoFormat.setInteger("profile", 8);
            createVideoFormat.setInteger("level", 32768);
        }
        if (cVar.f312570o) {
            createVideoFormat.setInteger("profile", 1);
            createVideoFormat.setInteger("level", 512);
        }
        if (QLog.isColorLevel()) {
            QLog.d("HWVideoEncoder", 2, "start : encodeConfig = + " + cVar.toString() + " ; format: " + createVideoFormat);
        }
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.f312585d = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f312582a = this.f312585d.createInputSurface();
        this.f312585d.start();
        File file = new File(cVar.f312558c);
        if (!file.exists()) {
            FileUtils.createFileIfNotExits(file.getAbsolutePath());
        }
        g gVar = cVar.f312575t;
        this.f312584c = gVar;
        if (gVar == null) {
            MediaMuxer mediaMuxer = new MediaMuxer(cVar.f312558c, 0);
            this.f312583b = mediaMuxer;
            mediaMuxer.setOrientationHint(cVar.f312568m);
        } else {
            this.f312584c = gVar;
            gVar.a().setOrientationHint(cVar.f312568m);
        }
        this.f312588g = -1;
        this.f312589h = false;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HWVideoEncoder", 2, "HWVideoEncoder stop.");
        }
        a(true);
        d();
    }

    public void h(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) byteBuffer, (Object) bufferInfo);
            return;
        }
        g gVar = this.f312584c;
        if (gVar == null) {
            if (this.f312589h) {
                byteBuffer.position(this.f312586e.offset);
                MediaCodec.BufferInfo bufferInfo2 = this.f312586e;
                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                this.f312583b.writeSampleData(this.f312588g, byteBuffer, this.f312586e);
                return;
            }
            throw new RuntimeException("muxer hasn't started");
        }
        gVar.writeSampleData(0, byteBuffer, bufferInfo);
    }
}
