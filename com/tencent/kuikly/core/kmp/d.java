package com.tencent.kuikly.core.kmp;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010)\n\u0000\n\u0002\u0010+\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b/\u00100J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016J\u0018\u0010\f\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0096\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u0006J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u0006J\u0016\u0010\u001b\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016J\u001e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016J\u0016\u0010\u001c\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016J\u0016\u0010\u001d\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J \u0010 \u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b \u0010!J\u001f\u0010\u0019\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0019\u0010\"J\u0017\u0010#\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b#\u0010\rR$\u0010(\u001a\u0012\u0012\u0004\u0012\u00028\u00000$j\b\u0012\u0004\u0012\u00028\u0000`%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/kuikly/core/kmp/d;", "E", "", DTConstants.TAG.ELEMENT, "", "contains", "(Ljava/lang/Object;)Z", "", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "containsAll", "", "index", "get", "(I)Ljava/lang/Object;", "isEmpty", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "", "iterator", "", "listIterator", "fromIndex", "toIndex", "subList", "add", "remove", "addAll", "removeAll", "retainAll", "", QCircleLpReportDc05507.KEY_CLEAR, "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "(ILjava/lang/Object;)V", "g", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "internalArrayList", "Lcom/tencent/kuikly/core/kmp/c;", "e", "Lcom/tencent/kuikly/core/kmp/c;", "rwLock", "()I", "size", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class d<E> implements List<E>, KMutableList {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<E> internalArrayList = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final c rwLock = new c();

    @Override // java.util.List, java.util.Collection
    public boolean add(E element) {
        this.rwLock.c();
        boolean add = this.internalArrayList.add(element);
        this.rwLock.d();
        return add;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.rwLock.c();
        boolean addAll = this.internalArrayList.addAll(elements);
        this.rwLock.d();
        return addAll;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.rwLock.c();
        this.internalArrayList.clear();
        this.rwLock.d();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object element) {
        this.rwLock.a();
        boolean contains = this.internalArrayList.contains(element);
        this.rwLock.b();
        return contains;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.rwLock.a();
        boolean containsAll = this.internalArrayList.containsAll(elements);
        this.rwLock.b();
        return containsAll;
    }

    public int d() {
        this.rwLock.a();
        int size = this.internalArrayList.size();
        this.rwLock.b();
        return size;
    }

    public E g(int index) {
        this.rwLock.c();
        E remove = this.internalArrayList.remove(index);
        this.rwLock.d();
        return remove;
    }

    @Override // java.util.List
    public E get(int index) {
        this.rwLock.a();
        E e16 = this.internalArrayList.get(index);
        this.rwLock.b();
        return e16;
    }

    @Override // java.util.List
    public int indexOf(Object element) {
        this.rwLock.a();
        int indexOf = this.internalArrayList.indexOf(element);
        this.rwLock.b();
        return indexOf;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        this.rwLock.a();
        boolean isEmpty = this.internalArrayList.isEmpty();
        this.rwLock.b();
        return isEmpty;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        List mutableList;
        this.rwLock.a();
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.internalArrayList);
        this.rwLock.b();
        return mutableList.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object element) {
        this.rwLock.a();
        int lastIndexOf = this.internalArrayList.lastIndexOf(element);
        this.rwLock.b();
        return lastIndexOf;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        List mutableList;
        this.rwLock.a();
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.internalArrayList);
        this.rwLock.b();
        return mutableList.listIterator();
    }

    @Override // java.util.List
    public final /* bridge */ E remove(int i3) {
        return g(i3);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.rwLock.c();
        boolean removeAll = this.internalArrayList.removeAll(elements);
        this.rwLock.d();
        return removeAll;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.rwLock.c();
        boolean retainAll = this.internalArrayList.retainAll(elements);
        this.rwLock.d();
        return retainAll;
    }

    @Override // java.util.List
    public E set(int index, E element) {
        this.rwLock.c();
        E e16 = this.internalArrayList.set(index, element);
        this.rwLock.d();
        return e16;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return d();
    }

    @Override // java.util.List
    public List<E> subList(int fromIndex, int toIndex) {
        List<E> mutableList;
        this.rwLock.a();
        List<E> subList = this.internalArrayList.subList(fromIndex, toIndex);
        Intrinsics.checkNotNullExpressionValue(subList, "internalArrayList.subList(fromIndex, toIndex)");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) subList);
        this.rwLock.b();
        return mutableList;
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object element) {
        this.rwLock.c();
        boolean remove = this.internalArrayList.remove(element);
        this.rwLock.d();
        return remove;
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    @Override // java.util.List
    public void add(int index, E element) {
        this.rwLock.c();
        this.internalArrayList.add(index, element);
        this.rwLock.d();
    }

    @Override // java.util.List
    public boolean addAll(int index, Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.rwLock.c();
        boolean addAll = this.internalArrayList.addAll(index, elements);
        this.rwLock.d();
        return addAll;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int index) {
        List mutableList;
        this.rwLock.a();
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.internalArrayList);
        this.rwLock.b();
        return mutableList.listIterator(index);
    }
}
