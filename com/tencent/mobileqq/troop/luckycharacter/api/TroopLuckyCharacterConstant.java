package com.tencent.mobileqq.troop.luckycharacter.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopLuckyCharacterConstant {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final HashSet<Long> f297770a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28650);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f297770a = new HashSet<Long>() { // from class: com.tencent.mobileqq.troop.luckycharacter.api.TroopLuckyCharacterConstant.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    add(1069L);
                    add(1070L);
                    add(1071L);
                    add(1072L);
                    add(1073L);
                }
            };
        }
    }
}
