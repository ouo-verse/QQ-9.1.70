package com.tencent.ad.tangram.util;

import android.app.Activity;
import android.content.Context;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.metric.AdMetricService;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ad.tangram.statistics.metric.IAdMetric;
import com.tencent.ad.tangram.util.AdClickUtil;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdClickMetricLogger {
    private static IAdMetric build(AdClickUtil.Params params, long j3) {
        Ad ad5;
        String str = null;
        if (params != null) {
            ad5 = params.f61334ad;
        } else {
            ad5 = null;
        }
        if (ad5 != null) {
            str = ad5.getPosId();
        }
        return AdMetricService.getInstance().build(j3).setTagSet("posId", str);
    }

    private static String getMessage(String str, AdClickUtil.Params params) {
        Ad ad5;
        if (params != null) {
            ad5 = params.f61334ad;
        } else {
            ad5 = null;
        }
        if (ad5 == null) {
            return str;
        }
        return str + " posId:" + ad5.getPosId() + " aid:" + ad5.getAId() + " traceId:" + ad5.getTraceId();
    }

    public static void logError(String str, String str2, long j3, AdClickUtil.Params params, AdClickUtil.Result result) {
        WeakReference<Activity> weakReference;
        Activity activity;
        int i3;
        Context context = null;
        if (params != null) {
            weakReference = params.activity;
        } else {
            weakReference = null;
        }
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (activity != null) {
            context = activity.getApplicationContext();
        }
        AdLog.e(str, getMessage(str2, params));
        AdMetricService adMetricService = AdMetricService.getInstance();
        WeakReference<Context> weakReference2 = new WeakReference<>(context);
        IAdMetric build = build(params, j3);
        if (result != null) {
            i3 = result.getErrorCode();
        } else {
            i3 = 1;
        }
        adMetricService.handle(weakReference2, build.setTagSet(AdMetricTag.ERROR_CODE, String.valueOf(i3)));
    }

    public static void logInfo(String str, String str2, long j3, AdClickUtil.Params params) {
        WeakReference<Activity> weakReference = params != null ? params.activity : null;
        Activity activity = weakReference != null ? weakReference.get() : null;
        Context applicationContext = activity != null ? activity.getApplicationContext() : null;
        AdLog.i(str, getMessage(str2, params));
        AdMetricService.getInstance().handle(new WeakReference<>(applicationContext), build(params, j3));
    }

    public static void logInfo(String str, String str2, long j3, AdClickUtil.Params params, AdClickUtil.Result result) {
        WeakReference<Activity> weakReference = params != null ? params.activity : null;
        Activity activity = weakReference != null ? weakReference.get() : null;
        Context applicationContext = activity != null ? activity.getApplicationContext() : null;
        AdLog.i(str, getMessage(str2, params));
        AdMetricService.getInstance().handle(new WeakReference<>(applicationContext), build(params, j3).setTagSet(AdMetricTag.Click.ACTION, String.valueOf(result != null ? result.action : 0)));
    }
}
