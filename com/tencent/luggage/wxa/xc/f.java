package com.tencent.luggage.wxa.xc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f extends com.tencent.luggage.wxa.xc.a {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public int f144688b;

    /* renamed from: c, reason: collision with root package name */
    public String f144689c;

    /* renamed from: d, reason: collision with root package name */
    public float f144690d;

    /* renamed from: e, reason: collision with root package name */
    public float f144691e;

    /* renamed from: f, reason: collision with root package name */
    public float f144692f;

    /* renamed from: g, reason: collision with root package name */
    public float f144693g;

    /* renamed from: h, reason: collision with root package name */
    public int f144694h;

    /* renamed from: i, reason: collision with root package name */
    public int f144695i;

    /* renamed from: j, reason: collision with root package name */
    public int f144696j;

    /* renamed from: k, reason: collision with root package name */
    public int f144697k;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
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

    public f(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
        this.f144688b = parcel.readInt();
        this.f144689c = parcel.readString();
        this.f144690d = parcel.readFloat();
        this.f144691e = parcel.readFloat();
        this.f144692f = parcel.readFloat();
        this.f144693g = parcel.readFloat();
        this.f144694h = parcel.readInt();
        this.f144695i = parcel.readInt();
        this.f144696j = parcel.readInt();
        this.f144697k = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f) || !super.equals(obj)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f144688b == fVar.f144688b && Float.compare(fVar.f144690d, this.f144690d) == 0 && Float.compare(fVar.f144691e, this.f144691e) == 0 && Float.compare(fVar.f144692f, this.f144692f) == 0 && Float.compare(fVar.f144693g, this.f144693g) == 0 && this.f144694h == fVar.f144694h && this.f144695i == fVar.f144695i && this.f144696j == fVar.f144696j && this.f144697k == fVar.f144697k && Objects.equals(this.f144689c, fVar.f144689c)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), Integer.valueOf(this.f144688b), this.f144689c, Float.valueOf(this.f144690d), Float.valueOf(this.f144691e), Float.valueOf(this.f144692f), Float.valueOf(this.f144693g), Integer.valueOf(this.f144694h), Integer.valueOf(this.f144695i), Integer.valueOf(this.f144696j), Integer.valueOf(this.f144697k));
    }

    @Override // com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeInt(this.f144688b);
        parcel.writeString(this.f144689c);
        parcel.writeFloat(this.f144690d);
        parcel.writeFloat(this.f144691e);
        parcel.writeFloat(this.f144692f);
        parcel.writeFloat(this.f144693g);
        parcel.writeInt(this.f144694h);
        parcel.writeInt(this.f144695i);
        parcel.writeInt(this.f144696j);
        parcel.writeInt(this.f144697k);
    }
}
