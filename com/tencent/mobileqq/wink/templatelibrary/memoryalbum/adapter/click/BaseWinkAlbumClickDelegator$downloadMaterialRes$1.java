package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator", f = "BaseWinkAlbumClickDelegator.kt", i = {0}, l = {236}, m = "downloadMaterialRes", n = {"costMap"}, s = {"L$0"})
/* loaded from: classes21.dex */
public final class BaseWinkAlbumClickDelegator$downloadMaterialRes$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseWinkAlbumClickDelegator<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWinkAlbumClickDelegator$downloadMaterialRes$1(BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator, Continuation<? super BaseWinkAlbumClickDelegator$downloadMaterialRes$1> continuation) {
        super(continuation);
        this.this$0 = baseWinkAlbumClickDelegator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object e16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        e16 = this.this$0.e(null, this);
        return e16;
    }
}
