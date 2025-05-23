package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class dp extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public dp(BaseQQAppInterface baseQQAppInterface, Context context) {
        super(baseQQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        QLog.i("RedPacketJumpAction", 1, "doAction: action=" + this.f307440e);
        if (!"redgiftDetail".equals(this.f307440e)) {
            return true;
        }
        return ((IQWalletApi) QRoute.api(IQWalletApi.class)).jumpToHbDetail(this.f307437b, this.f307441f);
    }
}
