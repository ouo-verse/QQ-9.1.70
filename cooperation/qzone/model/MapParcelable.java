package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* loaded from: classes28.dex */
public class MapParcelable implements Parcelable {
    public static final Parcelable.Creator<MapParcelable> CREATOR = new Parcelable.Creator<MapParcelable>() { // from class: cooperation.qzone.model.MapParcelable.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapParcelable[] newArray(int i3) {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapParcelable createFromParcel(Parcel parcel) {
            return new MapParcelable(parcel.readHashMap(getClass().getClassLoader()));
        }
    };
    private Map<Integer, String> singleMap;

    public MapParcelable(Map<Integer, String> map) {
        this.singleMap = map;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<Integer, String> getSingleMap() {
        return this.singleMap;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeMap(this.singleMap);
    }
}
