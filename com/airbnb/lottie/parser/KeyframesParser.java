package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class KeyframesParser {
    static JsonReader.Options NAMES = JsonReader.Options.of("k");

    KeyframesParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> List<Keyframe<T>> parse(JsonReader jsonReader, LottieComposition lottieComposition, float f16, ValueParser<T> valueParser, boolean z16) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonReader.Token.STRING) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(NAMES) != 0) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonReader.Token.NUMBER) {
                    arrayList.add(KeyframeParser.parse(jsonReader, lottieComposition, f16, valueParser, false, z16));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(KeyframeParser.parse(jsonReader, lottieComposition, f16, valueParser, true, z16));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(KeyframeParser.parse(jsonReader, lottieComposition, f16, valueParser, false, z16));
            }
        }
        jsonReader.endObject();
        setEndFrames(arrayList);
        return arrayList;
    }

    public static <T> void setEndFrames(List<? extends Keyframe<T>> list) {
        int i3;
        T t16;
        int size = list.size();
        int i16 = 0;
        while (true) {
            i3 = size - 1;
            if (i16 >= i3) {
                break;
            }
            Keyframe<T> keyframe = list.get(i16);
            i16++;
            Keyframe<T> keyframe2 = list.get(i16);
            keyframe.endFrame = Float.valueOf(keyframe2.startFrame);
            if (keyframe.endValue == null && (t16 = keyframe2.startValue) != null) {
                keyframe.endValue = t16;
                if (keyframe instanceof PathKeyframe) {
                    ((PathKeyframe) keyframe).createPath();
                }
            }
        }
        Keyframe<T> keyframe3 = list.get(i3);
        if ((keyframe3.startValue == null || keyframe3.endValue == null) && list.size() > 1) {
            list.remove(keyframe3);
        }
    }
}
