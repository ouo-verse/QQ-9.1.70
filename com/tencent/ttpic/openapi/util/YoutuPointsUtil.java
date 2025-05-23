package com.tencent.ttpic.openapi.util;

import android.graphics.PointF;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes27.dex */
public class YoutuPointsUtil {
    private static final int LEN_83 = 166;
    private static final int LEN_90 = 180;

    private static void adjustEyeFeatureFloat(float[] fArr) {
        fArr[40] = (float) (fArr[38] + ((fArr[40] - r0) * 0.98d));
        fArr[41] = (float) (fArr[37] + ((fArr[41] - r0) * 0.95d));
        fArr[42] = (float) (fArr[36] + ((fArr[42] - r0) * 0.9d));
        fArr[50] = (float) (fArr[48] + ((fArr[50] - r0) * 0.98d));
        fArr[51] = (float) (fArr[47] + ((fArr[51] - r0) * 0.95d));
        fArr[52] = (float) (fArr[46] + ((fArr[52] - r0) * 0.9d));
        fArr[35] = (float) (fArr[35] + ((fArr[39] - r1) / 40.0d));
    }

    private static void adjustEyeFeatureV2(PointF[] pointFArr) {
        PointF pointF = pointFArr[40];
        PointF pointF2 = pointFArr[38];
        pointF.x = (float) (pointF2.x + ((pointF.x - r2) * 0.98d));
        pointF.y = (float) (pointF2.y + ((pointF.y - r1) * 0.98d));
        PointF pointF3 = pointFArr[41];
        PointF pointF4 = pointFArr[37];
        pointF3.x = (float) (pointF4.x + ((pointF3.x - r2) * 0.95d));
        pointF3.y = (float) (pointF4.y + ((pointF3.y - r1) * 0.95d));
        PointF pointF5 = pointFArr[42];
        PointF pointF6 = pointFArr[36];
        pointF5.x = (float) (pointF6.x + ((pointF5.x - r2) * 0.9d));
        pointF5.y = (float) (pointF6.y + ((pointF5.y - r1) * 0.9d));
        PointF pointF7 = pointFArr[50];
        PointF pointF8 = pointFArr[48];
        pointF7.x = (float) (pointF8.x + ((pointF7.x - r2) * 0.98d));
        pointF7.y = (float) (pointF8.y + ((pointF7.y - r1) * 0.98d));
        PointF pointF9 = pointFArr[51];
        PointF pointF10 = pointFArr[47];
        pointF9.x = (float) (pointF10.x + ((pointF9.x - r2) * 0.95d));
        pointF9.y = (float) (pointF10.y + ((pointF9.y - r1) * 0.95d));
        PointF pointF11 = pointFArr[52];
        PointF pointF12 = pointFArr[46];
        pointF11.x = (float) (pointF12.x + ((pointF11.x - r2) * 0.9d));
        pointF11.y = (float) (pointF12.y + ((pointF11.y - r1) * 0.9d));
        pointFArr[35].y = (float) (r0.y + ((pointFArr[39].x - r0.x) / 40.0d));
        pointFArr[45].y = (float) (r0.y + ((r0.x - pointFArr[49].x) / 40.0d));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static float[] calEyeEulerAngles(List<PointF> list) {
        double d16;
        double d17;
        double d18;
        new PointF();
        new PointF();
        PointF pointF = new PointF(list.get(54).x, list.get(54).y);
        PointF pointF2 = new PointF(pointF.x - list.get(49).x, pointF.y - list.get(49).y);
        PointF pointF3 = new PointF(pointF.x - list.get(45).x, pointF.y - list.get(45).y);
        float sqrt = (((float) Math.sqrt(Math.pow(pointF3.x, 2.0d) + Math.pow(pointF3.y, 2.0d))) + ((float) Math.sqrt(Math.pow(pointF2.x, 2.0d) + Math.pow(pointF2.y, 2.0d)))) * 0.5f;
        float f16 = (float) ((1.5707964f / 3.0d) * ((r1 - sqrt) / sqrt));
        PointF pointF4 = new PointF(list.get(45).x - list.get(49).x, list.get(45).y - list.get(49).y);
        float atan2 = (float) (((Math.atan2(pointF2.x, pointF2.y) - Math.atan2(pointF4.x, pointF4.y)) * 180.0d) / 3.141592653589793d);
        double d19 = atan2;
        if (d19 > 180.0d) {
            d16 = d19 - 360.0d;
        } else {
            if (d19 < -180.0d) {
                d16 = d19 + 360.0d;
            }
            PointF pointF5 = new PointF(((-1.5707964f) * atan2) / 270.0f, f16);
            PointF pointF6 = new PointF(list.get(44).x, list.get(44).y);
            PointF pointF7 = new PointF(pointF6.x - list.get(39).x, pointF6.y - list.get(39).y);
            PointF pointF8 = new PointF(pointF6.x - list.get(35).x, pointF6.y - list.get(35).y);
            float sqrt2 = (float) Math.sqrt(Math.pow(pointF7.x, 2.0d) + Math.pow(pointF7.y, 2.0d));
            float sqrt3 = (((float) Math.sqrt(Math.pow(pointF8.x, 2.0d) + Math.pow(pointF8.y, 2.0d))) + sqrt2) * 0.5f;
            float f17 = (-0.5235988f) * ((sqrt2 - sqrt3) / sqrt3);
            PointF pointF9 = new PointF(list.get(35).x - list.get(39).x, list.get(35).y - list.get(39).y);
            float atan22 = (float) (((Math.atan2(pointF7.x, pointF7.y) - Math.atan2(pointF9.x, pointF9.y)) * 180.0d) / 3.141592653589793d);
            d17 = atan22;
            if (d17 <= 180.0d) {
                d18 = d17 - 360.0d;
            } else {
                if (d17 < -180.0d) {
                    d18 = d17 + 360.0d;
                }
                PointF pointF10 = new PointF((1.5707964f * atan22) / 270.0f, f17);
                PointF pointF11 = new PointF((pointF5.x + pointF10.x) * 0.5f, (pointF5.y + pointF10.y) * 0.5f);
                return new float[]{pointF11.x, pointF11.y, 0.0f};
            }
            atan22 = (float) d18;
            PointF pointF102 = new PointF((1.5707964f * atan22) / 270.0f, f17);
            PointF pointF112 = new PointF((pointF5.x + pointF102.x) * 0.5f, (pointF5.y + pointF102.y) * 0.5f);
            return new float[]{pointF112.x, pointF112.y, 0.0f};
        }
        atan2 = (float) d16;
        PointF pointF52 = new PointF(((-1.5707964f) * atan2) / 270.0f, f16);
        PointF pointF62 = new PointF(list.get(44).x, list.get(44).y);
        PointF pointF72 = new PointF(pointF62.x - list.get(39).x, pointF62.y - list.get(39).y);
        PointF pointF82 = new PointF(pointF62.x - list.get(35).x, pointF62.y - list.get(35).y);
        float sqrt22 = (float) Math.sqrt(Math.pow(pointF72.x, 2.0d) + Math.pow(pointF72.y, 2.0d));
        float sqrt32 = (((float) Math.sqrt(Math.pow(pointF82.x, 2.0d) + Math.pow(pointF82.y, 2.0d))) + sqrt22) * 0.5f;
        float f172 = (-0.5235988f) * ((sqrt22 - sqrt32) / sqrt32);
        PointF pointF92 = new PointF(list.get(35).x - list.get(39).x, list.get(35).y - list.get(39).y);
        float atan222 = (float) (((Math.atan2(pointF72.x, pointF72.y) - Math.atan2(pointF92.x, pointF92.y)) * 180.0d) / 3.141592653589793d);
        d17 = atan222;
        if (d17 <= 180.0d) {
        }
        atan222 = (float) d18;
        PointF pointF1022 = new PointF((1.5707964f * atan222) / 270.0f, f172);
        PointF pointF1122 = new PointF((pointF52.x + pointF1022.x) * 0.5f, (pointF52.y + pointF1022.y) * 0.5f);
        return new float[]{pointF1122.x, pointF1122.y, 0.0f};
    }

    private static void calculatePoints(float[] fArr, float[] fArr2, int i3, int i16, int i17) {
        int i18 = i3 * 2;
        fArr[i18] = getFacePointX(fArr2, i16) + ((getFacePointX(fArr2, i17) - getFacePointX(fArr2, i16)) / 2.0f);
        fArr[i18 + 1] = getFacePointY(fArr2, i16) + ((getFacePointY(fArr2, i17) - getFacePointY(fArr2, i16)) / 2.0f);
    }

    private static float getArrayMiddleFloat(float[] fArr, int i3, int i16) {
        Float valueOf = Float.valueOf(0.0f);
        for (int i17 = i3; i17 <= i16; i17++) {
            valueOf = Float.valueOf(valueOf.floatValue() + fArr[i17]);
        }
        return Float.valueOf(valueOf.floatValue() / ((i16 - i3) + 1)).floatValue();
    }

    private static PointF getArrayMiddleV2(float[] fArr, int i3, int i16) {
        PointF pointF = new PointF();
        for (int i17 = i3; i17 <= i16; i17++) {
            int i18 = i17 * 2;
            pointF.x += fArr[i18];
            pointF.y += fArr[i18 + 1];
        }
        float f16 = (i16 - i3) + 1;
        pointF.x /= f16;
        pointF.y /= f16;
        return pointF;
    }

    private static float getFacePointX(float[] fArr, int i3) {
        int i16;
        if (fArr != null && fArr.length > (i16 = i3 * 2)) {
            return fArr[i16];
        }
        return 0.0f;
    }

    public static float getFacePointY(float[] fArr, int i3) {
        int i16;
        if (fArr != null && fArr.length > (i16 = (i3 * 2) + 1)) {
            return fArr[i16];
        }
        return 0.0f;
    }

    public static List<PointF> getIris3Points(List<List<PointF>> list, List<List<PointF>> list2) {
        ArrayList arrayList = new ArrayList();
        if (!CollectionUtils.isEmpty(list) && !CollectionUtils.isEmpty(list2)) {
            List<PointF> list3 = list.get(0);
            list2.get(0);
            arrayList.add(list3.get(43));
            arrayList.add(list3.get(53));
        }
        return arrayList;
    }

    public static List<PointF> getIris4Points(List<List<PointF>> list, List<List<PointF>> list2) {
        ArrayList arrayList = new ArrayList();
        if (!CollectionUtils.isEmpty(list) && !CollectionUtils.isEmpty(list2)) {
            List<PointF> list3 = list.get(0);
            list2.get(0);
            arrayList.add(list3.get(44));
            arrayList.add(list3.get(54));
        }
        return arrayList;
    }

    public static List<PointF> getIrisPoints(float[] fArr) {
        ArrayList arrayList = new ArrayList();
        if (fArr.length != 188) {
            return arrayList;
        }
        for (int i3 = 90; i3 < 94; i3++) {
            int i16 = i3 * 2;
            arrayList.add(new PointF(fArr[i16], fArr[i16 + 1]));
        }
        return arrayList;
    }

    public static List<PointF> getIrisRelatedPoints(List<List<PointF>> list, List<List<PointF>> list2) {
        ArrayList arrayList = new ArrayList();
        if (!CollectionUtils.isEmpty(list) && !CollectionUtils.isEmpty(list2)) {
            List<PointF> list3 = list.get(0);
            List<PointF> list4 = list2.get(0);
            arrayList.add(list3.get(44));
            arrayList.add(list3.get(41));
            arrayList.add(list4.get(0));
            arrayList.add(list3.get(37));
            arrayList.add(list4.get(1));
            arrayList.add(list3.get(54));
            arrayList.add(list3.get(51));
            arrayList.add(list4.get(2));
            arrayList.add(list3.get(47));
            arrayList.add(list4.get(3));
        }
        return arrayList;
    }

    private static float getMiddleFloat(float[] fArr, int i3, int i16) {
        return (fArr[i3] / 2.0f) + (fArr[i16] / 2.0f);
    }

    private static PointF getMiddleV2(float[] fArr, int i3, int i16) {
        int i17 = i3 * 2;
        int i18 = i16 * 2;
        return new PointF((fArr[i17] + fArr[i18]) / 2.0f, (fArr[i17 + 1] + fArr[i18 + 1]) / 2.0f);
    }

    public static void normalizePoints(List<PointF> list) {
        float distance = AlgoUtils.getDistance(list.get(99), list.get(105));
        float distance2 = AlgoUtils.getDistance(list.get(99), list.get(101));
        float f16 = ((int) (distance * 1.0f)) / distance;
        float f17 = ((int) (1.0f * distance2)) / distance2;
        for (int i3 = 0; i3 < 83; i3++) {
            list.get(i3).set(AlgoUtils.distanceOfPoint2Line(list.get(99), list.get(101), distance2, list.get(i3)) * f16, AlgoUtils.distanceOfPoint2Line(list.get(99), list.get(105), distance, list.get(i3)) * f17);
        }
        while (list.size() > 83) {
            list.remove(list.size() - 1);
        }
    }

    public static Float[] smoothYTPointsVisPoints(Float[] fArr) {
        if (fArr != null && fArr.length >= 90) {
            int i3 = 0;
            for (int i16 = 66; i16 <= 82; i16++) {
                if (fArr[i16].floatValue() < 0.7d) {
                    i3++;
                }
            }
            if (i3 >= 15) {
                for (int i17 = 66; i17 <= 82; i17++) {
                    if (fArr[i17].floatValue() >= 0.7d) {
                        fArr[i17] = Float.valueOf(0.5f);
                    }
                }
            }
        }
        return fArr;
    }

    public static float[] transform83PointsTo90(float[] fArr) {
        float[] fArr2 = new float[180];
        if (fArr != null && fArr.length >= 166) {
            int i3 = 0;
            for (int i16 = 0; i16 < 83; i16++) {
                int i17 = i16 * 2;
                fArr2[i17] = fArr[i17];
                int i18 = i17 + 1;
                fArr2[i18] = fArr[i18];
                i3++;
            }
            int i19 = i3 * 2;
            fArr2[i19] = getFacePointX(fArr, 55) + ((getFacePointX(fArr, 63) - getFacePointX(fArr, 55)) / 2.0f);
            fArr2[i19 + 1] = getFacePointY(fArr, 55) + ((getFacePointY(fArr, 63) - getFacePointY(fArr, 55)) / 2.0f);
            int i26 = i3 + 1;
            int i27 = i26 * 2;
            fArr2[i27] = getFacePointX(fArr, 23) + ((getFacePointX(fArr, 31) - getFacePointX(fArr, 23)) / 2.0f);
            fArr2[i27 + 1] = getFacePointY(fArr, 23) + ((getFacePointY(fArr, 31) - getFacePointY(fArr, 23)) / 2.0f);
            int i28 = i26 + 1;
            int i29 = i28 * 2;
            fArr2[i29] = getFacePointX(fArr, 59) + ((getFacePointX(fArr, 77) - getFacePointX(fArr, 59)) / 2.0f);
            fArr2[i29 + 1] = getFacePointY(fArr, 59) + ((getFacePointY(fArr, 77) - getFacePointY(fArr, 59)) / 2.0f);
            int i36 = i28 + 1;
            int i37 = i36 * 2;
            fArr2[i37] = getFacePointX(fArr, 35) + (getFacePointX(fArr, 35) - getFacePointX(fArr, 6));
            fArr2[i37 + 1] = getFacePointY(fArr, 35) + (getFacePointY(fArr, 35) - getFacePointY(fArr, 6));
            int i38 = i36 + 1;
            int i39 = i38 * 2;
            fArr2[i39] = getFacePointX(fArr, 64) + ((getFacePointX(fArr, 64) - getFacePointX(fArr, 9)) * 1.4f);
            fArr2[i39 + 1] = getFacePointY(fArr, 64) + ((getFacePointY(fArr, 64) - getFacePointY(fArr, 9)) * 1.4f);
            int i46 = i38 + 1;
            int i47 = i46 * 2;
            fArr2[i47] = getFacePointX(fArr, 45) + (getFacePointX(fArr, 45) - getFacePointX(fArr, 12));
            fArr2[i47 + 1] = getFacePointY(fArr, 45) + (getFacePointY(fArr, 45) - getFacePointY(fArr, 12));
            int i48 = (i46 + 1) * 2;
            fArr2[i48] = getFacePointX(fArr2, 83) + (getFacePointX(fArr2, 83) - getFacePointX(fArr2, 59));
            fArr2[i48 + 1] = getFacePointY(fArr2, 83) + (getFacePointY(fArr2, 83) - getFacePointY(fArr2, 59));
        }
        return fArr2;
    }

    public static List<PointF> transform90PointsTo83(float[] fArr) {
        PointF[] pointFArr = new PointF[83];
        for (int i3 = 0; i3 < 83; i3++) {
            pointFArr[i3] = new PointF();
        }
        pointFArr[0] = getMiddleV2(fArr, 67, 68);
        for (int i16 = 1; i16 <= 17; i16++) {
            PointF pointF = pointFArr[i16];
            int i17 = (i16 + 68) * 2;
            pointF.x = fArr[i17 + 0];
            pointF.y = fArr[i17 + 1];
        }
        pointFArr[18] = getMiddleV2(fArr, 86, 87);
        for (int i18 = 19; i18 <= 34; i18++) {
            PointF pointF2 = pointFArr[i18];
            int i19 = (i18 - 19) * 2;
            pointF2.x = fArr[i19 + 0];
            pointF2.y = fArr[i19 + 1];
        }
        for (int i26 = 35; i26 <= 42; i26++) {
            PointF pointF3 = pointFArr[i26];
            int i27 = (i26 - 19) * 2;
            pointF3.x = fArr[i27 + 0];
            pointF3.y = fArr[i27 + 1];
        }
        pointFArr[43] = getArrayMiddleV2(fArr, 16, 23);
        PointF pointF4 = pointFArr[44];
        pointF4.x = fArr[176];
        pointF4.y = fArr[177];
        for (int i28 = 45; i28 <= 52; i28++) {
            PointF pointF5 = pointFArr[i28];
            int i29 = (i28 - 21) * 2;
            pointF5.x = fArr[i29 + 0];
            pointF5.y = fArr[i29 + 1];
        }
        pointFArr[53] = getArrayMiddleV2(fArr, 24, 31);
        PointF pointF6 = pointFArr[54];
        pointF6.x = fArr[178];
        pointF6.y = fArr[179];
        PointF pointF7 = pointFArr[55];
        pointF7.x = (float) ((fArr[66] * 0.5d) + (fArr[40] * 0.5d));
        pointF7.y = (float) ((fArr[67] * 0.5d) + (fArr[41] * 0.5d));
        PointF pointF8 = pointFArr[56];
        pointF8.x = (float) ((fArr[64] * 0.1d) + (fArr[70] * 0.45d) + (fArr[72] * 0.45d));
        pointF8.y = (float) ((fArr[65] * 0.1d) + (fArr[71] * 0.45d) + (fArr[73] * 0.45d));
        for (int i36 = 57; i36 <= 61; i36++) {
            PointF pointF9 = pointFArr[i36];
            int i37 = (i36 - 20) * 2;
            pointF9.x = fArr[i37 + 0];
            pointF9.y = fArr[i37 + 1];
        }
        PointF pointF10 = pointFArr[62];
        float f16 = fArr[64];
        pointF10.x = (float) ((f16 * 0.1d) + (fArr[86] * 0.45d) + (fArr[84] * 0.45d));
        float f17 = fArr[65];
        pointF10.y = (float) ((f17 * 0.1d) + (fArr[87] * 0.45d) + (fArr[85] * 0.45d));
        PointF pointF11 = pointFArr[63];
        pointF11.x = (float) ((fArr[66] * 0.5d) + (fArr[56] * 0.5d));
        pointF11.y = (float) ((fArr[67] * 0.5d) + (fArr[57] * 0.5d));
        PointF pointF12 = pointFArr[64];
        pointF12.x = f16;
        pointF12.y = f17;
        PointF pointF13 = pointFArr[65];
        pointF13.x = fArr[90];
        pointF13.y = fArr[91];
        PointF pointF14 = pointFArr[66];
        pointF14.x = fArr[102];
        pointF14.y = fArr[103];
        for (int i38 = 67; i38 <= 71; i38++) {
            PointF pointF15 = pointFArr[i38];
            int i39 = (i38 - 21) * 2;
            pointF15.x = fArr[i39 + 0];
            pointF15.y = fArr[i39 + 1];
        }
        pointFArr[72] = getMiddleV2(fArr, 60, 61);
        PointF pointF16 = pointFArr[73];
        pointF16.x = fArr[118];
        pointF16.y = fArr[119];
        pointFArr[74] = getMiddleV2(fArr, 57, 58);
        for (int i46 = 75; i46 <= 79; i46++) {
            PointF pointF17 = pointFArr[i46];
            int i47 = (131 - i46) * 2;
            pointF17.x = fArr[i47 + 0];
            pointF17.y = fArr[i47 + 1];
        }
        pointFArr[80] = getMiddleV2(fArr, 62, 63);
        PointF pointF18 = pointFArr[81];
        pointF18.x = fArr[128];
        pointF18.y = fArr[129];
        pointFArr[82] = getMiddleV2(fArr, 65, 66);
        adjustEyeFeatureV2(pointFArr);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(pointFArr));
        return arrayList;
    }

    public static float[] transform90PointsVisTo83(float[] fArr) {
        float[] fArr2 = new float[83];
        for (int i3 = 0; i3 < 83; i3++) {
            fArr2[i3] = 0.0f;
        }
        fArr2[0] = getMiddleFloat(fArr, 67, 68);
        for (int i16 = 1; i16 <= 17; i16++) {
            fArr2[i16] = fArr[i16 + 68];
        }
        fArr2[18] = getMiddleFloat(fArr, 86, 87);
        for (int i17 = 19; i17 <= 34; i17++) {
            fArr2[i17] = fArr[i17 - 19];
        }
        for (int i18 = 35; i18 <= 42; i18++) {
            fArr2[i18] = fArr[i18 - 19];
        }
        fArr2[43] = getArrayMiddleFloat(fArr, 16, 23);
        fArr2[44] = fArr[88];
        for (int i19 = 45; i19 <= 52; i19++) {
            fArr2[i19] = fArr[i19 - 21];
        }
        fArr2[53] = getArrayMiddleFloat(fArr, 24, 31);
        fArr2[54] = fArr[89];
        fArr2[55] = (float) ((fArr[33] * 0.5d) + (fArr[20] * 0.5d));
        fArr2[56] = (float) ((fArr[32] * 0.1d) + (fArr[35] * 0.45d) + (fArr[36] * 0.45d));
        for (int i26 = 57; i26 <= 61; i26++) {
            fArr2[i26] = fArr[i26 - 20];
        }
        float f16 = fArr[32];
        fArr2[62] = (float) ((f16 * 0.1d) + (fArr[43] * 0.45d) + (fArr[42] * 0.45d));
        fArr2[63] = (float) ((fArr[33] * 0.5d) + (fArr[28] * 0.5d));
        fArr2[64] = f16;
        fArr2[65] = fArr[45];
        fArr2[66] = fArr[51];
        for (int i27 = 67; i27 <= 71; i27++) {
            fArr2[i27] = fArr[i27 - 21];
        }
        fArr2[72] = getMiddleFloat(fArr, 60, 61);
        fArr2[73] = fArr[59];
        fArr2[74] = getMiddleFloat(fArr, 57, 58);
        for (int i28 = 75; i28 <= 79; i28++) {
            fArr2[i28] = fArr[131 - i28];
        }
        fArr2[80] = getMiddleFloat(fArr, 62, 63);
        fArr2[81] = fArr[64];
        fArr2[82] = getMiddleFloat(fArr, 65, 66);
        return fArr2;
    }

    public static List<PointF> transformYTPointsToPtuPoints(float[] fArr) {
        List<PointF> transform90PointsTo83 = transform90PointsTo83(fArr);
        PointF middlePoint = AlgoUtils.middlePoint(transform90PointsTo83.get(55), transform90PointsTo83.get(63));
        transform90PointsTo83.add(middlePoint);
        transform90PointsTo83.add(AlgoUtils.middlePoint(transform90PointsTo83.get(23), transform90PointsTo83.get(31)));
        transform90PointsTo83.add(AlgoUtils.middlePoint(transform90PointsTo83.get(59), transform90PointsTo83.get(77)));
        transform90PointsTo83.add(new PointF((transform90PointsTo83.get(35).x * 2.0f) - transform90PointsTo83.get(6).x, (float) (transform90PointsTo83.get(39).y + ((transform90PointsTo83.get(39).y - transform90PointsTo83.get(56).y) * 3.2d))));
        transform90PointsTo83.add(new PointF((float) ((transform90PointsTo83.get(64).x * 2.4d) - (transform90PointsTo83.get(9).x * 1.4d)), (float) ((middlePoint.y * 2.5d) - (transform90PointsTo83.get(59).y * 1.5d))));
        transform90PointsTo83.add(new PointF((transform90PointsTo83.get(45).x * 2.0f) - transform90PointsTo83.get(12).x, (float) ((transform90PointsTo83.get(49).y * 4.2d) - (transform90PointsTo83.get(62).y * 3.2d))));
        transform90PointsTo83.add(new PointF((middlePoint.x * 2.0f) - transform90PointsTo83.get(59).x, (float) (((transform90PointsTo83.get(39).y + transform90PointsTo83.get(49).y) / 2.0d) - ((transform90PointsTo83.get(64).y - middlePoint.y) * 1.4d))));
        return transform90PointsTo83;
    }

    public static Float[] transformYTPointsVisToPtuPoints(float[] fArr) {
        ArrayList arrayList = new ArrayList();
        float[] transform90PointsVisTo83 = transform90PointsVisTo83(fArr);
        for (int i3 = 0; i3 < 83; i3++) {
            arrayList.add(Float.valueOf(transform90PointsVisTo83[i3]));
        }
        arrayList.add(Float.valueOf((transform90PointsVisTo83[55] + transform90PointsVisTo83[63]) / 2.0f));
        arrayList.add(Float.valueOf((transform90PointsVisTo83[23] + transform90PointsVisTo83[31]) / 2.0f));
        arrayList.add(Float.valueOf((transform90PointsVisTo83[59] + transform90PointsVisTo83[77]) / 2.0f));
        arrayList.add(Float.valueOf(1.0f));
        arrayList.add(Float.valueOf(1.0f));
        arrayList.add(Float.valueOf(1.0f));
        arrayList.add(Float.valueOf(1.0f));
        return (Float[]) arrayList.toArray(new Float[0]);
    }
}
