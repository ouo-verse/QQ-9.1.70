package com.tencent.ams.fusion.widget.alphaplayer.gl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class ScaleType {
    private static final /* synthetic */ ScaleType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ScaleType CENTER_CROP;
    public static final ScaleType FIT_CENTER;
    public static final ScaleType FIT_HEIGHT;
    public static final ScaleType FIT_WIDTH;
    public static final ScaleType FIT_XY;
    final int nativeInt;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31365);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ScaleType scaleType = new ScaleType("FIT_CENTER", 0, 0);
        FIT_CENTER = scaleType;
        ScaleType scaleType2 = new ScaleType("FIT_HEIGHT", 1, 1);
        FIT_HEIGHT = scaleType2;
        ScaleType scaleType3 = new ScaleType("FIT_WIDTH", 2, 2);
        FIT_WIDTH = scaleType3;
        ScaleType scaleType4 = new ScaleType("FIT_XY", 3, 3);
        FIT_XY = scaleType4;
        ScaleType scaleType5 = new ScaleType("CENTER_CROP", 4, 4);
        CENTER_CROP = scaleType5;
        $VALUES = new ScaleType[]{scaleType, scaleType2, scaleType3, scaleType4, scaleType5};
    }

    ScaleType(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.nativeInt = i16;
        }
    }

    public static ScaleType valueOf(String str) {
        return (ScaleType) Enum.valueOf(ScaleType.class, str);
    }

    public static ScaleType[] values() {
        return (ScaleType[]) $VALUES.clone();
    }
}
