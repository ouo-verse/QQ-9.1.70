package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FavoritesData implements Parcelable {
    public static final Parcelable.Creator<FavoritesData> CREATOR = new Parcelable.Creator<FavoritesData>() { // from class: com.tencent.qqmini.sdk.launcher.model.FavoritesData.1
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
    protected MiniAppInfo miniAppInfo;
    public String picPath;
    public String summary;
    public String title;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class FavoritesAction {
        public static final int ADD_FAVORITES = 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FavoritesData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMiniAppId() {
        return this.miniAppInfo.appId;
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
