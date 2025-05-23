package com.tencent.liteav.videobase.frame;

import android.os.SystemClock;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.i;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class a<T extends i> {

    /* renamed from: a, reason: collision with root package name */
    private static final long f119334a = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: c, reason: collision with root package name */
    private final Map<InterfaceC5951a, Deque<T>> f119336c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f119337d = false;

    /* renamed from: e, reason: collision with root package name */
    private final com.tencent.liteav.base.b.a f119338e = new com.tencent.liteav.base.b.a(f119334a);

    /* renamed from: f, reason: collision with root package name */
    private final g<T> f119339f = new g(this) { // from class: com.tencent.liteav.videobase.frame.b

        /* renamed from: a, reason: collision with root package name */
        private final a f119340a;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            this.f119340a = this;
        }

        @Override // com.tencent.liteav.videobase.frame.g
        public final void a(i iVar) {
            a.a(this.f119340a, iVar);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private final String f119335b = null;

    /* compiled from: P */
    /* renamed from: com.tencent.liteav.videobase.frame.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC5951a {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(a aVar, i iVar) {
        if (iVar == 0) {
            return;
        }
        synchronized (aVar.f119336c) {
            if (aVar.f119337d) {
                aVar.a((a) iVar);
                return;
            }
            Deque<T> b16 = aVar.b(aVar.b((a) iVar));
            iVar.updateLastUsedTimestamp(SystemClock.elapsedRealtime());
            b16.addFirst(iVar);
            aVar.c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c() {
        T peekLast;
        if (!this.f119338e.a()) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ArrayList arrayList = new ArrayList();
        synchronized (this.f119336c) {
            for (Deque<T> deque : this.f119336c.values()) {
                while (!deque.isEmpty() && ((peekLast = deque.peekLast()) == null || elapsedRealtime - peekLast.getLastUsedTimestamp() >= f119334a)) {
                    deque.pollLast();
                    arrayList.add(peekLast);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a((a<T>) it.next());
        }
    }

    protected abstract T a(g<T> gVar, InterfaceC5951a interfaceC5951a);

    protected abstract void a(T t16);

    protected abstract InterfaceC5951a b(T t16);

    public void b() {
        this.f119337d = true;
        a();
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (!this.f119337d) {
            LiteavLog.e("FramePool", "%s must call destroy() before finalize()!\n%s", getClass().getName(), this.f119335b);
        }
    }

    private Deque<T> b(InterfaceC5951a interfaceC5951a) {
        Deque<T> deque = this.f119336c.get(interfaceC5951a);
        if (deque != null) {
            return deque;
        }
        LinkedList linkedList = new LinkedList();
        this.f119336c.put(interfaceC5951a, linkedList);
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final T a(InterfaceC5951a interfaceC5951a) {
        T removeFirst;
        synchronized (this.f119336c) {
            Deque<T> b16 = b(interfaceC5951a);
            removeFirst = !b16.isEmpty() ? b16.removeFirst() : null;
        }
        c();
        if (removeFirst == null) {
            removeFirst = a(this.f119339f, interfaceC5951a);
        }
        if (removeFirst.retain() != 1) {
            LiteavLog.e("FramePool", "invalid reference count for %s", removeFirst);
        }
        return removeFirst;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f119336c) {
            Iterator<Deque<T>> it = this.f119336c.values().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next());
            }
            this.f119336c.clear();
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            a((a<T>) it5.next());
        }
    }
}
