package com.tencent.qqlive.tvkplayer.moduleupdate.api;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKModuleInfo implements Serializable {
    private static final long serialVersionUID = 2;
    private String mModuleName = "";
    private String mModuleVersion = "";
    private String mArch = "";
    private String mMd5 = "";
    private String mUrl = "";
    private String mSdkVersion = "";
    private boolean mIsForceUpdate = true;

    public String getArch() {
        return this.mArch;
    }

    public String getMd5() {
        return this.mMd5;
    }

    public String getModuleName() {
        return this.mModuleName;
    }

    public String getModuleVersion() {
        return this.mModuleVersion;
    }

    public String getSdkVersion() {
        return this.mSdkVersion;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean isForceUpdate() {
        return this.mIsForceUpdate;
    }

    public void setArch(String str) {
        this.mArch = str;
    }

    public void setForceUpdate(boolean z16) {
        this.mIsForceUpdate = z16;
    }

    public void setMd5(String str) {
        this.mMd5 = str;
    }

    public void setModuleName(String str) {
        this.mModuleName = str;
    }

    public void setModuleVersion(String str) {
        this.mModuleVersion = str;
    }

    public void setSdkVersion(String str) {
        this.mSdkVersion = str;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public String toString() {
        return "TVKModuleInfo, moduleName:" + this.mModuleName + ", moduleVersion:" + this.mModuleVersion + ", arch:" + this.mArch + ", md5:" + this.mMd5 + ", url:" + this.mUrl + ", sdkVersion:" + this.mSdkVersion + ", forceUpdate:" + this.mIsForceUpdate;
    }
}
