package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final Month f33511d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final Month f33512e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final DateValidator f33513f;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private Month f33514h;

    /* renamed from: i, reason: collision with root package name */
    private final int f33515i;

    /* renamed from: m, reason: collision with root package name */
    private final int f33516m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface DateValidator extends Parcelable {
        boolean i(long j3);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<CalendarConstraints> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints createFromParcel(@NonNull Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints[] newArray(int i3) {
            return new CalendarConstraints[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: e, reason: collision with root package name */
        static final long f33517e = o.a(Month.e(1900, 0).f33573m);

        /* renamed from: f, reason: collision with root package name */
        static final long f33518f = o.a(Month.e(2100, 11).f33573m);

        /* renamed from: a, reason: collision with root package name */
        private long f33519a;

        /* renamed from: b, reason: collision with root package name */
        private long f33520b;

        /* renamed from: c, reason: collision with root package name */
        private Long f33521c;

        /* renamed from: d, reason: collision with root package name */
        private DateValidator f33522d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(@NonNull CalendarConstraints calendarConstraints) {
            this.f33519a = f33517e;
            this.f33520b = f33518f;
            this.f33522d = DateValidatorPointForward.a(Long.MIN_VALUE);
            this.f33519a = calendarConstraints.f33511d.f33573m;
            this.f33520b = calendarConstraints.f33512e.f33573m;
            this.f33521c = Long.valueOf(calendarConstraints.f33514h.f33573m);
            this.f33522d = calendarConstraints.f33513f;
        }

        @NonNull
        public CalendarConstraints a() {
            Month f16;
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f33522d);
            Month f17 = Month.f(this.f33519a);
            Month f18 = Month.f(this.f33520b);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l3 = this.f33521c;
            if (l3 == null) {
                f16 = null;
            } else {
                f16 = Month.f(l3.longValue());
            }
            return new CalendarConstraints(f17, f18, dateValidator, f16, null);
        }

        @NonNull
        public b b(long j3) {
            this.f33521c = Long.valueOf(j3);
            return this;
        }
    }

    /* synthetic */ CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, a aVar) {
        this(month, month2, dateValidator, month3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        if (this.f33511d.equals(calendarConstraints.f33511d) && this.f33512e.equals(calendarConstraints.f33512e) && ObjectsCompat.equals(this.f33514h, calendarConstraints.f33514h) && this.f33513f.equals(calendarConstraints.f33513f)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month f(Month month) {
        if (month.compareTo(this.f33511d) < 0) {
            return this.f33511d;
        }
        if (month.compareTo(this.f33512e) > 0) {
            return this.f33512e;
        }
        return month;
    }

    public DateValidator g() {
        return this.f33513f;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f33511d, this.f33512e, this.f33514h, this.f33513f});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Month j() {
        return this.f33512e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f33516m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Month l() {
        return this.f33514h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Month m() {
        return this.f33511d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.f33515i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o(long j3) {
        if (this.f33511d.l(1) <= j3) {
            Month month = this.f33512e;
            if (j3 <= month.l(month.f33572i)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f33511d, 0);
        parcel.writeParcelable(this.f33512e, 0);
        parcel.writeParcelable(this.f33514h, 0);
        parcel.writeParcelable(this.f33513f, 0);
    }

    CalendarConstraints(@NonNull Month month, @NonNull Month month2, @NonNull DateValidator dateValidator, @Nullable Month month3) {
        this.f33511d = month;
        this.f33512e = month2;
        this.f33514h = month3;
        this.f33513f = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.f33516m = month.q(month2) + 1;
        this.f33515i = (month2.f33570f - month.f33570f) + 1;
    }
}
