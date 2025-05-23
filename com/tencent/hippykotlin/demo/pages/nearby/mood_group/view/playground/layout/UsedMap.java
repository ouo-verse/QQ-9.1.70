package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.layout;

import com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry.Point;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry.Rectangle;
import com.tencent.kuikly.core.log.KLog;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class UsedMap {
    public final int extraXAxisUseCells;
    public final int extraYAxisUseCells;

    /* renamed from: m, reason: collision with root package name */
    public final byte[] f114233m;
    public final int mapHeight;
    public final MatrixSpiralVisitor mapVisitor;
    public final int mapWidth;
    public final Rectangle mappedRegin;
    public final int pointUseLen;
    public final float usedMapCellHeight;
    public final float usedMapCellWidth;

    public UsedMap(int i3, int i16, Rectangle rectangle, int i17, float f16, float f17) {
        this.mapWidth = i3;
        this.mapHeight = i16;
        this.mappedRegin = rectangle;
        int i18 = i3 * i16;
        byte[] bArr = new byte[i18];
        ArraysKt___ArraysJvmKt.fill$default(bArr, (byte) 0, 0, 0, 6, (Object) null);
        this.f114233m = bArr;
        double d16 = i18 / i17;
        int sqrt = ((int) Math.sqrt(0.5625d * d16)) - 1;
        this.pointUseLen = sqrt;
        float width = rectangle.getWidth() / i3;
        this.usedMapCellWidth = width;
        float height = rectangle.getHeight() / i16;
        this.usedMapCellHeight = height;
        this.extraXAxisUseCells = (int) Math.ceil(f16 / width);
        this.extraYAxisUseCells = (int) Math.ceil((f17 / height) / 2);
        this.mapVisitor = new MatrixSpiralVisitor(i3, i16);
        KLog kLog = KLog.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u70b9\u5e73\u5747\u6700\u5927\u53ef\u7528\u9762\u79ef\uff1a");
        sb5.append(d16);
        sb5.append(" \u70b9\u5b9e\u9645\u5f71\u54cd\u9762\u79ef: ");
        int i19 = (sqrt * 2) + 1;
        sb5.append(i19 * i19);
        sb5.append(" \u7f13\u5b58\u5730\u56fe\u683c\u5b50\u5c3a\u5bf8: ");
        sb5.append(width);
        sb5.append(" x ");
        sb5.append(height);
        sb5.append(" \u70b9\u5e73\u5747\u5f71\u54cd\u8303\u56f4\u8fb9\u957f: ");
        sb5.append(sqrt);
        kLog.d("UsedMap", sb5.toString());
    }

    public final boolean isUsed(Point point) {
        float f16 = point.f114220x;
        Rectangle rectangle = this.mappedRegin;
        float width = (f16 - rectangle.left) / rectangle.getWidth();
        float f17 = point.f114221y;
        Rectangle rectangle2 = this.mappedRegin;
        return isUsedByIndex((int) (width * (this.mapWidth - 1)), (int) (((f17 - rectangle2.top) / rectangle2.getHeight()) * (this.mapHeight - 1)));
    }

    public final boolean isUsedByIndex(int i3, int i16) {
        int i17 = (i16 * this.mapWidth) + i3;
        byte[] bArr = this.f114233m;
        return i17 >= bArr.length || bArr[i17] == 1;
    }

    public final void markUsed(Point point) {
        int coerceIn;
        int coerceIn2;
        float f16 = point.f114220x;
        Rectangle rectangle = this.mappedRegin;
        float width = (f16 - rectangle.left) / rectangle.getWidth();
        float f17 = point.f114221y;
        Rectangle rectangle2 = this.mappedRegin;
        int i3 = (int) (width * (this.mapWidth - 1));
        int height = (int) (((f17 - rectangle2.top) / rectangle2.getHeight()) * (this.mapHeight - 1));
        int i16 = this.pointUseLen;
        int i17 = -i16;
        if (i17 <= i16) {
            while (true) {
                int i18 = this.pointUseLen;
                int i19 = -i18;
                if (i19 <= i18) {
                    while (true) {
                        coerceIn = RangesKt___RangesKt.coerceIn(i3 + i17, 0, this.mapWidth - 1);
                        coerceIn2 = RangesKt___RangesKt.coerceIn(height + i19, 0, this.mapHeight - 1);
                        int i26 = (coerceIn2 * this.mapWidth) + coerceIn;
                        byte[] bArr = this.f114233m;
                        if (i26 < bArr.length) {
                            bArr[i26] = 1;
                        }
                        if (i19 == i18) {
                            break;
                        } else {
                            i19++;
                        }
                    }
                }
                if (i17 == i16) {
                    break;
                } else {
                    i17++;
                }
            }
        }
        int max = Math.max(height - this.extraYAxisUseCells, 0);
        int min = Math.min(height + this.extraYAxisUseCells, this.mapHeight - 1);
        int max2 = Math.max(i3 - this.extraXAxisUseCells, 0);
        int min2 = Math.min(i3 + this.extraXAxisUseCells, this.mapWidth - 1);
        if (max2 > min2) {
            return;
        }
        while (true) {
            if (max <= min) {
                int i27 = max;
                while (true) {
                    int i28 = (this.mapWidth * i27) + max2;
                    byte[] bArr2 = this.f114233m;
                    if (i28 < bArr2.length) {
                        bArr2[i28] = 1;
                    }
                    if (i27 == min) {
                        break;
                    } else {
                        i27++;
                    }
                }
            }
            if (max2 == min2) {
                return;
            } else {
                max2++;
            }
        }
    }

    public final void reset() {
        ArraysKt___ArraysJvmKt.fill$default(this.f114233m, (byte) 0, 0, 0, 6, (Object) null);
        MatrixSpiralVisitor matrixSpiralVisitor = this.mapVisitor;
        matrixSpiralVisitor.f114229x = matrixSpiralVisitor.width / 2;
        int i3 = matrixSpiralVisitor.height;
        matrixSpiralVisitor.f114230y = i3 / 2;
        matrixSpiralVisitor.step = 1;
        matrixSpiralVisitor.directionIndex = 0;
        boolean[][] zArr = new boolean[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            zArr[i16] = new boolean[matrixSpiralVisitor.width];
        }
        matrixSpiralVisitor.visited = zArr;
        matrixSpiralVisitor.initialized = false;
        matrixSpiralVisitor.stepsInCurrentDirection = 0;
        matrixSpiralVisitor.stepsInCurrentLeg = 0;
    }
}
