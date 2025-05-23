package com.tencent.gdtad.api.interstitial;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.analysis.AdAnalysisUtil;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.statistics.AdAnalysisHelper;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtAnalysisHelperForInterstitial {
    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x002a  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static gdt_analysis_event createEventForInterstitial(Context context, int i3, @Nullable GdtInterstitialParams gdtInterstitialParams, @Nullable GdtInterstitialStatus gdtInterstitialStatus) {
        int i16;
        GdtAd gdtAd;
        int i17;
        long j3;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        GdtHandler.Options options;
        int i29 = 0;
        int i36 = Integer.MIN_VALUE;
        if (gdtInterstitialParams != null) {
            int i37 = gdtInterstitialParams.orientation;
            if (i37 == 1) {
                i16 = 0;
            } else if (i37 == 0) {
                i16 = 1;
            } else if (i37 == 8) {
                i16 = 2;
            }
            if (gdtInterstitialParams == null && (options = gdtInterstitialParams.clickOptions) != null) {
                gdtAd = options.f108486ad;
            } else {
                gdtAd = null;
            }
            gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(context, i3, gdtAd);
            if (gdtInterstitialStatus == null) {
                i17 = gdtInterstitialStatus.activityStatus;
            } else {
                i17 = Integer.MIN_VALUE;
            }
            createEventForAd.activityStatus = i17;
            if (gdtInterstitialStatus == null) {
                j3 = gdtInterstitialStatus.getDurationBetweenStartAndNow();
            } else {
                j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            }
            createEventForAd.duration = j3;
            createEventForAd.orientation = i16;
            if (gdtInterstitialStatus == null) {
                i18 = gdtInterstitialStatus.closeReason;
            } else {
                i18 = Integer.MIN_VALUE;
            }
            createEventForAd.reason = i18;
            if (gdtInterstitialStatus == null && gdtInterstitialStatus.arkAppDownloaded) {
                i19 = 1;
            } else {
                i19 = 0;
            }
            createEventForAd.status1 = i19;
            if (gdtInterstitialStatus == null && gdtInterstitialStatus.jsCoreDownloaded) {
                i26 = 1;
            } else {
                i26 = 0;
            }
            createEventForAd.status2 = i26;
            if (gdtInterstitialStatus == null && gdtInterstitialStatus.arkViewLoaded) {
                i27 = 1;
            } else {
                i27 = 0;
            }
            createEventForAd.status3 = i27;
            if (gdtInterstitialStatus == null && gdtInterstitialStatus.arkScriptLoaded) {
                i28 = 1;
            } else {
                i28 = 0;
            }
            createEventForAd.status4 = i28;
            if (gdtInterstitialStatus != null && gdtInterstitialStatus.exposed) {
                i29 = 1;
            }
            createEventForAd.status5 = i29;
            if (gdtInterstitialStatus != null) {
                i36 = gdtInterstitialStatus.videoStatus;
            }
            createEventForAd.videoStatus = i36;
            return createEventForAd;
        }
        i16 = Integer.MIN_VALUE;
        if (gdtInterstitialParams == null) {
        }
        gdtAd = null;
        gdt_analysis_event createEventForAd2 = AdAnalysisHelper.createEventForAd(context, i3, gdtAd);
        if (gdtInterstitialStatus == null) {
        }
        createEventForAd2.activityStatus = i17;
        if (gdtInterstitialStatus == null) {
        }
        createEventForAd2.duration = j3;
        createEventForAd2.orientation = i16;
        if (gdtInterstitialStatus == null) {
        }
        createEventForAd2.reason = i18;
        if (gdtInterstitialStatus == null) {
        }
        i19 = 0;
        createEventForAd2.status1 = i19;
        if (gdtInterstitialStatus == null) {
        }
        i26 = 0;
        createEventForAd2.status2 = i26;
        if (gdtInterstitialStatus == null) {
        }
        i27 = 0;
        createEventForAd2.status3 = i27;
        if (gdtInterstitialStatus == null) {
        }
        i28 = 0;
        createEventForAd2.status4 = i28;
        if (gdtInterstitialStatus != null) {
            i29 = 1;
        }
        createEventForAd2.status5 = i29;
        if (gdtInterstitialStatus != null) {
        }
        createEventForAd2.videoStatus = i36;
        return createEventForAd2;
    }

    public static void reportForInterstitialReceiveNotification(Context context, GdtInterstitialParams gdtInterstitialParams, GdtInterstitialStatus gdtInterstitialStatus, String str, String str2) {
        gdt_analysis_event createEventForInterstitial = createEventForInterstitial(context, 1071, gdtInterstitialParams, gdtInterstitialStatus);
        createEventForInterstitial.api = str;
        createEventForInterstitial.hostName = str2;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForInterstitial, 102));
    }

    public static void reportForInterstitialSendNotification(Context context, GdtInterstitialParams gdtInterstitialParams, GdtInterstitialStatus gdtInterstitialStatus, String str, String str2) {
        gdt_analysis_event createEventForInterstitial = createEventForInterstitial(context, 1072, gdtInterstitialParams, gdtInterstitialStatus);
        createEventForInterstitial.api = str;
        createEventForInterstitial.hostName = str2;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForInterstitial, 102));
    }

    public static void reportForPreDownloadInterstitialEnd(Context context, long j3, int i3, int i16) {
        gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
        AdAnalysisUtil.initEvent(context, 1082, gdt_analysis_eventVar);
        long j16 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        if (j3 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            j16 = System.currentTimeMillis() - j3;
        }
        gdt_analysis_eventVar.duration = j16;
        gdt_analysis_eventVar.internalErrorCode = i3;
        gdt_analysis_eventVar.errorCode1 = i16;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(gdt_analysis_eventVar, 102));
    }

    public static void reportForPreDownloadInterstitialStart(Context context) {
        gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
        AdAnalysisUtil.initEvent(context, 1081, gdt_analysis_eventVar);
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(gdt_analysis_eventVar, 102));
    }

    public static void reportFortCloseInterstitialStart(Context context, GdtInterstitialParams gdtInterstitialParams, @Nullable GdtInterstitialStatus gdtInterstitialStatus) {
        int i3;
        int i16;
        gdt_analysis_event createEventForInterstitial = createEventForInterstitial(context, 1092, gdtInterstitialParams, gdtInterstitialStatus);
        int i17 = Integer.MIN_VALUE;
        if (gdtInterstitialStatus != null) {
            i3 = gdtInterstitialStatus.closeError;
        } else {
            i3 = Integer.MIN_VALUE;
        }
        createEventForInterstitial.internalErrorCode = i3;
        if (gdtInterstitialStatus != null) {
            i16 = gdtInterstitialStatus.closeErrorForArk;
        } else {
            i16 = Integer.MIN_VALUE;
        }
        createEventForInterstitial.errorCode1 = i16;
        if (gdtInterstitialStatus != null) {
            i17 = gdtInterstitialStatus.closeErrorForArkScript;
        }
        createEventForInterstitial.errorCode2 = i17;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForInterstitial, 102));
    }

    public static void reportFortShowInterstitialCreated(Context context, GdtInterstitialParams gdtInterstitialParams, GdtInterstitialStatus gdtInterstitialStatus, int i3) {
        gdt_analysis_event createEventForInterstitial = createEventForInterstitial(context, 1085, gdtInterstitialParams, gdtInterstitialStatus);
        createEventForInterstitial.internalErrorCode = i3;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForInterstitial, 102));
    }

    public static void reportFortShowInterstitialImpression(Context context, GdtInterstitialParams gdtInterstitialParams, GdtInterstitialStatus gdtInterstitialStatus) {
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForInterstitial(context, 1089, gdtInterstitialParams, gdtInterstitialStatus), 102));
    }

    public static void reportFortShowInterstitialLoadArkScript(Context context, GdtInterstitialParams gdtInterstitialParams, GdtInterstitialStatus gdtInterstitialStatus) {
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForInterstitial(context, 1088, gdtInterstitialParams, gdtInterstitialStatus), 102));
    }

    public static void reportFortShowInterstitialLoadArkViewEnd(Context context, GdtInterstitialParams gdtInterstitialParams, GdtInterstitialStatus gdtInterstitialStatus, int i3, int i16) {
        gdt_analysis_event createEventForInterstitial = createEventForInterstitial(context, 1087, gdtInterstitialParams, gdtInterstitialStatus);
        createEventForInterstitial.internalErrorCode = i3;
        createEventForInterstitial.errorCode1 = i16;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForInterstitial, 102));
    }

    public static void reportFortShowInterstitialLoadArkViewStart(Context context, GdtInterstitialParams gdtInterstitialParams, GdtInterstitialStatus gdtInterstitialStatus) {
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForInterstitial(context, 1086, gdtInterstitialParams, gdtInterstitialStatus), 102));
    }

    public static void reportFortShowInterstitialStart(Context context, GdtInterstitialParams gdtInterstitialParams, int i3) {
        GdtAd gdtAd;
        int i16;
        GdtHandler.Options options;
        if (gdtInterstitialParams != null && (options = gdtInterstitialParams.clickOptions) != null) {
            gdtAd = options.f108486ad;
        } else {
            gdtAd = null;
        }
        boolean z16 = false;
        if (gdtAd != null && !TextUtils.isEmpty(gdtAd.getExtJSON())) {
            z16 = true;
        }
        if (z16) {
            i16 = 102;
        } else {
            i16 = 103;
        }
        gdt_analysis_event createEventForInterstitial = createEventForInterstitial(context, 1084, gdtInterstitialParams, null);
        createEventForInterstitial.internalErrorCode = i3;
        createEventForInterstitial.androidFromProcessName = AdProcessManager.getInstance().getCurrentProcessName(context);
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForInterstitial, i16));
    }
}
