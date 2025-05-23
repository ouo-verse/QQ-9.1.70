package com.tencent.luggage.wxa.c0;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.ChapterTocFrame;
import com.tencent.luggage.wxa.n0.v;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends h {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f123173b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f123174c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f123175d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f123176e;

    /* renamed from: f, reason: collision with root package name */
    public final h[] f123177f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i3) {
            return new d[i3];
        }
    }

    public d(String str, boolean z16, boolean z17, String[] strArr, h[] hVarArr) {
        super(ChapterTocFrame.ID);
        this.f123173b = str;
        this.f123174c = z16;
        this.f123175d = z17;
        this.f123176e = strArr;
        this.f123177f = hVarArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f123174c == dVar.f123174c && this.f123175d == dVar.f123175d && v.a(this.f123173b, dVar.f123173b) && Arrays.equals(this.f123176e, dVar.f123176e) && Arrays.equals(this.f123177f, dVar.f123177f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = ((((this.f123174c ? 1 : 0) + 527) * 31) + (this.f123175d ? 1 : 0)) * 31;
        String str = this.f123173b;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return i16 + i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f123173b);
        parcel.writeByte(this.f123174c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f123175d ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f123176e);
        parcel.writeInt(this.f123177f.length);
        int i16 = 0;
        while (true) {
            h[] hVarArr = this.f123177f;
            if (i16 < hVarArr.length) {
                parcel.writeParcelable(hVarArr[i16], 0);
                i16++;
            } else {
                return;
            }
        }
    }

    public d(Parcel parcel) {
        super(ChapterTocFrame.ID);
        this.f123173b = parcel.readString();
        this.f123174c = parcel.readByte() != 0;
        this.f123175d = parcel.readByte() != 0;
        this.f123176e = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.f123177f = new h[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            this.f123177f[i3] = (h) parcel.readParcelable(h.class.getClassLoader());
        }
    }
}
