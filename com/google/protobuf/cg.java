package com.google.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: P */
/* loaded from: classes2.dex */
public class cg extends AbstractList<String> implements ah, RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    private final ah f35812d;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements ListIterator<String> {

        /* renamed from: d, reason: collision with root package name */
        ListIterator<String> f35813d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f35814e;

        a(int i3) {
            this.f35814e = i3;
            this.f35813d = cg.this.f35812d.listIterator(i3);
        }

        @Override // java.util.ListIterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            return this.f35813d.next();
        }

        @Override // java.util.ListIterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String previous() {
            return this.f35813d.previous();
        }

        @Override // java.util.ListIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f35813d.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f35813d.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f35813d.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f35813d.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b implements Iterator<String> {

        /* renamed from: d, reason: collision with root package name */
        Iterator<String> f35816d;

        b() {
            this.f35816d = cg.this.f35812d.iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            return this.f35816d.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f35816d.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public cg(ah ahVar) {
        this.f35812d = ahVar;
    }

    @Override // com.google.protobuf.ah
    public Object c(int i3) {
        return this.f35812d.c(i3);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public String get(int i3) {
        return this.f35812d.get(i3);
    }

    @Override // com.google.protobuf.ah
    public void f(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.ah
    public ByteString getByteString(int i3) {
        return this.f35812d.getByteString(i3);
    }

    @Override // com.google.protobuf.ah
    public List<?> getUnderlyingElements() {
        return this.f35812d.getUnderlyingElements();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i3) {
        return new a(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f35812d.size();
    }

    @Override // com.google.protobuf.ah
    public ah getUnmodifiableView() {
        return this;
    }
}
