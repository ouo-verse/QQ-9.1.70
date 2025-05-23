package com.tencent.mobileqq.wink.downloader;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.downloader.WinkQZoneMediaDownloader", f = "WinkQZoneMediaDownloader.kt", i = {0, 0, 1, 1}, l = {64, 76}, m = "downloadVideo", n = {"this", "downloadUrl", "downloadUrl", "filePath"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes21.dex */
public final class WinkQZoneMediaDownloader$downloadVideo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WinkQZoneMediaDownloader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkQZoneMediaDownloader$downloadVideo$1(WinkQZoneMediaDownloader winkQZoneMediaDownloader, Continuation<? super WinkQZoneMediaDownloader$downloadVideo$1> continuation) {
        super(continuation);
        this.this$0 = winkQZoneMediaDownloader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
