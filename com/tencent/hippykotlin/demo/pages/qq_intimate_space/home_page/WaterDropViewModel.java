package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.BubbleTriangleDirection;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.Point;
import com.tencent.ntcompose.activity.b;
import e25.aj;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class WaterDropViewModel {
    public final WaterDropFloatViewModel floatViewModel;
    public MutableState<Float> marginHorizontal;
    public MutableState<Point> point;
    public MutableState<BubbleTriangleDirection> triangleDirection;
    public MutableState<aj> waterTask;
    public MutableState<Float> width;

    /* JADX WARN: Removed duplicated region for block: B:47:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.util.List<java.lang.Float>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.util.List<java.lang.Float>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.util.List<java.lang.Integer>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.List<java.lang.Integer>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.List<java.lang.Integer>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.util.List<java.lang.Integer>, java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateWaterDropConfig() {
        Float leftWaterDropPointY;
        IntRange indices;
        IntRange indices2;
        if (this.waterTask.getValue().E != null) {
            this.width.setValue(Float.valueOf(Math.max(74.0f, (14 * r0.f395424f.length()) + 114)));
        }
        float nextDouble = (float) Random.INSTANCE.nextDouble(6.0d, 20.0d);
        if (this.marginHorizontal.getValue() == null) {
            this.marginHorizontal.setValue(Float.valueOf(nextDouble));
        } else {
            Float value = this.marginHorizontal.getValue();
            Intrinsics.checkNotNull(value);
            nextDouble = value.floatValue();
        }
        int i3 = this.waterTask.getValue().f395459d;
        Float f16 = null;
        if (i3 == 1) {
            leftWaterDropPointY = this.floatViewModel.getLeftWaterDropPointY(0);
            this.triangleDirection.setValue(BubbleTriangleDirection.DOWN_LEFT);
        } else if (i3 == 2) {
            leftWaterDropPointY = this.floatViewModel.getRightWaterDropPointY(0);
            this.triangleDirection.setValue(BubbleTriangleDirection.DOWN_RIGHT);
        } else if (i3 == 3) {
            leftWaterDropPointY = this.floatViewModel.getRightWaterDropPointY(1);
            this.triangleDirection.setValue(BubbleTriangleDirection.DOWN_RIGHT);
        } else if (i3 != 4) {
            leftWaterDropPointY = null;
        } else {
            leftWaterDropPointY = this.floatViewModel.getLeftWaterDropPointY(1);
            this.triangleDirection.setValue(BubbleTriangleDirection.DOWN_LEFT);
        }
        if (leftWaterDropPointY == null) {
            WaterDropFloatViewModel waterDropFloatViewModel = this.floatViewModel;
            indices = CollectionsKt__CollectionsKt.getIndices(waterDropFloatViewModel.waterDropPointYList);
            ArrayList arrayList = new ArrayList();
            for (Integer num : indices) {
                if (!waterDropFloatViewModel.rightPointYIndexList.contains(Integer.valueOf(num.intValue()))) {
                    arrayList.add(num);
                }
            }
            if (!arrayList.isEmpty()) {
                int intValue = ((Number) arrayList.get(Random.INSTANCE.nextInt(arrayList.size()))).intValue();
                waterDropFloatViewModel.rightPointYIndexList.add(Integer.valueOf(intValue));
                leftWaterDropPointY = (Float) waterDropFloatViewModel.waterDropPointYList.get(intValue);
            } else {
                leftWaterDropPointY = null;
            }
            if (leftWaterDropPointY != null) {
                this.triangleDirection.setValue(BubbleTriangleDirection.DOWN_RIGHT);
            } else {
                this.triangleDirection.setValue(BubbleTriangleDirection.DOWN_LEFT);
                WaterDropFloatViewModel waterDropFloatViewModel2 = this.floatViewModel;
                indices2 = CollectionsKt__CollectionsKt.getIndices(waterDropFloatViewModel2.waterDropPointYList);
                ArrayList arrayList2 = new ArrayList();
                for (Integer num2 : indices2) {
                    if (!waterDropFloatViewModel2.leftPointYIndexList.contains(Integer.valueOf(num2.intValue()))) {
                        arrayList2.add(num2);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    int intValue2 = ((Number) arrayList2.get(Random.INSTANCE.nextInt(arrayList2.size()))).intValue();
                    waterDropFloatViewModel2.leftPointYIndexList.add(Integer.valueOf(intValue2));
                    f16 = (Float) waterDropFloatViewModel2.waterDropPointYList.get(intValue2);
                }
                if (f16 == null) {
                    float floatValue = f16.floatValue();
                    int ordinal = this.triangleDirection.getValue().ordinal();
                    if (ordinal != 0) {
                        if (ordinal != 2) {
                            return;
                        }
                        this.point.setValue(new Point((b.a().getPageData().m() - nextDouble) - this.width.getValue().floatValue(), floatValue));
                        return;
                    }
                    this.point.setValue(new Point(nextDouble, floatValue));
                    return;
                }
                return;
            }
        }
        f16 = leftWaterDropPointY;
        if (f16 == null) {
        }
    }

    public WaterDropViewModel(WaterDropFloatViewModel waterDropFloatViewModel) {
        MutableState<Float> mutableStateOf$default;
        MutableState<Point> mutableStateOf$default2;
        MutableState<BubbleTriangleDirection> mutableStateOf$default3;
        MutableState<aj> mutableStateOf$default4;
        MutableState<Float> mutableStateOf$default5;
        this.floatViewModel = waterDropFloatViewModel;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(74.0f), null, 2, null);
        this.width = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.point = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(BubbleTriangleDirection.DOWN_LEFT, null, 2, null);
        this.triangleDirection = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new aj(0, 0, null, 0L, 0L, null, false, null, null, 511, null), null, 2, null);
        this.waterTask = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.marginHorizontal = mutableStateOf$default5;
    }
}
