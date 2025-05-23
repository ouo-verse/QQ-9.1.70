package com.tencent.weclip;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes27.dex */
public final class LoadModelTYPE {
    private static final /* synthetic */ LoadModelTYPE[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final LoadModelTYPE LoadAllBinEncryptedFile;
    public static final LoadModelTYPE LoadBinEncryptedFile;
    public static final LoadModelTYPE LoadOriginEncryptedFile;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62354);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        LoadModelTYPE loadModelTYPE = new LoadModelTYPE("LoadOriginEncryptedFile", 0);
        LoadOriginEncryptedFile = loadModelTYPE;
        LoadModelTYPE loadModelTYPE2 = new LoadModelTYPE("LoadBinEncryptedFile", 1);
        LoadBinEncryptedFile = loadModelTYPE2;
        LoadModelTYPE loadModelTYPE3 = new LoadModelTYPE("LoadAllBinEncryptedFile", 2);
        LoadAllBinEncryptedFile = loadModelTYPE3;
        $VALUES = new LoadModelTYPE[]{loadModelTYPE, loadModelTYPE2, loadModelTYPE3};
    }

    LoadModelTYPE(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static LoadModelTYPE valueOf(String str) {
        return (LoadModelTYPE) Enum.valueOf(LoadModelTYPE.class, str);
    }

    public static LoadModelTYPE[] values() {
        return (LoadModelTYPE[]) $VALUES.clone();
    }

    public int toInt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return ordinal();
    }
}
