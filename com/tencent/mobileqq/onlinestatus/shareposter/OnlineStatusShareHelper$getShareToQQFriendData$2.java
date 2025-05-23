package com.tencent.mobileqq.onlinestatus.shareposter;

import android.graphics.Bitmap;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.onlinestatus.shareposter.OnlineStatusShareHelper$getShareToQQFriendData$2", f = "OnlineStatusShareHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
public final class OnlineStatusShareHelper$getShareToQQFriendData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ Ref.ObjectRef<String> $filePath;
    int label;
    final /* synthetic */ OnlineStatusShareHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineStatusShareHelper$getShareToQQFriendData$2(Ref.ObjectRef<String> objectRef, OnlineStatusShareHelper onlineStatusShareHelper, Bitmap bitmap, Continuation<? super OnlineStatusShareHelper$getShareToQQFriendData$2> continuation) {
        super(2, continuation);
        this.$filePath = objectRef;
        this.this$0 = onlineStatusShareHelper;
        this.$bitmap = bitmap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OnlineStatusShareHelper$getShareToQQFriendData$2(this.$filePath, this.this$0, this.$bitmap, continuation);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ?? y16;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef<String> objectRef = this.$filePath;
            y16 = this.this$0.y(this.$bitmap);
            objectRef.element = y16;
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OnlineStatusShareHelper$getShareToQQFriendData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
