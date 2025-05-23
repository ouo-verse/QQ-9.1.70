package com.tencent.mobileqq.app.message;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e extends DatalineMessageManager {
    static IPatchRedirector $redirector_;

    public e(QQAppInterface qQAppInterface, QQMessageFacade qQMessageFacade) {
        super(qQAppInterface, qQMessageFacade);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) qQMessageFacade);
        } else {
            this.f195837f = AppConstants.DATALINE_PC_UIN;
            this.f195838h = 6000;
        }
    }

    @Override // com.tencent.mobileqq.app.message.DatalineMessageManager
    protected DataLineMsgProxy c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DataLineMsgProxy) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f195835d.getDataLineMsgProxy(0);
    }

    @Override // com.tencent.mobileqq.app.message.DatalineMessageManager
    protected void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            ((DataLineHandler) this.f195835d.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).A4(false);
        }
    }
}
