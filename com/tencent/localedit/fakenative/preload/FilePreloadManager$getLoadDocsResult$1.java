package com.tencent.localedit.fakenative.preload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.localedit.fakenative.preload.FilePreloadManager", f = "FilePreloadManager.kt", i = {0}, l = {58}, m = "getLoadDocsResult", n = {"globalPadId"}, s = {"L$0"})
/* loaded from: classes7.dex */
public final class FilePreloadManager$getLoadDocsResult$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FilePreloadManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilePreloadManager$getLoadDocsResult$1(FilePreloadManager filePreloadManager, Continuation<? super FilePreloadManager$getLoadDocsResult$1> continuation) {
        super(continuation);
        this.this$0 = filePreloadManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getLoadDocsResult(null, this);
    }
}
