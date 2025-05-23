package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bj extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public bj(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private boolean F() {
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(this.f307437b, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend((Activity) this.f307437b, 1, com.tencent.mobileqq.utils.ax.E(this.f307441f.get("friendUin")), "", 3001, 11, "", "", null, "", ""));
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            return F();
        } catch (Exception e16) {
            QLog.e("OdAddFriendAction", 1, "doAction error: " + e16.getMessage());
            i("OdAddFriendAction");
            return false;
        }
    }
}
