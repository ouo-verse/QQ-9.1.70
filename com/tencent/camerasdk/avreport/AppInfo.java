package com.tencent.camerasdk.avreport;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Process;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AppInfo {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MobileBase-AppInfo";
    private static final String UNKNOWN_INFO = "unknown";
    private static ActivityManager activityManager;

    AppInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String byte2Hex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : bArr) {
            String hexString = Integer.toHexString(b16 & 255);
            if (hexString.length() == 1) {
                sb5.append("0");
            }
            sb5.append(hexString);
        }
        return sb5.toString().toUpperCase();
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static String getApkCertificate(Context context) {
        PackageManager packageManager;
        Signature[] signatureArr;
        String packageName = getPackageName(context);
        if (packageName == null || (packageManager = context.getPackageManager()) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, packageName, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length != 0) {
                return getSignature(signatureArr[0].toByteArray());
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    public static String getAppName(Context context) {
        CharSequence applicationLabel;
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (packageManager != null && applicationInfo != null && (applicationLabel = packageManager.getApplicationLabel(applicationInfo)) != null) {
                return applicationLabel.toString();
            }
        } catch (Throwable th5) {
            AVRLogUtils.e(TAG, "getAppName error", th5);
        }
        return null;
    }

    public static String getCurProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> list;
        if (context != null) {
            int myPid = Process.myPid();
            ActivityManager activityManager2 = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager2 != null) {
                try {
                    list = SystemMethodProxy.getRunningAppProcesses(activityManager2);
                } catch (Throwable th5) {
                    AVRLogUtils.e(TAG, "Exception occurred when getting process name.", th5);
                    list = null;
                }
                if (list != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
                        if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                            return runningAppProcessInfo.processName;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static Map<String, String> getManifestMetadata(Context context, Set<String> set) {
        PackageManager packageManager;
        if (context == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            packageManager = context.getPackageManager();
        } catch (Throwable th5) {
            AVRLogUtils.e(TAG, "getManifestMetaDatas error", th5);
        }
        if (packageManager == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
        if (applicationInfo.metaData != null) {
            for (String str : set) {
                Object obj = applicationInfo.metaData.get(str);
                if (obj != null) {
                    hashMap.put(str, obj.toString());
                }
            }
        }
        return hashMap;
    }

    public static PackageInfo getPackageInfo(Context context) {
        try {
            String packageName = getPackageName(context);
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return InstalledAppListMonitor.getPackageInfo(packageManager, packageName, 0);
            }
            return null;
        } catch (Throwable th5) {
            AVRLogUtils.e(TAG, "getPackageInfo error", th5);
            return null;
        }
    }

    public static String getPackageName(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable th5) {
            AVRLogUtils.e(TAG, "getPackageName error", th5);
            return "fail";
        }
    }

    public static String getProcessName(Context context, int i3) {
        FileReader fileReader;
        Throwable th5;
        try {
            fileReader = new FileReader("/proc/" + i3 + "/cmdline");
            try {
                char[] cArr = new char[512];
                fileReader.read(cArr);
                int i16 = 0;
                while (i16 < 512 && cArr[i16] != 0) {
                    i16++;
                }
                String substring = new String(cArr).substring(0, i16);
                try {
                    fileReader.close();
                } catch (Throwable unused) {
                }
                return substring;
            } catch (Throwable th6) {
                th5 = th6;
                try {
                    AVRLogUtils.e(TAG, "getProcessName error", th5);
                    String valueOf = String.valueOf(i3);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return valueOf;
                } catch (Throwable th7) {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th7;
                }
            }
        } catch (Throwable th8) {
            fileReader = null;
            th5 = th8;
        }
    }

    public static String getSignature(byte[] bArr) {
        X509Certificate x509Certificate;
        StringBuilder sb5 = new StringBuilder();
        if (bArr != null && bArr.length > 0) {
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                if (certificateFactory == null || (x509Certificate = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArr))) == null) {
                    return null;
                }
                sb5.append("Issuer|");
                Principal issuerDN = x509Certificate.getIssuerDN();
                if (issuerDN != null) {
                    sb5.append(issuerDN.toString());
                } else {
                    sb5.append("unknown");
                }
                sb5.append("\n");
                sb5.append("SerialNumber|");
                BigInteger serialNumber = x509Certificate.getSerialNumber();
                if (issuerDN != null) {
                    sb5.append(serialNumber.toString(16));
                } else {
                    sb5.append("unknown");
                }
                sb5.append("\n");
                sb5.append("NotBefore|");
                Date notBefore = x509Certificate.getNotBefore();
                if (issuerDN != null) {
                    sb5.append(notBefore.toString());
                } else {
                    sb5.append("unknown");
                }
                sb5.append("\n");
                sb5.append("NotAfter|");
                Date notAfter = x509Certificate.getNotAfter();
                if (issuerDN != null) {
                    sb5.append(notAfter.toString());
                } else {
                    sb5.append("unknown");
                }
                sb5.append("\n");
                sb5.append("SHA1|");
                String byte2Hex = byte2Hex(MessageDigest.getInstance("SHA1").digest(x509Certificate.getEncoded()));
                if (byte2Hex.length() > 0) {
                    sb5.append(byte2Hex);
                } else {
                    sb5.append("unknown");
                }
                sb5.append("\n");
                sb5.append("MD5|");
                String byte2Hex2 = byte2Hex(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(x509Certificate.getEncoded()));
                if (byte2Hex2.length() > 0) {
                    sb5.append(byte2Hex2);
                } else {
                    sb5.append("unknown");
                }
            } catch (CertificateException e16) {
                AVRLogUtils.e(TAG, "getSignature CertificateException error", e16);
            } catch (Throwable th5) {
                AVRLogUtils.e(TAG, "getSignature error", th5);
            }
        }
        if (sb5.length() == 0) {
            return "unknown";
        }
        return sb5.toString();
    }

    public static int getVersionCode(Context context) {
        PackageInfo packageInfo = getPackageInfo(context);
        if (packageInfo == null) {
            return -1;
        }
        return packageInfo.versionCode;
    }

    public static String getVersionName(Context context) {
        PackageInfo packageInfo = getPackageInfo(context);
        if (packageInfo == null) {
            return "CantGetVersionName";
        }
        return packageInfo.versionName;
    }

    public static boolean isContainPermission(Context context, String str) {
        String[] strArr;
        if (context != null && str != null && str.trim().length() > 0) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (strArr = InstalledAppListMonitor.getPackageInfo(packageManager, context.getPackageName(), 4096).requestedPermissions) != null) {
                    for (String str2 : strArr) {
                        if (str.equals(str2)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th5) {
                AVRLogUtils.e(TAG, "isContainPermission error", th5);
            }
        }
        return false;
    }

    public static boolean isLowMemory(Context context) {
        if (context == null) {
            return false;
        }
        if (activityManager == null) {
            activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            AVRLogUtils.d(TAG, "Memory is low.");
            return memoryInfo.lowMemory;
        } catch (Throwable th5) {
            AVRLogUtils.e(TAG, "isLowMemory error", th5);
            return false;
        }
    }
}
