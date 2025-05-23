package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/task/a;", "p1", "Lkotlin/Function0;", "", "p2", "invoke", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/task/a;Lkotlin/jvm/functions/Function0;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final /* synthetic */ class MsgListVBImpl$queue$1 extends FunctionReferenceImpl implements Function2<com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.task.a, Function0<? extends Unit>, Unit> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MsgListVBImpl$queue$1(MsgListVBImpl msgListVBImpl) {
        super(2, msgListVBImpl, MsgListVBImpl.class, "submitAction", "submitAction(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/task/Task;Lkotlin/jvm/functions/Function0;)V", 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgListVBImpl);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.task.a aVar, Function0<? extends Unit> function0) {
        invoke2(aVar, (Function0<Unit>) function0);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.task.a p16, @NotNull Function0<Unit> p26) {
        Intrinsics.checkNotNullParameter(p16, "p1");
        Intrinsics.checkNotNullParameter(p26, "p2");
        ((MsgListVBImpl) this.receiver).J1(p16, p26);
    }
}
