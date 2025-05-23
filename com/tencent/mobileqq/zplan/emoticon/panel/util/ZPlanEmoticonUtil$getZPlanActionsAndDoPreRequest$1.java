package com.tencent.mobileqq.zplan.emoticon.panel.util;

import com.tencent.mobileqq.zplan.aio.panel.page.EmoticonPageBuilder;
import com.tencent.mobileqq.zplan.aio.panel.panel.Panel;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil$getZPlanActionsAndDoPreRequest$1", f = "ZPlanEmoticonUtil.kt", i = {}, l = {1009}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonUtil$getZPlanActionsAndDoPreRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaseApplication $context;
    final /* synthetic */ CoroutineScope $scope;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonUtil$getZPlanActionsAndDoPreRequest$1(CoroutineScope coroutineScope, BaseApplication baseApplication, Continuation<? super ZPlanEmoticonUtil$getZPlanActionsAndDoPreRequest$1> continuation) {
        super(2, continuation);
        this.$scope = coroutineScope;
        this.$context = baseApplication;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ZPlanEmoticonUtil$getZPlanActionsAndDoPreRequest$1 zPlanEmoticonUtil$getZPlanActionsAndDoPreRequest$1 = new ZPlanEmoticonUtil$getZPlanActionsAndDoPreRequest$1(this.$scope, this.$context, continuation);
        zPlanEmoticonUtil$getZPlanActionsAndDoPreRequest$1.L$0 = obj;
        return zPlanEmoticonUtil$getZPlanActionsAndDoPreRequest$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        List listOf;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Panel.Companion companion = Panel.INSTANCE;
            CoroutineScope coroutineScope2 = this.$scope;
            BaseApplication baseApplication = this.$context;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new EmoticonPageBuilder(this.$scope, this.$context, null, 4, null));
            StateFlow h16 = Panel.Companion.h(companion, coroutineScope2, baseApplication, listOf, false, null, 16, null);
            ZPlanEmoticonUtil$getZPlanActionsAndDoPreRequest$1$invokeSuspend$$inlined$collect$1 zPlanEmoticonUtil$getZPlanActionsAndDoPreRequest$1$invokeSuspend$$inlined$collect$1 = new ZPlanEmoticonUtil$getZPlanActionsAndDoPreRequest$1$invokeSuspend$$inlined$collect$1(coroutineScope);
            this.label = 1;
            if (h16.collect(zPlanEmoticonUtil$getZPlanActionsAndDoPreRequest$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
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
        return ((ZPlanEmoticonUtil$getZPlanActionsAndDoPreRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
