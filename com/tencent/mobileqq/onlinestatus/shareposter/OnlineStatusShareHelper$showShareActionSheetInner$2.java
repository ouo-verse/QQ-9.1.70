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
@DebugMetadata(c = "com.tencent.mobileqq.onlinestatus.shareposter.OnlineStatusShareHelper$showShareActionSheetInner$2", f = "OnlineStatusShareHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
public final class OnlineStatusShareHelper$showShareActionSheetInner$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Bitmap> $qrCodeBitmap;
    int label;
    final /* synthetic */ OnlineStatusShareHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineStatusShareHelper$showShareActionSheetInner$2(Ref.ObjectRef<Bitmap> objectRef, OnlineStatusShareHelper onlineStatusShareHelper, Continuation<? super OnlineStatusShareHelper$showShareActionSheetInner$2> continuation) {
        super(2, continuation);
        this.$qrCodeBitmap = objectRef;
        this.this$0 = onlineStatusShareHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OnlineStatusShareHelper$showShareActionSheetInner$2(this.$qrCodeBitmap, this.this$0, continuation);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, android.graphics.Bitmap] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ?? z16;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef<Bitmap> objectRef = this.$qrCodeBitmap;
            z16 = this.this$0.z();
            objectRef.element = z16;
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OnlineStatusShareHelper$showShareActionSheetInner$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
