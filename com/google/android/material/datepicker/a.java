package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.shape.MaterialShapeDrawable;

/* compiled from: P */
/* loaded from: classes2.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final Rect f33581a;

    /* renamed from: b, reason: collision with root package name */
    private final ColorStateList f33582b;

    /* renamed from: c, reason: collision with root package name */
    private final ColorStateList f33583c;

    /* renamed from: d, reason: collision with root package name */
    private final ColorStateList f33584d;

    /* renamed from: e, reason: collision with root package name */
    private final int f33585e;

    /* renamed from: f, reason: collision with root package name */
    private final com.google.android.material.shape.g f33586f;

    a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i3, com.google.android.material.shape.g gVar, @NonNull Rect rect) {
        Preconditions.checkArgumentNonnegative(rect.left);
        Preconditions.checkArgumentNonnegative(rect.top);
        Preconditions.checkArgumentNonnegative(rect.right);
        Preconditions.checkArgumentNonnegative(rect.bottom);
        this.f33581a = rect;
        this.f33582b = colorStateList2;
        this.f33583c = colorStateList;
        this.f33584d = colorStateList3;
        this.f33585e = i3;
        this.f33586f = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static a a(@NonNull Context context, @StyleRes int i3) {
        boolean z16;
        if (i3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Preconditions.checkArgument(z16, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i3, w0.a.A4);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(w0.a.B4, 0), obtainStyledAttributes.getDimensionPixelOffset(w0.a.D4, 0), obtainStyledAttributes.getDimensionPixelOffset(w0.a.C4, 0), obtainStyledAttributes.getDimensionPixelOffset(w0.a.E4, 0));
        ColorStateList a16 = g1.c.a(context, obtainStyledAttributes, w0.a.F4);
        ColorStateList a17 = g1.c.a(context, obtainStyledAttributes, w0.a.K4);
        ColorStateList a18 = g1.c.a(context, obtainStyledAttributes, w0.a.I4);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(w0.a.J4, 0);
        com.google.android.material.shape.g m3 = com.google.android.material.shape.g.b(context, obtainStyledAttributes.getResourceId(w0.a.G4, 0), obtainStyledAttributes.getResourceId(w0.a.H4, 0)).m();
        obtainStyledAttributes.recycle();
        return new a(a16, a17, a18, dimensionPixelSize, m3, rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f33581a.bottom;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f33581a.top;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(@NonNull TextView textView) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable();
        materialShapeDrawable.setShapeAppearanceModel(this.f33586f);
        materialShapeDrawable2.setShapeAppearanceModel(this.f33586f);
        materialShapeDrawable.Y(this.f33583c);
        materialShapeDrawable.h0(this.f33585e, this.f33584d);
        textView.setTextColor(this.f33582b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f33582b.withAlpha(30), materialShapeDrawable, materialShapeDrawable2);
        Rect rect = this.f33581a;
        ViewCompat.setBackground(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
