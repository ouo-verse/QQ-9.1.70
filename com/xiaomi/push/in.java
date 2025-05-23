package com.xiaomi.push;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* compiled from: P */
/* loaded from: classes28.dex */
public class in {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f389425a = {"jpg", "png", "bmp", "gif", "webp"};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.isDirectory();
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0064: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:101), block:B:22:0x0064 */
    public static String a(File file) {
        InputStreamReader inputStreamReader;
        Closeable closeable;
        StringWriter stringWriter = new StringWriter();
        Closeable closeable2 = null;
        try {
            try {
                inputStreamReader = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)));
            } catch (IOException e16) {
                e = e16;
                inputStreamReader = null;
            } catch (Throwable th5) {
                th = th5;
                b(closeable2);
                b(stringWriter);
                throw th;
            }
            try {
                char[] cArr = new char[2048];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        stringWriter.write(cArr, 0, read);
                    } else {
                        String stringWriter2 = stringWriter.toString();
                        b(inputStreamReader);
                        b(stringWriter);
                        return stringWriter2;
                    }
                }
            } catch (IOException e17) {
                e = e17;
                jz4.c.z("read file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                b(inputStreamReader);
                b(stringWriter);
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            closeable2 = closeable;
            b(closeable2);
            b(stringWriter);
            throw th;
        }
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void c(File file, File file2) {
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2 = null;
        try {
            try {
                zipOutputStream = new ZipOutputStream(new FileOutputStream(file, false));
            } catch (FileNotFoundException unused) {
                b(zipOutputStream2);
            } catch (IOException e16) {
                e = e16;
            }
            try {
                e(zipOutputStream, file2, null, null);
                b(zipOutputStream);
            } catch (FileNotFoundException unused2) {
                zipOutputStream2 = zipOutputStream;
                b(zipOutputStream2);
            } catch (IOException e17) {
                e = e17;
                zipOutputStream2 = zipOutputStream;
                jz4.c.m("zip file failure + " + e.getMessage());
                b(zipOutputStream2);
            } catch (Throwable th5) {
                th = th5;
                zipOutputStream2 = zipOutputStream;
                b(zipOutputStream2);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static void d(File file, String str) {
        if (!file.exists()) {
            jz4.c.z("mkdir " + file.getAbsolutePath());
            file.getParentFile().mkdirs();
        }
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                try {
                    bufferedWriter2.write(str);
                    b(bufferedWriter2);
                } catch (IOException e16) {
                    e = e16;
                    bufferedWriter = bufferedWriter2;
                    jz4.c.z("write file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                    b(bufferedWriter);
                } catch (Throwable th5) {
                    th = th5;
                    bufferedWriter = bufferedWriter2;
                    b(bufferedWriter);
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static void e(ZipOutputStream zipOutputStream, File file, String str, FileFilter fileFilter) {
        File[] listFiles;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                if (file.isDirectory()) {
                    if (fileFilter != null) {
                        listFiles = file.listFiles(fileFilter);
                    } else {
                        listFiles = file.listFiles();
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str);
                    String str3 = File.separator;
                    sb5.append(str3);
                    zipOutputStream.putNextEntry(new ZipEntry(sb5.toString()));
                    if (!TextUtils.isEmpty(str)) {
                        str2 = str + str3;
                    }
                    for (int i3 = 0; i3 < listFiles.length; i3++) {
                        e(zipOutputStream, listFiles[i3], str2 + listFiles[i3].getName(), null);
                    }
                    File[] listFiles2 = file.listFiles(new a());
                    if (listFiles2 != null) {
                        for (File file2 : listFiles2) {
                            e(zipOutputStream, file2, str2 + File.separator + file2.getName(), fileFilter);
                        }
                    }
                } else {
                    if (!TextUtils.isEmpty(str)) {
                        zipOutputStream.putNextEntry(new ZipEntry(str));
                    } else {
                        zipOutputStream.putNextEntry(new ZipEntry(String.valueOf(new Date().getTime()) + ".txt"));
                    }
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                zipOutputStream.write(bArr, 0, read);
                            }
                        }
                        fileInputStream = fileInputStream2;
                    } catch (IOException e16) {
                        e = e16;
                        fileInputStream = fileInputStream2;
                        jz4.c.B("zipFiction failed with exception:" + e.toString());
                        b(fileInputStream);
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = fileInputStream2;
                        b(fileInputStream);
                        throw th;
                    }
                }
            } catch (IOException e17) {
                e = e17;
            }
            b(fileInputStream);
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static boolean f(File file) {
        try {
            if (file.isDirectory()) {
                return false;
            }
            if (file.exists()) {
                return true;
            }
            File parentFile = file.getParentFile();
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                return false;
            }
            return file.createNewFile();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    public static byte[] g(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                try {
                    int read = inputStream.read(bArr, 0, 8192);
                    if (read > 0) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        return byteArrayOutputStream.toByteArray();
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    b(inputStream);
                    b(byteArrayOutputStream);
                    return null;
                }
            } finally {
                b(inputStream);
                b(byteArrayOutputStream);
            }
        }
    }

    public static byte[] h(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception unused) {
            return bArr;
        }
    }

    public static void i(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        if (file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            return;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
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
                if (read >= 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
