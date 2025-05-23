package com.tencent.mobileqq.wink.magicAvatar.viewmodel;

import android.graphics.Bitmap;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarDataSource;
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
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel$loadBitmap$1", f = "MagicAvatarCropViewModel.kt", i = {}, l = {143, 144, 145, 147}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicAvatarCropViewModel$loadBitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $path;
    int label;
    final /* synthetic */ MagicAvatarCropViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicAvatarCropViewModel$loadBitmap$1(String str, MagicAvatarCropViewModel magicAvatarCropViewModel, Continuation<? super MagicAvatarCropViewModel$loadBitmap$1> continuation) {
        super(2, continuation);
        this.$path = str;
        this.this$0 = magicAvatarCropViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicAvatarCropViewModel$loadBitmap$1(this.$path, this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0060 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        MagicAvatarCropViewModel magicAvatarCropViewModel;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
        } catch (Exception e16) {
            mutableStateFlow = this.this$0._generateEvent;
            a.e eVar = new a.e(e16);
            this.label = 4;
            if (mutableStateFlow.emit(eVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                magicAvatarCropViewModel = this.this$0;
                this.label = 3;
                if (MagicAvatarCropViewModel.Q2(magicAvatarCropViewModel, null, this, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            MagicAvatarDataSource magicAvatarDataSource = MagicAvatarDataSource.f323499a;
            String str = this.$path;
            this.label = 1;
            obj = magicAvatarDataSource.n(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        mutableStateFlow2 = this.this$0._generateEvent;
        a.f fVar = new a.f((Bitmap) obj);
        this.label = 2;
        if (mutableStateFlow2.emit(fVar, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        magicAvatarCropViewModel = this.this$0;
        this.label = 3;
        if (MagicAvatarCropViewModel.Q2(magicAvatarCropViewModel, null, this, 1, null) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicAvatarCropViewModel$loadBitmap$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
