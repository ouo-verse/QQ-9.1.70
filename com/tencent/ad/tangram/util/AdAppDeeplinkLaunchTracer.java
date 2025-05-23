package com.tencent.ad.tangram.util;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.app.tracer.AdAppLaunchTracer;
import com.tencent.ad.tangram.app.tracer.AdAppLaunchTracerParams;
import com.tencent.ad.tangram.app.tracer.AdAppLaunchTracerResult;
import com.tencent.ad.tangram.app.tracer.IAdAppLaunchTracerListener;
import com.tencent.ad.tangram.config.AdConfigManager;
import com.tencent.ad.tangram.config.data.AdConfigForDeeplinkLaunchTracer;
import com.tencent.ad.tangram.device.AdDevice;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ad.tangram.statistics.metric.AdMetricService;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.biz.common.util.WebViewConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdAppDeeplinkLaunchTracer {
    private static final String TAG = "AdAppDeeplinkLaunchTracer";
    private static volatile AdAppDeeplinkLaunchTracer sInstance;
    private volatile AdClickUtil.Params mClickParams;
    private volatile AdAppLaunchTracerListener mLaunchTracerListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class AdAppLaunchTracerListener implements IAdAppLaunchTracerListener {
        private volatile AdClickUtil.Params mClickParams;
        private volatile IFallbackListener mFallbackListener;

        public AdAppLaunchTracerListener(AdClickUtil.Params params, IFallbackListener iFallbackListener) {
            this.mClickParams = params;
            this.mFallbackListener = iFallbackListener;
        }

        private void reportForLinkEvent(AdAppLaunchTracerResult adAppLaunchTracerResult, AdError adError) {
            Activity activity;
            Ad ad5;
            int i3;
            long j3;
            int i16;
            AdClickUtil.Params params = this.mClickParams;
            String str = null;
            if (params != null && params.isValid()) {
                activity = params.activity.get();
            } else {
                activity = null;
            }
            if (params != null && params.isValid()) {
                ad5 = params.f61334ad;
            } else {
                ad5 = null;
            }
            if (adAppLaunchTracerResult != null && adAppLaunchTracerResult.isSuccess()) {
                i3 = adAppLaunchTracerResult.getAction();
            } else {
                i3 = 0;
            }
            ArrayList arrayList = new ArrayList();
            if (i3 == 0) {
                arrayList.add(Integer.valueOf(sdk_event_log.SdkEventDimension.EVENT_LAUNCH_DEEPLINK_UNKNOWN));
            } else if (i3 == 3) {
                arrayList.add(Integer.valueOf(sdk_event_log.SdkEventDimension.EVENT_LAUNCH_DEEPLINK_START_WITH_CONFIRMATION));
                arrayList.add(Integer.valueOf(sdk_event_log.SdkEventDimension.EVENT_LAUNCH_DEEPLINK_SUCCESS_WITH_CONFIRMATION));
            } else if (i3 == 4) {
                arrayList.add(Integer.valueOf(sdk_event_log.SdkEventDimension.EVENT_LAUNCH_DEEPLINK_START_WITH_CONFIRMATION));
                arrayList.add(Integer.valueOf(sdk_event_log.SdkEventDimension.EVENT_LAUNCH_DEEPLINK_FAILED_WITH_CONFIRMATION));
            }
            if (i3 == 4 && adError != null && !adError.isSuccess()) {
                arrayList.add(Integer.valueOf(sdk_event_log.SdkEventDimension.EVENT_LAUNCH_DEEPLINK_FALLBACK_TO_URL_FAILED_WITH_CONFIRMATION));
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[reportForLinkEvent] aid:");
            if (ad5 != null) {
                j3 = ad5.getAId();
            } else {
                j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            }
            sb5.append(j3);
            sb5.append(" traceId:");
            if (ad5 != null) {
                str = ad5.getTraceId();
            }
            sb5.append(str);
            sb5.append(" eventIdList:");
            sb5.append(arrayList);
            sb5.append(" tracerResult:");
            sb5.append(adAppLaunchTracerResult);
            sb5.append(" fallbackError:");
            if (adError != null) {
                i16 = adError.getErrorCode();
            } else {
                i16 = Integer.MIN_VALUE;
            }
            sb5.append(i16);
            AdLog.i(AdAppDeeplinkLaunchTracer.TAG, sb5.toString());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
                reportBiz.deeplink_scene = 1;
                AdReporterForLinkEvent.getInstance().reportAsync(activity, num.intValue(), ad5, reportBiz, null);
            }
        }

        public boolean isValid() {
            if (this.mClickParams != null && this.mClickParams.isValid()) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ad.tangram.app.tracer.IAdAppLaunchTracerListener
        public void onResult(AdAppLaunchTracerParams adAppLaunchTracerParams, AdAppLaunchTracerResult adAppLaunchTracerResult) {
            Activity activity;
            boolean z16;
            AdClickUtil.Params params = this.mClickParams;
            if (!isValid()) {
                AdLog.i(AdAppDeeplinkLaunchTracer.TAG, "[AdAppLaunchTracerListener][onResult] do nothing, not valid, result:" + adAppLaunchTracerResult);
                return;
            }
            AdError adError = null;
            if (params != null && params.isValid()) {
                activity = params.activity.get();
            } else {
                activity = null;
            }
            IFallbackListener iFallbackListener = this.mFallbackListener;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[AdAppLaunchTracerListener][OnResult] fallbackListener:");
            if (iFallbackListener != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            Activity activity2 = activity;
            AdAppDeeplinkLaunchTracerLogger.log(AdAppDeeplinkLaunchTracer.TAG, sb5.toString(), null, 201204L, 201205L, 201206L, 201207L, params, adAppLaunchTracerResult);
            if (iFallbackListener == null) {
                AdMetricService.getInstance().flush(new WeakReference<>(activity2));
                return;
            }
            if (adAppLaunchTracerResult != null && adAppLaunchTracerResult.isSuccess() && (adAppLaunchTracerResult.getAction() == 2 || adAppLaunchTracerResult.getAction() == 4)) {
                adError = iFallbackListener.fallback();
                AdAppDeeplinkLaunchTracerLogger.log(AdAppDeeplinkLaunchTracer.TAG, "[AdAppLaunchTracerListener][OnResult] fallback", null, 201208L, 201201L, params, adError);
            }
            reportForLinkEvent(adAppLaunchTracerResult, adError);
            AdMetricService.getInstance().flush(new WeakReference<>(activity2));
        }

        public void reset() {
            AdLog.i(AdAppDeeplinkLaunchTracer.TAG, "[AdAppLaunchTracerListener][reset]");
            this.mClickParams = null;
            IFallbackListener iFallbackListener = this.mFallbackListener;
            if (iFallbackListener != null) {
                iFallbackListener.reset();
            }
            this.mFallbackListener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface IFallbackListener {
        AdError fallback();

        void reset();
    }

    AdAppDeeplinkLaunchTracer() {
    }

    public static AdAppDeeplinkLaunchTracer getInstance() {
        if (sInstance == null) {
            synchronized (AdAppDeeplinkLaunchTracer.class) {
                if (sInstance == null) {
                    sInstance = new AdAppDeeplinkLaunchTracer();
                }
            }
        }
        return sInstance;
    }

    public static boolean isValid(AdClickUtil.Params params) {
        AdConfigForDeeplinkLaunchTracer configForDeeplinkLaunchTracer = AdConfigManager.getInstance().getConfigForDeeplinkLaunchTracer();
        if (params != null && params.isValid() && params.startActivityRequestCode != Integer.MIN_VALUE && !TextUtils.isEmpty(params.f61334ad.getAppDeeplink(params.clickLocationParams)) && AdAppLaunchTracer.getInstance().isValid() && AdDevice.getInstance().getDeviceType(params.activity.get()) == 1 && !AdDevice.getInstance().isInMultiWindowMode(params.activity.get()) && configForDeeplinkLaunchTracer != null) {
            return true;
        }
        return false;
    }

    public AdClickUtil.Result launch(AdClickUtil.Params params, IFallbackListener iFallbackListener) {
        int i3;
        Integer num;
        AdError adError;
        reset();
        AdConfigForDeeplinkLaunchTracer configForDeeplinkLaunchTracer = AdConfigManager.getInstance().getConfigForDeeplinkLaunchTracer();
        if (configForDeeplinkLaunchTracer == null) {
            AdAppDeeplinkLaunchTracerLogger.logError(TAG, "[launch] error, not allowed", null, 201201L, params, 106);
            return new AdClickUtil.Result(106, 18);
        }
        if (!isValid(params)) {
            AdAppDeeplinkLaunchTracerLogger.logError(TAG, "[launch] error, not valid", null, 201201L, params, 4);
            return new AdClickUtil.Result(4, 18);
        }
        AdAppLaunchTracerListener adAppLaunchTracerListener = new AdAppLaunchTracerListener(params, iFallbackListener);
        if (!adAppLaunchTracerListener.isValid()) {
            AdAppDeeplinkLaunchTracerLogger.logError(TAG, "[launch] error, launchTracerListener is not valid", null, 201201L, params, 1);
            return new AdClickUtil.Result(1, 18);
        }
        AdAppLaunchTracerParams adAppLaunchTracerParams = new AdAppLaunchTracerParams();
        adAppLaunchTracerParams.weakActivity = params.activity;
        CopyOnWriteArrayList<WeakReference<IAdAppLaunchTracerListener>> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        adAppLaunchTracerParams.weakListeners = copyOnWriteArrayList;
        copyOnWriteArrayList.add(new WeakReference<>(adAppLaunchTracerListener));
        adAppLaunchTracerParams.requestCode = params.startActivityRequestCode;
        adAppLaunchTracerParams.timeoutMillis = configForDeeplinkLaunchTracer.timeout;
        AdError onPreLaunch = AdAppLaunchTracer.getInstance().onPreLaunch(adAppLaunchTracerParams);
        if (onPreLaunch != null && onPreLaunch.isSuccess()) {
            AdAppDeeplinkLaunchTracerLogger.logInfo(TAG, "[launch] start", 201200L, params);
            this.mClickParams = params;
            this.mLaunchTracerListener = adAppLaunchTracerListener;
            AdAppDeeplinkLauncher.Params params2 = new AdAppDeeplinkLauncher.Params();
            params2.deeplink = this.mClickParams.f61334ad.getAppDeeplink(this.mClickParams.clickLocationParams);
            params2.extrasForIntent = this.mClickParams.extrasForIntent;
            params2.addflags = 268435456;
            params2.requestCode = this.mClickParams.startActivityRequestCode;
            AdAppDeeplinkLauncher.Result launch = AdAppDeeplinkLauncher.launch(this.mClickParams.activity.get(), params2);
            if (launch != null) {
                adError = launch.getError();
            } else {
                adError = new AdError(1);
            }
            AdClickUtil.Result result = new AdClickUtil.Result(adError, 18);
            if (!adError.isSuccess()) {
                AdAppDeeplinkLaunchTracerLogger.logError(TAG, "[launch] failed, error:" + adError.getErrorCode(), null, 201203L, params, Integer.valueOf(adError.getErrorCode()));
                reset();
                return result;
            }
            AdAppDeeplinkLaunchTracerLogger.logInfo(TAG, "[launch] success", 201202L, params);
            return result;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[launch] error:");
        if (onPreLaunch != null) {
            i3 = onPreLaunch.getErrorCode();
        } else {
            i3 = Integer.MIN_VALUE;
        }
        sb5.append(i3);
        String sb6 = sb5.toString();
        if (onPreLaunch != null) {
            num = Integer.valueOf(onPreLaunch.getErrorCode());
        } else {
            num = null;
        }
        AdAppDeeplinkLaunchTracerLogger.logError(TAG, sb6, null, 201201L, params, num);
        return new AdClickUtil.Result(onPreLaunch, 18);
    }

    public void onActivityResult(WeakReference<Activity> weakReference, int i3, int i16, Intent intent) {
        Activity activity;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (!isValid(this.mClickParams)) {
            AdLog.i(TAG, "[onActivityResult] do nothing, not valid, activity:" + activity + " requestCode:" + i3 + " resultCode:" + i16);
            return;
        }
        if (activity != this.mClickParams.activity.get()) {
            AdLog.i(TAG, "[onActivityResult] do nothing, not the specific activity, activity:" + activity + " requestCode:" + i3 + " resultCode:" + i16);
            return;
        }
        if (!AdAppLaunchTracer.getInstance().onActivityResult(i3, i16, intent)) {
            AdLog.i(TAG, "[onActivityResult] do nothing, activity:" + activity + " requestCode:" + i3 + " resultCode:" + i16);
            return;
        }
        AdAppDeeplinkLaunchTracerLogger.logInfo(TAG, "[onActivityResult] activity:" + activity + " requestCode:" + i3 + " resultCode:" + i16, 201210L, this.mClickParams);
    }

    public void onTopResumedActivityChanged(WeakReference<Activity> weakReference, boolean z16) {
        Activity activity;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (!isValid(this.mClickParams)) {
            AdLog.i(TAG, "[onTopResumedActivityChanged] do nothing, not valid, activity:" + activity + " onTop:" + z16);
            return;
        }
        if (activity != this.mClickParams.activity.get()) {
            AdLog.i(TAG, "[onTopResumedActivityChanged] do nothing, not the specific activity, activity:" + activity + " onTop:" + z16);
            return;
        }
        if (!AdAppLaunchTracer.getInstance().onTopResumedActivityChanged(z16)) {
            AdLog.i(TAG, "[onTopResumedActivityChanged] do nothing, activity:" + activity + " onTop:" + z16);
            return;
        }
        AdAppDeeplinkLaunchTracerLogger.logInfo(TAG, "[onTopResumedActivityChanged] activity:" + activity + " onTop:" + z16, 201211L, this.mClickParams);
    }

    public void reset() {
        AdLog.i(TAG, "[reset]");
        AdAppLaunchTracer.getInstance().reset();
        this.mClickParams = null;
        AdAppLaunchTracerListener adAppLaunchTracerListener = this.mLaunchTracerListener;
        if (adAppLaunchTracerListener != null) {
            adAppLaunchTracerListener.reset();
        }
        this.mLaunchTracerListener = null;
    }
}
