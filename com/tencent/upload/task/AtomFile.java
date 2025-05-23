package com.tencent.upload.task;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.utils.FileUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AtomFile {
    static IPatchRedirector $redirector_;
    private File mFile;
    private boolean mFileHasExportingCompleted;
    private long mFileSize;
    private long mOffset;
    private String mSessionId;
    private int mSliceSize;
    private long mStartTime;

    public AtomFile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.mFileHasExportingCompleted = false;
        this.mFile = new File(str);
        this.mFileSize = FileUtils.getFileLength(str);
    }

    public synchronized File getFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (File) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mFile;
    }

    public long getFileSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
        }
        long fileLength = FileUtils.getFileLength(this.mFile.getPath());
        this.mFileSize = fileLength;
        return fileLength;
    }

    public long getFileSizeNoUpdate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.mFileSize;
    }

    public synchronized long getRemainSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.mFileSize - this.mOffset;
    }

    public synchronized long getRemainSizeByCheckFileSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        long fileLength = FileUtils.getFileLength(this.mFile.getPath());
        this.mFileSize = fileLength;
        long j3 = this.mOffset;
        if (fileLength > j3) {
            return fileLength - j3;
        }
        return 0L;
    }

    public boolean isAvailable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (this.mFileHasExportingCompleted && this.mFileSize <= this.mOffset) {
            return false;
        }
        return true;
    }

    public boolean isFileHasExportingCompleted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.mFileHasExportingCompleted;
    }

    public synchronized long reduce(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, j3)).longValue();
        }
        long j16 = this.mOffset;
        this.mOffset = j3 + j16;
        return j16;
    }

    public AtomFile setFileHasExportingCompleted(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (AtomFile) iPatchRedirector.redirect((short) 12, (Object) this, z16);
        }
        this.mFileHasExportingCompleted = z16;
        return this;
    }

    public synchronized AtomFile setOffset(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AtomFile) iPatchRedirector.redirect((short) 8, (Object) this, j3);
        }
        this.mOffset = j3;
        return this;
    }

    public AtomFile setSessionId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AtomFile) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        synchronized (this) {
            this.mSessionId = str;
            notifyAll();
        }
        return this;
    }

    public AtomFile setSliceSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AtomFile) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        synchronized (this) {
            this.mSliceSize = i3;
        }
        return this;
    }

    public AtomFile setStartTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (AtomFile) iPatchRedirector.redirect((short) 10, (Object) this, j3);
        }
        synchronized (this) {
            this.mStartTime = j3;
        }
        return this;
    }

    public String toLogString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return "AtomFile{mFile=" + this.mFile + ", mFileSize=" + this.mFileSize + ", mOffset=" + this.mOffset + ", mSliceSize=" + this.mSliceSize + ", mSessionId='" + this.mSessionId + "', mStartTime=" + this.mStartTime + ", mFileHasExportingCompleted=" + this.mFileHasExportingCompleted + '}';
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer("AtomFile{\n");
        stringBuffer.append("mFile=");
        stringBuffer.append(this.mFile);
        stringBuffer.append('\n');
        stringBuffer.append(", exist=");
        stringBuffer.append(this.mFile.exists());
        stringBuffer.append('\n');
        stringBuffer.append(", mFileSize=");
        stringBuffer.append(this.mFileSize);
        stringBuffer.append('\n');
        stringBuffer.append(", mOffset=");
        stringBuffer.append(this.mOffset);
        stringBuffer.append('\n');
        stringBuffer.append(", mSliceSize=");
        stringBuffer.append(this.mSliceSize);
        stringBuffer.append('\n');
        stringBuffer.append(", mSessionId='");
        stringBuffer.append(this.mSessionId);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", mStartTime=");
        stringBuffer.append(this.mStartTime);
        stringBuffer.append('\n');
        stringBuffer.append(", mFileHasExportingCompleted=");
        stringBuffer.append(this.mFileHasExportingCompleted);
        stringBuffer.append('\n');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public AtomFile(String str, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.mFileHasExportingCompleted = false;
        this.mFile = new File(str);
        this.mFileSize = j16 - j3;
    }
}
