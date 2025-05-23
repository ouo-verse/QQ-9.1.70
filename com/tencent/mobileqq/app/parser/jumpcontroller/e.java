package com.tencent.mobileqq.app.parser.jumpcontroller;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.au;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ax;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e implements c {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.parser.jumpcontroller.c
    public ax a(BaseQQAppInterface baseQQAppInterface, Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ax) iPatchRedirector.redirect((short) 3, this, baseQQAppInterface, context, str);
        }
        ax d16 = com.tencent.mobileqq.app.parser.ax.d(baseQQAppInterface, context, str);
        if (d16 != null) {
            return d16;
        }
        return au.g(baseQQAppInterface, context, str);
    }
}
