package com.airbnb.lottie.utils;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class MiscUtils {
    private static final PointF pathFromDataCurrentPoint = new PointF();

    public static PointF addPoints(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static int clamp(int i3, int i16, int i17) {
        return Math.max(i16, Math.min(i17, i3));
    }

    public static boolean contains(float f16, float f17, float f18) {
        if (f16 >= f17 && f16 <= f18) {
            return true;
        }
        return false;
    }

    private static int floorDiv(int i3, int i16) {
        boolean z16;
        int i17 = i3 / i16;
        if ((i3 ^ i16) >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i18 = i3 % i16;
        if (!z16 && i18 != 0) {
            return i17 - 1;
        }
        return i17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int floorMod(float f16, float f17) {
        return floorMod((int) f16, (int) f17);
    }

    public static void getPathFromData(ShapeData shapeData, Path path) {
        path.reset();
        PointF initialPoint = shapeData.getInitialPoint();
        path.moveTo(initialPoint.x, initialPoint.y);
        pathFromDataCurrentPoint.set(initialPoint.x, initialPoint.y);
        for (int i3 = 0; i3 < shapeData.getCurves().size(); i3++) {
            CubicCurveData cubicCurveData = shapeData.getCurves().get(i3);
            PointF controlPoint1 = cubicCurveData.getControlPoint1();
            PointF controlPoint2 = cubicCurveData.getControlPoint2();
            PointF vertex = cubicCurveData.getVertex();
            PointF pointF = pathFromDataCurrentPoint;
            if (controlPoint1.equals(pointF) && controlPoint2.equals(vertex)) {
                path.lineTo(vertex.x, vertex.y);
            } else {
                path.cubicTo(controlPoint1.x, controlPoint1.y, controlPoint2.x, controlPoint2.y, vertex.x, vertex.y);
            }
            pointF.set(vertex.x, vertex.y);
        }
        if (shapeData.isClosed()) {
            path.close();
        }
    }

    public static double lerp(double d16, double d17, @FloatRange(from = 0.0d, to = 1.0d) double d18) {
        return d16 + (d18 * (d17 - d16));
    }

    public static void resolveKeyPath(KeyPath keyPath, int i3, List<KeyPath> list, KeyPath keyPath2, KeyPathElementContent keyPathElementContent) {
        if (keyPath.fullyResolvesTo(keyPathElementContent.getName(), i3)) {
            list.add(keyPath2.addKey(keyPathElementContent.getName()).resolve(keyPathElementContent));
        }
    }

    public static float clamp(float f16, float f17, float f18) {
        return Math.max(f17, Math.min(f18, f16));
    }

    private static int floorMod(int i3, int i16) {
        return i3 - (i16 * floorDiv(i3, i16));
    }

    public static float lerp(float f16, float f17, @FloatRange(from = 0.0d, to = 1.0d) float f18) {
        return f16 + (f18 * (f17 - f16));
    }

    public static double clamp(double d16, double d17, double d18) {
        return Math.max(d17, Math.min(d18, d16));
    }

    public static int lerp(int i3, int i16, @FloatRange(from = 0.0d, to = 1.0d) float f16) {
        return (int) (i3 + (f16 * (i16 - i3)));
    }
}
