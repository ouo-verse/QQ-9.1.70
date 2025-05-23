package com.tencent.timi.game.liveroom.impl.room.medal.commonrender;

import android.graphics.Bitmap;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sr4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/graphics/Bitmap;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.timi.game.liveroom.impl.room.medal.commonrender.MsgCommonMedalLoader$load$1$1$medalJob$1", f = "MsgCommonMedalLoader.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes26.dex */
final class MsgCommonMedalLoader$load$1$1$medalJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ g $it;
    int label;
    final /* synthetic */ MsgCommonMedalLoader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgCommonMedalLoader$load$1$1$medalJob$1(g gVar, MsgCommonMedalLoader msgCommonMedalLoader, Continuation<? super MsgCommonMedalLoader$load$1$1$medalJob$1> continuation) {
        super(2, continuation);
        this.$it = gVar;
        this.this$0 = msgCommonMedalLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MsgCommonMedalLoader$load$1$1$medalJob$1(this.$it, this.this$0, continuation);
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
            Option coverOption = Option.obtain().setUrl(this.$it.B.f434410b).setPreferDecodeFormat(DecodeFormat.PREFER_ARGB_8888).setSupportRecycler(true);
            MsgCommonMedalLoader msgCommonMedalLoader = this.this$0;
            Intrinsics.checkNotNullExpressionValue(coverOption, "coverOption");
            this.label = 1;
            obj = msgCommonMedalLoader.f(coverOption, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Bitmap> continuation) {
        return ((MsgCommonMedalLoader$load$1$1$medalJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
