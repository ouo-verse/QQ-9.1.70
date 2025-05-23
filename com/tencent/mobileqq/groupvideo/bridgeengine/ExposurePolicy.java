package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Keep
/* loaded from: classes12.dex */
public final class ExposurePolicy {
    private static final /* synthetic */ ExposurePolicy[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ExposurePolicy REPORT_ALL;
    public static final ExposurePolicy REPORT_FIRST;
    public static final ExposurePolicy REPORT_NONE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11695);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ExposurePolicy exposurePolicy = new ExposurePolicy("REPORT_NONE", 0);
        REPORT_NONE = exposurePolicy;
        ExposurePolicy exposurePolicy2 = new ExposurePolicy("REPORT_FIRST", 1);
        REPORT_FIRST = exposurePolicy2;
        ExposurePolicy exposurePolicy3 = new ExposurePolicy("REPORT_ALL", 2);
        REPORT_ALL = exposurePolicy3;
        $VALUES = new ExposurePolicy[]{exposurePolicy, exposurePolicy2, exposurePolicy3};
    }

    ExposurePolicy(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static ExposurePolicy valueOf(String str) {
        return (ExposurePolicy) Enum.valueOf(ExposurePolicy.class, str);
    }

    public static ExposurePolicy[] values() {
        return (ExposurePolicy[]) $VALUES.clone();
    }
}
