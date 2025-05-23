package com.tencent.mobileqq.shortvideo.facedancegame.utils;

import android.graphics.PointF;
import com.tencent.ttpic.openapi.util.FaceDetectUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ActUtil {
    public static final int EXPRESSION_ITEM_COUNT = 7;
    private static final String TAG = com.tencent.ttpic.util.ActUtil.class.getSimpleName();

    private static float distanceOfPoint(PointF pointF, PointF pointF2) {
        float f16 = pointF.x;
        float f17 = pointF2.x;
        float f18 = pointF.y;
        float f19 = pointF2.y;
        return (float) Math.sqrt(((f16 - f17) * (f16 - f17)) + ((f18 - f19) * (f18 - f19)));
    }

    public static float getExpressionSimilarity(List<PointF> list, List<PointF> list2, float[] fArr, float[] fArr2, double[] dArr) {
        if (list != null && list2 != null && fArr != null && fArr.length >= 3 && dArr != null && dArr.length >= 7) {
            List<PointF> fullCoords = FaceOffUtil.getFullCoords(FaceDetectUtil.facePointf83to90(list), 2.0f);
            List<PointF> fullCoords2 = FaceOffUtil.getFullCoords(FaceDetectUtil.facePointf83to90(list2), 2.0f);
            if (fullCoords2.size() >= 106 && fullCoords.size() >= 106) {
                ArrayList arrayList = new ArrayList(fullCoords.size());
                ArrayList arrayList2 = new ArrayList(fullCoords2.size());
                float distance = AlgoUtils.getDistance(fullCoords.get(99), fullCoords.get(105));
                float distance2 = AlgoUtils.getDistance(fullCoords.get(99), fullCoords.get(101));
                float distance3 = AlgoUtils.getDistance(fullCoords2.get(99), fullCoords2.get(105));
                float distance4 = AlgoUtils.getDistance(fullCoords2.get(99), fullCoords2.get(101));
                for (int i3 = 0; i3 < fullCoords.size(); i3++) {
                    arrayList.add(new PointF(fullCoords.get(i3).x / distance, fullCoords.get(i3).y / distance2));
                    arrayList2.add(new PointF(fullCoords2.get(i3).x / distance3, fullCoords2.get(i3).y / distance4));
                }
                float[] fArr3 = {getSimilarityOfValue(distanceOfPoint((PointF) arrayList.get(37), (PointF) arrayList.get(41)) / distanceOfPoint((PointF) arrayList.get(35), (PointF) arrayList.get(39)), distanceOfPoint((PointF) arrayList2.get(37), (PointF) arrayList2.get(41)) / distanceOfPoint((PointF) arrayList2.get(35), (PointF) arrayList2.get(39)), 0.18f, 0.5f), getSimilarityOfValue(distanceOfPoint((PointF) arrayList.get(47), (PointF) arrayList.get(51)) / distanceOfPoint((PointF) arrayList.get(45), (PointF) arrayList.get(49)), distanceOfPoint((PointF) arrayList2.get(47), (PointF) arrayList2.get(51)) / distanceOfPoint((PointF) arrayList2.get(45), (PointF) arrayList2.get(49)), 0.18f, 0.5f), getSimilarityOfValue(distanceOfPoint((PointF) arrayList.get(73), (PointF) arrayList.get(81)) / distanceOfPoint((PointF) arrayList.get(65), (PointF) arrayList.get(66)), distanceOfPoint((PointF) arrayList2.get(73), (PointF) arrayList2.get(81)) / distanceOfPoint((PointF) arrayList2.get(65), (PointF) arrayList2.get(66)), 0.05f, 0.6f), getSimilarityOfValue(fArr[0], fArr2[0], -15.0f, 15.0f), getSimilarityOfValue(fArr[1], fArr2[1], -20.0f, 20.0f), getSimilarityOfValue(fArr[2], fArr2[2], -15.0f, 15.0f), getSimilarityOfValue((((((PointF) arrayList.get(44)).x - ((PointF) arrayList.get(35)).x) / (((PointF) arrayList.get(39)).x - ((PointF) arrayList.get(35)).x)) + ((((PointF) arrayList.get(54)).x - ((PointF) arrayList.get(45)).x) / (((PointF) arrayList.get(49)).x - ((PointF) arrayList.get(45)).x))) / 2.0f, (((((PointF) arrayList2.get(44)).x - ((PointF) arrayList2.get(35)).x) / (((PointF) arrayList2.get(39)).x - ((PointF) arrayList2.get(35)).x)) + ((((PointF) arrayList2.get(54)).x - ((PointF) arrayList2.get(45)).x) / (((PointF) arrayList2.get(49)).x - ((PointF) arrayList2.get(45)).x))) / 2.0f, 0.25f, 0.75f)};
                float f16 = 0.0f;
                float f17 = 0.0f;
                for (int i16 = 0; i16 < 7; i16++) {
                    double d16 = dArr[i16];
                    f16 = (float) (f16 + (fArr3[i16] * d16));
                    f17 = (float) (f17 + d16);
                }
                return (f16 / f17) * 100.0f;
            }
            return 0.0f;
        }
        return 0.0f;
    }

    private static float getSimilarityOfValue(float f16, float f17, float f18, float f19) {
        if (f16 < f18) {
            f16 = f18;
        }
        if (f16 > f19) {
            f16 = f19;
        }
        if (f17 < f18) {
            f17 = f18;
        }
        if (f17 > f19) {
            f17 = f19;
        }
        float abs = (Math.abs(f16 - f17) * 2.0f) / (f19 - f18);
        if (abs > 1.0d) {
            abs = 1.0f;
        }
        return 1.0f - smoothStep(abs);
    }

    private static float smoothStep(float f16) {
        return f16 * f16 * f16 * f16 * (((35.0f - (84.0f * f16)) + ((70.0f * f16) * f16)) - (((20.0f * f16) * f16) * f16));
    }
}
