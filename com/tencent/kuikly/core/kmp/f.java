package com.tencent.kuikly.core.kmp;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002J\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\r\u0010\u0007J\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u0007J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0016\u0010\u0010\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0016\u0010\u0011\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R$\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0014j\b\u0012\u0004\u0012\u00028\u0000`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/kuikly/core/kmp/f;", "E", "", "", "isEmpty", DTConstants.TAG.ELEMENT, "contains", "(Ljava/lang/Object;)Z", "", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "containsAll", "", "iterator", "add", "remove", "addAll", "removeAll", "retainAll", "", QCircleLpReportDc05507.KEY_CLEAR, "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "d", "Ljava/util/HashSet;", "internalHashSet", "Lcom/tencent/kuikly/core/kmp/c;", "e", "Lcom/tencent/kuikly/core/kmp/c;", "rwLock", "", "()I", "size", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class f<E> implements Set<E>, KMutableSet {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final HashSet<E> internalHashSet = new HashSet<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final c rwLock = new c();

    @Override // java.util.Set, java.util.Collection
    public boolean add(E element) {
        this.rwLock.c();
        boolean add = this.internalHashSet.add(element);
        this.rwLock.d();
        return add;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.rwLock.c();
        boolean addAll = this.internalHashSet.addAll(elements);
        this.rwLock.d();
        return addAll;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.rwLock.c();
        this.internalHashSet.clear();
        this.rwLock.d();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object element) {
        this.rwLock.a();
        boolean contains = this.internalHashSet.contains(element);
        this.rwLock.b();
        return contains;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.rwLock.a();
        boolean containsAll = this.internalHashSet.containsAll(elements);
        this.rwLock.b();
        return containsAll;
    }

    public int d() {
        this.rwLock.a();
        int size = this.internalHashSet.size();
        this.rwLock.b();
        return size;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        this.rwLock.a();
        boolean isEmpty = this.internalHashSet.isEmpty();
        this.rwLock.b();
        return isEmpty;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        Set mutableSet;
        this.rwLock.a();
        mutableSet = CollectionsKt___CollectionsKt.toMutableSet(this.internalHashSet);
        this.rwLock.b();
        return mutableSet.iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object element) {
        this.rwLock.c();
        boolean remove = this.internalHashSet.remove(element);
        this.rwLock.d();
        return remove;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.rwLock.c();
        boolean removeAll = this.internalHashSet.removeAll(elements);
        this.rwLock.d();
        return removeAll;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        this.rwLock.c();
        boolean retainAll = this.internalHashSet.retainAll(elements);
        this.rwLock.d();
        return retainAll;
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return d();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }
}
