package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.avcore.jni.codec.MediaCodecConstants;
import com.tencent.liteav.base.storage.PersistStorage;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.videobase.e;
import com.tencent.liteav.videoconsumer.decoder.SpsInfo;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.encoder.e;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import com.tencent.liteav.videoproducer.producer.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public String f119693a;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f119694b;

    /* renamed from: c, reason: collision with root package name */
    public CustomHandler f119695c;

    /* renamed from: d, reason: collision with root package name */
    public MediaCodec f119696d;

    /* renamed from: e, reason: collision with root package name */
    public e.a f119697e;

    /* renamed from: f, reason: collision with root package name */
    public VideoEncodeParams f119698f;

    /* renamed from: l, reason: collision with root package name */
    private final com.tencent.liteav.videobase.videobase.c f119704l;

    /* renamed from: y, reason: collision with root package name */
    private ServerVideoProducerConfig f119717y;

    /* renamed from: n, reason: collision with root package name */
    private byte[] f119706n = null;

    /* renamed from: o, reason: collision with root package name */
    private boolean f119707o = true;

    /* renamed from: g, reason: collision with root package name */
    public long f119699g = 0;

    /* renamed from: h, reason: collision with root package name */
    public r f119700h = null;

    /* renamed from: p, reason: collision with root package name */
    private long f119708p = 0;

    /* renamed from: q, reason: collision with root package name */
    private long f119709q = 0;

    /* renamed from: r, reason: collision with root package name */
    private long f119710r = 0;

    /* renamed from: s, reason: collision with root package name */
    private int f119711s = -1;

    /* renamed from: i, reason: collision with root package name */
    public final Deque<Long> f119701i = new LinkedList();

    /* renamed from: t, reason: collision with root package name */
    private long f119712t = 0;

    /* renamed from: u, reason: collision with root package name */
    private long f119713u = 0;

    /* renamed from: v, reason: collision with root package name */
    private long f119714v = 0;

    /* renamed from: w, reason: collision with root package name */
    private long f119715w = Long.MIN_VALUE;

    /* renamed from: x, reason: collision with root package name */
    private boolean f119716x = false;

    /* renamed from: z, reason: collision with root package name */
    private double f119718z = 0.0d;
    private long A = 0;
    private long B = 0;
    private long C = 0;
    private long D = 0;
    private long E = 0;
    private final Deque<Long> F = new LinkedList();
    private int G = 0;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicLong f119702j = new AtomicLong(0);
    private final List<Long> H = new ArrayList();
    private final AtomicLong I = new AtomicLong(0);

    /* renamed from: k, reason: collision with root package name */
    public final Runnable f119703k = c.a(this);

    /* renamed from: m, reason: collision with root package name */
    private final a.EnumC5954a f119705m = a.EnumC5954a.STREAM_TYPE_BIG_VIDEO;

    public b(Bundle bundle, com.tencent.liteav.videobase.videobase.c cVar, String str) {
        this.f119704l = cVar;
        this.f119694b = bundle;
        this.f119693a = str + "SurfaceInputVideoEncoder_" + hashCode();
    }

    private void e() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime <= this.A + TimeUnit.SECONDS.toMillis(2L)) {
            this.B++;
            return;
        }
        this.f119718z = (this.B * 1000.0d) / (elapsedRealtime - this.A);
        this.B = 1L;
        this.A = elapsedRealtime;
        Iterator<Long> it = this.H.iterator();
        long j3 = -1;
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            if (j3 < longValue) {
                j3 = longValue;
            }
        }
        this.I.set(j3);
        this.H.clear();
    }

    public final void a(ServerVideoProducerConfig serverVideoProducerConfig) {
        this.f119717y = serverVideoProducerConfig;
        LiteavLog.i(this.f119693a, "Set serverConfig: " + this.f119717y);
    }

    public final void b() {
        if (this.f119700h != null) {
            LiteavLog.i(this.f119693a, "stopEosTimer");
            this.f119700h.a();
            this.f119700h = null;
        }
    }

    public final void c() {
        ByteBuffer byteBuffer;
        int i3;
        byte[] a16;
        boolean z16;
        Long peekFirst;
        if (this.f119696d == null) {
            return;
        }
        while (true) {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            try {
                int dequeueOutputBuffer = this.f119696d.dequeueOutputBuffer(bufferInfo, 0L);
                if (dequeueOutputBuffer == -1) {
                    break;
                }
                if (dequeueOutputBuffer == -3) {
                    LiteavLog.i(this.f119693a, "encoder output buffers changed");
                } else if (dequeueOutputBuffer == -2) {
                    try {
                        MediaFormat outputFormat = this.f119696d.getOutputFormat();
                        e.a aVar = this.f119697e;
                        if (aVar != null) {
                            aVar.onOutputFormatChanged(outputFormat);
                        }
                        LiteavLog.i(this.f119693a, "encoder output format changed: %s", outputFormat);
                    } catch (Throwable th5) {
                        a("getOutputFormat failed." + th5.getMessage());
                    }
                } else {
                    if (dequeueOutputBuffer < 0) {
                        a("dequeueOutputBuffer return ".concat(String.valueOf(dequeueOutputBuffer)));
                        break;
                    }
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    this.H.add(Long.valueOf(elapsedRealtime - this.f119702j.getAndSet(elapsedRealtime)));
                    try {
                        if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
                            byteBuffer = this.f119696d.getOutputBuffer(dequeueOutputBuffer);
                        } else {
                            byteBuffer = this.f119696d.getOutputBuffers()[dequeueOutputBuffer];
                        }
                        if (byteBuffer != null && ((i3 = bufferInfo.size) != 0 || (bufferInfo.flags & 4) != 0)) {
                            byte[] a17 = com.tencent.liteav.videobase.utils.d.a(i3);
                            if (a17 == null) {
                                a16 = null;
                            } else {
                                byteBuffer.position(bufferInfo.offset);
                                byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                                byteBuffer.get(a17);
                                a16 = a(a17);
                                VideoEncodeParams videoEncodeParams = this.f119698f;
                                if (videoEncodeParams != null && !videoEncodeParams.annexb) {
                                    a16 = b(a16);
                                }
                            }
                            if (a16 == null) {
                                a("modifyEncodedData return null byte array");
                            } else {
                                int i16 = bufferInfo.flags;
                                boolean z17 = (i16 & 2) > 0;
                                boolean z18 = (i16 & 1) > 0;
                                if (z17 && z18) {
                                    VideoEncodeParams videoEncodeParams2 = this.f119698f;
                                    this.f119706n = SpsInfo.nativeGetSpsPps(a16, videoEncodeParams2 == null || videoEncodeParams2.codecType == CodecType.H264, videoEncodeParams2 == null || videoEncodeParams2.annexb);
                                } else if (z17) {
                                    this.f119706n = (byte[]) a16.clone();
                                } else if (this.f119707o && z18) {
                                    byte[] bArr = this.f119706n;
                                    if (bArr != null) {
                                        byte[] a18 = com.tencent.liteav.videobase.utils.d.a(bArr.length + a16.length);
                                        if (a18 != null) {
                                            byte[] bArr2 = this.f119706n;
                                            System.arraycopy(bArr2, 0, a18, 0, bArr2.length);
                                            System.arraycopy(a16, 0, a18, this.f119706n.length, a16.length);
                                            a16 = a18;
                                        } else {
                                            a("add spspps for I frame, allocate buffer failed.");
                                        }
                                    } else {
                                        a("mSpsPps is null.");
                                    }
                                }
                                boolean z19 = (bufferInfo.flags & 1) > 0;
                                if (z19) {
                                    this.f119711s = -1;
                                }
                                VideoEncodeParams videoEncodeParams3 = this.f119698f;
                                if (videoEncodeParams3 != null && !videoEncodeParams3.fullIFrame) {
                                    int i17 = this.f119711s + 1;
                                    this.f119711s = i17;
                                    if (i17 == videoEncodeParams3.fps * videoEncodeParams3.gop) {
                                        d();
                                    }
                                }
                                long length = a16.length;
                                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                if (z19) {
                                    if (elapsedRealtime2 > this.D + 1000) {
                                        this.C = (long) (((this.E * 8000.0d) / (elapsedRealtime2 - r14)) / 1024.0d);
                                        this.E = 0L;
                                        this.D = elapsedRealtime2;
                                        if (!this.F.isEmpty()) {
                                            int i18 = this.f119698f.fps;
                                            if (((float) (i18 - this.f119718z)) <= Math.max(i18 / 2.0f, 5.0f) && (peekFirst = this.F.peekFirst()) != null && SystemClock.elapsedRealtime() > peekFirst.longValue()) {
                                                this.F.removeFirst();
                                                if (this.G - this.C > Math.max(this.f119698f.bitrate / 2, 100)) {
                                                    LiteavLog.w(this.f119693a, "restart hardware encoder because real bitrate is too low.expectBitrate: " + this.G + ", realBitrate=" + this.C);
                                                    this.f119694b.putBoolean("need_restart_when_down_bitrate", true);
                                                    this.f119703k.run();
                                                    this.F.clear();
                                                }
                                            }
                                        }
                                    }
                                }
                                this.E += length;
                                e();
                                if (z19) {
                                    this.f119709q++;
                                    this.f119710r = 0L;
                                } else {
                                    this.f119710r++;
                                }
                                this.f119708p++;
                                Long pollFirst = this.f119701i.pollFirst();
                                long longValue = pollFirst == null ? 0L : pollFirst.longValue();
                                long millis = TimeUnit.MICROSECONDS.toMillis(bufferInfo.presentationTimeUs);
                                if (this.f119712t == 0) {
                                    this.f119712t = longValue;
                                }
                                if (this.f119713u == 0) {
                                    this.f119713u = millis;
                                }
                                long j3 = millis + (this.f119712t - this.f119713u);
                                long j16 = this.f119714v;
                                if (longValue <= j16) {
                                    longValue = j16 + 1;
                                }
                                if (longValue > j3) {
                                    longValue = j3;
                                }
                                this.f119714v = longValue;
                                EncodedVideoFrame encodedVideoFrame = new EncodedVideoFrame();
                                VideoEncodeParams videoEncodeParams4 = this.f119698f;
                                if (videoEncodeParams4 != null && videoEncodeParams4.isEnablesUnlimitedGop()) {
                                    encodedVideoFrame.nalType = z19 ? com.tencent.liteav.videobase.common.c.IDR : com.tencent.liteav.videobase.common.c.P_MULTI_REF;
                                } else {
                                    encodedVideoFrame.nalType = z19 ? com.tencent.liteav.videobase.common.c.IDR : com.tencent.liteav.videobase.common.c.P;
                                }
                                ByteBuffer b16 = com.tencent.liteav.videobase.utils.d.b(a16.length);
                                encodedVideoFrame.data = b16;
                                if (b16 == null) {
                                    a("allocate direct buffer for nal failed");
                                } else {
                                    b16.put(a16);
                                    encodedVideoFrame.data.rewind();
                                    encodedVideoFrame.dts = longValue;
                                    encodedVideoFrame.pts = j3;
                                    encodedVideoFrame.info = bufferInfo;
                                    encodedVideoFrame.gopIndex = this.f119709q;
                                    long j17 = this.f119710r;
                                    encodedVideoFrame.frameIndex = j17;
                                    encodedVideoFrame.gopFrameIndex = j17;
                                    if (!z19) {
                                        j17--;
                                    }
                                    encodedVideoFrame.refFrameIndex = j17;
                                    encodedVideoFrame.profileType = com.tencent.liteav.videobase.common.d.BASELINE;
                                    VideoEncodeParams videoEncodeParams5 = this.f119698f;
                                    encodedVideoFrame.codecType = videoEncodeParams5.codecType;
                                    encodedVideoFrame.width = videoEncodeParams5.width;
                                    encodedVideoFrame.height = videoEncodeParams5.height;
                                    if ((bufferInfo.flags & 4) > 0) {
                                        b();
                                        z16 = true;
                                    } else {
                                        boolean z26 = videoEncodeParams5.enableBFrame;
                                        if (!z26 && !this.f119716x && j3 < this.f119715w) {
                                            LiteavLog.i(this.f119693a, "has B frame,isEnablesBframe=%b,mLastPresentationTimestamp=%d,packet.pts=%d", Boolean.valueOf(z26), Long.valueOf(this.f119715w), Long.valueOf(encodedVideoFrame.pts));
                                            this.f119716x = true;
                                            PersistStorage persistStorage = new PersistStorage(PersistStorage.GLOBAL_DOMAIN);
                                            persistStorage.put("Liteav.Video.android.local.rtc.enable.high.profile", 0);
                                            persistStorage.commit();
                                            e.a aVar2 = this.f119697e;
                                            if (aVar2 != null) {
                                                aVar2.a();
                                            }
                                        }
                                        this.f119715w = encodedVideoFrame.pts;
                                        z16 = false;
                                    }
                                    e.a aVar3 = this.f119697e;
                                    if (aVar3 != null) {
                                        aVar3.onEncodedNAL(encodedVideoFrame, z16);
                                    }
                                }
                            }
                        } else {
                            a("size is zero, but it isn't end of stream");
                        }
                        MediaCodec mediaCodec = this.f119696d;
                        if (mediaCodec == null) {
                            return;
                        }
                        try {
                            mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                        } catch (Throwable th6) {
                            a("releaseOutputBuffer failed." + th6.getMessage());
                        }
                    } catch (Throwable th7) {
                        a("getOutputBuffer failed." + th7.getMessage());
                    }
                }
            } catch (Throwable th8) {
                a("dequeueOutputBuffer failed." + th8.getMessage());
            }
        }
        if (this.f119701i.isEmpty()) {
            return;
        }
        int i19 = this.f119698f.fps;
        int i26 = i19 != 0 ? 500 / i19 : 10;
        if (this.f119695c.hasMessages(10)) {
            return;
        }
        this.f119695c.sendEmptyMessageDelayed(10, i26);
    }

    public final void d() {
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 19 && this.f119696d != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt(MediaCodecConstants.FORCE_I_FRAME, 0);
                this.f119696d.setParameters(bundle);
            } catch (Throwable th5) {
                LiteavLog.e(this.f119693a, "requestSyncFrame failed.", th5);
            }
        }
    }

    public final void a(int i3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i16 = 1; i16 <= 3; i16++) {
            this.F.addLast(Long.valueOf((i16 * 2000) + elapsedRealtime));
        }
        this.G = i3;
    }

    private static byte[] b(byte[] bArr) {
        int i3;
        int length = bArr.length;
        ArrayList<int[]> arrayList = new ArrayList(20);
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i16 <= length) {
            int i19 = i16 + 2;
            if (i19 < length && bArr[i16] == 0 && bArr[i16 + 1] == 0 && bArr[i19] == 1) {
                i3 = 3;
            } else {
                int i26 = i16 + 3;
                i3 = (i26 < length && bArr[i16] == 0 && bArr[i16 + 1] == 0 && bArr[i19] == 0 && bArr[i26] == 1) ? 4 : 1;
            }
            if (i3 == 3 || i3 == 4 || i16 == length) {
                if (i18 != i16) {
                    arrayList.add(new int[]{i18, i16});
                    i17 += i16 - i18;
                }
                i18 = i16 + i3;
            }
            i16 += i3;
        }
        byte[] a16 = com.tencent.liteav.videobase.utils.d.a(i17 + (arrayList.size() * 4));
        if (a16 == null) {
            return bArr;
        }
        int i27 = 0;
        for (int[] iArr : arrayList) {
            int i28 = iArr[1] - iArr[0];
            ByteBuffer order = ByteBuffer.wrap(new byte[4]).order(ByteOrder.BIG_ENDIAN);
            order.putInt(i28);
            System.arraycopy(order.array(), 0, a16, i27, 4);
            int i29 = i27 + 4;
            System.arraycopy(bArr, iArr[0], a16, i29, i28);
            i27 = i29 + i28;
        }
        return a16;
    }

    public final void a(MediaCodec mediaCodec, int i3) {
        if (mediaCodec == null || LiteavSystemInfo.getSystemOSVersionInt() < 19) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("video-bitrate", i3 * 1024);
            mediaCodec.setParameters(bundle);
        } catch (Throwable th5) {
            LiteavLog.e(this.f119693a, "updateBitrateToMediaCodec failed.", th5);
        }
    }

    private void a(String str) {
        LiteavLog.e(this.f119693a, "notifyEncodeError message = ".concat(String.valueOf(str)));
        e.a aVar = this.f119697e;
        if (aVar != null) {
            aVar.onEncodedFail(e.a.ERR_VIDEO_ENCODE_FAIL);
        }
    }

    public final void a() {
        this.f119695c.removeMessages(10);
        a(this.f119696d);
        this.f119696d = null;
    }

    private MediaCodec b(String str) throws Throwable {
        String str2;
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType(str);
        try {
            str2 = createEncoderByType.getName();
        } catch (Throwable th5) {
            LiteavLog.e(this.f119693a, "mediaCodec getName failed.", th5);
            str2 = null;
        }
        LiteavLog.i(this.f119693a, "codecName=".concat(String.valueOf(str2)));
        if (str2 == null || !str2.equals("OMX.google.h264.encoder")) {
            return createEncoderByType;
        }
        LiteavLog.w(this.f119693a, "will be destroyed codecName=".concat(str2));
        a(createEncoderByType);
        throw new IOException("this is a Google H264 soft encoder. cancel use MediaCodec.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0129, code lost:
    
        r5 = r2.getInteger("bitrate-mode", -1);
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d1 A[Catch: all -> 0x0170, TRY_LEAVE, TryCatch #0 {all -> 0x0170, blocks: (B:20:0x00a5, B:22:0x00bf, B:26:0x00d1, B:69:0x0167, B:70:0x016f), top: B:19:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0167 A[Catch: all -> 0x0170, TRY_ENTER, TryCatch #0 {all -> 0x0170, blocks: (B:20:0x00a5, B:22:0x00bf, B:26:0x00d1, B:69:0x0167, B:70:0x016f), top: B:19:0x00a5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Surface a(VideoEncodeParams videoEncodeParams) {
        ServerVideoProducerConfig serverVideoProducerConfig;
        MediaCodec mediaCodec;
        Surface surface;
        MediaFormat mediaFormat;
        boolean z16;
        int integer;
        this.f119699g = SystemClock.elapsedRealtime();
        this.f119715w = Long.MIN_VALUE;
        if (videoEncodeParams.bitrate == 0) {
            int i3 = videoEncodeParams.width;
            int i16 = videoEncodeParams.height;
            videoEncodeParams.bitrate = (int) (Math.sqrt((i3 * i3) + (i16 * i16)) * 1.2d);
        }
        VideoEncodeParams videoEncodeParams2 = new VideoEncodeParams(videoEncodeParams);
        this.f119698f = videoEncodeParams2;
        this.f119708p = videoEncodeParams2.baseFrameIndex;
        this.f119709q = videoEncodeParams2.baseGopIndex;
        this.f119710r = 0L;
        String str = videoEncodeParams2.codecType == CodecType.H265 ? "video/hevc" : "video/avc";
        VideoEncoderDef.EncoderProfile encoderProfile = videoEncodeParams2.encoderProfile;
        VideoEncoderDef.EncoderProfile encoderProfile2 = VideoEncoderDef.EncoderProfile.PROFILE_MAIN;
        if (encoderProfile == encoderProfile2) {
            videoEncodeParams2.encoderProfile = VideoEncoderDef.EncoderProfile.PROFILE_HIGH;
        }
        VideoEncoderDef.EncoderProfile encoderProfile3 = videoEncodeParams2.encoderProfile;
        VideoEncoderDef.EncoderProfile encoderProfile4 = VideoEncoderDef.EncoderProfile.PROFILE_HIGH;
        if ((encoderProfile3 == encoderProfile4 || encoderProfile3 == encoderProfile2) && (serverVideoProducerConfig = this.f119717y) != null && !serverVideoProducerConfig.isHardwareEncoderHighProfileAllowed()) {
            this.f119698f.encoderProfile = VideoEncoderDef.EncoderProfile.PROFILE_BASELINE;
        }
        VideoEncodeParams videoEncodeParams3 = this.f119698f;
        VideoEncoderDef.EncoderProfile encoderProfile5 = videoEncodeParams3.encoderProfile;
        if ((encoderProfile5 == encoderProfile4 || encoderProfile5 == encoderProfile2) && !videoEncodeParams3.enableBFrame) {
            Integer num = new PersistStorage(PersistStorage.GLOBAL_DOMAIN).getInt("Liteav.Video.android.local.rtc.enable.high.profile");
            LiteavLog.i(this.f119693a, "enable high profile from persist storage:".concat(String.valueOf(num)));
            if (num != null && num.intValue() == 0) {
                this.f119698f.encoderProfile = VideoEncoderDef.EncoderProfile.PROFILE_BASELINE;
            }
        }
        try {
            mediaCodec = b(str);
            try {
                a aVar = new a(mediaCodec, str, this.f119698f, this.f119717y.isHardwareEncoderBitrateModeCBRSupported());
                aVar.f119685a = true;
                MediaFormat a16 = aVar.a();
                if (!a(mediaCodec, a16)) {
                    z16 = false;
                    aVar.f119686b = false;
                    mediaFormat = aVar.a();
                    if (a(mediaCodec, mediaFormat)) {
                        a16 = mediaFormat;
                    }
                    if (!z16) {
                        surface = mediaCodec.createInputSurface();
                        try {
                            mediaCodec.start();
                            try {
                                this.f119698f.width = mediaFormat.getInteger("width");
                                this.f119698f.height = mediaFormat.getInteger("height");
                                this.f119698f.bitrate = mediaFormat.getInteger("bitrate") / 1024;
                                int i17 = this.f119698f.bitrate;
                                if (LiteavSystemInfo.getSystemOSVersionInt() > 30) {
                                    LiteavLog.i(this.f119693a, "resetBitrateAfterApiLevel30,bitrate=".concat(String.valueOf(i17)));
                                    a(mediaCodec, i17);
                                }
                                if (this.f119697e != null) {
                                    VideoEncoderDef.BitrateMode bitrateMode = VideoEncoderDef.BitrateMode.UNKNOWN;
                                    if (LiteavSystemInfo.getSystemOSVersionInt() >= 21 && integer != -1) {
                                        if (integer == 0) {
                                            bitrateMode = VideoEncoderDef.BitrateMode.CQ;
                                        } else if (integer == 1) {
                                            bitrateMode = VideoEncoderDef.BitrateMode.VBR;
                                        } else if (integer == 2) {
                                            bitrateMode = VideoEncoderDef.BitrateMode.CBR;
                                        }
                                    }
                                    this.f119697e.onBitrateModeUpdated(bitrateMode);
                                }
                            } catch (Throwable th5) {
                                LiteavLog.e(this.f119693a, "MediaFormat get key fail", th5);
                            }
                            LiteavLog.i(this.f119693a, "start MediaCodec with format: ".concat(String.valueOf(mediaFormat)));
                            this.f119696d = mediaCodec;
                            return surface;
                        } catch (Throwable th6) {
                            th = th6;
                            if (surface != null) {
                                surface.release();
                            }
                            a(mediaCodec);
                            e.c cVar = e.c.WARNING_VIDEO_ENCODE_START_FAILED;
                            String str2 = "Start encoder failed:" + th.getMessage();
                            if (LiteavSystemInfo.getSystemOSVersionInt() >= 23 && (th instanceof MediaCodec.CodecException) && th.getErrorCode() == 1100) {
                                cVar = e.c.WARNING_VIDEO_ENCODE_START_FAILED_INSUFFICIENT_RESOURCE;
                                str2 = "Insufficient resource, Start encoder failed:" + th.getMessage();
                            }
                            this.f119704l.updateStatus(com.tencent.liteav.videobase.videobase.f.STATUS_VIDEO_HW_ENCODE_START_ERROR_TYPE, this.f119705m.mValue, Integer.valueOf(cVar.mValue));
                            this.f119704l.notifyWarning(cVar, str2);
                            LiteavLog.e(this.f119693a, "Start MediaCodec failed,encode params:" + this.f119698f, th);
                            return null;
                        }
                    }
                    throw new IOException("configure encoder failed.");
                }
                mediaFormat = a16;
                z16 = true;
                if (!z16) {
                }
            } catch (Throwable th7) {
                th = th7;
                surface = null;
            }
        } catch (Throwable th8) {
            th = th8;
            mediaCodec = null;
            surface = null;
        }
    }

    private boolean a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return false;
        }
        try {
            LiteavLog.i(this.f119693a, "configure format: %s", mediaFormat);
            mediaCodec.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
            return true;
        } catch (Throwable th5) {
            LiteavLog.e(this.f119693a, "configure failed.", th5);
            return false;
        }
    }

    private static byte[] a(byte[] bArr) {
        byte[] a16;
        if (bArr.length > 5 && bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 0 && bArr[4] == 0 && bArr[5] == 0) {
            int i3 = 0;
            while (true) {
                int i16 = i3 + 3;
                if (i16 >= bArr.length) {
                    i3 = 0;
                    break;
                }
                byte b16 = bArr[i3];
                if ((b16 == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 0 && bArr[i16] == 1) || (b16 == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 1)) {
                    break;
                }
                i3++;
            }
            if (i3 == 0 || (a16 = com.tencent.liteav.videobase.utils.d.a(bArr.length - i3)) == null) {
                return bArr;
            }
            System.arraycopy(bArr, i3, a16, 0, a16.length);
            return a16;
        }
        return bArr;
    }

    private void a(MediaCodec mediaCodec) {
        if (mediaCodec == null) {
            return;
        }
        try {
            mediaCodec.stop();
        } catch (Throwable th5) {
            LiteavLog.e(this.f119693a, "destroy mediaCodec stop failed.", th5);
        }
        try {
            mediaCodec.release();
        } catch (Throwable th6) {
            LiteavLog.e(this.f119693a, "destroy mediaCodec release failed.", th6);
        }
        LiteavLog.i(this.f119693a, "destroy mediaCodec");
    }
}
