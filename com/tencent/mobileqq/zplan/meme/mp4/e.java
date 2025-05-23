package com.tencent.mobileqq.zplan.meme.mp4;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.mobileqq.highway.netprobe.WeakNetLearner;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes34.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private String f334118a;

    /* renamed from: b, reason: collision with root package name */
    private MediaMuxer f334119b;

    /* renamed from: c, reason: collision with root package name */
    private b f334120c;

    /* renamed from: d, reason: collision with root package name */
    private int f334121d = -1;

    /* renamed from: e, reason: collision with root package name */
    private int f334122e = -1;

    /* renamed from: f, reason: collision with root package name */
    private boolean f334123f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f334124g = false;

    /* renamed from: h, reason: collision with root package name */
    private long f334125h = 0;

    /* renamed from: i, reason: collision with root package name */
    private long f334126i = 0;

    /* renamed from: j, reason: collision with root package name */
    private volatile int f334127j = 0;

    /* renamed from: k, reason: collision with root package name */
    private volatile int f334128k = 0;

    public e(String str, int i3, b bVar) throws Exception {
        this.f334118a = str;
        this.f334120c = bVar;
        this.f334119b = new MediaMuxer(str, i3);
    }

    private void b(int i3, boolean z16) {
        boolean z17 = i3 == this.f334122e;
        if (z17) {
            this.f334127j = z16 ? this.f334127j + 1 : 0;
        } else {
            this.f334128k = z16 ? this.f334128k + 1 : 0;
        }
        if (z17 && this.f334127j >= 10) {
            d(-1105, "continue err");
        } else {
            if (z17 || this.f334128k < 10) {
                return;
            }
            d(-1104, "continue err");
        }
    }

    private void d(int i3, String str) {
        b bVar = this.f334120c;
        if (bVar != null) {
            bVar.onError(i3, str);
        }
        f(false);
    }

    private void f(boolean z16) {
        MediaMuxer mediaMuxer = this.f334119b;
        boolean z17 = true;
        if (mediaMuxer != null && this.f334123f) {
            try {
                mediaMuxer.stop();
                mediaMuxer.release();
            } catch (Throwable th5) {
                QLog.e("SR_MP4_Muxer", 1, "stop error: ", th5);
                if (z16) {
                    d(-1103, "muxer release error");
                }
                z17 = false;
            }
        }
        b bVar = this.f334120c;
        if (z16 && z17 && bVar != null) {
            bVar.a(this.f334118a);
        }
        this.f334119b = null;
        this.f334120c = null;
    }

    private void i(int i3, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        boolean z16 = true;
        if (this.f334124g) {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Muxer", 1, "writeMediaData, interrupt");
            }
        } else if (this.f334123f) {
            MediaMuxer mediaMuxer = this.f334119b;
            if (mediaMuxer != null) {
                try {
                    mediaMuxer.writeSampleData(i3, byteBuffer, bufferInfo);
                } catch (Throwable th5) {
                    QLog.e("SR_MP4_Muxer", 1, "writeSampleData err, ", th5);
                }
            }
            z16 = false;
            b(i3, z16);
        }
    }

    public void a(MediaFormat mediaFormat, boolean z16) {
        if (this.f334124g) {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Muxer", 1, "addTrack, interrupt");
                return;
            }
            return;
        }
        if (this.f334119b == null) {
            QLog.i("SR_MP4_Muxer", 1, "addTrack, muxer is null");
            return;
        }
        if (this.f334123f) {
            QLog.i("SR_MP4_Muxer", 1, "addTrack, already start");
            return;
        }
        if (z16) {
            try {
                if (this.f334121d == -1) {
                    QLog.i("SR_MP4_Muxer", 1, "addTrack video");
                    this.f334121d = this.f334119b.addTrack(mediaFormat);
                    g();
                }
            } catch (Throwable th5) {
                QLog.e("SR_MP4_Muxer", 1, "addTrack error: ", th5);
                d(WeakNetLearner.PROBE_REASON.INVALID_DATA, th5.getMessage());
                return;
            }
        }
        if (!z16 && this.f334122e == -1) {
            QLog.i("SR_MP4_Muxer", 1, "addTrack audio");
            this.f334122e = this.f334119b.addTrack(mediaFormat);
        }
        g();
    }

    public void c() {
        if (this.f334124g) {
            return;
        }
        this.f334124g = true;
        f(false);
    }

    public void g() {
        if (this.f334124g) {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Muxer", 1, "start, interrupt");
                return;
            }
            return;
        }
        if (this.f334123f) {
            QLog.i("SR_MP4_Muxer", 1, "start, already started");
            return;
        }
        if (this.f334121d != -1 && this.f334122e != -1) {
            MediaMuxer mediaMuxer = this.f334119b;
            if (mediaMuxer == null) {
                QLog.i("SR_MP4_Muxer", 1, "start, muxer is null");
                return;
            }
            try {
                mediaMuxer.start();
                this.f334123f = true;
                b bVar = this.f334120c;
                if (bVar != null) {
                    bVar.onStart();
                    return;
                }
                return;
            } catch (Throwable th5) {
                QLog.e("SR_MP4_Muxer", 1, "muxer start error: ", th5);
                d(WeakNetLearner.PROBE_REASON.TRANSACTION_FAIL, "muxer start error, " + th5.getMessage());
                return;
            }
        }
        QLog.i("SR_MP4_Muxer", 1, "start, trackId not ready");
    }

    public void h(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f334124g) {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Muxer", 1, "writeAudioData, interrupt");
                return;
            }
            return;
        }
        long j3 = bufferInfo.presentationTimeUs;
        if (j3 < this.f334126i) {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Muxer", 1, "writeAudioData, time check, ignore, pts:" + bufferInfo.presentationTimeUs + ", last:" + this.f334126i);
                return;
            }
            return;
        }
        this.f334126i = j3;
        int i3 = this.f334122e;
        if (i3 != -1 && this.f334123f) {
            i(i3, byteBuffer, bufferInfo);
        } else if (QLog.isColorLevel()) {
            QLog.d("SR_MP4_Muxer", 1, "writeAudioData, not ready, ignore");
        }
    }

    public void j(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f334124g) {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Muxer", 1, "writeVideoData, interrupt");
                return;
            }
            return;
        }
        long j3 = bufferInfo.presentationTimeUs;
        if (j3 < this.f334125h) {
            if (QLog.isColorLevel()) {
                QLog.d("SR_MP4_Muxer", 1, "writeVideoData, time check, ignore");
                return;
            }
            return;
        }
        this.f334125h = j3;
        int i3 = this.f334121d;
        if (i3 != -1 && this.f334123f) {
            i(i3, byteBuffer, bufferInfo);
        } else if (QLog.isColorLevel()) {
            QLog.d("SR_MP4_Muxer", 1, "writeVideoData, not ready, ignore");
        }
    }

    public void e() {
        f(true);
    }
}
