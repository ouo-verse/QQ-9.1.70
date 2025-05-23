package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.io.IOException;
import java.lang.ref.WeakReference;
import tl.h;

/* loaded from: classes.dex */
class KeyframeParser {
    private static final float MAX_CP_VALUE = 100.0f;
    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    static JsonReader.Options NAMES = JsonReader.Options.of("t", ReportConstant.COSTREPORT_PREFIX, "e", "o", "i", h.F, "to", "ti");
    static JsonReader.Options INTERPOLATOR_NAMES = JsonReader.Options.of(HippyTKDListViewAdapter.X, "y");

    KeyframeParser() {
    }

    @Nullable
    private static WeakReference<Interpolator> getInterpolator(int i3) {
        WeakReference<Interpolator> weakReference;
        synchronized (KeyframeParser.class) {
            weakReference = pathInterpolatorCache().get(i3);
        }
        return weakReference;
    }

    private static Interpolator interpolatorFor(PointF pointF, PointF pointF2) {
        Interpolator interpolator;
        Interpolator linearInterpolator;
        pointF.x = MiscUtils.clamp(pointF.x, -1.0f, 1.0f);
        pointF.y = MiscUtils.clamp(pointF.y, -100.0f, 100.0f);
        pointF2.x = MiscUtils.clamp(pointF2.x, -1.0f, 1.0f);
        float clamp = MiscUtils.clamp(pointF2.y, -100.0f, 100.0f);
        pointF2.y = clamp;
        int hashFor = Utils.hashFor(pointF.x, pointF.y, pointF2.x, clamp);
        WeakReference<Interpolator> interpolator2 = getInterpolator(hashFor);
        if (interpolator2 != null) {
            interpolator = interpolator2.get();
        } else {
            interpolator = null;
        }
        if (interpolator2 == null || interpolator == null) {
            try {
                linearInterpolator = PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e16) {
                if ("The Path cannot loop back on itself.".equals(e16.getMessage())) {
                    linearInterpolator = PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            try {
                putInterpolator(hashFor, new WeakReference(interpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Keyframe<T> parse(JsonReader jsonReader, LottieComposition lottieComposition, float f16, ValueParser<T> valueParser, boolean z16, boolean z17) throws IOException {
        if (z16 && z17) {
            return parseMultiDimensionalKeyframe(lottieComposition, jsonReader, f16, valueParser);
        }
        if (z16) {
            return parseKeyframe(lottieComposition, jsonReader, f16, valueParser);
        }
        return parseStaticValue(jsonReader, f16, valueParser);
    }

    private static <T> Keyframe<T> parseKeyframe(LottieComposition lottieComposition, JsonReader jsonReader, float f16, ValueParser<T> valueParser) throws IOException {
        Interpolator interpolator;
        Interpolator interpolator2;
        T t16;
        jsonReader.beginObject();
        PointF pointF = null;
        T t17 = null;
        T t18 = null;
        PointF pointF2 = null;
        PointF pointF3 = null;
        float f17 = 0.0f;
        boolean z16 = false;
        PointF pointF4 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    f17 = (float) jsonReader.nextDouble();
                    break;
                case 1:
                    t18 = valueParser.parse(jsonReader, f16);
                    break;
                case 2:
                    t17 = valueParser.parse(jsonReader, f16);
                    break;
                case 3:
                    pointF = JsonUtils.jsonToPoint(jsonReader, 1.0f);
                    break;
                case 4:
                    pointF4 = JsonUtils.jsonToPoint(jsonReader, 1.0f);
                    break;
                case 5:
                    if (jsonReader.nextInt() == 1) {
                        z16 = true;
                        break;
                    } else {
                        z16 = false;
                        break;
                    }
                case 6:
                    pointF2 = JsonUtils.jsonToPoint(jsonReader, f16);
                    break;
                case 7:
                    pointF3 = JsonUtils.jsonToPoint(jsonReader, f16);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z16) {
            interpolator2 = LINEAR_INTERPOLATOR;
            t16 = t18;
        } else {
            if (pointF != null && pointF4 != null) {
                interpolator = interpolatorFor(pointF, pointF4);
            } else {
                interpolator = LINEAR_INTERPOLATOR;
            }
            interpolator2 = interpolator;
            t16 = t17;
        }
        Keyframe<T> keyframe = new Keyframe<>(lottieComposition, t18, t16, interpolator2, f17, null);
        keyframe.pathCp1 = pointF2;
        keyframe.pathCp2 = pointF3;
        return keyframe;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0023. Please report as an issue. */
    private static <T> Keyframe<T> parseMultiDimensionalKeyframe(LottieComposition lottieComposition, JsonReader jsonReader, float f16, ValueParser<T> valueParser) throws IOException {
        Interpolator interpolator;
        Interpolator interpolatorFor;
        Interpolator interpolatorFor2;
        T t16;
        PointF pointF;
        Keyframe<T> keyframe;
        PointF pointF2;
        float f17;
        PointF pointF3;
        float f18;
        jsonReader.beginObject();
        PointF pointF4 = null;
        boolean z16 = false;
        PointF pointF5 = null;
        PointF pointF6 = null;
        PointF pointF7 = null;
        T t17 = null;
        PointF pointF8 = null;
        PointF pointF9 = null;
        PointF pointF10 = null;
        float f19 = 0.0f;
        PointF pointF11 = null;
        T t18 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    pointF2 = pointF4;
                    f19 = (float) jsonReader.nextDouble();
                    pointF4 = pointF2;
                    break;
                case 1:
                    pointF2 = pointF4;
                    t17 = valueParser.parse(jsonReader, f16);
                    pointF4 = pointF2;
                    break;
                case 2:
                    pointF2 = pointF4;
                    t18 = valueParser.parse(jsonReader, f16);
                    pointF4 = pointF2;
                    break;
                case 3:
                    pointF2 = pointF4;
                    f17 = f19;
                    PointF pointF12 = pointF11;
                    if (jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float f26 = 0.0f;
                        float f27 = 0.0f;
                        float f28 = 0.0f;
                        float f29 = 0.0f;
                        while (jsonReader.hasNext()) {
                            int selectName = jsonReader.selectName(INTERPOLATOR_NAMES);
                            if (selectName != 0) {
                                if (selectName != 1) {
                                    jsonReader.skipValue();
                                } else {
                                    JsonReader.Token peek = jsonReader.peek();
                                    JsonReader.Token token = JsonReader.Token.NUMBER;
                                    if (peek == token) {
                                        f29 = (float) jsonReader.nextDouble();
                                        f27 = f29;
                                    } else {
                                        jsonReader.beginArray();
                                        f27 = (float) jsonReader.nextDouble();
                                        if (jsonReader.peek() == token) {
                                            f29 = (float) jsonReader.nextDouble();
                                        } else {
                                            f29 = f27;
                                        }
                                        jsonReader.endArray();
                                    }
                                }
                            } else {
                                JsonReader.Token peek2 = jsonReader.peek();
                                JsonReader.Token token2 = JsonReader.Token.NUMBER;
                                if (peek2 == token2) {
                                    f28 = (float) jsonReader.nextDouble();
                                    f26 = f28;
                                } else {
                                    jsonReader.beginArray();
                                    f26 = (float) jsonReader.nextDouble();
                                    if (jsonReader.peek() == token2) {
                                        f28 = (float) jsonReader.nextDouble();
                                    } else {
                                        f28 = f26;
                                    }
                                    jsonReader.endArray();
                                }
                            }
                        }
                        PointF pointF13 = new PointF(f26, f27);
                        PointF pointF14 = new PointF(f28, f29);
                        jsonReader.endObject();
                        pointF8 = pointF14;
                        pointF7 = pointF13;
                        pointF11 = pointF12;
                        f19 = f17;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF5 = JsonUtils.jsonToPoint(jsonReader, f16);
                        f19 = f17;
                        pointF11 = pointF12;
                        pointF4 = pointF2;
                    }
                case 4:
                    if (jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float f36 = 0.0f;
                        float f37 = 0.0f;
                        float f38 = 0.0f;
                        float f39 = 0.0f;
                        while (jsonReader.hasNext()) {
                            PointF pointF15 = pointF11;
                            int selectName2 = jsonReader.selectName(INTERPOLATOR_NAMES);
                            if (selectName2 != 0) {
                                pointF3 = pointF4;
                                if (selectName2 != 1) {
                                    jsonReader.skipValue();
                                } else {
                                    JsonReader.Token peek3 = jsonReader.peek();
                                    JsonReader.Token token3 = JsonReader.Token.NUMBER;
                                    if (peek3 == token3) {
                                        f39 = (float) jsonReader.nextDouble();
                                        f19 = f19;
                                        f37 = f39;
                                    } else {
                                        float f46 = f19;
                                        jsonReader.beginArray();
                                        float nextDouble = (float) jsonReader.nextDouble();
                                        if (jsonReader.peek() == token3) {
                                            f18 = (float) jsonReader.nextDouble();
                                        } else {
                                            f18 = nextDouble;
                                        }
                                        jsonReader.endArray();
                                        f19 = f46;
                                        pointF11 = pointF15;
                                        pointF4 = pointF3;
                                        f39 = f18;
                                        f37 = nextDouble;
                                    }
                                }
                            } else {
                                pointF3 = pointF4;
                                float f47 = f19;
                                JsonReader.Token peek4 = jsonReader.peek();
                                JsonReader.Token token4 = JsonReader.Token.NUMBER;
                                if (peek4 == token4) {
                                    f38 = (float) jsonReader.nextDouble();
                                    f19 = f47;
                                    f36 = f38;
                                } else {
                                    jsonReader.beginArray();
                                    f36 = (float) jsonReader.nextDouble();
                                    if (jsonReader.peek() == token4) {
                                        f38 = (float) jsonReader.nextDouble();
                                    } else {
                                        f38 = f36;
                                    }
                                    jsonReader.endArray();
                                    f19 = f47;
                                }
                            }
                            pointF11 = pointF15;
                            pointF4 = pointF3;
                        }
                        pointF2 = pointF4;
                        f17 = f19;
                        PointF pointF16 = new PointF(f36, f37);
                        PointF pointF17 = new PointF(f38, f39);
                        jsonReader.endObject();
                        pointF10 = pointF17;
                        pointF9 = pointF16;
                        f19 = f17;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF2 = pointF4;
                        pointF6 = JsonUtils.jsonToPoint(jsonReader, f16);
                        pointF4 = pointF2;
                    }
                case 5:
                    if (jsonReader.nextInt() == 1) {
                        z16 = true;
                        break;
                    } else {
                        z16 = false;
                        break;
                    }
                case 6:
                    pointF11 = JsonUtils.jsonToPoint(jsonReader, f16);
                    break;
                case 7:
                    pointF4 = JsonUtils.jsonToPoint(jsonReader, f16);
                    break;
                default:
                    pointF2 = pointF4;
                    jsonReader.skipValue();
                    pointF4 = pointF2;
                    break;
            }
        }
        PointF pointF18 = pointF4;
        float f48 = f19;
        PointF pointF19 = pointF11;
        jsonReader.endObject();
        if (z16) {
            interpolator = LINEAR_INTERPOLATOR;
            t16 = t17;
        } else {
            if (pointF5 != null && pointF6 != null) {
                interpolator = interpolatorFor(pointF5, pointF6);
            } else {
                if (pointF7 != null && pointF8 != null && pointF9 != null && pointF10 != null) {
                    interpolatorFor = interpolatorFor(pointF7, pointF9);
                    interpolatorFor2 = interpolatorFor(pointF8, pointF10);
                    t16 = t18;
                    interpolator = null;
                    if (interpolatorFor == null && interpolatorFor2 != null) {
                        pointF = pointF19;
                        keyframe = new Keyframe<>(lottieComposition, t17, t16, interpolatorFor, interpolatorFor2, f48, null);
                    } else {
                        pointF = pointF19;
                        keyframe = new Keyframe<>(lottieComposition, t17, t16, interpolator, f48, null);
                    }
                    keyframe.pathCp1 = pointF;
                    keyframe.pathCp2 = pointF18;
                    return keyframe;
                }
                interpolator = LINEAR_INTERPOLATOR;
            }
            t16 = t18;
        }
        interpolatorFor = null;
        interpolatorFor2 = null;
        if (interpolatorFor == null) {
        }
        pointF = pointF19;
        keyframe = new Keyframe<>(lottieComposition, t17, t16, interpolator, f48, null);
        keyframe.pathCp1 = pointF;
        keyframe.pathCp2 = pointF18;
        return keyframe;
    }

    private static <T> Keyframe<T> parseStaticValue(JsonReader jsonReader, float f16, ValueParser<T> valueParser) throws IOException {
        return new Keyframe<>(valueParser.parse(jsonReader, f16));
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache() {
        if (pathInterpolatorCache == null) {
            pathInterpolatorCache = new SparseArrayCompat<>();
        }
        return pathInterpolatorCache;
    }

    private static void putInterpolator(int i3, WeakReference<Interpolator> weakReference) {
        synchronized (KeyframeParser.class) {
            pathInterpolatorCache.put(i3, weakReference);
        }
    }
}
