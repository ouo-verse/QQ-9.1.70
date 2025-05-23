package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected int f303960a;

    /* renamed from: b, reason: collision with root package name */
    private Object f303961b;

    /* renamed from: c, reason: collision with root package name */
    private long f303962c;

    a() {
    }

    public static a c(int i3, Object obj) {
        a aVar = new a();
        aVar.f303960a = i3;
        aVar.f303961b = obj;
        aVar.f303962c = Thread.currentThread().getId();
        return aVar;
    }

    public int a() {
        return this.f303960a;
    }

    public Object b() {
        return this.f303961b;
    }

    public String toString() {
        return "Id = [" + this.f303960a + "], thread id = [" + this.f303962c + "] , message = [" + this.f303961b + "]";
    }
}
