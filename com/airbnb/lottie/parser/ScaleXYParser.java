package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;

/* loaded from: classes.dex */
public class ScaleXYParser implements ValueParser<ScaleXY> {
    public static final ScaleXYParser INSTANCE = new ScaleXYParser();

    ScaleXYParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public ScaleXY parse(JsonReader jsonReader, float f16) throws IOException {
        boolean z16 = jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY;
        if (z16) {
            jsonReader.beginArray();
        }
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z16) {
            jsonReader.endArray();
        }
        return new ScaleXY((nextDouble / 100.0f) * f16, (nextDouble2 / 100.0f) * f16);
    }
}
