package com.tencent.luggage.wxa.xc;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f144673a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.xc.a f144674b;

    /* renamed from: c, reason: collision with root package name */
    public JSONObject f144675c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i3) {
            return new d[i3];
        }
    }

    public d(Parcel parcel) {
        int readInt = parcel.readInt();
        this.f144673a = readInt;
        if (readInt != 1) {
            if (readInt == 2) {
                this.f144674b = (com.tencent.luggage.wxa.xc.a) parcel.readParcelable(d.class.getClassLoader());
            }
        } else {
            try {
                this.f144675c = new JSONObject(parcel.readString());
            } catch (JSONException e16) {
                com.tencent.luggage.wxa.tn.w.a("DrawActionWrapper", e16, "", new Object[0]);
            }
        }
    }

    public String a() {
        int i3 = this.f144673a;
        if (i3 != 1) {
            if (i3 != 2) {
                return "";
            }
            return this.f144674b.f144662a;
        }
        return this.f144675c.optString("method");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("type %d ,method %s", Integer.valueOf(this.f144673a), a());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f144673a);
        int i16 = this.f144673a;
        if (i16 != 1) {
            if (i16 == 2) {
                parcel.writeParcelable(this.f144674b, i3);
                return;
            }
            return;
        }
        parcel.writeString(this.f144675c.toString());
    }
}
