package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CircleShapeParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "p", ReportConstant.COSTREPORT_PREFIX, "hd", "d");

    CircleShapeParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CircleShape parse(JsonReader jsonReader, LottieComposition lottieComposition, int i3) throws IOException {
        boolean z16;
        if (i3 == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = z16;
        boolean z18 = false;
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatablePointValue animatablePointValue = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName != 0) {
                if (selectName != 1) {
                    if (selectName != 2) {
                        if (selectName != 3) {
                            if (selectName != 4) {
                                jsonReader.skipName();
                                jsonReader.skipValue();
                            } else if (jsonReader.nextInt() == 3) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                        } else {
                            z18 = jsonReader.nextBoolean();
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
        return new CircleShape(str, animatableValue, animatablePointValue, z17, z18);
    }
}
