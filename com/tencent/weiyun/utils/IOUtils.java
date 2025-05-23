package com.tencent.weiyun.utils;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class IOUtils {
    static IPatchRedirector $redirector_ = null;
    private static final long MAX_MMAP_BUFFER = 536870912;
    private static final int MAX_STREAM_BUFFER = 8192;
    private static final String TAG = "IOUtils";

    IOUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String calcCapUnit(long j3) {
        return calcCapUnit(0, (float) j3);
    }

    public static void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean copyFileAndNotifyOS(Context context, String str, String str2) {
        File file = new File(str);
        File file2 = new File(str2);
        if (copyFiles(file, file2)) {
            scan2MediaStore(context, file2);
            return true;
        }
        return false;
    }

    public static boolean copyFiles(File file, File file2) {
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return performCopyFile(file, file2);
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        boolean z16 = true;
        for (File file3 : listFiles) {
            if (!copyFiles(file3, new File(file2, file3.getName()))) {
                z16 = false;
            }
        }
        return z16;
    }

    private static String countToUnit(int i3) {
        if (i3 == 0) {
            return "byte";
        }
        if (i3 == 1) {
            return "KB";
        }
        if (i3 == 2) {
            return "MB";
        }
        if (i3 == 3) {
            return "GB";
        }
        if (i3 == 4) {
            return "TB";
        }
        if (i3 == 5) {
            return "PB";
        }
        return "";
    }

    public static void deleteFile(File file, boolean z16) {
        if (file != null && file.exists()) {
            if (!file.isDirectory()) {
                File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
                file.renameTo(file2);
                file2.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file3 : listFiles) {
                deleteFile(file3, z16);
            }
            if (!z16) {
                File file4 = new File(file.getAbsolutePath() + System.currentTimeMillis());
                file.renameTo(file4);
                file4.delete();
            }
        }
    }

    public static String ensureFilePath(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!str.endsWith(File.separator)) {
                str = str + File.separatorChar;
            }
            File file = new File(str + str2);
            while (file.exists()) {
                String performRename = performRename(file.getName());
                if (TextUtils.isEmpty(performRename)) {
                    break;
                }
                file = new File(str + performRename);
            }
            return file.getAbsolutePath();
        }
        return "";
    }

    public static boolean ensureStorageSpace(String str, long j3) {
        long j16;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        while (!file.exists()) {
            file = file.getParentFile();
        }
        if (!file.isDirectory()) {
            file = file.getParentFile();
        }
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j16 = statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th5) {
            Log.d(TAG, "ensure storage space error for path:" + str, th5);
            j16 = 0;
        }
        if (j16 <= j3) {
            return false;
        }
        return true;
    }

    public static boolean ensureWritable(String str) {
        File file;
        File file2 = null;
        try {
            File file3 = new File(str);
            if (!file3.exists()) {
                file3.mkdirs();
            } else if (!file3.isDirectory()) {
                Log.w(TAG, "ensure writable: dest dir path is file.");
                return false;
            }
            int i3 = 0;
            do {
                file = new File(file3, System.currentTimeMillis() + ".tmp");
                i3++;
                try {
                    if (!file.exists()) {
                        break;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    file2 = file;
                    try {
                        Log.d(TAG, "ensure writable error for path:" + str, th);
                        return false;
                    } finally {
                        if (file2 != null && file2.exists()) {
                            file2.delete();
                        }
                    }
                }
            } while (i3 < 30);
            boolean createNewFile = file.createNewFile();
            if (file.exists()) {
                file.delete();
            }
            return createNewFile;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static String getDirPathNoSeparator(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = File.separator;
            if (str.endsWith(str2)) {
                return str.substring(0, str.lastIndexOf(str2));
            }
            return str;
        }
        return str;
    }

    public static String getFileExt(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(46)) < 0) {
            return "";
        }
        return str.substring(lastIndexOf);
    }

    public static String getFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return new File(str).getName();
    }

    public static String getFileSha1(String str) {
        FileInputStream fileInputStream;
        Throwable th5;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th6) {
            fileInputStream = null;
            th5 = th6;
        }
        try {
            byte[] bArr = new byte[16384];
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            int i3 = 0;
            while (i3 != -1) {
                i3 = fileInputStream.read(bArr);
                if (i3 > 0) {
                    messageDigest.update(bArr, 0, i3);
                }
            }
            return Utils.bytes2HexStr(messageDigest.digest()).toLowerCase();
        } catch (Throwable th7) {
            th5 = th7;
            try {
                Log.d(TAG, "fail get sha1 for file:" + str, th5);
                return "";
            } finally {
                closeSilently(fileInputStream);
            }
        }
    }

    public static String[] getFileSha1AndMd5(String str) {
        FileInputStream fileInputStream;
        Throwable th5;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th6) {
            fileInputStream = null;
            th5 = th6;
        }
        try {
            byte[] bArr = new byte[16384];
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            MessageDigest messageDigest2 = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            int i3 = 0;
            while (i3 != -1) {
                i3 = fileInputStream.read(bArr);
                if (i3 > 0) {
                    messageDigest.update(bArr, 0, i3);
                    messageDigest2.update(bArr, 0, i3);
                }
            }
            return new String[]{Utils.bytes2HexStr(messageDigest.digest()).toLowerCase(), Utils.bytes2HexStr(messageDigest2.digest()).toLowerCase()};
        } catch (Throwable th7) {
            th5 = th7;
            try {
                Log.d(TAG, "fail get sha1 for file:" + str, th5);
                return new String[]{"", ""};
            } finally {
                closeSilently(fileInputStream);
            }
        }
    }

    public static long getFileSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return getFileSize(new File(str));
    }

    public static int[] getImageWidthHeight(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new int[]{options.outWidth, options.outHeight};
    }

    public static String getParentDir(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return getDirPathNoSeparator(new File(str).getParent());
    }

    public static long getSdcardCapability() {
        if (!isSdcardMounted()) {
            return -1L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th5) {
            Log.e(TAG, "getSdcardCapability error", th5);
            return -1L;
        }
    }

    public static String getSdcardCapabilityForDisplay() {
        long sdcardCapability = getSdcardCapability();
        if (sdcardCapability >= 0) {
            return calcCapUnit(sdcardCapability);
        }
        return "\u65e0SD Card";
    }

    public static long getSdcardRemain() {
        if (!isSdcardMounted()) {
            return -1L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th5) {
            Log.e(TAG, "getSdcardRemain error", th5);
            return -1L;
        }
    }

    public static String getSdcardRemainForDisplay() {
        long sdcardRemain = getSdcardRemain();
        if (sdcardRemain >= 0) {
            return calcCapUnit(sdcardRemain);
        }
        return "\u65e0SD Card";
    }

    public static boolean isFileModified(String str, long j3) {
        if (TextUtils.isEmpty(str) || new File(str).lastModified() == j3) {
            return false;
        }
        return true;
    }

    public static boolean isSdcardMounted() {
        return TextUtils.equals(Environment.getExternalStorageState(), "mounted");
    }

    private static boolean performCopyFile(File file, File file2) {
        FileChannel fileChannel;
        if (file == null || file2 == null) {
            return false;
        }
        FileChannel fileChannel2 = null;
        try {
            if (file.exists() && file.isFile()) {
                if (file2.exists()) {
                    if (TextUtils.equals(file.getAbsolutePath(), file2.getAbsolutePath())) {
                        closeSilently((Closeable) null);
                        closeSilently(fileChannel2);
                        return true;
                    }
                    deleteFile(file2, false);
                }
                File parentFile = file2.getParentFile();
                if (parentFile.isFile()) {
                    deleteFile(parentFile, false);
                }
                if (!parentFile.exists() && !parentFile.mkdirs()) {
                    closeSilently((Closeable) null);
                    closeSilently((Closeable) null);
                    return false;
                }
                FileChannel channel = new FileInputStream(file).getChannel();
                try {
                    fileChannel2 = new FileOutputStream(file2).getChannel();
                    if (channel.size() <= TTL.MAX_VALUE) {
                        try {
                            long size = channel.size();
                            for (long j3 = 0; j3 < size; j3 += fileChannel2.transferFrom(channel, j3, 536870912L)) {
                            }
                        } catch (Throwable unused) {
                        }
                        closeSilently(channel);
                        closeSilently(fileChannel2);
                        return true;
                    }
                    ByteBuffer allocate = ByteBuffer.allocate(8192);
                    while (channel.read(allocate) > 0) {
                        allocate.flip();
                        fileChannel2.write(allocate);
                        allocate.compact();
                    }
                    closeSilently(channel);
                    closeSilently(fileChannel2);
                    return true;
                } catch (Throwable th5) {
                    th = th5;
                    fileChannel = fileChannel2;
                    fileChannel2 = channel;
                    try {
                        Log.e(TAG, "fail to copy file", th);
                        deleteFile(file2, false);
                        return false;
                    } finally {
                        closeSilently(fileChannel2);
                        closeSilently(fileChannel);
                    }
                }
            }
            closeSilently((Closeable) null);
            closeSilently((Closeable) null);
            return false;
        } catch (Throwable th6) {
            th = th6;
            fileChannel = null;
        }
    }

    private static String performRename(String str) {
        String substring;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            substring = "";
        } else {
            substring = str.substring(lastIndexOf);
        }
        if (lastIndexOf != -1) {
            str2 = str.substring(0, lastIndexOf);
        }
        StringBuilder sb5 = new StringBuilder();
        Matcher matcher = Pattern.compile("(^.+)(\\((\\d+)\\)$)").matcher(str2);
        if (matcher.find()) {
            String group = matcher.group(1);
            try {
                int parseInt = Integer.parseInt(matcher.group(3));
                if (Integer.MAX_VALUE > parseInt) {
                    sb5.append(group);
                    sb5.append('(');
                    sb5.append(parseInt + 1);
                    sb5.append(')');
                    sb5.append(substring);
                }
            } catch (Throwable th5) {
                Log.e(TAG, "fail to rename", th5);
            }
        } else {
            sb5.append(str2);
            sb5.append("(1)");
            sb5.append(substring);
        }
        return sb5.toString();
    }

    public static void scan2MediaStore(Context context, File file) {
        MediaScannerConnection.scanFile(context.getApplicationContext(), new String[]{file.getAbsolutePath()}, null, null);
    }

    public static String spliceFilePath(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!str.endsWith(File.separator)) {
                str = str + File.separatorChar;
            }
            return str + str2;
        }
        return "";
    }

    private static String calcCapUnit(int i3, float f16) {
        if (f16 < 0.0f) {
            return "";
        }
        if (f16 < 1024.0f) {
            return String.format("%.2f", Float.valueOf(f16)) + countToUnit(i3);
        }
        return calcCapUnit(i3 + 1, f16 / 1024.0f);
    }

    public static void closeSilently(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        try {
            cursor.close();
        } catch (Throwable unused) {
        }
    }

    public static long getFileSize(File file) {
        long j3 = 0;
        if (file != null && file.exists()) {
            if (file.isFile()) {
                return file.length();
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return 0L;
            }
            for (File file2 : listFiles) {
                j3 += getFileSize(file2);
            }
        }
        return j3;
    }
}
