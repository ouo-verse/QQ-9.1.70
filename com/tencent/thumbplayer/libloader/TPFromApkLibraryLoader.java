package com.tencent.thumbplayer.libloader;

import android.content.Context;
import android.os.SystemProperties;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes26.dex */
public final class TPFromApkLibraryLoader {
    public static final String ANDROID_OS_SYSTEM_PROPERTIES_CLASS_NAME = "android.os.SystemProperties";
    public static final String ARMEABI = "armeabi";
    private static final int BUFFER_MAX_SIZE = 2048;
    public static final String GET_METHOD = "get";
    private static final String LIB_DIR = "lib";
    private static final String LIB_PREFIX = "lib";
    private static final String LIB_SUFFIX = ".so";
    private static final ArrayList<String> LOAD_SUCCESS_LIBS = new ArrayList<>();
    private static final String PARENT_DIR = "../";
    private static final String RECOVER_LIB_DIR = "recover_lib";
    public static final String RO_PRODUCT_CPU_ABI = "ro.product.cpu.abi";
    public static final String RO_PRODUCT_CPU_ABI_2 = "ro.product.cpu.abi2";
    private static final String TAG = "TPFromApkLibraryLoader";

    private static void addToLoadSuccessList(@NonNull String str) {
        LOAD_SUCCESS_LIBS.add(str);
    }

    private static boolean extractLibrary(@NonNull ZipFile zipFile, @NonNull String str, @NonNull List<String> list, @NonNull File file) throws Exception {
        if (file.isFile()) {
            TPLogUtil.i(TAG, "library:" + str + " has already been extracted and does not need to be extracted again");
            return true;
        }
        if (list.isEmpty()) {
            TPLogUtil.w(TAG, "abi list is empty");
            return false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(RFixConstants.SO_PATH);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(list.get(0));
        sb5.append(str2);
        sb5.append(RFixConstants.SO_PATH);
        sb5.append(str);
        sb5.append(LIB_SUFFIX);
        ZipEntry entry = zipFile.getEntry(sb5.toString());
        if (entry == null) {
            TPLogUtil.w(TAG, "entry is null, not find library:" + str + " in apk");
            return false;
        }
        String name = entry.getName();
        if (!TextUtils.isEmpty(name) && name.contains(PARENT_DIR)) {
            TPLogUtil.w(TAG, "not find library:" + str + " in apk");
            return false;
        }
        InputStream inputStream = zipFile.getInputStream(entry);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[2048];
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, 2048);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    fileOutputStream.close();
                    file.setReadOnly();
                    return true;
                }
            } catch (Throwable th5) {
                inputStream.close();
                fileOutputStream.close();
                throw th5;
            }
        }
    }

    private static boolean extractLibraryFromApkToRecoverLibFile(Context context, String str, File file) {
        String str2;
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        try {
            str2 = context.getApplicationInfo().sourceDir;
            zipFile = new ZipFile(str2);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            TPLogUtil.i(TAG, "unzip apk,libName:" + str + ", apkPath:" + str2);
            if (!extractLibrary(zipFile, str, getCpuAbiList(), file)) {
                TPLogUtil.w(TAG, "Can't find recover library: " + str);
                try {
                    zipFile.close();
                } catch (IOException e16) {
                    TPLogUtil.w(TAG, "zip close exception:" + e16);
                }
                return false;
            }
            try {
                zipFile.close();
                return true;
            } catch (IOException e17) {
                TPLogUtil.w(TAG, "zip close exception:" + e17);
                return true;
            }
        } catch (Throwable th6) {
            th = th6;
            zipFile2 = zipFile;
            try {
                TPLogUtil.w(TAG, "Failed to extract library." + th);
                return false;
            } finally {
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                    } catch (IOException e18) {
                        TPLogUtil.w(TAG, "zip close exception:" + e18);
                    }
                }
            }
        }
    }

    private static List<String> getCpuAbiList() throws Exception {
        ArrayList arrayList = new ArrayList(0);
        Method method = SystemProperties.class.getMethod("get", String.class);
        String str = (String) method.invoke(null, RO_PRODUCT_CPU_ABI);
        if (str != null && str.length() > 0) {
            arrayList.add(str);
        }
        String str2 = (String) method.invoke(null, RO_PRODUCT_CPU_ABI_2);
        if (str2 != null && str2.length() > 0) {
            arrayList.add(str2);
        }
        arrayList.add("armeabi");
        return arrayList;
    }

    private static boolean isLibrarySuccessfullyLoaded(@NonNull String str) {
        return LOAD_SUCCESS_LIBS.contains(str);
    }

    private static boolean loadByReflectRuntimeLoadLibraryMethod(@NonNull String str) {
        try {
            reflectRuntimeLoadLibrary(str);
            TPLogUtil.i(TAG, "Load library using reflectRuntimeLoadLibrary,name:" + str);
            return true;
        } catch (Throwable th5) {
            TPLogUtil.w(TAG, "Failed to load library: " + str + ", " + th5);
            return false;
        }
    }

    private static boolean loadFromApk(String str, Context context, File file) {
        if (!file.isFile()) {
            TPLogUtil.i(TAG, "need extract lib:" + str + "from apk to recoverLibFile:" + file);
            if (!extractLibraryFromApkToRecoverLibFile(context, str, file)) {
                TPLogUtil.w(TAG, "failed to extract lib from apk, libName:" + str);
                return false;
            }
        }
        try {
            TPLogUtil.i(TAG, "load Library from unzip apk,libName:" + str);
            reflectRuntimeLoad(file.getAbsolutePath());
            addToLoadSuccessList(str);
            return true;
        } catch (Throwable th5) {
            TPLogUtil.w(TAG, "Failed to load library,libName:" + str + ", " + th5);
            return false;
        }
    }

    public static boolean loadLibrary(@NonNull Context context, @NonNull String str) {
        TPLogUtil.i(TAG, "load library\uff0c context:" + context + ", libName:" + str);
        if (TextUtils.isEmpty(str)) {
            TPLogUtil.w(TAG, "libName is empty");
            return false;
        }
        if (isLibrarySuccessfullyLoaded(str)) {
            TPLogUtil.i(TAG, "libName:" + str + " has load success");
            return true;
        }
        if (loadByReflectRuntimeLoadLibraryMethod(str)) {
            addToLoadSuccessList(str);
            return true;
        }
        if (!loadFromApk(str, context, new File(context.getDir(RECOVER_LIB_DIR, 0), RFixConstants.SO_PATH + str + LIB_SUFFIX))) {
            return false;
        }
        addToLoadSuccessList(str);
        return true;
    }

    private static void reflectRuntimeLoad(String str) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IllegalArgumentException, SecurityException {
        Runtime runtime = Runtime.getRuntime();
        Method declaredMethod = runtime.getClass().getDeclaredMethod("load", String.class, ClassLoader.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(runtime, str, TPFromApkLibraryLoader.class.getClassLoader());
    }

    private static void reflectRuntimeLoadLibrary(String str) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IllegalArgumentException, SecurityException {
        Runtime runtime = Runtime.getRuntime();
        Method declaredMethod = runtime.getClass().getDeclaredMethod("loadLibrary", String.class, ClassLoader.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(runtime, str, TPFromApkLibraryLoader.class.getClassLoader());
    }
}
