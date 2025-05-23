package com.tencent.aelight.camera.ae.gif.video;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d {

    /* renamed from: p, reason: collision with root package name */
    private static String f65560p = "d";

    /* renamed from: d, reason: collision with root package name */
    private MediaExtractor f65564d;

    /* renamed from: e, reason: collision with root package name */
    private MediaCodec f65565e;

    /* renamed from: f, reason: collision with root package name */
    private ByteBuffer f65566f;

    /* renamed from: l, reason: collision with root package name */
    private int f65572l;

    /* renamed from: a, reason: collision with root package name */
    private int f65561a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f65562b = 0;

    /* renamed from: c, reason: collision with root package name */
    private MediaCodec.BufferInfo f65563c = new MediaCodec.BufferInfo();

    /* renamed from: g, reason: collision with root package name */
    private long f65567g = 0;

    /* renamed from: h, reason: collision with root package name */
    private long f65568h = 0;

    /* renamed from: i, reason: collision with root package name */
    private long f65569i = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f65570j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f65571k = 0;

    /* renamed from: m, reason: collision with root package name */
    private long f65573m = 0;

    /* renamed from: n, reason: collision with root package name */
    private String f65574n = "";

    /* renamed from: o, reason: collision with root package name */
    private boolean f65575o = false;

    private void g(Surface surface) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        this.f65564d = mediaExtractor;
        try {
            mediaExtractor.setDataSource(this.f65574n);
        } catch (IOException e16) {
            QLog.e(f65560p, 4, "video decoder media extractor setDataSource() exception, msg = " + e16.getMessage());
        }
        int trackCount = this.f65564d.getTrackCount();
        int i3 = 0;
        while (true) {
            if (i3 >= trackCount) {
                break;
            }
            if (this.f65564d.getTrackFormat(i3).getString("mime").contains("video")) {
                this.f65561a = i3;
                break;
            }
            i3++;
        }
        int i16 = this.f65561a;
        if (i16 == -1) {
            this.f65564d.release();
            return;
        }
        MediaFormat trackFormat = this.f65564d.getTrackFormat(i16);
        String string = trackFormat.getString("mime");
        int integer = trackFormat.getInteger("max-input-size");
        this.f65562b = integer;
        this.f65566f = ByteBuffer.allocate(integer);
        try {
            this.f65565e = MediaCodec.createDecoderByType(string);
        } catch (IOException e17) {
            QLog.e(f65560p, 4, "video decoder media codec create exception, msg = " + e17.getMessage());
        }
        this.f65565e.configure(trackFormat, surface, (MediaCrypto) null, 0);
        this.f65565e.start();
        this.f65564d.selectTrack(this.f65561a);
        this.f65564d.seekTo(this.f65567g * 1000, 0);
    }

    private void h(String str, float f16, long j3) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                this.f65574n = str;
                mediaMetadataRetriever.setDataSource(str);
                this.f65572l = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                this.f65570j = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                this.f65571k = parseInt;
                int i3 = this.f65572l;
                if (i3 == 90 || i3 == 270) {
                    int i16 = this.f65570j;
                    this.f65570j = parseInt;
                    this.f65571k = i16;
                }
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                this.f65573m = parseLong;
                long j16 = ((float) parseLong) * f16;
                this.f65567g = j16;
                this.f65568h = j16 + j3;
            } catch (Exception e16) {
                QLog.e(f65560p, 4, "video decoder init parameters exception, msg = " + e16.getMessage());
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    private void i(String str, long j3, long j16) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                this.f65574n = str;
                this.f65567g = j3;
                this.f65568h = j16;
                mediaMetadataRetriever.setDataSource(str);
                this.f65572l = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                this.f65570j = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                this.f65571k = parseInt;
                int i3 = this.f65572l;
                if (i3 == 90 || i3 == 270) {
                    int i16 = this.f65570j;
                    this.f65570j = parseInt;
                    this.f65571k = i16;
                }
                this.f65573m = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
            } catch (Exception e16) {
                QLog.e(f65560p, 4, "video decoder init parameters exception, msg = " + e16.getMessage());
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public boolean a() {
        int dequeueInputBuffer;
        QLog.e(f65560p, 4, "decodeToSurface start");
        while (!Thread.interrupted()) {
            QLog.e(f65560p, 4, "decodeToSurface loop");
            if (!this.f65575o && (dequeueInputBuffer = this.f65565e.dequeueInputBuffer(10000L)) >= 0) {
                int readSampleData = this.f65564d.readSampleData(this.f65565e.getInputBuffers()[dequeueInputBuffer], 0);
                if (readSampleData < 0) {
                    QLog.e(f65560p, 4, "decodeToSurface BUFFER_FLAG_END_OF_STREAM");
                    this.f65565e.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                    this.f65575o = true;
                } else {
                    QLog.e(f65560p, 4, "decodeToSurface mediaCodec.queueInputBuffer");
                    this.f65565e.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, this.f65564d.getSampleTime(), 0);
                    this.f65564d.advance();
                }
            }
            int dequeueOutputBuffer = this.f65565e.dequeueOutputBuffer(this.f65563c, 10000L);
            QLog.e(f65560p, 4, "mediaCodec.dequeueOutputBuffer, outputBufferIndex = ", Integer.valueOf(dequeueOutputBuffer));
            MediaCodec.BufferInfo bufferInfo = this.f65563c;
            if ((bufferInfo.flags & 4) != 0) {
                QLog.e(f65560p, 4, "decodeToSurface decode complete");
                return false;
            }
            if (dequeueOutputBuffer != -3 && dequeueOutputBuffer != -2 && dequeueOutputBuffer != -1) {
                this.f65569i = bufferInfo.presentationTimeUs;
                QLog.e(f65560p, 4, "mediaCodec.releaseOutputBuffer, outputBufferIndex = ", Integer.valueOf(dequeueOutputBuffer), ", timestamp = ", Long.valueOf(this.f65569i));
                this.f65565e.releaseOutputBuffer(dequeueOutputBuffer, this.f65569i < this.f65568h * 1000);
                return this.f65569i < this.f65568h * 1000;
            }
        }
        return false;
    }

    public int b() {
        return this.f65572l;
    }

    public int c() {
        return this.f65571k;
    }

    public int d() {
        return this.f65570j;
    }

    public void e(String str, float f16, long j3, Surface surface) {
        try {
            h(str, f16, j3);
            g(surface);
        } catch (Exception e16) {
            QLog.e(f65560p, 4, "video decoder init exception, msg = " + e16.getMessage());
        }
    }

    public void f(String str, long j3, long j16, Surface surface) {
        try {
            i(str, j3, j16);
            g(surface);
        } catch (Exception e16) {
            QLog.e(f65560p, 4, "video decoder init exception, msg = " + e16.getMessage());
        }
    }

    public void j() {
        try {
            this.f65564d.unselectTrack(this.f65561a);
            this.f65564d.release();
            this.f65565e.stop();
            this.f65565e.release();
        } catch (Exception e16) {
            QLog.e(f65560p, 4, "video decoder exception, msg = " + e16.getMessage());
        }
    }
}
