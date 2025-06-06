package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class FloatParser implements ValueParser<Float> {
    public static final FloatParser INSTANCE = new FloatParser();

    FloatParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public Float parse(JsonReader jsonReader, float f16) throws IOException {
        return Float.valueOf(JsonUtils.valueFromObject(jsonReader) * f16);
    }
}
