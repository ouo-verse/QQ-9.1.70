package com.tencent.luggage.wxa.c0;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.ChapterFrame;
import com.tencent.luggage.wxa.n0.v;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends h {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f123167b;

    /* renamed from: c, reason: collision with root package name */
    public final int f123168c;

    /* renamed from: d, reason: collision with root package name */
    public final int f123169d;

    /* renamed from: e, reason: collision with root package name */
    public final long f123170e;

    /* renamed from: f, reason: collision with root package name */
    public final long f123171f;

    /* renamed from: g, reason: collision with root package name */
    public final h[] f123172g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i3) {
            return new c[i3];
        }
    }

    public c(String str, int i3, int i16, long j3, long j16, h[] hVarArr) {
        super(ChapterFrame.ID);
        this.f123167b = str;
        this.f123168c = i3;
        this.f123169d = i16;
        this.f123170e = j3;
        this.f123171f = j16;
        this.f123172g = hVarArr;
    }

    @Override // com.tencent.luggage.wxa.c0.h, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f123168c == cVar.f123168c && this.f123169d == cVar.f123169d && this.f123170e == cVar.f123170e && this.f123171f == cVar.f123171f && v.a(this.f123167b, cVar.f123167b) && Arrays.equals(this.f123172g, cVar.f123172g)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = (((((((this.f123168c + 527) * 31) + this.f123169d) * 31) + ((int) this.f123170e)) * 31) + ((int) this.f123171f)) * 31;
        String str = this.f123167b;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return i16 + i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f123167b);
        parcel.writeInt(this.f123168c);
        parcel.writeInt(this.f123169d);
        parcel.writeLong(this.f123170e);
        parcel.writeLong(this.f123171f);
        parcel.writeInt(this.f123172g.length);
        for (h hVar : this.f123172g) {
            parcel.writeParcelable(hVar, 0);
        }
    }

    public c(Parcel parcel) {
        super(ChapterFrame.ID);
        this.f123167b = parcel.readString();
        this.f123168c = parcel.readInt();
        this.f123169d = parcel.readInt();
        this.f123170e = parcel.readLong();
        this.f123171f = parcel.readLong();
        int readInt = parcel.readInt();
        this.f123172g = new h[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            this.f123172g[i3] = (h) parcel.readParcelable(h.class.getClassLoader());
        }
    }
}
