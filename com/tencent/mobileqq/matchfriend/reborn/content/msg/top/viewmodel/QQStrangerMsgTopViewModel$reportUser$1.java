package com.tencent.mobileqq.matchfriend.reborn.content.msg.top.viewmodel;

import com.tencent.mobileqq.matchfriend.reborn.content.msg.top.repository.QQStrangerMsgTopRepository;
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
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.msg.top.viewmodel.QQStrangerMsgTopViewModel$reportUser$1", f = "QQStrangerMsgTopViewModel.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerMsgTopViewModel$reportUser$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $openId;
    final /* synthetic */ String $trace;
    int label;
    final /* synthetic */ QQStrangerMsgTopViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerMsgTopViewModel$reportUser$1(QQStrangerMsgTopViewModel qQStrangerMsgTopViewModel, String str, String str2, Continuation<? super QQStrangerMsgTopViewModel$reportUser$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerMsgTopViewModel;
        this.$openId = str;
        this.$trace = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerMsgTopViewModel$reportUser$1(this.this$0, this.$openId, this.$trace, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        QQStrangerMsgTopRepository O1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            O1 = this.this$0.O1();
            String str = this.$openId;
            String str2 = this.$trace;
            this.label = 1;
            if (O1.f(str, str2, this) == coroutine_suspended) {
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
        return ((QQStrangerMsgTopViewModel$reportUser$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
