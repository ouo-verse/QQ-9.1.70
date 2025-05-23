package com.tencent.mobileqq.wink.magicAvatar.viewmodel;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.magicAvatar.model.AvatarCountInfo;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarDataSource;
import com.tencent.mobileqq.wink.magicAvatar.model.f;
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
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel$checkCount$1", f = "MagicAvatarCropViewModel.kt", i = {1, 2, 4}, l = {405, 408, 414, 417, 422, 423}, m = "invokeSuspend", n = {"info", "state", "state"}, s = {"L$0", "L$0", "L$0"})
/* loaded from: classes21.dex */
public final class MagicAvatarCropViewModel$checkCount$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MagicAvatarCropViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicAvatarCropViewModel$checkCount$1(MagicAvatarCropViewModel magicAvatarCropViewModel, Continuation<? super MagicAvatarCropViewModel$checkCount$1> continuation) {
        super(2, continuation);
        this.this$0 = magicAvatarCropViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicAvatarCropViewModel$checkCount$1(this.this$0, continuation);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0120 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e6 A[Catch: Exception -> 0x0127, TryCatch #0 {Exception -> 0x0127, blocks: (B:7:0x0017, B:8:0x0121, B:12:0x0020, B:13:0x010f, B:16:0x0025, B:17:0x00f4, B:20:0x002e, B:21:0x00de, B:23:0x00e6, B:26:0x00f7, B:28:0x00fb, B:32:0x0037, B:33:0x0082, B:37:0x003b, B:38:0x0059, B:42:0x0048), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f7 A[Catch: Exception -> 0x0127, TryCatch #0 {Exception -> 0x0127, blocks: (B:7:0x0017, B:8:0x0121, B:12:0x0020, B:13:0x010f, B:16:0x0025, B:17:0x00f4, B:20:0x002e, B:21:0x00de, B:23:0x00e6, B:26:0x00f7, B:28:0x00fb, B:32:0x0037, B:33:0x0082, B:37:0x003b, B:38:0x0059, B:42:0x0048), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00dc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0081 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        AvatarCountInfo avatarCountInfo;
        com.tencent.mobileqq.wink.magicAvatar.model.f n26;
        boolean z17;
        MutableSharedFlow mutableSharedFlow;
        com.tencent.mobileqq.wink.magicAvatar.model.f fVar;
        boolean z18;
        MutableSharedFlow mutableSharedFlow2;
        Object f36;
        MutableSharedFlow mutableSharedFlow3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception unused) {
            z16 = this.this$0.hasInitCountSuccess;
            if (z16) {
                QQToast.makeText(MobileQQ.sMobileQQ, "\u7f51\u7edc\u62e5\u6324\uff0c\u8bf7\u91cd\u65b0\u8fdb\u5165", 0).show();
                return Unit.INSTANCE;
            }
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                w53.b.f("MagicAvatarCropViewModel", "checkCount");
                MagicAvatarDataSource magicAvatarDataSource = MagicAvatarDataSource.f323499a;
                int from = this.this$0.getFrom();
                this.label = 1;
                obj = magicAvatarDataSource.i(from, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                avatarCountInfo = (AvatarCountInfo) obj;
                w53.b.f("MagicAvatarCropViewModel", "getCount = " + avatarCountInfo);
                MagicAvatarCropViewModel.Z = avatarCountInfo;
                MagicAvatarDataSource magicAvatarDataSource2 = MagicAvatarDataSource.f323499a;
                this.L$0 = avatarCountInfo;
                this.label = 2;
                obj = magicAvatarDataSource2.l(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                AvatarCountInfo avatarCountInfo2 = (AvatarCountInfo) obj;
                w53.b.f("MagicAvatarCropViewModel", "getVipCount = " + avatarCountInfo2);
                MagicAvatarCropViewModel.f323590a0 = avatarCountInfo2;
                n26 = this.this$0.n2(avatarCountInfo, avatarCountInfo2);
                this.this$0.d3(n26);
                z17 = this.this$0.hasInitCountSuccess;
                w53.b.f("MagicAvatarCropViewModel", "hasInitCountSuccess = " + z17 + ", state = " + n26);
                mutableSharedFlow = this.this$0._styleFragmentButtonState;
                this.L$0 = n26;
                this.label = 3;
                if (mutableSharedFlow.emit(n26, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                fVar = n26;
                z18 = this.this$0.hasInitCountSuccess;
                if (z18) {
                    MagicAvatarCropViewModel magicAvatarCropViewModel = this.this$0;
                    this.L$0 = null;
                    this.label = 4;
                    f36 = magicAvatarCropViewModel.f3(fVar, this);
                    if (f36 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                if (fVar instanceof f.C9055f) {
                    mutableSharedFlow2 = this.this$0._refreshButtonState;
                    Unit unit = Unit.INSTANCE;
                    this.L$0 = fVar;
                    this.label = 5;
                    if (mutableSharedFlow2.emit(unit, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutableSharedFlow3 = this.this$0._textCountState;
                    this.L$0 = null;
                    this.label = 6;
                    if (mutableSharedFlow3.emit(fVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                this.this$0.hasInitCountSuccess = true;
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure(obj);
                avatarCountInfo = (AvatarCountInfo) obj;
                w53.b.f("MagicAvatarCropViewModel", "getCount = " + avatarCountInfo);
                MagicAvatarCropViewModel.Z = avatarCountInfo;
                MagicAvatarDataSource magicAvatarDataSource22 = MagicAvatarDataSource.f323499a;
                this.L$0 = avatarCountInfo;
                this.label = 2;
                obj = magicAvatarDataSource22.l(this);
                if (obj == coroutine_suspended) {
                }
                AvatarCountInfo avatarCountInfo22 = (AvatarCountInfo) obj;
                w53.b.f("MagicAvatarCropViewModel", "getVipCount = " + avatarCountInfo22);
                MagicAvatarCropViewModel.f323590a0 = avatarCountInfo22;
                n26 = this.this$0.n2(avatarCountInfo, avatarCountInfo22);
                this.this$0.d3(n26);
                z17 = this.this$0.hasInitCountSuccess;
                w53.b.f("MagicAvatarCropViewModel", "hasInitCountSuccess = " + z17 + ", state = " + n26);
                mutableSharedFlow = this.this$0._styleFragmentButtonState;
                this.L$0 = n26;
                this.label = 3;
                if (mutableSharedFlow.emit(n26, this) == coroutine_suspended) {
                }
                break;
            case 2:
                avatarCountInfo = (AvatarCountInfo) this.L$0;
                ResultKt.throwOnFailure(obj);
                AvatarCountInfo avatarCountInfo222 = (AvatarCountInfo) obj;
                w53.b.f("MagicAvatarCropViewModel", "getVipCount = " + avatarCountInfo222);
                MagicAvatarCropViewModel.f323590a0 = avatarCountInfo222;
                n26 = this.this$0.n2(avatarCountInfo, avatarCountInfo222);
                this.this$0.d3(n26);
                z17 = this.this$0.hasInitCountSuccess;
                w53.b.f("MagicAvatarCropViewModel", "hasInitCountSuccess = " + z17 + ", state = " + n26);
                mutableSharedFlow = this.this$0._styleFragmentButtonState;
                this.L$0 = n26;
                this.label = 3;
                if (mutableSharedFlow.emit(n26, this) == coroutine_suspended) {
                }
                break;
            case 3:
                fVar = (com.tencent.mobileqq.wink.magicAvatar.model.f) this.L$0;
                ResultKt.throwOnFailure(obj);
                z18 = this.this$0.hasInitCountSuccess;
                if (z18) {
                }
                break;
            case 4:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 5:
                fVar = (com.tencent.mobileqq.wink.magicAvatar.model.f) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutableSharedFlow3 = this.this$0._textCountState;
                this.L$0 = null;
                this.label = 6;
                if (mutableSharedFlow3.emit(fVar, this) == coroutine_suspended) {
                }
                this.this$0.hasInitCountSuccess = true;
                return Unit.INSTANCE;
            case 6:
                ResultKt.throwOnFailure(obj);
                this.this$0.hasInitCountSuccess = true;
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicAvatarCropViewModel$checkCount$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
