package com.tencent.luggage.wxa.c0;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.tencent.luggage.wxa.n0.v;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends h {
    public static final Parcelable.Creator<a> CREATOR = new C6088a();

    /* renamed from: b, reason: collision with root package name */
    public final String f123162b;

    /* renamed from: c, reason: collision with root package name */
    public final String f123163c;

    /* renamed from: d, reason: collision with root package name */
    public final int f123164d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f123165e;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.c0.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6088a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i3) {
            return new a[i3];
        }
    }

    public a(String str, String str2, int i3, byte[] bArr) {
        super(ApicFrame.ID);
        this.f123162b = str;
        this.f123163c = str2;
        this.f123164d = i3;
        this.f123165e = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f123164d == aVar.f123164d && v.a(this.f123162b, aVar.f123162b) && v.a(this.f123163c, aVar.f123163c) && Arrays.equals(this.f123165e, aVar.f123165e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = (this.f123164d + 527) * 31;
        String str = this.f123162b;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = (i16 + i3) * 31;
        String str2 = this.f123163c;
        if (str2 != null) {
            i17 = str2.hashCode();
        }
        return ((i18 + i17) * 31) + Arrays.hashCode(this.f123165e);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f123162b);
        parcel.writeString(this.f123163c);
        parcel.writeInt(this.f123164d);
        parcel.writeByteArray(this.f123165e);
    }

    public a(Parcel parcel) {
        super(ApicFrame.ID);
        this.f123162b = parcel.readString();
        this.f123163c = parcel.readString();
        this.f123164d = parcel.readInt();
        this.f123165e = parcel.createByteArray();
    }
}
