package com.tencent.luggage.wxa.c0;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.tencent.luggage.wxa.n0.v;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends h {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f123178b;

    /* renamed from: c, reason: collision with root package name */
    public final String f123179c;

    /* renamed from: d, reason: collision with root package name */
    public final String f123180d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i3) {
            return new e[i3];
        }
    }

    public e(String str, String str2, String str3) {
        super(CommentFrame.ID);
        this.f123178b = str;
        this.f123179c = str2;
        this.f123180d = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (v.a(this.f123179c, eVar.f123179c) && v.a(this.f123178b, eVar.f123178b) && v.a(this.f123180d, eVar.f123180d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        String str = this.f123178b;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = (i3 + 527) * 31;
        String str2 = this.f123179c;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        String str3 = this.f123180d;
        if (str3 != null) {
            i17 = str3.hashCode();
        }
        return i19 + i17;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f123190a);
        parcel.writeString(this.f123178b);
        parcel.writeString(this.f123180d);
    }

    public e(Parcel parcel) {
        super(CommentFrame.ID);
        this.f123178b = parcel.readString();
        this.f123179c = parcel.readString();
        this.f123180d = parcel.readString();
    }
}
