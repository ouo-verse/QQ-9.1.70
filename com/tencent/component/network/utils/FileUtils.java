package com.tencent.component.network.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.BytesBufferPool;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.GZIPInputStream;

/* compiled from: P */
/* loaded from: classes5.dex */
public class FileUtils {
    private static final int ASSET_SPLIT_BASE = 0;
    private static final int BUFFER_SIZE = 8192;
    private static final int BUFFER_SIZE_MMAP = 8388608;
    private static final String DCIM_PATTERN = "/DCIM/";
    private static final String TAG = "FileUtils";
    public static final FileComparator SIMPLE_COMPARATOR = new FileComparator() { // from class: com.tencent.component.network.utils.FileUtils.1
        @Override // com.tencent.component.network.utils.FileUtils.FileComparator
        public boolean equals(File file, File file2) {
            if (file.length() == file2.length() && file.lastModified() == file2.lastModified()) {
                return true;
            }
            return false;
        }
    };
    public static final AssetFileComparator SIMPLE_ASSET_COMPARATOR = new AssetFileComparator() { // from class: com.tencent.component.network.utils.FileUtils.2
        @Override // com.tencent.component.network.utils.FileUtils.AssetFileComparator
        public boolean equals(Context context, String str, File file) {
            long assetLength = FileUtils.getAssetLength(context, str);
            if (assetLength != -1 && assetLength == file.length()) {
                return true;
            }
            return false;
        }
    };
    private static final BytesBufferPool sBytesBufferPool = new BytesBufferPool(2, 8192);

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface AssetFileComparator {
        boolean equals(Context context, String str, File file);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface FileComparator {
        boolean equals(File file, File file2);
    }

    private static void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean copyAssets(Context context, String str, String str2) {
        return copyAssets(context, str, str2, SIMPLE_ASSET_COMPARATOR);
    }

    public static boolean copyFile(String str, OutputStream outputStream) {
        if (TextUtils.isEmpty(str) || outputStream == null) {
            return false;
        }
        BytesBufferPool bytesBufferPool = sBytesBufferPool;
        BytesBufferPool.BytesBuffer bytesBuffer = bytesBufferPool.get();
        FileInputStream fileInputStream = null;
        try {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                while (true) {
                    try {
                        byte[] bArr = bytesBuffer.data;
                        int read = fileInputStream2.read(bArr, 0, bArr.length);
                        if (read > 0) {
                            outputStream.write(bytesBuffer.data, 0, read);
                        } else {
                            sBytesBufferPool.recycle(bytesBuffer);
                            try {
                                fileInputStream2.close();
                                return true;
                            } catch (Throwable unused) {
                                return true;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = fileInputStream2;
                        try {
                            Log.e("FileUtils", "exception when copy file!", th);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable unused2) {
                                }
                            }
                            return false;
                        } finally {
                            sBytesBufferPool.recycle(bytesBuffer);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable unused3) {
                                }
                            }
                        }
                    }
                }
            }
            bytesBufferPool.recycle(bytesBuffer);
            return false;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static boolean copyFiles(File file, File file2) {
        return copyFiles(file, file2, null);
    }

    public static void delete(String str) {
        delete(str, false);
    }

    public static long getAssetLength(Context context, String str) {
        AssetManager assets = context.getAssets();
        try {
            return assets.openFd(str).getLength();
        } catch (IOException unused) {
            InputStream inputStream = null;
            try {
                inputStream = assets.open(str);
                long available = inputStream.available();
                closeSilently(inputStream);
                return available;
            } catch (IOException unused2) {
                closeSilently(inputStream);
                return -1L;
            } catch (Throwable th5) {
                closeSilently(inputStream);
                throw th5;
            }
        }
    }

    private static boolean isEmpty(String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }

    private static boolean performCopyAssetsFile(Context context, String str, String str2, AssetFileComparator assetFileComparator) {
        BufferedOutputStream bufferedOutputStream;
        if (isEmpty(str) || isEmpty(str2)) {
            return false;
        }
        AssetManager assets = context.getAssets();
        File file = new File(str2);
        InputStream inputStream = null;
        try {
            if (file.exists()) {
                if (assetFileComparator != null && assetFileComparator.equals(context, str, file)) {
                    closeSilently(null);
                    closeSilently(null);
                    return true;
                }
                if (file.isDirectory()) {
                    delete(file);
                }
            }
            File parentFile = file.getParentFile();
            if (parentFile.isFile()) {
                delete(parentFile);
            }
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                closeSilently(null);
                closeSilently(null);
                return false;
            }
            InputStream open = assets.open(str);
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open.read(bArr);
                        if (read > 0) {
                            bufferedOutputStream.write(bArr, 0, read);
                        } else {
                            closeSilently(open);
                            closeSilently(bufferedOutputStream);
                            return true;
                        }
                    }
                } catch (Throwable th5) {
                    inputStream = open;
                    th = th5;
                    try {
                        QDLog.w("FileUtils", "fail to copy assets file", th);
                        delete(file);
                        return false;
                    } finally {
                        closeSilently(inputStream);
                        closeSilently(bufferedOutputStream);
                    }
                }
            } catch (Throwable th6) {
                inputStream = open;
                th = th6;
                bufferedOutputStream = null;
            }
        } catch (Throwable th7) {
            th = th7;
            bufferedOutputStream = null;
        }
    }

    private static boolean performCopyFile(File file, File file2, FileFilter fileFilter, FileComparator fileComparator) {
        FileChannel fileChannel;
        boolean z16;
        if (file == null || file2 == null) {
            return false;
        }
        if (fileFilter != null && !fileFilter.accept(file)) {
            return false;
        }
        FileChannel fileChannel2 = null;
        try {
            if (file.exists() && file.isFile()) {
                if (file2.exists()) {
                    if (fileComparator != null && fileComparator.equals(file, file2)) {
                        closeSilently(null);
                        closeSilently(fileChannel2);
                        return true;
                    }
                    delete(file2);
                }
                File parentFile = file2.getParentFile();
                if (parentFile.isFile()) {
                    delete(parentFile);
                }
                if (!parentFile.exists() && !parentFile.mkdirs()) {
                    closeSilently(null);
                    closeSilently(null);
                    return false;
                }
                FileChannel channel = new FileInputStream(file).getChannel();
                try {
                    fileChannel2 = new FileOutputStream(file2).getChannel();
                    if (channel.size() <= TTL.MAX_VALUE) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        for (long j3 = 0; j3 < channel.size(); j3 += fileChannel2.transferFrom(channel, j3, Math.min(channel.size() - j3, VasBusiness.CHAT_FONT_SWITCH))) {
                            try {
                            } catch (Throwable unused) {
                                delete(file2);
                                channel.position(0L);
                                fileChannel2.position(0L);
                            }
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
                        QDLog.w("FileUtils", "fail to copy file", th);
                        delete(file2);
                        return false;
                    } finally {
                        closeSilently(fileChannel2);
                        closeSilently(fileChannel);
                    }
                }
            }
            closeSilently(null);
            closeSilently(null);
            return false;
        } catch (Throwable th6) {
            th = th6;
            fileChannel = null;
        }
    }

    public static boolean rename(File file, File file2) {
        if (file != null && file2 != null) {
            try {
                String path = file.getPath();
                if (path.equals(file2.getPath())) {
                    return true;
                }
                if (file2.exists()) {
                    return false;
                }
                return new File(path).renameTo(file2);
            } catch (SecurityException e16) {
                QDLog.e("FileUtils", "Fail to rename file," + e16.toString());
                return false;
            }
        }
        QDLog.e("FileUtils", "Rename: null parameter");
        return false;
    }

    public static boolean unGzip(File file, File file2) {
        BufferedOutputStream bufferedOutputStream;
        if (file == null || !file.exists()) {
            return false;
        }
        GZIPInputStream gZIPInputStream = null;
        try {
            if (file2.exists()) {
                delete(file2);
            }
            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(new FileInputStream(file));
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    byte[] bArr = new byte[RFixConstants.MD5_FILE_BUF_LENGTH];
                    while (true) {
                        int read = gZIPInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream2.write(bArr, 0, read);
                    }
                    bufferedOutputStream2.flush();
                    try {
                        gZIPInputStream2.close();
                        bufferedOutputStream2.close();
                    } catch (Throwable th5) {
                        QDLog.w("FileUtils", "fail to close file!", th5);
                    }
                    return true;
                } catch (Throwable th6) {
                    gZIPInputStream = gZIPInputStream2;
                    bufferedOutputStream = bufferedOutputStream2;
                    th = th6;
                    try {
                        QDLog.w("FileUtils", "fail to unzip file!", th);
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (Throwable th7) {
                                QDLog.w("FileUtils", "fail to close file!", th7);
                                return false;
                            }
                        }
                        if (bufferedOutputStream == null) {
                            return false;
                        }
                        bufferedOutputStream.close();
                        return false;
                    } catch (Throwable th8) {
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (Throwable th9) {
                                QDLog.w("FileUtils", "fail to close file!", th9);
                                throw th8;
                            }
                        }
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        throw th8;
                    }
                }
            } catch (Throwable th10) {
                th = th10;
                bufferedOutputStream = null;
                gZIPInputStream = gZIPInputStream2;
            }
        } catch (Throwable th11) {
            th = th11;
            bufferedOutputStream = null;
        }
    }

    public static boolean copyAssets(Context context, String str, String str2, AssetFileComparator assetFileComparator) {
        return performCopyAssetsFile(context, str, str2, assetFileComparator);
    }

    public static boolean copyFiles(File file, File file2, FileFilter fileFilter) {
        return copyFiles(file, file2, fileFilter, SIMPLE_COMPARATOR);
    }

    public static void delete(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        delete(new File(str), z16);
    }

    public static boolean copyFiles(File file, File file2, FileFilter fileFilter, FileComparator fileComparator) {
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return performCopyFile(file, file2, fileFilter, fileComparator);
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        boolean z16 = true;
        for (File file3 : listFiles) {
            if (!copyFiles(file3, new File(file2, file3.getName()), fileFilter)) {
                z16 = false;
            }
        }
        return z16;
    }

    public static void delete(File file) {
        delete(file, false);
    }

    public static void delete(File file, boolean z16) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.getAbsolutePath().contains(DCIM_PATTERN)) {
            QDLog.e("FileUtils", "ignore DCIM path");
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
            delete(file2, z16);
        }
        if (z16) {
            return;
        }
        file.delete();
    }
}
