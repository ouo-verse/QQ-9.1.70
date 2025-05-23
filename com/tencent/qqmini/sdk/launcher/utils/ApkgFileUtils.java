package com.tencent.qqmini.sdk.launcher.utils;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ApkgFileUtils {
    public static String TAG = "ApkgFileUtils";

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class WxapkgFile {
        public int length;
        public String name;
        public int start;

        public WxapkgFile(String str, int i3, int i16) {
            this.name = str;
            this.start = i3;
            this.length = i16;
        }

        public String toString() {
            return "WxapkgFile{name='" + this.name + "', start=" + this.start + ", length=" + this.length + '}';
        }
    }

    public static HashMap<String, WxapkgFile> getFileMapFromApkg(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        if (!isApkgFileExist(file)) {
            return null;
        }
        HashMap<String, WxapkgFile> hashMap = new HashMap<>();
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "rsf close fail", e16);
            e16.printStackTrace();
        }
        try {
        } catch (Throwable th6) {
            th = th6;
            randomAccessFile2 = randomAccessFile;
            try {
                QMLog.e(TAG, "getFileMapFromApkg fail", th);
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
                return hashMap;
            } catch (Throwable th7) {
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Exception e17) {
                        QMLog.e(TAG, "rsf close fail", e17);
                        e17.printStackTrace();
                    }
                }
                throw th7;
            }
        }
        if (randomAccessFile.readByte() == -66) {
            randomAccessFile.seek(14L);
            int readInt = randomAccessFile.readInt();
            for (int i3 = 0; i3 < readInt; i3++) {
                int readInt2 = randomAccessFile.readInt();
                byte[] bArr = new byte[readInt2];
                randomAccessFile.read(bArr, 0, readInt2);
                String absolutePath = new File(new String(bArr, 0, readInt2)).getAbsolutePath();
                if (absolutePath.charAt(0) == '/') {
                    absolutePath = absolutePath.substring(1);
                }
                hashMap.put(absolutePath, new WxapkgFile(absolutePath, randomAccessFile.readInt(), randomAccessFile.readInt()));
            }
            randomAccessFile.close();
            return hashMap;
        }
        throw new RuntimeException("File type error");
    }

    public static boolean isApkgFileExist(File file) throws IOException {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (file.canRead()) {
                    return true;
                }
                throw new IOException("File '" + file + "' cannot be read");
            }
            throw new IOException("File '" + file + "' exists but is a directory");
        }
        throw new FileNotFoundException("File '" + file + "' does not exist");
    }

    public static byte[] readApkgToByte(File file, int i3, int i16) throws IOException {
        RandomAccessFile randomAccessFile;
        if (!isApkgFileExist(file)) {
            QMLog.e(TAG, "readApkgToByte !isApkgFileExist");
            return null;
        }
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th5) {
            th = th5;
            randomAccessFile = null;
        }
        try {
            randomAccessFile.seek(i3);
            byte[] bArr = new byte[i16];
            randomAccessFile.read(bArr, 0, i16);
            randomAccessFile.close();
            return bArr;
        } catch (Throwable th6) {
            th = th6;
            try {
                QMLog.e(TAG, "readApkgToByte fail", th);
                return null;
            } finally {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            }
        }
    }

    public static String readApkgToStr(File file, int i3, int i16) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return readApkgToString(file, i3, i16);
                }
            } catch (Throwable th5) {
                QMLog.e(TAG, "readApkgToStr fail", th5);
                return "";
            }
        }
        QMLog.e(TAG, "readApkgToStr file is not exists:" + file);
        return null;
    }

    public static ByteArrayInputStream readApkgToStream(File file, int i3, int i16) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return readToStream(file, i3, i16);
                }
            } catch (Throwable th5) {
                QMLog.e(TAG, "readToStream fail", th5);
            }
        }
        return null;
    }

    public static String readApkgToString(File file, int i3, int i16) throws IOException {
        byte[] readApkgToByte = readApkgToByte(file, i3, i16);
        if (readApkgToByte != null) {
            return new String(readApkgToByte);
        }
        QMLog.e(TAG, "readApkgToString got null");
        return null;
    }

    public static ByteArrayInputStream readToStream(File file, int i3, int i16) throws IOException {
        byte[] readApkgToByte = readApkgToByte(file, i3, i16);
        if (readApkgToByte != null) {
            return new ByteArrayInputStream(readApkgToByte);
        }
        return null;
    }
}
