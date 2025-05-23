package com.tencent.mobileqq.qshadow.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.Future;

/* loaded from: classes17.dex */
public class QShadowPmUpdater implements PluginManagerUpdater {
    static IPatchRedirector $redirector_;
    private File mLocalPmFile;

    public QShadowPmUpdater(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) file);
        } else {
            this.mLocalPmFile = file;
        }
    }

    @Override // com.tencent.shadow.dynamic.host.PluginManagerUpdater
    public File getLatest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (File) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mLocalPmFile;
    }

    @Override // com.tencent.shadow.dynamic.host.PluginManagerUpdater
    public Future<Boolean> isAvailable(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Future) iPatchRedirector.redirect((short) 5, (Object) this, (Object) file);
        }
        return null;
    }

    @Override // com.tencent.shadow.dynamic.host.PluginManagerUpdater
    public Future<File> update() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Future) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.shadow.dynamic.host.PluginManagerUpdater
    public boolean wasUpdating() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }
}
