package com.tencent.commonsdk.soload;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.commonsdk.classloaderload.b;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfix.loader.utils.RFixConstants;
import dalvik.system.BaseDexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.zip.CRC32;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SoLoadCore {
    static IPatchRedirector $redirector_ = null;
    public static final String APP_ROOT = "/data/data/com.tencent.mobileqq/files";
    private static final String CONFIGPATH = "soconfig.cfg";
    public static final int CONFIG_SO_PATH_IN_LIB = 131072;
    public static final int CONFIG_SO_PATH_IN_TXLIB = 65536;
    public static final int IF_CONFIG_SO_CRCCHECK_SUCCESS = 32768;
    public static final int IF_GENERATE_CACHE_SUCCESS = 8388608;
    public static final int IF_GET_AVAILIABLE_CRCVALUE = 4194304;
    public static final int IF_READ_CONFIGFILE_SUCCESS = 262144;
    public static final int IF_RELEASE_BY_CLASSLOADER_SUCCESS = 256;
    public static final int IF_RELEASE_BY_ZIP_CHECK_SUCCESS = 16;
    public static final int IF_RELEASE_SOFILE_CHECK_SUCCESS = 128;
    public static final int IF_SOFILE_EXIST_IN_LIBPATH = 4096;
    public static final int IF_SOFILE_IN_LIB_CHECK_SUCCESS = 2048;
    public static final int IF_SO_CONFIG_EXIST = 524288;
    public static final int IF_TRY_LOADSO_INLIBPATH_SUCCESS = 1024;
    public static final int IF_TRY_LOAD_CONFIG_SO_SUCCESS = 16384;
    public static final int IF_TRY_LOAD_LIBRARY_SUCCESS = 2097152;
    public static final int IF_TRY_LOAD_RELEASESO_SUCCESS = 64;
    public static final int IF_TRY_LOAD_SO_BY_ZIP_SUCCESS = 8;
    public static boolean IS_CPU_64_BIT = false;
    public static final int LOAD_SO_SUCCESS_SAVE_AND_RETURN = 2;
    private static final String PACKAGE_NAME = "com.tencent.mobileqq";
    public static final String PATH_LIB = "/lib/";
    public static final String PATH_TX_LIB = "/txlib/";
    public static final String TAG = "SoLoadCore";
    public static final int TRY_LOADSO_INLIBPATH_SUCCESS = 512;
    public static final int TRY_LOAD_CONFIG_SO_SUCCESS = 8192;
    public static final int TRY_LOAD_LIBRARY_SUCCESS = 1048576;
    public static final int TRY_LOAD_RELEASESO_SUCCESS = 32;
    public static final int TRY_LOAD_SO_BY_ZIP_SUCCESS = 4;
    private static HashMap<String, Long> assestCrcConfigs;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47034);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            assestCrcConfigs = null;
            IS_CPU_64_BIT = false;
        }
    }

    public SoLoadCore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void closeResource(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e16) {
            QLog.e(TAG, 1, "closeResource failed ", e16);
        }
    }

    public static boolean contentEquals(InputStream inputStream, InputStream inputStream2) throws IOException {
        if (!(inputStream instanceof BufferedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        if (!(inputStream2 instanceof BufferedInputStream)) {
            inputStream2 = new BufferedInputStream(inputStream2);
        }
        for (int read = inputStream.read(); read != -1; read = inputStream.read()) {
            if (read != inputStream2.read()) {
                return false;
            }
        }
        if (inputStream2.read() != -1) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.tencent.commonsdk.soload.MyZipFile] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    private static File createAndWriteZipFile(String str, MyZipFile myZipFile, MyZipEntry myZipEntry) {
        int read;
        String name = myZipEntry.getName();
        int lastIndexOf = name.lastIndexOf(47);
        if (lastIndexOf != -1) {
            name = name.substring(lastIndexOf + 1);
        }
        File file = new File(str + name);
        if (file.exists()) {
            file.delete();
        }
        byte[] bArr = new byte[4096];
        FileOutputStream fileOutputStream = null;
        r0 = null;
        FileOutputStream fileOutputStream2 = null;
        fileOutputStream = null;
        try {
            try {
                myZipFile = myZipFile.getInputStream(myZipEntry);
                try {
                    FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                    while (true) {
                        try {
                            read = myZipFile.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            fileOutputStream3.write(bArr, 0, read);
                        } catch (IOException e16) {
                            e = e16;
                            fileOutputStream2 = fileOutputStream3;
                            QLog.e(TAG, 1, "releaseFromApk failed", e);
                            closeResource(fileOutputStream2);
                            fileOutputStream = fileOutputStream2;
                            myZipFile = myZipFile;
                            closeResource(myZipFile);
                            return file;
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream = fileOutputStream3;
                            closeResource(fileOutputStream);
                            closeResource(myZipFile);
                            throw th;
                        }
                    }
                    closeResource(fileOutputStream3);
                    fileOutputStream = read;
                    myZipFile = myZipFile;
                } catch (IOException e17) {
                    e = e17;
                }
            } catch (IOException e18) {
                e = e18;
                myZipFile = 0;
            } catch (Throwable th6) {
                th = th6;
                myZipFile = 0;
            }
            closeResource(myZipFile);
            return file;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public static String findNativeLibraryPath(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return ((BaseDexClassLoader) context.getClassLoader()).findLibrary(str);
    }

    public static String getApkPath(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 8192);
            if (applicationInfo == null) {
                return null;
            }
            return applicationInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e16) {
            QLog.e(TAG, 1, "getApkPath failed", e16);
            return null;
        }
    }

    public static File getAppWorkFile(Context context) {
        Object obj;
        try {
            return context.getFilesDir().getParentFile();
        } catch (Exception unused) {
            try {
                if (context instanceof ContextWrapper) {
                    obj = ((ContextWrapper) context).getBaseContext();
                } else {
                    Field declaredField = ContextWrapper.class.getDeclaredField("mBase");
                    declaredField.setAccessible(true);
                    obj = declaredField.get(context);
                }
                Method declaredMethod = obj.getClass().getDeclaredMethod("getDataDirFile", new Class[0]);
                declaredMethod.setAccessible(true);
                return (File) declaredMethod.invoke(obj, new Object[0]);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "getAppWorkFile failed", th5);
                return null;
            }
        }
    }

    public static String getAppWorkPath(Context context) {
        Object obj;
        try {
            return context.getFilesDir().getParent();
        } catch (Exception unused) {
            try {
                if (context instanceof ContextWrapper) {
                    obj = ((ContextWrapper) context).getBaseContext();
                } else {
                    Field declaredField = ContextWrapper.class.getDeclaredField("mBase");
                    declaredField.setAccessible(true);
                    obj = declaredField.get(context);
                }
                Method declaredMethod = obj.getClass().getDeclaredMethod("getDataDirFile", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((File) declaredMethod.invoke(obj, new Object[0])).getAbsolutePath();
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "getAppWorkPath failed", th5);
                return null;
            }
        }
    }

    public static long getCRC32Value(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[8192];
        CRC32 crc32 = new CRC32();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                crc32.update(bArr, 0, read);
            } else {
                return crc32.getValue();
            }
        }
    }

    private static String getCurProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getApplicationContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        if (runningAppProcesses != null) {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.startsWith("com.tencent.mobileqq") && runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName + "_" + myPid;
                }
            }
            return null;
        }
        return null;
    }

    private static synchronized String getDefaultPlatformString() {
        synchronized (SoLoadCore.class) {
            String str = Build.CPU_ABI;
            if (str != null) {
                if (str.contains(IPreloadResource.ABI_64)) {
                    return "arm64-v8a";
                }
            }
            return "armeabi";
        }
    }

    @SuppressLint({"SdCardPath"})
    public static File getExistFile(Context context, String str) {
        File file = new File(context.getFilesDir(), str);
        if (!file.exists()) {
            File file2 = new File(context.getFilesDir(), str);
            if (!file2.exists()) {
                File file3 = new File(APP_ROOT, str);
                if (!file3.exists()) {
                    return null;
                }
                return file3;
            }
            return file2;
        }
        return file;
    }

    public static String getLibActualName(String str) {
        return RFixConstants.SO_PATH + str + ".so";
    }

    private static synchronized String getPlatform32String() {
        synchronized (SoLoadCore.class) {
            String str = Build.CPU_ABI;
            if (str != null && str.contains(ResourceAttributes.HostArchValues.X86)) {
                return ResourceAttributes.HostArchValues.X86;
            }
            if (str != null) {
                if (str.contains("mip")) {
                    return "mips";
                }
            }
            return "armeabi";
        }
    }

    private static synchronized String getPlatform64String() {
        synchronized (SoLoadCore.class) {
            String str = Build.CPU_ABI;
            if (str != null && str.contains("x86_64")) {
                return "x86_64";
            }
            if (str != null) {
                if (str.contains("mips64")) {
                    return "mips64";
                }
            }
            return "arm64-v8a";
        }
    }

    private static synchronized String getPlatformString() {
        synchronized (SoLoadCore.class) {
            if (IS_CPU_64_BIT) {
                return getPlatform64String();
            }
            return getPlatform32String();
        }
    }

    public static String getReleasedSoFilePath(Context context, String str) {
        ConfigStruct readConfig;
        String libActualName = getLibActualName(str);
        initAssestCrcConfigs(context);
        HashMap<String, Long> hashMap = assestCrcConfigs;
        if (hashMap != null && !hashMap.isEmpty()) {
            HashMap<String, Long> hashMap2 = assestCrcConfigs;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(getDefaultPlatformString());
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append(libActualName);
            Long l3 = hashMap2.get(sb5.toString());
            if (l3 != null) {
                long longValue = l3.longValue();
                if (longValue > 0) {
                    File file = new File((context.getFilesDir() + str2 + "soconfigs") + str2 + libActualName + PluginUtils.CONFIG_FILE_EXTEND_NAME);
                    if (file.exists() && file.isFile() && (readConfig = readConfig(file)) != null && readConfig.mCrcvalue == longValue) {
                        return readConfig.mSopath;
                    }
                }
            }
        }
        return null;
    }

    private static long getRightcrcWhenLoadSo(String str, long j3) {
        HashMap<String, Long> hashMap = assestCrcConfigs;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getPlatformString());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(str);
        Long l3 = hashMap.get(sb5.toString());
        if (l3 != null && l3.longValue() > 1) {
            j3 = l3.longValue();
        } else {
            Long l16 = assestCrcConfigs.get(getDefaultPlatformString() + str2 + str);
            if (l16 != null && l16.longValue() > 1) {
                j3 = l16.longValue();
            }
        }
        QLog.d(TAG, 1, "getRightcrcWhenLoadSo " + str + MsgSummary.STR_COLON + j3);
        return j3;
    }

    private static long getRightcrcWhenReleaseSo(String str, long j3) {
        HashMap<String, Long> hashMap = assestCrcConfigs;
        if (hashMap != null && !hashMap.isEmpty()) {
            Long l3 = assestCrcConfigs.get(getDefaultPlatformString() + File.separator + str);
            if (l3 != null) {
                j3 = l3.longValue();
            }
        }
        QLog.d(TAG, 1, "getRightcrcWhenReleaseSo " + str + MsgSummary.STR_COLON + j3);
        return j3;
    }

    private static boolean hasBaseDexClassloader() {
        try {
            Class.forName("dalvik.system.BaseDexClassLoader");
            return true;
        } catch (ClassNotFoundException e16) {
            QLog.e(TAG, 1, "dalvik.system.BaseDexClassLoader not found ", e16);
            return false;
        }
    }

    private static synchronized void initAssestCrcConfigs(Context context) {
        synchronized (SoLoadCore.class) {
            if (assestCrcConfigs != null) {
                QLog.w(TAG, 1, "assestCrcConfigs already exists");
                return;
            }
            InputStream inputStream = null;
            try {
                try {
                    assestCrcConfigs = new HashMap<>();
                    inputStream = context.getResources().getAssets().open(CONFIGPATH);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        int indexOf = readLine.indexOf(":");
                        String substring = readLine.substring(0, indexOf);
                        long parseLong = Long.parseLong(readLine.substring(indexOf + 1));
                        if (parseLong >= 1) {
                            assestCrcConfigs.put(substring, Long.valueOf(parseLong));
                        }
                    }
                    QLog.d(TAG, 1, "initAssestCrcConfigs success");
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "initAssestCrcConfigs failed", e16);
                }
            } finally {
                closeResource(inputStream);
            }
        }
    }

    public static boolean isLibExtracted(Context context, String str, String str2) {
        File existFile;
        FileInputStream fileInputStream;
        InputStream open;
        if (getExistFile(context, str) == null || (existFile = getExistFile(context, str2)) == null) {
            return false;
        }
        InputStream inputStream = null;
        try {
            open = context.getAssets().open(str2);
            try {
                fileInputStream = new FileInputStream(existFile);
            } catch (IOException e16) {
                e = e16;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
            }
        } catch (IOException e17) {
            e = e17;
            fileInputStream = null;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
        }
        try {
            boolean contentEquals = contentEquals(open, fileInputStream);
            closeResource(open);
            closeResource(fileInputStream);
            return contentEquals;
        } catch (IOException e18) {
            e = e18;
            inputStream = open;
            try {
                QLog.e(TAG, 1, "isLibExtracted failed ", e);
                closeResource(inputStream);
                closeResource(fileInputStream);
                return false;
            } catch (Throwable th7) {
                th = th7;
                closeResource(inputStream);
                closeResource(fileInputStream);
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            inputStream = open;
            closeResource(inputStream);
            closeResource(fileInputStream);
            throw th;
        }
    }

    private static boolean loadAndSave(File file, String str, long j3, File file2) {
        boolean z16 = true;
        try {
            System.load(file.getAbsolutePath());
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "System.load path = " + file.getAbsolutePath() + " suc");
            }
        } catch (UnsatisfiedLinkError e16) {
            reportThrowable(e16, str);
            QLog.e(TAG, 1, "System.load path = " + file.getAbsolutePath() + " failed", e16);
            z16 = false;
        }
        if (z16) {
            writeConfig(new ConfigStruct(j3, file.getAbsolutePath()), file2);
        }
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int loadSo(Context context, String str) {
        int i3;
        int i16;
        String str2;
        File file;
        String findNativeLibraryPath;
        File a16;
        boolean z16;
        long cRC32Value;
        QLog.d(TAG, 1, "loadSo begin, libName[" + str + "]");
        String libActualName = getLibActualName(str);
        initAssestCrcConfigs(context);
        HashMap<String, Long> hashMap = assestCrcConfigs;
        long j3 = -1;
        if (hashMap != null && !hashMap.isEmpty()) {
            j3 = getRightcrcWhenLoadSo(libActualName, -1L);
            i3 = 12582912;
        } else {
            i3 = 8388608;
        }
        int i17 = 2097152 | i3;
        try {
            System.loadLibrary(str);
            i17 |= 1048576;
            QLog.d(TAG, 1, "System.loadLibrary, lib = " + str + " suc");
            return i17;
        } catch (UnsatisfiedLinkError e16) {
            reportThrowable(e16, str);
            QLog.e(TAG, 1, "try System.loadLibrary, lib = " + str + " failed", e16);
            if (j3 < 0) {
                return i17;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(context.getFilesDir());
            String str3 = File.separator;
            sb5.append(str3);
            sb5.append("soconfigs");
            String sb6 = sb5.toString();
            new File(sb6).mkdirs();
            int i18 = i17 | 524288;
            File file2 = new File(sb6 + str3 + str + PluginUtils.CONFIG_FILE_EXTEND_NAME);
            QLog.d(TAG, 1, "soConfig path:[" + file2.getAbsolutePath() + "], exist[" + file2.exists() + "]");
            if (file2.exists()) {
                ConfigStruct readConfig = readConfig(file2);
                i18 |= 262144;
                if (readConfig == null) {
                    QLog.w(TAG, 1, "read soConfig is null!");
                } else {
                    if (readConfig.mSopath.contains(PATH_TX_LIB)) {
                        i16 = 65536;
                    } else {
                        i16 = 131072;
                    }
                    int i19 = i18 | i16;
                    File file3 = new File(readConfig.mSopath);
                    i18 = i19 | 32768;
                    str2 = libActualName;
                    if (readConfig.mCrcvalue == j3 && file3.exists()) {
                        int i26 = i18 | 16384;
                        try {
                            System.load(file3.getAbsolutePath());
                            i26 = i26 | 2 | 8192;
                            QLog.d(TAG, 1, "System.load path = " + file3.getAbsolutePath() + " suc");
                            return i26;
                        } catch (UnsatisfiedLinkError e17) {
                            i18 = i26;
                            QLog.e(TAG, 1, "System.load path = " + file3.getAbsolutePath() + " failed", e17);
                            String str4 = getAppWorkPath(context) + PATH_TX_LIB;
                            file = new File(str4);
                            if (!file.exists()) {
                            }
                            findNativeLibraryPath = findNativeLibraryPath(context, str);
                            if (findNativeLibraryPath == null) {
                            }
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("lib/");
                            sb7.append(getPlatformString());
                            sb7.append(File.separator);
                            String str5 = str2;
                            sb7.append(str5);
                            a16 = b.a(context, sb7.toString(), str4 + str5);
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append("get from resultFile[");
                            sb8.append(str5);
                            sb8.append("], res[");
                            if (a16 != null) {
                            }
                            sb8.append(z16);
                            sb8.append("]");
                            QLog.w(TAG, 1, sb8.toString());
                            int i27 = i18 | 256;
                            if (a16 != null) {
                            }
                            QLog.d(TAG, 1, "above load failed, releaseFromApk");
                            File releaseFromApk = releaseFromApk(getApkPath(context), str5, str4);
                            cRC32Value = getCRC32Value(releaseFromApk);
                            int i28 = i27 | 16;
                            if (cRC32Value == j3) {
                            }
                        }
                    }
                    String str42 = getAppWorkPath(context) + PATH_TX_LIB;
                    file = new File(str42);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    findNativeLibraryPath = findNativeLibraryPath(context, str);
                    if (findNativeLibraryPath == null) {
                        QLog.w(TAG, 1, "libSoFile not exists, which for lib: " + str);
                    } else {
                        File file4 = new File(findNativeLibraryPath);
                        i18 |= 4096;
                        QLog.d(TAG, 1, "libSoFile: [" + file4.getName() + "], path: [" + file4.getAbsolutePath() + "], exist: [" + file4.exists() + "]");
                        if (file4.exists()) {
                            i18 |= 2048;
                            long cRC32Value2 = getCRC32Value(file4);
                            if (cRC32Value2 == j3) {
                                i18 |= 1024;
                                boolean loadAndSave = loadAndSave(file4, str, cRC32Value2, file2);
                                QLog.d(TAG, 1, "loadAndSave libSoFile: " + file4.getName() + ", res[" + loadAndSave + "]");
                                if (loadAndSave) {
                                    return i18 | 2 | 512;
                                }
                            }
                        }
                    }
                    StringBuilder sb72 = new StringBuilder();
                    sb72.append("lib/");
                    sb72.append(getPlatformString());
                    sb72.append(File.separator);
                    String str52 = str2;
                    sb72.append(str52);
                    a16 = b.a(context, sb72.toString(), str42 + str52);
                    StringBuilder sb82 = new StringBuilder();
                    sb82.append("get from resultFile[");
                    sb82.append(str52);
                    sb82.append("], res[");
                    if (a16 != null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    sb82.append(z16);
                    sb82.append("]");
                    QLog.w(TAG, 1, sb82.toString());
                    int i272 = i18 | 256;
                    if (a16 != null) {
                        long cRC32Value3 = getCRC32Value(a16);
                        i272 |= 128;
                        if (cRC32Value3 == j3) {
                            i272 |= 64;
                            boolean loadAndSave2 = loadAndSave(a16, str, cRC32Value3, file2);
                            QLog.d(TAG, 1, "loadAndSave resultClassLoaderFile: " + a16.getName() + ", res[" + loadAndSave2 + "]");
                            if (loadAndSave2) {
                                return i272 | 2 | 32;
                            }
                        } else if (a16.exists()) {
                            a16.delete();
                        }
                    }
                    QLog.d(TAG, 1, "above load failed, releaseFromApk");
                    File releaseFromApk2 = releaseFromApk(getApkPath(context), str52, str42);
                    cRC32Value = getCRC32Value(releaseFromApk2);
                    int i282 = i272 | 16;
                    if (cRC32Value == j3) {
                        int i29 = i282 | 8;
                        boolean loadAndSave3 = loadAndSave(releaseFromApk2, str, cRC32Value, file2);
                        QLog.d(TAG, 1, "loadAndSave resultApkFile: " + releaseFromApk2.getName() + ", res[" + loadAndSave3 + "]");
                        if (loadAndSave3) {
                            return i29 | 2 | 4;
                        }
                        return i29;
                    }
                    return i282;
                }
            }
            str2 = libActualName;
            String str422 = getAppWorkPath(context) + PATH_TX_LIB;
            file = new File(str422);
            if (!file.exists()) {
            }
            findNativeLibraryPath = findNativeLibraryPath(context, str);
            if (findNativeLibraryPath == null) {
            }
            StringBuilder sb722 = new StringBuilder();
            sb722.append("lib/");
            sb722.append(getPlatformString());
            sb722.append(File.separator);
            String str522 = str2;
            sb722.append(str522);
            a16 = b.a(context, sb722.toString(), str422 + str522);
            StringBuilder sb822 = new StringBuilder();
            sb822.append("get from resultFile[");
            sb822.append(str522);
            sb822.append("], res[");
            if (a16 != null) {
            }
            sb822.append(z16);
            sb822.append("]");
            QLog.w(TAG, 1, sb822.toString());
            int i2722 = i18 | 256;
            if (a16 != null) {
            }
            QLog.d(TAG, 1, "above load failed, releaseFromApk");
            File releaseFromApk22 = releaseFromApk(getApkPath(context), str522, str422);
            cRC32Value = getCRC32Value(releaseFromApk22);
            int i2822 = i2722 | 16;
            if (cRC32Value == j3) {
            }
        }
    }

    private static ConfigStruct readConfig(File file) {
        BufferedReader bufferedReader;
        String readLine;
        String str;
        BufferedReader bufferedReader2 = null;
        r2 = null;
        r2 = null;
        ConfigStruct configStruct = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        } catch (Exception e16) {
            e = e16;
            bufferedReader = null;
        } catch (Throwable th5) {
            th = th5;
            closeResource(bufferedReader2);
            throw th;
        }
        try {
            try {
                readLine = bufferedReader.readLine();
            } catch (Throwable th6) {
                th = th6;
                bufferedReader2 = bufferedReader;
                closeResource(bufferedReader2);
                throw th;
            }
        } catch (Exception e17) {
            e = e17;
            QLog.e(TAG, 1, "readConfig failed ", e);
            closeResource(bufferedReader);
            return configStruct;
        }
        if (readLine != null && readLine.contains("crc")) {
            long parseLong = Long.parseLong(readLine.substring(readLine.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1));
            String readLine2 = bufferedReader.readLine();
            if (readLine2 == null || !readLine2.contains("path")) {
                str = "";
            } else {
                str = readLine2.substring(readLine2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1);
            }
            if (parseLong != -1 && str != "") {
                configStruct = new ConfigStruct(parseLong, str);
            }
            closeResource(bufferedReader);
            return configStruct;
        }
        closeResource(bufferedReader);
        return null;
    }

    public static boolean releaseDexFromApk(Context context, String str) {
        String str2;
        String str3;
        String str4;
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            str2 = filesDir.getAbsolutePath();
        } else {
            str2 = APP_ROOT;
        }
        String str5 = File.separator;
        if (!str2.endsWith(str5)) {
            str2 = str2 + str5;
        }
        new File(str2).mkdirs();
        DexReleasor dexReleasor = DexReleasor.getInstance(getApkPath(context), str2);
        int i3 = 0;
        while (true) {
            String[] strArr = DexReleasor.sExtraDexes;
            if (i3 < strArr.length) {
                if (TextUtils.equals(str, strArr[i3])) {
                    str3 = DexReleasor.sExtraJarDexes[i3];
                    str4 = DexReleasor.sExtraDexes[i3] + ".MD5";
                    break;
                }
                i3++;
            } else {
                str3 = null;
                str4 = null;
                break;
            }
        }
        String curProcessName = getCurProcessName(context);
        if (TextUtils.isEmpty(curProcessName)) {
            return false;
        }
        File releaseDex = dexReleasor.releaseDex(curProcessName, str);
        if (isLibExtracted(context, str3, str4)) {
            if (releaseDex != null && releaseDex.exists()) {
                releaseDex.delete();
            }
        } else {
            File file = new File(str2 + str3);
            if (file.exists()) {
                file.delete();
            }
            if (releaseDex == null || !releaseDex.exists()) {
                return false;
            }
            releaseDex.renameTo(file);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00fc, code lost:
    
        if (r6 == null) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File releaseFromApk(String str, String str2, String str3) {
        MyZipFile myZipFile;
        QLog.d(TAG, 1, "releaseFromApk, srcPath[" + str + "], soname[" + str2 + "], dstPath[" + str3 + "]");
        MyZipFile myZipFile2 = null;
        r0 = null;
        r0 = null;
        r0 = null;
        r0 = null;
        File file = null;
        if (str == null) {
            return null;
        }
        String str4 = File.separator;
        if (!str3.endsWith(str4)) {
            str3 = str3 + str4;
        }
        new File(str3).mkdirs();
        String str5 = "lib/" + getPlatformString() + str4;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("lib/");
        String platformString = getPlatformString();
        sb5.append(platformString);
        sb5.append(str4);
        sb5.append(str2);
        try {
            try {
                myZipFile = new MyZipFile(new File(str), sb5.toString());
            } catch (IOException e16) {
                e = e16;
                myZipFile = null;
            } catch (Throwable th5) {
                th = th5;
                if (myZipFile2 != null) {
                }
                throw th;
            }
            try {
                QLog.d(TAG, 1, "releaseFromApk,soname[" + str2 + "], zipFile[" + myZipFile + "]");
                MyZipEntry desEntry = myZipFile.getDesEntry();
                if (desEntry != null) {
                    QLog.d(TAG, 1, "releaseFromApk, mz[" + desEntry + "]");
                }
                if (desEntry != null && desEntry.getName().contains(str5) && desEntry.getName().endsWith(".so")) {
                    file = createAndWriteZipFile(str3, myZipFile, desEntry);
                }
            } catch (IOException e17) {
                e = e17;
                QLog.e(TAG, 1, "releaseFromApk failed", e);
            }
            myZipFile.closeResource();
            return file;
        } catch (Throwable th6) {
            th = th6;
            myZipFile2 = platformString;
            if (myZipFile2 != null) {
                myZipFile2.closeResource();
            }
            throw th;
        }
    }

    public static String releaseSo(Context context, String str) {
        QLog.d(TAG, 1, "releaseSo begin, libName[" + str + "]");
        String libActualName = getLibActualName(str);
        initAssestCrcConfigs(context);
        long rightcrcWhenReleaseSo = getRightcrcWhenReleaseSo(libActualName, -1L);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(context.getFilesDir());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("soconfigs");
        String sb6 = sb5.toString();
        new File(sb6).mkdirs();
        File file = new File(sb6 + str2 + libActualName + PluginUtils.CONFIG_FILE_EXTEND_NAME);
        if (file.exists() && file.isFile()) {
            ConfigStruct readConfig = readConfig(file);
            if (readConfig != null) {
                File file2 = new File(readConfig.mSopath);
                if (readConfig.mCrcvalue == rightcrcWhenReleaseSo && file2.exists()) {
                    return file2.getAbsolutePath();
                }
            }
            file.delete();
        }
        String str3 = getAppWorkPath(context) + PATH_TX_LIB;
        String str4 = getAppWorkPath(context) + PATH_LIB;
        File file3 = new File(str3);
        File file4 = new File(str4);
        if (!file3.exists()) {
            file3.mkdir();
        }
        if (!file4.exists()) {
            file4.mkdir();
        }
        File file5 = new File(str4 + libActualName);
        if (file5.exists() && file5.isFile() && getCRC32Value(file5) == rightcrcWhenReleaseSo) {
            String absolutePath = file5.getAbsolutePath();
            writeConfig(new ConfigStruct(rightcrcWhenReleaseSo, file5.getAbsolutePath()), file);
            return absolutePath;
        }
        File a16 = b.a(context, "lib/" + getPlatformString() + str2 + libActualName, str3 + libActualName);
        if (a16 == null) {
            a16 = releaseFromApk(getApkPath(context), libActualName, str3);
        }
        if (a16 != null && a16.exists()) {
            String absolutePath2 = a16.getAbsolutePath();
            writeConfig(new ConfigStruct(rightcrcWhenReleaseSo, a16.getAbsolutePath()), file);
            return absolutePath2;
        }
        return null;
    }

    private static void reportThrowable(Throwable th5, String str) {
        SoLoadReport soLoadReport = SoLoadUtilNew.sReport;
        if (soLoadReport != null) {
            soLoadReport.reportThrowable(th5, str);
        }
    }

    public static void setIsCpu64Bit(boolean z16) {
        IS_CPU_64_BIT = z16;
    }

    private static boolean writeConfig(ConfigStruct configStruct, File file) {
        BufferedWriter bufferedWriter = null;
        try {
            try {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                try {
                    bufferedWriter2.write("crcvalue=" + configStruct.mCrcvalue);
                    bufferedWriter2.newLine();
                    bufferedWriter2.write("path=" + configStruct.mSopath);
                    closeResource(bufferedWriter2);
                    return true;
                } catch (Exception e16) {
                    e = e16;
                    bufferedWriter = bufferedWriter2;
                    QLog.e(TAG, 1, "writeConfig failed ", e);
                    closeResource(bufferedWriter);
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedWriter = bufferedWriter2;
                    closeResource(bufferedWriter);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static long getCRC32Value(File file) {
        if (file != null && file.exists()) {
            FileInputStream fileInputStream = null;
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        long cRC32Value = getCRC32Value(fileInputStream2);
                        QLog.e(TAG, 1, "getCRC32Value, " + file.getName() + "[" + cRC32Value + "]");
                        closeResource(fileInputStream2);
                        return cRC32Value;
                    } catch (Exception e16) {
                        e = e16;
                        fileInputStream = fileInputStream2;
                        QLog.e(TAG, 1, "getCRC32Value failed ", e);
                        closeResource(fileInputStream);
                        return -100L;
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = fileInputStream2;
                        closeResource(fileInputStream);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e17) {
                e = e17;
            }
        } else {
            QLog.e(TAG, 1, "getCRC32Value, file not exists!");
            return -100L;
        }
    }
}
