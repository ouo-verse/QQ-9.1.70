package com.tencent.luggage.wxa.cp;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.cp.k;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n extends o implements k {
    public static final Parcelable.Creator<n> CREATOR = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b implements Parcelable.Creator {

        /* renamed from: a, reason: collision with root package name */
        public static final u f123816a = new u(new n());

        public b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n createFromParcel(Parcel parcel) {
            return (n) f123816a.f123837a;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n[] newArray(int i3) {
            return new n[i3];
        }
    }

    public static u c() {
        return b.f123816a;
    }

    public static k.a d() {
        return (k.a) b.f123816a.f123837a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "(null)";
    }

    public n() {
    }

    @Override // com.tencent.luggage.wxa.cp.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k.a a(Map map) {
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
    }
}
