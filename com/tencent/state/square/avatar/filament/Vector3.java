package com.tencent.state.square.avatar.filament;

import com.google.gson.annotations.SerializedName;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/square/avatar/filament/Vector3;", "", HippyTKDListViewAdapter.X, "", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(FFF)V", "getX", "()F", "getY", "getZ", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class Vector3 {

    @SerializedName("X")
    private final float x;

    @SerializedName("Y")
    private final float y;

    @SerializedName("Z")
    private final float z;

    public Vector3(float f16, float f17, float f18) {
        this.x = f16;
        this.y = f17;
        this.z = f18;
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

    public final Vector3 copy(float x16, float y16, float z16) {
        return new Vector3(x16, y16, z16);
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

    public String toString() {
        return "Vector3(x=" + this.x + ", y=" + this.y + ", z=" + this.z + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Vector3)) {
            return false;
        }
        Vector3 vector3 = (Vector3) other;
        return Float.compare(this.x, vector3.x) == 0 && Float.compare(this.y, vector3.y) == 0 && Float.compare(this.z, vector3.z) == 0;
    }

    public static /* synthetic */ Vector3 copy$default(Vector3 vector3, float f16, float f17, float f18, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = vector3.x;
        }
        if ((i3 & 2) != 0) {
            f17 = vector3.y;
        }
        if ((i3 & 4) != 0) {
            f18 = vector3.z;
        }
        return vector3.copy(f16, f17, f18);
    }
}
