package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi.api.IWSManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class eu extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;
    private Object Q;

    public eu(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        try {
            return ((IWSManager) QRoute.api(IWSManager.class)).doJumpAction(this.f307441f.get("action"), this.f307437b, this.f307441f, this.Q);
        } catch (Exception e16) {
            QLog.e("WeishiPublicAccountUniversalAction", 1, "doAction error: " + e16.getMessage());
            i("WeishiPublicAccountUniversalAction");
            return false;
        }
    }

    public eu(QQAppInterface qQAppInterface, Context context, Object obj) {
        this(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.Q = obj;
        } else {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, context, obj);
        }
    }
}
