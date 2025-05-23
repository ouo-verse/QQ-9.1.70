package com.tencent.gdtad.splash.statistics;

import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.splash.p;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public final class GdtSplashReporterForPreloader {

    /* renamed from: a, reason: collision with root package name */
    private volatile long f109411a = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

    /* renamed from: b, reason: collision with root package name */
    private volatile long f109412b = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

    static /* bridge */ /* synthetic */ int a() {
        return e();
    }

    public static void b() {
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
                ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.gdtad.splash.statistics.GdtSplashReporterForPreloader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b bVar = new b(intValue);
                        bVar.k(GdtSplashReporterForPreloader.a());
                        GdtSplashReporterUtil.e(bVar);
                    }
                }, 128, null, true, longValue);
            }
        }
    }

    private long c() {
        if (this.f109411a == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        return System.currentTimeMillis() - this.f109411a;
    }

    private long d() {
        if (this.f109412b == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        return System.currentTimeMillis() - this.f109412b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v5 */
    private static int e() {
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
        QLog.i("GdtSplashReporterForPreloader", 1, "[getValueOfPreloadState] isConnected:" + isNetSupport + " isWifiConnected:" + isWifiConn + " isApplicationForeground:" + ((boolean) r26) + " value:" + i3);
        return i3;
    }

    public void f(p pVar) {
        b bVar = new b(2000110, c());
        bVar.i(pVar);
        GdtSplashReporterUtil.e(bVar);
    }

    public void g(p pVar) {
        b bVar = new b(2000108, d());
        bVar.i(pVar);
        GdtSplashReporterUtil.e(bVar);
    }

    public void h() {
        b bVar = new b(2000109, c());
        bVar.k(e());
        GdtSplashReporterUtil.e(bVar);
    }

    public void i() {
        GdtSplashReporterUtil.e(new b(2000107, d()));
    }

    public void j(long j3) {
        this.f109411a = j3;
        GdtSplashReporterUtil.e(new b(2000101));
    }

    public void k() {
        GdtSplashReporterUtil.e(new b(2000104, c()));
    }

    public void l(p pVar) {
        b bVar = new b(2000103, c());
        bVar.i(pVar);
        GdtSplashReporterUtil.e(bVar);
    }

    public void m(p pVar) {
        b bVar = new b(2000106, c());
        bVar.i(pVar);
        GdtSplashReporterUtil.e(bVar);
    }

    public void n() {
        GdtSplashReporterUtil.e(new b(2000102, c()));
    }

    public void o(long j3) {
        this.f109412b = j3;
        GdtSplashReporterUtil.e(new b(2000105, c()));
    }
}
