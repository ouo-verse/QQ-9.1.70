package com.tencent.mobileqq.wink.magicAvatar.viewmodel;

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
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel$checkNeedGenerate$1", f = "MagicAvatarCropViewModel.kt", i = {0}, l = {277}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
/* loaded from: classes21.dex */
public final class MagicAvatarCropViewModel$checkNeedGenerate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MagicAvatarCropViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicAvatarCropViewModel$checkNeedGenerate$1(MagicAvatarCropViewModel magicAvatarCropViewModel, Continuation<? super MagicAvatarCropViewModel$checkNeedGenerate$1> continuation) {
        super(2, continuation);
        this.this$0 = magicAvatarCropViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicAvatarCropViewModel$checkNeedGenerate$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MagicAvatarCropViewModel magicAvatarCropViewModel;
        boolean z16;
        Object v26;
        MagicAvatarMaterialInfo magicAvatarMaterialInfo;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                magicAvatarMaterialInfo = (MagicAvatarMaterialInfo) this.L$1;
                magicAvatarCropViewModel = (MagicAvatarCropViewModel) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            MagicAvatarMaterialInfo currentSelectMaterial = this.this$0.getCurrentSelectMaterial();
            if (currentSelectMaterial != null) {
                magicAvatarCropViewModel = this.this$0;
                if (currentSelectMaterial.getGenerateUrl().length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    w53.b.f("MagicAvatarCropViewModel", "NeedGenerate");
                    magicAvatarCropViewModel.b3(true);
                    this.L$0 = magicAvatarCropViewModel;
                    this.L$1 = currentSelectMaterial;
                    this.label = 1;
                    v26 = magicAvatarCropViewModel.v2(currentSelectMaterial, this);
                    if (v26 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    magicAvatarMaterialInfo = currentSelectMaterial;
                }
            }
            return Unit.INSTANCE;
        }
        magicAvatarCropViewModel.N2(magicAvatarMaterialInfo.getLocalPicPath());
        magicAvatarCropViewModel.b3(false);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicAvatarCropViewModel$checkNeedGenerate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
