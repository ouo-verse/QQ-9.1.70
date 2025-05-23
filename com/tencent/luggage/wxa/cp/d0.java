package com.tencent.luggage.wxa.cp;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.luggage.wxa.cp.k;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d0 extends t {
    public static final b CREATOR = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b implements Parcelable.Creator {

        /* renamed from: a, reason: collision with root package name */
        public static final u f123742a = new u(new d0());

        public b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d0 createFromParcel(Parcel parcel) {
            return (d0) f123742a.f123837a;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d0[] newArray(int i3) {
            return new d0[i3];
        }
    }

    public static u a() {
        return b.f123742a;
    }

    public d0() {
    }

    @Override // com.tencent.luggage.wxa.cp.s.a
    public Pair a(p pVar, b0 b0Var) {
        k.a b16 = ((r) pVar).b(b0Var.f123726b);
        String str = b0Var.f123727c;
        return new Pair(b16, str == null ? "" : c0.a(str, true, true));
    }
}
