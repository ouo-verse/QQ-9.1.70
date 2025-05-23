package com.tencent.mobileqq.mini.share.opensdk;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes15.dex */
public class OpenSdkShareModel implements Parcelable {
    public static final Parcelable.Creator<OpenSdkShareModel> CREATOR = new Parcelable.Creator<OpenSdkShareModel>() { // from class: com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OpenSdkShareModel createFromParcel(Parcel parcel) {
            return new OpenSdkShareModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OpenSdkShareModel[] newArray(int i3) {
            return new OpenSdkShareModel[i3];
        }
    };
    public String appRichId;
    public String desc;
    public String iconUrl;
    public String imageUrl;
    public String jsonStr;
    public String miniAppAppid;
    public String miniAppPath;
    public String miniAppType;
    public String title;
    public String webPageUrl;

    public OpenSdkShareModel() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.miniAppAppid);
        parcel.writeString(this.miniAppPath);
        parcel.writeString(this.webPageUrl);
        parcel.writeString(this.miniAppType);
        parcel.writeString(this.title);
        parcel.writeString(this.desc);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.appRichId);
        parcel.writeString(this.jsonStr);
    }

    protected OpenSdkShareModel(Parcel parcel) {
        this.miniAppAppid = parcel.readString();
        this.miniAppPath = parcel.readString();
        this.webPageUrl = parcel.readString();
        this.miniAppType = parcel.readString();
        this.title = parcel.readString();
        this.desc = parcel.readString();
        this.imageUrl = parcel.readString();
        this.iconUrl = parcel.readString();
        this.appRichId = parcel.readString();
        this.jsonStr = parcel.readString();
    }
}
