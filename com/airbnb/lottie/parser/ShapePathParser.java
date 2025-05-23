package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ShapePathParser {
    static JsonReader.Options NAMES = JsonReader.Options.of("nm", "ind", "ks", "hd");

    ShapePathParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapePath parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        int i3 = 0;
        boolean z16 = false;
        AnimatableShapeValue animatableShapeValue = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName != 0) {
                if (selectName != 1) {
                    if (selectName != 2) {
                        if (selectName != 3) {
                            jsonReader.skipValue();
                        } else {
                            z16 = jsonReader.nextBoolean();
                        }
                    } else {
                        animatableShapeValue = AnimatableValueParser.parseShapeData(jsonReader, lottieComposition);
                    }
                } else {
                    i3 = jsonReader.nextInt();
                }
            } else {
                str = jsonReader.nextString();
            }
        }
        return new ShapePath(str, i3, animatableShapeValue, z16);
    }
}
