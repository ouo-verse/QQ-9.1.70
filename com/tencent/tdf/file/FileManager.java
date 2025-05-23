package com.tencent.tdf.file;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class FileManager implements IFileManager {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class FileInfo {
        static IPatchRedirector $redirector_;
        private String path;
        private long size;
        private long time;

        public FileInfo(String str, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, FileManager.this, str, Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            this.path = str;
            this.size = j3;
            this.time = j16;
        }

        public String getPath() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.path;
        }

        public long getSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.size;
        }

        public long getTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.time;
        }
    }

    public FileManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.tdf.file.IFileManager
    public boolean delete(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).delete();
    }

    @Override // com.tencent.tdf.file.IFileManager
    public boolean exists(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    @Override // com.tencent.tdf.file.IFileManager
    public List<FileInfo> getFileInfos(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        File file = new File(str);
        if (!file.exists() && file.isFile()) {
            return Collections.emptyList();
        }
        if (file.isFile()) {
            arrayList.add(new FileInfo(file.getAbsolutePath(), file.length(), file.lastModified()));
        } else {
            for (File file2 : file.listFiles()) {
                arrayList.add(new FileInfo(file2.getAbsolutePath(), file2.length(), file2.lastModified()));
            }
        }
        return arrayList;
    }

    @Override // com.tencent.tdf.file.IFileManager
    public boolean makeDir(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.mkdirs() || !file.exists()) {
            return false;
        }
        return true;
    }
}
