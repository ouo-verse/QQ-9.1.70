package com.tencent.aelight.camera.struct.editor;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.aelight.camera.qqstory.api.ICaptureVideoFilterManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FilterCategoryItem implements Parcelable, Cloneable {
    public static final Parcelable.Creator<FilterCategoryItem> CREATOR = new a();
    public String C;
    public String D;
    public boolean E;
    public String F;
    public String G;
    public String H;
    public boolean I;
    public String J;
    public String K;
    public String L;
    public String M;
    public String N;
    public String P;
    public String Q;
    int R;
    public ArrayList<String> S;

    /* renamed from: d, reason: collision with root package name */
    public String f69060d;

    /* renamed from: e, reason: collision with root package name */
    public String f69061e;

    /* renamed from: f, reason: collision with root package name */
    public String f69062f;

    /* renamed from: h, reason: collision with root package name */
    public String f69063h;

    /* renamed from: i, reason: collision with root package name */
    public int f69064i;

    /* renamed from: m, reason: collision with root package name */
    public int f69065m;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<FilterCategoryItem> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FilterCategoryItem createFromParcel(Parcel parcel) {
            return new FilterCategoryItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FilterCategoryItem[] newArray(int i3) {
            return new FilterCategoryItem[i3];
        }
    }

    public FilterCategoryItem() {
        this.I = true;
        this.R = -1;
        this.S = new ArrayList<>();
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FilterCategoryItem clone() {
        try {
            return (FilterCategoryItem) super.clone();
        } catch (CloneNotSupportedException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public FilterDesc b() {
        ArrayList<String> arrayList = this.S;
        if (arrayList != null && arrayList.size() > 0) {
            return ((ICaptureVideoFilterManager) QRoute.api(ICaptureVideoFilterManager.class)).getFilterDesc(this.S.get(0));
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.hashCode() != hashCode()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f69060d.intern().hashCode();
    }

    public String toString() {
        return "FilterCategoryItem{id='" + this.f69060d + "', name='" + this.f69061e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f69060d);
        parcel.writeString(this.f69061e);
        parcel.writeString(this.f69062f);
        parcel.writeString(this.f69063h);
        parcel.writeInt(this.f69064i);
        parcel.writeInt(this.f69065m);
        parcel.writeStringList(this.S);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeInt(this.E ? 1 : 0);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeInt(this.I ? 1 : 0);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeString(this.L);
        parcel.writeString(this.M);
        parcel.writeString(this.N);
        parcel.writeString(this.P);
        parcel.writeString(this.Q);
        parcel.writeInt(0);
    }

    protected FilterCategoryItem(Parcel parcel) {
        this.I = true;
        this.R = -1;
        this.S = new ArrayList<>();
        this.f69060d = parcel.readString();
        this.f69061e = parcel.readString();
        this.f69062f = parcel.readString();
        this.f69063h = parcel.readString();
        this.f69064i = parcel.readInt();
        this.f69065m = parcel.readInt();
        this.S = parcel.createStringArrayList();
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readInt() == 1;
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.H = parcel.readString();
        this.I = parcel.readInt() == 1;
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.L = parcel.readString();
        this.M = parcel.readString();
        this.N = parcel.readString();
        this.P = parcel.readString();
        this.Q = parcel.readString();
        parcel.readInt();
    }
}
