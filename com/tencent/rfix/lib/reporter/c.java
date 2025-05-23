package com.tencent.rfix.lib.reporter;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.raft.measure.RAFTMeasure;
import com.tencent.raft.measure.config.RAFTComConfig;
import com.tencent.rfix.lib.atta.RFixATTASwitch;
import com.tencent.rfix.loader.entity.RFixLoadResult;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final RAFTComConfig f364996a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10213);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f364996a = new RAFTComConfig("RFix-Android", "1.2.4-beta4-SNAPSHOT");
        }
    }

    public static void a(Context context, boolean z16, long j3, String str) {
        if (RFixATTASwitch.isATTAReportEnable()) {
            RAFTComConfig rAFTComConfig = f364996a;
            RAFTMeasure.reportSuccess(context, rAFTComConfig, "install_status", z16);
            RAFTMeasure.reportAvg(context, rAFTComConfig, "install_cost", j3);
            RAFTMeasure.reportDistribution(context, rAFTComConfig, "install_result", str);
        }
    }

    public static boolean b(Context context, RFixLoadResult rFixLoadResult, boolean z16, long j3) {
        if (context != null && rFixLoadResult != null) {
            if (RFixATTASwitch.isATTAReportEnable()) {
                RAFTComConfig rAFTComConfig = f364996a;
                RAFTMeasure.reportSuccess(context, rAFTComConfig, "patch_status", rFixLoadResult.isSuccess());
                RAFTMeasure.reportAvg(context, rAFTComConfig, "patch_cost", rFixLoadResult.timeCost);
            }
            if (RFixATTASwitch.isATTAReportEnable()) {
                RAFTComConfig rAFTComConfig2 = f364996a;
                RAFTMeasure.enableCrashMonitor(context, rAFTComConfig2);
                RAFTMeasure.reportSuccess(context, rAFTComConfig2, "init_status", z16);
                RAFTMeasure.reportAvg(context, rAFTComConfig2, "init_cost", j3);
                return true;
            }
            return true;
        }
        return false;
    }
}
