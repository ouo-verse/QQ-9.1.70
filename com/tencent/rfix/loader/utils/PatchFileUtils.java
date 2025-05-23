package com.tencent.rfix.loader.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.tencent.rfix.loader.log.RFixLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes25.dex */
public class PatchFileUtils {
    public static final int MAX_EXTRACT_ATTEMPTS = 2;
    private static final String TAG = "RFix.FileUtils";

    public static boolean checkMd5AndExtractZipEntry(ZipFile zipFile, ZipEntry zipEntry, File file) throws IOException {
        String str;
        BufferedInputStream bufferedInputStream;
        String md5;
        RFixLog.i(TAG, String.format("checkMd5AndExtractZipEntry zipFile=%s zipEntry=%s extractToFile=%s", zipFile.getName(), zipEntry.getName(), file));
        BufferedInputStream bufferedInputStream2 = null;
        if (isLegalFile(file)) {
            str = PatchMD5Utils.getMD5(file);
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                md5 = PatchMD5Utils.getMD5(bufferedInputStream);
                closeQuietly(bufferedInputStream);
            } catch (Throwable th6) {
                th = th6;
                bufferedInputStream2 = bufferedInputStream;
                closeQuietly(bufferedInputStream2);
                throw th;
            }
        } else {
            md5 = null;
        }
        RFixLog.i(TAG, String.format("checkMd5AndExtractZipEntry srcMD5=%s destMD5=%s", md5, str));
        if (!TextUtils.isEmpty(md5) && TextUtils.equals(md5, str)) {
            RFixLog.i(TAG, "checkMd5AndExtractZipEntry ignore extract with same md5.");
            return true;
        }
        return extractZipEntry(zipFile, zipEntry, file, null);
    }

    @SuppressLint({"NewApi"})
    public static void closeQuietly(Object obj) {
        if (obj == null) {
            return;
        }
        try {
            if (obj instanceof Closeable) {
                ((Closeable) obj).close();
            } else if (obj instanceof AutoCloseable) {
                ((AutoCloseable) obj).close();
            } else {
                throw new IllegalArgumentException("obj: " + obj + " cannot be closed.");
            }
        } catch (Throwable unused) {
        }
    }

    private static void copyEntry(ZipFile zipFile, ZipEntry zipEntry, File file) throws IOException {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream = null;
        }
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    bufferedOutputStream.write(bArr, 0, read);
                } else {
                    closeQuietly(bufferedOutputStream);
                    closeQuietly(bufferedInputStream);
                    return;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            bufferedOutputStream2 = bufferedOutputStream;
            closeQuietly(bufferedOutputStream2);
            closeQuietly(bufferedInputStream);
            throw th;
        }
    }

    public static void copyFileUsingStream(File file, File file2) throws IOException {
        FileOutputStream fileOutputStream;
        if (!isLegalFile(file) || file2 == null || file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            return;
        }
        makeParent(file2);
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2, false);
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
            }
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        closeQuietly(fileInputStream2);
                        closeQuietly(fileOutputStream);
                        return;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = fileInputStream2;
                closeQuietly(fileInputStream);
                closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream = null;
        }
    }

    public static boolean deleteFile(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!deleteFile(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean extractZip(File file, String str, File file2) {
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement = entries.nextElement();
                        String name = nextElement.getName();
                        if (!TextUtils.isEmpty(name) && name.startsWith(str)) {
                            int lastIndexOf = str.lastIndexOf(47);
                            if (lastIndexOf < 0) {
                                lastIndexOf = 0;
                            }
                            if (!extractZipEntry(zipFile2, nextElement, new File(file2, name.substring(lastIndexOf)), null)) {
                                RFixLog.e(TAG, "extractZip fail.");
                                closeQuietly(zipFile2);
                                return false;
                            }
                        }
                    }
                    closeQuietly(zipFile2);
                    return true;
                } catch (IOException e16) {
                    e = e16;
                    zipFile = zipFile2;
                    RFixLog.e(TAG, "extractZip ", e);
                    closeQuietly(zipFile);
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    zipFile = zipFile2;
                    closeQuietly(zipFile);
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static boolean extractZipEntry(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException {
        int i3 = 0;
        boolean z16 = false;
        while (i3 < 2 && !z16) {
            i3++;
            RFixLog.d(TAG, "extractZipEntry path: " + file.getPath());
            if (zipEntry.isDirectory()) {
                if (file.exists()) {
                    return true;
                }
                return file.mkdirs();
            }
            makeParent(file);
            copyEntry(zipFile, zipEntry, file);
            if (str != null) {
                z16 = PatchMD5Utils.verifyFileMd5(file, str);
            } else {
                z16 = true;
            }
            if (!z16 && (!file.delete() || file.exists())) {
                RFixLog.e(TAG, "extractZipEntry extract fail, delete path: " + file.getPath());
            }
        }
        return z16;
    }

    public static File getPatchDirectory(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        return new File(applicationInfo.dataDir, RFixConstants.PATCH_DIRECTORY_NAME);
    }

    public static File getPatchLastCrashFile(Context context) {
        File patchTempDirectory = getPatchTempDirectory(context);
        if (patchTempDirectory == null) {
            return null;
        }
        return new File(patchTempDirectory, RFixConstants.PATCH_TEMP_LAST_CRASH_NAME);
    }

    public static File getPatchTempDirectory(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        return new File(applicationInfo.dataDir, RFixConstants.PATCH_TEMP_DIRECTORY_NAME);
    }

    public static File getPatchVersionDirectory(String str, String str2) {
        if (str2 != null && str2.length() == 32) {
            return new File(str + "/" + (RFixConstants.PATCH_NAME_PREFIX + str2.substring(0, 8)));
        }
        return null;
    }

    public static File getPatchVersionFile(String str, String str2) {
        if (str2 != null && str2.length() == 32) {
            return new File(getPatchVersionDirectory(str, str2), RFixConstants.PATCH_NAME_PREFIX + str2.substring(0, 8) + ".apk");
        }
        return null;
    }

    public static boolean isLegalFile(File file) {
        if (file != null && file.exists() && file.canRead() && file.isFile() && file.length() > 0) {
            return true;
        }
        return false;
    }

    public static String loadZipEntry(JarFile jarFile, JarEntry jarEntry) throws Exception {
        BufferedInputStream bufferedInputStream;
        StringBuilder sb5 = new StringBuilder();
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb5.append(new String(bArr, 0, read));
                } else {
                    closeQuietly(bufferedInputStream);
                    return sb5.toString();
                }
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream2 = bufferedInputStream;
            closeQuietly(bufferedInputStream2);
            throw th;
        }
    }

    private static void makeParent(File file) {
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
    }
}
