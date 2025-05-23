package com.tencent.luggage.wxa.ic;

import androidx.core.util.Consumer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentSkipListSet;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k0 implements d0 {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentSkipListSet f129914a = new ConcurrentSkipListSet(new a());

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d0 d0Var, d0 d0Var2) {
            if (d0Var == d0Var2) {
                return 0;
            }
            return d0Var.hashCode() - d0Var2.hashCode();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Consumer {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f129916a;

        public b(v vVar) {
            this.f129916a = vVar;
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(d0 d0Var) {
            d0Var.a(this.f129916a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Consumer {
        public c() {
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(d0 d0Var) {
            d0Var.a();
        }
    }

    public final void a(Consumer consumer) {
        Iterator it = new LinkedList(this.f129914a).iterator();
        while (it.hasNext()) {
            consumer.accept((d0) it.next());
        }
    }

    @Override // com.tencent.luggage.wxa.ic.d0
    public void a(v vVar) {
        a(new b(vVar));
    }

    @Override // com.tencent.luggage.wxa.ic.d0
    public void a() {
        a(new c());
    }

    public void a(d0 d0Var) {
        if (d0Var != null) {
            this.f129914a.add(d0Var);
        }
    }
}
