package com.tencent.mobileqq.bigbrother.impl;

import com.tencent.mobileqq.bigbrother.ISourceIDSetter;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class SourceIDSetterImpl implements ISourceIDSetter {
    static IPatchRedirector $redirector_;

    public SourceIDSetterImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.bigbrother.ISourceIDSetter
    public void setTeleScreenRefID(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            JefsClass.getInstance().setRefID(str);
        }
    }

    @Override // com.tencent.mobileqq.bigbrother.ISourceIDSetter
    public void setTeleScreenSourceID(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            JefsClass.getInstance().setSourceID(str);
        }
    }
}
