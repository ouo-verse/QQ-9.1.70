package org.light.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightAIClassifier implements Parcelable {
    public static final Parcelable.Creator<LightAIClassifier> CREATOR = new Parcelable.Creator<LightAIClassifier>() { // from class: org.light.bean.LightAIClassifier.1
        @Override // android.os.Parcelable.Creator
        public LightAIClassifier createFromParcel(Parcel parcel) {
            return new LightAIClassifier(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LightAIClassifier[] newArray(int i3) {
            return new LightAIClassifier[i3];
        }
    };
    List<String> classifiers;
    int traceId;

    public LightAIClassifier(int i3, List<String> list) {
        this.traceId = i3;
        this.classifiers = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<String> getClassifiers() {
        return this.classifiers;
    }

    public int getTraceId() {
        return this.traceId;
    }

    public void readFromParcel(Parcel parcel) {
        this.traceId = parcel.readInt();
        this.classifiers = parcel.createStringArrayList();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.traceId);
        parcel.writeStringList(this.classifiers);
    }

    protected LightAIClassifier(Parcel parcel) {
        this.traceId = parcel.readInt();
        this.classifiers = parcel.createStringArrayList();
    }
}
