package com.tencent.mobileqq.zplan.debug;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zplan.resource.api.impl.ZPlanAvatarInfoHelperImpl;
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
@DebugMetadata(c = "com.tencent.mobileqq.zplan.debug.ZPlanDebugFragment$doOnCreateView$4$1", f = "ZPlanDebugFragment.kt", i = {}, l = {255}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class ZPlanDebugFragment$doOnCreateView$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ZPlanDebugFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanDebugFragment$doOnCreateView$4$1(ZPlanDebugFragment zPlanDebugFragment, Continuation<? super ZPlanDebugFragment$doOnCreateView$4$1> continuation) {
        super(2, continuation);
        this.this$0 = zPlanDebugFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ZPlanDebugFragment zPlanDebugFragment, String str) {
        zPlanDebugFragment.ji(str);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanDebugFragment$doOnCreateView$4$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanAvatarInfoHelperImpl.Companion companion = ZPlanAvatarInfoHelperImpl.INSTANCE;
            this.label = 1;
            obj = companion.fetchMyAvatarInfo(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final String valueOf = String.valueOf(obj);
        final ZPlanDebugFragment zPlanDebugFragment = this.this$0;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.debug.t
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanDebugFragment$doOnCreateView$4$1.b(ZPlanDebugFragment.this, valueOf);
            }
        }, 64, null, false);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanDebugFragment$doOnCreateView$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
