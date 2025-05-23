package com.tencent.luggage.wxa.rj;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.hn.z0;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements Parcelable, com.tencent.luggage.wxa.xd.l {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f139775a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f139776b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f139777c;

    /* renamed from: d, reason: collision with root package name */
    public static b f139774d = new b();
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i3) {
            return new b[i3];
        }
    }

    public /* synthetic */ b(Parcel parcel, a aVar) {
        this(parcel);
    }

    public byte[] a() {
        return this.f139776b;
    }

    public byte[] b() {
        return this.f139775a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "PermissionBundle[%d][%d][%d]", Integer.valueOf(this.f139775a.length), Integer.valueOf(this.f139776b.length), Integer.valueOf(this.f139777c.length));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeByteArray(this.f139775a);
        parcel.writeByteArray(this.f139776b);
        parcel.writeByteArray(this.f139777c);
    }

    public b(z0 z0Var) {
        this.f139775a = z0Var.f129112d.a();
        this.f139776b = ((com.tencent.luggage.wxa.fn.c) z0Var.f129113e.get(0)).a();
        this.f139777c = ((com.tencent.luggage.wxa.fn.c) z0Var.f129113e.get(1)).a();
    }

    b() {
        this.f139775a = new byte[0];
        this.f139776b = new byte[0];
        this.f139777c = new byte[0];
    }

    public b(Parcel parcel) {
        this.f139775a = parcel.createByteArray();
        this.f139776b = parcel.createByteArray();
        this.f139777c = parcel.createByteArray();
    }
}
