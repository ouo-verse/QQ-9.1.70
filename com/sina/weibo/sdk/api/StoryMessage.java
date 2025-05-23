package com.sina.weibo.sdk.api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class StoryMessage implements Parcelable {
    public static final Parcelable.Creator<StoryMessage> CREATOR = new Parcelable.Creator<StoryMessage>() { // from class: com.sina.weibo.sdk.api.StoryMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StoryMessage createFromParcel(Parcel parcel) {
            return new StoryMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StoryMessage[] newArray(int i3) {
            return new StoryMessage[i3];
        }
    };
    private Uri imageUri;
    private Uri videoUri;

    public StoryMessage() {
    }

    public boolean checkResource() {
        Uri uri = this.imageUri;
        if (uri != null && this.videoUri != null) {
            return false;
        }
        if (uri == null && this.videoUri == null) {
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Uri getImageUri() {
        return this.imageUri;
    }

    public Uri getVideoUri() {
        return this.videoUri;
    }

    public void setImageUri(Uri uri) {
        this.imageUri = uri;
    }

    public void setVideoUri(Uri uri) {
        this.videoUri = uri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.imageUri, i3);
        parcel.writeParcelable(this.videoUri, i3);
    }

    protected StoryMessage(Parcel parcel) {
        this.imageUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.videoUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }
}
