package com.tencent.could.huiyansdk.enums;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes5.dex */
public final class HuiYanEncryptMode {
    private static final /* synthetic */ HuiYanEncryptMode[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final HuiYanEncryptMode AES;
    public static final HuiYanEncryptMode SM4;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16302);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HuiYanEncryptMode huiYanEncryptMode = new HuiYanEncryptMode(KeyPropertiesCompact.KEY_ALGORITHM_AES, 0);
        AES = huiYanEncryptMode;
        HuiYanEncryptMode huiYanEncryptMode2 = new HuiYanEncryptMode("SM4", 1);
        SM4 = huiYanEncryptMode2;
        $VALUES = new HuiYanEncryptMode[]{huiYanEncryptMode, huiYanEncryptMode2};
    }

    HuiYanEncryptMode(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static HuiYanEncryptMode valueOf(String str) {
        return (HuiYanEncryptMode) Enum.valueOf(HuiYanEncryptMode.class, str);
    }

    public static HuiYanEncryptMode[] values() {
        return (HuiYanEncryptMode[]) $VALUES.clone();
    }
}
