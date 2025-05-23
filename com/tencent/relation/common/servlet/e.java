package com.tencent.relation.common.servlet;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e extends d {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.relation.common.servlet.d
    public void a(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, intent, fromServiceMsg, bArr);
            return;
        }
        Bundle bundle = new Bundle();
        if (intent != null) {
            bundle.putAll(intent.getExtras());
        }
        bundle.putParcelable(FromServiceMsg.class.getSimpleName(), fromServiceMsg);
        bundle.putByteArray("rsp_data", bArr);
        notifyObserver(intent, 0, fromServiceMsg.isSuccess(), bundle, c.class);
    }
}
