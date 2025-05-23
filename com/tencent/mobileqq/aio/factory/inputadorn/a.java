package com.tencent.mobileqq.aio.factory.inputadorn;

import android.content.Context;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mobileqq.aio.factory.inputadorn.c;
import com.tencent.mobileqq.aio.input.adorn.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.bottombar.sectionbar.api.IBottomSectionBarApi;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J<\u0010\r\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0012\u0006\b\u0000\u0012\u00020\u00020\tj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`\f0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J2\u0010\u0012\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000e0\u000fj\u0002`\u00110\b2\u0006\u0010\u0007\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0014\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/inputadorn/a;", "Lcom/tencent/mobileqq/aio/input/adorn/a;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Landroid/content/Context;", "context", "f", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "host", "", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "e", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "c", "Lcom/tencent/aio/base/mvvm/a;", "", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a implements com.tencent.mobileqq.aio.input.adorn.a<com.tencent.mobileqq.aio.input.inputbar.viewbinding.a> {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    @NotNull
    public com.tencent.aio.base.mvvm.a<Object, Object> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return ((IBottomSectionBarApi) QRoute.api(IBottomSectionBarApi.class)).getBottomSectionBarVB();
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    @NotNull
    public List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> c(@NotNull com.tencent.mobileqq.aio.input.adorn.c host) {
        List plus;
        List plus2;
        List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>> plus3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) host);
        }
        Intrinsics.checkNotNullParameter(host, "host");
        c.C7245c c7245c = c.C7245c.f188794a;
        plus = CollectionsKt___CollectionsKt.plus((Collection) c7245c.b(host), (Iterable) c7245c.d(host));
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) c7245c.e(host));
        plus3 = CollectionsKt___CollectionsKt.plus((Collection) plus2, (Iterable) c7245c.a(host));
        return plus3;
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return a.C7250a.b(this);
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    @NotNull
    public List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> e(@NotNull com.tencent.mobileqq.aio.input.adorn.b host) {
        List plus;
        List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, ? super com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>> plus2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) host);
        }
        Intrinsics.checkNotNullParameter(host, "host");
        c.b bVar = c.b.f188793a;
        plus = CollectionsKt___CollectionsKt.plus((Collection) bVar.a(host), (Iterable) bVar.c(host));
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) bVar.d(host));
        return plus2;
    }

    @Override // com.tencent.mobileqq.aio.input.adorn.a
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.inputbar.viewbinding.a b(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.inputbar.viewbinding.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return c.INSTANCE.a(context);
    }
}
