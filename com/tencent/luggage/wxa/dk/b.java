package com.tencent.luggage.wxa.dk;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.bk.e;
import com.tencent.luggage.wxa.j4.d;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f124303a;

    /* renamed from: b, reason: collision with root package name */
    public String f124304b;

    /* renamed from: c, reason: collision with root package name */
    public int f124305c;

    /* renamed from: d, reason: collision with root package name */
    public int f124306d;

    /* renamed from: e, reason: collision with root package name */
    public int f124307e;

    /* renamed from: f, reason: collision with root package name */
    public int f124308f;

    /* renamed from: g, reason: collision with root package name */
    public long f124309g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f124310h;

    /* renamed from: i, reason: collision with root package name */
    public long f124311i;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i3) {
            return new b[i3];
        }
    }

    public b(String str, d dVar, e eVar, long j3) {
        this.f124309g = 0L;
        this.f124310h = false;
        this.f124303a = str;
        this.f124304b = dVar.f125808a;
        int i3 = dVar.f125811d;
        if (i3 == 0) {
            this.f124305c = 1;
        } else if (i3 == 1) {
            this.f124305c = 2;
        } else if (i3 == 2) {
            this.f124305c = 3;
        }
        int i16 = dVar.I + 1000;
        this.f124306d = i16;
        this.f124307e = eVar.f122984c;
        this.f124308f = dVar.V;
        this.f124311i = j3;
        w.d("MicroMsg.AppBrand.QualitySession", "primary <init> instanceId[%s] apptype[%d] scene[%d] appversion[%d] wxProcessColdStartTimestamp[%d]", str, Integer.valueOf(i16), Integer.valueOf(this.f124307e), Integer.valueOf(this.f124308f), Long.valueOf(this.f124311i));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f124303a);
        parcel.writeString(this.f124304b);
        parcel.writeInt(this.f124305c);
        parcel.writeInt(this.f124306d);
        parcel.writeInt(this.f124307e);
        parcel.writeInt(this.f124308f);
        parcel.writeLong(this.f124309g);
        parcel.writeByte(this.f124310h ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f124311i);
    }

    public b(Parcel parcel) {
        this.f124309g = 0L;
        this.f124310h = false;
        String readString = parcel.readString();
        this.f124303a = readString;
        this.f124304b = parcel.readString();
        this.f124305c = parcel.readInt();
        this.f124306d = parcel.readInt();
        this.f124307e = parcel.readInt();
        this.f124308f = parcel.readInt();
        this.f124309g = parcel.readLong();
        this.f124310h = parcel.readByte() > 0;
        this.f124311i = parcel.readLong();
        w.d("MicroMsg.AppBrand.QualitySession", "secondary <init> instanceId[%s] apptype[%d] scene[%d] appversion[%d] UIReadyT[%d] isNewUser[%b] wxProcessColdStartTimestamp[%d]", readString, Integer.valueOf(this.f124306d), Integer.valueOf(this.f124307e), Integer.valueOf(this.f124308f), Long.valueOf(this.f124309g), Boolean.valueOf(this.f124310h), Long.valueOf(this.f124311i));
    }
}
