package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import com.tencent.av.so.ResInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.io.IOException;

/* loaded from: classes.dex */
public class AnimatableTransformParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("a", "p", ReportConstant.COSTREPORT_PREFIX, "rz", "r", "o", ResInfo.RES_TYPE_SO, "eo", "sk", "sa");
    private static final JsonReader.Options ANIMATABLE_NAMES = JsonReader.Options.of("k");

    AnimatableTransformParser() {
    }

    private static boolean isAnchorPointIdentity(AnimatablePathValue animatablePathValue) {
        if (animatablePathValue != null && (!animatablePathValue.isStatic() || !animatablePathValue.getKeyframes().get(0).startValue.equals(0.0f, 0.0f))) {
            return false;
        }
        return true;
    }

    private static boolean isPositionIdentity(AnimatableValue<PointF, PointF> animatableValue) {
        if (animatableValue != null && ((animatableValue instanceof AnimatableSplitDimensionPathValue) || !animatableValue.isStatic() || !animatableValue.getKeyframes().get(0).startValue.equals(0.0f, 0.0f))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isRotationIdentity(AnimatableFloatValue animatableFloatValue) {
        if (animatableFloatValue != null && (!animatableFloatValue.isStatic() || ((Float) ((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() != 0.0f)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isScaleIdentity(AnimatableScaleValue animatableScaleValue) {
        if (animatableScaleValue != null && (!animatableScaleValue.isStatic() || !((ScaleXY) ((Keyframe) animatableScaleValue.getKeyframes().get(0)).startValue).equals(1.0f, 1.0f))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isSkewAngleIdentity(AnimatableFloatValue animatableFloatValue) {
        if (animatableFloatValue != null && (!animatableFloatValue.isStatic() || ((Float) ((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() != 0.0f)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isSkewIdentity(AnimatableFloatValue animatableFloatValue) {
        if (animatableFloatValue != null && (!animatableFloatValue.isStatic() || ((Float) ((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() != 0.0f)) {
            return false;
        }
        return true;
    }

    public static AnimatableTransform parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z16;
        AnimatablePathValue animatablePathValue;
        AnimatableValue<PointF, PointF> animatableValue;
        AnimatableFloatValue animatableFloatValue;
        AnimatableFloatValue animatableFloatValue2;
        AnimatableFloatValue animatableFloatValue3;
        boolean z17;
        boolean z18 = false;
        if (jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            jsonReader.beginObject();
        }
        AnimatableFloatValue animatableFloatValue4 = null;
        AnimatablePathValue animatablePathValue2 = null;
        AnimatableValue<PointF, PointF> animatableValue2 = null;
        AnimatableScaleValue animatableScaleValue = null;
        AnimatableFloatValue animatableFloatValue5 = null;
        AnimatableFloatValue animatableFloatValue6 = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatableFloatValue animatableFloatValue7 = null;
        AnimatableFloatValue animatableFloatValue8 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    boolean z19 = z18;
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if (jsonReader.selectName(ANIMATABLE_NAMES) != 0) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        } else {
                            animatablePathValue2 = AnimatablePathValueParser.parse(jsonReader, lottieComposition);
                        }
                    }
                    jsonReader.endObject();
                    z18 = z19;
                    continue;
                case 1:
                    animatableValue2 = AnimatablePathValueParser.parseSplitPath(jsonReader, lottieComposition);
                    continue;
                case 2:
                    animatableScaleValue = AnimatableValueParser.parseScale(jsonReader, lottieComposition);
                    continue;
                case 3:
                    lottieComposition.addWarning("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    continue;
                case 6:
                    animatableFloatValue7 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z18);
                    continue;
                case 7:
                    animatableFloatValue8 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z18);
                    continue;
                case 8:
                    animatableFloatValue5 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z18);
                    continue;
                case 9:
                    animatableFloatValue6 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z18);
                    continue;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    continue;
            }
            AnimatableFloatValue parseFloat = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z18);
            if (parseFloat.getKeyframes().isEmpty()) {
                parseFloat.getKeyframes().add(new Keyframe(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(lottieComposition.getEndFrame())));
            } else if (((Keyframe) parseFloat.getKeyframes().get(0)).startValue == 0) {
                z17 = false;
                parseFloat.getKeyframes().set(0, new Keyframe(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(lottieComposition.getEndFrame())));
                z18 = z17;
                animatableFloatValue4 = parseFloat;
            }
            z17 = false;
            z18 = z17;
            animatableFloatValue4 = parseFloat;
        }
        if (z16) {
            jsonReader.endObject();
        }
        if (isAnchorPointIdentity(animatablePathValue2)) {
            animatablePathValue = null;
        } else {
            animatablePathValue = animatablePathValue2;
        }
        if (isPositionIdentity(animatableValue2)) {
            animatableValue = null;
        } else {
            animatableValue = animatableValue2;
        }
        if (isRotationIdentity(animatableFloatValue4)) {
            animatableFloatValue = null;
        } else {
            animatableFloatValue = animatableFloatValue4;
        }
        if (isScaleIdentity(animatableScaleValue)) {
            animatableScaleValue = null;
        }
        if (isSkewIdentity(animatableFloatValue5)) {
            animatableFloatValue2 = null;
        } else {
            animatableFloatValue2 = animatableFloatValue5;
        }
        if (isSkewAngleIdentity(animatableFloatValue6)) {
            animatableFloatValue3 = null;
        } else {
            animatableFloatValue3 = animatableFloatValue6;
        }
        return new AnimatableTransform(animatablePathValue, animatableValue, animatableScaleValue, animatableFloatValue, animatableIntegerValue, animatableFloatValue7, animatableFloatValue8, animatableFloatValue2, animatableFloatValue3);
    }
}
