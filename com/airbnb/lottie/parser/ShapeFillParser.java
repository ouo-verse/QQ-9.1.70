package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ShapeFillParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "c", "o", "fillEnabled", "r", "hd");

    ShapeFillParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeFill parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        Path.FillType fillType;
        AnimatableIntegerValue animatableIntegerValue = null;
        String str = null;
        AnimatableColorValue animatableColorValue = null;
        boolean z16 = false;
        boolean z17 = false;
        int i3 = 1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName != 0) {
                if (selectName != 1) {
                    if (selectName != 2) {
                        if (selectName != 3) {
                            if (selectName != 4) {
                                if (selectName != 5) {
                                    jsonReader.skipName();
                                    jsonReader.skipValue();
                                } else {
                                    z17 = jsonReader.nextBoolean();
                                }
                            } else {
                                i3 = jsonReader.nextInt();
                            }
                        } else {
                            z16 = jsonReader.nextBoolean();
                        }
                    } else {
                        animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    }
                } else {
                    animatableColorValue = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
                }
            } else {
                str = jsonReader.nextString();
            }
        }
        if (animatableIntegerValue == null) {
            animatableIntegerValue = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100)));
        }
        AnimatableIntegerValue animatableIntegerValue2 = animatableIntegerValue;
        if (i3 == 1) {
            fillType = Path.FillType.WINDING;
        } else {
            fillType = Path.FillType.EVEN_ODD;
        }
        return new ShapeFill(str, z16, fillType, animatableColorValue, animatableIntegerValue2, z17);
    }
}
