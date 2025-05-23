package com.tencent.luggage.wxa.kj;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b implements n1 {

    /* renamed from: a, reason: collision with root package name */
    public final o1 f132073a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedList f132074b = new LinkedList();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends com.tencent.luggage.wxa.h6.g {

        /* renamed from: b, reason: collision with root package name */
        public m1 f132075b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ListIterator f132076c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ListIterator listIterator, ListIterator listIterator2) {
            super(listIterator);
            this.f132076c = listIterator2;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public m1 next() {
            m1 m1Var = (m1) this.f132076c.next();
            this.f132075b = m1Var;
            return m1Var;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.f132076c.remove();
            if (this.f132075b != null && b.this.f132073a != null) {
                b.this.f132073a.a(this.f132075b);
            }
        }
    }

    public b(o1 o1Var) {
        this.f132073a = o1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(m1 m1Var) {
        this.f132073a.a(m1Var);
    }

    @Override // com.tencent.luggage.wxa.kj.n1
    public void clear() {
        this.f132074b.clear();
    }

    @Override // com.tencent.luggage.wxa.kj.n1
    public boolean isEmpty() {
        return this.f132074b.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        ListIterator listIterator = (ListIterator) this.f132074b.iterator();
        return new a(listIterator, listIterator);
    }

    @Override // com.tencent.luggage.wxa.kj.n1
    public boolean pop() {
        if (size() >= 1) {
            final m1 m1Var = (m1) this.f132074b.removeLast();
            if (this.f132073a != null) {
                com.tencent.luggage.wxa.tn.c0.a(new Runnable() { // from class: b31.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.tencent.luggage.wxa.kj.b.this.b(m1Var);
                    }
                });
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.kj.n1
    public int size() {
        return this.f132074b.size();
    }

    @Override // com.tencent.luggage.wxa.kj.n1
    public m1 a() {
        return (m1) this.f132074b.peekLast();
    }

    @Override // com.tencent.luggage.wxa.kj.n1
    public void a(m1 m1Var) {
        this.f132074b.addLast(m1Var);
    }
}
