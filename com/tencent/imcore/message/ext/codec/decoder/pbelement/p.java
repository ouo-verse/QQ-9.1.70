package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes7.dex */
public class p extends af {
    static IPatchRedirector $redirector_;

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_elem)).booleanValue();
        }
        if (im_msg_body_elem.common_elem.has() && 18 == im_msg_body_elem.common_elem.uint32_service_type.get()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public int getPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return -1000;
    }
}
