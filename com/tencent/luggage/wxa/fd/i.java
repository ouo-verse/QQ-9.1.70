package com.tencent.luggage.wxa.fd;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import org.joor.Reflect;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i implements Parcelable {
    public static final Parcelable.Creator<i> CREATOR = new a();
    public boolean C;

    /* renamed from: a, reason: collision with root package name */
    public String f125808a;

    /* renamed from: b, reason: collision with root package name */
    public String f125809b;

    /* renamed from: c, reason: collision with root package name */
    public String f125810c;

    /* renamed from: d, reason: collision with root package name */
    public int f125811d;

    /* renamed from: e, reason: collision with root package name */
    public String f125812e;

    /* renamed from: f, reason: collision with root package name */
    public String f125813f;

    /* renamed from: g, reason: collision with root package name */
    public int f125814g;

    /* renamed from: h, reason: collision with root package name */
    public String f125815h;

    /* renamed from: i, reason: collision with root package name */
    public String f125816i;

    /* renamed from: j, reason: collision with root package name */
    public int f125817j;

    /* renamed from: k, reason: collision with root package name */
    public String f125818k;

    /* renamed from: l, reason: collision with root package name */
    public int f125819l;

    /* renamed from: m, reason: collision with root package name */
    public int f125820m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
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

    public i() {
    }

    @Override // 
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public i clone() {
        Parcel b16 = b();
        i iVar = (i) Reflect.on(getClass()).create(b16).get();
        OaidMonitor.parcelRecycle(b16);
        return iVar;
    }

    public Parcel b() {
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        return obtain;
    }

    public JSONObject c() {
        return null;
    }

    public final int d() {
        return this.f125811d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f125808a);
        parcel.writeString(this.f125809b);
        parcel.writeString(this.f125810c);
        parcel.writeInt(this.f125811d);
        parcel.writeString(this.f125813f);
        parcel.writeString(this.f125812e);
        parcel.writeInt(this.f125814g);
        parcel.writeString(this.f125815h);
        parcel.writeString(this.f125816i);
        parcel.writeInt(this.f125817j);
        parcel.writeString(this.f125818k);
    }

    public i(Parcel parcel) {
        this.f125808a = parcel.readString();
        this.f125809b = parcel.readString();
        this.f125810c = parcel.readString();
        this.f125811d = parcel.readInt();
        this.f125813f = parcel.readString();
        this.f125812e = parcel.readString();
        this.f125814g = parcel.readInt();
        this.f125815h = parcel.readString();
        this.f125816i = parcel.readString();
        this.f125817j = parcel.readInt();
        this.f125818k = parcel.readString();
    }
}
