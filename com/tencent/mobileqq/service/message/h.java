package com.tencent.mobileqq.service.message;

import com.tencent.mobileqq.data.troop.TroopMemberSpecialTitleInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f286257a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45115);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f286257a = TroopMemberSpecialTitleInfo.SPECIAL_TITLE_EXPIRE_SOON_TIME;
        }
    }
}
