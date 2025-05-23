package com.tencent.luggage.wxa.uk;

import android.os.Looper;
import android.os.Message;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class k extends com.tencent.luggage.wxa.wn.c {

    /* renamed from: d, reason: collision with root package name */
    public final c f142746d;

    /* renamed from: e, reason: collision with root package name */
    public final b f142747e;

    /* renamed from: f, reason: collision with root package name */
    public final String f142748f;

    /* renamed from: g, reason: collision with root package name */
    public final Queue f142749g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class b extends com.tencent.luggage.wxa.bk.i {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.wn.b
        public boolean a(Message message) {
            if (2 == message.what) {
                k kVar = k.this;
                kVar.a((com.tencent.luggage.wxa.wn.a) kVar.f142746d);
                return true;
            }
            return super.a(message);
        }

        @Override // com.tencent.luggage.wxa.wn.b, com.tencent.luggage.wxa.wn.a
        public String getName() {
            return k.this.f142748f + "|StateExecuting";
        }
    }

    public k(String str, Looper looper) {
        super(str, looper);
        c cVar = new c();
        this.f142746d = cVar;
        b bVar = new b();
        this.f142747e = bVar;
        this.f142749g = new LinkedList();
        this.f142748f = str;
        a((com.tencent.luggage.wxa.wn.b) cVar);
        a((com.tencent.luggage.wxa.wn.b) bVar);
        b((com.tencent.luggage.wxa.wn.b) cVar);
        m();
    }

    public abstract void b(Object obj);

    public abstract boolean c(Object obj);

    @Override // com.tencent.luggage.wxa.wn.c
    public void j() {
        super.j();
        synchronized (this.f142749g) {
            this.f142749g.clear();
        }
    }

    public final void n() {
        Object poll;
        synchronized (this.f142749g) {
            poll = this.f142749g.poll();
        }
        if (poll != null) {
            a((com.tencent.luggage.wxa.wn.a) this.f142747e);
            b(poll);
        }
    }

    public int o() {
        return this.f142749g.size();
    }

    public final void p() {
        c(2);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class c extends com.tencent.luggage.wxa.bk.i {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.bk.i, com.tencent.luggage.wxa.wn.b
        public void a() {
            super.a();
            k.this.n();
        }

        @Override // com.tencent.luggage.wxa.wn.b, com.tencent.luggage.wxa.wn.a
        public String getName() {
            return k.this.f142748f + "|StateIdle";
        }

        @Override // com.tencent.luggage.wxa.wn.b
        public boolean a(Message message) {
            int i3 = message.what;
            if (1 == i3 || 2 == i3) {
                k.this.n();
                return true;
            }
            return super.a(message);
        }
    }

    public final void a(Object obj) {
        if (obj == null || c(obj)) {
            return;
        }
        synchronized (this.f142749g) {
            this.f142749g.offer(obj);
        }
        c(1);
    }
}
