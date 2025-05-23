package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes19.dex */
public class DiskCache {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DiskCache";
    File directory;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class Editor {
        static IPatchRedirector $redirector_;
        File dirtyFile;
        private String key;

        Editor(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiskCache.this, (Object) str);
                return;
            }
            if (!DiskCache.this.directory.exists()) {
                DiskCache.this.directory.mkdirs();
            }
            this.key = str;
            this.dirtyFile = new File(DiskCache.this.directory, str + ".tmp");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void abort(boolean z16) {
            if (!z16 || this.dirtyFile.length() <= 0) {
                this.dirtyFile.delete();
                QLog.d(DiskCache.TAG, 2, "dirtyFile delete as abort: " + this.dirtyFile.getPath());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public File commit() throws IOException {
            File cleanFile = DiskCache.this.getCleanFile(this.key);
            if (cleanFile.exists()) {
                return cleanFile;
            }
            if (this.dirtyFile.exists() && this.dirtyFile.length() > 0) {
                QLog.d(DiskCache.TAG, 2, "dirtyFile rename: " + this.dirtyFile.getPath());
                this.dirtyFile.renameTo(cleanFile);
                return cleanFile;
            }
            QLog.d(DiskCache.TAG, 2, "dirtyFile delete: " + this.dirtyFile.getPath());
            this.dirtyFile.delete();
            throw new IOException("write 0 length file or null File");
        }
    }

    public DiskCache(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) file);
        } else {
            this.directory = file;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Editor edit(String str) {
        return new Editor(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File getCleanFile(String str) {
        if (!this.directory.exists()) {
            this.directory.mkdirs();
        }
        return new File(this.directory, str);
    }

    public File getDirectory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.directory;
    }
}
