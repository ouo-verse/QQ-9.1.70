package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();

    @Nullable
    private String C;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final Calendar f33568d;

    /* renamed from: e, reason: collision with root package name */
    final int f33569e;

    /* renamed from: f, reason: collision with root package name */
    final int f33570f;

    /* renamed from: h, reason: collision with root package name */
    final int f33571h;

    /* renamed from: i, reason: collision with root package name */
    final int f33572i;

    /* renamed from: m, reason: collision with root package name */
    final long f33573m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<Month> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Month createFromParcel(@NonNull Parcel parcel) {
            return Month.e(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Month[] newArray(int i3) {
            return new Month[i3];
        }
    }

    Month(@NonNull Calendar calendar) {
        calendar.set(5, 1);
        Calendar f16 = o.f(calendar);
        this.f33568d = f16;
        this.f33569e = f16.get(2);
        this.f33570f = f16.get(1);
        this.f33571h = f16.getMaximum(7);
        this.f33572i = f16.getActualMaximum(5);
        this.f33573m = f16.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static Month e(int i3, int i16) {
        Calendar q16 = o.q();
        q16.set(1, i3);
        q16.set(2, i16);
        return new Month(q16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static Month f(long j3) {
        Calendar q16 = o.q();
        q16.setTimeInMillis(j3);
        return new Month(q16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static Month j() {
        return new Month(o.o());
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull Month month) {
        return this.f33568d.compareTo(month.f33568d);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        if (this.f33569e == month.f33569e && this.f33570f == month.f33570f) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f33569e), Integer.valueOf(this.f33570f)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        int firstDayOfWeek = this.f33568d.get(7) - this.f33568d.getFirstDayOfWeek();
        if (firstDayOfWeek < 0) {
            return firstDayOfWeek + this.f33571h;
        }
        return firstDayOfWeek;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long l(int i3) {
        Calendar f16 = o.f(this.f33568d);
        f16.set(5, i3);
        return f16.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(long j3) {
        Calendar f16 = o.f(this.f33568d);
        f16.setTimeInMillis(j3);
        return f16.get(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public String n() {
        if (this.C == null) {
            this.C = d.i(this.f33568d.getTimeInMillis());
        }
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long o() {
        return this.f33568d.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Month p(int i3) {
        Calendar f16 = o.f(this.f33568d);
        f16.add(2, i3);
        return new Month(f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q(@NonNull Month month) {
        if (this.f33568d instanceof GregorianCalendar) {
            return ((month.f33570f - this.f33570f) * 12) + (month.f33569e - this.f33569e);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i3) {
        parcel.writeInt(this.f33570f);
        parcel.writeInt(this.f33569e);
    }
}
