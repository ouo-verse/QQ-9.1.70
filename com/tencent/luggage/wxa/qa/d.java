package com.tencent.luggage.wxa.qa;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d implements a {
    @Override // com.tencent.luggage.wxa.qa.a
    public boolean a(Object obj) {
        return obj instanceof Parcelable;
    }

    @Override // com.tencent.luggage.wxa.qa.a
    public String getName() {
        return getClass().getName();
    }

    @Override // com.tencent.luggage.wxa.qa.a
    public void a(Object obj, Parcel parcel) {
        parcel.writeParcelable((Parcelable) obj, 0);
    }

    @Override // com.tencent.luggage.wxa.qa.a
    public Object a(Parcel parcel) {
        return parcel.readParcelable(getClass().getClassLoader());
    }
}
