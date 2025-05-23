package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class RectangleShapeParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "p", ReportConstant.COSTREPORT_PREFIX, "r", "hd");

    RectangleShapeParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RectangleShape parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        boolean z16 = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName != 0) {
                if (selectName != 1) {
                    if (selectName != 2) {
                        if (selectName != 3) {
                            if (selectName != 4) {
                                jsonReader.skipValue();
                            } else {
                                z16 = jsonReader.nextBoolean();
                            }
                        } else {
                            animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                        }
                    } else {
                        animatablePointValue = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                    }
                } else {
                    animatableValue = AnimatablePathValueParser.parseSplitPath(jsonReader, lottieComposition);
                }
            } else {
                str = jsonReader.nextString();
            }
        }
        return new RectangleShape(str, animatableValue, animatablePointValue, animatableFloatValue, z16);
    }
}
