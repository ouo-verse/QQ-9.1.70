package com.tencent.turingfd.sdk.xq;

import com.tencent.ams.fusion.widget.cny2025.twist.CNYTwistArrowLayer;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.video.decode.AVDecodeError;
import cooperation.qzone.QZoneHelper;
import org.apache.commons.fileupload.MultipartStream;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.continue, reason: invalid class name */
/* loaded from: classes27.dex */
public class Ccontinue {
    static IPatchRedirector $redirector_;
    public static final int[] A;
    public static final int[] A0;
    public static final int[] B;
    public static final int[] B0;
    public static final int[] C;
    public static final int[] C0;
    public static final int[] D;
    public static final int[] D0;
    public static final int[] E;
    public static final int[] E0;
    public static final int[] F;
    public static final int[] F0;
    public static final int[] G;
    public static final int[] G0;
    public static final int[] H;
    public static final int[] H0;
    public static final int[] I;
    public static final int[] I0;
    public static final int[] J;
    public static final int[] J0;
    public static final int[] K;
    public static final int[] K0;
    public static final int[] L;
    public static final int[] L0;
    public static final int[] M;
    public static final int[] M0;
    public static final int[] N;
    public static final int[] N0;
    public static final int[] O;
    public static final int[] O0;
    public static final int[] P;
    public static final int[] P0;
    public static final int[] Q;
    public static final int[] Q0;
    public static final int[] R;
    public static final int[] R0;
    public static final int[] S;
    public static final int[] S0;
    public static final int[] T;
    public static final int[] T0;
    public static final int[] U;
    public static final int[] U0;
    public static final int[] V;
    public static final int[] V0;
    public static final int[] W;
    public static final int[] W0;
    public static final int[] X;
    public static final int[] X0;
    public static final int[] Y;
    public static final int[] Y0;
    public static final int[] Z;
    public static final int[] Z0;

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f383249a;

    /* renamed from: a0, reason: collision with root package name */
    public static final int[] f383250a0;

    /* renamed from: a1, reason: collision with root package name */
    public static final byte[] f383251a1;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f383252b;

    /* renamed from: b0, reason: collision with root package name */
    public static final int[] f383253b0;

    /* renamed from: b1, reason: collision with root package name */
    public static final byte[] f383254b1;

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f383255c;

    /* renamed from: c0, reason: collision with root package name */
    public static final int[] f383256c0;

    /* renamed from: c1, reason: collision with root package name */
    public static final byte[] f383257c1;

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f383258d;

    /* renamed from: d0, reason: collision with root package name */
    public static final int[] f383259d0;

    /* renamed from: d1, reason: collision with root package name */
    public static final byte[] f383260d1;

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f383261e;

    /* renamed from: e0, reason: collision with root package name */
    public static final int[] f383262e0;

    /* renamed from: e1, reason: collision with root package name */
    public static final byte[] f383263e1;

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f383264f;

    /* renamed from: f0, reason: collision with root package name */
    public static final int[] f383265f0;

    /* renamed from: f1, reason: collision with root package name */
    public static final byte[] f383266f1;

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f383267g;

    /* renamed from: g0, reason: collision with root package name */
    public static final int[] f383268g0;

    /* renamed from: g1, reason: collision with root package name */
    public static final byte[] f383269g1;

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f383270h;

    /* renamed from: h0, reason: collision with root package name */
    public static final int[] f383271h0;

    /* renamed from: h1, reason: collision with root package name */
    public static final int[] f383272h1;

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f383273i;

    /* renamed from: i0, reason: collision with root package name */
    public static final int[] f383274i0;

    /* renamed from: i1, reason: collision with root package name */
    public static final int[] f383275i1;

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f383276j;

    /* renamed from: j0, reason: collision with root package name */
    public static final int[] f383277j0;

    /* renamed from: j1, reason: collision with root package name */
    public static final int[] f383278j1;

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f383279k;

    /* renamed from: k0, reason: collision with root package name */
    public static final int[] f383280k0;

    /* renamed from: k1, reason: collision with root package name */
    public static final int[] f383281k1;

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f383282l;

    /* renamed from: l0, reason: collision with root package name */
    public static final int[] f383283l0;

    /* renamed from: l1, reason: collision with root package name */
    public static byte[] f383284l1;

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f383285m;

    /* renamed from: m0, reason: collision with root package name */
    public static final int[] f383286m0;

    /* renamed from: m1, reason: collision with root package name */
    public static final byte[] f383287m1;

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f383288n;

    /* renamed from: n0, reason: collision with root package name */
    public static final int[] f383289n0;

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f383290o;

    /* renamed from: o0, reason: collision with root package name */
    public static final int[] f383291o0;

    /* renamed from: p, reason: collision with root package name */
    public static final int[] f383292p;

    /* renamed from: p0, reason: collision with root package name */
    public static final int[] f383293p0;

    /* renamed from: q, reason: collision with root package name */
    public static final int[] f383294q;

    /* renamed from: q0, reason: collision with root package name */
    public static final int[] f383295q0;

    /* renamed from: r, reason: collision with root package name */
    public static final int[] f383296r;

    /* renamed from: r0, reason: collision with root package name */
    public static final int[] f383297r0;

    /* renamed from: s, reason: collision with root package name */
    public static final int[] f383298s;

    /* renamed from: s0, reason: collision with root package name */
    public static final int[] f383299s0;

    /* renamed from: t, reason: collision with root package name */
    public static final int[] f383300t;

    /* renamed from: t0, reason: collision with root package name */
    public static final int[] f383301t0;

    /* renamed from: u, reason: collision with root package name */
    public static final int[] f383302u;

    /* renamed from: u0, reason: collision with root package name */
    public static final int[] f383303u0;

    /* renamed from: v, reason: collision with root package name */
    public static final int[] f383304v;

    /* renamed from: v0, reason: collision with root package name */
    public static final int[] f383305v0;

    /* renamed from: w, reason: collision with root package name */
    public static final int[] f383306w;

    /* renamed from: w0, reason: collision with root package name */
    public static final int[] f383307w0;

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f383308x;

    /* renamed from: x0, reason: collision with root package name */
    public static final int[] f383309x0;

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f383310y;

    /* renamed from: y0, reason: collision with root package name */
    public static final int[] f383311y0;

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f383312z;

    /* renamed from: z0, reason: collision with root package name */
    public static final int[] f383313z0;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13482);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f383249a = new int[]{75, -17, 34, 86, -10, -77, 76, -127, 42, 77, 123, 122};
        f383252b = new int[]{73, -69, 33, -16, -1, 76, -60, 30, -101, 34, -24, 77, -1, -105, -36, 96};
        f383255c = new int[]{-30, 35, 37, 42, -96, -26, 99, 115, 92, Constants.BINARY_PERF_STATS, 36, -21, 108, -51, -101, -68};
        f383258d = new int[]{120, -25, -3, 69, -90, 113, 105, 105, -100, -90, -37, -51};
        f383261e = new int[]{AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, -100, -58, -48, 17, -78, 5, -77, -103, 61, 68, 48};
        f383264f = new int[]{-43, 29, -19, -102, 95, 52, 96, -68, -1, 127, AVDecodeError.VIDEO_DECODE_V_ERR, 97};
        f383267g = new int[]{52, 46, 108, -98, -88, 93, -102, -66, 30, -11, -99, -6, -40, -61, 49, 106, -7, 44, 59, -9, 111, -49, -35, -68};
        f383270h = new int[]{-54, 100, 110, AVDecodeError.VIDEO_DECODE_V_ERR, -89, -33, -53, -72, -47, -61, -60, 29, AVDecodeError.AUDIO_DATA_DECODE_FINISH, 117, 80, 53, 3, -72, -52, 124, 39, 41, 127, 10, 30, -39, 42, -119, -5, -112, 53, 27, 84, 88, 113, -27, 24, -75, -34, -73};
        f383273i = new int[]{101, -104, 76, -39, -84, 62, -43, 114, 58, 7, 64, -14, -60, 23, 22, 44, 5, 41, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, 120, -65, -48, 54, -76, -16, 80, 14, 106, 16, -22, 58, 99};
        f383276j = new int[]{46, 90, 54, 109, -127, -41, 84, -119};
        f383279k = new int[]{-6, 109, -18, 19, -87, 44, -60, -57, -107, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, AVDecodeError.VIDEO_DECODE_V_ERR, -9, -90, 35, -15, 48, 2, -45, -69, -66, -51, -73, -104, 64, -22, -101, 101, -94, 35, -42, 39, -83, 96, -14, 127, 78, -32, 47, -31, -74, -39, 91, 86, -128};
        f383282l = new int[]{-64, 111, 2, -97, 43, 94, -40, -110, -106, -11, 127, 44, -32, 24, -98, 25, -69, 74, -105, -127, -106, -59, -50, 88, 86, 108, AVDecodeError.VIDEO_DECODE_A_ERR, AVDecodeError.JNI_BITMAP_STRIDE_ERR, 101, 6, 85, 33, -46, 6, 113, -30};
        f383285m = new int[]{89, 66, 67, AVDecodeError.JNI_BITMAP_STRIDE_ERR, 26, 115, -44, 40, 18, 74, 50, 41, 37, 73, -38, -49, 91, 84, -43, -20};
        f383288n = new int[]{-8, 109, 44, -13, -112, -62, 56, -119, -82, 106, 107, -8, 98, 83, -12, 121, 32, -45, 73, 10};
        f383290o = new int[]{-76, 8, 24, 88, -5, 0, 96, 85, 60, -23, 72, 114, 13, -96, -34, 36, -73, 9, 58, -22, -57, -81, -72, 89, -80, -84, 36, 7, 38, -29, -28, 54, -50, 2, -28, 8, -127, -24, AVDecodeError.VIDEO_DECODE_V_ERR, 112, -47, 31, -46, -62, -83, -85, 118, 14, -120, 61, -92, 91, -54, -21, 103, -88, -7, 1, 44, 43};
        f383292p = new int[]{-58, -34, -67, 25, -82, 115, 120, 22, 71, -104, 92, -107, 94, -79, -45, -80, 79, 21, 67, -110, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, 44, 124, -104, 67, -40, -86, -69, 20, 67, -44, 84, 39, 52, -24, 58, -17, -65, -13, 95, 51, -77, 82, -69, 28, 48, 90, 2, -39, 35, 64, -19, 43, 115, 114, 108, -64, 41, 77, 100, -4, -16, -34, 65, -11, 95, -64, 41, 124, 50, 98, -47};
        f383294q = new int[]{110, -65, Constants.BINARY_PERF_STATS, -22, 116, 12, -58, -51, -53, 3, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, -112, -74, 37, -69, -97, 117, 16, -31, -62, -91, -65, 82, 35, -99, 62, 105, -6, 45, 60, -16, 89, -32, -53, -99, -18, 6, -76, -105, -5, 65, 22, 55, -110, -122, 41, -53, -104, -55, 99, 63, -67, 104, 0, -99, -72, 3, AVDecodeError.VIDEO_DECODE_A_ERR, -61, -12, -14, -83, -25, -17, -3, 115, 20, -18, 112, 108, 69, -92, 109, 78, -47, -87, AVDecodeError.VIDEO_DECODE_A_ERR, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, -26, 58, -54, 103, -91, 72};
        f383296r = new int[]{-14, -78, -106, -26, 123, -84, 79, -86, -36, 86, 13, -91, -57, 89, -107, 118, 28, -92, 116, 70, -117, 86, -20, -91, -4, 24, -101, 19, 2, 120, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, -42, -30, 92, 113, 38, -13, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, 80, -75, -88, -42, -4, -66, -53, 30, -30, -119, 126, -17, 20, -102, -27, 108, 41, 95, 24, -13, 24, -71};
        f383298s = new int[]{-15, 53, -128, -12, 85, -113, 6, 53, 96, -31, -65, -1, 58, 24, -74, 23, -97, 120, 121, -44, -35, 109, 5, -46, 16, -101, -15, -122, 49, 79, -65, 100, -67, -68, 68, -89, -104, -10, -49, -77, 23, -27, 37, 40, 83, -37, 37, 35, 74, -82, 34, 43, 116, 3, -96, 72, -75, -113, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, 51, 28, 88, 105, 8, 71, AVDecodeError.JNI_BITMAP_STRIDE_ERR, 38, 104, -69, -28, 0, -19, 15, -56, 51, -70, -102, 37, -91, 28, 47, -42, 27, 71, 70, -98, -99, -61};
        f383300t = new int[]{-31, 124, 89, 92, -17, 121, 91, AVDecodeError.VIDEO_DECODE_V_ERR, AVDecodeError.VIDEO_DECODE_A_ERR, -92, 55, 61, 79, -42, -92, 103, 10, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, 101, -17, 63, -40, 88, 104, 87, 108, -97, -99, -120, 55, 36, -31, 22, 90, -92, 51, 29, 77, 43, 83, 73, 75, 43, 104, -75, 85, 86, AVDecodeError.VIDEO_DECODE_V_ERR, -14, -13, -97, 56, -97, 27, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, -96, 16, -94, -107, 54};
        f383302u = new int[]{50, -65, -89, 30, -68, -32, 64, -3, 33, -105, 58, -42, 48, 118, 76, 25, 102, AVDecodeError.VIDEO_DECODE_V_ERR, 87, 118, 42, 110, 48, -86, 39, 76, 122, -19, 9, 20, 64, 26, 22, 80, 93, 67, 34, -25, -28, -72, -29, 6, 49, -93, 72, 59, -36, 55, -98, 10, 38, -99, 106, -112, 41, 24, 120, -125, 95, -46, 83, 110, -67, -47, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, -46, 48, 59};
        f383304v = new int[]{-67, AVDecodeError.VIDEO_DECODE_V_ERR, -14, -73, -32, -113, AVDecodeError.VIDEO_DECODE_A_ERR, -62, -55, 87, 118, -57, 88, -77, 102, 55, -69, 46, Constants.BINARY_PERF_STATS, 121, 9, -2, 4, 9, -91, 89, -117, -51, 24, -89, 81, -42, -119, -4, -57, -24, -16, -62, 69, 58, 99, 23, -95, -15, -55, -127, 21, 36, 43, -49, -78, 36, 16, 74, 84, 13, 74, 33, -50, 7, 57, -103, 38, 118, -25, 100, 3, 115, 9, -15, -42, 23};
        f383306w = new int[]{1, 77, -50, 11, -52, 72, -40, 65, 7, 90, 120, 63, 85, 75, -82, -10, -60, 10, -54, 29, -105, -72, 18, 36, 99, 46, -22, 31, 47, 92, -84, -29, -14, 111, 34, -9, -65, 101, 63, 49, -88, -2, 4, 85, -21, 8, 85, -122, 32, -1, -49, 110, 24, -1, -75, 42};
        f383308x = new int[]{-72, -85, 16, 11, -96, 7, 3, -120, -52, 120, -73, 49, 90, 47, -99, -85, 105, -81, 93, 10, 58, -70, 98, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, -67, -53, -125, 3, -45, 117, 56, -46, 23, -111, 94, 17, 30, 47, 120, -8, 41, 109, 33, -52, Constants.BINARY_PERF_STATS, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, -100, 19, -16, 34, 43, -53, 3, AVDecodeError.VIDEO_DECODE_A_ERR, -110, -96, 23, -32, -39, 92};
        f383310y = new int[]{-111, -42, 47, -99, -28, -56, -49, 116, 100, 115, 33, -12, 86, 73, 11, -101, -69, 57, 82, -105, -73, -24, -30, -23, 28, -40, -98, 11, 77, 62, 71, 71, -59, -67, -64, -93, 50, -85, -93, -29, 45, -17, 102, 24, -79, -4, 40, -6, 42, 60, -23, -106, 95, 65, -110, -92, 65, -122, 59, -7, -87, -65, -15, -27, 7, 123, -11, 32, -10, -30, -85, 14, 38, 69, -125, 60, -18, 65, -6, 53, 84, 71, 49, -113, -98, 71, AVDecodeError.JNI_BITMAP_STRIDE_ERR, 12, 64, -44, -8, 81, 17, -74, -81, 52, 111, -77, 108, 49};
        f383312z = new int[]{-16, 29, 83, -39, 2, -91, 80, -49, -55, AVDecodeError.AUDIO_DATA_DECODE_FINISH, -73, 99, 70, -77, -15, 50, 84, 100, -111, 86, 31, 78, 5, ExportErrorStatus.WRITE_VIDEO_SAMPLE, 95, -40, -13, 91, -49, -104, -46, -102, -27, -17, 17, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, 42, 93, -91, -58, 125, -31, -86, 58, 64, -84, -100, -91, 42, -81, 42, 71, -47, -102, -41, 115, -85, 27, 58, 15, 1, 105, 7, 52, 109, AVDecodeError.VIDEO_DECODE_A_ERR, -38, 121, 56, 21, -92, 62, AVDecodeError.VIDEO_DECODE_V_ERR, 59, -80, 97, 100, 11, -59, -14};
        A = new int[]{-12, -23, 126, -87, -58, -40, -32, 99, -111, -62, 40, 40, 74, 17, 40, -82, 87, -107, -82, 32, -23, -9, 103, -112, -101, -86, -17, 3, -102, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, Constants.BINARY_PERF_STATS, -111, 37, -102, -60, 95, 48, 123, -128, 110, 106, -48, 79, 42, -86, 102, 108, -26, 118, 18, -52, -27, 33, 24, -49, -63, -59, 43, 65, -54, 107, 40, 78, 79};
        B = new int[]{125, -42, 65, 109, 116, 63, -61, -30, -9, 117, -79, -81, 104, -55, -122, 14, 102, -29, 101, 75, -112, 57, 112, -111, -4, -122, 93, ExportErrorStatus.WRITE_VIDEO_SAMPLE, 5, 30, -26, -68, ExportErrorStatus.WRITE_VIDEO_SAMPLE, -73, 34, AVDecodeError.AUDIO_DATA_DECODE_FINISH, 62, 120, 85, 62, -97, -78, -70, 14, 96, 43, 39, 61, -49, -55, -83, 28, -112, -73, -13, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, 55, -12, -68, -35, AVDecodeError.VIDEO_DECODE_V_ERR, 25, 124, -25, -83, 72, -11, -101, -86, 34, -33, -31, 15, -94, 88, 121, -8, -93, 111, 3, 3, -110, 100, -75};
        C = new int[]{-105, 102, 121, 34, -74, -80, 5, 25, -127, -65, 94, -104, -120, 120, 18, 17, -16, -79, 15, -103, 71, 35, 2, -39, 57, -82, -54, 101, 99, 87, -41, -47, 99, 23, 70, 16, 27, -75, -56, -4, -77, 98, 113, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, -75, 73, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, -89, 54, 0, -46, -86, -48, 31, 57, -33, 0, 5, 92, 111, 99, 77, Constants.BINARY_PERF_STATS, 81, -42, 96, 100, 81, -10, 118, -119, -107, 1, -98, 21, -28, 73, -6, 26, 43, 90, 30, -112, 116};
        D = new int[]{45, 98, 109, 13, -92, -91, 20, -3, 95, 60, -36, 4, 17, -42, 122, -68, 70, 78, 28, 27, -21, -54, 93, -1, -18, 113, -43, 37, 100, -80, 66, 26, -78, -55, 15, 66, 85, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, 103, -45, 103, 45, -73, -67, 34, -106, 102, -99, -63, -2, 7, -32, -99, 27, 110, -17, AVDecodeError.VIDEO_DECODE_A_ERR, 13, 75, -77, 65, 13, -97, -88};
        E = new int[]{-87, -106, 56, -34, -54, AVDecodeError.VIDEO_DECODE_A_ERR, -78, -26, -71, -105, 60, 92, 65, 69, 61, 66, -13, 16, 63, 9, 16, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, 109, 65, 101, 39, AVDecodeError.JNI_BITMAP_STRIDE_ERR, 120, -100, 52, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, -23, -102, -12, -111, -95, -75, 9, 89, 43, 65, 16, 70, -111, -43, 60, 36, -97, -33, AVDecodeError.JNI_BITMAP_STRIDE_ERR, -53, 52};
        F = new int[]{-31, -128, 99, -51, 121, 94, 101, -14, 58, -128, 71, -96, -84, -93, -5, 43, 39, 89, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, 12, -92, ExportErrorStatus.WRITE_VIDEO_SAMPLE, 69, 91, -51, -95, 81, -33, 78, 44, 103, AVDecodeError.VIDEO_DECODE_V_ERR, -117, -33, 11, -85, 124, -1, 36, -43, 71, 109, -48, -55};
        G = new int[]{31, 111, -53, -46, 127, -41, -13, -45, -12, 28, -125, 93, 103, -18, 49, -112, -43, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, 115, 21, 85, -117, -41, -16, 20, 16, -9, 124, -4, 45, 93, 104, 63, 5, -61, -4, 85, 84, -97, 64, 55, -65, -83, 81, 127, 41, 117, 34, 7, -106, -50, 9, -14, -57, -23, 21};
        H = new int[]{32, -113, -104, -127, 83, 34, 69, 41, -28, -82, -18, 20, -79, -18, 69, -64, -83, 66, 9, -111, 36, 114, -112, -42, -24, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, -4, -13, -18, 22, -107, -84, 126, 67, -26, 30, 37, -78, 38, Constants.BINARY_PERF_STATS, AVDecodeError.JNI_BITMAP_STRIDE_ERR, 111, 110, 13};
        I = new int[]{-127, 117, -101, -125, -93, -117, 71, -32, 44, 75, -14, -104, 76, 83, -18, -122, 21, 37, -32, 114, -49, -56, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, 69, -72, -54, -107, 65, 9, -64, -44, 29};
        J = new int[]{-73, -82, 56, 68, -8, -1, 42, -8, 89, 89, -103, 7, 23, 114, -96, -24, 46, -25, -99, -43};
        K = new int[]{-13, 56, -75, -14, -32, 25, 48, -52, 5, -21, -112, 41, 25, -25, -80, -36, 122, -61, -50, -20, 1, 72, 68, -48};
        L = new int[]{-24, -127, -93, 99, 16, 73, -50, -48, -80, -92, 57, 41, 97, 85, 47, -91, 24, 4, -107, 37, -98, -18, 5, -107, -94, -77, -21, -17};
        M = new int[]{122, 104, -111, -74, -111, -107, -76, -61, -93, 107, 55, 91, -78, -21, -68, 103, 105, -71, 85, -44};
        N = new int[]{39, AVDecodeError.AUDIO_DATA_DECODE_FINISH, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, 80, 119, -127, 63, 115, -27, -94, 35, -75, -92, 91, 100, 83, -30, 69, 107, -46, 10, -64, 31, 29, -91, 12, 6, 48, -22, -39, 5, -11};
        O = new int[]{15, -4, 120, -21, 44, 99, 49, -1, -46, -61, -23, -49, 83, 96, 113, AVDecodeError.JNI_BITMAP_STRIDE_ERR, 22, -17, 32, -85, -56, 111, 94, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, -70, 61, 62, 55};
        P = new int[]{100, 99, 86, 22, -59, -83, -122, 11, 87, -33, -95, 110, 53, -39, 35, 110, AVDecodeError.AUDIO_DATA_DECODE_FINISH, 64, 65, -21, 46, -65, 94, -50, 93, -13, -24, 79};
        Q = new int[]{-102, -70, 108, -84, 96, -77, 123, 117, -47, 39, -112, -120, 75, 86, 113, -105, -80, -2, 88, -24, -15, 118, -92, -81, -67, -102, -101, -6};
        R = new int[]{-119, -36, 73, 72, -65, -38, 27, -35, -101, 9, -28, -105, 12, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, -24, 87, -1, 118, -113, 65, 51, -7, -13, -42, 113, -81, 42, -122};
        S = new int[]{28, -73, -6, -59, -41, 101, 111, 29, 13, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, 26, 103, 85, 43, 127, 26, 34, 44, 94, 118, -53, 9, -127, 35};
        T = new int[]{127, 49, -105, -112, -53, -53, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, 4, -40, 16, -18, -16, -32, -35, 38, 67, 75, 105, 48, 9};
        U = new int[]{-72, -22, -1, 121, -25, 35, -99, 126, -54, -97, 17, -19, 32, -68, -86, -128, 27, 54, 36, -16, 36, -55, 66, 61, -113, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, -98, 56, 39, 78, 98, -83};
        V = new int[]{21, 60, -55, 26, -105, 117, 1, -119, -55, 81, 3, 71, -69, -22, -11, 2};
        W = new int[]{26, 7, 1, 69, 34, 107, -59, -53, -98, -127, 37, -50, -67, 122, 112, -43, 34, -33, -38, 112, 46, -127, 17, -73};
        X = new int[]{-15, -18, -18, -26, -125, -112, 76, 7, -45, -14, 24, 118, 1, -82, -120, 118, 76, 48, 115, -49, -51, -24, 61, 11, 97, 92, Constants.BINARY_PERF_STATS, -85};
        Y = new int[]{-100, -70, -102, -106, 55, 127, -74, 46, AVDecodeError.VIDEO_DECODE_V_ERR, 24, -56, -21, -37, -112, -73, 121};
        Z = new int[]{104, 35, -8, 8, -87, 20, 127, -54, -51, 119, 73, -25, 100, 67, 77, -52};
        f383250a0 = new int[]{113, 46, -58, -82, -77, 56, 106, -10, -101, -54, 90, -66, -91, 104, -68, -68};
        f383253b0 = new int[]{111, 60, 66, -40, -21, 123, -34, -22, 86, -20, -79, 113, -59, 84, -52, 126, 125, 124, -55, 23, 76, -117, 27, -75, -29, 9, 25, -96};
        f383256c0 = new int[]{-42, -8, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, -107, -99, -63, 93, 86, 67, -119, 29, 57};
        f383259d0 = new int[]{28, -117, 22, -24, -94, 54, 68, 71, 97, AVDecodeError.JNI_BITMAP_STRIDE_ERR, 19, -128};
        f383262e0 = new int[]{-29, 37, 113, -88, -51, 59, 42, 89, -68, 79, -35, 89};
        f383265f0 = new int[]{AVDecodeError.AUDIO_DATA_DECODE_FINISH, 72, 16, 96, 98, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, 18, 95, 112, 106, 62, -71};
        f383268g0 = new int[]{-83, -125, 70, -50, -27, 53, 33, 113, -61, 89, 6, -78, Constants.BINARY_PERF_STATS, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, 67, -101};
        f383271h0 = new int[]{70, 90, -110, 20, -113, 3, 119, -19, -36, 26, 72, 62, -2, -103, 126, -120, -58, 89, -17, 40};
        f383274i0 = new int[]{63, -26, -20, 80, -39, -72, 34, 95, -16, -53, -104, 31};
        f383277j0 = new int[]{104, -74, -79, 105, 70, 84, -117, 16};
        f383280k0 = new int[]{48, 77, -18, -91, 65, -15, -36, -69, -71, 35, -31, 45, 18, 34, 82, -53, -8, 15, 100, AVDecodeError.VIDEO_DECODE_A_ERR, -41, -68, 30, -44};
        f383283l0 = new int[]{82, 11, -9, 46, 110, 96, -32, -46, 101, -43, -20, 77, -45, 51, 85, -48, -94, 32, 77, -26, 14, -43, 26, 73, 36, 24, -65, -52};
        f383286m0 = new int[]{67, -34, 116, 103, 125, 99, 36, 32, -31, -99, 105, 58, -35, 77, 83, 84, -93, 14, -61, 126, -75, 56, -54, 88, -50, -22, 83, -47, -12, 66, -104, 30};
        f383289n0 = new int[]{-56, 35, 26, 103, 53, 14, 30, 127, 24, 93, 114, 23, -64, 57, 52, -21, 17, 0, 74, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, -58, 80, -52, 112, 107, 116, 124, AVDecodeError.VIDEO_DECODE_V_ERR, -79, 120, 92, -41, -69, 109, 58, 60, -11, -90, 68, 73, -24, 121, -74, 0};
        f383291o0 = new int[]{3, -59, -44, -18, -77, 48, 55, 100, 16, 98, 105, -46, 40, 22, -37, 35, -46, -23, 6, -106};
        f383293p0 = new int[]{-88, -47, -94, 64, -39, 8, -113, AVDecodeError.AUDIO_DATA_DECODE_FINISH, 49, 50, AVDecodeError.VIDEO_DECODE_A_ERR, 21, -8, 41, 76, -38, -53, 119, AVDecodeError.VIDEO_DECODE_A_ERR, 120};
        f383295q0 = new int[]{122, 46, 7, 109, -71, AVDecodeError.AUDIO_DATA_DECODE_FINISH, 123, 116, -98, 18, 59, 14, 83, 8, 35, 44};
        f383297r0 = new int[]{-14, 21, 39, -99, -104, -39, 37, -25, -55, 26, 88, -33, -125, 68, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, -50};
        f383299s0 = new int[]{-86, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, -1, 24, -28, -33, 50, -38};
        f383301t0 = new int[]{9, -125, -4, -6, -24, -68, 69, 59, -88, -53, AVDecodeError.VIDEO_DECODE_V_ERR, -89};
        f383303u0 = new int[]{63, 20, -58, 27, 5, 82, -53, -17, 109, -15, 53, -76};
        f383305v0 = new int[]{87, 38, -71, 65, 41, -39, 123, -78, -2, 95, 95, 115, 31, -10, 123, -128, 120, -90, -87, 89};
        f383307w0 = new int[]{3, 45, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, -57, 80, 13, -23, -35, -8, 24, -90, 40, -78, -11, 105, 42, 14, 16, -106, 83};
        f383309x0 = new int[]{-102, 98, -110, 10, 124, 56, -101, -7, 77, -43, 24, 64, 87, -76, -45, -105, -72, 10, 6, -65, -80, -19, -51, Constants.BINARY_PERF_STATS, 51, -21, 44, -81, -3, 17, 70, -67, 8, -77, -47, 113, -63, 30, 119, 15};
        f383311y0 = new int[]{-9, 36, -50, 30, 63, 42, -25, -79};
        f383313z0 = new int[]{115, 30, -60, 26, 105, -93, 23, 116};
        A0 = new int[]{-38, -46, -113, 16, AVDecodeError.VIDEO_DECODE_A_ERR, -120, -61, -27, -20, -89, -13, -45, -94, -22, -57, -35};
        B0 = new int[]{49, 10, 53, 36, -13, 119, 57, -35, -43, 49, -47, 68, 107, 95, 117, 28};
        C0 = new int[]{-21, 2, -59, 90, -54, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, -60, -57, -9, 106, 8, -40, -16, -113, 21, -92, 33, 59, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, 116, -45, 11, -90, 42, -12, -22, 81, -113, -75, 36, -101, ExportErrorStatus.WRITE_VIDEO_SAMPLE, 126, -18, -82, 75, 41, 29, -56, 69, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, 31, -32, -125, -125, 101, 78, -31, 95, -49, -42, 56, 105, -3, -75, 41, 75, -35, -34, -85, 116, 8, 45, -77, 13, 1, 96, 108, 6, -2, 49, 109, -84, 97, 35, 125};
        D0 = new int[]{116, 33, 62, -28, 27, 78, -26, -38, -57, -112, 119, -29, 102, -85, 111, -17, -53, 28, -89, 7, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, -92, 75, -7, -117, 100, 67, 110};
        E0 = new int[]{-20, -59, -31, -50, 61, 97, -57, 83, -88, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, -5, Constants.BINARY_PERF_STATS, 25, -30, 82, 85, -55, -45, 83, -100, 10, -80, -66, -5};
        F0 = new int[]{49, 32, -105, -84, -92, 23, 29, 19, -128, 58, 17, 98, 95, -119, -44, 69, -44, 25, -97, 92, -41, 93, -52, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, 81, -105, -12, -83, -105, -52, -4, -107, -64, -16, -25, -85, 58, -60, 42, 85};
        G0 = new int[]{-113, -64, 20, 3, 94, -102, 52, AVDecodeError.VIDEO_DECODE_A_ERR, 85, -25, 123, -97, 16, 76, 83, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, -111, -106, -18, 64, -89, -120, 124, -57, 48, -50, -33, 64, 66, 78, 43, 18, -36, -45, 93, 44, 90, -23, 2, 101, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, -22, 68, 71};
        H0 = new int[]{-53, 83, 63, -47, 117, -106, 94, 42, 105, -22, -98, 56, 117, 69, 82, 58, 25, 18, 99, 11};
        I0 = new int[]{-111, 35, -52, 14, 85, 111, 77, 88, -97, 63, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, 28, -61, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, 89, 69, 109, 65, 123, -50, -8, 87, -73, -119, 101, 39, AVDecodeError.VIDEO_DECODE_A_ERR, 121, 78, -67, -77, -6, 110, 98, 16, 19, -112, 124, 39, 70, 31, -125, -112, -23, 46, 15, 124, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, 88, -111, -10};
        J0 = new int[]{-107, 121, 43, 87, -52, -98, -40, 98, -40, 75, 65, -12};
        K0 = new int[]{8, -107, 102, 29, 53, -57, 20, -73, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, -49, -28, -22, 110, 87, 65, -75, 89, 62, AVDecodeError.AUDIO_DATA_DECODE_FINISH, -3, -106, 28, 49, 2, -4, 2, -117, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, -86, AVDecodeError.AUDIO_DATA_DECODE_FINISH, -105, -83, 96, 43, 47, 10, 102, 56, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, 119, 41, -57, 109, -117, -105, -117, 67, -43};
        L0 = new int[]{-33, 19, 80, -35, -85, -94, 25, -62, -38, 112, -31, -31, 11, -57, -41, 74, 43, 12, -125, ExportErrorStatus.WRITE_VIDEO_SAMPLE};
        M0 = new int[]{19, 92, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, 24, Constants.BINARY_PERF_STATS, -56, -12, 84, -56, 42, -119, -107, 68, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, 13, -18, 90, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, -36, 51, AVDecodeError.VIDEO_DECODE_V_ERR, -24, -31, 21, 27, -97, -54, 126, 97, -35, 30, 49, 5, 81, 117, 124, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, 124, 67, -61, 83, 36, 113, 88, -90, -64, 115, -41};
        N0 = new int[]{120, 39, 90, -27, -52, -90, 77, -23, -69, 123, 44, 88, -119, -117, -31, -62, -74, 71, 64, 82, 48, 60, 33, -26, 37, -77, -86, 99, 59, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, -30, 13, 95, -69, -122, 50};
        O0 = new int[]{47, 69, -57, -100, 55, 104, 119, -60, -15, 49, -32, 16};
        P0 = new int[]{-75, -60, 60, -106, AVDecodeError.VIDEO_DECODE_A_ERR, -83, -120, -75, 27, 94, 119, 123};
        Q0 = new int[]{-68, 73, 12, -87, -8, -89, 21, -18, 83, ExportErrorStatus.WRITE_VIDEO_SAMPLE, 121, 8};
        R0 = new int[]{-59, -120, 11, 2, 86, 91, -93, 105};
        S0 = new int[]{27, 109, 96, 122, 13, -92, 104, -91, 10, 80, -46, -91};
        T0 = new int[]{91, -27, -30, 24, AVDecodeError.JNI_BITMAP_STRIDE_ERR, 117, -45, -62, AVDecodeError.VIDEO_DECODE_A_ERR, -9, -103, -86, 18, -94, 55, 5, -90, -105, 34, 57, ExportErrorStatus.WRITE_VIDEO_SAMPLE, 110, 102, -90, 84, 70, -5, -88};
        U0 = new int[]{-6, -104, -2, 102, -2, 34, -62, 127, 79, -99, 67, 6, 101, -27, 19, 2, 69, 91, 35, 73, 69, -8, -82, -120, 16, 14, 63, 16, 4, -122, 18, 4};
        V0 = new int[]{-67, 40, -18, -14, 58, 52, -29, -68, 35, 6, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, 87, 38, Constants.BINARY_PERF_STATS, -73, 44, AVDecodeError.JNI_BITMAP_STRIDE_ERR, -76, -27, -31, -62, 98, -91, 81, -119, -10, 13, 31, -79, -98, -19, -22, -17, 91, 64, -26};
        W0 = new int[]{118, 86, 121, -33, 32, 124, 98, 122, -90, -2, 22, -106, -113, 67, -80, -9, -75, 76, -102, 82, -104, -44, 40, 31, 10, 92, 88, -119, 43, -5, -4, -93};
        X0 = new int[]{-67, -49, 119, 49, 65, -64, 25, 94, 109, 48, 77, 93, 121, -62, 23, -13, -97, 31, 33, 103, -86, 21, -97, 101, 55, -46, -4, 109, 23, -16, -27, 119, -2, 63, -49, -89, -16, ExportErrorStatus.WRITE_VIDEO_SAMPLE, 24, -122};
        Y0 = new int[]{-30, 107, 71, 98, -105, 71, 90, 72, 0, -53, 27, -91, -80, -5, -100, -83, -26, 76, -45, -67, -60, 34, -35, -120, -50, -102, -52, 60, -11, -94, -54, 48, -79, -72, -82, -44};
        Z0 = new int[]{127, 107, 76, 31, -101, -76, -111, -51, -48, -113, -5, 6, -91, 72, 100, -120, 38, 16, 121, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, -79, 62, -47, -62, 84, -1, -79, 28};
        f383251a1 = new byte[]{87, 65, 4, 81, -101, -57, RegisterType.DOUBLE_LO, RegisterType.UNINIT_REF};
        f383254b1 = new byte[]{-4, -115, 78, 60, -19, 26, -118, -42, -36, -13, -118, -18, -24, 47, -80, -95, -34, -12, RegisterType.REFERENCE, -107, -14, 28, -49, Byte.MAX_VALUE, MultipartStream.DASH, 73, -100, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 24, -31, 8, 2, 99, 90, -101, PublicAccountH5AbilityPluginImpl.OPENIMG, -3, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, -122, -72};
        f383257c1 = new byte[]{IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 3, 26, -78, -20, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, 7, -9, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, -14, -83, 36, 102, -109, -85, -2, -27, -16, -69, 72, -31, -93, -23, 77, 1, 70, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 0, -29, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, -20, -53, 50, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, Constants.VIRTUAL_GAMEPAD_SDK_DATA, -66, -81, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, 73, 54, RegisterType.UNINIT_REF, 92, -100, -114};
        f383260d1 = new byte[]{126, 51, -29, -62, 97, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, 73, -17, 41, -45, 5, -115, -50, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, 9, 52, 6, 51, 48, -32, 32, 1, -108, 60, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, 37, -62, 8, -39, -53, RegisterType.CONFLICTED, -112, 59, -20, 33, 83, 69, -125, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, -102, -61, -42, -1, 33, RegisterType.UNINIT_REF, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, -62};
        f383263e1 = new byte[]{49, -127, -44, 5, -84, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 54, -124, 61, -78, 30, -46, -102, 0, 26, 31, 55, -8, -125, -7, 99, -60, 60, -89, -38, 120, -34, -68, 80, -76, -44, -11, -27, -30, 59, RegisterType.DOUBLE_LO, -124, 4, -7, -103, RegisterType.DOUBLE_HI, 100, -34, 7, 43, -39, -4, 42, 92, -74, 39, -73, -6, -13, 50, 123, -98, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, 88, -63, Constants.SEND_CHANNEL_LATENCY, -75, -97, 78};
        f383266f1 = new byte[]{32, 70, 52, -103, 11, -106, 46, 51, 5, 81, -39, 48};
        f383269g1 = new byte[]{100, 47, -100, -67, 104, 49, 82, 49, 11, Constants.PACKET_LOSS_EFFECT_STATIS, 4, -99};
        f383272h1 = new int[]{100, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, -57, -104, 23, -92, -16, 74, -69, 118, 63, 114, 40, -100, -9, -26, 92, -66, 70, 45, 65, 40, -73, -101, -35, -105, 82, -14, -54, 32, 50, -110, 126, -63, -24, -105, -22, 36, -89, 85, 46, 67, -120, 47, 83, -50, -44, AVDecodeError.AUDIO_DATA_DECODE_FINISH, -38, -57, 37, 48, -125, 101, 3, 33, -19, AVDecodeError.VIDEO_DECODE_A_ERR, -6, -23, 17, -122, 93, -27, -27, -89, 58, -74, -32, -111, -38, -74, 78, 21, 23, Constants.BINARY_PERF_STATS, -10, 104, -90, -37, -49, 72, 113, AVDecodeError.VIDEO_DECODE_A_ERR, -52, 45, -33, -127, -120, 0, 29, -107, -80, 11, 109, -34, 49, 60, -60, -67, 33, -97, 109, -79, -36, 4, -53, 94, -85, 16, -24, -19, 122, -41, 94, 4, -100, 64, -5, 16, 51, 52, 112, 126, -76, -55, 124, 117, 107, -61, -122, -110, 71, -27, -65, -67, ExportErrorStatus.WRITE_VIDEO_SAMPLE, -97, -96, 48, 51, -49, -2, 119, -62, 78, 91, 71, -55, -15, 20, -67, -35, -9, -7, -74, 14, -12, 12, -96, -104, 45, -125, 45, 71, -66, 66, -92, -103, 73, 27, -18, -63, -17, -51, -86, -59, 105, -29, 36, -60, 94, -57, -32, 101, 73, 22, 112, -67, Constants.BINARY_PERF_STATS, 54, -84, -96, 0, -38, -99, -36, 94, -14, 11, 19, 7, 45, -9, 21, -72, -5, 44, 38, 22, -17, -79, -104, -30, 57, 64, -29, -32, -107, -44, -42, 66, 99, -58, 43, -47, 64, -6, -75, -122, -59, -36, 3, -127, 27, 102, -47, -77, -39, 85, 27, -19, -122, AVDecodeError.JNI_BITMAP_STRIDE_ERR, 42, 34, -72, -42, 58, 29, -76, 29, -53, -14, -10, AVDecodeError.JNI_BITMAP_STRIDE_ERR, -12, 112, 28, 1, -111, 110, -10, 104, 19, -21, 37, -10, -74, -38, -50, -107, -44, 40, 124, -110, 74, 76, -14, -48, 21, 25, -34, 2, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, -88, 99, -40, -20, 9, 17, -112, 31, 9, 113, -10, 29, 23, AVDecodeError.VIDEO_DECODE_A_ERR, -110, 45, -22, -65, -71, Constants.BINARY_PERF_STATS, -79, -110, AVDecodeError.VIDEO_DECODE_A_ERR, -96, -58, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, 102, AVDecodeError.AUDIO_DATA_DECODE_FINISH, -53, 111, 77, 82, -125, -3, 83, 11, -74, 1, 36, -54, 106, -23, -41, -117, 8, 23, -35, 21, 68, -66, 58, -17, -58, 98, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, Constants.BINARY_PERF_STATS, -120, 1, -102, -128, -69, 101, 25, -63, -41, -98, 5, -43, 97, 30, -13, 109, -79, -52, 60, -36, 85, 33, 0, -26, -103, 83, 26, 80, -64, 116, -2, 68, -85, -113, 87, 56, 40, -8, 57, 101, 22, -1, 46, 54, 55, -79, -120, 52, 54, 72, 0, -92, -101, -52, 18, -16, -103, 33, 53, -5, 76, 59, 113, 109, 106, 32, 69, -19, 3, 85, 8, -52, -113, -92, 16, -89, 55, 17, 109, 124, 108, 121, 58, -63, -88, 32, 95, 9, 119, 83, 66, 71, 4, -83, 46, -94, 7, -52, 127, -49, 25, -38, -106, -96, -68, 73, -66, -75, -66, -17, -50, 103, AVDecodeError.AUDIO_DATA_DECODE_FINISH, -5, 8, -9, 85, 52, -16, 34, 113, -68, 44, 116, -28, 40, 87, 39, 116, -44, 59, -33, 80, 120, 78, 43, -69, 6, -77, 111, -96, -83, -38, -69, 5, -70, 41, -112, 4, 83, -92, -83, 70, 126, 66, -54, 7, -8, 68, -62, 19, -90, 27, -32, 78, 73, -51, 112, -110, 20, 91, -55, 90, 70, -65, -128, 67, -105, -127, -90, -90, -79, -49, -37, 120, -10, 87, 36, -103, -59, 113, -54, 113, 102, -99, -54, 82, 25, -101, -40, 87, -19, 116, -18, -80, 59, 80, 117, -10, -50, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, 127, -62, -71, 54, -98, -122, -46, -51, -80, 73, 89, 89, -120, 12, -37, -55, -51, 111, -16, -54, 48, 53, 86, -58, -35, 42, 55, -22, -26, 100, 59, 38, 67, 102, -97, 92, 28, 58, 121, -69, -1, -9, -12, -92, -128, -113, -84, -78, -35, 113, -7, -26, 89, 108, -49, -41, -34, ExportErrorStatus.WRITE_VIDEO_SAMPLE, -60, 23, 86, 115, 17, -17, 17, 7, 110, 37, -71, -99, -87, -22, -36, -47, -86, -95, -36, 81, 16, 96, -64, 90, 57, -25, 120, 7, 95, -107, 91, -18, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, 108, 26, 110, -16, AVDecodeError.JNI_BITMAP_STRIDE_ERR, -50, 40, 9, 83, 106, 119, -89, -62, 22, 82, 54, 10, 5, 114, -107, 4, -35, 77, 82, -112, 92, -104, 106, 39, -7, 36, -42, 79, -17, 20, -93, 19, -29, -79, 46, -85, -82, 31, -94, 108, 50, 40, -14, -101, -105, -9, -46, -17, Constants.BINARY_PERF_STATS, -99, 11, 51, -66, -4, -69, -3, -64, 22, ExportErrorStatus.WRITE_VIDEO_SAMPLE, 59, 10, 45, -4, -91, 117, 72, -49, 69, 103, 100, -111, -83, -122, 90, -90, 24, 85, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, -57, -58, -128, 90, -26, -21, AVDecodeError.AUDIO_DATA_DECODE_FINISH, 125, 101, -51, -112, AVDecodeError.VIDEO_DECODE_V_ERR, 105, 118, 16, 97, -37, -61, 40, 101, 29, -32, 38, -52, -102, -79, 113, -87, 109, -42, -104, 101, AVDecodeError.AUDIO_DATA_DECODE_FINISH, 87, -23, -63, -84, 7, -2, 87, -14, -107, -10, -90, -56, 60, 31, -106, 107, 16, 97, -57, -1, 30, 17, -44, 113, 127, -96, 51, 63, ExportErrorStatus.WRITE_VIDEO_SAMPLE, -72, -70, 12, -6, -1, 61, -42, 78, -102, -37, -39, AVDecodeError.AUDIO_DATA_DECODE_FINISH, -97, 85, -13, -113, -60, -10, -111, 73, 114, -57, -7, 80, 28, -37, -78, -9, -84, -74, -71, -11, -117, 109, -29, 103, -44, 49, 32, 59, 118, -110, 6, 91, 24, -100, 86, -74, -95, 60, 53, -70, Constants.BINARY_PERF_STATS, -43, 64, -105, -106, 39, 78, -92, 68, -59, 10, -98, 118, 105, 68, 96, AVDecodeError.VIDEO_DECODE_A_ERR, -26, -99, -81, 114, -127, 1, 96, 126, 4, AVDecodeError.VIDEO_DECODE_A_ERR, 119, 13, -113, 60, 95, 118, -101, -81, 104, -35, -83, 5, -82, -5, 30, -69, -79, 24, 48, -42, 76, -34, -52, 125, -48, 91, 70, -25, 109, 101, -102, 72, 105, 120, 45, 47, 44, 39, -30, 73, 120, -86, -82, 81, -54, -61, 53, -125, -103, 87, 11, -69, -21, 116, -88, 5, 49, 125, -125, 37, 24, 27, 102, -10, 105, 108, 21, -3, 91, 126, 31, -79, -24, -45, -55, 81, -38, -74, -7, 102, 51, 1, -95, 3, -105, 79, -127, 110, 0, -59, -77, -39, -75, 58, -48, 109, -89, 35, -107, -34, 65, 59, -105, -14, 111, 118, 78, 114, 60, -89, -47, 43, 74, -125, -59, 55, -11, -60, 63, 104, 76, -50, -79, 111, 17, 86, -98, 74, -19, -62, 3, 33, -45, 
        23, 12, -27, -52, 97, 82, 45, 103, -31, 117, 29, 16, -37, 69, 118, 113, -28, -101, 49, 47, -38, 26, 27, 30, 101, -67, -1, -119, 72, -103, 28, 72, -13, -31, -18, 1, -41, -44, 83, -29, 23, -91, 91, 88, -127, -68, -3, -51, 37, -13, AVDecodeError.JNI_BITMAP_STRIDE_ERR, 118, 126, -20, 40, AVDecodeError.VIDEO_DECODE_A_ERR, 42, 115, 114, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, -31, 100, 45, 62, 33, -80, 127, 30, 34, -29, -38, -50, 85, 110, -19, -103, -41, 116, 59, 77, 26, 93, 91, 43, -35, -47, 74, 39, -75, -8, -17, 69, 122, -26, -7, -100, -92, 49, -86, 72, 43, 123, 93, 50, 97, -13, 49, -70, 117, 92, -50, 125, 91, 113, -53, AVDecodeError.JNI_BITMAP_STRIDE_ERR, 71, -21, 61, 50, 90, 115, AVDecodeError.JNI_BITMAP_STRIDE_ERR, 51, 7, -15, 35, 27, 40, 124, 41, 88, -1, 17, -38, -102, 33, -21, 15, 20, 100, 55, 10, -55, -45, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, -40, -101, -18, -1, 85, 89, -67, 81, 76, -25, 90, 5, -93, 56, 84, 16, -7, -74, 106, -74, 89, 117, 27, -63, 62, -22, 48, 3, -101, 125, 91, 36, 8, -81, 73, -122, -62, 74, 76, -36, -100, -61, -47, -1, -28, -6, -18, -15, -65, -23, 17, 82, 41, -68, -76, -74, 57, 14, 90, -38, -93, -78, -8, -105, -75, -117, -93, 14, 120, -102, 26, 109, 114, 114, 12, 2, 116, -104, 51, 89, -1, -91, -40, -84, -60, -107, 48, 36, 18, 80, 99, -83, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, 110, -70, -69, 29, -80, -86, -103, -60, -56, -7, 46, -89, -55, 78, -98, -103, -4, 35, 17, -80, 55, 4, 124, 97, 63, -104, 56, 31, 52, -107, -16, -122, -67, -60, -99, -47, 36, -6, -68, -62, -110, 51, 110, 122, -37, 118, -106, 91, 121, -1, -57, -94, 54, -9, 51, -99, -128, 74, -38, -111, 68, 82, -19, 71, AVDecodeError.AUDIO_DATA_DECODE_FINISH, 52, -77, 98, -43, 81, -95, 123, -83, 46, -52, -93, -99, 47, 28, 19, -93, -40, 53, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, -102, -95, 116, 77, -125, 25, 9, 50, 39, -93, -65, -92, -1, 13, 96, 9, -44, 123, 118, 72, -79, 42, -33, 44, 40, 83, -74, 117, -1, -48, 106, -19, -62, 49, -98, -81, -101, 108, -112, -7, 90, 25, -92, 19, -11, 8, 66, 16, 39, 46, 2, 87, 40, -65, 28, -42, -35, 13, -54, -99, 90, -41, 29, -98, 47, -60, -91, -98, -100, 66, -4, 95, 50, 40, -50, 83, -110, -76, 92, 16, 5, 35, -98, 49, -39, 62, -92, -69, -86, -117, 81, 47, -102, 71, 80, -9, -113, 86, -91, -31, 127, -24, 74, 81, 48, -24, -113, AVDecodeError.JNI_BITMAP_STRIDE_ERR, -98, -45, -52, 61, -67, -111, -112, Constants.BINARY_PERF_STATS, 114, 68, -107, -110, 7, -117, -36, -81, 98, -49, 47, 51, -42, -79, -86, 4, -102, 107, AVDecodeError.AUDIO_DATA_DECODE_FINISH, -30, -44, 11, -44, -31, 111, -25, -20, 88, 100, 40, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, -20, 54, -2, 101, 58, 56, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, -65, 115, 32, -91, 126, -28, 41, 99, -73, -61, 126, 37, 19, 50, -66, 83, 45, -35, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, -83, -31, 15, -8, -125, 1, -77, -82, 77, 124, 18, 105, 40, -103, 9, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, 15, -32, 28, -99, 0, -53, 25, -63, -22, 124, AVDecodeError.VIDEO_DECODE_A_ERR, -86, 93, -32, -113, 34, 5, -35, -30, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, -49, -6, 62, 2, -5, 30, 117, -97, 8, AVDecodeError.VIDEO_DECODE_V_ERR, -79, -23, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, -62, -29, 106, -74, 8, -55, 108, -24, -53, 31, -128, -38, 25, -97, -26, 97, -38, 123, 100, -58, -52, -100, -80, -55, 39, -2, 26, 71, -50, -37, 44, -53, 38, -42, 65, 59, 10, 47, -5, 77, -58, -111, 21, -113, 5, -78, 20, -127, 79, 23};
        f383275i1 = new int[]{78, 117, 127, 99, -76, 111, 76, 48, -36, 34, 41, 100, 12, -13, -127, 7, 79, 38, -96, -107, -70, -38, 80, 94, 83, 109, 14, AVDecodeError.VIDEO_DECODE_A_ERR, -49, -20, 35, -19, -93, 120, -84, 112, -23, -32, 45, -69, 82, -58, -52, 27, -65, 23, 123, -67, -65, 122, 124, 68, -95, 51, 30, -75, -68, 68, 13, -19, -52, 5, 97, 18, 18, -72, -40, -80, 72, 19, -117, -27, -110, 79, 66, -89, 114, 106, -23, 125, -68, -99, 6, -49, AVDecodeError.VIDEO_DECODE_A_ERR, -35, -73, -68, -100, 95, 100, 115, -95, -71, 33, -16, -73, 20, -41, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, -95, Constants.BINARY_PERF_STATS, -16, -57, 78, -103, 21, Constants.BINARY_PERF_STATS, -57, Constants.BINARY_PERF_STATS, 59, 84, -5, AVDecodeError.JNI_BITMAP_STRIDE_ERR, 68, 1, 87, 20, -74, 11, -24, -20, -49, 82, -81, 30, -89, 112, 108, 103, -41, -120, 123, -31, 92, 48, 116, 119, -11, -106, 125, -14, 124, 4, 27, 71, 115, 122, -10, -44, 112, -13, -96, 52, -86, 6, -2, -50, -30, -39, 36, -92, -55, -11, 76, 25, 36, 60, 79, 18, 100, 83, 58, 45, -95, 120, 3, 122, -71, -69, 13, -97, -22, 9, -23, -122, 122, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, 74, 81, 3, 2, 127, -19, 10, 88, -27, 91, -45, 111, 9, -92, -66, 24, -71, 102, -56, -62, 73, -106, -83, -76, -26, 79, -61, -46, 70, -98, 51, -26, -32, -88, -80, -90, -1, -67, -70, -30, 78, -12, 59, -53, 31, 4, 97, 16, -4, Constants.BINARY_PERF_STATS, -78, -9, 123, 13, 6, -101, 39, 93, 104, -100, 72, -67, -51, 83, -22, 1, 10, 125, 78, 100, 120, 113, 77, 7, -113, 66, -58, -127, -40, 55, -112, -12, 102, -29, -54, 56, 12, 30, 74, 19, -29, -110, -106, -103, -72, -89, 125, 55, 73, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, 7, 104, -71, -9, -101, -74, 94, 34, 52, AVDecodeError.VIDEO_DECODE_V_ERR, 85, -105, -72, 113, -94, -2, 114, 3, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, -30, -66, -107, AVDecodeError.VIDEO_DECODE_A_ERR, 0, -10, -8, -21, 71, 45, -33, 80, -100, -20, 46, -68, -51};
        f383278j1 = new int[]{20, -40, 59, -94, -79, 53, -105, 53, -57, 71, -45, 79, 51, -83, 127, 100, -90, 125, -99, 106, 32, -41, 61, AVDecodeError.JNI_BITMAP_STRIDE_ERR, 79, -34, 75, 87, -111, -30, 58, -26, -100, -54, 48, 41, 88, 33, 126, 122, 42, -51, -58, -102, 50, 25, 32, -21, 123, -16, -95, -128, 33, -74, 2, 88, 22, -75, -127, AVDecodeError.JNI_BITMAP_STRIDE_ERR, -99, -77, 116, 126, 10, -57, 66, 58, 23, -94, 32, -92, -30, 86, 97, 68, -78, -87, 58, -1, -101, 69, 45, -125, -78, 30, -23, 101, 34, -46, -18, -53, 26, 8, -77, 88, 85, 75, 10, -106, 73, 5, -49, 5, 66, -11, -71, -120, -57, -20, -19, -21, 51, 51, 90, 80, 43, 2, 19, AVDecodeError.AUDIO_DATA_DECODE_FINISH, -54, -10, -7, 84, -96, -93, 72, 36, -99, -2, 37, 31, ExportErrorStatus.WRITE_VIDEO_SAMPLE, -69, 2, 17, -64, 85, -50, 113, -48, 74, AVDecodeError.VIDEO_DECODE_A_ERR, -4};
        f383281k1 = new int[]{-11, -65, -92, -65, -2, -112, 6, -21, 98, 112, 89, -84, -37, -112, -64, -35, 115, -87, -89, 111, -21, -8, 90, -113, -52, -38, -7, -87, 89, AVDecodeError.VIDEO_DECODE_V_ERR, 17, AVDecodeError.VIDEO_DECODE_V_ERR, -68, -9, 127, -10, 33, -77, 109, -44, -68, 29, -49, 17, -86, 66, -50, 111, 68, 62, 45, -111, -27, -74, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, 55, 90, -52, -112, 48, -85, -26, 31, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, 16, 107, 89, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, 79, 103, -38, 122, 60, 63, -60, 70, 98, -34, -65, -111, -106, -88, 95, 46, AVDecodeError.AUDIO_DATA_DECODE_FINISH, 86, 96, -12, -67, -19, 72, 48, 50, 99, 2, -63, 12, 111, -25, 76, 87, -40, -113, -12, 120, 95, -93, 6, 122, -44, 48, -17, -117, -41, -40, 21, 51, 22, -8, -79, 29, -3, 86, 9, -90, -20, -99, -92, -104, 65, -41, -53, 27, 118, 78, -48, -11, -23, -37, 109, -106, -88, 1, 102, 124, 30, -103, 105, -33, -61, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR, 57, 13, 121, -54, -69, -82, 95, -52, -11, -46, 91, -125, 57, 28, 49, 115, 110, -78, 114, -112, -64, -50, 79, 3, -104, 84, -32, ExportErrorStatus.END_WRITE_AUDIO_SAMPLE, -14, 7, 70, -70, 110, -73, 50, 50, 105, -19, 31, -122, 9, 71, -81, -92, 70, -71, 0, -24, ExportErrorStatus.WRITE_VIDEO_SAMPLE, 62, 69, -18, 75, 30, 3, 28, 55, -50, 41, 51, -79, 104, -110, 32, -61, -72, 49, 19, 33, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, 100, -98, 72, -13, 82, 53, -76, -41, 10, -57, 71, -85, 36, 57, 3, 78, 106, -45, -98, 111, 84, -15, 22, -95, 19, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, -3, -84, -80, -16, -122, 17, 76, 46, 37, 5, -88, -39, 53, 121, 15, 87, 25, -38, CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE, 113, 98, 21, 12, -61, -59, -37, 81, -107, 51, -96, -54, -58, 63, 54, 51, -53, -66, -70, 127, -98, -122, -29, -117, ExportErrorStatus.END_WRITE_VIDEO_SAMPLE, 52, 123, -4, -6, -56, 95, 92, ExportErrorStatus.WRITE_VIDEO_SAMPLE, -2, -111, 4, -11, 11, 94, 33, 121, 49, -72, 98, 99, -23, 103, -35, -81, 53, 13, -82, 17, -85, -49, -122, -54, 123, 63, 28, 111, -1, 22, -113, 58, 29, -22, -111, 87, 60, 0, -47, -30, 59, -93, -40, 11, 85, 44, 99, -97, -96, 42, 95, -50, 83, -51, -22, -8, 88, -80, 76, 29, -111, 22, Constants.BINARY_PERF_STATS, -99, 63, 1, -85, 108, 123};
        f383287m1 = new byte[]{IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, 105, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, 103, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH};
    }

    public static String a(int[] iArr) {
        if (f383284l1 == null) {
            try {
                byte[] bArr = f383287m1;
                int i3 = Papaya.f382982a;
                f383284l1 = Vulpecula.a(bArr).getBytes();
            } catch (Exception unused) {
                f383284l1 = new byte[0];
            }
        }
        byte[] bArr2 = new byte[iArr.length];
        for (int i16 = 0; i16 < iArr.length; i16++) {
            bArr2[i16] = (byte) iArr[i16];
        }
        return Plum.a(Cdefault.a(bArr2, f383284l1), null);
    }

    public static String a(byte[] bArr) {
        if (f383284l1 == null) {
            try {
                byte[] bArr2 = f383287m1;
                int i3 = Papaya.f382982a;
                f383284l1 = Vulpecula.a(bArr2).getBytes();
            } catch (Exception unused) {
                f383284l1 = new byte[0];
            }
        }
        return Plum.a(Cdefault.a(bArr, f383284l1), null);
    }
}
