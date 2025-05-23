package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Keep
/* loaded from: classes12.dex */
public final class ClickPolicy {
    private static final /* synthetic */ ClickPolicy[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ClickPolicy REPORT_ALL;
    public static final ClickPolicy REPORT_NONE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11673);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ClickPolicy clickPolicy = new ClickPolicy("REPORT_NONE", 0);
        REPORT_NONE = clickPolicy;
        ClickPolicy clickPolicy2 = new ClickPolicy("REPORT_ALL", 1);
        REPORT_ALL = clickPolicy2;
        $VALUES = new ClickPolicy[]{clickPolicy, clickPolicy2};
    }

    ClickPolicy(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static ClickPolicy valueOf(String str) {
        return (ClickPolicy) Enum.valueOf(ClickPolicy.class, str);
    }

    public static ClickPolicy[] values() {
        return (ClickPolicy[]) $VALUES.clone();
    }
}
