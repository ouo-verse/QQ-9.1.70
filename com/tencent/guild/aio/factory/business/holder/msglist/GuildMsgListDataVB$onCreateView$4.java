package com.tencent.guild.aio.factory.business.holder.msglist;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
/* synthetic */ class GuildMsgListDataVB$onCreateView$4 extends FunctionReferenceImpl implements Function1<at.b, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildMsgListDataVB$onCreateView$4(Object obj) {
        super(1, obj, GuildMsgListDataVB.class, "sendIntent", "sendIntent(Lcom/tencent/mvi/base/mvi/MviIntent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(at.b bVar) {
        invoke2(bVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull at.b p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((GuildMsgListDataVB) this.receiver).sendIntent(p06);
    }
}
