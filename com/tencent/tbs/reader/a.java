package com.tencent.tbs.reader;

import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import re4.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    public static void a(File file) throws IOException, IllegalArgumentException {
        File[] fileArr;
        if (file == null) {
            return;
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                IOException e16 = null;
                try {
                    fileArr = file.listFiles();
                } catch (Error e17) {
                    e17.printStackTrace();
                    fileArr = null;
                }
                if (fileArr != null) {
                    for (File file2 : fileArr) {
                        try {
                            b(file2);
                        } catch (IOException e18) {
                            e16 = e18;
                        }
                    }
                    if (e16 == null) {
                        return;
                    } else {
                        throw e16;
                    }
                }
                throw new IOException("Failed to list contents of " + file);
            }
            throw new IllegalArgumentException(file + " is not a directory");
        }
        throw new IllegalArgumentException(file + " does not exist");
    }

    public static void b(File file) throws IOException, IllegalArgumentException {
        if (file == null) {
            return;
        }
        if (file.isDirectory() && file.getCanonicalPath().equals(file.getAbsolutePath())) {
            a(file);
        }
        boolean exists = file.exists();
        if (!file.delete()) {
            if (!exists) {
                throw new FileNotFoundException("File does not exist: " + file);
            }
            throw new IOException("Unable to delete file: " + file);
        }
    }

    public static void c(File file) {
        if (!file.exists()) {
            if (!file.mkdirs()) {
                String str = "Failed to create non-exist directory " + file.getAbsolutePath();
                Log.e("ReaderUtils", str);
                b.b("ReaderUtils", str);
                return;
            }
            return;
        }
        if (!file.isDirectory()) {
            if (!file.delete() || !file.mkdirs()) {
                String str2 = "Failed to create namesake directory " + file.getAbsolutePath();
                Log.e("ReaderUtils", str2);
                b.b("ReaderUtils", str2);
            }
        }
    }
}
