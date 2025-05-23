package com.tencent.aekit.openrender;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AEDebugConfig {
    static IPatchRedirector $redirector_;
    public static boolean ENABLE_BODY_BEAUTY;
    public static boolean ENABLE_CAT;
    public static boolean ENABLE_FACEKIT_3D_LINE;
    public static boolean ENABLE_FACELINE;
    public static boolean ENABLE_GENDER_DETECT;
    public static boolean ENABLE_HAIRSEG;
    public static boolean ENABLE_HAND_LINE;
    public static boolean ENABLE_RGBDEPTH;
    public static boolean ENABLE_SEGMENT;
    public static boolean ENABLE_SKYSEG;
    public static boolean ENABLE_SMART_FILTER;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12047);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ENABLE_FACELINE = false;
        ENABLE_FACEKIT_3D_LINE = false;
        ENABLE_HAND_LINE = false;
        ENABLE_GENDER_DETECT = true;
        ENABLE_BODY_BEAUTY = false;
        ENABLE_HAIRSEG = false;
        ENABLE_SKYSEG = false;
        ENABLE_RGBDEPTH = false;
        ENABLE_SEGMENT = false;
        ENABLE_SMART_FILTER = false;
        ENABLE_CAT = false;
    }

    public AEDebugConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void reset() {
        ENABLE_FACELINE = false;
        ENABLE_FACEKIT_3D_LINE = false;
        ENABLE_HAND_LINE = false;
        ENABLE_BODY_BEAUTY = false;
        ENABLE_HAIRSEG = false;
        ENABLE_SKYSEG = false;
        ENABLE_RGBDEPTH = false;
        ENABLE_SEGMENT = false;
        ENABLE_SMART_FILTER = false;
        ENABLE_CAT = false;
    }
}
