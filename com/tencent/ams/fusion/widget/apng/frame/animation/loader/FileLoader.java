package com.tencent.ams.fusion.widget.apng.frame.animation.loader;

import com.tencent.ams.fusion.widget.apng.frame.animation.io.FileReader;
import com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FileLoader implements Loader {
    static IPatchRedirector $redirector_;
    private final File mFile;
    private Reader mReader;

    public FileLoader(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.mFile = new File(str);
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.loader.Loader
    public synchronized Reader obtain() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Reader) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new FileReader(this.mFile);
    }
}
