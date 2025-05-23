package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GetClubContentUpdateStatus extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public GetClubContentUpdateStatus() {
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
            QLog.d("IAutomator", 2, "[GetClubContentUpdateStatus]system time" + System.currentTimeMillis() + ",last update time:");
        }
        ClubContentJsonTask.getPersonalCardUrlInfo(((Automator) this.mAutomator).E);
        VipGrayConfigHelper.getsInstance().parseJson(((Automator) this.mAutomator).E);
        ClubContentJsonTask.downloadAllIfNotExist(((Automator) this.mAutomator).E);
        SharedPreferences sharedPreferences = ((Automator) this.mAutomator).E.getApp().getSharedPreferences("mobileQQ", 0);
        long j3 = sharedPreferences.getLong("last_pull_club_content_update_time", 0L);
        if (System.currentTimeMillis() - j3 <= 43200000 && System.currentTimeMillis() >= j3) {
            if (QLog.isColorLevel()) {
                QLog.d("IAutomator", 2, "system time" + System.currentTimeMillis() + ",last update time:" + j3);
            }
        } else {
            ClubContentUpdateHandler clubContentUpdateHandler = (ClubContentUpdateHandler) ((Automator) this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.CLUBCONTENTUPDATE_HANDLER);
            if (clubContentUpdateHandler != null) {
                clubContentUpdateHandler.V2();
                sharedPreferences.edit().putLong("last_pull_club_content_update_time", System.currentTimeMillis()).commit();
            }
        }
        com.tencent.mobileqq.vip.b.c().m(((Automator) this.mAutomator).E.getApplication(), ((Automator) this.mAutomator).E.getCurrentAccountUin());
        return 7;
    }
}
