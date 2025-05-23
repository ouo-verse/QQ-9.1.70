package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final d f33525d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final List<CalendarConstraints.DateValidator> f33526e;

    /* renamed from: f, reason: collision with root package name */
    private static final d f33523f = new a();

    /* renamed from: h, reason: collision with root package name */
    private static final d f33524h = new b();
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements d {
        a() {
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public boolean a(@NonNull List<CalendarConstraints.DateValidator> list, long j3) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && dateValidator.i(j3)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public int getId() {
            return 1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b implements d {
        b() {
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public boolean a(@NonNull List<CalendarConstraints.DateValidator> list, long j3) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && !dateValidator.i(j3)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.d
        public int getId() {
            return 2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class c implements Parcelable.Creator<CompositeDateValidator> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CompositeDateValidator createFromParcel(@NonNull Parcel parcel) {
            d dVar;
            ArrayList readArrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            int readInt = parcel.readInt();
            if (readInt == 2) {
                dVar = CompositeDateValidator.f33524h;
            } else {
                dVar = readInt == 1 ? CompositeDateValidator.f33523f : CompositeDateValidator.f33524h;
            }
            return new CompositeDateValidator((List) Preconditions.checkNotNull(readArrayList), dVar, null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CompositeDateValidator[] newArray(int i3) {
            return new CompositeDateValidator[i3];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface d {
        boolean a(@NonNull List<CalendarConstraints.DateValidator> list, long j3);

        int getId();
    }

    /* synthetic */ CompositeDateValidator(List list, d dVar, a aVar) {
        this(list, dVar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        if (this.f33526e.equals(compositeDateValidator.f33526e) && this.f33525d.getId() == compositeDateValidator.f33525d.getId()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f33526e.hashCode();
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean i(long j3) {
        return this.f33525d.a(this.f33526e, j3);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i3) {
        parcel.writeList(this.f33526e);
        parcel.writeInt(this.f33525d.getId());
    }

    CompositeDateValidator(@NonNull List<CalendarConstraints.DateValidator> list, d dVar) {
        this.f33526e = list;
        this.f33525d = dVar;
    }
}
