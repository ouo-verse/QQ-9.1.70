package com.gcore.abase.utils;

import android.util.Log;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes2.dex */
public class FileUtils {
    private static final String TAG = "ABase.FileUtils";
    private static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    private static String convertHashToString(byte[] bArr) {
        String str = "";
        for (byte b16 : bArr) {
            str = str + Integer.toString((b16 & 255) + 256, 16).substring(1);
        }
        return str.toLowerCase();
    }

    public static void copyFileUsingStream(File file, File file2) throws IOException {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        if (!isLegalFile(file) || file2 == null || file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            return;
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2, false);
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
            }
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    closeQuietly(fileInputStream);
                    closeQuietly(fileOutputStream);
                    return;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            fileInputStream2 = fileInputStream;
            closeQuietly(fileInputStream2);
            closeQuietly(fileOutputStream);
            throw th;
        }
    }

    public static final boolean deleteDir(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            safeDeleteFile(file);
        } else if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                deleteDir(file2);
            }
            safeDeleteFile(file);
        }
        return file.delete();
    }

    public static String filePartToSHA1(String str, long j3, long j16) {
        FileInputStream fileInputStream;
        RandomAccessFile randomAccessFile;
        MessageDigest messageDigest;
        int read;
        RandomAccessFile randomAccessFile2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
                randomAccessFile = new RandomAccessFile(str, "r");
            } catch (Exception unused) {
                randomAccessFile = null;
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
            randomAccessFile = null;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            randomAccessFile.seek(j3);
            for (int i3 = 0; i3 < j16 / 1024 && (read = randomAccessFile.read(bArr)) != -1; i3++) {
                messageDigest.update(bArr, 0, read);
            }
            String convertHashToString = convertHashToString(messageDigest.digest());
            closeQuietly(randomAccessFile);
            closeQuietly(fileInputStream);
            return convertHashToString;
        } catch (Exception unused3) {
            closeQuietly(randomAccessFile);
            closeQuietly(fileInputStream);
            return null;
        } catch (Throwable th7) {
            th = th7;
            randomAccessFile2 = randomAccessFile;
            closeQuietly(randomAccessFile2);
            closeQuietly(fileInputStream);
            throw th;
        }
    }

    public static String fileToSHA1(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception unused) {
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            byte[] bArr = new byte[1024];
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
            int i3 = 0;
            while (i3 != -1) {
                i3 = fileInputStream.read(bArr);
                if (i3 > 0) {
                    messageDigest.update(bArr, 0, i3);
                }
            }
            String convertHashToString = convertHashToString(messageDigest.digest());
            closeQuietly(fileInputStream);
            return convertHashToString;
        } catch (Exception unused2) {
            closeQuietly(fileInputStream);
            return null;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = fileInputStream;
            closeQuietly(fileInputStream2);
            throw th;
        }
    }

    public static String getMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr = new char[digest.length * 2];
            int i3 = 0;
            for (byte b16 : digest) {
                int i16 = i3 + 1;
                char[] cArr2 = hexDigits;
                cArr[i3] = cArr2[(b16 >>> 4) & 15];
                i3 = i16 + 1;
                cArr[i16] = cArr2[b16 & RegisterType.DOUBLE_HI];
            }
            return new String(cArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final boolean isLegalFile(File file) {
        if (file != null && file.exists() && file.canRead() && file.isFile() && file.length() > 0) {
            return true;
        }
        return false;
    }

    public static String loadDigestes(JarFile jarFile, JarEntry jarEntry) throws Exception {
        StringBuilder sb5 = new StringBuilder();
        BufferedInputStream bufferedInputStream = null;
        try {
            InputStream inputStream = jarFile.getInputStream(jarEntry);
            byte[] bArr = new byte[16384];
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            while (true) {
                try {
                    int read = bufferedInputStream2.read(bArr);
                    if (read > 0) {
                        sb5.append(new String(bArr, 0, read));
                    } else {
                        closeQuietly(bufferedInputStream2);
                        return sb5.toString();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = bufferedInputStream2;
                    closeQuietly(bufferedInputStream);
                    throw th;
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static String readFileToString(File file) {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    String readStreamToString = readStreamToString(fileInputStream2);
                    closeQuietly(fileInputStream2);
                    return readStreamToString;
                } catch (IOException e16) {
                    e = e16;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    Log.e(TAG, e.getMessage());
                    closeQuietly(fileInputStream);
                    return "";
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static String readStreamToString(InputStream inputStream) {
        Throwable th5;
        BufferedReader bufferedReader;
        IOException e16;
        StringBuilder sb5;
        try {
            try {
                sb5 = new StringBuilder(inputStream.available() + 10);
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            } catch (IOException e17) {
                bufferedReader = null;
                e16 = e17;
            } catch (Throwable th6) {
                th5 = th6;
                closeQuietly(null);
                closeQuietly(inputStream);
                throw th5;
            }
            try {
                char[] cArr = new char[4096];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (read > 0) {
                        sb5.append(cArr, 0, read);
                    } else {
                        String sb6 = sb5.toString();
                        closeQuietly(bufferedReader);
                        closeQuietly(inputStream);
                        return sb6;
                    }
                }
            } catch (IOException e18) {
                e16 = e18;
                e16.printStackTrace();
                Log.e(TAG, e16.getMessage());
                closeQuietly(bufferedReader);
                closeQuietly(inputStream);
                return "";
            }
        } catch (Throwable th7) {
            th5 = th7;
            closeQuietly(null);
            closeQuietly(inputStream);
            throw th5;
        }
    }

    public static final boolean safeDeleteFile(File file) {
        boolean z16 = true;
        if (file == null) {
            return true;
        }
        if (file.exists()) {
            Log.i(TAG, "safeDeleteFile, try to delete path: " + file.getPath());
            z16 = file.delete();
            if (!z16) {
                Log.e(TAG, "Failed to delete file, try to delete when exit. path: " + file.getPath());
                file.deleteOnExit();
            }
        }
        return z16;
    }

    public static boolean verifyFileMd5(File file, String str) {
        String md5;
        if (str == null || (md5 = getMD5(file)) == null) {
            return false;
        }
        return str.equals(md5);
    }

    public static final String getMD5(InputStream inputStream) {
        int i3;
        if (inputStream == null) {
            return null;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            StringBuilder sb5 = new StringBuilder(32);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            for (byte b16 : messageDigest.digest()) {
                sb5.append(Integer.toString((b16 & 255) + 256, 16).substring(1));
            }
            return sb5.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getMD5(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception unused) {
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                String md5 = getMD5(fileInputStream);
                closeQuietly(fileInputStream);
                return md5;
            } catch (Exception unused2) {
                closeQuietly(fileInputStream);
                return null;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream2 = fileInputStream;
                closeQuietly(fileInputStream2);
                throw th;
            }
        }
        return null;
    }
}
