package com.tencent.mobileqq.qcircle.api.global;

import com.tencent.biz.richframework.delegate.impl.RFWLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f261660a = false;

    /* renamed from: b, reason: collision with root package name */
    public static float f261661b = -1.0f;

    /* renamed from: c, reason: collision with root package name */
    public static long f261662c = -1;

    /* renamed from: d, reason: collision with root package name */
    public static long f261663d = -1;

    /* renamed from: e, reason: collision with root package name */
    public static long f261664e;

    /* renamed from: f, reason: collision with root package name */
    public static long f261665f;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f261666g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f261667h;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f261668i;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f261669j;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f261670k;

    public static void a() {
        f261663d = System.currentTimeMillis();
        RFWLog.d("QCircleFolderStatus", RFWLog.USR, "onProcessForeground :" + f261663d);
    }

    public static void b() {
        RFWLog.d("QCircleFolderStatus", RFWLog.USR, "resetExpFlag");
        f261669j = false;
        f261670k = false;
        f261664e = -1L;
        f261665f = -1L;
        f261666g = false;
        f261660a = false;
        f261667h = false;
        f261661b = -1.0f;
        f261668i = false;
    }

    public static void c() {
        RFWLog.d("QCircleFolderStatus", RFWLog.USR, "resetFolderLaunchTime");
        f261664e = System.currentTimeMillis();
    }

    public static void d() {
        f261662c = System.currentTimeMillis();
        RFWLog.d("QCircleFolderStatus", RFWLog.USR, "resetSplashActivityStartTime :" + f261662c);
        a();
    }

    public static void e(float f16) {
        RFWLog.d("QCircleFolderStatus", RFWLog.USR, "setFastPlayCanPlayCacheTime time:" + f16);
        f261661b = f16;
    }

    public static void f(long j3) {
        RFWLog.d("QCircleFolderStatus", RFWLog.USR, "setFastPlayCost :" + j3);
        f261665f = j3;
    }

    public static void g(boolean z16, boolean z17, boolean z18) {
        RFWLog.d("QCircleFolderStatus", RFWLog.USR, "setFastPlayCostPlayerInfo hitCache:" + z16 + ",hitPreRender:" + z17 + ",firstFramePreRenderSucceed:" + z18);
        f261667h = z17;
        f261666g = z16;
        f261660a = z18;
    }

    public static void h(boolean z16) {
        RFWLog.d("QCircleFolderStatus", RFWLog.USR, "setFastPlayTimeout :" + z16);
        f261668i = z16;
    }

    public static void i(boolean z16) {
        RFWLog.d("QCircleFolderStatus", RFWLog.USR, "setHitClickPreloadFlag :" + z16);
        f261669j = z16;
    }
}
