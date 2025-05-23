package com.tencent.luggage.wxa.r5;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.hn.u1;
import com.tencent.luggage.wxa.i3.y;
import com.tencent.luggage.wxa.j4.a;
import com.tencent.luggage.wxa.j4.d;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends d {
    public static final Parcelable.Creator<a> CREATOR = new C6675a();
    public String M0;
    public float N0;
    public float O0;
    public int P0;
    public int Q0;
    public a.EnumC6326a R0;
    public boolean S0;
    public int T0;
    public Point U0;
    public b V0;
    public u1 W0;
    public String X0;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.r5.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6675a implements Parcelable.Creator {
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
    public enum b {
        NORMAL,
        LANDSCAPE,
        LANDSCAPE_COMPAT,
        FORCE_COMPAT
    }

    public a(Parcel parcel) {
        super(parcel);
        this.N0 = -1.0f;
        this.O0 = -1.0f;
        this.P0 = -1;
        this.Q0 = -1;
        this.R0 = a.EnumC6326a.NORMAL;
        this.S0 = false;
        this.T0 = 0;
        this.U0 = null;
        this.W0 = y.f129448a.a();
        this.M0 = parcel.readString();
        this.R0 = a.EnumC6326a.values()[parcel.readByte()];
        this.X0 = parcel.readString();
        this.V0 = b.values()[parcel.readInt()];
        this.S0 = parcel.readByte() > 0;
        int readInt = parcel.readInt();
        if (readInt > 0) {
            byte[] bArr = new byte[readInt];
            parcel.readByteArray(bArr);
            try {
                this.W0 = (u1) new u1().a(bArr);
            } catch (IOException unused) {
                this.W0 = null;
            }
        }
        this.f130806r0 = parcel.readString();
        this.U0 = (Point) parcel.readParcelable(getClass().getClassLoader());
        this.T0 = parcel.readInt();
        this.N0 = parcel.readFloat();
        this.O0 = parcel.readFloat();
        this.P0 = parcel.readInt();
        this.Q0 = parcel.readInt();
    }

    public void b(int i3) {
        this.V0 = b.values()[i3];
    }

    @Override // com.tencent.luggage.wxa.j4.d
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public a clone() {
        Parcel b16 = b();
        a aVar = new a(b16);
        OaidMonitor.parcelRecycle(b16);
        return aVar;
    }

    @Override // com.tencent.luggage.wxa.j4.d, com.tencent.luggage.wxa.fd.i, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.M0);
        parcel.writeByte((byte) this.R0.ordinal());
        parcel.writeString(this.X0);
        b bVar = this.V0;
        if (bVar == null) {
            parcel.writeInt(b.NORMAL.ordinal());
        } else {
            parcel.writeInt(bVar.ordinal());
        }
        parcel.writeByte(this.S0 ? (byte) 1 : (byte) 0);
        byte[] bArr = new byte[0];
        try {
            u1 u1Var = this.W0;
            if (u1Var != null) {
                bArr = u1Var.b();
            }
        } catch (IOException unused) {
        }
        parcel.writeInt(bArr.length);
        if (bArr.length > 0) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeString(this.f130806r0);
        parcel.writeParcelable(this.U0, 0);
        parcel.writeInt(this.T0);
        parcel.writeFloat(this.N0);
        parcel.writeFloat(this.O0);
        parcel.writeInt(this.P0);
        parcel.writeInt(this.Q0);
    }

    public void a(int i3) {
        this.R0 = a.EnumC6326a.values()[i3];
    }

    @Override // com.tencent.luggage.wxa.fd.i
    public Parcel b() {
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        return obtain;
    }
}
