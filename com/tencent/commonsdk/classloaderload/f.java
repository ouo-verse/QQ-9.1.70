package com.tencent.commonsdk.classloaderload;

import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.BaseDexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f {
    static IPatchRedirector $redirector_;

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                QLog.e("SoLoadClassLoaderUtil", 1, "closeResource failed ", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.zip.ZipEntry] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.io.BufferedInputStream, java.io.InputStream] */
    public static void b(ZipEntry zipEntry, ZipFile zipFile, File file) {
        if (zipEntry != 0 && zipFile != 0) {
            ?? r06 = 0;
            r0 = null;
            r0 = null;
            r06 = 0;
            BufferedOutputStream bufferedOutputStream = null;
            r06 = 0;
            try {
                try {
                    zipEntry = zipFile.getInputStream(zipEntry);
                    try {
                        zipFile = new BufferedInputStream(zipEntry);
                        try {
                            byte[] bArr = new byte[8192];
                            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                            while (true) {
                                try {
                                    int read = zipFile.read(bArr);
                                    r06 = -1;
                                    if (read == -1) {
                                        break;
                                    } else {
                                        bufferedOutputStream2.write(bArr, 0, read);
                                    }
                                } catch (IOException e16) {
                                    e = e16;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    QLog.e("SoLoadClassLoaderUtil", 1, "copyZipEntry2File failed", e);
                                    a(bufferedOutputStream);
                                    r06 = bufferedOutputStream;
                                    zipEntry = zipEntry;
                                    zipFile = zipFile;
                                    a(zipFile);
                                    a(zipEntry);
                                } catch (Throwable th5) {
                                    th = th5;
                                    r06 = bufferedOutputStream2;
                                    a(r06);
                                    a(zipFile);
                                    a(zipEntry);
                                    throw th;
                                }
                            }
                            a(bufferedOutputStream2);
                            zipEntry = zipEntry;
                            zipFile = zipFile;
                        } catch (IOException e17) {
                            e = e17;
                        }
                    } catch (IOException e18) {
                        e = e18;
                        zipFile = 0;
                    } catch (Throwable th6) {
                        th = th6;
                        zipFile = 0;
                    }
                } catch (IOException e19) {
                    e = e19;
                    zipEntry = 0;
                    zipFile = 0;
                } catch (Throwable th7) {
                    th = th7;
                    zipEntry = 0;
                    zipFile = 0;
                }
                a(zipFile);
                a(zipEntry);
            } catch (Throwable th8) {
                th = th8;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object c(Context context) throws Exception {
        Field declaredField;
        ClassLoader classLoader = context.getClassLoader();
        BaseDexClassLoader baseDexClassLoader = (BaseDexClassLoader) context.getClassLoader();
        QLog.d("SoLoadClassLoaderUtil", 1, "BaseDexClassLoader: " + baseDexClassLoader);
        Field declaredField2 = classLoader.getClass().getSuperclass().getDeclaredField("pathList");
        declaredField2.setAccessible(true);
        Object obj = declaredField2.get(baseDexClassLoader);
        Class<?> cls = declaredField2.get(baseDexClassLoader).getClass();
        if (Build.VERSION.SDK_INT <= 23) {
            declaredField = cls.getDeclaredField("dexElements");
        } else {
            declaredField = cls.getDeclaredField("nativeLibraryPathElements");
        }
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean d(Object obj) throws NoSuchFieldException, IllegalAccessException {
        Object d16 = a.d(obj, "isDirectory");
        if (d16 != null && !((Boolean) d16).booleanValue()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object e(Object obj) throws NoSuchFieldException, IllegalAccessException {
        return a.d(obj, "urlHandler");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object f(Object obj) {
        return a.c(obj, "libcore.io.ClassPathURLStreamHandler", "jarFile", 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ZipEntry g(ZipFile zipFile, String str) {
        QLog.e("SoLoadClassLoaderUtil", 1, "zipFile.getEntry(): " + str);
        ZipEntry entry = zipFile.getEntry(str);
        QLog.e("SoLoadClassLoaderUtil", 1, "zipEntry: " + entry);
        return entry;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object h(Object obj) throws NoSuchFieldException, IllegalAccessException {
        return a.d(obj, "zipFile");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void i(Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        a.b(obj, "maybeInit");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean j(Object obj) throws NoSuchFieldException, IllegalAccessException {
        Object d16 = a.d(obj, "path");
        if (d16 != null && !((File) d16).isDirectory()) {
            return false;
        }
        return true;
    }
}
