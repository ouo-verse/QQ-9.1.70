package com.tencent.qqlive.common.ratelimit;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b<E> {

    /* renamed from: a, reason: collision with root package name */
    private int f345191a;

    /* renamed from: b, reason: collision with root package name */
    private LinkedList<E> f345192b = new LinkedList<>();

    public b(int i3) {
        this.f345191a = i3;
    }

    public void a() {
        this.f345192b.clear();
    }

    public E b() {
        return this.f345192b.getFirst();
    }

    public void c(E e16) {
        if (this.f345192b.size() >= this.f345191a) {
            this.f345192b.poll();
        }
        this.f345192b.offer(e16);
    }

    public int d() {
        return this.f345192b.size();
    }
}
