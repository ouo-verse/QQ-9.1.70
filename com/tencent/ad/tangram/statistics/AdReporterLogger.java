package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.protocol.click;
import com.tencent.ad.tangram.statistics.metric.AdMetricService;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ad.tangram.statistics.metric.IAdMetric;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.lang.ref.WeakReference;
import java.net.SocketTimeoutException;

/* compiled from: P */
/* loaded from: classes3.dex */
final class AdReporterLogger {
    AdReporterLogger() {
    }

    private static IAdMetric build(Ad ad5, long j3, int i3) {
        String str;
        IAdMetric build = AdMetricService.getInstance().build(j3);
        if (ad5 != null) {
            str = ad5.getPosId();
        } else {
            str = null;
        }
        return build.setTagSet("posId", str).setTagSet(AdMetricTag.Report.TYPE, String.valueOf(i3));
    }

    private static int getError(AdHttp.Params params, int[] iArr) {
        if (iArr == null) {
            return 1;
        }
        if (params != null && params.canSend()) {
            for (int i3 : iArr) {
                if (i3 == params.responseCode) {
                    return 0;
                }
            }
            if (params.responseCode != Integer.MIN_VALUE) {
                return 5;
            }
            if (params.throwable instanceof SocketTimeoutException) {
                return 13;
            }
            return 3;
        }
        return 4;
    }

    private static String getMessage(String str, Ad ad5) {
        long j3;
        String str2;
        if (ad5 != null) {
            j3 = ad5.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        if (ad5 != null) {
            str2 = ad5.getTraceId();
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str)) {
            str = str + ", ";
        }
        return str + "aid:" + j3 + " traceId:" + str2;
    }

    public static void logEnd(String str, String str2, int i3, int[] iArr, AdHttp.Params params, click.Response response, String str3, WeakReference<Context> weakReference, Ad ad5) {
        int i16;
        String str4;
        String str5;
        String str6;
        String str7;
        int i17;
        int i18;
        int i19;
        click.Response.Data data;
        int error = getError(params, iArr);
        if (error == 0 && (response == null || response.ret != 0 || (data = response.data) == null || TextUtils.isEmpty(data.dstlink))) {
            error = 5;
        }
        if (error == 0) {
            AdLog.i(str, getMessage(str2, ad5));
            AdMetricService.getInstance().handle(weakReference, build(ad5, 300001L, i3));
            if (params != null && params.durationMillis > 0) {
                AdMetricService.getInstance().handle(weakReference, build(ad5, 300002L, i3).setValue(params.durationMillis));
                return;
            }
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getMessage(str2, ad5));
        sb5.append(" httpResponseCode:");
        if (params != null) {
            i16 = params.responseCode;
        } else {
            i16 = Integer.MIN_VALUE;
        }
        sb5.append(i16);
        sb5.append(" responseString:");
        sb5.append(str3);
        AdLog.e(str, sb5.toString());
        AdMetricService adMetricService = AdMetricService.getInstance();
        IAdMetric tagSet = build(ad5, 300003L, i3).setTagSet(AdMetricTag.ERROR_CODE, String.valueOf(error));
        if (params != null && (i19 = params.responseCode) != Integer.MIN_VALUE) {
            str4 = String.valueOf(i19);
        } else {
            str4 = null;
        }
        IAdMetric tagSet2 = tagSet.setTagSet(AdMetricTag.HTTP_RESPONSE_CODE, str4);
        if (response != null && (i18 = response.ret) != Integer.MIN_VALUE) {
            str5 = String.valueOf(i18);
        } else {
            str5 = null;
        }
        adMetricService.handle(weakReference, tagSet2.setTagSet(AdMetricTag.RESPONSE_CODE, str5));
        if (params != null && params.durationMillis > 0) {
            AdMetricService adMetricService2 = AdMetricService.getInstance();
            IAdMetric tagSet3 = build(ad5, 300004L, i3).setValue(params.durationMillis).setTagSet(AdMetricTag.ERROR_CODE, String.valueOf(error));
            int i26 = params.responseCode;
            if (i26 != Integer.MIN_VALUE) {
                str6 = String.valueOf(i26);
            } else {
                str6 = null;
            }
            IAdMetric tagSet4 = tagSet3.setTagSet(AdMetricTag.HTTP_RESPONSE_CODE, str6);
            if (response != null && (i17 = response.ret) != Integer.MIN_VALUE) {
                str7 = String.valueOf(i17);
            } else {
                str7 = null;
            }
            adMetricService2.handle(weakReference, tagSet4.setTagSet(AdMetricTag.RESPONSE_CODE, str7));
        }
    }

    public static void logStart(String str, String str2, int i3, WeakReference<Context> weakReference, Ad ad5) {
        AdLog.i(str, getMessage(str2, ad5));
        AdMetricService.getInstance().handle(weakReference, build(ad5, MiniBoxNoticeInfo.MIN_5, i3));
    }
}
