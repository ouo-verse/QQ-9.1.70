package com.tencent.map.sdk.utilities.visualization;

import android.graphics.Color;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class Gradient {
    private static final int DEFAULT_COLOR_MAP_SIZE = 1000;
    public final int mColorMapSize;
    public int[] mColors;
    public float[] mStartPoints;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        final int f147596a;

        /* renamed from: b, reason: collision with root package name */
        final int f147597b;

        /* renamed from: c, reason: collision with root package name */
        final float f147598c;

        /* synthetic */ a(Gradient gradient, int i3, int i16, float f16, byte b16) {
            this(i3, i16, f16);
        }

        a(int i3, int i16, float f16) {
            this.f147596a = i3;
            this.f147597b = i16;
            this.f147598c = f16;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, 1000);
    }

    private HashMap<Integer, a> generateColorIntervals() {
        HashMap<Integer, a> hashMap = new HashMap<>();
        if (this.mStartPoints[0] != 0.0f) {
            hashMap.put(0, new a(this, Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0])), this.mColors[0], this.mColorMapSize * this.mStartPoints[0], (byte) 0));
        }
        for (int i3 = 1; i3 < this.mColors.length; i3++) {
            int i16 = i3 - 1;
            Integer valueOf = Integer.valueOf((int) (this.mColorMapSize * this.mStartPoints[i16]));
            int[] iArr = this.mColors;
            int i17 = iArr[i16];
            int i18 = iArr[i3];
            float f16 = this.mColorMapSize;
            float[] fArr = this.mStartPoints;
            hashMap.put(valueOf, new a(this, i17, i18, (fArr[i3] - fArr[i16]) * f16, (byte) 0));
        }
        float[] fArr2 = this.mStartPoints;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int length = fArr2.length - 1;
            Integer valueOf2 = Integer.valueOf((int) (this.mColorMapSize * fArr2[length]));
            int i19 = this.mColors[length];
            hashMap.put(valueOf2, new a(this, i19, i19, this.mColorMapSize * (1.0f - this.mStartPoints[length]), (byte) 0));
        }
        return hashMap;
    }

    static int interpolateColor(int i3, int i16, float f16) {
        int alpha = (int) (((Color.alpha(i16) - Color.alpha(i3)) * f16) + Color.alpha(i3));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i3), Color.green(i3), Color.blue(i3), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i16), Color.green(i16), Color.blue(i16), fArr2);
        float f17 = fArr[0];
        float f18 = fArr2[0];
        if (f17 - f18 > 180.0f) {
            fArr2[0] = f18 + 360.0f;
        } else if (f18 - f17 > 180.0f) {
            fArr[0] = f17 + 360.0f;
        }
        float[] fArr3 = new float[3];
        for (int i17 = 0; i17 < 3; i17++) {
            float f19 = fArr2[i17];
            float f26 = fArr[i17];
            fArr3[i17] = ((f19 - f26) * f16) + f26;
        }
        return Color.HSVToColor(alpha, fArr3);
    }

    public final int[] generateColorMap(double d16) {
        HashMap<Integer, a> generateColorIntervals = generateColorIntervals();
        int[] iArr = new int[this.mColorMapSize];
        a aVar = generateColorIntervals.get(0);
        int i3 = 0;
        for (int i16 = 0; i16 < this.mColorMapSize; i16++) {
            if (generateColorIntervals.containsKey(Integer.valueOf(i16))) {
                aVar = generateColorIntervals.get(Integer.valueOf(i16));
                i3 = i16;
            }
            iArr[i16] = interpolateColor(aVar.f147596a, aVar.f147597b, (i16 - i3) / aVar.f147598c);
        }
        if (d16 != 1.0d) {
            for (int i17 = 0; i17 < this.mColorMapSize; i17++) {
                int i18 = iArr[i17];
                iArr[i17] = Color.argb((int) (Color.alpha(i18) * d16), Color.red(i18), Color.green(i18), Color.blue(i18));
            }
        }
        return iArr;
    }

    public Gradient(int[] iArr, float[] fArr, int i3) {
        if (iArr.length == fArr.length) {
            if (iArr.length != 0) {
                for (int i16 = 1; i16 < fArr.length; i16++) {
                    if (fArr[i16] <= fArr[i16 - 1]) {
                        throw new IllegalArgumentException("startPoints should be in increasing order");
                    }
                }
                this.mColorMapSize = i3;
                int[] iArr2 = new int[iArr.length];
                this.mColors = iArr2;
                this.mStartPoints = new float[fArr.length];
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(fArr, 0, this.mStartPoints, 0, fArr.length);
                return;
            }
            throw new IllegalArgumentException("No colors have been defined");
        }
        throw new IllegalArgumentException("colors and startPoints should be same length");
    }
}
