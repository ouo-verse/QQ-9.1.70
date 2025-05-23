package com.tencent.ams.fusion.widget.apng.decode;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
class IENDChunk extends Chunk {
    static IPatchRedirector $redirector_;
    static final int ID;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52202);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            ID = Chunk.fourCCToInt("IEND");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IENDChunk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
