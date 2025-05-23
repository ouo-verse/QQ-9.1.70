package com.tencent.gdtad.web;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.analysis.AdAnalysisUtil;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.SocketTimeoutException;
import mqq.app.MobileQQ;

/* loaded from: classes6.dex */
public final class GdtLandingPageConfig {

    /* renamed from: b, reason: collision with root package name */
    private static GdtLandingPageConfig f109750b;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f109751a = false;

    GdtLandingPageConfig() {
    }

    public static GdtLandingPageConfig b() {
        if (f109750b == null) {
            synchronized (GdtLandingPageConfig.class) {
                if (f109750b == null) {
                    f109750b = new GdtLandingPageConfig();
                }
            }
        }
        return f109750b;
    }

    private String d() {
        String str;
        com.tencent.gdtad.config.data.e f16 = wm0.b.m().f();
        if (f16 != null) {
            str = f16.jsUrlForPagePerformance;
        } else {
            str = null;
        }
        QLog.i("GdtLandingPageConfig", 1, "[getUrl] url:" + str);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b4 A[Catch: all -> 0x00e6, TRY_LEAVE, TryCatch #0 {all -> 0x00e6, blocks: (B:22:0x0096, B:25:0x00b4), top: B:21:0x0096 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g() {
        boolean z16;
        String str;
        GdtLog.e("GdtLandingPageConfig", "isSupportNewLandingPageReport ==" + f());
        if (f()) {
            String d16 = d();
            if (TextUtils.isEmpty(d16)) {
                return;
            }
            String str2 = Build.MANUFACTURER;
            boolean z17 = true;
            try {
                if (TextUtils.isEmpty(str2) || !str2.equalsIgnoreCase("OPPO")) {
                    String str3 = Build.BRAND;
                    if (TextUtils.isEmpty(str3) || !str3.equalsIgnoreCase("OPPO")) {
                        z16 = false;
                        if (Build.VERSION.SDK_INT > 23) {
                            z17 = false;
                        }
                        GdtLog.i("GdtLandingPageConfig", "[load] isOPPO:" + z16 + " islowerThanM:" + z17);
                        if (!z16 && z17) {
                            GdtLog.i("GdtLandingPageConfig", "[load] error, OPPO <= 6.0.1 should be ignored");
                            return;
                        }
                        GdtLog.e("GdtLandingPageConfig", "startLoad");
                        new Bundle().putString("Referer", "h5.gdt.qq.com");
                        AdHttp.Params params = new AdHttp.Params();
                        params.setUrl(d16);
                        params.method = "GET";
                        AdHttp.send(params);
                        str = new String(params.responseData);
                        if (!TextUtils.isEmpty(str)) {
                            return;
                        }
                        GdtLog.d("GdtLandingPageConfig", "load resultStr =" + str);
                        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("gdtLandingPageConfig", 4).edit();
                        edit.putString("landingpageScript", str);
                        edit.apply();
                        i(d16, params);
                        return;
                    }
                }
                AdHttp.Params params2 = new AdHttp.Params();
                params2.setUrl(d16);
                params2.method = "GET";
                AdHttp.send(params2);
                str = new String(params2.responseData);
                if (!TextUtils.isEmpty(str)) {
                }
            } catch (Throwable th5) {
                GdtLog.e("GdtLandingPageConfig", "load", th5);
                return;
            }
            z16 = true;
            if (Build.VERSION.SDK_INT > 23) {
            }
            GdtLog.i("GdtLandingPageConfig", "[load] isOPPO:" + z16 + " islowerThanM:" + z17);
            if (!z16) {
            }
            GdtLog.e("GdtLandingPageConfig", "startLoad");
            new Bundle().putString("Referer", "h5.gdt.qq.com");
        }
    }

    private void h(String str) {
        String d16 = d();
        gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
        AdAnalysisUtil.initEvent(BaseApplication.getContext(), gdt_analysis_event.CONFIG_REPORT_FOR_LINK_LANDING_PAGE_INJECT_SCRIPT, gdt_analysis_eventVar);
        gdt_analysis_eventVar.internalErrorCode = !TextUtils.isEmpty(str) ? 1 : 0;
        gdt_analysis_eventVar.errorCode1 = !TextUtils.isEmpty(d16) ? 1 : 0;
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(BaseApplication.getContext()), new AdAnalysisEvent(gdt_analysis_eventVar, 103));
        QLog.i("GdtLandingPageConfig", 1, "[reportForAnalysisWhenInject] internalErrorCode:" + gdt_analysis_eventVar.internalErrorCode + " errorCode1:" + gdt_analysis_eventVar.errorCode1 + " url:" + d16);
    }

    private void i(String str, AdHttp.Params params) {
        int i3;
        if (params != null && params.canSend()) {
            int i16 = params.responseCode;
            if (i16 == 200) {
                i3 = 0;
            } else if (i16 != Integer.MIN_VALUE) {
                i3 = 5;
            } else if (params.throwable instanceof SocketTimeoutException) {
                i3 = 13;
            } else {
                i3 = 3;
            }
        } else {
            i3 = 4;
        }
        gdt_analysis_event gdt_analysis_eventVar = new gdt_analysis_event();
        AdAnalysisUtil.initEvent(BaseApplication.getContext(), gdt_analysis_event.CONFIG_REPORT_FOR_LINK_LANDING_PAGE_LOAD_SCRIPT, gdt_analysis_eventVar);
        gdt_analysis_eventVar.internalErrorCode = i3;
        gdt_analysis_eventVar.errorCode1 = !AdNet.isNetValid(BaseApplication.getContext()) ? 1 : 0;
        if (params != null) {
            gdt_analysis_eventVar.duration = params.durationMillis;
            gdt_analysis_eventVar.httpErrorCode = params.responseCode;
        }
        AdAnalysis.getInstance().handleAsync(new WeakReference<>(BaseApplication.getContext()), new AdAnalysisEvent(gdt_analysis_eventVar, 102));
        QLog.i("GdtLandingPageConfig", 1, "[reportForAnalysisWhenLoad] internalErrorCode:" + gdt_analysis_eventVar.internalErrorCode + " errorCode1:" + gdt_analysis_eventVar.errorCode1 + " url:" + str);
    }

    @Nullable
    public String c(@Nullable Context context) {
        String str = "";
        if (!f()) {
            h("");
            return "";
        }
        if (context != null) {
            str = context.getSharedPreferences("gdtLandingPageConfig", 4).getString("landingpageScript", "");
            GdtLog.d("GdtLandingPageConfig", "sharedPreferences result ==" + str);
            if (!TextUtils.isEmpty(str)) {
                h(str);
                return str;
            }
        }
        h(str);
        return str;
    }

    public void e(Context context) {
        if (this.f109751a) {
            return;
        }
        synchronized (this) {
            if (this.f109751a) {
                return;
            }
            boolean z16 = true;
            this.f109751a = true;
            if (1 != MobileQQ.sProcessId) {
                z16 = false;
            }
            if (!z16) {
                GdtLog.i("GdtLandingPageConfig", "[init] do nothing, not on main process");
            } else {
                AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.web.GdtLandingPageConfig.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GdtLandingPageConfig.this.g();
                    }
                }, 4);
            }
        }
    }

    public boolean f() {
        return !TextUtils.isEmpty(d());
    }
}
