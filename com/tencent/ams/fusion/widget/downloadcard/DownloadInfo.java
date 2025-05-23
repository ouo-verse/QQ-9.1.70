package com.tencent.ams.fusion.widget.downloadcard;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DownloadInfo {
    static IPatchRedirector $redirector_;
    private String mAgeAppropriate;
    private String mAgreementUrl;
    private Bitmap mAppIcon;
    private String mAppIconUrl;
    private String mAppName;
    private String mAppVersion;
    private String mAuthorName;
    private String mDeveloperName;
    private long mDownloadCount;
    private Map<String, Object> mExtraInfo;
    private String mFeatureListUrl;
    private String mICP;
    private DownloadStatus mInitDownloadStatus;
    private boolean mIsAutoDownload;
    private boolean mIsCheckWifiBeforeDownload;
    private boolean mIsManualInstall;
    private boolean mIsShowCancelViewDownloadCountTv;
    private String mPermissionsUrl;

    public DownloadInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mIsAutoDownload = false;
        this.mIsManualInstall = false;
        this.mIsCheckWifiBeforeDownload = true;
        this.mIsShowCancelViewDownloadCountTv = true;
        this.mExtraInfo = new HashMap();
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DownloadInfo downloadInfo = (DownloadInfo) obj;
        if (TextUtils.equals(this.mAppName, downloadInfo.mAppName) && TextUtils.equals(this.mAppVersion, downloadInfo.mAppVersion) && TextUtils.equals(this.mAuthorName, downloadInfo.mAuthorName) && TextUtils.equals(this.mFeatureListUrl, downloadInfo.mFeatureListUrl) && TextUtils.equals(this.mAppIconUrl, downloadInfo.mAppIconUrl) && TextUtils.equals(this.mPermissionsUrl, downloadInfo.mPermissionsUrl) && TextUtils.equals(this.mAgreementUrl, downloadInfo.mAgreementUrl) && this.mIsManualInstall == downloadInfo.mIsManualInstall && this.mIsCheckWifiBeforeDownload == downloadInfo.mIsCheckWifiBeforeDownload && this.mIsAutoDownload == downloadInfo.mIsAutoDownload && this.mIsShowCancelViewDownloadCountTv == downloadInfo.mIsShowCancelViewDownloadCountTv) {
            return true;
        }
        return false;
    }

    public String getAgeAppropriate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return this.mAgeAppropriate;
    }

    public String getAgreementUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.mAgreementUrl;
    }

    public Bitmap getAppIcon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Bitmap) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.mAppIcon;
    }

    public String getAppIconUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.mAppIconUrl;
    }

    public String getAppName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.mAppName;
    }

    public String getAppVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.mAppVersion;
    }

    public String getAuthorName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.mAuthorName;
    }

    public String getDeveloperName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.mDeveloperName;
    }

    public long getDownloadCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Long) iPatchRedirector.redirect((short) 24, (Object) this)).longValue();
        }
        return this.mDownloadCount;
    }

    public Object getExtraInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return iPatchRedirector.redirect((short) 36, (Object) this, (Object) str);
        }
        if (str != null) {
            return this.mExtraInfo.get(str);
        }
        return null;
    }

    public String getFeatureListUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.mFeatureListUrl;
    }

    public String getICP() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.mICP;
    }

    public DownloadStatus getInitDownloadStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (DownloadStatus) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return this.mInitDownloadStatus;
    }

    public String getPermissionsUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return this.mPermissionsUrl;
    }

    public boolean isAutoDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this)).booleanValue();
        }
        return this.mIsAutoDownload;
    }

    public boolean isCheckWifiBeforeDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        return this.mIsCheckWifiBeforeDownload;
    }

    public boolean isManualInstall() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        return this.mIsManualInstall;
    }

    public boolean isShowCancelViewDownloadCountTv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this)).booleanValue();
        }
        return this.mIsShowCancelViewDownloadCountTv;
    }

    public void setAgeAppropriate(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.mAgeAppropriate = str;
        }
    }

    public void setAgreementUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            this.mAgreementUrl = str;
        }
    }

    public void setAppIcon(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
        } else {
            this.mAppIcon = bitmap;
        }
    }

    public void setAppIconUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.mAppIconUrl = str;
        }
    }

    public void setAppName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.mAppName = str;
        }
    }

    public void setAppVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.mAppVersion = str;
        }
    }

    public void setAuthorName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.mAuthorName = str;
        }
    }

    public void setAutoDownload(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.mIsAutoDownload = z16;
        }
    }

    public void setCheckWifiBeforeDownload(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.mIsCheckWifiBeforeDownload = z16;
        }
    }

    public void setDeveloperName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.mDeveloperName = str;
        }
    }

    public void setDownloadCount(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else {
            this.mDownloadCount = j3;
        }
    }

    public void setExtraInfo(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str, obj);
        } else if (str != null) {
            this.mExtraInfo.put(str, obj);
        }
    }

    public void setFeatureListUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.mFeatureListUrl = str;
        }
    }

    public void setICP(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.mICP = str;
        }
    }

    public void setInitDownloadStatus(DownloadStatus downloadStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) downloadStatus);
        } else {
            this.mInitDownloadStatus = downloadStatus;
        }
    }

    public void setManualInstall(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.mIsManualInstall = z16;
        }
    }

    public void setPermissionsUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.mPermissionsUrl = str;
        }
    }

    public void setShowCancelViewDownloadCountTv(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        } else {
            this.mIsShowCancelViewDownloadCountTv = z16;
        }
    }
}
