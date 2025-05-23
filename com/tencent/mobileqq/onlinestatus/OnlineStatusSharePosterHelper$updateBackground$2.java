package com.tencent.mobileqq.onlinestatus;

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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.onlinestatus.OnlineStatusSharePosterHelper$updateBackground$2", f = "OnlineStatusSharePosterHelper.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
public final class OnlineStatusSharePosterHelper$updateBackground$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $backgroundUrl;
    final /* synthetic */ Ref.ObjectRef<Bitmap> $bgBitmap;
    Object L$0;
    int label;
    final /* synthetic */ OnlineStatusSharePosterHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineStatusSharePosterHelper$updateBackground$2(String str, Ref.ObjectRef<Bitmap> objectRef, OnlineStatusSharePosterHelper onlineStatusSharePosterHelper, Continuation<? super OnlineStatusSharePosterHelper$updateBackground$2> continuation) {
        super(2, continuation);
        this.$backgroundUrl = str;
        this.$bgBitmap = objectRef;
        this.this$0 = onlineStatusSharePosterHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OnlineStatusSharePosterHelper$updateBackground$2(this.$backgroundUrl, this.$bgBitmap, this.this$0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        Object d16;
        Ref.ObjectRef<Bitmap> objectRef;
        T t16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                objectRef = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                t16 = obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            String str = this.$backgroundUrl;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                Ref.ObjectRef<Bitmap> objectRef2 = this.$bgBitmap;
                OnlineStatusSharePosterHelper onlineStatusSharePosterHelper = this.this$0;
                String str2 = this.$backgroundUrl;
                this.L$0 = objectRef2;
                this.label = 1;
                d16 = onlineStatusSharePosterHelper.d(str2, this);
                if (d16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
                t16 = d16;
            }
            return Unit.INSTANCE;
        }
        objectRef.element = t16;
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OnlineStatusSharePosterHelper$updateBackground$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
