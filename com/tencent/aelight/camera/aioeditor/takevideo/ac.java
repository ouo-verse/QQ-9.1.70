package com.tencent.aelight.camera.aioeditor.takevideo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ac {

    /* renamed from: a, reason: collision with root package name */
    private List<a> f67930a = new LinkedList();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void G();

        void X(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        static final ac f67931a = new ac();
    }

    ac() {
    }

    public static ac a() {
        return b.f67931a;
    }

    public void b() {
        Iterator<a> it = this.f67930a.iterator();
        while (it.hasNext()) {
            it.next().G();
        }
    }

    public void c(boolean z16) {
        Iterator<a> it = this.f67930a.iterator();
        while (it.hasNext()) {
            it.next().X(z16);
        }
    }

    public boolean d(a aVar) {
        return this.f67930a.add(aVar);
    }

    public boolean e(a aVar) {
        return this.f67930a.remove(aVar);
    }
}
