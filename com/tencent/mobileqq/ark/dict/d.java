package com.tencent.mobileqq.ark.dict;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public int f199447a;

    /* renamed from: b, reason: collision with root package name */
    public String f199448b;

    /* renamed from: c, reason: collision with root package name */
    public String f199449c;

    /* renamed from: d, reason: collision with root package name */
    public String f199450d;

    /* renamed from: e, reason: collision with root package name */
    public String f199451e;

    /* renamed from: f, reason: collision with root package name */
    public String f199452f;

    /* renamed from: g, reason: collision with root package name */
    public String f199453g;

    /* renamed from: h, reason: collision with root package name */
    public String f199454h;

    public boolean a() {
        if (!TextUtils.isEmpty(this.f199452f) && !TextUtils.isEmpty(this.f199453g) && !TextUtils.isEmpty(this.f199454h)) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f199447a >= 0 && !TextUtils.isEmpty(this.f199448b) && !TextUtils.isEmpty(this.f199449c) && !TextUtils.isEmpty(this.f199450d) && !TextUtils.isEmpty(this.f199451e)) {
            return true;
        }
        return false;
    }

    public void c() {
        this.f199452f = null;
        this.f199453g = null;
        this.f199454h = null;
    }
}
