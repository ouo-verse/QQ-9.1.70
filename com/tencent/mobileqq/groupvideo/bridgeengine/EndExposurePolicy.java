package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Keep
/* loaded from: classes12.dex */
public final class EndExposurePolicy {
    private static final /* synthetic */ EndExposurePolicy[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final EndExposurePolicy REPORT_ALL;
    public static final EndExposurePolicy REPORT_NONE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11683);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        EndExposurePolicy endExposurePolicy = new EndExposurePolicy("REPORT_NONE", 0);
        REPORT_NONE = endExposurePolicy;
        EndExposurePolicy endExposurePolicy2 = new EndExposurePolicy("REPORT_ALL", 1);
        REPORT_ALL = endExposurePolicy2;
        $VALUES = new EndExposurePolicy[]{endExposurePolicy, endExposurePolicy2};
    }

    EndExposurePolicy(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static EndExposurePolicy valueOf(String str) {
        return (EndExposurePolicy) Enum.valueOf(EndExposurePolicy.class, str);
    }

    public static EndExposurePolicy[] values() {
        return (EndExposurePolicy[]) $VALUES.clone();
    }
}
