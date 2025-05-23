package com.tencent.icgame.common.ratelimit;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b<E> {

    /* renamed from: a, reason: collision with root package name */
    private int f114845a;

    /* renamed from: b, reason: collision with root package name */
    private LinkedList<E> f114846b = new LinkedList<>();

    public b(int i3) {
        this.f114845a = i3;
    }

    public void a() {
        this.f114846b.clear();
    }

    public E b() {
        return this.f114846b.getFirst();
    }

    public void c(E e16) {
        if (this.f114846b.size() >= this.f114845a) {
            this.f114846b.poll();
        }
        this.f114846b.offer(e16);
    }

    public int d() {
        return this.f114846b.size();
    }
}
