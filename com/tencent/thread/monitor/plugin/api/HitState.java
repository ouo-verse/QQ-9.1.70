package com.tencent.thread.monitor.plugin.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/thread/monitor/plugin/api/HitState;", "", "(Ljava/lang/String;I)V", "New", "Yes", "No", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class HitState {
    private static final /* synthetic */ HitState[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final HitState New;
    public static final HitState No;
    public static final HitState Yes;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7795);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        HitState hitState = new HitState("New", 0);
        New = hitState;
        HitState hitState2 = new HitState("Yes", 1);
        Yes = hitState2;
        HitState hitState3 = new HitState("No", 2);
        No = hitState3;
        $VALUES = new HitState[]{hitState, hitState2, hitState3};
    }

    HitState(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        }
    }

    public static HitState valueOf(String str) {
        return (HitState) Enum.valueOf(HitState.class, str);
    }

    public static HitState[] values() {
        return (HitState[]) $VALUES.clone();
    }
}
