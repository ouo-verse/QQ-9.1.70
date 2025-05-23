package com.tencent.mobileqq.qqlive.push;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public /* synthetic */ class LivePushRepository$startHandlers$7 extends FunctionReferenceImpl implements Function2<fp4.c, LiveMsgExtInfo.MsgSpeed, Unit> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LivePushRepository$startHandlers$7(Object obj) {
        super(2, obj, LivePushRepository.class, "pushCallback", "pushCallback(Lcom/tencent/trpcprotocol/ilive/common/roomMsg/nano/MsgInfo;Lcom/tencent/mobileqq/qqlive/data/message/LiveMsgExtInfo$MsgSpeed;)V", 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(fp4.c cVar, LiveMsgExtInfo.MsgSpeed msgSpeed) {
        invoke2(cVar, msgSpeed);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull fp4.c p06, @NotNull LiveMsgExtInfo.MsgSpeed p16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Intrinsics.checkNotNullParameter(p16, "p1");
        ((LivePushRepository) this.receiver).h(p06, p16);
    }
}
