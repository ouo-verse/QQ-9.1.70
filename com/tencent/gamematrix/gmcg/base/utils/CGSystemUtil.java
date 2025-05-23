package com.tencent.gamematrix.gmcg.base.utils;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.SystemProperties;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.RequiresApi;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileFilter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGSystemUtil {
    @RequiresApi(api = 19)
    public static String HMACSHA256(String str, String str2, String str3) {
        try {
            Mac mac = Mac.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA256);
            mac.init(new SecretKeySpec(str3.getBytes(StandardCharsets.UTF_8), KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA256));
            mac.update(str.getBytes(StandardCharsets.UTF_8));
            mac.update(str2.getBytes(StandardCharsets.UTF_8));
            byte[] doFinal = mac.doFinal();
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : doFinal) {
                sb5.append(Integer.toHexString((b16 & 255) | 256).substring(1, 3));
            }
            return sb5.toString().toUpperCase();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String encryptMd5(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.reset();
            messageDigest.update(bArr);
            for (byte b16 : messageDigest.digest()) {
                int i3 = b16 & 255;
                if (Integer.toHexString(i3).length() == 1) {
                    sb5.append("0");
                    sb5.append(Integer.toHexString(i3));
                } else {
                    sb5.append(Integer.toHexString(i3));
                }
            }
        } catch (NoSuchAlgorithmException e16) {
            e16.printStackTrace();
        }
        return sb5.toString();
    }

    public static void forceHideInputMethod(Context context, View view) {
        if (context == null) {
            CGLog.w("forceHideInputMethod, context is null!!!");
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }

    public static void forceShowInputMethod(Context context, View view) {
        if (context == null) {
            CGLog.w("forceShowInputMethod, context is null!!!");
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(view, 0);
        }
    }

    public static String getAndroidVersionString() {
        switch (Build.VERSION.SDK_INT) {
            case 23:
                return "Android 6.0";
            case 24:
                return "Android 7.0";
            case 25:
                return "Android 7.1";
            case 26:
                return "Android 8.0";
            case 27:
                return "Android 8.1";
            case 28:
                return "Android 9";
            case 29:
                return "Android 10";
            case 30:
                return "Android 11";
            case 31:
                return "Android 12";
            case 32:
                return "Android 12.1";
            default:
                return "Android " + Build.VERSION.RELEASE;
        }
    }

    public static String getAppName(Context context) {
        try {
            return context.getResources().getString(InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception e16) {
            e16.printStackTrace();
            return "GmCgSdk";
        }
    }

    public static String getAppPackageName(Context context) {
        return context.getApplicationContext().getPackageName();
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static String getAppSignMd5(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 64);
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
        }
        if (packageInfo == null) {
            CGLog.i("getAppSignMd5 packageInfo is null, context: " + context.getClass().getName());
            return "";
        }
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            return encryptMd5(signatureArr[0].toByteArray());
        }
        return "";
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static String getAppSignSHA1(Context context) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : digest) {
                String upperCase = Integer.toHexString(b16 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    sb5.append("0");
                }
                sb5.append(upperCase);
                sb5.append(":");
            }
            String sb6 = sb5.toString();
            return sb6.substring(0, sb6.length() - 1);
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e17) {
            e17.printStackTrace();
            return "";
        }
    }

    public static int getCpuCores() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.tencent.gamematrix.gmcg.base.utils.a
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    boolean lambda$getCpuCores$0;
                    lambda$getCpuCores$0 = CGSystemUtil.lambda$getCpuCores$0(file);
                    return lambda$getCpuCores$0;
                }
            }).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String getFakeDeviceId(Context context) {
        String uuid;
        String string;
        String str = (String) CGSharedPrefUtil.get(context, "pref.fake.device.id", "");
        if (CGStringUtil.isEmpty(str)) {
            try {
                string = DeviceInfoMonitor.getString(context.getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
            } catch (Exception unused) {
                uuid = UUID.randomUUID().toString();
            }
            if (!"".equals(string) && !"9774d56d682e549c".equals(string)) {
                uuid = UUID.nameUUIDFromBytes(string.getBytes(Charset.forName("utf8"))).toString();
                String str2 = uuid;
                CGSharedPrefUtil.put(context, "pref.fake.device.id", str2);
                return str2;
            }
            uuid = UUID.randomUUID().toString();
            String str22 = uuid;
            CGSharedPrefUtil.put(context, "pref.fake.device.id", str22);
            return str22;
        }
        return str;
    }

    public static View getRootView(Activity activity) {
        return activity.getWindow().getDecorView().findViewById(R.id.content);
    }

    public static String getStackTrackString() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuilder sb5 = new StringBuilder();
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb5.append(stackTraceElement.getLineNumber());
                sb5.append(MsgSummary.STR_COLON);
                sb5.append(stackTraceElement.getClassName());
                sb5.append(".");
                sb5.append(stackTraceElement.getMethodName());
                sb5.append('\n');
            }
            return sb5.toString();
        } catch (Exception e16) {
            CGLog.i("getStackTrackString error: " + e16.getMessage());
            return "";
        }
    }

    public static String getSysProperty(String str, String str2) {
        try {
            return (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(SystemProperties.class, str, "unknown");
        } catch (Exception e16) {
            e16.printStackTrace();
            return str2;
        }
    }

    public static int getTotalMemoryInGb(Context context) {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager == null) {
                return 1;
            }
            activityManager.getMemoryInfo(memoryInfo);
            return (int) (memoryInfo.totalMem / 1073741824);
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static boolean hasBluetoothConnected() {
        try {
            int profileConnectionState = BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1);
            if (profileConnectionState != 1 && profileConnectionState != 2) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isInputMethodActive(Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null) {
            return inputMethodManager.isActive();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getCpuCores$0(File file) {
        String name = file.getName();
        if (!name.startsWith("cpu")) {
            return false;
        }
        for (int i3 = 3; i3 < name.length(); i3++) {
            if (name.charAt(i3) < '0' || name.charAt(i3) > '9') {
                return false;
            }
        }
        return true;
    }
}
