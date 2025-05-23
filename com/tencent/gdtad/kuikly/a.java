package com.tencent.gdtad.kuikly;

import com.tencent.ad.tangram.statistics.metric.AdMetricService;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ad.tangram.statistics.metric.IAdMetric;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    private static IAdMetric a(GdtAd gdtAd, String str, String str2, long j3) {
        String str3;
        if (gdtAd != null) {
            str3 = gdtAd.getPosId();
        } else {
            str3 = null;
        }
        return AdMetricService.getInstance().build(j3).setTagSet("posId", str3).setTagSet(AdMetricTag.Kuikly.BUNDLE_NAME, str).setTagSet(AdMetricTag.Kuikly.PAGE_NAME, str2);
    }

    private static String b(String str, GdtAd gdtAd, String str2, String str3) {
        if (gdtAd == null) {
            return str;
        }
        return str + " aid:" + gdtAd.getAId() + " traceId:" + gdtAd.getTraceId() + " bundleName:" + str2 + " pageName:" + str3;
    }

    public static void c(String str, String str2, Throwable th5, long j3, long j16, GdtAd gdtAd, String str3, String str4, long j17, int i3) {
        QLog.e(str, 1, b(str2, gdtAd, str3, str4), th5);
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtAd, str3, str4, j3).setTagSet(AdMetricTag.ERROR_CODE, String.valueOf(i3)));
        if (j17 >= 0) {
            AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtAd, str3, str4, j16).setValue(j17).setTagSet(AdMetricTag.ERROR_CODE, String.valueOf(i3)));
        }
    }

    public static void d(String str, String str2, Throwable th5, long j3, long j16, GdtAd gdtAd, String str3, String str4, long j17, int i3, String str5, Integer num) {
        String str6;
        QLog.e(str, 1, b(str2, gdtAd, str3, str4), th5);
        if (num != null) {
            str6 = String.valueOf(num);
        } else {
            str6 = null;
        }
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtAd, str3, str4, j3).setTagSet(AdMetricTag.ERROR_CODE, String.valueOf(i3)).setTagSet(str5, str6));
        if (j17 >= 0) {
            AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtAd, str3, str4, j16).setValue(j17).setTagSet(AdMetricTag.ERROR_CODE, String.valueOf(i3)).setTagSet(str5, str6));
        }
    }

    public static void e(String str, String str2, Throwable th5, long j3, long j16, String str3, String str4, long j17, int i3, String str5, Integer num) {
        String str6;
        QLog.e(str, 1, str2 + " posId:" + str3 + " bundleName:" + str4, th5);
        if (num != null) {
            str6 = String.valueOf(num);
        } else {
            str6 = null;
        }
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), AdMetricService.getInstance().build(j3).setTagSet("posId", str3).setTagSet(AdMetricTag.Kuikly.BUNDLE_NAME, str4).setTagSet(AdMetricTag.ERROR_CODE, String.valueOf(i3)).setTagSet(str5, str6));
        if (j17 >= 0) {
            AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), AdMetricService.getInstance().build(j16).setValue(j17).setTagSet("posId", str3).setTagSet(AdMetricTag.Kuikly.BUNDLE_NAME, str4).setTagSet(AdMetricTag.ERROR_CODE, String.valueOf(i3)).setTagSet(str5, str6));
        }
    }

    public static void f(String str, String str2, Throwable th5, long j3, GdtAd gdtAd, String str3, String str4, int i3) {
        QLog.e(str, 1, b(str2, gdtAd, str3, str4), th5);
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtAd, str3, str4, j3).setTagSet(AdMetricTag.ERROR_CODE, String.valueOf(i3)));
    }

    public static void g(String str, String str2, Throwable th5, long j3, GdtAd gdtAd, String str3, String str4, String str5, int i3) {
        QLog.e(str, 1, b(str2, gdtAd, str3, str4), th5);
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtAd, str3, str4, j3).setTagSet(AdMetricTag.EVENT_NAME, str5).setTagSet(AdMetricTag.ERROR_CODE, String.valueOf(i3)));
    }

    public static void h(String str, String str2, long j3, long j16, GdtAd gdtAd, String str3, String str4, long j17) {
        QLog.i(str, 1, b(str2, gdtAd, str3, str4));
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtAd, str3, str4, j3));
        if (j17 >= 0) {
            AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtAd, str3, str4, j16).setValue(j17));
        }
    }

    public static void i(String str, String str2, long j3, long j16, GdtAd gdtAd, String str3, String str4, long j17, int i3) {
        QLog.i(str, 1, b(str2, gdtAd, str3, str4));
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtAd, str3, str4, j3).setTagSet(AdMetricTag.ERROR_CODE, String.valueOf(i3)));
        if (j17 >= 0) {
            AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtAd, str3, str4, j16).setValue(j17).setTagSet(AdMetricTag.ERROR_CODE, String.valueOf(i3)));
        }
    }

    public static void j(String str, String str2, long j3, long j16, String str3, String str4, long j17) {
        QLog.i(str, 1, str2 + " posId:" + str3 + " bundleName:" + str4);
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), AdMetricService.getInstance().build(j3).setTagSet("posId", str3).setTagSet(AdMetricTag.Kuikly.BUNDLE_NAME, str4));
        if (j17 >= 0) {
            AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), AdMetricService.getInstance().build(j16).setValue(j17).setTagSet("posId", str3).setTagSet(AdMetricTag.Kuikly.BUNDLE_NAME, str4));
        }
    }

    public static void k(String str, String str2, long j3, GdtAd gdtAd, String str3, String str4) {
        QLog.i(str, 1, b(str2, gdtAd, str3, str4));
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtAd, str3, str4, j3));
    }

    public static void l(String str, String str2, long j3, GdtAd gdtAd, String str3, String str4, String str5) {
        QLog.i(str, 1, b(str2, gdtAd, str3, str4));
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtAd, str3, str4, j3).setTagSet(AdMetricTag.EVENT_NAME, str5));
    }

    public static void m(String str, String str2, long j3, String str3, String str4) {
        QLog.i(str, 1, str2 + " posId:" + str3 + " bundleName:" + str4);
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), AdMetricService.getInstance().build(j3).setTagSet("posId", str3).setTagSet(AdMetricTag.Kuikly.BUNDLE_NAME, str4));
    }
}
