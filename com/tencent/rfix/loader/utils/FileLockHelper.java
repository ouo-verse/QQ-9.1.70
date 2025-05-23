package com.tencent.rfix.loader.utils;

import com.tencent.rfix.loader.log.RFixLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

/* compiled from: P */
/* loaded from: classes25.dex */
public class FileLockHelper implements Closeable {
    private static final int LOCK_WAIT_EACH_TIME = 10;
    private static final int MAX_LOCK_ATTEMPTS = 2;
    private static final String TAG = "RFix.FileLockHelper";
    private final FileLock fileLock;
    private final FileOutputStream outputStream;

    FileLockHelper(File file) throws IOException {
        boolean z16;
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        this.outputStream = new FileOutputStream(file);
        FileLock fileLock = null;
        Exception e16 = null;
        int i3 = 0;
        while (i3 < 2) {
            i3++;
            try {
                fileLock = this.outputStream.getChannel().lock();
                if (fileLock != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } catch (Exception e17) {
                e16 = e17;
                RFixLog.e(TAG, "get lock fail, wait time: 10");
            }
            try {
                Thread.sleep(10L);
            } catch (Exception e18) {
                RFixLog.e(TAG, "get lock fail, thread sleep exception.", e18);
            }
        }
        if (fileLock != null) {
            this.fileLock = fileLock;
            return;
        }
        throw new IOException("lock file failed: " + file.getAbsolutePath(), e16);
    }

    public static FileLockHelper getFileLock(File file) throws IOException {
        return new FileLockHelper(file);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            FileLock fileLock = this.fileLock;
            if (fileLock != null) {
                fileLock.release();
            }
        } finally {
            FileOutputStream fileOutputStream = this.outputStream;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }
}
