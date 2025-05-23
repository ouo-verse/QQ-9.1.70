package com.tencent.tbs.one.impl.a.a;

import com.tencent.tbs.one.impl.a.a.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class c implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    d f374539b;

    /* renamed from: d, reason: collision with root package name */
    private boolean f374541d;

    /* renamed from: e, reason: collision with root package name */
    private AtomicBoolean f374542e = new AtomicBoolean();

    /* renamed from: a, reason: collision with root package name */
    AtomicBoolean f374538a = new AtomicBoolean();

    /* renamed from: c, reason: collision with root package name */
    List<c> f374540c = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private List<Runnable> f374543f = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        if (this.f374541d) {
            return;
        }
        this.f374541d = true;
        List<c> list = this.f374540c;
        if (list != null && list.size() > 0) {
            for (c cVar : this.f374540c) {
                cVar.f374539b = this.f374539b;
                cVar.f374543f.add(new Runnable() { // from class: com.tencent.tbs.one.impl.a.a.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        c cVar2 = c.this;
                        Iterator<c> it = cVar2.f374540c.iterator();
                        while (it.hasNext()) {
                            if (!it.next().f374538a.get()) {
                                return;
                            }
                        }
                        cVar2.b();
                    }
                });
                cVar.a();
            }
        } else {
            b();
        }
        this.f374539b.a();
    }

    public final void b(c cVar) {
        this.f374540c.add(cVar);
    }

    public final void c() {
        if (this.f374538a.compareAndSet(false, true)) {
            Iterator<Runnable> it = this.f374543f.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            this.f374539b.b();
        }
    }

    final void b() {
        if (this.f374542e.compareAndSet(false, true)) {
            this.f374539b.b(this);
        }
    }

    public final void a(int i3, String str, Throwable th5) {
        d.a aVar = this.f374539b.f374545a;
        if (aVar != null) {
            aVar.a(i3, str, th5);
        }
    }
}
