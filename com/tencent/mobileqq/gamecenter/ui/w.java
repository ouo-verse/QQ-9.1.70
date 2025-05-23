package com.tencent.mobileqq.gamecenter.ui;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* compiled from: P */
/* loaded from: classes12.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public final String f213384a;

    /* renamed from: b, reason: collision with root package name */
    public final int f213385b;

    /* renamed from: c, reason: collision with root package name */
    public final Drawable f213386c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f213387d;

    w(String str, int i3, Drawable drawable, Drawable drawable2) {
        this.f213384a = str;
        this.f213385b = i3;
        this.f213386c = drawable;
        this.f213387d = drawable2;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public static w b(Resources resources, int i3, int i16, int i17, int i18) {
        return new w(resources.getString(i3), resources.getColor(i16), c(resources.getColor(i17), com.tencent.mobileqq.gamecenter.util.a.a(2.0f, resources)), resources.getDrawable(i18));
    }

    static Drawable c(int i3, int i16) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(i16);
        gradientDrawable.setColor(i3);
        return gradientDrawable;
    }

    public String a(int i3) {
        return this.f213384a + i3;
    }
}
