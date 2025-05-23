package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    final a f33587a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    final a f33588b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    final a f33589c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    final a f33590d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    final a f33591e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    final a f33592f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    final a f33593g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    final Paint f33594h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(g1.b.d(context, R.attr.auw, MaterialCalendar.class.getCanonicalName()), w0.a.f444011r4);
        this.f33587a = a.a(context, obtainStyledAttributes.getResourceId(w0.a.f444047u4, 0));
        this.f33593g = a.a(context, obtainStyledAttributes.getResourceId(w0.a.f444023s4, 0));
        this.f33588b = a.a(context, obtainStyledAttributes.getResourceId(w0.a.f444035t4, 0));
        this.f33589c = a.a(context, obtainStyledAttributes.getResourceId(w0.a.f444058v4, 0));
        ColorStateList a16 = g1.c.a(context, obtainStyledAttributes, w0.a.f444069w4);
        this.f33590d = a.a(context, obtainStyledAttributes.getResourceId(w0.a.f444093y4, 0));
        this.f33591e = a.a(context, obtainStyledAttributes.getResourceId(w0.a.f444081x4, 0));
        this.f33592f = a.a(context, obtainStyledAttributes.getResourceId(w0.a.f444105z4, 0));
        Paint paint = new Paint();
        this.f33594h = paint;
        paint.setColor(a16.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
