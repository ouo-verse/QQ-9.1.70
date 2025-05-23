package com.tencent.gdtad.statistics.metric;

import com.tencent.ad.tangram.statistics.metric.AdMetricService;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ad.tangram.statistics.metric.IAdMetric;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class d {
    private static IAdMetric a(GdtAd gdtAd, long j3) {
        String str;
        if (gdtAd != null) {
            str = gdtAd.getPosId();
        } else {
            str = null;
        }
        return AdMetricService.getInstance().build(j3).setTagSet("posId", str);
    }

    private static String b(String str, GdtAd gdtAd) {
        if (gdtAd == null) {
            return str;
        }
        return str + " aid:" + gdtAd.getAId() + " traceId:" + gdtAd.getTraceId();
    }

    public static void c(String str, String str2, Throwable th5, long j3, long j16, GdtAd gdtAd, long j17, int i3) {
        QLog.e(str, 1, b(str2, gdtAd), th5);
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtAd, j3).setTagSet(AdMetricTag.ERROR_CODE, String.valueOf(i3)));
        if (j17 >= 0) {
            AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtAd, j16).setValue(j17).setTagSet(AdMetricTag.ERROR_CODE, String.valueOf(i3)));
        }
    }

    public static void d(String str, String str2, Throwable th5, long j3, GdtAd gdtAd, int i3) {
        QLog.e(str, 1, b(str2, gdtAd), th5);
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtAd, j3).setTagSet(AdMetricTag.ERROR_CODE, String.valueOf(i3)));
    }

    public static void e(String str, String str2, long j3, long j16, GdtAd gdtAd, long j17) {
        QLog.i(str, 1, b(str2, gdtAd));
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtAd, j3));
        if (j17 >= 0) {
            AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtAd, j16).setValue(j17));
        }
    }
}
