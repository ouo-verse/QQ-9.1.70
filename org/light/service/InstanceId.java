package org.light.service;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class InstanceId implements Parcelable {
    public static final Parcelable.Creator<InstanceId> CREATOR = new Parcelable.Creator<InstanceId>() { // from class: org.light.service.InstanceId.1
        @Override // android.os.Parcelable.Creator
        public InstanceId createFromParcel(Parcel parcel) {
            return new InstanceId(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public InstanceId[] newArray(int i3) {
            return new InstanceId[i3];
        }
    };

    /* renamed from: id, reason: collision with root package name */
    public int f423839id;

    public InstanceId(int i3) {
        this.f423839id = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f423839id);
    }

    protected InstanceId(Parcel parcel) {
        this.f423839id = 0;
        this.f423839id = parcel.readInt();
    }
}
