package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.ads.data.AdParam;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import tl.h;

/* loaded from: classes.dex */
public class LayerParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "ind", "refId", AdParam.TY, HippyNestedScrollComponent.PRIORITY_PARENT, "sw", "sh", "sc", "ks", TtmlNode.TAG_TT, "masksProperties", "shapes", "t", "ef", "sr", "st", "w", h.F, "ip", "op", TVKLiveRequestBuilder.RequestParamKey.CKEY_TIMESTAMP, "cl", "hd");
    private static final JsonReader.Options TEXT_NAMES = JsonReader.Options.of("d", "a");
    private static final JsonReader.Options EFFECTS_NAMES = JsonReader.Options.of(AdParam.TY, "nm");

    /* renamed from: com.airbnb.lottie.parser.LayerParser$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType = iArr;
            try {
                iArr[Layer.MatteType.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[Layer.MatteType.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    LayerParser() {
    }

    public static Layer parse(LottieComposition lottieComposition) {
        Rect bounds = lottieComposition.getBounds();
        return new Layer(Collections.emptyList(), lottieComposition, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new AnimatableTransform(), 0, 0, 0, 0.0f, 0.0f, bounds.width(), bounds.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false, null, null);
    }

    public static Layer parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        float f16;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.beginObject();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        Layer.MatteType matteType2 = matteType;
        Layer.LayerType layerType = null;
        String str = null;
        AnimatableTransform animatableTransform = null;
        AnimatableTextFrame animatableTextFrame = null;
        AnimatableTextProperties animatableTextProperties = null;
        AnimatableFloatValue animatableFloatValue = null;
        BlurEffect blurEffect = null;
        DropShadowEffect dropShadowEffect = null;
        long j3 = 0;
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        boolean z16 = false;
        float f17 = 1.0f;
        long j16 = -1;
        float f18 = 0.0f;
        float f19 = 0.0f;
        float f26 = 0.0f;
        String str2 = "UNSET";
        String str3 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    str2 = jsonReader.nextString();
                    break;
                case 1:
                    j3 = jsonReader.nextInt();
                    break;
                case 2:
                    str = jsonReader.nextString();
                    break;
                case 3:
                    int nextInt = jsonReader.nextInt();
                    layerType = Layer.LayerType.UNKNOWN;
                    if (nextInt >= layerType.ordinal()) {
                        break;
                    } else {
                        layerType = Layer.LayerType.values()[nextInt];
                        break;
                    }
                case 4:
                    j16 = jsonReader.nextInt();
                    break;
                case 5:
                    i3 = (int) (jsonReader.nextInt() * Utils.dpScale());
                    break;
                case 6:
                    i16 = (int) (jsonReader.nextInt() * Utils.dpScale());
                    break;
                case 7:
                    i17 = Color.parseColor(jsonReader.nextString());
                    break;
                case 8:
                    animatableTransform = AnimatableTransformParser.parse(jsonReader, lottieComposition);
                    break;
                case 9:
                    int nextInt2 = jsonReader.nextInt();
                    if (nextInt2 >= Layer.MatteType.values().length) {
                        lottieComposition.addWarning("Unsupported matte type: " + nextInt2);
                        break;
                    } else {
                        matteType2 = Layer.MatteType.values()[nextInt2];
                        int i26 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[matteType2.ordinal()];
                        if (i26 == 1) {
                            lottieComposition.addWarning("Unsupported matte type: Luma");
                        } else if (i26 == 2) {
                            lottieComposition.addWarning("Unsupported matte type: Luma Inverted");
                        }
                        lottieComposition.incrementMatteOrMaskCount(1);
                        break;
                    }
                case 10:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList3.add(MaskParser.parse(jsonReader, lottieComposition));
                    }
                    lottieComposition.incrementMatteOrMaskCount(arrayList3.size());
                    jsonReader.endArray();
                    break;
                case 11:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        ContentModel parse = ContentModelParser.parse(jsonReader, lottieComposition);
                        if (parse != null) {
                            arrayList4.add(parse);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case 12:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        int selectName = jsonReader.selectName(TEXT_NAMES);
                        if (selectName == 0) {
                            animatableTextFrame = AnimatableValueParser.parseDocumentData(jsonReader, lottieComposition);
                        } else if (selectName != 1) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        } else {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                animatableTextProperties = AnimatableTextPropertiesParser.parse(jsonReader, lottieComposition);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 13:
                    jsonReader.beginArray();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            int selectName2 = jsonReader.selectName(EFFECTS_NAMES);
                            if (selectName2 == 0) {
                                int nextInt3 = jsonReader.nextInt();
                                if (nextInt3 == 29) {
                                    blurEffect = BlurEffectParser.parse(jsonReader, lottieComposition);
                                } else if (nextInt3 == 25) {
                                    dropShadowEffect = new DropShadowEffectParser().parse(jsonReader, lottieComposition);
                                }
                            } else if (selectName2 != 1) {
                                jsonReader.skipName();
                                jsonReader.skipValue();
                            } else {
                                arrayList5.add(jsonReader.nextString());
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    lottieComposition.addWarning("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    f17 = (float) jsonReader.nextDouble();
                    break;
                case 15:
                    f19 = (float) jsonReader.nextDouble();
                    break;
                case 16:
                    i18 = (int) (jsonReader.nextInt() * Utils.dpScale());
                    break;
                case 17:
                    i19 = (int) (jsonReader.nextInt() * Utils.dpScale());
                    break;
                case 18:
                    f18 = (float) jsonReader.nextDouble();
                    break;
                case 19:
                    f26 = (float) jsonReader.nextDouble();
                    break;
                case 20:
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 21:
                    str3 = jsonReader.nextString();
                    break;
                case 22:
                    z16 = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        ArrayList arrayList6 = new ArrayList();
        if (f18 > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new Keyframe(lottieComposition, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f18)));
            f16 = 0.0f;
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            f16 = 0.0f;
        }
        if (f26 <= f16) {
            f26 = lottieComposition.getEndFrame();
        }
        arrayList2.add(new Keyframe(lottieComposition, valueOf, valueOf, null, f18, Float.valueOf(f26)));
        arrayList2.add(new Keyframe(lottieComposition, valueOf2, valueOf2, null, f26, Float.valueOf(Float.MAX_VALUE)));
        if (str2.endsWith(".ai") || "ai".equals(str3)) {
            lottieComposition.addWarning("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList4, lottieComposition, str2, j3, layerType, j16, str, arrayList, animatableTransform, i3, i16, i17, f17, f19, i18, i19, animatableTextFrame, animatableTextProperties, arrayList2, matteType2, animatableFloatValue, z16, blurEffect, dropShadowEffect);
    }
}
