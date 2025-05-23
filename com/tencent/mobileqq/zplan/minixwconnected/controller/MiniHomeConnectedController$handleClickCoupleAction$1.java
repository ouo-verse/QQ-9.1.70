package com.tencent.mobileqq.zplan.minixwconnected.controller;

import com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectActionFocusComponent;
import com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectMapComponent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ri3.MapModeInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController$handleClickCoupleAction$1", f = "MiniHomeConnectedController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class MiniHomeConnectedController$handleClickCoupleAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ le3.b $actionConfig;
    int label;
    final /* synthetic */ MiniHomeConnectedController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeConnectedController$handleClickCoupleAction$1(MiniHomeConnectedController miniHomeConnectedController, le3.b bVar, Continuation<? super MiniHomeConnectedController$handleClickCoupleAction$1> continuation) {
        super(2, continuation);
        this.this$0 = miniHomeConnectedController;
        this.$actionConfig = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniHomeConnectedController$handleClickCoupleAction$1(this.this$0, this.$actionConfig, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MiniHomeConnectActionFocusComponent F;
        ri3.c T;
        Long hostUin;
        MiniHomeConnectMapComponent R;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.i("MiniHomeConnectedController", 1, "handleClickCoupleAction");
            F = this.this$0.F();
            F.l(this.$actionConfig.getId(), true);
            T = this.this$0.T();
            MapModeInfo value = T.O1().getValue();
            if (value != null && (hostUin = value.getHostUin()) != null) {
                long longValue = hostUin.longValue();
                int id5 = this.$actionConfig.getId();
                int b16 = this.$actionConfig.b();
                R = this.this$0.R();
                R.A(id5, b16, longValue, true);
                return Boxing.boxBoolean(true);
            }
            return Boxing.boxBoolean(false);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((MiniHomeConnectedController$handleClickCoupleAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
