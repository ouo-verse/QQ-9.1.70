package com.tencent.mobileqq.qshadow.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes17.dex */
public class FileUtil {
    static IPatchRedirector $redirector_ = null;
    private static final int BUFFER_SIZE = 2048;
    private static final String TAG = "FileUtil";

    FileUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void cleanDirectory(File file) throws IOException {
        IOException e16 = null;
        for (File file2 : verifiedListFiles(file)) {
            try {
                forceDelete(file2);
            } catch (IOException e17) {
                e16 = e17;
            }
        }
        if (e16 != null) {
            throw e16;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.io.FileOutputStream] */
    public static boolean copyFile(File file, File file2) {
        boolean z16;
        if (!file2.exists()) {
            return false;
        }
        if (file.exists()) {
            z16 = file.delete();
        } else {
            z16 = true;
        }
        if (!z16) {
            return false;
        }
        try {
            if (!file.createNewFile()) {
                return false;
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        byte[] bArr = new byte[2048];
        FileInputStream fileInputStream = null;
        try {
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream((File) file2);
                try {
                    file2 = new FileOutputStream(file);
                    while (true) {
                        try {
                            int read = fileInputStream2.read(bArr, 0, 2048);
                            if (read != -1) {
                                file2.write(bArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (IOException e18) {
                                    e18.printStackTrace();
                                }
                            }
                        } catch (FileNotFoundException e19) {
                            e = e19;
                            fileInputStream = fileInputStream2;
                            file2 = file2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e26) {
                                    e26.printStackTrace();
                                }
                            }
                            if (file2 != 0) {
                                file2.close();
                            }
                            return true;
                        } catch (IOException e27) {
                            e = e27;
                            fileInputStream = fileInputStream2;
                            file2 = file2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e28) {
                                    e28.printStackTrace();
                                }
                            }
                            if (file2 != 0) {
                                file2.close();
                            }
                            return true;
                        } catch (Throwable th5) {
                            th = th5;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e29) {
                                    e29.printStackTrace();
                                }
                            }
                            if (file2 != 0) {
                                try {
                                    file2.close();
                                    throw th;
                                } catch (IOException e36) {
                                    e36.printStackTrace();
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    }
                    fileInputStream2.close();
                    file2.close();
                } catch (FileNotFoundException e37) {
                    e = e37;
                    file2 = 0;
                } catch (IOException e38) {
                    e = e38;
                    file2 = 0;
                } catch (Throwable th6) {
                    th = th6;
                    file2 = 0;
                }
            } catch (FileNotFoundException e39) {
                e = e39;
                file2 = 0;
            } catch (IOException e46) {
                e = e46;
                file2 = 0;
            } catch (Throwable th7) {
                th = th7;
                file2 = 0;
            }
            return true;
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public static void copyFileUsingFileStreams(File file, File file2) throws IOException {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
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
                if (read != -1) {
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
            fileInputStream2.close();
            fileOutputStream.close();
            throw th;
        }
    }

    private static void deleteDirectory(File file) throws IOException {
        if (!file.exists()) {
            return;
        }
        cleanDirectory(file);
        if (file.delete()) {
            return;
        }
        throw new IOException("Unable to delete directory " + file + ".");
    }

    private static void forceDelete(File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectory(file);
            return;
        }
        boolean exists = file.exists();
        if (!file.delete()) {
            if (!exists) {
                throw new FileNotFoundException("File does not exist: " + file);
            }
            throw new IOException("Unable to delete file: " + file);
        }
    }

    public static boolean moveFile(File file, File file2) {
        if (!copyFile(file, file2) || !file2.delete()) {
            return false;
        }
        return true;
    }

    public static void unZipFolder(String str, String str2) throws IOException {
        SafeZipFile safeZipFile;
        File file = new File(str2);
        SafeZipFile safeZipFile2 = null;
        try {
            safeZipFile = new SafeZipFile(new File(str));
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            Enumeration<? extends ZipEntry> entries = safeZipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.getName().contains("..") && !nextElement.isDirectory()) {
                    writeOutZipEntry(safeZipFile, nextElement, file, nextElement.getName());
                }
            }
            try {
                safeZipFile.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        } catch (Throwable th6) {
            th = th6;
            safeZipFile2 = safeZipFile;
            if (safeZipFile2 != null) {
                try {
                    safeZipFile2.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static File[] verifiedListFiles(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    return listFiles;
                }
                throw new IOException("Failed to list contents of " + file);
            }
            throw new IllegalArgumentException(file + " is not a directory");
        }
        throw new IllegalArgumentException(file + " does not exist");
    }

    private static void writeOutInputStream(File file, String str, InputStream inputStream) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(file, str)));
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, 8192);
                if (read >= 0) {
                    bufferedOutputStream.write(bArr, 0, read);
                } else {
                    bufferedOutputStream.close();
                    return;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                bufferedOutputStream2.close();
            }
            throw th;
        }
    }

    private static void writeOutZipEntry(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException {
        InputStream inputStream;
        try {
            inputStream = zipFile.getInputStream(zipEntry);
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
        try {
            writeOutInputStream(file, str, inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th6) {
            th = th6;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }
}
