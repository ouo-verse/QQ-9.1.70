package com.tencent.tbs.one.impl.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class h<T> extends b<T> {

    /* renamed from: b, reason: collision with root package name */
    private List<b<T>> f374576b;

    /* renamed from: c, reason: collision with root package name */
    private b<T> f374577c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public final class a extends m<T> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f374578f;

        a(boolean z16) {
            this.f374578f = z16;
        }

        @Override // com.tencent.tbs.one.impl.a.m
        public final void a(int i3, int i16) {
            h.this.a(i16);
        }

        @Override // com.tencent.tbs.one.impl.a.m
        public final void a(T t16) {
            h.this.a((h) t16);
        }

        @Override // com.tencent.tbs.one.impl.a.m
        public final void a(int i3, String str, Throwable th5) {
            g.b("[MixedCancellableJob].onError " + str, th5);
            if (!this.f374578f) {
                h hVar = h.this;
                if (!hVar.f374550a) {
                    hVar.c();
                    return;
                }
            }
            h.this.a(i3, str, th5);
        }
    }

    public h(b<T>[] bVarArr) {
        this.f374576b = new ArrayList(Arrays.asList(bVarArr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tbs.one.impl.a.b
    public final void a() {
        c();
    }

    @Override // com.tencent.tbs.one.impl.a.b
    public final void b() {
        super.b();
        b<T> bVar = this.f374577c;
        if (bVar != null) {
            bVar.b();
        }
    }

    final void c() {
        boolean z16 = false;
        this.f374577c = this.f374576b.remove(0);
        if (this.f374576b.size() == 0) {
            z16 = true;
        }
        this.f374577c.a((m) new a(z16));
    }
}
