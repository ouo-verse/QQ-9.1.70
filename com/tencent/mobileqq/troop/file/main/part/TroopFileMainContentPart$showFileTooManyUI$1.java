package com.tencent.mobileqq.troop.file.main.part;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.bc;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import mqq.app.api.ProcessConstant;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.file.main.part.TroopFileMainContentPart$showFileTooManyUI$1", f = "TroopFileMainContentPart.kt", i = {}, l = {414}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class TroopFileMainContentPart$showFileTooManyUI$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TroopFileMainContentPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopFileMainContentPart$showFileTooManyUI$1(TroopFileMainContentPart troopFileMainContentPart, Continuation<? super TroopFileMainContentPart$showFileTooManyUI$1> continuation) {
        super(2, continuation);
        this.this$0 = troopFileMainContentPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TroopFileMainContentPart$showFileTooManyUI$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        View view;
        View view2;
        View view3;
        String O9;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        view = this.this$0.headerView;
        View view4 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            view = null;
        }
        final View findViewById = view.findViewById(R.id.jwb);
        final TroopFileMainContentPart troopFileMainContentPart = this.this$0;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.file.main.part.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                TroopFileMainContentPart$showFileTooManyUI$1.b(findViewById, troopFileMainContentPart, view5);
            }
        };
        view2 = this.this$0.headerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            view2 = null;
        }
        view2.findViewById(R.id.jwa).setOnClickListener(onClickListener);
        view3 = this.this$0.headerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
        } else {
            view4 = view3;
        }
        view4.findViewById(R.id.jwc).setOnClickListener(onClickListener);
        findViewById.setVisibility(0);
        QQAppInterface a16 = bc.a(this.this$0);
        O9 = this.this$0.O9();
        ReportController.o(a16, "dc00899", "Grp_files", "", ProcessConstant.MULTI, "show_limit", 0, 0, O9, "2", "", "");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TroopFileMainContentPart$showFileTooManyUI$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view, TroopFileMainContentPart troopFileMainContentPart, View view2) {
        String O9;
        view.setVisibility(8);
        QQAppInterface a16 = bc.a(troopFileMainContentPart);
        O9 = troopFileMainContentPart.O9();
        ReportController.o(a16, "dc00899", "Grp_files", "", ProcessConstant.MULTI, "Clk_limit", 0, 0, O9, "2", "", "");
    }
}
