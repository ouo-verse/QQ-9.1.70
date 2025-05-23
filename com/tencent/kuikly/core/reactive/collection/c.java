package com.tencent.kuikly.core.reactive.collection;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B3\u0012\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010/\u0012\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000(\u00a2\u0006\u0004\b:\u0010;J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0096\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001J\u0018\u0010\r\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00028\u0000H\u0096\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0005H\u0096\u0001J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0096\u0003J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00028\u0000H\u0096\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0010J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0001J\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0001J\u0017\u0010\u0017\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001J\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0096\u0001J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u0007J\u0016\u0010\u001c\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u001f\u0010\u001b\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001fJ\u001e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0017\u0010 \u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b \u0010\u000eJ\u0017\u0010!\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b!\u0010\u0007J \u0010\"\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0016\u0010$\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020\u000b8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u001e\u00103\u001a\u0004\u0018\u00010/8\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b%\u00100\"\u0004\b1\u00102R\u001a\u00108\u001a\b\u0012\u0004\u0012\u000205048\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b6\u00107\u00a8\u0006<"}, d2 = {"Lcom/tencent/kuikly/core/reactive/collection/c;", "T", "", "Lcom/tencent/kuikly/core/reactive/collection/b;", DTConstants.TAG.ELEMENT, "", "contains", "(Ljava/lang/Object;)Z", "", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "containsAll", "", "index", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "", "iterator", "lastIndexOf", "", "listIterator", "retainAll", "fromIndex", "toIndex", "subList", "add", "addAll", "", QCircleLpReportDc05507.KEY_CLEAR, "(ILjava/lang/Object;)V", "i", "remove", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "removeAll", "d", "Ljava/util/List;", "innerList", "Lcom/tencent/kuikly/core/reactive/collection/CollectionMethodPropertyDelegate;", "e", "Lcom/tencent/kuikly/core/reactive/collection/CollectionMethodPropertyDelegate;", "collectionMethodPropertyDelegate", h.F, "()I", "size", "Lc01/a;", "()Lc01/a;", "a", "(Lc01/a;)V", "collectionElementChangeHandler", "", "Lcom/tencent/kuikly/core/reactive/collection/a;", "g", "()Ljava/util/List;", "collectionOperation", "handler", "<init>", "(Ljava/util/List;Lc01/a;Lcom/tencent/kuikly/core/reactive/collection/CollectionMethodPropertyDelegate;)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c<T> implements List<T>, b, KMutableList {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<T> innerList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final CollectionMethodPropertyDelegate<T> collectionMethodPropertyDelegate;

    public c() {
        this(null, null, null, 7, null);
    }

    @Override // com.tencent.kuikly.core.reactive.collection.b
    public void a(c01.a aVar) {
        this.collectionMethodPropertyDelegate.a(aVar);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T element) {
        return this.collectionMethodPropertyDelegate.e(this.innerList, element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.collectionMethodPropertyDelegate.f(this.innerList, elements);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.collectionMethodPropertyDelegate.i(this.innerList);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object element) {
        return this.innerList.contains(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.innerList.containsAll(elements);
    }

    @Override // com.tencent.kuikly.core.reactive.collection.b
    /* renamed from: d */
    public c01.a getHandler() {
        return this.collectionMethodPropertyDelegate.getHandler();
    }

    public List<a> g() {
        return this.collectionMethodPropertyDelegate.j();
    }

    @Override // java.util.List
    public T get(int index) {
        return this.innerList.get(index);
    }

    public int h() {
        return this.innerList.size();
    }

    public T i(int index) {
        return this.collectionMethodPropertyDelegate.n(this.innerList, index);
    }

    @Override // java.util.List
    public int indexOf(Object element) {
        return this.innerList.indexOf(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.innerList.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return this.innerList.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object element) {
        return this.innerList.lastIndexOf(element);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return this.innerList.listIterator();
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int i3) {
        return i(i3);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.collectionMethodPropertyDelegate.m(this.innerList, elements);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.innerList.retainAll(elements);
    }

    @Override // java.util.List
    public T set(int index, T element) {
        return this.collectionMethodPropertyDelegate.p(this.innerList, index, element);
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return h();
    }

    @Override // java.util.List
    public List<T> subList(int fromIndex, int toIndex) {
        return this.innerList.subList(fromIndex, toIndex);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public c(List<T> innerList, c01.a aVar, CollectionMethodPropertyDelegate<T> collectionMethodPropertyDelegate) {
        Intrinsics.checkNotNullParameter(innerList, "innerList");
        Intrinsics.checkNotNullParameter(collectionMethodPropertyDelegate, "collectionMethodPropertyDelegate");
        this.innerList = innerList;
        this.collectionMethodPropertyDelegate = collectionMethodPropertyDelegate;
    }

    @Override // java.util.List
    public void add(int index, T element) {
        this.collectionMethodPropertyDelegate.c(this.innerList, index, element);
    }

    @Override // java.util.List
    public boolean addAll(int index, Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.collectionMethodPropertyDelegate.g(this.innerList, index, elements);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int index) {
        return this.innerList.listIterator(index);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object element) {
        return this.collectionMethodPropertyDelegate.l(this.innerList, element);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ c(List list, c01.a aVar, CollectionMethodPropertyDelegate collectionMethodPropertyDelegate, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, aVar, (i3 & 4) != 0 ? new CollectionMethodPropertyDelegate(aVar) : collectionMethodPropertyDelegate);
        list = (i3 & 1) != 0 ? new ArrayList() : list;
        aVar = (i3 & 2) != 0 ? null : aVar;
    }
}
