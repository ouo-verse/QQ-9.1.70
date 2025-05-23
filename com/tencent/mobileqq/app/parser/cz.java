package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class cz extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public cz(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        JSONObject optJSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            if (this.f307441f.containsKey("params")) {
                try {
                    JSONObject jSONObject = new JSONObject(URLDecoder.decode(this.f307441f.get("params")));
                    if (QLog.isColorLevel()) {
                        QLog.i("QwalletToNotifyAction", 2, "urlParamObj: " + jSONObject);
                    }
                    if (jSONObject.optInt("view_type", 0) == 0 && (optJSONObject = jSONObject.optJSONObject("params")) != null) {
                        ReminderListFragment.launch(this.f307437b, optJSONObject.optString("notice_time"));
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("QwalletToNotifyAction", 2, "JumpAction parse url throw an exception: " + e16);
                    }
                }
            }
            return false;
        } catch (Exception e17) {
            QLog.e("QwalletToNotifyAction", 1, "doAction error: " + e17.getMessage());
            i("QwalletToNotifyAction");
            return false;
        }
    }
}
