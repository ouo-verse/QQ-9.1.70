package com.tencent.mobileqq.pad;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes16.dex */
public final class SplitViewState {
    private static final /* synthetic */ SplitViewState[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final SplitViewState STATE_FLAT;
    public static final SplitViewState STATE_OVERLAP;
    public static final SplitViewState UNKNOWN;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44436);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SplitViewState splitViewState = new SplitViewState("UNKNOWN", 0);
        UNKNOWN = splitViewState;
        SplitViewState splitViewState2 = new SplitViewState("STATE_FLAT", 1);
        STATE_FLAT = splitViewState2;
        SplitViewState splitViewState3 = new SplitViewState("STATE_OVERLAP", 2);
        STATE_OVERLAP = splitViewState3;
        $VALUES = new SplitViewState[]{splitViewState, splitViewState2, splitViewState3};
    }

    SplitViewState(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static SplitViewState valueOf(String str) {
        return (SplitViewState) Enum.valueOf(SplitViewState.class, str);
    }

    public static SplitViewState[] values() {
        return (SplitViewState[]) $VALUES.clone();
    }
}
