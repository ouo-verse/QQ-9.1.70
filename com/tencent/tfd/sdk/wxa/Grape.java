package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.EmotcationConstants;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Grape {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f375635a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62626);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f375635a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        }
    }
}
