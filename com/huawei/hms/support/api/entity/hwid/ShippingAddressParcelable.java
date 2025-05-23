package com.huawei.hms.support.api.entity.hwid;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class ShippingAddressParcelable implements Parcelable {
    public static final Parcelable.Creator<ShippingAddressParcelable> CREATOR = new Parcelable.Creator<ShippingAddressParcelable>() { // from class: com.huawei.hms.support.api.entity.hwid.ShippingAddressParcelable.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShippingAddressParcelable createFromParcel(Parcel parcel) {
            return new ShippingAddressParcelable(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShippingAddressParcelable[] newArray(int i3) {
            return new ShippingAddressParcelable[i3];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<ShippingAddressInfo> f37548a;

    public ShippingAddressParcelable() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<ShippingAddressInfo> getShippingAddressInfoList() {
        return this.f37548a;
    }

    public void setShippingAddressInfoList(ArrayList<ShippingAddressInfo> arrayList) {
        this.f37548a = arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeTypedList(this.f37548a);
    }

    protected ShippingAddressParcelable(Parcel parcel) {
        this.f37548a = parcel.createTypedArrayList(ShippingAddressInfo.CREATOR);
    }
}
