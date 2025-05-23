package com.tencent.state.map.v2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/map/v2/Size;", "", "width", "", "height", "(FF)V", "getHeight", "()F", "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final /* data */ class Size {
    private final float height;
    private final float width;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Size() {
        this(r2, r2, 3, null);
        float f16 = 0.0f;
    }

    /* renamed from: component1, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    /* renamed from: component2, reason: from getter */
    public final float getHeight() {
        return this.height;
    }

    public final Size copy(float width, float height) {
        return new Size(width, height);
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.width) * 31) + Float.floatToIntBits(this.height);
    }

    public String toString() {
        return "Size(width=" + this.width + ", height=" + this.height + ")";
    }

    public Size(float f16, float f17) {
        this.width = f16;
        this.height = f17;
    }

    public /* synthetic */ Size(float f16, float f17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Size)) {
            return false;
        }
        Size size = (Size) other;
        return Float.compare(this.width, size.width) == 0 && Float.compare(this.height, size.height) == 0;
    }

    public static /* synthetic */ Size copy$default(Size size, float f16, float f17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = size.width;
        }
        if ((i3 & 2) != 0) {
            f17 = size.height;
        }
        return size.copy(f16, f17);
    }
}
