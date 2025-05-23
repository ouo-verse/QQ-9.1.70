package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes2.dex */
final class SystemClock implements Clock {
    @Override // com.google.android.exoplayer2.util.Clock
    public HandlerWrapper createHandler(Looper looper, @Nullable Handler.Callback callback) {
        return new SystemHandlerWrapper(new Handler(looper, callback));
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public long elapsedRealtime() {
        return android.os.SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public void sleep(long j3) {
        android.os.SystemClock.sleep(j3);
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public long uptimeMillis() {
        return android.os.SystemClock.uptimeMillis();
    }
}
