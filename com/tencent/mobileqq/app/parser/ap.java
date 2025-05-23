package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ap extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public ap(QQAppInterface qQAppInterface, Context context) {
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
            String E = com.tencent.mobileqq.utils.ax.E(this.f307441f.get("url"));
            if (!TextUtils.isEmpty(this.f307441f.get("appid")) && !TextUtils.isEmpty(this.f307441f.get("openid"))) {
                ReportController.o(this.f307436a, "dc00898", "", "", "0X80097E8", "0X80097E8", 0, 0, "", "", this.f307441f.get("appid"), "");
                Intent intent = new Intent(this.f307437b, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", E);
                this.f307437b.startActivity(intent);
                return true;
            }
            QLog.e("IdentifierWebJumpAction", 1, "identification with illegal params");
            return true;
        } catch (Exception e16) {
            QLog.e("IdentifierWebJumpAction", 1, "doAction error: " + e16.getMessage());
            i("IdentifierWebJumpAction");
            return false;
        }
    }
}
