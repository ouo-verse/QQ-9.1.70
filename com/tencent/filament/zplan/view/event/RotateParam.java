package com.tencent.filament.zplan.view.event;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0012\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0013\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/filament/zplan/view/event/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "b", "()F", "axisX", "c", "axisY", "d", "axisZ", "angle", "<init>", "(FFFF)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.filament.zplan.view.event.a, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class RotateParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final float axisX;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float axisY;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float axisZ;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final float angle;

    public RotateParam(float f16, float f17, float f18, float f19) {
        this.axisX = f16;
        this.axisY = f17;
        this.axisZ = f18;
        this.angle = f19;
    }

    /* renamed from: a, reason: from getter */
    public final float getAngle() {
        return this.angle;
    }

    /* renamed from: b, reason: from getter */
    public final float getAxisX() {
        return this.axisX;
    }

    /* renamed from: c, reason: from getter */
    public final float getAxisY() {
        return this.axisY;
    }

    /* renamed from: d, reason: from getter */
    public final float getAxisZ() {
        return this.axisZ;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof RotateParam) {
                RotateParam rotateParam = (RotateParam) other;
                if (Float.compare(this.axisX, rotateParam.axisX) != 0 || Float.compare(this.axisY, rotateParam.axisY) != 0 || Float.compare(this.axisZ, rotateParam.axisZ) != 0 || Float.compare(this.angle, rotateParam.angle) != 0) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.axisX) * 31) + Float.floatToIntBits(this.axisY)) * 31) + Float.floatToIntBits(this.axisZ)) * 31) + Float.floatToIntBits(this.angle);
    }

    @NotNull
    public String toString() {
        return "RotateParam(axisX=" + this.axisX + ", axisY=" + this.axisY + ", axisZ=" + this.axisZ + ", angle=" + this.angle + ")";
    }
}
