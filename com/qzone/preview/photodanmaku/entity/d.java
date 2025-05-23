package com.qzone.preview.photodanmaku.entity;

import com.qzone.proxy.feedcomponent.util.j;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d<T> {

    /* renamed from: b, reason: collision with root package name */
    private final Comparator<T> f49981b;

    /* renamed from: c, reason: collision with root package name */
    private int f49982c = 0;

    /* renamed from: a, reason: collision with root package name */
    private final a<T> f49980a = new a<>();

    public d(Comparator<T> comparator) {
        this.f49981b = comparator;
    }

    public boolean a(T t16) {
        a<T> aVar = this.f49980a.f49984b;
        while (aVar != this.f49980a && this.f49981b.compare(aVar.f49983a, t16) < 0) {
            aVar = aVar.f49984b;
        }
        a<T> aVar2 = new a<>(t16, aVar, aVar.f49985c);
        aVar.f49985c.f49984b = aVar2;
        aVar.f49985c = aVar2;
        this.f49982c++;
        return true;
    }

    public boolean b(T t16) {
        a<T> aVar = this.f49980a.f49985c;
        while (aVar != this.f49980a && this.f49981b.compare(aVar.f49983a, t16) > 0) {
            aVar = aVar.f49985c;
        }
        a<T> aVar2 = new a<>(t16, aVar.f49984b, aVar);
        aVar.f49984b.f49985c = aVar2;
        aVar.f49984b = aVar2;
        this.f49982c++;
        return true;
    }

    public void c() {
        a<T> aVar = this.f49980a;
        aVar.f49984b = aVar;
        aVar.f49985c = aVar;
        this.f49982c = 0;
    }

    public List<T> d(T t16, List<T> list) {
        a<T> aVar = this.f49980a.f49984b;
        while (aVar != this.f49980a && this.f49981b.compare(aVar.f49983a, t16) <= 0) {
            j.a("PhotoDanmakuDataSource", 2, "befor removeLessThanData - mDrawingDanmakuList - added");
            list.add(aVar.f49983a);
            this.f49982c--;
            aVar = aVar.f49984b;
        }
        a<T> aVar2 = this.f49980a;
        aVar2.f49984b = aVar;
        aVar.f49985c = aVar2;
        return list;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final T f49983a;

        /* renamed from: b, reason: collision with root package name */
        public a<T> f49984b;

        /* renamed from: c, reason: collision with root package name */
        public a<T> f49985c;

        public a() {
            this.f49983a = null;
            this.f49984b = this;
            this.f49985c = this;
        }

        public a(T t16, a<T> aVar, a<T> aVar2) {
            this.f49983a = t16;
            this.f49984b = aVar;
            this.f49985c = aVar2;
        }
    }
}
