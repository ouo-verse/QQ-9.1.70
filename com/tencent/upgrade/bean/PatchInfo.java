package com.tencent.upgrade.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.vivo.push.PushClientConstants;
import java.io.Serializable;

/* loaded from: classes27.dex */
public class PatchInfo implements Serializable {
    static IPatchRedirector $redirector_ = null;
    private static final long serialVersionUID = -3235076507304669256L;

    @SerializedName("baseBuildNo")
    private int baseBuildNo;

    @SerializedName("baseMd5")
    private String baseMd5;

    @SerializedName(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION)
    private String baseVersion;

    @SerializedName("baseVersionCode")
    private int baseVersionCode;

    @SerializedName("buildNo")
    private int buildNo;

    @SerializedName("downloadUrl")
    private String downloadUrl;

    @SerializedName("md5")
    private String md5;

    @SerializedName(PushClientConstants.TAG_PKG_NAME)
    private String pkgName;

    @SerializedName(VirtualAppProxy.KEY_PKG_SIZE)
    private long pkgSize;

    @SerializedName("version")
    private String version;

    @SerializedName("versionCode")
    private int versionCode;

    public PatchInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public int getBaseBuildNo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.baseBuildNo;
    }

    public String getBaseMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.baseMd5;
    }

    public String getBaseVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.baseVersion;
    }

    public int getBaseVersionCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.baseVersionCode;
    }

    public int getBuildNo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.buildNo;
    }

    public String getDownloadUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.downloadUrl;
    }

    public String getMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.md5;
    }

    public String getPkgName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.pkgName;
    }

    public long getPkgSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return this.pkgSize;
    }

    public String getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.version;
    }

    public int getVersionCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.versionCode;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "PatchInfo{pkgName='" + this.pkgName + "', md5='" + this.md5 + "', version='" + this.version + "', versionCode=" + this.versionCode + ", buildNo=" + this.buildNo + ", baseMd5='" + this.baseMd5 + "', baseVersion='" + this.baseVersion + "', baseVersionCode=" + this.baseVersionCode + ", baseBuildNo=" + this.baseBuildNo + ", downloadUrl='" + this.downloadUrl + "', pkgSize=" + this.pkgSize + '}';
    }
}
