package com.tencent.shadow.dynamic.host;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class NotFoundException extends Exception implements Parcelable {
    public static final Parcelable.Creator<NotFoundException> CREATOR = new Parcelable.Creator<NotFoundException>() { // from class: com.tencent.shadow.dynamic.host.NotFoundException.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotFoundException createFromParcel(Parcel parcel) {
            return new NotFoundException(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotFoundException[] newArray(int i3) {
            return new NotFoundException[i3];
        }
    };

    public NotFoundException(String str) {
        super(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(getMessage());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public NotFoundException(Parcel parcel) {
        super(parcel.readString());
    }
}
