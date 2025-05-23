package com.tencent.luggage.wxa.uk;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f142646a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue f142647b = new LinkedBlockingQueue();

    /* renamed from: c, reason: collision with root package name */
    public final AtomicInteger f142648c = new AtomicInteger(0);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.uk.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6804a {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {
        public b() {
            super(0);
        }

        public final void a() {
            a.this.b();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public a(int i3) {
        this.f142646a = i3;
    }

    public abstract void a(InterfaceC6804a interfaceC6804a, Function0 function0);

    public final void b(InterfaceC6804a task) {
        Intrinsics.checkNotNullParameter(task, "task");
        a(task);
    }

    public boolean c(InterfaceC6804a task) {
        Intrinsics.checkNotNullParameter(task, "task");
        return false;
    }

    public final int d() {
        return this.f142647b.size();
    }

    public final void a(InterfaceC6804a interfaceC6804a) {
        while (this.f142648c.incrementAndGet() > this.f142646a) {
            this.f142647b.offer(interfaceC6804a);
            if (this.f142648c.decrementAndGet() >= this.f142646a || (interfaceC6804a = (InterfaceC6804a) this.f142647b.poll()) == null) {
                return;
            }
        }
        d(interfaceC6804a);
    }

    public final void b() {
        InterfaceC6804a interfaceC6804a;
        this.f142648c.decrementAndGet();
        do {
            interfaceC6804a = (InterfaceC6804a) this.f142647b.poll();
            if (com.tencent.luggage.wxa.h6.d.a(interfaceC6804a) && !c(interfaceC6804a)) {
                break;
            }
        } while (!this.f142647b.isEmpty());
        if (interfaceC6804a != null) {
            a(interfaceC6804a);
        }
        if (this.f142648c.get() == 0 && this.f142647b.isEmpty()) {
            e();
        }
    }

    public final int c() {
        return this.f142648c.get();
    }

    public final void d(InterfaceC6804a interfaceC6804a) {
        a(interfaceC6804a, new b());
    }

    public void a() {
        this.f142647b.clear();
    }

    public void e() {
    }
}
