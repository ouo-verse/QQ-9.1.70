package com.huawei.hms.utils;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class FileUtil {
    public static final String LOCAL_REPORT_FILE = "hms/HwMobileServiceReport.txt";
    public static final String LOCAL_REPORT_FILE_CONFIG = "hms/config.txt";
    public static final long LOCAL_REPORT_FILE_MAX_SIZE = 10240;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f37664a = false;

    /* renamed from: b, reason: collision with root package name */
    private static ScheduledExecutorService f37665b = ProxyExecutors.newSingleThreadScheduledExecutor();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f37666a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f37667b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f37668c;

        a(File file, long j3, String str) {
            this.f37666a = file;
            this.f37667b = j3;
            this.f37668c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RandomAccessFile randomAccessFile;
            Throwable th5;
            File file = this.f37666a;
            if (file == null) {
                HMSLog.e("FileUtil", "In writeFile Failed to get local file.");
                return;
            }
            File parentFile = file.getParentFile();
            if (parentFile != null && (parentFile.mkdirs() || parentFile.isDirectory())) {
                RandomAccessFile randomAccessFile2 = null;
                try {
                    try {
                        long length = this.f37666a.length();
                        if (length > this.f37667b) {
                            String canonicalPath = this.f37666a.getCanonicalPath();
                            if (!this.f37666a.delete()) {
                                HMSLog.e("FileUtil", "last file delete failed.");
                            }
                            randomAccessFile2 = new RandomAccessFile(new File(canonicalPath), "rw");
                        } else {
                            randomAccessFile = new RandomAccessFile(this.f37666a, "rw");
                            try {
                                randomAccessFile.seek(length);
                                randomAccessFile2 = randomAccessFile;
                            } catch (IOException e16) {
                                e = e16;
                                randomAccessFile2 = randomAccessFile;
                                HMSLog.e("FileUtil", "writeFile exception:", e);
                                IOUtils.closeQuietly(randomAccessFile2);
                                return;
                            } catch (Throwable th6) {
                                th5 = th6;
                                IOUtils.closeQuietly(randomAccessFile);
                                throw th5;
                            }
                        }
                        randomAccessFile2.writeBytes(this.f37668c + System.getProperty("line.separator"));
                    } catch (Throwable th7) {
                        randomAccessFile = randomAccessFile2;
                        th5 = th7;
                    }
                } catch (IOException e17) {
                    e = e17;
                }
                IOUtils.closeQuietly(randomAccessFile2);
                return;
            }
            HMSLog.e("FileUtil", "In writeFile, Failed to create directory.");
        }
    }

    public static boolean verifyHash(String str, File file) {
        byte[] digest = SHA256.digest(file);
        if (digest != null && HEX.encodeHexString(digest, true).equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    public static void writeFile(File file, String str, long j3) {
        f37665b.execute(new a(file, j3, str));
    }

    public static void writeFileReport(Context context, File file, File file2, String str, long j3, int i3) {
        if (file != null && file.isFile() && file.exists()) {
            if (!f37664a) {
                if (file2 != null && file2.exists() && !file2.delete()) {
                    HMSLog.e("FileUtil", "file delete failed.");
                }
                f37664a = true;
            }
            writeFile(file2, str + "|" + j3 + "|" + i3, 10240L);
        }
    }
}
