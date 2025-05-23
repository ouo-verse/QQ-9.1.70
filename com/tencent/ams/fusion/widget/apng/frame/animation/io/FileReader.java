package com.tencent.ams.fusion.widget.apng.frame.animation.io;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FileReader extends FilterReader {
    static IPatchRedirector $redirector_;
    private final File mFile;

    public FileReader(File file) throws IOException {
        super(new StreamReader(new FileInputStream(file)));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) file);
        } else {
            this.mFile = file;
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.io.FilterReader, com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader
    public void reset() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.reader.close();
            this.reader = new StreamReader(new FileInputStream(this.mFile));
        }
    }
}
