package com.tencent.luggage.wxa.kq;

import android.os.Handler;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d implements Handler.Callback {

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC6409d f132736c;

    /* renamed from: h, reason: collision with root package name */
    public c[] f132741h;

    /* renamed from: a, reason: collision with root package name */
    public Handler f132734a = com.tencent.luggage.wxa.eq.d.a("SerialQueueLeader", this);

    /* renamed from: b, reason: collision with root package name */
    public AtomicBoolean f132735b = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    public boolean f132737d = false;

    /* renamed from: e, reason: collision with root package name */
    public HashSet f132738e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f132739f = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    public final LinkedList f132740g = new LinkedList();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        boolean a(e eVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        boolean a(e eVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c extends MessageQueue.IdleHandler {
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.kq.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6409d {
        void b(e eVar);
    }

    public d(InterfaceC6409d interfaceC6409d) {
        this.f132736c = interfaceC6409d;
    }

    public void a(long j3, e eVar) {
        synchronized (this) {
            if (this.f132735b.get()) {
                return;
            }
            if (eVar == null) {
                return;
            }
            if (eVar.isCancelled()) {
                return;
            }
            if (j3 > 0) {
                Message obtainMessage = this.f132734a.obtainMessage();
                obtainMessage.obj = eVar;
                obtainMessage.what = 1;
                synchronized (this) {
                    this.f132738e.add(eVar);
                    this.f132734a.sendMessageAtTime(obtainMessage, SystemClock.uptimeMillis() + j3);
                }
                return;
            }
            boolean isEmpty = this.f132739f.isEmpty();
            if (isEmpty && !this.f132737d) {
                this.f132737d = true;
                InterfaceC6409d interfaceC6409d = this.f132736c;
                Objects.requireNonNull(interfaceC6409d);
                interfaceC6409d.b(eVar);
                return;
            }
            if (!isEmpty && j3 != Long.MIN_VALUE) {
                this.f132739f.addLast(eVar);
            }
            this.f132739f.addFirst(eVar);
        }
    }

    public LinkedList b() {
        LinkedList linkedList;
        synchronized (this) {
            linkedList = new LinkedList(this.f132739f);
            linkedList.addAll(this.f132738e);
        }
        return linkedList;
    }

    public List c() {
        LinkedList linkedList = new LinkedList();
        Iterator it = b().iterator();
        while (it.hasNext()) {
            linkedList.add(((e) it.next()).getKey());
        }
        return linkedList;
    }

    public void d() {
        if (this.f132735b.get()) {
            return;
        }
        synchronized (this) {
            e eVar = (e) this.f132739f.pollFirst();
            while (eVar != null && eVar.isCancelled()) {
                eVar = (e) this.f132739f.pollFirst();
            }
            if (eVar != null) {
                InterfaceC6409d interfaceC6409d = this.f132736c;
                Objects.requireNonNull(interfaceC6409d);
                interfaceC6409d.b(eVar);
            } else {
                this.f132737d = false;
                e();
            }
        }
    }

    public final void e() {
        int size;
        synchronized (this) {
            size = this.f132740g.size();
            if (size > 0) {
                if (this.f132741h == null) {
                    this.f132741h = new c[size];
                }
                this.f132741h = (c[]) this.f132740g.toArray(this.f132741h);
            }
        }
        if (size <= 0) {
            return;
        }
        c[] cVarArr = this.f132741h;
        c cVar = cVarArr[0];
        cVarArr[0] = null;
        try {
            throw null;
        } catch (Throwable th5) {
            synchronized (this) {
                this.f132740g.remove((Object) null);
                throw th5;
            }
        }
    }

    public boolean f() {
        if (!this.f132735b.compareAndSet(false, true)) {
            return false;
        }
        synchronized (this) {
            a();
            this.f132737d = false;
        }
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            synchronized (this) {
                if (this.f132738e.remove(message.obj)) {
                    a(0L, (e) message.obj);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public void a() {
        synchronized (this) {
            this.f132734a.removeMessages(1);
            Iterator it = this.f132739f.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                if (!eVar.isCancelled()) {
                    eVar.cancel(false);
                }
            }
            this.f132739f.clear();
            Iterator it5 = this.f132738e.iterator();
            while (it5.hasNext()) {
                e eVar2 = (e) it5.next();
                if (!eVar2.isCancelled()) {
                    eVar2.cancel(false);
                }
            }
            this.f132738e.clear();
        }
    }

    public void a(e eVar) {
        synchronized (this) {
            if (this.f132738e.remove(eVar)) {
                this.f132734a.removeMessages(1, eVar);
            }
            Iterator it = this.f132739f.iterator();
            while (it.hasNext()) {
                e eVar2 = (e) it.next();
                if (eVar2 == eVar) {
                    if (!eVar2.isCancelled()) {
                        eVar2.cancel(false);
                    }
                    it.remove();
                }
            }
        }
    }

    public void a(b bVar) {
        Objects.requireNonNull(bVar);
        synchronized (this) {
            Iterator it = this.f132738e.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                if (bVar.a(eVar)) {
                    this.f132734a.removeMessages(1, eVar);
                    if (!eVar.isCancelled()) {
                        eVar.cancel(false);
                    }
                    it.remove();
                }
            }
            Iterator it5 = this.f132739f.iterator();
            while (it5.hasNext()) {
                e eVar2 = (e) it5.next();
                if (bVar.a(eVar2)) {
                    if (!eVar2.isCancelled()) {
                        eVar2.cancel(false);
                    }
                    it5.remove();
                }
            }
        }
    }

    public boolean a(a aVar) {
        synchronized (this) {
            Iterator it = this.f132738e.iterator();
            while (it.hasNext()) {
                if (aVar.a((e) it.next())) {
                    return true;
                }
            }
            Iterator it5 = this.f132739f.iterator();
            while (it5.hasNext()) {
                if (aVar.a((e) it5.next())) {
                    return true;
                }
            }
            return false;
        }
    }
}
