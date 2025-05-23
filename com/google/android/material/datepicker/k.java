package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes2.dex */
class k {

    /* renamed from: c, reason: collision with root package name */
    private static final k f33609c = new k(null, null);

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final Long f33610a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final TimeZone f33611b;

    k(@Nullable Long l3, @Nullable TimeZone timeZone) {
        this.f33610a = l3;
        this.f33611b = timeZone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k c() {
        return f33609c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Calendar a() {
        return b(this.f33611b);
    }

    Calendar b(@Nullable TimeZone timeZone) {
        Calendar calendar;
        if (timeZone == null) {
            calendar = Calendar.getInstance();
        } else {
            calendar = Calendar.getInstance(timeZone);
        }
        Long l3 = this.f33610a;
        if (l3 != null) {
            calendar.setTimeInMillis(l3.longValue());
        }
        return calendar;
    }
}
