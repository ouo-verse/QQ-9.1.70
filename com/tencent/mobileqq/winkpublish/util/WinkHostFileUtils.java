package com.tencent.mobileqq.winkpublish.util;

import cooperation.qzone.util.FileUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkHostFileUtils {
    public static boolean copyFile(File file, File file2) {
        return FileUtils.copyFile(file, file2);
    }

    public static void createFileIfNotExits(String str) {
        com.tencent.mobileqq.utils.FileUtils.createFileIfNotExits(str);
    }

    public static void delete(String str, boolean z16) {
        com.tencent.mobileqq.utils.FileUtils.delete(str, z16);
    }

    public static void deleteDirectory(String str) {
        com.tencent.mobileqq.utils.FileUtils.deleteDirectory(str);
    }

    public static void deleteFile(File file) {
        FileUtils.deleteFile(file);
    }

    public static String estimateFileType(String str) {
        return com.tencent.mobileqq.utils.FileUtils.estimateFileType(str);
    }

    public static boolean fileExists(String str) {
        return com.tencent.mobileqq.utils.FileUtils.fileExists(str);
    }

    public static boolean fileExistsAndNotEmpty(String str) {
        return com.tencent.mobileqq.utils.FileUtils.fileExistsAndNotEmpty(str);
    }

    public static boolean isFileJPEG(String str) {
        return estimateFileType(str).equals("jpg");
    }

    public static String readFileContent(File file) {
        return com.tencent.mobileqq.utils.FileUtils.readFileContent(file);
    }

    public static boolean unzip(File file, File file2) {
        return FileUtils.unzip(file, file2);
    }
}
