package com.tencent.mobileqq.wink.picker.interceptor;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.wink.picker.interceptor.DownloadQZoneMediaInterceptor", f = "DownloadQZoneMediaInterceptor.kt", i = {0, 0}, l = {101}, m = "downloadVideos", n = {"this", "unDownloadedVideos"}, s = {"L$0", "L$1"})
/* loaded from: classes21.dex */
public final class DownloadQZoneMediaInterceptor$downloadVideos$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadQZoneMediaInterceptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadQZoneMediaInterceptor$downloadVideos$1(DownloadQZoneMediaInterceptor downloadQZoneMediaInterceptor, Continuation<? super DownloadQZoneMediaInterceptor$downloadVideos$1> continuation) {
        super(continuation);
        this.this$0 = downloadQZoneMediaInterceptor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object h16;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        h16 = this.this$0.h(null, null, this);
        return h16;
    }
}
