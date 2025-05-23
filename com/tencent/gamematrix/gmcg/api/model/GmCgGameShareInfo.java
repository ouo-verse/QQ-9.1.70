package com.tencent.gamematrix.gmcg.api.model;

import com.tencent.gamematrix.gmcg.api.util.CGStringUtil;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GmCgGameShareInfo {
    private QQShareInfo mQQShareInfo;
    private String mShareMessage;
    private WXShareInfo mWXShareInfo;
    private WxMiniProgramInfo mWxMiniProgramInfo;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class QQShareInfo {
        public String defaultTypeJumpUrl;
        public String defaultTypeShareDescription;
        public String defaultTypeShareImageUrl;
        public String defaultTypeShareTitle;
        public String imageTypeShareData;
        public String qqArkInfo;
        public boolean shareToQZone;

        /* compiled from: P */
        /* loaded from: classes6.dex */
        public static class Builder {
            private String defaultTypeJumpUrl;
            private String defaultTypeShareDescription;
            private String defaultTypeShareImageUrl;
            private String defaultTypeShareTitle;
            private String imageTypeShareData;
            private String qqArkInfo;
            private boolean shareToQZone;

            public QQShareInfo build() {
                return new QQShareInfo(this);
            }

            public Builder setArkInfo(String str) {
                this.qqArkInfo = str;
                return this;
            }

            public Builder setImageTypeShareData(String str) {
                this.imageTypeShareData = str;
                return this;
            }

            public Builder setShareDescription(String str) {
                this.defaultTypeShareDescription = str;
                return this;
            }

            public Builder setShareImageUrl(String str) {
                this.defaultTypeShareImageUrl = str;
                return this;
            }

            public Builder setShareJumpUrl(String str) {
                this.defaultTypeJumpUrl = str;
                return this;
            }

            public Builder setShareTitle(String str) {
                this.defaultTypeShareTitle = str;
                return this;
            }

            public Builder setShareToZone(boolean z16) {
                this.shareToQZone = z16;
                return this;
            }
        }

        public boolean isImageShareType() {
            return CGStringUtil.notEmpty(this.imageTypeShareData);
        }

        public String toString() {
            return "QQShareInfo{shareToQZone=" + this.shareToQZone + ", imageTypeShareData='" + this.imageTypeShareData + "', defaultTypeJumpUrl='" + this.defaultTypeJumpUrl + "', defaultTypeShareTitle='" + this.defaultTypeShareTitle + "', defaultTypeShareDescription='" + this.defaultTypeShareDescription + "', defaultTypeShareImageUrl='" + this.defaultTypeShareImageUrl + "'}";
        }

        QQShareInfo(Builder builder) {
            this.shareToQZone = builder.shareToQZone;
            this.imageTypeShareData = builder.imageTypeShareData;
            this.defaultTypeJumpUrl = builder.defaultTypeJumpUrl;
            this.defaultTypeShareDescription = builder.defaultTypeShareDescription;
            this.defaultTypeShareTitle = builder.defaultTypeShareTitle;
            this.defaultTypeShareImageUrl = builder.defaultTypeShareImageUrl;
            this.qqArkInfo = builder.qqArkInfo;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class WXShareInfo {
        public String defaultTypeShareDescription;
        public String defaultTypeShareThumbUrl;
        public String defaultTypeShareTitle;
        public String defaultTypeTargetUrl;
        public int defaultTypeThumbId;
        public String imageTypeShareData;
        public boolean shareToWXCircle;

        /* compiled from: P */
        /* loaded from: classes6.dex */
        public static class Builder {
            private String defaultTypeShareDescription;
            private String defaultTypeShareThumbUrl;
            private String defaultTypeShareTitle;
            private String defaultTypeTargetUrl;
            private int defaultTypeThumbId;
            private String imageTypeShareData;
            private boolean shareToWXCircle;

            public WXShareInfo build() {
                return new WXShareInfo(this);
            }

            public Builder setShareDescription(String str) {
                this.defaultTypeShareDescription = str;
                return this;
            }

            public Builder setShareImageData(String str) {
                this.imageTypeShareData = str;
                return this;
            }

            public Builder setShareTargetUrl(String str) {
                this.defaultTypeTargetUrl = str;
                return this;
            }

            public Builder setShareThumbId(int i3) {
                this.defaultTypeThumbId = i3;
                return this;
            }

            public Builder setShareThumbUrl(String str) {
                this.defaultTypeShareThumbUrl = str;
                return this;
            }

            public Builder setShareTile(String str) {
                this.defaultTypeShareTitle = str;
                return this;
            }

            public Builder setShareToWXCircle(boolean z16) {
                this.shareToWXCircle = z16;
                return this;
            }
        }

        public boolean isImageShareType() {
            return CGStringUtil.notEmpty(this.imageTypeShareData);
        }

        public String toString() {
            return "WXShareInfo{shareToWXCircle=" + this.shareToWXCircle + ", imageTypeShareData='" + this.imageTypeShareData + "', defaultTypeTargetUrl='" + this.defaultTypeTargetUrl + "', defaultTypeShareTitle='" + this.defaultTypeShareTitle + "', defaultTypeShareDescription='" + this.defaultTypeShareDescription + "', defaultTypeShareThumbUrl='" + this.defaultTypeShareThumbUrl + "', defaultTypeThumbId=" + this.defaultTypeThumbId + '}';
        }

        WXShareInfo(Builder builder) {
            this.shareToWXCircle = builder.shareToWXCircle;
            this.imageTypeShareData = builder.imageTypeShareData;
            this.defaultTypeTargetUrl = builder.defaultTypeTargetUrl;
            this.defaultTypeShareTitle = builder.defaultTypeShareTitle;
            this.defaultTypeShareDescription = builder.defaultTypeShareDescription;
            this.defaultTypeShareThumbUrl = builder.defaultTypeShareThumbUrl;
            this.defaultTypeThumbId = builder.defaultTypeThumbId;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class WxMiniProgramInfo {
        public String miniProgramAppPackage;
        public String miniProgramPath;
        public String miniProgramShareDescription;
        public String miniProgramShareTitle;
        public String miniProgramUserName;

        /* compiled from: P */
        /* loaded from: classes6.dex */
        public static class Builder {
            private String miniProgramAppPackage;
            private String miniProgramPath;
            private String miniProgramShareDescription;
            private String miniProgramShareTitle;
            private String miniProgramUserName;

            public WxMiniProgramInfo build() {
                return new WxMiniProgramInfo(this);
            }

            public Builder setAppPackage(String str) {
                this.miniProgramAppPackage = str;
                return this;
            }

            public Builder setAppUserName(String str) {
                this.miniProgramUserName = str;
                return this;
            }

            public Builder setMiniProgramPath(String str) {
                this.miniProgramPath = str;
                return this;
            }

            public Builder setShareDescription(String str) {
                this.miniProgramShareDescription = str;
                return this;
            }

            public Builder setShareTitle(String str) {
                this.miniProgramShareTitle = str;
                return this;
            }
        }

        public String toString() {
            return "WxMiniProgramInfo{miniProgramAppPackage='" + this.miniProgramAppPackage + "', miniProgramShareTitle='" + this.miniProgramShareTitle + "', miniProgramShareDescription='" + this.miniProgramShareDescription + "', miniProgramUserName='" + this.miniProgramUserName + "', miniProgramPath='" + this.miniProgramPath + "'}";
        }

        WxMiniProgramInfo(Builder builder) {
            this.miniProgramAppPackage = builder.miniProgramAppPackage;
            this.miniProgramShareTitle = builder.miniProgramShareTitle;
            this.miniProgramShareDescription = builder.miniProgramShareDescription;
            this.miniProgramUserName = builder.miniProgramUserName;
            this.miniProgramPath = builder.miniProgramPath;
        }
    }

    public GmCgGameShareInfo(String str) {
        this.mShareMessage = str;
    }

    public QQShareInfo getQQShareInfo() {
        return this.mQQShareInfo;
    }

    public String getShareMessage() {
        return this.mShareMessage;
    }

    public WXShareInfo getWXShareInfo() {
        return this.mWXShareInfo;
    }

    public WxMiniProgramInfo getWxMiniProgramInfo() {
        return this.mWxMiniProgramInfo;
    }

    public void setQQShareInfo(QQShareInfo qQShareInfo) {
        this.mQQShareInfo = qQShareInfo;
    }

    public void setShareMessage(String str) {
        this.mShareMessage = str;
    }

    public void setWXShareInfo(WXShareInfo wXShareInfo) {
        this.mWXShareInfo = wXShareInfo;
    }

    public void setWxMiniProgramInfo(WxMiniProgramInfo wxMiniProgramInfo) {
        this.mWxMiniProgramInfo = wxMiniProgramInfo;
    }

    public String toString() {
        return "GmCgGameShareInfo{mShareMessage='" + this.mShareMessage + "', mQQShareInfo=" + this.mQQShareInfo + ", mWXShareInfo=" + this.mWXShareInfo + ", mWxMiniProgramInfo=" + this.mWxMiniProgramInfo + '}';
    }
}
