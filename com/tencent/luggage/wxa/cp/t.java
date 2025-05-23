package com.tencent.luggage.wxa.cp;

import android.os.CancellationSignal;
import android.os.Parcel;
import com.tencent.luggage.wxa.cp.s;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class t implements s, s.a {
    @Override // com.tencent.luggage.wxa.cp.s.a
    public void a(CancellationSignal cancellationSignal) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    @Override // com.tencent.luggage.wxa.cp.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s.a a(Map map) {
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
    }
}
