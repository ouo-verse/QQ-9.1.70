package com.tencent.mobileqq.main.loginpart;

import com.tencent.mobileqq.main.api.c;
import com.tencent.mobileqq.main.api.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/main/loginpart/c;", "Lcom/tencent/mobileqq/main/api/c;", "Lcom/tencent/mobileqq/main/api/d;", "proxy", "", h.F, "<init>", "()V", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c implements com.tencent.mobileqq.main.api.c {
    @Override // com.tencent.mobileqq.main.api.c
    public void a(d dVar) {
        c.a.a(this, dVar);
    }

    @Override // com.tencent.mobileqq.main.api.c
    public void b(d dVar, boolean z16) {
        c.a.d(this, dVar, z16);
    }

    @Override // com.tencent.mobileqq.main.api.c
    public void c(d dVar) {
        c.a.b(this, dVar);
    }

    @Override // com.tencent.mobileqq.main.api.c
    public void d(d dVar) {
        c.a.e(this, dVar);
    }

    @Override // com.tencent.mobileqq.main.api.c
    public void e(d dVar) {
        c.a.j(this, dVar);
    }

    @Override // com.tencent.mobileqq.main.api.c
    public void f(d dVar) {
        c.a.f(this, dVar);
    }

    @Override // com.tencent.mobileqq.main.api.c
    public void g(d dVar, boolean z16) {
        c.a.c(this, dVar, z16);
    }

    @Override // com.tencent.mobileqq.main.api.c
    public void h(d proxy) {
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        proxy.a().mUiHandler.sendEmptyMessage(4);
    }

    @Override // com.tencent.mobileqq.main.api.c
    public void i(d dVar) {
        c.a.g(this, dVar);
    }

    @Override // com.tencent.mobileqq.main.api.c
    public void j(d dVar) {
        c.a.h(this, dVar);
    }

    @Override // com.tencent.mobileqq.main.api.c
    public void onPostThemeChanged() {
        c.a.i(this);
    }
}
