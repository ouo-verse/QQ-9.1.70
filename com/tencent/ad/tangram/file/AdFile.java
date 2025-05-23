package com.tencent.ad.tangram.file;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.mobileqq.msf.core.auth.k;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdFile {
    private static final String TAG = "AdFile";
    private String charsetName;
    private String directoryPath;

    @Nullable
    private FileLock fileLock;
    private String filename;

    @Nullable
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
            AdLog.e(TAG, "close", th5);
        }
        try {
            RandomAccessFile randomAccessFile = this.randomAccessFile;
            if (randomAccessFile != null) {
                randomAccessFile.close();
                this.randomAccessFile = null;
            }
        } catch (Throwable th6) {
            AdLog.e(TAG, "close", th6);
        }
    }

    public boolean open() {
        String str;
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
                    this.fileLock = randomAccessFile.getChannel().lock();
                } else {
                    this.fileLock = randomAccessFile.getChannel().tryLock(0L, Long.MAX_VALUE, true);
                }
                if (file2.exists() && file2.isFile()) {
                    return true;
                }
                close();
                return false;
            } catch (Throwable th5) {
                AdLog.e(TAG, "open", th5);
                close();
            }
        }
        return false;
    }

    @Nullable
    public String readFully() {
        return readFully(Integer.MIN_VALUE);
    }

    public boolean writeFully(@Nullable String str) {
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
                AdLog.e(TAG, k.f247492f, th5);
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x001c, code lost:
    
        if (r0.length() <= r7) goto L14;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String readFully(int i3) {
        if (isValid() && (r0 = this.randomAccessFile) != null && this.fileLock != null) {
            if (i3 != Integer.MIN_VALUE) {
                try {
                } catch (Throwable th5) {
                    AdLog.e(TAG, k.f247491e, th5);
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
