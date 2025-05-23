package com.tencent.tavcut.core.utils;

import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.light.lightAssetKit.components.Quat;
import org.light.lightAssetKit.components.ScreenTransform;
import org.light.lightAssetKit.components.Vec3;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0007J\u001e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/tavcut/core/utils/b;", "", "Lorg/light/lightAssetKit/components/ScreenTransform;", "screenTransform", "", "b", "rotationDegree", "Lorg/light/lightAssetKit/components/Quat;", "d", BasicAnimation.KeyPath.ROTATION, "Lorg/light/lightAssetKit/components/Vec3;", "c", "pitch", "roll", "yaw", "a", "<init>", "()V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f374339a = new b();

    b() {
    }

    @NotNull
    public final Quat a(float pitch, float roll, float yaw) {
        double d16 = pitch * 0.5f;
        double d17 = roll * 0.5f;
        double d18 = yaw * 0.5f;
        Vec3 vec3 = new Vec3((float) Math.cos(d16), (float) Math.cos(d17), (float) Math.cos(d18));
        Vec3 vec32 = new Vec3((float) Math.sin(d16), (float) Math.sin(d17), (float) Math.sin(d18));
        float f16 = vec32.f423832x;
        float f17 = vec3.f423833y;
        float f18 = vec3.f423834z;
        float f19 = vec3.f423832x;
        float f26 = vec32.f423833y;
        float f27 = vec32.f423834z;
        return new Quat((f19 * f17 * f18) + (f16 * f26 * f27), ((f16 * f17) * f18) - ((f19 * f26) * f27), (f19 * f26 * f18) + (f16 * f17 * f27), ((f19 * f17) * f27) - ((f16 * f26) * f18));
    }

    public final float b(@NotNull ScreenTransform screenTransform) {
        Intrinsics.checkParameterIsNotNull(screenTransform, "screenTransform");
        Quat rotation = screenTransform.getRotation();
        if (rotation != null) {
            return f374339a.c(rotation).f423834z * 57.29578f;
        }
        return 0.0f;
    }

    @NotNull
    public final Vec3 c(@NotNull Quat rotation) {
        Intrinsics.checkParameterIsNotNull(rotation, "rotation");
        float f16 = rotation.f423824x;
        float f17 = rotation.f423825y;
        float f18 = rotation.f423826z;
        float f19 = rotation.f423823w;
        float f26 = 2;
        float f27 = f19 * f19;
        float f28 = f16 * f16;
        float f29 = f17 * f17;
        float f36 = f18 * f18;
        return new Vec3((float) Math.atan2(f26 * ((f17 * f18) + (f19 * f16)), ((f27 - f28) - f29) + f36), (float) Math.asin((-2) * ((f16 * f18) - (f19 * f17))), (float) Math.atan2(((f16 * f17) + (f19 * f18)) * f26, ((f27 + f28) - f29) - f36));
    }

    @NotNull
    public final Quat d(float rotationDegree) {
        return a(0.0f, 0.0f, rotationDegree / 57.29578f);
    }
}
