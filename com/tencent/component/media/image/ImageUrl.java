package com.tencent.component.media.image;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ImageUrl implements Parcelable {
    public static final Parcelable.Creator<ImageUrl> CREATOR = new Parcelable.Creator<ImageUrl>() { // from class: com.tencent.component.media.image.ImageUrl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageUrl createFromParcel(Parcel parcel) {
            ImageUrl imageUrl = new ImageUrl();
            imageUrl.url = parcel.readString();
            imageUrl.urlKey = parcel.readString();
            imageUrl.isSuperResolutionUrl = parcel.readInt() == 1;
            imageUrl.isHighScaleUrl = parcel.readInt() == 1;
            imageUrl.isNetWorkUrl = parcel.readInt() == 1;
            imageUrl.urlKeyHashCode = Integer.valueOf(parcel.readInt());
            imageUrl.bigUrl = parcel.readString();
            return imageUrl;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageUrl[] newArray(int i3) {
            return new ImageUrl[i3];
        }
    };
    public String bigUrl;
    public boolean isHighScaleUrl;
    public boolean isNetWorkUrl;
    public boolean isSuperResolutionUrl;
    public String url;
    public String urlKey;
    public Integer urlKeyHashCode;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.url);
        parcel.writeString(this.urlKey);
        parcel.writeInt(this.isSuperResolutionUrl ? 1 : 0);
        parcel.writeInt(this.isHighScaleUrl ? 1 : 0);
        parcel.writeInt(this.isNetWorkUrl ? 1 : 0);
        parcel.writeInt(this.urlKeyHashCode.intValue());
        parcel.writeString(this.bigUrl);
    }
}
