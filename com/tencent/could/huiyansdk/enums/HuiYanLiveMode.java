package com.tencent.could.huiyansdk.enums;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes5.dex */
public final class HuiYanLiveMode {
    private static final /* synthetic */ HuiYanLiveMode[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final HuiYanLiveMode ACTION_MODE;
    public static final HuiYanLiveMode ACTION_REFLECT_MODE;
    public static final HuiYanLiveMode SILENCE_MODE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18106);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HuiYanLiveMode huiYanLiveMode = new HuiYanLiveMode("ACTION_MODE", 0);
        ACTION_MODE = huiYanLiveMode;
        HuiYanLiveMode huiYanLiveMode2 = new HuiYanLiveMode("SILENCE_MODE", 1);
        SILENCE_MODE = huiYanLiveMode2;
        HuiYanLiveMode huiYanLiveMode3 = new HuiYanLiveMode("ACTION_REFLECT_MODE", 2);
        ACTION_REFLECT_MODE = huiYanLiveMode3;
        $VALUES = new HuiYanLiveMode[]{huiYanLiveMode, huiYanLiveMode2, huiYanLiveMode3};
    }

    HuiYanLiveMode(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static HuiYanLiveMode valueOf(String str) {
        return (HuiYanLiveMode) Enum.valueOf(HuiYanLiveMode.class, str);
    }

    public static HuiYanLiveMode[] values() {
        return (HuiYanLiveMode[]) $VALUES.clone();
    }
}
