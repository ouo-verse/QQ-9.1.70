package com.tencent.mobileqq.wink.magicstudio;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioImageDataManager", f = "MagicStudioDataManager.kt", i = {}, l = {191}, m = "handleCutPic", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicStudioImageDataManager$handleCutPic$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MagicStudioImageDataManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioImageDataManager$handleCutPic$1(MagicStudioImageDataManager magicStudioImageDataManager, Continuation<? super MagicStudioImageDataManager$handleCutPic$1> continuation) {
        super(continuation);
        this.this$0 = magicStudioImageDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(null, null, this);
    }
}
