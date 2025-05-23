package com.tencent.now.app.medal.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MedalInfo implements Parcelable {
    public static final Parcelable.Creator<MedalInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public int f337983d;

    /* renamed from: e, reason: collision with root package name */
    public int f337984e;

    /* renamed from: f, reason: collision with root package name */
    public int f337985f;

    /* renamed from: h, reason: collision with root package name */
    public List<MedalItem> f337986h = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements Parcelable.Creator<MedalInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MedalInfo createFromParcel(Parcel parcel) {
            return new MedalInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MedalInfo[] newArray(int i3) {
            return new MedalInfo[i3];
        }
    }

    public MedalInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z16 = obj instanceof MedalInfo;
        return false;
    }

    public String toString() {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        List<MedalItem> list = this.f337986h;
        if (list != null) {
            i3 = list.size();
            Iterator<MedalItem> it = this.f337986h.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().toString());
            }
        } else {
            i3 = 0;
        }
        return "MedalInfo{level=" + this.f337983d + ", point=" + this.f337984e + ", nextpoint=" + this.f337985f + ", medalItemList=" + this.f337986h + "}  msize =" + i3 + " info=" + sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f337983d);
        parcel.writeInt(this.f337984e);
        parcel.writeInt(this.f337985f);
        List<MedalItem> list = this.f337986h;
        if (list != null) {
            parcel.writeTypedList(list);
        }
    }

    protected MedalInfo(Parcel parcel) {
        this.f337983d = parcel.readInt();
        this.f337984e = parcel.readInt();
        this.f337985f = parcel.readInt();
        parcel.readTypedList(this.f337986h, MedalItem.CREATOR);
    }
}
