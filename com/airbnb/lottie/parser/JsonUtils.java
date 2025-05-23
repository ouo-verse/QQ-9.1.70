package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
class JsonUtils {
    private static final JsonReader.Options POINT_NAMES = JsonReader.Options.of(HippyTKDListViewAdapter.X, "y");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.airbnb.lottie.parser.JsonUtils$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token;

        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            $SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token = iArr;
            try {
                iArr[JsonReader.Token.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    JsonUtils() {
    }

    private static PointF jsonArrayToPoint(JsonReader jsonReader, float f16) throws IOException {
        jsonReader.beginArray();
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.peek() != JsonReader.Token.END_ARRAY) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return new PointF(nextDouble * f16, nextDouble2 * f16);
    }

    private static PointF jsonNumbersToPoint(JsonReader jsonReader, float f16) throws IOException {
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        return new PointF(nextDouble * f16, nextDouble2 * f16);
    }

    private static PointF jsonObjectToPoint(JsonReader jsonReader, float f16) throws IOException {
        jsonReader.beginObject();
        float f17 = 0.0f;
        float f18 = 0.0f;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(POINT_NAMES);
            if (selectName != 0) {
                if (selectName != 1) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                } else {
                    f18 = valueFromObject(jsonReader);
                }
            } else {
                f17 = valueFromObject(jsonReader);
            }
        }
        jsonReader.endObject();
        return new PointF(f17 * f16, f18 * f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ColorInt
    public static int jsonToColor(JsonReader jsonReader) throws IOException {
        jsonReader.beginArray();
        int nextDouble = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return Color.argb(255, nextDouble, nextDouble2, nextDouble3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PointF jsonToPoint(JsonReader jsonReader, float f16) throws IOException {
        int i3 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token[jsonReader.peek().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return jsonObjectToPoint(jsonReader, f16);
                }
                throw new IllegalArgumentException("Unknown point starts with " + jsonReader.peek());
            }
            return jsonArrayToPoint(jsonReader, f16);
        }
        return jsonNumbersToPoint(jsonReader, f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<PointF> jsonToPoints(JsonReader jsonReader, float f16) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add(jsonToPoint(jsonReader, f16));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float valueFromObject(JsonReader jsonReader) throws IOException {
        JsonReader.Token peek = jsonReader.peek();
        int i3 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token[peek.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                jsonReader.beginArray();
                float nextDouble = (float) jsonReader.nextDouble();
                while (jsonReader.hasNext()) {
                    jsonReader.skipValue();
                }
                jsonReader.endArray();
                return nextDouble;
            }
            throw new IllegalArgumentException("Unknown value for token of type " + peek);
        }
        return (float) jsonReader.nextDouble();
    }
}
