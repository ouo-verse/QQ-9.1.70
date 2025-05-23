package com.tencent.luggage.wxa.ic;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l0 implements m0 {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentSkipListSet f129933a = new ConcurrentSkipListSet(new a());

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f129934b = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(m0 m0Var, m0 m0Var2) {
            if (m0Var == m0Var2) {
                return 0;
            }
            return m0Var.hashCode() - m0Var2.hashCode();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Function1 {
        public b() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void invoke(m0 m0Var) {
            m0Var.b();
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f129937a;

        public c(String str) {
            this.f129937a = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void invoke(m0 m0Var) {
            m0Var.a(this.f129937a);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Function1 {
        public d() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void invoke(m0 m0Var) {
            m0Var.a();
            return null;
        }
    }

    @Override // com.tencent.luggage.wxa.ic.m0
    public /* synthetic */ void a(int i3) {
        as.b(this, i3);
    }

    @Override // com.tencent.luggage.wxa.ic.m0
    public void b() {
        a(new b());
        this.f129934b.set(true);
        this.f129933a.clear();
    }

    public void c() {
        this.f129933a.clear();
        this.f129934b.set(false);
    }

    public void a(m0 m0Var) {
        if (m0Var == null || this.f129934b.get()) {
            return;
        }
        this.f129933a.add(m0Var);
    }

    public final void a(Function1 function1) {
        Iterator it = new LinkedList(this.f129933a).iterator();
        while (it.hasNext()) {
            function1.invoke((m0) it.next());
        }
    }

    @Override // com.tencent.luggage.wxa.ic.m0
    public void a(String str) {
        a(new c(str));
    }

    @Override // com.tencent.luggage.wxa.ic.m0
    public void a() {
        a(new d());
    }
}
