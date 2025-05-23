package le4;

import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.tavcut.composition.model.component.Quat;
import com.tencent.tavcut.composition.model.component.Vec3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002\u001a\u001e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000\u00a8\u0006\u000b"}, d2 = {"", "rotationDegree", "Lcom/tencent/tavcut/composition/model/component/Quat;", "c", BasicAnimation.KeyPath.ROTATION, "Lcom/tencent/tavcut/composition/model/component/Vec3;", "b", "pitch", "roll", "yaw", "a", "lib_tavcut_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class d {
    @NotNull
    public static final Quat a(float f16, float f17, float f18) {
        double d16 = f16 * 0.5f;
        double d17 = f17 * 0.5f;
        double d18 = f18 * 0.5f;
        ByteString byteString = null;
        int i3 = 8;
        DefaultConstructorMarker defaultConstructorMarker = null;
        Vec3 vec3 = new Vec3((float) Math.cos(d16), (float) Math.cos(d17), (float) Math.cos(d18), byteString, i3, defaultConstructorMarker);
        Vec3 vec32 = new Vec3((float) Math.sin(d16), (float) Math.sin(d17), (float) Math.sin(d18), byteString, i3, defaultConstructorMarker);
        float f19 = vec32.x;
        float f26 = vec3.y;
        float f27 = vec3.z;
        float f28 = vec3.x;
        float f29 = vec32.y;
        float f36 = vec32.z;
        return new Quat(((f19 * f26) * f27) - ((f28 * f29) * f36), (f28 * f29 * f27) + (f19 * f26 * f36), ((f28 * f26) * f36) - ((f19 * f29) * f27), (f28 * f26 * f27) + (f19 * f29 * f36), null, 16, null);
    }

    @NotNull
    public static final Vec3 b(@NotNull Quat rotation) {
        Intrinsics.checkParameterIsNotNull(rotation, "rotation");
        float f16 = rotation.x;
        float f17 = rotation.y;
        float f18 = rotation.z;
        float f19 = rotation.w;
        float f26 = 2;
        float f27 = f19 * f19;
        float f28 = f16 * f16;
        float f29 = f17 * f17;
        float f36 = f18 * f18;
        return new Vec3((float) Math.atan2(f26 * ((f17 * f18) + (f19 * f16)), ((f27 - f28) - f29) + f36), (float) Math.asin((-2) * ((f16 * f18) - (f19 * f17))), (float) Math.atan2(((f16 * f17) + (f19 * f18)) * f26, ((f27 + f28) - f29) - f36), null, 8, null);
    }

    @NotNull
    public static final Quat c(float f16) {
        return a(0.0f, 0.0f, f16 / 57.29578f);
    }
}
