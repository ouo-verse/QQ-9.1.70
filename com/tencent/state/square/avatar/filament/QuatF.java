package com.tencent.state.square.avatar.filament;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/square/avatar/filament/QuatF;", "", HippyTKDListViewAdapter.X, "", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "w", "(FFFF)V", "getW", "()F", "setW", "(F)V", "getX", "setX", "getY", "setY", "getZ", "setZ", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toFloatArray", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class QuatF {
    private float w;
    private float x;
    private float y;
    private float z;

    public QuatF() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
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

    /* renamed from: component4, reason: from getter */
    public final float getW() {
        return this.w;
    }

    public final QuatF copy(float x16, float y16, float z16, float w3) {
        return new QuatF(x16, y16, z16, w3);
    }

    public final float getW() {
        return this.w;
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
        return (((((Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y)) * 31) + Float.floatToIntBits(this.z)) * 31) + Float.floatToIntBits(this.w);
    }

    public final void setW(float f16) {
        this.w = f16;
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
        return "QuatF(x=" + this.x + ", y=" + this.y + ", z=" + this.z + ", w=" + this.w + ")";
    }

    public QuatF(float f16, float f17, float f18, float f19) {
        this.x = f16;
        this.y = f17;
        this.z = f18;
        this.w = f19;
    }

    public final float[] toFloatArray() {
        return new float[]{this.x, this.y, this.z, this.w};
    }

    public /* synthetic */ QuatF(float f16, float f17, float f18, float f19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? 0.0f : f17, (i3 & 4) != 0 ? 0.0f : f18, (i3 & 8) != 0 ? 0.0f : f19);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuatF)) {
            return false;
        }
        QuatF quatF = (QuatF) other;
        return Float.compare(this.x, quatF.x) == 0 && Float.compare(this.y, quatF.y) == 0 && Float.compare(this.z, quatF.z) == 0 && Float.compare(this.w, quatF.w) == 0;
    }

    public static /* synthetic */ QuatF copy$default(QuatF quatF, float f16, float f17, float f18, float f19, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = quatF.x;
        }
        if ((i3 & 2) != 0) {
            f17 = quatF.y;
        }
        if ((i3 & 4) != 0) {
            f18 = quatF.z;
        }
        if ((i3 & 8) != 0) {
            f19 = quatF.w;
        }
        return quatF.copy(f16, f17, f18, f19);
    }
}
