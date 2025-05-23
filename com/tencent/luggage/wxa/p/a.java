package com.tencent.luggage.wxa.p;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.n0.v;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements Comparator, Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C6566a();

    /* renamed from: a, reason: collision with root package name */
    public final b[] f137090a;

    /* renamed from: b, reason: collision with root package name */
    public int f137091b;

    /* renamed from: c, reason: collision with root package name */
    public final int f137092c;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.p.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6566a implements Parcelable.Creator {
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

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new C6567a();

        /* renamed from: a, reason: collision with root package name */
        public int f137093a;

        /* renamed from: b, reason: collision with root package name */
        public final UUID f137094b;

        /* renamed from: c, reason: collision with root package name */
        public final String f137095c;

        /* renamed from: d, reason: collision with root package name */
        public final String f137096d;

        /* renamed from: e, reason: collision with root package name */
        public final byte[] f137097e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f137098f;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.p.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class C6567a implements Parcelable.Creator {
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

        public b(UUID uuid, String str, String str2, byte[] bArr) {
            this(uuid, str, str2, bArr, false);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            b bVar = (b) obj;
            if (!this.f137096d.equals(bVar.f137096d) || !v.a(this.f137094b, bVar.f137094b) || !v.a(this.f137095c, bVar.f137095c) || !Arrays.equals(this.f137097e, bVar.f137097e)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode;
            if (this.f137093a == 0) {
                int hashCode2 = this.f137094b.hashCode() * 31;
                String str = this.f137095c;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                this.f137093a = ((((hashCode2 + hashCode) * 31) + this.f137096d.hashCode()) * 31) + Arrays.hashCode(this.f137097e);
            }
            return this.f137093a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeLong(this.f137094b.getMostSignificantBits());
            parcel.writeLong(this.f137094b.getLeastSignificantBits());
            parcel.writeString(this.f137095c);
            parcel.writeString(this.f137096d);
            parcel.writeByteArray(this.f137097e);
            parcel.writeByte(this.f137098f ? (byte) 1 : (byte) 0);
        }

        public b(UUID uuid, String str, String str2, byte[] bArr, boolean z16) {
            this.f137094b = (UUID) com.tencent.luggage.wxa.n0.a.a(uuid);
            this.f137095c = str;
            this.f137096d = (String) com.tencent.luggage.wxa.n0.a.a((Object) str2);
            this.f137097e = (byte[]) com.tencent.luggage.wxa.n0.a.a(bArr);
            this.f137098f = z16;
        }

        public b a(String str) {
            return v.a(this.f137095c, str) ? this : new b(this.f137094b, str, this.f137096d, this.f137097e, this.f137098f);
        }

        public b(Parcel parcel) {
            this.f137094b = new UUID(parcel.readLong(), parcel.readLong());
            this.f137095c = parcel.readString();
            this.f137096d = parcel.readString();
            this.f137097e = parcel.createByteArray();
            this.f137098f = parcel.readByte() != 0;
        }
    }

    public a(List list) {
        this(false, (b[]) list.toArray(new b[list.size()]));
    }

    public b a(int i3) {
        return this.f137090a[i3];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            return Arrays.equals(this.f137090a, ((a) obj).f137090a);
        }
        return false;
    }

    public int hashCode() {
        if (this.f137091b == 0) {
            this.f137091b = Arrays.hashCode(this.f137090a);
        }
        return this.f137091b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeTypedArray(this.f137090a, 0);
    }

    public a(b... bVarArr) {
        this(true, bVarArr);
    }

    public a a(String str) {
        boolean z16;
        b[] bVarArr = this.f137090a;
        int length = bVarArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                z16 = false;
                break;
            }
            if (!v.a(bVarArr[i3].f137095c, str)) {
                z16 = true;
                break;
            }
            i3++;
        }
        if (!z16) {
            return this;
        }
        int length2 = this.f137090a.length;
        b[] bVarArr2 = new b[length2];
        for (int i16 = 0; i16 < length2; i16++) {
            bVarArr2[i16] = this.f137090a[i16].a(str);
        }
        return new a(bVarArr2);
    }

    public a(boolean z16, b... bVarArr) {
        bVarArr = z16 ? (b[]) bVarArr.clone() : bVarArr;
        Arrays.sort(bVarArr, this);
        for (int i3 = 1; i3 < bVarArr.length; i3++) {
            if (bVarArr[i3 - 1].f137094b.equals(bVarArr[i3].f137094b)) {
                throw new IllegalArgumentException("Duplicate data for uuid: " + bVarArr[i3].f137094b);
            }
        }
        this.f137090a = bVarArr;
        this.f137092c = bVarArr.length;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(b bVar, b bVar2) {
        UUID uuid = com.tencent.luggage.wxa.m.b.f133806b;
        if (uuid.equals(bVar.f137094b)) {
            return uuid.equals(bVar2.f137094b) ? 0 : 1;
        }
        return bVar.f137094b.compareTo(bVar2.f137094b);
    }

    public a(Parcel parcel) {
        b[] bVarArr = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f137090a = bVarArr;
        this.f137092c = bVarArr.length;
    }
}
