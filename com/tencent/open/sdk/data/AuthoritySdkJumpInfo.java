package com.tencent.open.sdk.data;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AuthoritySdkJumpInfo extends iq3.a implements Parcelable {
    public static final Parcelable.Creator<AuthoritySdkJumpInfo> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements Parcelable.Creator<AuthoritySdkJumpInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AuthoritySdkJumpInfo createFromParcel(Parcel parcel) {
            return new AuthoritySdkJumpInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AuthoritySdkJumpInfo[] newArray(int i3) {
            return new AuthoritySdkJumpInfo[i3];
        }
    }

    public AuthoritySdkJumpInfo(BasicSdkJumpInfo basicSdkJumpInfo) {
        super(basicSdkJumpInfo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // iq3.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
    }

    public AuthoritySdkJumpInfo(Parcel parcel) {
        super(parcel);
    }
}
