package com.tencent.mobileqq.wink.magicAvatar.viewmodel;

import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarGenerateInfo;
import com.tencent.mobileqq.wink.magicAvatar.model.f;
import com.tencent.mobileqq.wink.magicAvatar.viewmodel.a;
import com.tencent.ttpic.openapi.filter.LightConstants;
import java.util.List;
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
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel$changeGender$1", f = "MagicAvatarCropViewModel.kt", i = {3}, l = {106, 115, 120, 125}, m = "invokeSuspend", n = {"isGen"}, s = {"Z$0"})
/* loaded from: classes21.dex */
public final class MagicAvatarCropViewModel$changeGender$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    boolean Z$0;
    int label;
    final /* synthetic */ MagicAvatarCropViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicAvatarCropViewModel$changeGender$1(MagicAvatarCropViewModel magicAvatarCropViewModel, Continuation<? super MagicAvatarCropViewModel$changeGender$1> continuation) {
        super(2, continuation);
        this.this$0 = magicAvatarCropViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicAvatarCropViewModel$changeGender$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00bd  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableStateFlow mutableStateFlow;
        List t26;
        Object U2;
        boolean J2;
        MutableSharedFlow mutableSharedFlow;
        boolean z16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                z16 = this.Z$0;
                                ResultKt.throwOnFailure(obj);
                                J2 = z16;
                                this.this$0.R2(0, J2);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        J2 = this.this$0.J2(0);
                        w53.b.f("MagicAvatarCropViewModel", "changeGender isGen: " + J2);
                        if (J2) {
                            mutableSharedFlow = this.this$0._buttonState;
                            f.a aVar = f.a.f323518a;
                            this.Z$0 = J2;
                            this.label = 4;
                            if (mutableSharedFlow.emit(aVar, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z16 = J2;
                            J2 = z16;
                        }
                        this.this$0.R2(0, J2);
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    J2 = this.this$0.J2(0);
                    w53.b.f("MagicAvatarCropViewModel", "changeGender isGen: " + J2);
                    if (J2) {
                    }
                    this.this$0.R2(0, J2);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                mutableStateFlow = this.this$0._generateEvent;
                a.g gVar = a.g.f323601a;
                this.label = 1;
                if (mutableStateFlow.emit(gVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            MagicAvatarCropViewModel magicAvatarCropViewModel = this.this$0;
            if (magicAvatarCropViewModel.M2(magicAvatarCropViewModel.getInfoFromPicker())) {
                MagicAvatarGenerateInfo infoFromPicker = this.this$0.getInfoFromPicker();
                if (infoFromPicker != null) {
                    infoFromPicker.setGender(LightConstants.MALE);
                }
            } else {
                MagicAvatarGenerateInfo infoFromPicker2 = this.this$0.getInfoFromPicker();
                if (infoFromPicker2 != null) {
                    infoFromPicker2.setGender(LightConstants.FEMALE);
                }
            }
            t26 = this.this$0.t2();
            if (t26.isEmpty()) {
                w53.b.f("MagicAvatarCropViewModel", "changeGender need init data");
                MagicAvatarCropViewModel magicAvatarCropViewModel2 = this.this$0;
                this.label = 2;
                U2 = magicAvatarCropViewModel2.U2(this);
                if (U2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                J2 = this.this$0.J2(0);
                w53.b.f("MagicAvatarCropViewModel", "changeGender isGen: " + J2);
                if (J2) {
                }
                this.this$0.R2(0, J2);
                return Unit.INSTANCE;
            }
            MagicAvatarCropViewModel magicAvatarCropViewModel3 = this.this$0;
            this.label = 3;
            if (MagicAvatarCropViewModel.Q2(magicAvatarCropViewModel3, null, this, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            J2 = this.this$0.J2(0);
            w53.b.f("MagicAvatarCropViewModel", "changeGender isGen: " + J2);
            if (J2) {
            }
            this.this$0.R2(0, J2);
            return Unit.INSTANCE;
        } catch (Exception unused) {
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicAvatarCropViewModel$changeGender$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
