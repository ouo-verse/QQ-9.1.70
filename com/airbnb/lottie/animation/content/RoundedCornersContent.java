package com.airbnb.lottie.animation.content;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.RoundedCorners;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class RoundedCornersContent implements ShapeModifierContent, BaseKeyframeAnimation.AnimationListener {
    private static final float ROUNDED_CORNER_MAGIC_NUMBER = 0.5519f;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<Float, Float> roundedCorners;

    @Nullable
    private ShapeData shapeData;

    public RoundedCornersContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RoundedCorners roundedCorners) {
        this.lottieDrawable = lottieDrawable;
        this.name = roundedCorners.getName();
        BaseKeyframeAnimation<Float, Float> createAnimation = roundedCorners.getCornerRadius().createAnimation();
        this.roundedCorners = createAnimation;
        baseLayer.addAnimation(createAnimation);
        createAnimation.addUpdateListener(this);
    }

    private static int floorDiv(int i3, int i16) {
        int i17 = i3 / i16;
        if ((i3 ^ i16) < 0 && i16 * i17 != i3) {
            return i17 - 1;
        }
        return i17;
    }

    private static int floorMod(int i3, int i16) {
        return i3 - (floorDiv(i3, i16) * i16);
    }

    @NonNull
    private ShapeData getShapeData(ShapeData shapeData) {
        PointF vertex;
        PointF controlPoint2;
        boolean z16;
        List<CubicCurveData> curves = shapeData.getCurves();
        boolean isClosed = shapeData.isClosed();
        int i3 = 0;
        for (int size = curves.size() - 1; size >= 0; size--) {
            CubicCurveData cubicCurveData = curves.get(size);
            CubicCurveData cubicCurveData2 = curves.get(floorMod(size - 1, curves.size()));
            if (size == 0 && !isClosed) {
                vertex = shapeData.getInitialPoint();
            } else {
                vertex = cubicCurveData2.getVertex();
            }
            if (size == 0 && !isClosed) {
                controlPoint2 = vertex;
            } else {
                controlPoint2 = cubicCurveData2.getControlPoint2();
            }
            PointF controlPoint1 = cubicCurveData.getControlPoint1();
            if (!shapeData.isClosed() && size == 0 && size == curves.size() - 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (controlPoint2.equals(vertex) && controlPoint1.equals(vertex) && !z16) {
                i3 += 2;
            } else {
                i3++;
            }
        }
        ShapeData shapeData2 = this.shapeData;
        if (shapeData2 == null || shapeData2.getCurves().size() != i3) {
            ArrayList arrayList = new ArrayList(i3);
            for (int i16 = 0; i16 < i3; i16++) {
                arrayList.add(new CubicCurveData());
            }
            this.shapeData = new ShapeData(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.shapeData.setClosed(isClosed);
        return this.shapeData;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    public BaseKeyframeAnimation<Float, Float> getRoundedCorners() {
        return this.roundedCorners;
    }

    @Override // com.airbnb.lottie.animation.content.ShapeModifierContent
    public ShapeData modifyShape(ShapeData shapeData) {
        PointF vertex;
        PointF controlPoint2;
        boolean z16;
        List<CubicCurveData> list;
        List<CubicCurveData> curves = shapeData.getCurves();
        if (curves.size() <= 2) {
            return shapeData;
        }
        float floatValue = this.roundedCorners.getValue().floatValue();
        if (floatValue == 0.0f) {
            return shapeData;
        }
        ShapeData shapeData2 = getShapeData(shapeData);
        shapeData2.setInitialPoint(shapeData.getInitialPoint().x, shapeData.getInitialPoint().y);
        List<CubicCurveData> curves2 = shapeData2.getCurves();
        boolean isClosed = shapeData.isClosed();
        int i3 = 0;
        int i16 = 0;
        while (i3 < curves.size()) {
            CubicCurveData cubicCurveData = curves.get(i3);
            CubicCurveData cubicCurveData2 = curves.get(floorMod(i3 - 1, curves.size()));
            CubicCurveData cubicCurveData3 = curves.get(floorMod(i3 - 2, curves.size()));
            if (i3 == 0 && !isClosed) {
                vertex = shapeData.getInitialPoint();
            } else {
                vertex = cubicCurveData2.getVertex();
            }
            if (i3 == 0 && !isClosed) {
                controlPoint2 = vertex;
            } else {
                controlPoint2 = cubicCurveData2.getControlPoint2();
            }
            PointF controlPoint1 = cubicCurveData.getControlPoint1();
            PointF vertex2 = cubicCurveData3.getVertex();
            PointF vertex3 = cubicCurveData.getVertex();
            if (!shapeData.isClosed() && i3 == 0 && i3 == curves.size() - 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (controlPoint2.equals(vertex) && controlPoint1.equals(vertex) && !z16) {
                float f16 = vertex.x;
                float f17 = f16 - vertex2.x;
                float f18 = vertex.y;
                float f19 = f18 - vertex2.y;
                float f26 = vertex3.x - f16;
                float f27 = vertex3.y - f18;
                list = curves;
                float hypot = (float) Math.hypot(f17, f19);
                float hypot2 = (float) Math.hypot(f26, f27);
                float min = Math.min(floatValue / hypot, 0.5f);
                float min2 = Math.min(floatValue / hypot2, 0.5f);
                float f28 = vertex.x;
                float f29 = ((vertex2.x - f28) * min) + f28;
                float f36 = vertex.y;
                float f37 = ((vertex2.y - f36) * min) + f36;
                float f38 = ((vertex3.x - f28) * min2) + f28;
                float f39 = ((vertex3.y - f36) * min2) + f36;
                float f46 = f29 - ((f29 - f28) * ROUNDED_CORNER_MAGIC_NUMBER);
                float f47 = f37 - ((f37 - f36) * ROUNDED_CORNER_MAGIC_NUMBER);
                float f48 = f38 - ((f38 - f28) * ROUNDED_CORNER_MAGIC_NUMBER);
                float f49 = f39 - ((f39 - f36) * ROUNDED_CORNER_MAGIC_NUMBER);
                CubicCurveData cubicCurveData4 = curves2.get(floorMod(i16 - 1, curves2.size()));
                CubicCurveData cubicCurveData5 = curves2.get(i16);
                cubicCurveData4.setControlPoint2(f29, f37);
                cubicCurveData4.setVertex(f29, f37);
                if (i3 == 0) {
                    shapeData2.setInitialPoint(f29, f37);
                }
                cubicCurveData5.setControlPoint1(f46, f47);
                i16++;
                CubicCurveData cubicCurveData6 = curves2.get(i16);
                cubicCurveData5.setControlPoint2(f48, f49);
                cubicCurveData5.setVertex(f38, f39);
                cubicCurveData6.setControlPoint1(f38, f39);
            } else {
                list = curves;
                CubicCurveData cubicCurveData7 = curves2.get(floorMod(i16 - 1, curves2.size()));
                CubicCurveData cubicCurveData8 = curves2.get(i16);
                cubicCurveData7.setControlPoint2(cubicCurveData2.getVertex().x, cubicCurveData2.getVertex().y);
                cubicCurveData7.setVertex(cubicCurveData2.getVertex().x, cubicCurveData2.getVertex().y);
                cubicCurveData8.setControlPoint1(cubicCurveData.getVertex().x, cubicCurveData.getVertex().y);
            }
            i16++;
            i3++;
            curves = list;
        }
        return shapeData2;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
    }
}
