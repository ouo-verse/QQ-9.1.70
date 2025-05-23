package com.huawei.secure.android.common.sign;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.secure.android.common.util.LogsUtil;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class HiPkgSignManager {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37855a = "HiPkgSignManager";

    private static PackageInfo a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageArchiveInfo(str, 64);
            }
            return null;
        } catch (Exception e16) {
            LogsUtil.e(f37855a, "Exception : " + e16.getMessage(), true);
            return null;
        }
    }

    private static String b(byte[] bArr) {
        try {
            return a(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256).digest(bArr));
        } catch (NoSuchAlgorithmException e16) {
            LogsUtil.e(f37855a, "NoSuchAlgorithmException" + e16.getMessage());
            return "";
        }
    }

    public static boolean doCheckArchiveApk(Context context, String str, String str2, String str3) {
        PackageInfo a16;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || context == null || TextUtils.isEmpty(str3) || (a16 = a(context, str2)) == null) {
            return false;
        }
        String b16 = b(a16.signatures[0].toByteArray());
        String str4 = a16.packageName;
        if (!str.equalsIgnoreCase(b16) || !str3.equals(str4)) {
            return false;
        }
        return true;
    }

    public static boolean doCheckInstalled(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && context != null) {
            return str.equalsIgnoreCase(getInstalledAppHash(context, str2));
        }
        return false;
    }

    public static boolean doCheckInstalledV2V3(Context context, List<String> list, String str) {
        List<String> installedAppHashV2V3;
        if (TextUtils.isEmpty(str) || list == null || context == null || (installedAppHashV2V3 = getInstalledAppHashV2V3(context, str)) == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toUpperCase(Locale.ENGLISH));
        }
        Iterator<String> it5 = installedAppHashV2V3.iterator();
        while (it5.hasNext()) {
            if (!arrayList.contains(it5.next())) {
                return false;
            }
        }
        return true;
    }

    public static byte[] getInstalledAPPSignature(Context context, String str) {
        PackageInfo packageInfo;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, str, 64)) != null) {
                    return packageInfo.signatures[0].toByteArray();
                }
            } catch (PackageManager.NameNotFoundException e16) {
                LogsUtil.e(f37855a, "PackageManager.NameNotFoundException : " + e16.getMessage(), true);
            } catch (Exception e17) {
                LogsUtil.e(f37855a, "Exception : " + e17.getMessage(), true);
            }
            return new byte[0];
        }
        LogsUtil.e(f37855a, "packageName is null or context is null");
        return new byte[0];
    }

    public static String getInstalledAppHash(Context context, String str) {
        byte[] installedAPPSignature = getInstalledAPPSignature(context, str);
        if (installedAPPSignature != null && installedAPPSignature.length > 0) {
            return b(installedAPPSignature);
        }
        return "";
    }

    public static List<String> getInstalledAppHashV2V3(Context context, String str) {
        PackageManager packageManager;
        Signature[] signatureArr;
        SigningInfo signingInfo;
        SigningInfo signingInfo2;
        boolean hasMultipleSigners;
        SigningInfo signingInfo3;
        Signature[] signingCertificateHistory;
        SigningInfo signingInfo4;
        Signature[] apkContentsSigners;
        try {
            packageManager = context.getPackageManager();
        } catch (Throwable unused) {
        }
        if (Build.VERSION.SDK_INT >= 28) {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, str, 134217728);
            if (packageInfo != null) {
                signingInfo = packageInfo.signingInfo;
                if (signingInfo != null) {
                    signingInfo2 = packageInfo.signingInfo;
                    hasMultipleSigners = signingInfo2.hasMultipleSigners();
                    if (hasMultipleSigners) {
                        signingInfo4 = packageInfo.signingInfo;
                        apkContentsSigners = signingInfo4.getApkContentsSigners();
                        return a(apkContentsSigners);
                    }
                    signingInfo3 = packageInfo.signingInfo;
                    signingCertificateHistory = signingInfo3.getSigningCertificateHistory();
                    return a(signingCertificateHistory);
                }
            }
            return null;
        }
        PackageInfo packageInfo2 = InstalledAppListMonitor.getPackageInfo(packageManager, str, 64);
        if (packageInfo2 != null && (signatureArr = packageInfo2.signatures) != null && signatureArr.length != 0 && signatureArr[0] != null) {
            return a(signatureArr);
        }
        return null;
    }

    public static String getUnInstalledAPPPackageName(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            PackageInfo a16 = a(context, str);
            if (a16 == null) {
                return "";
            }
            return a16.packageName;
        }
        LogsUtil.e(f37855a, "archiveFilePath is null or context is null");
        return "";
    }

    public static byte[] getUnInstalledAPPSignature(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            PackageInfo a16 = a(context, str);
            if (a16 != null) {
                Signature signature = a16.signatures[0];
                if (signature != null) {
                    return signature.toByteArray();
                }
            } else {
                LogsUtil.e(f37855a, "PackageInfo is null ");
            }
            return new byte[0];
        }
        LogsUtil.e(f37855a, "archiveFilePath is null or context is null");
        return new byte[0];
    }

    public static String getUnInstalledAppHash(Context context, String str) {
        byte[] unInstalledAPPSignature = getUnInstalledAPPSignature(context, str);
        if (unInstalledAPPSignature != null && unInstalledAPPSignature.length > 0) {
            return b(unInstalledAPPSignature);
        }
        return "";
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < length; i3++) {
            byte b16 = bArr[i3];
            if ((b16 & 255) < 16) {
                stringBuffer.append("0" + Integer.toHexString(bArr[i3] & 255));
            } else {
                stringBuffer.append(Integer.toHexString(b16 & 255));
            }
        }
        return stringBuffer.toString().toUpperCase(Locale.ENGLISH);
    }

    private static List<String> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        if (signatureArr != null && signatureArr.length != 0) {
            for (Signature signature : signatureArr) {
                arrayList.add(b(signature.toByteArray()));
            }
        }
        return arrayList;
    }
}
