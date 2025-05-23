package da4;

import ba4.ColorData;
import com.tencent.sqshow.zootopia.nativeui.view.color.picker.GradientPickerView;
import com.tencent.sqshow.zootopia.nativeui.view.color.picker.MultiHuePickerView;
import com.tencent.sqshow.zootopia.nativeui.view.color.picker.RectColorPickerView;
import java.util.ArrayList;
import java.util.List;
import k94.ColorPanelData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import qu4.c;
import qu4.d;
import qu4.l;
import qu4.p;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J \u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J \u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J \u0010\n\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J&\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000bJ\u0018\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u000bJ&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bJ4\u0010 \u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u001e\u0010\"\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0016\u00a8\u0006%"}, d2 = {"Lda4/b;", "", "Lqu4/d;", "colorSlotInfo", "", "Lba4/c;", "colorDataList", "", "j", "g", h.F, "", "colorIndex", "d", "colorShowType", "i", "Lqu4/c;", "colorInfo", "slotId", "e", "pointPanelIndex", "f", "Lk94/b;", "colorPanelData", "a", "mColorPanelData", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/GradientPickerView;", "gradientPickerView", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/MultiHuePickerView;", "multiHuePickerView", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/RectColorPickerView;", "rectPickerView", "b", "colorData", "c", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f393480a = new b();

    b() {
    }

    private final int d(int colorIndex) {
        if (colorIndex == 3) {
            return 0;
        }
        return colorIndex;
    }

    public final List<ColorData> a(ColorPanelData colorPanelData, d colorSlotInfo, int colorIndex) {
        Intrinsics.checkNotNullParameter(colorPanelData, "colorPanelData");
        ArrayList arrayList = new ArrayList();
        if (colorIndex == 1) {
            l[] lVarArr = colorPanelData.getColorConfig().f440221d;
            if (lVarArr != null) {
                ArrayList arrayList2 = new ArrayList(lVarArr.length);
                for (l lVar : lVarArr) {
                    arrayList2.add(Boolean.valueOf(arrayList.add(new ColorData(false, colorIndex, null, lVar))));
                }
            }
        } else if (colorIndex != 2) {
            p[] pVarArr = colorPanelData.getColorConfig().f440220c;
            if (pVarArr != null) {
                ArrayList arrayList3 = new ArrayList(pVarArr.length);
                for (p pVar : pVarArr) {
                    arrayList3.add(Boolean.valueOf(arrayList.add(new ColorData(false, colorIndex, pVar, null))));
                }
            }
        } else {
            l[] lVarArr2 = colorPanelData.getColorConfig().f440222e;
            if (lVarArr2 != null) {
                ArrayList arrayList4 = new ArrayList(lVarArr2.length);
                for (l lVar2 : lVarArr2) {
                    float f16 = lVar2.f429619f;
                    if (!(f16 == 0.0f)) {
                        if (!(f16 == 1.0f)) {
                            arrayList.add(new ColorData(false, colorIndex, null, lVar2));
                        }
                    }
                    arrayList4.add(Unit.INSTANCE);
                }
            }
        }
        i(colorPanelData.getColorConfig().f440219b, colorSlotInfo, arrayList);
        return arrayList;
    }

    public final c b(int colorIndex, ColorPanelData mColorPanelData, GradientPickerView gradientPickerView, MultiHuePickerView multiHuePickerView, RectColorPickerView rectPickerView) {
        List mutableList;
        Intrinsics.checkNotNullParameter(mColorPanelData, "mColorPanelData");
        d dVar = new d();
        int d16 = d(colorIndex);
        dVar.f429584b = d16;
        if (d16 == 1) {
            l lVar = new l();
            p pVar = new p();
            pVar.f429637b = gradientPickerView != null ? gradientPickerView.e() : 0;
            lVar.f429615b = pVar;
            p pVar2 = new p();
            pVar2.f429637b = gradientPickerView != null ? gradientPickerView.f() : 0;
            lVar.f429616c = pVar2;
            lVar.f429619f = gradientPickerView != null ? gradientPickerView.d() : 0.0f;
            dVar.f429586d = lVar;
        } else if (d16 == 2) {
            l lVar2 = new l();
            lVar2.f429619f = multiHuePickerView != null ? multiHuePickerView.getMFraction() : 0.0f;
            dVar.f429586d = lVar2;
        } else {
            p pVar3 = new p();
            pVar3.f429637b = rectPickerView != null ? rectPickerView.c() : 0;
            dVar.f429585c = pVar3;
        }
        dVar.f429583a = mColorPanelData.getSlotId();
        d[] dVarArr = mColorPanelData.getColorInfo().f429581b;
        Intrinsics.checkNotNullExpressionValue(dVarArr, "mColorPanelData.colorInfo.slotArr");
        int length = dVarArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                i3 = -1;
                break;
            }
            if (dVarArr[i3].f429583a == mColorPanelData.getSlotId()) {
                break;
            }
            i3++;
        }
        c i16 = bj3.a.i(mColorPanelData.getColorInfo());
        if (i3 < 0) {
            d[] dVarArr2 = i16.f429581b;
            Intrinsics.checkNotNullExpressionValue(dVarArr2, "newColorInfo.slotArr");
            mutableList = ArraysKt___ArraysKt.toMutableList(dVarArr2);
            mutableList.add(dVar);
            Object[] array = mutableList.toArray(new d[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            i16.f429581b = (d[]) array;
        } else {
            i16.f429581b[i3] = dVar;
        }
        return i16;
    }

    public final c c(ColorData colorData, int colorIndex, ColorPanelData mColorPanelData) {
        List mutableList;
        Intrinsics.checkNotNullParameter(colorData, "colorData");
        Intrinsics.checkNotNullParameter(mColorPanelData, "mColorPanelData");
        d dVar = new d();
        dVar.f429584b = d(colorIndex);
        dVar.f429583a = mColorPanelData.getSlotId();
        if (colorData.getColorIndex() == 1) {
            dVar.f429586d = colorData.getGradientColor();
        } else if (colorData.getColorIndex() == 2) {
            dVar.f429586d = colorData.getGradientColor();
        } else {
            dVar.f429585c = colorData.getSingleColor();
        }
        d[] dVarArr = mColorPanelData.getColorInfo().f429581b;
        Intrinsics.checkNotNullExpressionValue(dVarArr, "mColorPanelData.colorInfo.slotArr");
        int length = dVarArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                i3 = -1;
                break;
            }
            if (dVarArr[i3].f429583a == mColorPanelData.getSlotId()) {
                break;
            }
            i3++;
        }
        c i16 = bj3.a.i(mColorPanelData.getColorInfo());
        if (i3 < 0) {
            d[] dVarArr2 = i16.f429581b;
            Intrinsics.checkNotNullExpressionValue(dVarArr2, "newColorInfo.slotArr");
            mutableList = ArraysKt___ArraysKt.toMutableList(dVarArr2);
            mutableList.add(dVar);
            Object[] array = mutableList.toArray(new d[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            i16.f429581b = (d[]) array;
        } else {
            i16.f429581b[i3] = dVar;
        }
        return i16;
    }

    public final d e(c colorInfo, int slotId) {
        Intrinsics.checkNotNullParameter(colorInfo, "colorInfo");
        d[] dVarArr = colorInfo.f429581b;
        Intrinsics.checkNotNullExpressionValue(dVarArr, "colorInfo.slotArr");
        for (d dVar : dVarArr) {
            if (dVar.f429583a == slotId) {
                return dVar;
            }
        }
        return null;
    }

    public final void i(int colorShowType, d colorSlotInfo, List<ColorData> colorDataList) {
        Intrinsics.checkNotNullParameter(colorDataList, "colorDataList");
        if (colorShowType != 1) {
            if (colorShowType == 2) {
                if (colorSlotInfo != null && colorSlotInfo.f429584b == 0) {
                    j(colorSlotInfo, colorDataList);
                    return;
                } else {
                    g(colorSlotInfo, colorDataList);
                    return;
                }
            }
            if (colorShowType == 3) {
                h(colorSlotInfo, colorDataList);
                return;
            } else if (colorShowType != 4) {
                return;
            }
        }
        j(colorSlotInfo, colorDataList);
    }

    private final void g(d colorSlotInfo, List<ColorData> colorDataList) {
        p pVar;
        p pVar2;
        l lVar = colorSlotInfo != null ? colorSlotInfo.f429586d : null;
        if (lVar == null) {
            return;
        }
        a aVar = a.f393479a;
        p pVar3 = lVar.f429615b;
        int b16 = aVar.b(pVar3 != null ? pVar3.f429637b : 0);
        p pVar4 = lVar.f429616c;
        int b17 = aVar.b(pVar4 != null ? pVar4.f429637b : 0);
        for (ColorData colorData : colorDataList) {
            a aVar2 = a.f393479a;
            l gradientColor = colorData.getGradientColor();
            int b18 = aVar2.b((gradientColor == null || (pVar2 = gradientColor.f429615b) == null) ? 0 : pVar2.f429637b);
            l gradientColor2 = colorData.getGradientColor();
            int b19 = aVar2.b((gradientColor2 == null || (pVar = gradientColor2.f429616c) == null) ? 0 : pVar.f429637b);
            if (b16 == b18 && b17 == b19) {
                colorData.e(true);
                return;
            }
        }
    }

    private final void j(d colorSlotInfo, List<ColorData> colorDataList) {
        if ((colorSlotInfo != null ? colorSlotInfo.f429585c : null) != null) {
            int b16 = a.f393479a.b(colorSlotInfo.f429585c.f429637b);
            int size = colorDataList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ColorData colorData = colorDataList.get(i3);
                a aVar = a.f393479a;
                p singleColor = colorData.getSingleColor();
                if (aVar.b(singleColor != null ? singleColor.f429637b : 0) == b16) {
                    colorData.e(true);
                    return;
                }
            }
        }
    }

    private final void h(d colorSlotInfo, List<ColorData> colorDataList) {
        l lVar = colorSlotInfo != null ? colorSlotInfo.f429586d : null;
        if (lVar == null) {
            return;
        }
        float f16 = lVar.f429619f;
        for (ColorData colorData : colorDataList) {
            l gradientColor = colorData.getGradientColor();
            if (Intrinsics.areEqual(f16, gradientColor != null ? Float.valueOf(gradientColor.f429619f) : null)) {
                colorData.e(true);
                return;
            }
        }
    }

    public final int f(d colorSlotInfo, int pointPanelIndex) {
        return pointPanelIndex > 0 ? pointPanelIndex : (colorSlotInfo == null || colorSlotInfo.f429584b != 1) ? 0 : 1;
    }
}
