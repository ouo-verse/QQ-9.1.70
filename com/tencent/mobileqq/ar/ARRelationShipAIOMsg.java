package com.tencent.mobileqq.ar;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARRelationShipAIOMsg implements Parcelable {
    public static final Parcelable.Creator<ARRelationShipAIOMsg> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public String f197069d;

    /* renamed from: e, reason: collision with root package name */
    public String f197070e;

    /* renamed from: f, reason: collision with root package name */
    public String f197071f;

    /* renamed from: h, reason: collision with root package name */
    public String f197072h;

    /* renamed from: i, reason: collision with root package name */
    public String f197073i;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<ARRelationShipAIOMsg> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ARRelationShipAIOMsg createFromParcel(Parcel parcel) {
            return new ARRelationShipAIOMsg(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ARRelationShipAIOMsg[] newArray(int i3) {
            return new ARRelationShipAIOMsg[i3];
        }
    }

    public ARRelationShipAIOMsg() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f197069d);
        parcel.writeString(this.f197070e);
        parcel.writeString(this.f197071f);
        parcel.writeString(this.f197072h);
        parcel.writeString(this.f197073i);
    }

    protected ARRelationShipAIOMsg(Parcel parcel) {
        this.f197069d = parcel.readString();
        this.f197070e = parcel.readString();
        this.f197071f = parcel.readString();
        this.f197072h = parcel.readString();
        this.f197073i = parcel.readString();
    }
}
