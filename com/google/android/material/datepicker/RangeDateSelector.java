package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
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
public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new c();

    /* renamed from: d, reason: collision with root package name */
    private String f33574d;

    /* renamed from: e, reason: collision with root package name */
    private final String f33575e = " ";

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private Long f33576f = null;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private Long f33577h = null;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private Long f33578i = null;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private Long f33579m = null;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends DateFormatTextWatcher {
        final /* synthetic */ TextInputLayout C;
        final /* synthetic */ TextInputLayout D;
        final /* synthetic */ i E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, i iVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.C = textInputLayout2;
            this.D = textInputLayout3;
            this.E = iVar;
        }

        @Override // com.google.android.material.datepicker.DateFormatTextWatcher
        void e() {
            RangeDateSelector.this.f33578i = null;
            RangeDateSelector.this.m(this.C, this.D, this.E);
        }

        @Override // com.google.android.material.datepicker.DateFormatTextWatcher
        void f(@Nullable Long l3) {
            RangeDateSelector.this.f33578i = l3;
            RangeDateSelector.this.m(this.C, this.D, this.E);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b extends DateFormatTextWatcher {
        final /* synthetic */ TextInputLayout C;
        final /* synthetic */ TextInputLayout D;
        final /* synthetic */ i E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, i iVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.C = textInputLayout2;
            this.D = textInputLayout3;
            this.E = iVar;
        }

        @Override // com.google.android.material.datepicker.DateFormatTextWatcher
        void e() {
            RangeDateSelector.this.f33579m = null;
            RangeDateSelector.this.m(this.C, this.D, this.E);
        }

        @Override // com.google.android.material.datepicker.DateFormatTextWatcher
        void f(@Nullable Long l3) {
            RangeDateSelector.this.f33579m = l3;
            RangeDateSelector.this.m(this.C, this.D, this.E);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class c implements Parcelable.Creator<RangeDateSelector> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RangeDateSelector createFromParcel(@NonNull Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.f33576f = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.f33577h = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RangeDateSelector[] newArray(int i3) {
            return new RangeDateSelector[i3];
        }
    }

    private void g(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        if (textInputLayout.R() != null && this.f33574d.contentEquals(textInputLayout.R())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.R() != null && " ".contentEquals(textInputLayout2.R())) {
            textInputLayout2.setError(null);
        }
    }

    private boolean k(long j3, long j16) {
        if (j3 <= j16) {
            return true;
        }
        return false;
    }

    private void l(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.f33574d);
        textInputLayout2.setError(" ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull i<Pair<Long, Long>> iVar) {
        Long l3 = this.f33578i;
        if (l3 != null && this.f33579m != null) {
            if (k(l3.longValue(), this.f33579m.longValue())) {
                this.f33576f = this.f33578i;
                this.f33577h = this.f33579m;
                iVar.b(X());
                return;
            } else {
                l(textInputLayout, textInputLayout2);
                iVar.a();
                return;
            }
        }
        g(textInputLayout, textInputLayout2);
        iVar.a();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean K() {
        Long l3 = this.f33576f;
        if (l3 != null && this.f33577h != null && k(l3.longValue(), this.f33577h.longValue())) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void L(long j3) {
        Long l3 = this.f33576f;
        if (l3 == null) {
            this.f33576f = Long.valueOf(j3);
        } else if (this.f33577h == null && k(l3.longValue(), j3)) {
            this.f33577h = Long.valueOf(j3);
        } else {
            this.f33577h = null;
            this.f33576f = Long.valueOf(j3);
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Pair<Long, Long>> P() {
        if (this.f33576f != null && this.f33577h != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair(this.f33576f, this.f33577h));
            return arrayList;
        }
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int R(@NonNull Context context) {
        int i3;
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.csx)) {
            i3 = R.attr.auy;
        } else {
            i3 = R.attr.aum;
        }
        return g1.b.d(context, i3, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Long> T() {
        ArrayList arrayList = new ArrayList();
        Long l3 = this.f33576f;
        if (l3 != null) {
            arrayList.add(l3);
        }
        Long l16 = this.f33577h;
        if (l16 != null) {
            arrayList.add(l16);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull i<Pair<Long, Long>> iVar) {
        View inflate = layoutInflater.inflate(R.layout.f168314fm2, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.zhi);
        TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(R.id.zhh);
        EditText L = textInputLayout.L();
        EditText L2 = textInputLayout2.L();
        if (com.google.android.material.internal.f.a()) {
            L.setInputType(17);
            L2.setInputType(17);
        }
        this.f33574d = inflate.getResources().getString(R.string.f168622g5);
        SimpleDateFormat k3 = o.k();
        Long l3 = this.f33576f;
        if (l3 != null) {
            L.setText(k3.format(l3));
            this.f33578i = this.f33576f;
        }
        Long l16 = this.f33577h;
        if (l16 != null) {
            L2.setText(k3.format(l16));
            this.f33579m = this.f33577h;
        }
        String l17 = o.l(inflate.getResources(), k3);
        textInputLayout.setPlaceholderText(l17);
        textInputLayout2.setPlaceholderText(l17);
        L.addTextChangedListener(new a(l17, k3, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, iVar));
        L2.addTextChangedListener(new b(l17, k3, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, iVar));
        ViewUtils.l(L);
        return inflate;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String h(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l3 = this.f33576f;
        if (l3 == null && this.f33577h == null) {
            return resources.getString(R.string.f168692gb);
        }
        Long l16 = this.f33577h;
        if (l16 == null) {
            return resources.getString(R.string.f168662g9, d.c(l3.longValue()));
        }
        if (l3 == null) {
            return resources.getString(R.string.f168652g8, d.c(l16.longValue()));
        }
        Pair<String, String> a16 = d.a(l3, l16);
        return resources.getString(R.string.f168672g_, a16.first, a16.second);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Pair<Long, Long> X() {
        return new Pair<>(this.f33576f, this.f33577h);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i3) {
        parcel.writeValue(this.f33576f);
        parcel.writeValue(this.f33577h);
    }
}
