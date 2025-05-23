package com.tencent.biz.qqcircle.sensor;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/qqcircle/sensor/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "getX", "()F", HippyTKDListViewAdapter.X, "b", "getY", "y", "c", "getZ", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "<init>", "(FFF)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.sensor.a, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class AccelerometerPoint {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final float x;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float y;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float z;

    public AccelerometerPoint(float f16, float f17, float f18) {
        this.x = f16;
        this.y = f17;
        this.z = f18;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AccelerometerPoint)) {
            return false;
        }
        AccelerometerPoint accelerometerPoint = (AccelerometerPoint) other;
        if (Float.compare(this.x, accelerometerPoint.x) == 0 && Float.compare(this.y, accelerometerPoint.y) == 0 && Float.compare(this.z, accelerometerPoint.z) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y)) * 31) + Float.floatToIntBits(this.z);
    }

    @NotNull
    public String toString() {
        return "AccelerometerPoint(x=" + this.x + ", y=" + this.y + ", z=" + this.z + ")";
    }
}
