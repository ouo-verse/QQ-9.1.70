package com.tencent.ad.tangram.statistics;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.analysis.AdAnalysisUtil;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.ad.tangram.util.AdUriUtil;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdAnalysisHelperForUtil {
    private static final String TAG = "AdAnalysisHelperForUtil";

    @NonNull
    public static AdAnalysisEvent createEventForAidTicket(Context context, int i3, int i16, long j3) {
        gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
        AdAnalysisUtil.initEvent(context, 1049, gdt_analysis_eventVar);
        gdt_analysis_eventVar.internalErrorCode = i3;
        gdt_analysis_eventVar.errorCode1 = i16;
        gdt_analysis_eventVar.duration = j3;
        return new AdAnalysisEvent(gdt_analysis_eventVar, 102);
    }

    @NonNull
    public static AdAnalysisEvent createEventForDeviceIdentifier(Context context, int i3, int i16, long j3, int i17) {
        gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
        AdAnalysisUtil.initEvent(context, i3, gdt_analysis_eventVar);
        gdt_analysis_eventVar.internalErrorCode = i16;
        gdt_analysis_eventVar.duration = j3;
        gdt_analysis_eventVar.cached = i17;
        return new AdAnalysisEvent(gdt_analysis_eventVar, 102);
    }

    @NonNull
    public static AdAnalysisEvent createEventForDeviceInfoEnd(Context context, long j3) {
        gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
        AdAnalysisUtil.initEvent(context, 1037, gdt_analysis_eventVar);
        gdt_analysis_eventVar.duration = j3;
        gdt_analysis_eventVar.ipType = AdNet.getIpFamily(context);
        return new AdAnalysisEvent(gdt_analysis_eventVar, 102);
    }

    @NonNull
    private static gdt_analysis_event createEventForLaunchAppWithDeepLink(Context context, int i3, @Nullable Ad ad5, boolean z16) {
        String str;
        if (ad5 != null) {
            str = ad5.getAppPackageName();
        } else {
            str = null;
        }
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(context, i3, ad5);
        if (TextUtils.isEmpty(str)) {
            createEventForAd.androidAppInstalled = 2;
        } else {
            createEventForAd.androidAppInstalled = AdAppUtil.isInstalled(context, str) ? 1 : 0;
        }
        createEventForAd.androidDeeplinkDelayed = z16 ? 1 : 0;
        return createEventForAd;
    }

    @NonNull
    public static AdAnalysisEvent createEventForLocation(Context context, boolean z16, long j3, long j16) {
        gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
        AdAnalysisUtil.initEvent(context, 1038, gdt_analysis_eventVar);
        gdt_analysis_eventVar.internalErrorCode = !z16 ? 1 : 0;
        gdt_analysis_eventVar.duration = j3;
        if (z16) {
            gdt_analysis_eventVar.interval = j16;
        }
        return new AdAnalysisEvent(gdt_analysis_eventVar, 102);
    }

    public static AdAnalysisEvent createEventForQuickApp(Context context, Boolean bool) {
        int i3;
        gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
        AdAnalysisUtil.initEvent(context, 1159, gdt_analysis_eventVar);
        if (bool != null) {
            i3 = !bool.booleanValue() ? 1 : 0;
        } else {
            i3 = 106;
        }
        gdt_analysis_eventVar.internalErrorCode = i3;
        return new AdAnalysisEvent(gdt_analysis_eventVar, 102);
    }

    @NonNull
    public static AdAnalysisEvent createEventForTaidTicket(Context context, int i3, int i16, long j3) {
        gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
        AdAnalysisUtil.initEvent(context, 1050, gdt_analysis_eventVar);
        gdt_analysis_eventVar.internalErrorCode = i3;
        gdt_analysis_eventVar.errorCode1 = i16;
        gdt_analysis_eventVar.duration = j3;
        return new AdAnalysisEvent(gdt_analysis_eventVar, 102);
    }

    public static void reportForAPIInvoked(Context context, boolean z16, String str, Ad ad5) {
        int i3 = z16 ? 102 : 103;
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(context, 1051, ad5);
        createEventForAd.api = str;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForAd, i3));
    }

    public static void reportForARKReceiveNotification(Context context, boolean z16, String str, String str2, Ad ad5) {
        int i3;
        if (z16) {
            i3 = 102;
        } else {
            i3 = 103;
        }
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(context, 1071, ad5);
        createEventForAd.api = str;
        createEventForAd.hostName = str2;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForAd, i3));
    }

    public static void reportForARKSendNotification(Context context, boolean z16, String str, String str2, Ad ad5) {
        int i3;
        if (z16) {
            i3 = 102;
        } else {
            i3 = 103;
        }
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(context, 1072, ad5);
        createEventForAd.api = str;
        createEventForAd.hostName = str2;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForAd, i3));
    }

    public static void reportForBanner(Context context, Ad ad5) {
        int i3;
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(context, 1054, ad5);
        boolean z16 = false;
        if (ad5 != null && !TextUtils.isEmpty(ad5.getExtJSON())) {
            z16 = true;
        }
        if (z16) {
            i3 = 102;
        } else {
            i3 = 103;
        }
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForAd, i3));
    }

    public static void reportForClickEnd(@Nullable AdClickUtil.Params params, @Nullable AdClickUtil.Result result) {
        Activity activity;
        int i3;
        int i16;
        int i17;
        WeakReference<Activity> weakReference;
        Ad ad5 = null;
        if (params != null && (weakReference = params.activity) != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (params != null) {
            ad5 = params.f61334ad;
        }
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(activity, 1017, ad5);
        int i18 = 1;
        if (result != null) {
            i3 = result.getErrorCode();
        } else {
            i3 = 1;
        }
        createEventForAd.internalErrorCode = i3;
        if (result != null) {
            i16 = result.action;
        } else {
            i16 = 0;
        }
        createEventForAd.actionId = i16;
        if (result == null || !result.errorHandled) {
            i18 = 0;
        }
        createEventForAd.errorHandled = i18;
        if (result != null) {
            i17 = result.urlType;
        } else {
            i17 = Integer.MIN_VALUE;
        }
        createEventForAd.urlType = i17;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(activity), new AdAnalysisEvent(createEventForAd, 103));
    }

    public static void reportForClickStart(@Nullable AdClickUtil.Params params) {
        Activity activity;
        WeakReference<Activity> weakReference;
        Ad ad5 = null;
        if (params != null && (weakReference = params.activity) != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (params != null) {
            ad5 = params.f61334ad;
        }
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(activity), new AdAnalysisEvent(AdAnalysisHelper.createEventForAd(activity, 1016, ad5), 103));
    }

    public static void reportForExposureApiInvoked(Context context, Ad ad5) {
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(AdAnalysisHelper.createEventForAd(context, 1103, ad5), 102));
    }

    public static void reportForExposureCallback(Context context, Ad ad5, int i3) {
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(context, 1104, ad5);
        createEventForAd.isSupplement = i3;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForAd, 102));
    }

    public static void reportForHippyAPIInvoked(Context context, boolean z16, String str, String str2) {
        int i3;
        if (z16) {
            i3 = 102;
        } else {
            i3 = 103;
        }
        gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
        AdAnalysisUtil.initEvent(context, 1300, gdt_analysis_eventVar);
        gdt_analysis_eventVar.api = str;
        gdt_analysis_eventVar.posId = str2;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(gdt_analysis_eventVar, i3));
    }

    public static void reportForJSBridgeInvoked(Context context, boolean z16, String str, String str2) {
        Uri parse = AdUriUtil.parse(str2);
        int i3 = z16 ? 102 : 103;
        gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
        AdAnalysisUtil.initEvent(context, 1052, gdt_analysis_eventVar);
        gdt_analysis_eventVar.api = str;
        gdt_analysis_eventVar.url = str2;
        gdt_analysis_eventVar.hostName = parse != null ? parse.getHost() : null;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(gdt_analysis_eventVar, i3));
    }

    public static void reportForLaunchAppMarket(@Nullable AdClickUtil.Params params, @Nullable AdClickUtil.Result result, String str, String str2) {
        Activity activity;
        Ad ad5;
        int i3;
        Ad ad6;
        WeakReference<Activity> weakReference;
        String str3 = null;
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
        if (result != null) {
            i3 = result.getErrorCode();
        } else {
            i3 = 1;
        }
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(activity, 1061, ad5);
        createEventForAd.androidActivityName = str;
        createEventForAd.androidAppMarketPackageName = str2;
        if (params != null && (ad6 = params.f61334ad) != null) {
            str3 = ad6.getAppPackageName();
        }
        createEventForAd.androidPackageName = str3;
        createEventForAd.internalErrorCode = i3;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(activity), new AdAnalysisEvent(createEventForAd, 103));
    }

    public static void reportForLaunchAppWithDeepLinkEND(@Nullable AdClickUtil.Params params, @Nullable AdClickUtil.Result result, boolean z16) {
        Activity activity;
        int i3;
        int i16;
        WeakReference<Activity> weakReference;
        Ad ad5 = null;
        if (params != null && (weakReference = params.activity) != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (params != null) {
            ad5 = params.f61334ad;
        }
        if (result != null) {
            i3 = result.getErrorCode();
        } else {
            i3 = 1;
        }
        if (i3 == 0) {
            i16 = 1004;
        } else {
            i16 = 1005;
        }
        gdt_analysis_event createEventForLaunchAppWithDeepLink = createEventForLaunchAppWithDeepLink(activity, i16, ad5, z16);
        createEventForLaunchAppWithDeepLink.internalErrorCode = i3;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(activity), new AdAnalysisEvent(createEventForLaunchAppWithDeepLink, 103));
    }

    public static void reportForLaunchAppWithDeepLinkStart(@Nullable AdClickUtil.Params params, boolean z16) {
        Activity activity;
        WeakReference<Activity> weakReference;
        Ad ad5 = null;
        if (params != null && (weakReference = params.activity) != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (params != null) {
            ad5 = params.f61334ad;
        }
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(activity), new AdAnalysisEvent(createEventForLaunchAppWithDeepLink(activity, 1003, ad5, z16), 103));
    }

    public static void reportForLaunchQQMINIProgramEND(Context context, Ad ad5, boolean z16) {
        int i3;
        if (z16) {
            i3 = 1014;
        } else {
            i3 = 1015;
        }
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(AdAnalysisHelper.createEventForAd(context, i3, ad5), 103));
    }

    public static void reportForLaunchQQMINIProgramStart(Context context, Ad ad5) {
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(AdAnalysisHelper.createEventForAd(context, 1013, ad5), 103));
    }

    public static void reportForLaunchQuickAppEnd(@Nullable AdClickUtil.Params params, @Nullable AdClickUtil.Result result) {
        Activity activity;
        int i3;
        int i16;
        WeakReference<Activity> weakReference;
        Ad ad5 = null;
        if (params != null && (weakReference = params.activity) != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (params != null) {
            ad5 = params.f61334ad;
        }
        if (result != null) {
            i3 = result.getErrorCode();
        } else {
            i3 = 1;
        }
        if (i3 == 0) {
            i16 = 1212;
        } else {
            i16 = 1213;
        }
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(activity, i16, ad5);
        createEventForAd.internalErrorCode = i3;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(activity), new AdAnalysisEvent(createEventForAd, 103));
    }

    public static void reportForLaunchQuickAppStart(@Nullable AdClickUtil.Params params) {
        Activity activity;
        WeakReference<Activity> weakReference;
        Ad ad5 = null;
        if (params != null && (weakReference = params.activity) != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (params != null) {
            ad5 = params.f61334ad;
        }
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(activity), new AdAnalysisEvent(AdAnalysisHelper.createEventForAd(activity, 1211, ad5), 103));
    }

    public static void reportForLoadAd(Context context, String str) {
        gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
        AdAnalysisUtil.initEvent(context, 1053, gdt_analysis_eventVar);
        gdt_analysis_eventVar.posId = str;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(gdt_analysis_eventVar, 102));
    }

    public static void reportForPreload(Context context, Ad ad5) {
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(AdAnalysisHelper.createEventForAd(context, 1105, ad5), 102));
    }

    public static void reportForRewardedVideo(Context context, Ad ad5) {
        int i3;
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(context, 1055, ad5);
        boolean z16 = false;
        if (ad5 != null && !TextUtils.isEmpty(ad5.getExtJSON())) {
            z16 = true;
        }
        if (z16) {
            i3 = 102;
        } else {
            i3 = 103;
        }
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForAd, i3));
    }

    public static void reportForAPIInvoked(Context context, boolean z16, String str, String str2) {
        Uri parse = AdUriUtil.parse(str2);
        int i3 = z16 ? 102 : 103;
        gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
        AdAnalysisUtil.initEvent(context, 1051, gdt_analysis_eventVar);
        gdt_analysis_eventVar.api = str;
        gdt_analysis_eventVar.posId = parse != null ? AdUriUtil.getQueryParameter(parse, "pid") : null;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(gdt_analysis_eventVar, i3));
    }

    public static void reportForJSBridgeInvoked(Context context, boolean z16, String str, String str2, Ad ad5) {
        Uri parse = AdUriUtil.parse(str2);
        int i3 = z16 ? 102 : 103;
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(context, 1052, ad5);
        createEventForAd.api = str;
        createEventForAd.url = str2;
        createEventForAd.hostName = parse != null ? parse.getHost() : null;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForAd, i3));
    }

    public static void reportForJSBridgeInvoked(Context context, boolean z16, String str, String str2, String str3) {
        Uri parse = AdUriUtil.parse(str2);
        Uri parse2 = AdUriUtil.parse(str3);
        int i3 = z16 ? 102 : 103;
        gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
        AdAnalysisUtil.initEvent(context, 1052, gdt_analysis_eventVar);
        gdt_analysis_eventVar.api = str;
        gdt_analysis_eventVar.url = str2;
        gdt_analysis_eventVar.posId = parse2 != null ? AdUriUtil.getQueryParameter(parse2, "pid") : null;
        gdt_analysis_eventVar.hostName = parse != null ? parse.getHost() : null;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(gdt_analysis_eventVar, i3));
    }

    public static void reportForJSBridgeInvoked(Context context, boolean z16, String str, String str2, Ad ad5, long j3) {
        Uri parse = AdUriUtil.parse(str2);
        int i3 = z16 ? 102 : 103;
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(context, 1052, ad5);
        createEventForAd.api = str;
        createEventForAd.url = str2;
        createEventForAd.hostName = parse != null ? parse.getHost() : null;
        createEventForAd.duration = j3;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForAd, i3));
    }
}
