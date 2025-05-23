package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;
    private Activity Q;

    public a(BaseQQAppInterface baseQQAppInterface, Context context) {
        super(baseQQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.Q = null;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) context);
        }
    }

    private void G(String str) {
        QLog.e("AVGameShareCreateRoomAction", 1, "doAction error: intent is null");
    }

    public void F(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        try {
            String str = this.f307441f.get("startFrom");
            String str2 = this.f307441f.get(IProfileCardConst.KEY_FROM_TYPE);
            if ("1".equals(str)) {
                F(str2);
            } else {
                G(str2);
            }
        } catch (Exception e16) {
            QLog.e("AVGameShareCreateRoomAction", 1, "doAction error: " + e16.getMessage());
            i("AVGameShareCreateRoomAction");
        }
        return true;
    }

    public a(BaseQQAppInterface baseQQAppInterface, Activity activity) {
        super(baseQQAppInterface, activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.Q = activity;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseQQAppInterface, (Object) activity);
        }
    }
}
