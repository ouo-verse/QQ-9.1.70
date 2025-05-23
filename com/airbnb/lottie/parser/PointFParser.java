package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class PointFParser implements ValueParser<PointF> {
    public static final PointFParser INSTANCE = new PointFParser();

    PointFParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public PointF parse(JsonReader jsonReader, float f16) throws IOException {
        JsonReader.Token peek = jsonReader.peek();
        if (peek == JsonReader.Token.BEGIN_ARRAY) {
            return JsonUtils.jsonToPoint(jsonReader, f16);
        }
        if (peek == JsonReader.Token.BEGIN_OBJECT) {
            return JsonUtils.jsonToPoint(jsonReader, f16);
        }
        if (peek == JsonReader.Token.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f16, ((float) jsonReader.nextDouble()) * f16);
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + peek);
    }
}
