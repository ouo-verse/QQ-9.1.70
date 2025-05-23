package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QGmZm implements FileFilter {
    static IPatchRedirector $redirector_;

    public QGmZm() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file)).booleanValue();
        }
        if (Pattern.matches("cpu[0-9]", file.getName())) {
            return true;
        }
        return false;
    }
}
