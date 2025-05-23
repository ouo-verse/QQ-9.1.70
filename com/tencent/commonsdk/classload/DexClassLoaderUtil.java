package com.tencent.commonsdk.classload;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Base64;
import android.util.Log;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
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
    static IPatchRedirector $redirector_ = null;
    private static final String INFO_FILE_SUFFIX = ".dat";
    private static final String TAG = "DexClassLoaderUtil";
    private static Handler sHandler;
    public static Looper sLooper;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class CheckMD5Task implements Runnable {
        static IPatchRedirector $redirector_;
        private final File file;
        private final String info;
        private final File infoFile;
        private final String oldMD5;
        private final File tempInfoFile;

        CheckMD5Task(File file, String str, String str2, File file2, File file3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, file, str, str2, file2, file3);
                return;
            }
            this.file = file;
            this.info = str;
            this.oldMD5 = str2;
            this.infoFile = file2;
            this.tempInfoFile = file3;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13163);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sLooper = null;
            sHandler = null;
        }
    }

    public DexClassLoaderUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void close(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e16) {
            Log.e(TAG, "closeable close failed", e16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DexClassLoader createDexClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
        BufferedReader bufferedReader;
        String str4;
        String str5;
        File[] listFiles;
        String str6;
        File[] listFiles2;
        if (sHandler == null && sLooper != null) {
            sHandler = new Handler(sLooper);
        }
        Handler handler = sHandler;
        String fileName = getFileName(str);
        String str7 = str2 + File.separator + fileName;
        File andInitOdexDir = getAndInitOdexDir(str7);
        File file = new File(andInitOdexDir, fileName + ".dat");
        if (file.isDirectory()) {
            file.delete();
        }
        BufferedReader bufferedReader2 = null;
        String str8 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                try {
                    str4 = bufferedReader.readLine();
                    if (str4 != null) {
                        try {
                            str5 = bufferedReader.readLine();
                        } catch (Exception unused) {
                            close(bufferedReader);
                            str5 = null;
                            listFiles = andInitOdexDir.listFiles();
                            int i3 = 0;
                            if (listFiles != null) {
                            }
                            str8 = str4;
                            str6 = str5;
                            DexClassLoader dexClassLoader = new DexClassLoader(str, str7, str3, classLoader);
                            listFiles2 = andInitOdexDir.listFiles();
                            if (listFiles2 != null) {
                            }
                            return dexClassLoader;
                        }
                    } else {
                        str5 = null;
                    }
                    close(bufferedReader);
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader2 = bufferedReader;
                    close(bufferedReader2);
                    throw th;
                }
            } catch (Exception unused2) {
                str4 = null;
            }
        } catch (Exception unused3) {
            bufferedReader = null;
            str4 = null;
        } catch (Throwable th6) {
            th = th6;
        }
        listFiles = andInitOdexDir.listFiles();
        int i36 = 0;
        if (listFiles != null) {
            int length = listFiles.length;
            int i16 = 0;
            while (true) {
                if (i16 >= length) {
                    break;
                }
                File file2 = listFiles[i16];
                if (file2.getName().endsWith(".dat")) {
                    i16++;
                } else {
                    String mD5String = getMD5String(file2);
                    if (str4 == null || !str4.equalsIgnoreCase(mD5String) || (str5 == null && handler != null)) {
                        file2.delete();
                        file.delete();
                        str6 = null;
                    }
                }
            }
        }
        str8 = str4;
        str6 = str5;
        DexClassLoader dexClassLoader2 = new DexClassLoader(str, str7, str3, classLoader);
        listFiles2 = andInitOdexDir.listFiles();
        if (listFiles2 != null) {
            int length2 = listFiles2.length;
            while (true) {
                if (i36 >= length2) {
                    break;
                }
                File file3 = listFiles2[i36];
                if (file3.getName().endsWith(".dat")) {
                    i36++;
                } else {
                    String mD5String2 = getMD5String(file3);
                    File file4 = new File(andInitOdexDir, "temp_" + fileName + ".dat");
                    if (str8 == null || !str8.equals(mD5String2)) {
                        saveInfo(file, file4, mD5String2, str6);
                    }
                    if (handler != null) {
                        handler.post(new CheckMD5Task(file3, mD5String2, str6, file, file4));
                    }
                }
            }
        }
        return dexClassLoader2;
    }

    private static File getAndInitOdexDir(String str) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @SuppressLint({"NewApi"})
    private static String getBase64String(String str) {
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 0);
        } catch (Exception e16) {
            Log.e(TAG, "getBase64String failed", e16);
            return str;
        }
    }

    private static String getFileName(String str) {
        int i3;
        int max = Math.max(str.lastIndexOf("\\"), str.lastIndexOf("/"));
        if (max >= 0) {
            i3 = max + 1;
        } else {
            i3 = 0;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            lastIndexOf = str.length();
        }
        return str.substring(i3, lastIndexOf);
    }

    private static String getMD5String(File file) {
        return MD5Coding.encodeHexStr(getBase64String(file.getName() + file.length() + file.lastModified()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
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
                    Log.e(TAG, "saveInfo failed", e);
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
