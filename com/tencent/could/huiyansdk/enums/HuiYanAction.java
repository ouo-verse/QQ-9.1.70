package com.tencent.could.huiyansdk.enums;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes5.dex */
public final class HuiYanAction {
    private static final /* synthetic */ HuiYanAction[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final HuiYanAction BLINK;
    public static final HuiYanAction NOD_HEAD;
    public static final HuiYanAction OPEN_MOUTH;
    public static final HuiYanAction SHAKE_HEAD;
    public static final HuiYanAction SILENCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18617);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HuiYanAction huiYanAction = new HuiYanAction("BLINK", 0);
        BLINK = huiYanAction;
        HuiYanAction huiYanAction2 = new HuiYanAction("OPEN_MOUTH", 1);
        OPEN_MOUTH = huiYanAction2;
        HuiYanAction huiYanAction3 = new HuiYanAction("NOD_HEAD", 2);
        NOD_HEAD = huiYanAction3;
        HuiYanAction huiYanAction4 = new HuiYanAction("SHAKE_HEAD", 3);
        SHAKE_HEAD = huiYanAction4;
        HuiYanAction huiYanAction5 = new HuiYanAction("SILENCE", 4);
        SILENCE = huiYanAction5;
        $VALUES = new HuiYanAction[]{huiYanAction, huiYanAction2, huiYanAction3, huiYanAction4, huiYanAction5};
    }

    HuiYanAction(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static HuiYanAction valueOf(String str) {
        return (HuiYanAction) Enum.valueOf(HuiYanAction.class, str);
    }

    public static HuiYanAction[] values() {
        return (HuiYanAction[]) $VALUES.clone();
    }
}
