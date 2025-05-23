package com.tencent.gdtad.splash.statistics;

import android.text.TextUtils;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.tg.TangramReportUtil;
import com.qq.e.tg.splash.TGSplashAD;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.splash.GdtSplashDeviceInfoUtil;
import com.tencent.gdtad.splash.mcconfig.GdtSplashAdSwitchConfigParser;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtSplashReporterUtil {
    private static int b(long j3) {
        if (j3 <= 0) {
            return Integer.MIN_VALUE;
        }
        if (j3 <= 43200000) {
            return 1;
        }
        if (j3 <= 86400000) {
            return 2;
        }
        if (j3 <= 172800000) {
            return 3;
        }
        if (j3 <= 259200000) {
            return 4;
        }
        if (j3 <= QzoneConfig.DefaultValue.DEFAULT_OTHERENTITY_DELEATE_INTERVAL_TIME) {
            return 5;
        }
        return 6;
    }

    public static void c(final String str, final boolean z16, final boolean z17) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.gdtad.splash.statistics.GdtSplashReporterUtil.1
            @Override // java.lang.Runnable
            public void run() {
                GdtSplashReporterUtil.d(str, z16, z17);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, boolean z16, boolean z17) {
        GdtSplashAdSwitchConfigParser.a b16 = com.tencent.gdtad.splash.mcconfig.a.b();
        if (b16 == null) {
            b16 = new GdtSplashAdSwitchConfigParser.a();
        }
        boolean a16 = com.tencent.gdtad.splash.mcconfig.c.a();
        if (z16) {
            if (a16 && b16.f109391h) {
                a16 = true;
            } else {
                a16 = false;
            }
        }
        QLog.i("GdtSplashReporterUtil", 1, "[reportEmptyOrderIfNecessaryAndPreFetchAdImpl] GdtSplashSwitchConfig.canReportForEmptyOrder():" + com.tencent.gdtad.splash.mcconfig.c.a() + " hasValidOrder:" + z16 + " isReportHasVaildOrder:" + b16.f109391h + " emptyOrderReportEnabled:" + a16 + " urlForEmptyOrder:" + str);
        GdtSplashDeviceInfoUtil.e();
        TGSplashAD.FetchAdParams fetchAdParams = new TGSplashAD.FetchAdParams();
        if (!a16) {
            str = null;
        }
        fetchAdParams.emptyOrderApUrl = str;
        TGSplashAD tGSplashAD = new TGSplashAD(BaseApplication.getContext(), "1109803375", "9065538021425253", null);
        LoadAdParams loadAdParams = new LoadAdParams();
        loadAdParams.setHotStart(z17);
        tGSplashAD.setLoadAdParams(loadAdParams);
        tGSplashAD.reportEmptyOrderIfNecessaryAndPreFetchAd(fetchAdParams);
        if (a16) {
            com.tencent.gdtad.splash.mcconfig.c.c();
        }
    }

    public static void e(final b bVar) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.gdtad.splash.statistics.GdtSplashReporterUtil.3
            @Override // java.lang.Runnable
            public void run() {
                GdtSplashReporterUtil.g(b.this);
            }
        }, 128, null, true);
    }

    public static void f(List<b> list) {
        final ArrayList arrayList = new ArrayList(list);
        if (arrayList.isEmpty()) {
            QLog.i("GdtSplashReporterUtil", 1, "[reportForAnalysis] do nothing, eventList is empty");
            return;
        }
        QLog.i("GdtSplashReporterUtil", 1, "[reportForAnalysis] count:" + arrayList.size());
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.gdtad.splash.statistics.GdtSplashReporterUtil.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    GdtSplashReporterUtil.g((b) it.next());
                }
            }
        }, 128, null, true);
    }

    public static void g(b bVar) {
        ConcurrentHashMap concurrentHashMap;
        if (bVar == null) {
            QLog.e("GdtSplashReporterUtil", 1, "[reportForAnalysisImpl] do nothing, event is null");
            return;
        }
        int d16 = bVar.d();
        int g16 = bVar.g();
        if (g16 == Integer.MIN_VALUE) {
            g16 = 0;
        }
        int i3 = g16;
        int c16 = bVar.c();
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        long b16 = bVar.b();
        int b17 = b(bVar.e());
        if (b16 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            concurrentHashMap2.put("cost_time", Long.valueOf(b16));
        }
        if (b17 != Integer.MIN_VALUE) {
            concurrentHashMap2.put("httpErrorCode", Integer.valueOf(b17));
        }
        if (c16 != Integer.MIN_VALUE) {
            concurrentHashMap2.put("error_code", Integer.valueOf(c16));
        }
        int f16 = bVar.f();
        if (f16 != Integer.MIN_VALUE) {
            concurrentHashMap2.put("subErrorCode", Integer.valueOf(f16));
        }
        if (!concurrentHashMap2.isEmpty()) {
            concurrentHashMap = concurrentHashMap2;
        } else {
            concurrentHashMap = null;
        }
        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
        String a16 = bVar.a();
        concurrentHashMap3.put("pid", "9065538021425253");
        if (!TextUtils.isEmpty(a16)) {
            concurrentHashMap3.put("aid", a16);
        }
        try {
            String str = "[reportForAnalysisImpl] eventId:" + d16 + " value:" + i3 + " devMap:" + concurrentHashMap + " bizMap:" + concurrentHashMap3;
            if (QLog.isColorLevel()) {
                QLog.i("GdtSplashReporterUtil", 2, str);
            }
        } catch (Throwable th5) {
            QLog.e("GdtSplashReporterUtil", 1, "[reportForAnalysisImpl]", th5);
        }
        TangramReportUtil.report(BaseApplication.getContext(), "1109803375", d16, i3, concurrentHashMap3, concurrentHashMap);
    }
}
