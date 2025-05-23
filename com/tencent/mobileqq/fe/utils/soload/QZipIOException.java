package com.tencent.mobileqq.fe.utils.soload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.util.zip.ZipEntry;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QZipIOException extends IOException {
    static IPatchRedirector $redirector_;

    public QZipIOException() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean isInvalidEntry(ZipEntry zipEntry) {
        String name;
        if (zipEntry != null && (name = zipEntry.getName()) != null && (name.contains("../") || name.contains("..\\"))) {
            return true;
        }
        return false;
    }
}
