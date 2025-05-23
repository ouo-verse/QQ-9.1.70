package com.tencent.mobileqq.wink.magicAvatar.viewmodel;

import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarMaterialInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel$onStyleClicked$1", f = "MagicAvatarCropViewModel.kt", i = {0, 1}, l = {295, 297, 304, 305}, m = "invokeSuspend", n = {"curr", "curr"}, s = {"L$0", "L$0"})
/* loaded from: classes21.dex */
public final class MagicAvatarCropViewModel$onStyleClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $hasGenerate;
    final /* synthetic */ int $pos;
    Object L$0;
    int label;
    final /* synthetic */ MagicAvatarCropViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicAvatarCropViewModel$onStyleClicked$1(MagicAvatarCropViewModel magicAvatarCropViewModel, int i3, boolean z16, Continuation<? super MagicAvatarCropViewModel$onStyleClicked$1> continuation) {
        super(2, continuation);
        this.this$0 = magicAvatarCropViewModel;
        this.$pos = i3;
        this.$hasGenerate = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicAvatarCropViewModel$onStyleClicked$1(this.this$0, this.$pos, this.$hasGenerate, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0088  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List t26;
        Object orNull;
        MagicAvatarMaterialInfo magicAvatarMaterialInfo;
        Object e36;
        Object U2;
        Object v26;
        MagicAvatarMaterialInfo magicAvatarMaterialInfo2;
        MagicAvatarCropViewModel magicAvatarCropViewModel;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            ResultKt.throwOnFailure(obj);
                            this.this$0.b3(false);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    magicAvatarCropViewModel = this.this$0;
                    this.label = 4;
                    if (MagicAvatarCropViewModel.Q2(magicAvatarCropViewModel, null, this, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.this$0.b3(false);
                    return Unit.INSTANCE;
                }
                magicAvatarMaterialInfo2 = (MagicAvatarMaterialInfo) this.L$0;
                ResultKt.throwOnFailure(obj);
                magicAvatarMaterialInfo = magicAvatarMaterialInfo2;
                this.this$0.N2(magicAvatarMaterialInfo.getLocalPicPath());
                this.this$0.b3(false);
                return Unit.INSTANCE;
            }
            MagicAvatarMaterialInfo magicAvatarMaterialInfo3 = (MagicAvatarMaterialInfo) this.L$0;
            ResultKt.throwOnFailure(obj);
            magicAvatarMaterialInfo = magicAvatarMaterialInfo3;
            if (!this.$hasGenerate) {
                MagicAvatarCropViewModel magicAvatarCropViewModel2 = this.this$0;
                this.L$0 = magicAvatarMaterialInfo;
                this.label = 2;
                v26 = magicAvatarCropViewModel2.v2(magicAvatarMaterialInfo, this);
                if (v26 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                magicAvatarMaterialInfo2 = magicAvatarMaterialInfo;
                magicAvatarMaterialInfo = magicAvatarMaterialInfo2;
            }
            this.this$0.N2(magicAvatarMaterialInfo.getLocalPicPath());
            this.this$0.b3(false);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        t26 = this.this$0.t2();
        orNull = CollectionsKt___CollectionsKt.getOrNull(t26, this.$pos);
        magicAvatarMaterialInfo = (MagicAvatarMaterialInfo) orNull;
        if (magicAvatarMaterialInfo == null) {
            return Unit.INSTANCE;
        }
        this.this$0.b3(true);
        int type = magicAvatarMaterialInfo.getType();
        if (type != 0) {
            if (type == 1) {
                MagicAvatarCropViewModel magicAvatarCropViewModel3 = this.this$0;
                this.label = 3;
                U2 = magicAvatarCropViewModel3.U2(this);
                if (U2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                magicAvatarCropViewModel = this.this$0;
                this.label = 4;
                if (MagicAvatarCropViewModel.Q2(magicAvatarCropViewModel, null, this, 1, null) == coroutine_suspended) {
                }
            }
            this.this$0.b3(false);
            return Unit.INSTANCE;
        }
        this.this$0.a3(magicAvatarMaterialInfo);
        MagicAvatarCropViewModel magicAvatarCropViewModel4 = this.this$0;
        this.L$0 = magicAvatarMaterialInfo;
        this.label = 1;
        e36 = magicAvatarCropViewModel4.e3(magicAvatarMaterialInfo, this);
        if (e36 == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (!this.$hasGenerate) {
        }
        this.this$0.N2(magicAvatarMaterialInfo.getLocalPicPath());
        this.this$0.b3(false);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicAvatarCropViewModel$onStyleClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
