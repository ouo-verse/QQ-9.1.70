package com.tencent.luggage.wxa.oe;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class o implements Parcelable {
    public static final Parcelable.Creator<o> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public BluetoothDevice f136437a;

    /* renamed from: b, reason: collision with root package name */
    public n f136438b;

    /* renamed from: c, reason: collision with root package name */
    public int f136439c;

    /* renamed from: d, reason: collision with root package name */
    public long f136440d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f136441e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public o createFromParcel(Parcel parcel) {
            return new o(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public o[] newArray(int i3) {
            return new o[i3];
        }
    }

    public /* synthetic */ o(Parcel parcel, a aVar) {
        this(parcel);
    }

    public final void a(Parcel parcel) {
        if (parcel.readInt() == 1) {
            this.f136437a = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() == 1) {
            this.f136438b = n.a(parcel.createByteArray());
        }
        this.f136439c = parcel.readInt();
        this.f136440d = parcel.readLong();
        int readInt = parcel.readInt();
        if (-1 == readInt) {
            this.f136441e = null;
        } else {
            this.f136441e = Boolean.valueOf(1 == readInt);
        }
    }

    public int b() {
        return this.f136439c;
    }

    public n c() {
        return this.f136438b;
    }

    public long d() {
        return this.f136440d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Boolean e() {
        return this.f136441e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (k.b(this.f136437a, oVar.f136437a) && this.f136439c == oVar.f136439c && k.b(this.f136438b, oVar.f136438b) && this.f136440d == oVar.f136440d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return k.a(this.f136437a, Integer.valueOf(this.f136439c), this.f136438b, Long.valueOf(this.f136440d));
    }

    public String toString() {
        return "ScanResult{mDevice=" + this.f136437a + ", mScanRecord=" + k.a(this.f136438b) + ", mRssi=" + this.f136439c + ", mTimestampNanos=" + this.f136440d + '}';
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i16;
        if (this.f136437a != null) {
            parcel.writeInt(1);
            this.f136437a.writeToParcel(parcel, i3);
        } else {
            parcel.writeInt(0);
        }
        if (this.f136438b != null) {
            parcel.writeInt(1);
            parcel.writeByteArray(this.f136438b.a());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.f136439c);
        parcel.writeLong(this.f136440d);
        Boolean bool = this.f136441e;
        if (bool == null) {
            i16 = -1;
        } else {
            i16 = bool.booleanValue();
        }
        parcel.writeInt(i16);
    }

    public o(BluetoothDevice bluetoothDevice, n nVar, int i3, long j3) {
        this.f136437a = bluetoothDevice;
        this.f136438b = nVar;
        this.f136439c = i3;
        this.f136440d = j3;
        this.f136441e = null;
    }

    public o(ScanResult scanResult) {
        boolean isConnectable;
        this.f136437a = scanResult.getDevice();
        ScanRecord scanRecord = scanResult.getScanRecord();
        if (scanRecord != null) {
            this.f136438b = n.a(scanRecord.getBytes());
        }
        this.f136439c = scanResult.getRssi();
        this.f136440d = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT >= 26) {
            isConnectable = scanResult.isConnectable();
            this.f136441e = Boolean.valueOf(isConnectable);
        } else {
            this.f136441e = null;
        }
    }

    public BluetoothDevice a() {
        BluetoothDevice bluetoothDevice = this.f136437a;
        if (bluetoothDevice != null) {
            return bluetoothDevice;
        }
        return null;
    }

    public o(Parcel parcel) {
        a(parcel);
    }
}
