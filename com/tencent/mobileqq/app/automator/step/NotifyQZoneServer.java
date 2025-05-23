package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes11.dex */
public class NotifyQZoneServer extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public NotifyQZoneServer() {
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
        if (!((Automator) this.mAutomator).E.isBackgroundPause) {
            if (QLog.isColorLevel()) {
                QLog.d("NotifyQZoneServer", 2, "isBackground_Pause:" + ((Automator) this.mAutomator).E.isBackgroundPause);
            }
            return super.doStep();
        }
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_CLINET_ONLINE_COLD_TIME, 300);
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("QZoneOnLineServlet", 0);
        String currentAccountUin = ((Automator) this.mAutomator).getCurrentAccountUin();
        long j3 = sharedPreferences.getLong("lastReqTime" + currentAccountUin, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        long j16 = currentTimeMillis - j3;
        if (QLog.isDevelopLevel()) {
            QLog.d("NotifyQZoneServer", 4, "lastReqTime(ms):" + j3 + ",currentTime(ms):" + currentTimeMillis + "divTime(ms):" + j16 + ",coldTime(ms):" + (config * 1000));
        }
        if (j16 > config * 1000) {
            if (QLog.isDevelopLevel()) {
                QLog.d("NotifyQZoneServer", 4, "saveReqTime:" + currentTimeMillis);
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong("lastReqTime" + currentAccountUin, currentTimeMillis);
            edit.apply();
            com.tencent.mobileqq.model.c cVar = (com.tencent.mobileqq.model.c) ((Automator) this.mAutomator).E.getManager(QQManagerFactory.QZONE_MANAGER);
            if (cVar != null) {
                cVar.o0();
            }
        }
        return super.doStep();
    }
}
