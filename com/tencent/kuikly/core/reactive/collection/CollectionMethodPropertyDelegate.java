package com.tencent.kuikly.core.reactive.collection;

import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b0\u0010.J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J#\u0010\u000e\u001a\u00020\r2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\f\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0011\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0015\u001a\u00020\r2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013J*\u0010\u0016\u001a\u00020\r2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013J\"\u0010\u0017\u001a\u00020\r2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013J#\u0010\u0018\u001a\u00020\r2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\f\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0018\u0010\u000fJ#\u0010\u0019\u001a\u00028\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u001b\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nJ+\u0010\u001c\u001a\u00028\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00028\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R$\u0010&\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010%R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020#0'8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R(\u0010/\u001a\u0004\u0018\u00010\u001e2\b\u0010+\u001a\u0004\u0018\u00010\u001e8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010,\"\u0004\b-\u0010.\u00a8\u00061"}, d2 = {"Lcom/tencent/kuikly/core/reactive/collection/CollectionMethodPropertyDelegate;", "T", "Lcom/tencent/kuikly/core/reactive/collection/b;", "", "k", "", "index", "count", h.F, "o", "", "mutableCollection", DTConstants.TAG.ELEMENT, "", "e", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "", "c", "(Ljava/util/List;ILjava/lang/Object;)V", "", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "f", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", DomainData.DOMAIN_NAME, "(Ljava/util/List;I)Ljava/lang/Object;", "i", "p", "(Ljava/util/List;ILjava/lang/Object;)Ljava/lang/Object;", "Lc01/a;", "d", "Lc01/a;", "handler", "Ljava/util/ArrayList;", "Lcom/tencent/kuikly/core/reactive/collection/a;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "collectionOperations", "", "j", "()Ljava/util/List;", "collectionOperation", "value", "()Lc01/a;", "a", "(Lc01/a;)V", "collectionElementChangeHandler", "<init>", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class CollectionMethodPropertyDelegate<T> implements b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private c01.a handler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<a> collectionOperations = new ArrayList<>();

    public CollectionMethodPropertyDelegate(c01.a aVar) {
        this.handler = aVar;
    }

    private final void h(int index, int count) {
        this.collectionOperations.add(new a(1, index, count));
    }

    private final void k() {
        c01.a aVar = this.handler;
        if (aVar != null) {
            aVar.a();
        }
        ReactiveObserver.INSTANCE.a(new Function0<Unit>(this) { // from class: com.tencent.kuikly.core.reactive.collection.CollectionMethodPropertyDelegate$notifyElementChanged$1
            final /* synthetic */ CollectionMethodPropertyDelegate<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ArrayList arrayList;
                arrayList = ((CollectionMethodPropertyDelegate) this.this$0).collectionOperations;
                arrayList.clear();
            }
        });
    }

    private final void o(int index, int count) {
        this.collectionOperations.add(new a(2, index, count));
    }

    @Override // com.tencent.kuikly.core.reactive.collection.b
    public void a(c01.a aVar) {
        this.handler = aVar;
    }

    public final void c(List<T> mutableCollection, int index, T element) {
        Intrinsics.checkNotNullParameter(mutableCollection, "mutableCollection");
        mutableCollection.add(index, element);
        h(index, 1);
        k();
    }

    @Override // com.tencent.kuikly.core.reactive.collection.b
    /* renamed from: d, reason: from getter */
    public c01.a getHandler() {
        return this.handler;
    }

    public final boolean e(Collection<T> mutableCollection, T element) {
        Intrinsics.checkNotNullParameter(mutableCollection, "mutableCollection");
        boolean add = mutableCollection.add(element);
        if (add) {
            h(mutableCollection.size() - 1, 1);
        }
        k();
        return add;
    }

    public final boolean f(Collection<T> mutableCollection, Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(mutableCollection, "mutableCollection");
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean addAll = mutableCollection.addAll(elements);
        if (addAll) {
            h(mutableCollection.size() - elements.size(), elements.size());
        }
        k();
        return addAll;
    }

    public final boolean g(List<T> mutableCollection, int index, Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(mutableCollection, "mutableCollection");
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean addAll = mutableCollection.addAll(index, elements);
        if (addAll) {
            h(index, elements.size());
        }
        k();
        return addAll;
    }

    public final void i(Collection<T> mutableCollection) {
        Intrinsics.checkNotNullParameter(mutableCollection, "mutableCollection");
        int size = mutableCollection.size();
        mutableCollection.clear();
        o(0, size);
        k();
    }

    public List<a> j() {
        return this.collectionOperations;
    }

    public final boolean l(Collection<T> mutableCollection, T element) {
        int indexOf;
        Intrinsics.checkNotNullParameter(mutableCollection, "mutableCollection");
        indexOf = CollectionsKt___CollectionsKt.indexOf((Iterable<? extends Object>) mutableCollection, element);
        boolean remove = mutableCollection.remove(element);
        if (remove) {
            o(indexOf, 1);
        }
        k();
        return remove;
    }

    public final boolean m(Collection<T> mutableCollection, Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(mutableCollection, "mutableCollection");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<? extends T> it = elements.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (l(mutableCollection, it.next())) {
                z16 = true;
            }
        }
        return z16;
    }

    public final T n(List<T> mutableCollection, int index) {
        Intrinsics.checkNotNullParameter(mutableCollection, "mutableCollection");
        T remove = mutableCollection.remove(index);
        if (remove != null) {
            o(index, 1);
        }
        k();
        return remove;
    }

    public final T p(List<T> mutableCollection, int index, T element) {
        Intrinsics.checkNotNullParameter(mutableCollection, "mutableCollection");
        T t16 = mutableCollection.set(index, element);
        if (t16 != null) {
            o(index, 1);
        }
        h(index, 1);
        k();
        return t16;
    }
}
