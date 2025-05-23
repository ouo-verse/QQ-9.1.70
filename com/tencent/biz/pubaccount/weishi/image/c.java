package com.tencent.biz.pubaccount.weishi.image;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f80888a;

    /* renamed from: b, reason: collision with root package name */
    private String f80889b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f80890c;

    /* renamed from: d, reason: collision with root package name */
    private String f80891d;

    /* renamed from: e, reason: collision with root package name */
    private int f80892e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f80893f = true;

    /* renamed from: g, reason: collision with root package name */
    private iy.a f80894g;

    public c(ImageView imageView, String str) {
        this.f80888a = imageView;
        this.f80889b = str;
    }

    public ImageView a() {
        return this.f80888a;
    }

    public int b() {
        return this.f80892e;
    }

    public iy.a c() {
        return this.f80894g;
    }

    public String d() {
        return this.f80889b;
    }

    public Drawable e() {
        return this.f80890c;
    }

    public String f() {
        return this.f80891d;
    }

    public boolean g() {
        return this.f80893f;
    }

    public c h(boolean z16) {
        this.f80893f = z16;
        return this;
    }

    public c i(int i3) {
        this.f80892e = i3;
        return this;
    }

    public c j(Drawable drawable) {
        this.f80890c = drawable;
        return this;
    }

    public c k(String str) {
        this.f80891d = str;
        return this;
    }

    public String toString() {
        Object obj;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ImageView:");
        ImageView imageView = this.f80888a;
        if (imageView != null) {
            obj = Integer.valueOf(imageView.hashCode());
        } else {
            obj = "";
        }
        sb5.append(obj);
        sb5.append(", sopName:");
        sb5.append(this.f80891d);
        sb5.append(", listIndex:");
        sb5.append(this.f80892e);
        sb5.append(", isNeedReport:");
        sb5.append(this.f80893f);
        sb5.append(", path:");
        sb5.append(this.f80889b);
        return sb5.toString();
    }
}
