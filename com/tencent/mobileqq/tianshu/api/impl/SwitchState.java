package com.tencent.mobileqq.tianshu.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/tianshu/api/impl/SwitchState;", "", "(Ljava/lang/String;I)V", "NONE", "ON", "OFF", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class SwitchState {
    private static final /* synthetic */ SwitchState[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final SwitchState NONE;
    public static final SwitchState OFF;
    public static final SwitchState ON;

    private static final /* synthetic */ SwitchState[] $values() {
        return new SwitchState[]{NONE, ON, OFF};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22310);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        NONE = new SwitchState("NONE", 0);
        ON = new SwitchState("ON", 1);
        OFF = new SwitchState("OFF", 2);
        $VALUES = $values();
    }

    SwitchState(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static SwitchState valueOf(String str) {
        return (SwitchState) Enum.valueOf(SwitchState.class, str);
    }

    public static SwitchState[] values() {
        return (SwitchState[]) $VALUES.clone();
    }
}
