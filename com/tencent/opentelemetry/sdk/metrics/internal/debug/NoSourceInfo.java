package com.tencent.opentelemetry.sdk.metrics.internal.debug;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class NoSourceInfo implements SourceInfo {
    private static final /* synthetic */ NoSourceInfo[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final NoSourceInfo INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25899);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        NoSourceInfo noSourceInfo = new NoSourceInfo("INSTANCE", 0);
        INSTANCE = noSourceInfo;
        $VALUES = new NoSourceInfo[]{noSourceInfo};
    }

    NoSourceInfo(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static NoSourceInfo valueOf(String str) {
        return (NoSourceInfo) Enum.valueOf(NoSourceInfo.class, str);
    }

    public static NoSourceInfo[] values() {
        return (NoSourceInfo[]) $VALUES.clone();
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.debug.SourceInfo
    public String multiLineDebugString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "\tat unknown source\n\t\t";
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.debug.SourceInfo
    public String shortDebugString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "unknown source";
    }
}
