package com.tencent.tbs.one.impl.a.a;

import com.tencent.tbs.one.impl.a.a.d;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class e extends d {

    /* renamed from: c, reason: collision with root package name */
    private Executor f374547c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f374548d;

    /* renamed from: b, reason: collision with root package name */
    private AtomicInteger f374546b = new AtomicInteger();

    /* renamed from: e, reason: collision with root package name */
    private List<c> f374549e = new ArrayList();

    public e(Executor executor) {
        this.f374547c = executor;
    }

    @Override // com.tencent.tbs.one.impl.a.a.d
    public final void a() {
        this.f374546b.incrementAndGet();
    }

    @Override // com.tencent.tbs.one.impl.a.a.d
    public final void b(c cVar) {
        if (this.f374548d) {
            this.f374549e.add(cVar);
        } else {
            this.f374547c.execute(cVar);
        }
    }

    @Override // com.tencent.tbs.one.impl.a.a.d
    public final void a(c cVar) {
        cVar.f374539b = this;
        this.f374548d = true;
        cVar.a();
        this.f374548d = false;
        c[] cVarArr = (c[]) this.f374549e.toArray(new c[0]);
        this.f374549e.clear();
        for (c cVar2 : cVarArr) {
            this.f374547c.execute(cVar2);
        }
    }

    @Override // com.tencent.tbs.one.impl.a.a.d
    public final void b() {
        d.a aVar;
        if (this.f374546b.decrementAndGet() > 0 || (aVar = this.f374545a) == null) {
            return;
        }
        aVar.a();
    }
}
