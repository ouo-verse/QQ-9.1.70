package com.tencent.commonsdk.zip;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QZipFile extends ZipFile {
    static IPatchRedirector $redirector_;

    public QZipFile(File file) throws ZipException, IOException {
        super(file);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) file);
    }

    @Override // java.util.zip.ZipFile
    public InputStream getInputStream(ZipEntry zipEntry) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (InputStream) iPatchRedirector.redirect((short) 4, (Object) this, (Object) zipEntry);
        }
        if (!QZipIOException.isInvalidEntry(zipEntry)) {
            return super.getInputStream(zipEntry);
        }
        throw new QZipIOException();
    }

    public QZipFile(File file, int i3) throws IOException {
        super(file, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, i3);
    }

    public QZipFile(String str) throws IOException {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
    }
}
