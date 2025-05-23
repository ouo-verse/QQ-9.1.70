package com.tencent.luggage.wxa.qa;

import android.os.Parcel;
import com.tencent.luggage.wxa.ka.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements a {
    @Override // com.tencent.luggage.wxa.qa.a
    public boolean a(Object obj) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.qa.a
    public String getName() {
        return getClass().getName();
    }

    @Override // com.tencent.luggage.wxa.qa.a
    public void a(Object obj, Parcel parcel) {
        com.tencent.luggage.wxa.k0.d.a(obj);
        throw null;
    }

    @Override // com.tencent.luggage.wxa.qa.a
    public Object a(Parcel parcel) {
        String readString = parcel.readString();
        parcel.readBundle();
        com.tencent.luggage.wxa.k0.d.a(w.b(readString, com.tencent.luggage.wxa.oa.a.class));
        return null;
    }
}
