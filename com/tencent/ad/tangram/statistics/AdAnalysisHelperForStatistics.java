package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.util.AdUriUtil;
import java.lang.ref.WeakReference;
import java.net.SocketTimeoutException;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdAnalysisHelperForStatistics {
    private static final String TAG = "AdAnalysisHelperForStatistics";

    @NonNull
    private static gdt_analysis_event createEventForStatistics(Context context, int i3, int i16, Ad ad5, String str) {
        String host;
        Uri parse = AdUriUtil.parse(str);
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(context, i3, ad5);
        createEventForAd.statisticsType = i16;
        if (parse != null) {
            try {
                host = parse.getHost();
            } catch (Throwable th5) {
                AdLog.e(TAG, "[createEventForStatistics]", th5);
            }
        } else {
            host = null;
        }
        createEventForAd.hostName = host;
        return createEventForAd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportForActionStatisticsEnd(Context context, Ad ad5, AdHttp.Params params) {
        reportForStatisticsEnd(context, 4, new int[]{200}, ad5, params);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportForActionStatisticsStart(Context context, Ad ad5, String str) {
        reportForStatisticsStart(context, 4, ad5, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportForClickStatisticsEnd(Context context, Ad ad5, AdHttp.Params params) {
        reportForStatisticsEnd(context, 2, new int[]{200, 302}, ad5, params);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportForClickStatisticsStart(Context context, Ad ad5, String str) {
        reportForStatisticsStart(context, 2, ad5, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportForEffectStatisticsEnd(Context context, Ad ad5, AdHttp.Params params) {
        reportForStatisticsEnd(context, 3, new int[]{200}, ad5, params);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportForEffectStatisticsStart(Context context, Ad ad5, String str) {
        reportForStatisticsStart(context, 3, ad5, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportForFeedbackStatisticsEnd(Context context, Ad ad5, AdHttp.Params params) {
        reportForStatisticsEnd(context, 7, new int[]{200}, ad5, params);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportForFeedbackStatisticsStart(Context context, Ad ad5, String str) {
        reportForStatisticsStart(context, 7, ad5, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportForSdkMsgStatisticsEnd(Context context, Ad ad5, AdHttp.Params params) {
        reportForStatisticsEnd(context, 6, new int[]{200}, ad5, params);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportForSdkMsgStatisticsStart(Context context, Ad ad5, String str) {
        reportForStatisticsStart(context, 6, ad5, str);
    }

    private static void reportForStatisticsEnd(Context context, int i3, @Nullable int[] iArr, Ad ad5, @Nullable AdHttp.Params params) {
        int i16;
        String str;
        if (iArr != null && iArr.length > 0) {
            if (params != null && params.canSend()) {
                int length = iArr.length;
                i16 = 0;
                int i17 = 0;
                while (true) {
                    if (i17 < length) {
                        if (iArr[i17] == params.responseCode) {
                            break;
                        } else {
                            i17++;
                        }
                    } else {
                        i16 = 1;
                        break;
                    }
                }
                if (i16 != 0) {
                    if (params.responseCode != Integer.MIN_VALUE) {
                        i16 = 5;
                    } else if (params.throwable instanceof SocketTimeoutException) {
                        i16 = 13;
                    } else {
                        i16 = 3;
                    }
                }
            } else {
                i16 = 4;
            }
            if (params != null) {
                str = params.getUrl();
            } else {
                str = null;
            }
            gdt_analysis_event createEventForStatistics = createEventForStatistics(context, 1057, i3, ad5, str);
            if (params != null) {
                createEventForStatistics.duration = params.durationMillis;
                createEventForStatistics.httpErrorCode = params.responseCode;
                createEventForStatistics.internalErrorCode = i16;
                createEventForStatistics.errorCode1 = !AdNet.isNetValid(context) ? 1 : 0;
            }
            AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForStatistics, 102));
            return;
        }
        AdLog.e(TAG, "reportForStatisticsEnd error");
    }

    private static void reportForStatisticsStart(Context context, int i3, Ad ad5, String str) {
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), new AdAnalysisEvent(createEventForStatistics(context, 1056, i3, ad5, str), 102));
    }
}
