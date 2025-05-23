package com.tencent.ams.mosaic.jsengine.common.file;

import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MosaicFile implements IFile {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final File f70882a;

    /* renamed from: b, reason: collision with root package name */
    private final a f70883b;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    @interface ErrorCode {
        public static final int FAILURE_EXIST = -1;
        public static final int FAILURE_INVALID = -2;
        public static final int FAILURE_OTHER = -4;
        public static final int FAILURE_PERMISSON = -3;
        public static final int SUCCESS = 0;
    }

    public MosaicFile(@NonNull File file, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) file, (Object) aVar);
        } else {
            this.f70882a = file;
            this.f70883b = aVar;
        }
    }

    private int a(File file) {
        if (file == null) {
            return -4;
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                a(file2);
            }
        }
        if (!file.delete()) {
            return -4;
        }
        return 0;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IFile
    public int createNewFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        File file = this.f70882a;
        if (file == null) {
            return -4;
        }
        if (file.exists()) {
            return -1;
        }
        try {
            File parentFile = this.f70882a.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
        } catch (Throwable th5) {
            f.c("MosaicFile", "create file error.", th5);
            if (th5 instanceof IOException) {
                return -2;
            }
        }
        if (!this.f70882a.createNewFile()) {
            return -4;
        }
        return 0;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IFile
    public int deleteFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return a(this.f70882a);
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IFile
    public IFile[] fileList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (IFile[]) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        File file = this.f70882a;
        if (file == null) {
            return new IFile[0];
        }
        File[] listFiles = file.listFiles();
        IFile[] iFileArr = new IFile[listFiles.length];
        for (int i3 = 0; i3 < listFiles.length; i3++) {
            iFileArr[i3] = new MosaicFile(listFiles[i3], this.f70883b);
        }
        return iFileArr;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IFile
    public String getAbsolutePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        File file = this.f70882a;
        if (file == null) {
            return null;
        }
        return file.getAbsolutePath();
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IFile
    public long getLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        File file = this.f70882a;
        if (file == null) {
            return 0L;
        }
        return file.length();
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IFile
    public long getModifyDate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        File file = this.f70882a;
        if (file == null) {
            return 0L;
        }
        return file.lastModified();
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IFile
    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        File file = this.f70882a;
        if (file == null) {
            return null;
        }
        return file.getName();
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IFile
    public IFile getParent() {
        File parentFile;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (IFile) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        File file = this.f70882a;
        if (file == null || (parentFile = file.getParentFile()) == null) {
            return null;
        }
        return new MosaicFile(parentFile, this.f70883b);
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IFile
    public IReader getReader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (IReader) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        try {
            return new b(this.f70883b, this.f70882a);
        } catch (Throwable th5) {
            f.c("MosaicFile", "create reader error.", th5);
            return null;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IFile
    public IWriter getWriter(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (IWriter) iPatchRedirector.redirect((short) 16, (Object) this, z16);
        }
        try {
            return new c(this.f70883b, this.f70882a, z16);
        } catch (Throwable th5) {
            f.c("MosaicFile", "create writer error.", th5);
            return null;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IFile
    public boolean isDirectory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        File file = this.f70882a;
        if (file != null && file.isDirectory()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IFile
    public boolean isExists() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        File file = this.f70882a;
        if (file != null && file.exists()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IFile
    public boolean isFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        File file = this.f70882a;
        if (file != null && file.isFile()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IFile
    public int mkdirs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        File file = this.f70882a;
        if (file == null) {
            return -4;
        }
        if (file.exists()) {
            return -1;
        }
        try {
        } catch (Throwable th5) {
            if (th5 instanceof IOException) {
                return -2;
            }
        }
        if (!this.f70882a.mkdirs()) {
            return -4;
        }
        return 0;
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.file.IFile
    public boolean updateModifyDate(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, j3)).booleanValue();
        }
        File file = this.f70882a;
        if (file == null) {
            return false;
        }
        return file.setLastModified(j3);
    }
}
