package com.tencent.tgpa.lite.gradish;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tgpa.lite.g.d;
import com.tencent.tgpa.lite.g.h;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes26.dex */
public class LibraryLoaderHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String LIB_DIR = "lib";

    public LibraryLoaderHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static File getWorkaroundLibDir(Context context) {
        return context.getDir("lib", 0);
    }

    private static File getWorkaroundLibFile(Context context, String str) {
        return new File(getWorkaroundLibDir(context), System.mapLibraryName(str));
    }

    public static boolean loadLibrary(Context context, String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError unused) {
            h.b("load tgpa so lib by system failed!!!", new Object[0]);
            return tryLoadLibraryUsingWorkaround(context, str);
        }
    }

    private static boolean tryLoadLibraryUsingWorkaround(Context context, String str) {
        if (context == null) {
            return false;
        }
        File workaroundLibFile = getWorkaroundLibFile(context, str);
        if (!workaroundLibFile.exists()) {
            h.b("can not find lib file && unzip lib file failed. lib path: " + workaroundLibFile.getAbsolutePath(), new Object[0]);
            if (!unpackLibrariesOnce(context, str)) {
                h.b("can not unzip lib file. lib path: " + workaroundLibFile.getAbsolutePath(), new Object[0]);
                return false;
            }
        }
        if (!workaroundLibFile.canRead()) {
            h.b("can not read lib file: " + workaroundLibFile.getAbsolutePath(), new Object[0]);
            return false;
        }
        try {
            System.load(workaroundLibFile.getAbsolutePath());
            return true;
        } catch (UnsatisfiedLinkError unused) {
            return false;
        }
    }

    private static boolean unpackLibrariesOnce(Context context, String str) {
        Throwable th5;
        InputStream inputStream;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            ZipFile zipFile = new ZipFile(new File(applicationInfo.sourceDir), 1);
            String str2 = "lib/" + d.c() + "/" + System.mapLibraryName(str);
            ZipEntry entry = zipFile.getEntry(str2);
            if (entry == null) {
                h.b(applicationInfo.sourceDir + " doesn't have file " + str2, new Object[0]);
                zipFile.close();
                return false;
            }
            File workaroundLibFile = getWorkaroundLibFile(context, str);
            if (!workaroundLibFile.exists()) {
                return false;
            }
            try {
                if (workaroundLibFile.createNewFile()) {
                    FileOutputStream fileOutputStream = null;
                    try {
                        inputStream = zipFile.getInputStream(entry);
                        try {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(workaroundLibFile);
                            try {
                                byte[] bArr = new byte[16384];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read > 0) {
                                        fileOutputStream2.write(bArr, 0, read);
                                    } else {
                                        try {
                                            inputStream.close();
                                            fileOutputStream2.close();
                                            workaroundLibFile.setReadable(true, false);
                                            workaroundLibFile.setExecutable(true, false);
                                            workaroundLibFile.setWritable(true);
                                            zipFile.close();
                                            return true;
                                        } catch (Throwable th6) {
                                            fileOutputStream2.close();
                                            throw th6;
                                        }
                                    }
                                }
                            } catch (Throwable th7) {
                                th5 = th7;
                                fileOutputStream = fileOutputStream2;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } finally {
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                    }
                                }
                                throw th5;
                            }
                        } catch (Throwable th8) {
                            th5 = th8;
                        }
                    } catch (Throwable th9) {
                        th5 = th9;
                        inputStream = null;
                    }
                } else {
                    throw new IOException();
                }
            } catch (IOException e16) {
                if (workaroundLibFile.exists() && !workaroundLibFile.delete()) {
                    h.b("Failed to delete " + workaroundLibFile.getAbsolutePath(), new Object[0]);
                }
                zipFile.close();
                throw e16;
            }
        } catch (IOException e17) {
            h.a("Failed to unpack native libraries", e17);
            return false;
        }
    }

    public static boolean loadLibrary(File file) {
        if (file != null && file.exists() && file.canRead()) {
            try {
                System.load(file.getAbsolutePath());
                return true;
            } catch (UnsatisfiedLinkError unused) {
            }
        }
        return false;
    }
}
