package com.tencent.mobileqq.auto.engine.loader;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* loaded from: classes11.dex */
public class ASPluginBean implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final String TYPE_DEBUG = "TYPE_DEBUG";
    public static final String TYPE_NATIVE = "TYPE_NATIVE";
    public static final String TYPE_NET = "TYPE_NET";
    public static final long serialVersionUID = -2250766705698539904L;
    private String mBusinessKey;
    private String mConfigJsonPath;
    private String mCookie;
    private int mCrashCount;
    private boolean mIsInvalid;
    private boolean mIsReady;
    private long mManagerFileLength;
    private String mManagerFileUrl;
    private String mPluginMangerApkPath;
    private String mPluginZipPath;
    private String mQua;
    private int mSupportMinHostVersion;
    private int mSupportMinPluginVersion;
    private String mType;
    private String mUUid;
    private long mUin;
    private String mUnzipPath;
    private int mVersionCode;
    private long mZipFileLength;
    private String mZipFileUrl;

    public ASPluginBean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String getBusinessKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mBusinessKey;
    }

    public String getConfigJsonPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mConfigJsonPath;
    }

    public String getCookie() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.mCookie;
    }

    public int getCrashCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.mCrashCount;
    }

    public long getManagerFileLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Long) iPatchRedirector.redirect((short) 30, (Object) this)).longValue();
        }
        return this.mManagerFileLength;
    }

    public String getManagerFileUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.mManagerFileUrl;
    }

    public String getPluginMangerApkPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mPluginMangerApkPath;
    }

    public String getPluginZipPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mPluginZipPath;
    }

    public String getQua() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.mQua;
    }

    public int getSupportMinHostVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.mSupportMinHostVersion;
    }

    public int getSupportMinPluginVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this)).intValue();
        }
        return this.mSupportMinPluginVersion;
    }

    public String getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mType;
    }

    public String getUUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (String) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        return this.mUUid;
    }

    public long getUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Long) iPatchRedirector.redirect((short) 34, (Object) this)).longValue();
        }
        return this.mUin;
    }

    public int getVersionCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mVersionCode;
    }

    public long getZipFileLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Long) iPatchRedirector.redirect((short) 28, (Object) this)).longValue();
        }
        return this.mZipFileLength;
    }

    public String getZipFileUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.mZipFileUrl;
    }

    public boolean isInvalid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.mIsInvalid;
    }

    public boolean isReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this)).booleanValue();
        }
        return this.mIsReady;
    }

    public ASPluginBean setBusinessKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.mBusinessKey = str;
        return this;
    }

    public ASPluginBean setConfigJsonPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
        this.mConfigJsonPath = str;
        return this;
    }

    public ASPluginBean setCookie(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        }
        this.mCookie = str;
        return this;
    }

    public ASPluginBean setCrashCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 15, (Object) this, i3);
        }
        this.mCrashCount = i3;
        return this;
    }

    public ASPluginBean setInvalid(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 23, (Object) this, z16);
        }
        this.mIsInvalid = z16;
        return this;
    }

    public ASPluginBean setManagerFileLength(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 31, (Object) this, j3);
        }
        this.mManagerFileLength = j3;
        return this;
    }

    public ASPluginBean setManagerFileUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
        }
        this.mManagerFileUrl = str;
        return this;
    }

    public ASPluginBean setPluginMangerApkPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        this.mPluginMangerApkPath = str;
        return this;
    }

    public ASPluginBean setPluginZipPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        this.mPluginZipPath = str;
        return this;
    }

    public ASPluginBean setQua(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        }
        this.mQua = str;
        return this;
    }

    public ASPluginBean setReady(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 33, (Object) this, z16);
        }
        this.mIsReady = z16;
        return this;
    }

    public ASPluginBean setSupportMinHostVersion(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 17, (Object) this, i3);
        }
        this.mSupportMinHostVersion = i3;
        return this;
    }

    public void setSupportMinPluginVersion(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, i3);
        } else {
            this.mSupportMinPluginVersion = i3;
        }
    }

    public ASPluginBean setType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        this.mType = str;
        return this;
    }

    public ASPluginBean setUUid(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 39, (Object) this, (Object) str);
        }
        this.mUUid = str;
        return this;
    }

    public ASPluginBean setUin(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 35, (Object) this, j3);
        }
        this.mUin = j3;
        return this;
    }

    public ASPluginBean setUnZipPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 36, (Object) this, (Object) str);
        }
        this.mUnzipPath = str;
        return this;
    }

    public ASPluginBean setVersionCode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        this.mVersionCode = i3;
        return this;
    }

    public ASPluginBean setZipFileLength(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 29, (Object) this, j3);
        }
        this.mZipFileLength = j3;
        return this;
    }

    public ASPluginBean setZipFileUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
        }
        this.mZipFileUrl = str;
        return this;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (String) iPatchRedirector.redirect((short) 41, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer("ASPluginBean{");
        stringBuffer.append("mBusinessKey='");
        stringBuffer.append(this.mBusinessKey);
        stringBuffer.append('\'');
        stringBuffer.append(", mVersionCode=");
        stringBuffer.append(this.mVersionCode);
        stringBuffer.append(", mPluginZipPath='");
        stringBuffer.append(this.mPluginZipPath);
        stringBuffer.append('\'');
        stringBuffer.append(", mPluginMangerApkPath='");
        stringBuffer.append(this.mPluginMangerApkPath);
        stringBuffer.append('\'');
        stringBuffer.append(", mConfigJsonPath='");
        stringBuffer.append(this.mConfigJsonPath);
        stringBuffer.append('\'');
        stringBuffer.append(", mType='");
        stringBuffer.append(this.mType);
        stringBuffer.append('\'');
        stringBuffer.append(", mCrashCount=");
        stringBuffer.append(this.mCrashCount);
        stringBuffer.append(", mSupportMinHostVersion=");
        stringBuffer.append(this.mSupportMinHostVersion);
        stringBuffer.append(", mSupportMinPluginVersion=");
        stringBuffer.append(this.mSupportMinPluginVersion);
        stringBuffer.append(", mQua='");
        stringBuffer.append(this.mQua);
        stringBuffer.append('\'');
        stringBuffer.append(", mCookie='");
        stringBuffer.append(this.mCookie);
        stringBuffer.append('\'');
        stringBuffer.append(", mIsInvalid=");
        stringBuffer.append(this.mIsInvalid);
        stringBuffer.append(", mZipFileUrl='");
        stringBuffer.append(this.mZipFileUrl);
        stringBuffer.append('\'');
        stringBuffer.append(", mManagerFileUrl='");
        stringBuffer.append(this.mManagerFileUrl);
        stringBuffer.append('\'');
        stringBuffer.append(", mZipFileLength=");
        stringBuffer.append(this.mZipFileLength);
        stringBuffer.append(", mManagerFileLength=");
        stringBuffer.append(this.mManagerFileLength);
        stringBuffer.append(", mIsReady=");
        stringBuffer.append(this.mIsReady);
        stringBuffer.append(", mUin=");
        stringBuffer.append(this.mUin);
        stringBuffer.append(", mUnzipPath='");
        stringBuffer.append(this.mUnzipPath);
        stringBuffer.append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
