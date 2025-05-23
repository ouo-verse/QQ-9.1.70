package com.tencent.mobileqq.wink.magicAvatar.viewmodel;

import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarMaterialInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
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
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel$initStyles$1", f = "MagicAvatarCropViewModel.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicAvatarCropViewModel$initStyles$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<MagicAvatarMaterialInfo> $styles;
    int label;
    final /* synthetic */ MagicAvatarCropViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicAvatarCropViewModel$initStyles$1(MagicAvatarCropViewModel magicAvatarCropViewModel, List<MagicAvatarMaterialInfo> list, Continuation<? super MagicAvatarCropViewModel$initStyles$1> continuation) {
        super(2, continuation);
        this.this$0 = magicAvatarCropViewModel;
        this.$styles = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicAvatarCropViewModel$initStyles$1(this.this$0, this.$styles, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List t26;
        List t27;
        boolean z16;
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
            this.this$0.l2(this.$styles);
            t26 = this.this$0.t2();
            int i16 = 0;
            for (Object obj2 : t26) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                MagicAvatarMaterialInfo magicAvatarMaterialInfo = (MagicAvatarMaterialInfo) obj2;
                if (i16 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                magicAvatarMaterialInfo.setSelected(z16);
                i16 = i17;
            }
            t27 = this.this$0.t2();
            t27.addAll(this.$styles);
            MagicAvatarCropViewModel magicAvatarCropViewModel = this.this$0;
            this.label = 1;
            if (MagicAvatarCropViewModel.Q2(magicAvatarCropViewModel, null, this, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicAvatarCropViewModel$initStyles$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
