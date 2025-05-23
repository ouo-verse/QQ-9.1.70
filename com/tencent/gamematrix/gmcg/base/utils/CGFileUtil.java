package com.tencent.gamematrix.gmcg.base.utils;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGFileUtil {
    public static float convertToGb(long j3) {
        return ((float) j3) / 1.07374182E9f;
    }

    public static float convertToKb(long j3) {
        return ((float) j3) / 1024.0f;
    }

    public static float convertToMb(long j3) {
        return ((float) j3) / 1048576.0f;
    }

    public static boolean delete(File file) {
        if (file == null) {
            return true;
        }
        if (file.isFile()) {
            return deleteFile(file.getAbsolutePath());
        }
        if (file.isDirectory()) {
            return deleteDirectory(file);
        }
        return file.delete();
    }

    public static boolean deleteDirectory(File file) {
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                deleteDirectory(file2);
            }
        }
        return file.delete();
    }

    public static boolean deleteFile(String str) {
        return deleteFile(new File(str));
    }

    public static String formatFileSize(long j3) {
        if (j3 < 1024) {
            return j3 + " B";
        }
        double d16 = j3;
        int log = (int) (Math.log(d16) / Math.log(1024.0d));
        return String.format(Locale.getDefault(), "%.1f %sB", Double.valueOf(d16 / Math.pow(1024.0d, log)), "KMGTPE".charAt(log - 1) + "");
    }

    public static long getAvailableExternalMemorySize() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        }
        return 0L;
    }

    public static long getAvailableInternalMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }

    public static long getFileSize(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return file.length();
        }
        return 0L;
    }

    public static String getNameWithoutSuffix(File file) {
        if (file == null) {
            return "";
        }
        String name = file.getName();
        String[] split = name.split("\\.");
        if (split.length < 2) {
            return name;
        }
        return name.replace("." + split[split.length - 1], "");
    }

    public static long getTotalExternalMemorySize() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        }
        return 0L;
    }

    public static long getTotalInternalMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
    }

    public static boolean unzip(String str, String str2) {
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            ZipFile zipFile = new ZipFile(str);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory()) {
                    InputStream inputStream = zipFile.getInputStream(nextElement);
                    FileOutputStream fileOutputStream = new FileOutputStream(str2 + File.separator + nextElement.getName());
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();
                } else {
                    new File(str2 + File.separator + nextElement.getName()).mkdirs();
                }
            }
            zipFile.close();
            return true;
        } catch (IOException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static boolean deleteFile(File file) {
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }
}
