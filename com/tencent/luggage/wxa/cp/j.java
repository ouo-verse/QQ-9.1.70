package com.tencent.luggage.wxa.cp;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j extends t {
    public static final b CREATOR = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b implements Parcelable.Creator {

        /* renamed from: a, reason: collision with root package name */
        public static final u f123772a = new u(new j());

        public b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j createFromParcel(Parcel parcel) {
            return (j) f123772a.f123837a;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j[] newArray(int i3) {
            return new j[i3];
        }
    }

    public static u a() {
        return b.f123772a;
    }

    public j() {
    }

    @Override // com.tencent.luggage.wxa.cp.s.a
    public Pair a(p pVar, b0 b0Var) {
        String str = b0Var.f123727c;
        if (str == null) {
            str = "";
        }
        return pVar.a(str);
    }
}
