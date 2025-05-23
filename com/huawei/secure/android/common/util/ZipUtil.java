package com.huawei.secure.android.common.util;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ZipUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f38029a = "ZipUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final int f38030b = 104857600;

    /* renamed from: c, reason: collision with root package name */
    private static final int f38031c = 100;

    /* renamed from: d, reason: collision with root package name */
    private static final int f38032d = 4096;

    /* renamed from: e, reason: collision with root package name */
    private static final String f38033e = "../";

    /* renamed from: f, reason: collision with root package name */
    private static final String f38034f = "..\\";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0134  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List<File> a(File file, File file2, long j3, boolean z16) {
        ZipFile zipFile;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream = null;
        if (file == null || file2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z17 = false;
        boolean z18 = true;
        try {
            zipFile = new ZipFile(file);
        } catch (IOException e16) {
            e = e16;
        } catch (Throwable th5) {
            th = th5;
            IOUtil.closeSecure((Closeable) fileOutputStream);
            if (!z18) {
            }
            throw th;
        }
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            int i3 = 0;
            while (true) {
                if (!entries.hasMoreElements()) {
                    z17 = z18;
                    break;
                }
                try {
                    ZipEntry nextElement = entries.nextElement();
                    String name = nextElement.getName();
                    if (!TextUtils.isEmpty(name)) {
                        String normalize = Normalizer.normalize(name, Normalizer.Form.NFKC);
                        if (e(normalize)) {
                            Log.e(f38029a, "zipPath is a invalid path: " + d(normalize));
                            break;
                        }
                        File file3 = new File(file2, normalize.replaceAll("\\\\", "/"));
                        if (z16 && file3.exists() && file3.isFile()) {
                            e(file3);
                        }
                        arrayList.add(file3);
                        if (nextElement.isDirectory()) {
                            if (!a(file3)) {
                                IOUtil.closeSecure(zipFile);
                                a(arrayList);
                                return null;
                            }
                        } else {
                            if (!b(file3)) {
                                IOUtil.closeSecure(zipFile);
                                a(arrayList);
                                return null;
                            }
                            try {
                                bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(nextElement));
                                try {
                                    FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                                    try {
                                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
                                    } catch (Throwable th6) {
                                        th = th6;
                                        bufferedOutputStream = null;
                                    }
                                    try {
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int read = bufferedInputStream.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            i3 += read;
                                            if (i3 > j3) {
                                                Log.e(f38029a, "unzipFileNew: over than top size");
                                                z18 = false;
                                                break;
                                            }
                                            bufferedOutputStream.write(bArr, 0, read);
                                        }
                                        IOUtil.closeSecure((InputStream) bufferedInputStream);
                                        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                        IOUtil.closeSecure((OutputStream) fileOutputStream2);
                                    } catch (Throwable th7) {
                                        th = th7;
                                        fileOutputStream = fileOutputStream2;
                                        IOUtil.closeSecure((InputStream) bufferedInputStream);
                                        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                        IOUtil.closeSecure((OutputStream) fileOutputStream);
                                        throw th;
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    bufferedOutputStream = null;
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                bufferedInputStream = null;
                                bufferedOutputStream = null;
                            }
                        }
                    }
                } catch (IllegalArgumentException unused) {
                    Log.e(f38029a, "entries.nextElement IllegalArgumentException");
                }
            }
            IOUtil.closeSecure(zipFile);
            if (!z17) {
                a(arrayList);
            }
        } catch (IOException e17) {
            e = e17;
            fileOutputStream = zipFile;
            try {
                Log.e(f38029a, "unzip new IOException : " + e.getMessage());
                IOUtil.closeSecure((Closeable) fileOutputStream);
                a(arrayList);
                return arrayList;
            } catch (Throwable th10) {
                th = th10;
                z18 = z17;
                IOUtil.closeSecure((Closeable) fileOutputStream);
                if (!z18) {
                    a(arrayList);
                }
                throw th;
            }
        } catch (Throwable th11) {
            th = th11;
            z17 = true;
            fileOutputStream = zipFile;
            z18 = z17;
            IOUtil.closeSecure((Closeable) fileOutputStream);
            if (!z18) {
            }
            throw th;
        }
        return arrayList;
    }

    private static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!a(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            Log.e(f38029a, "createOrExistsFile IOException ");
            return false;
        }
    }

    private static File c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return b(str);
    }

    private static String d(String str) {
        int lastIndexOf;
        return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(File.separator)) == -1) ? str : str.substring(lastIndexOf + 1);
    }

    private static void e(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            c(file);
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    e(file2);
                }
                c(file);
                return;
            }
            c(file);
        }
    }

    @Deprecated
    public static boolean unZip(String str, String str2, boolean z16) throws SecurityCommonException {
        return unZip(str, str2, GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT, 100, z16);
    }

    public static List<File> unZipNew(String str, String str2, boolean z16) throws SecurityCommonException {
        return unZipNew(str, str2, GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT, 100, z16);
    }

    private static void c(File file) {
        if (file == null || file.delete()) {
            return;
        }
        LogsUtil.e(f38029a, "delete file error");
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d2, code lost:
    
        android.util.Log.e(com.huawei.secure.android.common.util.ZipUtil.f38029a, "unzip  over than top size");
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d8, code lost:
    
        r2 = 0;
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0070, code lost:
    
        android.util.Log.e(com.huawei.secure.android.common.util.ZipUtil.f38029a, "zipPath is a invalid path: " + d(r13));
        r2 = r3;
        r10 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0161  */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean unZip(String str, String str2, long j3, int i3, boolean z16) throws SecurityCommonException {
        ZipInputStream zipInputStream;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        int i16;
        FileOutputStream fileOutputStream2;
        FileInputStream fileInputStream;
        boolean z17;
        int i17;
        FileOutputStream fileOutputStream3;
        String str3 = str2;
        int i18 = 0;
        if (!a(str, str2, j3, i3)) {
            return false;
        }
        String str4 = File.separator;
        if (str3.endsWith(str4) && str2.length() > str4.length()) {
            str3 = str3.substring(0, str2.length() - str4.length());
        }
        int i19 = 4096;
        byte[] bArr = new byte[4096];
        ArrayList arrayList = new ArrayList();
        FileInputStream fileInputStream2 = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));
                int i26 = 0;
                i17 = 1;
                fileOutputStream2 = null;
                while (true) {
                    try {
                        try {
                            ZipEntry nextEntry = zipInputStream.getNextEntry();
                            if (nextEntry == null) {
                                i16 = i18;
                                break;
                            }
                            String replaceAll = nextEntry.getName().replaceAll("\\\\", "/");
                            File file = new File(str3, replaceAll);
                            String normalize = Normalizer.normalize(replaceAll, Normalizer.Form.NFKC);
                            if (e(normalize)) {
                                break;
                            }
                            if (z16 && file.exists() && file.isFile()) {
                                e(file);
                            }
                            if (nextEntry.isDirectory()) {
                                d(file);
                                arrayList.add(file);
                                i16 = i18;
                            } else {
                                File parentFile = file.getParentFile();
                                if (parentFile != null && !parentFile.exists()) {
                                    d(parentFile);
                                }
                                fileOutputStream = new FileOutputStream(file);
                                try {
                                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                    while (true) {
                                        try {
                                            try {
                                                int read = zipInputStream.read(bArr, i18, i19);
                                                if (read == -1) {
                                                    i16 = i18;
                                                    break;
                                                }
                                                i26 += read;
                                                if (i26 <= j3) {
                                                    bufferedOutputStream.write(bArr, 0, read);
                                                    i18 = 0;
                                                    i19 = 4096;
                                                } else {
                                                    try {
                                                        break;
                                                    } catch (IOException e16) {
                                                        e = e16;
                                                        fileOutputStream3 = fileOutputStream;
                                                        i16 = 0;
                                                        fileOutputStream = fileOutputStream3;
                                                        fileInputStream2 = fileInputStream;
                                                        try {
                                                            LogsUtil.e(f38029a, "Unzip IOException : " + e.getMessage());
                                                            z17 = i16;
                                                            fileInputStream = fileInputStream2;
                                                            bufferedOutputStream2 = bufferedOutputStream;
                                                            fileOutputStream2 = fileOutputStream;
                                                            a(fileInputStream, bufferedOutputStream2, zipInputStream, fileOutputStream2);
                                                            if (z17 == 0) {
                                                            }
                                                            return z17;
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            a(fileInputStream2, bufferedOutputStream, zipInputStream, fileOutputStream);
                                                            throw th;
                                                        }
                                                    }
                                                }
                                            } catch (IOException e17) {
                                                e = e17;
                                                i16 = i18;
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            fileInputStream2 = fileInputStream;
                                            a(fileInputStream2, bufferedOutputStream, zipInputStream, fileOutputStream);
                                            throw th;
                                        }
                                    }
                                } catch (IOException e18) {
                                    e = e18;
                                    i16 = i18;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    fileInputStream2 = fileInputStream;
                                    LogsUtil.e(f38029a, "Unzip IOException : " + e.getMessage());
                                    z17 = i16;
                                    fileInputStream = fileInputStream2;
                                    bufferedOutputStream2 = bufferedOutputStream;
                                    fileOutputStream2 = fileOutputStream;
                                    a(fileInputStream, bufferedOutputStream2, zipInputStream, fileOutputStream2);
                                    if (z17 == 0) {
                                    }
                                    return z17;
                                } catch (Throwable th7) {
                                    th = th7;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    fileInputStream2 = fileInputStream;
                                    a(fileInputStream2, bufferedOutputStream, zipInputStream, fileOutputStream);
                                    throw th;
                                }
                                try {
                                    arrayList.add(file);
                                    bufferedOutputStream.flush();
                                    IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                    IOUtil.closeSecure((OutputStream) fileOutputStream);
                                    bufferedOutputStream2 = bufferedOutputStream;
                                    fileOutputStream2 = fileOutputStream;
                                } catch (IOException e19) {
                                    e = e19;
                                    fileOutputStream3 = fileOutputStream;
                                    fileOutputStream = fileOutputStream3;
                                    fileInputStream2 = fileInputStream;
                                    LogsUtil.e(f38029a, "Unzip IOException : " + e.getMessage());
                                    z17 = i16;
                                    fileInputStream = fileInputStream2;
                                    bufferedOutputStream2 = bufferedOutputStream;
                                    fileOutputStream2 = fileOutputStream;
                                    a(fileInputStream, bufferedOutputStream2, zipInputStream, fileOutputStream2);
                                    if (z17 == 0) {
                                    }
                                    return z17;
                                }
                            }
                            try {
                                zipInputStream.closeEntry();
                                i18 = i16;
                                i19 = 4096;
                            } catch (IOException e26) {
                                e = e26;
                                FileOutputStream fileOutputStream4 = fileOutputStream2;
                                bufferedOutputStream = bufferedOutputStream2;
                                fileOutputStream3 = fileOutputStream4;
                                fileOutputStream = fileOutputStream3;
                                fileInputStream2 = fileInputStream;
                                LogsUtil.e(f38029a, "Unzip IOException : " + e.getMessage());
                                z17 = i16;
                                fileInputStream = fileInputStream2;
                                bufferedOutputStream2 = bufferedOutputStream;
                                fileOutputStream2 = fileOutputStream;
                                a(fileInputStream, bufferedOutputStream2, zipInputStream, fileOutputStream2);
                                if (z17 == 0) {
                                }
                                return z17;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            fileOutputStream = fileOutputStream2;
                        }
                    } catch (IOException e27) {
                        e = e27;
                        i16 = i18;
                    }
                }
            } catch (IOException e28) {
                e = e28;
                i16 = 0;
                zipInputStream = null;
                bufferedOutputStream = null;
                fileOutputStream = null;
            } catch (Throwable th9) {
                th = th9;
                zipInputStream = null;
                bufferedOutputStream = null;
                fileOutputStream = null;
            }
        } catch (IOException e29) {
            e = e29;
            i16 = 0;
            zipInputStream = null;
            bufferedOutputStream = null;
            fileOutputStream = null;
        } catch (Throwable th10) {
            th = th10;
            zipInputStream = null;
            bufferedOutputStream = null;
            fileOutputStream = null;
        }
        try {
            IOUtil.closeSecure((InputStream) zipInputStream);
            IOUtil.closeSecure((InputStream) fileInputStream);
            z17 = i17;
        } catch (IOException e36) {
            e = e36;
            fileOutputStream = fileOutputStream2;
            bufferedOutputStream = bufferedOutputStream2;
            fileInputStream2 = fileInputStream;
            LogsUtil.e(f38029a, "Unzip IOException : " + e.getMessage());
            z17 = i16;
            fileInputStream = fileInputStream2;
            bufferedOutputStream2 = bufferedOutputStream;
            fileOutputStream2 = fileOutputStream;
            a(fileInputStream, bufferedOutputStream2, zipInputStream, fileOutputStream2);
            if (z17 == 0) {
            }
            return z17;
        }
        a(fileInputStream, bufferedOutputStream2, zipInputStream, fileOutputStream2);
        if (z17 == 0) {
            a(arrayList);
        }
        return z17;
    }

    public static List<File> unZipNew(String str, String str2, long j3, int i3, boolean z16) throws SecurityCommonException {
        if (!a(str, str2, j3, i3)) {
            return null;
        }
        String str3 = File.separator;
        if (str2.endsWith(str3) && str2.length() > str3.length()) {
            str2 = str2.substring(0, str2.length() - str3.length());
        }
        return a(c(str), c(str2), j3, z16);
    }

    private static void d(File file) {
        if (file == null || file.exists() || file.mkdirs()) {
            return;
        }
        LogsUtil.e(f38029a, "mkdirs error , files exists or IOException.");
    }

    private static File b(String str) {
        a(str);
        return new File(str);
    }

    private static boolean e(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.contains(f38033e) || str.contains(f38034f) || str.contains("..") || str.contains("./") || str.contains(".\\.\\") || str.contains("%00");
        }
        Log.e(f38029a, "isContainInvalidStr: name is null");
        return true;
    }

    private static void a(String str) {
        if (TextUtils.isEmpty(str) || !e(str)) {
            return;
        }
        Log.e(f38029a, "IllegalArgumentException--path is not a standard path");
        throw new IllegalArgumentException("path is not a standard path");
    }

    private static boolean a(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:27:0x0075
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    private static boolean a(java.lang.String r11, long r12, int r14) {
        /*
            java.lang.String r0 = "close zipFile IOException "
            java.lang.String r1 = "ZipUtil"
            r2 = 0
            r3 = 0
            java.util.zip.ZipFile r4 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            r4.<init>(r11)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L55
            java.util.Enumeration r11 = r4.entries()     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L50
            r5 = 0
            r2 = r3
        L14:
            boolean r7 = r11.hasMoreElements()     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L50
            r8 = 1
            if (r7 == 0) goto L48
            java.lang.Object r7 = r11.nextElement()     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L50
            java.util.zip.ZipEntry r7 = (java.util.zip.ZipEntry) r7     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L50
            long r9 = r7.getSize()     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L50
            long r5 = r5 + r9
            int r2 = r2 + r8
            java.lang.String r8 = r7.getName()     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L50
            boolean r8 = e(r8)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L50
            if (r8 != 0) goto L41
            if (r2 >= r14) goto L41
            int r8 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r8 > 0) goto L41
            long r7 = r7.getSize()     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L50
            r9 = -1
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L14
        L41:
            java.lang.String r11 = "File name is invalid or too many files or too big"
            com.huawei.secure.android.common.util.LogsUtil.e(r1, r11)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L50
            goto L49
        L48:
            r3 = r8
        L49:
            r4.close()     // Catch: java.io.IOException -> L75
            goto L78
        L4d:
            r11 = move-exception
            r2 = r4
            goto L79
        L50:
            r11 = move-exception
            r2 = r4
            goto L56
        L53:
            r11 = move-exception
            goto L79
        L55:
            r11 = move-exception
        L56:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L53
            r12.<init>()     // Catch: java.lang.Throwable -> L53
            java.lang.String r13 = "not a valid zip file, IOException : "
            r12.append(r13)     // Catch: java.lang.Throwable -> L53
            java.lang.String r11 = r11.getMessage()     // Catch: java.lang.Throwable -> L53
            r12.append(r11)     // Catch: java.lang.Throwable -> L53
            java.lang.String r11 = r12.toString()     // Catch: java.lang.Throwable -> L53
            com.huawei.secure.android.common.util.LogsUtil.e(r1, r11)     // Catch: java.lang.Throwable -> L53
            if (r2 == 0) goto L78
            r2.close()     // Catch: java.io.IOException -> L75
            goto L78
        L75:
            com.huawei.secure.android.common.util.LogsUtil.e(r1, r0)
        L78:
            return r3
        L79:
            if (r2 == 0) goto L82
            r2.close()     // Catch: java.io.IOException -> L7f
            goto L82
        L7f:
            com.huawei.secure.android.common.util.LogsUtil.e(r1, r0)
        L82:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.a(java.lang.String, long, int):boolean");
    }

    private static boolean a(String str, String str2, long j3, int i3) throws SecurityCommonException {
        if (!TextUtils.isEmpty(str) && !e(str)) {
            if (!TextUtils.isEmpty(str2) && !e(str2)) {
                if (a(str, j3, i3)) {
                    return true;
                }
                LogsUtil.e(f38029a, "zip file contains valid chars or too many files");
                throw new SecurityCommonException("unsecure zipfile!");
            }
            LogsUtil.e(f38029a, "target directory is not valid");
            return false;
        }
        LogsUtil.e(f38029a, "zip file is not valid");
        return false;
    }

    private static boolean a(List<File> list) {
        try {
            Iterator<File> it = list.iterator();
            while (it.hasNext()) {
                e(it.next());
            }
            return true;
        } catch (Exception e16) {
            LogsUtil.e(f38029a, "unzip fail delete file failed" + e16.getMessage());
            return false;
        }
    }

    private static void a(FileInputStream fileInputStream, BufferedOutputStream bufferedOutputStream, ZipInputStream zipInputStream, FileOutputStream fileOutputStream) {
        IOUtil.closeSecure((InputStream) fileInputStream);
        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
        IOUtil.closeSecure((InputStream) zipInputStream);
        IOUtil.closeSecure((OutputStream) fileOutputStream);
    }
}
