package com.tencent.mobileqq.icgame.framework.connector;

import com.tencent.mobileqq.icgame.framework.page.Page;
import g32.d;
import g32.f;
import g32.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import m32.c;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/connector/PageUIConnector;", "Lcom/tencent/mobileqq/icgame/framework/connector/a;", "", "a", "Lf32/b;", "connectorContext", "<init>", "(Lf32/b;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class PageUIConnector extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageUIConnector(@NotNull f32.b connectorContext) {
        super(connectorContext);
        Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
    }

    @Override // com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
    public void a() {
        f.a(getConnectorContext().c(), new d(c.class, new Function1<c, Unit>() { // from class: com.tencent.mobileqq.icgame.framework.connector.PageUIConnector$initEventConnector$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull c it) {
                Intrinsics.checkNotNullParameter(it, "it");
                g c16 = PageUIConnector.this.getConnectorContext().c();
                Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.framework.component.IConnectableComponent<com.tencent.mobileqq.icgame.framework.page.Page.RootComponent>");
                Page.d dVar = (Page.d) ((com.tencent.mobileqq.icgame.framework.component.f) c16).a();
                if (dVar != null) {
                    dVar.b(it);
                }
            }
        }));
    }
}
