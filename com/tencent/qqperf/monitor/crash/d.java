package com.tencent.qqperf.monitor.crash;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.aelight.camera.api.IAEPath;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.bn;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.api.report.IMiniReport;
import com.tencent.mobileqq.perf.tool.MemoryUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
import com.tencent.qqperf.monitor.crash.tools.m;
import com.tencent.qqperf.monitor.crash.tools.o;
import com.tencent.smtt.sdk.WebView;
import java.text.SimpleDateFormat;
import java.util.Date;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class d {
    private void e(StringBuilder sb5) {
        sb5.append("\nMobileQQ onActivityCreate component: ");
        sb5.append(BaseApplicationImpl.getApplication().startComponentInfo);
        if (BaseApplicationImpl.getApplication().broadcastInfoQueue != null && !BaseApplicationImpl.getApplication().broadcastInfoQueue.isEmpty()) {
            for (Pair<Long, String> pair : BaseApplicationImpl.getApplication().broadcastInfoQueue) {
                if (pair != null) {
                    sb5.append("\nQQBroadcastReceiver time: ");
                    sb5.append(ly3.a.f415787b.format(new Date(((Long) pair.first).longValue())));
                    sb5.append(", broadcast intent: ");
                    sb5.append((String) pair.second);
                }
            }
        }
    }

    private void f(StringBuilder sb5) {
        String crashReportAppInfo = ((IMiniReport) QRoute.api(IMiniReport.class)).getCrashReportAppInfo();
        if (!TextUtils.isEmpty(crashReportAppInfo)) {
            sb5.append('\n');
            sb5.append("MiniApp crashInfo: ");
            sb5.append(crashReportAppInfo);
        }
    }

    private void g(String str, Context context, StringBuilder sb5) {
        boolean z16;
        sb5.append("\nisPublicVersion=true");
        sb5.append("\nrevision=" + AppSetting.f99543c);
        sb5.append("\nsInjectResult: ");
        sb5.append(MobileQQ.sInjectResult);
        sb5.append("\nsQQAppInterfaceEscaped: ");
        sb5.append(BaseApplicationImpl.sQQAppInterfaceEscapedMsg);
        sb5.append("\nsSplashActivityEscaped: ");
        sb5.append(BaseApplicationImpl.sSplashActivityEscapedMsg);
        sb5.append("\nsImmersiveUtilsEscapedMsg: ");
        sb5.append(MobileQQ.sImmersiveUtilsEscapedMsg);
        sb5.append("\nPatch enable=");
        if (com.tencent.mobileqq.rfix.a.c() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(", installStatus=");
        sb5.append(com.tencent.mobileqq.rfix.a.i());
        sb5.append(", patchVersion=");
        sb5.append(com.tencent.mobileqq.rfix.a.d(MobileQQ.processName));
        sb5.append(", maxHeap=");
        sb5.append(Runtime.getRuntime().maxMemory());
        sb5.append(", curHeap=");
        sb5.append(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        sb5.append(", imgSize=");
        sb5.append(com.tencent.cache.core.manager.api.c.f98725d.g());
        if ((((float) (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory())) * 1.0f) / ((float) Runtime.getRuntime().maxMemory()) >= 0.3d && !TextUtils.isEmpty(str) && str.contains("OutOfMemory")) {
            m.a(sb5);
        }
        sb5.append("\r\n");
        sb5.append(SharedPreferencesProxyManager.sSystemSpExceptionMsg);
        QQCrashReportManager.a();
        sb5.append(QQCrashReportManager.f363169m.toString());
        QQCrashReportManager.a();
        sb5.append(QQCrashReportManager.f363170n.toString());
        sb5.append("\nstartup time: ");
        SimpleDateFormat simpleDateFormat = ly3.a.f415787b;
        sb5.append(simpleDateFormat.format(new Date(SafeModeUtil.f363212d)));
        sb5.append("\nfirst foreground time: ");
        sb5.append(simpleDateFormat.format(new Date(SafeModeUtil.f363213e)));
        sb5.append("\n");
    }

    private void h(StringBuilder sb5, String str) {
        String loadPagPath = ((IAEPath) QRoute.api(IAEPath.class)).getLoadPagPath();
        if (!TextUtils.isEmpty(loadPagPath) && str != null && str.contains("libpag")) {
            sb5.append('\n');
            sb5.append("PAG crashInfo: ");
            sb5.append(loadPagPath);
        }
    }

    private void i(StringBuilder sb5) {
        String k3 = MemoryUtil.k();
        long[] T = ah.T();
        sb5.append(ah.R());
        sb5.append("\n");
        String str = "null";
        if (k3 == null) {
            k3 = "null";
        }
        sb5.append(k3);
        sb5.append("\n");
        sb5.append("Rom total size: ");
        sb5.append(T[0]);
        sb5.append(" MB, Rom available size: ");
        sb5.append(T[1]);
        sb5.append(" MB\n");
        QQCrashReportManager.a();
        if (QQCrashReportManager.f363168l != null) {
            QQCrashReportManager.a();
            str = QQCrashReportManager.f363168l;
        }
        sb5.append(str);
        sb5.append("\n");
        sb5.append("Foreground.sCountResume = " + Foreground.getResumeActivityCount() + "\n");
        sb5.append("SplashActivity curFragment=");
        sb5.append(SplashActivity.currentFragment);
        sb5.append("\n");
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity instanceof SplashActivity) {
            sb5.append("SplashActivity curTab=");
            sb5.append(((SplashActivity) baseActivity).getCurrentTab());
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(bn.f180605a)) {
            sb5.append("PublicFragmentActivity create fragment error: \n");
            sb5.append(bn.f180605a);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(BaseApplicationImpl.sNativeMonitorEscapedMsg)) {
            sb5.append("Native monitor config: \n");
            sb5.append(BaseApplicationImpl.sNativeMonitorEscapedMsg);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(BaseApplicationImpl.ASanEscapedMsg)) {
            sb5.append("ASan msg: \n");
            sb5.append(BaseApplicationImpl.ASanEscapedMsg);
            sb5.append("\n");
        }
    }

    private void j(Context context, StringBuilder sb5) {
        int i3 = MobileQQ.sProcessId;
        if (i3 == 7 || i3 == 11) {
            sb5.append("\n");
            sb5.append(o.b());
            sb5.append("\nTBS CrashExtraMsg:");
            sb5.append(WebView.getCrashExtraCacheInfo(context));
        }
    }

    public abstract boolean a(boolean z16, String str, String str2, String str3, int i3);

    public String c(Context context, boolean z16, String str, String str2, String str3, int i3, long j3, String str4) {
        StringBuilder sb5 = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        g(str, context, sb5);
        long d16 = d(currentTimeMillis, 2, "recordNormalInfo");
        i(sb5);
        long d17 = d(d16, 2, "recordRomAndActivityInfo");
        e(sb5);
        long d18 = d(d17, 2, "recordBroadcastInfo");
        j(context, sb5);
        long d19 = d(d18, 2, "recordWebTbsInfo");
        f(sb5);
        long d26 = d(d19, 2, "recordMiniAppInfo");
        h(sb5, str3);
        d(d26, 2, "recordPagInfo");
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized long d(long j3, int i3, String str) {
        long currentTimeMillis;
        currentTimeMillis = System.currentTimeMillis();
        CrashRunStepRecordHelper.e().f(i3, str, currentTimeMillis - j3);
        return currentTimeMillis;
    }

    public void b(Context context, boolean z16, String str, String str2, String str3, int i3, long j3, String str4) {
    }
}
