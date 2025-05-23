package com.tencent.mobileqq.zplan.avatar.encoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ApolloVideoEncoder {

    /* renamed from: b, reason: collision with root package name */
    private File f331672b;

    /* renamed from: d, reason: collision with root package name */
    private final List<String> f331674d;

    /* renamed from: e, reason: collision with root package name */
    private int f331675e;

    /* renamed from: f, reason: collision with root package name */
    private MediaCodec f331676f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f331677g;

    /* renamed from: h, reason: collision with root package name */
    private MediaMuxer f331678h;

    /* renamed from: i, reason: collision with root package name */
    private int f331679i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f331680j;

    /* renamed from: k, reason: collision with root package name */
    private int f331681k;

    /* renamed from: l, reason: collision with root package name */
    private int f331682l;

    /* renamed from: m, reason: collision with root package name */
    private int f331683m;

    /* renamed from: n, reason: collision with root package name */
    private a f331684n;

    /* renamed from: a, reason: collision with root package name */
    protected int f331671a = 10;

    /* renamed from: c, reason: collision with root package name */
    private int f331673c = 0;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface a {
        void a(int i3, String str, int i16, int i17);
    }

    public ApolloVideoEncoder(List<String> list, String str, int i3, int i16) {
        ArrayList arrayList = new ArrayList();
        this.f331674d = arrayList;
        this.f331675e = 0;
        this.f331672b = new File(str);
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
        }
        this.f331677g = false;
        this.f331679i = 0;
        this.f331680j = false;
        this.f331682l = i3;
        this.f331683m = i16;
        QLog.i("[zplan]ApolloVideoEncoder", 1, "ApolloVideoEncoder ver1.1, " + Build.BRAND + ", " + DeviceInfoMonitor.getModel() + ", " + Build.VERSION.SDK_INT);
    }

    private void g(boolean z16, MediaCodec.BufferInfo bufferInfo) {
        if (z16) {
            try {
                try {
                    this.f331676f.signalEndOfInputStream();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } catch (Exception e17) {
                QLog.i("[zplan]ApolloVideoEncoder", 1, "drainEncoder error: " + e17.getMessage(), e17);
                o(3, "");
                return;
            }
        }
        while (true) {
            int dequeueOutputBuffer = this.f331676f.dequeueOutputBuffer(bufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z16) {
                    return;
                } else {
                    QLog.i("[zplan]ApolloVideoEncoder", 4, "no output available, spinning to await EOS");
                }
            } else if (dequeueOutputBuffer == -2) {
                if (!this.f331680j) {
                    this.f331679i = this.f331678h.addTrack(this.f331676f.getOutputFormat());
                    this.f331678h.start();
                    this.f331680j = true;
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer < 0) {
                QLog.i("[zplan]ApolloVideoEncoder", 4, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer outputBuffer = this.f331676f.getOutputBuffer(dequeueOutputBuffer);
                if (outputBuffer != null) {
                    if ((bufferInfo.flags & 2) != 0) {
                        QLog.d("[zplan]ApolloVideoEncoder", 4, "ignoring BUFFER_FLAG_CODEC_CONFIG");
                        bufferInfo.size = 0;
                    }
                    if (bufferInfo.size != 0) {
                        if (this.f331680j) {
                            outputBuffer.position(bufferInfo.offset);
                            outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            QLog.d("[zplan]ApolloVideoEncoder", 4, "BufferInfo: " + bufferInfo.offset + ", " + bufferInfo.size + ", " + bufferInfo.presentationTimeUs);
                            try {
                                this.f331678h.writeSampleData(this.f331679i, outputBuffer, bufferInfo);
                            } catch (Exception unused) {
                                QLog.i("[zplan]ApolloVideoEncoder", 4, "Too many frames");
                            }
                        } else {
                            throw new RuntimeException("muxer hasn't started");
                        }
                    }
                    this.f331676f.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((bufferInfo.flags & 4) != 0) {
                        if (!z16) {
                            QLog.i("[zplan]ApolloVideoEncoder", 1, "reached end of stream unexpectedly");
                            o(1, "");
                            return;
                        } else {
                            QLog.i("[zplan]ApolloVideoEncoder", 1, "end of stream reached");
                            return;
                        }
                    }
                } else {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
            }
        }
    }

    private byte[] k(int i3, int i16, Bitmap bitmap) {
        int i17 = i3 * i16;
        try {
            int[] iArr = new int[i17];
            bitmap.getPixels(iArr, 0, i3, 0, 0, i3, i16);
            byte[] bArr = new byte[(i17 * 3) / 2];
            QLog.d("[zplan]ApolloVideoEncoder", 4, "getNV12 " + this.f331681k);
            int i18 = this.f331681k;
            if (i18 != 39) {
                switch (i18) {
                    case 19:
                        com.tencent.mobileqq.zplan.avatar.encoder.a.b(bArr, iArr, i3, i16);
                        break;
                    case 20:
                        com.tencent.mobileqq.zplan.avatar.encoder.a.c(bArr, iArr, i3, i16);
                        break;
                    case 21:
                        com.tencent.mobileqq.zplan.avatar.encoder.a.e(bArr, iArr, i3, i16);
                        break;
                }
            } else {
                com.tencent.mobileqq.zplan.avatar.encoder.a.d(bArr, iArr, i3, i16);
            }
            return bArr;
        } catch (OutOfMemoryError e16) {
            QLog.e("[zplan]ApolloVideoEncoder", 1, "getNV12 OOM", e16);
            System.gc();
            return null;
        }
    }

    private Bitmap l() {
        Bitmap bitmap;
        if (!this.f331674d.isEmpty() && this.f331675e < this.f331674d.size()) {
            try {
                String str = this.f331674d.get(this.f331675e);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getNextBitmap ");
                sb5.append(this.f331675e);
                sb5.append(", ");
                sb5.append(str);
                sb5.append(MsgSummary.STR_COLON);
                int i3 = 0;
                sb5.append(decodeFile == null ? 0 : decodeFile.getByteCount());
                QLog.d("[zplan]ApolloVideoEncoder", 4, sb5.toString());
                this.f331675e++;
                if (decodeFile != null) {
                    bitmap = Bitmap.createScaledBitmap(decodeFile, this.f331682l, this.f331683m, true);
                    if (decodeFile != bitmap) {
                        decodeFile.recycle();
                    }
                } else {
                    bitmap = null;
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append("getNextBitmap ");
                sb6.append(this.f331675e);
                sb6.append(", ");
                sb6.append(str);
                sb6.append(MsgSummary.STR_COLON);
                if (bitmap != null) {
                    i3 = bitmap.getByteCount();
                }
                sb6.append(i3);
                QLog.d("[zplan]ApolloVideoEncoder", 4, sb6.toString());
                return bitmap;
            } catch (OutOfMemoryError e16) {
                QLog.e("[zplan]ApolloVideoEncoder", 1, "getNextBitmap error", e16);
                System.gc();
            }
        }
        return null;
    }

    private int m(int i3) {
        return (i3 / 4) * 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0039. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean n(int i3, int i16) {
        int i17 = this.f331673c;
        if (i17 == 0) {
            i17 = i(i3, i16);
        }
        QLog.i("[zplan]ApolloVideoEncoder", 1, "bitrate = " + i17);
        int[] j3 = j();
        if (j3 == null) {
            QLog.e("[zplan]ApolloVideoEncoder", 1, "getMediaCodecList returns null");
            return false;
        }
        try {
            for (int i18 : j3) {
                if (i18 != 39) {
                    switch (i18) {
                        case 19:
                            QLog.i("[zplan]ApolloVideoEncoder", 1, "COLOR_FormatYUV420Planar");
                            this.f331681k = i18;
                            break;
                        case 20:
                            QLog.i("[zplan]ApolloVideoEncoder", 1, "COLOR_FormatYUV420PackedPlanar");
                            this.f331681k = i18;
                            break;
                        case 21:
                            QLog.i("[zplan]ApolloVideoEncoder", 1, "COLOR_FormatYUV420SemiPlanar");
                            this.f331681k = i18;
                            break;
                    }
                } else {
                    QLog.i("[zplan]ApolloVideoEncoder", 1, "COLOR_FormatYUV420PackedSemiPlanar");
                    this.f331681k = i18;
                }
                if (this.f331681k > 0) {
                    if (this.f331681k <= 0) {
                        this.f331681k = 21;
                    }
                    MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i3, i16);
                    createVideoFormat.setInteger("color-format", this.f331681k);
                    createVideoFormat.setInteger("bitrate", i17);
                    createVideoFormat.setInteger("frame-rate", this.f331671a);
                    createVideoFormat.setInteger("i-frame-interval", 0);
                    this.f331676f = MediaCodec.createEncoderByType("video/avc");
                    this.f331678h = new MediaMuxer(this.f331672b.getAbsolutePath(), 0);
                    this.f331676f.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                    this.f331676f.start();
                    this.f331677g = true;
                    return true;
                }
            }
            this.f331676f = MediaCodec.createEncoderByType("video/avc");
            this.f331678h = new MediaMuxer(this.f331672b.getAbsolutePath(), 0);
            this.f331676f.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            this.f331676f.start();
            this.f331677g = true;
            return true;
        } catch (Exception e16) {
            QLog.e("[zplan]ApolloVideoEncoder", 1, "init error video/avc, " + this.f331681k, e16);
            o(4, "");
            return false;
        }
        if (this.f331681k <= 0) {
        }
        MediaFormat createVideoFormat2 = MediaFormat.createVideoFormat("video/avc", i3, i16);
        createVideoFormat2.setInteger("color-format", this.f331681k);
        createVideoFormat2.setInteger("bitrate", i17);
        createVideoFormat2.setInteger("frame-rate", this.f331671a);
        createVideoFormat2.setInteger("i-frame-interval", 0);
    }

    private void o(int i3, String str) {
        if (this.f331684n != null) {
            h();
            this.f331684n.a(i3, str, this.f331682l, this.f331683m);
            this.f331684n = null;
        }
    }

    protected int i(int i3, int i16) {
        return i3 * i16;
    }

    public int[] j() {
        int codecCount = MediaCodecList.getCodecCount();
        MediaCodecInfo mediaCodecInfo = null;
        int i3 = 0;
        while (true) {
            boolean z16 = true;
            if (i3 >= codecCount || mediaCodecInfo != null) {
                break;
            }
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                int i16 = 0;
                while (true) {
                    if (i16 >= supportedTypes.length) {
                        z16 = false;
                        break;
                    }
                    if (supportedTypes[i16].equals("video/avc")) {
                        break;
                    }
                    i16++;
                }
                if (z16) {
                    mediaCodecInfo = codecInfoAt;
                }
            }
            i3++;
        }
        if (mediaCodecInfo == null) {
            return null;
        }
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
        QLog.i("[zplan]ApolloVideoEncoder", 1, "getMediaCodecList " + mediaCodecInfo.getName());
        return capabilitiesForType.colorFormats;
    }

    public void p(int i3) {
        this.f331673c = i3;
    }

    public void q(int i3) {
        this.f331671a = i3;
    }

    public void r(a aVar) {
        this.f331684n = aVar;
    }

    public void s() {
        File file = this.f331672b;
        if (file != null && !TextUtils.isEmpty(file.getAbsolutePath())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.encoder.ApolloVideoEncoder.1
                @Override // java.lang.Runnable
                public void run() {
                    ApolloVideoEncoder apolloVideoEncoder = ApolloVideoEncoder.this;
                    if (apolloVideoEncoder.n(apolloVideoEncoder.f331682l, ApolloVideoEncoder.this.f331683m)) {
                        ApolloVideoEncoder.this.f();
                    }
                }
            }, 16, null, true);
        } else {
            QLog.e("[zplan]ApolloVideoEncoder", 1, "cannot start due to empty output path");
        }
    }

    public void h() {
        this.f331677g = false;
        MediaCodec mediaCodec = this.f331676f;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                this.f331676f.release();
            } catch (Exception e16) {
                QLog.e("[zplan]ApolloVideoEncoder", 1, "finish media codec error: " + e16.getMessage(), e16);
            }
        }
        MediaMuxer mediaMuxer = this.f331678h;
        if (mediaMuxer != null) {
            try {
                if (this.f331680j) {
                    mediaMuxer.stop();
                    this.f331678h.release();
                }
            } catch (Exception e17) {
                QLog.e("[zplan]ApolloVideoEncoder", 1, "finish media muxer error: " + e17.getMessage(), e17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        String str;
        if (this.f331676f != null && this.f331678h != null) {
            this.f331677g = true;
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            long j3 = 0;
            while (this.f331677g) {
                int dequeueInputBuffer = this.f331676f.dequeueInputBuffer(10000L);
                QLog.d("[zplan]ApolloVideoEncoder", 4, "run " + dequeueInputBuffer);
                if (dequeueInputBuffer >= 0) {
                    long e16 = e(j3);
                    if (j3 >= this.f331674d.size()) {
                        this.f331676f.queueInputBuffer(dequeueInputBuffer, 0, 0, e16, 4);
                        this.f331677g = false;
                        g(true, bufferInfo);
                    } else {
                        Bitmap l3 = l();
                        int i3 = this.f331675e - 1;
                        if (i3 >= this.f331674d.size() || i3 < 0) {
                            str = "";
                        } else {
                            str = this.f331674d.get(i3);
                        }
                        if (l3 == null) {
                            QLog.e("[zplan]ApolloVideoEncoder", 1, "getNextBitmap returns null: " + str);
                            o(2, "");
                            return;
                        }
                        byte[] k3 = k(m(l3.getWidth()), m(l3.getHeight()), l3);
                        l3.recycle();
                        if (k3 == null) {
                            QLog.e("[zplan]ApolloVideoEncoder", 1, "getNV12 returns null: " + str);
                            o(6, "");
                            return;
                        }
                        ByteBuffer inputBuffer = this.f331676f.getInputBuffer(dequeueInputBuffer);
                        inputBuffer.clear();
                        inputBuffer.put(k3);
                        this.f331676f.queueInputBuffer(dequeueInputBuffer, 0, k3.length, e16, 0);
                        g(false, bufferInfo);
                    }
                    j3++;
                } else {
                    QLog.i("[zplan]ApolloVideoEncoder", 4, "input buffer not available");
                    try {
                        LockMethodProxy.sleep(50L);
                    } catch (InterruptedException e17) {
                        e17.printStackTrace();
                    }
                }
            }
            MediaCodec mediaCodec = this.f331676f;
            if (mediaCodec != null) {
                try {
                    mediaCodec.flush();
                } catch (Exception e18) {
                    QLog.e("[zplan]ApolloVideoEncoder", 1, "flush error: " + e18.getMessage(), e18);
                    o(5, "");
                    return;
                }
            }
            o(0, this.f331672b.getAbsolutePath());
            return;
        }
        QLog.e("[zplan]ApolloVideoEncoder", 1, "doStart exits due to codec or muxer null: " + this.f331676f + ", " + this.f331678h);
    }

    protected long e(long j3) {
        return (((float) ((j3 * 1000000) / this.f331671a)) * 1.8f) + 100.0f;
    }
}
