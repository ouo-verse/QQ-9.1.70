package com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap;

import android.graphics.Color;
import android.graphics.Point;
import androidx.annotation.CallSuper;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010*\u001a\u00020&\u0012\u0006\u0010?\u001a\u00020>\u00a2\u0006\u0004\b@\u0010AJ+\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000bH\u0017J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0017J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0017J\b\u0010\u0018\u001a\u00020\u0012H\u0017J,\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u0019H&J\u0006\u0010!\u001a\u00020 J\u0006\u0010\"\u001a\u00020\u0006J\u0018\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#2\u0006\u0010\u0003\u001a\u00020\u0002H\u0004R\u001a\u0010*\u001a\u00020&8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b(\u0010)R\"\u00100\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u00101R\u001a\u00106\u001a\u0002028\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b%\u00103\u001a\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u00107R\u0016\u00109\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010+R\u0016\u0010:\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010+R\u0016\u0010;\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010+R\u0016\u0010<\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010+R\u0016\u0010=\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010+\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/d;", "", "Lcom/tencent/tencentmap/mapsdk/maps/Projection;", "projection", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "latLng", "", "edgeMargin", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/j;", "g", "(Lcom/tencent/tencentmap/mapsdk/maps/Projection;Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;Ljava/lang/Integer;)Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/j;", "Lvp4/a;", "heatMapData", "", "b", "", "c", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/tencentmap/mapsdk/maps/model/CameraPosition;", "cameraPosition", "j", "k", "a", "", "showHeatMap", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/RenderReason;", "reason", FileReaderHelper.OPEN_FILE_FROM_FORCE, "ignoreTransition", "l", "", "e", tl.h.F, "", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/h;", "d", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;", "i", "()Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;", "tencentMap", UserInfo.SEX_FEMALE, "getRenderScale", "()F", "setRenderScale", "(F)V", "renderScale", "Lvp4/a;", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/b;", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/b;", "f", "()Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/b;", "heatMapImage", "Ljava/lang/Integer;", "forceRadiusDp", "currentZoom", "intensityScaleStartZoom", "intensityScaleEndZoom", "intensityScaleStart", "intensityScaleEnd", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/RenderAlgorithm;", "renderAlgorithm", "<init>", "(Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/RenderAlgorithm;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class d {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final int[] f253861l = {Color.argb(153, 255, 0, 0), Color.argb(153, 255, 255, 0), Color.argb(153, 0, 255, 0), Color.argb(153, 0, 255, 255), Color.argb(0, 0, 255, 255)};

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final float[] f253862m = {0.0f, 0.2f, 0.5f, 0.75f, 1.0f};

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TencentMap tencentMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float renderScale;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private vp4.a heatMapData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.b heatMapImage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer forceRadiusDp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float currentZoom;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float intensityScaleStartZoom;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float intensityScaleEndZoom;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float intensityScaleStart;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private float intensityScaleEnd;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f253873a;

        static {
            int[] iArr = new int[RenderAlgorithm.values().length];
            try {
                iArr[RenderAlgorithm.Convolution.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f253873a = iArr;
        }
    }

    public d(@NotNull TencentMap tencentMap, @NotNull RenderAlgorithm renderAlgorithm) {
        Intrinsics.checkNotNullParameter(tencentMap, "tencentMap");
        Intrinsics.checkNotNullParameter(renderAlgorithm, "renderAlgorithm");
        this.tencentMap = tencentMap;
        this.renderScale = 3.0f;
        if (b.f253873a[renderAlgorithm.ordinal()] == 1) {
            this.heatMapImage = new c(this.renderScale, f253861l, f253862m);
            this.currentZoom = 1.0f;
            this.intensityScaleStartZoom = 13.0f;
            this.intensityScaleEndZoom = 7.0f;
            this.intensityScaleStart = 1.2f;
            this.intensityScaleEnd = 0.5f;
            return;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int[] b(vp4.a heatMapData) {
        String[] strArr = heatMapData.f443163j.f443164a;
        int length = strArr.length;
        int[] iArr = new int[strArr.length];
        for (int i3 = 0; i3 < length; i3++) {
            String str = strArr[i3];
            Intrinsics.checkNotNullExpressionValue(str, "gradientColors[i]");
            iArr[i3] = com.tencent.kuikly.core.render.android.css.ktx.b.w(str);
        }
        return iArr;
    }

    private final float[] c(vp4.a heatMapData) {
        String[] strArr = heatMapData.f443163j.f443165b;
        int length = strArr.length;
        float[] fArr = new float[strArr.length];
        for (int i3 = 0; i3 < length; i3++) {
            String str = strArr[i3];
            Intrinsics.checkNotNullExpressionValue(str, "gradientStartPoints[i]");
            fArr[i3] = Float.parseFloat(str);
        }
        return fArr;
    }

    private final NBPPoint g(Projection projection, LatLng latLng, Integer edgeMargin) {
        int mapWidth = this.tencentMap.getMapWidth();
        int mapHeight = this.tencentMap.getMapHeight();
        Point screenLocation = projection.toScreenLocation(latLng);
        if (edgeMargin == null) {
            return new NBPPoint(screenLocation.x, screenLocation.y);
        }
        if (screenLocation.x < (-edgeMargin.intValue()) || screenLocation.x > mapWidth + edgeMargin.intValue() || screenLocation.y < (-edgeMargin.intValue()) || screenLocation.y > mapHeight + edgeMargin.intValue()) {
            return null;
        }
        return new NBPPoint(screenLocation.x, screenLocation.y);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final List<HeatPoint> d(@NotNull Projection projection) {
        float f16;
        Object first;
        List<HeatPoint> filterNotNull;
        HeatPoint heatPoint;
        int i3;
        float f17;
        Intrinsics.checkNotNullParameter(projection, "projection");
        vp4.a aVar = this.heatMapData;
        HeatPoint heatPoint2 = null;
        if (aVar == null) {
            return null;
        }
        vp4.c cVar = aVar.f443156c;
        if (cVar != null) {
            f16 = cVar.f443167b;
        } else {
            vp4.e[] eVarArr = aVar.f443154a;
            if (eVarArr != null) {
                first = ArraysKt___ArraysKt.first(eVarArr);
                vp4.e eVar = (vp4.e) first;
                if (eVar != null) {
                    f16 = (float) eVar.f443173b;
                }
            }
            f16 = 1.0f;
        }
        int h16 = h();
        vp4.e[] eVarArr2 = aVar.f443154a;
        Intrinsics.checkNotNullExpressionValue(eVarArr2, "heapData.weightedData");
        ArrayList arrayList = new ArrayList(eVarArr2.length);
        int length = eVarArr2.length;
        int i16 = 0;
        while (i16 < length) {
            vp4.e eVar2 = eVarArr2[i16];
            if (eVar2.f443172a == null) {
                f17 = f16;
                i3 = h16;
                heatPoint = heatPoint2;
            } else {
                vp4.d dVar = eVar2.f443172a;
                float f18 = f16;
                NBPPoint g16 = g(projection, new LatLng(dVar.f443169a, dVar.f443170b), Integer.valueOf(h16));
                if (g16 == null) {
                    i3 = h16;
                    f17 = f18;
                    heatPoint = null;
                } else {
                    i3 = h16;
                    f17 = f18;
                    heatPoint = new HeatPoint(g16.getX(), g16.getY(), Math.max(Math.min((float) ((eVar2.f443173b * e()) / f17), 1.0f), 0.1f));
                }
            }
            arrayList.add(heatPoint);
            i16++;
            f16 = f17;
            h16 = i3;
            heatPoint2 = null;
        }
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(arrayList);
        return filterNotNull;
    }

    public final float e() {
        float f16 = this.currentZoom;
        float f17 = this.intensityScaleEndZoom;
        if (f16 < f17) {
            return this.intensityScaleEnd;
        }
        float f18 = this.intensityScaleStartZoom;
        if (f16 > f18) {
            return this.intensityScaleStart;
        }
        float f19 = (f16 - f17) / (f18 - f17);
        float f26 = this.intensityScaleEnd;
        return f26 + ((this.intensityScaleStart - f26) * f19);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: f, reason: from getter */
    public final com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.b getHeatMapImage() {
        return this.heatMapImage;
    }

    public final int h() {
        int i3;
        Integer num = this.forceRadiusDp;
        if (num != null) {
            Intrinsics.checkNotNull(num);
            return com.tencent.mobileqq.nearbypro.utils.d.b(num.intValue());
        }
        vp4.a aVar = this.heatMapData;
        if (aVar != null) {
            i3 = aVar.f443158e;
        } else {
            i3 = 35;
        }
        return com.tencent.mobileqq.nearbypro.utils.d.b(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: i, reason: from getter */
    public final TencentMap getTencentMap() {
        return this.tencentMap;
    }

    @CallSuper
    public void j(@NotNull CameraPosition cameraPosition) {
        Intrinsics.checkNotNullParameter(cameraPosition, "cameraPosition");
        this.currentZoom = cameraPosition.zoom;
    }

    @CallSuper
    public void k(@NotNull CameraPosition cameraPosition) {
        Intrinsics.checkNotNullParameter(cameraPosition, "cameraPosition");
        this.currentZoom = cameraPosition.zoom;
    }

    public abstract void l(boolean showHeatMap, @NotNull RenderReason reason, boolean force, boolean ignoreTransition);

    @CallSuper
    public void m(@NotNull vp4.a data) {
        boolean z16;
        Intrinsics.checkNotNullParameter(data, "data");
        this.heatMapData = data;
        try {
            vp4.b bVar = data.f443163j;
            if (bVar != null && bVar.f443164a != null) {
                int[] b16 = b(data);
                float[] c16 = c(data);
                if (b16.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if ((!z16) && b16.length == c16.length) {
                    com.tencent.mobileqq.nearbypro.base.j.c().c("HeatMapRenderer", "\u66f4\u65b0\u8272\u677f " + b16.length);
                    this.heatMapImage.j(b16, c16);
                }
            }
        } catch (Exception e16) {
            com.tencent.mobileqq.nearbypro.base.j.c().d("HeatMapRenderer", "updateData error: " + e16.getMessage());
        }
    }

    @CallSuper
    public void a() {
    }
}
