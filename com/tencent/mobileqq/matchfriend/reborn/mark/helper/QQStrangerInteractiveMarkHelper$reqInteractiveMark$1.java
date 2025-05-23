package com.tencent.mobileqq.matchfriend.reborn.mark.helper;

import com.tencent.mobileqq.matchfriend.reborn.mark.InteractiveMarkRequest;
import com.tencent.mobileqq.matchfriend.reborn.utils.c;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.mark.helper.QQStrangerInteractiveMarkHelper$reqInteractiveMark$1", f = "QQStrangerInteractiveMarkHelper.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerInteractiveMarkHelper$reqInteractiveMark$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $chatType;
    final /* synthetic */ long $peerTinyId;
    int label;
    final /* synthetic */ QQStrangerInteractiveMarkHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerInteractiveMarkHelper$reqInteractiveMark$1(int i3, long j3, QQStrangerInteractiveMarkHelper qQStrangerInteractiveMarkHelper, Continuation<? super QQStrangerInteractiveMarkHelper$reqInteractiveMark$1> continuation) {
        super(2, continuation);
        this.$chatType = i3;
        this.$peerTinyId = j3;
        this.this$0 = qQStrangerInteractiveMarkHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerInteractiveMarkHelper$reqInteractiveMark$1(this.$chatType, this.$peerTinyId, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ArrayList<Long> arrayListOf;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            InteractiveMarkRequest interactiveMarkRequest = InteractiveMarkRequest.f245170a;
            int b16 = c.f245468a.b(this.$chatType);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Boxing.boxLong(this.$peerTinyId));
            this.label = 1;
            obj = interactiveMarkRequest.b(b16, arrayListOf, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List list = (List) obj;
        if (!list.isEmpty()) {
            this.this$0.r(this.$peerTinyId, list);
            return Unit.INSTANCE;
        }
        QLog.i("QQStrangerInteractiveMarkHelper", 1, "getInteractiveMarkFromSever result is empty.");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQStrangerInteractiveMarkHelper$reqInteractiveMark$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
