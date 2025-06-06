package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class IntegerParser implements ValueParser<Integer> {
    public static final IntegerParser INSTANCE = new IntegerParser();

    IntegerParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public Integer parse(JsonReader jsonReader, float f16) throws IOException {
        return Integer.valueOf(Math.round(JsonUtils.valueFromObject(jsonReader) * f16));
    }
}
