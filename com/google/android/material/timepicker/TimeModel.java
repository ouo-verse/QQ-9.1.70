package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new a();
    int C;

    /* renamed from: d, reason: collision with root package name */
    private final b f34476d;

    /* renamed from: e, reason: collision with root package name */
    private final b f34477e;

    /* renamed from: f, reason: collision with root package name */
    final int f34478f;

    /* renamed from: h, reason: collision with root package name */
    int f34479h;

    /* renamed from: i, reason: collision with root package name */
    int f34480i;

    /* renamed from: m, reason: collision with root package name */
    int f34481m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<TimeModel> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TimeModel[] newArray(int i3) {
            return new TimeModel[i3];
        }
    }

    public TimeModel() {
        this(0);
    }

    public static String a(Resources resources, CharSequence charSequence) {
        return b(resources, charSequence, "%02d");
    }

    public static String b(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    private static int c(int i3) {
        if (i3 >= 12) {
            return 1;
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        if (this.f34479h == timeModel.f34479h && this.f34480i == timeModel.f34480i && this.f34478f == timeModel.f34478f && this.f34481m == timeModel.f34481m) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f34478f), Integer.valueOf(this.f34479h), Integer.valueOf(this.f34480i), Integer.valueOf(this.f34481m)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f34479h);
        parcel.writeInt(this.f34480i);
        parcel.writeInt(this.f34481m);
        parcel.writeInt(this.f34478f);
    }

    public TimeModel(int i3) {
        this(0, 0, 10, i3);
    }

    public TimeModel(int i3, int i16, int i17, int i18) {
        this.f34479h = i3;
        this.f34480i = i16;
        this.f34481m = i17;
        this.f34478f = i18;
        this.C = c(i3);
        this.f34476d = new b(59);
        this.f34477e = new b(i18 == 1 ? 24 : 12);
    }

    protected TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
