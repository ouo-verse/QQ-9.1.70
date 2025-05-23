package com.google.android.renderscript;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014B\t\b\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/google/android/renderscript/Range2d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "startX", "b", "endX", "d", "startY", "endY", "<init>", "(IIII)V", "()V", "renderscript-toolkit_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class Range2d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int startX;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int endX;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int startY;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int endY;

    public Range2d(int i3, int i16, int i17, int i18) {
        this.startX = i3;
        this.endX = i16;
        this.startY = i17;
        this.endY = i18;
    }

    /* renamed from: a, reason: from getter */
    public final int getEndX() {
        return this.endX;
    }

    /* renamed from: b, reason: from getter */
    public final int getEndY() {
        return this.endY;
    }

    /* renamed from: c, reason: from getter */
    public final int getStartX() {
        return this.startX;
    }

    /* renamed from: d, reason: from getter */
    public final int getStartY() {
        return this.startY;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Range2d) {
                Range2d range2d = (Range2d) other;
                if (this.startX != range2d.startX || this.endX != range2d.endX || this.startY != range2d.startY || this.endY != range2d.endY) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((this.startX * 31) + this.endX) * 31) + this.startY) * 31) + this.endY;
    }

    @NotNull
    public String toString() {
        return "Range2d(startX=" + this.startX + ", endX=" + this.endX + ", startY=" + this.startY + ", endY=" + this.endY + ")";
    }

    public Range2d() {
        this(0, 0, 0, 0);
    }
}
