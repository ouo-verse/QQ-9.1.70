package com.tencent.mobileqq.mini.appbrand.utils;

import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes33.dex */
public class FileUtils {
    public static final String TAG = "MiniAppFileUtils";
    private static char[] hexChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static boolean copyFile(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        try {
            return copyFile(file, createFile(str2));
        } catch (IOException e16) {
            QLog.d(TAG, 2, "copy fail from " + str + " to " + str2 + " " + e16.getMessage());
            return false;
        }
    }

    public static File createFile(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (file.getParentFile().mkdirs()) {
                    file.createNewFile();
                }
            } else {
                file.createNewFile();
            }
        }
        return file;
    }

    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    public static String encodeFile2HexStr(String str) {
        return HexUtil.bytes2HexStr(encodeFile(str));
    }

    public static byte[] fileToBytes(File file) {
        BufferedInputStream bufferedInputStream;
        if (!file.exists()) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                long length = file.length();
                if (length <= TTL.MAX_VALUE && length > 0) {
                    int i3 = (int) length;
                    byte[] bArr = new byte[i3];
                    int i16 = 0;
                    while (i16 < i3) {
                        int read = bufferedInputStream.read(bArr, i16, i3 - i16);
                        if (read < 0) {
                            break;
                        }
                        i16 += read;
                    }
                    if (i16 < i3 && QLog.isColorLevel()) {
                        QLog.d("FileUtils", 2, "Could not completely read file " + file);
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                    return bArr;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("FileUtils", 2, "return null. File length=" + length);
                }
                try {
                    bufferedInputStream.close();
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
                return null;
            } catch (Throwable unused) {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("FileUtils", 2, "Failed to read file " + file);
                    }
                    return null;
                } finally {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
            bufferedInputStream = null;
        }
    }

    public static long getFileOrFolderSize(String str) {
        File[] listFiles;
        long length;
        File file = new File(str);
        long j3 = 0;
        if (file.exists()) {
            if (file.isFile()) {
                return file.length();
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2 != null && file2.exists()) {
                        if (file2.isDirectory()) {
                            length = getFileOrFolderSize(file2.getAbsolutePath());
                        } else if (file2.isFile()) {
                            length = file2.length();
                        }
                        j3 += length;
                    }
                }
            }
        }
        return j3;
    }

    public static String getFileSHA1(String str) {
        try {
            return getHash(str, "SHA1");
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static long getFileSizes(String str) {
        try {
            return new File(str).length();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String toHexString(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (int i3 = 0; i3 < bArr.length; i3++) {
            sb5.append(hexChar[(bArr[i3] & 240) >>> 4]);
            sb5.append(hexChar[bArr[i3] & RegisterType.DOUBLE_HI]);
        }
        return sb5.toString();
    }

    public static boolean writeFile(byte[] bArr, String str) {
        return writeFile(bArr, str, false);
    }

    public static byte[] encodeFile(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[16384];
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                } catch (IOException unused) {
                    fileInputStream.close();
                    return null;
                } catch (Throwable th5) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                    }
                    throw th5;
                }
            }
            byte[] digest = messageDigest.digest();
            try {
                fileInputStream.close();
            } catch (IOException unused3) {
            }
            return digest;
        } catch (FileNotFoundException | IOException | NoSuchAlgorithmException unused4) {
            return null;
        }
    }

    private static String getHash(String str, String str2) throws Exception {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            byte[] bArr = new byte[4096];
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (IOException unused) {
                    }
                }
            }
            bufferedInputStream.close();
            return toHexString(messageDigest.digest());
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static boolean writeFile(byte[] bArr, String str, boolean z16) {
        return writeFile(bArr, str, z16, bArr.length);
    }

    public static boolean writeFile(String str, String str2) {
        return writeFile(str, str2, true);
    }

    public static boolean writeFile(String str, String str2, boolean z16) {
        boolean z17;
        FileOutputStream fileOutputStream;
        File file = new File(str);
        if (!file.exists()) {
            try {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            } catch (IOException unused) {
                z17 = false;
            }
        }
        z17 = true;
        try {
            fileOutputStream = new FileOutputStream(file, false);
        } catch (FileNotFoundException unused2) {
            fileOutputStream = null;
            z17 = false;
        }
        if (z16) {
            try {
                str2 = str2 + "\r\n";
            } catch (IOException unused3) {
                z17 = false;
            }
        }
        if (fileOutputStream != null) {
            fileOutputStream.write(str2.getBytes());
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException unused4) {
                z17 = false;
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException unused5) {
                return false;
            }
        }
        return z17;
    }

    public static long deleteDirectory(String str) {
        long j3 = 0;
        if (str != null && str.trim().length() != 0) {
            File file = new File(str);
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (int i3 = 0; i3 < listFiles.length; i3++) {
                    if (listFiles[i3].isDirectory()) {
                        j3 += deleteDirectory(listFiles[i3].getAbsolutePath());
                    } else {
                        j3 += listFiles[i3].length();
                        listFiles[i3].delete();
                    }
                }
            }
            file.delete();
        }
        return j3;
    }

    public static long deleteFilesInDirectory(String str) {
        File[] listFiles;
        long j3 = 0;
        if (str != null && str.trim().length() != 0 && (listFiles = new File(str).listFiles()) != null && listFiles.length > 0) {
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                if (listFiles[i3].isDirectory()) {
                    j3 += deleteDirectory(listFiles[i3].getAbsolutePath());
                } else {
                    j3 += listFiles[i3].length();
                    listFiles[i3].delete();
                }
            }
        }
        return j3;
    }

    public static boolean fileExists(String str) {
        return str != null && new File(str).exists();
    }

    public static boolean copyFile(File file, File file2) {
        return copyFile(file, file2, false);
    }

    public static long delete(String str, boolean z16) {
        long j3 = 0;
        if (str == null) {
            return 0L;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 0L;
        }
        if (file.isFile()) {
            long length = file.length();
            file.delete();
            return length;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0L;
        }
        for (File file2 : listFiles) {
            j3 += delete(file2.getAbsolutePath(), z16);
        }
        if (!z16) {
            file.delete();
        }
        return j3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d8, code lost:
    
        if (r9 == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x009f, code lost:
    
        com.tencent.qphone.base.util.QLog.e(com.tencent.mobileqq.mini.appbrand.utils.FileUtils.TAG, 1, "copyFile error, ", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x009d, code lost:
    
        if (r9 == false) goto L92;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean copyFile(File file, File file2, boolean z16) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (file2.exists()) {
                    file2.delete();
                }
                if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                fileOutputStream = new FileOutputStream((File) file2);
                try {
                    file2 = new BufferedInputStream(new FileInputStream(file));
                } catch (IOException e16) {
                    e = e16;
                    file2 = 0;
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    file2 = 0;
                } catch (Throwable th5) {
                    th = th5;
                    file2 = 0;
                }
            } catch (IOException e18) {
                e = e18;
                bufferedInputStream2 = null;
            } catch (OutOfMemoryError e19) {
                e = e19;
                bufferedInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                file2 = 0;
            }
            try {
                byte[] buf = ByteArrayPool.getGenericInstance().getBuf(4096);
                while (true) {
                    int read = file2.read(buf);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(buf, 0, read);
                    fileOutputStream.flush();
                }
                ByteArrayPool.getGenericInstance().returnBuf(buf);
                try {
                    fileOutputStream.close();
                } catch (IOException e26) {
                    if (z16) {
                        QLog.e(TAG, 1, "copyFile error, ", e26);
                    }
                }
                try {
                    file2.close();
                    return true;
                } catch (IOException e27) {
                    if (!z16) {
                        return true;
                    }
                    QLog.e(TAG, 1, "copyFile error, ", e27);
                    return true;
                }
            } catch (IOException e28) {
                e = e28;
                fileOutputStream2 = fileOutputStream;
                bufferedInputStream2 = file2;
                if (z16) {
                    QLog.e(TAG, 1, "copyFile error, ", e);
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e29) {
                        if (z16) {
                            QLog.e(TAG, 1, "copyFile error, ", e29);
                        }
                    }
                }
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e36) {
                        e = e36;
                    }
                }
                return false;
            } catch (OutOfMemoryError e37) {
                e = e37;
                fileOutputStream2 = fileOutputStream;
                bufferedInputStream = file2;
                if (z16) {
                    QLog.e(TAG, 1, "copyFile error, ", e);
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e38) {
                        if (z16) {
                            QLog.e(TAG, 1, "copyFile error, ", e38);
                        }
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e39) {
                        e = e39;
                    }
                }
                return false;
            } catch (Throwable th7) {
                th = th7;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e46) {
                        if (z16) {
                            QLog.e(TAG, 1, "copyFile error, ", e46);
                        }
                    }
                }
                if (file2 != 0) {
                    try {
                        file2.close();
                    } catch (IOException e47) {
                        if (z16) {
                            QLog.e(TAG, 1, "copyFile error, ", e47);
                        }
                    }
                }
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public static boolean moveFile(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        try {
            copyFile(file, createFile(str2));
            file.delete();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean rename(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.renameTo(new File(str2));
        }
        return false;
    }

    public static boolean writeFile(byte[] bArr, String str, boolean z16, int i3) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        boolean z17 = false;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (!file.exists()) {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file, z16);
            } catch (IOException unused) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                fileOutputStream.write(bArr, 0, i3);
                fileOutputStream.flush();
                fileOutputStream.close();
                z17 = true;
            } catch (IOException unused2) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                return z17;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (IOException unused4) {
        }
        return z17;
    }
}
