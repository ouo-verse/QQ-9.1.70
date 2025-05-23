package com.tencent.mobileqq.qfix;

import android.content.Context;
import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Keep;
import com.tencent.mobileqq.commonutils.classloader.SystemClassLoaderInjector;
import com.tencent.mobileqq.commonutils.zip.QZipFile;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;

/* compiled from: P */
/* loaded from: classes16.dex */
public class Relax {
    public static final int APPLY_KITKAT_ERROR = 5;
    public static final int K_APPLY_DISABLED = 6;
    public static final int K_APPLY_FILE_ERROR = 8;
    public static final int K_APPLY_INIT_ERROR = 2;
    public static final int K_APPLY_INJECT_ERROR = 1;
    public static final int K_APPLY_NO_SUCH_METHOD = 7;
    public static final int K_APPLY_PRELOAD_CLEAN_ERROR = 3;
    public static final int K_APPLY_RELAX_DISABLE_STUB_ASSERT_ERROR = 10;
    public static final int K_APPLY_RELAX_DISABLE_STUB_ERROR = 9;
    public static final int K_APPLY_RELAX_ERROR = 4;
    public static final int K_APPLY_SUCCESS = 0;
    public static final String K_CONFIG_FILE = "config.txt";
    public static final String K_PATCH_DEX = "classes.dex";
    public static final String TAG = "PatchLogTag";
    public static final String[] K_PATCH_SO = {"lib/armeabi-v7a/librelax.so", "lib/armeabi/librelax.so"};
    private static boolean sEnableLogFile = true;
    private static String sLogPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/rfix/log/";

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes16.dex */
    public @interface ApplyResult {
    }

    /* compiled from: P */
    @Keep
    /* loaded from: classes16.dex */
    class D {
        D() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class RelaxHolder {
        private static final Relax sInstance = new Relax();

        RelaxHolder() {
        }
    }

    static {
        try {
            getInstance();
        } catch (Throwable th5) {
            Log.e("PatchLogTag", "static initializer: ", th5);
        }
    }

    Relax() {
    }

    public static int apply(Context context, File file, File file2, File file3, boolean z16) {
        File file4 = new File(file3, "config.txt");
        if (!file4.exists()) {
            return 8;
        }
        String[] strArr = K_PATCH_SO;
        int length = strArr.length;
        boolean z17 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            File file5 = new File(file3, strArr[i3]);
            if (file5.exists()) {
                Log.d("PatchLogTag", "load relax from local: " + file5.getAbsolutePath());
                System.load(file5.getAbsolutePath());
                z17 = true;
                break;
            }
            i3++;
        }
        return apply(context, file, file2, new FileInputStream(file4), z17, z16);
    }

    protected static int applyInternal(Context context, File file, File file2, InputStream inputStream, boolean z16, boolean z17) {
        if (file.isFile() && file2.isDirectory()) {
            if (!z16) {
                System.loadLibrary("relax");
            }
            if (!"Success".equals(SystemClassLoaderInjector.inject(context, file.getAbsolutePath(), file2.getAbsolutePath(), (String) null, false))) {
                return 1;
            }
            ClassLoader classLoader = Relax.class.getClassLoader();
            try {
                Method declaredMethod = C.class.getDeclaredMethod("a", new Class[0]);
                Method declaredMethod2 = C.class.getDeclaredMethod("b", new Class[0]);
                byte[] bytes = getBytes(inputStream);
                configLogNative(sEnableLogFile, sLogPath);
                int relax = relax(context, declaredMethod, declaredMethod2, classLoader, file2, bytes, z17);
                if (relax != 0) {
                    Log.d("PatchLogTag", "applyRelaxPatch failed, unloadResult=" + SystemClassLoaderInjector.unloadDexElement(context, 0));
                }
                return relax;
            } catch (NoSuchMethodException e16) {
                e16.printStackTrace();
                return 7;
            }
        }
        return 8;
    }

    public static void configLog(boolean z16, String str) {
        sEnableLogFile = z16;
        sLogPath = str;
    }

    private static native void configLogNative(boolean z16, String str);

    public static void copy(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (IOException unused) {
                    }
                }
            }
            inputStream.close();
            try {
                fileOutputStream.close();
            } catch (IOException unused2) {
            }
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream2 = fileOutputStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
            throw th;
        }
    }

    private static byte[] getBytes(InputStream inputStream) {
        BufferedInputStream bufferedInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            bufferedInputStream = new BufferedInputStream(inputStream);
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = null;
        }
        try {
            byte[] bArr = new byte[4000];
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, 4000);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.write(0);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                bufferedInputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            return byteArray;
        } catch (Throwable th6) {
            th = th6;
            try {
                th.printStackTrace();
                return null;
            } finally {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
            }
        }
    }

    public static Relax getInstance() {
        return RelaxHolder.sInstance;
    }

    static String prettyApplyResult(int i3) {
        switch (i3) {
            case 0:
                return "ApplySuccess";
            case 1:
                return "ApplyInjectError";
            case 2:
                return "ApplyInitError";
            case 3:
                return "ApplyPreloadCleanError";
            case 4:
                return "ApplyRelaxError";
            case 5:
                return "ApplyKitkatError";
            case 6:
                return "ApplyDisabled";
            case 7:
                return "ApplyNoSuchMethod";
            case 8:
                return "ApplyFileError";
            case 9:
                return "DisableStubError";
            case 10:
                return "DisableStubAssertError";
            default:
                return "unknown";
        }
    }

    private static native int relax(Context context, Method method, Method method2, ClassLoader classLoader, File file, byte[] bArr, boolean z16);

    static void unzipRelaxConfig(String str, QZipFile qZipFile) {
        ZipEntry entry = qZipFile.getEntry("config.txt");
        if (entry != null) {
            Log.d("PatchLogTag", "pre-unzip patch config files..");
            copy(qZipFile.getInputStream(entry), new File(str, "config.txt"));
        }
        for (String str2 : K_PATCH_SO) {
            ZipEntry entry2 = qZipFile.getEntry(str2);
            if (entry2 != null) {
                Log.d("PatchLogTag", "pre-unzip patch so: " + str2);
                copy(qZipFile.getInputStream(entry2), new File(str, str2));
            }
        }
    }

    public int applyPatch(Context context, File file, File file2, InputStream inputStream, boolean z16) {
        return apply(context, file, file2, inputStream, z16);
    }

    public static int apply(Context context, File file, File file2, InputStream inputStream, boolean z16) {
        return apply(context, file, file2, inputStream, z16, true);
    }

    public static void unzipRelaxConfig(String str, String str2) {
        QZipFile qZipFile = null;
        try {
            try {
                QZipFile qZipFile2 = new QZipFile(str);
                try {
                    unzipRelaxConfig(str2, qZipFile2);
                    qZipFile2.close();
                } catch (Throwable th5) {
                    th = th5;
                    qZipFile = qZipFile2;
                    try {
                        th.printStackTrace();
                        if (qZipFile != null) {
                            qZipFile.close();
                        }
                    } catch (Throwable th6) {
                        if (qZipFile != null) {
                            try {
                                qZipFile.close();
                            } catch (IOException e16) {
                                e16.printStackTrace();
                            }
                        }
                        throw th6;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (IOException e17) {
            e17.printStackTrace();
        }
    }

    public static int apply(Context context, File file, File file2, InputStream inputStream, boolean z16, boolean z17) {
        SystemClock.uptimeMillis();
        int applyInternal = applyInternal(context, file, file2, inputStream, z16, z17);
        Log.i("PatchLogTag", "apply: applyResult = " + applyInternal + ", " + prettyApplyResult(applyInternal));
        return applyInternal;
    }

    /* compiled from: P */
    @Keep
    /* loaded from: classes16.dex */
    static class AssertDisableInstallStubsForClass {
        AssertDisableInstallStubsForClass() {
        }

        @Keep
        public static void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Keep
    /* loaded from: classes16.dex */
    public class C {
        C() {
        }

        @Keep
        private void a() {
        }

        @Keep
        private void b() {
        }
    }
}
