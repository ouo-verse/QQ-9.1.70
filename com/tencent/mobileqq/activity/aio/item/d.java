package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes10.dex */
abstract class d {

    /* renamed from: a, reason: collision with root package name */
    protected int f179453a;

    /* renamed from: b, reason: collision with root package name */
    protected int f179454b;

    /* renamed from: c, reason: collision with root package name */
    protected String f179455c;

    /* renamed from: d, reason: collision with root package name */
    protected String f179456d;

    /* renamed from: e, reason: collision with root package name */
    protected a f179457e;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    interface a {
        void onComplete();
    }

    public abstract void a();

    public String b() {
        return this.f179456d;
    }

    public int c() {
        return this.f179454b;
    }

    public boolean d(String str) {
        a();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.f179455c = str;
        this.f179454b = -1;
        return true;
    }

    public abstract boolean e(String str);

    public void f(a aVar) {
        this.f179457e = aVar;
    }

    public void g(int i3) {
        this.f179453a = i3;
    }
}
