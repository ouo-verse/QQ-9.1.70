package com.tencent.ad.tangram.util;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdClickLocationParams;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.config.AdConfigManager;
import com.tencent.ad.tangram.device.AdDevice;
import com.tencent.ad.tangram.halfScreenDownload.AdHalfScreenDownload;
import com.tencent.ad.tangram.interpage.AdInterPage;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.mini.AdQQMINIProgram;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.statistics.AdLinkReportForClick;
import com.tencent.ad.tangram.statistics.AdReporterForClick;
import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ad.tangram.statistics.AdReporterForOuterJump;
import com.tencent.ad.tangram.statistics.AdReporterOfApp;
import com.tencent.ad.tangram.statistics.AdReporterOfDeeplink;
import com.tencent.ad.tangram.statistics.metric.AdMetricService;
import com.tencent.ad.tangram.triple.AdTripleLink;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher;
import com.tencent.ad.tangram.util.AdAppMarketLauncher;
import com.tencent.ad.tangram.videoceiling.AdVideoCeiling;
import com.tencent.ad.tangram.views.floatwindow.AdFloatWindow;
import com.tencent.ad.tangram.web.AdBrowser;
import com.tencent.ad.tangram.wechat.AdWXCanvas;
import com.tencent.ad.tangram.wechat.AdWXCustomerService;
import com.tencent.ad.tangram.wechat.AdWXMINIProgram;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qzone.util.PerfTracer;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdClickUtil {
    public static final int ACTION_APP = 5;
    public static final int ACTION_APP_MARKET = 8;
    public static final int ACTION_APP_WITH_DEEPLINK = 4;
    public static final int ACTION_APP_WITH_DEEPLINK_FALLBACK_TO_URL = 18;
    public static final int ACTION_DOWNLOAD_CANCEL = 35;
    public static final int ACTION_DOWNLOAD_DO_NOTHING = 30;
    public static final int ACTION_DOWNLOAD_INSTALL = 34;
    public static final int ACTION_DOWNLOAD_LOAD_INFO = 31;
    public static final int ACTION_DOWNLOAD_PAUSE = 33;
    public static final int ACTION_DOWNLOAD_START = 32;
    public static final int ACTION_HALF_SCREEN_DOWNLOAD = 14;
    public static final int ACTION_OLYMPIC_INTER_PAGE_JUMP = 17;
    public static final int ACTION_QQ_MINI_PROGRAM = 6;
    public static final int ACTION_QUICK_APP = 13;
    public static final int ACTION_TRIPLE_LINK_OUTER_JUMP_STEP = 16;
    public static final int ACTION_TRIPLE_LINK_URL_STEP = 15;
    public static final int ACTION_UNKNOWN = 0;
    public static final int ACTION_VIDEO_CEILING = 2;
    public static final int ACTION_WEB = 1;
    public static final int ACTION_WX_CANVAS = 12;
    public static final int ACTION_WX_CUSTOMER_SERVICE = 19;
    public static final int ACTION_WX_MINI_PROGRAM = 9;
    private static final String TAG = "AdClickUtil";

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class LaunchAppWithDeeplinkOptions {
        public static final int LAUNCH_APP_WITH_DEEPLINK = 1;
        public static final int LAUNCH_APP_WITH_DEEPLINK_AND_TRACE = 2;
        public static final int LAUNCH_APP_WITH_DEEPLINK_FALLBACK_TO_URL_AND_TRACE = 3;

        public static boolean canFallbackToUrl(int i3) {
            if (i3 == 3) {
                return true;
            }
            return false;
        }

        public static boolean canTrace(int i3) {
            if (i3 != 2 && i3 != 3) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public static class Params {
        public WeakReference<Activity> activity;

        /* renamed from: ad, reason: collision with root package name */
        @Nullable
        public Ad f61334ad;
        public Bundle extrasForIntent;
        public String widthHeightRatioOfVideoCeiling;
        public boolean reportForClick = true;
        public long clickStartTimeMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        public int sceneID = Integer.MIN_VALUE;
        public int componentID = Integer.MIN_VALUE;
        public boolean videoCeilingSupported = false;
        public boolean videoPlayForced = false;
        private final boolean videoLoop = false;
        public long videoStartPositionMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

        @Nullable
        public String antiSpamParams = null;
        public AdClickLocationParams clickLocationParams = null;
        public boolean browserForcePortrait = false;
        public boolean useVerticalTransitionBetweenActivities = false;
        public int startActivityRequestCode = Integer.MIN_VALUE;

        public boolean isValid() {
            Ad ad5;
            boolean z16;
            boolean z17;
            WeakReference<Activity> weakReference = this.activity;
            if (weakReference == null || weakReference.get() == null || (ad5 = this.f61334ad) == null || !ad5.isValid()) {
                return false;
            }
            if (!TextUtils.isEmpty(this.f61334ad.getTraceId()) && !TextUtils.isEmpty(this.f61334ad.getUrlForEffect()) && !TextUtils.isEmpty(this.f61334ad.getUrlForAction())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!this.f61334ad.isWXCanvasAd() && !this.f61334ad.isWXMINIProgramOrWXMINIGameProductType()) {
                if (z16 && !TextUtils.isEmpty(this.f61334ad.getUrlForLandingPage())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                AdClickLocationParams adClickLocationParams = this.clickLocationParams;
                if (adClickLocationParams != null && adClickLocationParams.isValidForCarouselAd(this.f61334ad)) {
                    if (z16 && !TextUtils.isEmpty(this.f61334ad.getUrlForLandingPage(this.clickLocationParams))) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                }
            }
            if (z16 && !TextUtils.isEmpty(this.f61334ad.getUrlForImpression()) && !TextUtils.isEmpty(this.f61334ad.getUrlForClick())) {
                z17 = true;
            } else {
                z17 = false;
            }
            AdClickLocationParams adClickLocationParams2 = this.clickLocationParams;
            if (adClickLocationParams2 != null && adClickLocationParams2.isValidForCarouselAd(this.f61334ad)) {
                if (!z17 || TextUtils.isEmpty(this.f61334ad.getUrlForClick(this.clickLocationParams))) {
                    return false;
                }
                return true;
            }
            return z17;
        }

        public boolean isValidForApp() {
            if (isValid() && this.f61334ad.isAppProductType() && !TextUtils.isEmpty(this.f61334ad.getVia()) && !TextUtils.isEmpty(this.f61334ad.getAppName()) && !TextUtils.isEmpty(this.f61334ad.getAppId()) && !TextUtils.isEmpty(this.f61334ad.getAppPackageName())) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class URLParams {
        public boolean isVideoCeiling = false;
    }

    public static void afterClick(Params params, Result result) {
        if (params != null && params.isValid()) {
            AdAnalysisHelperForUtil.reportForClickEnd(params, result);
            if (result != null && result.isSuccess()) {
                AdClickMetricLogger.logInfo(TAG, "[afterClick]", 200001L, params, result);
            } else {
                AdClickMetricLogger.logError(TAG, "[afterClick] error", 200002L, params, result);
            }
            AdReporterOfApp.report(new WeakReference(params.activity.get()), params.f61334ad);
            AdReporterOfDeeplink.report(params, result, false);
            if (result != null && result.isJumpOutType()) {
                AdReporterForOuterJump.getInstance().onClick(params.f61334ad);
            }
            if (result != null && result.isSuccess()) {
                AdFloatWindow.getInstance().close(params.activity);
            }
            AdMetricService.getInstance().flush(new WeakReference<>(params.activity.get()));
            return;
        }
        AdLog.e(TAG, "[afterClick] error, not valid");
    }

    public static void beforeClick(Params params) {
        int i3;
        if (params != null && params.isValid()) {
            AdClickMetricLogger.logInfo(TAG, "[beforeClick]", 200000L, params);
            if (params.reportForClick) {
                Activity activity = params.activity.get();
                Ad ad5 = params.f61334ad;
                if (params.reportForClick) {
                    i3 = 1;
                } else {
                    i3 = 3;
                }
                AdLinkReportForClick.linkReportForClickStart(activity, ad5, i3);
            }
            AdAnalysisHelperForUtil.reportForClickStart(params);
            return;
        }
        AdLog.e(TAG, "[beforeClick] error, not valid");
    }

    public static boolean canLaunchApp(@Nullable Params params) {
        boolean z16;
        boolean z17;
        AdError adError;
        if (params == null || !params.isValid() || params.f61334ad.isWXCanvasAd() || params.f61334ad.isQQMINIProgram()) {
            return false;
        }
        if (params.f61334ad.isWXMINIProgram() && !TextUtils.isEmpty(params.f61334ad.getAppDeeplink(params.clickLocationParams))) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (isWebProductType(params) && isWebDestType(params) && !TextUtils.isEmpty(params.f61334ad.getAppDeeplink(params.clickLocationParams))) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (params.f61334ad.isAppProductType() && params.isValidForApp()) {
            boolean isInstalled = AdAppUtil.isInstalled(params.activity.get(), params.f61334ad.getAppPackageName());
            if ((TextUtils.isEmpty(params.f61334ad.getAppDeeplink(params.clickLocationParams)) && params.f61334ad.isAppXiJing() && params.f61334ad.disableLaunchApp()) || !isInstalled) {
                return false;
            }
            return true;
        }
        if (!z16 && !z17) {
            return false;
        }
        AdAppDeeplinkLauncher.Params params2 = new AdAppDeeplinkLauncher.Params();
        params2.deeplink = params.f61334ad.getAppDeeplink(params.clickLocationParams);
        params2.addflags = 268435456;
        params2.extrasForIntent = params.extrasForIntent;
        AdAppDeeplinkLauncher.Result canLaunch = AdAppDeeplinkLauncher.canLaunch(params.activity.get(), params2);
        if (canLaunch != null) {
            adError = canLaunch.getError();
        } else {
            adError = new AdError(1);
        }
        if (adError == null || !adError.isSuccess()) {
            return false;
        }
        return true;
    }

    private static void fillAntiSpamParams(Params params) {
        if (params != null && params.isValid()) {
            if (TextUtils.isEmpty(params.antiSpamParams)) {
                AdLog.i(TAG, "[fillAntiSpamParams] do nothing, antiSpamParams is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(params.antiSpamParams);
                int screenWidth = AdUIUtils.getScreenWidth(params.activity.get());
                int screenHeight = AdUIUtils.getScreenHeight(params.activity.get());
                jSONObject.put("sw", String.valueOf(AdUIUtils.px2dp(params.activity.get(), screenWidth)));
                jSONObject.put("sh", String.valueOf(AdUIUtils.px2dp(params.activity.get(), screenHeight)));
                params.antiSpamParams = jSONObject.toString();
            } catch (Throwable th5) {
                AdLog.d(TAG, "[fillAntiSpamParams]", th5);
            }
            AdLog.i(TAG, String.format("[fillAntiSpamParams] antiSpamParams:%s", params.antiSpamParams));
            return;
        }
        AdLog.e(TAG, "[fillAntiSpamParams] error");
    }

    private static void fillClickStartTimeParams(Params params) {
        params.clickStartTimeMillis = System.currentTimeMillis();
    }

    public static void fillParams(Params params) {
        if (params != null && params.isValid()) {
            fillClickStartTimeParams(params);
            fillAntiSpamParams(params);
        } else {
            AdLog.e(TAG, "[fillParams] error");
        }
    }

    public static AdBrowser.Params getBrowserParams(@Nullable Params params, URLObject uRLObject) {
        if (params != null && params.isValid()) {
            if (uRLObject != null && uRLObject.isValid()) {
                AdBrowser.Params params2 = new AdBrowser.Params();
                params2.activity = params.activity;
                params2.f61348ad = params.f61334ad;
                params2.url = uRLObject.url;
                params2.forcePortrait = params.browserForcePortrait;
                params2.useVerticalTransitionBetweenActivities = params.useVerticalTransitionBetweenActivities;
                params2.extrasForIntent = params.extrasForIntent;
                return params2;
            }
            AdLog.e(TAG, "getHandleUrlParams error");
            return null;
        }
        AdLog.e(TAG, "getHandleUrlParams error");
        return null;
    }

    private static int getErrorCodeOfAppMarketForLinkEvent(AdError adError) {
        if (adError == null) {
            return 0;
        }
        int errorCode = adError.getErrorCode();
        if (errorCode != 4) {
            if (errorCode != 12) {
                if (errorCode != 204) {
                    if (errorCode != 201) {
                        if (errorCode != 202) {
                            return 0;
                        }
                        return 317;
                    }
                    return 304;
                }
                return 315;
            }
            return 314;
        }
        return 206;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static URLObject getURLObject(@Nullable Params params, URLParams uRLParams) {
        if (params != null && params.isValid() && uRLParams != null) {
            URLObject uRLObject = new URLObject();
            boolean z16 = true;
            if (!params.reportForClick) {
                if (!params.f61334ad.isXijingByExtensionType() || !uRLParams.isVideoCeiling) {
                    z16 = false;
                }
                uRLObject.url = replaceUrlWithClickLpp(params.f61334ad.getUrlForLandingPage(params.clickLocationParams), params, z16);
                uRLObject.type = 2;
            } else {
                uRLObject.url = getUrlForClick(params, uRLParams);
                uRLObject.type = 1;
            }
            return uRLObject;
        }
        return null;
    }

    @Nullable
    public static String getUrlForClick(@Nullable Params params, URLParams uRLParams) {
        boolean z16;
        if (params != null && params.isValid() && uRLParams != null) {
            String urlForClick = params.f61334ad.getUrlForClick(params.clickLocationParams);
            if (TextUtils.isEmpty(urlForClick)) {
                AdLog.e(TAG, "getUrlForClick error");
                return null;
            }
            if (params.f61334ad.isXijingByExtensionType() && uRLParams.isVideoCeiling) {
                z16 = true;
            } else {
                z16 = false;
            }
            String replaceUrlWithViewId = replaceUrlWithViewId(replaceUrlWithClickLpp(urlForClick, params, z16), params);
            Uri parse = AdUriUtil.parse(replaceUrlWithViewId);
            if (parse == null) {
                AdLog.e(TAG, "getUrlForClick error");
                return replaceUrlWithViewId;
            }
            Uri.Builder buildUpon = parse.buildUpon();
            if (buildUpon == null) {
                AdLog.e(TAG, "getUrlForClick error");
                return replaceUrlWithViewId;
            }
            if (AdUriUtil.getQueryParameter(parse, "feeds_attachment") == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    int i3 = params.sceneID;
                    if (i3 != Integer.MIN_VALUE) {
                        jSONObject.put("click_scene", String.valueOf(i3));
                    }
                    int i16 = params.componentID;
                    if (i16 != Integer.MIN_VALUE) {
                        jSONObject.put("click_pos", String.valueOf(i16));
                    }
                    if (jSONObject.length() > 0) {
                        buildUpon = buildUpon.appendQueryParameter("feeds_attachment", jSONObject.toString());
                    }
                } catch (Throwable th5) {
                    AdLog.e(TAG, "getUrlForClick", th5);
                }
            }
            if (AdUriUtil.getQueryParameter(parse, "isfromqqb") == null) {
                buildUpon = buildUpon.appendQueryParameter("isfromqqb", "1");
            }
            if (AdUriUtil.getQueryParameter(parse, ReportConstant.COSTREPORT_PREFIX) == null && !TextUtils.isEmpty(params.antiSpamParams)) {
                buildUpon = buildUpon.appendQueryParameter(ReportConstant.COSTREPORT_PREFIX, params.antiSpamParams);
            }
            return buildUpon.toString();
        }
        AdLog.e(TAG, "getUrlForClick error");
        return null;
    }

    @Nullable
    public static AdVideoCeiling.Params getVideoCeilingParams(@Nullable Params params) {
        boolean z16;
        if (params != null && params.isValid() && params.videoCeilingSupported && !TextUtils.isEmpty(params.f61334ad.getVideoUrl(params.clickLocationParams)) && !params.f61334ad.isVideoOnTopDisabled()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return null;
        }
        URLParams uRLParams = new URLParams();
        uRLParams.isVideoCeiling = true;
        URLObject uRLObject = getURLObject(params, uRLParams);
        if (uRLObject != null && uRLObject.isValid()) {
            int deviceType = AdDevice.getInstance().getDeviceType(params.activity.get());
            if (deviceType != 1) {
                AdLog.e(TAG, "[getVideoCeilingParams] error, not enabled, deviceType:" + deviceType);
                return null;
            }
            String str = params.widthHeightRatioOfVideoCeiling;
            int videoWidth = params.f61334ad.getVideoWidth();
            int videoHeight = params.f61334ad.getVideoHeight();
            AdLog.i(TAG, "[getVideoCeilingParams] videoWidth:" + videoWidth + " videoHeight:" + videoHeight);
            if (TextUtils.isEmpty(str) && videoWidth > 0 && videoHeight > 0) {
                if (videoWidth * 9 != videoHeight * 16 && videoWidth * 3 != videoHeight * 4) {
                    if (videoWidth * 16 == videoHeight * 9) {
                        str = "1:1";
                    }
                } else {
                    str = "16:9";
                }
            }
            AdVideoCeiling.Params params2 = new AdVideoCeiling.Params();
            params2.activity = params.activity;
            Ad ad5 = params.f61334ad;
            params2.f61336ad = ad5;
            params2.webUrl = uRLObject.url;
            params2.videoUrl = ad5.getVideoUrl(params.clickLocationParams);
            params2.widthHeightRatio = str;
            params2.videoPlayForced = params.videoPlayForced;
            params2.videoLoop = false;
            params2.useVerticalTransitionBetweenActivities = params.useVerticalTransitionBetweenActivities;
            params2.extrasForIntent = params.extrasForIntent;
            if (!params2.isValid()) {
                return null;
            }
            return params2;
        }
        AdLog.e(TAG, "[getVideoCeilingParams] error, urlObject is not valid");
        return null;
    }

    @Nullable
    public static Result handle(@Nullable Params params) {
        Result handleUrl;
        AdLog.i(TAG, "[handle]");
        AdAppDeeplinkLaunchTracer.getInstance().reset();
        if (params != null && params.isValid()) {
            fillParams(params);
            beforeClick(params);
            Result result = new Result(1, 0);
            if (params.f61334ad.isTripleLink()) {
                handleUrl = handleTripleLink(params);
            } else if (params.f61334ad.isWXMINIProgram()) {
                handleUrl = handleWXMINIProgramWithDeeplink(params);
            } else if (params.f61334ad.isWXCanvasAd()) {
                handleUrl = handleWXCanvasType(params);
            } else if (params.f61334ad.isWXCustomerService()) {
                handleUrl = handleWXCustomerServiceType(params);
            } else if (params.f61334ad.isQQMINIProgram()) {
                handleUrl = handleQQMINIProgramType(params);
            } else if (params.f61334ad.isWXMINIGameProductType()) {
                handleUrl = handleWXMINIGameProductType(params);
            } else {
                if (params.f61334ad.isAppProductType()) {
                    result = handleAppProductType(params);
                } else if (params.f61334ad.isQuickAppProductType()) {
                    result = handleQuickAppProductType(params);
                } else if (isWebProductType(params)) {
                    result = handleWebProductType(params);
                }
                if (result != null && result.isSuccess()) {
                    handleUrl = result;
                } else {
                    handleUrl = handleUrl(params, getURLObject(params, new URLParams()));
                    if (handleUrl != null) {
                        handleUrl.errorHandled = true;
                    }
                }
            }
            afterClick(params, handleUrl);
            return handleUrl;
        }
        AdLog.e(TAG, "handle error");
        return new Result(4, 0);
    }

    @NonNull
    public static Result handleApp(@Nullable Params params, boolean z16) {
        if (params != null && params.isValidForApp()) {
            if (!AdAppUtil.isInstalled(params.activity.get(), params.f61334ad.getAppPackageName())) {
                AdLog.e(TAG, "[handleApp] error, not installed");
                return new Result(19, 5);
            }
            AdError launch = AdAppUtil.launch(params.activity.get(), params.f61334ad.getAppPackageName(), params.extrasForIntent);
            if (launch != null && launch.isSuccess() && params.reportForClick && !z16) {
                AdReporterForClick.reportAsync(new WeakReference(params.activity.get()), params.f61334ad, getUrlForClick(params, new URLParams()), params.clickStartTimeMillis, 1);
            }
            return new Result(launch, 5);
        }
        AdLog.e(TAG, "[handleApp] error, not valid");
        return new Result(4, 5);
    }

    public static void handleAppAfterInstalled(@Nullable Params params, Result result) {
        if (params != null && params.isValidForApp()) {
            if (params.f61334ad.isAppXiJingFengling()) {
                return;
            }
            AdAppReceiverWrapper.getInstance().observe(params, result);
            return;
        }
        AdLog.e(TAG, "handleAppAfterInstalled error");
    }

    private static Result handleAppMarket(@Nullable Params params) {
        AdError adError;
        int i3;
        List<Pair<AdAppDeeplinkLauncher.Params, AdAppDeeplinkLauncher.Result>> list;
        AdAppDeeplinkLauncher.Params params2;
        AdAppDeeplinkLauncher.Result result;
        AdError adError2;
        String str;
        String str2;
        if (params != null && params.isValidForApp() && !TextUtils.isEmpty(params.f61334ad.getAppMarketDeeplink()) && params.f61334ad.getAppMarketJumpType() == 1) {
            link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
            reportBiz.download_scene = 1;
            AdReporterForLinkEvent.getInstance().reportAsync(params.activity.get(), sdk_event_log.SdkEventDimension.EVENT_OPEN_APP_MARKET_START, params.f61334ad, reportBiz, null);
            AdAppMarketLauncher.Params params3 = new AdAppMarketLauncher.Params();
            params3.list = new LinkedList();
            List<String> appMarketPackageName = params.f61334ad.getAppMarketPackageName();
            String appMarketDeeplink = params.f61334ad.getAppMarketDeeplink();
            if (appMarketPackageName != null) {
                for (String str3 : appMarketPackageName) {
                    AdAppDeeplinkLauncher.Params params4 = new AdAppDeeplinkLauncher.Params();
                    params4.deeplink = appMarketDeeplink;
                    params4.packageName = str3;
                    params4.extrasForIntent = params.extrasForIntent;
                    params4.addflags = 268435456;
                    params3.list.add(params4);
                }
            }
            AdAppMarketLauncher.Result launch = AdAppMarketLauncher.launch(params.activity, params3);
            if (launch != null) {
                adError = launch.getError();
            } else {
                adError = new AdError(1);
            }
            Result result2 = new Result(adError, 8);
            if (result2.isSuccess() && params.reportForClick) {
                AdReporterForClick.reportAsync(new WeakReference(params.activity.get()), params.f61334ad, getUrlForClick(params, new URLParams()), params.clickStartTimeMillis, 1);
            }
            if (result2.isSuccess()) {
                AdReporterForEffect.reportAsync(new WeakReference(params.activity.get()), params.f61334ad, 285);
            }
            link_report.LinkReport.ReportBiz reportBiz2 = new link_report.LinkReport.ReportBiz();
            reportBiz2.download_scene = 1;
            AdReporterForLinkEvent adReporterForLinkEvent = AdReporterForLinkEvent.getInstance();
            Activity activity = params.activity.get();
            if (result2.isSuccess()) {
                i3 = sdk_event_log.SdkEventDimension.EVENT_OPEN_APP_MARKET_SUCCESS;
            } else {
                i3 = sdk_event_log.SdkEventDimension.EVENT_OPEN_APP_MARKET_FAILED;
            }
            adReporterForLinkEvent.reportAsync(activity, i3, params.f61334ad, reportBiz2, null);
            if (launch != null) {
                list = launch.getDetails();
            } else {
                list = null;
            }
            if (list != null && !list.isEmpty()) {
                for (Pair<AdAppDeeplinkLauncher.Params, AdAppDeeplinkLauncher.Result> pair : list) {
                    AdReporterForLinkEvent.getInstance().reportAsync(params.activity.get(), sdk_event_log.SdkEventDimension.EVENT_SINGLE_APP_MARKET_JUMP_START, params.f61334ad, null, null);
                    if (pair != null) {
                        params2 = (AdAppDeeplinkLauncher.Params) pair.first;
                    } else {
                        params2 = null;
                    }
                    if (pair != null) {
                        result = (AdAppDeeplinkLauncher.Result) pair.second;
                    } else {
                        result = null;
                    }
                    if (result == null || !result.isSuccess()) {
                        link_report.LinkReport.ReportBiz reportBiz3 = new link_report.LinkReport.ReportBiz();
                        if (result != null) {
                            adError2 = result.getError();
                        } else {
                            adError2 = null;
                        }
                        reportBiz3.act_code = getErrorCodeOfAppMarketForLinkEvent(adError2);
                        AdReporterForLinkEvent.getInstance().reportAsync(params.activity.get(), sdk_event_log.SdkEventDimension.EVENT_SINGLE_APP_MARKET_JUMP_FAILED, params.f61334ad, reportBiz3, null);
                        if (result != null) {
                            str = result.getActivityName();
                        } else {
                            str = null;
                        }
                        if (params2 != null) {
                            str2 = params2.packageName;
                        } else {
                            str2 = null;
                        }
                        AdAnalysisHelperForUtil.reportForLaunchAppMarket(params, result2, str, str2);
                    }
                }
            }
            return result2;
        }
        return new Result(4, 8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x006d, code lost:
    
        if (android.text.TextUtils.isEmpty(r5.f61334ad.getAppDeeplink(r5.clickLocationParams)) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x006f, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bd  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Result handleAppProductType(@Nullable Params params) {
        boolean z16;
        boolean z17 = false;
        if (params != null && params.isValidForApp()) {
            boolean isInstalled = AdAppUtil.isInstalled(params.activity.get(), params.f61334ad.getAppPackageName());
            AdLog.i(TAG, "handleAppProductTypeV2 " + params.f61334ad.getAppPackageName() + " installed:" + isInstalled);
            if (AdConfigManager.getInstance().isClickXIJINGV2Enabled()) {
                if (isInstalled) {
                    if (params.f61334ad.isAppXiJing()) {
                        if (params.f61334ad.disableLaunchApp()) {
                        }
                    }
                }
                if (z17) {
                    AdVideoCeiling.Params videoCeilingParams = getVideoCeilingParams(params);
                    if (videoCeilingParams != null) {
                        return handleVideoCeiling(params, videoCeilingParams);
                    }
                    return handleUrl(params, getURLObject(params, new URLParams()));
                }
                if (isInstalled) {
                    return handleAppProductTypeIfInstalled(params);
                }
                return handleAppProductTypeIfNotInstalled(params);
            }
            if (params.f61334ad.isAppXiJing() && params.f61334ad.disableLaunchApp()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!isInstalled) {
                if (z17) {
                }
            } else if (z17) {
            }
        } else {
            AdLog.e(TAG, "handleAppProductTypeV2 error");
            return new Result(4, 0);
        }
    }

    @NonNull
    private static Result handleAppProductTypeIfInstalled(@Nullable Params params) {
        int i3;
        if (params != null && params.isValidForApp()) {
            AdLog.i(TAG, "handleAppProductTypeIfInstalled " + params.f61334ad.getAppPackageName());
            if (params.f61334ad.getDestType() == 0) {
                i3 = 3;
            } else {
                i3 = 2;
            }
            Result handleAppWithDeeplink = handleAppWithDeeplink(params, i3, false);
            if (handleAppWithDeeplink != null && handleAppWithDeeplink.isSuccess()) {
                return handleAppWithDeeplink;
            }
            return handleApp(params, false);
        }
        AdLog.e(TAG, "handleAppProductTypeIfInstalled error");
        return new Result(4, 0);
    }

    @NonNull
    private static Result handleAppProductTypeIfNotInstalled(@Nullable Params params) {
        if (params != null && params.isValidForApp()) {
            AdVideoCeiling.Params videoCeilingParams = getVideoCeilingParams(params);
            if (!params.f61334ad.isAppXiJingDefault() && !params.f61334ad.isAppXiJing() && !params.f61334ad.isAppXiJingFengling() && params.f61334ad.getDestType() != 22) {
                AdLog.e(TAG, "handleAppProductTypeIfNotInstalled error");
                return new Result(4, 0);
            }
            Result handleAppMarket = handleAppMarket(params);
            if (handleAppMarket == null || !handleAppMarket.isSuccess()) {
                if (params.f61334ad.isEnableHalfScreenDownload() && (TextUtils.isEmpty(params.f61334ad.getAppMarketDeeplink()) || params.f61334ad.getAppMarketJumpType() != 2)) {
                    handleAppMarket = handleHalfScreenDownload(params);
                }
                if (handleAppMarket == null || !handleAppMarket.isSuccess()) {
                    if (videoCeilingParams != null) {
                        handleAppMarket = handleVideoCeiling(params, videoCeilingParams);
                    }
                    if (handleAppMarket == null || !handleAppMarket.isSuccess()) {
                        handleAppMarket = handleUrl(params, getURLObject(params, new URLParams()));
                    }
                }
            }
            handleAppAfterInstalled(params, handleAppMarket);
            return handleAppMarket;
        }
        AdLog.e(TAG, "handleAppProductTypeIfNotInstalled error");
        return new Result(4, 0);
    }

    public static Result handleAppWithDeeplink(@Nullable Params params, int i3, boolean z16) {
        if (params != null && params.isValid() && !TextUtils.isEmpty(params.f61334ad.getAppDeeplink(params.clickLocationParams))) {
            if (AdAppDeeplinkLaunchTracer.isValid(params) && params.f61334ad.isDeeplinkFallbackToUrl() && params.reportForClick && LaunchAppWithDeeplinkOptions.canTrace(i3) && !z16) {
                return handleAppWithDeeplinkWithTrace(params, i3);
            }
            return handleAppWithDeeplinkWithoutTrace(params, z16);
        }
        AdLog.e(TAG, "[handleAppWithDeeplink] error");
        return new Result(4, 4);
    }

    private static Result handleAppWithDeeplinkWithTrace(@Nullable Params params, int i3) {
        String str;
        String str2;
        String str3;
        if (params != null && params.isValid() && !TextUtils.isEmpty(params.f61334ad.getAppDeeplink(params.clickLocationParams)) && AdAppDeeplinkLaunchTracer.isValid(params) && LaunchAppWithDeeplinkOptions.canTrace(i3)) {
            AdAppDeeplinkLaunchTracerFallbackListener adAppDeeplinkLaunchTracerFallbackListener = null;
            r4 = null;
            String str4 = null;
            String str5 = null;
            if (params.f61334ad.isDeeplinkFallbackToUrl() && params.reportForClick && LaunchAppWithDeeplinkOptions.canFallbackToUrl(i3)) {
                AdVideoCeiling.Params videoCeilingParams = getVideoCeilingParams(params);
                AdBrowser.Params browserParams = getBrowserParams(params, getURLObject(params, new URLParams()));
                if (videoCeilingParams != null && videoCeilingParams.isValid()) {
                    browserParams = null;
                }
                if (TextUtils.isEmpty(params.f61334ad.getUrlForRewardLandingPage())) {
                    String uuid = UUID.randomUUID().toString();
                    if (videoCeilingParams != null && videoCeilingParams.isValid()) {
                        str4 = videoCeilingParams.webUrl;
                    } else if (browserParams != null && browserParams.isValid()) {
                        str4 = browserParams.url;
                    }
                    str3 = str4;
                    str5 = uuid;
                } else {
                    str3 = null;
                }
                AdAppDeeplinkLaunchTracerFallbackListener adAppDeeplinkLaunchTracerFallbackListener2 = new AdAppDeeplinkLaunchTracerFallbackListener(params, videoCeilingParams, browserParams, str5);
                if (!adAppDeeplinkLaunchTracerFallbackListener2.isValid()) {
                    AdLog.e(TAG, "[handleAppWithDeeplinkWithTrace] error, fallbackListener not valid");
                    return new Result(1, 18);
                }
                str2 = str5;
                adAppDeeplinkLaunchTracerFallbackListener = adAppDeeplinkLaunchTracerFallbackListener2;
                str = str3;
            } else {
                str = null;
                str2 = null;
            }
            AdLog.i(TAG, "[handleAppWithDeeplinkWithTrace]");
            Result launch = AdAppDeeplinkLaunchTracer.getInstance().launch(params, adAppDeeplinkLaunchTracerFallbackListener);
            if (launch != null && launch.isSuccess() && params.reportForClick) {
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    AdReporterForClick.reportAndFetchAsync(new WeakReference(params.activity.get()), params.f61334ad, str, str2, params.clickStartTimeMillis, 1);
                } else {
                    AdReporterForClick.reportAsync(new WeakReference(params.activity.get()), params.f61334ad, getUrlForClick(params, new URLParams()), params.clickStartTimeMillis, 1);
                }
            }
            return launch;
        }
        AdLog.e(TAG, "[handleAppWithDeeplinkWithTrace] error, not valid");
        return new Result(4, 18);
    }

    private static Result handleAppWithDeeplinkWithoutTrace(@Nullable Params params, boolean z16) {
        AdError adError;
        if (params != null && params.isValid() && !TextUtils.isEmpty(params.f61334ad.getAppDeeplink(params.clickLocationParams))) {
            AdAnalysisHelperForUtil.reportForLaunchAppWithDeepLinkStart(params, z16);
            AdAppDeeplinkLauncher.Params params2 = new AdAppDeeplinkLauncher.Params();
            params2.deeplink = params.f61334ad.getAppDeeplink(params.clickLocationParams);
            params2.extrasForIntent = params.extrasForIntent;
            params2.addflags = 268435456;
            AdAppDeeplinkLauncher.Result launch = AdAppDeeplinkLauncher.launch(params.activity.get(), params2);
            if (launch != null && launch.isSuccess() && params.reportForClick && !z16) {
                AdReporterForClick.reportAsync(new WeakReference(params.activity.get()), params.f61334ad, getUrlForClick(params, new URLParams()), params.clickStartTimeMillis, 1);
            }
            if (launch != null) {
                adError = launch.getError();
            } else {
                adError = new AdError(1);
            }
            Result result = new Result(adError, 4);
            AdAnalysisHelperForUtil.reportForLaunchAppWithDeepLinkEND(params, result, z16);
            return result;
        }
        AdLog.e(TAG, "[handleAppWithDeeplinkWithoutTrace] error");
        return new Result(4, 4);
    }

    @Nullable
    private static Result handleHalfScreenDownload(@Nullable Params params) {
        Activity activity;
        if (params != null && params.isValid() && params.f61334ad.isEnableHalfScreenDownload()) {
            WeakReference<Activity> weakReference = params.activity;
            WeakReference weakReference2 = null;
            if (weakReference != null) {
                activity = weakReference.get();
            } else {
                activity = null;
            }
            AdHalfScreenDownload.Params params2 = new AdHalfScreenDownload.Params();
            params2.weakActivity = params.activity;
            params2.f61320ad = params.f61334ad;
            params2.extrasForIntent = params.extrasForIntent;
            params2.clickLocationParams = params.clickLocationParams;
            AdError show = AdHalfScreenDownload.getInstance().show(params2);
            if (params.reportForClick && show != null && show.isSuccess()) {
                if (activity != null) {
                    weakReference2 = new WeakReference(activity);
                }
                AdReporterForClick.reportAsync(weakReference2, params.f61334ad, getUrlForClick(params, new URLParams()), params.clickStartTimeMillis, 1);
            }
            return new Result(show, 14);
        }
        return new Result(4, 14);
    }

    @Nullable
    private static Result handleOlympicInterPage(@Nullable Params params) {
        if (params != null && params.isValid() && params.f61334ad.isOlympicInterPageType() && (params.f61334ad.isWXMINIProgramOrWXMINIGameProductType() || params.f61334ad.isWXCanvasAd())) {
            AdError showOlympicPage = AdInterPage.getInstance().showOlympicPage(params);
            if (showOlympicPage == null) {
                showOlympicPage = new AdError(1);
            }
            if (params.reportForClick && showOlympicPage.isSuccess()) {
                AdReporterForClick.reportAsync(new WeakReference(params.activity.get()), params.f61334ad, getUrlForClick(params, new URLParams()), params.clickStartTimeMillis, 2);
            }
            return new Result(showOlympicPage, 17);
        }
        return new Result(4, 17);
    }

    public static Result handleOlympicInterPageJump(@Nullable Params params) {
        if (params != null && params.isValid() && params.f61334ad.isOlympicInterPageType() && (params.f61334ad.isWXMINIProgramOrWXMINIGameProductType() || params.f61334ad.isWXCanvasAd())) {
            if (params.f61334ad.isWXMINIProgramOrWXMINIGameProductType()) {
                return handleWXMINIProgramOrWXMINIGameImpl(params);
            }
            if (params.f61334ad.isWXCanvasAd()) {
                return handleWXCanvasTypeImpl(params);
            }
            return null;
        }
        return new Result(4, 17);
    }

    @NonNull
    private static Result handleQQMINIProgramType(@Nullable Params params) {
        if (params != null && params.isValid() && params.f61334ad.isQQMINIProgram()) {
            AdQQMINIProgram.Params params2 = new AdQQMINIProgram.Params();
            params2.context = new WeakReference<>(params.activity.get());
            params2.f61321ad = params.f61334ad;
            params2.extrasForIntent = params.extrasForIntent;
            AdError show = AdQQMINIProgram.getInstance().show(params2);
            if (show != null && show.isSuccess() && params.reportForClick) {
                AdReporterForClick.reportAsync(new WeakReference(params.activity.get()), params.f61334ad, getUrlForClick(params, new URLParams()), params.clickStartTimeMillis, 1);
            }
            return new Result(show, 6);
        }
        return new Result(4, 0);
    }

    @NonNull
    private static Result handleQuickApp(@Nullable Params params) {
        int i3;
        int i16;
        AdError adError;
        if (params != null && params.isValid() && !TextUtils.isEmpty(params.f61334ad.getQuickAppDeeplink())) {
            AdReporterForEffect.reportAsync(new WeakReference(params.activity.get()), params.f61334ad, 326);
            link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
            reportBiz.deeplink_scene = 1;
            AdReporterForLinkEvent.getInstance().reportAsync(params.activity.get(), sdk_event_log.SdkEventDimension.EVENT_TRY_TO_OPEN_QUICK_APP, params.f61334ad, reportBiz, null);
            AdAnalysisHelperForUtil.reportForLaunchQuickAppStart(params);
            AdAppDeeplinkLauncher.Params params2 = new AdAppDeeplinkLauncher.Params();
            params2.deeplink = params.f61334ad.getQuickAppDeeplink();
            params2.extrasForIntent = params.extrasForIntent;
            params2.addflags = 268435456;
            AdAppDeeplinkLauncher.Result launch = AdAppDeeplinkLauncher.launch(params.activity.get(), params2);
            if (launch != null && launch.isSuccess() && params.reportForClick) {
                AdReporterForClick.reportAsync(new WeakReference(params.activity.get()), params.f61334ad, getUrlForClick(params, new URLParams()), params.clickStartTimeMillis, 1);
            }
            if (launch != null && launch.isSuccess()) {
                i3 = 327;
            } else {
                i3 = AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE;
            }
            AdReporterForEffect.reportAsync(new WeakReference(params.activity.get()), params.f61334ad, i3);
            if (launch != null && launch.isSuccess()) {
                i16 = sdk_event_log.SdkEventDimension.EVENT_OPEN_QUICK_APP_SUCCESS;
            } else {
                i16 = sdk_event_log.SdkEventDimension.EVENT_OPEN_QUICK_APP_FAILED;
            }
            link_report.LinkReport.ReportBiz reportBiz2 = new link_report.LinkReport.ReportBiz();
            reportBiz2.deeplink_scene = 1;
            AdReporterForLinkEvent.getInstance().reportAsync(params.activity.get(), i16, params.f61334ad, reportBiz2, null);
            if (launch != null) {
                adError = launch.getError();
            } else {
                adError = new AdError(1);
            }
            Result result = new Result(adError, 4);
            AdAnalysisHelperForUtil.reportForLaunchQuickAppEnd(params, result);
            return result;
        }
        AdLog.e(TAG, "handleQuickApp error");
        return new Result(4, 13);
    }

    @NonNull
    private static Result handleQuickAppProductType(@Nullable Params params) {
        if (params != null && params.isValid() && params.f61334ad.isQuickAppProductType()) {
            Result handleQuickApp = handleQuickApp(params);
            if (handleQuickApp != null && handleQuickApp.isSuccess()) {
                return handleQuickApp;
            }
            if (params.f61334ad.getDestType() == 4) {
                AdVideoCeiling.Params videoCeilingParams = getVideoCeilingParams(params);
                if (videoCeilingParams != null) {
                    return handleVideoCeiling(params, videoCeilingParams);
                }
                return handleUrl(params, getURLObject(params, new URLParams()));
            }
            AdLog.e(TAG, "handleQuickAppProductType error");
            return new Result(4, 0);
        }
        AdLog.e(TAG, "handleQuickAppProductType error");
        return new Result(4, 0);
    }

    @Nullable
    private static Result handleTripleLink(@Nullable Params params) {
        if (params != null && params.isValid() && params.f61334ad.isTripleLink()) {
            URLObject uRLObject = getURLObject(params, new URLParams());
            if (uRLObject != null && uRLObject.isValid()) {
                AdError show = AdTripleLink.getInstance().show(params, uRLObject);
                if (params.reportForClick && show != null && show.isSuccess() && uRLObject.type != 1) {
                    AdReporterForClick.reportAsync(new WeakReference(params.activity.get()), params.f61334ad, getUrlForClick(params, new URLParams()), params.clickStartTimeMillis, 1);
                }
                return new Result(show, 15);
            }
            AdLog.e(TAG, "handleTripleLink error");
            return new Result(4, 15);
        }
        return new Result(4, 15);
    }

    public static Result handleTripleLinkAfterWebViewLoaded(@Nullable Params params) {
        Result result;
        if (params != null && params.isValid() && params.f61334ad.isTripleLink()) {
            if (!TextUtils.isEmpty(params.f61334ad.getAppDeeplink(params.clickLocationParams))) {
                result = handleAppWithDeeplink(params, 1, false);
            } else {
                result = null;
            }
            if (result == null || !result.isSuccess()) {
                return handleWXMINIProgramOrWXMINIGame(params);
            }
            return result;
        }
        return new Result(4, 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static Result handleUrl(@Nullable Params params, @Nullable URLObject uRLObject) {
        if (params != null && params.isValid() && uRLObject != null && uRLObject.isValid()) {
            if (params.reportForClick && uRLObject.type != 1) {
                AdReporterForClick.reportAsync(new WeakReference(params.activity.get()), params.f61334ad, getUrlForClick(params, new URLParams()), params.clickStartTimeMillis, 1);
            }
            AdBrowser.Params browserParams = getBrowserParams(params, uRLObject);
            if (browserParams == null) {
                AdLog.e(TAG, "handleUrl error");
                return new Result(4, 1);
            }
            Result result = new Result(AdBrowser.getInstance().show(browserParams), 1);
            result.urlType = uRLObject.type;
            return result;
        }
        AdLog.e(TAG, "handleUrl error");
        return new Result(4, 1);
    }

    @NonNull
    private static Result handleVideoCeiling(@NonNull Params params, @Nullable AdVideoCeiling.Params params2) {
        if (params2 == null) {
            AdLog.e(TAG, "handleVideoCeiling error");
            return new Result(4, 2);
        }
        URLObject uRLObject = getURLObject(params, new URLParams());
        if (uRLObject != null && uRLObject.isValid()) {
            AdError show = AdVideoCeiling.getInstance().show(params2);
            if (params.reportForClick && show != null && show.isSuccess() && uRLObject.type != 1) {
                AdReporterForClick.reportAsync(new WeakReference(params.activity.get()), params.f61334ad, getUrlForClick(params, new URLParams()), params.clickStartTimeMillis, 1);
            }
            Result result = new Result(show, 2);
            result.urlType = uRLObject.type;
            return result;
        }
        AdLog.e(TAG, "handleVideoCeiling error");
        return new Result(4, 2);
    }

    @NonNull
    private static Result handleWXCanvasType(@Nullable Params params) {
        if (params != null && params.isValid() && params.f61334ad.isWXCanvasAd()) {
            if (params.f61334ad.isOlympicInterPageType()) {
                return handleOlympicInterPage(params);
            }
            return handleWXCanvasTypeImpl(params);
        }
        return new Result(4, 12);
    }

    private static Result handleWXCanvasTypeImpl(@Nullable Params params) {
        if (params != null && params.isValid() && params.f61334ad.isWXCanvasAd()) {
            AdLog.i(TAG, "[handleWXCanvasTypeImpl] start");
            AdWXCanvas.Params params2 = new AdWXCanvas.Params();
            params2.context = new WeakReference<>(params.activity.get());
            Ad ad5 = params.f61334ad;
            params2.f61349ad = ad5;
            params2.channelAppID = ad5.getWXChannelAppID();
            params2.extInfo = params.f61334ad.getWXCanvasExtInfo(params.clickLocationParams);
            params2.videoStartPositionMillis = params.videoStartPositionMillis;
            params2.reportForLinkEvent = true;
            AdError show = AdWXCanvas.getInstance().show(params2);
            if (show == null) {
                show = new AdError(1);
            }
            AdLog.i(TAG, "[handleWXCanvasTypeImpl] end, errorCode:" + show.getErrorCode());
            if (params.reportForClick && show.isSuccess()) {
                AdReporterForClick.reportAsync(new WeakReference(params.activity.get()), params.f61334ad, getUrlForClick(params, new URLParams()), params.clickStartTimeMillis, 1);
            }
            return new Result(show, 12);
        }
        return new Result(4, 12);
    }

    private static Result handleWXCustomerServiceType(@Nullable Params params) {
        if (params != null && params.isValid() && params.f61334ad.isWXCustomerService()) {
            AdWXCustomerService.Params params2 = new AdWXCustomerService.Params();
            params2.waekActivity = params.activity;
            params2.f61350ad = params.f61334ad;
            params2.extrasForIntent = params.extrasForIntent;
            AdError show = AdWXCustomerService.getInstance().show(params2);
            if (show != null && show.isSuccess() && params.reportForClick) {
                AdReporterForClick.reportAsync(new WeakReference(params.activity.get()), params.f61334ad, getUrlForClick(params, new URLParams()), params.clickStartTimeMillis, 1);
            }
            return new Result(show, 19);
        }
        return new Result(4, 19);
    }

    @Nullable
    private static Result handleWXMINIGameProductType(@Nullable Params params) {
        if (params != null && params.isValid() && params.f61334ad.isWXMINIGameProductType()) {
            if (params.f61334ad.getWXMINIGameJumpType() == 1) {
                return handleWXMINIProgramOrWXMINIGame(params);
            }
            if (params.f61334ad.getWXMINIGameJumpType() == 2) {
                AdVideoCeiling.Params videoCeilingParams = getVideoCeilingParams(params);
                if (videoCeilingParams != null) {
                    return handleVideoCeiling(params, videoCeilingParams);
                }
                return handleUrl(params, getURLObject(params, new URLParams()));
            }
            AdLog.e(TAG, "handleWXMINIGameProductType error, unknown jumpType");
            return handleWXMINIProgramOrWXMINIGame(params);
        }
        return new Result(4, 9);
    }

    private static Result handleWXMINIProgramOrWXMINIGame(@Nullable Params params) {
        if (params != null && params.isValid() && params.f61334ad.isWXMINIProgramOrWXMINIGameProductType()) {
            if (params.f61334ad.isOlympicInterPageType()) {
                return handleOlympicInterPage(params);
            }
            return handleWXMINIProgramOrWXMINIGameImpl(params);
        }
        return new Result(4, 9);
    }

    private static Result handleWXMINIProgramOrWXMINIGameImpl(@Nullable Params params) {
        if (params != null && params.isValid() && params.f61334ad.isWXMINIProgramOrWXMINIGameProductType()) {
            AdLog.i(TAG, "[handleWXMINIProgramOrWXMINIGameImpl] start");
            AdWXMINIProgram.Params params2 = new AdWXMINIProgram.Params();
            params2.weakActivity = params.activity;
            Ad ad5 = params.f61334ad;
            params2.f61351ad = ad5;
            params2.openType = ad5.getWXMINIProgramOpenType(params.clickLocationParams);
            params2.channelAppID = params.f61334ad.getWXChannelAppID();
            params2.token = params.f61334ad.getWXToken(params.clickLocationParams);
            params2.appID = params.f61334ad.getWXMINIProgramAppID(params.clickLocationParams);
            params2.userName = params.f61334ad.getWXMINIProgramUserName(params.clickLocationParams);
            params2.path = params.f61334ad.getWXMINIProgramPath(params.clickLocationParams);
            params2.traceData = params.f61334ad.getWXMINIProgramTraceData(params.clickLocationParams);
            params2.reportForLinkEvent = true;
            AdError show = AdWXMINIProgram.getInstance().show(params2);
            if (show == null) {
                show = new AdError(1);
            }
            AdLog.i(TAG, "[handleWXMINIProgramOrWXMINIGameImpl] end, errorCode:" + show);
            if (params.reportForClick && show.isSuccess()) {
                AdReporterForClick.reportAsync(new WeakReference(params.activity.get()), params.f61334ad, getUrlForClick(params, new URLParams()), params.clickStartTimeMillis, 2);
            }
            return new Result(show, 9);
        }
        return new Result(4, 9);
    }

    @Nullable
    private static Result handleWXMINIProgramWithDeeplink(@Nullable Params params) {
        Result result;
        if (params != null && params.isValid() && params.f61334ad.isWXMINIProgram()) {
            if (!TextUtils.isEmpty(params.f61334ad.getAppDeeplink(params.clickLocationParams))) {
                result = handleAppWithDeeplink(params, 2, false);
            } else {
                result = null;
            }
            if (result == null || !result.isSuccess()) {
                return handleWXMINIProgramOrWXMINIGame(params);
            }
            return result;
        }
        return new Result(4, 9);
    }

    @NonNull
    private static Result handleWebProductType(@Nullable Params params) {
        int i3;
        if (params != null && params.isValid() && isWebProductType(params) && isWebDestType(params)) {
            if (!TextUtils.isEmpty(params.f61334ad.getAppDeeplink(params.clickLocationParams))) {
                if (params.f61334ad.getDestType() == 0) {
                    i3 = 3;
                } else {
                    i3 = 2;
                }
                Result handleAppWithDeeplink = handleAppWithDeeplink(params, i3, false);
                if (handleAppWithDeeplink != null && handleAppWithDeeplink.isSuccess()) {
                    return handleAppWithDeeplink;
                }
            }
            AdVideoCeiling.Params videoCeilingParams = getVideoCeilingParams(params);
            if (videoCeilingParams != null) {
                return handleVideoCeiling(params, videoCeilingParams);
            }
            return handleUrl(params, getURLObject(params, new URLParams()));
        }
        AdLog.e(TAG, "handleWebProductType error");
        return new Result(4, 0);
    }

    private static boolean isWebDestType(@Nullable Params params) {
        if (params != null && params.isValid() && (params.f61334ad.getDestType() == 0 || params.f61334ad.getDestType() == 4 || params.f61334ad.getDestType() == 7)) {
            return true;
        }
        return false;
    }

    private static boolean isWebProductType(@Nullable Params params) {
        if (params != null && params.isValid() && (params.f61334ad.getProductType() == 25 || params.f61334ad.getProductType() == 26 || params.f61334ad.getProductType() == 30 || params.f61334ad.getProductType() == 37 || params.f61334ad.getProductType() == 41 || params.f61334ad.getProductType() == 1000)) {
            return true;
        }
        return false;
    }

    @NonNull
    private static String replaceUrlWithClickLpp(@Nullable String str, Params params, boolean z16) {
        int i3;
        if (!TextUtils.isEmpty(str) && params != null && params.isValid() && str.contains("__CLICK_LPP__")) {
            Boolean isWebProcessRunning = AdProcessManager.getInstance().isWebProcessRunning();
            int i16 = 0;
            if (isWebProcessRunning != null) {
                if (isWebProcessRunning.booleanValue()) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
            } else {
                i3 = 2;
            }
            Boolean isWebProcessRunningForPreloading = AdProcessManager.getInstance().isWebProcessRunningForPreloading();
            if (isWebProcessRunningForPreloading != null) {
                if (!isWebProcessRunningForPreloading.booleanValue()) {
                    i16 = 1;
                }
            } else {
                i16 = 2;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                long j3 = params.clickStartTimeMillis;
                if (j3 > 0) {
                    jSONObject.put(PerfTracer.PARAM_CLICK_TIME, j3);
                }
                if (!AdConfigManager.getInstance().canClickLppRemoveWebProcess()) {
                    jSONObject.put("toolsalive", i3);
                    jSONObject.put("preload", i16);
                }
                if (z16) {
                    jSONObject.put("withOuterVideo", 1);
                }
                String jSONObject2 = jSONObject.toString();
                if (!TextUtils.isEmpty(jSONObject2)) {
                    String encode = URLEncoder.encode(jSONObject2, "UTF-8");
                    if (!TextUtils.isEmpty(encode)) {
                        String replaceAll = str.replaceAll("__CLICK_LPP__", encode);
                        if (!TextUtils.isEmpty(replaceAll)) {
                            return replaceAll;
                        }
                        return str;
                    }
                    return str;
                }
                return str;
            } catch (Throwable th5) {
                AdLog.e(TAG, "replaceUrlWithClickLpp", th5);
                return str;
            }
        }
        return str;
    }

    @Nullable
    private static String replaceUrlWithViewId(String str, @Nullable Params params) {
        if (!TextUtils.isEmpty(str) && str.contains("__VIEW_ID__") && params != null && params.isValid()) {
            String viewId = params.f61334ad.getViewId(params.clickLocationParams);
            if (!TextUtils.isEmpty(viewId)) {
                String replaceAll = str.replaceAll("__VIEW_ID__", viewId);
                if (!TextUtils.isEmpty(replaceAll)) {
                    return replaceAll;
                }
            }
        }
        return str;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class URLObject {
        public static final int TYPE_CLICK_URL = 1;
        public static final int TYPE_LANDING_PAGE = 2;
        public static final int TYPE_UNKNOWN = 0;
        int type;

        @Nullable
        String url;

        public URLObject() {
            this.type = 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isValid() {
            if (!TextUtils.isEmpty(this.url) && this.type != 0) {
                return true;
            }
            return false;
        }

        public URLObject(URLObject uRLObject) {
            this.type = 0;
            if (uRLObject == null) {
                return;
            }
            this.url = uRLObject.url;
            this.type = uRLObject.type;
        }
    }

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public static class Result {
        public int action;
        private AdError error;
        public boolean errorHandled;
        public int urlType;

        public Result(Result result) {
            this.error = new AdError(1);
            this.action = 0;
            this.urlType = 0;
            this.errorHandled = false;
            if (result == null) {
                return;
            }
            this.error = result.error;
            this.action = result.action;
            this.urlType = result.urlType;
            this.errorHandled = result.errorHandled;
        }

        public int getErrorCode() {
            AdError adError = this.error;
            if (adError != null) {
                return adError.getErrorCode();
            }
            return 1;
        }

        public boolean isJumpOutType() {
            int i3 = this.action;
            if (i3 == 4 || i3 == 5 || i3 == 6 || i3 == 8 || i3 == 9 || i3 == 12 || i3 == 13 || i3 == 18) {
                return true;
            }
            return false;
        }

        public boolean isSuccess() {
            if (getErrorCode() == 0) {
                return true;
            }
            return false;
        }

        public Result(int i3, int i16) {
            this.error = new AdError(1);
            this.action = 0;
            this.urlType = 0;
            this.errorHandled = false;
            this.error = new AdError(i3);
            this.action = i16;
        }

        public Result(AdError adError, int i3) {
            new AdError(1);
            this.urlType = 0;
            this.errorHandled = false;
            this.error = adError;
            this.action = i3;
        }
    }
}
