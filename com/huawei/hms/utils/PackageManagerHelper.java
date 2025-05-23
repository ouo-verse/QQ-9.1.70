package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.AndroidException;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* loaded from: classes2.dex */
public class PackageManagerHelper {

    /* renamed from: a, reason: collision with root package name */
    private final PackageManager f37705a;

    /* loaded from: classes2.dex */
    public enum PackageStates {
        ENABLED,
        DISABLED,
        NOT_INSTALLED,
        SPOOF
    }

    public PackageManagerHelper(Context context) {
        this.f37705a = context.getPackageManager();
    }

    private byte[] a(String str) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(this.f37705a, str, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0) {
                return signatureArr[0].toByteArray();
            }
        } catch (AndroidException e16) {
            HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e16.getMessage());
        } catch (RuntimeException e17) {
            HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint.", e17);
        }
        HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
        return new byte[0];
    }

    public String getApplicationName(String str) {
        try {
            return this.f37705a.getApplicationLabel(this.f37705a.getApplicationInfo(str, 128)).toString();
        } catch (AndroidException | RuntimeException unused) {
            HMSLog.e("PackageManagerHelper", "Failed to get application name for " + str);
            return null;
        }
    }

    public long getPackageFirstInstallTime(String str) {
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(this.f37705a, str, 128);
            if (packageInfo == null) {
                return 0L;
            }
            return packageInfo.firstInstallTime;
        } catch (AndroidException | RuntimeException unused) {
            return 0L;
        }
    }

    public String getPackageSignature(String str) {
        byte[] a16 = a(str);
        if (a16 != null && a16.length != 0) {
            return HEX.encodeHexString(SHA256.digest(a16), true);
        }
        return null;
    }

    public PackageStates getPackageStates(String str) {
        if (TextUtils.isEmpty(str)) {
            return PackageStates.NOT_INSTALLED;
        }
        try {
            if (this.f37705a.getApplicationInfo(str, 128).enabled) {
                return PackageStates.ENABLED;
            }
            return PackageStates.DISABLED;
        } catch (AndroidException | RuntimeException unused) {
            HMSLog.e("PackageManagerHelper", "in getPackageStates, getApplicationInfo threw an exception");
            return PackageStates.NOT_INSTALLED;
        }
    }

    public int getPackageVersionCode(String str) {
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(this.f37705a, str, 16);
            if (packageInfo == null) {
                return 0;
            }
            return packageInfo.versionCode;
        } catch (AndroidException e16) {
            HMSLog.e("PackageManagerHelper", "get PackageVersionCode failed " + e16);
            return 0;
        } catch (RuntimeException e17) {
            HMSLog.e("PackageManagerHelper", "get PackageVersionCode failed", e17);
            return 0;
        }
    }

    public String getPackageVersionName(String str) {
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(this.f37705a, str, 16);
            if (packageInfo != null) {
                String str2 = packageInfo.versionName;
                if (str2 != null) {
                    return str2;
                }
            }
            return "";
        } catch (AndroidException unused) {
            return "";
        } catch (RuntimeException e16) {
            HMSLog.e("PackageManagerHelper", "get getPackageVersionName failed", e16);
            return "";
        }
    }

    public boolean hasProvider(String str, String str2) {
        ProviderInfo[] providerInfoArr;
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(this.f37705a, str, 8);
            if (packageInfo != null && (providerInfoArr = packageInfo.providers) != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if (str2.equals(providerInfo.authority)) {
                        return true;
                    }
                }
            }
        } catch (AndroidException | RuntimeException unused) {
        }
        return false;
    }

    public boolean isPackageFreshInstall(String str) {
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(this.f37705a, str, 128);
            if (packageInfo == null) {
                return false;
            }
            if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                return false;
            }
            return true;
        } catch (AndroidException | RuntimeException unused) {
            return false;
        }
    }

    public boolean verifyPackageArchive(String str, String str2, String str3) {
        PackageInfo packageInfo;
        InputStream inputStream = null;
        try {
            packageInfo = this.f37705a.getPackageArchiveInfo(str, 64);
        } catch (Exception e16) {
            HMSLog.e("PackageManagerHelper", "getPackageArchiveInfo Exception. " + e16.getMessage());
            packageInfo = null;
        }
        if (packageInfo != null && packageInfo.signatures.length > 0) {
            try {
                if (!str2.equals(packageInfo.packageName)) {
                    return false;
                }
                try {
                    inputStream = IOUtils.toInputStream(packageInfo.signatures[0].toByteArray());
                    return str3.equalsIgnoreCase(HEX.encodeHexString(SHA256.digest(CertificateFactory.getInstance("X.509").generateCertificate(inputStream).getEncoded()), true));
                } catch (IOException | CertificateException e17) {
                    HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e17.getMessage());
                }
            } finally {
                IOUtils.closeQuietly((InputStream) null);
            }
        }
        return false;
    }
}
