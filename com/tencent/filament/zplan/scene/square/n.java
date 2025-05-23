package com.tencent.filament.zplan.scene.square;

import android.graphics.Point;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.Directional;
import com.tencent.filament.zplan.avatar.IndirectLight;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.avatar.SpotLight;
import com.tencent.filament.zplan.avatar.model.Float3;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplanservice.util.log.FLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\fB\u001f\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001a\u0010\u001bJ*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J*\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ(\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0012R\u0014\u0010\u0015\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/n;", "", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;", "viewer", "Lcom/tencent/filament/zplan/scene/square/Location;", "location", "Lcom/tencent/filament/zplan/scene/square/Size;", "size", "", "depth", "Lcom/tencent/filament/zplan/scene/square/Location3D;", "c", "a", "Lcom/tencent/filament/zplan/scene/couple/config/d;", "d", "b", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "e", "Lcom/tencent/filament/zplan/avatar/LightsParams;", "f", "Lcom/tencent/filament/zplan/scene/square/Size;", "mapSize", "viewportSize", "Lcom/tencent/filament/zplan/scene/square/SquareMapViewport;", "Lcom/tencent/filament/zplan/scene/square/SquareMapViewport;", "viewport", "<init>", "(Lcom/tencent/filament/zplan/scene/square/Size;Lcom/tencent/filament/zplan/scene/square/Size;Lcom/tencent/filament/zplan/scene/square/SquareMapViewport;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Size mapSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Size viewportSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final SquareMapViewport viewport;

    public n(@NotNull Size mapSize, @NotNull Size viewportSize, @NotNull SquareMapViewport viewport) {
        Intrinsics.checkNotNullParameter(mapSize, "mapSize");
        Intrinsics.checkNotNullParameter(viewportSize, "viewportSize");
        Intrinsics.checkNotNullParameter(viewport, "viewport");
        this.mapSize = mapSize;
        this.viewportSize = viewportSize;
        this.viewport = viewport;
    }

    private final Location3D a(FilamentViewerV2305 viewer, Location location, Size size, float depth) {
        if (location != null) {
            Location center = this.viewport.getCurrentViewportInfo().getCenter();
            float x16 = center.getX();
            float y16 = center.getY();
            double scale = this.viewport.getCurrentViewportInfo().getScale();
            double y17 = (((location.getY() * scale) + y16) + (size.getHeight() * r3)) - ((size.getHeight() * r3) * 0.16d);
            double height = this.viewportSize.getHeight() / 1.0d;
            Point point = new Point((int) ((location.getX() * scale) + x16 + ((size.getWidth() * r3) / 2.0d) + ((this.viewportSize.getWidth() - (this.viewportSize.getWidth() / 1.0d)) / 2.0d)), (int) (((this.viewportSize.getHeight() - height) / 2.0d) + (height - y17)));
            float f16 = -depth;
            double d16 = 0.43633232f;
            if (viewer.projectPointOntoPlane(point, new Float3(0.0f, f16, ((float) Math.tan(d16)) * f16), new Float3(0.0f, 1.0f, (float) Math.tan(d16))) != null) {
                return new Location3D(r1.getF0(), r1.getF1(), r1.getF2());
            }
            return new Location3D(0.0d, 0.0d, 0.0d, 7, null);
        }
        return new Location3D(0.0d, 0.0d, 0.0d, 7, null);
    }

    private final Location3D c(FilamentViewerV2305 viewer, Location location, Size size, float depth) {
        if (location != null) {
            Location center = this.viewport.getCurrentViewportInfo().getCenter();
            float x16 = center.getX();
            float y16 = center.getY();
            double scale = this.viewport.getCurrentViewportInfo().getScale();
            double y17 = (location.getY() * scale) + y16 + ((size.getHeight() * r3) / 2.0d);
            double height = this.viewportSize.getHeight() / 1.0d;
            Point point = new Point((int) ((location.getX() * scale) + x16 + ((size.getWidth() * r3) / 2.0d) + ((this.viewportSize.getWidth() - (this.viewportSize.getWidth() / 1.0d)) / 2.0d)), (int) (((this.viewportSize.getHeight() - height) / 2.0d) + (height - y17)));
            float f16 = -depth;
            double d16 = 0.43633232f;
            if (viewer.projectPointOntoPlane(point, new Float3(0.0f, f16, ((float) Math.tan(d16)) * f16), new Float3(0.0f, 1.0f, (float) Math.tan(d16))) != null) {
                return new Location3D(r1.getF0(), r1.getF1(), r1.getF2());
            }
            return new Location3D(0.0d, 0.0d, 0.0d, 7, null);
        }
        return new Location3D(0.0d, 0.0d, 0.0d, 7, null);
    }

    @NotNull
    public final com.tencent.filament.zplan.scene.couple.config.d b(@NotNull FilamentViewerV2305 viewer, @Nullable Location location, @NotNull Size size, float depth) {
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        Intrinsics.checkNotNullParameter(size, "size");
        if (location != null) {
            Location3D a16 = a(viewer, location, size, depth);
            double x16 = (a(viewer, new Location(location.getX() + (size.getWidth() / 2.0f), location.getY() - (size.getHeight() / 2.0f)), size, depth).getX() - a16.getX()) * 1.05d;
            double height = (size.getHeight() / size.getWidth()) * x16;
            return new com.tencent.filament.zplan.scene.couple.config.d(a16.toDoubleArray(), null, new double[]{x16, height, height}, 2, null);
        }
        return new com.tencent.filament.zplan.scene.couple.config.d(null, null, null, 7, null);
    }

    @NotNull
    public final com.tencent.filament.zplan.scene.couple.config.d d(@NotNull FilamentViewerV2305 viewer, @Nullable Location location, @NotNull Size size, float depth) {
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        Intrinsics.checkNotNullParameter(size, "size");
        if (location != null) {
            Location3D c16 = c(viewer, location, size, depth);
            double x16 = (c(viewer, new Location(location.getX() + (size.getWidth() / 2.0f), location.getY() - (size.getHeight() / 2.0f)), size, depth).getX() - c16.getX()) / 0.201d;
            double height = 0.7913385826771654d * x16 * (size.getHeight() / size.getWidth());
            return new com.tencent.filament.zplan.scene.couple.config.d(c16.toDoubleArray(), null, new double[]{x16, height, height}, 2, null);
        }
        return new com.tencent.filament.zplan.scene.couple.config.d(null, null, null, 7, null);
    }

    @NotNull
    public final CameraParams e() {
        float width = this.viewportSize.getWidth() / this.viewportSize.getHeight();
        if (Float.isNaN(width)) {
            FLog.INSTANCE.e("SquareMapSceneHelper", "getSquareCamera aspect is NaN, use default aspect");
            width = 1.0f;
        }
        return i.f106111a.b(width);
    }

    @NotNull
    public final LightsParams f() {
        List mutableListOf;
        Directional directional = new Directional(null, 0, 0.0f, null, false, 31, null);
        directional.setColor(new float[]{1.0f, 0.94f, 0.99f});
        directional.setIntensity(67000.0f);
        directional.setDirection(new float[]{0.5f, -0.246f, -0.856f});
        directional.setCastShadows(true);
        Unit unit = Unit.INSTANCE;
        IndirectLight indirectLight = new IndirectLight(null, 0.0f, 3, null);
        indirectLight.setIntensity(5000.0f);
        SpotLight spotLight = new SpotLight(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
        spotLight.setKey("spotLight1");
        spotLight.setPosition(new float[]{1.017f, 1.017f, 0.905f});
        spotLight.setDirection(new float[]{-0.61f, 0.281f, -0.741f});
        spotLight.setColor(new float[]{0.8f, 0.8f, 1.0f});
        spotLight.setIntensity(123380.0f);
        spotLight.setFalloff(10.0d);
        spotLight.setInnerCone(10);
        spotLight.setOuterCone(50);
        spotLight.setCastShadows(false);
        SpotLight spotLight2 = new SpotLight(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
        spotLight2.setKey("spotLight2");
        spotLight2.setPosition(new float[]{0.152f, 0.273f, -1.897f});
        spotLight2.setDirection(new float[]{-0.307f, -0.237f, 0.922f});
        spotLight2.setColor(new float[]{0.5f, 0.5f, 1.0f});
        spotLight2.setIntensity(48330.0f);
        spotLight2.setFalloff(30.0d);
        spotLight2.setInnerCone(10);
        spotLight2.setOuterCone(40);
        spotLight2.setCastShadows(false);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(spotLight, spotLight2);
        return new LightsParams(directional, indirectLight, mutableListOf);
    }
}
