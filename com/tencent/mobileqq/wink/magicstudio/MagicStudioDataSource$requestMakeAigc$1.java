package com.tencent.mobileqq.wink.magicstudio;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioDataSource", f = "MagicStudioDataSource.kt", i = {}, l = {431}, m = "requestMakeAigc", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicStudioDataSource$requestMakeAigc$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MagicStudioDataSource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioDataSource$requestMakeAigc$1(MagicStudioDataSource magicStudioDataSource, Continuation<? super MagicStudioDataSource$requestMakeAigc$1> continuation) {
        super(continuation);
        this.this$0 = magicStudioDataSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j0(null, null, null, null, null, false, this);
    }
}
