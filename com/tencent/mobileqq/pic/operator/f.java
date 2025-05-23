package com.tencent.mobileqq.pic.operator;

import com.tencent.mobileqq.pic.api.IDep;
import com.tencent.mobileqq.pic.p;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransferRequest;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f extends UploadPicOperator {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pic.operator.UploadPicOperator
    public TransferRequest x(p pVar, v vVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TransferRequest) iPatchRedirector.redirect((short) 2, (Object) this, (Object) pVar, (Object) vVar);
        }
        TransferRequest x16 = super.x(pVar, vVar);
        if (pVar != null && x16 != null && x16.mUinType == 1) {
            ((IDep) QRoute.api(IDep.class)).addWaitingEssenceMsg(x16.mPeerUin, x16.mUniseq);
        }
        return x16;
    }
}
