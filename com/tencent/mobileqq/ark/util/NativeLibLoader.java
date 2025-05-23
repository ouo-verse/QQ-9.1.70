package com.tencent.mobileqq.ark.util;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wordsegment.WordSegment;
import java.io.File;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes11.dex */
public class NativeLibLoader {
    public static synchronized boolean a(final Context context, final String str) {
        synchronized (NativeLibLoader.class) {
            if (QLog.isColorLevel()) {
                QLog.i("ArkApp.ArkEngineExtract", 2, "start LoadExtractedSo: " + str);
            }
            final String str2 = k(context) + e(str);
            int j3 = j(str);
            long h16 = h(str);
            final File file = new File(str2);
            if (file.exists() && ((j3 == -1 || j3 == file.length()) && (h16 == -1 || h16 == IOUtil.getCRC32Value(file)))) {
                try {
                    System.loadLibrary("c++_shared");
                    System.load(str2);
                    QLog.i("ArkApp.ArkEngineExtract", 1, "LoadExtractedSo, lib=" + str + ", path=" + str2);
                    return true;
                } catch (SecurityException e16) {
                    String str3 = "arkso.old.load.fail.1." + str;
                    QLog.i("ArkApp.ArkEngineExtract", 1, str3, e16);
                    b.g(str3);
                } catch (UnsatisfiedLinkError e17) {
                    String str4 = "arkso.old.load.fail.2." + str;
                    QLog.i("ArkApp.ArkEngineExtract", 1, str4, e17);
                    b.g(str4);
                }
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ark.util.NativeLibLoader.1
                @Override // java.lang.Runnable
                public void run() {
                    file.delete();
                    try {
                        if (NativeLibLoader.c(context, str)) {
                            System.loadLibrary("c++_shared");
                            System.load(str2);
                            QLog.i("ArkApp.ArkEngineExtract", 1, "LoadExtractedSo, lib=" + str + ", path=" + str2);
                        } else {
                            String str5 = "arkso.old.extract.fail." + str;
                            QLog.i("ArkApp.ArkEngineExtract", 1, str5);
                            b.g(str5);
                        }
                    } catch (SecurityException e18) {
                        String str6 = "arkso.old.load.fail.3." + str;
                        QLog.i("ArkApp.ArkEngineExtract", 1, str6, e18);
                        b.g(str6);
                    } catch (UnsatisfiedLinkError e19) {
                        String str7 = "arkso.old.load.fail.4." + str;
                        QLog.i("ArkApp.ArkEngineExtract", 1, str7, e19);
                        b.g(str7);
                    }
                }
            }, 64, null, true);
            return true;
        }
    }

    public static synchronized boolean b(Context context, String str) {
        synchronized (NativeLibLoader.class) {
            String f16 = f(str, i(str));
            String str2 = k(context) + f16;
            if (QLog.isColorLevel()) {
                QLog.i("ArkApp.ArkEngineExtract", 2, "start.LoadExtractedSo." + f16);
            }
            int j3 = j(str);
            long h16 = h(str);
            File file = new File(str2);
            if (file.exists()) {
                long length = file.length();
                long cRC32Value = IOUtil.getCRC32Value(file);
                if ((j3 != -1 && j3 != length) || (h16 != -1 && h16 != cRC32Value)) {
                    QLog.w("ArkApp.ArkEngineExtract", 1, String.format(Locale.CHINA, "library exists but wrong size or crc, fileSize=%d->%d, fileCrc=%d->%d path=%s", Integer.valueOf(j3), Long.valueOf(length), Long.valueOf(h16), Long.valueOf(cRC32Value), str2));
                }
                try {
                    System.loadLibrary("c++_shared");
                    System.load(str2);
                    QLog.i("ArkApp.ArkEngineExtract", 1, String.format(Locale.CHINA, "load library with version ok, fileSize=%d->%d, fileCrc=%d->%d path=%s", Integer.valueOf(j3), Long.valueOf(length), Long.valueOf(h16), Long.valueOf(cRC32Value), str2));
                    return true;
                } catch (SecurityException e16) {
                    String str3 = "arkso.load.fail.1." + f16 + ".path." + str2;
                    QLog.i("ArkApp.ArkEngineExtract", 1, str3, e16);
                    b.g(str3);
                    return false;
                } catch (UnsatisfiedLinkError e17) {
                    String str4 = "arkso.load.fail.2." + f16 + ".path." + str2;
                    QLog.i("ArkApp.ArkEngineExtract", 1, str4, e17);
                    b.g(str4);
                }
            }
            try {
            } catch (SecurityException e18) {
                String str5 = "arkso.load.fail.3." + f16 + ".path." + str2;
                QLog.i("ArkApp.ArkEngineExtract", 1, str5, e18);
                b.g(str5);
            } catch (UnsatisfiedLinkError e19) {
                String str6 = "arkso.load.fail.4." + f16 + ".path." + str2;
                QLog.i("ArkApp.ArkEngineExtract", 1, str6, e19);
                b.g(str6);
            }
            if (d(context, str, true)) {
                System.loadLibrary("c++_shared");
                System.load(str2);
                QLog.i("ArkApp.ArkEngineExtract", 1, String.format(Locale.CHINA, "extract and load library with version ok, fileSize=%d, path=%s", Integer.valueOf(j3), str2));
                return true;
            }
            QLog.i("ArkApp.ArkEngineExtract", 1, "arkso.extract.return.false");
            b.g("arkso.extract.return.false");
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0075, code lost:
    
        if ((r14 | r15) == false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0118 A[Catch: all -> 0x011d, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x00dc, B:10:0x0118, B:15:0x0019, B:17:0x0024, B:20:0x002e, B:23:0x0059, B:28:0x0069, B:31:0x0074, B:36:0x007b, B:38:0x0084, B:40:0x0096, B:42:0x00a5, B:43:0x00ac, B:48:0x00b9, B:50:0x00c2, B:53:0x00cd, B:55:0x00d5), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean c(Context context, String str) {
        boolean z16;
        String str2;
        String str3;
        File file;
        boolean z17;
        boolean z18;
        synchronized (NativeLibLoader.class) {
            long uptimeMillis = SystemClock.uptimeMillis();
            String k3 = k(context);
            z16 = false;
            if (TextUtils.isEmpty(k3)) {
                str3 = "arkso.old.getTxlibPath.return.null";
            } else {
                File file2 = new File(k3);
                if (!file2.exists() && !file2.mkdir()) {
                    str3 = "arkso.old.mkdir.fail";
                } else {
                    int j3 = j(str);
                    long h16 = h(str);
                    File file3 = new File(k3 + e(str));
                    if (file3.exists()) {
                        if (j3 != -1 && j3 != file3.length()) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (h16 != -1 && h16 != IOUtil.getCRC32Value(file3)) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                    }
                    file3.delete();
                    if (file3.exists()) {
                        str2 = String.format("arkso.old.delete.%s.fail!!", file3.getName());
                    } else if (SoLoadUtil.s(context, k3, "txlib", e(str)) != 0) {
                        file3.delete();
                        str2 = "arkso.old.extract.fail!!";
                    } else if (!file3.exists()) {
                        str2 = "arkso.old.file.not.exist!!";
                    } else if (j3 != -1 && j3 != file3.length()) {
                        file3.delete();
                        str2 = "arkso.old.size.mismatch!!";
                    } else {
                        if (h16 != -1 && h16 != IOUtil.getCRC32Value(file3)) {
                            file3.delete();
                            str2 = "arkso.old.crc32.mismatch!!";
                        }
                        z16 = true;
                        file = file3;
                        str3 = null;
                        QLog.d("ArkApp.ArkEngineExtract", 1, "extract.so. lib=" + str + ", file=" + file + ", costTime=" + (SystemClock.uptimeMillis() - uptimeMillis) + ", msg=" + str3);
                        if (str3 != null) {
                            b.g(str3);
                        }
                    }
                    str3 = str2;
                    file = file3;
                    QLog.d("ArkApp.ArkEngineExtract", 1, "extract.so. lib=" + str + ", file=" + file + ", costTime=" + (SystemClock.uptimeMillis() - uptimeMillis) + ", msg=" + str3);
                    if (str3 != null) {
                    }
                }
            }
            file = null;
            QLog.d("ArkApp.ArkEngineExtract", 1, "extract.so. lib=" + str + ", file=" + file + ", costTime=" + (SystemClock.uptimeMillis() - uptimeMillis) + ", msg=" + str3);
            if (str3 != null) {
            }
        }
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0145 A[Catch: all -> 0x018e, TryCatch #0 {, blocks: (B:4:0x0007, B:9:0x0018, B:14:0x0145, B:15:0x0150, B:18:0x015d, B:20:0x0181, B:22:0x0189, B:27:0x002e, B:29:0x0039, B:32:0x0043, B:35:0x006e, B:40:0x0080, B:43:0x008b, B:45:0x008e, B:47:0x0094, B:51:0x00b1, B:55:0x00b4, B:57:0x00d8, B:60:0x00df, B:62:0x00ec, B:64:0x00f3, B:67:0x00fd, B:69:0x0104, B:71:0x0109, B:72:0x0110, B:76:0x011c, B:77:0x0123, B:78:0x0127, B:80:0x012d, B:81:0x0136, B:82:0x0132), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0189 A[Catch: all -> 0x018e, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0007, B:9:0x0018, B:14:0x0145, B:15:0x0150, B:18:0x015d, B:20:0x0181, B:22:0x0189, B:27:0x002e, B:29:0x0039, B:32:0x0043, B:35:0x006e, B:40:0x0080, B:43:0x008b, B:45:0x008e, B:47:0x0094, B:51:0x00b1, B:55:0x00b4, B:57:0x00d8, B:60:0x00df, B:62:0x00ec, B:64:0x00f3, B:67:0x00fd, B:69:0x0104, B:71:0x0109, B:72:0x0110, B:76:0x011c, B:77:0x0123, B:78:0x0127, B:80:0x012d, B:81:0x0136, B:82:0x0132), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x002e A[Catch: all -> 0x018e, TryCatch #0 {, blocks: (B:4:0x0007, B:9:0x0018, B:14:0x0145, B:15:0x0150, B:18:0x015d, B:20:0x0181, B:22:0x0189, B:27:0x002e, B:29:0x0039, B:32:0x0043, B:35:0x006e, B:40:0x0080, B:43:0x008b, B:45:0x008e, B:47:0x0094, B:51:0x00b1, B:55:0x00b4, B:57:0x00d8, B:60:0x00df, B:62:0x00ec, B:64:0x00f3, B:67:0x00fd, B:69:0x0104, B:71:0x0109, B:72:0x0110, B:76:0x011c, B:77:0x0123, B:78:0x0127, B:80:0x012d, B:81:0x0136, B:82:0x0132), top: B:3:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean d(Context context, String str, boolean z16) {
        boolean z17;
        String k3;
        File file;
        String name;
        String format;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        synchronized (NativeLibLoader.class) {
            long i3 = i(str);
            if (i3 != 0 && !z16) {
                z17 = false;
                long uptimeMillis = SystemClock.uptimeMillis();
                k3 = k(context);
                if (!TextUtils.isEmpty(k3)) {
                    format = "arkso.getTxlibPath.return.null";
                } else {
                    File file2 = new File(k3);
                    if (!file2.exists() && !file2.mkdir()) {
                        format = "arkso.getTxlibPath.mkdir.fail";
                    } else {
                        int j3 = j(str);
                        long h16 = h(str);
                        file = new File(k3 + f(str, i3));
                        if (file.exists()) {
                            if (j3 != -1) {
                                z19 = z17;
                                if (j3 != file.length()) {
                                    z26 = true;
                                    if (h16 == -1 && h16 != IOUtil.getCRC32Value(file)) {
                                        z27 = true;
                                    } else {
                                        z27 = false;
                                    }
                                    z28 = z26 | z27;
                                    if (z28 && QLog.isColorLevel()) {
                                        QLog.d("ArkApp.ArkEngineExtract", 2, "arkso.corrupt.", file.getName());
                                    }
                                    if (!z19 || z28) {
                                        file.delete();
                                    }
                                    format = null;
                                    z18 = true;
                                    if (z18) {
                                        ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFile(context, file);
                                    }
                                    long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                                    if (QLog.isColorLevel()) {
                                        if (z18) {
                                            QLog.d("ArkApp.ArkEngineExtract", 2, "extract.so.", file.getName(), ".spend time.", Long.valueOf(uptimeMillis2));
                                        } else if (format != null) {
                                            QLog.d("ArkApp.ArkEngineExtract", 2, format);
                                        }
                                    }
                                    if (format != null) {
                                        b.g(format);
                                    }
                                }
                            } else {
                                z19 = z17;
                            }
                            z26 = false;
                            if (h16 == -1) {
                            }
                            z27 = false;
                            z28 = z26 | z27;
                            if (z28) {
                                QLog.d("ArkApp.ArkEngineExtract", 2, "arkso.corrupt.", file.getName());
                            }
                            if (!z19) {
                            }
                            file.delete();
                        }
                        File file3 = new File(k3 + e(str));
                        file3.delete();
                        l(k3, str);
                        if (!file3.exists() && !file.exists()) {
                            if (SoLoadUtil.s(context, k3, "txlib", e(str)) != 0) {
                                file3.delete();
                                format = "arkso.extract.fail!!";
                            } else if (!file3.exists()) {
                                format = "arkso.file.not.exist!!";
                            } else {
                                long length = file3.length();
                                if (j3 != -1 && j3 != length) {
                                    file3.delete();
                                    format = "arkso.size.mismatch!!";
                                } else {
                                    long cRC32Value = IOUtil.getCRC32Value(file3);
                                    if (h16 != -1 && h16 != cRC32Value) {
                                        file3.delete();
                                        format = "arkso.crc32.mismatch!!";
                                    } else {
                                        file3.renameTo(file);
                                        format = null;
                                        z18 = true;
                                        if (z18) {
                                        }
                                        long uptimeMillis22 = SystemClock.uptimeMillis() - uptimeMillis;
                                        if (QLog.isColorLevel()) {
                                        }
                                        if (format != null) {
                                        }
                                    }
                                }
                            }
                            z18 = false;
                            if (z18) {
                            }
                            long uptimeMillis222 = SystemClock.uptimeMillis() - uptimeMillis;
                            if (QLog.isColorLevel()) {
                            }
                            if (format != null) {
                            }
                        }
                        if (file3.exists()) {
                            name = file3.getName();
                        } else {
                            name = file.getName();
                        }
                        format = String.format("arkso.delete.%s.fail!!", name);
                        z18 = false;
                        if (z18) {
                        }
                        long uptimeMillis2222 = SystemClock.uptimeMillis() - uptimeMillis;
                        if (QLog.isColorLevel()) {
                        }
                        if (format != null) {
                        }
                    }
                }
                z18 = false;
                file = null;
                if (z18) {
                }
                long uptimeMillis22222 = SystemClock.uptimeMillis() - uptimeMillis;
                if (QLog.isColorLevel()) {
                }
                if (format != null) {
                }
            }
            z17 = true;
            long uptimeMillis3 = SystemClock.uptimeMillis();
            k3 = k(context);
            if (!TextUtils.isEmpty(k3)) {
            }
            z18 = false;
            file = null;
            if (z18) {
            }
            long uptimeMillis222222 = SystemClock.uptimeMillis() - uptimeMillis3;
            if (QLog.isColorLevel()) {
            }
            if (format != null) {
            }
        }
        return z18;
    }

    private static String e(String str) {
        return String.format("lib%s.so", str);
    }

    private static String f(String str, long j3) {
        String format = String.format(Locale.CHINA, "%07x.so", Long.valueOf(j3));
        if (!TextUtils.isEmpty(format) && format.length() > 6) {
            format = format.substring(0, 6);
        }
        return String.format(Locale.CHINA, "lib%s-%s.so", str, format);
    }

    public static String g() {
        return "png-arm64-v8a";
    }

    private static long h(String str) {
        if (str.equals("ark")) {
            return ark.getArkSOArm64CRC();
        }
        if (str.equals("WordSegment")) {
            return WordSegment.getARM64LibCRC32();
        }
        if (str.equals("png-arm64-v8a")) {
            return ark.getPngArm64CRC();
        }
        return -1L;
    }

    private static long i(String str) {
        try {
            if (str.equals("ark")) {
                return ark.arkGetPlatformBuildNumber();
            }
            if (str.equals("WordSegment")) {
                return WordSegment.getPlatformBuildNumber();
            }
            return 0L;
        } catch (Exception e16) {
            QLog.e("ArkApp.ArkEngineExtract", 1, "getSoReversion exception = " + e16);
            return 0L;
        }
    }

    private static int j(String str) {
        if (str.equals("ark")) {
            return ark.getArkSOArm64Size();
        }
        if (str.equals("WordSegment")) {
            return WordSegment.getARM64LibSize();
        }
        if (str.equals("png-arm64-v8a")) {
            return ark.getPngArm64Size();
        }
        return -1;
    }

    private static String k(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            if (QLog.isColorLevel()) {
                QLog.i("ArkApp.ArkEngineExtract", 2, "getFilesDir is null");
                return "";
            }
            return "";
        }
        return filesDir.getParent() + SoLoadCore.PATH_TX_LIB;
    }

    private static void l(String str, String str2) {
        String format = String.format("lib%s", str2);
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkApp.ArkEngineExtract", 2, "path.listFiles return null!!");
                return;
            }
            return;
        }
        for (File file : listFiles) {
            String name = file.getName();
            if (name.startsWith(format)) {
                file.delete();
                if (QLog.isColorLevel()) {
                    QLog.d("ArkApp.ArkEngineExtract", 2, "remove previous so: ", name);
                }
            }
        }
    }
}
