package com.tencent.state.square.avatar.filament;

import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0017H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/square/avatar/filament/TransformData;", "", "location", "Lcom/tencent/state/square/avatar/filament/Vec3F;", BasicAnimation.KeyPath.ROTATION, "Lcom/tencent/state/square/avatar/filament/QuatF;", "scale", "(Lcom/tencent/state/square/avatar/filament/Vec3F;Lcom/tencent/state/square/avatar/filament/QuatF;Lcom/tencent/state/square/avatar/filament/Vec3F;)V", "getLocation", "()Lcom/tencent/state/square/avatar/filament/Vec3F;", "getRotation", "()Lcom/tencent/state/square/avatar/filament/QuatF;", "getScale", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toJson", "", "toString", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class TransformData {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Vec3F location;
    private final QuatF rotation;
    private final Vec3F scale;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/square/avatar/filament/TransformData$Companion;", "", "()V", "fromJson", "Lcom/tencent/state/square/avatar/filament/TransformData;", "str", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final TransformData fromJson(String str) {
            Intrinsics.checkNotNullParameter(str, "str");
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("location");
            JSONArray jSONArray2 = jSONObject.getJSONArray(BasicAnimation.KeyPath.ROTATION);
            JSONArray jSONArray3 = jSONObject.getJSONArray("scale");
            return new TransformData(new Vec3F((float) jSONArray.getDouble(0), (float) jSONArray.getDouble(1), (float) jSONArray.getDouble(2)), new QuatF((float) jSONArray2.getDouble(0), (float) jSONArray2.getDouble(1), (float) jSONArray2.getDouble(2), (float) jSONArray2.getDouble(3)), new Vec3F((float) jSONArray3.getDouble(0), (float) jSONArray3.getDouble(1), (float) jSONArray3.getDouble(2)));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TransformData(Vec3F location, QuatF rotation, Vec3F scale) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        Intrinsics.checkNotNullParameter(scale, "scale");
        this.location = location;
        this.rotation = rotation;
        this.scale = scale;
    }

    /* renamed from: component1, reason: from getter */
    public final Vec3F getLocation() {
        return this.location;
    }

    /* renamed from: component2, reason: from getter */
    public final QuatF getRotation() {
        return this.rotation;
    }

    /* renamed from: component3, reason: from getter */
    public final Vec3F getScale() {
        return this.scale;
    }

    public final TransformData copy(Vec3F location, QuatF rotation, Vec3F scale) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        Intrinsics.checkNotNullParameter(scale, "scale");
        return new TransformData(location, rotation, scale);
    }

    public final Vec3F getLocation() {
        return this.location;
    }

    public final QuatF getRotation() {
        return this.rotation;
    }

    public final Vec3F getScale() {
        return this.scale;
    }

    public int hashCode() {
        Vec3F vec3F = this.location;
        int hashCode = (vec3F != null ? vec3F.hashCode() : 0) * 31;
        QuatF quatF = this.rotation;
        int hashCode2 = (hashCode + (quatF != null ? quatF.hashCode() : 0)) * 31;
        Vec3F vec3F2 = this.scale;
        return hashCode2 + (vec3F2 != null ? vec3F2.hashCode() : 0);
    }

    public final String toJson() {
        List list;
        JSONObject jSONObject = new JSONObject();
        list = ArraysKt___ArraysKt.toList(this.location.toFloatArray());
        jSONObject.put("location", new JSONArray((Collection) list));
        jSONObject.put(BasicAnimation.KeyPath.ROTATION, new JSONArray(this.rotation.toFloatArray()));
        jSONObject.put("scale", new JSONArray(this.scale.toFloatArray()));
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }

    public String toString() {
        return "TransformData(location=" + this.location + ", rotation=" + this.rotation + ", scale=" + this.scale + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransformData)) {
            return false;
        }
        TransformData transformData = (TransformData) other;
        return Intrinsics.areEqual(this.location, transformData.location) && Intrinsics.areEqual(this.rotation, transformData.rotation) && Intrinsics.areEqual(this.scale, transformData.scale);
    }

    public static /* synthetic */ TransformData copy$default(TransformData transformData, Vec3F vec3F, QuatF quatF, Vec3F vec3F2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            vec3F = transformData.location;
        }
        if ((i3 & 2) != 0) {
            quatF = transformData.rotation;
        }
        if ((i3 & 4) != 0) {
            vec3F2 = transformData.scale;
        }
        return transformData.copy(vec3F, quatF, vec3F2);
    }
}
