package com.tencent.qqmini.sdk.launcher.core.model;

import cooperation.vip.pb.TianShuAccess;

/* loaded from: classes23.dex */
public class PendantAdInfo {
    public static final String SHOULD_PENDANT_SHOW = "1";
    public static final String TYPE_SCHEMA = "1";
    public static final String TYPE_URL = "0";
    public static final String WEBVIEW_AUTO_POPUP = "1";
    private String absTimeRemovePendant;
    private String absTimeShowPendant;
    private String activeId;
    private TianShuAccess.AdItem adItem;
    private String appId;
    private String autoPopUpWebview;
    private String autoWebviewDelay;
    private String jumpUrl;
    private String numMaxConsumption;
    private String pendantUrl;
    private String pictureUrl;
    private String popUpTime;
    private int scene;
    private String showPendant;
    private String staticPendantUrl;
    private String type;

    /* loaded from: classes23.dex */
    public static class Builder {
        private String absTimeRemovePendant;
        private String absTimeShowPendant;
        private String activeId;
        private TianShuAccess.AdItem adItem;
        private String appId;
        private String autoPopUpWebview;
        private String autoWebviewDelay;
        private String jumpUrl;
        private String numMaxConsumption;
        private String pendantUrl;
        private String pictureUrl;
        private String popUpTime;
        private int scene;
        private String showPendant;
        private String staticPendantUrl;
        private String type;

        public Builder absTimeRemovePendant(String str) {
            this.absTimeRemovePendant = str;
            return this;
        }

        public Builder absTimeShowPendant(String str) {
            this.absTimeShowPendant = str;
            return this;
        }

        public Builder activeId(String str) {
            this.activeId = str;
            return this;
        }

        public Builder adItem(TianShuAccess.AdItem adItem) {
            this.adItem = adItem;
            return this;
        }

        public Builder appId(String str) {
            this.appId = str;
            return this;
        }

        public Builder autoPopUpWebview(String str) {
            this.autoPopUpWebview = str;
            return this;
        }

        public Builder autoWebviewDelay(String str) {
            this.autoWebviewDelay = str;
            return this;
        }

        public PendantAdInfo build() {
            return new PendantAdInfo(this.adItem, this.type, this.pictureUrl, this.pendantUrl, this.staticPendantUrl, this.jumpUrl, this.appId, this.scene, this.autoPopUpWebview, this.popUpTime, this.autoWebviewDelay, this.showPendant, this.absTimeShowPendant, this.absTimeRemovePendant, this.numMaxConsumption, this.activeId);
        }

        public Builder jumpUrl(String str) {
            this.jumpUrl = str;
            return this;
        }

        public Builder numMaxConsumption(String str) {
            this.numMaxConsumption = str;
            return this;
        }

        public Builder pendantUrl(String str) {
            this.pendantUrl = str;
            return this;
        }

        public Builder pictureUrl(String str) {
            this.pictureUrl = str;
            return this;
        }

        public Builder popUpTime(String str) {
            this.popUpTime = str;
            return this;
        }

        public Builder scene(int i3) {
            this.scene = i3;
            return this;
        }

        public Builder showPendant(String str) {
            this.showPendant = str;
            return this;
        }

        public Builder staticPendantUrl(String str) {
            this.staticPendantUrl = str;
            return this;
        }

        public Builder type(String str) {
            this.type = str;
            return this;
        }
    }

    public String getAbsTimeRemovePendant() {
        return this.absTimeRemovePendant;
    }

    public String getAbsTimeShowPendant() {
        return this.absTimeShowPendant;
    }

    public String getActiveId() {
        return this.activeId;
    }

    public TianShuAccess.AdItem getAdItem() {
        return this.adItem;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAutoPopUpWebview() {
        return this.autoPopUpWebview;
    }

    public String getAutoWebviewDelay() {
        return this.autoWebviewDelay;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getNumMaxConsumption() {
        return this.numMaxConsumption;
    }

    public String getPendantUrl() {
        return this.pendantUrl;
    }

    public String getPictureUrl() {
        return this.pictureUrl;
    }

    public String getPopUpTime() {
        return this.popUpTime;
    }

    public int getScene() {
        return this.scene;
    }

    public String getShowPendant() {
        return this.showPendant;
    }

    public String getStaticPendantUrl() {
        return this.staticPendantUrl;
    }

    public String getType() {
        return this.type;
    }

    public boolean isSchema() {
        return "1".equals(this.type);
    }

    public void setCurrentAvailableConsumption(String str) {
        this.numMaxConsumption = str;
    }

    public boolean shouldPendantShow() {
        return "1".equals(this.showPendant);
    }

    public boolean shouldWebviewAutoPopup() {
        return "1".equals(this.autoPopUpWebview);
    }

    PendantAdInfo(TianShuAccess.AdItem adItem, String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.adItem = adItem;
        this.type = str;
        this.pictureUrl = str2;
        this.pendantUrl = str3;
        this.staticPendantUrl = str4;
        this.jumpUrl = str5;
        this.appId = str6;
        this.scene = i3;
        this.autoPopUpWebview = str7;
        this.popUpTime = str8;
        this.autoWebviewDelay = str9;
        this.showPendant = str10;
        this.absTimeShowPendant = str11;
        this.absTimeRemovePendant = str12;
        this.numMaxConsumption = str13;
        this.activeId = str14;
    }
}
