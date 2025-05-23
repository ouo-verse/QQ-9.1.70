package com.tencent.state.square.media.extractor;

import com.tencent.state.square.media.MediaSource;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/square/media/extractor/MediaFuture;", "", "source", "Lcom/tencent/state/square/media/MediaSource;", "(Lcom/tencent/state/square/media/MediaSource;)V", "isSuccess", "", "()Ljava/lang/Boolean;", "setSuccess", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "latch", "Ljava/util/concurrent/CountDownLatch;", "await", "", "cancel", "complete", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MediaFuture {
    private Boolean isSuccess;
    private final CountDownLatch latch;
    private final MediaSource source;

    public MediaFuture(MediaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.latch = new CountDownLatch(1);
    }

    public final void await() {
        this.latch.await();
    }

    public final void cancel() {
        this.latch.countDown();
    }

    public final void complete() {
        this.latch.countDown();
    }

    /* renamed from: isSuccess, reason: from getter */
    public final Boolean getIsSuccess() {
        return this.isSuccess;
    }

    public final void setSuccess(Boolean bool) {
        this.isSuccess = bool;
    }
}
