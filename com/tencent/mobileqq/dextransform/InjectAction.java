package com.tencent.mobileqq.dextransform;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes10.dex */
public final class InjectAction {
    private static final /* synthetic */ InjectAction[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final InjectAction GET_FIELD_REPLACE;
    public static final InjectAction GET_STATIC_FIELD_REPLACE;
    public static final InjectAction METHOD_ENTER;
    public static final InjectAction METHOD_EXIT;
    public static final InjectAction METHOD_REPLACE;
    public static final InjectAction PUT_FIELD_REPLACE;
    public static final InjectAction PUT_STATIC_FIELD_REPLACE;
    public static final InjectAction STATIC_METHOD_ENTER;
    public static final InjectAction STATIC_METHOD_EXIT;
    public static final InjectAction STATIC_METHOD_REPLACE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11847);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        InjectAction injectAction = new InjectAction("METHOD_REPLACE", 0);
        METHOD_REPLACE = injectAction;
        InjectAction injectAction2 = new InjectAction("STATIC_METHOD_REPLACE", 1);
        STATIC_METHOD_REPLACE = injectAction2;
        InjectAction injectAction3 = new InjectAction("METHOD_ENTER", 2);
        METHOD_ENTER = injectAction3;
        InjectAction injectAction4 = new InjectAction("STATIC_METHOD_ENTER", 3);
        STATIC_METHOD_ENTER = injectAction4;
        InjectAction injectAction5 = new InjectAction("METHOD_EXIT", 4);
        METHOD_EXIT = injectAction5;
        InjectAction injectAction6 = new InjectAction("STATIC_METHOD_EXIT", 5);
        STATIC_METHOD_EXIT = injectAction6;
        InjectAction injectAction7 = new InjectAction("GET_FIELD_REPLACE", 6);
        GET_FIELD_REPLACE = injectAction7;
        InjectAction injectAction8 = new InjectAction("GET_STATIC_FIELD_REPLACE", 7);
        GET_STATIC_FIELD_REPLACE = injectAction8;
        InjectAction injectAction9 = new InjectAction("PUT_FIELD_REPLACE", 8);
        PUT_FIELD_REPLACE = injectAction9;
        InjectAction injectAction10 = new InjectAction("PUT_STATIC_FIELD_REPLACE", 9);
        PUT_STATIC_FIELD_REPLACE = injectAction10;
        $VALUES = new InjectAction[]{injectAction, injectAction2, injectAction3, injectAction4, injectAction5, injectAction6, injectAction7, injectAction8, injectAction9, injectAction10};
    }

    InjectAction(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static InjectAction valueOf(String str) {
        return (InjectAction) Enum.valueOf(InjectAction.class, str);
    }

    public static InjectAction[] values() {
        return (InjectAction[]) $VALUES.clone();
    }
}
