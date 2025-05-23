package com.tencent.mobileqq.onlinestatus.shareposter;

import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mobileqq.sharepanel.m;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.onlinestatus.shareposter.OnlineStatusShareHelper$showNewSharePanelInner$3$prepareForwardData$1", f = "OnlineStatusShareHelper.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
final class OnlineStatusShareHelper$showNewSharePanelInner$3$prepareForwardData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ m $callback;
    int label;
    final /* synthetic */ OnlineStatusShareHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineStatusShareHelper$showNewSharePanelInner$3$prepareForwardData$1(OnlineStatusShareHelper onlineStatusShareHelper, Bitmap bitmap, m mVar, Continuation<? super OnlineStatusShareHelper$showNewSharePanelInner$3$prepareForwardData$1> continuation) {
        super(2, continuation);
        this.this$0 = onlineStatusShareHelper;
        this.$bitmap = bitmap;
        this.$callback = mVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OnlineStatusShareHelper$showNewSharePanelInner$3$prepareForwardData$1(this.this$0, this.$bitmap, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            OnlineStatusShareHelper onlineStatusShareHelper = this.this$0;
            Bitmap bitmap = this.$bitmap;
            this.label = 1;
            obj = onlineStatusShareHelper.H(bitmap, true, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Intent intent = (Intent) obj;
        if (intent == null) {
            this.$callback.onFail();
            return Unit.INSTANCE;
        }
        this.$callback.a(intent);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OnlineStatusShareHelper$showNewSharePanelInner$3$prepareForwardData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
