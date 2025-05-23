package com.tencent.rdelivery.reshub.util.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a implements InterfaceC9731c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f364613a;

        a(File file) {
            this.f364613a = file;
        }

        @Override // com.tencent.rdelivery.reshub.util.zip.c.InterfaceC9731c
        public boolean a(e eVar, ZipEntry zipEntry, Exception exc) {
            eVar.cancel();
            return false;
        }

        @Override // com.tencent.rdelivery.reshub.util.zip.c.InterfaceC9731c
        public boolean b(e eVar, ZipEntry zipEntry) {
            return true;
        }

        @Override // com.tencent.rdelivery.reshub.util.zip.c.InterfaceC9731c
        public String c(e eVar, ZipEntry zipEntry) {
            return this.f364613a.getAbsolutePath() + File.separator + c.f(zipEntry.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class b implements d<ZipEntry> {

        /* renamed from: a, reason: collision with root package name */
        String f364614a = null;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ InterfaceC9731c f364615b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f364616c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ZipInputStream f364617d;

        b(InterfaceC9731c interfaceC9731c, String str, ZipInputStream zipInputStream) {
            this.f364615b = interfaceC9731c;
            this.f364616c = str;
            this.f364617d = zipInputStream;
        }

        @Override // com.tencent.rdelivery.reshub.util.zip.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e eVar, ZipEntry zipEntry, long j3) {
            FileOutputStream fileOutputStream;
            if (!this.f364615b.b(eVar, zipEntry)) {
                return;
            }
            BufferedOutputStream bufferedOutputStream = null;
            try {
                try {
                    String c16 = this.f364615b.c(eVar, zipEntry);
                    this.f364614a = c16;
                    if (c16 == null) {
                        c16 = this.f364616c + File.separator + c.f(zipEntry.getName());
                    }
                    this.f364614a = c.f(c16);
                    String str = this.f364614a + System.currentTimeMillis();
                    File file = new File(this.f364614a);
                    File file2 = new File(str);
                    if (zipEntry.isDirectory()) {
                        file.mkdirs();
                        fileOutputStream = null;
                    } else {
                        jz3.c.n(file2.getAbsolutePath());
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                            try {
                                com.tencent.rdelivery.reshub.util.b.a(this.f364617d, bufferedOutputStream2);
                                bufferedOutputStream2.flush();
                                if (!file2.renameTo(file)) {
                                    jz3.d.c("UnZipUtil", "Rename File Failed: " + str);
                                    boolean e16 = jz3.c.e(file2, file);
                                    jz3.c.f(file2, true);
                                    if (!e16) {
                                        throw new Exception("Copy Failed: " + str + " --> " + this.f364614a);
                                    }
                                }
                                bufferedOutputStream = bufferedOutputStream2;
                            } catch (Exception e17) {
                                e = e17;
                                bufferedOutputStream = bufferedOutputStream2;
                                jz3.d.d("UnZipUtil", "Unzip File Exception", e);
                                if (!this.f364615b.a(eVar, zipEntry, e)) {
                                    throw new RuntimeException(e);
                                }
                                jz3.c.p(bufferedOutputStream);
                                jz3.c.p(fileOutputStream);
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedOutputStream = bufferedOutputStream2;
                                jz3.c.p(bufferedOutputStream);
                                jz3.c.p(fileOutputStream);
                                throw th;
                            }
                        } catch (Exception e18) {
                            e = e18;
                        }
                    }
                } catch (Exception e19) {
                    e = e19;
                    fileOutputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream = null;
                }
                jz3.c.p(bufferedOutputStream);
                jz3.c.p(fileOutputStream);
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.rdelivery.reshub.util.zip.c$c, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC9731c {
        boolean a(e eVar, ZipEntry zipEntry, Exception exc);

        boolean b(e eVar, ZipEntry zipEntry);

        String c(e eVar, ZipEntry zipEntry);
    }

    private static void a(File file, String str, InterfaceC9731c interfaceC9731c) throws Exception {
        BufferedInputStream bufferedInputStream;
        ZipInputStream zipInputStream;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream2);
                try {
                    zipInputStream = new ZipInputStream(bufferedInputStream);
                } catch (Throwable th5) {
                    th = th5;
                    zipInputStream = null;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedInputStream = null;
                zipInputStream = null;
            }
            try {
                new f().a(zipInputStream, true, new b(interfaceC9731c, str, zipInputStream));
                jz3.c.p(fileInputStream2);
                jz3.c.p(bufferedInputStream);
                jz3.c.p(zipInputStream);
            } catch (Throwable th7) {
                th = th7;
                fileInputStream = fileInputStream2;
                jz3.c.p(fileInputStream);
                jz3.c.p(bufferedInputStream);
                jz3.c.p(zipInputStream);
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            bufferedInputStream = null;
            zipInputStream = null;
        }
    }

    public static File b(String str) {
        File file = new File(str);
        jz3.c.f(file, true);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                jz3.d.c("UnZipUtil", "Fail to Create Unzip Target Dir: " + str);
            }
        } else {
            jz3.d.c("UnZipUtil", "Fail to Clear Unzip Target Dir: " + str);
        }
        return file;
    }

    public static boolean c(String str, String str2) {
        File file = new File(str);
        File b16 = b(str2);
        if (!b16.exists()) {
            jz3.d.c("UnZipUtil", "Res ZipFile Unzip Fail: Bad Target Path " + b16.getAbsolutePath());
            return false;
        }
        jz3.d.a("UnZipUtil", "do unzip origin = " + str + ",destination" + str2);
        try {
            a(file, b16.getAbsolutePath(), new a(b16));
            return true;
        } catch (ZipException e16) {
            jz3.d.i("UnZipUtil", "Res ZipFile Unzip ZipException, Retry Use FileUnZipper:" + e16.getMessage() + " Zip: " + str);
            return d(str, file, b16);
        } catch (Exception e17) {
            jz3.d.d("UnZipUtil", "Res ZipFile Unzip Exception: " + e17.getMessage() + " Zip: " + str, e17);
            return d(str, file, b16);
        }
    }

    private static boolean d(String str, File file, File file2) {
        try {
            FileUnZipper.c(file, file2.getAbsolutePath());
            return true;
        } catch (Exception e16) {
            jz3.d.d("UnZipUtil", "Res ZipFile Unzip(FileUnZipper) Exception: " + e16.getMessage() + " Zip: " + str, e16);
            return false;
        }
    }

    public static boolean e(String str, String str2) {
        File file = new File(str);
        File b16 = b(str2);
        if (!b16.exists()) {
            jz3.d.c("UnZipUtil", "unzipByZipFileMode Fail: Bad Target Path " + b16.getAbsolutePath());
            return false;
        }
        jz3.d.a("UnZipUtil", "unzipByZipFileMode origin = " + str + ",destination" + str2);
        boolean d16 = d(str, file, b16);
        if (!d16) {
            jz3.d.a("UnZipUtil", "unzipByZipFileMode failed, try another unzip");
            return c(str, str2);
        }
        return d16;
    }

    public static String f(String str) {
        if (str != null && str.contains("../")) {
            throw new IllegalArgumentException(" file name contain  '../'");
        }
        return str;
    }
}
