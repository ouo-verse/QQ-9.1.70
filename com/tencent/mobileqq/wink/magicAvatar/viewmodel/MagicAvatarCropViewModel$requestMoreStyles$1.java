package com.tencent.mobileqq.wink.magicAvatar.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel", f = "MagicAvatarCropViewModel.kt", i = {1}, l = {178, 182, 188, 196}, m = "requestMoreStyles", n = {"this"}, s = {"L$0"})
/* loaded from: classes21.dex */
public final class MagicAvatarCropViewModel$requestMoreStyles$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MagicAvatarCropViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicAvatarCropViewModel$requestMoreStyles$1(MagicAvatarCropViewModel magicAvatarCropViewModel, Continuation<? super MagicAvatarCropViewModel$requestMoreStyles$1> continuation) {
        super(continuation);
        this.this$0 = magicAvatarCropViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object U2;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        U2 = this.this$0.U2(this);
        return U2;
    }
}
