package com.tencent.tbs.one.impl.a;

import com.tencent.tbs.one.impl.a.k;
import java.io.File;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class c<T> extends b<T> {

    /* renamed from: b, reason: collision with root package name */
    final File f374560b;

    /* renamed from: c, reason: collision with root package name */
    final long f374561c;

    /* renamed from: d, reason: collision with root package name */
    k f374562d;

    public c(File file, long j3) {
        this.f374560b = file;
        this.f374561c = j3;
    }

    private void d() {
        g.a("[ExclusiveJob].releaseLock", new Object[0]);
        k kVar = this.f374562d;
        if (kVar != null) {
            kVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tbs.one.impl.a.b
    public final void a() {
        o.f(new Runnable() { // from class: com.tencent.tbs.one.impl.a.c.1

            /* compiled from: P */
            /* renamed from: com.tencent.tbs.one.impl.a.c$1$a */
            /* loaded from: classes26.dex */
            final class a implements Callable<Boolean> {
                a() {
                }

                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Boolean call() throws Exception {
                    return Boolean.valueOf(!c.this.f374550a);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    c cVar = c.this;
                    File file = cVar.f374560b;
                    a aVar = new a();
                    cVar.f374562d = (k) k.a(new k.a(aVar, file), file, c.this.f374561c);
                    c.this.c();
                } catch (Exception e16) {
                    c.this.a(e16);
                }
            }
        });
    }

    public abstract void a(Exception exc);

    public abstract void c();

    @Override // com.tencent.tbs.one.impl.a.b
    public void a(T t16) {
        d();
        super.a((c<T>) t16);
    }

    @Override // com.tencent.tbs.one.impl.a.b
    public void a(int i3, String str, Throwable th5) {
        d();
        super.a(i3, str, th5);
    }
}
