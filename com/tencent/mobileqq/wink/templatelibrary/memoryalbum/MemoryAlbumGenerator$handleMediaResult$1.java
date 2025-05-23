package com.tencent.mobileqq.wink.templatelibrary.memoryalbum;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumGenerator", f = "MemoryAlbumGenerator.kt", i = {}, l = {240, 241}, m = "handleMediaResult", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MemoryAlbumGenerator$handleMediaResult$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MemoryAlbumGenerator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemoryAlbumGenerator$handleMediaResult$1(MemoryAlbumGenerator memoryAlbumGenerator, Continuation<? super MemoryAlbumGenerator$handleMediaResult$1> continuation) {
        super(continuation);
        this.this$0 = memoryAlbumGenerator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object Y;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Y = this.this$0.Y(null, this);
        return Y;
    }
}
