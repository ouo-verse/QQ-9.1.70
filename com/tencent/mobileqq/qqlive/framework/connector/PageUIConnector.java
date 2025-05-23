package com.tencent.mobileqq.qqlive.framework.connector;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.d;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.f;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.g;
import com.tencent.mobileqq.qqlive.framework.page.Page;
import com.tencent.mobileqq.qqlive.framework.pageevent.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/connector/PageUIConnector;", "Lcom/tencent/mobileqq/qqlive/framework/connector/a;", "", "a", "Lfi2/b;", "connectorContext", "<init>", "(Lfi2/b;)V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class PageUIConnector extends a {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageUIConnector(@NotNull fi2.b connectorContext) {
        super(connectorContext);
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) connectorContext);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.connector.a, com.tencent.mobileqq.qqlive.framework.connector.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            f.a(b().c(), new d(c.class, new Function1<c, Unit>() { // from class: com.tencent.mobileqq.qqlive.framework.connector.PageUIConnector$initEventConnector$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PageUIConnector.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(c cVar) {
                    invoke2(cVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull c it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    g c16 = PageUIConnector.this.b().c();
                    Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.framework.component.IConnectableComponent<com.tencent.mobileqq.qqlive.framework.page.Page.RootComponent>");
                    Page.d dVar = (Page.d) ((com.tencent.mobileqq.qqlive.framework.component.f) c16).a();
                    if (dVar != null) {
                        dVar.b(it);
                    }
                }
            }));
        }
    }
}
