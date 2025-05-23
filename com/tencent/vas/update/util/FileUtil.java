package com.tencent.vas.update.util;

import android.text.TextUtils;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import sw4.g;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FileUtil {
    private static final String TAG = "VasUpdate_FileUtil";

    public static void checkFilePathExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str2 = null;
        String str3 = str;
        while (!file.isDirectory()) {
            int lastIndexOf = str3.lastIndexOf(File.separator);
            if (lastIndexOf > 0) {
                String substring = str3.substring(0, lastIndexOf);
                String str4 = str3;
                str3 = substring;
                file = new File(substring);
                str2 = str4;
            } else {
                VasUpdateWrapper.getLog().e(TAG, "checkFileExist no dir path = " + str);
                return;
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            new File(str2).delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static boolean copyFile(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            try {
                return copyFile(file, createFile(str2));
            } catch (Throwable th5) {
                th5.printStackTrace();
                VasUpdateWrapper.getLog().e(TAG, "copyFile exception", th5);
            }
        }
        return false;
    }

    public static File createFile(String str) {
        File file = new File(str);
        try {
        } catch (Throwable th5) {
            th5.printStackTrace();
            VasUpdateWrapper.getLog().e(TAG, "createFile exception", th5);
        }
        if (file.exists()) {
            return file;
        }
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            if (file.getParentFile().mkdirs()) {
                file.createNewFile();
            }
        } else {
            file.createNewFile();
        }
        return file;
    }

    private static void deleteDirectoryInner(String str, ArrayList<String> arrayList) {
        deleteDirectoryInner(str, arrayList, 0);
    }

    public static void deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean filePatch(String str, String str2) {
        return false;
    }

    private static void handleClose(OutputStream outputStream, InputStream inputStream, ZipFile zipFile) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception e16) {
                e16.printStackTrace();
                VasUpdateWrapper.getLog().e(TAG, "unCompressFile close error: ", e16);
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e17) {
                e17.printStackTrace();
                VasUpdateWrapper.getLog().e(TAG, "unCompressFile close error: ", e17);
            }
        }
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (Exception e18) {
                e18.printStackTrace();
                VasUpdateWrapper.getLog().e(TAG, "unCompressFile close error: ", e18);
            }
        }
    }

    public static String readFileContent(File file) {
        ByteArrayOutputStream byteArrayOutputStream;
        BufferedInputStream bufferedInputStream;
        int length;
        String str = null;
        try {
            try {
                length = (int) file.length();
                byteArrayOutputStream = new ByteArrayOutputStream(length);
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = null;
                }
            } catch (Throwable th6) {
                th = th6;
                byteArrayOutputStream = null;
                bufferedInputStream = null;
            }
            try {
                byte[] bArr = new byte[4096];
                int i3 = 0;
                while (i3 < length) {
                    int read = bufferedInputStream.read(bArr);
                    byteArrayOutputStream.write(bArr, 0, read);
                    i3 += read;
                }
                str = byteArrayOutputStream.toString("utf-8");
                byteArrayOutputStream.close();
                bufferedInputStream.close();
            } catch (Throwable th7) {
                th = th7;
                try {
                    th.printStackTrace();
                    VasUpdateWrapper.getLog().e(TAG, "readFileContent exception", th);
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    return str;
                } catch (Throwable th8) {
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                            VasUpdateWrapper.getLog().e(TAG, "readFileContent exception", e16);
                            throw th8;
                        }
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    throw th8;
                }
            }
        } catch (IOException e17) {
            e17.printStackTrace();
            VasUpdateWrapper.getLog().e(TAG, "readFileContent exception", e17);
        }
        return str;
    }

    public static boolean removeFile(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (VasUpdateWrapper.getLog().isColorLevel()) {
            VasUpdateWrapper.getLog().i(TAG, "removeFile from = " + str + " , to = " + str2);
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        return file.renameTo(new File(str2));
    }

    public static boolean safeDeleteFile(File file, String str) {
        File[] listFiles;
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                safeDeleteFile(file2, str);
            }
        }
        File file3 = new File(file.getParent() + File.separator + str + System.currentTimeMillis());
        file.renameTo(file3);
        return file3.delete();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static String unZipFile(String str, boolean z16) throws IOException {
        ?? r36;
        BufferedOutputStream bufferedOutputStream;
        Object obj;
        Object obj2;
        ?? r75;
        OutOfMemoryError e16;
        Exception e17;
        File file = new File(str);
        String str2 = file.getParent() + File.separator;
        if (z16) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                deleteDirectoryInner(str2, arrayList);
                r36 = arrayList;
            } catch (Exception e18) {
                g log = VasUpdateWrapper.getLog();
                log.e(TAG, "unCompressFile delete old dir error new: ", e18);
                r36 = log;
            }
        }
        String str3 = null;
        try {
            try {
                r36 = new ZipFile(file);
            } catch (Exception e19) {
                e = e19;
                obj2 = null;
            } catch (OutOfMemoryError e26) {
                e = e26;
                obj = null;
            } catch (Throwable th5) {
                th = th5;
                r36 = 0;
                bufferedOutputStream = null;
            }
            try {
                Enumeration<? extends ZipEntry> entries = r36.entries();
                byte[] bArr = new byte[8192];
                BufferedOutputStream bufferedOutputStream2 = null;
                InputStream inputStream = null;
                while (entries.hasMoreElements()) {
                    try {
                        try {
                            ZipEntry nextElement = entries.nextElement();
                            if (!nextElement.getName().contains("..")) {
                                if (nextElement.isDirectory()) {
                                    String str4 = new String((str2 + nextElement.getName()).getBytes("8859_1"), "GB2312");
                                    if (VasUpdateWrapper.getLog().isColorLevel()) {
                                        VasUpdateWrapper.getLog().d(TAG, "upZipFile , str = " + str4);
                                    }
                                    new File(str4).mkdir();
                                    str3 = str4;
                                } else {
                                    str3 = nextElement.getName();
                                    File file2 = new File(str2 + nextElement.getName());
                                    if (z16) {
                                        try {
                                            deleteFile(file2.getAbsolutePath());
                                        } catch (Exception e27) {
                                            VasUpdateWrapper.getLog().e(TAG, "unCompressFile delete old file error: ", e27);
                                        }
                                    }
                                    file2.getParentFile().mkdirs();
                                    if (file2.exists()) {
                                        file2.delete();
                                    }
                                    BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(file2));
                                    try {
                                        inputStream = r36.getInputStream(nextElement);
                                        while (true) {
                                            int read = inputStream.read(bArr, 0, 8192);
                                            if (read == -1) {
                                                break;
                                            }
                                            bufferedOutputStream3.write(bArr, 0, read);
                                        }
                                        inputStream.close();
                                        bufferedOutputStream3.close();
                                        bufferedOutputStream2 = bufferedOutputStream3;
                                    } catch (Exception e28) {
                                        e17 = e28;
                                        VasUpdateWrapper.getLog().e(TAG, "unCompressFile error: ", e17);
                                        throw new IOException("unzip error");
                                    } catch (OutOfMemoryError e29) {
                                        e16 = e29;
                                        VasUpdateWrapper.getLog().e(TAG, "unCompressFile oom: ", e16);
                                        throw new IOException("OOM");
                                    } catch (Throwable th6) {
                                        th = th6;
                                        bufferedOutputStream = bufferedOutputStream3;
                                        r75 = inputStream;
                                        handleClose(bufferedOutputStream, r75, r36);
                                        throw th;
                                    }
                                }
                            }
                        } catch (Exception e36) {
                            e17 = e36;
                        }
                    } catch (OutOfMemoryError e37) {
                        e16 = e37;
                    }
                }
                r36.close();
                if (str3 != null) {
                    String str5 = str2 + str3;
                    VasUpdateWrapper.getLog().d(TAG, "uncompressZip result = " + str5);
                    handleClose(bufferedOutputStream2, inputStream, r36);
                    return str5;
                }
                VasUpdateWrapper.getLog().e(TAG, "uncompressZip fail");
                handleClose(bufferedOutputStream2, inputStream, r36);
                return str3;
            } catch (Exception e38) {
                e = e38;
                obj2 = null;
                e17 = e;
                VasUpdateWrapper.getLog().e(TAG, "unCompressFile error: ", e17);
                throw new IOException("unzip error");
            } catch (OutOfMemoryError e39) {
                e = e39;
                obj = null;
                e16 = e;
                VasUpdateWrapper.getLog().e(TAG, "unCompressFile oom: ", e16);
                throw new IOException("OOM");
            } catch (Throwable th7) {
                th = th7;
                bufferedOutputStream = null;
                r36 = r36;
                r75 = bufferedOutputStream;
                th = th;
                handleClose(bufferedOutputStream, r75, r36);
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public static String unZipFileNew(String str, boolean z16) throws IOException {
        File parentFile = new File(str).getParentFile();
        if (z16) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                if (parentFile != null) {
                    deleteDirectoryInner(parentFile.getAbsolutePath(), arrayList);
                }
            } catch (Exception e16) {
                VasUpdateWrapper.getLog().e(TAG, "unCompressFile delete old dir error new: ", e16);
            }
        }
        FileInputStream fileInputStream = new FileInputStream(str);
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        while (nextEntry != null) {
            String name = nextEntry.getName();
            if (name.contains("..")) {
                nextEntry = zipInputStream.getNextEntry();
            } else {
                File file = new File(parentFile + File.separator + name);
                if (nextEntry.isDirectory()) {
                    file.mkdirs();
                } else {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[1024];
                    int read = zipInputStream.read(bArr);
                    while (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.close();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
        }
        zipInputStream.close();
        fileInputStream.close();
        return parentFile.getAbsolutePath();
    }

    public static boolean writeFileContent(String str, String str2) {
        boolean z16;
        File file = new File(str);
        if (!file.exists()) {
            try {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            } catch (IOException unused) {
                z16 = false;
            }
        }
        z16 = true;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            fileOutputStream.write((str2 + "\r\n").getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            return z16;
        } catch (FileNotFoundException | IOException unused2) {
            return false;
        }
    }

    private static void deleteDirectoryInner(String str, ArrayList<String> arrayList, int i3) {
        if (str == null || str.trim().length() == 0) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (int i16 = 0; i16 < listFiles.length; i16++) {
                    if (listFiles[i16].isDirectory()) {
                        deleteDirectoryInner(listFiles[i16].getAbsolutePath(), arrayList, i3 + 1);
                    } else {
                        listFiles[i16].delete();
                    }
                }
            }
            if (i3 > 0) {
                file.delete();
            }
        }
    }

    public static boolean copyFile(File file, File file2) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            if (file2.exists()) {
                file2.delete();
            }
            if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            fileOutputStream = new FileOutputStream(file2);
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (Throwable th5) {
                th = th5;
                bufferedInputStream = null;
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                    fileOutputStream.flush();
                } else {
                    try {
                        break;
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        VasUpdateWrapper.getLog().e(TAG, "copyFile exception", e16);
                    }
                }
            }
            fileOutputStream.close();
            try {
                bufferedInputStream.close();
            } catch (IOException e17) {
                e17.printStackTrace();
                VasUpdateWrapper.getLog().e(TAG, "copyFile exception", e17);
            }
            return true;
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream2 = fileOutputStream;
            try {
                th.printStackTrace();
                VasUpdateWrapper.getLog().e(TAG, "copyFile exception", th);
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                        VasUpdateWrapper.getLog().e(TAG, "copyFile exception", e18);
                    }
                }
                if (bufferedInputStream == null) {
                    return false;
                }
                try {
                    bufferedInputStream.close();
                    return false;
                } catch (IOException e19) {
                    e19.printStackTrace();
                    VasUpdateWrapper.getLog().e(TAG, "copyFile exception", e19);
                    return false;
                }
            } finally {
            }
        }
    }
}
