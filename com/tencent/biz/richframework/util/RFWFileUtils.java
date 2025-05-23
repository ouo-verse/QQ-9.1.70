package com.tencent.biz.richframework.util;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.file.FileType;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWFileUtils {
    private static volatile File sExternalPrivateRootFile;
    private static volatile File sInnerPrivateRootFile;

    private static String bytesToHex(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder();
        if (bArr != null) {
            for (byte b16 : bArr) {
                sb5.append(String.format("%02X", Byte.valueOf(b16)));
            }
        }
        return sb5.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
        } catch (IOException e16) {
            e = e16;
            bufferedInputStream = null;
            try {
                RFWLog.e("RFWFileUtils", RFWLog.USR, "copyFile error, ", e);
                if (fileOutputStream2 != null) {
                }
                if (bufferedInputStream != null) {
                }
                return false;
            } catch (Throwable th5) {
                th = th5;
                if (fileOutputStream2 != null) {
                    RFWIOUtil.closeAll(fileOutputStream2);
                }
                if (bufferedInputStream != null) {
                    RFWIOUtil.closeAll(bufferedInputStream);
                }
                throw th;
            }
        } catch (OutOfMemoryError e17) {
            e = e17;
            bufferedInputStream = null;
            RFWLog.e("RFWFileUtils", RFWLog.USR, "copyFile error, ", e);
            if (fileOutputStream2 != null) {
            }
            if (bufferedInputStream != null) {
            }
            return false;
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream = null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        } catch (IOException e18) {
            e = e18;
            bufferedInputStream = null;
            fileOutputStream2 = fileOutputStream;
            RFWLog.e("RFWFileUtils", RFWLog.USR, "copyFile error, ", e);
            if (fileOutputStream2 != null) {
            }
            if (bufferedInputStream != null) {
            }
            return false;
        } catch (OutOfMemoryError e19) {
            e = e19;
            bufferedInputStream = null;
            fileOutputStream2 = fileOutputStream;
            RFWLog.e("RFWFileUtils", RFWLog.USR, "copyFile error, ", e);
            if (fileOutputStream2 != null) {
            }
            if (bufferedInputStream != null) {
            }
            return false;
        } catch (Throwable th7) {
            th = th7;
            bufferedInputStream = null;
        }
        try {
            byte[] buf = ByteArrayPool.getGenericInstance().getBuf(4096);
            while (true) {
                int read = bufferedInputStream.read(buf);
                if (read != -1) {
                    fileOutputStream.write(buf, 0, read);
                    fileOutputStream.flush();
                } else {
                    ByteArrayPool.getGenericInstance().returnBuf(buf);
                    RFWIOUtil.closeAll(fileOutputStream);
                    RFWIOUtil.closeAll(bufferedInputStream);
                    return true;
                }
            }
        } catch (IOException e26) {
            e = e26;
            fileOutputStream2 = fileOutputStream;
            RFWLog.e("RFWFileUtils", RFWLog.USR, "copyFile error, ", e);
            if (fileOutputStream2 != null) {
                RFWIOUtil.closeAll(fileOutputStream2);
            }
            if (bufferedInputStream != null) {
                RFWIOUtil.closeAll(bufferedInputStream);
            }
            return false;
        } catch (OutOfMemoryError e27) {
            e = e27;
            fileOutputStream2 = fileOutputStream;
            RFWLog.e("RFWFileUtils", RFWLog.USR, "copyFile error, ", e);
            if (fileOutputStream2 != null) {
            }
            if (bufferedInputStream != null) {
            }
            return false;
        } catch (Throwable th8) {
            th = th8;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
            }
            if (bufferedInputStream != null) {
            }
            throw th;
        }
    }

    public static File createFile(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (file.getParentFile().mkdirs()) {
                    file.createNewFile();
                }
            } else {
                file.createNewFile();
            }
        }
        return file;
    }

    public static void createFileIfNotExits(String str) {
        if (!fileExists(str)) {
            try {
                createFile(str);
            } catch (IOException e16) {
                if (RFWLog.isColorLevel()) {
                    RFWLog.e("RFWFileUtils", RFWLog.CLR, "createFileIfNotExits", e16);
                }
            }
        }
    }

    public static File createNewFile(String str) {
        try {
            File file = new File(str);
            if (file.getParentFile() != null && !file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
                RFWLog.e("RFWFileUtils", RFWLog.USR, "[createNewFile] mkDirSuccess false, fileName=", str);
                return null;
            }
            if (file.exists()) {
                RFWLog.d("RFWFileUtils", RFWLog.USR, "[createNewFile] tempFile exists fileName=", str);
                deleteFile(file);
            }
            if (file.createNewFile()) {
                return file;
            }
            RFWLog.e("RFWFileUtils", RFWLog.USR, "[createNewFile] createNewFile false fileName=", str);
            return null;
        } catch (IOException e16) {
            RFWLog.e("RFWFileUtils", RFWLog.USR, "[createNewFile] error fileName=", str, " error=", e16);
            return null;
        }
    }

    public static void createNoMediaFile(String str) {
        createFileIfNotExits(new File(str).getParentFile().getAbsolutePath() + File.separator + ".nomedia");
    }

    public static void deleteDb(String str) {
        try {
            File databasePath = RFWApplication.getApplication().getDatabasePath(str);
            deleteFile(databasePath);
            deleteFile(databasePath.getPath() + "-shm");
            deleteFile(databasePath.getPath() + "-wal");
        } catch (Exception e16) {
            RFWLog.e("RFWFileUtils", RFWLog.USR, e16);
        }
    }

    public static void deleteFile(File file) {
        File[] listFiles;
        try {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    deleteFile(file2);
                }
            }
            file.delete();
        } catch (Exception unused) {
            RFWLog.e("RFWFileUtils", RFWLog.USR, "deleteFile error");
        }
    }

    public static boolean deleteFileIfBlank(String str) {
        if (isBlankFile(str)) {
            deleteFile(str);
            return true;
        }
        return false;
    }

    public static boolean fileExists(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean fileExistsWithBlackCheck(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || file.length() == 0) {
            return false;
        }
        return true;
    }

    public static String generateUniqueFileName(String str, String str2, String str3) {
        String str4 = str + File.separator + str2 + "." + str3;
        String str5 = str2;
        int i3 = 1;
        while (new File(str4).exists()) {
            str5 = str2 + "(" + i3 + ")";
            str4 = str + File.separator + str5 + "." + str3;
            i3++;
        }
        return str5;
    }

    public static File getExternalPrivateFile() {
        if (sExternalPrivateRootFile == null) {
            synchronized (RFWFileUtils.class) {
                if (sExternalPrivateRootFile == null) {
                    sExternalPrivateRootFile = RFWApplication.getApplication().getExternalFilesDir(null);
                }
            }
        }
        return sExternalPrivateRootFile;
    }

    public static String getFileExtensionFromFileHeader(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            try {
                byte[] bArr = new byte[12];
                fileInputStream.read(bArr);
                String upperCase = bytesToHex(bArr).toUpperCase();
                for (FileType fileType : FileType.values()) {
                    if (fileType.matches(upperCase)) {
                        String lowerCase = fileType.name().toLowerCase();
                        fileInputStream.close();
                        return lowerCase;
                    }
                }
                fileInputStream.close();
            } finally {
            }
        } catch (IOException e16) {
            RFWLog.e("RFWFileUtils", RFWLog.USR, "getFileExtension  e = " + e16);
        }
        return "";
    }

    @NonNull
    public static String getFileExtensionFromFilePath(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > Math.max(str.lastIndexOf(47), str.lastIndexOf(92))) {
            return str.substring(lastIndexOf + 1);
        }
        return "";
    }

    @NonNull
    public static String getFileExtensionFromUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return getFileExtensionFromFilePath(new URL(str).getPath());
        } catch (Exception e16) {
            RFWLog.fatal("RFWFileUtils", RFWLog.USR, "[getFileExtensionFromUrl] error, url: " + str, e16);
            return "";
        }
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x005b: MOVE (r4 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:92), block:B:20:0x005b */
    public static long getFileSizes(String str) {
        FileInputStream fileInputStream;
        Exception e16;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                File file = new File(str);
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        long available = fileInputStream.available();
                        RFWIOUtil.closeAll(fileInputStream);
                        return available;
                    } catch (Exception e17) {
                        e16 = e17;
                        RFWLog.e("RFWFileUtils", RFWLog.USR, "get file size failed:" + str, e16);
                        RFWIOUtil.closeAll(fileInputStream);
                        return 0L;
                    }
                }
                RFWIOUtil.closeAll(null);
                return 0L;
            } catch (Exception e18) {
                fileInputStream = null;
                e16 = e18;
            } catch (Throwable th5) {
                th = th5;
                RFWIOUtil.closeAll(closeable2);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            closeable2 = closeable;
            RFWIOUtil.closeAll(closeable2);
            throw th;
        }
    }

    public static FileType getFileType(@Nullable InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            try {
                byte[] bArr = new byte[12];
                inputStream.read(bArr);
                String upperCase = bytesToHex(bArr).toUpperCase();
                RFWLog.d("RFWFileUtils", RFWLog.USR, "getFileExtension  fileHeader = " + upperCase);
                FileType[] values = FileType.values();
                int length = values.length;
                for (int i3 = 0; i3 < length; i3++) {
                    FileType fileType = values[i3];
                    if (fileType.matches(upperCase)) {
                        inputStream.close();
                        return fileType;
                    }
                }
                inputStream.close();
            } finally {
            }
        } catch (IOException e16) {
            RFWLog.e("RFWFileUtils", RFWLog.USR, "[getFileType]  e = " + e16);
        }
        return null;
    }

    public static FileType getFileTypeByExtension(String str) {
        String fileExtensionFromFilePath = getFileExtensionFromFilePath(str);
        if (TextUtils.isEmpty(fileExtensionFromFilePath)) {
            RFWLog.e("RFWFileUtils", RFWLog.USR, "[getFileTypeByExtension] getExtension error, filePath: " + str);
            return null;
        }
        RFWLog.d("RFWFileUtils", RFWLog.USR, "[getFileTypeByExtension] fileExtension from Path: " + fileExtensionFromFilePath);
        for (FileType fileType : FileType.values()) {
            if (fileExtensionFromFilePath.equalsIgnoreCase(fileType.getTypeInfo().getFileExtension())) {
                return fileType;
            }
        }
        return null;
    }

    private static FileType getFileTypeByMimeTool(String str) {
        String mimeByMimeTool = RFWMimeUtil.getMimeByMimeTool(str);
        if (TextUtils.isEmpty(mimeByMimeTool)) {
            return null;
        }
        return getFileTypeFromMime(mimeByMimeTool);
    }

    public static FileType getFileTypeFromMime(String str) {
        for (FileType fileType : FileType.values()) {
            if (str.equalsIgnoreCase(RFWMimeUtil.getMimePrefixByMediaType(fileType.getTypeInfo().getMediaType()) + "/" + fileType.getTypeInfo().getMIMEType())) {
                return fileType;
            }
        }
        return null;
    }

    public static File getInnerPrivateFile() {
        if (sInnerPrivateRootFile == null) {
            synchronized (RFWFileUtils.class) {
                if (sInnerPrivateRootFile == null) {
                    sInnerPrivateRootFile = RFWApplication.getApplication().getFilesDir();
                }
            }
        }
        return sInnerPrivateRootFile;
    }

    public static String getOriginSizeStr(long j3) {
        long j16 = j3 / 1024;
        DecimalFormat decimalFormat = new DecimalFormat("##0.0");
        if (j16 > 1024) {
            float f16 = ((float) j16) / 1024.0f;
            if (f16 > 1024.0f) {
                return decimalFormat.format(f16 / 1024.0f) + "G";
            }
            return decimalFormat.format(f16) + "M";
        }
        return j16 + "K";
    }

    public static boolean isBlankFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || file.length() != 0) {
            return false;
        }
        return true;
    }

    public static boolean isLocalPath(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("http")) {
            return false;
        }
        if ((!TextUtils.isEmpty(RFWSdcardUtils.getSdCardDirectory()) && str.startsWith(RFWSdcardUtils.getSdCardDirectory())) || str.startsWith("/data/")) {
            return true;
        }
        return new File(str).exists();
    }

    public static boolean isPrivateFilePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (getExternalPrivateFile() != null && str.startsWith(getExternalPrivateFile().getAbsolutePath())) {
            return true;
        }
        if (getInnerPrivateFile() == null || !str.startsWith(getInnerPrivateFile().getAbsolutePath())) {
            return false;
        }
        return true;
    }

    public static boolean isUriPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("content://") && !str.startsWith("file://")) {
            return false;
        }
        return true;
    }

    public static byte[] readFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return readFile(new File(str));
    }

    public static boolean renameFile(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            return new File(str).renameTo(new File(str2));
        } catch (Exception e16) {
            RFWLog.e("RFWFileUtils", RFWLog.USR, "renameFile e = " + e16);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Flushable[]] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.Flushable[]] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.OutputStream, com.tencent.biz.richframework.util.RecycleableBufferedOutputStream] */
    public static void unZipFile(File file, String str) throws IOException {
        InputStream inputStream;
        ?? obtain;
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        byte[] bArr = new byte[8192];
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            if (!nextElement.getName().contains("..")) {
                if (nextElement.isDirectory()) {
                    new File(new String((str + nextElement.getName()).getBytes("8859_1"), "GB2312")).mkdir();
                } else {
                    File file2 = new File(str + nextElement.getName());
                    file2.getParentFile().mkdirs();
                    InputStream inputStream2 = null;
                    try {
                        obtain = RecycleableBufferedOutputStream.obtain(new FileOutputStream(file2));
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = null;
                    }
                    try {
                        inputStream2 = zipFile.getInputStream(nextElement);
                        while (true) {
                            int read = inputStream2.read(bArr, 0, 8192);
                            if (read == -1) {
                                break;
                            } else {
                                obtain.write(bArr, 0, read);
                            }
                        }
                        RFWIOUtil.flushAll(new Flushable[]{obtain});
                        RFWIOUtil.closeAll(new Closeable[]{inputStream2, obtain});
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream = inputStream2;
                        inputStream2 = obtain;
                        RFWIOUtil.flushAll(new Flushable[]{inputStream2});
                        RFWIOUtil.closeAll(inputStream, inputStream2);
                        throw th;
                    }
                }
            }
        }
        zipFile.close();
    }

    public static boolean uriFileExist(String str) {
        try {
            InputStream openInputStream = RFWApplication.getApplication().getContentResolver().openInputStream(Uri.parse(str));
            if (openInputStream != null) {
                openInputStream.close();
            }
            return true;
        } catch (Exception e16) {
            RFWLog.e("RFWFileUtils", RFWLog.USR, e16);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v17, types: [int] */
    /* JADX WARN: Type inference failed for: r10v18, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r10v19, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r10v20, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r5v4, types: [com.tencent.biz.richframework.util.ByteArrayPool] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.tencent.biz.richframework.util.ByteArrayPool] */
    public static byte[] readFile(File file) {
        Object obj;
        ?? r65;
        ?? r75;
        int length;
        byte[] bArr = null;
        if (!file.exists()) {
            return null;
        }
        try {
            try {
                length = (int) file.length();
                r65 = new ByteArrayOutputStream(length);
            } catch (Exception e16) {
                e = e16;
                r65 = 0;
                r75 = 0;
            } catch (OutOfMemoryError e17) {
                e = e17;
                r65 = 0;
                r75 = 0;
            } catch (Throwable th5) {
                th = th5;
                obj = null;
                RFWIOUtil.closeAll(new Closeable[]{bArr, obj});
                throw th;
            }
            try {
                r75 = new FileInputStream(file);
                ?? r102 = 4096;
                try {
                    try {
                        try {
                            if (length < 4096) {
                                r102 = ByteArrayPool.getGenericInstance().getBuf(4096);
                            } else {
                                r102 = ByteArrayPool.getGenericInstance().getBuf(12288);
                            }
                        } catch (OutOfMemoryError e18) {
                            e = e18;
                            RFWLog.e("RFWFileUtils", RFWLog.USR, "readFileContent OutOfMemoryError", e);
                            RFWIOUtil.closeAll(new Closeable[]{r65, r75});
                            return bArr;
                        }
                    } catch (Exception e19) {
                        e = e19;
                        RFWLog.e("RFWFileUtils", RFWLog.USR, "readFileContent", e);
                        RFWIOUtil.closeAll(new Closeable[]{r65, r75});
                        return bArr;
                    }
                } catch (OutOfMemoryError unused) {
                    r102 = ByteArrayPool.getGenericInstance().getBuf(r102);
                }
                int i3 = 0;
                while (i3 < length) {
                    int read = r75.read(r102);
                    r65.write(r102, 0, read);
                    i3 += read;
                }
                ByteArrayPool.getGenericInstance().returnBuf(r102);
                bArr = r65.toByteArray();
                RFWIOUtil.closeAll(new Closeable[]{r65, r75});
            } catch (Exception e26) {
                e = e26;
                r75 = 0;
            } catch (OutOfMemoryError e27) {
                e = e27;
                r75 = 0;
            } catch (Throwable th6) {
                th = th6;
                obj = null;
                bArr = r65;
                RFWIOUtil.closeAll(new Closeable[]{bArr, obj});
                throw th;
            }
            return bArr;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public static void deleteFile(String str) {
        deleteFile(new File(str));
    }

    public static FileType getFileType(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            try {
                byte[] bArr = new byte[12];
                fileInputStream.read(bArr);
                String upperCase = bytesToHex(bArr).toUpperCase();
                RFWLog.d("RFWFileUtils", RFWLog.USR, "getFileExtension  fileHeader = " + upperCase);
                FileType[] values = FileType.values();
                int length = values.length;
                for (int i3 = 0; i3 < length; i3++) {
                    FileType fileType = values[i3];
                    if (fileType.matches(upperCase)) {
                        fileInputStream.close();
                        return fileType;
                    }
                }
                fileInputStream.close();
            } finally {
            }
        } catch (IOException e16) {
            RFWLog.e("RFWFileUtils", RFWLog.USR, "getFileExtension  e = " + e16);
        }
        FileType fileTypeByExtension = getFileTypeByExtension(str);
        return fileTypeByExtension == null ? getFileTypeByMimeTool(str) : fileTypeByExtension;
    }
}
