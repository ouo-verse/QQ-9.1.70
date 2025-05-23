package com.tencent.mobileqq.zplan.aio.couple;

import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qui.quibutton.QUIButton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarLayout$jsEventListener$2$1$handleEvent$2", f = "CoupleAvatarLayout.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class CoupleAvatarLayout$jsEventListener$2$1$handleEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CoupleAvatarLayout this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarLayout$jsEventListener$2$1$handleEvent$2(CoupleAvatarLayout coupleAvatarLayout, Continuation<? super CoupleAvatarLayout$jsEventListener$2$1$handleEvent$2> continuation) {
        super(2, continuation);
        this.this$0 = coupleAvatarLayout;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoupleAvatarLayout$jsEventListener$2$1$handleEvent$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        View T;
        ImageView imageView;
        View view;
        QUIButton qUIButton;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            T = this.this$0.T();
            T.setVisibility(8);
            imageView = this.this$0.loadingFirstFrameImageView;
            imageView.setVisibility(8);
            view = this.this$0.textureView;
            if (view != null) {
                view.setVisibility(4);
            }
            qUIButton = this.this$0.errorBtn;
            qUIButton.setVisibility(0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoupleAvatarLayout$jsEventListener$2$1$handleEvent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
