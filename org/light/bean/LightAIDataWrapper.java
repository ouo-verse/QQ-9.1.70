package org.light.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightAIDataWrapper implements Parcelable {
    public static final Parcelable.Creator<LightAIDataWrapper> CREATOR = new Parcelable.Creator<LightAIDataWrapper>() { // from class: org.light.bean.LightAIDataWrapper.1
        @Override // android.os.Parcelable.Creator
        public LightAIDataWrapper createFromParcel(Parcel parcel) {
            return new LightAIDataWrapper(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LightAIDataWrapper[] newArray(int i3) {
            return new LightAIDataWrapper[i3];
        }
    };
    public static final int DATA_TYPE_BOTH = 6;
    public static final int DATA_TYPE_NONE = 0;
    public static final int DATA_TYPE_OBJ = 4;
    public static final int DATA_TYPE_STR = 2;
    HashMap<String, LightAIData> aiDataMap;

    public LightAIDataWrapper() {
        this.aiDataMap = new HashMap<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LightAIData getAIData(String str) {
        return this.aiDataMap.get(str);
    }

    public HashMap<String, LightAIData> getAiDataMap() {
        return this.aiDataMap;
    }

    public void readFromParcel(Parcel parcel) {
        this.aiDataMap = (HashMap) parcel.readSerializable();
    }

    public void setAIData(String str, LightAIData lightAIData) {
        this.aiDataMap.put(str, lightAIData);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeSerializable(this.aiDataMap);
    }

    protected LightAIDataWrapper(Parcel parcel) {
        this.aiDataMap = (HashMap) parcel.readSerializable();
    }
}
