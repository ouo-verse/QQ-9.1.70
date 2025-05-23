package com.tencent.biz.qqcircle.richframework.widget.menu;

import android.graphics.drawable.Drawable;
import rb0.e;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    protected int f92217a;

    /* renamed from: b, reason: collision with root package name */
    protected String f92218b;

    /* renamed from: c, reason: collision with root package name */
    protected Drawable f92219c;

    /* renamed from: d, reason: collision with root package name */
    private rb0.c f92220d = new e();

    public b(int i3, String str, Drawable drawable) {
        this.f92217a = i3;
        this.f92218b = str;
        this.f92219c = drawable;
    }

    public int a() {
        return this.f92217a;
    }

    public rb0.c b() {
        return this.f92220d;
    }

    public String c() {
        return this.f92218b;
    }

    public void d(rb0.c cVar) {
        this.f92220d = cVar;
    }

    public String toString() {
        return "QQCustomMenuItem{title='" + this.f92218b + '\'';
    }
}
