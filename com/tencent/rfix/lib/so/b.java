package com.tencent.rfix.lib.so;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rfix.loader.so.IOHelper;
import com.tencent.rfix.loader.so.MD5;
import com.tencent.rfix.loader.so.SoConfig;
import com.tencent.rfix.loader.so.SoConfigParser;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Context f365012a;

    public b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f365012a = context;
        }
    }

    private boolean a(SoConfig soConfig) {
        String substring = soConfig.oldSo.substring(soConfig.oldSo.indexOf("/") + 1, soConfig.oldSo.lastIndexOf("/"));
        if (!TextUtils.equals(substring, Build.CPU_ABI) && !TextUtils.equals(substring, Build.CPU_ABI2)) {
            return true;
        }
        return false;
    }

    private boolean b(SoConfig soConfig, File file) {
        String md5 = MD5.getMD5(file);
        if (TextUtils.equals(soConfig.newSoMD5, md5)) {
            return true;
        }
        Log.e("SoPatchInstaller", "md5 not equal " + soConfig.oldSo + ", md5 " + md5 + ", wanted md5 " + soConfig.newSoMD5);
        if (file.exists() && file.delete()) {
            return false;
        }
        Log.e("SoPatchInstaller", "BSPatch delete failed " + soConfig.oldSo);
        return false;
    }

    private boolean c(SoConfig soConfig, ZipEntry zipEntry) {
        return !String.valueOf(zipEntry.getCrc()).equals(soConfig.oldSoCRC);
    }

    private boolean d(SoConfig soConfig) {
        return TextUtils.equals(soConfig.diffMD5, soConfig.newSoMD5);
    }

    private static boolean e(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        int i3 = 0;
        boolean z16 = false;
        while (i3 < 2 && !z16) {
            i3++;
            Log.d("SoPatchInstaller", "extractZipEntry path: " + file.getPath());
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedInputStream = null;
            }
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                }
                IOHelper.closeQuietly(bufferedOutputStream);
                IOHelper.closeQuietly(bufferedInputStream);
                if (str != null) {
                    z16 = TextUtils.equals(MD5.getMD5(file), str);
                } else {
                    z16 = true;
                }
                if (!z16 && (!file.delete() || file.exists())) {
                    Log.e("SoPatchInstaller", "extractZipEntry extract fail, delete path: " + file.getPath());
                }
            } catch (Throwable th7) {
                th = th7;
                bufferedOutputStream2 = bufferedOutputStream;
                IOHelper.closeQuietly(bufferedOutputStream2);
                IOHelper.closeQuietly(bufferedInputStream);
                throw th;
            }
        }
        return z16;
    }

    private static long f() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory());
    }

    private boolean g(File file, SoConfig soConfig, boolean z16) throws IOException {
        ZipFile zipFile = new ZipFile(this.f365012a.getApplicationInfo().sourceDir);
        if (a(soConfig)) {
            Log.i("SoPatchInstaller", "abi not equal");
            return true;
        }
        if (j(file, soConfig)) {
            Log.i("SoPatchInstaller", "is installed");
            return true;
        }
        ZipEntry entry = zipFile.getEntry(soConfig.oldSo);
        if (c(soConfig, entry)) {
            Log.e("SoPatchInstaller", "CRC not equal " + soConfig.oldSo + ", crc " + entry.getCrc() + ", wanted crc " + soConfig.oldSoCRC);
            return false;
        }
        File file2 = new File(file, soConfig.diff);
        if (!file2.exists()) {
            Log.e("SoPatchInstaller", "diff file do not exist: " + file2.getAbsolutePath());
            return false;
        }
        File file3 = new File(file, soConfig.oldSo);
        if (d(soConfig)) {
            file2.renameTo(file3);
        } else {
            k(file, soConfig, z16, zipFile, entry, file2, file3);
        }
        return b(soConfig, file3);
    }

    private boolean h(File file, List<SoConfig> list, boolean z16) throws IOException {
        Iterator<SoConfig> it = list.iterator();
        while (it.hasNext()) {
            if (!g(file, it.next(), z16)) {
                return false;
            }
        }
        return true;
    }

    private boolean j(File file, SoConfig soConfig) {
        return TextUtils.equals(MD5.getMD5(new File(file, soConfig.oldSo)), soConfig.newSoMD5);
    }

    private void k(File file, SoConfig soConfig, boolean z16, ZipFile zipFile, ZipEntry zipEntry, File file2, File file3) throws IOException {
        if (z16 && (zipEntry.getSize() * 2) + file2.length() + 4194304 >= f()) {
            m(file, soConfig, zipFile, zipEntry, file2, file3);
            return;
        }
        try {
            l(zipFile, zipEntry, file2, file3);
        } catch (OutOfMemoryError e16) {
            if (z16) {
                Log.e("SoPatchInstaller", "bspatch so oom: ", e16);
                m(file, soConfig, zipFile, zipEntry, file2, file3);
                return;
            }
            throw e16;
        }
    }

    private void l(ZipFile zipFile, ZipEntry zipEntry, File file, File file2) throws IOException {
        long uptimeMillis = SystemClock.uptimeMillis();
        Log.i("SoPatchInstaller", "patchFast result " + a.a(zipFile.getInputStream(zipEntry), new FileInputStream(file), file2) + ", cost time = " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
    }

    private void m(File file, SoConfig soConfig, ZipFile zipFile, ZipEntry zipEntry, File file2, File file3) throws IOException {
        File file4 = new File(file, soConfig.oldSo + ".tmp");
        e(zipFile, zipEntry, file4, soConfig.oldSoMD5);
        n(new RandomAccessFile(file4, "r"), file2, file3);
        file4.delete();
    }

    private void n(RandomAccessFile randomAccessFile, File file, File file2) {
        long uptimeMillis = SystemClock.uptimeMillis();
        Log.i("SoPatchInstaller", "patchLessMemory result " + a.b(randomAccessFile, file2, file) + ", cost time = " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
    }

    public boolean i(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) file)).booleanValue();
        }
        try {
            List<SoConfig> parseSoMeta = SoConfigParser.parseSoMeta(new File(file, SoConfigParser.SO_META_TXT));
            Log.i("SoPatchInstaller", "soConfigList size " + parseSoMeta.size());
            return h(file, parseSoMeta, true);
        } catch (Throwable th5) {
            Log.e("SoPatchInstaller", "install: ", th5);
            return false;
        }
    }
}
