package com.tencent.mobileqq.qshadow.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes17.dex */
public class SafeZipFile extends ZipFile {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    private static class SafeZipEntryIterator implements Enumeration<ZipEntry> {
        static IPatchRedirector $redirector_;
        private final Enumeration<? extends ZipEntry> delegate;

        /* synthetic */ SafeZipEntryIterator(Enumeration enumeration, AnonymousClass1 anonymousClass1) {
            this(enumeration);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) enumeration, (Object) anonymousClass1);
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.delegate.hasMoreElements();
        }

        SafeZipEntryIterator(Enumeration<? extends ZipEntry> enumeration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.delegate = enumeration;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) enumeration);
            }
        }

        @Override // java.util.Enumeration
        public ZipEntry nextElement() {
            String name;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ZipEntry) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            ZipEntry nextElement = this.delegate.nextElement();
            if (nextElement == null || (name = nextElement.getName()) == null || !(name.contains("../") || name.contains("..\\"))) {
                return nextElement;
            }
            throw new SecurityException("\u975e\u6cd5entry\u8def\u5f84:" + nextElement.getName());
        }
    }

    public SafeZipFile(File file) throws IOException {
        super(file);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) file);
        }
    }

    @Override // java.util.zip.ZipFile
    public Enumeration<? extends ZipEntry> entries() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Enumeration) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new SafeZipEntryIterator(super.entries(), null);
    }
}
