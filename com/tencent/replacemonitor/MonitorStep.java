package com.tencent.replacemonitor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes25.dex */
public final class MonitorStep {
    private static final /* synthetic */ MonitorStep[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final MonitorStep AFTER_INSTALL;
    public static final MonitorStep BEFORE_INSTALL;
    public static final MonitorStep DOWNLOADING;
    public static final MonitorStep INSTALLING;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10605);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        MonitorStep monitorStep = new MonitorStep("DOWNLOADING", 0);
        DOWNLOADING = monitorStep;
        MonitorStep monitorStep2 = new MonitorStep("BEFORE_INSTALL", 1);
        BEFORE_INSTALL = monitorStep2;
        MonitorStep monitorStep3 = new MonitorStep("INSTALLING", 2);
        INSTALLING = monitorStep3;
        MonitorStep monitorStep4 = new MonitorStep("AFTER_INSTALL", 3);
        AFTER_INSTALL = monitorStep4;
        $VALUES = new MonitorStep[]{monitorStep, monitorStep2, monitorStep3, monitorStep4};
    }

    MonitorStep(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static MonitorStep valueOf(String str) {
        return (MonitorStep) Enum.valueOf(MonitorStep.class, str);
    }

    public static MonitorStep[] values() {
        return (MonitorStep[]) $VALUES.clone();
    }
}
