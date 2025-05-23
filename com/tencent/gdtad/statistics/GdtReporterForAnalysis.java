package com.tencent.gdtad.statistics;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.analysis.AdAnalysisUtil;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.statistics.AdAnalysisHelper;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.c2s.GdtC2SReportInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtReporterForAnalysis {
    static /* bridge */ /* synthetic */ int a() {
        return c();
    }

    @NonNull
    private static gdt_analysis_event b(Context context, int i3, GdtAd gdtAd, int i16, int i17, String str) {
        String str2;
        Uri parse = AdUriUtil.parse(str);
        gdt_analysis_event createEventForAd = AdAnalysisHelper.createEventForAd(context, i3, gdtAd);
        if (i16 == 0) {
            createEventForAd.statisticsType = 101;
        } else if (i16 == 1) {
            createEventForAd.statisticsType = 102;
        } else if (i16 == 2) {
            createEventForAd.statisticsType = 105;
        }
        createEventForAd.businessId = String.valueOf(i17);
        if (parse != null) {
            str2 = parse.getHost();
        } else {
            str2 = null;
        }
        createEventForAd.hostName = str2;
        return createEventForAd;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v5 */
    private static int c() {
        ?? r26;
        boolean isNetSupport = AppNetConnInfo.isNetSupport();
        boolean isWifiConn = AppNetConnInfo.isWifiConn();
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            r26 = guardManager.isApplicationForeground();
        } else {
            r26 = 0;
        }
        int i3 = ((isNetSupport ? 1 : 0) << 0) | ((isWifiConn ? 1 : 0) << 1) | (r26 << 2);
        QLog.i("GdtReporterForAnalysis", 1, "[getValueOfPreloadState] isConnected:" + isNetSupport + " isWifiConnected:" + isWifiConn + " isApplicationForeground:" + ((boolean) r26) + " value:" + i3);
        return i3;
    }

    public static void d(final Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(0L, Integer.valueOf(gdt_analysis_event.EVENT_AFTER_LOGIN_AND_MESSAGE_LOADED));
        hashMap.put(5000L, Integer.valueOf(gdt_analysis_event.EVENT_AFTER_LOGIN_AND_MESSAGE_LOADED_5_SECONDS_DELAY));
        hashMap.put(10000L, Integer.valueOf(gdt_analysis_event.EVENT_AFTER_LOGIN_AND_MESSAGE_LOADED_10_SECONDS_DELAY));
        hashMap.put(15000L, Integer.valueOf(gdt_analysis_event.EVENT_AFTER_LOGIN_AND_MESSAGE_LOADED_15_SECONDS_DELAY));
        hashMap.put(20000L, Integer.valueOf(gdt_analysis_event.EVENT_AFTER_LOGIN_AND_MESSAGE_LOADED_20_SECONDS_DELAY));
        hashMap.put(Long.valueOf(s.G), Integer.valueOf(gdt_analysis_event.EVENT_AFTER_LOGIN_AND_MESSAGE_LOADED_25_SECONDS_DELAY));
        hashMap.put(30000L, Integer.valueOf(gdt_analysis_event.EVENT_AFTER_LOGIN_AND_MESSAGE_LOADED_30_SECONDS_DELAY));
        hashMap.put(60000L, Integer.valueOf(gdt_analysis_event.EVENT_AFTER_LOGIN_AND_MESSAGE_LOADED_60_SECONDS_DELAY));
        hashMap.put(90000L, Integer.valueOf(gdt_analysis_event.EVENT_AFTER_LOGIN_AND_MESSAGE_LOADED_90_SECONDS_DELAY));
        hashMap.put(120000L, Integer.valueOf(gdt_analysis_event.EVENT_AFTER_LOGIN_AND_MESSAGE_LOADED_120_SECONDS_DELAY));
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && entry.getKey() != null && entry.getKey() != null) {
                long longValue = ((Long) entry.getKey()).longValue();
                final int intValue = ((Integer) entry.getValue()).intValue();
                final WeakReference weakReference = new WeakReference(context);
                ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.gdtad.statistics.GdtReporterForAnalysis.1
                    @Override // java.lang.Runnable
                    public void run() {
                        gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
                        AdAnalysisUtil.initEvent(context, intValue, gdt_analysis_eventVar);
                        gdt_analysis_eventVar.status1 = GdtReporterForAnalysis.a();
                        AdAnalysis.getInstance().handleAsync(weakReference, new AdAnalysisEvent(gdt_analysis_eventVar, 102));
                    }
                }, 128, null, true, longValue);
            }
        }
    }

    public static void e(Context context, @NonNull GdtC2SReportInterface gdtC2SReportInterface, String str, int i3, long j3) {
        BaseApplication context2 = BaseApplication.getContext();
        gdt_analysis_event b16 = b(context2, 1057, new GdtAd(gdtC2SReportInterface.f109492g), gdtC2SReportInterface.f109490e, gdtC2SReportInterface.f109491f, str);
        b16.httpErrorCode = i3;
        if (i3 == 200) {
            b16.internalErrorCode = 0;
        } else if (i3 == -1) {
            b16.internalErrorCode = 3;
        } else {
            b16.internalErrorCode = 5;
        }
        b16.duration = j3;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context2), new AdAnalysisEvent(b16, 102));
    }

    public static void f(Context context, @NonNull GdtC2SReportInterface gdtC2SReportInterface, String str, int i3) {
        BaseApplication context2 = BaseApplication.getContext();
        gdt_analysis_event b16 = b(context2, 1060, new GdtAd(gdtC2SReportInterface.f109492g), gdtC2SReportInterface.f109490e, gdtC2SReportInterface.f109491f, str);
        b16.httpErrorCode = i3;
        if (i3 == 200) {
            b16.internalErrorCode = 0;
        } else if (i3 == -1) {
            b16.internalErrorCode = 3;
        } else {
            b16.internalErrorCode = 5;
        }
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context2), new AdAnalysisEvent(b16, 102));
    }

    public static void g(Context context, GdtAd gdtAd, int i3, int i16, boolean z16) {
        int i17;
        BaseApplication context2 = BaseApplication.getContext();
        gdt_analysis_event b16 = b(context2, 1058, gdtAd, i3, i16, null);
        if (z16) {
            i17 = 0;
        } else {
            i17 = 4;
        }
        b16.internalErrorCode = i17;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context2), new AdAnalysisEvent(b16, 102));
    }

    public static void h(Context context, @NonNull GdtC2SReportInterface gdtC2SReportInterface, String str) {
        BaseApplication context2 = BaseApplication.getContext();
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(context2), new AdAnalysisEvent(b(context2, 1056, new GdtAd(gdtC2SReportInterface.f109492g), gdtC2SReportInterface.f109490e, gdtC2SReportInterface.f109491f, str), 102));
    }
}
