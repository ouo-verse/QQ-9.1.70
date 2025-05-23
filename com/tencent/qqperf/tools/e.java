package com.tencent.qqperf.tools;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e {
    public static int a() {
        File[] listFiles;
        File b16 = b();
        if (b16 == null || (listFiles = b16.listFiles()) == null) {
            return 0;
        }
        return listFiles.length;
    }

    @Nullable
    private static File b() {
        File file;
        Throwable th5;
        try {
            file = new File("/proc/self/fd");
        } catch (Throwable th6) {
            file = null;
            th5 = th6;
        }
        try {
            if (!file.exists()) {
                return null;
            }
            if (!file.isDirectory()) {
                return null;
            }
            return file;
        } catch (Throwable th7) {
            th5 = th7;
            try {
                QLog.e("FileDescriptorHelper", 1, "getFDInfoFile has error!", th5);
            } catch (Throwable unused) {
            }
            return file;
        }
    }

    public static int c() {
        BufferedReader bufferedReader;
        Throwable th5;
        String readLine;
        int i3 = 0;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("/proc/self/limits")));
            try {
                do {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine != null) {
                        }
                        break;
                    } catch (Throwable th6) {
                        th5 = th6;
                        try {
                            QLog.e("FileDescriptorHelper", 1, "getMaxFdLimit has error!", th5);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e16) {
                                    QLog.w("FileDescriptorHelper", 2, "getMaxFdLimit close reader has IOException", e16);
                                }
                            }
                            return 0;
                        } catch (Throwable unused) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e17) {
                                    QLog.w("FileDescriptorHelper", 2, "getMaxFdLimit close reader has IOException", e17);
                                }
                            }
                            return 0;
                        }
                    }
                } while (!readLine.contains("Max open files"));
                break;
                bufferedReader.close();
            } catch (IOException e18) {
                QLog.w("FileDescriptorHelper", 2, "getMaxFdLimit close reader has IOException", e18);
            }
            i3 = Integer.parseInt(readLine.trim().split("\\s+")[3]);
            return i3;
        } catch (Throwable th7) {
            bufferedReader = null;
            th5 = th7;
        }
    }
}
