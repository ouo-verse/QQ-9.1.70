package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VsAppKeyBean {
    private String mPkgName;
    private String mPlatform;
    private String mSdtfrom;
    private String mVsKey;

    public VsAppKeyBean(String str, String str2, String str3, String str4) {
        this.mPlatform = str;
        this.mSdtfrom = str2;
        this.mVsKey = str3;
        this.mPkgName = str4;
    }

    public String getPkgName() {
        return this.mPkgName;
    }

    public String getPlatform() {
        return this.mPlatform;
    }

    public String getSdtfrom() {
        return this.mSdtfrom;
    }

    public String getVsKey() {
        return this.mVsKey;
    }

    public void setPkgName(String str) {
        this.mPkgName = str;
    }

    public void setPlatform(String str) {
        this.mPlatform = str;
    }

    public void setSdtfrom(String str) {
        this.mSdtfrom = str;
    }

    public void setVsKey(String str) {
        this.mVsKey = str;
    }
}
