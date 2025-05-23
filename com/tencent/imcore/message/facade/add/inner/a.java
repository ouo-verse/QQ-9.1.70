package com.tencent.imcore.message.facade.add.inner;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.vashealth.api.IQQHealthReportApi;

/* compiled from: P */
/* loaded from: classes7.dex */
class a implements com.tencent.imcore.message.facade.b {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.facade.b
    public void a(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseQQAppInterface, (Object) messageRecord);
        } else if (((IQQHealthApi) QRoute.api(IQQHealthApi.class)).isHealthUin(messageRecord.frienduin)) {
            ((IQQHealthReportApi) QRoute.api(IQQHealthReportApi.class)).reportHealthMessageArrive(messageRecord);
        }
    }
}
