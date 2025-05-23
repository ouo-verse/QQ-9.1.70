package com.tencent.mobileqq.transfile;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes19.dex */
public class BasePttDownloaderProcessor extends BaseDownloadProcessor {
    static IPatchRedirector $redirector_;
    AppInterface app;

    public BasePttDownloaderProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.app = super.app;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
        }
    }

    public String getPttStorePath(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, str, str2, Integer.valueOf(i3));
        }
        return MessageForPtt.getLocalFilePath(i3, AppConstants.SDCARD_PATH + this.app.getAccount() + "/ptt/" + str + "_" + FileMsg.getTransFileDateTime() + ".amr");
    }

    public BasePttDownloaderProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
