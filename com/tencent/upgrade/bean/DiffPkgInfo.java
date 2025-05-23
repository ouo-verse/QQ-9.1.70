package com.tencent.upgrade.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* loaded from: classes27.dex */
public class DiffPkgInfo implements Serializable {
    static IPatchRedirector $redirector_ = null;
    private static final long serialVersionUID = -4037104677665500946L;

    @SerializedName("baseBuildNo")
    private int baseBuildNo;

    @SerializedName("baseMd5")
    private String baseMd5;

    @SerializedName(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION)
    private String baseVersion;

    @SerializedName("baseVersionCode")
    private int baseVersionCode;

    @SerializedName("diffType")
    private int diffType;

    @SerializedName("downloadUrl")
    private String downloadUrl;

    @SerializedName("md5")
    private String md5;

    @SerializedName("size")
    private long size;

    public DiffPkgInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public int getBaseBuildNo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.baseBuildNo;
    }

    public String getBaseMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.baseMd5;
    }

    public String getBaseVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.baseVersion;
    }

    public int getBaseVersionCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.baseVersionCode;
    }

    public int getDiffType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.diffType;
    }

    public String getDownloadUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.downloadUrl;
    }

    public String getMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.md5;
    }

    public long getSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.size;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "DiffPkgInfo{md5='" + this.md5 + ", downloadUrl='" + this.downloadUrl + ", size=" + this.size + ", baseMd5='" + this.baseMd5 + ", baseVersion='" + this.baseVersion + ", baseVersionCode=" + this.baseVersionCode + ", baseBuildNo=" + this.baseBuildNo + ", diffType=" + this.diffType + '}';
    }
}
