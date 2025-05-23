package com.tencent.oskplayer.datasource;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SystemClock implements Clock {
    @Override // com.tencent.oskplayer.datasource.Clock
    public long elapsedRealtime() {
        return android.os.SystemClock.elapsedRealtime();
    }
}
