package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WeishiInterestInfo implements Parcelable {
    public static final Parcelable.Creator<WeishiInterestInfo> CREATOR = new Parcelable.Creator<WeishiInterestInfo>() { // from class: cooperation.qzone.model.WeishiInterestInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeishiInterestInfo createFromParcel(Parcel parcel) {
            return new WeishiInterestInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeishiInterestInfo[] newArray(int i3) {
            return new WeishiInterestInfo[i3];
        }
    };
    public String desc;
    public ArrayList<Long> uinList;

    public WeishiInterestInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeList(this.uinList);
        parcel.writeString(this.desc);
    }

    protected WeishiInterestInfo(Parcel parcel) {
        this.uinList = parcel.readArrayList(Long.class.getClassLoader());
        this.desc = parcel.readString();
    }
}
