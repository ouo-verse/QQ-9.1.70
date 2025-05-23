package com.tencent.medialab.video.decoder;

import android.os.Environment;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.webrtc.CodecMimeType;
import com.tencent.gamematrix.gmcg.webrtc.MediaCodecUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import org.tencwebrtc.EglBase;
import org.tencwebrtc.EncodedImage;
import org.tencwebrtc.SurfaceTextureHelper;
import org.tencwebrtc.ThreadUtils;
import org.tencwebrtc.VideoCodecStatus;
import org.tencwebrtc.VideoDecoder;
import org.tencwebrtc.VideoFrame;
import org.tencwebrtc.VideoSink;
import org.tencwebrtc.ad;

/* compiled from: P */
/* loaded from: classes9.dex */
public class VDecoder implements VideoDecoder, VideoSink {
    static IPatchRedirector $redirector_;

    /* renamed from: r0, reason: collision with root package name */
    private static boolean f151495r0;

    /* renamed from: s0, reason: collision with root package name */
    @Nullable
    private static Surface f151496s0;

    /* renamed from: t0, reason: collision with root package name */
    private static long f151497t0;

    /* renamed from: u0, reason: collision with root package name */
    private static long f151498u0;

    /* renamed from: v0, reason: collision with root package name */
    private static long f151499v0;

    /* renamed from: w0, reason: collision with root package name */
    private static int f151500w0;

    /* renamed from: x0, reason: collision with root package name */
    private static long f151501x0;

    /* renamed from: y0, reason: collision with root package name */
    public static VideoDecoder.DecodeCallback f151502y0;

    /* renamed from: z0, reason: collision with root package name */
    public static b f151503z0;
    private BlockingDeque<a> C;
    private ThreadUtils.ThreadChecker D;
    private final Object E;
    private boolean F;
    private int G;
    private int H;
    private int I;
    private int J;
    private boolean K;
    private boolean L;
    private int M;
    private int N;
    private final long P;
    private long Q;
    private final int R;
    private final int S;
    private final int T;
    private final int U;
    private final int V;
    private final int W;
    private int X;
    private int Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f151504a0;

    /* renamed from: b0, reason: collision with root package name */
    private final boolean f151505b0;

    /* renamed from: c0, reason: collision with root package name */
    private final int f151506c0;

    /* renamed from: d, reason: collision with root package name */
    private String f151507d;

    /* renamed from: d0, reason: collision with root package name */
    private final int f151508d0;

    /* renamed from: e, reason: collision with root package name */
    private CodecMimeType f151509e;

    /* renamed from: e0, reason: collision with root package name */
    private final int f151510e0;

    /* renamed from: f, reason: collision with root package name */
    private int f151511f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f151512f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f151513g0;

    /* renamed from: h, reason: collision with root package name */
    private int f151514h;

    /* renamed from: h0, reason: collision with root package name */
    @Nullable
    private final EglBase.Context f151515h0;

    /* renamed from: i, reason: collision with root package name */
    private int f151516i;

    /* renamed from: i0, reason: collision with root package name */
    @Nullable
    private Surface f151517i0;

    /* renamed from: j0, reason: collision with root package name */
    @Nullable
    private SurfaceTextureHelper f151518j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f151519k0;

    /* renamed from: l0, reason: collision with root package name */
    private final Object f151520l0;

    /* renamed from: m, reason: collision with root package name */
    private long f151521m;

    /* renamed from: m0, reason: collision with root package name */
    String f151522m0;

    /* renamed from: n0, reason: collision with root package name */
    File f151523n0;

    /* renamed from: o0, reason: collision with root package name */
    FileOutputStream f151524o0;

    /* renamed from: p0, reason: collision with root package name */
    @Nullable
    private VideoDecoder.Callback f151525p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f151526q0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class DecAbility {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f151527a;

        /* renamed from: b, reason: collision with root package name */
        public int f151528b;

        /* renamed from: c, reason: collision with root package name */
        public int f151529c;

        /* renamed from: d, reason: collision with root package name */
        public int f151530d;

        /* renamed from: e, reason: collision with root package name */
        public int f151531e;

        /* renamed from: f, reason: collision with root package name */
        public int f151532f;

        /* renamed from: g, reason: collision with root package name */
        public int[] f151533g;

        /* renamed from: h, reason: collision with root package name */
        public int f151534h;

        /* renamed from: i, reason: collision with root package name */
        public int[] f151535i;

        /* renamed from: j, reason: collision with root package name */
        public int[] f151536j;

        /* renamed from: k, reason: collision with root package name */
        public String f151537k;

        public DecAbility() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f151527a = 0;
            this.f151528b = 0;
            this.f151529c = 0;
            this.f151530d = 0;
            this.f151531e = 0;
            this.f151532f = 0;
            this.f151533g = null;
            this.f151534h = 0;
            this.f151535i = null;
            this.f151536j = null;
            this.f151537k = "";
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class DecParam {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f151538a;

        /* renamed from: b, reason: collision with root package name */
        int f151539b;

        /* renamed from: c, reason: collision with root package name */
        int f151540c;

        /* renamed from: d, reason: collision with root package name */
        int f151541d;

        /* renamed from: e, reason: collision with root package name */
        int f151542e;

        /* renamed from: f, reason: collision with root package name */
        int f151543f;

        /* renamed from: g, reason: collision with root package name */
        int f151544g;

        /* renamed from: h, reason: collision with root package name */
        int f151545h;

        /* renamed from: i, reason: collision with root package name */
        Object f151546i;

        /* renamed from: j, reason: collision with root package name */
        int f151547j;

        /* renamed from: k, reason: collision with root package name */
        String f151548k;

        /* renamed from: l, reason: collision with root package name */
        String f151549l;

        /* renamed from: m, reason: collision with root package name */
        String f151550m;

        /* renamed from: n, reason: collision with root package name */
        String f151551n;

        /* renamed from: o, reason: collision with root package name */
        String f151552o;

        public DecParam() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f151538a = 0;
            this.f151539b = 0;
            this.f151540c = 0;
            this.f151541d = 0;
            this.f151542e = 0;
            this.f151543f = 0;
            this.f151544g = 0;
            this.f151545h = 0;
            this.f151546i = null;
            this.f151547j = 4;
            this.f151548k = "";
            this.f151549l = "";
            this.f151550m = "";
            this.f151551n = "";
            this.f151552o = "";
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class DecStatistics {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f151553a;

        /* renamed from: b, reason: collision with root package name */
        public int f151554b;

        /* renamed from: c, reason: collision with root package name */
        public int f151555c;

        /* renamed from: d, reason: collision with root package name */
        public int f151556d;

        /* renamed from: e, reason: collision with root package name */
        public int f151557e;

        /* renamed from: f, reason: collision with root package name */
        public int f151558f;

        /* renamed from: g, reason: collision with root package name */
        public int f151559g;

        /* renamed from: h, reason: collision with root package name */
        public double f151560h;

        /* renamed from: i, reason: collision with root package name */
        public double f151561i;

        /* renamed from: j, reason: collision with root package name */
        public double f151562j;

        /* renamed from: k, reason: collision with root package name */
        public double f151563k;

        /* renamed from: l, reason: collision with root package name */
        public double f151564l;

        /* renamed from: m, reason: collision with root package name */
        public double f151565m;

        public DecStatistics() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f151553a = 0;
            this.f151554b = 0;
            this.f151555c = 0;
            this.f151556d = 0;
            this.f151557e = 0;
            this.f151558f = 0;
            this.f151559g = 0;
            this.f151560h = 0.0d;
            this.f151561i = 0.0d;
            this.f151562j = 0.0d;
            this.f151563k = 0.0d;
            this.f151564l = 0.0d;
            this.f151565m = 0.0d;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class VideoPacket {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        byte[] f151566a;

        /* renamed from: b, reason: collision with root package name */
        int f151567b;

        /* renamed from: c, reason: collision with root package name */
        int f151568c;

        /* renamed from: d, reason: collision with root package name */
        int f151569d;

        /* renamed from: e, reason: collision with root package name */
        int f151570e;

        /* renamed from: f, reason: collision with root package name */
        int f151571f;

        public VideoPacket() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VDecoder.this);
                return;
            }
            this.f151566a = null;
            this.f151567b = 0;
            this.f151568c = 0;
            this.f151569d = 0;
            this.f151570e = 0;
            this.f151571f = 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class VideoStream {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        byte[] f151573a;

        /* renamed from: b, reason: collision with root package name */
        int f151574b;

        /* renamed from: c, reason: collision with root package name */
        int f151575c;

        /* renamed from: d, reason: collision with root package name */
        int f151576d;

        /* renamed from: e, reason: collision with root package name */
        int f151577e;

        public VideoStream() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VDecoder.this);
                return;
            }
            this.f151573a = null;
            this.f151574b = 0;
            this.f151575c = 0;
            this.f151576d = 0;
            this.f151577e = 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final long f151579a;

        /* renamed from: b, reason: collision with root package name */
        final long f151580b;

        /* renamed from: c, reason: collision with root package name */
        final int f151581c;

        /* renamed from: d, reason: collision with root package name */
        final int f151582d;

        /* renamed from: e, reason: collision with root package name */
        final byte[] f151583e;

        a(long j3, long j16, int i3, int i16, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16), bArr);
                return;
            }
            this.f151579a = j3;
            this.f151580b = j16;
            this.f151581c = i3;
            this.f151583e = bArr;
            this.f151582d = i16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38579);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
            return;
        }
        f151495r0 = true;
        try {
            System.loadLibrary("VDecoder");
            Log.i("VDecoder", "load library= VDecoder");
        } catch (Exception e16) {
            Log.i("VDecoder", "load library= VDecoderexception= " + e16.getStackTrace());
        }
    }

    public VDecoder(String str, CodecMimeType codecMimeType, int i3, boolean z16, int i16, boolean z17, int i17, @Nullable EglBase.Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, codecMimeType, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), Boolean.valueOf(z17), Integer.valueOf(i17), context);
            return;
        }
        this.f151507d = "";
        this.f151509e = null;
        this.C = null;
        this.E = new Object();
        this.L = false;
        this.M = 4;
        this.P = 500L;
        this.R = -315;
        this.S = -319;
        this.T = 48;
        this.U = 64;
        this.V = 16;
        this.W = 16;
        this.X = 48;
        this.Y = 16;
        this.Z = 16;
        this.f151504a0 = false;
        this.f151505b0 = true;
        this.f151506c0 = 10;
        this.f151508d0 = 12000;
        this.f151510e0 = 1;
        this.f151512f0 = false;
        this.f151513g0 = false;
        this.f151520l0 = new Object();
        this.I = 0;
        this.J = 0;
        this.Q = 0L;
        this.K = z16;
        this.N = i17;
        this.f151515h0 = context;
        this.f151519k0 = false;
        int i18 = i16 >= 2 ? i16 : 2;
        this.M = i18 <= 7 ? i18 : 7;
        this.L = z17;
        if (z16) {
            this.f151522m0 = Environment.getExternalStorageDirectory().getAbsolutePath();
            this.f151523n0 = new File(this.f151522m0 + "/encoded_video_stream.data");
            try {
                this.f151524o0 = new FileOutputStream(this.f151523n0);
            } catch (Exception unused) {
                CGLog.e("Failed to open encoded_video_stream.data");
            }
        }
        if (j(i3)) {
            CGLog.i("ctor name: " + str + " type: " + codecMimeType + " color format: " + i3 + " context: ");
            this.f151507d = str;
            this.f151509e = codecMimeType;
            this.f151514h = i3;
            this.C = new LinkedBlockingDeque();
            if (codecMimeType == CodecMimeType.H264) {
                this.f151511f = 16;
            } else if (codecMimeType == CodecMimeType.H265) {
                this.f151511f = 17;
            }
            if (i3 == 19) {
                this.f151516i = 1;
            } else if (i3 == 21) {
                this.f151516i = 3;
            }
            this.f151512f0 = false;
            return;
        }
        throw new IllegalArgumentException("Unsupported color format: " + i3);
    }

    static native String GetVersion();

    public static long d() {
        return f151497t0;
    }

    public static long e() {
        return f151499v0;
    }

    public static long f() {
        return f151498u0;
    }

    public static long g() {
        return f151501x0;
    }

    private VideoCodecStatus i(int i3, int i16) {
        try {
            this.D.checkIsOnValidThread();
            CGLog.i("VDecoder initDecodeInternal name:  type: " + this.f151509e + " width: " + i3 + " height: " + i16);
            this.G = i3;
            this.H = i16;
            DecParam decParam = new DecParam();
            decParam.f151538a = this.f151511f;
            decParam.f151539b = this.f151516i;
            decParam.f151540c = i3;
            decParam.f151541d = i16;
            decParam.f151542e = 60;
            decParam.f151543f = 1;
            int i17 = 0;
            decParam.f151544g = 0;
            if (f151495r0) {
                decParam.f151546i = f151496s0;
            } else {
                SurfaceTextureHelper surfaceTextureHelper = this.f151518j0;
                if (surfaceTextureHelper != null) {
                    decParam.f151546i = this.f151517i0;
                    surfaceTextureHelper.setTextureSize(i3, i16);
                } else {
                    decParam.f151546i = null;
                    decParam.f151545h = 1;
                    CGLog.i("mSurfaceTextureHelper is null, switch decode to YUV mode");
                }
            }
            decParam.f151552o = "com/tencent/medialab/video/decoder/VDecoder";
            decParam.f151547j = this.M;
            decParam.f151542e = this.N;
            long Create = Create();
            this.f151521m = Create;
            int Open = Open(Create, decParam);
            CGLog.i("Open decoder result=" + Open);
            if (Open != 0) {
                VideoDecoder.DecodeCallback decodeCallback = f151502y0;
                if (decodeCallback != null) {
                    decodeCallback.onDecodeErrCodeReported(true, VideoCodecStatus.CREATE_DECODER_FAILED.getNumber(), Open, "Open decoder result=" + Open);
                }
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
            long j3 = this.f151521m;
            if (this.L) {
                i17 = 1;
            }
            SetFeatureInt(j3, "tunneled-playback", i17);
            this.F = true;
            SurfaceTextureHelper surfaceTextureHelper2 = this.f151518j0;
            if (surfaceTextureHelper2 != null) {
                surfaceTextureHelper2.setTextureSize(i3, i16);
            }
            CGLog.i("initDecodeInternal done");
            this.f151513g0 = true;
            return VideoCodecStatus.OK;
        } catch (Throwable th5) {
            CGLog.e("initDecodeInternal error:" + th5.toString());
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
    }

    private boolean j(int i3) {
        for (int i16 : MediaCodecUtils.DECODER_COLOR_FORMATS) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    private VideoCodecStatus k(int i3, int i16) {
        ThreadUtils.ThreadChecker threadChecker = this.D;
        if (threadChecker != null) {
            threadChecker.checkIsOnValidThread();
        }
        VideoCodecStatus l3 = l();
        if (l3 != VideoCodecStatus.OK) {
            CGLog.e("fail to release decoder status: " + l3);
            return l3;
        }
        if (this.f151519k0) {
            return i(i3, i16);
        }
        return VideoCodecStatus.ERR_PARAMETER;
    }

    public static void m(VideoDecoder.DecodeCallback decodeCallback) {
        f151502y0 = decodeCallback;
    }

    public static void n(boolean z16) {
        f151495r0 = z16;
    }

    public static void o(Surface surface) {
        f151496s0 = surface;
    }

    public static void p(b bVar) {
        f151503z0 = bVar;
    }

    public native int Close(long j3);

    public native long Create();

    public native int DetectAbility(long j3, int i3, DecAbility decAbility);

    public native int DoDecode(long j3, VideoPacket videoPacket);

    public native int DoDecodeStream(long j3, VideoStream videoStream, DecStatistics decStatistics);

    public native int GetStatistics(long j3, DecStatistics decStatistics);

    public native int Open(long j3, DecParam decParam);

    public native void Release(long j3);

    public native int SetFeatureInt(long j3, String str, int i3);

    public int a(byte[] bArr, DecStatistics decStatistics) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, (Object) bArr, (Object) decStatistics)).intValue();
        }
        VideoStream videoStream = new VideoStream();
        videoStream.f151573a = bArr;
        videoStream.f151574b = bArr.length;
        int i3 = this.N;
        videoStream.f151575c = i3;
        videoStream.f151576d = i3 * 10;
        videoStream.f151577e = 12000;
        return DoDecodeStream(this.f151521m, videoStream, decStatistics);
    }

    protected SurfaceTextureHelper b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (SurfaceTextureHelper) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return SurfaceTextureHelper.create("decoder-texture-thread", this.f151515h0);
    }

    public void c(DecAbility decAbility, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) decAbility, i3);
        } else {
            DetectAbility(this.f151521m, i3, decAbility);
        }
    }

    @Override // org.tencwebrtc.VideoDecoder
    public /* synthetic */ long createNativeVideoDecoder() {
        return ad.a(this);
    }

    @Override // org.tencwebrtc.VideoDecoder
    public VideoCodecStatus decode(EncodedImage encodedImage, VideoDecoder.DecodeInfo decodeInfo) {
        ByteBuffer byteBuffer;
        byte[] bArr;
        int i3;
        VideoCodecStatus k3;
        int i16;
        byte b16;
        Surface surface;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (VideoCodecStatus) iPatchRedirector.redirect((short) 3, (Object) this, (Object) encodedImage, (Object) decodeInfo);
        }
        if (f151495r0 && ((surface = f151496s0) == null || !surface.isValid())) {
            CGLog.i("displaySurface is released, will not do decode");
            VideoDecoder.DecodeCallback decodeCallback = f151502y0;
            if (decodeCallback != null) {
                decodeCallback.onDecodeErrCodeReported(true, VideoCodecStatus.SURFACE_NULL_OR_VALID.getNumber(), 0, "displaySurface is released, will not do decode");
            }
            return VideoCodecStatus.OK;
        }
        ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
        this.D = threadChecker;
        threadChecker.checkIsOnValidThread();
        ByteBuffer byteBuffer2 = encodedImage.buffer;
        if (byteBuffer2 == null) {
            CGLog.e("decode() - no input data");
            VideoDecoder.DecodeCallback decodeCallback2 = f151502y0;
            if (decodeCallback2 != null) {
                decodeCallback2.onDecodeErrCodeReported(true, VideoCodecStatus.NO_INPUT_DATA_OR_EMPTY.getNumber(), 0, "decode() - no input data");
            }
            return VideoCodecStatus.ERR_PARAMETER;
        }
        int remaining = byteBuffer2.remaining();
        if (remaining == 0) {
            CGLog.e("decode() - input buffer empty");
            VideoDecoder.DecodeCallback decodeCallback3 = f151502y0;
            if (decodeCallback3 != null) {
                decodeCallback3.onDecodeErrCodeReported(true, VideoCodecStatus.NO_INPUT_DATA_OR_EMPTY.getNumber(), 0, "decode() - input buffer empty");
            }
            return VideoCodecStatus.ERR_SIZE;
        }
        int i18 = this.X;
        int i19 = i18 - this.Y;
        int i26 = ((remaining - i18) - 3) - 3;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.Q == 0) {
            this.Q = currentTimeMillis;
        }
        int i27 = 0;
        while (true) {
            if (i27 < i26) {
                int i28 = i27 + 2;
                if (encodedImage.buffer.get(i28) <= 1) {
                    if (encodedImage.buffer.get(i28) == 1) {
                        int i29 = i27 + 1;
                        if (encodedImage.buffer.get(i29) == 0 && encodedImage.buffer.get(i27) == 0) {
                            CodecMimeType codecMimeType = this.f151509e;
                            if (codecMimeType == CodecMimeType.H264) {
                                b16 = (byte) (encodedImage.buffer.get(i27 + 3) & 31);
                            } else if (codecMimeType == CodecMimeType.H265) {
                                b16 = (byte) ((encodedImage.buffer.get(i27 + 3) & Byte.MAX_VALUE) >> 1);
                                i27 = i29;
                            } else {
                                b16 = 0;
                            }
                            if ((b16 == 6 || b16 == 39) && encodedImage.buffer.get(i27 + 4) == 5) {
                                byte b17 = encodedImage.buffer.get(i27 + 5);
                                this.X = b17;
                                int i36 = this.Z;
                                int i37 = b17 - i36;
                                int i38 = this.Y;
                                int i39 = i27 + 6 + i38;
                                byte[] bArr2 = new byte[(b17 - i38) + i36];
                                ByteBuffer wrap = ByteBuffer.wrap(bArr2);
                                wrap.order(ByteOrder.LITTLE_ENDIAN);
                                int i46 = 0;
                                while (i46 + 2 < this.X - this.Y) {
                                    int i47 = i39 + 2;
                                    if (encodedImage.buffer.get(i47) > 3) {
                                        int i48 = i46 + 1;
                                        int i49 = i39 + 1;
                                        bArr2[i46] = encodedImage.buffer.get(i39);
                                        i46 = i48 + 1;
                                        bArr2[i48] = encodedImage.buffer.get(i49);
                                        i39 = i49 + 1;
                                    } else if (encodedImage.buffer.get(i39) == 0 && encodedImage.buffer.get(i39 + 1) == 0 && encodedImage.buffer.get(i47) == 3) {
                                        int i56 = i46 + 1;
                                        bArr2[i46] = 0;
                                        i46 = i56 + 1;
                                        bArr2[i56] = 0;
                                        i39 += 3;
                                    }
                                    bArr2[i46] = encodedImage.buffer.get(i39);
                                    i46++;
                                    i39++;
                                }
                                while (i46 < this.X - this.Y) {
                                    bArr2[i46] = encodedImage.buffer.get(i39);
                                    i46++;
                                    i39++;
                                }
                                bArr = bArr2;
                                byteBuffer = wrap;
                                i19 = i37;
                            }
                        }
                    }
                    i27++;
                }
                i27 += 3;
            } else {
                byteBuffer = null;
                bArr = null;
                break;
            }
        }
        if (this.F) {
            if (encodedImage.frameType != EncodedImage.FrameType.VideoFrameKey) {
                CGLog.e("decode() - key frame required first");
                VideoDecoder.DecodeCallback decodeCallback4 = f151502y0;
                if (decodeCallback4 != null) {
                    decodeCallback4.onDecodeErrCodeReported(true, VideoCodecStatus.NO_OUTPUT.getNumber(), 0, "decode() - key frame required first");
                }
                return VideoCodecStatus.NO_OUTPUT;
            }
            if (!encodedImage.completeFrame) {
                CGLog.e("decode() - complete frame required first");
                VideoDecoder.DecodeCallback decodeCallback5 = f151502y0;
                if (decodeCallback5 != null) {
                    decodeCallback5.onDecodeErrCodeReported(true, VideoCodecStatus.NO_OUTPUT.getNumber(), 0, "decode() - complete frame required first");
                }
                return VideoCodecStatus.NO_OUTPUT;
            }
        }
        encodedImage.buffer.position(0);
        VideoPacket videoPacket = new VideoPacket();
        int remaining2 = encodedImage.buffer.remaining();
        videoPacket.f151567b = remaining2;
        byte[] bArr3 = new byte[remaining2];
        encodedImage.buffer.get(bArr3);
        videoPacket.f151566a = bArr3;
        if (encodedImage.frameType == EncodedImage.FrameType.VideoFrameKey) {
            i17 = 1;
        }
        videoPacket.f151568c = i17;
        videoPacket.f151569d = f151500w0;
        videoPacket.f151570e = (int) encodedImage.captureTimeMs;
        a aVar = new a(System.currentTimeMillis(), TimeUnit.NANOSECONDS.toMicros(encodedImage.captureTimeNs), encodedImage.rotation, f151500w0, bArr);
        f151500w0++;
        CGLog.v("decode frameIndex=" + encodedImage.captureTimeMs + " decodeStartTimeMs=" + aVar.f151579a + " packet frameIndex: " + videoPacket.f151569d);
        this.C.offer(aVar);
        videoPacket.f151571f = 0;
        if (this.K) {
            try {
                this.f151524o0.write(videoPacket.f151566a);
            } catch (Exception unused) {
                CGLog.e("Failed to write to encoded_video_stream.data");
            }
        }
        if (byteBuffer != null) {
            byteBuffer.putInt(i19, remaining);
            int i57 = i19 + 4;
            byteBuffer.putShort(i57, (short) encodedImage.recvToDecodeMs);
            byteBuffer.putLong(i57 + 4, currentTimeMillis);
        }
        if (this.f151513g0) {
            i3 = DoDecode(this.f151521m, videoPacket);
        } else {
            VideoDecoder.DecodeCallback decodeCallback6 = f151502y0;
            if (decodeCallback6 != null) {
                decodeCallback6.onDecodeErrCodeReported(true, VideoCodecStatus.UNINITIALIZED.getNumber(), 0, "Decoder not initialized successfully");
            }
            CGLog.e("Decoder not initialized successfully");
            i3 = 0;
        }
        VideoCodecStatus videoCodecStatus = VideoCodecStatus.OK;
        if (i3 != 0 && i3 != -315) {
            VideoDecoder.DecodeCallback decodeCallback7 = f151502y0;
            if (decodeCallback7 != null) {
                decodeCallback7.onDecodeErrCodeReported(true, VideoCodecStatus.DO_DECODE_ERROR.getNumber(), i3, "result != 0");
            }
            CGLog.d("Reinit decoder, frame.encodedWidth:" + encodedImage.encodedWidth + " frame.encodedHeight" + encodedImage.encodedHeight + " mPreviousWidth" + this.I);
            int i58 = encodedImage.encodedWidth;
            if (i58 > 0 && (i16 = encodedImage.encodedHeight) > 0) {
                k3 = k(i58, i16);
            } else {
                k3 = k(this.I, this.J);
            }
            if (k3 != videoCodecStatus) {
                CGLog.e("Failed to reinit decoder, framesDecoded :" + f151501x0 + " result:" + i3 + " status:" + k3);
                return k3;
            }
            CGLog.d("Succeed to reinit decoder,  framesDecoded :" + f151501x0 + " result: " + i3 + " status:" + k3);
            videoCodecStatus = k3;
        }
        if ((i3 != 0 || this.f151512f0) && currentTimeMillis - this.Q >= 500) {
            videoCodecStatus = VideoCodecStatus.NO_OUTPUT;
            this.Q = currentTimeMillis;
            this.f151512f0 = false;
            CGLog.i("DoDecode result=" + i3 + ", mIdrRequest=" + this.f151512f0 + ", requesting IDR");
        }
        if (this.F) {
            this.F = false;
        }
        return videoCodecStatus;
    }

    @Override // org.tencwebrtc.VideoDecoder
    public String getImplementationName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f151507d;
    }

    @Override // org.tencwebrtc.VideoDecoder
    public boolean getPrefersLateDecoding() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    public long h(int i3, Surface surface, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), surface, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18))).longValue();
        }
        CGLog.i("VDecoder initDecodeInternal name: " + i17 + " height: " + i18);
        DecParam decParam = new DecParam();
        decParam.f151538a = i3;
        decParam.f151539b = 1;
        decParam.f151540c = i17;
        decParam.f151541d = i18;
        decParam.f151543f = 1;
        decParam.f151544g = 0;
        decParam.f151546i = surface;
        decParam.f151552o = "com/tencent/medialab/video/decoder/VDecoder";
        decParam.f151547j = this.M;
        decParam.f151542e = i16;
        this.N = i16;
        CGLog.i("Open decoder result=" + Open(this.f151521m, decParam));
        SetFeatureInt(this.f151521m, "tunneled-playback", this.L ? 1 : 0);
        return this.f151521m;
    }

    @Override // org.tencwebrtc.VideoDecoder
    public VideoCodecStatus initDecode(VideoDecoder.Settings settings, VideoDecoder.Callback callback) {
        Surface surface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (VideoCodecStatus) iPatchRedirector.redirect((short) 2, (Object) this, (Object) settings, (Object) callback);
        }
        if (f151495r0 && ((surface = f151496s0) == null || !surface.isValid())) {
            CGLog.i("initDecode: skipRender, but displaySurface is released");
            VideoDecoder.DecodeCallback decodeCallback = f151502y0;
            if (decodeCallback != null) {
                decodeCallback.onDecodeErrCodeReported(true, VideoCodecStatus.SURFACE_NULL_OR_VALID.getNumber(), 0, "initDecode: skipRender, but displaySurface is released");
            }
            return VideoCodecStatus.ERR_PARAMETER;
        }
        f151500w0 = 0;
        f151501x0 = 0L;
        f151497t0 = 0L;
        this.f151526q0 = false;
        this.D = new ThreadUtils.ThreadChecker();
        this.f151525p0 = callback;
        if (!f151495r0 && this.f151515h0 != null) {
            try {
                SurfaceTextureHelper b16 = b();
                this.f151518j0 = b16;
                if (b16 == null) {
                    CGLog.e("surfaceTextureHelper=null returned by createSurfaceTextureHelper");
                    VideoDecoder.DecodeCallback decodeCallback2 = f151502y0;
                    if (decodeCallback2 != null) {
                        decodeCallback2.onDecodeErrCodeReported(true, VideoCodecStatus.SURFACE_TEXTURE_HELPER_NULL_EXCEPTION.getNumber(), 0, "surfaceTextureHelper=null returned by createSurfaceTextureHelper");
                    }
                    return VideoCodecStatus.ERR_PARAMETER;
                }
                this.f151517i0 = new Surface(this.f151518j0.getSurfaceTexture());
                this.f151518j0.startListening(this);
            } catch (Throwable th5) {
                CGLog.e("initDecode exception: " + th5);
                VideoDecoder.DecodeCallback decodeCallback3 = f151502y0;
                if (decodeCallback3 != null) {
                    decodeCallback3.onDecodeErrCodeReported(true, VideoCodecStatus.SURFACE_TEXTURE_HELPER_NULL_EXCEPTION.getNumber(), 0, "initDecode exception: " + th5.getMessage());
                }
                return VideoCodecStatus.ERR_PARAMETER;
            }
        }
        this.f151519k0 = true;
        return i(settings.width, settings.height);
    }

    public VideoCodecStatus l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (VideoCodecStatus) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        CGLog.i("releaseInternal result=" + Close(this.f151521m));
        Release(this.f151521m);
        this.f151521m = 0L;
        this.f151513g0 = false;
        return VideoCodecStatus.OK;
    }

    @Override // org.tencwebrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) videoFrame);
            return;
        }
        synchronized (this.f151520l0) {
            CGLog.e("Rendered texture metadata was null in onTextureFrameAvailable.");
        }
    }

    @Override // org.tencwebrtc.VideoDecoder
    public VideoCodecStatus release() {
        FileOutputStream fileOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (VideoCodecStatus) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        this.f151519k0 = false;
        VideoCodecStatus l3 = l();
        if (this.K && (fileOutputStream = this.f151524o0) != null) {
            try {
                fileOutputStream.close();
            } catch (Exception unused) {
            }
            this.f151524o0 = null;
        }
        Surface surface = this.f151517i0;
        if (surface != null) {
            surface.release();
            this.f151517i0 = null;
            SurfaceTextureHelper surfaceTextureHelper = this.f151518j0;
            if (surfaceTextureHelper != null) {
                surfaceTextureHelper.stopListening();
                this.f151518j0.dispose();
                this.f151518j0 = null;
            }
        }
        synchronized (this.f151520l0) {
        }
        this.f151525p0 = null;
        this.C.clear();
        CGLog.i("release, status=" + l3);
        return l3;
    }

    public VDecoder(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.f151507d = "";
        this.f151509e = null;
        this.C = null;
        this.E = new Object();
        this.K = false;
        this.L = false;
        this.M = 4;
        this.P = 500L;
        this.R = -315;
        this.S = -319;
        this.T = 48;
        this.U = 64;
        this.V = 16;
        this.W = 16;
        this.X = 48;
        this.Y = 16;
        this.Z = 16;
        this.f151504a0 = false;
        this.f151505b0 = true;
        this.f151506c0 = 10;
        this.f151508d0 = 12000;
        this.f151510e0 = 1;
        this.f151512f0 = false;
        this.f151513g0 = false;
        this.f151520l0 = new Object();
        this.f151521m = Create();
        this.M = i3;
        this.f151504a0 = z16;
        this.f151515h0 = null;
    }
}
