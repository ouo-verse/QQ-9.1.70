package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class EmosmEmoticonConstant {
    static IPatchRedirector $redirector_ = null;
    public static final String EXTRA_LAUNCH_MODE = "extra_launch_mode";
    public static final String EXTRA_LAUNCH_SOURCE = "extra_launch_source";
    public static final int LAUNCH_MODE_EMOTICON_MAGIC = 2;
    public static final int LAUNCH_MODE_EMOTICON_ORIGINAL = 1;
    public static final int LAUNCH_SOURCE_AIO_PANEL = 1;
    public static final int LAUNCH_SOURCE_EMOTICON_MARKET = 2;

    public EmosmEmoticonConstant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
