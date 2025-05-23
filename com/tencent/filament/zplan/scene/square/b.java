package com.tencent.filament.zplan.scene.square;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.Build;
import com.tencent.filament.zplan.animation.FilamentAnimation;
import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplanservice.util.log.FLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a.\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u001a\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f\u001a\u000e\u0010\u0013\u001a\u00020\u0012*\u00060\u0010j\u0002`\u0011\u001a\u000e\u0010\u0015\u001a\u00020\u0014*\u00060\u0010j\u0002`\u0011\u001a\u001a\u0010\u0019\u001a\u00060\u0010j\u0002`\u0011*\u00060\u0016j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\u0010\u001a\u001a\u0010\u001b\u001a\u00060\u0010j\u0002`\u0011*\u00060\u0016j\u0002`\u00172\u0006\u0010\u001a\u001a\u00020\u0012\u001a\u0018\u0010!\u001a\u00020 *\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d*\n\u0010\"\"\u00020\u00162\u00020\u0016*\n\u0010#\"\u00020\u00102\u00020\u0010\u00a8\u0006$"}, d2 = {"", "radian", "g", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;", "viewer", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "", "animPaths", "Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "f", "Landroid/graphics/PointF;", "touchPoint", "Landroid/graphics/Point;", "a", "", "Lcom/tencent/filament/zplan/scene/square/EngineTime;", "", tl.h.F, "", "e", "Lkotlin/Long$Companion;", "Lcom/tencent/filament/zplan/scene/square/EngineCompanion;", "millis", "c", "seconds", "d", "Lcom/tencent/filament/zplan/avatar/LightsParams;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/app/impl/FilamentNativeAppV2305;", "app", "", "b", "EngineCompanion", "EngineTime", "zplan-android_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class b {
    @NotNull
    public static final Point a(@NotNull FilamentViewerV2305 viewer, @NotNull PointF touchPoint) {
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        Intrinsics.checkNotNullParameter(touchPoint, "touchPoint");
        return new Point((int) touchPoint.x, viewer.getViewportHeight() - ((int) touchPoint.y));
    }

    public static final void b(@NotNull LightsParams fixSpotLightConfig, @NotNull WeakReference<FilamentNativeAppV2305> app) {
        sk0.a configuration;
        dl0.k toggleProxy;
        Intrinsics.checkNotNullParameter(fixSpotLightConfig, "$this$fixSpotLightConfig");
        Intrinsics.checkNotNullParameter(app, "app");
        FilamentNativeAppV2305 filamentNativeAppV2305 = app.get();
        int i3 = 28;
        if (filamentNativeAppV2305 != null && (configuration = filamentNativeAppV2305.getConfiguration()) != null && (toggleProxy = configuration.getToggleProxy()) != null) {
            i3 = toggleProxy.d("zplan_filament_support_spotlight_min_api_level", 28);
        }
        int i16 = Build.VERSION.SDK_INT;
        if (i16 < i3) {
            FLog.INSTANCE.i("SquareAvatarScene", "configLight, remove unSupport spotLights, " + i16);
            fixSpotLightConfig.setSpotLights(new ArrayList());
        }
    }

    public static final long c(@NotNull LongCompanionObject fromMillis, long j3) {
        Intrinsics.checkNotNullParameter(fromMillis, "$this$fromMillis");
        return j3 * 1000000;
    }

    public static final long d(@NotNull LongCompanionObject fromSeconds, double d16) {
        Intrinsics.checkNotNullParameter(fromSeconds, "$this$fromSeconds");
        return (long) (d16 * 1000000000);
    }

    public static final boolean e(long j3) {
        if (j3 == 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final List<FilamentAnimation> f(@Nullable FilamentViewerV2305 filamentViewerV2305, @Nullable com.tencent.zplan.zplantracing.c cVar, @NotNull List<String> animPaths) {
        List<FilamentAnimation> emptyList;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(animPaths, "animPaths");
        if (filamentViewerV2305 == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = animPaths.iterator();
        while (it.hasNext()) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(filamentViewerV2305.loadAnimation((String) it.next(), cVar));
            FilamentAnimation filamentAnimation = (FilamentAnimation) firstOrNull;
            if (filamentAnimation != null) {
                arrayList.add(filamentAnimation);
            }
        }
        return arrayList;
    }

    public static final float g(float f16) {
        return f16 * ((float) 57.29577951308232d);
    }

    public static final double h(long j3) {
        return j3 / 1000000000;
    }
}
