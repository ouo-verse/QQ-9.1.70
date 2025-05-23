package com.tencent.aelight.camera.ae.gif.video;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c {

    /* renamed from: j, reason: collision with root package name */
    private static String f65550j = "c";

    /* renamed from: e, reason: collision with root package name */
    private MediaExtractor f65555e;

    /* renamed from: f, reason: collision with root package name */
    private MediaCodec f65556f;

    /* renamed from: a, reason: collision with root package name */
    private final long f65551a = 0;

    /* renamed from: b, reason: collision with root package name */
    private final long f65552b = TTL.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    private int f65553c = 0;

    /* renamed from: d, reason: collision with root package name */
    private MediaCodec.BufferInfo f65554d = new MediaCodec.BufferInfo();

    /* renamed from: g, reason: collision with root package name */
    private long f65557g = 0;

    /* renamed from: h, reason: collision with root package name */
    private String f65558h = "";

    /* renamed from: i, reason: collision with root package name */
    private boolean f65559i = false;

    private void c(Surface surface) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        this.f65555e = mediaExtractor;
        try {
            mediaExtractor.setDataSource(this.f65558h);
        } catch (IOException e16) {
            QLog.e(f65550j, 4, "video decoder media extractor setDataSource() exception, msg = " + e16.getMessage());
        }
        int trackCount = this.f65555e.getTrackCount();
        int i3 = 0;
        while (true) {
            if (i3 >= trackCount) {
                break;
            }
            if (this.f65555e.getTrackFormat(i3).getString("mime").contains("video")) {
                this.f65553c = i3;
                break;
            }
            i3++;
        }
        int i16 = this.f65553c;
        if (i16 == -1) {
            this.f65555e.release();
            return;
        }
        MediaFormat trackFormat = this.f65555e.getTrackFormat(i16);
        try {
            this.f65556f = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
        } catch (IOException e17) {
            QLog.e(f65550j, 4, "video decoder media codec create exception, msg = " + e17.getMessage());
        }
        this.f65556f.configure(trackFormat, surface, (MediaCrypto) null, 0);
        this.f65556f.start();
        this.f65555e.selectTrack(this.f65553c);
        this.f65555e.seekTo(0L, 0);
    }

    public boolean a() {
        int dequeueInputBuffer;
        QLog.e(f65550j, 4, "decodeToSurface start");
        while (!Thread.interrupted()) {
            QLog.e(f65550j, 4, "decodeToSurface loop");
            if (!this.f65559i && (dequeueInputBuffer = this.f65556f.dequeueInputBuffer(10000L)) >= 0) {
                int readSampleData = this.f65555e.readSampleData(this.f65556f.getInputBuffers()[dequeueInputBuffer], 0);
                if (readSampleData < 0) {
                    QLog.e(f65550j, 4, "decodeToSurface BUFFER_FLAG_END_OF_STREAM");
                    this.f65556f.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                    this.f65559i = true;
                } else {
                    QLog.e(f65550j, 4, "decodeToSurface mediaCodec.queueInputBuffer");
                    this.f65556f.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, this.f65555e.getSampleTime(), 0);
                    this.f65555e.advance();
                }
            }
            int dequeueOutputBuffer = this.f65556f.dequeueOutputBuffer(this.f65554d, 10000L);
            QLog.e(f65550j, 4, "mediaCodec.dequeueOutputBuffer, outputBufferIndex = ", Integer.valueOf(dequeueOutputBuffer));
            if (dequeueOutputBuffer != -3 && dequeueOutputBuffer != -2 && dequeueOutputBuffer != -1) {
                this.f65557g = this.f65554d.presentationTimeUs;
                QLog.e(f65550j, 4, "mediaCodec.releaseOutputBuffer, outputBufferIndex = ", Integer.valueOf(dequeueOutputBuffer), ", timestamp = ", Long.valueOf(this.f65557g));
                boolean z16 = (this.f65554d.flags & 4) != 0;
                this.f65556f.releaseOutputBuffer(dequeueOutputBuffer, !z16);
                if (!z16) {
                    return true;
                }
                QLog.e(f65550j, 4, "decodeToSurface decode complete");
                return false;
            }
        }
        return false;
    }

    public void b(String str, Surface surface) {
        try {
            this.f65558h = str;
            c(surface);
        } catch (Exception e16) {
            QLog.e(f65550j, 4, "video decoder init exception, msg = " + e16.getMessage());
        }
    }

    public void d() {
        try {
            this.f65555e.unselectTrack(this.f65553c);
            this.f65555e.release();
            this.f65556f.stop();
            this.f65556f.release();
        } catch (Exception e16) {
            QLog.e(f65550j, 4, "video decoder exception, msg = " + e16.getMessage());
        }
    }

    public void e() {
        if (this.f65559i) {
            this.f65559i = false;
            this.f65555e.seekTo(0L, 1);
            this.f65556f.flush();
        }
    }
}
