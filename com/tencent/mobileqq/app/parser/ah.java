package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ah extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public ah(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    protected boolean F(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.f307437b instanceof Activity) {
            ((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).startPublishHomeWorkFragment((Activity) this.f307437b, null, str);
            ((Activity) this.f307437b).overridePendingTransition(R.anim.f155030h6, R.anim.f154442w);
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        try {
            return F(f("gc"));
        } catch (Exception e16) {
            QLog.e("HomeWorkTroopPublishAction", 1, "doAction error: " + e16.getMessage());
            i("HomeWorkTroopPublishAction");
            return false;
        }
    }
}
