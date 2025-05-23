package com.tencent.upgrade.bean;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.upgrade.util.d;
import com.tencent.upgrade.util.h;
import com.vivo.push.PushClientConstants;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ApkBasicInfo implements Serializable {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ApkBasicInfo";
    private static final long serialVersionUID = 5378316823797746796L;

    @SerializedName("md5")
    private String apkMd5;

    @SerializedName(VirtualAppProxy.KEY_PKG_SIZE)
    private long apkSize;

    @SerializedName("buildNo")
    private int buildNo;

    @SerializedName("bundleId")
    private String bundleId;

    @SerializedName("diffPkg")
    private DiffPkgInfo diffPkg;

    @SerializedName("downloadUrl")
    private String downloadUrl;

    @SerializedName(PushClientConstants.TAG_PKG_NAME)
    private String packageName;

    @SerializedName("versionCode")
    private int versionCode;

    @SerializedName("version")
    private String versionName;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class CompareResult {
        private static final /* synthetic */ CompareResult[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final CompareResult EQUAL;
        public static final CompareResult LARGER;
        public static final CompareResult SMALLER;
        public static final CompareResult UNKNOWN;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7107);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            CompareResult compareResult = new CompareResult("UNKNOWN", 0);
            UNKNOWN = compareResult;
            CompareResult compareResult2 = new CompareResult("EQUAL", 1);
            EQUAL = compareResult2;
            CompareResult compareResult3 = new CompareResult("LARGER", 2);
            LARGER = compareResult3;
            CompareResult compareResult4 = new CompareResult("SMALLER", 3);
            SMALLER = compareResult4;
            $VALUES = new CompareResult[]{compareResult, compareResult2, compareResult3, compareResult4};
        }

        CompareResult(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static CompareResult valueOf(String str) {
            return (CompareResult) Enum.valueOf(CompareResult.class, str);
        }

        public static CompareResult[] values() {
            return (CompareResult[]) $VALUES.clone();
        }
    }

    public ApkBasicInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public CompareResult compareVersionName(String str, String str2) {
        CompareResult compareResult;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (CompareResult) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) str2);
        }
        CompareResult compareResult2 = CompareResult.EQUAL;
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        int i3 = 0;
        while (true) {
            if (i3 >= min) {
                break;
            }
            try {
                int intValue = Integer.valueOf(split[i3]).intValue();
                int intValue2 = Integer.valueOf(split2[i3]).intValue();
                if (intValue > intValue2) {
                    compareResult2 = CompareResult.LARGER;
                    break;
                }
                if (intValue < intValue2) {
                    compareResult2 = CompareResult.SMALLER;
                    break;
                }
                i3++;
            } catch (NumberFormatException unused) {
                return CompareResult.UNKNOWN;
            }
        }
        if (compareResult2 == CompareResult.EQUAL && split.length != split2.length) {
            if (split.length > split2.length) {
                compareResult = CompareResult.LARGER;
            } else {
                compareResult = CompareResult.SMALLER;
            }
            return compareResult;
        }
        return compareResult2;
    }

    public boolean eq(@Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, obj)).booleanValue();
        }
        if (!(obj instanceof ApkBasicInfo)) {
            return false;
        }
        ApkBasicInfo apkBasicInfo = (ApkBasicInfo) obj;
        if (getVersionCode() != apkBasicInfo.getVersionCode() || getBuildNo() != apkBasicInfo.getBuildNo()) {
            return false;
        }
        return true;
    }

    public String getApkMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.apkMd5;
    }

    public String getApkName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return getPackageName() + "_" + getVersionCode() + "_" + getBuildNo() + ".apk";
    }

    public long getApkSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.apkSize;
    }

    public int getBuildNo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.buildNo;
    }

    public String getBundleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.bundleId;
    }

    public DiffPkgInfo getDiffPkg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DiffPkgInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.diffPkg;
    }

    public String getDownloadUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.downloadUrl;
    }

    public String getFullVersionString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return h.b(getVersionName(), getVersionCode(), getBuildNo());
    }

    public String getPackageName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.packageName;
    }

    public int getVersionCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.versionCode;
    }

    public String getVersionName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.versionName;
    }

    public boolean isLaterThan(ApkBasicInfo apkBasicInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) apkBasicInfo)).booleanValue();
        }
        if (apkBasicInfo == null) {
            return true;
        }
        return isLaterThan(apkBasicInfo.getVersionCode(), apkBasicInfo.getBuildNo(), apkBasicInfo.getVersionName());
    }

    @NonNull
    public String toString() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        DiffPkgInfo diffPkgInfo = this.diffPkg;
        if (diffPkgInfo != null) {
            str = diffPkgInfo.toString();
        } else {
            str = null;
        }
        return "versionCode = " + this.versionCode + ", buildNo = " + this.buildNo + ", diffPkgInfo = " + str;
    }

    public boolean isLaterThan(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), str)).booleanValue();
        }
        boolean z16 = getVersionCode() > i3;
        boolean z17 = getVersionCode() == i3 && compareVersionName(getVersionName(), str) == CompareResult.LARGER;
        boolean z18 = getVersionCode() == i3 && getBuildNo() > i16;
        d.a(TAG, "isLaterThan isNewVersion = " + z16 + ",isNewVersionName = " + z17 + ",isNewBuildVer = " + z18);
        return z16 || z17 || z18;
    }
}
