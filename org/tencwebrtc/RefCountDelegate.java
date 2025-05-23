package org.tencwebrtc;

import android.support.annotation.Nullable;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes29.dex */
class RefCountDelegate implements RefCounted {
    private final AtomicInteger refCount = new AtomicInteger(1);

    @Nullable
    private final Runnable releaseCallback;

    public RefCountDelegate(@Nullable Runnable runnable) {
        this.releaseCallback = runnable;
    }

    @Override // org.tencwebrtc.RefCounted
    public void release() {
        Runnable runnable;
        if (this.refCount.decrementAndGet() == 0 && (runnable = this.releaseCallback) != null) {
            runnable.run();
        }
    }

    @Override // org.tencwebrtc.RefCounted
    public void retain() {
        this.refCount.incrementAndGet();
    }
}
