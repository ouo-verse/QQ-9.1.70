package org.light;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MaterialConfig implements Parcelable {
    public static final Parcelable.Creator<MaterialConfig> CREATOR = new Parcelable.Creator<MaterialConfig>() { // from class: org.light.MaterialConfig.1
        @Override // android.os.Parcelable.Creator
        public MaterialConfig createFromParcel(Parcel parcel) {
            return new MaterialConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public MaterialConfig[] newArray(int i3) {
            return new MaterialConfig[i3];
        }
    };
    public static final int SourceType_MultiMedia = 2;
    public static final int SourceType_Photo = 1;
    public static final int SourceType_Video = 0;
    public HashMap<String, String> aiFilterList;
    public int clipAssetCount;
    public String description;
    public String key;
    public int minImageHeight;
    public int minImageWidth;
    public int minVideoDuration;
    public int type;

    public MaterialConfig(String str, int i3, int i16, int i17, int i18, int i19, HashMap<String, String> hashMap, String str2) {
        this.key = str;
        this.type = i3;
        this.clipAssetCount = i16;
        this.minVideoDuration = i17;
        this.minImageHeight = i18;
        this.minImageWidth = i19;
        this.aiFilterList = hashMap;
        this.description = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.key);
        parcel.writeInt(this.type);
        parcel.writeInt(this.aiFilterList.size());
        List<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, String> entry : this.aiFilterList.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList.add(entry.getValue());
        }
        parcel.writeStringList(arrayList);
        parcel.writeInt(this.clipAssetCount);
        parcel.writeInt(this.minVideoDuration);
        parcel.writeInt(this.minImageHeight);
        parcel.writeInt(this.minImageWidth);
        parcel.writeString(this.description);
    }

    protected MaterialConfig(Parcel parcel) {
        this.key = "";
        this.type = 0;
        this.clipAssetCount = 0;
        this.minVideoDuration = 0;
        this.minImageHeight = 0;
        this.minImageWidth = 0;
        this.description = "";
        this.key = parcel.readString();
        this.type = parcel.readInt();
        ArrayList arrayList = new ArrayList(parcel.readInt());
        parcel.readStringList(arrayList);
        this.aiFilterList = new HashMap<>();
        for (int i3 = 0; i3 < arrayList.size(); i3 += 2) {
            this.aiFilterList.put(arrayList.get(i3), arrayList.get(i3 + 1));
        }
        this.clipAssetCount = parcel.readInt();
        this.minVideoDuration = parcel.readInt();
        this.minImageHeight = parcel.readInt();
        this.minImageWidth = parcel.readInt();
        this.description = parcel.readString();
    }
}
