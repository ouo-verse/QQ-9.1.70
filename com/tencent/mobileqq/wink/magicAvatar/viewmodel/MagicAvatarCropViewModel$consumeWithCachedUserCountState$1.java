package com.tencent.mobileqq.wink.magicAvatar.viewmodel;

import com.tencent.biz.qqcircle.immersive.constants.QFSNumberConstants;
import com.tencent.mobileqq.wink.magicAvatar.model.AvatarCountInfo;
import com.tencent.mobileqq.wink.magicAvatar.model.f;
import com.tencent.mobileqq.wink.magicAvatar.viewmodel.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel$consumeWithCachedUserCountState$1", f = "MagicAvatarCropViewModel.kt", i = {0, 1}, l = {451, 455, QFSNumberConstants.Int.NUM_456, 457}, m = "invokeSuspend", n = {"currentImageGenerated", "state"}, s = {"Z$0", "L$1"})
/* loaded from: classes21.dex */
public final class MagicAvatarCropViewModel$consumeWithCachedUserCountState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $pos;
    int I$0;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ MagicAvatarCropViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicAvatarCropViewModel$consumeWithCachedUserCountState$1(MagicAvatarCropViewModel magicAvatarCropViewModel, int i3, Continuation<? super MagicAvatarCropViewModel$consumeWithCachedUserCountState$1> continuation) {
        super(2, continuation);
        this.this$0 = magicAvatarCropViewModel;
        this.$pos = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicAvatarCropViewModel$consumeWithCachedUserCountState$1(this.this$0, this.$pos, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d0  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        AvatarCountInfo avatarCountInfo;
        AvatarCountInfo avatarCountInfo2;
        com.tencent.mobileqq.wink.magicAvatar.model.f n26;
        boolean J2;
        MutableStateFlow mutableStateFlow;
        com.tencent.mobileqq.wink.magicAvatar.model.f fVar;
        MagicAvatarCropViewModel magicAvatarCropViewModel;
        int i3;
        MutableSharedFlow mutableSharedFlow;
        MagicAvatarCropViewModel magicAvatarCropViewModel2;
        int i16;
        boolean z16;
        MutableSharedFlow mutableSharedFlow2;
        MagicAvatarCropViewModel magicAvatarCropViewModel3;
        Object S2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i17 = this.label;
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 != 3) {
                        if (i17 == 4) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        i3 = this.I$0;
                        magicAvatarCropViewModel3 = (MagicAvatarCropViewModel) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        this.L$0 = null;
                        this.label = 4;
                        S2 = magicAvatarCropViewModel3.S2(i3, this);
                        if (S2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    i3 = this.I$0;
                    fVar = (com.tencent.mobileqq.wink.magicAvatar.model.f) this.L$1;
                    magicAvatarCropViewModel = (MagicAvatarCropViewModel) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    mutableSharedFlow2 = magicAvatarCropViewModel._buttonState;
                    this.L$0 = magicAvatarCropViewModel;
                    this.L$1 = null;
                    this.I$0 = i3;
                    this.label = 3;
                    if (mutableSharedFlow2.emit(fVar, this) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    magicAvatarCropViewModel3 = magicAvatarCropViewModel;
                    this.L$0 = null;
                    this.label = 4;
                    S2 = magicAvatarCropViewModel3.S2(i3, this);
                    if (S2 == coroutine_suspended) {
                    }
                }
            } else {
                z16 = this.Z$0;
                i16 = this.I$0;
                magicAvatarCropViewModel2 = (MagicAvatarCropViewModel) this.L$0;
                ResultKt.throwOnFailure(obj);
                magicAvatarCropViewModel2.R2(i16, z16);
            }
        } else {
            ResultKt.throwOnFailure(obj);
            avatarCountInfo = MagicAvatarCropViewModel.Z;
            if (avatarCountInfo != null) {
                MagicAvatarCropViewModel magicAvatarCropViewModel4 = this.this$0;
                int i18 = this.$pos;
                avatarCountInfo2 = MagicAvatarCropViewModel.f323590a0;
                n26 = magicAvatarCropViewModel4.n2(avatarCountInfo, avatarCountInfo2);
                w53.b.f("MagicAvatarCropViewModel", "state = " + n26);
                J2 = magicAvatarCropViewModel4.J2(i18);
                if (J2) {
                    mutableSharedFlow = magicAvatarCropViewModel4._buttonState;
                    f.a aVar = f.a.f323518a;
                    this.L$0 = magicAvatarCropViewModel4;
                    this.I$0 = i18;
                    this.Z$0 = J2;
                    this.label = 1;
                    if (mutableSharedFlow.emit(aVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    magicAvatarCropViewModel2 = magicAvatarCropViewModel4;
                    i16 = i18;
                    z16 = J2;
                    magicAvatarCropViewModel2.R2(i16, z16);
                } else if ((n26 instanceof f.b) || (n26 instanceof f.e)) {
                    mutableStateFlow = magicAvatarCropViewModel4._generateEvent;
                    a.b bVar = a.b.f323596a;
                    this.L$0 = magicAvatarCropViewModel4;
                    this.L$1 = n26;
                    this.I$0 = i18;
                    this.label = 2;
                    if (mutableStateFlow.emit(bVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    fVar = n26;
                    magicAvatarCropViewModel = magicAvatarCropViewModel4;
                    i3 = i18;
                    mutableSharedFlow2 = magicAvatarCropViewModel._buttonState;
                    this.L$0 = magicAvatarCropViewModel;
                    this.L$1 = null;
                    this.I$0 = i3;
                    this.label = 3;
                    if (mutableSharedFlow2.emit(fVar, this) != coroutine_suspended) {
                    }
                } else {
                    magicAvatarCropViewModel4.R2(i18, J2);
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicAvatarCropViewModel$consumeWithCachedUserCountState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
