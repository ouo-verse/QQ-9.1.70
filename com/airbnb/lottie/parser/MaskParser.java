package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MaskParser {
    MaskParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
    
        if (r0.equals(com.tencent.mobileqq.transfile.report.ReportConstant.COSTREPORT_PREFIX) == false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Mask parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z16;
        jsonReader.beginObject();
        Mask.MaskMode maskMode = null;
        AnimatableShapeValue animatableShapeValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        boolean z17 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c16 = 3;
            switch (nextName.hashCode()) {
                case 111:
                    if (nextName.equals("o")) {
                        z16 = false;
                        break;
                    }
                    break;
                case 3588:
                    if (nextName.equals("pt")) {
                        z16 = true;
                        break;
                    }
                    break;
                case 104433:
                    if (nextName.equals("inv")) {
                        z16 = 2;
                        break;
                    }
                    break;
                case 3357091:
                    if (nextName.equals("mode")) {
                        z16 = 3;
                        break;
                    }
                    break;
            }
            z16 = -1;
            switch (z16) {
                case false:
                    animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    break;
                case true:
                    animatableShapeValue = AnimatableValueParser.parseShapeData(jsonReader, lottieComposition);
                    break;
                case true:
                    z17 = jsonReader.nextBoolean();
                    break;
                case true:
                    String nextString = jsonReader.nextString();
                    nextString.hashCode();
                    switch (nextString.hashCode()) {
                        case 97:
                            if (nextString.equals("a")) {
                                c16 = 0;
                                break;
                            }
                            break;
                        case 105:
                            if (nextString.equals("i")) {
                                c16 = 1;
                                break;
                            }
                            break;
                        case 110:
                            if (nextString.equals(DomainData.DOMAIN_NAME)) {
                                c16 = 2;
                                break;
                            }
                            break;
                        case 115:
                            break;
                    }
                    c16 = '\uffff';
                    switch (c16) {
                        case 0:
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                        case 1:
                            lottieComposition.addWarning("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            maskMode = Mask.MaskMode.MASK_MODE_INTERSECT;
                            break;
                        case 2:
                            maskMode = Mask.MaskMode.MASK_MODE_NONE;
                            break;
                        case 3:
                            maskMode = Mask.MaskMode.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            Logger.warning("Unknown mask mode " + nextName + ". Defaulting to Add.");
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new Mask(maskMode, animatableShapeValue, animatableIntegerValue, z17);
    }
}
