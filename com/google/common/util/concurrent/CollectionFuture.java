package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    abstract class CollectionFutureRunningState extends AggregateFuture<V, C>.RunningState {
        private List<Optional<V>> D;
        final /* synthetic */ CollectionFuture this$0;

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        final void k(boolean z16, int i3, @NullableDecl V v3) {
            List<Optional<V>> list = this.D;
            if (list != null) {
                list.set(i3, Optional.fromNullable(v3));
            } else {
                if (z16) {
                    com.google.common.base.j.t(true, "Future was done before all dependencies completed");
                    return;
                }
                throw null;
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        final void m() {
            List<Optional<V>> list = this.D;
            list.getClass();
            s(list);
            throw null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void r() {
            super.r();
            this.D = null;
        }

        abstract C s(List<Optional<V>> list);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class ListFuture<V> extends CollectionFuture<V, List<V>> {

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private final class ListFutureRunningState extends CollectionFuture<V, List<V>>.CollectionFutureRunningState {
            final /* synthetic */ ListFuture this$0;

            @Override // com.google.common.util.concurrent.CollectionFuture.CollectionFutureRunningState
            /* renamed from: t, reason: merged with bridge method [inline-methods] */
            public List<V> s(List<Optional<V>> list) {
                V v3;
                ArrayList l3 = Lists.l(list.size());
                for (Optional<V> optional : list) {
                    if (optional != null) {
                        v3 = optional.orNull();
                    } else {
                        v3 = null;
                    }
                    l3.add(v3);
                }
                return Collections.unmodifiableList(l3);
            }
        }
    }
}
