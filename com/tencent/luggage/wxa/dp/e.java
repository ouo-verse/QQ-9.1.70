package com.tencent.luggage.wxa.dp;

import com.tencent.luggage.wxa.dp.a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e implements Iterable {

    /* renamed from: b, reason: collision with root package name */
    public static final b f124420b = new b();

    /* renamed from: a, reason: collision with root package name */
    public final List f124421a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements a.InterfaceC6145a {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.dp.a.InterfaceC6145a
        public Iterable a(Iterable iterable) {
            return iterable;
        }
    }

    public e(List list) {
        this.f124421a = list;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new com.tencent.luggage.wxa.dp.b(this.f124421a.iterator(), f124420b);
    }

    public e(Iterable... iterableArr) {
        this(Arrays.asList(iterableArr));
    }
}
