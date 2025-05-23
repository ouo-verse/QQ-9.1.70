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
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel", f = "MagicAvatarCropViewModel.kt", i = {0, 0, 1, 1, 2}, l = {360, 361, 369, com.tencent.luggage.wxa.se.b.CTRL_INDEX}, m = "generateAvatar", n = {"this", "curr", "this", "curr", "this"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
/* loaded from: classes21.dex */
public final class MagicAvatarCropViewModel$generateAvatar$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MagicAvatarCropViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicAvatarCropViewModel$generateAvatar$1(MagicAvatarCropViewModel magicAvatarCropViewModel, Continuation<? super MagicAvatarCropViewModel$generateAvatar$1> continuation) {
        super(continuation);
        this.this$0 = magicAvatarCropViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object v26;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        v26 = this.this$0.v2(null, this);
        return v26;
    }
}
