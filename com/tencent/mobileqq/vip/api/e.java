package com.tencent.mobileqq.vip.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public final /* synthetic */ class e {
    static {
        IVipTraceDetailReport.Companion companion = IVipTraceDetailReport.INSTANCE;
    }

    @JvmStatic
    @NotNull
    public static IVipTraceDetailReport a() {
        IPatchRedirector iPatchRedirector = IVipTraceDetailReport.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (IVipTraceDetailReport) iPatchRedirector.redirect((short) 1);
        }
        return IVipTraceDetailReport.INSTANCE.a();
    }
}
