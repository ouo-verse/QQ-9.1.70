package com.tencent.filament.zplan.scene.square;

import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.Exposure;
import com.tencent.filament.zplan.avatar.FovProjection;
import com.tencent.filament.zplan.avatar.FreeFlight;
import com.tencent.filament.zplan.avatar.LookAt;
import com.tencent.filament.zplan.avatar.Manipulator;
import com.tencent.filament.zplan.avatar.ManipulatorMode;
import com.tencent.filament.zplan.avatar.Orbit;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/i;", "", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "a", "", "aspect", "b", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f106111a = new i();

    i() {
    }

    @NotNull
    public final CameraParams a() {
        return b(1.0f);
    }

    @NotNull
    public final CameraParams b(float aspect) {
        return new CameraParams(new Exposure(16, 100.0d, 0.008d), new LookAt(new float[]{1.1622908E-6f, 9.8f, 19.500002f}, new float[]{1.1082707E-6f, 9.377382f, 18.593695f}, new float[]{-2.5190017E-8f, 0.9063078f, -0.42261833f}), null, new FovProjection(5.0f, aspect, 1000.0f, 0.05f, "Vertical"), new Manipulator(ManipulatorMode.FREE_FLIGHT, new FreeFlight(1.0f, 1, -0.43633232f, 0.0f, new float[]{8.0E-5f, 6.0E-5f}, 0.0f), new Orbit(new float[]{0.1f})), 4, null);
    }
}
