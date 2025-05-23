package com.tencent.ad.tangram.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.app.tracer.AdAppLaunchTracerResult;
import com.tencent.ad.tangram.device.AdDevice;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.metric.AdMetricService;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ad.tangram.statistics.metric.IAdMetric;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdAppDeeplinkLaunchTracerLogger {
    AdAppDeeplinkLaunchTracerLogger() {
    }

    private static IAdMetric build(AdClickUtil.Params params, long j3) {
        Ad ad5;
        boolean z16;
        String str = null;
        if (params != null) {
            ad5 = params.f61334ad;
        } else {
            ad5 = null;
        }
        IAdMetric tagSet = AdMetricService.getInstance().build(j3).setTagSet("manufacturer", Build.MANUFACTURER).setTagSet(AdMetricTag.MANUFACTURER_OS_VERSION, AdDevice.getInstance().getManufacturerOSVersion()).setTagSet("model", DeviceInfoMonitor.getModel());
        if (ad5 != null) {
            str = ad5.getPosId();
        }
        IAdMetric tagSet2 = tagSet.setTagSet("posId", str);
        if (ad5 != null && ad5.isDeeplinkFallbackToUrl() && !TextUtils.isEmpty(ad5.getUrlForRewardLandingPage())) {
            z16 = true;
        } else {
            z16 = false;
        }
        return tagSet2.setTagSet(AdMetricTag.Click.FALLBACK_TO_REWARD_URL, String.valueOf(z16));
    }

    private static String getMessage(String str, AdClickUtil.Params params) {
        Activity activity;
        Ad ad5;
        long j3;
        WeakReference<Activity> weakReference;
        String str2 = null;
        if (params != null && (weakReference = params.activity) != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (params != null) {
            ad5 = params.f61334ad;
        } else {
            ad5 = null;
        }
        if (ad5 != null) {
            j3 = ad5.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        if (ad5 != null) {
            str2 = ad5.getTraceId();
        }
        if (!TextUtils.isEmpty(str)) {
            str = str + ", ";
        }
        return str + "aid:" + j3 + " traceId:" + str2 + " activity:" + activity;
    }

    public static void log(String str, String str2, Throwable th5, long j3, long j16, long j17, long j18, AdClickUtil.Params params, AdAppLaunchTracerResult adAppLaunchTracerResult) {
        WeakReference<Activity> weakReference;
        Activity activity = (params == null || (weakReference = params.activity) == null) ? null : weakReference.get();
        long currentTimeMillis = (params == null || params.clickStartTimeMillis <= 0) ? WebViewConstants.WV.ENABLE_WEBAIO_SWITCH : System.currentTimeMillis() - params.clickStartTimeMillis;
        if (adAppLaunchTracerResult != null && adAppLaunchTracerResult.isSuccess()) {
            AdLog.i(str, getMessage(str2 + " result:" + adAppLaunchTracerResult, params));
            AdMetricService.getInstance().handle(new WeakReference<>(activity), build(params, j3).setTagSet(AdMetricTag.Click.LAUNCH_APP_RESULT, String.valueOf(adAppLaunchTracerResult.getAction())));
            if (currentTimeMillis >= 0) {
                AdMetricService.getInstance().handle(new WeakReference<>(activity), build(params, j16).setValue(currentTimeMillis).setTagSet(AdMetricTag.Click.LAUNCH_APP_RESULT, String.valueOf(adAppLaunchTracerResult.getAction())));
                return;
            }
            return;
        }
        AdLog.e(str, getMessage(str2 + " error, result:" + adAppLaunchTracerResult, params), th5);
        AdMetricService.getInstance().handle(new WeakReference<>(activity), build(params, j17).setTagSet(AdMetricTag.ERROR_CODE, adAppLaunchTracerResult != null ? String.valueOf(adAppLaunchTracerResult.getError()) : null));
        if (currentTimeMillis >= 0) {
            AdMetricService.getInstance().handle(new WeakReference<>(activity), build(params, j18).setValue(currentTimeMillis).setTagSet(AdMetricTag.ERROR_CODE, adAppLaunchTracerResult != null ? String.valueOf(adAppLaunchTracerResult.getError()) : null));
        }
    }

    public static void logError(String str, String str2, Throwable th5, long j3, AdClickUtil.Params params, Integer num) {
        Activity activity;
        WeakReference<Activity> weakReference;
        AdLog.e(str, getMessage(str2, params), th5);
        String str3 = null;
        if (params != null && (weakReference = params.activity) != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        AdMetricService adMetricService = AdMetricService.getInstance();
        WeakReference<Context> weakReference2 = new WeakReference<>(activity);
        IAdMetric build = build(params, j3);
        if (num != null) {
            str3 = String.valueOf(num);
        }
        adMetricService.handle(weakReference2, build.setTagSet(AdMetricTag.ERROR_CODE, str3));
    }

    public static void logInfo(String str, String str2, long j3, AdClickUtil.Params params) {
        Activity activity;
        WeakReference<Activity> weakReference;
        AdLog.i(str, getMessage(str2, params));
        if (params != null && (weakReference = params.activity) != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        AdMetricService.getInstance().handle(new WeakReference<>(activity), build(params, j3));
    }

    public static void log(String str, String str2, Throwable th5, long j3, long j16, AdClickUtil.Params params, AdError adError) {
        WeakReference<Activity> weakReference;
        Activity activity = (params == null || (weakReference = params.activity) == null) ? null : weakReference.get();
        if (adError != null && adError.isSuccess()) {
            AdLog.i(str, getMessage(str2, params) + " success");
            AdMetricService.getInstance().handle(new WeakReference<>(activity), build(params, j3));
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str2);
        sb5.append(" failed, error:");
        sb5.append(adError != null ? adError.getErrorCode() : Integer.MIN_VALUE);
        AdLog.e(str, getMessage(sb5.toString(), params), th5);
        AdMetricService.getInstance().handle(new WeakReference<>(activity), build(params, j16).setTagSet(AdMetricTag.ERROR_CODE, adError != null ? String.valueOf(adError.getErrorCode()) : null));
    }
}
