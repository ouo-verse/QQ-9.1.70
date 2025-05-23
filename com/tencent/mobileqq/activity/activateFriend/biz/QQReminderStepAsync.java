package com.tencent.mobileqq.activity.activateFriend.biz;

import com.tencent.mobileqq.activity.activateFriend.y;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.api.IQQReminderOfTianshuService;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes9.dex */
public class QQReminderStepAsync extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public QQReminderStepAsync() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("IAutomator", 2, "mStepId: " + this.mStepId);
        }
        try {
            ((IQQReminderDataService) ((Automator) this.mAutomator).E.getRuntimeService(IQQReminderDataService.class, "")).checkTodayReminder();
            y.a(((Automator) this.mAutomator).E);
            IQQReminderOfTianshuService iQQReminderOfTianshuService = (IQQReminderOfTianshuService) ((Automator) this.mAutomator).E.getRuntimeService(IQQReminderOfTianshuService.class, "");
            if (iQQReminderOfTianshuService != null) {
                iQQReminderOfTianshuService.getReminderDataFromTianshu(0);
                return 7;
            }
            return 7;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("IAutomator", 1, "activateManager doLogin throw an exception: " + th5);
                return 7;
            }
            return 7;
        }
    }
}
