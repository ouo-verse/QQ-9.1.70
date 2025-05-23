package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;

/* compiled from: P */
/* loaded from: classes11.dex */
public class dl extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public dl(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private boolean F() {
        if (this.f307437b instanceof Activity) {
            QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
            userInfo.qzone_uin = this.f307436a.getCurrentAccountUin();
            userInfo.nickname = this.f307436a.getCurrentNickname();
            QZoneHelper.forwardToPublishQueue((Activity) this.f307437b, userInfo, -1);
            return true;
        }
        return false;
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
            QLog.e("QzonePublishQueueAction", 1, "doAction error: " + e16.getMessage());
            i("QzonePublishQueueAction");
            return false;
        }
    }
}
