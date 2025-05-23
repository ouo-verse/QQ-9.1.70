package com.tencent.mobileqq.guild.theme;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.util.k;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.theme.QuiBitmapResourceObtainColorHelper$obtainBubbleDrawableAsyncInternal$1", f = "QuiBitmapResourceObtainColorHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class QuiBitmapResourceObtainColorHelper$obtainBubbleDrawableAsyncInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableLiveData<Bitmap> $colorLiveData;
    final /* synthetic */ Drawable $drawable;
    final /* synthetic */ k $paletteRule;
    final /* synthetic */ int $resId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuiBitmapResourceObtainColorHelper$obtainBubbleDrawableAsyncInternal$1(Drawable drawable, MutableLiveData<Bitmap> mutableLiveData, k kVar, int i3, Continuation<? super QuiBitmapResourceObtainColorHelper$obtainBubbleDrawableAsyncInternal$1> continuation) {
        super(2, continuation);
        this.$drawable = drawable;
        this.$colorLiveData = mutableLiveData;
        this.$paletteRule = kVar;
        this.$resId = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QuiBitmapResourceObtainColorHelper$obtainBubbleDrawableAsyncInternal$1(this.$drawable, this.$colorLiveData, this.$paletteRule, this.$resId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Bitmap i3;
        Bitmap bitmap;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            i3 = QuiBitmapResourceObtainColorHelper.f235295a.i(this.$drawable);
            if (i3 != null) {
                bitmap = this.$paletteRule.a(this.$resId, i3);
            } else {
                bitmap = null;
            }
            this.$colorLiveData.postValue(bitmap);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QuiBitmapResourceObtainColorHelper$obtainBubbleDrawableAsyncInternal$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
