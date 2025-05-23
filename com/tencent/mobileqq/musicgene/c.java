package com.tencent.mobileqq.musicgene;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    private static float[] a(List<float[]> list) {
        if (list.size() > 4) {
            float f16 = Float.MAX_VALUE;
            float[] fArr = null;
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3)[2] < f16) {
                    f16 = list.get(i3)[2];
                    fArr = list.get(i3);
                }
            }
            float f17 = fArr[2];
            if (f17 > 0.15d) {
                fArr[2] = f17 - 0.1f;
            }
            float f18 = fArr[1];
            if (f18 > 0.5d) {
                fArr[1] = f18 - 0.1f;
            }
            return fArr;
        }
        float[] fArr2 = list.get(0);
        fArr2[2] = 0.15f;
        return fArr2;
    }

    private static List<float[]> b(float[][] fArr) {
        int i3;
        int[] iArr = new int[8];
        HashMap hashMap = new HashMap();
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i17 >= fArr.length) {
                break;
            }
            int i18 = 1;
            while (true) {
                if (i18 > 7) {
                    break;
                }
                if (fArr[i17][0] < (i18 / 7.0f) * 360.0f) {
                    iArr[i18] = iArr[i18] + 1;
                    List list = (List) hashMap.get(Integer.valueOf(i18));
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(fArr[i17]);
                    hashMap.put(Integer.valueOf(i18), list);
                } else {
                    i18++;
                }
            }
            i17++;
        }
        int i19 = -1;
        for (i3 = 1; i3 <= 7; i3++) {
            int i26 = iArr[i3];
            if (i26 > i16) {
                i16 = i26;
                i19 = i3;
            }
        }
        if (hashMap.containsKey(Integer.valueOf(i19))) {
            return (List) hashMap.get(Integer.valueOf(i19));
        }
        return new ArrayList();
    }

    private static int[] c(Bitmap bitmap) {
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, 4, 4, false);
        int[] iArr = new int[16];
        createScaledBitmap.getPixels(iArr, 0, 4, 0, 0, 4, 4);
        return iArr;
    }

    public static int[] d(int i3) {
        float[] fArr = new float[3];
        Color.colorToHSV(i3, fArr);
        float[] fArr2 = new float[3];
        g(fArr, fArr2);
        return new int[]{Color.HSVToColor(fArr), Color.HSVToColor(fArr2)};
    }

    public static int[] e(Bitmap bitmap) {
        float[] a16 = a(b(f(c(bitmap))));
        float[] fArr = new float[3];
        h(a16, fArr);
        return new int[]{Color.HSVToColor(a16), Color.HSVToColor(fArr)};
    }

    private static float[][] f(int[] iArr) {
        float[][] fArr = new float[16];
        for (int i3 = 0; i3 < 16; i3++) {
            float[] fArr2 = new float[3];
            fArr[i3] = fArr2;
            Color.colorToHSV(iArr[i3], fArr2);
        }
        return fArr;
    }

    private static void g(float[] fArr, float[] fArr2) {
        float f16 = fArr[2];
        if (f16 <= 0.15d) {
            fArr2[0] = fArr[0];
            fArr2[1] = fArr[1];
            fArr2[2] = f16 + 0.7f;
        } else {
            fArr2[0] = fArr[0];
            fArr2[1] = fArr[1];
            if (f16 + 0.5d >= 1.0d) {
                fArr2[2] = f16 - 0.5f;
            } else {
                fArr2[2] = f16 + 0.5f;
            }
        }
        float f17 = fArr2[1];
        if (f17 > 0.5f) {
            fArr2[1] = f17 - 0.1f;
        }
    }

    private static void h(float[] fArr, float[] fArr2) {
        float f16;
        float f17 = fArr[0];
        float f18 = fArr[1];
        float f19 = fArr[2];
        double d16 = f19;
        if (d16 <= 0.15d) {
            f16 = f19 + 0.7f;
        } else if (d16 <= 0.5d) {
            f16 = f19 + 0.5f;
        } else {
            f16 = f19 - 0.5f;
        }
        if (f18 >= 0.5f) {
            f18 -= 0.1f;
        }
        fArr2[0] = f17;
        fArr2[1] = f18;
        fArr2[2] = f16;
    }
}
