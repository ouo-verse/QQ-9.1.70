package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsLogReport;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: P */
@SuppressLint({"NewApi"})
/* loaded from: classes25.dex */
public class FileUtil {

    /* renamed from: a, reason: collision with root package name */
    public static String f369637a = null;

    /* renamed from: b, reason: collision with root package name */
    public static final a f369638b = new a() { // from class: com.tencent.smtt.utils.FileUtil.2
    };

    /* renamed from: c, reason: collision with root package name */
    private static final int f369639c = 4;

    /* renamed from: d, reason: collision with root package name */
    private static RandomAccessFile f369640d = null;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f369641e = true;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface b {
        boolean a(InputStream inputStream, ZipEntry zipEntry, String str) throws Exception;
    }

    private static String b(Context context, String str) {
        if (context != null && str != null && a(context)) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            try {
                return context.getExternalFilesDir(str).getAbsolutePath();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        return "";
    }

    public static boolean c(File file) {
        return file != null && file.exists() && file.isFile() && file.length() > 0;
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException, OutOfMemoryError {
        long a16 = a(inputStream, outputStream);
        if (a16 > TTL.MAX_VALUE) {
            return -1;
        }
        return (int) a16;
    }

    public static FileOutputStream d(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (!file.canWrite()) {
                    throw new IOException("File '" + file + "' cannot be written to");
                }
            } else {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
        } else {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException("File '" + file + "' could not be created");
            }
        }
        return new FileOutputStream(file);
    }

    public static FileLock e(Context context) {
        FileLock fileLock;
        File a16 = a(context, "tbs_rename_lock");
        TbsLog.i("FileHelper", "getTbsCoreRenameFileLock #1 " + a16);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(a16.getAbsolutePath(), "rw");
            f369640d = randomAccessFile;
            fileLock = randomAccessFile.getChannel().tryLock(0L, Long.MAX_VALUE, false);
        } catch (Throwable unused) {
            TbsLog.e("FileHelper", "getTbsCoreRenameFileLock -- excpetion: tbs_rename_lock");
            fileLock = null;
        }
        if (fileLock == null) {
            TbsLog.i("FileHelper", "getTbsCoreRenameFileLock -- failed: tbs_rename_lock");
        } else {
            TbsLog.i("FileHelper", "getTbsCoreRenameFileLock -- success: tbs_rename_lock");
        }
        return fileLock;
    }

    private static FileLock f(Context context) {
        FileLock fileLock = null;
        try {
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
            tbsLogInfo.setErrorCode(803);
            File a16 = a(context, "tbs_rename_lock");
            if (TbsDownloadConfig.getInstance(context).getTbsCoreLoadRenameFileLockWaitEnable()) {
                boolean z16 = false;
                int i3 = 0;
                while (i3 < 20 && fileLock == null) {
                    try {
                        try {
                            LockMethodProxy.sleep(100L);
                        } catch (Throwable unused) {
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(a16.getAbsolutePath(), "r");
                    f369640d = randomAccessFile;
                    fileLock = randomAccessFile.getChannel().tryLock(0L, Long.MAX_VALUE, true);
                    i3++;
                }
                if (fileLock != null) {
                    tbsLogInfo.setErrorCode(802);
                } else {
                    tbsLogInfo.setErrorCode(801);
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getTbsCoreLoadFileLock,retry num=");
                sb5.append(i3);
                sb5.append("success=");
                if (fileLock == null) {
                    z16 = true;
                }
                sb5.append(z16);
                TbsLog.i("FileHelper", sb5.toString());
            }
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        return fileLock;
    }

    public static String a(Context context, int i3) {
        return a(context, context.getApplicationInfo().packageName, i3, true);
    }

    public static String c(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static String a(Context context, String str, int i3, boolean z16) {
        if (context == null || !a(context)) {
            return "";
        }
        if (i3 != 6) {
            if (i3 != 8) {
                return i3 != 9 ? "" : b(context, "Download");
            }
            return b(context, MosaicConstants$JsProperty.PROP_ENV);
        }
        String str2 = f369637a;
        if (str2 != null) {
            return str2;
        }
        String b16 = b(context, "tbslog");
        f369637a = b16;
        return b16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public static boolean b(InputStream inputStream, ZipEntry zipEntry, String str, String str2) throws Exception {
        a(new File(str));
        String str3 = str + File.separator + str2;
        File file = new File(str3);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    }
                    fileOutputStream2.close();
                    if (a(str3, zipEntry.getSize(), zipEntry.getTime(), zipEntry.getCrc())) {
                        TbsLog.e("FileHelper", "file is different: " + str3);
                        return false;
                    }
                    if (file.setLastModified(zipEntry.getTime())) {
                        return true;
                    }
                    TbsLog.e("FileHelper", "Couldn't set time for dst file " + file);
                    return true;
                } catch (IOException e16) {
                    e = e16;
                    b(file);
                    throw new IOException("Couldn't write dst file " + file, e);
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static void a(boolean z16) {
        f369641e = z16;
    }

    public static boolean a(Context context) {
        return f369641e;
    }

    public static boolean a(File file, File file2) throws Exception {
        return a(file.getPath(), file2.getPath());
    }

    @SuppressLint({"InlinedApi"})
    public static boolean a(String str, String str2) throws Exception {
        return a(str, str2, Build.CPU_ABI, Build.CPU_ABI2, PropertyUtils.getQuickly("ro.product.cpu.upgradeabi", "armeabi"));
    }

    public static FileLock d(Context context) {
        FileLock fileLock;
        TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #1");
        File a16 = a(context, "tbs_rename_lock");
        TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #4 " + a16);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(a16.getAbsolutePath(), "r");
            f369640d = randomAccessFile;
            fileLock = randomAccessFile.getChannel().tryLock(0L, Long.MAX_VALUE, true);
        } catch (Throwable th5) {
            TbsLog.e("FileHelper", "getTbsCoreLoadFileLock -- exception: " + th5);
            fileLock = null;
        }
        if (fileLock == null) {
            fileLock = f(context);
        }
        if (fileLock == null) {
            TbsLog.i("FileHelper", "getTbsCoreLoadFileLock -- failed: tbs_rename_lock");
        } else {
            TbsLog.i("FileHelper", "getTbsCoreLoadFileLock -- success: tbs_rename_lock");
        }
        return fileLock;
    }

    private static boolean a(String str, final String str2, String str3, String str4, String str5) throws Exception {
        return a(str, str3, str4, str5, new b() { // from class: com.tencent.smtt.utils.FileUtil.1
            @Override // com.tencent.smtt.utils.FileUtil.b
            public boolean a(InputStream inputStream, ZipEntry zipEntry, String str6) throws Exception {
                try {
                    return FileUtil.b(inputStream, zipEntry, str2, str6);
                } catch (Exception e16) {
                    throw new Exception("copyFileIfChanged Exception", e16);
                }
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x008f, code lost:
    
        if (r6.regionMatches(r9, r14, 0, r14.length()) == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009a, code lost:
    
        if (r6.charAt(r9 + r14.length()) != '/') goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x009c, code lost:
    
        if (r2 != false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x009e, code lost:
    
        if (r3 == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x000d, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(String str, String str2, String str3, String str4, b bVar) throws Exception {
        ZipFile zipFile;
        Enumeration<? extends ZipEntry> entries;
        boolean z16;
        boolean z17;
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(str);
            try {
                entries = zipFile.entries();
                z16 = false;
                z17 = false;
            } catch (Throwable th5) {
                th = th5;
                zipFile2 = zipFile;
            }
        } catch (Throwable th6) {
            th = th6;
        }
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            String name = nextElement.getName();
            if (name != null && !name.contains("../") && (name.startsWith("lib/") || name.startsWith("assets/"))) {
                String substring = name.substring(name.lastIndexOf(47));
                if (substring.endsWith(".so")) {
                    int i3 = f369639c;
                    if (!name.regionMatches(i3, str2, 0, str2.length()) || name.charAt(str2.length() + i3) != '/') {
                        if (str3 != null && name.regionMatches(i3, str3, 0, str3.length()) && name.charAt(str3.length() + i3) == '/') {
                            z17 = true;
                            if (z16) {
                            }
                        } else {
                            Log.i("FileHelper", "abi didn't match anything entry " + name + ", ABI is " + str2 + " ABI2 is " + str3 + " ABI3 is " + str4);
                        }
                        th = th5;
                        zipFile2 = zipFile;
                        if (zipFile2 != null) {
                            zipFile2.close();
                        }
                        throw th;
                    }
                    z16 = true;
                }
                InputStream inputStream = zipFile.getInputStream(nextElement);
                try {
                    if (!bVar.a(inputStream, nextElement, substring.substring(1))) {
                        zipFile.close();
                        return false;
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
        }
        zipFile.close();
        return true;
    }

    public static void b(File file) {
        a(file, false);
    }

    public static boolean b(Context context) {
        long a16 = r.a();
        boolean z16 = a16 >= TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
        if (!z16) {
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = " + a16);
        }
        return z16;
    }

    public static FileOutputStream b(Context context, boolean z16, String str) {
        File a16 = a(context, z16, str);
        if (a16 == null) {
            return null;
        }
        try {
            return new FileOutputStream(a16);
        } catch (FileNotFoundException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private static boolean a(String str, long j3, long j16, long j17) throws Exception {
        FileInputStream fileInputStream;
        Throwable th5;
        File file = new File(str);
        if (file.length() != j3) {
            TbsLog.e("FileHelper", "file size doesn't match: " + file.length() + " vs " + j3);
            return true;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th6) {
            fileInputStream = null;
            th5 = th6;
        }
        try {
            CRC32 crc32 = new CRC32();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                crc32.update(bArr, 0, read);
            }
            long value = crc32.getValue();
            TbsLog.i("FileHelper", "" + file.getName() + ": crc = " + value + ", zipCrc = " + j17);
            if (value != j17) {
                fileInputStream.close();
                return true;
            }
            fileInputStream.close();
            return false;
        } catch (Throwable th7) {
            th5 = th7;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th5;
        }
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        b(file);
        return file.mkdirs();
    }

    public static void a(File file, boolean z16) {
        a(file, z16, true);
    }

    public static void a(File file, boolean z16, boolean z17) {
        TbsLog.i("FileUtils", "delete file,ignore=" + z16 + "isSoftLink=" + z17);
        if (file == null) {
            return;
        }
        if (z17 || file.exists()) {
            if ((z17 && !file.isDirectory()) || file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                a(file2, z16, z17);
            }
            if (z16) {
                return;
            }
            file.delete();
        }
    }

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException, OutOfMemoryError {
        if (inputStream == null) {
            return -1L;
        }
        byte[] bArr = new byte[4096];
        long j3 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j3;
            }
            outputStream.write(bArr, 0, read);
            j3 += read;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static File a(Context context, boolean z16, String str) {
        String c16 = c(context);
        if (c16 == null) {
            return null;
        }
        File file = new File(c16);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.canWrite()) {
            return null;
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e16) {
                e16.printStackTrace();
                return null;
            }
        }
        return file2;
    }

    public static File a(Context context, String str) {
        File file = new File(context.getFilesDir(), "tbs");
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.canWrite()) {
            TbsLog.e("FileHelper", "getPermanentTbsFile -- no permission!");
            return null;
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e16) {
                TbsLog.e("FileHelper", "getPermanentTbsFile -- exception: " + e16);
                return null;
            }
        }
        return file2;
    }

    public static FileLock a(Context context, FileOutputStream fileOutputStream) {
        FileLock tryLock;
        if (fileOutputStream == null) {
            return null;
        }
        try {
            tryLock = fileOutputStream.getChannel().tryLock();
        } catch (OverlappingFileLockException e16) {
            e16.printStackTrace();
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        if (tryLock.isValid()) {
            return tryLock;
        }
        return null;
    }

    public static void a(FileLock fileLock, FileOutputStream fileOutputStream) {
        if (fileLock != null) {
            try {
                FileChannel channel = fileLock.channel();
                if (channel != null && channel.isOpen()) {
                    fileLock.release();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
    }

    public static synchronized void a(Context context, FileLock fileLock) {
        synchronized (FileUtil.class) {
            TbsLog.i("FileHelper", "releaseTbsCoreRenameFileLock -- lock: " + fileLock);
            FileChannel channel = fileLock.channel();
            if (channel != null && channel.isOpen()) {
                try {
                    fileLock.release();
                    channel.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }
}
