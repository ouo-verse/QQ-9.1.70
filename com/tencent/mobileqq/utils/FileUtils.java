package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.commonsdk.zip.QZipInputStream;
import com.tencent.image.Utils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.EstablishSetting;
import com.tencent.util.Pair;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FileUtils {
    private static final String DCIM = "/DCIM/";
    public static final String FILE_TYPE_APNG = "apng";
    public static final String FILE_TYPE_AVI = "avi";
    public static final String FILE_TYPE_BMP = "bmp";
    public static final String FILE_TYPE_FLV = "flv";
    public static final String FILE_TYPE_GIF = "gif";
    public static final String FILE_TYPE_JPEG = "jpg";
    public static final String FILE_TYPE_MOV = "mov";
    public static final String FILE_TYPE_MP4 = "mp4";
    public static final String FILE_TYPE_PNG = "png";
    public static final String FILE_TYPE_SHARPP = "sharpp";
    public static final String FILE_TYPE_WEBP = "webp";
    public static final String FILE_TYPE_WMV = "wmv";
    public static final long ONE_GB = 1073741824;
    public static final long ONE_KB = 1024;
    public static final long ONE_MB = 1048576;
    private static final String PIC = "Pictures/";
    public static final int QUICK_MOVE_ARGS_ERROR = 1;
    public static final int QUICK_MOVE_MAKE_TRAGET_PARENT_FILE_FAIL = 2;
    public static final int QUICK_MOVE_RENAME_FAIL = 3;
    public static final int QUICK_MOVE_SUCCESS = 0;
    public static final String TAG = "FileUtils";
    private static Float sBaseNumber = null;
    public static String unKnownFileTypeMark = "unknown_";

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface OnFileExistsAndNotEmptyResult {
        void onComplete(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class StorageInfo {
        public boolean isRemoveable;
        public String path;
        public String state;

        public StorageInfo(String str) {
            this.path = str;
        }

        public boolean isMounted() {
            return "mounted".equals(this.state);
        }
    }

    public static String byteCountToDisplaySize(int i3, long j3) {
        if (j3 == 0) {
            if (i3 == 0) {
                return "0.0B";
            }
            if (i3 == 1) {
                return "0.0K";
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        if (j3 / 1073741824 > 0) {
            float f16 = ((float) j3) / 1.07374182E9f;
            String format = decimalFormat.format(f16);
            if (format.endsWith(".0")) {
                return ((int) f16) + "G";
            }
            return format + "G";
        }
        if (j3 / 1048576 > 0) {
            float f17 = ((float) j3) / 1048576.0f;
            String format2 = decimalFormat.format(f17);
            if (format2.endsWith(".0")) {
                return ((int) f17) + "M";
            }
            return format2 + "M";
        }
        long j16 = j3 / 1024;
        if (j16 > 0) {
            return ((int) j16) + "K";
        }
        if (i3 == 0) {
            return decimalFormat.format(j3) + "B";
        }
        if (i3 == 1) {
            return ((int) j16) + "K";
        }
        return null;
    }

    public static String calcMd5(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        long length = file.length();
        if (length == 0) {
            return null;
        }
        return calcMd5(str, length);
    }

    public static boolean checkDiskCacheExist() {
        return fileExists(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH) + "/" + AppConstants.PATH_URLDRAWABLE_DISKCACHE);
    }

    protected static boolean checkEntryLegal(ZipEntry zipEntry, String str) {
        if (zipEntry.isDirectory()) {
            return true;
        }
        String name = zipEntry.getName();
        File file = new File(str + name);
        if (!file.exists()) {
            QLog.d("FileUtils", 1, "checkUnzipResult, file in path not exists: ", name);
            return false;
        }
        long size = zipEntry.getSize();
        long length = file.length();
        if (size == length) {
            return true;
        }
        QLog.d("FileUtils", 1, "checkUnzipResult, file size not same : ", name, " entrySize : ", Long.valueOf(size), " fileLength : ", Long.valueOf(length));
        return false;
    }

    public static boolean checkIsValidUri(String str) {
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                QLog.e("FileUtils", 1, "checkIsValidUri uri is null");
                return false;
            }
            String path = parse.getPath();
            if (path != null && !path.isEmpty()) {
                QLog.d("FileUtils", 1, "checkIsValidUri path=", path, ", actFilePath=", new File(path).getCanonicalPath());
                return !r3.startsWith(getDataDataPath() + BaseApplication.getContext().getPackageName());
            }
            QLog.e("FileUtils", 1, "checkIsValidUri path: " + path);
            return false;
        } catch (Throwable th5) {
            QLog.e("FileUtils", 1, "checkIsValidUri exception ", th5);
            return false;
        }
    }

    public static boolean checkMobileQQFolderExist() {
        return fileExists(AppConstants.SDCARD_PATH);
    }

    public static boolean checkTencentFolderExist() {
        return fileExists(AppConstants.SDCARD_ROOT + "/Tencent/");
    }

    public static boolean checkUnzipResult(InputStream inputStream, String str) {
        ZipEntry nextEntry;
        if (inputStream != null && str != null) {
            try {
                QZipInputStream qZipInputStream = new QZipInputStream(inputStream);
                do {
                    try {
                        nextEntry = qZipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            QLog.d("FileUtils", 1, "checkUnzipResult pass");
                            qZipInputStream.close();
                            return true;
                        }
                    } finally {
                    }
                } while (checkEntryLegal(nextEntry, str));
                qZipInputStream.close();
                return false;
            } catch (Exception e16) {
                QLog.d("FileUtils", 1, "checkUnzipResult error : ", e16);
                return false;
            }
        }
        QLog.d("FileUtils", 1, "checkUnzipResult stream or path is null");
        return false;
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean copyAssetDirsToSdcard(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                AssetManager assets = context.getAssets();
                for (String str3 : assets.list(str)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str);
                    String str4 = File.separator;
                    sb5.append(str4);
                    sb5.append(str3);
                    String sb6 = sb5.toString();
                    String str5 = str2 + str4 + str3;
                    if (assets.list(sb6).length == 0) {
                        copyAssetToFile(context, sb6, str5);
                    } else {
                        File file = new File(str2 + str4 + str3);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        copyAssetDirsToSdcard(context, sb6, str5);
                    }
                }
                return true;
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public static boolean copyAssetToFile(Context context, String str, String str2) {
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(str2);
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(context.getAssets().open(str));
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = bufferedInputStream2.read(bArr);
                            if (read != -1) {
                                fileOutputStream.write(bArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (IOException unused) {
                                }
                            }
                        }
                        bufferedInputStream2.close();
                        try {
                            fileOutputStream.close();
                            return true;
                        } catch (IOException unused2) {
                            return true;
                        }
                    } catch (IOException e16) {
                        e = e16;
                        bufferedInputStream = bufferedInputStream2;
                        if (QLog.isColorLevel()) {
                            QLog.e("FileUtils", 2, "copyAssetToFile: failed. ", e);
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused5) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                throw th;
                            } catch (IOException unused6) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (IOException e17) {
                    e = e17;
                }
            } catch (IOException e18) {
                e = e18;
                fileOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public static int copyDirectory(String str, String str2, boolean z16) {
        return copyDirectory(str, str2, z16, false, false);
    }

    public static int copyDocumentItemsToAnotherDocument(String str, String str2) {
        File file = new File(str);
        if (!file.isDirectory()) {
            return -1;
        }
        File file2 = new File(str2);
        if (!file2.exists() || !file2.isDirectory()) {
            file2.mkdirs();
        }
        File[] listFiles = file.listFiles();
        if (listFiles.length == 0) {
            return -2;
        }
        for (int i3 = 0; i3 < listFiles.length; i3++) {
            if (listFiles[i3].isDirectory()) {
                copyDocumentItemsToAnotherDocument(listFiles[i3].getPath() + "/" + listFiles[i3], str2 + "/" + listFiles[i3].getName());
            } else {
                copyFile(new File(listFiles[i3].getPath()), new File(str2 + "/" + listFiles[i3].getName()));
            }
        }
        return 1;
    }

    public static boolean copyFile(File file, File file2) {
        return copyFile(file, file2, false);
    }

    public static long copyFileUsingFileChannels(File file, File file2, int i3, int i16) throws IOException {
        FileChannel fileChannel;
        FileChannel fileChannel2;
        FileChannel channel;
        FileChannel fileChannel3 = null;
        try {
            channel = new FileInputStream(file).getChannel();
        } catch (FileNotFoundException unused) {
            fileChannel2 = null;
        } catch (Throwable th5) {
            th = th5;
            fileChannel = null;
        }
        try {
            fileChannel3 = new FileOutputStream(file2).getChannel();
            long transferFrom = fileChannel3.transferFrom(channel, i3, i16);
            if (channel != null) {
                channel.close();
            }
            fileChannel3.close();
            return transferFrom;
        } catch (FileNotFoundException unused2) {
            FileChannel fileChannel4 = fileChannel3;
            fileChannel3 = channel;
            fileChannel2 = fileChannel4;
            if (fileChannel3 != null) {
                fileChannel3.close();
            }
            if (fileChannel2 != null) {
                fileChannel2.close();
            }
            return 0L;
        } catch (Throwable th6) {
            th = th6;
            FileChannel fileChannel5 = fileChannel3;
            fileChannel3 = channel;
            fileChannel = fileChannel5;
            if (fileChannel3 != null) {
                fileChannel3.close();
            }
            if (fileChannel != null) {
                fileChannel.close();
            }
            throw th;
        }
    }

    public static void copyResToFile(Context context, int i3, String str) {
        FileOutputStream fileOutputStream;
        if (context != null && i3 != 0 && !TextUtils.isEmpty(str)) {
            SkinnableBitmapDrawable skinnableBitmapDrawable = (SkinnableBitmapDrawable) context.getResources().getDrawable(i3);
            File file = new File(str);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                try {
                    file.createNewFile();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException unused) {
                } catch (OutOfMemoryError unused2) {
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    skinnableBitmapDrawable.getBitmap().compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    fileOutputStream.close();
                } catch (IOException unused3) {
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 == null) {
                        return;
                    }
                    fileOutputStream2.close();
                } catch (OutOfMemoryError unused4) {
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 == null) {
                        return;
                    }
                    fileOutputStream2.close();
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused5) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused6) {
            }
        }
    }

    public static File createDirectory(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (file.getParentFile().mkdirs()) {
                    file.mkdirs();
                }
            } else {
                file.mkdirs();
            }
        }
        return file;
    }

    public static VFSFile createDirectoryVFS(String str) throws IOException {
        VFSFile vFSFile = new VFSFile(str);
        if (!vFSFile.exists()) {
            if (vFSFile.getParentFile() != null && !vFSFile.getParentFile().exists()) {
                if (vFSFile.getParentFile().mkdirs()) {
                    vFSFile.mkdirs();
                }
            } else {
                vFSFile.mkdirs();
            }
        }
        return vFSFile;
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
                if (QLog.isColorLevel()) {
                    QLog.i("FileUtils", 2, "createFileIfNotExits", e16);
                }
            }
        }
    }

    public static void delete(String str, boolean z16) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            delete(file2.getAbsolutePath(), z16);
        }
        if (!z16) {
            file.delete();
        }
    }

    public static void deleteDirectory(String str) {
        if (str != null && str.trim().length() != 0) {
            File file = new File(str);
            if (EstablishSetting.isDebugVersion() && !file.exists()) {
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (int i3 = 0; i3 < listFiles.length; i3++) {
                    if (listFiles[i3].isDirectory()) {
                        deleteDirectory(listFiles[i3].getAbsolutePath());
                    } else {
                        listFiles[i3].delete();
                    }
                }
            }
            file.delete();
        }
    }

    public static void deleteFile(File file) {
        File[] listFiles;
        if (file == null) {
            return;
        }
        try {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    deleteFile(file2);
                }
            }
            file.delete();
        } catch (Exception unused) {
            QLog.e("FileUtils", 1, "deleteFile error");
        }
    }

    public static void deleteFilesInDirectory(String str) {
        File[] listFiles;
        if (str != null && str.trim().length() != 0) {
            File file = new File(str);
            if ((!EstablishSetting.isDebugVersion() || file.exists()) && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (int i3 = 0; i3 < listFiles.length; i3++) {
                    if (listFiles[i3].isDirectory()) {
                        deleteDirectory(listFiles[i3].getAbsolutePath());
                    } else {
                        listFiles[i3].delete();
                    }
                }
            }
        }
    }

    public static boolean deleteVFSFile(String str) {
        VFSFile vFSFile = new VFSFile(str);
        if (vFSFile.exists()) {
            return vFSFile.delete();
        }
        return true;
    }

    public static String encryptFile(String str, String str2) {
        FileInputStream fileInputStream;
        File file = new File(str);
        FileInputStream fileInputStream2 = null;
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            fileInputStream = new FileInputStream(file);
            try {
                byte[] buf = ByteArrayPool.getGenericInstance().getBuf(8192);
                char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
                while (true) {
                    int read = fileInputStream.read(buf);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(buf, 0, read);
                }
                ByteArrayPool.getGenericInstance().returnBuf(buf);
                byte[] digest = messageDigest.digest();
                if (digest != null && digest.length != 0) {
                    char[] cArr2 = new char[digest.length * 2];
                    for (int i3 = 0; i3 < digest.length; i3++) {
                        byte b16 = digest[i3];
                        int i16 = i3 * 2;
                        cArr2[i16 + 1] = cArr[b16 & RegisterType.DOUBLE_HI];
                        cArr2[i16] = cArr[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI];
                    }
                    String str3 = new String(cArr2);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    return str3;
                }
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                }
                return null;
            } catch (IOException unused3) {
                if (fileInputStream == null) {
                    return null;
                }
                try {
                    fileInputStream.close();
                } catch (IOException unused4) {
                    return null;
                }
            } catch (NoSuchAlgorithmException unused5) {
                if (fileInputStream == null) {
                    return null;
                }
                fileInputStream.close();
            } catch (Throwable th5) {
                th = th5;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused6) {
                    }
                }
                throw th;
            }
        } catch (IOException unused7) {
            fileInputStream = null;
        } catch (NoSuchAlgorithmException unused8) {
            fileInputStream = null;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005c, code lost:
    
        if (r2 == null) goto L23;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0061: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:25:0x0061 */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String estimateFileType(String str) {
        String str2;
        FileInputStream fileInputStream;
        IOException e16;
        FileInputStream fileInputStream2;
        str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        FileInputStream fileInputStream3 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (IOException e17) {
                fileInputStream = null;
                e16 = e17;
            } catch (Throwable th5) {
                th = th5;
                if (fileInputStream3 != null) {
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[2];
                str2 = fileInputStream.read(bArr) != -1 ? estimateFileType(bArr) : "";
                fileInputStream.close();
            } catch (IOException e18) {
                e16 = e18;
                QLog.i("FileUtils", 1, "[estimateFileType] file=" + str + ", exc=" + e16 + ", stack=" + QLog.getStackTraceString(e16));
            }
            try {
                fileInputStream.close();
            } catch (IOException unused) {
                return str2;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream3 = fileInputStream2;
            if (fileInputStream3 != null) {
                try {
                    fileInputStream3.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00bb, code lost:
    
        if (r1 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b3, code lost:
    
        r1.close();
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b1, code lost:
    
        if (r1 == null) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String estimateVideoType(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        String str2;
        String str3;
        String str4 = "";
        ?? r16 = 0;
        FileInputStream fileInputStream3 = null;
        FileInputStream fileInputStream4 = null;
        try {
            try {
                fileInputStream2 = new FileInputStream(str);
            } catch (FileNotFoundException e16) {
                e = e16;
            } catch (IOException e17) {
                e = e17;
            }
            try {
                byte[] bArr = new byte[10];
                int read = fileInputStream2.read(bArr);
                Object obj = bArr;
                if (read != -1) {
                    StringBuilder sb5 = new StringBuilder();
                    for (int i3 = 0; i3 < 10; i3++) {
                        sb5.append(bArr[i3] & 255);
                    }
                    String str5 = "00032102116121112105115";
                    if (!sb5.toString().equals("00032102116121112105115")) {
                        String str6 = "00024102116121112109112";
                        if (sb5.toString().equals("00024102116121112109112")) {
                            str5 = str6;
                        } else {
                            String str7 = "827370701461421606586";
                            if (sb5.toString().equals("827370701461421606586")) {
                                str2 = FILE_TYPE_AVI;
                                str3 = str7;
                            } else {
                                String str8 = "483817811714210220717166217";
                                if (sb5.toString().equals("483817811714210220717166217")) {
                                    str2 = FILE_TYPE_WMV;
                                    str3 = str8;
                                } else {
                                    String str9 = "00020102116121112113116";
                                    if (sb5.toString().equals("00020102116121112113116")) {
                                        str2 = FILE_TYPE_MOV;
                                        str3 = str9;
                                    } else {
                                        String str10 = "7076861500090";
                                        if (sb5.toString().equals("7076861500090")) {
                                            str2 = "flv";
                                            str3 = str10;
                                        } else {
                                            StringBuilder sb6 = new StringBuilder();
                                            String str11 = unKnownFileTypeMark;
                                            sb6.append(str11);
                                            sb6.append((Object) sb5);
                                            str2 = sb6.toString();
                                            str3 = str11;
                                        }
                                    }
                                }
                            }
                            str4 = str2;
                            obj = str3;
                        }
                    }
                    str2 = "mp4";
                    str3 = str5;
                    str4 = str2;
                    obj = str3;
                }
                fileInputStream2.close();
                fileInputStream2.close();
                r16 = obj;
            } catch (FileNotFoundException e18) {
                e = e18;
                fileInputStream3 = fileInputStream2;
                e.printStackTrace();
                r16 = fileInputStream3;
                fileInputStream = fileInputStream3;
            } catch (IOException e19) {
                e = e19;
                fileInputStream4 = fileInputStream2;
                e.printStackTrace();
                r16 = fileInputStream4;
                fileInputStream = fileInputStream4;
            } catch (Throwable th5) {
                th = th5;
                r16 = fileInputStream2;
                if (r16 != 0) {
                    try {
                        r16.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
            return str4;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static boolean fileExists(String str) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return false;
        }
        return true;
    }

    public static boolean fileExistsAndNotEmpty(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.length() > 0;
    }

    public static byte[] fileToBytes(File file) {
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                try {
                    long length = file.length();
                    if (length <= TTL.MAX_VALUE && length > 0) {
                        int i3 = (int) length;
                        byte[] bArr = new byte[i3];
                        int i16 = 0;
                        while (i16 < i3) {
                            int read = bufferedInputStream.read(bArr, i16, i3 - i16);
                            if (read < 0) {
                                break;
                            }
                            i16 += read;
                        }
                        if (i16 < i3 && QLog.isColorLevel()) {
                            QLog.d("FileUtils", 2, "Could not completely read file " + file);
                        }
                        try {
                            bufferedInputStream.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                        try {
                            fileInputStream.close();
                        } catch (Throwable th6) {
                            th6.printStackTrace();
                        }
                        return bArr;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("FileUtils", 2, "return null. File length=" + length);
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th7) {
                        th7.printStackTrace();
                    }
                    try {
                        fileInputStream.close();
                    } catch (Throwable th8) {
                        th8.printStackTrace();
                    }
                    return null;
                } catch (Throwable unused) {
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d("FileUtils", 2, "Failed to read file " + file);
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Throwable th9) {
                                th9.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th10) {
                                th10.printStackTrace();
                            }
                        }
                        return null;
                    } finally {
                    }
                }
            } catch (Throwable unused2) {
                bufferedInputStream = null;
            }
        } catch (Throwable unused3) {
            fileInputStream = null;
            bufferedInputStream = null;
        }
    }

    public static float getAvailableExternalMemorySize() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception unused) {
            return -1.0f;
        }
    }

    public static float getAvailableInnernalMemorySize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception unused) {
            return -1.0f;
        }
    }

    public static float getBaseNumber() {
        boolean z16;
        float f16;
        Float f17 = sBaseNumber;
        if (f17 != null) {
            return f17.floatValue();
        }
        String str = Build.BRAND;
        boolean z17 = false;
        if (!"HUAWEI".equalsIgnoreCase(str) && !CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR.equalsIgnoreCase(str)) {
            z16 = false;
        } else {
            z16 = true;
        }
        String str2 = Build.MANUFACTURER;
        boolean equalsIgnoreCase = CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI.equalsIgnoreCase(str2);
        boolean equalsIgnoreCase2 = CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO.equalsIgnoreCase(str2);
        if (z16 || equalsIgnoreCase || equalsIgnoreCase2) {
            z17 = true;
        }
        if (z17) {
            f16 = 1000.0f;
        } else {
            f16 = 1024.0f;
        }
        Float valueOf = Float.valueOf(f16);
        sBaseNumber = valueOf;
        return valueOf.floatValue();
    }

    public static double getBaseNumberThreshold() {
        if (getBaseNumber() == 1000.0f) {
            return 0.9999499917030334d;
        }
        return 0.999951183795929d;
    }

    public static byte[] getByte(File file) throws Exception {
        byte[] bArr;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        r2 = null;
        byte[] bArr2 = null;
        fileInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                try {
                    int length = (int) file.length();
                    bArr = new byte[length];
                    int i3 = 0;
                    while (i3 < length) {
                        try {
                            int read = fileInputStream.read(bArr, i3, length - i3);
                            if (read < 0) {
                                break;
                            }
                            i3 += read;
                        } catch (Exception e16) {
                            e = e16;
                            fileInputStream2 = fileInputStream;
                            if (QLog.isColorLevel()) {
                                QLog.e("FileUtils", 2, "getByte excp!", e);
                            }
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e17) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("FileUtils", 2, "close steam excp!", e17);
                                    }
                                }
                            }
                            return bArr;
                        }
                    }
                    if (i3 < length) {
                        if (QLog.isColorLevel()) {
                            QLog.d("FileUtils", 2, "file length is error");
                        }
                    } else {
                        bArr2 = bArr;
                    }
                    try {
                        fileInputStream.close();
                        return bArr2;
                    } catch (IOException e18) {
                        if (QLog.isColorLevel()) {
                            QLog.e("FileUtils", 2, "close steam excp!", e18);
                            return bArr2;
                        }
                        return bArr2;
                    }
                } catch (Exception e19) {
                    e = e19;
                    bArr = null;
                }
            } catch (Throwable th6) {
                th = th6;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e26) {
                        if (QLog.isColorLevel()) {
                            QLog.e("FileUtils", 2, "close steam excp!", e26);
                        }
                    }
                }
                throw th;
            }
        } catch (Exception e27) {
            e = e27;
            bArr = null;
        }
    }

    @Nullable
    private static Handler getCallbackHandler() {
        if (Looper.myLooper() == null) {
            return null;
        }
        return new Handler(Looper.myLooper());
    }

    public static ArrayList<String> getChildFiles(String str) {
        return getChildFiles(str, false);
    }

    private static String getDataDataPath() {
        StringBuilder sb5 = new StringBuilder();
        String str = File.separator;
        sb5.append(str);
        sb5.append("data");
        sb5.append(str);
        sb5.append("data");
        sb5.append(str);
        return sb5.toString();
    }

    public static String getExtension(String str) {
        if (str == null) {
            return "";
        }
        if (str.endsWith(".rename")) {
            String replace = str.replace(".rename", "");
            int lastIndexOf = replace.lastIndexOf(".");
            if (lastIndexOf == -1) {
                return "";
            }
            if (replace.substring(lastIndexOf).replaceAll("[0-9]*", "").replace("(", "").replace(")", "").equalsIgnoreCase(".apk")) {
                return ".apk.rename";
            }
        }
        int lastIndexOf2 = str.lastIndexOf(".");
        if (lastIndexOf2 < 0) {
            return "";
        }
        return str.substring(lastIndexOf2);
    }

    public static long getFileAmount(String str) {
        File[] listFiles;
        File file = new File(str);
        long j3 = 0;
        if (file.exists()) {
            if (file.isFile()) {
                return 1L;
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2 != null && file2.exists()) {
                        if (file2.isDirectory()) {
                            j3 += getFileAmount(file2.getAbsolutePath());
                        } else {
                            j3++;
                        }
                    }
                }
            }
        }
        return j3;
    }

    public static String getFileDirectoryOf(String str) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf("/")) < 0) {
            return null;
        }
        return str.substring(0, lastIndexOf + 1);
    }

    public static String getFileName(String str) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.eAsync("FMERROR", 1, "getFileName but strFilePath is null");
            }
            if (QLog.isDevelopLevel()) {
                printStack();
            }
            return "";
        }
        int length = str.length();
        int lastIndexOf = str.lastIndexOf(47);
        int lastIndexOf2 = str.lastIndexOf(92);
        if (lastIndexOf2 > lastIndexOf) {
            lastIndexOf = lastIndexOf2;
        }
        if (lastIndexOf < 0) {
            if (QLog.isColorLevel()) {
                QLog.e("FileUtils", 2, "filepath without / ?");
            }
            i3 = 0;
        } else {
            i3 = 1 + lastIndexOf;
        }
        String substring = str.substring(i3, length);
        if (QLog.isColorLevel() && substring != null && substring.startsWith(".")) {
            QLog.e("FileUtils", 2, "InvaildName ,filePath[" + str + "], subName[" + substring + "]");
        }
        String str2 = substring;
        while (str2 != null && str2.startsWith(".")) {
            str2 = str2.replaceFirst(".", "");
        }
        if (TextUtils.isEmpty(str2)) {
            if (QLog.isColorLevel()) {
                QLog.e("FileUtils", 2, "InvaildName ,filePath[" + str + "], subName[" + substring + "]");
            }
            return "InvaildName";
        }
        return str2;
    }

    public static long getFileOrFolderSize(String str) {
        File[] listFiles;
        long length;
        File file = new File(str);
        long j3 = 0;
        if (file.exists()) {
            if (file.isFile()) {
                return file.length();
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2 != null && file2.exists()) {
                        if (file2.isDirectory()) {
                            length = getFileOrFolderSize(file2.getAbsolutePath());
                        } else if (file2.isFile()) {
                            length = file2.length();
                        }
                        j3 += length;
                    }
                }
            }
        }
        return j3;
    }

    public static String getFileSize(long j3) {
        return ao.a(j3);
    }

    public static long getFileSizes(String str) {
        FileInputStream fileInputStream = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                return 0L;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                long available = fileInputStream2.available();
                try {
                    fileInputStream2.close();
                } catch (IOException unused) {
                }
                return available;
            } catch (Exception unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return 0L;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static float getTotalExternalMemorySize() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Exception unused) {
            return -1.0f;
        }
    }

    public static float getTotalInnernalMemorySize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Exception unused) {
            return -1.0f;
        }
    }

    public static String getUnitFileName(String str, String str2) {
        String str3;
        File file = new File(str);
        if (!new File(file, str2).exists()) {
            return str2;
        }
        if (str2.lastIndexOf(46) < 0) {
            str3 = "";
        } else {
            String substring = str2.substring(0, str2.lastIndexOf(46));
            String substring2 = str2.substring(substring.length(), str2.length());
            str2 = substring;
            str3 = substring2;
        }
        int i3 = 1;
        while (true) {
            String str4 = str2 + "(" + i3 + ")" + str3;
            if (new File(file, str4).exists()) {
                i3++;
            } else {
                return str4;
            }
        }
    }

    public static boolean hasSDCardAndWritable() {
        boolean z16;
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory.exists() && externalStorageDirectory.canWrite()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.e("FileUtils", 2, "existAndCanWrite=" + z16 + " externalDir.canWrite()= " + externalStorageDirectory.canWrite() + " state=" + Environment.getExternalStorageState().equals("mounted"));
            }
            if (!Environment.getExternalStorageState().equals("mounted") || !z16) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("FileUtils", 2, "hasSDCardAndWritable", e16);
            }
            return false;
        }
    }

    public static boolean isAssetsFileExist(Context context, String str) {
        try {
            context.getAssets().open(str).close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean isDir(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        return true;
    }

    public static boolean isEmptyFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        File file = new File(str);
        if (!file.exists() || file.length() <= 0) {
            return true;
        }
        return false;
    }

    public static boolean isLocalPath(String str) {
        if (str != null && (str.startsWith(AppConstants.SDCARD_ROOT) || str.startsWith(AppConstants.INTERNAL_MEDIA) || new File(str).exists())) {
            return true;
        }
        return false;
    }

    public static boolean isNeedTransPic(@NonNull List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (isNeedTransPic(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPicFile(String str) {
        String estimateFileType = estimateFileType(str);
        if (!estimateFileType.equals("jpg") && !estimateFileType.equals("gif") && !estimateFileType.equals("bmp") && !estimateFileType.equals("png")) {
            return false;
        }
        return true;
    }

    public static boolean isPicFileByExt(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.equals("jpg") && !str.equals("gif") && !str.equals("bmp") && !str.equals("png")) {
            return false;
        }
        return true;
    }

    public static boolean isValidPathCanDelete(String str) {
        if (TextUtils.isEmpty(str) || str.contains(DCIM) || str.contains(PIC)) {
            return false;
        }
        return true;
    }

    public static boolean justOnExistFileAndAddSuffix(String str, StringBuffer stringBuffer, String str2) {
        boolean z16;
        File file = new File(str);
        File file2 = new File(str + stringBuffer.toString());
        if (!file.exists()) {
            z16 = file.mkdirs();
        } else {
            z16 = true;
        }
        if (file.exists() && file2.exists()) {
            stringBuffer.insert(stringBuffer.indexOf(str2), "(0)");
            while (file2.exists()) {
                int lastIndexOf = stringBuffer.lastIndexOf("(") + 1;
                int lastIndexOf2 = stringBuffer.lastIndexOf(")");
                stringBuffer.replace(lastIndexOf, lastIndexOf2, String.valueOf(Integer.parseInt(stringBuffer.substring(lastIndexOf, lastIndexOf2)) + 1));
                file2 = new File(str + ((Object) stringBuffer));
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$fileExistsAndNotEmpty$1(String str, Handler handler, final OnFileExistsAndNotEmptyResult onFileExistsAndNotEmptyResult) {
        final boolean fileExistsAndNotEmpty = fileExistsAndNotEmpty(str);
        if (handler == null) {
            onFileExistsAndNotEmptyResult.onComplete(fileExistsAndNotEmpty);
        } else {
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.utils.aq
                @Override // java.lang.Runnable
                public final void run() {
                    FileUtils.OnFileExistsAndNotEmptyResult.this.onComplete(fileExistsAndNotEmpty);
                }
            });
        }
    }

    @TargetApi(9)
    public static List<StorageInfo> listAvaliableExternalStorage(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService(QQPermissionConstants.Permission.STORAGE_GROUP);
            Method method = StorageManager.class.getMethod("getVolumeList", new Class[0]);
            method.setAccessible(true);
            Object[] objArr = (Object[]) method.invoke(storageManager, new Object[0]);
            if (objArr != null) {
                for (Object obj : objArr) {
                    StorageInfo storageInfo = new StorageInfo((String) obj.getClass().getMethod("getPath", new Class[0]).invoke(obj, new Object[0]));
                    File file = new File(storageInfo.path);
                    if (file.exists() && file.isDirectory() && file.canWrite()) {
                        Method method2 = obj.getClass().getMethod("isRemovable", new Class[0]);
                        try {
                            storageInfo.state = (String) StorageManager.class.getMethod("getVolumeState", String.class).invoke(storageManager, storageInfo.path);
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                        if (storageInfo.isMounted()) {
                            storageInfo.isRemoveable = ((Boolean) method2.invoke(obj, new Object[0])).booleanValue();
                            arrayList.add(storageInfo);
                        }
                    }
                }
            }
        } catch (IllegalAccessException e17) {
            e17.printStackTrace();
        } catch (IllegalArgumentException e18) {
            e18.printStackTrace();
        } catch (NoSuchMethodException e19) {
            e19.printStackTrace();
        } catch (InvocationTargetException e26) {
            e26.printStackTrace();
        }
        arrayList.trimToSize();
        return arrayList;
    }

    public static boolean mergeFiles(String[] strArr, String str) {
        if (strArr == null || strArr.length < 1 || TextUtils.isEmpty(str)) {
            return false;
        }
        File[] fileArr = new File[strArr.length];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (TextUtils.isEmpty(strArr[i3])) {
                return false;
            }
            fileArr[i3] = new File(strArr[i3]);
        }
        return mergeFiles(fileArr, str, false);
    }

    public static boolean moveFile(String str, String str2) {
        return moveFile(str, str2, TextUtils.isEmpty(str) || !str.startsWith(AppConstants.SDCARD_IMG_CAMERA));
    }

    public static synchronized String printStack() {
        String str;
        synchronized (FileUtils.class) {
            str = "";
            try {
                for (StackTraceElement stackTraceElement : Thread.getAllStackTraces().get(Thread.currentThread())) {
                    if (QLog.isColorLevel()) {
                        QLog.eAsync("FMERROR", 1, stackTraceElement.toString());
                    }
                    str = str + stackTraceElement.toString() + "\n";
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    public static boolean pushData2File(String str, byte[] bArr, boolean z16) {
        if (str == null || str.length() == 0 || bArr == null || bArr.length == 0) {
            return false;
        }
        if (z16) {
            str = str + "." + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss", Locale.CHINA).format(new Date(System.currentTimeMillis()));
        }
        File file = new File(str);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    if (file.exists()) {
                        file.delete();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArr);
                        fileOutputStream2.flush();
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                        return true;
                    } catch (FileNotFoundException e17) {
                        e = e17;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        if (fileOutputStream == null) {
                            return false;
                        }
                        fileOutputStream.close();
                        return false;
                    } catch (IOException e18) {
                        e = e18;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        if (fileOutputStream == null) {
                            return false;
                        }
                        fileOutputStream.close();
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e19) {
                                e19.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e26) {
                    e = e26;
                } catch (IOException e27) {
                    e = e27;
                }
            } catch (Exception e28) {
                e28.printStackTrace();
                return false;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static int quickMove(String str, String str2) {
        File file = new File(str);
        File file2 = new File(str2);
        if (!file.exists() && file2.exists()) {
            return 1;
        }
        if (!file2.getParentFile().exists() && !file2.getParentFile().mkdirs()) {
            return 2;
        }
        if (file.renameTo(file2)) {
            return 0;
        }
        return 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b2 A[Catch: IOException -> 0x00ae, TRY_LEAVE, TryCatch #9 {IOException -> 0x00ae, blocks: (B:59:0x00aa, B:52:0x00b2), top: B:58:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v17, types: [com.tencent.commonsdk.pool.ByteArrayPool] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [int] */
    /* JADX WARN: Type inference failed for: r7v2, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r7v3, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.tencent.commonsdk.pool.ByteArrayPool] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] readFile(String str) {
        FileInputStream fileInputStream;
        ?? r56;
        ?? r65;
        int length;
        byte[] bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
        } catch (IOException e16) {
            QLog.e("FileUtils", 1, "readFileContent", e16);
        }
        try {
            try {
                length = (int) file.length();
                r56 = new ByteArrayOutputStream(length);
            } catch (Exception e17) {
                e = e17;
                r56 = 0;
                r65 = 0;
            } catch (OutOfMemoryError e18) {
                e = e18;
                r56 = 0;
                r65 = 0;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
                if (byteArrayOutputStream != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
            try {
                r65 = new FileInputStream(file);
                ?? r75 = 4096;
                try {
                    try {
                        try {
                            if (length < 4096) {
                                r75 = ByteArrayPool.getGenericInstance().getBuf(4096);
                            } else {
                                r75 = ByteArrayPool.getGenericInstance().getBuf(12288);
                            }
                        } catch (OutOfMemoryError e19) {
                            e = e19;
                            QLog.e("FileUtils", 1, "readFileContent OutOfMemoryError", e);
                            if (r56 != 0) {
                                r56.close();
                            }
                            if (r65 != 0) {
                                r65.close();
                            }
                            return bArr;
                        }
                    } catch (Exception e26) {
                        e = e26;
                        QLog.e("FileUtils", 1, "readFileContent", e);
                        if (r56 != 0) {
                            r56.close();
                        }
                        if (r65 != 0) {
                            r65.close();
                        }
                        return bArr;
                    }
                } catch (OutOfMemoryError unused) {
                    r75 = ByteArrayPool.getGenericInstance().getBuf(r75);
                }
                int i3 = 0;
                while (i3 < length) {
                    int read = r65.read(r75);
                    r56.write(r75, 0, read);
                    i3 += read;
                }
                ByteArrayPool.getGenericInstance().returnBuf(r75);
                bArr = r56.toByteArray();
                r56.close();
                r65.close();
            } catch (Exception e27) {
                e = e27;
                r65 = 0;
            } catch (OutOfMemoryError e28) {
                e = e28;
                r65 = 0;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = null;
                byteArrayOutputStream = r56;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e29) {
                        QLog.e("FileUtils", 1, "readFileContent", e29);
                        throw th;
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
            return bArr;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0074, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
    
        com.tencent.qphone.base.util.QLog.e("FileUtils", 2, "readFileContent", r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0090, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readFileContent(File file) {
        ByteArrayOutputStream byteArrayOutputStream;
        BufferedInputStream bufferedInputStream;
        byte[] buf;
        String str = null;
        try {
            if (EstablishSetting.isDebugVersion() && file.length() >= TTL.MAX_VALUE) {
                throw new IOException("readFileContent file too large");
            }
            int length = (int) file.length();
            byteArrayOutputStream = new ByteArrayOutputStream(length);
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    try {
                        buf = ByteArrayPool.getGenericInstance().getBuf(12288);
                    } catch (Throwable unused) {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e16) {
                                e = e16;
                            }
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        return str;
                    }
                } catch (OutOfMemoryError unused2) {
                    buf = ByteArrayPool.getGenericInstance().getBuf(4096);
                }
                int i3 = 0;
                while (i3 < length) {
                    int read = bufferedInputStream.read(buf);
                    byteArrayOutputStream.write(buf, 0, read);
                    i3 += read;
                }
                ByteArrayPool.getGenericInstance().returnBuf(buf);
                str = byteArrayOutputStream.toString("utf-8");
                try {
                    byteArrayOutputStream.close();
                    bufferedInputStream.close();
                } catch (IOException e17) {
                    e = e17;
                }
            } catch (Throwable unused3) {
                bufferedInputStream = null;
            }
        } catch (Throwable unused4) {
            byteArrayOutputStream = null;
            bufferedInputStream = null;
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0079, code lost:
    
        if (r2 == null) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readFileToString(File file) throws IOException {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        r0 = null;
        String str = null;
        if (file == null) {
            return null;
        }
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (file.canRead()) {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                        } catch (Exception unused) {
                            inputStreamReader = null;
                        } catch (Throwable th5) {
                            th = th5;
                            inputStreamReader = null;
                        }
                        try {
                            int length = (int) file.length();
                            if (length > 12288) {
                                char[] cArr = new char[4096];
                                StringBuilder sb5 = new StringBuilder(12288);
                                while (true) {
                                    int read = inputStreamReader.read(cArr);
                                    if (-1 == read) {
                                        break;
                                    }
                                    sb5.append(cArr, 0, read);
                                }
                                str = sb5.toString();
                            } else {
                                char[] cArr2 = new char[length];
                                str = new String(cArr2, 0, inputStreamReader.read(cArr2));
                            }
                            try {
                                fileInputStream.close();
                            } catch (Exception unused2) {
                            }
                        } catch (Exception unused3) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception unused4) {
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (Exception unused5) {
                                }
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                    throw th;
                                } catch (Exception unused6) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Exception unused7) {
                        fileInputStream = null;
                        inputStreamReader = null;
                    } catch (Throwable th7) {
                        th = th7;
                        inputStreamReader = null;
                    }
                    try {
                        inputStreamReader.close();
                    } catch (Exception unused8) {
                        return str;
                    }
                } else {
                    throw new IOException("File '" + file + "' cannot be read");
                }
            } else {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
        } else {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ce, code lost:
    
        if (r5 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00aa, code lost:
    
        if (r5 == null) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readFileToStringEx(File file, int i3) {
        InputStreamReader inputStreamReader;
        BufferedInputStream bufferedInputStream;
        InputStreamReader inputStreamReader2;
        BufferedInputStream bufferedInputStream2 = null;
        r2 = null;
        r2 = null;
        String str = null;
        if (file == null) {
            QLog.e("FileUtils", 1, "readFileToStringEx file = null");
            return null;
        }
        if (file.exists() && file.canRead()) {
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                } catch (Exception e16) {
                    e = e16;
                    bufferedInputStream = null;
                    inputStreamReader2 = null;
                } catch (OutOfMemoryError unused) {
                    bufferedInputStream = null;
                    inputStreamReader2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    inputStreamReader = null;
                    if (bufferedInputStream2 != null) {
                    }
                    if (inputStreamReader == null) {
                    }
                }
                try {
                    inputStreamReader2 = new InputStreamReader(bufferedInputStream, "UTF-8");
                } catch (Exception e17) {
                    e = e17;
                    inputStreamReader2 = null;
                } catch (OutOfMemoryError unused2) {
                    inputStreamReader2 = null;
                } catch (Throwable th6) {
                    th = th6;
                    inputStreamReader = null;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (inputStreamReader == null) {
                        try {
                            inputStreamReader.close();
                            throw th;
                        } catch (Exception unused4) {
                            throw th;
                        }
                    }
                    throw th;
                }
                try {
                    int length = (int) file.length();
                    if (length > 12288) {
                        if (i3 == -1) {
                            i3 = length / 6144;
                            int i16 = 12;
                            if (i3 >= 12) {
                                i16 = 60;
                                if (i3 > 60) {
                                }
                            }
                            i3 = i16;
                        }
                        char[] cArr = new char[4096];
                        StringBuilder sb5 = new StringBuilder(i3 * 1024);
                        while (true) {
                            int read = inputStreamReader2.read(cArr);
                            if (-1 == read) {
                                break;
                            }
                            sb5.append(cArr, 0, read);
                        }
                        str = sb5.toString();
                    } else {
                        char[] cArr2 = new char[length];
                        str = new String(cArr2, 0, inputStreamReader2.read(cArr2));
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (Exception unused5) {
                    }
                } catch (Exception e18) {
                    e = e18;
                    QLog.e("FileUtils", 1, "readFileToStringEx error info: " + e.toString());
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused6) {
                        }
                    }
                } catch (OutOfMemoryError unused7) {
                    QLog.d("FileUtils", 1, "readSignatureFileToString OOM!! filename: " + file.getName());
                    if (i3 == -1) {
                        str = readFileToStringEx(file, 6);
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused8) {
                        }
                    }
                }
                try {
                    inputStreamReader2.close();
                } catch (Exception unused9) {
                    return str;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } else {
            QLog.e("FileUtils", 1, "readFileToStringEx file exists = " + file.exists() + " canRead = " + file.canRead());
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0045 A[Catch: all -> 0x007b, TRY_LEAVE, TryCatch #16 {all -> 0x007b, blocks: (B:12:0x001a, B:29:0x003f, B:31:0x0045), top: B:11:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object readObject(String str) {
        FileInputStream fileInputStream;
        ?? r26;
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            fileInputStream = BaseApplication.getContext().openFileInput(str);
        } catch (Exception e16) {
            e = e16;
            fileInputStream = null;
            r26 = 0;
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
            r26 = 0;
        }
        try {
            r26 = new BufferedInputStream(fileInputStream);
        } catch (Exception e17) {
            e = e17;
            r26 = 0;
            objectInputStream = r26;
            if (QLog.isColorLevel()) {
            }
            if (objectInputStream != null) {
            }
            if (r26 != 0) {
            }
            if (fileInputStream != null) {
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            r26 = 0;
        }
        try {
            objectInputStream = new ObjectInputStream(r26);
        } catch (Exception e18) {
            e = e18;
            objectInputStream = null;
        } catch (Throwable th7) {
            th = th7;
            if (objectInputStream2 != null) {
            }
            if (r26 != 0) {
            }
            if (fileInputStream == null) {
            }
        }
        try {
            try {
                Object readObject = objectInputStream.readObject();
                try {
                    objectInputStream.close();
                } catch (Throwable unused) {
                }
                try {
                    r26.close();
                } catch (Throwable unused2) {
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused3) {
                    }
                }
                return readObject;
            } catch (Throwable th8) {
                th = th8;
                objectInputStream2 = objectInputStream;
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (Throwable unused4) {
                    }
                }
                if (r26 != 0) {
                    try {
                        r26.close();
                    } catch (Throwable unused5) {
                    }
                }
                if (fileInputStream == null) {
                    try {
                        fileInputStream.close();
                        throw th;
                    } catch (Throwable unused6) {
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Exception e19) {
            e = e19;
            if (QLog.isColorLevel()) {
                QLog.i("FileUtils", 2, "FileUtils.readObject throw an Exception. fileName=" + str + ", Exception=" + e.toString());
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (Throwable unused7) {
                }
            }
            if (r26 != 0) {
                try {
                    r26.close();
                } catch (Throwable unused8) {
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable unused9) {
                }
            }
            return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00a4: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:165), block:B:50:0x00a4 */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object[] readObjectList(String str, Class[] clsArr) {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2;
        Object[] objArr;
        boolean z16 = false;
        ObjectInputStream objectInputStream3 = null;
        try {
            try {
                objectInputStream = new ObjectInputStream(new BufferedInputStream(BaseApplication.getContext().openFileInput(str)));
            } catch (Exception e16) {
                e = e16;
                objectInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (objectInputStream3 != null) {
                }
                throw th;
            }
            try {
                objArr = new Object[clsArr.length];
                for (int i3 = 0; i3 < clsArr.length; i3++) {
                    Class cls = clsArr[i3];
                    if (cls == Byte.class) {
                        objArr[i3] = Byte.valueOf(objectInputStream.readByte());
                    } else if (cls == Boolean.class) {
                        objArr[i3] = Boolean.valueOf(objectInputStream.readBoolean());
                    } else if (cls == Integer.class) {
                        objArr[i3] = Integer.valueOf(objectInputStream.readInt());
                    } else if (cls == Long.class) {
                        objArr[i3] = Long.valueOf(objectInputStream.readLong());
                    } else {
                        objArr[i3] = objectInputStream.readObject();
                    }
                }
                try {
                    objectInputStream.close();
                } catch (IOException unused) {
                }
                z16 = true;
            } catch (Exception e17) {
                e = e17;
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.NEARBY, 2, "read ObjectList file=" + str + " exception=" + e.getMessage());
                }
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                objArr = null;
                if (z16) {
                }
            }
            if (z16) {
                return null;
            }
            return objArr;
        } catch (Throwable th6) {
            th = th6;
            objectInputStream3 = objectInputStream2;
            if (objectInputStream3 != null) {
                try {
                    objectInputStream3.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    public static String readStringFromAsset(String str) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = BaseApplication.getContext().getAssets().open(str);
                String readFile = readFile(inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return readFile;
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            e16.printStackTrace();
                            return readFile;
                        }
                        return readFile;
                    }
                }
                return readFile;
            } catch (IOException e17) {
                if (QLog.isColorLevel()) {
                    e17.printStackTrace();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e18) {
                        if (QLog.isColorLevel()) {
                            e18.printStackTrace();
                        }
                    }
                }
                return "";
            }
        } catch (Throwable th5) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e19) {
                    if (QLog.isColorLevel()) {
                        e19.printStackTrace();
                    }
                }
            }
            throw th5;
        }
    }

    public static boolean rename(String str, String str2) {
        return rename(str, str2, false);
    }

    public static boolean renameFile(File file, File file2) {
        boolean z16;
        if (file2.exists()) {
            z16 = file2.delete();
        } else {
            z16 = true;
        }
        if (z16) {
            return file.renameTo(file2);
        }
        return z16;
    }

    public static Pair<Boolean, String> safeSaveFileUriToFile(Context context, String str, String str2) {
        if (!checkIsValidUri(str)) {
            QLog.e("FileUtils", 1, "safeSaveFileUriToFile invalid uri: " + str);
            return new Pair<>(Boolean.FALSE, null);
        }
        return new Pair<>(Boolean.TRUE, saveFileUriToFile(context, str, str2));
    }

    public static String sanitizeFilename(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            QLog.e("FileUtils", 1, "sanitizeFilename displayName is null or empty: " + str);
            return str;
        }
        String[] strArr = {"..", "/"};
        String[] split = str.split("/");
        if (split.length == 0) {
            QLog.e("FileUtils", 1, "sanitizeFilename split / return empty array: " + str);
            return str;
        }
        String str3 = split[split.length - 1];
        if (TextUtils.isEmpty(str3)) {
            return str;
        }
        int lastIndexOf = str3.lastIndexOf(46);
        if (lastIndexOf > -1) {
            str2 = str3.substring(lastIndexOf);
            str3 = str3.substring(0, lastIndexOf);
        } else {
            str2 = "";
        }
        for (int i3 = 0; i3 < 2; i3++) {
            str3 = str3.replace(strArr[i3], "_");
        }
        if (!str.equals(str3)) {
            QLog.d("FileUtils", 1, "sanitizeFilename " + str + " -> " + str3 + ", suf:" + str2);
        }
        return str3 + str2;
    }

    public static boolean saveBitmapToFile(Bitmap bitmap, String str) {
        return saveBitmapToFile(bitmap, str, 70);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String saveFileUriToFile(Context context, String str, String str2) {
        ParcelFileDescriptor parcelFileDescriptor;
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream = null;
        int i3 = 1;
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                parcelFileDescriptor = context.getContentResolver().openFileDescriptor(Uri.parse(str), "r");
            } catch (Exception e16) {
                QLog.e("FileUtils", 1, "saveFileUriToFile FileNotFoundException, ", e16);
                parcelFileDescriptor = null;
            }
            if (parcelFileDescriptor == null) {
                QLog.e("FileUtils", 1, "saveFileUriToFile parcelFileDescriptor is null");
                return null;
            }
            String str3 = File.separator;
            int lastIndexOf = str.lastIndexOf(str3);
            if (lastIndexOf != -1 || lastIndexOf >= str.length()) {
                str = str.substring(lastIndexOf + 1);
            }
            String sanitizeFilename = sanitizeFilename(urlDecode(str));
            ?? sb5 = new StringBuilder();
            sb5.append(context.getExternalFilesDir(null));
            sb5.append(str3);
            sb5.append(str2);
            sb5.append(str3);
            sb5.append(sanitizeFilename);
            String sb6 = sb5.toString();
            ?? r122 = "saveFileUriToFile destFile = ";
            QLog.e("FileUtils", 1, "saveFileUriToFile destFile = ", sb6);
            File file = new File(sb6);
            try {
            } catch (IOException e17) {
                QLog.e("FileUtils", 1, "saveFileUriToFile error, ", e17);
            }
            try {
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    if (file.getParentFile() != null && !file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(parcelFileDescriptor.getFileDescriptor()));
                        try {
                            byte[] bArr = new byte[RFixConstants.MD5_FILE_BUF_LENGTH];
                            while (true) {
                                int read = bufferedInputStream.read(bArr);
                                if (read != -1) {
                                    fileOutputStream2.write(bArr, 0, read);
                                    fileOutputStream2.flush();
                                } else {
                                    try {
                                        break;
                                    } catch (IOException e18) {
                                        QLog.e("FileUtils", 1, "saveFileUriToFile error, ", e18);
                                    }
                                }
                            }
                            parcelFileDescriptor.close();
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e19) {
                                QLog.e("FileUtils", 1, "saveFileUriToFile error, ", e19);
                            }
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e26) {
                                QLog.e("FileUtils", 1, "saveFileUriToFile error, ", e26);
                            }
                        } catch (IOException e27) {
                            r122 = bufferedInputStream;
                            e = e27;
                            sb5 = fileOutputStream2;
                            QLog.e("FileUtils", 1, "saveFileUriToFile IOException, ", e);
                            try {
                                parcelFileDescriptor.close();
                            } catch (IOException e28) {
                                QLog.e("FileUtils", 1, "saveFileUriToFile error, ", e28);
                            }
                            if (sb5 != 0) {
                                try {
                                    sb5.close();
                                } catch (IOException e29) {
                                    QLog.e("FileUtils", 1, "saveFileUriToFile error, ", e29);
                                }
                            }
                            if (r122 != 0) {
                                r122.close();
                                sb5 = sb5;
                                r122 = r122;
                            }
                            i3 = 0;
                            if (i3 == 0) {
                            }
                        } catch (OutOfMemoryError e36) {
                            r122 = bufferedInputStream;
                            e = e36;
                            sb5 = fileOutputStream2;
                            QLog.e("FileUtils", 1, "saveFileUriToFile OutOfMemoryError, ", e);
                            try {
                                parcelFileDescriptor.close();
                            } catch (IOException e37) {
                                QLog.e("FileUtils", 1, "saveFileUriToFile error, ", e37);
                            }
                            if (sb5 != 0) {
                                try {
                                    sb5.close();
                                } catch (IOException e38) {
                                    QLog.e("FileUtils", 1, "saveFileUriToFile error, ", e38);
                                }
                            }
                            if (r122 != 0) {
                                r122.close();
                                sb5 = sb5;
                                r122 = r122;
                            }
                            i3 = 0;
                            if (i3 == 0) {
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream = fileOutputStream2;
                            try {
                                parcelFileDescriptor.close();
                            } catch (IOException e39) {
                                QLog.e("FileUtils", i3, "saveFileUriToFile error, ", e39);
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e46) {
                                    QLog.e("FileUtils", i3, "saveFileUriToFile error, ", e46);
                                }
                            }
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                    throw th;
                                } catch (IOException e47) {
                                    QLog.e("FileUtils", i3, "saveFileUriToFile error, ", e47);
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e48) {
                        e = e48;
                        sb5 = fileOutputStream2;
                        r122 = 0;
                    } catch (OutOfMemoryError e49) {
                        e = e49;
                        sb5 = fileOutputStream2;
                        r122 = 0;
                    } catch (Throwable th6) {
                        th = th6;
                        bufferedInputStream = null;
                    }
                } catch (IOException e56) {
                    e = e56;
                    r122 = 0;
                    sb5 = 0;
                } catch (OutOfMemoryError e57) {
                    e = e57;
                    r122 = 0;
                    sb5 = 0;
                } catch (Throwable th7) {
                    th = th7;
                    bufferedInputStream = null;
                }
                if (i3 == 0) {
                    return null;
                }
                return sb6;
            } catch (Throwable th8) {
                th = th8;
                bufferedInputStream = r122;
                fileOutputStream = sb5;
            }
        } else {
            QLog.e("FileUtils", 1, "saveFileUriToFile return for shareUri or context is null");
            return null;
        }
    }

    public static void uncompressZip(String str, String str2, boolean z16) throws IOException {
        uncompressZip(str, str2, z16, null);
    }

    public static boolean uncompressZipEntry(String str, String str2) throws IOException {
        InputStream inputStream;
        QZipFile qZipFile;
        BufferedOutputStream bufferedOutputStream;
        File file;
        byte[] buf;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        r0 = null;
        InputStream inputStream2 = null;
        fileOutputStream2 = null;
        try {
            File file2 = new File(str2);
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            qZipFile = new QZipFile(str);
            try {
                file = new File(str2 + ".tmp");
                buf = ByteArrayPool.getGenericInstance().getBuf(8192);
                fileOutputStream = new FileOutputStream(file);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream, buf.length);
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th6) {
                th = th6;
                inputStream = null;
                bufferedOutputStream = null;
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            qZipFile = null;
            bufferedOutputStream = null;
        }
        try {
            Enumeration<? extends ZipEntry> entries = qZipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused) {
                    }
                }
                inputStream2 = qZipFile.getInputStream(nextElement);
                while (true) {
                    int read = inputStream2.read(buf, 0, buf.length);
                    if (read != -1) {
                        bufferedOutputStream.write(buf, 0, read);
                    }
                }
            }
            ByteArrayPool.getGenericInstance().returnBuf(buf);
            boolean renameTo = file.renameTo(new File(str2));
            try {
                fileOutputStream.close();
            } catch (IOException unused2) {
            }
            try {
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            } catch (IOException unused3) {
            }
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException unused4) {
                }
            }
            try {
                qZipFile.close();
            } catch (IOException unused5) {
            }
            return renameTo;
        } catch (Throwable th8) {
            th = th8;
            inputStream = inputStream2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused6) {
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                } catch (IOException unused7) {
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused8) {
                }
            }
            if (qZipFile != null) {
                try {
                    qZipFile.close();
                    throw th;
                } catch (IOException unused9) {
                    throw th;
                }
            }
            throw th;
        }
    }

    private static String urlDecode(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String decode = URLDecoder.decode(str, "UTF-8");
            if (QLog.isDevelopLevel()) {
                QLog.d("FileUtils", 2, "fileName urlDecode: " + str + " -> " + decode);
            }
            return decode;
        } catch (UnsupportedEncodingException e16) {
            QLog.e("FileUtils", 1, "urlDecode exception: ", e16);
            return str;
        }
    }

    public static boolean writeFile(String str, String str2, String str3) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        if (str2 != null) {
            str2 = str2.replaceAll("[\\\\/*?<>:\"|]", "");
        }
        File file2 = new File(str + str2);
        boolean mkdirs = !file.exists() ? file.mkdirs() : true;
        if (!file.exists()) {
            return mkdirs;
        }
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException unused) {
                mkdirs = false;
            }
        }
        try {
            fileOutputStream = new FileOutputStream(file2, false);
        } catch (FileNotFoundException unused2) {
            fileOutputStream = null;
            mkdirs = false;
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.write(str3.getBytes());
                fileOutputStream.write("\r\n".getBytes());
            } catch (IOException | OutOfMemoryError unused3) {
                mkdirs = false;
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException unused4) {
                mkdirs = false;
            }
        }
        if (fileOutputStream == null) {
            return mkdirs;
        }
        try {
            fileOutputStream.close();
            return mkdirs;
        } catch (IOException unused5) {
            return false;
        }
    }

    public static void writeObject(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(BaseApplication.getContext().openFileOutput(str, 0)));
                    try {
                        objectOutputStream2.writeObject(obj);
                        objectOutputStream2.flush();
                        objectOutputStream2.close();
                    } catch (Exception e16) {
                        e = e16;
                        objectOutputStream = objectOutputStream2;
                        if (QLog.isColorLevel()) {
                            QLog.i("FileUtils", 2, "FileUtils.writeObject throw an Exception. fileName=" + str + ", Exception=" + e.toString());
                        }
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        objectOutputStream = objectOutputStream2;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e18) {
                e = e18;
            }
        } catch (IOException e19) {
            e19.printStackTrace();
        }
    }

    public static void writeObjectList(String str, Object... objArr) {
        if (str != null && str.length() != 0) {
            ObjectOutputStream objectOutputStream = null;
            try {
                try {
                    try {
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(BaseApplication.getContext().openFileOutput(str, 0)));
                        try {
                            for (Object obj : objArr) {
                                if (obj instanceof Boolean) {
                                    objectOutputStream2.writeBoolean(((Boolean) obj).booleanValue());
                                } else if (obj instanceof Byte) {
                                    objectOutputStream2.writeByte(((Byte) obj).byteValue());
                                } else if (obj instanceof Integer) {
                                    objectOutputStream2.writeInt(((Integer) obj).intValue());
                                } else if (obj instanceof Long) {
                                    objectOutputStream2.writeLong(((Long) obj).longValue());
                                } else {
                                    objectOutputStream2.writeObject(obj);
                                }
                            }
                            objectOutputStream2.flush();
                            objectOutputStream2.close();
                        } catch (Exception e16) {
                            e = e16;
                            objectOutputStream = objectOutputStream2;
                            if (QLog.isColorLevel()) {
                                QLog.d(LogTag.NEARBY, 2, "write ObjectList file=" + str + " exception=" + e.getMessage());
                            }
                            e.printStackTrace();
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            objectOutputStream = objectOutputStream2;
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Exception e18) {
                    e = e18;
                }
            } catch (IOException e19) {
                e19.printStackTrace();
            }
        }
    }

    public static boolean zipFiles(List<String> list, String str) {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        ZipOutputStream zipOutputStream = null;
        FileInputStream fileInputStream2 = null;
        zipOutputStream = null;
        zipOutputStream = null;
        zipOutputStream = null;
        zipOutputStream = null;
        zipOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File(str));
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    try {
                        ZipOutputStream zipOutputStream2 = new ZipOutputStream(bufferedOutputStream);
                        try {
                            Iterator<String> it = list.iterator();
                            while (it.hasNext()) {
                                File file = new File(it.next());
                                if (file.exists()) {
                                    zipOutputStream2.putNextEntry(new ZipEntry(file.getName()));
                                    zipOutputStream2.setLevel(9);
                                    try {
                                        fileInputStream = new FileInputStream(file);
                                    } catch (Throwable th5) {
                                        th = th5;
                                    }
                                    try {
                                        byte[] bArr = new byte[20480];
                                        while (true) {
                                            int read = fileInputStream.read(bArr, 0, 20480);
                                            if (read == -1) {
                                                break;
                                            }
                                            zipOutputStream2.write(bArr, 0, read);
                                        }
                                        fileInputStream.close();
                                        zipOutputStream2.flush();
                                        zipOutputStream2.closeEntry();
                                    } catch (Throwable th6) {
                                        th = th6;
                                        fileInputStream2 = fileInputStream;
                                        if (fileInputStream2 != null) {
                                            fileInputStream2.close();
                                        }
                                        zipOutputStream2.flush();
                                        zipOutputStream2.closeEntry();
                                        throw th;
                                    }
                                }
                            }
                            try {
                                zipOutputStream2.close();
                            } catch (IOException e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("FileUtils", 2, "zipFiles exception: ", e16);
                                }
                            }
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e17) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("FileUtils", 2, "zipFiles exception: ", e17);
                                }
                            }
                            try {
                                fileOutputStream.close();
                            } catch (IOException e18) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("FileUtils", 2, "zipFiles exception: ", e18);
                                }
                            }
                            return true;
                        } catch (Exception e19) {
                            e = e19;
                            zipOutputStream = zipOutputStream2;
                            if (QLog.isColorLevel()) {
                                QLog.e("FileUtils", 2, "magnifier zipFiles exception: ", e);
                            }
                            if (zipOutputStream != null) {
                                try {
                                    zipOutputStream.close();
                                } catch (IOException e26) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("FileUtils", 2, "zipFiles exception: ", e26);
                                    }
                                }
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e27) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("FileUtils", 2, "zipFiles exception: ", e27);
                                    }
                                }
                            }
                            if (fileOutputStream == null) {
                                return false;
                            }
                            try {
                                fileOutputStream.close();
                                return false;
                            } catch (IOException e28) {
                                if (!QLog.isColorLevel()) {
                                    return false;
                                }
                                QLog.e("FileUtils", 2, "zipFiles exception: ", e28);
                                return false;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            zipOutputStream = zipOutputStream2;
                            if (zipOutputStream != null) {
                                try {
                                    zipOutputStream.close();
                                } catch (IOException e29) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("FileUtils", 2, "zipFiles exception: ", e29);
                                    }
                                }
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e36) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("FileUtils", 2, "zipFiles exception: ", e36);
                                    }
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e37) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("FileUtils", 2, "zipFiles exception: ", e37);
                                    }
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                    }
                } catch (Exception e38) {
                    e = e38;
                }
            } catch (Exception e39) {
                e = e39;
                bufferedOutputStream = null;
            } catch (Throwable th9) {
                th = th9;
                bufferedOutputStream = null;
            }
        } catch (Exception e46) {
            e = e46;
            bufferedOutputStream = null;
            fileOutputStream = null;
        } catch (Throwable th10) {
            th = th10;
            bufferedOutputStream = null;
            fileOutputStream = null;
        }
    }

    public static int copyDirectory(String str, String str2, boolean z16, boolean z17, boolean z18) {
        File[] listFiles;
        File file = new File(str);
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return -1;
        }
        File file2 = new File(str2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        for (int i3 = 0; i3 < listFiles.length; i3++) {
            if (listFiles[i3].isDirectory()) {
                copyDirectory(listFiles[i3].getPath() + "/", str2 + listFiles[i3].getName() + "/", z16, z17, z18);
            } else {
                File file3 = new File(listFiles[i3].getPath());
                File file4 = new File(str2 + listFiles[i3].getName());
                if (file3.exists()) {
                    if (z17 && file4.exists() && !file4.delete() && z18) {
                        QLog.d("FileUtils", 1, "copyDirectory fail, delete file name:", file3.getPath());
                    }
                    if (!file4.exists()) {
                        try {
                            file4.createNewFile();
                            if (!copyFile(file3, file4, z18) && z18) {
                                QLog.d("FileUtils", 1, "copyDirectory fail, file name:", file3.getPath());
                            }
                        } catch (IOException e16) {
                            if (z18) {
                                QLog.e("FileUtils", 1, "copyDirectory error, ", e16);
                            }
                        }
                    }
                    if (z16) {
                        file3.delete();
                    }
                }
            }
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0137, code lost:
    
        if (r11 == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e5, code lost:
    
        com.tencent.qphone.base.util.QLog.e("FileUtils", 1, "copyFile error, ", r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00e3, code lost:
    
        if (r11 == false) goto L124;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x010d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ee A[Catch: all -> 0x00f2, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x00f2, blocks: (B:79:0x00c1, B:52:0x00ee), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0132 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0126 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00c1 A[Catch: all -> 0x00f2, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x00f2, blocks: (B:79:0x00c1, B:52:0x00ee), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r10v11, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.io.BufferedInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean copyFile(File file, File file2, boolean z16) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3;
        FileInputStream fileInputStream4;
        FileInputStream fileInputStream5;
        ?? r102;
        ?? r103;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream6;
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (file2.exists() && isValidPathCanDelete(file2.getPath())) {
                    file2.delete();
                }
                if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                fileOutputStream = new FileOutputStream((File) file2);
            } catch (IOException e16) {
                e = e16;
                fileInputStream2 = null;
            } catch (OutOfMemoryError e17) {
                e = e17;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                file2 = 0;
            }
            try {
                fileInputStream6 = new FileInputStream(file);
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream6);
                } catch (IOException e18) {
                    e = e18;
                    fileInputStream5 = fileInputStream6;
                    r103 = 0;
                    fileOutputStream2 = fileOutputStream;
                } catch (OutOfMemoryError e19) {
                    e = e19;
                    fileInputStream4 = fileInputStream6;
                    r102 = 0;
                    fileOutputStream2 = fileOutputStream;
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream3 = fileInputStream6;
                    file2 = 0;
                    fileOutputStream2 = fileOutputStream;
                }
            } catch (IOException e26) {
                e = e26;
                fileInputStream2 = null;
                fileOutputStream2 = fileOutputStream;
                fileInputStream5 = fileInputStream2;
                r103 = fileInputStream2;
                if (z16) {
                }
                if (fileOutputStream2 != null) {
                }
                if (r103 != 0) {
                }
                if (fileInputStream5 != null) {
                }
                return false;
            } catch (OutOfMemoryError e27) {
                e = e27;
                fileInputStream = null;
                fileOutputStream2 = fileOutputStream;
                fileInputStream4 = fileInputStream;
                r102 = fileInputStream;
                if (z16) {
                }
                if (fileOutputStream2 != null) {
                }
                if (r102 != 0) {
                }
                if (fileInputStream4 != null) {
                }
                return false;
            } catch (Throwable th7) {
                th = th7;
                file2 = 0;
                fileOutputStream2 = fileOutputStream;
                fileInputStream3 = file2;
                if (fileOutputStream2 != null) {
                }
                if (file2 != 0) {
                }
                if (fileInputStream3 == null) {
                }
            }
            try {
                byte[] buf = ByteArrayPool.getGenericInstance().getBuf(4096);
                while (true) {
                    int read = bufferedInputStream.read(buf);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(buf, 0, read);
                    fileOutputStream.flush();
                }
                ByteArrayPool.getGenericInstance().returnBuf(buf);
                try {
                    fileOutputStream.close();
                } catch (IOException e28) {
                    if (z16) {
                        QLog.e("FileUtils", 1, "copyFile error, ", e28);
                    }
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e29) {
                    if (z16) {
                        QLog.e("FileUtils", 1, "copyFile error, ", e29);
                    }
                }
                try {
                    fileInputStream6.close();
                    return true;
                } catch (IOException e36) {
                    if (!z16) {
                        return true;
                    }
                    QLog.e("FileUtils", 1, "copyFile error, ", e36);
                    return true;
                }
            } catch (IOException e37) {
                r103 = bufferedInputStream;
                e = e37;
                fileOutputStream2 = fileOutputStream;
                fileInputStream5 = fileInputStream6;
                if (z16) {
                    QLog.e("FileUtils", 1, "copyFile error, ", e);
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e38) {
                        if (z16) {
                            QLog.e("FileUtils", 1, "copyFile error, ", e38);
                        }
                    }
                }
                if (r103 != 0) {
                    try {
                        r103.close();
                    } catch (IOException e39) {
                        if (z16) {
                            QLog.e("FileUtils", 1, "copyFile error, ", e39);
                        }
                    }
                }
                if (fileInputStream5 != null) {
                    try {
                        fileInputStream5.close();
                    } catch (IOException e46) {
                        e = e46;
                    }
                }
                return false;
            } catch (OutOfMemoryError e47) {
                r102 = bufferedInputStream;
                e = e47;
                fileOutputStream2 = fileOutputStream;
                fileInputStream4 = fileInputStream6;
                if (z16) {
                    QLog.e("FileUtils", 1, "copyFile error, ", e);
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e48) {
                        if (z16) {
                            QLog.e("FileUtils", 1, "copyFile error, ", e48);
                        }
                    }
                }
                if (r102 != 0) {
                    try {
                        r102.close();
                    } catch (IOException e49) {
                        if (z16) {
                            QLog.e("FileUtils", 1, "copyFile error, ", e49);
                        }
                    }
                }
                if (fileInputStream4 != null) {
                    try {
                        fileInputStream4.close();
                    } catch (IOException e56) {
                        e = e56;
                    }
                }
                return false;
            } catch (Throwable th8) {
                file2 = bufferedInputStream;
                th = th8;
                fileOutputStream2 = fileOutputStream;
                fileInputStream3 = fileInputStream6;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e57) {
                        if (z16) {
                            QLog.e("FileUtils", 1, "copyFile error, ", e57);
                        }
                    }
                }
                if (file2 != 0) {
                    try {
                        file2.close();
                    } catch (IOException e58) {
                        if (z16) {
                            QLog.e("FileUtils", 1, "copyFile error, ", e58);
                        }
                    }
                }
                if (fileInputStream3 == null) {
                    try {
                        fileInputStream3.close();
                        throw th;
                    } catch (IOException e59) {
                        if (z16) {
                            QLog.e("FileUtils", 1, "copyFile error, ", e59);
                            throw th;
                        }
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th9) {
            th = th9;
        }
    }

    public static ArrayList<String> getChildFiles(String str, boolean z16) {
        File file = new File(str);
        ArrayList<String> arrayList = new ArrayList<>();
        File[] listFiles = file.listFiles();
        try {
            int length = listFiles.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (listFiles[i3].isDirectory()) {
                    if (z16) {
                        arrayList.add(listFiles[i3].getCanonicalPath());
                    }
                    arrayList.addAll(getChildFiles(listFiles[i3].getCanonicalPath(), z16));
                } else {
                    arrayList.add(listFiles[i3].getCanonicalPath());
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return arrayList;
    }

    public static boolean moveFile(String str, String str2, boolean z16) {
        if (str == null || str2 == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        try {
            copyFile(file, createFile(str2));
            if (z16) {
                if (str.contains(DCIM)) {
                    QLog.e("FileUtils", 1, "deleteFrom: /DCIM/ trace:" + Log.getStackTraceString(new RuntimeException()));
                }
                file.delete();
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean rename(String str, String str2, boolean z16) {
        if (str == null || str2 == null) {
            if (z16) {
                QLog.d("FileUtils", 1, "rename failed, fromPath:" + str + ", toPath:" + str2);
            }
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.renameTo(new File(str2));
        }
        if (!z16) {
            return false;
        }
        QLog.d("FileUtils", 1, "rename failed, file not exists, fromPath:" + str);
        return false;
    }

    public static boolean saveBitmapToFile(Bitmap bitmap, String str, int i3) {
        if (bitmap == null || str == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str), 204800);
                try {
                    boolean compress = bitmap.compress(Bitmap.CompressFormat.JPEG, i3, bufferedOutputStream2);
                    try {
                        bufferedOutputStream2.flush();
                        bufferedOutputStream2.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    return compress;
                } catch (IOException e17) {
                    e = e17;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e26) {
                e = e26;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static void uncompressZip(String str, String str2, boolean z16, @android.support.annotation.Nullable Pattern pattern) throws IOException {
        uncompressZip(str, str2, z16, pattern, null);
    }

    public static void fileExistsAndNotEmpty(final String str, final OnFileExistsAndNotEmptyResult onFileExistsAndNotEmptyResult) {
        if (onFileExistsAndNotEmptyResult == null) {
            return;
        }
        final Handler callbackHandler = getCallbackHandler();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.utils.ap
            @Override // java.lang.Runnable
            public final void run() {
                FileUtils.lambda$fileExistsAndNotEmpty$1(str, callbackHandler, onFileExistsAndNotEmptyResult);
            }
        }, 64, null, false);
    }

    public static boolean isNeedTransPic(@NonNull String str) {
        return Utils.isHeifFile(str) || "webp".equals(estimateFileType(str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0159, code lost:
    
        throw new java.io.IOException("System unzip bug caused by bad zip file");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01aa A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r19v0, types: [java.util.regex.Pattern] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void uncompressZip(String str, String str2, boolean z16, @android.support.annotation.Nullable Pattern pattern, @android.support.annotation.Nullable List<File> list) throws IOException {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        OutputStream outputStream;
        ?? r95;
        int i3;
        String name;
        String str3;
        int lastIndexOf;
        QZipInputStream qZipInputStream = null;
        FileOutputStream fileOutputStream2 = null;
        qZipInputStream = null;
        boolean z17 = false;
        try {
            i3 = 2;
            if (QLog.isColorLevel()) {
                QLog.d("FileUtils", 2, "zipPath is:" + str + ",destDir is:" + str2);
            }
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
            fileOutputStream = null;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            try {
                QZipInputStream qZipInputStream2 = new QZipInputStream(bufferedInputStream);
                try {
                    new File(str2).mkdirs();
                    byte[] buf = ByteArrayPool.getGenericInstance().getBuf(8192);
                    outputStream = null;
                    loop0: while (true) {
                        try {
                            ZipEntry nextEntry = qZipInputStream2.getNextEntry();
                            if (nextEntry == null) {
                                ByteArrayPool.getGenericInstance().returnBuf(buf);
                                try {
                                    qZipInputStream2.close();
                                } catch (IOException unused) {
                                }
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException unused2) {
                                }
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused3) {
                                }
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException unused4) {
                                    }
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                        return;
                                    } catch (IOException unused5) {
                                        return;
                                    }
                                }
                                return;
                            }
                            if (!nextEntry.isDirectory() && (name = nextEntry.getName()) != null && !name.contains("../")) {
                                if (pattern != 0 && !pattern.matcher(name).matches()) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("FileUtils", i3, "not match and skip :" + name);
                                    }
                                } else {
                                    int lastIndexOf2 = name.lastIndexOf(File.separatorChar);
                                    if (lastIndexOf2 != name.length() - 1) {
                                        if (lastIndexOf2 <= 0) {
                                            if (lastIndexOf2 >= 0) {
                                                name = name.substring(1);
                                            }
                                            str3 = str2;
                                        } else {
                                            String substring = name.substring(0, lastIndexOf2);
                                            if (substring.charAt(0) == File.separatorChar) {
                                                str3 = str2 + substring;
                                            } else {
                                                str3 = str2 + File.separatorChar + substring;
                                            }
                                            name = name.substring(lastIndexOf2 + 1);
                                        }
                                        if (z16 && (lastIndexOf = name.lastIndexOf(".")) > 0) {
                                            name = name.substring(0, lastIndexOf);
                                        }
                                        File file = new File(str3, name);
                                        if (!file.getParentFile().exists()) {
                                            file.getParentFile().mkdirs();
                                        }
                                        if (file.exists()) {
                                            file.delete();
                                        }
                                        fileOutputStream = new FileOutputStream(file);
                                        try {
                                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, buf.length);
                                            int i16 = 0;
                                            while (true) {
                                                try {
                                                    int read = qZipInputStream2.read(buf, 0, buf.length);
                                                    if (read == -1) {
                                                        bufferedOutputStream.flush();
                                                        bufferedOutputStream.close();
                                                        fileOutputStream.close();
                                                        if (list != null) {
                                                            list.add(file);
                                                        }
                                                        outputStream = bufferedOutputStream;
                                                        fileOutputStream2 = fileOutputStream;
                                                    } else if (read != 0 || (i16 = i16 + 1) <= 10) {
                                                        bufferedOutputStream.write(buf, 0, read);
                                                    } else {
                                                        try {
                                                            break loop0;
                                                        } catch (Throwable th6) {
                                                            th = th6;
                                                            outputStream = bufferedOutputStream;
                                                            qZipInputStream = qZipInputStream2;
                                                            z17 = true;
                                                            r95 = bufferedInputStream;
                                                            if (qZipInputStream != null) {
                                                            }
                                                            if (r95 != 0) {
                                                            }
                                                            if (fileInputStream != null) {
                                                            }
                                                            if (fileOutputStream != null) {
                                                            }
                                                            if (outputStream != null) {
                                                            }
                                                        }
                                                    }
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                    outputStream = bufferedOutputStream;
                                                    qZipInputStream = qZipInputStream2;
                                                    r95 = bufferedInputStream;
                                                    if (qZipInputStream != null) {
                                                        try {
                                                            qZipInputStream.close();
                                                        } catch (IOException unused6) {
                                                        }
                                                    }
                                                    if (r95 != 0) {
                                                    }
                                                    if (fileInputStream != null) {
                                                    }
                                                    if (fileOutputStream != null) {
                                                    }
                                                    if (outputStream != null) {
                                                    }
                                                }
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                        }
                                    } else {
                                        throw new IllegalArgumentException("file name must not be empty,fileName is:" + name);
                                    }
                                }
                            }
                            i3 = 2;
                        } catch (Throwable th9) {
                            th = th9;
                            fileOutputStream = fileOutputStream2;
                        }
                    }
                } catch (Throwable th10) {
                    th = th10;
                    fileOutputStream = null;
                    outputStream = null;
                }
            } catch (Throwable th11) {
                th = th11;
                fileOutputStream = null;
                outputStream = null;
                r95 = bufferedInputStream;
            }
        } catch (Throwable th12) {
            th = th12;
            fileOutputStream = null;
            FileOutputStream fileOutputStream3 = fileOutputStream;
            outputStream = fileOutputStream3;
            r95 = fileOutputStream3;
            if (qZipInputStream != null && !z17) {
                qZipInputStream.close();
            }
            if (r95 != 0) {
                try {
                    r95.close();
                } catch (IOException unused7) {
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused8) {
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused9) {
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                    throw th;
                } catch (IOException unused10) {
                    throw th;
                }
            }
            throw th;
        }
    }

    public static String calcMd5(String str, long j3) {
        String bytes2HexStr;
        String str2 = null;
        try {
            bytes2HexStr = com.qq.taf.jce.HexUtil.bytes2HexStr(MD5.toMD5Byte(new FileInputStream(str), j3));
        } catch (FileNotFoundException e16) {
            e16.printStackTrace();
        }
        if (TextUtils.isEmpty(bytes2HexStr)) {
            return null;
        }
        str2 = bytes2HexStr;
        return str2;
    }

    private static boolean createDirectory(File file) {
        if (file.exists()) {
            return true;
        }
        if (createDirectory(file.getParentFile())) {
            return file.mkdir();
        }
        return false;
    }

    public static boolean mergeFiles(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return mergeFiles(new File(str).listFiles(), str2, false);
    }

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return true;
    }

    public static String estimateFileType(byte[] bArr) {
        String str = "";
        if (bArr != null && bArr.length >= 2) {
            for (byte b16 : bArr) {
                str = str + Integer.toString(b16 & 255);
            }
            int parseInt = Integer.parseInt(str);
            if (parseInt == 6677) {
                return "bmp";
            }
            if (parseInt == 7173) {
                return "gif";
            }
            if (parseInt == 7784) {
                return "midi";
            }
            if (parseInt == 7790) {
                return "exe";
            }
            if (parseInt == 8075) {
                return "zip";
            }
            if (parseInt == 8273) {
                return "webp";
            }
            if (parseInt == 8297) {
                return "rar";
            }
            if (parseInt == 13780) {
                return "png";
            }
            if (parseInt == 255216) {
                return "jpg";
            }
            return unKnownFileTypeMark + str;
        }
        return unKnownFileTypeMark + "";
    }

    public static boolean mergeFiles(File[] fileArr, String str, boolean z16) {
        FileChannel channel;
        if (fileArr == null || fileArr.length == 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i3 = 0; i3 < fileArr.length; i3++) {
            File file = fileArr[i3];
            if (file == null || !file.exists() || !fileArr[i3].isFile()) {
                return false;
            }
        }
        if (fileArr.length == 1) {
            return fileArr[0].renameTo(new File(str));
        }
        File file2 = new File(str);
        FileOutputStream fileOutputStream = null;
        FileChannel fileChannel = null;
        FileOutputStream fileOutputStream2 = null;
        FileOutputStream fileOutputStream3 = null;
        try {
            try {
                FileOutputStream fileOutputStream4 = new FileOutputStream(file2, true);
                try {
                    FileChannel channel2 = fileOutputStream4.getChannel();
                    for (File file3 : fileArr) {
                        try {
                            channel = new FileInputStream(file3).getChannel();
                        } catch (Throwable th5) {
                            th = th5;
                        }
                        try {
                            channel2.transferFrom(channel, channel2.size(), channel.size());
                            channel.close();
                        } catch (Throwable th6) {
                            th = th6;
                            fileChannel = channel;
                            fileChannel.close();
                            throw th;
                        }
                    }
                    channel2.close();
                    try {
                        fileOutputStream4.close();
                    } catch (IOException unused) {
                    }
                    if (z16) {
                        for (File file4 : fileArr) {
                            file4.delete();
                        }
                    }
                    return true;
                } catch (FileNotFoundException e16) {
                    e = e16;
                    fileOutputStream3 = fileOutputStream4;
                    e.printStackTrace();
                    if (fileOutputStream3 != null) {
                        try {
                            fileOutputStream3.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return false;
                } catch (IOException e17) {
                    e = e17;
                    fileOutputStream = fileOutputStream4;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return false;
                } catch (Throwable th7) {
                    th = th7;
                    fileOutputStream2 = fileOutputStream4;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e18) {
                e = e18;
            } catch (IOException e19) {
                e = e19;
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public static boolean writeFile(String str, String str2) {
        return writeFile(str, str2, true);
    }

    public static boolean writeFile(String str, StringBuffer stringBuffer, InputStream inputStream) {
        boolean z16;
        File file = new File(str);
        if (stringBuffer == null) {
            return false;
        }
        File file2 = new File(str + stringBuffer.toString().replaceAll("[\\\\/*?<>:\"|]", ""));
        if (file.exists()) {
            z16 = true;
        } else {
            z16 = file.mkdirs();
            if (!z16) {
                return false;
            }
        }
        if (file.exists()) {
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                } catch (IOException unused) {
                    return false;
                }
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2, false);
                try {
                    try {
                        byte[] buf = ByteArrayPool.getGenericInstance().getBuf(4096);
                        while (true) {
                            int read = inputStream.read(buf);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(buf, 0, read);
                        }
                        ByteArrayPool.getGenericInstance().returnBuf(buf);
                        fileOutputStream.flush();
                        try {
                            fileOutputStream.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                    } catch (Throwable th5) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                        throw th5;
                    }
                } catch (IOException e18) {
                    e18.printStackTrace();
                    try {
                        fileOutputStream.close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                    }
                    return false;
                }
            } catch (FileNotFoundException e26) {
                e26.printStackTrace();
                return false;
            }
        }
        return z16;
    }

    public static boolean saveBitmapToFile(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        return saveBitmapToFile(bitmap, str, compressFormat, 70);
    }

    public static boolean saveBitmapToFile(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i3) {
        if (bitmap == null || str == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str), 204800);
                try {
                    boolean compress = bitmap.compress(compressFormat, i3, bufferedOutputStream2);
                    try {
                        bufferedOutputStream2.flush();
                        bufferedOutputStream2.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    return compress;
                } catch (IOException e17) {
                    e = e17;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e26) {
                e = e26;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static String readFile(InputStream inputStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb5 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb5.append(readLine);
                } else {
                    return sb5.toString();
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static boolean writeFile(String str, String str2, boolean z16) {
        boolean z17;
        FileOutputStream fileOutputStream;
        File file = new File(str);
        if (!file.exists()) {
            try {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            } catch (IOException unused) {
                z17 = false;
            }
        }
        z17 = true;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file, false);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            try {
                fileOutputStream.write(str2.getBytes());
                if (z16) {
                    fileOutputStream.write("\r\n".getBytes());
                }
            } catch (IOException unused2) {
                z17 = false;
            }
            try {
                fileOutputStream.flush();
            } catch (IOException unused3) {
                z17 = false;
            }
            try {
                fileOutputStream.close();
                return z17;
            } catch (Throwable th6) {
                if (!QLog.isColorLevel()) {
                    return false;
                }
                QLog.e("FileUtils", 2, th6, new Object[0]);
                return false;
            }
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream2 = fileOutputStream;
            try {
                if (QLog.isColorLevel()) {
                    QLog.e("FileUtils", 2, th, new Object[0]);
                }
                if (fileOutputStream2 == null) {
                    return false;
                }
                try {
                    fileOutputStream2.close();
                    return false;
                } catch (Throwable th8) {
                    if (!QLog.isColorLevel()) {
                        return false;
                    }
                    QLog.e("FileUtils", 2, th8, new Object[0]);
                    return false;
                }
            } catch (Throwable th9) {
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th10) {
                        if (QLog.isColorLevel()) {
                            QLog.e("FileUtils", 2, th10, new Object[0]);
                        }
                    }
                }
                throw th9;
            }
        }
    }

    public static boolean copyFile(String str, String str2) {
        return copyFile(str, str2, false);
    }

    public static boolean copyFile(String str, String str2, boolean z16) {
        File file = new File(str);
        if (file.exists()) {
            try {
                return copyFile(file, createFile(str2), z16);
            } catch (IOException e16) {
                QLog.d("FileUtils", 1, "copyFile fail, from:" + str + ", to:" + str2 + ", exception:" + e16.getMessage());
            }
        } else if (z16) {
            QLog.d("FileUtils", 1, "copyFile failed, file not exists, from path:" + str);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r15v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r15v9 */
    public static boolean zipFiles(String str, String str2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        ZipOutputStream zipOutputStream = null;
        FileInputStream fileInputStream2 = null;
        r4 = null;
        r4 = null;
        zipOutputStream = null;
        zipOutputStream = null;
        ZipOutputStream zipOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(new File((String) str2));
                try {
                    str2 = new BufferedOutputStream(fileOutputStream);
                    try {
                        ZipOutputStream zipOutputStream3 = new ZipOutputStream(str2);
                        try {
                            for (File file : new File(str).listFiles()) {
                                if (file != null && file.isFile()) {
                                    zipOutputStream3.putNextEntry(new ZipEntry(file.getName()));
                                    zipOutputStream3.setLevel(9);
                                    try {
                                        fileInputStream = new FileInputStream(file);
                                    } catch (Throwable th5) {
                                        th = th5;
                                    }
                                    try {
                                        byte[] bArr = new byte[20480];
                                        while (true) {
                                            int read = fileInputStream.read(bArr, 0, 20480);
                                            if (read == -1) {
                                                break;
                                            }
                                            zipOutputStream3.write(bArr, 0, read);
                                        }
                                        fileInputStream.close();
                                        zipOutputStream3.flush();
                                        zipOutputStream3.closeEntry();
                                    } catch (Throwable th6) {
                                        th = th6;
                                        fileInputStream2 = fileInputStream;
                                        if (fileInputStream2 != null) {
                                            fileInputStream2.close();
                                        }
                                        zipOutputStream3.flush();
                                        zipOutputStream3.closeEntry();
                                        throw th;
                                    }
                                }
                            }
                            try {
                                zipOutputStream3.close();
                            } catch (IOException e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("FileUtils", 2, "zipFiles exception: ", e16);
                                }
                            }
                            try {
                                str2.close();
                            } catch (IOException e17) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("FileUtils", 2, "zipFiles exception: ", e17);
                                }
                            }
                            try {
                                fileOutputStream.close();
                            } catch (IOException e18) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("FileUtils", 2, "zipFiles exception: ", e18);
                                }
                            }
                            return true;
                        } catch (Exception e19) {
                            e = e19;
                            zipOutputStream2 = zipOutputStream3;
                            if (QLog.isColorLevel()) {
                                QLog.e("FileUtils", 2, "magnifier zipFiles exception: ", e);
                            }
                            if (zipOutputStream2 != null) {
                                try {
                                    zipOutputStream2.close();
                                } catch (IOException e26) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("FileUtils", 2, "zipFiles exception: ", e26);
                                    }
                                }
                            }
                            if (str2 != 0) {
                                try {
                                    str2.close();
                                } catch (IOException e27) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("FileUtils", 2, "zipFiles exception: ", e27);
                                    }
                                }
                            }
                            if (fileOutputStream == null) {
                                return false;
                            }
                            try {
                                fileOutputStream.close();
                                return false;
                            } catch (IOException e28) {
                                if (!QLog.isColorLevel()) {
                                    return false;
                                }
                                QLog.e("FileUtils", 2, "zipFiles exception: ", e28);
                                return false;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            zipOutputStream = zipOutputStream3;
                            if (zipOutputStream != null) {
                                try {
                                    zipOutputStream.close();
                                } catch (IOException e29) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("FileUtils", 2, "zipFiles exception: ", e29);
                                    }
                                }
                            }
                            if (str2 != 0) {
                                try {
                                    str2.close();
                                } catch (IOException e36) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("FileUtils", 2, "zipFiles exception: ", e36);
                                    }
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e37) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("FileUtils", 2, "zipFiles exception: ", e37);
                                    }
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e38) {
                        e = e38;
                    }
                } catch (Exception e39) {
                    e = e39;
                    str2 = 0;
                } catch (Throwable th8) {
                    th = th8;
                    str2 = 0;
                }
            } catch (Exception e46) {
                e = e46;
                str2 = 0;
                fileOutputStream = null;
            } catch (Throwable th9) {
                th = th9;
                str2 = 0;
                fileOutputStream = null;
            }
        } catch (Throwable th10) {
            th = th10;
        }
    }

    public static boolean writeFile(String str, String str2, InputStream inputStream) {
        return writeFile(str, new StringBuffer(str2), inputStream);
    }

    public static boolean writeFile(byte[] bArr, String str) {
        return writeFile(bArr, str, false);
    }

    public static boolean writeFile(byte[] bArr, String str, boolean z16) {
        return writeFile(bArr, str, z16, bArr.length);
    }

    public static boolean writeFile(byte[] bArr, String str, boolean z16, int i3) {
        File file = new File(str);
        boolean z17 = false;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (!file.exists()) {
                    if (file.getParentFile() == null) {
                        QLog.d("FileUtils", 1, "wfile parent is null: ", file.toString());
                        return false;
                    }
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, z16);
                try {
                    fileOutputStream2.write(bArr, 0, i3);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    z17 = true;
                } catch (IOException unused) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return z17;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException unused4) {
        }
        return z17;
    }
}
