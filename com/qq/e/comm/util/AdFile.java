package com.qq.e.comm.util;

import android.text.TextUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AdFile {
    private static final String TAG = "AdFile";
    private String charsetName;
    private String directoryPath;
    private FileLock fileLock;
    private String filename;
    private RandomAccessFile randomAccessFile;
    private boolean writable;

    public AdFile(String str, String str2, String str3, boolean z16) {
        this.directoryPath = str;
        this.filename = str2;
        this.charsetName = str3;
        this.writable = z16;
    }

    private boolean isValid() {
        if (!TextUtils.isEmpty(this.directoryPath) && !TextUtils.isEmpty(this.filename) && !TextUtils.isEmpty(this.charsetName)) {
            return true;
        }
        return false;
    }

    public void close() {
        try {
            FileLock fileLock = this.fileLock;
            if (fileLock != null) {
                fileLock.release();
                this.fileLock = null;
            }
        } catch (Throwable th5) {
            GDTLogger.e("AdFile close", th5);
        }
        try {
            RandomAccessFile randomAccessFile = this.randomAccessFile;
            if (randomAccessFile != null) {
                randomAccessFile.close();
                this.randomAccessFile = null;
            }
        } catch (Throwable th6) {
            GDTLogger.e("AdFile close", th6);
        }
    }

    public boolean open() {
        String str;
        FileLock tryLock;
        if (isValid() && this.randomAccessFile == null && this.fileLock == null) {
            try {
                File file = new File(this.directoryPath);
                File file2 = new File(file, this.filename);
                if (this.writable && !file.exists() && !file.mkdirs()) {
                    return false;
                }
                if (this.writable) {
                    str = "rwd";
                } else {
                    str = "r";
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, str);
                this.randomAccessFile = randomAccessFile;
                if (this.writable) {
                    tryLock = randomAccessFile.getChannel().lock();
                } else {
                    tryLock = randomAccessFile.getChannel().tryLock(0L, Long.MAX_VALUE, true);
                }
                this.fileLock = tryLock;
                if (file2.exists() && file2.isFile()) {
                    return true;
                }
                close();
                return false;
            } catch (Throwable th5) {
                GDTLogger.e("AdFile open", th5);
                close();
            }
        }
        return false;
    }

    public String readFully() {
        return readFully(Integer.MIN_VALUE);
    }

    public boolean writeFully(String str) {
        RandomAccessFile randomAccessFile;
        if (isValid() && this.writable && (randomAccessFile = this.randomAccessFile) != null && this.fileLock != null) {
            try {
                randomAccessFile.setLength(0L);
                if (!TextUtils.isEmpty(str)) {
                    this.randomAccessFile.write(str.getBytes(this.charsetName));
                    return true;
                }
                return true;
            } catch (Throwable th5) {
                GDTLogger.e("AdFile write", th5);
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x001c, code lost:
    
        if (r0.length() <= r7) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String readFully(int i3) {
        if (isValid() && (r0 = this.randomAccessFile) != null && this.fileLock != null) {
            if (i3 != Integer.MIN_VALUE) {
                try {
                } catch (Throwable th5) {
                    GDTLogger.e("AdFile read", th5);
                }
            }
            i3 = Long.valueOf(this.randomAccessFile.length()).intValue();
            if (i3 <= 0) {
                return null;
            }
            byte[] bArr = new byte[i3];
            if (this.randomAccessFile.read(bArr, 0, i3) == i3) {
                return new String(bArr, 0, i3, this.charsetName);
            }
            return null;
        }
        return null;
    }
}
