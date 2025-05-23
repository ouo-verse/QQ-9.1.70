package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ShapeGroupParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "hd", "it");

    ShapeGroupParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeGroup parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z16 = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName != 0) {
                if (selectName != 1) {
                    if (selectName != 2) {
                        jsonReader.skipValue();
                    } else {
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            ContentModel parse = ContentModelParser.parse(jsonReader, lottieComposition);
                            if (parse != null) {
                                arrayList.add(parse);
                            }
                        }
                        jsonReader.endArray();
                    }
                } else {
                    z16 = jsonReader.nextBoolean();
                }
            } else {
                str = jsonReader.nextString();
            }
        }
        return new ShapeGroup(str, arrayList, z16);
    }
}
