package com.tencent.luggage.wxa.s8;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f140125a;

        /* renamed from: b, reason: collision with root package name */
        public int f140126b;

        /* renamed from: c, reason: collision with root package name */
        public int f140127c;

        public b a(int i3, int i16, int i17) {
            this.f140125a = i3;
            this.f140126b = i16;
            this.f140127c = i17;
            return this;
        }

        public String toString() {
            return "[" + this.f140125a + ", " + this.f140126b + ", " + this.f140127c + "]";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f140128a;

        /* renamed from: b, reason: collision with root package name */
        public int f140129b;

        /* renamed from: c, reason: collision with root package name */
        public int f140130c;

        /* renamed from: d, reason: collision with root package name */
        public int f140131d;

        public c a(int i3, int i16, int i17, int i18) {
            this.f140128a = i3;
            this.f140129b = i16;
            this.f140130c = i17;
            this.f140131d = i18;
            return this;
        }

        public String toString() {
            return "[" + this.f140128a + ", " + this.f140129b + ", " + this.f140130c + ", " + this.f140131d + "]";
        }
    }

    void a(int i3, int i16, Rect rect);

    void init(int i3, int i16);

    void reset();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Queue f140124a = new LinkedList();

        public b a() {
            b bVar = (b) this.f140124a.poll();
            return bVar == null ? new b() : bVar;
        }

        public void a(b bVar) {
            this.f140124a.offer(bVar);
        }

        public void a(ArrayList arrayList) {
            if (arrayList == null || arrayList.isEmpty()) {
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f140124a.offer((b) it.next());
            }
            arrayList.clear();
        }
    }
}
