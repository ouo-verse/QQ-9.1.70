package com.tencent.ecommerce.biz.live.ui;

import android.graphics.drawable.Drawable;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$configUIForMasterEditable$1;
import com.tencent.mobileqq.R;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Landroid/graphics/drawable/Drawable;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment$configUIForMasterEditable$1$1$deleteDrawable$1", f = "ECLiveWindowSubFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECLiveWindowSubFragment$configUIForMasterEditable$1$1$deleteDrawable$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Drawable>, Object> {
    int label;
    final /* synthetic */ ECLiveWindowSubFragment$configUIForMasterEditable$1.AnonymousClass1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECLiveWindowSubFragment$configUIForMasterEditable$1$1$deleteDrawable$1(ECLiveWindowSubFragment$configUIForMasterEditable$1.AnonymousClass1 anonymousClass1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECLiveWindowSubFragment$configUIForMasterEditable$1$1$deleteDrawable$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Drawable> continuation) {
        return ((ECLiveWindowSubFragment$configUIForMasterEditable$1$1$deleteDrawable$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Drawable drawable = ECSkin.INSTANCE.getDrawable(R.drawable.bsc);
            if (drawable != null) {
                int i3 = this.this$0.$size.element;
                drawable.setBounds(0, 0, i3, i3);
            }
            return drawable;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
