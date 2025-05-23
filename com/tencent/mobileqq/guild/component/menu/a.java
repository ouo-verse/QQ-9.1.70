package com.tencent.mobileqq.guild.component.menu;

import android.graphics.drawable.Drawable;
import rg1.d;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected int f215941a;

    /* renamed from: b, reason: collision with root package name */
    protected String f215942b;

    /* renamed from: c, reason: collision with root package name */
    protected Drawable f215943c;

    /* renamed from: d, reason: collision with root package name */
    private rg1.b f215944d = new d();

    public a(int i3, String str, Drawable drawable) {
        this.f215941a = i3;
        this.f215942b = str;
        this.f215943c = drawable;
    }

    public int a() {
        return this.f215941a;
    }

    public rg1.b b() {
        return this.f215944d;
    }

    public String c() {
        return this.f215942b;
    }

    public void d(rg1.b bVar) {
        this.f215944d = bVar;
    }

    public String toString() {
        return "QQCustomMenuItem{title='" + this.f215942b + '\'';
    }
}
