package com.tencent.mm.ui.widget.snackbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes9.dex */
public class Snack implements Parcelable {
    public static final Parcelable.Creator<Snack> CREATOR = new Parcelable.Creator<Snack>() { // from class: com.tencent.mm.ui.widget.snackbar.Snack.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Snack createFromParcel(Parcel parcel) {
            return new Snack(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Snack[] newArray(int i3) {
            return new Snack[i3];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final String f153802a;

    /* renamed from: b, reason: collision with root package name */
    public final String f153803b;

    /* renamed from: c, reason: collision with root package name */
    public final int f153804c;

    /* renamed from: d, reason: collision with root package name */
    public final Parcelable f153805d;

    /* renamed from: e, reason: collision with root package name */
    public final int f153806e;

    /* renamed from: f, reason: collision with root package name */
    public final int f153807f;

    /* renamed from: g, reason: collision with root package name */
    public final int f153808g;

    /* renamed from: h, reason: collision with root package name */
    public View f153809h;

    public Snack(String str, String str2, int i3, Parcelable parcelable, int i16, int i17, int i18, View view) {
        this.f153802a = str;
        this.f153803b = str2;
        this.f153804c = i3;
        this.f153805d = parcelable;
        this.f153806e = i16;
        this.f153807f = i17;
        this.f153808g = i18;
        this.f153809h = view;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f153802a);
        parcel.writeString(this.f153803b);
        parcel.writeInt(this.f153804c);
        parcel.writeParcelable(this.f153805d, 0);
        parcel.writeInt(this.f153806e);
        parcel.writeInt(this.f153807f);
        parcel.writeInt(this.f153808g);
    }

    public Snack(Parcel parcel) {
        this.f153802a = parcel.readString();
        this.f153803b = parcel.readString();
        this.f153804c = parcel.readInt();
        this.f153805d = parcel.readParcelable(parcel.getClass().getClassLoader());
        this.f153806e = (short) parcel.readInt();
        this.f153807f = parcel.readInt();
        this.f153808g = parcel.readInt();
    }
}
