package com.tencent.mobileqq.matchfriend.reborn.liteinteraction;

import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.repo.QQStrangerLIARepo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper$reportExpoLIA$1", f = "QQStrangerLIAHelper.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerLIAHelper$reportExpoLIA$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ QQStrangerLIAItem $item;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerLIAHelper$reportExpoLIA$1(QQStrangerLIAItem qQStrangerLIAItem, Continuation<? super QQStrangerLIAHelper$reportExpoLIA$1> continuation) {
        super(2, continuation);
        this.$item = qQStrangerLIAItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerLIAHelper$reportExpoLIA$1(this.$item, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        QQStrangerLIARepo w3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            w3 = QQStrangerLIAHelper.f245114a.w();
            int chatType = this.$item.getChatType();
            long peerTinyId = this.$item.getPeerTinyId();
            int type = this.$item.getType();
            this.label = 1;
            if (w3.b(chatType, peerTinyId, type, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQStrangerLIAHelper$reportExpoLIA$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
