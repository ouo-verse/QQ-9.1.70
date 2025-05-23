package com.tencent.mobileqq.statistics;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f290001a;

    /* renamed from: b, reason: collision with root package name */
    static boolean f290002b;

    /* renamed from: c, reason: collision with root package name */
    static String f290003c;

    /* renamed from: d, reason: collision with root package name */
    static int f290004d;

    /* renamed from: e, reason: collision with root package name */
    public static int f290005e;

    /* renamed from: f, reason: collision with root package name */
    public static int f290006f;

    /* renamed from: g, reason: collision with root package name */
    public static int f290007g;

    /* renamed from: h, reason: collision with root package name */
    private static long f290008h;

    /* renamed from: i, reason: collision with root package name */
    private static String f290009i;

    /* renamed from: j, reason: collision with root package name */
    private static long f290010j;

    /* renamed from: k, reason: collision with root package name */
    private static String f290011k;

    /* renamed from: l, reason: collision with root package name */
    private static long f290012l;

    /* renamed from: m, reason: collision with root package name */
    private static String f290013m;

    /* renamed from: n, reason: collision with root package name */
    private static long f290014n;

    /* renamed from: o, reason: collision with root package name */
    private static String f290015o;

    /* renamed from: p, reason: collision with root package name */
    private static int f290016p;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75422);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f290001a = "MultiVideoRichActionReportCollection";
        f290002b = false;
        f290003c = "";
        f290004d = 0;
        f290005e = 1;
        f290006f = 2;
        f290007g = 3;
        f290008h = 0L;
        f290009i = "";
        f290010j = 0L;
        f290011k = "";
        f290012l = 0L;
        f290013m = "";
        f290014n = 0L;
        f290015o = "";
        f290016p = 0;
    }

    public static void a(String str) {
        int i3 = f290016p;
        if (i3 == f290006f) {
            e("0X8007F35", str);
        } else if (i3 == f290007g) {
            e("0X8007F3B", str);
        }
        f290013m = str;
        f290012l = System.currentTimeMillis();
    }

    public static void b(String str) {
        int i3 = f290016p;
        if (i3 == f290006f) {
            e("0X8007E6A", str);
        } else if (i3 == f290007g) {
            e("0X8007E66", str);
        }
        f290015o = str;
        f290014n = System.currentTimeMillis();
    }

    public static void c(VideoAppInterface videoAppInterface) {
        int i3;
        if (videoAppInterface != null) {
            i3 = videoAppInterface.z("BEAUTY_SKIN");
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            a(i3 + "");
        }
        int i16 = f290016p;
        if (i16 == f290006f) {
            if (f290008h == 0) {
                d("0X8007F32");
            }
            if (f290010j == 0) {
                d("0X8007F34");
            }
            if (f290012l == 0) {
                d("0X8007F36");
            }
            if (f290014n == 0) {
                d("0X8007E69");
                return;
            }
            return;
        }
        if (i16 == f290007g) {
            if (f290008h == 0) {
                d("0X8007F38");
            }
            if (f290010j == 0) {
                d("0X8007F3A");
            }
            if (f290012l == 0) {
                d("0X8007F3C");
            }
            if (f290014n == 0) {
                d("0X8007E65");
            }
        }
    }

    public static void d(String str) {
        AVCoreLog.printDebugLog(f290001a, String.format("reportClickEvent key = %s, type = %s, roomid = %s", str, "", f290003c));
        ReportController.o(null, "dc00898", "", "", str, str, 0, 0, "", "", f290003c, "");
    }

    public static void e(String str, String str2) {
        AVCoreLog.printDebugLog(f290001a, String.format("reportClickEvent id = %s, type = %s, roomid = %s", str, str2, f290003c));
        ReportController.o(null, "dc00898", "", "", str, str, 0, 0, "", "", f290003c, str2);
    }

    public static void f(int i3, String str) {
        AVCoreLog.printDebugLog(f290001a, String.format("onConnected sessionType = %s, roomid = %s", Integer.valueOf(i3), str));
        f290002b = true;
        f290004d = i3;
        f290003c = str;
        if (i3 != 4 && i3 != 3) {
            if (i3 == 2 || i3 == 1) {
                f290016p = f290006f;
                return;
            }
            return;
        }
        f290016p = f290007g;
    }
}
