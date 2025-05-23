package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ag extends d<String> implements ah, RandomAccess {

    /* renamed from: f, reason: collision with root package name */
    private static final ag f35655f;

    /* renamed from: h, reason: collision with root package name */
    public static final ah f35656h;

    /* renamed from: e, reason: collision with root package name */
    private final List<Object> f35657e;

    static {
        ag agVar = new ag();
        f35655f = agVar;
        agVar.y();
        f35656h = agVar;
    }

    public ag() {
        this(10);
    }

    private static ByteString h(Object obj) {
        if (obj instanceof ByteString) {
            return (ByteString) obj;
        }
        if (obj instanceof String) {
            return ByteString.copyFromUtf8((String) obj);
        }
        return ByteString.copyFrom((byte[]) obj);
    }

    private static String i(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            return ((ByteString) obj).toStringUtf8();
        }
        return ad.l((byte[]) obj);
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.protobuf.ah
    public Object c(int i3) {
        return this.f35657e.get(i3);
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        d();
        this.f35657e.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.protobuf.ah
    public void f(ByteString byteString) {
        d();
        this.f35657e.add(byteString);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void add(int i3, String str) {
        d();
        this.f35657e.add(i3, str);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.ah
    public ByteString getByteString(int i3) {
        Object obj = this.f35657e.get(i3);
        ByteString h16 = h(obj);
        if (h16 != obj) {
            this.f35657e.set(i3, h16);
        }
        return h16;
    }

    @Override // com.google.protobuf.ah
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.f35657e);
    }

    @Override // com.google.protobuf.ah
    public ah getUnmodifiableView() {
        if (z()) {
            return new cg(this);
        }
        return this;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public String get(int i3) {
        Object obj = this.f35657e.get(i3);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.f35657e.set(i3, stringUtf8);
            }
            return stringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        String l3 = ad.l(bArr);
        if (ad.i(bArr)) {
            this.f35657e.set(i3, l3);
        }
        return l3;
    }

    @Override // com.google.protobuf.ad.j, com.google.protobuf.ad.f
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public ag b2(int i3) {
        if (i3 >= size()) {
            ArrayList arrayList = new ArrayList(i3);
            arrayList.addAll(this.f35657e);
            return new ag((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public String remove(int i3) {
        d();
        Object remove = this.f35657e.remove(i3);
        ((AbstractList) this).modCount++;
        return i(remove);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public String set(int i3, String str) {
        d();
        return i(this.f35657e.set(i3, str));
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f35657e.size();
    }

    @Override // com.google.protobuf.d, com.google.protobuf.ad.j
    public /* bridge */ /* synthetic */ boolean z() {
        return super.z();
    }

    public ag(int i3) {
        this((ArrayList<Object>) new ArrayList(i3));
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.List
    public boolean addAll(int i3, Collection<? extends String> collection) {
        d();
        if (collection instanceof ah) {
            collection = ((ah) collection).getUnderlyingElements();
        }
        boolean addAll = this.f35657e.addAll(i3, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public ag(ah ahVar) {
        this.f35657e = new ArrayList(ahVar.size());
        addAll(ahVar);
    }

    ag(ArrayList<Object> arrayList) {
        this.f35657e = arrayList;
    }
}
