package com.tencent.mobileqq.zplan.minihome;

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
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$refreshDecorateListWithNewData$1", f = "EditMiniHomeFragment.kt", i = {}, l = {1035}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class EditMiniHomeFragment$refreshDecorateListWithNewData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $filterExpression;
    int label;
    final /* synthetic */ EditMiniHomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditMiniHomeFragment$refreshDecorateListWithNewData$1(EditMiniHomeFragment editMiniHomeFragment, String str, Continuation<? super EditMiniHomeFragment$refreshDecorateListWithNewData$1> continuation) {
        super(2, continuation);
        this.this$0 = editMiniHomeFragment;
        this.$filterExpression = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EditMiniHomeFragment$refreshDecorateListWithNewData$1(this.this$0, this.$filterExpression, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MiniHomeEditDecorateListViewModel miniHomeEditDecorateListViewModel;
        MiniHomeEditDecorateListViewModel miniHomeEditDecorateListViewModel2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.i("EditMiniHomeFragment", 1, "start requestGetCandidateList");
            miniHomeEditDecorateListViewModel = this.this$0.viewModel;
            if (miniHomeEditDecorateListViewModel != null) {
                miniHomeEditDecorateListViewModel.R1(this.$filterExpression);
            }
            miniHomeEditDecorateListViewModel2 = this.this$0.viewModel;
            if (miniHomeEditDecorateListViewModel2 != null) {
                this.label = 1;
                if (miniHomeEditDecorateListViewModel2.P1(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
        return ((EditMiniHomeFragment$refreshDecorateListWithNewData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
