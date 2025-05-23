package com.tencent.util.notification;

import com.tencent.commonsdk.util.notification.NotificationLimiter;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b implements NotificationLimiter {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean a(int i3) {
        if (i3 >= 528 && i3 <= 3000528) {
            return true;
        }
        return false;
    }

    private boolean b(int i3) {
        if (i3 != 241 && i3 != 244 && i3 != 242 && i3 != 243) {
            return false;
        }
        return true;
    }

    private boolean c(int i3) {
        if (i3 == 3000530) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.commonsdk.util.notification.NotificationLimiter
    public boolean shouldNotify(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
        }
        if (b(i3) || a(i3) || c(i3)) {
            return true;
        }
        if (MiniChatActivity.M2()) {
            if (QLog.isColorLevel()) {
                QLog.i("NotificationLimiterImpl", 2, "MiniMsgActForeGround");
            }
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            z16 = !StudyModeManager.x(i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("NotificationLimiterImpl", 2, String.format("studymode_fightNotificationLimiterImpl ,shouldNotify1 = %b,", Boolean.valueOf(z16)));
        }
        return z16;
    }
}
