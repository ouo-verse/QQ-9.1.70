package com.tencent.tgpa.vendorpd.gradish;

import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tgpa.vendorpd.b.f;
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
        } catch (SecurityException | UnsatisfiedLinkError unused) {
            f.d("load tgpa so lib by system failed!!!");
            return tryLoadLibraryUsingWorkaround(context, str);
        }
    }

    private static boolean tryLoadLibraryUsingWorkaround(Context context, String str) {
        if (context == null) {
            return false;
        }
        File workaroundLibFile = getWorkaroundLibFile(context, str);
        if (!workaroundLibFile.exists() && !unpackLibrariesOnce(context, str)) {
            f.d("can not find lib file or unzip lib file failed. lib path: " + workaroundLibFile.getAbsolutePath());
            return false;
        }
        return loadLibrary(workaroundLibFile);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0096 A[Catch: IOException -> 0x00a0, DONT_GENERATE, TryCatch #3 {IOException -> 0x00a0, blocks: (B:12:0x0048, B:27:0x0069, B:32:0x007a, B:33:0x007d, B:38:0x0096, B:39:0x0099, B:45:0x0090, B:46:0x0093, B:54:0x009a, B:55:0x009f, B:26:0x0066, B:41:0x0089), top: B:11:0x0048, outer: #4, inners: #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean unpackLibrariesOnce(Context context, String str) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        Throwable th5;
        try {
            ZipFile zipFile = new ZipFile(new File(context.getApplicationInfo().sourceDir), 1);
            ZipEntry entry = zipFile.getEntry("lib/" + Build.CPU_ABI + "/" + System.mapLibraryName(str));
            if (entry == null) {
                zipFile.close();
                return false;
            }
            File workaroundLibFile = getWorkaroundLibFile(context, str);
            if (!workaroundLibFile.exists()) {
                return false;
            }
            try {
                if (workaroundLibFile.createNewFile()) {
                    try {
                        inputStream = zipFile.getInputStream(entry);
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream = null;
                        fileOutputStream = null;
                    }
                    try {
                        fileOutputStream = new FileOutputStream(workaroundLibFile);
                        try {
                            byte[] bArr = new byte[16384];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read > 0) {
                                    fileOutputStream.write(bArr, 0, read);
                                } else {
                                    try {
                                        inputStream.close();
                                        fileOutputStream.close();
                                        workaroundLibFile.setReadable(true, false);
                                        workaroundLibFile.setExecutable(true, false);
                                        workaroundLibFile.setWritable(true);
                                        zipFile.close();
                                        return true;
                                    } finally {
                                        fileOutputStream.close();
                                    }
                                }
                            }
                        } catch (Throwable th7) {
                            th5 = th7;
                            if (inputStream != null) {
                            }
                            throw th5;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        fileOutputStream = null;
                        th5 = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } finally {
                                if (fileOutputStream != null) {
                                }
                            }
                        }
                        throw th5;
                    }
                } else {
                    throw new IOException();
                }
            } catch (IOException e16) {
                e16.printStackTrace();
                if (workaroundLibFile.exists() && !workaroundLibFile.delete()) {
                    f.d("Failed to delete " + workaroundLibFile.getAbsolutePath());
                }
                zipFile.close();
                throw e16;
            }
        } catch (IOException e17) {
            e17.printStackTrace();
            f.d("Failed to unpack native libraries");
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
