package iq3;

import android.os.Parcel;
import com.tencent.open.sdk.data.BasicSdkJumpInfo;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class a {

    /* renamed from: d, reason: collision with root package name */
    private BasicSdkJumpInfo f408216d;

    public a(BasicSdkJumpInfo basicSdkJumpInfo) {
        this.f408216d = basicSdkJumpInfo;
    }

    public BasicSdkJumpInfo a() {
        return this.f408216d;
    }

    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f408216d, i3);
    }

    public a(Parcel parcel) {
        this.f408216d = (BasicSdkJumpInfo) parcel.readParcelable(BasicSdkJumpInfo.class.getClassLoader());
    }
}
