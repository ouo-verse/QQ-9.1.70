package com.tencent.open.base;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* compiled from: P */
/* loaded from: classes22.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    protected static final String f341038a = File.separator;

    public static void a(File file, File file2) throws Exception {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new CheckedOutputStream(new FileOutputStream(file2), new CRC32())));
        zipOutputStream.setLevel(0);
        c(file, zipOutputStream, "", false);
        zipOutputStream.flush();
        zipOutputStream.close();
    }

    public static void b(File file, String str) throws Exception {
        a(file, new File(str));
    }

    protected static void c(File file, ZipOutputStream zipOutputStream, String str, boolean z16) throws Exception {
        if (file.isDirectory()) {
            e(file, zipOutputStream, str, z16);
        } else {
            f(file, zipOutputStream, str);
        }
    }

    public static void d(String str, String str2) throws Exception {
        b(new File(str), str2);
    }

    protected static void e(File file, ZipOutputStream zipOutputStream, String str, boolean z16) throws Exception {
        String str2;
        String str3;
        File[] listFiles = file.listFiles();
        Arrays.sort(listFiles);
        if (listFiles.length == 0) {
            if (z16) {
                str3 = str + file.getName() + f341038a;
            } else {
                str3 = str;
            }
            ZipEntry zipEntry = new ZipEntry(str3);
            zipEntry.setTime(0L);
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.closeEntry();
        }
        for (File file2 : listFiles) {
            if (z16) {
                str2 = str + file.getName() + f341038a;
            } else {
                str2 = str;
            }
            c(file2, zipOutputStream, str2, true);
        }
    }

    protected static void f(File file, ZipOutputStream zipOutputStream, String str) throws Exception {
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                ZipEntry zipEntry = new ZipEntry(str + file.getName());
                zipEntry.setTime(0L);
                zipOutputStream.putNextEntry(zipEntry);
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = bufferedInputStream2.read(bArr, 0, 8192);
                        if (read != -1) {
                            zipOutputStream.write(bArr, 0, read);
                        } else {
                            zipOutputStream.closeEntry();
                            bufferedInputStream2.close();
                            return;
                        }
                    }
                } catch (Exception e16) {
                    e = e16;
                    bufferedInputStream = bufferedInputStream2;
                    throw new Exception(e);
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }
}
