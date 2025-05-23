package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi.api.IWSManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class es extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public es(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            ((IWSManager) QRoute.api(IWSManager.class)).enterWSPublicAccount(this.f307437b, "from_search_rzh_ws", false);
            return true;
        } catch (Exception e16) {
            QLog.e("WeishiPublicAccountAction", 1, "doAction error: " + e16.getMessage());
            i("WeishiPublicAccountAction");
            return false;
        }
    }
}
