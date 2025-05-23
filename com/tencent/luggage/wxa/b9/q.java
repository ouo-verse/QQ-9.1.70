package com.tencent.luggage.wxa.b9;

import com.eclipsesource.mmv8.InSandboxByteBuffer;
import com.eclipsesource.mmv8.SharedV8ArrayBuffer;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public class q implements g {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f122264a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    public final Map f122265b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final t f122266c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final t f122267a;

        /* renamed from: b, reason: collision with root package name */
        public final int f122268b;

        /* renamed from: c, reason: collision with root package name */
        public final InSandboxByteBuffer f122269c;

        /* renamed from: d, reason: collision with root package name */
        public final ByteBuffer f122270d;

        /* renamed from: e, reason: collision with root package name */
        public SharedV8ArrayBuffer f122271e;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.b9.q$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6043a implements Runnable {
            public RunnableC6043a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.SharedV8ArrayBufferMgr", "SharedBuffer do release");
                if (a.this.f122271e == null) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.SharedV8ArrayBufferMgr", "SharedBuffer do release mV8Buffer null");
                } else {
                    a.this.f122271e.manualRelease();
                }
            }
        }

        public a(int i3, t tVar) {
            this.f122267a = tVar;
            this.f122268b = i3;
            InSandboxByteBuffer allocate = InSandboxByteBuffer.allocate(i3);
            this.f122269c = allocate;
            this.f122270d = allocate.asByteBuffer();
            this.f122271e = null;
        }

        public ByteBuffer b() {
            return this.f122270d;
        }

        public SharedV8ArrayBuffer c() {
            if (this.f122271e == null && !this.f122269c.isReleased()) {
                this.f122271e = this.f122267a.j().newSharedV8ArrayBuffer(this.f122269c);
            }
            return this.f122271e;
        }

        public void a() {
            this.f122267a.h().a(new RunnableC6043a());
        }
    }

    public q(t tVar) {
        this.f122266c = tVar;
    }

    @Override // com.tencent.luggage.wxa.b9.g
    public int a(int i3) {
        int addAndGet = this.f122264a.addAndGet(1);
        this.f122265b.put(Integer.valueOf(addAndGet), new a(i3, this.f122266c));
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.SharedV8ArrayBufferMgr", "create capacity:%d, id:%d", Integer.valueOf(i3), Integer.valueOf(addAndGet));
        return addAndGet;
    }

    @Override // com.tencent.luggage.wxa.b9.g
    public void b(int i3) {
        if (!this.f122265b.containsKey(Integer.valueOf(i3))) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.SharedV8ArrayBufferMgr", "destroy: id %d not exist", Integer.valueOf(i3));
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.SharedV8ArrayBufferMgr", "destroy id:%d", Integer.valueOf(i3));
        ((a) this.f122265b.get(Integer.valueOf(i3))).a();
        this.f122265b.remove(Integer.valueOf(i3));
    }

    @Override // com.tencent.luggage.wxa.b9.g
    public ByteBuffer c(int i3) {
        if (!this.f122265b.containsKey(Integer.valueOf(i3))) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.SharedV8ArrayBufferMgr", "getBackingStore: id %d not exist", Integer.valueOf(i3));
            return null;
        }
        return ((a) this.f122265b.get(Integer.valueOf(i3))).b();
    }

    @Override // com.tencent.luggage.wxa.b9.g
    public SharedV8ArrayBuffer get(int i3) {
        if (!this.f122265b.containsKey(Integer.valueOf(i3))) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.SharedV8ArrayBufferMgr", "get: id %d not exist", Integer.valueOf(i3));
            return null;
        }
        return ((a) this.f122265b.get(Integer.valueOf(i3))).c();
    }
}
