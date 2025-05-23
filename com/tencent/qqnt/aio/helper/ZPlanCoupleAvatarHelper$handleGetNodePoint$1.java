package com.tencent.qqnt.aio.helper;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.qphone.base.util.QLog;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.helper.ZPlanCoupleAvatarHelper$handleGetNodePoint$1", f = "ZPlanCoupleAvatarHelper.kt", i = {}, l = {323}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ZPlanCoupleAvatarHelper$handleGetNodePoint$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $data;
    int label;
    final /* synthetic */ ZPlanCoupleAvatarHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanCoupleAvatarHelper$handleGetNodePoint$1(String str, ZPlanCoupleAvatarHelper zPlanCoupleAvatarHelper, Continuation<? super ZPlanCoupleAvatarHelper$handleGetNodePoint$1> continuation) {
        super(2, continuation);
        this.$data = str;
        this.this$0 = zPlanCoupleAvatarHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanCoupleAvatarHelper$handleGetNodePoint$1(this.$data, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        com.tencent.mobileqq.zplan.aio.couple.i iVar;
        com.tencent.aio.api.runtime.a aVar;
        Context context;
        com.tencent.mobileqq.zplan.couple.manager.a aVar2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.i("ZPlanCoupleAvatarHelper", 1, "handleGetNodePoint eventData: " + this.$data);
            iVar = this.this$0.mViewController;
            if (iVar != null) {
                this.label = 1;
                obj = iVar.o(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        View view = (View) obj;
        if (view != null) {
            aVar = this.this$0.mAIOContext;
            if (aVar == null) {
                return Unit.INSTANCE;
            }
            Fragment c16 = aVar.c();
            if (c16 != null && (context = c16.getContext()) != null) {
                FragmentActivity activity = aVar.c().getActivity();
                if (activity != null) {
                    aVar2 = this.this$0.bubblePlayManager;
                    if (aVar2 != null) {
                        aVar2.a(context, activity, aVar.c().getView(), view, this.$data);
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanCoupleAvatarHelper$handleGetNodePoint$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
