package com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class GradientColorParser implements ValueParser<GradientColor> {
    private int colorPoints;

    public GradientColorParser(int i3) {
        this.colorPoints = i3;
    }

    private GradientColor addOpacityStopsToGradientIfNeeded(GradientColor gradientColor, List<Float> list) {
        int i3 = this.colorPoints * 4;
        if (list.size() <= i3) {
            return gradientColor;
        }
        float[] positions = gradientColor.getPositions();
        int[] colors = gradientColor.getColors();
        int size = (list.size() - i3) / 2;
        float[] fArr = new float[size];
        float[] fArr2 = new float[size];
        int i16 = 0;
        while (i3 < list.size()) {
            if (i3 % 2 == 0) {
                fArr[i16] = list.get(i3).floatValue();
            } else {
                fArr2[i16] = list.get(i3).floatValue();
                i16++;
            }
            i3++;
        }
        float[] mergeUniqueElements = mergeUniqueElements(gradientColor.getPositions(), fArr);
        int length = mergeUniqueElements.length;
        int[] iArr = new int[length];
        for (int i17 = 0; i17 < length; i17++) {
            float f16 = mergeUniqueElements[i17];
            int binarySearch = Arrays.binarySearch(positions, f16);
            int binarySearch2 = Arrays.binarySearch(fArr, f16);
            if (binarySearch >= 0 && binarySearch2 <= 0) {
                iArr[i17] = getColorInBetweenOpacityStops(f16, colors[binarySearch], fArr, fArr2);
            } else {
                if (binarySearch2 < 0) {
                    binarySearch2 = -(binarySearch2 + 1);
                }
                iArr[i17] = getColorInBetweenColorStops(f16, fArr2[binarySearch2], positions, colors);
            }
        }
        return new GradientColor(mergeUniqueElements, iArr);
    }

    private int getColorInBetweenColorStops(float f16, float f17, float[] fArr, int[] iArr) {
        if (iArr.length >= 2 && f16 != fArr[0]) {
            for (int i3 = 1; i3 < fArr.length; i3++) {
                float f18 = fArr[i3];
                if (f18 >= f16 || i3 == fArr.length - 1) {
                    int i16 = i3 - 1;
                    float f19 = fArr[i16];
                    float f26 = (f16 - f19) / (f18 - f19);
                    int i17 = iArr[i3];
                    int i18 = iArr[i16];
                    return Color.argb((int) (f17 * 255.0f), MiscUtils.lerp(Color.red(i18), Color.red(i17), f26), MiscUtils.lerp(Color.green(i18), Color.green(i17), f26), MiscUtils.lerp(Color.blue(i18), Color.blue(i17), f26));
                }
            }
            throw new IllegalArgumentException("Unreachable code.");
        }
        return iArr[0];
    }

    private int getColorInBetweenOpacityStops(float f16, int i3, float[] fArr, float[] fArr2) {
        float lerp;
        if (fArr2.length >= 2 && f16 > fArr[0]) {
            for (int i16 = 1; i16 < fArr.length; i16++) {
                float f17 = fArr[i16];
                if (f17 >= f16 || i16 == fArr.length - 1) {
                    if (f17 <= f16) {
                        lerp = fArr2[i16];
                    } else {
                        int i17 = i16 - 1;
                        float f18 = fArr[i17];
                        lerp = MiscUtils.lerp(fArr2[i17], fArr2[i16], (f16 - f18) / (f17 - f18));
                    }
                    return Color.argb((int) (lerp * 255.0f), Color.red(i3), Color.green(i3), Color.blue(i3));
                }
            }
            throw new IllegalArgumentException("Unreachable code.");
        }
        return Color.argb((int) (fArr2[0] * 255.0f), Color.red(i3), Color.green(i3), Color.blue(i3));
    }

    protected static float[] mergeUniqueElements(float[] fArr, float[] fArr2) {
        float f16;
        if (fArr.length == 0) {
            return fArr2;
        }
        if (fArr2.length == 0) {
            return fArr;
        }
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < length; i18++) {
            float f17 = Float.NaN;
            if (i16 < fArr.length) {
                f16 = fArr[i16];
            } else {
                f16 = Float.NaN;
            }
            if (i17 < fArr2.length) {
                f17 = fArr2[i17];
            }
            if (!Float.isNaN(f17) && f16 >= f17) {
                if (!Float.isNaN(f16) && f17 >= f16) {
                    fArr3[i18] = f16;
                    i16++;
                    i17++;
                    i3++;
                } else {
                    fArr3[i18] = f17;
                    i17++;
                }
            } else {
                fArr3[i18] = f16;
                i16++;
            }
        }
        if (i3 == 0) {
            return fArr3;
        }
        return Arrays.copyOf(fArr3, length - i3);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public GradientColor parse(JsonReader jsonReader, float f16) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z16 = jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY;
        if (z16) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (arrayList.size() == 4 && arrayList.get(0).floatValue() == 1.0f) {
            arrayList.set(0, Float.valueOf(0.0f));
            arrayList.add(Float.valueOf(1.0f));
            arrayList.add(arrayList.get(1));
            arrayList.add(arrayList.get(2));
            arrayList.add(arrayList.get(3));
            this.colorPoints = 2;
        }
        if (z16) {
            jsonReader.endArray();
        }
        if (this.colorPoints == -1) {
            this.colorPoints = arrayList.size() / 4;
        }
        int i3 = this.colorPoints;
        float[] fArr = new float[i3];
        int[] iArr = new int[i3];
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < this.colorPoints * 4; i18++) {
            int i19 = i18 / 4;
            double floatValue = arrayList.get(i18).floatValue();
            int i26 = i18 % 4;
            if (i26 == 0) {
                if (i19 > 0) {
                    float f17 = (float) floatValue;
                    if (fArr[i19 - 1] >= f17) {
                        fArr[i19] = f17 + 0.01f;
                    }
                }
                fArr[i19] = (float) floatValue;
            } else if (i26 == 1) {
                i16 = (int) (floatValue * 255.0d);
            } else if (i26 == 2) {
                i17 = (int) (floatValue * 255.0d);
            } else if (i26 == 3) {
                iArr[i19] = Color.argb(255, i16, i17, (int) (floatValue * 255.0d));
            }
        }
        return addOpacityStopsToGradientIfNeeded(new GradientColor(fArr, iArr), arrayList);
    }
}
