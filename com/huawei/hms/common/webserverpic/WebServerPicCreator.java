package com.huawei.hms.common.webserverpic;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public final class WebServerPicCreator implements Parcelable.Creator<WebServerPic> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public WebServerPic createFromParcel(Parcel parcel) {
        return new WebServerPic((Uri) parcel.readParcelable(Uri.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public WebServerPic[] newArray(int i3) {
        return new WebServerPic[i3];
    }
}
