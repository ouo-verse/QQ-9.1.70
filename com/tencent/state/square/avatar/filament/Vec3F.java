package com.tencent.state.square.avatar.filament;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\u0006\u0010\u001a\u001a\u00020\u0000J\u0011\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0000H\u0086\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020\u0000H\u0086\u0002R\u0011\u0010\u0007\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/square/avatar/filament/Vec3F;", "", HippyTKDListViewAdapter.X, "", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(FFF)V", "length", "getLength", "()F", "getX", "setX", "(F)V", "getY", "setY", "getZ", "setZ", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "normalize", QCircleDaTongConstant.ElementParamValue.PLUS, "toFloatArray", "", "toString", "", "unaryMinus", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class Vec3F {
    private float x;
    private float y;
    private float z;

    public Vec3F() {
        this(0.0f, 0.0f, 0.0f, 7, null);
    }

    /* renamed from: component1, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* renamed from: component2, reason: from getter */
    public final float getY() {
        return this.y;
    }

    /* renamed from: component3, reason: from getter */
    public final float getZ() {
        return this.z;
    }

    public final Vec3F copy(float x16, float y16, float z16) {
        return new Vec3F(x16, y16, z16);
    }

    public final float getLength() {
        float f16 = this.x;
        float f17 = this.y;
        float f18 = (f16 * f16) + (f17 * f17);
        float f19 = this.z;
        return (float) Math.sqrt(f18 + (f19 * f19));
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final float getZ() {
        return this.z;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y)) * 31) + Float.floatToIntBits(this.z);
    }

    public final Vec3F normalize() {
        float length = getLength();
        return length != 0.0f ? new Vec3F(this.x / length, this.y / length, this.z / length) : this;
    }

    public final Vec3F plus(Vec3F other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return new Vec3F(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public final void setX(float f16) {
        this.x = f16;
    }

    public final void setY(float f16) {
        this.y = f16;
    }

    public final void setZ(float f16) {
        this.z = f16;
    }

    public String toString() {
        return "Vec3F(x=" + this.x + ", y=" + this.y + ", z=" + this.z + ")";
    }

    public final Vec3F unaryMinus() {
        return new Vec3F(-this.x, -this.y, -this.z);
    }

    public Vec3F(float f16, float f17, float f18) {
        this.x = f16;
        this.y = f17;
        this.z = f18;
    }

    public final float[] toFloatArray() {
        return new float[]{this.x, this.y, this.z};
    }

    public /* synthetic */ Vec3F(float f16, float f17, float f18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17, (i3 & 4) != 0 ? 0.0f : f18);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Vec3F)) {
            return false;
        }
        Vec3F vec3F = (Vec3F) other;
        return Float.compare(this.x, vec3F.x) == 0 && Float.compare(this.y, vec3F.y) == 0 && Float.compare(this.z, vec3F.z) == 0;
    }

    public static /* synthetic */ Vec3F copy$default(Vec3F vec3F, float f16, float f17, float f18, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = vec3F.x;
        }
        if ((i3 & 2) != 0) {
            f17 = vec3F.y;
        }
        if ((i3 & 4) != 0) {
            f18 = vec3F.z;
        }
        return vec3F.copy(f16, f17, f18);
    }
}
