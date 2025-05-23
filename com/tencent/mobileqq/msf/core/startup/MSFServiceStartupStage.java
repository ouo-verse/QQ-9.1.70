package com.tencent.mobileqq.msf.core.startup;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/msf/core/startup/MSFServiceStartupStage;", "", "(Ljava/lang/String;I)V", "MSFServiceInit", "MSFSDK_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class MSFServiceStartupStage {
    private static final /* synthetic */ MSFServiceStartupStage[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final MSFServiceStartupStage MSFServiceInit;

    private static final /* synthetic */ MSFServiceStartupStage[] $values() {
        return new MSFServiceStartupStage[]{MSFServiceInit};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26070);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            MSFServiceInit = new MSFServiceStartupStage("MSFServiceInit", 0);
            $VALUES = $values();
        }
    }

    MSFServiceStartupStage(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static MSFServiceStartupStage valueOf(String str) {
        return (MSFServiceStartupStage) Enum.valueOf(MSFServiceStartupStage.class, str);
    }

    public static MSFServiceStartupStage[] values() {
        return (MSFServiceStartupStage[]) $VALUES.clone();
    }
}
