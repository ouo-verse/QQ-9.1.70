package com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap;

import android.graphics.Bitmap;
import com.heytap.databaseengine.model.UserInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0013\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010 \u001a\u00020\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b/\u00100J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH&J'\u0010\u0017\u001a\u0004\u0018\u00010\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u001a\u001a\u00020\u0019R\"\u0010 \u001a\u00020\u00198\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0!8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010.\u001a\u00020(8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/b;", "", "", "mapColors", "", "mapColorStops", "", "j", "", "e", "i", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/h;", "point", "a", "rawWidth", "rawHeight", "rawRadius", "Landroid/graphics/Bitmap;", "c", "", "", "grid", "colorMap", "b", "([[D[I)Landroid/graphics/Bitmap;", "", "g", UserInfo.SEX_FEMALE, tl.h.F, "()F", "setRenderScale", "(F)V", "renderScale", "", "Ljava/util/List;", "d", "()Ljava/util/List;", "setFrameData", "(Ljava/util/List;)V", "frameData", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/i;", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/i;", "f", "()Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/i;", "setMapColorGradient", "(Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/i;)V", "mapColorGradient", "<init>", "(F[I[F)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float renderScale;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<HeatPoint> frameData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private i mapColorGradient;

    public b(float f16, @NotNull int[] mapColors, @NotNull float[] mapColorStops) {
        Intrinsics.checkNotNullParameter(mapColors, "mapColors");
        Intrinsics.checkNotNullParameter(mapColorStops, "mapColorStops");
        this.renderScale = f16;
        this.frameData = new ArrayList();
        this.mapColorGradient = new i(mapColors, mapColorStops, 0, 0.0d, 12, null);
    }

    public void a(@NotNull HeatPoint point) {
        Intrinsics.checkNotNullParameter(point, "point");
        this.frameData.add(point);
    }

    @Nullable
    public Bitmap b(@NotNull double[][] grid, @NotNull int[] colorMap) {
        int last;
        boolean z16;
        int i3;
        Intrinsics.checkNotNullParameter(grid, "grid");
        Intrinsics.checkNotNullParameter(colorMap, "colorMap");
        last = ArraysKt___ArraysKt.last(colorMap);
        int length = grid.length;
        int length2 = grid[0].length;
        int[] iArr = new int[length * length2];
        for (int i16 = 0; i16 < length2; i16++) {
            for (int i17 = 0; i17 < length; i17++) {
                double d16 = grid[i17][i16];
                if (d16 == 0.0d) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    int i18 = (i16 * length) + i17;
                    int length3 = (int) (d16 * colorMap.length);
                    if (length3 < colorMap.length) {
                        i3 = colorMap[length3];
                    } else {
                        i3 = last;
                    }
                    iArr[i18] = i3;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(length, length2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, length, 0, 0, length, length2);
        return createBitmap;
    }

    @Nullable
    public abstract Bitmap c(int rawWidth, int rawHeight, int rawRadius);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final List<HeatPoint> d() {
        return this.frameData;
    }

    public final int e() {
        return this.frameData.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: f, reason: from getter */
    public final i getMapColorGradient() {
        return this.mapColorGradient;
    }

    public final float g() {
        return this.mapColorGradient.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h, reason: from getter */
    public final float getRenderScale() {
        return this.renderScale;
    }

    public final void i() {
        this.frameData.clear();
    }

    public final void j(@NotNull int[] mapColors, @NotNull float[] mapColorStops) {
        Intrinsics.checkNotNullParameter(mapColors, "mapColors");
        Intrinsics.checkNotNullParameter(mapColorStops, "mapColorStops");
        this.mapColorGradient = new i(mapColors, mapColorStops, 0, 0.0d, 12, null);
    }
}
