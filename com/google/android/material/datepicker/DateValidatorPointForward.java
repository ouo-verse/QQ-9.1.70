package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private final long f33536d;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<DateValidatorPointForward> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DateValidatorPointForward createFromParcel(@NonNull Parcel parcel) {
            return new DateValidatorPointForward(parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DateValidatorPointForward[] newArray(int i3) {
            return new DateValidatorPointForward[i3];
        }
    }

    /* synthetic */ DateValidatorPointForward(long j3, a aVar) {
        this(j3);
    }

    @NonNull
    public static DateValidatorPointForward a(long j3) {
        return new DateValidatorPointForward(j3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof DateValidatorPointForward) && this.f33536d == ((DateValidatorPointForward) obj).f33536d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f33536d)});
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean i(long j3) {
        if (j3 >= this.f33536d) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i3) {
        parcel.writeLong(this.f33536d);
    }

    DateValidatorPointForward(long j3) {
        this.f33536d = j3;
    }
}
