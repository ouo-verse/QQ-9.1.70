package com.tencent.superplayer.api;

import com.tencent.qqlive.superplayer.vinfo.a;

/* loaded from: classes26.dex */
public class TVideoPlatformInfo {
    private String mAppKey;
    private String mPkgName;
    private int mPlatform;
    private String mSdtfrom;

    /* loaded from: classes26.dex */
    public static class Builder {
        private String mAppKey;
        private String mPkgName;
        private int mPlatform;
        private String mSdtfrom;

        public Builder appKey(String str) {
            this.mAppKey = str;
            return this;
        }

        public TVideoPlatformInfo build() {
            return new TVideoPlatformInfo(this);
        }

        public Builder pkgName(String str) {
            this.mPkgName = str;
            return this;
        }

        public Builder platform(int i3) {
            this.mPlatform = i3;
            return this;
        }

        public Builder sdtfrom(String str) {
            this.mSdtfrom = str;
            return this;
        }
    }

    public TVideoPlatformInfo(Builder builder) {
        this.mPlatform = builder.mPlatform;
        this.mSdtfrom = builder.mSdtfrom;
        this.mAppKey = builder.mAppKey;
        this.mPkgName = builder.mPkgName;
    }

    public static a convert(TVideoPlatformInfo tVideoPlatformInfo) {
        if (tVideoPlatformInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.f(tVideoPlatformInfo.mPlatform);
        aVar.g(tVideoPlatformInfo.mSdtfrom);
        aVar.d(tVideoPlatformInfo.mAppKey);
        aVar.e(tVideoPlatformInfo.mPkgName);
        return aVar;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getPackageName() {
        return this.mPkgName;
    }

    public int getPlatform() {
        return this.mPlatform;
    }

    public String getSdtFrom() {
        return this.mSdtfrom;
    }

    public void setAppKey(String str) {
        this.mAppKey = str;
    }

    public void setPackageName(String str) {
        this.mPkgName = str;
    }

    public void setPlatform(int i3) {
        this.mPlatform = i3;
    }

    public void setSdtfrom(String str) {
        this.mSdtfrom = str;
    }
}
