package com.tencent.mobileqq.aio.input.at.business;

import com.tencent.mobileqq.aio.input.at.common.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J0\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\n0\u000b0\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/business/a;", "Lcom/tencent/mobileqq/aio/input/at/common/a;", "Lcom/tencent/mobileqq/aio/input/at/business/b;", "", "d", "b", "Lcom/tencent/mobileqq/aio/input/at/common/j;", "dialogContext", "Lcom/tencent/mobileqq/aio/input/at/common/b;", "delegateListener", "", "Lcom/tencent/mobileqq/aio/input/at/common/list/base/b;", "Lcom/tencent/mobileqq/aio/input/at/common/list/data/b;", tl.h.F, "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a implements com.tencent.mobileqq.aio.input.at.common.a<b> {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.a
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return a.b.d(this);
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.a
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return com.tencent.qqnt.util.view.b.f362999a.b(45);
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.a
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return a.b.a(this);
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.a
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 4;
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.a
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return a.b.b(this);
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.a
    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return a.b.c(this);
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.a
    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return a.b.e(this);
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.a
    @NotNull
    public List<com.tencent.mobileqq.aio.input.at.common.list.base.b<List<com.tencent.mobileqq.aio.input.at.common.list.data.b>>> h(@NotNull com.tencent.mobileqq.aio.input.at.common.j<b> dialogContext, @NotNull com.tencent.mobileqq.aio.input.at.common.b delegateListener) {
        List<com.tencent.mobileqq.aio.input.at.common.list.base.b<List<com.tencent.mobileqq.aio.input.at.common.list.data.b>>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) dialogContext, (Object) delegateListener);
        }
        Intrinsics.checkNotNullParameter(dialogContext, "dialogContext");
        Intrinsics.checkNotNullParameter(delegateListener, "delegateListener");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.aio.input.at.common.list.base.b[]{new l(dialogContext, delegateListener), new TroopAtMemberAdapterDelegate(dialogContext, delegateListener)});
        return listOf;
    }
}
