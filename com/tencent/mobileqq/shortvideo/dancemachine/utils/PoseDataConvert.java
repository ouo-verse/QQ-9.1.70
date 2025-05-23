package com.tencent.mobileqq.shortvideo.dancemachine.utils;

import com.tencent.mobileqq.qmcf.QmcfManager;
import java.util.List;

/* loaded from: classes18.dex */
public class PoseDataConvert {
    private static int[][] mirrorMap = {new int[]{14, 15}, new int[]{16, 17}, new int[]{2, 5}, new int[]{3, 6}, new int[]{4, 7}, new int[]{8, 11}, new int[]{9, 12}, new int[]{10, 13}, new int[]{32, 33}, new int[]{34, 35}, new int[]{20, 23}, new int[]{21, 24}, new int[]{22, 25}, new int[]{26, 29}, new int[]{27, 30}, new int[]{28, 31}};

    public static float[] convertPointsOld(float[] fArr, float f16, float f17, float f18, float f19) {
        int length = (fArr.length - 1) / 3;
        float[] fArr2 = new float[length * 3];
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = i3 * 3;
            fArr2[i16] = (-(f18 - (fArr[i16] * 2.0f))) / f18;
            int i17 = i16 + 1;
            fArr2[i17] = (f19 - (fArr[i17] * 2.0f)) / f19;
            int i18 = i16 + 2;
            fArr2[i18] = fArr[i18];
        }
        return fArr2;
    }

    public static float[] convertPointsToFrameCoordinate(float[] fArr, float f16, float f17, float f18, float f19) {
        float f26 = f16 / f18;
        float f27 = f17 / f19;
        int length = (fArr.length - 1) / 3;
        float[] fArr2 = new float[length * 3];
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = i3 * 3;
            float f28 = fArr[i16];
            if (QmcfManager.getInstance().needConvertCoor()) {
                f28 = f18 - fArr[i16];
            }
            int i17 = i16 + 1;
            float f29 = fArr[i17];
            fArr2[i16] = f28 * f26;
            fArr2[i17] = f29 * f27;
            int i18 = i16 + 2;
            fArr2[i18] = fArr[i18];
        }
        return fArr2;
    }

    public static void convertToVec3f(float[] fArr, List<Vec3f> list) {
        int length = fArr.length / 3;
        if (list.size() < length) {
            list.clear();
            for (int i3 = 0; i3 < length; i3++) {
                list.add(new Vec3f());
            }
        }
        for (int i16 = 0; i16 < length; i16++) {
            Vec3f vec3f = list.get(i16);
            if (vec3f == null) {
                vec3f = new Vec3f();
                list.set(i16, vec3f);
            }
            int i17 = i16 * 3;
            vec3f.set(fArr[i17], fArr[i17 + 1], fArr[i17 + 2]);
        }
        if (QmcfManager.getInstance().needConvertCoor()) {
            mirrorTrans(list);
        }
    }

    public static void mirrorTrans(List<Vec3f> list) {
        if (list.size() != 36) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            list.get(i3);
        }
        int i16 = 0;
        while (true) {
            int[][] iArr = mirrorMap;
            if (i16 < iArr.length) {
                Vec3f vec3f = list.get(iArr[i16][0]);
                int[] iArr2 = mirrorMap[i16];
                list.set(iArr2[0], list.get(iArr2[1]));
                list.set(mirrorMap[i16][1], vec3f);
                i16++;
            } else {
                return;
            }
        }
    }

    public static float[] normalizedPoseData(float[] fArr, float f16, float f17, float f18, float f19) {
        float[] convertPointsToFrameCoordinate = convertPointsToFrameCoordinate(fArr, f16, f17, f18, f19);
        int length = convertPointsToFrameCoordinate.length / 3;
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = i3 * 3;
            convertPointsToFrameCoordinate[i16] = (-(f16 - (convertPointsToFrameCoordinate[i16] * 2.0f))) / f16;
            int i17 = i16 + 1;
            convertPointsToFrameCoordinate[i17] = (f17 - (convertPointsToFrameCoordinate[i17] * 2.0f)) / f17;
        }
        return convertPointsToFrameCoordinate;
    }
}
