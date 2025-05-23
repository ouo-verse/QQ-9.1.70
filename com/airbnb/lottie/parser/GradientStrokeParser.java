package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class GradientStrokeParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "g", "o", "t", ReportConstant.COSTREPORT_PREFIX, "e", "w", "lc", "lj", "ml", "hd", "d");
    private static final JsonReader.Options GRADIENT_NAMES = JsonReader.Options.of("p", "k");
    private static final JsonReader.Options DASH_PATTERN_NAMES = JsonReader.Options.of(DomainData.DOMAIN_NAME, "v");

    GradientStrokeParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GradientStroke parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str;
        AnimatableGradientColorValue animatableGradientColorValue;
        GradientType gradientType;
        ArrayList arrayList = new ArrayList();
        float f16 = 0.0f;
        String str2 = null;
        GradientType gradientType2 = null;
        AnimatableGradientColorValue animatableGradientColorValue2 = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatablePointValue animatablePointValue2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        boolean z16 = false;
        AnimatableIntegerValue animatableIntegerValue = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    str2 = jsonReader.nextString();
                    continue;
                case 1:
                    str = str2;
                    jsonReader.beginObject();
                    int i3 = -1;
                    while (jsonReader.hasNext()) {
                        int selectName = jsonReader.selectName(GRADIENT_NAMES);
                        if (selectName != 0) {
                            animatableGradientColorValue = animatableGradientColorValue2;
                            if (selectName != 1) {
                                jsonReader.skipName();
                                jsonReader.skipValue();
                            } else {
                                animatableGradientColorValue2 = AnimatableValueParser.parseGradientColor(jsonReader, lottieComposition, i3);
                            }
                        } else {
                            animatableGradientColorValue = animatableGradientColorValue2;
                            i3 = jsonReader.nextInt();
                        }
                        animatableGradientColorValue2 = animatableGradientColorValue;
                    }
                    jsonReader.endObject();
                    break;
                case 2:
                    animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    continue;
                case 3:
                    str = str2;
                    if (jsonReader.nextInt() == 1) {
                        gradientType = GradientType.LINEAR;
                    } else {
                        gradientType = GradientType.RADIAL;
                    }
                    gradientType2 = gradientType;
                    break;
                case 4:
                    animatablePointValue = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                    continue;
                case 5:
                    animatablePointValue2 = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                    continue;
                case 6:
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    continue;
                case 7:
                    str = str2;
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.nextInt() - 1];
                    break;
                case 8:
                    str = str2;
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - 1];
                    break;
                case 9:
                    str = str2;
                    f16 = (float) jsonReader.nextDouble();
                    break;
                case 10:
                    z16 = jsonReader.nextBoolean();
                    continue;
                case 11:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String str3 = null;
                        AnimatableFloatValue animatableFloatValue3 = null;
                        while (jsonReader.hasNext()) {
                            int selectName2 = jsonReader.selectName(DASH_PATTERN_NAMES);
                            if (selectName2 != 0) {
                                AnimatableFloatValue animatableFloatValue4 = animatableFloatValue2;
                                if (selectName2 != 1) {
                                    jsonReader.skipName();
                                    jsonReader.skipValue();
                                } else {
                                    animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                                }
                                animatableFloatValue2 = animatableFloatValue4;
                            } else {
                                str3 = jsonReader.nextString();
                            }
                        }
                        AnimatableFloatValue animatableFloatValue5 = animatableFloatValue2;
                        jsonReader.endObject();
                        if (str3.equals("o")) {
                            animatableFloatValue2 = animatableFloatValue3;
                        } else {
                            if (str3.equals("d") || str3.equals("g")) {
                                lottieComposition.setHasDashPattern(true);
                                arrayList.add(animatableFloatValue3);
                            }
                            animatableFloatValue2 = animatableFloatValue5;
                        }
                    }
                    AnimatableFloatValue animatableFloatValue6 = animatableFloatValue2;
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add((AnimatableFloatValue) arrayList.get(0));
                    }
                    animatableFloatValue2 = animatableFloatValue6;
                    continue;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    continue;
            }
            str2 = str;
        }
        String str4 = str2;
        if (animatableIntegerValue == null) {
            animatableIntegerValue = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100)));
        }
        return new GradientStroke(str4, gradientType2, animatableGradientColorValue2, animatableIntegerValue, animatablePointValue, animatablePointValue2, animatableFloatValue, lineCapType, lineJoinType, f16, arrayList, animatableFloatValue2, z16);
    }
}
