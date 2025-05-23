package com.facebook.soloader;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.facebook.soloader.MinElf;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.TreeSet;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class l {

    /* compiled from: P */
    @DoNotOptimize
    @TargetApi(21)
    /* loaded from: classes2.dex */
    private static final class a {
        @DoNotOptimize
        public static void a(FileDescriptor fileDescriptor, long j3) throws IOException {
            int i3;
            try {
                Os.posix_fallocate(fileDescriptor, 0L, j3);
            } catch (ErrnoException e16) {
                if (e16.errno != OsConstants.EOPNOTSUPP && (i3 = e16.errno) != OsConstants.ENOSYS && i3 != OsConstants.EINVAL) {
                    throw new IOException(e16.toString(), e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @DoNotOptimize
    @TargetApi(23)
    /* loaded from: classes2.dex */
    public static final class b {
        @DoNotOptimize
        public static String[] a() {
            String[] strArr = Build.SUPPORTED_ABIS;
            TreeSet treeSet = new TreeSet();
            if (b()) {
                treeSet.add(MinElf.ISA.AARCH64.toString());
                treeSet.add(MinElf.ISA.X86_64.toString());
            } else {
                treeSet.add(MinElf.ISA.ARM.toString());
                treeSet.add(MinElf.ISA.X86.toString());
            }
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (treeSet.contains(str)) {
                    arrayList.add(str);
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }

        @DoNotOptimize
        public static boolean b() {
            return Process.is64Bit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(RandomAccessFile randomAccessFile, InputStream inputStream, int i3, byte[] bArr) throws IOException {
        int i16 = 0;
        while (i16 < i3) {
            int read = inputStream.read(bArr, 0, Math.min(bArr.length, i3 - i16));
            if (read == -1) {
                break;
            }
            randomAccessFile.write(bArr, 0, read);
            i16 += read;
        }
        return i16;
    }

    public static void b(File file) throws IOException {
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.canWrite() && !parentFile.setWritable(true)) {
            Log.e("SysUtil", "Enable write permission failed: " + parentFile);
        }
        if (!file.delete() && file.exists()) {
            throw new IOException("Could not delete file " + file);
        }
    }

    public static void c(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                c(file2);
            }
        }
        b(file);
    }

    public static void d(FileDescriptor fileDescriptor, long j3) throws IOException {
        a.a(fileDescriptor, j3);
    }

    public static int e(String[] strArr, String str) {
        for (int i3 = 0; i3 < strArr.length; i3++) {
            String str2 = strArr[i3];
            if (str2 != null && str.equals(str2)) {
                return i3;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    f(file2);
                }
                return;
            }
            throw new IOException("cannot list directory " + file);
        }
        if (!file.getPath().endsWith("_lock")) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th7) {
                        th5.addSuppressed(th7);
                    }
                    throw th6;
                }
            }
        }
    }

    public static int g(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                return InstalledAppListMonitor.getPackageInfo(packageManager, context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            }
        }
        return 0;
    }

    public static String[] h() {
        return b.a();
    }

    @SuppressLint({"CatchGeneralException"})
    public static boolean i() {
        return b.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(File file) throws IOException {
        if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException("cannot mkdir: " + file);
        }
    }
}
