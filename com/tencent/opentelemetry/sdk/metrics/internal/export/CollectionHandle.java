package com.tencent.opentelemetry.sdk.metrics.internal.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class CollectionHandle {
    static IPatchRedirector $redirector_;
    private final int index;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class CollectionHandleSet extends AbstractSet<CollectionHandle> {
        static IPatchRedirector $redirector_;
        private final BitSet storage;

        /* compiled from: P */
        /* loaded from: classes22.dex */
        private class MyIterator implements Iterator<CollectionHandle> {
            static IPatchRedirector $redirector_;
            private int currentIndex;

            MyIterator() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    this.currentIndex = 0;
                } else {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) CollectionHandleSet.this);
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (this.currentIndex != -1 && CollectionHandleSet.this.storage.nextSetBit(this.currentIndex) != -1) {
                    return true;
                }
                return false;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public CollectionHandle next() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (CollectionHandle) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                int nextSetBit = CollectionHandleSet.this.storage.nextSetBit(this.currentIndex);
                if (nextSetBit != -1) {
                    this.currentIndex = nextSetBit + 1;
                    return new CollectionHandle(nextSetBit, null);
                }
                throw new NoSuchElementException("Called `.next` on iterator with no remaining values.");
            }

            /* synthetic */ MyIterator(CollectionHandleSet collectionHandleSet, AnonymousClass1 anonymousClass1) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                    return;
                }
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) collectionHandleSet, (Object) anonymousClass1);
            }
        }

        CollectionHandleSet() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.storage = new BitSet();
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
            }
            if (obj instanceof CollectionHandle) {
                return this.storage.get(((CollectionHandle) obj).index);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) collection)).booleanValue();
            }
            if (collection instanceof CollectionHandleSet) {
                BitSet bitSet = (BitSet) this.storage.clone();
                BitSet bitSet2 = ((CollectionHandleSet) collection).storage;
                bitSet.and(bitSet2);
                return bitSet.equals(bitSet2);
            }
            return super.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<CollectionHandle> iterator() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Iterator) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new MyIterator(this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.storage.cardinality();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(CollectionHandle collectionHandle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) collectionHandle)).booleanValue();
            }
            if (this.storage.get(collectionHandle.index)) {
                return false;
            }
            this.storage.set(collectionHandle.index);
            return true;
        }

        /* synthetic */ CollectionHandleSet(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) anonymousClass1);
        }
    }

    /* synthetic */ CollectionHandle(int i3, AnonymousClass1 anonymousClass1) {
        this(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) anonymousClass1);
    }

    public static Supplier<CollectionHandle> createSupplier() {
        return new Supplier<CollectionHandle>() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.export.CollectionHandle.1
            static IPatchRedirector $redirector_;
            private final AtomicInteger nextIndex;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                } else {
                    this.nextIndex = new AtomicInteger(1);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.function.Supplier
            public CollectionHandle get() {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new CollectionHandle(this.nextIndex.getAndIncrement(), null) : (CollectionHandle) iPatchRedirector.redirect((short) 2, (Object) this);
            }
        };
    }

    public static Set<CollectionHandle> mutableSet() {
        return new CollectionHandleSet(null);
    }

    static Set<CollectionHandle> of(CollectionHandle... collectionHandleArr) {
        Set<CollectionHandle> mutableSet = mutableSet();
        mutableSet.addAll(Arrays.asList(collectionHandleArr));
        return mutableSet;
    }

    public boolean equals(@Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof CollectionHandle) && this.index == ((CollectionHandle) obj).index) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.index;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "CollectionHandle(" + this.index + ")";
    }

    CollectionHandle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.index = i3;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        }
    }
}
