package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public c(QQAppInterface qQAppInterface, Context context) {
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
            String str = this.f307441f.get(IProfileCardConst.KEY_FROM_TYPE);
            if (str != null && "1".equals(str)) {
                ReportController.o(e(), "dc00898", "", "", "0X800B693", "0X800B693", 0, 0, "", "", "", "");
            }
        } catch (Exception e16) {
            QLog.e("AVGameShareEntryLobbyAction", 1, "doAction error: " + e16.getMessage());
            i("AVGameShareEntryLobbyAction");
        }
        return true;
    }
}
