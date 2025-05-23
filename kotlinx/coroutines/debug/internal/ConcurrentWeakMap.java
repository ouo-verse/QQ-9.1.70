package kotlinx.coroutines.debug.internal;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*:\u0003&'(B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u000eJ\u001a\u0010\u0011\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0010\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0010\u001a\u00028\u00002\b\u0010\u0013\u001a\u0004\u0018\u00018\u0001H\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0015J\u0019\u0010\u0017\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0010\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0012J\r\u0010\u0018\u001a\u00020\n\u00a2\u0006\u0004\b\u0018\u0010\u000eR(\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a0\u00198V@\u0016X\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00198V@\u0016X\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0016\u0010#\u001a\u00020 8V@\u0016X\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$8\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010%\u00a8\u0006)"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "", "K", "V", "", "weakRefQueue", "<init>", "(Z)V", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "w", "", "cleanWeakRef", "(Lkotlinx/coroutines/debug/internal/HashedWeakRef;)V", QCircleLpReportDc05507.KEY_CLEAR, "()V", "decrementSize", "key", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putSynchronized", "remove", "runWeakRefQueueCleaningLoopUntilInterrupted", "", "", "getEntries", "()Ljava/util/Set;", "entries", "getKeys", "keys", "", "getSize", "()I", "size", "Ljava/lang/ref/ReferenceQueue;", "Ljava/lang/ref/ReferenceQueue;", "Core", "Entry", "KeyValueSet", "kotlinx-coroutines-core", "Lkotlin/collections/AbstractMutableMap;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class ConcurrentWeakMap<K, V> extends AbstractMutableMap<K, V> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _size$FU = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");

    @NotNull
    private volatile /* synthetic */ int _size;

    @NotNull
    volatile /* synthetic */ Object core;

    @Nullable
    private final ReferenceQueue<K> weakRefQueue;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0018:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00020\u0013\"\u0004\b\u0002\u0010\u00102\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0011\u00a2\u0006\u0004\b\u0014\u0010\u0015J3\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\n\u001a\u00028\u00002\b\u0010\u0016\u001a\u0004\u0018\u00018\u00012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\u00120\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001b\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0002\u0010 R\u0016\u0010!\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010\"\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 \u00a8\u0006$"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "", "allocated", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;I)V", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "weakRef", "", "cleanWeakRef", "(Lkotlinx/coroutines/debug/internal/HashedWeakRef;)V", "key", "getImpl", "(Ljava/lang/Object;)Ljava/lang/Object;", "hash", "index", "(I)I", "E", "Lkotlin/Function2;", "factory", "", "keyValueIterator", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "value", "weakKey0", "", "putImpl", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlinx/coroutines/debug/internal/HashedWeakRef;)Ljava/lang/Object;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "rehash", "()Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "removeCleanedAt", "(I)V", "I", "shift", "threshold", "KeyValueIterator", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public final class Core {
        private static final /* synthetic */ AtomicIntegerFieldUpdater load$FU = AtomicIntegerFieldUpdater.newUpdater(Core.class, "load");
        private final int allocated;

        @NotNull
        /* synthetic */ AtomicReferenceArray keys;

        @NotNull
        private volatile /* synthetic */ int load = 0;
        private final int shift;
        private final int threshold;

        @NotNull
        /* synthetic */ AtomicReferenceArray values;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0002J\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\u000e\u0010\u000f\u001a\u00028\u0002H\u0096\u0002\u00a2\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00028\u0000X\u0082.\u00a2\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u00028\u0001X\u0082.\u00a2\u0006\u0004\n\u0002\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator;", "E", "", "factory", "Lkotlin/Function2;", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;Lkotlin/jvm/functions/Function2;)V", "index", "", "key", "Ljava/lang/Object;", "value", "findNext", "", "hasNext", "", "next", "()Ljava/lang/Object;", "remove", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes28.dex */
        public final class KeyValueIterator<E> implements Iterator<E>, KMutableIterator {

            @NotNull
            private final Function2<K, V, E> factory;
            private int index = -1;
            private K key;
            private V value;

            /* JADX WARN: Multi-variable type inference failed */
            public KeyValueIterator(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
                this.factory = function2;
                findNext();
            }

            private final void findNext() {
                K k3;
                while (true) {
                    int i3 = this.index + 1;
                    this.index = i3;
                    if (i3 < ((Core) Core.this).allocated) {
                        HashedWeakRef hashedWeakRef = (HashedWeakRef) Core.this.keys.get(this.index);
                        if (hashedWeakRef == null) {
                            k3 = null;
                        } else {
                            k3 = (K) hashedWeakRef.get();
                        }
                        if (k3 != null) {
                            this.key = k3;
                            Object obj = (V) Core.this.values.get(this.index);
                            if (obj instanceof Marked) {
                                obj = (V) ((Marked) obj).ref;
                            }
                            if (obj != null) {
                                this.value = (V) obj;
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.index < ((Core) Core.this).allocated) {
                    return true;
                }
                return false;
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.index < ((Core) Core.this).allocated) {
                    Function2<K, V, E> function2 = this.factory;
                    K k3 = this.key;
                    if (k3 != null) {
                        V v3 = this.value;
                        if (v3 != null) {
                            E invoke = function2.invoke(k3, v3);
                            findNext();
                            return invoke;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("value");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("key");
                    throw null;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            @NotNull
            public Void remove() {
                ConcurrentWeakMapKt.noImpl();
                throw new KotlinNothingValueException();
            }
        }

        public Core(int i3) {
            this.allocated = i3;
            this.shift = Integer.numberOfLeadingZeros(i3) + 1;
            this.threshold = (i3 * 2) / 3;
            this.keys = new AtomicReferenceArray(i3);
            this.values = new AtomicReferenceArray(i3);
        }

        private final int index(int hash) {
            return (hash * (-1640531527)) >>> this.shift;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object putImpl$default(Core core, Object obj, Object obj2, HashedWeakRef hashedWeakRef, int i3, Object obj3) {
            if ((i3 & 4) != 0) {
                hashedWeakRef = null;
            }
            return core.putImpl(obj, obj2, hashedWeakRef);
        }

        private final void removeCleanedAt(int index) {
            Object obj;
            do {
                obj = this.values.get(index);
                if (obj == null || (obj instanceof Marked)) {
                    return;
                }
            } while (!a.a(this.values, index, obj, null));
            ConcurrentWeakMap.this.decrementSize();
        }

        public final void cleanWeakRef(@NotNull HashedWeakRef<?> weakRef) {
            int index = index(weakRef.hash);
            while (true) {
                HashedWeakRef<?> hashedWeakRef = (HashedWeakRef) this.keys.get(index);
                if (hashedWeakRef == null) {
                    return;
                }
                if (hashedWeakRef == weakRef) {
                    removeCleanedAt(index);
                    return;
                } else {
                    if (index == 0) {
                        index = this.allocated;
                    }
                    index--;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        public final V getImpl(@NotNull K key) {
            int index = index(key.hashCode());
            while (true) {
                HashedWeakRef hashedWeakRef = (HashedWeakRef) this.keys.get(index);
                if (hashedWeakRef == null) {
                    return null;
                }
                T t16 = hashedWeakRef.get();
                if (Intrinsics.areEqual(key, t16)) {
                    V v3 = (V) this.values.get(index);
                    if (v3 instanceof Marked) {
                        return (V) ((Marked) v3).ref;
                    }
                    return v3;
                }
                if (t16 == 0) {
                    removeCleanedAt(index);
                }
                if (index == 0) {
                    index = this.allocated;
                }
                index--;
            }
        }

        @NotNull
        public final <E> Iterator<E> keyValueIterator(@NotNull Function2<? super K, ? super V, ? extends E> factory) {
            return new KeyValueIterator(factory);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0056, code lost:
        
            r6 = r5.values.get(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
        
            if ((r6 instanceof kotlinx.coroutines.debug.internal.Marked) == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x006b, code lost:
        
            if (kotlinx.coroutines.debug.internal.a.a(r5.values, r0, r6, r7) == false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x006d, code lost:
        
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
        
            r6 = kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.REHASH;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
        
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0017, code lost:
        
            if (r1 == false) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0019, code lost:
        
            r1 = r5.load;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x001d, code lost:
        
            if (r1 < r5.threshold) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x002c, code lost:
        
            if (kotlinx.coroutines.debug.internal.ConcurrentWeakMap.Core.load$FU.compareAndSet(r5, r1, r1 + 1) == false) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x002e, code lost:
        
            r1 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x001f, code lost:
        
            r6 = kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.REHASH;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0023, code lost:
        
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x002f, code lost:
        
            if (r8 != null) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0031, code lost:
        
            r8 = new kotlinx.coroutines.debug.internal.HashedWeakRef<>(r6, ((kotlinx.coroutines.debug.internal.ConcurrentWeakMap) r5.this$0).weakRefQueue);
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0042, code lost:
        
            if (kotlinx.coroutines.debug.internal.a.a(r5.keys, r0, null, r8) == false) goto L45;
         */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object putImpl(@NotNull K key, @Nullable V value, @Nullable HashedWeakRef<K> weakKey0) {
            int index = index(key.hashCode());
            boolean z16 = false;
            while (true) {
                HashedWeakRef hashedWeakRef = (HashedWeakRef) this.keys.get(index);
                if (hashedWeakRef == null) {
                    if (value == null) {
                        return null;
                    }
                } else {
                    T t16 = hashedWeakRef.get();
                    if (Intrinsics.areEqual(key, t16)) {
                        if (z16) {
                            load$FU.decrementAndGet(this);
                        }
                    } else {
                        if (t16 == 0) {
                            removeCleanedAt(index);
                        }
                        if (index == 0) {
                            index = this.allocated;
                        }
                        index--;
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final ConcurrentWeakMap<K, V>.Core rehash() {
            int coerceAtLeast;
            ConcurrentWeakMap<K, V>.Core core;
            Object obj;
            Object obj2;
            Symbol symbol;
            Marked mark;
            loop0: while (true) {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(ConcurrentWeakMap.this.size(), 4);
                core = (ConcurrentWeakMap<K, V>.Core) new Core(Integer.highestOneBit(coerceAtLeast) * 4);
                int i3 = this.allocated;
                if (i3 <= 0) {
                    break;
                }
                int i16 = 0;
                while (true) {
                    int i17 = i16 + 1;
                    HashedWeakRef hashedWeakRef = (HashedWeakRef) this.keys.get(i16);
                    if (hashedWeakRef == null) {
                        obj = null;
                    } else {
                        obj = hashedWeakRef.get();
                    }
                    if (hashedWeakRef != null && obj == null) {
                        removeCleanedAt(i16);
                    }
                    while (true) {
                        obj2 = this.values.get(i16);
                        if (obj2 instanceof Marked) {
                            obj2 = ((Marked) obj2).ref;
                            break;
                        }
                        AtomicReferenceArray atomicReferenceArray = this.values;
                        mark = ConcurrentWeakMapKt.mark(obj2);
                        if (a.a(atomicReferenceArray, i16, obj2, mark)) {
                            break;
                        }
                    }
                    if (obj != null && obj2 != null) {
                        Object putImpl = core.putImpl(obj, obj2, hashedWeakRef);
                        symbol = ConcurrentWeakMapKt.REHASH;
                        if (putImpl == symbol) {
                            break;
                        }
                    }
                    if (i17 >= i3) {
                        break loop0;
                    }
                    i16 = i17;
                }
            }
            return core;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0003\u00a2\u0006\u0002\u0010\u0006J\u0015\u0010\u000b\u001a\u00028\u00032\u0006\u0010\f\u001a\u00028\u0003H\u0016\u00a2\u0006\u0002\u0010\rR\u0016\u0010\u0004\u001a\u00028\u0002X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00028\u0003X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Entry;", "K", "V", "", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", HippyTextInputController.COMMAND_getValue, HippyTextInputController.COMMAND_setValue, "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class Entry<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        private final K key;
        private final V value;

        public Entry(K k3, V v3) {
            this.key = k3;
            this.value = v3;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V newValue) {
            ConcurrentWeakMapKt.noImpl();
            throw new KotlinNothingValueException();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010)\n\u0000\b\u0082\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0002H\u0016\u00a2\u0006\u0002\u0010\rJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\u000fH\u0096\u0002R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$KeyValueSet;", "E", "Lkotlin/collections/AbstractMutableSet;", "factory", "Lkotlin/Function2;", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;Lkotlin/jvm/functions/Function2;)V", "size", "", "getSize", "()I", "add", "", DTConstants.TAG.ELEMENT, "(Ljava/lang/Object;)Z", "iterator", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    private final class KeyValueSet<E> extends AbstractMutableSet<E> {

        @NotNull
        private final Function2<K, V, E> factory;

        /* JADX WARN: Multi-variable type inference failed */
        public KeyValueSet(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
            this.factory = function2;
        }

        @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E element) {
            ConcurrentWeakMapKt.noImpl();
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.collections.AbstractMutableSet
        public int getSize() {
            return ConcurrentWeakMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        @NotNull
        public Iterator<E> iterator() {
            return ((Core) ConcurrentWeakMap.this.core).keyValueIterator(this.factory);
        }
    }

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    private final void cleanWeakRef(HashedWeakRef<?> w3) {
        ((Core) this.core).cleanWeakRef(w3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void decrementSize() {
        _size$FU.decrementAndGet(this);
    }

    private final synchronized V putSynchronized(K key, V value) {
        V v3;
        Symbol symbol;
        Core core = (Core) this.core;
        while (true) {
            v3 = (V) Core.putImpl$default(core, key, value, null, 4, null);
            symbol = ConcurrentWeakMapKt.REHASH;
            if (v3 == symbol) {
                core = core.rehash();
                this.core = core;
            }
        }
        return v3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V get(@Nullable Object key) {
        if (key == null) {
            return null;
        }
        return (V) ((Core) this.core).getImpl(key);
    }

    @Override // kotlin.collections.AbstractMutableMap
    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        return new KeyValueSet(new Function2<K, V, Map.Entry<K, V>>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$entries$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((ConcurrentWeakMap$entries$1<K, V>) obj, obj2);
            }

            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Map.Entry<K, V> invoke(@NotNull K k3, @NotNull V v3) {
                return new ConcurrentWeakMap.Entry(k3, v3);
            }
        });
    }

    @Override // kotlin.collections.AbstractMutableMap
    @NotNull
    public Set<K> getKeys() {
        return new KeyValueSet(new Function2<K, V, K>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$keys$1
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final K invoke(@NotNull K k3, @NotNull V v3) {
                return k3;
            }
        });
    }

    @Override // kotlin.collections.AbstractMutableMap
    /* renamed from: getSize, reason: from getter */
    public int get_size() {
        return this._size;
    }

    @Override // kotlin.collections.AbstractMutableMap, java.util.AbstractMap, java.util.Map
    @Nullable
    public V put(@NotNull K key, @NotNull V value) {
        Symbol symbol;
        V v3 = (V) Core.putImpl$default((Core) this.core, key, value, null, 4, null);
        symbol = ConcurrentWeakMapKt.REHASH;
        if (v3 == symbol) {
            v3 = putSynchronized(key, value);
        }
        if (v3 == null) {
            _size$FU.incrementAndGet(this);
        }
        return v3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V remove(@Nullable Object key) {
        Symbol symbol;
        if (key == 0) {
            return null;
        }
        V v3 = (V) Core.putImpl$default((Core) this.core, key, null, null, 4, null);
        symbol = ConcurrentWeakMapKt.REHASH;
        if (v3 == symbol) {
            v3 = putSynchronized(key, null);
        }
        if (v3 != null) {
            _size$FU.decrementAndGet(this);
        }
        return v3;
    }

    public final void runWeakRefQueueCleaningLoopUntilInterrupted() {
        boolean z16;
        if (this.weakRefQueue != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            while (true) {
                try {
                    Reference<? extends K> remove = this.weakRefQueue.remove();
                    if (remove == null) {
                        break;
                    } else {
                        cleanWeakRef((HashedWeakRef) remove);
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
        } else {
            throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
        }
    }

    public /* synthetic */ ConcurrentWeakMap(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }

    public ConcurrentWeakMap(boolean z16) {
        this._size = 0;
        this.core = new Core(16);
        this.weakRefQueue = z16 ? new ReferenceQueue<>() : null;
    }
}
