package com.tencent.luggage.wxa.c0;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.tencent.luggage.wxa.n0.v;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f extends h {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f123181b;

    /* renamed from: c, reason: collision with root package name */
    public final String f123182c;

    /* renamed from: d, reason: collision with root package name */
    public final String f123183d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f123184e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i3) {
            return new f[i3];
        }
    }

    public f(String str, String str2, String str3, byte[] bArr) {
        super(GeobFrame.ID);
        this.f123181b = str;
        this.f123182c = str2;
        this.f123183d = str3;
        this.f123184e = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (v.a(this.f123181b, fVar.f123181b) && v.a(this.f123182c, fVar.f123182c) && v.a(this.f123183d, fVar.f123183d) && Arrays.equals(this.f123184e, fVar.f123184e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        String str = this.f123181b;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = (i3 + 527) * 31;
        String str2 = this.f123182c;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        String str3 = this.f123183d;
        if (str3 != null) {
            i17 = str3.hashCode();
        }
        return ((i19 + i17) * 31) + Arrays.hashCode(this.f123184e);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f123181b);
        parcel.writeString(this.f123182c);
        parcel.writeString(this.f123183d);
        parcel.writeByteArray(this.f123184e);
    }

    public f(Parcel parcel) {
        super(GeobFrame.ID);
        this.f123181b = parcel.readString();
        this.f123182c = parcel.readString();
        this.f123183d = parcel.readString();
        this.f123184e = parcel.createByteArray();
    }
}
