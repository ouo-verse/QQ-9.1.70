package com.tencent.filament.zplan.data;

import androidx.annotation.Keep;
import com.tencent.luggage.wxa.c8.c;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@NativeProxy(allFields = true, allMethods = true)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/filament/zplan/data/ZPlanPinchFaceModel;", "", "groupID", "", c.G, "", "(IF)V", "getGroupID", "()I", "setGroupID", "(I)V", "getPos", "()F", "setPos", "(F)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class ZPlanPinchFaceModel {
    private int groupID;
    private float pos;

    public ZPlanPinchFaceModel(int i3, float f16) {
        this.groupID = i3;
        this.pos = f16;
    }

    public static /* synthetic */ ZPlanPinchFaceModel copy$default(ZPlanPinchFaceModel zPlanPinchFaceModel, int i3, float f16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = zPlanPinchFaceModel.groupID;
        }
        if ((i16 & 2) != 0) {
            f16 = zPlanPinchFaceModel.pos;
        }
        return zPlanPinchFaceModel.copy(i3, f16);
    }

    /* renamed from: component1, reason: from getter */
    public final int getGroupID() {
        return this.groupID;
    }

    /* renamed from: component2, reason: from getter */
    public final float getPos() {
        return this.pos;
    }

    @NotNull
    public final ZPlanPinchFaceModel copy(int groupID, float pos) {
        return new ZPlanPinchFaceModel(groupID, pos);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ZPlanPinchFaceModel) {
                ZPlanPinchFaceModel zPlanPinchFaceModel = (ZPlanPinchFaceModel) other;
                if (this.groupID != zPlanPinchFaceModel.groupID || Float.compare(this.pos, zPlanPinchFaceModel.pos) != 0) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getGroupID() {
        return this.groupID;
    }

    public final float getPos() {
        return this.pos;
    }

    public int hashCode() {
        return (this.groupID * 31) + Float.floatToIntBits(this.pos);
    }

    public final void setGroupID(int i3) {
        this.groupID = i3;
    }

    public final void setPos(float f16) {
        this.pos = f16;
    }

    @NotNull
    public String toString() {
        return "ZPlanPinchFaceModel(groupID=" + this.groupID + ", pos=" + this.pos + ")";
    }
}
