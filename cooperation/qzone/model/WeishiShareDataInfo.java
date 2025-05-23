package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WeishiShareDataInfo implements Parcelable {
    public static final Parcelable.Creator<WeishiShareDataInfo> CREATOR = new Parcelable.Creator<WeishiShareDataInfo>() { // from class: cooperation.qzone.model.WeishiShareDataInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeishiShareDataInfo createFromParcel(Parcel parcel) {
            return new WeishiShareDataInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeishiShareDataInfo[] newArray(int i3) {
            return new WeishiShareDataInfo[i3];
        }
    };
    public ArrayList<WeishiPictureUrl> pictureUrls;
    public String sSummary;
    public String sTitle;

    public WeishiShareDataInfo(String str, String str2, ArrayList<WeishiPictureUrl> arrayList) {
        this.sTitle = str;
        this.sSummary = str2;
        this.pictureUrls = arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.sTitle);
        parcel.writeString(this.sSummary);
        parcel.writeTypedList(this.pictureUrls);
    }

    protected WeishiShareDataInfo(Parcel parcel) {
        this.sTitle = parcel.readString();
        this.sSummary = parcel.readString();
        ArrayList<WeishiPictureUrl> arrayList = new ArrayList<>();
        this.pictureUrls = arrayList;
        parcel.readTypedList(arrayList, WeishiPictureUrl.CREATOR);
    }
}
