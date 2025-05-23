package com.tencent.filament.zplan.util;

import androidx.annotation.Keep;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@NativeProxy(allFields = false, allMethods = false)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u0003J\u0006\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u000bJ\u0011\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J\u0011\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0011\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0011\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0011\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0011\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0011\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0011\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0011\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0011\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0011\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0011\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0011\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082 J\u0006\u0010 \u001a\u00020\bJ\u0006\u0010!\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/tencent/filament/zplan/util/GamePerformanceMonitor;", "", "targetFps", "", "(I)V", "nativeObject", "", "destory", "", "endFrame", "getAverageFrameInterval", "", "getAverageFrameRate", "getFrameCount", "getJankCount", "getPerfDogBigJankCount", "getPerfDogJankCount", "getPerfDogStutterRate", "getStutterRate", "nCreateMonitor", "nDestroy", "nEndFrame", "nGetAverageFrameInterval", "nGetAverageFrameRate", "nGetFrameCount", "nGetJankCount", "nGetPerfDogBigJankCount", "nGetPerfDogJankCount", "nGetPerfDogStutterRate", "nGetStutterRate", "nRest", "nStartFrame", "reset", "startFrame", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class GamePerformanceMonitor {
    private long nativeObject;

    public GamePerformanceMonitor() {
        this(0, 1, null);
    }

    private final native long nCreateMonitor(int targetFps);

    private final native void nDestroy(long nativeObject);

    private final native void nEndFrame(long nativeObject);

    private final native double nGetAverageFrameInterval(long nativeObject);

    private final native double nGetAverageFrameRate(long nativeObject);

    private final native int nGetFrameCount(long nativeObject);

    private final native int nGetJankCount(long nativeObject);

    private final native int nGetPerfDogBigJankCount(long nativeObject);

    private final native int nGetPerfDogJankCount(long nativeObject);

    private final native double nGetPerfDogStutterRate(long nativeObject);

    private final native double nGetStutterRate(long nativeObject);

    private final native void nRest(long nativeObject);

    private final native void nStartFrame(long nativeObject);

    public final void destory() {
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return;
        }
        nDestroy(j3);
        this.nativeObject = 0L;
    }

    public final void endFrame() {
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return;
        }
        nEndFrame(j3);
    }

    public final double getAverageFrameInterval() {
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return 0.0d;
        }
        return nGetAverageFrameInterval(j3);
    }

    public final double getAverageFrameRate() {
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return 0.0d;
        }
        return nGetAverageFrameRate(j3);
    }

    public final int getFrameCount() {
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return 0;
        }
        return nGetFrameCount(j3);
    }

    public final int getJankCount() {
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return 0;
        }
        return nGetJankCount(j3);
    }

    public final int getPerfDogBigJankCount() {
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return 0;
        }
        return nGetPerfDogBigJankCount(j3);
    }

    public final int getPerfDogJankCount() {
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return 0;
        }
        return nGetPerfDogJankCount(j3);
    }

    public final double getPerfDogStutterRate() {
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return 0.0d;
        }
        return nGetPerfDogStutterRate(j3);
    }

    public final double getStutterRate() {
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return 0.0d;
        }
        return nGetStutterRate(j3);
    }

    public final void reset() {
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return;
        }
        nRest(j3);
    }

    public final void startFrame() {
        long j3 = this.nativeObject;
        if (j3 == 0) {
            return;
        }
        nStartFrame(j3);
    }

    public GamePerformanceMonitor(int i3) {
        this.nativeObject = nCreateMonitor(i3);
    }

    public /* synthetic */ GamePerformanceMonitor(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 30 : i3);
    }
}
