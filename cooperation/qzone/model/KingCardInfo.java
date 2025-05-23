package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class KingCardInfo implements Parcelable {
    public static final Parcelable.Creator<KingCardInfo> CREATOR = new Parcelable.Creator<KingCardInfo>() { // from class: cooperation.qzone.model.KingCardInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public KingCardInfo createFromParcel(Parcel parcel) {
            return new KingCardInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public KingCardInfo[] newArray(int i3) {
            return new KingCardInfo[i3];
        }
    };
    public String buttonTitle;
    public String jumpUrl;
    public boolean showGuide;

    public KingCardInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "KingCardInfo [showGuide=" + this.showGuide + ", buttonTitle=" + this.buttonTitle + ", jumpUrl=" + this.jumpUrl + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeByte(this.showGuide ? (byte) 1 : (byte) 0);
        parcel.writeString(this.buttonTitle);
        parcel.writeString(this.jumpUrl);
    }

    public KingCardInfo(boolean z16, String str, String str2) {
        this.showGuide = z16;
        this.buttonTitle = str;
        this.jumpUrl = str2;
    }

    protected KingCardInfo(Parcel parcel) {
        this.showGuide = parcel.readByte() != 0;
        this.buttonTitle = parcel.readString();
        this.jumpUrl = parcel.readString();
    }
}
