package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WeishiOperationInfo implements Parcelable {
    public static final Parcelable.Creator<WeishiOperationInfo> CREATOR = new Parcelable.Creator<WeishiOperationInfo>() { // from class: cooperation.qzone.model.WeishiOperationInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeishiOperationInfo createFromParcel(Parcel parcel) {
            return new WeishiOperationInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeishiOperationInfo[] newArray(int i3) {
            return new WeishiOperationInfo[i3];
        }
    };
    public String actionUrl;
    public Map<Integer, String> weishiOperationInfo;

    public WeishiOperationInfo(Map<Integer, String> map) {
        new HashMap();
        this.weishiOperationInfo = map;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeMap(this.weishiOperationInfo);
        parcel.writeString(this.actionUrl);
    }

    protected WeishiOperationInfo(Parcel parcel) {
        HashMap hashMap = new HashMap();
        this.weishiOperationInfo = hashMap;
        parcel.readMap(hashMap, Map.class.getClassLoader());
        this.actionUrl = parcel.readString();
    }
}
