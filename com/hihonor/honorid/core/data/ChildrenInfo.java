package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import i2.d;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ChildrenInfo implements Parcelable {
    public static final Parcelable.Creator<ChildrenInfo> CREATOR = new a();
    private String C;

    /* renamed from: d, reason: collision with root package name */
    private String f36256d;

    /* renamed from: e, reason: collision with root package name */
    private String f36257e;

    /* renamed from: f, reason: collision with root package name */
    private String f36258f;

    /* renamed from: h, reason: collision with root package name */
    private String f36259h;

    /* renamed from: i, reason: collision with root package name */
    private String f36260i;

    /* renamed from: m, reason: collision with root package name */
    private String f36261m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<ChildrenInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ChildrenInfo createFromParcel(Parcel parcel) {
            ChildrenInfo childrenInfo = new ChildrenInfo();
            childrenInfo.f36256d = parcel.readString();
            childrenInfo.f36257e = parcel.readString();
            childrenInfo.f36258f = parcel.readString();
            childrenInfo.f36259h = parcel.readString();
            childrenInfo.f36260i = parcel.readString();
            childrenInfo.f36261m = parcel.readString();
            childrenInfo.C = parcel.readString();
            return childrenInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ChildrenInfo[] newArray(int i3) {
            return new ChildrenInfo[i3];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "{'childrenUserId':" + d.b(this.f36256d) + ",'birthDate':" + this.f36257e + ",'uniquelyNickname':" + this.f36258f + ",'headPictureUrl':" + d.b(this.f36260i) + ",'accountName':" + this.f36259h + this.f36261m + d.b(this.C) + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f36256d);
        parcel.writeString(this.f36257e);
        parcel.writeString(this.f36258f);
        parcel.writeString(this.f36259h);
        parcel.writeString(this.f36260i);
        parcel.writeString(this.f36261m);
        parcel.writeString(this.C);
    }
}
