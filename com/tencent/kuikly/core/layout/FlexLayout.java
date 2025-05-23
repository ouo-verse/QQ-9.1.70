package com.tencent.kuikly.core.layout;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0000J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/kuikly/core/layout/FlexLayout;", "", "", "d", TtmlNode.TAG_LAYOUT, "a", "other", "", "equals", "", "hashCode", "", "[F", "c", "()[F", "position", "b", "dimensions", "Lcom/tencent/kuikly/core/layout/FlexLayoutDirection;", "Lcom/tencent/kuikly/core/layout/FlexLayoutDirection;", "getDirection", "()Lcom/tencent/kuikly/core/layout/FlexLayoutDirection;", "e", "(Lcom/tencent/kuikly/core/layout/FlexLayoutDirection;)V", "direction", "<init>", "()V", "DimensionType", "PositionType", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class FlexLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float[] position = new float[4];

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float[] dimensions = new float[2];

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private FlexLayoutDirection direction = FlexLayoutDirection.LTR;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/kuikly/core/layout/FlexLayout$DimensionType;", "", "value", "", "(Ljava/lang/String;II)V", "DIMENSION_WIDTH", "DIMENSION_HEIGHT", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public enum DimensionType {
        DIMENSION_WIDTH(0),
        DIMENSION_HEIGHT(1);

        DimensionType(int i3) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/kuikly/core/layout/FlexLayout$PositionType;", "", "value", "", "(Ljava/lang/String;II)V", "POSITION_LEFT", "POSITION_TOP", "POSITION_RIGHT", "POSITION_BOTTOM", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public enum PositionType {
        POSITION_LEFT(0),
        POSITION_TOP(1),
        POSITION_RIGHT(2),
        POSITION_BOTTOM(3);

        PositionType(int i3) {
        }
    }

    public final void a(FlexLayout layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        int ordinal = PositionType.POSITION_LEFT.ordinal();
        this.position[ordinal] = layout.position[ordinal];
        int ordinal2 = PositionType.POSITION_TOP.ordinal();
        this.position[ordinal2] = layout.position[ordinal2];
        int ordinal3 = PositionType.POSITION_RIGHT.ordinal();
        this.position[ordinal3] = layout.position[ordinal3];
        int ordinal4 = PositionType.POSITION_BOTTOM.ordinal();
        this.position[ordinal4] = layout.position[ordinal4];
        int ordinal5 = DimensionType.DIMENSION_WIDTH.ordinal();
        this.dimensions[ordinal5] = layout.dimensions[ordinal5];
        int ordinal6 = DimensionType.DIMENSION_HEIGHT.ordinal();
        this.dimensions[ordinal6] = layout.dimensions[ordinal6];
        this.direction = layout.direction;
    }

    /* renamed from: b, reason: from getter */
    public final float[] getDimensions() {
        return this.dimensions;
    }

    /* renamed from: c, reason: from getter */
    public final float[] getPosition() {
        return this.position;
    }

    public final void d() {
        ArraysKt___ArraysJvmKt.fill$default(this.position, 0.0f, 0, 0, 6, (Object) null);
        float[] fArr = this.dimensions;
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        ArraysKt___ArraysJvmKt.fill$default(fArr, Float.NaN, 0, 0, 6, (Object) null);
        this.direction = FlexLayoutDirection.LTR;
    }

    public final void e(FlexLayoutDirection flexLayoutDirection) {
        Intrinsics.checkNotNullParameter(flexLayoutDirection, "<set-?>");
        this.direction = flexLayoutDirection;
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.position) * 31) + Arrays.hashCode(this.dimensions)) * 31) + this.direction.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlexLayout)) {
            return false;
        }
        FlexLayout flexLayout = (FlexLayout) other;
        return Arrays.equals(this.position, flexLayout.position) && Arrays.equals(this.dimensions, flexLayout.dimensions) && this.direction == flexLayout.direction;
    }
}
