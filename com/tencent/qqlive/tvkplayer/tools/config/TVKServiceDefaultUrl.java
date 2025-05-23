package com.tencent.qqlive.tvkplayer.tools.config;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKServiceDefaultUrl {
    private String mDeveloperUrl;
    private String mPreReleaseUrl;
    private String mReleaseUrl;
    private String mServiceName;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Builder {
        private String mDeveloperUrl;
        private String mPreReleaseUrl;
        private String mReleaseUrl;
        private String mServiceName;

        public TVKServiceDefaultUrl build() {
            return new TVKServiceDefaultUrl(this.mServiceName, this.mReleaseUrl, this.mDeveloperUrl, this.mPreReleaseUrl);
        }

        public Builder reset() {
            this.mServiceName = null;
            this.mReleaseUrl = null;
            this.mDeveloperUrl = null;
            this.mPreReleaseUrl = null;
            return this;
        }

        public Builder setDeveloperUrl(String str) {
            this.mDeveloperUrl = str;
            return this;
        }

        public Builder setPreReleaseUrl(String str) {
            this.mPreReleaseUrl = str;
            return this;
        }

        public Builder setReleaseUrl(String str) {
            this.mReleaseUrl = str;
            return this;
        }

        public Builder setServiceName(String str) {
            this.mServiceName = str;
            return this;
        }
    }

    public String getServiceName() {
        return this.mServiceName;
    }

    @Nullable
    public String getUrl(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return null;
                }
                return this.mPreReleaseUrl;
            }
            return this.mDeveloperUrl;
        }
        return this.mReleaseUrl;
    }

    TVKServiceDefaultUrl(String str, String str2, String str3, String str4) {
        this.mServiceName = str;
        this.mReleaseUrl = str2;
        this.mDeveloperUrl = str3;
        this.mPreReleaseUrl = str4;
    }

    TVKServiceDefaultUrl() {
    }
}
