package com.tencent.filament.zplan.scene.minihome;

import com.tencent.filament.zplan.engine.FilamentMiniHome;
import com.tencent.filament.zplan.scene.minihome.MiniHomeScene;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.zplan.zplantracing.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/filament/zplan/scene/minihome/MiniHomeScene$eventListener$1", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class MiniHomeScene$eventListener$1 implements sk0.b {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MiniHomeScene f105965d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MiniHomeScene$eventListener$1(MiniHomeScene miniHomeScene) {
        this.f105965d = miniHomeScene;
    }

    @Override // sk0.b
    public void handleEvent(@Nullable c spanContext, @NotNull String type, @Nullable String data) {
        Intrinsics.checkNotNullParameter(type, "type");
        FLog fLog = FLog.INSTANCE;
        fLog.e("MiniHomeScene", "handleEvent " + type + ", data: " + data);
        if (Intrinsics.areEqual(type, MiniHomeScene.Companion.EVENT.INIT_HOME.name())) {
            this.f105965d.c0(data);
            return;
        }
        if (Intrinsics.areEqual(type, MiniHomeScene.Companion.EVENT.LOAD_ROOM.name())) {
            this.f105965d.f0(data);
            return;
        }
        if (Intrinsics.areEqual(type, MiniHomeScene.Companion.EVENT.LOAD_AVATAR.name())) {
            this.f105965d.e0(data);
            return;
        }
        if (Intrinsics.areEqual(type, MiniHomeScene.Companion.EVENT.RESET.name())) {
            this.f105965d.k().d("reset", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.minihome.MiniHomeScene$eventListener$1$handleEvent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FilamentMiniHome filamentMiniHome = MiniHomeScene$eventListener$1.this.f105965d.minihome;
                    if (filamentMiniHome != null) {
                        filamentMiniHome.reset();
                    }
                }
            });
            return;
        }
        if (Intrinsics.areEqual(type, MiniHomeScene.Companion.EVENT.RESET_ROOM_AND_AVATAR.name())) {
            this.f105965d.i0(data);
            return;
        }
        if (Intrinsics.areEqual(type, MiniHomeScene.Companion.EVENT.SET_GYRO_ANGLE_LIMIT.name())) {
            this.f105965d.n0(data);
            return;
        }
        if (Intrinsics.areEqual(type, MiniHomeScene.Companion.EVENT.ENABLE_GYRO_SENSOR.name())) {
            this.f105965d.p0(data);
            return;
        }
        if (Intrinsics.areEqual(type, MiniHomeScene.Companion.EVENT.ENABLE_TOUCH_EVENT.name())) {
            this.f105965d.q0(data);
            return;
        }
        if (Intrinsics.areEqual(type, MiniHomeScene.Companion.EVENT.SET_IS_NIGHT.name())) {
            this.f105965d.o0(data);
            return;
        }
        if (Intrinsics.areEqual(type, "onTouchEvent")) {
            this.f105965d.b0(data);
            return;
        }
        if (Intrinsics.areEqual(type, MiniHomeScene.Companion.EVENT.REPLACE_DECORATE.name())) {
            this.f105965d.h0(data);
            return;
        }
        if (Intrinsics.areEqual(type, MiniHomeScene.Companion.EVENT.SELECT_DECORATE.name())) {
            this.f105965d.k0(data);
            return;
        }
        if (Intrinsics.areEqual(type, MiniHomeScene.Companion.EVENT.SELECT_DECORATE_RAYCAST.name())) {
            this.f105965d.l0(data);
            return;
        }
        if (Intrinsics.areEqual(type, MiniHomeScene.Companion.EVENT.CANCEL_SELECT_DECORATE.name())) {
            this.f105965d.W(data);
            return;
        }
        if (Intrinsics.areEqual(type, MiniHomeScene.Companion.EVENT.SET_CAMERA_MODE.name())) {
            this.f105965d.m0(data);
            return;
        }
        if (Intrinsics.areEqual(type, MiniHomeScene.Companion.EVENT.GET_ROOM_CONFIG.name())) {
            this.f105965d.a0(data);
            return;
        }
        if (Intrinsics.areEqual(type, MiniHomeScene.Companion.EVENT.GET_DECORATE_POSITION.name())) {
            this.f105965d.Z(data);
            return;
        }
        if (Intrinsics.areEqual(type, MiniHomeScene.Companion.EVENT.DELETE_DECORATE.name())) {
            this.f105965d.X(data);
            return;
        }
        if (Intrinsics.areEqual(type, MiniHomeScene.Companion.EVENT.ROTATE_DECORATE.name())) {
            this.f105965d.j0(data);
            return;
        }
        fLog.e("MiniHomeScene", type + " not support.");
    }
}
