package com.tencent.ams.mosaic.jsengine.annotation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class MethodScope {
    private static final /* synthetic */ MethodScope[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final MethodScope ALL;
    public static final MethodScope DECLARED;
    public static final MethodScope SPECIFIED;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37650);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        MethodScope methodScope = new MethodScope("DECLARED", 0);
        DECLARED = methodScope;
        MethodScope methodScope2 = new MethodScope("SPECIFIED", 1);
        SPECIFIED = methodScope2;
        MethodScope methodScope3 = new MethodScope("ALL", 2);
        ALL = methodScope3;
        $VALUES = new MethodScope[]{methodScope, methodScope2, methodScope3};
    }

    MethodScope(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static MethodScope valueOf(String str) {
        return (MethodScope) Enum.valueOf(MethodScope.class, str);
    }

    public static MethodScope[] values() {
        return (MethodScope[]) $VALUES.clone();
    }
}
