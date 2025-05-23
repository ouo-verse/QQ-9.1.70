package com.tencent.luggage.wxa.c0;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.tencent.luggage.wxa.n0.v;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i extends h {
    public static final Parcelable.Creator<i> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f123191b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f123192c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i createFromParcel(Parcel parcel) {
            return new i(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i[] newArray(int i3) {
            return new i[i3];
        }
    }

    public i(String str, byte[] bArr) {
        super(PrivFrame.ID);
        this.f123191b = str;
        this.f123192c = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (v.a(this.f123191b, iVar.f123191b) && Arrays.equals(this.f123192c, iVar.f123192c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        String str = this.f123191b;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return ((i3 + 527) * 31) + Arrays.hashCode(this.f123192c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f123191b);
        parcel.writeByteArray(this.f123192c);
    }

    public i(Parcel parcel) {
        super(PrivFrame.ID);
        this.f123191b = parcel.readString();
        this.f123192c = parcel.createByteArray();
    }
}
