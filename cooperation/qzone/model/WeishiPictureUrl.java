package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes28.dex */
public class WeishiPictureUrl implements Parcelable {
    public static final Parcelable.Creator<WeishiPictureUrl> CREATOR = new Parcelable.Creator<WeishiPictureUrl>() { // from class: cooperation.qzone.model.WeishiPictureUrl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeishiPictureUrl createFromParcel(Parcel parcel) {
            return new WeishiPictureUrl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeishiPictureUrl[] newArray(int i3) {
            return new WeishiPictureUrl[i3];
        }
    };
    public int key;
    public PictureUrl pictureUrl;

    public WeishiPictureUrl() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.key);
        parcel.writeParcelable(this.pictureUrl, i3);
    }

    public WeishiPictureUrl(int i3, PictureUrl pictureUrl) {
        this.key = i3;
        this.pictureUrl = pictureUrl;
    }

    protected WeishiPictureUrl(Parcel parcel) {
        this.key = parcel.readInt();
        this.pictureUrl = (PictureUrl) parcel.readParcelable(PictureUrl.class.getClassLoader());
    }
}
