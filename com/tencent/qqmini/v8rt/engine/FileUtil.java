package com.tencent.qqmini.v8rt.engine;

import java.io.File;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FileUtil {
    public static boolean deleteFile(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                deleteFile(file2);
            }
        }
        return file.delete();
    }

    public static void deleteSubFile(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                deleteFile(file2);
            }
        }
    }
}
