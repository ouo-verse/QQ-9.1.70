package com.tencent.ecommerce.richtext.utils;

import android.graphics.LinearGradient;
import android.graphics.PointF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    private static double a(int i3) {
        return Math.tan(Math.toRadians(i3));
    }

    private static PointF[] b(int i3, float f16, float f17) {
        PointF pointF = new PointF();
        PointF pointF2 = new PointF();
        float f18 = f16 / 2.0f;
        double d16 = f18;
        double d17 = f17;
        float a16 = (float) (((a(i3) * d17) / 2.0d) + d16);
        pointF2.x = a16;
        pointF2.y = 0.0f;
        if (a16 > f16) {
            pointF2.x = f16;
            pointF2.y = (float) ((f17 / 2.0f) - (d16 / a(i3)));
        }
        float a17 = f18 - ((float) ((a(i3) * d17) / 2.0d));
        pointF.x = a17;
        pointF.y = f17;
        if (a17 < 0.0f) {
            pointF.x = 0.0f;
            pointF.y = (float) ((f17 / 2.0f) + (d16 / a(i3)));
        }
        return new PointF[]{pointF, pointF2};
    }

    private static PointF[] c(float f16, float f17) {
        PointF pointF = new PointF();
        PointF pointF2 = new PointF();
        float f18 = f16 / 2.0f;
        pointF.x = f18;
        pointF.y = 0.0f;
        pointF2.x = f18;
        pointF2.y = f17;
        return new PointF[]{pointF, pointF2};
    }

    private static PointF[] d(int i3, float f16, float f17) {
        PointF[] b16 = b(i3 - 180, f16, f17);
        return new PointF[]{b16[1], b16[0]};
    }

    private static PointF[] e(float f16, float f17) {
        PointF[] g16 = g(f16, f17);
        return new PointF[]{g16[1], g16[0]};
    }

    private static PointF[] f(int i3, float f16, float f17) {
        PointF[] h16 = h(i3 - 180, f16, f17);
        return new PointF[]{h16[1], h16[0]};
    }

    private static PointF[] g(float f16, float f17) {
        PointF pointF = new PointF();
        PointF pointF2 = new PointF();
        pointF.x = 0.0f;
        float f18 = f17 / 2.0f;
        pointF.y = f18;
        pointF2.x = f16;
        pointF2.y = f18;
        return new PointF[]{pointF, pointF2};
    }

    private static PointF[] h(int i3, float f16, float f17) {
        PointF pointF = new PointF();
        PointF pointF2 = new PointF();
        float f18 = f17 / 2.0f;
        double d16 = f18;
        int i16 = i3 - 90;
        float a16 = (float) (((a(i16) * f16) / 2.0d) + d16);
        pointF2.y = a16;
        pointF2.x = f16;
        if (a16 > f17) {
            pointF2.y = f17;
            pointF2.x = (float) ((f16 / 2.0f) + (d16 / a(i16)));
        }
        float f19 = f16 / 2.0f;
        float tan = f18 - ((float) (f19 * Math.tan(Math.toRadians(i16))));
        pointF.y = tan;
        pointF.x = 0.0f;
        if (tan < 0.0f) {
            pointF.y = 0.0f;
            pointF.x = f19 - ((float) (d16 / a(i16)));
        }
        return new PointF[]{pointF, pointF2};
    }

    private static PointF[] i(int i3, float f16, float f17) {
        return f(i3 + 360, f16, f17);
    }

    private static PointF[] j(float f16, float f17) {
        return c(f16, f17);
    }

    private static PointF[] k(int i3, float f16, float f17) {
        return h(i3 + 360, f16, f17);
    }

    private static PointF[] l(float f16, float f17) {
        return g(f16, f17);
    }

    private static PointF[] m(int i3, float f16, float f17) {
        return b(i3 + 360, f16, f17);
    }

    private static PointF[] n(float f16, float f17) {
        return e(f16, f17);
    }

    private static PointF[] o(int i3, float f16, float f17) {
        return d(i3 + 360, f16, f17);
    }

    private static PointF[] p(int i3, float f16, float f17) {
        if (i3 == -90) {
            return n(f16, f17);
        }
        if (i3 == -180) {
            return j(f16, f17);
        }
        if (i3 == -270) {
            return l(f16, f17);
        }
        if (-90 < i3) {
            return i(i3, f16, f17);
        }
        if (-180 < i3) {
            return o(i3, f16, f17);
        }
        if (-270 < i3) {
            return k(i3, f16, f17);
        }
        return m(i3, f16, f17);
    }

    private static PointF[] q(int i3, float f16, float f17) {
        if (i3 == 90) {
            return g(f16, f17);
        }
        if (i3 == 180) {
            return c(f16, f17);
        }
        if (i3 == 270) {
            return e(f16, f17);
        }
        if (i3 < 90) {
            return b(i3, f16, f17);
        }
        if (i3 < 180) {
            return h(i3, f16, f17);
        }
        if (i3 < 270) {
            return d(i3, f16, f17);
        }
        return f(i3, f16, f17);
    }

    private static Pair<int[], float[]> r(String[] strArr, int i3) {
        int i16;
        if (strArr != null && strArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                if (i3 >= strArr.length) {
                    break;
                }
                String trim = strArr[i3].trim();
                if (trim.contains("rgba")) {
                    trim = w(strArr, i3, 4, arrayList2);
                    i3 += 3;
                } else if (trim.contains("rgb")) {
                    trim = w(strArr, i3, 3, arrayList2);
                    i3 += 2;
                } else if (trim.contains("%")) {
                    String[] x16 = x(trim);
                    String str = x16[0];
                    arrayList2.add(x16[1]);
                    trim = str;
                }
                arrayList.add(trim);
                i3++;
            }
            int size = arrayList.size();
            int[] iArr = new int[size];
            for (int i17 = 0; i17 < size; i17++) {
                iArr[i17] = a.c((String) arrayList.get(i17));
            }
            if (!arrayList2.isEmpty() && arrayList2.size() != arrayList.size()) {
                if (arrayList2.size() == 1 && (arrayList2.contains("0") || arrayList2.contains("100"))) {
                    arrayList2.clear();
                } else if (arrayList2.size() == 2 && arrayList2.contains("0") && arrayList2.contains("100")) {
                    arrayList2.clear();
                } else {
                    if (!arrayList2.contains("0")) {
                        arrayList2.add(0, "0");
                    }
                    if (arrayList2.size() != arrayList.size() && !arrayList2.contains("100")) {
                        arrayList2.add(arrayList2.size(), "100");
                    }
                }
            }
            int size2 = arrayList2.size();
            float[] fArr = new float[size2];
            for (i16 = 0; i16 < size2; i16++) {
                fArr[i16] = Integer.parseInt((String) arrayList2.get(i16)) / 100.0f;
            }
            return new Pair<>(iArr, fArr);
        }
        return null;
    }

    private static PointF[] s(String str, float f16, float f17) {
        if (!TextUtils.isEmpty(str) && str.contains("deg")) {
            int parseInt = Integer.parseInt(str.substring(0, str.indexOf("deg"))) % 360;
            if (parseInt >= 0) {
                return q(parseInt, f16, f17);
            }
            return p(parseInt, f16, f17);
        }
        return null;
    }

    private static PointF[] t(String str, float f16, float f17) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -2080783504:
                if (str.equals("to bottom")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1213049204:
                if (str.equals("to left")) {
                    c16 = 1;
                    break;
                }
                break;
            case -870406608:
                if (str.equals("to top")) {
                    c16 = 2;
                    break;
                }
                break;
            case -677950924:
                if (str.equals("to right bottom")) {
                    c16 = 3;
                    break;
                }
                break;
            case 926430700:
                if (str.equals("to right top")) {
                    c16 = 4;
                    break;
                }
                break;
            case 1055841335:
                if (str.equals("to right")) {
                    c16 = 5;
                    break;
                }
                break;
            case 1381793217:
                if (str.equals("to left top")) {
                    c16 = 6;
                    break;
                }
                break;
            case 1520072255:
                if (str.equals("to left bottom")) {
                    c16 = 7;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return c(f16, f17);
            case 1:
                return e(f16, f17);
            case 2:
                return b(0, f16, f17);
            case 3:
                return h(135, f16, f17);
            case 4:
                return b(45, f16, f17);
            case 5:
                return g(f16, f17);
            case 6:
                return f(315, f16, f17);
            case 7:
                return d(225, f16, f17);
            default:
                return null;
        }
    }

    public static LinearGradient u(Object obj, lk0.b bVar) {
        if (bVar == null) {
            return null;
        }
        return v(e.p(obj, null), bVar.j(), bVar.i());
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static LinearGradient v(String str, float f16, float f17) {
        PointF[] t16;
        boolean z16;
        int i3;
        int[] iArr;
        float[] fArr;
        float[] fArr2;
        if (TextUtils.isEmpty(str) || !str.contains("linear-gradient(")) {
            return null;
        }
        String[] split = str.substring(str.indexOf(40) + 1, str.lastIndexOf(41)).split(",");
        if (split.length <= 1) {
            return null;
        }
        String str2 = split[0];
        if (str2.contains("to")) {
            t16 = t(str2, f16, f17);
        } else if (str2.contains("deg")) {
            t16 = s(str2, f16, f17);
        } else {
            t16 = t("to bottom", f16, f17);
            z16 = true;
            if (!z16) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            Pair<int[], float[]> r16 = r(split, i3);
            iArr = (int[]) r16.first;
            fArr = (float[]) r16.second;
            if (t16 != null && iArr != null && iArr.length >= 1) {
                if (fArr.length == 0) {
                    fArr2 = fArr;
                } else {
                    fArr2 = null;
                }
                PointF pointF = t16[0];
                float f18 = pointF.x;
                float f19 = pointF.y;
                PointF pointF2 = t16[1];
                return new LinearGradient(f18, f19, pointF2.x, pointF2.y, iArr, fArr2, Shader.TileMode.CLAMP);
            }
            return null;
        }
        z16 = false;
        if (!z16) {
        }
        Pair<int[], float[]> r162 = r(split, i3);
        iArr = (int[]) r162.first;
        fArr = (float[]) r162.second;
        if (t16 != null) {
            if (fArr.length == 0) {
            }
            PointF pointF3 = t16[0];
            float f182 = pointF3.x;
            float f192 = pointF3.y;
            PointF pointF22 = t16[1];
            return new LinearGradient(f182, f192, pointF22.x, pointF22.y, iArr, fArr2, Shader.TileMode.CLAMP);
        }
        return null;
    }

    private static String w(String[] strArr, int i3, int i16, List<String> list) {
        int i17;
        if (strArr != null && strArr.length >= (i17 = i16 + i3)) {
            StringBuilder sb5 = new StringBuilder();
            for (int i18 = i3; i18 < i17; i18++) {
                String trim = strArr[i18].trim();
                if (trim.contains("%")) {
                    String[] x16 = x(trim);
                    sb5.append(",");
                    sb5.append(x16[0]);
                    list.add(x16[1]);
                } else if (i18 != i3) {
                    sb5.append(',');
                    sb5.append(trim);
                } else {
                    sb5.append(trim);
                }
            }
            return sb5.toString();
        }
        return null;
    }

    private static String[] x(String str) {
        String[] strArr = new String[2];
        for (String str2 : str.trim().split(" ")) {
            if (!TextUtils.isEmpty(str2.trim())) {
                if (str2.contains("%")) {
                    strArr[1] = str2.substring(0, str2.length() - 1);
                } else {
                    strArr[0] = str2;
                }
            }
        }
        return strArr;
    }
}
