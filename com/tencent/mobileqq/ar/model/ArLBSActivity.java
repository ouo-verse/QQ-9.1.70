package com.tencent.mobileqq.ar.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArLBSActivity implements Parcelable {
    public static final Parcelable.Creator<ArLBSActivity> CREATOR = new a();
    public String C;
    public String D;

    /* renamed from: d, reason: collision with root package name */
    public String f198414d;

    /* renamed from: e, reason: collision with root package name */
    public String f198415e;

    /* renamed from: f, reason: collision with root package name */
    public String f198416f;

    /* renamed from: h, reason: collision with root package name */
    public String f198417h;

    /* renamed from: i, reason: collision with root package name */
    public String f198418i;

    /* renamed from: m, reason: collision with root package name */
    public String f198419m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<ArLBSActivity> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArLBSActivity createFromParcel(Parcel parcel) {
            return new ArLBSActivity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ArLBSActivity[] newArray(int i3) {
            return new ArLBSActivity[i3];
        }
    }

    public ArLBSActivity() {
        this.f198414d = "";
        this.f198415e = "";
        this.f198416f = "";
        this.f198417h = "";
        this.f198418i = "";
        this.f198419m = "";
        this.C = "";
        this.D = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ArLBSActivity{");
        stringBuffer.append("activityName = ");
        stringBuffer.append(this.f198414d);
        stringBuffer.append(", logoUrl = ");
        stringBuffer.append(this.f198415e);
        stringBuffer.append(", mapBackgroundUrl = ");
        stringBuffer.append(this.f198416f);
        stringBuffer.append(", prizeImageUrl = ");
        stringBuffer.append(this.f198417h);
        stringBuffer.append(", prizeName = ");
        stringBuffer.append(this.f198418i);
        stringBuffer.append(", tipsForOutsideLBSLocation = ");
        stringBuffer.append(this.f198419m);
        stringBuffer.append(", tipsTitleForNoLBSLocation = ");
        stringBuffer.append(this.C);
        stringBuffer.append(", tipsContentForNoLBSLocation = ");
        stringBuffer.append(this.D);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f198414d);
        parcel.writeString(this.f198415e);
        parcel.writeString(this.f198416f);
        parcel.writeString(this.f198417h);
        parcel.writeString(this.f198418i);
        parcel.writeString(this.f198419m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
    }

    protected ArLBSActivity(Parcel parcel) {
        this.f198414d = "";
        this.f198415e = "";
        this.f198416f = "";
        this.f198417h = "";
        this.f198418i = "";
        this.f198419m = "";
        this.C = "";
        this.D = "";
        this.f198414d = parcel.readString();
        this.f198415e = parcel.readString();
        this.f198416f = parcel.readString();
        this.f198417h = parcel.readString();
        this.f198418i = parcel.readString();
        this.f198419m = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readString();
    }
}
