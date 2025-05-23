package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.io.IOException;

/* loaded from: classes.dex */
public class DocumentDataParser implements ValueParser<DocumentData> {
    public static final DocumentDataParser INSTANCE = new DocumentDataParser();
    private static final JsonReader.Options NAMES = JsonReader.Options.of("t", "f", ReportConstant.COSTREPORT_PREFIX, "j", ReportConstant.COSTREPORT_TRANS, "lh", "ls", "fc", "sc", "sw", "of");

    DocumentDataParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public DocumentData parse(JsonReader jsonReader, float f16) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.beginObject();
        DocumentData.Justification justification2 = justification;
        String str = null;
        String str2 = null;
        float f17 = 0.0f;
        float f18 = 0.0f;
        float f19 = 0.0f;
        float f26 = 0.0f;
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        boolean z16 = true;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    str2 = jsonReader.nextString();
                    break;
                case 2:
                    f17 = (float) jsonReader.nextDouble();
                    break;
                case 3:
                    int nextInt = jsonReader.nextInt();
                    justification2 = DocumentData.Justification.CENTER;
                    if (nextInt <= justification2.ordinal() && nextInt >= 0) {
                        justification2 = DocumentData.Justification.values()[nextInt];
                        break;
                    }
                    break;
                case 4:
                    i3 = jsonReader.nextInt();
                    break;
                case 5:
                    f18 = (float) jsonReader.nextDouble();
                    break;
                case 6:
                    f19 = (float) jsonReader.nextDouble();
                    break;
                case 7:
                    i16 = JsonUtils.jsonToColor(jsonReader);
                    break;
                case 8:
                    i17 = JsonUtils.jsonToColor(jsonReader);
                    break;
                case 9:
                    f26 = (float) jsonReader.nextDouble();
                    break;
                case 10:
                    z16 = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new DocumentData(str, str2, f17, justification2, i3, f18, f19, i16, i17, f26, z16);
    }
}
