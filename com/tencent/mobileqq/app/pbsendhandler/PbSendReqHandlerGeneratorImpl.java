package com.tencent.mobileqq.app.pbsendhandler;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* loaded from: classes11.dex */
public class PbSendReqHandlerGeneratorImpl implements PbSendReqHandlerGenerator {
    static IPatchRedirector $redirector_;
    private com.tencent.imcore.message.basic.a<IPbSendReqHandler> mClassGenerator;

    public PbSendReqHandlerGeneratorImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mClassGenerator = new com.tencent.imcore.message.basic.b();
        }
    }

    @Override // com.tencent.mobileqq.app.pbsendhandler.PbSendReqHandlerGenerator, com.tencent.imcore.message.basic.a
    public List<IPbSendReqHandler> getInstances() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mClassGenerator.getInstances();
    }

    @Override // com.tencent.mobileqq.app.pbsendhandler.PbSendReqHandlerGenerator, com.tencent.imcore.message.basic.a
    public void register(Class<? extends IPbSendReqHandler> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
        } else {
            this.mClassGenerator.register(cls);
        }
    }

    @Override // com.tencent.mobileqq.app.pbsendhandler.PbSendReqHandlerGenerator, com.tencent.imcore.message.basic.a
    public void unregister(Class<? extends IPbSendReqHandler> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cls);
        } else {
            this.mClassGenerator.unregister(cls);
        }
    }

    @Override // com.tencent.mobileqq.app.pbsendhandler.PbSendReqHandlerGenerator, com.tencent.imcore.message.basic.a
    public List<Class<? extends IPbSendReqHandler>> values() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mClassGenerator.values();
    }
}
