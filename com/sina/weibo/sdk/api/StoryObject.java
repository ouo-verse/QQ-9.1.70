package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class StoryObject implements Parcelable {
    public static final Parcelable.Creator<StoryObject> CREATOR = new Parcelable.Creator<StoryObject>() { // from class: com.sina.weibo.sdk.api.StoryObject.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StoryObject createFromParcel(Parcel parcel) {
            return new StoryObject(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StoryObject[] newArray(int i3) {
            return new StoryObject[i3];
        }
    };
    public String appId;
    public String appPackage;
    public String callbackAction;
    public String sourcePath;
    public int sourceType;

    public StoryObject() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.sourcePath);
        parcel.writeInt(this.sourceType);
        parcel.writeString(this.appId);
        parcel.writeString(this.appPackage);
        parcel.writeString(this.callbackAction);
    }

    protected StoryObject(Parcel parcel) {
        this.sourcePath = parcel.readString();
        this.sourceType = parcel.readInt();
        this.appId = parcel.readString();
        this.appPackage = parcel.readString();
        this.callbackAction = parcel.readString();
    }
}
