package com.tencent.luggage.wxa.ar;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b1 {
    public static boolean a(File[] fileArr, String str) {
        return a(fileArr, str, -1);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00cf A[Catch: IOException -> 0x00cb, TRY_LEAVE, TryCatch #6 {IOException -> 0x00cb, blocks: (B:53:0x00c4, B:46:0x00cf), top: B:52:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(String str, String str2) {
        ZipInputStream zipInputStream;
        BufferedOutputStream bufferedOutputStream;
        ZipInputStream zipInputStream2;
        String a16 = a(str);
        BufferedOutputStream bufferedOutputStream2 = null;
        bufferedOutputStream2 = null;
        bufferedOutputStream2 = null;
        bufferedOutputStream2 = null;
        ZipInputStream zipInputStream3 = null;
        boolean z16 = false;
        try {
            try {
                zipInputStream2 = new ZipInputStream(new BufferedInputStream(new FileInputStream(str2)));
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        String name = nextEntry.getName();
                        if (!name.contains("../") && !name.contains("..\\")) {
                            a(name, a16);
                            if (nextEntry.isDirectory()) {
                                new File(a16 + name).mkdirs();
                            } else {
                                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(a16 + name));
                                while (true) {
                                    try {
                                        int read = zipInputStream2.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream.write(bArr, 0, read);
                                    } catch (IOException e16) {
                                        e = e16;
                                        zipInputStream3 = zipInputStream2;
                                        try {
                                            x0.a("ZipUtil", "unZipFile, error", e);
                                            if (zipInputStream3 != null) {
                                                zipInputStream3.closeEntry();
                                                zipInputStream3.close();
                                            }
                                            if (bufferedOutputStream != null) {
                                                bufferedOutputStream.close();
                                            }
                                            return z16;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            zipInputStream = zipInputStream3;
                                            bufferedOutputStream2 = bufferedOutputStream;
                                            zipInputStream2 = zipInputStream;
                                            bufferedOutputStream = bufferedOutputStream2;
                                            if (zipInputStream2 != null) {
                                                try {
                                                    zipInputStream2.closeEntry();
                                                    zipInputStream2.close();
                                                } catch (IOException e17) {
                                                    x0.a("ZipUtil", "unZipFile, error", e17);
                                                    throw th;
                                                }
                                            }
                                            if (bufferedOutputStream != null) {
                                                bufferedOutputStream.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        if (zipInputStream2 != null) {
                                        }
                                        if (bufferedOutputStream != null) {
                                        }
                                        throw th;
                                    }
                                }
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                bufferedOutputStream2 = bufferedOutputStream;
                            }
                        }
                    }
                    z16 = true;
                    zipInputStream2.closeEntry();
                    zipInputStream2.close();
                    if (bufferedOutputStream2 != null) {
                        bufferedOutputStream2.close();
                    }
                } catch (IOException e18) {
                    e = e18;
                    bufferedOutputStream = bufferedOutputStream2;
                } catch (Throwable th7) {
                    th = th7;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (zipInputStream2 != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    throw th;
                }
            } catch (IOException e19) {
                e = e19;
                bufferedOutputStream = null;
            } catch (Throwable th8) {
                th = th8;
                zipInputStream = null;
                zipInputStream2 = zipInputStream;
                bufferedOutputStream = bufferedOutputStream2;
                if (zipInputStream2 != null) {
                }
                if (bufferedOutputStream != null) {
                }
                throw th;
            }
        } catch (IOException e26) {
            x0.a("ZipUtil", "unZipFile, error", e26);
        }
        return z16;
    }

    public static boolean a(File[] fileArr, String str, int i3) {
        ZipOutputStream zipOutputStream;
        boolean z16 = false;
        if (fileArr == null) {
            x0.f("ZipUtil", "zipFilesEx, fs is null");
            return false;
        }
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
            try {
                zipOutputStream.setLevel(i3);
                for (File file : fileArr) {
                    if (file != null && file.exists()) {
                        if (file.isDirectory()) {
                            a(zipOutputStream, file, file.getName() + File.separator);
                        } else {
                            a(zipOutputStream, file, "");
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            zipOutputStream = null;
        }
        try {
            zipOutputStream.flush();
            try {
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                return true;
            } catch (IOException e16) {
                x0.c("ZipUtil", "zipFilesEx, error:" + e16);
                return true;
            }
        } catch (Throwable th7) {
            z16 = true;
            th = th7;
            try {
                x0.a("ZipUtil", "zipFilesEx, error", th);
                return z16;
            } finally {
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.closeEntry();
                        zipOutputStream.close();
                    } catch (IOException e17) {
                        x0.c("ZipUtil", "zipFilesEx, error:" + e17);
                    }
                }
            }
        }
    }

    public static void a(ZipOutputStream zipOutputStream, File file, String str) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2 != null) {
                    if (file2.isDirectory()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(file.getName());
                        String str2 = File.separator;
                        sb5.append(str2);
                        sb5.append(file2.getName());
                        sb5.append(str2);
                        a(zipOutputStream, file2, sb5.toString());
                    } else {
                        a(zipOutputStream, file2, str);
                    }
                }
            }
            return;
        }
        byte[] bArr = new byte[2048];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        zipOutputStream.putNextEntry(new ZipEntry(str + file.getName()));
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                zipOutputStream.write(bArr, 0, read);
            } else {
                bufferedInputStream.close();
                return;
            }
        }
    }

    public static void a(String str, String str2) {
        String[] split = str.split("/");
        if (split.length <= 1) {
            return;
        }
        for (int i3 = 0; i3 < split.length - 1; i3++) {
            str2 = str2 + split[i3] + "/";
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
    }

    public static String a(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (str.endsWith("/")) {
            return str;
        }
        return str + '/';
    }
}
