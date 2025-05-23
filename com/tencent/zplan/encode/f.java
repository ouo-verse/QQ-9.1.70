package com.tencent.zplan.encode;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.mobileqq.highway.netprobe.WeakNetLearner;
import java.io.File;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private String f385375a;

    /* renamed from: b, reason: collision with root package name */
    private MediaMuxer f385376b;

    /* renamed from: c, reason: collision with root package name */
    private c f385377c;

    /* renamed from: f, reason: collision with root package name */
    private boolean f385380f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f385381g;

    /* renamed from: d, reason: collision with root package name */
    private int f385378d = -1;

    /* renamed from: e, reason: collision with root package name */
    private int f385379e = -1;

    /* renamed from: h, reason: collision with root package name */
    private boolean f385382h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f385383i = false;

    /* renamed from: j, reason: collision with root package name */
    private long f385384j = 0;

    /* renamed from: k, reason: collision with root package name */
    private long f385385k = 0;

    /* renamed from: l, reason: collision with root package name */
    private volatile int f385386l = 0;

    /* renamed from: m, reason: collision with root package name */
    private volatile int f385387m = 0;

    public f(String str, int i3, c cVar, Boolean bool, Boolean bool2) throws Exception {
        this.f385380f = true;
        this.f385381g = true;
        this.f385375a = str;
        this.f385377c = cVar;
        File file = new File(str);
        if (file.isDirectory() && !file.exists()) {
            file.mkdirs();
        } else {
            File file2 = new File(file.getParent());
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
        this.f385380f = bool.booleanValue();
        this.f385381g = bool2.booleanValue();
        this.f385376b = new MediaMuxer(str, i3);
    }

    private void b(int i3, boolean z16) {
        boolean z17 = i3 == this.f385379e;
        if (z17) {
            this.f385386l = z16 ? this.f385386l + 1 : 0;
        } else {
            this.f385387m = z16 ? this.f385387m + 1 : 0;
        }
        if (z17 && this.f385386l >= 10) {
            d(-1105, "continue err");
        } else {
            if (z17 || this.f385387m < 10) {
                return;
            }
            d(-1104, "continue err");
        }
    }

    private void d(int i3, String str) {
        c cVar = this.f385377c;
        if (cVar != null) {
            cVar.onError(i3, str);
        }
        f(false);
    }

    private void f(boolean z16) {
        MediaMuxer mediaMuxer = this.f385376b;
        boolean z17 = true;
        if (mediaMuxer != null && this.f385382h) {
            try {
                mediaMuxer.stop();
                mediaMuxer.release();
            } catch (Throwable th5) {
                d.c("SR_MP4_Muxer", 1, "stop error: ", th5);
                if (z16) {
                    d(-1103, "muxer release error");
                }
                z17 = false;
            }
        }
        c cVar = this.f385377c;
        if (z16 && z17 && cVar != null) {
            cVar.a(this.f385375a);
        }
        this.f385376b = null;
        this.f385377c = null;
    }

    private void i(int i3, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        d.a("SR_MP4_Muxer", 2, "writeMediaData trackId:" + i3);
        boolean z16 = true;
        if (this.f385383i) {
            if (d.f()) {
                d.a("SR_MP4_Muxer", 1, "writeMediaData, interrupt");
            }
        } else if (this.f385382h) {
            MediaMuxer mediaMuxer = this.f385376b;
            if (mediaMuxer != null) {
                try {
                    mediaMuxer.writeSampleData(i3, byteBuffer, bufferInfo);
                    d.a("SR_MP4_Muxer", 1, "writeSampleData");
                } catch (Throwable th5) {
                    d.c("SR_MP4_Muxer", 1, "writeSampleData err, ", th5);
                }
            }
            z16 = false;
            b(i3, z16);
        }
    }

    public void a(MediaFormat mediaFormat, boolean z16) {
        if (this.f385383i) {
            if (d.f()) {
                d.a("SR_MP4_Muxer", 1, "addTrack, interrupt");
                return;
            }
            return;
        }
        if (this.f385376b == null) {
            d.e("SR_MP4_Muxer", 1, "addTrack, muxer is null");
            return;
        }
        if (this.f385382h) {
            d.e("SR_MP4_Muxer", 1, "addTrack, already start");
            return;
        }
        if (z16) {
            try {
                if (this.f385378d == -1) {
                    d.e("SR_MP4_Muxer", 1, "addTrack video");
                    this.f385378d = this.f385376b.addTrack(mediaFormat);
                    g();
                }
            } catch (Throwable th5) {
                d.c("SR_MP4_Muxer", 1, "addTrack error: ", th5);
                d(WeakNetLearner.PROBE_REASON.INVALID_DATA, th5.getMessage());
                return;
            }
        }
        if (!z16 && this.f385379e == -1) {
            d.e("SR_MP4_Muxer", 1, "addTrack audio");
            this.f385379e = this.f385376b.addTrack(mediaFormat);
        }
        g();
    }

    public void c() {
        if (this.f385383i) {
            return;
        }
        this.f385383i = true;
        f(false);
    }

    public void g() {
        if (this.f385383i) {
            if (d.f()) {
                d.a("SR_MP4_Muxer", 1, "start, interrupt");
                return;
            }
            return;
        }
        if (this.f385382h) {
            d.e("SR_MP4_Muxer", 1, "start, already started");
            return;
        }
        if (this.f385380f && this.f385378d == -1) {
            d.e("SR_MP4_Muxer", 1, "start, video trackId not ready videoTrackId:" + this.f385378d);
            return;
        }
        if (this.f385381g && this.f385379e == -1) {
            d.e("SR_MP4_Muxer", 1, "start, audio trackId not ready audioTrackId:" + this.f385379e);
            return;
        }
        MediaMuxer mediaMuxer = this.f385376b;
        if (mediaMuxer == null) {
            d.e("SR_MP4_Muxer", 1, "start, muxer is null");
            return;
        }
        try {
            mediaMuxer.start();
            this.f385382h = true;
            c cVar = this.f385377c;
            if (cVar != null) {
                cVar.onStart();
            }
        } catch (Throwable th5) {
            d.c("SR_MP4_Muxer", 1, "muxer start error: ", th5);
            d(WeakNetLearner.PROBE_REASON.TRANSACTION_FAIL, "muxer start error, " + th5.getMessage());
        }
    }

    public void h(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f385383i) {
            if (d.f()) {
                d.a("SR_MP4_Muxer", 1, "writeAudioData, interrupt");
                return;
            }
            return;
        }
        long j3 = bufferInfo.presentationTimeUs;
        if (j3 < this.f385385k) {
            if (d.f()) {
                d.a("SR_MP4_Muxer", 1, "writeAudioData, time check, ignore, pts:" + bufferInfo.presentationTimeUs + ", last:" + this.f385385k);
                return;
            }
            return;
        }
        this.f385385k = j3;
        int i3 = this.f385379e;
        if (i3 != -1 && this.f385382h) {
            i(i3, byteBuffer, bufferInfo);
        } else if (d.f()) {
            d.a("SR_MP4_Muxer", 1, "writeAudioData, not ready, ignore");
        }
    }

    public void e() {
        f(true);
    }

    public void j(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        d.a("SR_MP4_Muxer", 2, "writeVideoData");
        if (this.f385383i) {
            if (d.f()) {
                d.a("SR_MP4_Muxer", 1, "writeVideoData, interrupt");
                return;
            }
            return;
        }
        long j3 = bufferInfo.presentationTimeUs;
        if (j3 < this.f385384j) {
            if (d.f()) {
                d.a("SR_MP4_Muxer", 1, "writeVideoData, time check, ignore");
                return;
            }
            return;
        }
        this.f385384j = j3;
        int i3 = this.f385378d;
        if (i3 != -1 && this.f385382h) {
            i(i3, byteBuffer, bufferInfo);
        } else if (d.f()) {
            d.a("SR_MP4_Muxer", 1, "writeVideoData, not ready, ignore videoTrackId:" + this.f385378d);
        }
    }
}
