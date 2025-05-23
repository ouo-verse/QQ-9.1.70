package com.tencent.av.ui.funchat.record;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.decoder.EncoderWriter;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private MediaMuxer f75889a;

    /* renamed from: b, reason: collision with root package name */
    private int f75890b;

    /* renamed from: c, reason: collision with root package name */
    private int f75891c;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f75894f;

    /* renamed from: h, reason: collision with root package name */
    private Surface f75896h;

    /* renamed from: i, reason: collision with root package name */
    private MediaCodec f75897i;

    /* renamed from: j, reason: collision with root package name */
    private MediaCodec f75898j;

    /* renamed from: m, reason: collision with root package name */
    private QavVideoAudioRecorder f75901m;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f75892d = false;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f75893e = false;

    /* renamed from: g, reason: collision with root package name */
    private MediaCodec.BufferInfo f75895g = new MediaCodec.BufferInfo();

    /* renamed from: k, reason: collision with root package name */
    private ByteBuffer f75899k = null;

    /* renamed from: l, reason: collision with root package name */
    private long f75900l = 0;

    /* renamed from: n, reason: collision with root package name */
    private long f75902n = 0;

    /* renamed from: o, reason: collision with root package name */
    private long f75903o = 0;

    /* renamed from: p, reason: collision with root package name */
    private long f75904p = 0;

    /* renamed from: q, reason: collision with root package name */
    private boolean f75905q = false;

    public f(QavVideoAudioRecorder qavVideoAudioRecorder) {
        this.f75901m = qavVideoAudioRecorder;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00db, code lost:
    
        r4 = r2[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00dd, code lost:
    
        if (r4 == null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00e4, code lost:
    
        if ((r12.f75895g.flags & 2) == 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ea, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ec, code lost:
    
        com.tencent.qphone.base.util.QLog.d("QavRecordEncoder", 2, "ignoring BUFFER_FLAG_CODEC_CONFIG");
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00f2, code lost:
    
        r12.f75895g.size = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00fa, code lost:
    
        if (r12.f75895g.size == 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00fe, code lost:
    
        if (r12.f75894f == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0100, code lost:
    
        r4.position(r12.f75895g.offset);
        r6 = r12.f75895g;
        r4.limit(r6.offset + r6.size);
        r6 = r12.f75895g;
        r8 = r6.presentationTimeUs;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0119, code lost:
    
        if (r8 < r12.f75903o) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x011b, code lost:
    
        r12.f75903o = r8;
        r12.f75889a.writeSampleData(r12.f75890b, r4, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0125, code lost:
    
        com.tencent.qphone.base.util.QLog.e("QavRecordEncoder", 1, "handleVideoFrame, find older frame");
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x012b, code lost:
    
        r12.f75897i.releaseOutputBuffer(r5, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x016b, code lost:
    
        throw new java.lang.RuntimeException("encoderOutputBuffer " + r5 + " was null");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e(boolean z16) {
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("QavRecordEncoder", 2, "sending EOS to encoder");
            }
            this.f75897i.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.f75897i.getOutputBuffers();
        do {
            int i3 = 0;
            while (true) {
                int dequeueOutputBuffer = this.f75897i.dequeueOutputBuffer(this.f75895g, 10000L);
                if (dequeueOutputBuffer == -1) {
                    if (!z16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QavRecordEncoder", 2, "no output available yet");
                            return;
                        }
                        return;
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("QavRecordEncoder", 2, "no output available, spinning to await EOS");
                        }
                        i3++;
                        if (i3 > 100) {
                            throw new RuntimeException("Encoder is not stopped after dequeue 100 times.");
                        }
                    }
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.f75897i.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (!this.f75892d) {
                        MediaFormat outputFormat = this.f75897i.getOutputFormat();
                        if (QLog.isColorLevel()) {
                            QLog.d("QavRecordEncoder", 2, "encoder output format changed: " + outputFormat);
                        }
                        this.f75890b = this.f75889a.addTrack(outputFormat);
                        if (!this.f75894f && (this.f75893e || this.f75905q)) {
                            this.f75889a.start();
                            this.f75894f = true;
                            g gVar = this.f75901m.f75836d;
                            if (gVar != null) {
                                gVar.a();
                            }
                        }
                        this.f75892d = true;
                        this.f75904p = System.currentTimeMillis();
                    } else {
                        throw new RuntimeException("format changed twice");
                    }
                } else {
                    if (dequeueOutputBuffer >= 0) {
                        break;
                    }
                    QLog.w("QavRecordEncoder", 2, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                }
            }
        } while ((this.f75895g.flags & 4) == 0);
        if (!z16) {
            QLog.w("QavRecordEncoder", 2, "reached end of stream unexpectedly");
        } else if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "end of stream reached");
        }
    }

    public void a(byte[] bArr, long j3) {
        long j16 = this.f75900l;
        this.f75900l = 1 + j16;
        d dVar = new d(bArr, j16);
        dVar.f75867c = j3;
        d(dVar, false);
    }

    public boolean b() {
        if (this.f75893e || this.f75894f) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f75904p <= 2000) {
            return true;
        }
        QLog.d("QavRecordEncoder", 1, "onAudioTrackTimeout has timeout, ready=" + this.f75904p + ", now=" + currentTimeMillis);
        this.f75905q = true;
        MediaMuxer mediaMuxer = this.f75889a;
        if (mediaMuxer != null) {
            mediaMuxer.start();
            this.f75894f = true;
            g gVar = this.f75901m.f75836d;
            if (gVar != null) {
                gVar.a();
            }
        }
        QavRecordReporter.a();
        return false;
    }

    public Surface c() {
        return this.f75896h;
    }

    protected void d(d dVar, boolean z16) {
        int i3;
        int i16;
        int i17;
        if (com.tencent.av.utils.e.k()) {
            QLog.w("QavRecordEncoder", 1, "handleAudioFrame, frame[" + dVar + "], endOfStream[" + z16 + "], mNoAudio[" + this.f75905q + "]");
        }
        if (this.f75905q) {
            return;
        }
        this.f75899k.clear();
        this.f75899k.put(dVar.f75865a);
        this.f75899k.position(dVar.f75865a.length);
        this.f75899k.flip();
        ByteBuffer[] inputBuffers = this.f75898j.getInputBuffers();
        int i18 = 0;
        while (true) {
            int dequeueInputBuffer = this.f75898j.dequeueInputBuffer(10000L);
            i3 = 10;
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(this.f75899k);
                i16 = 2;
                this.f75898j.queueInputBuffer(dequeueInputBuffer, 0, dVar.f75865a.length, dVar.f75867c, 0);
                if (QLog.isColorLevel()) {
                    QLog.d("QavRecordEncoder", 2, "encode, write to codec, size=" + dVar.f75865a.length);
                }
                i17 = -1;
            } else {
                i16 = 2;
                i17 = -1;
                if (dequeueInputBuffer == -1) {
                    if (!z16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QavRecordEncoder", 2, "encode, encode, no output available yet");
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("QavRecordEncoder", 2, "encode, encode, no output available, spinning to await EOS");
                        }
                        i18++;
                        if (i18 > 10) {
                            break;
                        }
                    }
                }
            }
        }
        ByteBuffer[] outputBuffers = this.f75898j.getOutputBuffers();
        int i19 = 0;
        while (true) {
            int dequeueOutputBuffer = this.f75898j.dequeueOutputBuffer(this.f75895g, 10000L);
            if (dequeueOutputBuffer == i17) {
                if (!z16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QavRecordEncoder", i16, "no output available yet");
                        return;
                    }
                    return;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("QavRecordEncoder", i16, "no output available, spinning to await EOS");
                    }
                    i19++;
                    if (i19 > i3) {
                        return;
                    }
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f75898j.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (!this.f75893e) {
                    MediaFormat outputFormat = this.f75898j.getOutputFormat();
                    this.f75891c = this.f75889a.addTrack(outputFormat);
                    if (QLog.isColorLevel()) {
                        QLog.w("QavRecordEncoder", 1, "encoder output format changed, newFormat[" + outputFormat + "], mAudioTrackIndex[" + this.f75891c + "]");
                    }
                    if (!this.f75894f && this.f75892d) {
                        this.f75894f = true;
                        this.f75889a.start();
                        g gVar = this.f75901m.f75836d;
                        if (gVar != null) {
                            gVar.a();
                        }
                    }
                    this.f75893e = true;
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer < 0) {
                QLog.w("QavRecordEncoder", i16, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer2 != null) {
                    if ((this.f75895g.flags & i16) != 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QavRecordEncoder", i16, "ignoring BUFFER_FLAG_CODEC_CONFIG");
                        }
                        this.f75895g.size = 0;
                    }
                    if (this.f75895g.size != 0 && this.f75894f) {
                        byteBuffer2.position(this.f75895g.offset);
                        MediaCodec.BufferInfo bufferInfo = this.f75895g;
                        byteBuffer2.limit(bufferInfo.offset + bufferInfo.size);
                        MediaCodec.BufferInfo bufferInfo2 = this.f75895g;
                        long j3 = bufferInfo2.presentationTimeUs;
                        if (j3 >= this.f75902n) {
                            this.f75902n = j3;
                            this.f75889a.writeSampleData(this.f75891c, byteBuffer2, bufferInfo2);
                        } else {
                            QLog.e("QavRecordEncoder", 1, "handleAudioFrame, find older frame");
                        }
                    }
                    this.f75898j.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.f75895g.flags & 4) != 0) {
                        if (!z16) {
                            QLog.w("QavRecordEncoder", i16, "reached end of stream unexpectedly");
                            return;
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("QavRecordEncoder", i16, "end of stream reached");
                                return;
                            }
                            return;
                        }
                    }
                    i19 = 0;
                    i3 = 10;
                    i17 = -1;
                } else {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
            }
            i3 = 10;
            i17 = -1;
        }
    }

    public void f() {
        MediaCodec mediaCodec = this.f75898j;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
            } catch (Exception e16) {
                QLog.w("QavRecordEncoder", 2, "mAudioCodec stop exception:" + e16);
            }
            try {
                this.f75898j.release();
            } catch (Exception e17) {
                QLog.w("QavRecordEncoder", 2, "mAudioCodec release exception:" + e17);
            }
            this.f75898j = null;
        }
        MediaCodec mediaCodec2 = this.f75897i;
        if (mediaCodec2 != null) {
            try {
                mediaCodec2.stop();
            } catch (Exception e18) {
                QLog.w("QavRecordEncoder", 2, "mVideoCodec stop exception:" + e18);
            }
            try {
                this.f75897i.release();
            } catch (Exception e19) {
                QLog.w("QavRecordEncoder", 2, "mVideoCodec release exception:" + e19);
            }
            this.f75897i = null;
        }
        if (this.f75889a != null) {
            try {
                if (this.f75894f) {
                    this.f75894f = false;
                    this.f75889a.stop();
                }
                this.f75889a.release();
            } catch (Exception e26) {
                QLog.e("QavRecordEncoder", 2, "Muxer stop exception:" + e26, e26);
            }
            this.f75889a = null;
        }
        this.f75890b = -1;
        this.f75891c = -1;
        this.f75892d = false;
        this.f75893e = false;
        this.f75894f = false;
    }

    public void g(com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar) throws IOException {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", cVar.f312559d, cVar.f312560e);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", cVar.f312561f);
        createVideoFormat.setInteger("frame-rate", cVar.f312562g);
        createVideoFormat.setInteger("i-frame-interval", cVar.f312563h);
        if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "VideoFormat: " + createVideoFormat);
        }
        if (this.f75899k == null) {
            this.f75899k = ByteBuffer.allocateDirect(32768);
        }
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.f75897i = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f75896h = this.f75897i.createInputSurface();
        this.f75897i.start();
        this.f75900l = 0L;
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 12);
        createAudioFormat.setInteger("bitrate", EncoderWriter.OUTPUT_AUDIO_BIT_RATE);
        createAudioFormat.setInteger("channel-count", 1);
        createAudioFormat.setInteger("sample-rate", 48000);
        createAudioFormat.setInteger("max-input-size", 32768);
        if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "AudioFormat: " + createAudioFormat);
        }
        MediaCodec createEncoderByType2 = MediaCodec.createEncoderByType("audio/mp4a-latm");
        this.f75898j = createEncoderByType2;
        if (createEncoderByType2 != null) {
            createEncoderByType2.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
            this.f75898j.start();
        }
        File file = new File(cVar.f312558c);
        if (QLog.isColorLevel()) {
            QLog.i("QavRecordEncoder", 2, "start, before check file, exits[" + file.exists() + "]");
        }
        if (!file.exists()) {
            FileUtils.createFileIfNotExits(file.getAbsolutePath());
        }
        if (QLog.isColorLevel()) {
            QLog.i("QavRecordEncoder", 2, "start, end of check file, exits[" + file.exists() + "]");
        }
        MediaMuxer mediaMuxer = new MediaMuxer(cVar.f312558c, 0);
        this.f75889a = mediaMuxer;
        mediaMuxer.setOrientationHint(cVar.f312568m);
        this.f75890b = -1;
        this.f75891c = -1;
        this.f75892d = false;
        this.f75893e = false;
        this.f75894f = false;
        this.f75904p = System.currentTimeMillis() + 99999999;
        this.f75905q = false;
        this.f75903o = 0L;
        this.f75902n = 0L;
        if (this.f75898j == null) {
            this.f75905q = true;
        }
    }

    public void h() {
        if (QLog.isColorLevel()) {
            QLog.d("QavRecordEncoder", 2, "QavRecordEncoder stop.");
        }
        long j3 = this.f75900l;
        this.f75900l = 1 + j3;
        d dVar = new d(new byte[0], j3);
        dVar.f75867c = this.f75902n;
        d(dVar, true);
        e(true);
        f();
        ByteBuffer byteBuffer = this.f75899k;
        if (byteBuffer != null) {
            byteBuffer.clear();
            this.f75899k = null;
        }
    }

    public void i() {
        e(false);
    }
}
