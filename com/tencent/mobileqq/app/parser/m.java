package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class m extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public m(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    public boolean F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        Bundle bundle = new Bundle();
        int parseInt = Integer.parseInt(this.f307441f.get("des_type"));
        if (parseInt != 0 && parseInt != 1 && parseInt != 2) {
            parseInt = 0;
        }
        bundle.putInt("tab_index_key", parseInt);
        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).startAddContactsPage(this.f307437b, 0, 0, LaunchMode.singleTop, bundle);
        QLog.i("ContactAddAction", 1, "gotoAddContactsActivity");
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        try {
            return F();
        } catch (Exception e16) {
            QLog.e("ContactAddAction", 1, "doAction error: " + e16.getMessage());
            i("ContactAddAction");
            return false;
        }
    }
}
