package com.tencent.mobileqq.commonutils.classloader;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Base64;
import com.tencent.mobileqq.commonutils.util.MD5Coding;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import dalvik.system.DexClassLoader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DexClassLoaderUtil {
    private static final String INFO_FILE_SUFFIX = ".dat";
    private static Handler sHandler;
    public static Looper sLooper;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class CheckMD5Task implements Runnable {
        private File file;
        private String info;
        private File infoFile;
        private String oldMD5;
        private File tempInfoFile;

        CheckMD5Task(File file, String str, String str2, File file2, File file3) {
            this.file = file;
            this.info = str;
            this.oldMD5 = str2;
            this.infoFile = file2;
            this.tempInfoFile = file3;
        }

        @Override // java.lang.Runnable
        public void run() {
            String encodeFile2HexStr = MD5Coding.encodeFile2HexStr(this.file.getAbsolutePath());
            String str = this.oldMD5;
            if (str == null) {
                DexClassLoaderUtil.saveInfo(this.infoFile, this.tempInfoFile, this.info, encodeFile2HexStr);
            } else if (!str.equalsIgnoreCase(encodeFile2HexStr)) {
                this.file.delete();
                this.infoFile.delete();
                SystemMethodProxy.killProcess(Process.myPid());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface IHandlerCreator {
        Handler createHandler();
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class InfoReader {

        /* renamed from: a, reason: collision with root package name */
        private Handler f201809a;

        /* renamed from: b, reason: collision with root package name */
        private File f201810b;

        /* renamed from: c, reason: collision with root package name */
        private File f201811c;

        /* renamed from: d, reason: collision with root package name */
        private String f201812d;

        /* renamed from: e, reason: collision with root package name */
        private String f201813e;

        public InfoReader(Handler handler, File file, File file2) {
            this.f201809a = handler;
            this.f201810b = file;
            this.f201811c = file2;
        }

        public String a() {
            return this.f201812d;
        }

        public String b() {
            return this.f201813e;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public InfoReader c() {
            BufferedReader bufferedReader;
            Throwable th5;
            File[] listFiles;
            this.f201812d = null;
            this.f201813e = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(this.f201811c));
            } catch (Exception e16) {
                e = e16;
                bufferedReader = null;
            } catch (Throwable th6) {
                bufferedReader = null;
                th5 = th6;
                DexClassLoaderUtil.close(bufferedReader);
                throw th5;
            }
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    this.f201812d = readLine;
                    if (readLine != null) {
                        this.f201813e = bufferedReader.readLine();
                    }
                } catch (Throwable th7) {
                    th5 = th7;
                    DexClassLoaderUtil.close(bufferedReader);
                    throw th5;
                }
            } catch (Exception e17) {
                e = e17;
                e.printStackTrace();
                DexClassLoaderUtil.close(bufferedReader);
                listFiles = this.f201810b.listFiles();
                if (listFiles != null) {
                }
                return this;
            }
            DexClassLoaderUtil.close(bufferedReader);
            listFiles = this.f201810b.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    File file = listFiles[i3];
                    if (file.getName().endsWith(".dat")) {
                        i3++;
                    } else {
                        String encodeHexStr = MD5Coding.encodeHexStr(DexClassLoaderUtil.getBase64String(file.getName() + file.length() + file.lastModified()));
                        String str = this.f201812d;
                        if (str == null || !str.equalsIgnoreCase(encodeHexStr) || (this.f201813e == null && this.f201809a != null)) {
                            file.delete();
                            this.f201811c.delete();
                            this.f201812d = null;
                            this.f201813e = null;
                        }
                    }
                }
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public static DexClassLoader createDexClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
        int i3;
        if (sHandler == null && sLooper != null) {
            sHandler = new Handler(sLooper);
        }
        Handler handler = sHandler;
        int lastIndexOf = str.lastIndexOf("\\");
        int lastIndexOf2 = str.lastIndexOf("/");
        if (lastIndexOf <= lastIndexOf2) {
            lastIndexOf = lastIndexOf2;
        }
        if (lastIndexOf >= 0) {
            i3 = lastIndexOf + 1;
        } else {
            i3 = 0;
        }
        int lastIndexOf3 = str.lastIndexOf(".");
        if (lastIndexOf3 < 0) {
            lastIndexOf3 = str.length();
        }
        String substring = str.substring(i3, lastIndexOf3);
        String str4 = str2 + File.separator + substring;
        File file = new File(str4);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, substring + ".dat");
        if (file2.isDirectory()) {
            file2.delete();
        }
        InfoReader c16 = new InfoReader(handler, file, file2).c();
        String a16 = c16.a();
        String b16 = c16.b();
        DexClassLoader dexClassLoader = new DexClassLoader(str, str4, str3, classLoader);
        saveAndCheckInfo(handler, substring, file, file2, a16, b16);
        return dexClassLoader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public static String getBase64String(String str) {
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 0);
        } catch (Exception e16) {
            e16.printStackTrace();
            return str;
        }
    }

    protected static void saveAndCheckInfo(Handler handler, String str, File file, File file2, String str2, String str3) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file3 : listFiles) {
                if (!file3.getName().endsWith(".dat")) {
                    String encodeHexStr = MD5Coding.encodeHexStr(getBase64String(file3.getName() + file3.length() + file3.lastModified()));
                    File file4 = new File(file, "temp_" + str + ".dat");
                    if (str2 == null || !str2.equals(encodeHexStr)) {
                        saveInfo(file2, file4, encodeHexStr, str3);
                    }
                    if (handler != null) {
                        handler.post(new CheckMD5Task(file3, encodeHexStr, str3, file2, file4));
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void saveInfo(File file, File file2, String str, String str2) {
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2));
                try {
                    bufferedWriter2.write(str);
                    bufferedWriter2.newLine();
                    if (str2 != null) {
                        bufferedWriter2.write(str2);
                    }
                    close(bufferedWriter2);
                } catch (Exception e16) {
                    e = e16;
                    bufferedWriter = bufferedWriter2;
                    e.printStackTrace();
                    close(bufferedWriter);
                    if (file.exists()) {
                    }
                    file2.renameTo(file);
                } catch (Throwable th5) {
                    th = th5;
                    bufferedWriter = bufferedWriter2;
                    close(bufferedWriter);
                    throw th;
                }
            } catch (Exception e17) {
                e = e17;
            }
            if (file.exists()) {
                file.delete();
            }
            file2.renameTo(file);
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
