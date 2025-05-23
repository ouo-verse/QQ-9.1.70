package com.tencent.creatorad.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class CreatorConstant {
    static IPatchRedirector $redirector_ = null;
    public static final int BANNER = 1;
    public static final int BOX = 2;
    public static final int HORIZONTAL_BLOCKS = 4;
    public static final int LIFE_CYCLE_PAUSE = 1;
    public static final int LIFE_CYCLE_RESUME = 0;
    public static final int POS_INVALID = 0;
    public static final int STYLE_GAME = 2;
    public static final int STYLE_GENERAL = 1;
    public static final int STYLE_INVALID = 0;
    public static final int STYLE_NARROW_BANNER = 100;
    public static final int TEMP_INVALID = 0;
    public static final int VERTICAL_BLOCKS = 3;

    CreatorConstant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
