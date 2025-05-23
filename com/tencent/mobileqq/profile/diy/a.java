package com.tencent.mobileqq.profile.diy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.VasConstant;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f260152a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41387);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f260152a = VasConstant.PRO_FILE_CARD_DOWN_LOAD_DIR + "diyCardFonts/";
    }
}
