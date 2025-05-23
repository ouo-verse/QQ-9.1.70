package com.tencent.luggage.wxa.b9;

import com.eclipsesource.mmv8.JavaCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Function;
import com.eclipsesource.mmv8.V8Object;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public class z extends v {

    /* renamed from: b, reason: collision with root package name */
    public WeakReference f122374b = null;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements JavaCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f122375a;

        public a(t tVar) {
            this.f122375a = tVar;
        }

        @Override // com.eclipsesource.mmv8.JavaCallback
        public Object invoke(V8Object v8Object, V8Array v8Array) {
            if (v8Array.length() >= 2 && v8Array.getType(0) == 1 && v8Array.getType(1) == 7) {
                return Integer.valueOf(d.a().a(v8Array.getInteger(0), (V8Function) v8Array.getObject(1), this.f122375a));
            }
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.V8DirectApiSharedBufferLock", "hy: v8 params error");
            return -1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements JavaCallback {
        public b() {
        }

        @Override // com.eclipsesource.mmv8.JavaCallback
        public Object invoke(V8Object v8Object, V8Array v8Array) {
            if (v8Array.length() >= 2 && v8Array.getType(0) == 1 && v8Array.getType(1) == 1) {
                d.a().a(v8Array.getInteger(0), v8Array.getInteger(1));
                return null;
            }
            com.tencent.luggage.wxa.tn.w.f("MicroMsg.V8DirectApiSharedBufferLock", "hy: v8 params error");
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public volatile int f122378a;

        /* renamed from: b, reason: collision with root package name */
        public volatile t f122379b;

        /* renamed from: c, reason: collision with root package name */
        public volatile V8Function f122380c;

        public c(int i3, t tVar, V8Function v8Function) {
            this.f122378a = i3;
            this.f122379b = tVar;
            this.f122380c = v8Function;
        }

        public String toString() {
            return "LockItem{itemId=" + this.f122378a + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d {

        /* renamed from: c, reason: collision with root package name */
        public static d f122381c = null;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ boolean f122382d = true;

        /* renamed from: b, reason: collision with root package name */
        public AtomicInteger f122384b = new AtomicInteger(0);

        /* renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap f122383a = new ConcurrentHashMap(100);

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ V8Function f122385a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ t f122386b;

            public a(V8Function v8Function, t tVar) {
                this.f122385a = v8Function;
                this.f122386b = tVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!this.f122385a.isReleased()) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger task call");
                    this.f122385a.call(this.f122386b.j().getGlobalObject(), null);
                    this.f122385a.release();
                    return;
                }
                com.tencent.luggage.wxa.tn.w.f("MicroMsg.V8DirectApiSharedBufferLock", "hy: called a released task");
            }
        }

        public static /* synthetic */ d a() {
            return b();
        }

        public static d b() {
            if (f122381c == null) {
                synchronized (d.class) {
                    if (f122381c == null) {
                        f122381c = new d();
                    }
                }
            }
            return f122381c;
        }

        public final int a(int i3, V8Function v8Function, t tVar) {
            ConcurrentLinkedQueue concurrentLinkedQueue;
            boolean z16;
            int andIncrement;
            synchronized (this.f122383a) {
                if (this.f122383a.containsKey(Integer.valueOf(i3))) {
                    concurrentLinkedQueue = (ConcurrentLinkedQueue) this.f122383a.get(Integer.valueOf(i3));
                    if (!f122382d && concurrentLinkedQueue == null) {
                        throw new AssertionError();
                    }
                    z16 = concurrentLinkedQueue.isEmpty();
                } else {
                    ConcurrentLinkedQueue concurrentLinkedQueue2 = new ConcurrentLinkedQueue();
                    this.f122383a.put(Integer.valueOf(i3), concurrentLinkedQueue2);
                    concurrentLinkedQueue = concurrentLinkedQueue2;
                    z16 = true;
                }
                andIncrement = this.f122384b.getAndIncrement();
                c cVar = new c(andIncrement, tVar, v8Function);
                concurrentLinkedQueue.offer(cVar);
                if (z16) {
                    a(cVar.f122379b, cVar.f122380c);
                }
                com.tencent.luggage.wxa.tn.w.g("MicroMsg.V8DirectApiSharedBufferLock", "hy: request lock %d", Integer.valueOf(andIncrement));
            }
            return andIncrement;
        }

        public final void a(int i3, int i16) {
            synchronized (this.f122383a) {
                com.tencent.luggage.wxa.tn.w.g("MicroMsg.V8DirectApiSharedBufferLock", "hy: request unlock %d", Integer.valueOf(i16));
                ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.f122383a.get(Integer.valueOf(i3));
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.V8DirectApiSharedBufferLock", "hy: current queue: %s", concurrentLinkedQueue);
                if (concurrentLinkedQueue != null) {
                    c cVar = (c) concurrentLinkedQueue.poll();
                    if (cVar != null) {
                        com.tencent.luggage.wxa.tn.w.a("MicroMsg.V8DirectApiSharedBufferLock", "hy: toBeRemoved: %d", Integer.valueOf(cVar.f122378a));
                        c cVar2 = (c) concurrentLinkedQueue.peek();
                        if (cVar2 != null) {
                            com.tencent.luggage.wxa.tn.w.a("MicroMsg.V8DirectApiSharedBufferLock", "hy: next called: %d", Integer.valueOf(cVar2.f122378a));
                            a(cVar2.f122379b, cVar2.f122380c);
                        }
                    } else {
                        com.tencent.luggage.wxa.tn.w.h("MicroMsg.V8DirectApiSharedBufferLock", "hy: bufferId: %d itemId: %d not found", Integer.valueOf(i3), Integer.valueOf(i16));
                    }
                } else {
                    com.tencent.luggage.wxa.tn.w.g("MicroMsg.V8DirectApiSharedBufferLock", "hy: can not locate buffer locks %d", Integer.valueOf(i3));
                }
            }
        }

        public final void a(t tVar, V8Function v8Function) {
            tVar.h().a(new a(v8Function, tVar));
        }

        public final void a(t tVar) {
            synchronized (this.f122383a) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger release engine %d", Integer.valueOf(tVar.hashCode()));
                Iterator it = this.f122383a.keySet().iterator();
                while (it.hasNext()) {
                    ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.f122383a.get((Integer) it.next());
                    if (concurrentLinkedQueue != null) {
                        Iterator it5 = concurrentLinkedQueue.iterator();
                        while (it5.hasNext()) {
                            c cVar = (c) it5.next();
                            if (cVar.f122379b == tVar) {
                                cVar.f122380c.release();
                                concurrentLinkedQueue.remove(cVar);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.b9.v
    public void a(t tVar, V8Object v8Object) {
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(tVar != null ? tVar.hashCode() : 0);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger setup worker %d", objArr);
        this.f122374b = new WeakReference(tVar);
        v8Object.registerJavaMethod(new a(tVar), "lockSharedNativeBuffer");
        v8Object.registerJavaMethod(new b(), "unlockSharedNativeBuffer");
    }

    @Override // com.tencent.luggage.wxa.b9.v
    public void a() {
        if (this.f122374b != null) {
            d.a().a((t) this.f122374b.get());
        }
    }
}
