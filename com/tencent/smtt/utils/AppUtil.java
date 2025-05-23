package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsPrivacyAccess;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes25.dex */
public class AppUtil {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f369610a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f369611b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f369612c = false;
    public static String mAndroidID = "";
    public static String mCpu = "";
    public static String mDeviceModel = "";
    public static String mImsi = "";
    public static String mMac = "";
    public static String mSDKUID = "";

    private static String a(String str) {
        return str == null ? "" : str;
    }

    public static String getAndroidID(Context context) {
        return "";
    }

    public static int getAndroidVersion(Context context) {
        if (TbsPrivacyAccess.AndroidVersion.isDisabled()) {
            return 0;
        }
        return Build.VERSION.SDK_INT;
    }

    public static String getAppMetadata(Context context, String str) {
        String str2 = null;
        try {
            str2 = String.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str));
            return String.valueOf(Integer.toHexString(Integer.parseInt(str2)));
        } catch (Exception unused) {
            return str2;
        }
    }

    public static String getAppPkgName(Context context) {
        try {
            return context.getPackageName();
        } catch (Exception unused) {
            return null;
        }
    }

    public static int getAppVersionCode(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String getAppVersionName(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getCurrentNativeLibraryDir(Context context) {
        String str = context.getApplicationInfo().nativeLibraryDir;
        TbsLog.i("AppUtil", "[getCurrentNativeLibraryDir] -- nativeLibraryDir is:" + str);
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0065, code lost:
    
        if (r3 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getDeviceCpuabi() {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        String a16;
        if (!f369611b) {
            String str = null;
            try {
                inputStreamReader = new InputStreamReader(RuntimeMonitor.exec(Runtime.getRuntime(), "getprop ro.product.cpu.abi").getInputStream());
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader = null;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedReader = null;
                inputStreamReader = null;
            }
            try {
                if (bufferedReader.readLine().contains(ResourceAttributes.HostArchValues.X86)) {
                    a16 = a("i686");
                } else {
                    a16 = a(System.getProperty("os.arch"));
                }
                if (a16 != null) {
                    mCpu = a16;
                }
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th7) {
                th = th7;
                try {
                    str = a(System.getProperty("os.arch"));
                    th.printStackTrace();
                    if (str != null) {
                        mCpu = str;
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused2) {
                        }
                    }
                } finally {
                }
            }
            try {
                inputStreamReader.close();
            } catch (IOException unused3) {
                f369611b = true;
                return mCpu;
            }
        }
        return mCpu;
    }

    public static String getDeviceModel(Context context) {
        if (TbsPrivacyAccess.DeviceModel.isDisabled()) {
            return "";
        }
        if (!f369612c) {
            String a16 = r.a(context);
            try {
                mDeviceModel = new String(a16.getBytes("UTF-8"), "ISO8859-1");
            } catch (Exception unused) {
                mDeviceModel = a16;
            }
            f369612c = true;
        }
        return mDeviceModel;
    }

    public static String getGuid(Context context) {
        try {
            return TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_GUID, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getImsi(Context context) {
        return "";
    }

    public static String getMacAddress(Context context) {
        return GlobalUtil.DEFAULT_MAC_ADDRESS;
    }

    public static String getSDKUID(Context context) {
        if (!f369610a) {
            try {
                if (TextUtils.isEmpty(mSDKUID)) {
                    mSDKUID = l.a(context);
                }
            } catch (Exception e16) {
                TbsLog.i(e16);
            }
            f369610a = true;
        }
        return mSDKUID;
    }

    public static String getSHA256Signature(Context context) {
        try {
            Signature[] signatureArr = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 64).signatures;
            if (signatureArr.length > 0) {
                Signature signature = signatureArr[0];
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
                messageDigest.update(signature.toByteArray());
                return Base64.encodeToString(messageDigest.digest(), 2);
            }
            return null;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006b A[Catch: all -> 0x007e, TryCatch #6 {all -> 0x007e, blocks: (B:42:0x005a, B:44:0x006b, B:46:0x0077), top: B:41:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x004d -> B:15:0x005a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getSignatureFromApk(Context context, boolean z16, File file) {
        String a16;
        RandomAccessFile randomAccessFile;
        String str;
        if (file == null || (r2 = file.exists()) == 0) {
            return "";
        }
        if (z16) {
            ?? exists = 0;
            RandomAccessFile randomAccessFile2 = null;
            exists = 0;
            try {
            } catch (IOException e16) {
                e16.printStackTrace();
                exists = exists;
            }
            try {
                try {
                    byte[] bArr = new byte[2];
                    randomAccessFile = new RandomAccessFile(file, "r");
                    try {
                        randomAccessFile.read(bArr);
                        str = new String(bArr);
                    } catch (Exception e17) {
                        e = e17;
                        randomAccessFile2 = randomAccessFile;
                        e.printStackTrace();
                        randomAccessFile2.close();
                        exists = randomAccessFile2;
                        if (context.getApplicationContext().getPackageName().contains("com.jd.jrapp")) {
                        }
                        TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #4");
                        a16 = a(context, file);
                        TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  android api signature=" + a16);
                        if (a16 != null) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        exists = randomAccessFile;
                        try {
                            exists.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Exception e19) {
                    e = e19;
                }
                if (!str.equalsIgnoreCase("PK")) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e26) {
                        e26.printStackTrace();
                    }
                    return "";
                }
                randomAccessFile.close();
                exists = str;
            } catch (Throwable th6) {
                th = th6;
            }
        }
        try {
            if (context.getApplicationContext().getPackageName().contains("com.jd.jrapp")) {
                TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #1");
                String a17 = a(file);
                if (a17 != null) {
                    TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #2");
                    return a17;
                }
            }
        } catch (Throwable unused) {
            TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #3");
        }
        TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #4");
        a16 = a(context, file);
        TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  android api signature=" + a16);
        if (a16 != null) {
            String a18 = a(file);
            TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  java get signature=" + a18);
            return a18;
        }
        return a16;
    }

    public static boolean hasExternalStoragePermission(Context context) {
        if (context == null || context.checkCallingOrSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) != 0) {
            return false;
        }
        return true;
    }

    public static boolean is64BitImpl() {
        Class<?> cls;
        Method declaredMethod;
        Object invoke;
        Method declaredMethod2;
        try {
            cls = Class.forName("dalvik.system.VMRuntime");
            declaredMethod = cls.getDeclaredMethod("getRuntime", new Class[0]);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (declaredMethod == null || (invoke = declaredMethod.invoke(null, new Object[0])) == null || (declaredMethod2 = cls.getDeclaredMethod("is64Bit", new Class[0])) == null) {
            return false;
        }
        Object invoke2 = declaredMethod2.invoke(invoke, new Object[0]);
        if (invoke2 instanceof Boolean) {
            return ((Boolean) invoke2).booleanValue();
        }
        return false;
    }

    public static boolean isCpuValid() {
        Matcher matcher;
        try {
            matcher = Pattern.compile("i686|mips|x86_64|x86").matcher(mCpu);
        } catch (Exception unused) {
            matcher = null;
        }
        return matcher == null || !matcher.find();
    }

    public static void saveGuid(Context context, String str) {
        try {
            TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_GUID, str);
            tbsDownloadConfig.commit();
        } catch (Exception unused) {
        }
    }

    public static void setSDKUID(String str, boolean z16) {
        if (z16) {
            mSDKUID = l.a(str);
        } else {
            mSDKUID = str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028 A[Catch: Exception -> 0x002d, TRY_LEAVE, TryCatch #0 {Exception -> 0x002d, blocks: (B:3:0x0004, B:5:0x0014, B:7:0x0018, B:9:0x001b, B:11:0x0028, B:16:0x001f), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(Context context, File file) {
        Signature signature;
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 65);
            if (packageArchiveInfo != null) {
                Signature[] signatureArr = packageArchiveInfo.signatures;
                if (signatureArr != null && signatureArr.length > 0) {
                    signature = signatureArr[0];
                    if (signature == null) {
                        return signature.toCharsString();
                    }
                    return null;
                }
                TbsLog.w("AppUtil", "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!");
            }
            signature = null;
            if (signature == null) {
            }
        } catch (Exception unused) {
            TbsLog.i("AppUtil", "getSign " + file + "failed");
            return null;
        }
    }

    public static boolean isCpuValid(String str) {
        Matcher matcher;
        try {
            matcher = Pattern.compile("i686|mips|x86_64|x86").matcher(str);
        } catch (Exception unused) {
            matcher = null;
        }
        return matcher == null || !matcher.find();
    }

    private static String a(File file) {
        try {
            JarFile jarFile = new JarFile(file);
            byte[] bArr = new byte[8192];
            String a16 = a(a(jarFile, jarFile.getJarEntry("AndroidManifest.xml"), bArr)[0].getEncoded());
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                if (name != null) {
                    Certificate[] a17 = a(jarFile, nextElement, bArr);
                    String a18 = a17 != null ? a(a17[0].getEncoded()) : null;
                    if (a18 == null) {
                        if (!name.startsWith("META-INF/")) {
                            return null;
                        }
                    } else if (!a18.equals(a16)) {
                        return null;
                    }
                }
            }
            return a16;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) throws Exception {
        InputStream inputStream = jarFile.getInputStream(jarEntry);
        do {
        } while (inputStream.read(bArr, 0, bArr.length) != -1);
        inputStream.close();
        if (jarEntry != null) {
            return jarEntry.getCertificates();
        }
        return null;
    }

    private static String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length * 2];
        for (int i3 = 0; i3 < length; i3++) {
            byte b16 = bArr[i3];
            int i16 = (b16 >> 4) & 15;
            int i17 = i3 * 2;
            cArr[i17] = (char) (i16 >= 10 ? (i16 + 97) - 10 : i16 + 48);
            int i18 = b16 & RegisterType.DOUBLE_HI;
            cArr[i17 + 1] = (char) (i18 >= 10 ? (i18 + 97) - 10 : i18 + 48);
        }
        return new String(cArr);
    }
}
