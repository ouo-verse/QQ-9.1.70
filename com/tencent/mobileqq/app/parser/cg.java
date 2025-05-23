package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;

/* compiled from: P */
/* loaded from: classes11.dex */
public class cg extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public cg(QQAppInterface qQAppInterface, Context context) {
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
            if (this.f307441f.containsKey(ZPlanPublishSource.FROM_SCHEME) && this.f307441f.containsKey("msgid") && this.f307441f.containsKey("busiid")) {
                String str = this.f307441f.get("msgid");
                String str2 = this.f307441f.get("busiid");
                String str3 = this.f307441f.get(ZPlanPublishSource.FROM_SCHEME);
                String str4 = "";
                if (this.f307441f.containsKey("domain")) {
                    str4 = this.f307441f.get("domain");
                }
                QQNotifySettingFragment.Gh(this.f307437b, str, str2, str3, str4);
            }
            return false;
        } catch (Exception e16) {
            QLog.e("QQNotifySettingAction", 1, "doAction error: " + e16.getMessage());
            i("QQNotifySettingAction");
            return false;
        }
    }
}
