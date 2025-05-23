package com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J+\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\n\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/c;", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/b;", "", "radius", "", "sd", "", "l", "", "grid", "kernel", "k", "([[D[D)[[D", "rawWidth", "rawHeight", "rawRadius", "Landroid/graphics/Bitmap;", "c", "", "renderScale", "", "mapColors", "", "mapColorStops", "<init>", "(F[I[F)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class c extends b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(float f16, @NotNull int[] mapColors, @NotNull float[] mapColorStops) {
        super(f16, mapColors, mapColorStops);
        Intrinsics.checkNotNullParameter(mapColors, "mapColors");
        Intrinsics.checkNotNullParameter(mapColorStops, "mapColorStops");
    }

    private final double[][] k(double[][] grid, double[] kernel) {
        boolean z16;
        int i3;
        int length = kernel.length / 2;
        int length2 = grid.length;
        int i16 = 0;
        int length3 = grid[0].length;
        int i17 = length * 2;
        int i18 = length2 - i17;
        int i19 = length3 - i17;
        int i26 = (length + i18) - 1;
        int i27 = (length + i19) - 1;
        double[][] dArr = new double[length2];
        for (int i28 = 0; i28 < length2; i28++) {
            dArr[i28] = new double[length3];
        }
        int i29 = 0;
        while (true) {
            double d16 = 0.0d;
            if (i29 >= length2) {
                break;
            }
            int i36 = i16;
            while (i36 < length3) {
                double d17 = grid[i29][i36];
                if (d17 == d16) {
                    i3 = 1;
                } else {
                    i3 = i16;
                }
                if (i3 == 0) {
                    int min = Math.min(i26, i29 + length) + 1;
                    int i37 = i29 - length;
                    for (int max = Math.max(length, i37); max < min; max++) {
                        double[] dArr2 = dArr[max];
                        dArr2[i36] = dArr2[i36] + (kernel[max - i37] * d17);
                    }
                }
                i36++;
                i16 = 0;
                d16 = 0.0d;
            }
            i29++;
            i16 = 0;
        }
        double[][] dArr3 = new double[i18];
        for (int i38 = 0; i38 < i18; i38++) {
            dArr3[i38] = new double[i19];
        }
        int i39 = i26 + 1;
        for (int i46 = length; i46 < i39; i46++) {
            for (int i47 = 0; i47 < length3; i47++) {
                double d18 = dArr[i46][i47];
                if (d18 == 0.0d) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    int min2 = Math.min(i27, i47 + length) + 1;
                    int i48 = i47 - length;
                    for (int max2 = Math.max(length, i48); max2 < min2; max2++) {
                        double[] dArr4 = dArr3[i46 - length];
                        int i49 = max2 - length;
                        dArr4[i49] = dArr4[i49] + (kernel[max2 - i48] * d18);
                    }
                }
            }
        }
        return dArr3;
    }

    private final double[] l(int radius, double sd5) {
        double[] dArr = new double[(radius * 2) + 1];
        int i3 = -radius;
        if (i3 <= radius) {
            while (true) {
                dArr[i3 + radius] = Math.exp(((-i3) * i3) / ((2 * sd5) * sd5));
                if (i3 == radius) {
                    break;
                }
                i3++;
            }
        }
        return dArr;
    }

    @Override // com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.b
    @Nullable
    public Bitmap c(int rawWidth, int rawHeight, int rawRadius) {
        boolean z16;
        if (d().isEmpty()) {
            return null;
        }
        int renderScale = (int) (rawWidth / getRenderScale());
        int renderScale2 = (int) (rawHeight / getRenderScale());
        int renderScale3 = (int) (rawRadius / getRenderScale());
        int i3 = renderScale3 * 2;
        int i16 = renderScale + i3;
        double[][] dArr = new double[i16];
        for (int i17 = 0; i17 < i16; i17++) {
            dArr[i17] = new double[renderScale2 + i3];
        }
        for (HeatPoint heatPoint : d()) {
            int x16 = (int) (heatPoint.getX() / getRenderScale());
            int y16 = (int) (heatPoint.getY() / getRenderScale());
            int i18 = -renderScale3;
            boolean z17 = true;
            if (x16 < renderScale + renderScale3 && i18 <= x16) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (y16 >= renderScale2 + renderScale3 || i18 > y16) {
                    z17 = false;
                }
                if (z17) {
                    double[] dArr2 = dArr[x16 + renderScale3];
                    int i19 = y16 + renderScale3;
                    dArr2[i19] = dArr2[i19] + heatPoint.getWeight();
                }
            }
        }
        return b(k(dArr, l(renderScale3, renderScale3 / 3.0d)), getMapColorGradient().getColorMap());
    }
}
