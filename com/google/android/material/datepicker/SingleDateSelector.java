package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.textfield.TextInputLayout;
import com.tencent.mobileqq.R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new b();

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private Long f33580d;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends DateFormatTextWatcher {
        final /* synthetic */ i C;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, i iVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.C = iVar;
        }

        @Override // com.google.android.material.datepicker.DateFormatTextWatcher
        void e() {
            this.C.a();
        }

        @Override // com.google.android.material.datepicker.DateFormatTextWatcher
        void f(@Nullable Long l3) {
            if (l3 == null) {
                SingleDateSelector.this.c();
            } else {
                SingleDateSelector.this.L(l3.longValue());
            }
            this.C.b(SingleDateSelector.this.X());
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<SingleDateSelector> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SingleDateSelector createFromParcel(@NonNull Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            singleDateSelector.f33580d = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SingleDateSelector[] newArray(int i3) {
            return new SingleDateSelector[i3];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f33580d = null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean K() {
        if (this.f33580d != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void L(long j3) {
        this.f33580d = Long.valueOf(j3);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Pair<Long, Long>> P() {
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int R(Context context) {
        return g1.b.d(context, R.attr.auy, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Long> T() {
        ArrayList arrayList = new ArrayList();
        Long l3 = this.f33580d;
        if (l3 != null) {
            arrayList.add(l3);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull i<Long> iVar) {
        View inflate = layoutInflater.inflate(R.layout.f168313fm1, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.zhg);
        EditText L = textInputLayout.L();
        if (com.google.android.material.internal.f.a()) {
            L.setInputType(17);
        }
        SimpleDateFormat k3 = o.k();
        String l3 = o.l(inflate.getResources(), k3);
        textInputLayout.setPlaceholderText(l3);
        Long l16 = this.f33580d;
        if (l16 != null) {
            L.setText(k3.format(l16));
        }
        L.addTextChangedListener(new a(l3, k3, textInputLayout, calendarConstraints, iVar));
        ViewUtils.l(L);
        return inflate;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @Nullable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Long X() {
        return this.f33580d;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String h(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l3 = this.f33580d;
        if (l3 == null) {
            return resources.getString(R.string.f168572g0);
        }
        return resources.getString(R.string.f168552fy, d.j(l3.longValue()));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i3) {
        parcel.writeValue(this.f33580d);
    }
}
