package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes28.dex */
public class an {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    static class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            if (!TextUtils.isEmpty(str) && !str.toLowerCase().endsWith(".lock")) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    static class b implements FilenameFilter {
        b() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            if (!TextUtils.isEmpty(str) && !str.toLowerCase().endsWith(".lock")) {
                return true;
            }
            return false;
        }
    }

    public static String a() {
        return Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL;
    }

    public static String b(Context context) {
        String c16 = ap.b(context).c("sp_client_report_status", "sp_client_report_key", "");
        if (TextUtils.isEmpty(c16)) {
            String a16 = ag.a(20);
            ap.b(context).e("sp_client_report_status", "sp_client_report_key", a16);
            return a16;
        }
        return c16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f5, code lost:
    
        if (r7 == null) goto L62;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(Context context, String str, String str2) {
        File file;
        RandomAccessFile randomAccessFile;
        Exception e16;
        if (context != null && str != null && str2 != null) {
            File file2 = new File(context.getFilesDir(), str2);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(context.getFilesDir(), str);
            if (!file3.exists()) {
                file3.mkdirs();
                return;
            }
            File[] listFiles = file3.listFiles(new a());
            if (listFiles != null && listFiles.length > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                FileLock fileLock = null;
                File file4 = null;
                RandomAccessFile randomAccessFile2 = null;
                for (File file5 : listFiles) {
                    if (file5 != null) {
                        try {
                        } catch (Exception e17) {
                            file = file4;
                            randomAccessFile = randomAccessFile2;
                            e16 = e17;
                        } catch (Throwable th5) {
                            th = th5;
                        }
                        if (!TextUtils.isEmpty(file5.getAbsolutePath())) {
                            file = new File(file5.getAbsolutePath() + ".lock");
                            try {
                                in.f(file);
                                randomAccessFile = new RandomAccessFile(file, "rw");
                            } catch (Exception e18) {
                                randomAccessFile = randomAccessFile2;
                                e16 = e18;
                            } catch (Throwable th6) {
                                th = th6;
                            }
                            try {
                                try {
                                    fileLock = randomAccessFile.getChannel().lock();
                                    File file6 = new File(file2.getAbsolutePath() + File.separator + file5.getName() + currentTimeMillis);
                                    try {
                                        in.i(file5, file6);
                                    } catch (IOException e19) {
                                        e19.printStackTrace();
                                        file5.delete();
                                        file6.delete();
                                    }
                                    file5.delete();
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e26) {
                                            jz4.c.q(e26);
                                        }
                                    }
                                    in.b(randomAccessFile);
                                } catch (Throwable th7) {
                                    th = th7;
                                    randomAccessFile2 = randomAccessFile;
                                    file4 = file;
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e27) {
                                            jz4.c.q(e27);
                                        }
                                    }
                                    in.b(randomAccessFile2);
                                    if (file4 != null) {
                                        file4.delete();
                                        throw th;
                                    }
                                    throw th;
                                }
                            } catch (Exception e28) {
                                e16 = e28;
                                jz4.c.q(e16);
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e29) {
                                        jz4.c.q(e29);
                                    }
                                }
                                in.b(randomAccessFile);
                            }
                            file.delete();
                            randomAccessFile2 = randomAccessFile;
                            file4 = file;
                        }
                    }
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e36) {
                            jz4.c.q(e36);
                        }
                    }
                    in.b(randomAccessFile2);
                    if (file4 != null) {
                        file4.delete();
                    }
                }
            }
        }
    }

    public static boolean d(Context context, String str) {
        File file = new File(str);
        long d16 = com.xiaomi.clientreport.manager.a.c(context).e().d();
        if (file.exists()) {
            try {
                if (file.length() <= d16) {
                    return true;
                }
            } catch (Exception e16) {
                jz4.c.q(e16);
            }
            return false;
        }
        in.f(file);
        return true;
    }

    @TargetApi(9)
    public static byte[] e(String str) {
        byte[] copyOf = Arrays.copyOf(aa.b(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    public static File[] f(Context context, String str) {
        return new File(context.getFilesDir(), str).listFiles(new b());
    }
}
