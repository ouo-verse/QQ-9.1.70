package com.tencent.tdf.embed;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class EmbeddedViewFactoryRegister {
    static IPatchRedirector $redirector_;
    private final Map<String, EmbeddedViewFactory> mEmbeddedViewFactories;

    public EmbeddedViewFactoryRegister() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mEmbeddedViewFactories = new HashMap();
        }
    }

    public EmbeddedViewFactory getEmbeddedViewFactory(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EmbeddedViewFactory) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return this.mEmbeddedViewFactories.get(str);
    }

    public boolean registerEmbeddedViewFactory(String str, EmbeddedViewFactory embeddedViewFactory) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) embeddedViewFactory)).booleanValue();
        }
        if (this.mEmbeddedViewFactories.containsKey(str)) {
            return false;
        }
        this.mEmbeddedViewFactories.put(str, embeddedViewFactory);
        return true;
    }
}
