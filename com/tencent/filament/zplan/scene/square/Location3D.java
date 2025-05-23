package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import com.tencent.filament.zplan.avatar.model.Float3;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/Location3D;", "", HippyTKDListViewAdapter.X, "", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(DDD)V", "getX", "()D", "getY", "getZ", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toDoubleArray", "", "toFloat3", "Lcom/tencent/filament/zplan/avatar/model/Float3;", "toString", "", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class Location3D {
    private final double x;
    private final double y;
    private final double z;

    public Location3D() {
        this(0.0d, 0.0d, 0.0d, 7, null);
    }

    public static /* synthetic */ Location3D copy$default(Location3D location3D, double d16, double d17, double d18, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            d16 = location3D.x;
        }
        double d19 = d16;
        if ((i3 & 2) != 0) {
            d17 = location3D.y;
        }
        double d26 = d17;
        if ((i3 & 4) != 0) {
            d18 = location3D.z;
        }
        return location3D.copy(d19, d26, d18);
    }

    /* renamed from: component1, reason: from getter */
    public final double getX() {
        return this.x;
    }

    /* renamed from: component2, reason: from getter */
    public final double getY() {
        return this.y;
    }

    /* renamed from: component3, reason: from getter */
    public final double getZ() {
        return this.z;
    }

    @NotNull
    public final Location3D copy(double x16, double y16, double z16) {
        return new Location3D(x16, y16, z16);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Location3D) {
                Location3D location3D = (Location3D) other;
                if (Double.compare(this.x, location3D.x) != 0 || Double.compare(this.y, location3D.y) != 0 || Double.compare(this.z, location3D.z) != 0) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final double getX() {
        return this.x;
    }

    public final double getY() {
        return this.y;
    }

    public final double getZ() {
        return this.z;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.x);
        long doubleToLongBits2 = Double.doubleToLongBits(this.y);
        int i3 = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31;
        long doubleToLongBits3 = Double.doubleToLongBits(this.z);
        return i3 + ((int) ((doubleToLongBits3 >>> 32) ^ doubleToLongBits3));
    }

    @NotNull
    public final double[] toDoubleArray() {
        return new double[]{this.x, this.y, this.z};
    }

    @NotNull
    public final Float3 toFloat3() {
        return new Float3((float) this.x, (float) this.y, (float) this.z);
    }

    @NotNull
    public String toString() {
        return "Location3D(x=" + this.x + ", y=" + this.y + ", z=" + this.z + ")";
    }

    public Location3D(double d16, double d17, double d18) {
        this.x = d16;
        this.y = d17;
        this.z = d18;
    }

    public /* synthetic */ Location3D(double d16, double d17, double d18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0d : d16, (i3 & 2) != 0 ? 0.0d : d17, (i3 & 4) != 0 ? 0.0d : d18);
    }
}
