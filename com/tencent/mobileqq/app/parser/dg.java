package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;

/* compiled from: P */
/* loaded from: classes11.dex */
public class dg extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public dg(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private boolean F() {
        String str = this.f307441f.get("uin");
        try {
            if (TextUtils.isEmpty(str)) {
                str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            }
            QZoneHelper.forwardToUserHome((Activity) this.f307437b, QZoneHelper.UserInfo.getInstance(), str, 0, 0, 0);
        } catch (Exception e16) {
            QLog.e("QzoneOpenHomePageAction", 1, e16, new Object[0]);
        }
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
            QLog.e("QzoneOpenHomePageAction", 1, "doAction error: " + e16.getMessage());
            i("QzoneOpenHomePageAction");
            return false;
        }
    }
}
