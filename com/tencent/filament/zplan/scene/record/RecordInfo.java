package com.tencent.filament.zplan.scene.record;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/filament/zplan/scene/record/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "D", "b", "()D", "frameDuration", "I", "e", "()I", "width", "c", "height", "d", "fps", "getDuration", "duration", "f", "totalFrameCount", "<init>", "(IIIDI)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.filament.zplan.scene.record.b, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class RecordInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final double frameDuration;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int width;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int height;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int fps;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final double duration;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int totalFrameCount;

    public RecordInfo(int i3, int i16, int i17, double d16, int i18) {
        this.width = i3;
        this.height = i16;
        this.fps = i17;
        this.duration = d16;
        this.totalFrameCount = i18;
        this.frameDuration = 1.0d / i17;
    }

    /* renamed from: a, reason: from getter */
    public final int getFps() {
        return this.fps;
    }

    /* renamed from: b, reason: from getter */
    public final double getFrameDuration() {
        return this.frameDuration;
    }

    /* renamed from: c, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: d, reason: from getter */
    public final int getTotalFrameCount() {
        return this.totalFrameCount;
    }

    /* renamed from: e, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof RecordInfo) {
                RecordInfo recordInfo = (RecordInfo) other;
                if (this.width != recordInfo.width || this.height != recordInfo.height || this.fps != recordInfo.fps || Double.compare(this.duration, recordInfo.duration) != 0 || this.totalFrameCount != recordInfo.totalFrameCount) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3 = ((((this.width * 31) + this.height) * 31) + this.fps) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.duration);
        return ((i3 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.totalFrameCount;
    }

    @NotNull
    public String toString() {
        return "RecordInfo(width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + ", duration=" + this.duration + ", totalFrameCount=" + this.totalFrameCount + ")";
    }
}
