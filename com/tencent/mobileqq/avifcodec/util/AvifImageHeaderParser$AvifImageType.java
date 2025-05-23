package com.tencent.mobileqq.avifcodec.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes11.dex */
public final class AvifImageHeaderParser$AvifImageType {
    private static final /* synthetic */ AvifImageHeaderParser$AvifImageType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final AvifImageHeaderParser$AvifImageType AVIF_AVIF;
    public static final AvifImageHeaderParser$AvifImageType AVIF_AVIS;
    public static final AvifImageHeaderParser$AvifImageType UNKNOWN;
    private final boolean hasAlpha;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33628);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        AvifImageHeaderParser$AvifImageType avifImageHeaderParser$AvifImageType = new AvifImageHeaderParser$AvifImageType("AVIF_AVIF", 0, true);
        AVIF_AVIF = avifImageHeaderParser$AvifImageType;
        AvifImageHeaderParser$AvifImageType avifImageHeaderParser$AvifImageType2 = new AvifImageHeaderParser$AvifImageType("AVIF_AVIS", 1, true);
        AVIF_AVIS = avifImageHeaderParser$AvifImageType2;
        AvifImageHeaderParser$AvifImageType avifImageHeaderParser$AvifImageType3 = new AvifImageHeaderParser$AvifImageType("UNKNOWN", 2, false);
        UNKNOWN = avifImageHeaderParser$AvifImageType3;
        $VALUES = new AvifImageHeaderParser$AvifImageType[]{avifImageHeaderParser$AvifImageType, avifImageHeaderParser$AvifImageType2, avifImageHeaderParser$AvifImageType3};
    }

    AvifImageHeaderParser$AvifImageType(String str, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            this.hasAlpha = z16;
        }
    }

    public static AvifImageHeaderParser$AvifImageType valueOf(String str) {
        return (AvifImageHeaderParser$AvifImageType) Enum.valueOf(AvifImageHeaderParser$AvifImageType.class, str);
    }

    public static AvifImageHeaderParser$AvifImageType[] values() {
        return (AvifImageHeaderParser$AvifImageType[]) $VALUES.clone();
    }

    public boolean hasAlpha() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.hasAlpha;
    }
}
