package com.tencent.libra.extension.gif;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes7.dex */
public class i {
    public static boolean a(File file) {
        RandomAccessFile randomAccessFile;
        if (file != null && file.exists()) {
            RandomAccessFile randomAccessFile2 = null;
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
            } catch (Exception unused) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                byte[] bArr = new byte[3];
                randomAccessFile.read(bArr);
                if (bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70) {
                    randomAccessFile.close();
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                    return true;
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused3) {
                }
                return false;
            } catch (Exception unused4) {
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException unused5) {
                    }
                }
                return false;
            } catch (Throwable th6) {
                th = th6;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException unused6) {
                    }
                }
                throw th;
            }
        }
        return false;
    }
}
