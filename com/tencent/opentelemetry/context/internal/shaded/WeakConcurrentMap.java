package com.tencent.opentelemetry.context.internal.shaded;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WeakConcurrentMap<K, V> extends AbstractWeakConcurrentMap<K, V, LookupKey<K>> {
    static IPatchRedirector $redirector_;
    private static final AtomicLong ID;
    private static final ThreadLocal<LookupKey<?>> LOOKUP_KEY_CACHE;
    private final boolean reuseKeys;
    private final Thread thread;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class LookupKey<K> {
        static IPatchRedirector $redirector_;
        private int hashCode;
        private K key;

        LookupKey() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
            }
            if (obj instanceof LookupKey) {
                if (((LookupKey) obj).key == this.key) {
                    return true;
                }
                return false;
            }
            if (((AbstractWeakConcurrentMap.WeakKey) obj).get() == this.key) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.hashCode;
        }

        void reset() {
            this.key = null;
            this.hashCode = 0;
        }

        LookupKey<K> withValue(K k3) {
            this.key = k3;
            this.hashCode = System.identityHashCode(k3);
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class WithInlinedExpunction<K, V> extends WeakConcurrentMap<K, V> {
        static IPatchRedirector $redirector_;

        public WithInlinedExpunction() {
            super(false);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.opentelemetry.context.internal.shaded.WeakConcurrentMap, com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public int approximateSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            expungeStaleEntries();
            return super.approximateSize();
        }

        @Override // com.tencent.opentelemetry.context.internal.shaded.WeakConcurrentMap, com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // com.tencent.opentelemetry.context.internal.shaded.WeakConcurrentMap, com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public boolean containsKey(K k3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) k3)).booleanValue();
            }
            expungeStaleEntries();
            return super.containsKey(k3);
        }

        @Override // com.tencent.opentelemetry.context.internal.shaded.WeakConcurrentMap, com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public /* bridge */ /* synthetic */ void expungeStaleEntries() {
            super.expungeStaleEntries();
        }

        @Override // com.tencent.opentelemetry.context.internal.shaded.WeakConcurrentMap, com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public V get(K k3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (V) iPatchRedirector.redirect((short) 2, (Object) this, (Object) k3);
            }
            expungeStaleEntries();
            return (V) super.get(k3);
        }

        @Override // com.tencent.opentelemetry.context.internal.shaded.WeakConcurrentMap, com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public /* bridge */ /* synthetic */ Object getIfPresent(Object obj) {
            return super.getIfPresent(obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.opentelemetry.context.internal.shaded.WeakConcurrentMap, com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        protected /* bridge */ /* synthetic */ Object getLookupKey(Object obj) {
            return super.getLookupKey((WithInlinedExpunction<K, V>) obj);
        }

        @Override // com.tencent.opentelemetry.context.internal.shaded.WeakConcurrentMap, com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Iterator) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            expungeStaleEntries();
            return super.iterator();
        }

        @Override // com.tencent.opentelemetry.context.internal.shaded.WeakConcurrentMap, com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public V put(K k3, V v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (V) iPatchRedirector.redirect((short) 4, (Object) this, (Object) k3, (Object) v3);
            }
            expungeStaleEntries();
            return (V) super.put(k3, v3);
        }

        @Override // com.tencent.opentelemetry.context.internal.shaded.WeakConcurrentMap, com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
            return super.putIfAbsent(obj, obj2);
        }

        @Override // com.tencent.opentelemetry.context.internal.shaded.WeakConcurrentMap, com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public /* bridge */ /* synthetic */ Object putIfProbablyAbsent(Object obj, Object obj2) {
            return super.putIfProbablyAbsent(obj, obj2);
        }

        @Override // com.tencent.opentelemetry.context.internal.shaded.WeakConcurrentMap, com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public V remove(K k3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (V) iPatchRedirector.redirect((short) 5, (Object) this, (Object) k3);
            }
            expungeStaleEntries();
            return (V) super.remove(k3);
        }

        @Override // com.tencent.opentelemetry.context.internal.shaded.WeakConcurrentMap, com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        protected /* bridge */ /* synthetic */ void resetLookupKey(Object obj) {
            super.resetLookupKey((LookupKey) obj);
        }

        @Override // com.tencent.opentelemetry.context.internal.shaded.WeakConcurrentMap, com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap, java.lang.Runnable
        public /* bridge */ /* synthetic */ void run() {
            super.run();
        }

        @Override // com.tencent.opentelemetry.context.internal.shaded.WeakConcurrentMap, com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15865);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            LOOKUP_KEY_CACHE = new ThreadLocal<LookupKey<?>>() { // from class: com.tencent.opentelemetry.context.internal.shaded.WeakConcurrentMap.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.lang.ThreadLocal
                public LookupKey<?> initialValue() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new LookupKey<>() : (LookupKey) iPatchRedirector.redirect((short) 2, (Object) this);
                }
            };
            ID = new AtomicLong();
        }
    }

    public WeakConcurrentMap(boolean z16) {
        this(z16, isPersistentClassLoader(LookupKey.class.getClassLoader()));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, z16);
    }

    private static boolean isPersistentClassLoader(ClassLoader classLoader) {
        if (classLoader != null) {
            try {
                if (classLoader != ClassLoader.getSystemClassLoader()) {
                    if (classLoader != ClassLoader.getSystemClassLoader().getParent()) {
                        return false;
                    }
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ int approximateSize() {
        return super.approximateSize();
    }

    @Override // com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ void expungeStaleEntries() {
        super.expungeStaleEntries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object get(Object obj) {
        return super.get(obj);
    }

    public Thread getCleanerThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Thread) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.thread;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object getIfPresent(Object obj) {
        return super.getIfPresent(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    protected /* bridge */ /* synthetic */ Object getLookupKey(Object obj) {
        return getLookupKey((WeakConcurrentMap<K, V>) obj);
    }

    @Override // com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return super.putIfAbsent(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object putIfProbablyAbsent(Object obj, Object obj2) {
        return super.putIfProbablyAbsent(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object remove(Object obj) {
        return super.remove((WeakConcurrentMap<K, V>) obj);
    }

    @Override // com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap, java.lang.Runnable
    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    @Override // com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public WeakConcurrentMap(boolean z16, boolean z17) {
        this(z16, z17, new ConcurrentHashMap());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
    }

    @Override // com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    protected LookupKey<K> getLookupKey(K k3) {
        LookupKey<?> lookupKey;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LookupKey) iPatchRedirector.redirect((short) 4, (Object) this, (Object) k3);
        }
        if (this.reuseKeys) {
            lookupKey = LOOKUP_KEY_CACHE.get();
        } else {
            lookupKey = new LookupKey<>();
        }
        return lookupKey.withValue(k3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap
    public void resetLookupKey(LookupKey<K> lookupKey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            lookupKey.reset();
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) lookupKey);
        }
    }

    public WeakConcurrentMap(boolean z16, boolean z17, ConcurrentMap<AbstractWeakConcurrentMap.WeakKey<K>, V> concurrentMap) {
        super(concurrentMap);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17), concurrentMap);
            return;
        }
        this.reuseKeys = z17;
        if (z16) {
            BaseThread baseThread = new BaseThread(this);
            this.thread = baseThread;
            baseThread.setName("weak-ref-cleaner-" + ID.getAndIncrement());
            baseThread.setPriority(1);
            baseThread.setDaemon(true);
            baseThread.start();
            return;
        }
        this.thread = null;
    }
}
