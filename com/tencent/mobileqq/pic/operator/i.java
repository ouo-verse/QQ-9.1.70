package com.tencent.mobileqq.pic.operator;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class i extends UploadPicOperator {
    static IPatchRedirector $redirector_;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pic.operator.UploadPicOperator
    public void w(MessageForPic messageForPic, v vVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageForPic, (Object) vVar);
            return;
        }
        super.w(messageForPic, vVar);
        v.b bVar = vVar.A0;
        if (bVar != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            messageForPic.msgseq = bVar.f258841a;
            messageForPic.shmsgseq = bVar.f258842b;
            messageForPic.msgUid = bVar.f258843c;
        }
        com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "packMsg", "retry:" + z16 + " info.DLSendKey:" + vVar.S);
    }
}
