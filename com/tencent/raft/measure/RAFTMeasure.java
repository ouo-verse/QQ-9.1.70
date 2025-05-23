package com.tencent.raft.measure;

import android.content.Context;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.raft.measure.config.MeasureAppConfig;
import com.tencent.raft.measure.config.RAFTComConfig;
import com.tencent.raft.measure.utils.MeasureConst;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class RAFTMeasure {
    static IPatchRedirector $redirector_;
    private static final MeasureCore core;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11960);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            core = new MeasureCore();
        }
    }

    RAFTMeasure() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void enableCrashMonitor(@NonNull Context context, @NonNull RAFTComConfig rAFTComConfig) {
        core.h(context, rAFTComConfig);
    }

    public static MeasureAppConfig getAppConfig() {
        return core.j();
    }

    public static void reportAvg(@NonNull Context context, @NonNull RAFTComConfig rAFTComConfig, @NonNull String str, long j3) {
        core.l(context, rAFTComConfig, str, String.valueOf(j3), 1, "average");
    }

    public static void reportDistribution(@NonNull Context context, @NonNull RAFTComConfig rAFTComConfig, @NonNull String str, long j3) {
        reportDistribution(context, rAFTComConfig, str, String.valueOf(j3), 1);
    }

    public static void reportSuccess(@NonNull Context context, @NonNull RAFTComConfig rAFTComConfig, @NonNull String str, boolean z16) {
        core.l(context, rAFTComConfig, str, z16 ? "1" : "0", 1, MeasureConst.SLI_TYPE_SUCCESS);
    }

    public static void updateSLIAppConfig(@NonNull MeasureAppConfig measureAppConfig) {
        core.n(measureAppConfig);
    }

    public static void reportAvg(@NonNull Context context, @NonNull RAFTComConfig rAFTComConfig, @NonNull String str, long j3, @IntRange(from = 0, to = 100) int i3) {
        core.l(context, rAFTComConfig, str, String.valueOf(j3), i3, "average");
    }

    public static void reportDistribution(@NonNull Context context, @NonNull RAFTComConfig rAFTComConfig, @NonNull String str, long j3, @IntRange(from = 0, to = 100) int i3) {
        reportDistribution(context, rAFTComConfig, str, String.valueOf(j3), i3);
    }

    public static void reportSuccess(@NonNull Context context, @NonNull RAFTComConfig rAFTComConfig, @NonNull String str, boolean z16, @IntRange(from = 0, to = 100) int i3) {
        core.l(context, rAFTComConfig, str, z16 ? "1" : "0", i3, MeasureConst.SLI_TYPE_SUCCESS);
    }

    public static void reportDistribution(@NonNull Context context, @NonNull RAFTComConfig rAFTComConfig, @NonNull String str, @NonNull String str2) {
        core.l(context, rAFTComConfig, str, str2, 1, MeasureConst.SLI_TYPE_DISTRIBUTION);
    }

    public static void reportDistribution(@NonNull Context context, @NonNull RAFTComConfig rAFTComConfig, @NonNull String str, @NonNull String str2, @IntRange(from = 0, to = 100) int i3) {
        core.l(context, rAFTComConfig, str, str2, i3, MeasureConst.SLI_TYPE_DISTRIBUTION);
    }
}
