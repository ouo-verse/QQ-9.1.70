package com.tencent.qqlive.tvkplayer.tools.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKIOUtil {
    private static final String PROTOCOL_ASSET = "asset";
    private static final String PROTOCOL_FILE = "file";
    private static final String PROTOCOL_HTTP = "http";
    private static final String PROTOCOL_HTTPS = "https";
    private static final String TAG = "TVKPlayer[TVKIOUtil]";
    private static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static void appendHexPair(byte b16, StringBuffer stringBuffer) {
        char[] cArr = hexDigits;
        char c16 = cArr[(b16 & 240) >> 4];
        char c17 = cArr[b16 & RegisterType.DOUBLE_HI];
        stringBuffer.append(c16);
        stringBuffer.append(c17);
    }

    private static String bufferToHex(byte[] bArr, int i3, int i16) {
        StringBuffer stringBuffer = new StringBuffer(i16 * 2);
        int i17 = i16 + i3;
        while (i3 < i17) {
            appendHexPair(bArr[i3], stringBuffer);
            i3++;
        }
        return stringBuffer.toString();
    }

    public static void clearDir(File file) {
        File[] listFiles;
        if (file.isFile() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                file2.delete();
            } else {
                deleteDir(file2);
            }
        }
    }

    public static void close(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16, "[close]");
        }
    }

    public static File compare(File file, File file2) {
        if (file == null) {
            return file2;
        }
        if (file2 != null && file2.exists()) {
            if (!file.exists()) {
                return file2;
            }
            if (file.lastModified() <= file2.lastModified()) {
                return file2;
            }
            return file;
        }
        return file;
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null || outputStream == null) {
            return 0;
        }
        byte[] bArr = new byte[1024];
        int i3 = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                i3 += read;
            } catch (IOException e16) {
                TVKLogUtil.e(TAG, e16);
            }
        }
        return i3;
    }

    public static void createDirectoryIfNeeded(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public static boolean createFile(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        if (!createParentDirectories(file)) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean createParentDirectories(File file) {
        if (file == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            return parentFile.mkdirs();
        }
        if (parentFile != null && parentFile.exists() && !parentFile.isDirectory() && parentFile.canWrite() && parentFile.delete()) {
            return parentFile.mkdirs();
        }
        if (parentFile != null) {
            return parentFile.isDirectory();
        }
        return false;
    }

    public static boolean deleteDir(File file) {
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list == null) {
                return true;
            }
            for (String str : list) {
                if (!deleteDir(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean deleteFile(String str) {
        return new File(str).delete();
    }

    public static void deleteSuffixFiles(File file, String str) {
        File[] listFiles;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (!file.exists() || !file.isFile() || (listFiles = file.listFiles()) == null) {
                return;
            }
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (file2.isFile() && name.endsWith(str) && file2.delete()) {
                    Log.e("deleteSuffixFiles", "file delete err, filename:" + name);
                }
            }
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
        }
    }

    private static void extractFile(ZipInputStream zipInputStream, String str) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
        try {
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read != -1) {
                        bufferedOutputStream.write(bArr, 0, read);
                    } else {
                        return;
                    }
                }
            } catch (IOException e16) {
                throw e16;
            }
        } finally {
            bufferedOutputStream.close();
        }
    }

    public static String findPathWithName(String str, String str2, File file) {
        File[] listFiles;
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return "";
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (file2.getName().equals(str) && file2.getParentFile().getName().equals(str2)) {
                    return file2.getAbsolutePath();
                }
            } else {
                String findPathWithName = findPathWithName(str, str2, file2);
                if (!TextUtils.isEmpty(findPathWithName)) {
                    return findPathWithName;
                }
            }
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getFileMD5String(File file) throws IOException {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        String str = null;
        str = null;
        str = null;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                fileInputStream = new FileInputStream(file);
            } catch (NoSuchAlgorithmException e16) {
                e = e16;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (fileInputStream2 != null) {
                }
                throw th;
            }
        } catch (IOException e17) {
            TVKLogUtil.e(TAG, e17);
        }
        try {
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                str = bufferToHex(messageDigest.digest());
                fileInputStream.close();
            } catch (Throwable th6) {
                th = th6;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e18) {
                        TVKLogUtil.e(TAG, e18);
                    }
                }
                throw th;
            }
        } catch (NoSuchAlgorithmException e19) {
            e = e19;
            TVKLogUtil.e(TAG, e);
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return str;
        }
        return str;
    }

    public static String getPath(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("^(\\w+):/{2,3}(.*)").matcher(str);
        if (matcher.find() && matcher.group(1).equals(PROTOCOL_ASSET)) {
            return matcher.group(2);
        }
        return str;
    }

    public static final String getProtocol(String str) {
        if (str != null && str.length() > 0) {
            Matcher matcher = Pattern.compile("^(\\w+):/{2,3}").matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        return "file";
    }

    public static boolean isExternalStorageMounted() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isFileExists(String str) {
        return new File(str).exists();
    }

    public static boolean isFileMD5Matched(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    TVKLogUtil.i(TAG, "isFileMD5Matched: file.exists failed.");
                    return false;
                }
                return getFileMD5String(file).equalsIgnoreCase(str2);
            } catch (Exception e16) {
                TVKLogUtil.e(TAG, "isFileMD5Matched: Exception: " + e16.toString());
            }
        }
        return false;
    }

    public static boolean moveFile(File file, File file2, String str) {
        String[] list;
        if (TextUtils.isEmpty(str) || !file.isDirectory() || !file2.isDirectory() || (list = file.list()) == null) {
            return false;
        }
        for (String str2 : list) {
            if (str2.endsWith(str)) {
                File file3 = new File(file, str2);
                if (file3.isFile() && !file3.renameTo(new File(file2, str2))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static InputStream open(Context context, String str) {
        String protocol2 = getProtocol(str);
        if (protocol2.equals(PROTOCOL_ASSET)) {
            try {
                return context.getAssets().open(getPath(str));
            } catch (IOException unused) {
                return null;
            }
        }
        if (protocol2.equals("file")) {
            try {
                return new FileInputStream(getPath(str));
            } catch (Exception unused2) {
                return null;
            }
        }
        if (!protocol2.equals("http") && !protocol2.equals("https")) {
            return null;
        }
        try {
            return new URL(str).openStream();
        } catch (Exception unused3) {
            return null;
        }
    }

    public static InputStream openInputStream(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return openInputStream(new File(str));
    }

    public static OutputStream openOutputStream(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return openOutputStream(new File(str));
    }

    public static byte[] read(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e16) {
                TVKLogUtil.e(TAG, e16);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void recursiveDelete(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles == null) {
                            return;
                        }
                        for (File file2 : listFiles) {
                            recursiveDelete(file2);
                        }
                    }
                    file.delete();
                }
            } catch (Exception e16) {
                TVKLogUtil.e(TAG, e16);
            }
        }
    }

    public static void unzip(String str, String str2) throws IOException, IllegalArgumentException {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            if (file.isDirectory()) {
                if (!file.exists()) {
                    file.mkdir();
                }
                ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
                try {
                    try {
                        for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                            String str3 = str2 + File.separator + nextEntry.getName();
                            if (!nextEntry.isDirectory() && !str3.contains("__MACOSX")) {
                                extractFile(zipInputStream, str3);
                            } else {
                                new File(str3).mkdir();
                            }
                            zipInputStream.closeEntry();
                        }
                        return;
                    } catch (IOException e16) {
                        throw e16;
                    }
                } finally {
                    zipInputStream.close();
                }
            }
            throw new IOException("destDir:" + str2 + ", is not a Directory");
        }
        throw new IllegalArgumentException("zipSrcFilePath is empty: " + TextUtils.isEmpty(str) + "destDirectory is empty: " + TextUtils.isEmpty(str2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0023, code lost:
    
        if (r4.createNewFile() == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean write(File file, byte[] bArr, int i3, int i16) {
        FileOutputStream fileOutputStream;
        if (file != null && bArr != null && bArr.length > 0) {
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.mkdirs()) {
                    return false;
                }
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception unused) {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                fileOutputStream.write(bArr, i3, i16);
                try {
                    fileOutputStream.close();
                    return true;
                } catch (IOException e16) {
                    TVKLogUtil.e(TAG, e16);
                    return true;
                }
            } catch (Exception unused2) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e17) {
                        TVKLogUtil.e(TAG, e17);
                    }
                }
                return false;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e18) {
                        TVKLogUtil.e(TAG, e18);
                    }
                }
                throw th;
            }
        }
        return false;
        return false;
    }

    public static InputStream openInputStream(File file) {
        if (file == null) {
            return null;
        }
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    public static OutputStream openOutputStream(File file) {
        if (file != null && createFile(file)) {
            try {
                return new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }

    private static String bufferToHex(byte[] bArr) {
        return bufferToHex(bArr, 0, bArr.length);
    }

    public static int copy(File file, File file2) {
        FileOutputStream fileOutputStream;
        if (file == null || file2 == null || !file.exists()) {
            return 0;
        }
        if (!file2.exists()) {
            File parentFile = file2.getParentFile();
            if (parentFile == null) {
                return 0;
            }
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                return 0;
            }
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    int copy = copy(fileInputStream2, fileOutputStream);
                    try {
                        fileInputStream2.close();
                    } catch (IOException e16) {
                        TVKLogUtil.e(TAG, e16);
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException e17) {
                        TVKLogUtil.e(TAG, e17);
                    }
                    return copy;
                } catch (FileNotFoundException unused) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e18) {
                            TVKLogUtil.e(TAG, e18);
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e19) {
                            TVKLogUtil.e(TAG, e19);
                        }
                    }
                    return 0;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e26) {
                            TVKLogUtil.e(TAG, e26);
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            throw th;
                        } catch (IOException e27) {
                            TVKLogUtil.e(TAG, e27);
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused2) {
                fileOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
            }
        } catch (FileNotFoundException unused3) {
            fileOutputStream = null;
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream = null;
        }
    }

    public static boolean createFile(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return createFile(new File(str));
    }

    public static byte[] read(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] read = read(fileInputStream);
                    try {
                        fileInputStream.close();
                    } catch (IOException e16) {
                        TVKLogUtil.e(TAG, e16);
                    }
                    return read;
                } catch (FileNotFoundException unused) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e17) {
                            TVKLogUtil.e(TAG, e17);
                        }
                    }
                    return null;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e18) {
                            TVKLogUtil.e(TAG, e18);
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused2) {
                fileInputStream = null;
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return null;
    }

    public static boolean createParentDirectories(String str) {
        return createParentDirectories(new File(str));
    }
}
