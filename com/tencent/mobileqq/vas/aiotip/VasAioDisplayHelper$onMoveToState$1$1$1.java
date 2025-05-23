package com.tencent.mobileqq.vas.aiotip;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.aiotip.api.IVasAioTipService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.msg.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"", "Lcom/tencent/qqnt/msg/d;", "list", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.vas.aiotip.VasAioDisplayHelper$onMoveToState$1$1$1", f = "VasAioDisplayHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes20.dex */
public final class VasAioDisplayHelper$onMoveToState$1$1$1 extends SuspendLambda implements Function2<List<? extends d>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VasAioDisplayHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasAioDisplayHelper$onMoveToState$1$1$1(VasAioDisplayHelper vasAioDisplayHelper, Continuation<? super VasAioDisplayHelper$onMoveToState$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = vasAioDisplayHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        VasAioDisplayHelper$onMoveToState$1$1$1 vasAioDisplayHelper$onMoveToState$1$1$1 = new VasAioDisplayHelper$onMoveToState$1$1$1(this.this$0, continuation);
        vasAioDisplayHelper$onMoveToState$1$1$1.L$0 = obj;
        return vasAioDisplayHelper$onMoveToState$1$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<d> list = (List) this.L$0;
            if (SimpleUIUtil.getSimpleUISwitch()) {
                QLog.i("VasAioDisplayHelper", 1, "ReceiveMsg simple Ui, no support keyword tips");
                return Unit.INSTANCE;
            }
            VasAioDisplayHelper vasAioDisplayHelper = this.this$0;
            for (d dVar : list) {
                ((IVasAioTipService) QRoute.api(IVasAioTipService.class)).tryKeywordsAioTips(dVar, true);
                vasAioDisplayHelper.triggerRoamMsgTips(dVar);
                vasAioDisplayHelper.tryNickCoverDetect(dVar);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull List<? extends d> list, @Nullable Continuation<? super Unit> continuation) {
        return ((VasAioDisplayHelper$onMoveToState$1$1$1) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
