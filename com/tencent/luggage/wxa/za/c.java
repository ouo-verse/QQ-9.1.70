package com.tencent.luggage.wxa.za;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public int f146458b;

    /* renamed from: c, reason: collision with root package name */
    public int f146459c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence f146460d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f146461e;

    /* renamed from: f, reason: collision with root package name */
    public TextPaint f146462f;

    /* renamed from: g, reason: collision with root package name */
    public Layout.Alignment f146463g;

    /* renamed from: h, reason: collision with root package name */
    public TextUtils.TruncateAt f146464h;

    /* renamed from: i, reason: collision with root package name */
    public int f146465i;

    /* renamed from: k, reason: collision with root package name */
    public StaticLayout f146467k;

    /* renamed from: a, reason: collision with root package name */
    public boolean f146457a = true;

    /* renamed from: j, reason: collision with root package name */
    public int f146466j = -1;

    public c(StaticLayout staticLayout) {
        this.f146467k = staticLayout;
    }

    public StaticLayout a() {
        return this.f146467k;
    }

    public void b(CharSequence charSequence) {
        this.f146461e = charSequence;
    }

    public void c(int i3) {
        this.f146459c = i3;
    }

    public void d(int i3) {
        this.f146458b = i3;
    }

    public void a(CharSequence charSequence) {
        this.f146460d = charSequence;
    }

    public void b(int i3) {
        this.f146465i = i3;
    }

    public void a(TextPaint textPaint) {
        this.f146462f = textPaint;
    }

    public void a(Layout.Alignment alignment) {
        this.f146463g = alignment;
    }

    public void a(TextUtils.TruncateAt truncateAt) {
        this.f146464h = truncateAt;
    }

    public void a(int i3) {
        this.f146466j = i3;
    }
}
