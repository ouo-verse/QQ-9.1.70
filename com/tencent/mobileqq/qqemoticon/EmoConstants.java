package com.tencent.mobileqq.qqemoticon;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class EmoConstants {
    static IPatchRedirector $redirector_ = null;
    public static final int BUSINESS_ID_AIO = 0;
    public static final int BUSINESS_ID_ALL = -1;
    public static final int BUSINESS_ID_COLOR_NICK = 2;
    public static final int BUSINESS_ID_FORWARD_MSG = 4;
    public static final int BUSINESS_ID_KANDIAN = 1;
    public static final int BUSINESS_ID_ONLINE_STATUS = 3;
    public static final int BUSINESS_ID_QCIRCLE = 6;
    public static final int BUSINESS_ID_TIMI_GAME = 5;
    public static final int TYPE_EMOJI = 2;
    public static final int TYPE_SYSTEM = 1;

    public EmoConstants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
