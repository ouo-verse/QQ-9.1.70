package com.tencent.mobileqq.mini.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

/* compiled from: P */
/* loaded from: classes33.dex */
public class FavoritesData implements Parcelable {
    public static final Parcelable.Creator<FavoritesData> CREATOR = new Parcelable.Creator<FavoritesData>() { // from class: com.tencent.mobileqq.mini.model.FavoritesData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FavoritesData createFromParcel(Parcel parcel) {
            return new FavoritesData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FavoritesData[] newArray(int i3) {
            return new FavoritesData[i3];
        }
    };
    protected static final String TAG = "FavoritesData";
    public int action;
    public String bizDataList;
    public String entryPath;
    protected MiniAppInfo miniAppInfo;
    public String picPath;
    public String summary;
    public String title;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class Builder {
        private FavoritesData favoritesData = new FavoritesData();

        public FavoritesData build() {
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

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class FavoritesAction {
        public static final int ADD_FAVORITES = 1;
    }

    protected FavoritesData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMiniAppId() {
        return this.miniAppInfo.appId;
    }

    public MiniAppInfo getMiniAppInfo() {
        return this.miniAppInfo;
    }

    public String getMiniAppName() {
        return this.miniAppInfo.name;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.title);
        parcel.writeString(this.summary);
        parcel.writeString(this.picPath);
        parcel.writeParcelable(this.miniAppInfo, 0);
        parcel.writeInt(this.action);
    }

    public FavoritesData(Parcel parcel) {
        this.title = parcel.readString();
        this.summary = parcel.readString();
        this.picPath = parcel.readString();
        this.miniAppInfo = (MiniAppInfo) parcel.readParcelable(MiniAppInfo.class.getClassLoader());
        this.action = parcel.readInt();
    }
}
