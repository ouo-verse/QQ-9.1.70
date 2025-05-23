package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ChatObject extends MediaObject {
    public static final Parcelable.Creator<ChatObject> CREATOR = new Parcelable.Creator<ChatObject>() { // from class: com.sina.weibo.sdk.api.ChatObject.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ChatObject createFromParcel(Parcel parcel) {
            return new ChatObject(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ChatObject[] newArray(int i3) {
            return new ChatObject[i3];
        }
    };
    public String content;
    public String image_url;
    public String summary;
    public String url;

    public ChatObject() {
    }

    @Override // com.sina.weibo.sdk.api.MediaObject, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.sina.weibo.sdk.api.MediaObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.url);
        parcel.writeString(this.content);
        parcel.writeString(this.image_url);
        parcel.writeString(this.summary);
    }

    protected ChatObject(Parcel parcel) {
        super(parcel);
        this.url = parcel.readString();
        this.content = parcel.readString();
        this.image_url = parcel.readString();
        this.summary = parcel.readString();
    }
}
