package com.tencent.filament.zplan.util.vsync;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/filament/zplan/util/vsync/a;", "", "", "fps", "", "a", "", "drawingTimeNanos", "", "b", "", "D", "fpsIntervalNanos", "J", "accumulateStartTimeNanos", "", "c", "I", "accumulatedFrames", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile double fpsIntervalNanos;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile long accumulateStartTimeNanos = -1000;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int accumulatedFrames;

    public final void a(float fps) {
        double nanos;
        if (fps <= 0) {
            nanos = 0.0d;
        } else {
            nanos = TimeUnit.SECONDS.toNanos(1L) / fps;
        }
        this.fpsIntervalNanos = nanos;
        this.accumulateStartTimeNanos = 0L;
    }

    public final boolean b(long drawingTimeNanos) {
        boolean z16 = true;
        if (this.fpsIntervalNanos != 0.0d && drawingTimeNanos > 0) {
            long j3 = drawingTimeNanos - this.accumulateStartTimeNanos;
            double d16 = j3 / this.fpsIntervalNanos;
            int i3 = this.accumulatedFrames;
            if (d16 >= i3) {
                this.accumulatedFrames = i3 + 1;
            } else {
                z16 = false;
            }
            if (j3 > TimeUnit.SECONDS.toNanos(1L)) {
                this.accumulateStartTimeNanos = drawingTimeNanos;
                this.accumulatedFrames = 0;
            }
        }
        return z16;
    }
}
