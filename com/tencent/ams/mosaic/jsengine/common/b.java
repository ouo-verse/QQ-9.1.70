package com.tencent.ams.mosaic.jsengine.common;

import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements IConsole {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IConsole
    public void error(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            f.b(EnginePathProvider.ENGINE_JS_DIR, str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IConsole
    public void info(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            f.e(EnginePathProvider.ENGINE_JS_DIR, str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IConsole
    public void log(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            f.a(EnginePathProvider.ENGINE_JS_DIR, str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.IConsole
    public void warn(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            f.h(EnginePathProvider.ENGINE_JS_DIR, str);
        }
    }
}
