package com.xiaomi.push;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    private LinkedList<a> f389870a = new LinkedList<>();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a {

        /* renamed from: d, reason: collision with root package name */
        private static final z f389871d = new z();

        /* renamed from: a, reason: collision with root package name */
        public int f389872a;

        /* renamed from: b, reason: collision with root package name */
        public String f389873b;

        /* renamed from: c, reason: collision with root package name */
        public Object f389874c;

        a(int i3, Object obj) {
            this.f389872a = i3;
            this.f389874c = obj;
        }
    }

    public static z b() {
        return a.f389871d;
    }

    private void d() {
        if (this.f389870a.size() > 100) {
            this.f389870a.removeFirst();
        }
    }

    public synchronized int a() {
        return this.f389870a.size();
    }

    public synchronized LinkedList<a> c() {
        LinkedList<a> linkedList;
        linkedList = this.f389870a;
        this.f389870a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void e(Object obj) {
        this.f389870a.add(new a(0, obj));
        d();
    }
}
