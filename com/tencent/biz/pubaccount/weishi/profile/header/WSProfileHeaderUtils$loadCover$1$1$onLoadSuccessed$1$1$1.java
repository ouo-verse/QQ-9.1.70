package com.tencent.biz.pubaccount.weishi.profile.header;

import android.graphics.Bitmap;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.biz.pubaccount.weishi.profile.header.WSProfileHeaderUtils$loadCover$1$1$onLoadSuccessed$1$1$1", f = "WSProfileHeaderUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes32.dex */
final class WSProfileHeaderUtils$loadCover$1$1$onLoadSuccessed$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $cropCenter;
    final /* synthetic */ WeakReference<KandianUrlImageView> $ivCoverRef;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WSProfileHeaderUtils$loadCover$1$1$onLoadSuccessed$1$1$1(WeakReference<KandianUrlImageView> weakReference, Bitmap bitmap, Continuation<? super WSProfileHeaderUtils$loadCover$1$1$onLoadSuccessed$1$1$1> continuation) {
        super(2, continuation);
        this.$ivCoverRef = weakReference;
        this.$cropCenter = bitmap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WSProfileHeaderUtils$loadCover$1$1$onLoadSuccessed$1$1$1(this.$ivCoverRef, this.$cropCenter, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            KandianUrlImageView kandianUrlImageView = this.$ivCoverRef.get();
            if (kandianUrlImageView != null) {
                kandianUrlImageView.setImageBitmap(this.$cropCenter);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WSProfileHeaderUtils$loadCover$1$1$onLoadSuccessed$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
