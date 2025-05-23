package com.tencent.mobileqq.wink.magicAvatar.viewmodel;

import com.tencent.mobileqq.wink.magicAvatar.model.AvatarCountInfo;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarDataSource;
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
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel$consumeTimes$1", f = "MagicAvatarCropViewModel.kt", i = {}, l = {480, 485}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicAvatarCropViewModel$consumeTimes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MagicAvatarCropViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicAvatarCropViewModel$consumeTimes$1(MagicAvatarCropViewModel magicAvatarCropViewModel, Continuation<? super MagicAvatarCropViewModel$consumeTimes$1> continuation) {
        super(2, continuation);
        this.this$0 = magicAvatarCropViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicAvatarCropViewModel$consumeTimes$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        AvatarCountInfo avatarCountInfo;
        com.tencent.mobileqq.wink.magicAvatar.model.f n26;
        Object f36;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            w53.b.f("MagicAvatarCropViewModel", "consumeTimes");
            MagicAvatarDataSource magicAvatarDataSource = MagicAvatarDataSource.f323499a;
            int from = this.this$0.getFrom();
            this.label = 1;
            obj = magicAvatarDataSource.f(from, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        AvatarCountInfo avatarCountInfo2 = (AvatarCountInfo) obj;
        w53.b.f("MagicAvatarCropViewModel", "consumeCount = " + avatarCountInfo2);
        MagicAvatarCropViewModel.Z = avatarCountInfo2;
        MagicAvatarCropViewModel magicAvatarCropViewModel = this.this$0;
        avatarCountInfo = MagicAvatarCropViewModel.f323590a0;
        n26 = magicAvatarCropViewModel.n2(avatarCountInfo2, avatarCountInfo);
        w53.b.f("MagicAvatarCropViewModel", "state = " + n26);
        MagicAvatarCropViewModel magicAvatarCropViewModel2 = this.this$0;
        this.label = 2;
        f36 = magicAvatarCropViewModel2.f3(n26, this);
        if (f36 == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicAvatarCropViewModel$consumeTimes$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
