package com.tencent.mobileqq.wink.magicAvatar.viewmodel;

import com.tencent.luggage.wxa.gf.d0;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarMaterialInfo;
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
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel$generateAvatarWithCurrent$1$1", f = "MagicAvatarCropViewModel.kt", i = {}, l = {d0.CTRL_INDEX}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicAvatarCropViewModel$generateAvatarWithCurrent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MagicAvatarMaterialInfo $it;
    int label;
    final /* synthetic */ MagicAvatarCropViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicAvatarCropViewModel$generateAvatarWithCurrent$1$1(MagicAvatarCropViewModel magicAvatarCropViewModel, MagicAvatarMaterialInfo magicAvatarMaterialInfo, Continuation<? super MagicAvatarCropViewModel$generateAvatarWithCurrent$1$1> continuation) {
        super(2, continuation);
        this.this$0 = magicAvatarCropViewModel;
        this.$it = magicAvatarMaterialInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicAvatarCropViewModel$generateAvatarWithCurrent$1$1(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object v26;
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
            this.this$0.b3(true);
            MagicAvatarCropViewModel magicAvatarCropViewModel = this.this$0;
            MagicAvatarMaterialInfo magicAvatarMaterialInfo = this.$it;
            this.label = 1;
            v26 = magicAvatarCropViewModel.v2(magicAvatarMaterialInfo, this);
            if (v26 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.this$0.N2(this.$it.getLocalPicPath());
        this.this$0.b3(false);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicAvatarCropViewModel$generateAvatarWithCurrent$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
