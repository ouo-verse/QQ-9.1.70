package com.tencent.luggage.wxa.xo;

import java.util.Stack;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    public static g f145237b = new g();

    /* renamed from: a, reason: collision with root package name */
    public ThreadLocal f145238a = new ThreadLocal();

    public static g a() {
        return f145237b;
    }

    public d b() {
        Stack stack = (Stack) this.f145238a.get();
        if (stack == null || stack.size() == 0) {
            return null;
        }
        return (d) ((Stack) this.f145238a.get()).peek();
    }

    public void c() {
        ((Stack) this.f145238a.get()).pop();
    }

    public void a(d dVar) {
        Stack stack = (Stack) this.f145238a.get();
        if (stack == null) {
            stack = new Stack();
            this.f145238a.set(stack);
        }
        stack.push(dVar);
    }
}
