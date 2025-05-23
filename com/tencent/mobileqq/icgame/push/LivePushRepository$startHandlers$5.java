package com.tencent.mobileqq.icgame.push;

import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public /* synthetic */ class LivePushRepository$startHandlers$5 extends FunctionReferenceImpl implements Function2<bz0.c, LiveMsgExtInfo.MsgSpeed, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LivePushRepository$startHandlers$5(Object obj) {
        super(2, obj, LivePushRepository.class, "pushCallback", "pushCallback(Lcom/tencent/icgame/trpcprotocol/ilive/common/roomMsg/nano/MsgInfo;Lcom/tencent/mobileqq/qqlive/data/message/LiveMsgExtInfo$MsgSpeed;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(bz0.c cVar, LiveMsgExtInfo.MsgSpeed msgSpeed) {
        invoke2(cVar, msgSpeed);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull bz0.c p06, @NotNull LiveMsgExtInfo.MsgSpeed p16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Intrinsics.checkNotNullParameter(p16, "p1");
        ((LivePushRepository) this.receiver).f(p06, p16);
    }
}
