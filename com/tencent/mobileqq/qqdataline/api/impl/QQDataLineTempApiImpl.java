package com.tencent.mobileqq.qqdataline.api.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.i;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.ProcessorDispatcherInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqdataline.api.IQQDataLineTempApi;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQDataLineTempApiImpl implements IQQDataLineTempApi {
    static IPatchRedirector $redirector_;

    public QQDataLineTempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqdataline.api.IQQDataLineTempApi
    public void onGetOfflineMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            QLog.d("QQDataLine", 1, "onGetOfflineMsg");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqdataline.api.impl.QQDataLineTempApiImpl.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQDataLineTempApiImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    i iVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().peekAppRuntime();
                    if (qQAppInterface == null) {
                        QLog.d("QQDataLine", 1, "onGetOfflineMsg, Runnable app is null!");
                        return;
                    }
                    MessageHandler msgHandler = qQAppInterface.getMsgHandler();
                    if (msgHandler != null && msgHandler.getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_C2C) != null && (iVar = (i) msgHandler.getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_C2C)) != null) {
                        iVar.S();
                    }
                }
            }, 128, null, true);
        }
    }
}
