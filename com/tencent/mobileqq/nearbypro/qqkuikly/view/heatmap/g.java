package com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.xweb.FileReaderHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0001\u0006B:\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020%\u0012!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0011\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J(\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016R/\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001f\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/g;", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/d;", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/m;", "task", "", "p", "a", "Lvp4/a;", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "showHeatMap", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/RenderReason;", "reason", FileReaderHelper.OPEN_FILE_FROM_FORCE, "ignoreTransition", "l", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "value", "", DomainData.DOMAIN_NAME, "Lkotlin/jvm/functions/Function1;", "toDpiCallback", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/l;", "o", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/l;", "overlayUpdater", "", "J", "preRenderTs", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "frameId", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;", "tencentMap", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/RenderAlgorithm;", "renderAlgorithm", "<init>", "(Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/RenderAlgorithm;Lkotlin/jvm/functions/Function1;)V", "r", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class g extends d {

    /* renamed from: s, reason: collision with root package name */
    private static long f253878s = 100;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Float, Integer> toDpiCallback;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final l overlayUpdater;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private long preRenderTs;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private long frameId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull TencentMap tencentMap, @NotNull RenderAlgorithm renderAlgorithm, @NotNull Function1<? super Float, Integer> toDpiCallback) {
        super(tencentMap, renderAlgorithm);
        Intrinsics.checkNotNullParameter(tencentMap, "tencentMap");
        Intrinsics.checkNotNullParameter(renderAlgorithm, "renderAlgorithm");
        Intrinsics.checkNotNullParameter(toDpiCallback, "toDpiCallback");
        this.toDpiCallback = toDpiCallback;
        l lVar = new l(tencentMap);
        this.overlayUpdater = lVar;
        lVar.c(getHeatMapImage().g());
    }

    private final void p(RenderTask task) {
        if (task.getFrameId() != this.frameId) {
            com.tencent.mobileqq.nearbypro.base.j.c().c("HeatMapRendererByOverlay", "=== \u653e\u5f03\u6e32\u67d3 id=" + task.getFrameId() + " != frameId=" + this.frameId);
            return;
        }
        getHeatMapImage().i();
        List<HeatPoint> f16 = task.f();
        if (f16 != null) {
            Iterator<T> it = f16.iterator();
            while (it.hasNext()) {
                getHeatMapImage().a((HeatPoint) it.next());
            }
        }
        Bitmap c16 = getHeatMapImage().c(task.getImgWidth(), task.getImgHeight(), task.getRadius());
        if (c16 == null) {
            this.overlayUpdater.b();
            return;
        }
        BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(c16);
        if (fromBitmap == null) {
            this.overlayUpdater.b();
            return;
        }
        this.overlayUpdater.d(fromBitmap, task.getImgBounds(), task.getIgnoreTransition());
        com.tencent.mobileqq.nearbypro.base.j.c().e("HeatMapRendererByOverlay", "=== \u6e32\u67d3\u5b8c\u6210 [" + task.getReason() + "] id=" + task.getFrameId() + " size=" + getHeatMapImage().e() + " radius=" + this.toDpiCallback.invoke(Float.valueOf(task.getRadius())) + " intensityScale=" + e() + " canvas=" + c16.getWidth() + HippyTKDListViewAdapter.X + c16.getHeight() + " cost: " + task.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.overlayUpdater.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(g this$0, RenderTask renderTask) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(renderTask, "$renderTask");
        this$0.p(renderTask);
    }

    @Override // com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.d
    public void a() {
        super.a();
        getTencentMap().setCustomRender(null);
    }

    @Override // com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.d
    public void l(boolean showHeatMap, @NotNull RenderReason reason, boolean force, boolean ignoreTransition) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        long j3 = this.frameId + 1;
        this.frameId = j3;
        if (!showHeatMap) {
            com.tencent.mobileqq.nearbypro.base.j.g().a(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.q(g.this);
                }
            });
            return;
        }
        com.tencent.mobileqq.nearbypro.base.j.c().c("HeatMapRendererByOverlay", "=== \u89e6\u53d1\u6e32\u67d3 [" + reason + "] showHeatMap=" + showHeatMap + " id=" + j3 + " force=" + force + " ignoreTransition=" + ignoreTransition);
        long currentTimeMillis = System.currentTimeMillis();
        if (!force && currentTimeMillis - this.preRenderTs < f253878s) {
            com.tencent.mobileqq.nearbypro.base.j.c().c("HeatMapRendererByOverlay", "=== \u653e\u5f03\u6e32\u67d3\uff0c\u65f6\u95f4\u95f4\u9694\u592a\u77ed");
            return;
        }
        this.preRenderTs = currentTimeMillis;
        int h16 = h();
        Projection projection = getTencentMap().getProjection();
        int i3 = h16 * 2;
        Intrinsics.checkNotNullExpressionValue(projection, "projection");
        List<HeatPoint> d16 = d(projection);
        if (d16 != null) {
            for (HeatPoint heatPoint : d16) {
                heatPoint.d(heatPoint.getX() + i3);
                heatPoint.e(heatPoint.getY() + i3);
            }
        }
        if (d16 == null) {
            return;
        }
        int i16 = i3 * 2;
        int i17 = -i3;
        final RenderTask renderTask = new RenderTask(reason, j3, h16, getTencentMap().getMapWidth() + i16, i16 + getTencentMap().getMapHeight(), new LatLngBounds(projection.fromScreenLocation(new Point(getTencentMap().getMapWidth() + i3, i17)), projection.fromScreenLocation(new Point(i17, getTencentMap().getMapHeight() + i3))), d16, ignoreTransition, 0L, 256, null);
        com.tencent.mobileqq.nearbypro.base.j.g().a(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.f
            @Override // java.lang.Runnable
            public final void run() {
                g.r(g.this, renderTask);
            }
        });
    }

    @Override // com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.d
    public void m(@NotNull vp4.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.m(data);
        com.tencent.mobileqq.nearbypro.base.j.c().c("HeatMapRendererByOverlay", "=== \u6570\u636e\u66f4\u65b0");
        this.overlayUpdater.c(getHeatMapImage().g());
    }
}
