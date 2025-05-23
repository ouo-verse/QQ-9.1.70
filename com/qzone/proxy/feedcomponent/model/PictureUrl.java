package com.qzone.proxy.feedcomponent.model;

import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageUrl;

/* loaded from: classes39.dex */
public class PictureUrl implements SmartParcelable {

    @NeedParcel
    public int enlargeRate;

    @NeedParcel
    public int height;

    @NeedParcel
    public ImageUrl imageUrl;

    @NeedParcel
    public int pictureType;

    @NeedParcel
    public float pivotXRate;

    @NeedParcel
    public float pivotYRate;

    @NeedParcel
    public String url;

    @NeedParcel
    public int width;

    @NeedParcel
    public long size = 0;

    @NeedParcel
    public String md5 = "";

    public PictureUrl() {
    }

    public static ImageUrl calculateAvaterImageUrl(String str) {
        ImageUrl imageUrl = new ImageUrl();
        imageUrl.urlKey = str;
        imageUrl.url = str;
        ImageManager.isNetworkUrl(str);
        imageUrl.isHighScaleUrl = false;
        imageUrl.isNetWorkUrl = false;
        String str2 = imageUrl.urlKey;
        imageUrl.urlKeyHashCode = Integer.valueOf(str2 != null ? str2.hashCode() : -1);
        return imageUrl;
    }

    public static ImageUrl calculateImageUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ImageUrl imageUrl = new ImageUrl();
        imageUrl.url = str;
        boolean isNetworkUrl = ImageManager.isNetworkUrl(str);
        imageUrl.isNetWorkUrl = isNetworkUrl;
        String urlKey = ImageKey.getUrlKey(str, isNetworkUrl, imageUrl.isHighScaleUrl);
        imageUrl.urlKey = urlKey;
        imageUrl.urlKeyHashCode = Integer.valueOf(urlKey != null ? urlKey.hashCode() : -1);
        imageUrl.bigUrl = str;
        return imageUrl;
    }

    public boolean contains(String str) {
        String str2 = this.url;
        if (str2 == null) {
            return false;
        }
        return str2.equalsIgnoreCase(str);
    }

    public boolean isGif() {
        return this.pictureType == 2;
    }

    public void readFrom(Parcel parcel) {
        this.url = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.pictureType = parcel.readInt();
        this.enlargeRate = parcel.readInt();
        this.size = parcel.readLong();
        this.md5 = parcel.readString();
        this.imageUrl = calculateImageUrl(this.url);
    }

    public String toString() {
        return "PictureUrl [url=" + this.url + ", width=" + this.width + ", height=" + this.height + ", pictureType=" + this.pictureType + ", size=" + this.size + ", md5=" + this.md5 + "]";
    }

    public void writeTo(Parcel parcel) {
        parcel.writeString(this.url);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.pictureType);
        parcel.writeInt(this.enlargeRate);
        parcel.writeLong(this.size);
        parcel.writeString(this.md5);
    }

    public static boolean isEmpty(PictureUrl pictureUrl) {
        return pictureUrl == null || TextUtils.isEmpty(pictureUrl.url);
    }

    public PictureUrl(String str, int i3, int i16) {
        this.url = str;
        this.width = i3;
        this.height = i16;
        this.imageUrl = calculateImageUrl(str);
    }
}
