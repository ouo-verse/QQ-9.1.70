package com.tencent.luggage.wxa.qq;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f138959a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f138960b;

    public a(boolean z16, boolean z17) {
        this.f138959a = z16;
        this.f138960b = z17;
    }

    public static a a() {
        return new a(false, false);
    }

    public static a b() {
        return new a(true, false);
    }

    public String toString() {
        return "CommandResult{success=" + this.f138959a + ", shouldKillAllProcess=" + this.f138960b + '}';
    }
}
