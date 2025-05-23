package com.airbnb.lottie.parser;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ContentModelParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of(AdParam.TY, "d");

    ContentModelParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00cf, code lost:
    
        if (r2.equals("gf") == false) goto L16;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ContentModel parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ContentModel contentModel;
        String str;
        jsonReader.beginObject();
        char c16 = 2;
        int i3 = 2;
        while (true) {
            contentModel = null;
            if (jsonReader.hasNext()) {
                int selectName = jsonReader.selectName(NAMES);
                if (selectName != 0) {
                    if (selectName != 1) {
                        jsonReader.skipName();
                        jsonReader.skipValue();
                    } else {
                        i3 = jsonReader.nextInt();
                    }
                } else {
                    str = jsonReader.nextString();
                    break;
                }
            } else {
                str = null;
                break;
            }
        }
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case 3239:
                if (str.equals("el")) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case 3270:
                if (str.equals("fl")) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case 3295:
                break;
            case 3307:
                if (str.equals("gr")) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            case 3308:
                if (str.equals("gs")) {
                    c16 = 4;
                    break;
                }
                c16 = '\uffff';
                break;
            case 3488:
                if (str.equals("mm")) {
                    c16 = 5;
                    break;
                }
                c16 = '\uffff';
                break;
            case 3633:
                if (str.equals("rc")) {
                    c16 = 6;
                    break;
                }
                c16 = '\uffff';
                break;
            case 3634:
                if (str.equals("rd")) {
                    c16 = 7;
                    break;
                }
                c16 = '\uffff';
                break;
            case 3646:
                if (str.equals("rp")) {
                    c16 = '\b';
                    break;
                }
                c16 = '\uffff';
                break;
            case 3669:
                if (str.equals("sh")) {
                    c16 = '\t';
                    break;
                }
                c16 = '\uffff';
                break;
            case 3679:
                if (str.equals("sr")) {
                    c16 = '\n';
                    break;
                }
                c16 = '\uffff';
                break;
            case 3681:
                if (str.equals("st")) {
                    c16 = 11;
                    break;
                }
                c16 = '\uffff';
                break;
            case 3705:
                if (str.equals(TVKLiveRequestBuilder.RequestParamKey.CKEY_TIMESTAMP)) {
                    c16 = '\f';
                    break;
                }
                c16 = '\uffff';
                break;
            case 3710:
                if (str.equals(ReportConstant.COSTREPORT_TRANS)) {
                    c16 = '\r';
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
                contentModel = CircleShapeParser.parse(jsonReader, lottieComposition, i3);
                break;
            case 1:
                contentModel = ShapeFillParser.parse(jsonReader, lottieComposition);
                break;
            case 2:
                contentModel = GradientFillParser.parse(jsonReader, lottieComposition);
                break;
            case 3:
                contentModel = ShapeGroupParser.parse(jsonReader, lottieComposition);
                break;
            case 4:
                contentModel = GradientStrokeParser.parse(jsonReader, lottieComposition);
                break;
            case 5:
                contentModel = MergePathsParser.parse(jsonReader);
                lottieComposition.addWarning("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                contentModel = RectangleShapeParser.parse(jsonReader, lottieComposition);
                break;
            case 7:
                contentModel = RoundedCornersParser.parse(jsonReader, lottieComposition);
                break;
            case '\b':
                contentModel = RepeaterParser.parse(jsonReader, lottieComposition);
                break;
            case '\t':
                contentModel = ShapePathParser.parse(jsonReader, lottieComposition);
                break;
            case '\n':
                contentModel = PolystarShapeParser.parse(jsonReader, lottieComposition, i3);
                break;
            case 11:
                contentModel = ShapeStrokeParser.parse(jsonReader, lottieComposition);
                break;
            case '\f':
                contentModel = ShapeTrimPathParser.parse(jsonReader, lottieComposition);
                break;
            case '\r':
                contentModel = AnimatableTransformParser.parse(jsonReader, lottieComposition);
                break;
            default:
                Logger.warning("Unknown shape type " + str);
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return contentModel;
    }
}
