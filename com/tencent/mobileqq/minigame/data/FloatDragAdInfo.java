package com.tencent.mobileqq.minigame.data;

import cooperation.vip.pb.TianShuAccess;

/* compiled from: P */
/* loaded from: classes33.dex */
public class FloatDragAdInfo {
    public static final String TYPE_SCHEME = "1";
    public static final String TYPE_URL = "0";
    private TianShuAccess.AdItem adItem;
    private String appId;
    private String jumpUrl;
    private String pictureUrl;
    private int scene;
    private String sext1;
    private String sext2;
    private String sext3;
    private String tanChuang;
    private String type;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class Builder {
        private TianShuAccess.AdItem adItem;
        private String appId;
        private String jumpUrl;
        private String pictureUrl;
        private int scene;
        private String sext1;
        private String sext2;
        private String sext3;
        private String tanChuang;
        private String type;

        public Builder adItem(TianShuAccess.AdItem adItem) {
            this.adItem = adItem;
            return this;
        }

        public Builder appId(String str) {
            this.appId = str;
            return this;
        }

        public FloatDragAdInfo build() {
            return new FloatDragAdInfo(this.adItem, this.type, this.pictureUrl, this.jumpUrl, this.appId, this.scene, this.tanChuang, this.sext1, this.sext2, this.sext3);
        }

        public Builder jumpUrl(String str) {
            this.jumpUrl = str;
            return this;
        }

        public Builder pictureUrl(String str) {
            this.pictureUrl = str;
            return this;
        }

        public Builder scene(int i3) {
            this.scene = i3;
            return this;
        }

        public Builder sext1(String str) {
            this.sext1 = str;
            return this;
        }

        public Builder sext2(String str) {
            this.sext2 = str;
            return this;
        }

        public Builder sext3(String str) {
            this.sext3 = str;
            return this;
        }

        public Builder tanChuang(String str) {
            this.tanChuang = str;
            return this;
        }

        public Builder type(String str) {
            this.type = str;
            return this;
        }
    }

    FloatDragAdInfo(TianShuAccess.AdItem adItem, String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8) {
        this.adItem = adItem;
        this.type = str;
        this.pictureUrl = str2;
        this.jumpUrl = str3;
        this.appId = str4;
        this.scene = i3;
        this.tanChuang = str5;
        this.sext1 = str6;
        this.sext2 = str7;
        this.sext3 = str8;
    }

    public TianShuAccess.AdItem getAdItem() {
        return this.adItem;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getPictureUrl() {
        return this.pictureUrl;
    }

    public int getScene() {
        return this.scene;
    }

    public String getSext1() {
        return this.sext1;
    }

    public String getSext2() {
        return this.sext2;
    }

    public String getSext3() {
        return this.sext3;
    }

    public String getTanChuang() {
        return this.tanChuang;
    }

    public String getType() {
        return this.type;
    }

    public boolean isSchema() {
        return "1".equals(this.type);
    }
}
