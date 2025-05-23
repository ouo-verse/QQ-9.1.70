package com.tencent.mobileqq.wink.aiavatar.base;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarGenerateBtnViewModel", f = "WinkAIAvatarGenerateBtnViewModel.kt", i = {0}, l = {115}, m = "requestGetBtnStatus", n = {"this"}, s = {"L$0"})
/* loaded from: classes21.dex */
public final class WinkAIAvatarGenerateBtnViewModel$requestGetBtnStatus$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkAIAvatarGenerateBtnViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAIAvatarGenerateBtnViewModel$requestGetBtnStatus$1(WinkAIAvatarGenerateBtnViewModel winkAIAvatarGenerateBtnViewModel, Continuation<? super WinkAIAvatarGenerateBtnViewModel$requestGetBtnStatus$1> continuation) {
        super(continuation);
        this.this$0 = winkAIAvatarGenerateBtnViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object Z1;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Z1 = this.this$0.Z1(this);
        return Z1;
    }
}
