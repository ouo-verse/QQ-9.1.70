package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.textfield.TextInputLayout;
import com.tencent.mobileqq.R;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes2.dex */
abstract class DateFormatTextWatcher extends com.google.android.material.internal.n {

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final TextInputLayout f33527d;

    /* renamed from: e, reason: collision with root package name */
    private final DateFormat f33528e;

    /* renamed from: f, reason: collision with root package name */
    private final CalendarConstraints f33529f;

    /* renamed from: h, reason: collision with root package name */
    private final String f33530h;

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f33531i;

    /* renamed from: m, reason: collision with root package name */
    private Runnable f33532m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DateFormatTextWatcher(final String str, DateFormat dateFormat, @NonNull TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f33528e = dateFormat;
        this.f33527d = textInputLayout;
        this.f33529f = calendarConstraints;
        this.f33530h = textInputLayout.getContext().getString(R.string.f168642g7);
        this.f33531i = new Runnable() { // from class: com.google.android.material.datepicker.DateFormatTextWatcher.1
            @Override // java.lang.Runnable
            public void run() {
                TextInputLayout textInputLayout2 = DateFormatTextWatcher.this.f33527d;
                DateFormat dateFormat2 = DateFormatTextWatcher.this.f33528e;
                Context context = textInputLayout2.getContext();
                textInputLayout2.setError(context.getString(R.string.f168592g2) + "\n" + String.format(context.getString(R.string.f168612g4), str) + "\n" + String.format(context.getString(R.string.f168602g3), dateFormat2.format(new Date(o.o().getTimeInMillis()))));
                DateFormatTextWatcher.this.e();
            }
        };
    }

    private Runnable d(final long j3) {
        return new Runnable() { // from class: com.google.android.material.datepicker.DateFormatTextWatcher.2
            @Override // java.lang.Runnable
            public void run() {
                DateFormatTextWatcher.this.f33527d.setError(String.format(DateFormatTextWatcher.this.f33530h, d.c(j3)));
                DateFormatTextWatcher.this.e();
            }
        };
    }

    abstract void e();

    abstract void f(@Nullable Long l3);

    public void g(View view, Runnable runnable) {
        view.postDelayed(runnable, 1000L);
    }

    @Override // com.google.android.material.internal.n, android.text.TextWatcher
    public void onTextChanged(@NonNull CharSequence charSequence, int i3, int i16, int i17) {
        this.f33527d.removeCallbacks(this.f33531i);
        this.f33527d.removeCallbacks(this.f33532m);
        this.f33527d.setError(null);
        f(null);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        try {
            Date parse = this.f33528e.parse(charSequence.toString());
            this.f33527d.setError(null);
            long time = parse.getTime();
            if (this.f33529f.g().i(time) && this.f33529f.o(time)) {
                f(Long.valueOf(parse.getTime()));
                return;
            }
            Runnable d16 = d(time);
            this.f33532m = d16;
            g(this.f33527d, d16);
        } catch (ParseException unused) {
            g(this.f33527d, this.f33531i);
        }
    }
}
