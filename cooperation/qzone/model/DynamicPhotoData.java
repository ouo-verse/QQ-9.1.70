package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes28.dex */
public class DynamicPhotoData implements Parcelable {
    public static final Parcelable.Creator<DynamicPhotoData> CREATOR = new Parcelable.Creator<DynamicPhotoData>() { // from class: cooperation.qzone.model.DynamicPhotoData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DynamicPhotoData createFromParcel(Parcel parcel) {
            return new DynamicPhotoData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DynamicPhotoData[] newArray(int i3) {
            return new DynamicPhotoData[i3];
        }
    };
    public String mAlbumid;
    public String mDesc;
    public String mPhotoid;
    public String mTitle;
    public String mUrl;

    public DynamicPhotoData(String str, String str2, String str3) {
        this.mAlbumid = "";
        this.mPhotoid = "";
        this.mUrl = str;
        this.mTitle = str2;
        this.mDesc = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.mUrl);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mDesc);
        parcel.writeString(this.mAlbumid);
        parcel.writeString(this.mPhotoid);
    }

    public DynamicPhotoData(String str, String str2, String str3, String str4, String str5) {
        this.mUrl = str;
        this.mTitle = str2;
        this.mDesc = str3;
        this.mAlbumid = str4;
        this.mPhotoid = str5;
    }

    public DynamicPhotoData(Parcel parcel) {
        this.mUrl = "";
        this.mTitle = "";
        this.mDesc = "";
        this.mAlbumid = "";
        this.mPhotoid = "";
        this.mUrl = parcel.readString();
        this.mTitle = parcel.readString();
        this.mDesc = parcel.readString();
        this.mAlbumid = parcel.readString();
        this.mPhotoid = parcel.readString();
    }
}
