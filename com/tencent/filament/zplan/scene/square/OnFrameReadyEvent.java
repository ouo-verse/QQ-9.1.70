package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0005H\u00c6\u0003J1\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u00c6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u000b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001b\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/filament/zplan/scene/square/OnFrameReadyEvent;", "Lcom/tencent/filament/zplan/scene/square/SquareMapEvent;", "", "component1", "component2", "", "component3", "component4", "pixels", "pixelsSize", "width", "height", "copy", "", "toString", "hashCode", "", "other", "", "equals", "J", "getPixels", "()J", "getPixelsSize", "I", "getWidth", "()I", "getHeight", "<init>", "(JJII)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class OnFrameReadyEvent extends SquareMapEvent {

    @NotNull
    public static final String NAME = "SquareMapScene.EVENT_FRAME_READY";
    private final int height;
    private final long pixels;
    private final long pixelsSize;
    private final int width;

    public OnFrameReadyEvent(long j3, long j16, int i3, int i16) {
        super(NAME);
        this.pixels = j3;
        this.pixelsSize = j16;
        this.width = i3;
        this.height = i16;
    }

    public static /* synthetic */ OnFrameReadyEvent copy$default(OnFrameReadyEvent onFrameReadyEvent, long j3, long j16, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            j3 = onFrameReadyEvent.pixels;
        }
        long j17 = j3;
        if ((i17 & 2) != 0) {
            j16 = onFrameReadyEvent.pixelsSize;
        }
        long j18 = j16;
        if ((i17 & 4) != 0) {
            i3 = onFrameReadyEvent.width;
        }
        int i18 = i3;
        if ((i17 & 8) != 0) {
            i16 = onFrameReadyEvent.height;
        }
        return onFrameReadyEvent.copy(j17, j18, i18, i16);
    }

    /* renamed from: component1, reason: from getter */
    public final long getPixels() {
        return this.pixels;
    }

    /* renamed from: component2, reason: from getter */
    public final long getPixelsSize() {
        return this.pixelsSize;
    }

    /* renamed from: component3, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component4, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final OnFrameReadyEvent copy(long pixels, long pixelsSize, int width, int height) {
        return new OnFrameReadyEvent(pixels, pixelsSize, width, height);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof OnFrameReadyEvent) {
                OnFrameReadyEvent onFrameReadyEvent = (OnFrameReadyEvent) other;
                if (this.pixels != onFrameReadyEvent.pixels || this.pixelsSize != onFrameReadyEvent.pixelsSize || this.width != onFrameReadyEvent.width || this.height != onFrameReadyEvent.height) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getHeight() {
        return this.height;
    }

    public final long getPixels() {
        return this.pixels;
    }

    public final long getPixelsSize() {
        return this.pixelsSize;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        long j3 = this.pixels;
        int i3 = ((int) (j3 ^ (j3 >>> 32))) * 31;
        long j16 = this.pixelsSize;
        return ((((i3 + ((int) ((j16 >>> 32) ^ j16))) * 31) + this.width) * 31) + this.height;
    }

    @NotNull
    public String toString() {
        return "OnFrameReadyEvent(pixels=" + this.pixels + ", pixelsSize=" + this.pixelsSize + ", width=" + this.width + ", height=" + this.height + ")";
    }
}
