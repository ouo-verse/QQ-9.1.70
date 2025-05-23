package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;

/* loaded from: classes.dex */
class PathKeyframeParser {
    PathKeyframeParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PathKeyframe parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z16;
        if (jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT) {
            z16 = true;
        } else {
            z16 = false;
        }
        return new PathKeyframe(lottieComposition, KeyframeParser.parse(jsonReader, lottieComposition, Utils.dpScale(), PathParser.INSTANCE, z16, false));
    }
}
