package com.huawei.hms.push;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
class b implements Parcelable.Creator<RemoteMessage> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public RemoteMessage createFromParcel(Parcel parcel) {
        return new RemoteMessage(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public RemoteMessage[] newArray(int i3) {
        return new RemoteMessage[i3];
    }
}
