package com.tencent.mobileqq.app.generalflag;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* loaded from: classes11.dex */
public class GeneralFlagProviderGeneratorImpl implements GeneralFlagProviderGenerator {
    static IPatchRedirector $redirector_;
    private com.tencent.imcore.message.basic.a<IGeneralFlagProvider> mClassGenerator;

    public GeneralFlagProviderGeneratorImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mClassGenerator = new com.tencent.imcore.message.basic.b();
        }
    }

    @Override // com.tencent.mobileqq.app.generalflag.GeneralFlagProviderGenerator, com.tencent.imcore.message.basic.a
    public List<IGeneralFlagProvider> getInstances() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mClassGenerator.getInstances();
    }

    @Override // com.tencent.mobileqq.app.generalflag.GeneralFlagProviderGenerator, com.tencent.imcore.message.basic.a
    public void register(Class<? extends IGeneralFlagProvider> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
        } else {
            this.mClassGenerator.register(cls);
        }
    }

    @Override // com.tencent.mobileqq.app.generalflag.GeneralFlagProviderGenerator, com.tencent.imcore.message.basic.a
    public void unregister(Class<? extends IGeneralFlagProvider> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cls);
        } else {
            this.mClassGenerator.unregister(cls);
        }
    }

    @Override // com.tencent.mobileqq.app.generalflag.GeneralFlagProviderGenerator, com.tencent.imcore.message.basic.a
    public List<Class<? extends IGeneralFlagProvider>> values() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mClassGenerator.values();
    }
}
