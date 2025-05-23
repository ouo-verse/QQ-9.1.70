package com.tencent.mobileqq.auto.engine.loader.parse;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e extends ZipInputStream {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(InputStream inputStream) {
        super(inputStream);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) inputStream);
        }
    }

    @Override // java.util.zip.ZipInputStream
    public final ZipEntry getNextEntry() throws IOException {
        String name;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ZipEntry) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ZipEntry nextEntry = super.getNextEntry();
        if (nextEntry != null && (name = nextEntry.getName()) != null && (name.contains("../") || name.contains("..\\"))) {
            throw new SecurityException("\u975e\u6cd5entry\u8def\u5f84:" + nextEntry.getName());
        }
        return nextEntry;
    }
}
