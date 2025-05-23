package com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap;

import android.graphics.Color;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0006B+\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ$\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0006\u0010\u0012\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\rR\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0019R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0014\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/i;", "", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/a;", "Lkotlin/collections/HashMap;", "a", "", "opacity", "", "b", "color1", "color2", "", "ratio", "f", NodeProps.COLORS, "e", "c", "d", "[I", "stopColors", "", "[F", "stopPoints", "I", "colorMapSize", "D", "colorMap", "<init>", "([I[FID)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] stopColors;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final float[] stopPoints;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int colorMapSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final double opacity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] colorMap;

    public i(@NotNull int[] stopColors, @NotNull float[] stopPoints, int i3, double d16) {
        Intrinsics.checkNotNullParameter(stopColors, "stopColors");
        Intrinsics.checkNotNullParameter(stopPoints, "stopPoints");
        this.stopColors = stopColors;
        this.stopPoints = stopPoints;
        this.colorMapSize = i3;
        this.opacity = d16;
        this.colorMap = b(d16);
    }

    private final HashMap<Integer, ColorInterval> a() {
        boolean z16;
        float last;
        int lastIndex;
        HashMap<Integer, ColorInterval> hashMap = new HashMap<>();
        boolean z17 = false;
        if (this.stopPoints[0] == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            hashMap.put(0, new ColorInterval(Color.argb(0, Color.red(this.stopColors[0]), Color.green(this.stopColors[0]), Color.blue(this.stopColors[0])), this.stopColors[0], this.colorMapSize * this.stopPoints[0]));
        }
        int length = this.stopColors.length;
        for (int i3 = 1; i3 < length; i3++) {
            int i16 = i3 - 1;
            Integer valueOf = Integer.valueOf((int) (this.colorMapSize * this.stopPoints[i16]));
            int[] iArr = this.stopColors;
            int i17 = iArr[i16];
            int i18 = iArr[i3];
            float f16 = this.colorMapSize;
            float[] fArr = this.stopPoints;
            hashMap.put(valueOf, new ColorInterval(i17, i18, f16 * (fArr[i3] - fArr[i16])));
        }
        last = ArraysKt___ArraysKt.last(this.stopPoints);
        if (last == 1.0f) {
            z17 = true;
        }
        if (!z17) {
            lastIndex = ArraysKt___ArraysKt.getLastIndex(this.stopPoints);
            Integer valueOf2 = Integer.valueOf((int) (this.colorMapSize * this.stopPoints[lastIndex]));
            int i19 = this.stopColors[lastIndex];
            hashMap.put(valueOf2, new ColorInterval(i19, i19, this.colorMapSize * (1 - this.stopPoints[lastIndex])));
        }
        return hashMap;
    }

    private final int[] b(double opacity) {
        boolean z16;
        HashMap<Integer, ColorInterval> a16 = a();
        int[] iArr = new int[this.colorMapSize];
        ColorInterval colorInterval = a16.get(0);
        int i3 = this.colorMapSize;
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            if (a16.containsKey(Integer.valueOf(i17))) {
                colorInterval = a16.get(Integer.valueOf(i17));
                i16 = i17;
            }
            Intrinsics.checkNotNull(colorInterval);
            iArr[i17] = f(colorInterval.getColorStart(), colorInterval.getColorEnd(), (i17 - i16) / colorInterval.getDuration());
        }
        if (opacity == 1.0d) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            int i18 = this.colorMapSize;
            for (int i19 = 0; i19 < i18; i19++) {
                int i26 = iArr[i19];
                iArr[i19] = Color.argb((int) (Color.alpha(i26) * opacity), Color.red(i26), Color.green(i26), Color.blue(i26));
            }
        }
        ArraysKt___ArraysKt.reverse(iArr);
        return iArr;
    }

    private final float e(int[] colors) {
        int i3 = 0;
        for (int i16 : colors) {
            int alpha = Color.alpha(i16);
            if (alpha > i3) {
                i3 = alpha;
            }
        }
        return i3 / 255.0f;
    }

    private final int f(int color1, int color2, float ratio) {
        int alpha = (int) (((Color.alpha(color2) - Color.alpha(color1)) * ratio) + Color.alpha(color1));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(color1), Color.green(color1), Color.blue(color1), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(color2), Color.green(color2), Color.blue(color2), fArr2);
        float f16 = fArr[0];
        float f17 = fArr2[0];
        if (f16 - f17 > 180.0f) {
            fArr2[0] = f17 + 360.0f;
        } else if (f17 - f16 > 180.0f) {
            fArr[0] = f16 + 360.0f;
        }
        float[] fArr3 = new float[3];
        for (int i3 = 0; i3 < 3; i3++) {
            float f18 = fArr2[i3];
            float f19 = fArr[i3];
            fArr3[i3] = ((f18 - f19) * ratio) + f19;
        }
        return Color.HSVToColor(alpha, fArr3);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final int[] getColorMap() {
        return this.colorMap;
    }

    public final float d() {
        return e(this.colorMap);
    }

    public /* synthetic */ i(int[] iArr, float[] fArr, int i3, double d16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(iArr, fArr, (i16 & 4) != 0 ? 256 : i3, (i16 & 8) != 0 ? 1.0d : d16);
    }
}
