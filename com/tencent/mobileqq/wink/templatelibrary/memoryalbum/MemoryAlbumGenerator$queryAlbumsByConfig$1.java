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
@DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumGenerator", f = "MemoryAlbumGenerator.kt", i = {0, 0, 0}, l = {313}, m = "queryAlbumsByConfig", n = {"this", "queryAlbums", "queryResult"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes21.dex */
public final class MemoryAlbumGenerator$queryAlbumsByConfig$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MemoryAlbumGenerator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemoryAlbumGenerator$queryAlbumsByConfig$1(MemoryAlbumGenerator memoryAlbumGenerator, Continuation<? super MemoryAlbumGenerator$queryAlbumsByConfig$1> continuation) {
        super(continuation);
        this.this$0 = memoryAlbumGenerator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object h06;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        h06 = this.this$0.h0(null, this);
        return h06;
    }
}
