package com.tencent.ams.fusion.widget.alphaplayer.gl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class FormatType {
    private static final /* synthetic */ FormatType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final FormatType ALIGNED;
    public static final FormatType COMPRESS;
    final int nativeInt;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31152);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        FormatType formatType = new FormatType("ALIGNED", 0, 0);
        ALIGNED = formatType;
        FormatType formatType2 = new FormatType("COMPRESS", 1, 1);
        COMPRESS = formatType2;
        $VALUES = new FormatType[]{formatType, formatType2};
    }

    FormatType(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.nativeInt = i16;
        }
    }

    public static FormatType valueOf(String str) {
        return (FormatType) Enum.valueOf(FormatType.class, str);
    }

    public static FormatType[] values() {
        return (FormatType[]) $VALUES.clone();
    }
}
