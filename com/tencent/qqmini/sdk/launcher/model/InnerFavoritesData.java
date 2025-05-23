package com.tencent.qqmini.sdk.launcher.model;

/* compiled from: P */
/* loaded from: classes23.dex */
public class InnerFavoritesData extends FavoritesData {
    public String bizDataList;
    public String entryPath;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Builder {
        private InnerFavoritesData favoritesData = new InnerFavoritesData();

        public InnerFavoritesData build() {
            return this.favoritesData;
        }

        public Builder setAction(int i3) {
            this.favoritesData.action = i3;
            return this;
        }

        public Builder setBizDataList(String str) {
            this.favoritesData.bizDataList = str;
            return this;
        }

        public Builder setEntryPath(String str) {
            this.favoritesData.entryPath = str;
            return this;
        }

        public Builder setMiniAppInfo(MiniAppInfo miniAppInfo) {
            this.favoritesData.miniAppInfo = miniAppInfo;
            return this;
        }

        public Builder setPicPath(String str) {
            this.favoritesData.picPath = str;
            return this;
        }

        public Builder setSummary(String str) {
            this.favoritesData.summary = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.favoritesData.title = str;
            return this;
        }
    }

    public MiniAppInfo getMiniAppInfo() {
        return this.miniAppInfo;
    }

    InnerFavoritesData() {
    }
}
