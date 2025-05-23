package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: classes28.dex */
public class PictureUrl implements Parcelable {
    public static final Parcelable.Creator<PictureUrl> CREATOR = new Parcelable.Creator<PictureUrl>() { // from class: cooperation.qzone.model.PictureUrl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PictureUrl createFromParcel(Parcel parcel) {
            PictureUrl pictureUrl = new PictureUrl();
            pictureUrl.url = parcel.readString();
            pictureUrl.width = parcel.readInt();
            pictureUrl.height = parcel.readInt();
            pictureUrl.pictureType = parcel.readInt();
            pictureUrl.pivotXRate = parcel.readFloat();
            pictureUrl.pivotYRate = parcel.readFloat();
            pictureUrl.enlarge_rate = parcel.readInt();
            return pictureUrl;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PictureUrl[] newArray(int i3) {
            return new PictureUrl[i3];
        }
    };
    public int enlarge_rate;
    public int height;
    public int pictureType;
    public float pivotXRate;
    public float pivotYRate;
    public String url;
    public int width;

    public PictureUrl() {
    }

    public static boolean isEmpty(PictureUrl pictureUrl) {
        if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
            return false;
        }
        return true;
    }

    public boolean contains(String str) {
        String str2 = this.url;
        if (str2 == null) {
            return false;
        }
        return str2.equalsIgnoreCase(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isGif() {
        if (this.pictureType == 2) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "PictureUrl [url=" + this.url + ", width=" + this.width + ", height=" + this.height + ", pictureType=" + this.pictureType + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.url);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.pictureType);
        parcel.writeFloat(this.pivotXRate);
        parcel.writeFloat(this.pivotYRate);
        parcel.writeInt(this.enlarge_rate);
    }

    public PictureUrl(String str, int i3, int i16) {
        this.url = str;
        this.width = i3;
        this.height = i16;
    }
}
