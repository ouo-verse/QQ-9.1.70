package com.tencent.guild.aio.panel.photo;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
/* synthetic */ class GuildPhotoPanelVB$onCreateView$1$1$1 extends FunctionReferenceImpl implements Function1<ol3.b, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildPhotoPanelVB$onCreateView$1$1$1(Object obj) {
        super(1, obj, GuildPhotoPanelVB.class, "sendIntent", "sendIntent(Lcom/tencent/mvi/base/mvi/MviIntent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ol3.b bVar) {
        invoke2(bVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull ol3.b p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((GuildPhotoPanelVB) this.receiver).m(p06);
    }
}
