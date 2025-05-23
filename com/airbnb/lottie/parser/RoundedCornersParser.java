package com.airbnb.lottie.parser;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.RoundedCorners;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class RoundedCornersParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "r", "hd");

    RoundedCornersParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static RoundedCorners parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z16 = false;
        String str = null;
        AnimatableFloatValue animatableFloatValue = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName != 0) {
                if (selectName != 1) {
                    if (selectName != 2) {
                        jsonReader.skipValue();
                    } else {
                        z16 = jsonReader.nextBoolean();
                    }
                } else {
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, true);
                }
            } else {
                str = jsonReader.nextString();
            }
        }
        if (z16) {
            return null;
        }
        return new RoundedCorners(str, animatableFloatValue);
    }
}
