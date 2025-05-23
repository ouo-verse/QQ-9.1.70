package com.tencent.mobileqq.onlinestatus;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.onlinestatus.OnlineStatusSharePosterHelper$updateBackground$3", f = "OnlineStatusSharePosterHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
final class OnlineStatusSharePosterHelper$updateBackground$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Bitmap> $bgBitmap;
    final /* synthetic */ View $container;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineStatusSharePosterHelper$updateBackground$3(View view, Ref.ObjectRef<Bitmap> objectRef, Continuation<? super OnlineStatusSharePosterHelper$updateBackground$3> continuation) {
        super(2, continuation);
        this.$container = view;
        this.$bgBitmap = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OnlineStatusSharePosterHelper$updateBackground$3(this.$container, this.$bgBitmap, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ImageView imageView = (ImageView) this.$container.findViewById(R.id.zy_);
            if (imageView == null) {
                return Unit.INSTANCE;
            }
            imageView.setImageBitmap(this.$bgBitmap.element);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OnlineStatusSharePosterHelper$updateBackground$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
