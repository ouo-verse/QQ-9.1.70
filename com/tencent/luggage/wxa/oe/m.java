package com.tencent.luggage.wxa.oe;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanFilter;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public final String f136409a;

    /* renamed from: b, reason: collision with root package name */
    public final String f136410b;

    /* renamed from: c, reason: collision with root package name */
    public final ParcelUuid f136411c;

    /* renamed from: d, reason: collision with root package name */
    public final ParcelUuid f136412d;

    /* renamed from: e, reason: collision with root package name */
    public final ParcelUuid f136413e;

    /* renamed from: f, reason: collision with root package name */
    public final byte[] f136414f;

    /* renamed from: g, reason: collision with root package name */
    public final byte[] f136415g;

    /* renamed from: h, reason: collision with root package name */
    public final int f136416h;

    /* renamed from: i, reason: collision with root package name */
    public final byte[] f136417i;

    /* renamed from: j, reason: collision with root package name */
    public final byte[] f136418j;

    /* renamed from: k, reason: collision with root package name */
    public static final m f136408k = new b().a();
    public static final Parcelable.Creator<m> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public m[] newArray(int i3) {
            return new m[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public m createFromParcel(Parcel parcel) {
            b bVar = new b();
            if (parcel.readInt() == 1) {
                bVar.b(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                bVar.a(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                ParcelUuid parcelUuid = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                bVar.a(parcelUuid);
                if (parcel.readInt() == 1) {
                    bVar.a(parcelUuid, (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader()));
                }
            }
            if (parcel.readInt() == 1) {
                ParcelUuid parcelUuid2 = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                if (parcel.readInt() == 1) {
                    byte[] bArr = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr);
                    if (parcel.readInt() == 0) {
                        bVar.a(parcelUuid2, bArr);
                    } else {
                        byte[] bArr2 = new byte[parcel.readInt()];
                        parcel.readByteArray(bArr2);
                        bVar.a(parcelUuid2, bArr, bArr2);
                    }
                }
            }
            int readInt = parcel.readInt();
            if (parcel.readInt() == 1) {
                byte[] bArr3 = new byte[parcel.readInt()];
                parcel.readByteArray(bArr3);
                if (parcel.readInt() == 0) {
                    bVar.a(readInt, bArr3);
                } else {
                    byte[] bArr4 = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr4);
                    bVar.a(readInt, bArr3, bArr4);
                }
            }
            return bVar.a();
        }
    }

    public /* synthetic */ m(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i3, byte[] bArr3, byte[] bArr4, a aVar) {
        this(str, str2, parcelUuid, parcelUuid2, parcelUuid3, bArr, bArr2, i3, bArr3, bArr4);
    }

    public ScanFilter a() {
        ScanFilter.Builder builder = new ScanFilter.Builder();
        String str = this.f136409a;
        if (str != null) {
            builder.setDeviceName(str);
        }
        ParcelUuid parcelUuid = this.f136411c;
        if (parcelUuid != null) {
            builder.setServiceUuid(parcelUuid, this.f136412d);
        }
        String str2 = this.f136410b;
        if (str2 != null) {
            builder.setDeviceAddress(str2);
        }
        ParcelUuid parcelUuid2 = this.f136413e;
        if (parcelUuid2 != null) {
            builder.setServiceData(parcelUuid2, this.f136414f, this.f136415g);
        }
        int i3 = this.f136416h;
        if (i3 < 0) {
            builder.setManufacturerData(i3, this.f136417i, this.f136418j);
        }
        return builder.build();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        if (k.b(this.f136409a, mVar.f136409a) && k.b(this.f136410b, mVar.f136410b) && this.f136416h == mVar.f136416h && k.a(this.f136417i, mVar.f136417i) && k.a(this.f136418j, mVar.f136418j) && k.a(this.f136413e, mVar.f136413e) && k.a(this.f136414f, mVar.f136414f) && k.a(this.f136415g, mVar.f136415g) && k.b(this.f136411c, mVar.f136411c) && k.b(this.f136412d, mVar.f136412d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return k.a(this.f136409a, this.f136410b, Integer.valueOf(this.f136416h), this.f136417i, this.f136418j, this.f136413e, this.f136414f, this.f136415g, this.f136411c, this.f136412d);
    }

    public String toString() {
        return "BluetoothLeScanFilter [mDeviceName=" + this.f136409a + ", mDeviceAddress=" + this.f136410b + ", mUuid=" + this.f136411c + ", mUuidMask=" + this.f136412d + ", mServiceDataUuid=" + k.a(this.f136413e) + ", mServiceData=" + Arrays.toString(this.f136414f) + ", mServiceDataMask=" + Arrays.toString(this.f136415g) + ", mManufacturerId=" + this.f136416h + ", mManufacturerData=" + Arrays.toString(this.f136417i) + ", mManufacturerDataMask=" + Arrays.toString(this.f136418j) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36 = 0;
        if (this.f136409a == null) {
            i16 = 0;
        } else {
            i16 = 1;
        }
        parcel.writeInt(i16);
        String str = this.f136409a;
        if (str != null) {
            parcel.writeString(str);
        }
        if (this.f136410b == null) {
            i17 = 0;
        } else {
            i17 = 1;
        }
        parcel.writeInt(i17);
        String str2 = this.f136410b;
        if (str2 != null) {
            parcel.writeString(str2);
        }
        if (this.f136411c == null) {
            i18 = 0;
        } else {
            i18 = 1;
        }
        parcel.writeInt(i18);
        ParcelUuid parcelUuid = this.f136411c;
        if (parcelUuid != null) {
            parcel.writeParcelable(parcelUuid, i3);
            if (this.f136412d == null) {
                i29 = 0;
            } else {
                i29 = 1;
            }
            parcel.writeInt(i29);
            ParcelUuid parcelUuid2 = this.f136412d;
            if (parcelUuid2 != null) {
                parcel.writeParcelable(parcelUuid2, i3);
            }
        }
        if (this.f136413e == null) {
            i19 = 0;
        } else {
            i19 = 1;
        }
        parcel.writeInt(i19);
        ParcelUuid parcelUuid3 = this.f136413e;
        if (parcelUuid3 != null) {
            parcel.writeParcelable(parcelUuid3, i3);
            if (this.f136414f == null) {
                i27 = 0;
            } else {
                i27 = 1;
            }
            parcel.writeInt(i27);
            byte[] bArr = this.f136414f;
            if (bArr != null) {
                parcel.writeInt(bArr.length);
                parcel.writeByteArray(this.f136414f);
                if (this.f136415g == null) {
                    i28 = 0;
                } else {
                    i28 = 1;
                }
                parcel.writeInt(i28);
                byte[] bArr2 = this.f136415g;
                if (bArr2 != null) {
                    parcel.writeInt(bArr2.length);
                    parcel.writeByteArray(this.f136415g);
                }
            }
        }
        parcel.writeInt(this.f136416h);
        if (this.f136417i == null) {
            i26 = 0;
        } else {
            i26 = 1;
        }
        parcel.writeInt(i26);
        byte[] bArr3 = this.f136417i;
        if (bArr3 != null) {
            parcel.writeInt(bArr3.length);
            parcel.writeByteArray(this.f136417i);
            if (this.f136418j != null) {
                i36 = 1;
            }
            parcel.writeInt(i36);
            byte[] bArr4 = this.f136418j;
            if (bArr4 != null) {
                parcel.writeInt(bArr4.length);
                parcel.writeByteArray(this.f136418j);
            }
        }
    }

    public m(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i3, byte[] bArr3, byte[] bArr4) {
        this.f136409a = str;
        this.f136411c = parcelUuid;
        this.f136412d = parcelUuid2;
        this.f136410b = str2;
        this.f136413e = parcelUuid3;
        this.f136414f = bArr;
        this.f136415g = bArr2;
        this.f136416h = i3;
        this.f136417i = bArr3;
        this.f136418j = bArr4;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public String f136419a;

        /* renamed from: b, reason: collision with root package name */
        public String f136420b;

        /* renamed from: c, reason: collision with root package name */
        public ParcelUuid f136421c;

        /* renamed from: d, reason: collision with root package name */
        public ParcelUuid f136422d;

        /* renamed from: e, reason: collision with root package name */
        public ParcelUuid f136423e;

        /* renamed from: f, reason: collision with root package name */
        public byte[] f136424f;

        /* renamed from: g, reason: collision with root package name */
        public byte[] f136425g;

        /* renamed from: h, reason: collision with root package name */
        public int f136426h = -1;

        /* renamed from: i, reason: collision with root package name */
        public byte[] f136427i;

        /* renamed from: j, reason: collision with root package name */
        public byte[] f136428j;

        public b a(String str) {
            if (str != null && !BluetoothAdapter.checkBluetoothAddress(str)) {
                throw new IllegalArgumentException("invalid device address " + str);
            }
            this.f136420b = str;
            return this;
        }

        public b b(String str) {
            this.f136419a = str;
            return this;
        }

        public b a(ParcelUuid parcelUuid) {
            this.f136421c = parcelUuid;
            this.f136422d = null;
            return this;
        }

        public b a(ParcelUuid parcelUuid, ParcelUuid parcelUuid2) {
            if (this.f136422d != null && this.f136421c == null) {
                throw new IllegalArgumentException("uuid is null while uuidMask is not null!");
            }
            this.f136421c = parcelUuid;
            this.f136422d = parcelUuid2;
            return this;
        }

        public b a(ParcelUuid parcelUuid, byte[] bArr) {
            if (parcelUuid != null) {
                this.f136423e = parcelUuid;
                this.f136424f = bArr;
                this.f136425g = null;
                return this;
            }
            throw new IllegalArgumentException("serviceDataUuid is null");
        }

        public b a(ParcelUuid parcelUuid, byte[] bArr, byte[] bArr2) {
            if (parcelUuid != null) {
                byte[] bArr3 = this.f136425g;
                if (bArr3 != null) {
                    byte[] bArr4 = this.f136424f;
                    if (bArr4 != null) {
                        if (bArr4.length != bArr3.length) {
                            throw new IllegalArgumentException("size mismatch for service data and service data mask");
                        }
                    } else {
                        throw new IllegalArgumentException("serviceData is null while serviceDataMask is not null");
                    }
                }
                this.f136423e = parcelUuid;
                this.f136424f = bArr;
                this.f136425g = bArr2;
                return this;
            }
            throw new IllegalArgumentException("serviceDataUuid is null");
        }

        public b a(int i3, byte[] bArr) {
            if (bArr != null && i3 < 0) {
                throw new IllegalArgumentException("invalid manufacture id");
            }
            this.f136426h = i3;
            this.f136427i = bArr;
            this.f136428j = null;
            return this;
        }

        public b a(int i3, byte[] bArr, byte[] bArr2) {
            if (bArr != null && i3 < 0) {
                throw new IllegalArgumentException("invalid manufacture id");
            }
            byte[] bArr3 = this.f136428j;
            if (bArr3 != null) {
                byte[] bArr4 = this.f136427i;
                if (bArr4 != null) {
                    if (bArr4.length != bArr3.length) {
                        throw new IllegalArgumentException("size mismatch for manufacturerData and manufacturerDataMask");
                    }
                } else {
                    throw new IllegalArgumentException("manufacturerData is null while manufacturerDataMask is not null");
                }
            }
            this.f136426h = i3;
            this.f136427i = bArr;
            this.f136428j = bArr2;
            return this;
        }

        public m a() {
            return new m(this.f136419a, this.f136420b, this.f136421c, this.f136422d, this.f136423e, this.f136424f, this.f136425g, this.f136426h, this.f136427i, this.f136428j, null);
        }
    }

    public boolean a(o oVar) {
        if (oVar == null) {
            return false;
        }
        BluetoothDevice a16 = oVar.a();
        String str = this.f136410b;
        if (str != null && (a16 == null || !str.equals(a16.getAddress()))) {
            return false;
        }
        n c16 = oVar.c();
        if (c16 == null && (this.f136409a != null || this.f136411c != null || this.f136417i != null || this.f136414f != null || this.f136413e != null || this.f136416h >= 0)) {
            return false;
        }
        String str2 = this.f136409a;
        if (str2 != null && !str2.equals(c16.b())) {
            return false;
        }
        ParcelUuid parcelUuid = this.f136411c;
        if (parcelUuid != null && !a(parcelUuid, this.f136412d, c16.f())) {
            return false;
        }
        ParcelUuid parcelUuid2 = this.f136413e;
        if (parcelUuid2 != null && !a(this.f136414f, this.f136415g, c16.a(parcelUuid2))) {
            return false;
        }
        int i3 = this.f136416h;
        if (i3 < 0 || c16 == null) {
            return true;
        }
        return a(this.f136417i, this.f136418j, c16.a(i3));
    }

    public final boolean a(ParcelUuid parcelUuid, ParcelUuid parcelUuid2, List list) {
        if (parcelUuid == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (a(parcelUuid.getUuid(), parcelUuid2 == null ? null : parcelUuid2.getUuid(), ((ParcelUuid) it.next()).getUuid())) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(UUID uuid, UUID uuid2, UUID uuid3) {
        if (uuid2 == null) {
            return uuid.equals(uuid3);
        }
        if ((uuid.getLeastSignificantBits() & uuid2.getLeastSignificantBits()) != (uuid3.getLeastSignificantBits() & uuid2.getLeastSignificantBits())) {
            return false;
        }
        return (uuid.getMostSignificantBits() & uuid2.getMostSignificantBits()) == (uuid2.getMostSignificantBits() & uuid3.getMostSignificantBits());
    }

    public final boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr3 == null || bArr3.length < bArr.length) {
            return false;
        }
        if (bArr2 == null) {
            for (int i3 = 0; i3 < bArr.length; i3++) {
                if (bArr3[i3] != bArr[i3]) {
                    return false;
                }
            }
            return true;
        }
        for (int i16 = 0; i16 < bArr.length; i16++) {
            byte b16 = bArr2[i16];
            if ((bArr3[i16] & b16) != (b16 & bArr[i16])) {
                return false;
            }
        }
        return true;
    }
}
