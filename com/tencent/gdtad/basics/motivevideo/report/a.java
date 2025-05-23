package com.tencent.gdtad.basics.motivevideo.report;

import android.content.Context;
import com.tencent.ad.tangram.statistics.metric.AdMetricService;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ad.tangram.statistics.metric.IAdMetric;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveHippyParams;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    public static IAdMetric a(GdtMotiveVideoPageData gdtMotiveVideoPageData, GdtAd gdtAd, long j3) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        GdtMotiveHippyParams gdtMotiveHippyParams;
        IAdMetric build = AdMetricService.getInstance().build(j3);
        String str7 = null;
        if (gdtMotiveVideoPageData != null && (gdtMotiveHippyParams = gdtMotiveVideoPageData.hippyParams) != null) {
            str = gdtMotiveHippyParams.getCurrentJsBundleVersion();
        } else {
            str = null;
        }
        IAdMetric tagSet = build.setTagSet(AdMetricTag.JS_BUNDLE_VERSION, str).setTagSet("orientation", d(gdtMotiveVideoPageData));
        if (gdtAd != null) {
            str2 = gdtAd.getPosId();
        } else {
            str2 = null;
        }
        IAdMetric tagSet2 = tagSet.setTagSet("posId", str2);
        if (gdtAd != null) {
            str3 = gdtAd.getRewardTemplateId();
        } else {
            str3 = null;
        }
        IAdMetric tagSet3 = tagSet2.setTagSet("templateId", str3);
        if (gdtMotiveVideoPageData != null) {
            str4 = String.valueOf(gdtMotiveVideoPageData.containerType);
        } else {
            str4 = null;
        }
        IAdMetric tagSet4 = tagSet3.setTagSet(AdMetricTag.Reward.CONTAINER_TYPE, str4);
        if (gdtAd != null) {
            str5 = String.valueOf(gdtAd.getRewardPlayType());
        } else {
            str5 = null;
        }
        IAdMetric tagSet5 = tagSet4.setTagSet(AdMetricTag.Reward.PLAY_TYPE, str5);
        if (gdtAd != null) {
            str6 = String.valueOf(gdtAd.getRenderType());
        } else {
            str6 = null;
        }
        IAdMetric tagSet6 = tagSet5.setTagSet(AdMetricTag.Reward.RENDER_TYPE, str6);
        if (gdtMotiveVideoPageData != null) {
            str7 = String.valueOf(gdtMotiveVideoPageData.getType());
        }
        return tagSet6.setTagSet(AdMetricTag.Reward.STYLE, str7);
    }

    public static void b() {
        AdMetricService.getInstance().flush(new WeakReference<>(BaseApplication.getContext()));
    }

    private static String c(String str, GdtAd gdtAd, boolean z16) {
        if (!z16) {
            str = str + " error,";
        }
        if (gdtAd == null) {
            return str;
        }
        return str + " aid:" + gdtAd.getAId() + " traceId:" + gdtAd.getTraceId();
    }

    private static String d(GdtMotiveVideoPageData gdtMotiveVideoPageData) {
        if (gdtMotiveVideoPageData == null) {
            return null;
        }
        int i3 = gdtMotiveVideoPageData.screenOrientation;
        if (i3 == 1) {
            return "portrait";
        }
        if (i3 == 0) {
            return "landscape";
        }
        return "unknown";
    }

    public static void e(String str, String str2, Throwable th5, boolean z16, long j3, long j16, GdtMotiveVideoModel gdtMotiveVideoModel, Integer num) {
        if (z16) {
            m(str, str2, j3, gdtMotiveVideoModel);
        } else {
            j(str, str2, th5, j16, gdtMotiveVideoModel, num);
        }
    }

    public static void f(String str, String str2, Throwable th5, boolean z16, long j3, long j16, GdtMotiveVideoPageData gdtMotiveVideoPageData, Integer num) {
        if (z16) {
            p(str, str2, j3, gdtMotiveVideoPageData);
        } else {
            k(str, str2, th5, j16, gdtMotiveVideoPageData, num);
        }
    }

    public static void g(String str, String str2, Throwable th5, long j3, long j16, GdtMotiveVideoModel gdtMotiveVideoModel, long j17, int i3, int i16, int i17) {
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        GdtAd gdtAd = null;
        if (gdtMotiveVideoModel != null) {
            gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
        } else {
            gdtMotiveVideoPageData = null;
        }
        if (gdtMotiveVideoModel != null) {
            gdtAd = gdtMotiveVideoModel.getGdtAd();
        }
        QLog.e(str, 1, c(str2, gdtAd, false), th5);
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtMotiveVideoPageData, gdtAd, j3).setTagSet(AdMetricTag.SuperPlayer.ERROR_MODEL, String.valueOf(i3)).setTagSet(AdMetricTag.SuperPlayer.ERROR_TYPE, String.valueOf(i16)).setTagSet(AdMetricTag.SuperPlayer.ERROR_CODE, String.valueOf(i17)));
        if (j17 >= 0) {
            AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtMotiveVideoPageData, gdtAd, j16).setValue(j17).setTagSet(AdMetricTag.SuperPlayer.ERROR_MODEL, String.valueOf(i3)).setTagSet(AdMetricTag.SuperPlayer.ERROR_TYPE, String.valueOf(i16)).setTagSet(AdMetricTag.SuperPlayer.ERROR_CODE, String.valueOf(i17)));
        }
    }

    public static void h(String str, String str2, Throwable th5, long j3, long j16, GdtMotiveVideoModel gdtMotiveVideoModel, long j17, Integer num) {
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        GdtAd gdtAd;
        String str3;
        String str4 = null;
        if (gdtMotiveVideoModel != null) {
            gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
        } else {
            gdtMotiveVideoPageData = null;
        }
        if (gdtMotiveVideoModel != null) {
            gdtAd = gdtMotiveVideoModel.getGdtAd();
        } else {
            gdtAd = null;
        }
        QLog.e(str, 1, c(str2, gdtAd, false), th5);
        AdMetricService adMetricService = AdMetricService.getInstance();
        WeakReference<Context> weakReference = new WeakReference<>(BaseApplication.getContext());
        IAdMetric a16 = a(gdtMotiveVideoPageData, gdtAd, j3);
        if (num != null) {
            str3 = String.valueOf(num);
        } else {
            str3 = null;
        }
        adMetricService.handle(weakReference, a16.setTagSet(AdMetricTag.ERROR_CODE, str3));
        if (j17 >= 0) {
            AdMetricService adMetricService2 = AdMetricService.getInstance();
            WeakReference<Context> weakReference2 = new WeakReference<>(BaseApplication.getContext());
            IAdMetric value = a(gdtMotiveVideoPageData, gdtAd, j16).setValue(j17);
            if (num != null) {
                str4 = String.valueOf(num);
            }
            adMetricService2.handle(weakReference2, value.setTagSet(AdMetricTag.ERROR_CODE, str4));
        }
    }

    public static void i(String str, String str2, Throwable th5, long j3, long j16, GdtMotiveVideoModel gdtMotiveVideoModel, long j17, Integer num, String str3, Integer num2) {
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        GdtAd gdtAd;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (gdtMotiveVideoModel != null) {
            gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
        } else {
            gdtMotiveVideoPageData = null;
        }
        if (gdtMotiveVideoModel != null) {
            gdtAd = gdtMotiveVideoModel.getGdtAd();
        } else {
            gdtAd = null;
        }
        QLog.e(str, 1, c(str2, gdtAd, false), th5);
        AdMetricService adMetricService = AdMetricService.getInstance();
        WeakReference<Context> weakReference = new WeakReference<>(BaseApplication.getContext());
        IAdMetric a16 = a(gdtMotiveVideoPageData, gdtAd, j3);
        if (num != null) {
            str4 = String.valueOf(num);
        } else {
            str4 = null;
        }
        IAdMetric tagSet = a16.setTagSet(AdMetricTag.ERROR_CODE, str4);
        if (num2 != null) {
            str5 = String.valueOf(num2);
        } else {
            str5 = null;
        }
        adMetricService.handle(weakReference, tagSet.setTagSet(str3, str5));
        if (j17 >= 0) {
            AdMetricService adMetricService2 = AdMetricService.getInstance();
            WeakReference<Context> weakReference2 = new WeakReference<>(BaseApplication.getContext());
            IAdMetric value = a(gdtMotiveVideoPageData, gdtAd, j16).setValue(j17);
            if (num != null) {
                str6 = String.valueOf(num);
            } else {
                str6 = null;
            }
            IAdMetric tagSet2 = value.setTagSet(AdMetricTag.ERROR_CODE, str6);
            if (num2 != null) {
                str7 = String.valueOf(num2);
            }
            adMetricService2.handle(weakReference2, tagSet2.setTagSet(str3, str7));
        }
    }

    public static void j(String str, String str2, Throwable th5, long j3, GdtMotiveVideoModel gdtMotiveVideoModel, Integer num) {
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        GdtAd gdtAd;
        String str3 = null;
        if (gdtMotiveVideoModel != null) {
            gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
        } else {
            gdtMotiveVideoPageData = null;
        }
        if (gdtMotiveVideoModel != null) {
            gdtAd = gdtMotiveVideoModel.getGdtAd();
        } else {
            gdtAd = null;
        }
        QLog.e(str, 1, c(str2, gdtAd, false), th5);
        AdMetricService adMetricService = AdMetricService.getInstance();
        WeakReference<Context> weakReference = new WeakReference<>(BaseApplication.getContext());
        IAdMetric a16 = a(gdtMotiveVideoPageData, gdtAd, j3);
        if (num != null) {
            str3 = String.valueOf(num);
        }
        adMetricService.handle(weakReference, a16.setTagSet(AdMetricTag.ERROR_CODE, str3));
    }

    public static void k(String str, String str2, Throwable th5, long j3, GdtMotiveVideoPageData gdtMotiveVideoPageData, Integer num) {
        String str3;
        GdtAd parseGdtAdFromString = GdtUtil.parseGdtAdFromString(gdtMotiveVideoPageData);
        QLog.e(str, 1, c(str2, parseGdtAdFromString, false), th5);
        AdMetricService adMetricService = AdMetricService.getInstance();
        WeakReference<Context> weakReference = new WeakReference<>(BaseApplication.getContext());
        IAdMetric a16 = a(gdtMotiveVideoPageData, parseGdtAdFromString, j3);
        if (num != null) {
            str3 = String.valueOf(num);
        } else {
            str3 = null;
        }
        adMetricService.handle(weakReference, a16.setTagSet(AdMetricTag.ERROR_CODE, str3));
    }

    public static void l(String str, String str2, long j3, long j16, GdtMotiveVideoModel gdtMotiveVideoModel, long j17) {
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        GdtAd gdtAd = null;
        if (gdtMotiveVideoModel != null) {
            gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
        } else {
            gdtMotiveVideoPageData = null;
        }
        if (gdtMotiveVideoModel != null) {
            gdtAd = gdtMotiveVideoModel.getGdtAd();
        }
        QLog.i(str, 1, c(str2, gdtAd, true));
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtMotiveVideoPageData, gdtAd, j3));
        if (j17 >= 0) {
            AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtMotiveVideoPageData, gdtAd, j16).setValue(j17));
        }
    }

    public static void m(String str, String str2, long j3, GdtMotiveVideoModel gdtMotiveVideoModel) {
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        GdtAd gdtAd = null;
        if (gdtMotiveVideoModel != null) {
            gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
        } else {
            gdtMotiveVideoPageData = null;
        }
        if (gdtMotiveVideoModel != null) {
            gdtAd = gdtMotiveVideoModel.getGdtAd();
        }
        QLog.i(str, 1, c(str2, gdtAd, true));
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtMotiveVideoPageData, gdtAd, j3));
    }

    public static void n(String str, String str2, long j3, GdtMotiveVideoModel gdtMotiveVideoModel, Integer num) {
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        GdtAd gdtAd;
        String str3 = null;
        if (gdtMotiveVideoModel != null) {
            gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
        } else {
            gdtMotiveVideoPageData = null;
        }
        if (gdtMotiveVideoModel != null) {
            gdtAd = gdtMotiveVideoModel.getGdtAd();
        } else {
            gdtAd = null;
        }
        QLog.i(str, 1, c(str2, gdtAd, true));
        AdMetricService adMetricService = AdMetricService.getInstance();
        WeakReference<Context> weakReference = new WeakReference<>(BaseApplication.getContext());
        IAdMetric a16 = a(gdtMotiveVideoPageData, gdtAd, j3);
        if (num != null) {
            str3 = String.valueOf(num);
        }
        adMetricService.handle(weakReference, a16.setTagSet(AdMetricTag.ERROR_CODE, str3));
    }

    public static void o(String str, String str2, long j3, GdtMotiveVideoModel gdtMotiveVideoModel, String str3, String str4) {
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        GdtAd gdtAd = null;
        if (gdtMotiveVideoModel != null) {
            gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
        } else {
            gdtMotiveVideoPageData = null;
        }
        if (gdtMotiveVideoModel != null) {
            gdtAd = gdtMotiveVideoModel.getGdtAd();
        }
        QLog.i(str, 1, c(str2, gdtAd, true));
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtMotiveVideoPageData, gdtAd, j3).setTagSet(str3, str4));
    }

    public static void p(String str, String str2, long j3, GdtMotiveVideoPageData gdtMotiveVideoPageData) {
        GdtAd parseGdtAdFromString = GdtUtil.parseGdtAdFromString(gdtMotiveVideoPageData);
        QLog.i(str, 1, c(str2, parseGdtAdFromString, true));
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtMotiveVideoPageData, parseGdtAdFromString, j3));
    }

    public static void q(String str, String str2, long j3, GdtMotiveVideoPageData gdtMotiveVideoPageData, int i3) {
        GdtAd parseGdtAdFromString = GdtUtil.parseGdtAdFromString(gdtMotiveVideoPageData);
        QLog.i(str, 1, c(str2, parseGdtAdFromString, true));
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), a(gdtMotiveVideoPageData, parseGdtAdFromString, j3).setTagSet(AdMetricTag.Reward.CONTAINER_DETAIL_TYPE, String.valueOf(i3)));
    }
}
