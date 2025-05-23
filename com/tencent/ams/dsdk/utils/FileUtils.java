package com.tencent.ams.dsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.monitor.metric.DynamicReporter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.oskplayer.util.SecretUtils;
import com.tencent.pts.utils.PTSFileUtil;
import com.tencent.qqlive.tvkplayer.tools.httpdns.TVKHttpDnsCryptoUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FileUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "FileUtils";

    public FileUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void clearExceedSpaceSizeFile(String str, long j3) {
        File[] sortFiles;
        if (TextUtils.isEmpty(str)) {
            DLog.w("FileUtils", "dir is null");
            return;
        }
        long fileLength = getFileLength(new File(str));
        if (j3 <= fileLength && (sortFiles = getSortFiles(str)) != null && sortFiles.length > 0) {
            for (File file : sortFiles) {
                try {
                    long fileLength2 = getFileLength(file);
                    deleteFile(file);
                    fileLength -= fileLength2;
                    DLog.d("FileUtils", "delete over size file: " + file);
                } catch (Throwable th5) {
                    DLog.e("FileUtils", "check file over size error.", th5);
                }
                if (j3 > fileLength) {
                    DLog.d("FileUtils", "exceed the size of the space complete.");
                    return;
                }
                continue;
            }
        }
    }

    public static void clearExpireFile(String str, long j3) {
        clearExpireFile(str, j3, false);
    }

    public static byte[] decrypt(String str, String str2, byte[] bArr) {
        if (str != null && str2 != null && bArr != null) {
            try {
                SecretKey generateSecret = SecretKeyFactory.getInstance(TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_DES).generateSecret(new DESKeySpec(str.getBytes()));
                Cipher cipher = Cipher.getInstance(SecretUtils.ALGORITHM_DES);
                cipher.init(2, generateSecret, new IvParameterSpec(str2.getBytes()));
                return cipher.doFinal(Base64.decode(bArr, 2));
            } catch (Exception e16) {
                DLog.e(e16.getMessage());
            }
        }
        return null;
    }

    public static boolean deleteFile(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (!isSymlink(file) && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (!isEmpty(listFiles)) {
                    for (File file2 : listFiles) {
                        deleteFile(file2);
                    }
                }
            }
        } catch (Throwable th5) {
            DLog.e("FileUtils", "check symlink file error.", th5);
        }
        boolean delete = file.delete();
        DLog.w("FileUtils", "delete file: " + file + ", result: " + delete);
        return delete;
    }

    public static String getFileDir() {
        return getFileDir(DKEngine.getApplicationContext());
    }

    public static long getFileLength(File file) {
        long j3 = 0;
        if (file == null) {
            return 0L;
        }
        if (file.isFile()) {
            return file.length();
        }
        if (isSymlink(file)) {
            return 0L;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                j3 += getFileLength(file2);
            }
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getFileModifyDate(File file) {
        if (file == null) {
            return 0L;
        }
        return file.lastModified();
    }

    public static File getRealFileName(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] split = str2.split("/");
            File file = new File(str);
            int i3 = 0;
            if (split.length > 1) {
                while (i3 < split.length - 1) {
                    String str3 = split[i3];
                    try {
                        str3 = new String(str3.getBytes("8859_1"), "GB2312");
                    } catch (UnsupportedEncodingException e16) {
                        DLog.e("FileUtils", "bytes to string error.", e16);
                    }
                    i3++;
                    file = new File(file, str3);
                }
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str4 = split[split.length - 1];
                try {
                    str4 = new String(str4.getBytes("8859_1"), "GB2312");
                } catch (UnsupportedEncodingException e17) {
                    DLog.e("FileUtils", "bytes to string error.", e17);
                }
                return new File(file, str4);
            }
            if (split.length == 1) {
                return new File(file, split[0]);
            }
            return file;
        }
        return null;
    }

    private static File[] getSortFiles(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        return sortByModifyDate(file.listFiles());
    }

    public static boolean isEmpty(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            return false;
        }
        return true;
    }

    public static boolean isExpireFile(File file, long j3) {
        long j16 = 0;
        boolean z16 = false;
        if (j3 > 0 && file != null) {
            try {
                if (file.exists()) {
                    j16 = file.lastModified();
                    if (System.currentTimeMillis() - j16 > j3) {
                        z16 = true;
                    }
                }
            } catch (Throwable th5) {
                DLog.e("FileUtils", "check file expire time error.", th5);
            }
        }
        DLog.d("FileUtils", "isExpireFile, file: " + file + ", expireTime: " + j3 + ", lastModified:" + j16 + ", result: " + z16);
        return z16;
    }

    public static boolean isFileExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean isSymlink(File file) throws Exception {
        file.getClass();
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    public static byte[] readBytesFromFile(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        byte[] bArr = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
            }
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream = null;
            fileInputStream = null;
        }
        try {
            byte[] bArr2 = new byte[10240];
            while (true) {
                int read = fileInputStream.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            bArr = byteArrayOutputStream.toByteArray();
        } catch (Throwable th7) {
            th = th7;
            try {
                DLog.d("FileUtils", "read bytes from file error.", th);
                return bArr;
            } finally {
                DynamicUtils.safeClose((OutputStream) byteArrayOutputStream);
                DynamicUtils.safeClose((InputStream) fileInputStream);
            }
        }
        return bArr;
    }

    public static File[] sortByModifyDate(File[] fileArr) {
        if (fileArr != null && fileArr.length > 1) {
            Arrays.sort(fileArr, new Comparator<File>() { // from class: com.tencent.ams.dsdk.utils.FileUtils.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.util.Comparator
                public int compare(File file, File file2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? Long.compare(FileUtils.getFileModifyDate(file), FileUtils.getFileModifyDate(file2)) : ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) file2)).intValue();
                }
            });
        }
        return fileArr;
    }

    public static String stringFromFile(File file) {
        if (file != null && file.exists() && file.isFile()) {
            try {
                return stringFromInputStream(new FileInputStream(file));
            } catch (Throwable unused) {
                DLog.w("FileUtils", "stringFromFile failed: " + file);
            }
        }
        return null;
    }

    private static String stringFromInputStream(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (inputStream == null) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable unused) {
                }
            }
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr, 0, 4096);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
            try {
                inputStream.close();
            } catch (Throwable unused2) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (Throwable unused3) {
            }
            return byteArrayOutputStream2;
        } catch (Throwable th6) {
            th = th6;
            try {
                DLog.w("FileUtils", "stringFromInputStream failed", th);
                try {
                    inputStream.close();
                } catch (Throwable unused4) {
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused5) {
                    }
                }
                return null;
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x015f A[Catch: all -> 0x0174, Exception -> 0x0176, LOOP:2: B:50:0x0159->B:53:0x015f, LOOP_END, TRY_LEAVE, TryCatch #10 {Exception -> 0x0176, all -> 0x0174, blocks: (B:51:0x0159, B:53:0x015f), top: B:50:0x0159 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0163 A[EDGE_INSN: B:54:0x0163->B:55:0x0163 BREAK  A[LOOP:2: B:50:0x0159->B:53:0x015f], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void unZipFile(String str, File file, int i3) throws Exception {
        BufferedOutputStream bufferedOutputStream;
        InputStream inputStream;
        InputStream inputStream2;
        BufferedOutputStream bufferedOutputStream2;
        InputStream inputStream3;
        ByteArrayOutputStream byteArrayOutputStream;
        int read;
        File file2 = file;
        if (!TextUtils.isEmpty(str) && file2 != null) {
            if (!file.exists() && !file.mkdirs()) {
                DLog.d("FileUtils", "unzip folder create failed:" + file.getAbsolutePath());
            }
            ZipFile zipFile = new ZipFile(str);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            byte[] bArr = new byte[1024];
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                DLog.d("FileUtils", "unZipFile: " + name);
                if (name == null || !name.contains("../")) {
                    if (nextElement.isDirectory()) {
                        File file3 = new File(new String((file2 + File.separator + nextElement.getName()).getBytes("8859_1"), "GB2312"));
                        if (!file3.mkdir()) {
                            DLog.d("FileUtils", "unzip folder create failed:" + file3.getAbsolutePath());
                        }
                    } else {
                        try {
                            File realFileName = getRealFileName(file.getAbsolutePath(), nextElement.getName());
                            if (realFileName == null) {
                                DynamicUtils.safeClose((InputStream) null);
                                DynamicUtils.safeClose((OutputStream) null);
                                DynamicUtils.safeClose((InputStream) null);
                                DynamicUtils.safeClose((OutputStream) null);
                            } else {
                                inputStream = zipFile.getInputStream(nextElement);
                                try {
                                    inputStream3 = new BufferedInputStream(inputStream);
                                    if (i3 == 1 && name != null) {
                                        try {
                                            if (name.endsWith(PTSFileUtil.JS_FORMAT)) {
                                                DLog.d("FileUtils", "unZipFile start decrypt");
                                                byteArrayOutputStream = new ByteArrayOutputStream();
                                                try {
                                                    byte[] bArr2 = new byte[4096];
                                                    while (true) {
                                                        int read2 = inputStream3.read(bArr2, 0, 4096);
                                                        if (read2 == -1) {
                                                            break;
                                                        } else {
                                                            byteArrayOutputStream.write(bArr2, 0, read2);
                                                        }
                                                    }
                                                    byte[] decrypt = decrypt(DKConfiguration.getDesKey(), DKConfiguration.getDesIv(), byteArrayOutputStream.toByteArray());
                                                    if (decrypt != null) {
                                                        DynamicUtils.safeClose(inputStream3);
                                                        InputStream byteArrayInputStream = new ByteArrayInputStream(decrypt);
                                                        try {
                                                            DLog.i("FileUtils", "unzip file and des decrypt success");
                                                            inputStream3 = byteArrayInputStream;
                                                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(realFileName));
                                                            while (true) {
                                                                try {
                                                                    read = inputStream3.read(bArr, 0, 1024);
                                                                    if (read != -1) {
                                                                        break;
                                                                    } else {
                                                                        bufferedOutputStream.write(bArr, 0, read);
                                                                    }
                                                                } catch (Exception e16) {
                                                                    e = e16;
                                                                    bufferedOutputStream2 = bufferedOutputStream;
                                                                    try {
                                                                        DynamicReporter.reportUnzipEntryError(name, e.getClass().getName(), e.getMessage());
                                                                        zipFile.close();
                                                                        throw e;
                                                                    } catch (Throwable th5) {
                                                                        th = th5;
                                                                        bufferedOutputStream = bufferedOutputStream2;
                                                                        inputStream2 = inputStream3;
                                                                        DynamicUtils.safeClose(inputStream2);
                                                                        DynamicUtils.safeClose((OutputStream) bufferedOutputStream);
                                                                        DynamicUtils.safeClose(inputStream);
                                                                        DynamicUtils.safeClose((OutputStream) byteArrayOutputStream);
                                                                        throw th;
                                                                    }
                                                                } catch (Throwable th6) {
                                                                    th = th6;
                                                                    inputStream2 = inputStream3;
                                                                    DynamicUtils.safeClose(inputStream2);
                                                                    DynamicUtils.safeClose((OutputStream) bufferedOutputStream);
                                                                    DynamicUtils.safeClose(inputStream);
                                                                    DynamicUtils.safeClose((OutputStream) byteArrayOutputStream);
                                                                    throw th;
                                                                }
                                                            }
                                                            DynamicUtils.safeClose(inputStream3);
                                                            DynamicUtils.safeClose((OutputStream) bufferedOutputStream);
                                                            DynamicUtils.safeClose(inputStream);
                                                            DynamicUtils.safeClose((OutputStream) byteArrayOutputStream);
                                                            file2 = file;
                                                        } catch (Exception e17) {
                                                            e = e17;
                                                            inputStream3 = byteArrayInputStream;
                                                            bufferedOutputStream2 = null;
                                                            DynamicReporter.reportUnzipEntryError(name, e.getClass().getName(), e.getMessage());
                                                            zipFile.close();
                                                            throw e;
                                                        } catch (Throwable th7) {
                                                            th = th7;
                                                            inputStream2 = byteArrayInputStream;
                                                            bufferedOutputStream = null;
                                                            DynamicUtils.safeClose(inputStream2);
                                                            DynamicUtils.safeClose((OutputStream) bufferedOutputStream);
                                                            DynamicUtils.safeClose(inputStream);
                                                            DynamicUtils.safeClose((OutputStream) byteArrayOutputStream);
                                                            throw th;
                                                        }
                                                    } else {
                                                        throw new IllegalStateException("unzip failed: des decrypt failed");
                                                    }
                                                } catch (Exception e18) {
                                                    e = e18;
                                                } catch (Throwable th8) {
                                                    th = th8;
                                                    inputStream2 = inputStream3;
                                                }
                                            }
                                        } catch (Exception e19) {
                                            e = e19;
                                            bufferedOutputStream2 = null;
                                            byteArrayOutputStream = null;
                                            DynamicReporter.reportUnzipEntryError(name, e.getClass().getName(), e.getMessage());
                                            zipFile.close();
                                            throw e;
                                        } catch (Throwable th9) {
                                            th = th9;
                                            inputStream2 = inputStream3;
                                            bufferedOutputStream = null;
                                            byteArrayOutputStream = null;
                                            DynamicUtils.safeClose(inputStream2);
                                            DynamicUtils.safeClose((OutputStream) bufferedOutputStream);
                                            DynamicUtils.safeClose(inputStream);
                                            DynamicUtils.safeClose((OutputStream) byteArrayOutputStream);
                                            throw th;
                                        }
                                    }
                                    byteArrayOutputStream = null;
                                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(realFileName));
                                    while (true) {
                                        read = inputStream3.read(bArr, 0, 1024);
                                        if (read != -1) {
                                        }
                                        bufferedOutputStream.write(bArr, 0, read);
                                    }
                                    DynamicUtils.safeClose(inputStream3);
                                    DynamicUtils.safeClose((OutputStream) bufferedOutputStream);
                                    DynamicUtils.safeClose(inputStream);
                                    DynamicUtils.safeClose((OutputStream) byteArrayOutputStream);
                                    file2 = file;
                                } catch (Exception e26) {
                                    e = e26;
                                    bufferedOutputStream2 = null;
                                    inputStream3 = null;
                                    byteArrayOutputStream = null;
                                    DynamicReporter.reportUnzipEntryError(name, e.getClass().getName(), e.getMessage());
                                    zipFile.close();
                                    throw e;
                                } catch (Throwable th10) {
                                    th = th10;
                                    bufferedOutputStream = null;
                                    inputStream2 = null;
                                    byteArrayOutputStream = null;
                                    DynamicUtils.safeClose(inputStream2);
                                    DynamicUtils.safeClose((OutputStream) bufferedOutputStream);
                                    DynamicUtils.safeClose(inputStream);
                                    DynamicUtils.safeClose((OutputStream) byteArrayOutputStream);
                                    throw th;
                                }
                            }
                        } catch (Exception e27) {
                            e = e27;
                            inputStream = null;
                        } catch (Throwable th11) {
                            th = th11;
                            bufferedOutputStream = null;
                            inputStream = null;
                        }
                    }
                }
            }
            zipFile.close();
        }
    }

    public static void updateLastModified(File file) {
        if (file != null && file.exists()) {
            DynamicUtils.runOnAsyncThread(new Runnable(file) { // from class: com.tencent.ams.dsdk.utils.FileUtils.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ File val$file;

                {
                    this.val$file = file;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) file);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    File file2 = this.val$file;
                    if (file2 != null && file2.exists()) {
                        try {
                            this.val$file.setLastModified(System.currentTimeMillis());
                        } catch (Throwable th5) {
                            DLog.e("FileUtils", "setLastModified error.", th5);
                        }
                    }
                }
            });
        }
    }

    public static boolean writeBytesToFile(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length == 0) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                DLog.w("FileUtils", "mkdirs error. dir: " + parentFile);
                return false;
            }
            if (!file.exists() && !file.createNewFile()) {
                DLog.w("FileUtils", "create file error. file: " + file);
                return false;
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                DynamicUtils.safeClose((OutputStream) fileOutputStream2);
                return true;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = fileOutputStream2;
                try {
                    DLog.e("FileUtils", "writeTadCacheSplash error.", th);
                    return false;
                } finally {
                    DynamicUtils.safeClose((OutputStream) fileOutputStream);
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static void clearExpireFile(String str, long j3, boolean z16) {
        File[] listFiles;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return;
        }
        System.currentTimeMillis();
        for (File file2 : listFiles) {
            try {
                if ((!file2.isDirectory() || !z16) && isExpireFile(file2, j3)) {
                    deleteFile(file2);
                    DLog.i("FileUtils", "delete expire file: " + file2);
                }
            } catch (Throwable th5) {
                DLog.i("FileUtils", "check file expred error.", th5);
            }
        }
    }

    public static String getFileDir(Context context) {
        File filesDir;
        if (context == null) {
            context = DKEngine.getApplicationContext();
        }
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            return null;
        }
        return new File(filesDir, "dsdk").getAbsolutePath();
    }

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return deleteFile(new File(str));
    }
}
