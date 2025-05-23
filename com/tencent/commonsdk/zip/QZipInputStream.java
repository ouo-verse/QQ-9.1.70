package com.tencent.commonsdk.zip;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QZipInputStream extends ZipInputStream {
    static IPatchRedirector $redirector_;

    public QZipInputStream(InputStream inputStream) {
        super(inputStream);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) inputStream);
        }
    }

    @Override // java.util.zip.ZipInputStream
    public ZipEntry getNextEntry() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ZipEntry) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ZipEntry nextEntry = super.getNextEntry();
        if (!QZipIOException.isInvalidEntry(nextEntry)) {
            return nextEntry;
        }
        throw new QZipIOException();
    }
}
