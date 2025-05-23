package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService;
import com.tencent.mobileqq.emoticon.CommonUsedSystemEmojiManagerConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GetCommonUsedSystemEmojiStep extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public GetCommonUsedSystemEmojiStep() {
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
        SharedPreferences sharedPreferences = ((Automator) this.mAutomator).E.getApp().getSharedPreferences(CommonUsedSystemEmojiManagerConstants.SP_FILE_NAME, 0);
        long j3 = sharedPreferences.getLong(CommonUsedSystemEmojiManagerConstants.LAST_REQUEST_TIME, 0L);
        com.tencent.mobileqq.emosm.o oVar = (com.tencent.mobileqq.emosm.o) ((Automator) this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM);
        File file = new File(BaseApplicationImpl.sApplication.getFilesDir(), CommonUsedSystemEmojiManagerConstants.COMMONUSED_SYSTEM_EMOJI_FILE_NAME_ + ((Automator) this.mAutomator).E.getCurrentAccountUin());
        File file2 = new File(BaseApplicationImpl.sApplication.getFilesDir(), CommonUsedSystemEmojiManagerConstants.COMMONUSED_SYSTEM_EMOJI_FILE_NAME_V2_ + ((Automator) this.mAutomator).E.getCurrentAccountUin());
        if (!file.exists() && !file2.exists()) {
            QLog.d("IAutomator", 1, "GetCommonUsedSystemEmojiStep file and fileV2  not exsist");
            oVar.Y0();
            sharedPreferences.edit().putLong(CommonUsedSystemEmojiManagerConstants.LAST_REQUEST_TIME, System.currentTimeMillis()).commit();
            return 7;
        }
        if (file.exists() && !file2.exists()) {
            ((ICommonUsedSystemEmojiManagerService) ((Automator) this.mAutomator).E.getRuntimeService(ICommonUsedSystemEmojiManagerService.class)).copySystemEmojiFileToFileV2(file, file2);
        }
        if (System.currentTimeMillis() - j3 <= 43200000 && System.currentTimeMillis() - j3 >= 0) {
            if (QLog.isColorLevel()) {
                QLog.d("IAutomator", 2, "GetCommonUsedSystemEmojiStep updateCacheFromFile");
            }
            ((ICommonUsedSystemEmojiManagerService) ((Automator) this.mAutomator).E.getRuntimeService(ICommonUsedSystemEmojiManagerService.class)).getLocalSystemEmojiInfoFromFile();
            return 7;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IAutomator", 2, "GetCommonUsedSystemEmojiStep send req");
        }
        oVar.Y0();
        sharedPreferences.edit().putLong(CommonUsedSystemEmojiManagerConstants.LAST_REQUEST_TIME, System.currentTimeMillis()).commit();
        return 7;
    }
}
