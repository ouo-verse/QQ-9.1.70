package com.tencent.mobileqq.app.message;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d extends DatalineMessageManager {
    static IPatchRedirector $redirector_;

    public d(QQAppInterface qQAppInterface, QQMessageFacade qQMessageFacade) {
        super(qQAppInterface, qQMessageFacade);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) qQMessageFacade);
        } else {
            this.f195837f = AppConstants.DATALINE_IPAD_UIN;
            this.f195838h = 6003;
        }
    }

    @Override // com.tencent.mobileqq.app.message.DatalineMessageManager
    public long a(DataLineMsgRecord dataLineMsgRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, this, dataLineMsgRecord, Boolean.valueOf(z16))).longValue();
        }
        if (dataLineMsgRecord != null) {
            String str = this.f195837f;
            dataLineMsgRecord.selfuin = str;
            dataLineMsgRecord.frienduin = str;
            dataLineMsgRecord.senderuin = str;
            dataLineMsgRecord.istroop = this.f195838h;
            dataLineMsgRecord.dataline_type = 1;
        }
        return super.a(dataLineMsgRecord, z16);
    }

    @Override // com.tencent.mobileqq.app.message.DatalineMessageManager
    protected DataLineMsgProxy c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DataLineMsgProxy) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f195835d.getDataLineMsgProxy(1);
    }

    @Override // com.tencent.mobileqq.app.message.DatalineMessageManager
    protected void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            ((DataLineHandler) this.f195835d.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).y4(false);
        }
    }
}
