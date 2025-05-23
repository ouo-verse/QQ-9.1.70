package com.tencent.freesia;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class ModelType {
    private static final /* synthetic */ ModelType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ModelType FULL;
    public static final ModelType SPECIFY;
    public static final ModelType UNKNOWN;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10176);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ModelType modelType = new ModelType("UNKNOWN", 0);
        UNKNOWN = modelType;
        ModelType modelType2 = new ModelType("FULL", 1);
        FULL = modelType2;
        ModelType modelType3 = new ModelType("SPECIFY", 2);
        SPECIFY = modelType3;
        $VALUES = new ModelType[]{modelType, modelType2, modelType3};
    }

    ModelType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static ModelType valueOf(String str) {
        return (ModelType) Enum.valueOf(ModelType.class, str);
    }

    public static ModelType[] values() {
        return (ModelType[]) $VALUES.clone();
    }
}
