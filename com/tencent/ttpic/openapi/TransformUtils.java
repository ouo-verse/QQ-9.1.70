package com.tencent.ttpic.openapi;

import android.graphics.PointF;
import com.tencent.ttpic.facedetect.GenderType;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.filter.LightConstants;
import com.tencent.ttpic.openapi.util.YoutuPointsUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.light.bean.LightFaceData;
import org.light.bean.LightFaceFeature;
import org.light.bean.TTFaceOriginDataModel;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TransformUtils {
    private static final String TAG = "TransformUtils";

    public static float[] ConvertPointListToFloatArray(List<PointF> list) {
        if (list != null && list.size() != 0) {
            int size = list.size();
            float[] fArr = new float[size * 2];
            for (int i3 = 0; i3 < size; i3++) {
                int i16 = i3 * 2;
                fArr[i16] = list.get(i3).x;
                fArr[i16 + 1] = list.get(i3).y;
            }
            return fArr;
        }
        return null;
    }

    private static List<PointF> arrPointToList(float[] fArr, float f16) {
        if (fArr == null) {
            return new ArrayList();
        }
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr[i3] = fArr[i3] * f16;
        }
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < fArr.length / 2; i16++) {
            int i17 = i16 * 2;
            arrayList.add(new PointF(fArr[i17], fArr[i17 + 1]));
        }
        return arrayList;
    }

    public static PTFaceAttr lightFaceToPTFaceAttr(LightFaceData lightFaceData) {
        List<LightFaceFeature> list;
        int[] iArr;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (lightFaceData != null && (list = lightFaceData.mLightFaceFeatureList) != null) {
            float f16 = 1.0f;
            for (LightFaceFeature lightFaceFeature : list) {
                TTFaceOriginDataModel tTFaceOriginDataModel = lightFaceFeature.mTTFaceOriginDataModel;
                arrayList2.add(tTFaceOriginDataModel);
                FaceInfo faceInfo = new FaceInfo();
                if (lightFaceData.imageSize != null && (iArr = lightFaceData.renderSize) != null) {
                    f16 = (iArr[0] * 1.0f) / r10[0];
                }
                faceInfo.points = arrPointToList(lightFaceFeature.facePoint90, f16);
                faceInfo.point94 = arrPointToList(lightFaceFeature.facePoints, f16);
                faceInfo.irisPoints = YoutuPointsUtil.getIrisPoints(lightFaceFeature.facePoint90);
                Float[] transformYTPointsVisToPtuPoints = YoutuPointsUtil.transformYTPointsVisToPtuPoints(lightFaceFeature.facePoint90Visibility);
                faceInfo.pointsVis = transformYTPointsVisToPtuPoints;
                faceInfo.pointsVis = YoutuPointsUtil.smoothYTPointsVisPoints(transformYTPointsVisToPtuPoints);
                float[] fArr = faceInfo.angles;
                float f17 = tTFaceOriginDataModel.pitch;
                fArr[0] = f17;
                float f18 = tTFaceOriginDataModel.yaw;
                fArr[1] = f18;
                float f19 = tTFaceOriginDataModel.roll;
                fArr[2] = f19;
                faceInfo.pitch = f17;
                faceInfo.yaw = f18;
                faceInfo.roll = f19;
                if (LightConstants.FEMALE.equals(lightFaceFeature.gender)) {
                    faceInfo.gender = GenderType.FEMALE.value;
                } else if (LightConstants.MALE.equals(lightFaceFeature.gender)) {
                    faceInfo.gender = GenderType.MALE.value;
                } else {
                    faceInfo.gender = GenderType.DEFAULT.value;
                }
                faceInfo.age = lightFaceFeature.age;
                faceInfo.scale = 0.0f;
                faceInfo.f381699tx = 0.0f;
                faceInfo.f381700ty = 0.0f;
                faceInfo.denseFaceModel = null;
                faceInfo.transform = null;
                faceInfo.expressionWeights = null;
                arrayList.add(faceInfo);
            }
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            ArrayList arrayList7 = new ArrayList();
            ArrayList arrayList8 = new ArrayList();
            ArrayList arrayList9 = new ArrayList();
            HashSet hashSet = new HashSet();
            hashSet.add(1);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                arrayList3.add(((FaceInfo) arrayList.get(i3)).points);
            }
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                arrayList4.add(((FaceInfo) arrayList.get(i16)).point94);
            }
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                arrayList5.add(((FaceInfo) arrayList.get(i17)).irisPoints);
            }
            for (int i18 = 0; i18 < arrayList.size(); i18++) {
                arrayList6.add(((FaceInfo) arrayList.get(i18)).pointsVis);
            }
            for (int i19 = 0; i19 < arrayList.size(); i19++) {
                arrayList7.add(((FaceInfo) arrayList.get(i19)).angles);
            }
            for (int i26 = 0; i26 < arrayList.size(); i26++) {
                int i27 = ((FaceInfo) arrayList.get(i26)).gender;
                int i28 = ((FaceInfo) arrayList.get(i26)).age;
                arrayList8.add(Integer.valueOf(i27));
                arrayList9.add(Integer.valueOf(i28));
            }
            PTFaceAttr.Builder builder = new PTFaceAttr.Builder();
            builder.facePoints(arrayList3).facePoint94(arrayList4).irisPoints(arrayList5).pointsVis(arrayList6).faceAngles(arrayList7).genderList(arrayList8).ageList(arrayList9).faceDetectScale(f16).triggeredExpression(hashSet).faceDetWidth(lightFaceData.imageSize[0]).faceDetHeight(lightFaceData.imageSize[1]).data(lightFaceData.imageData).build();
            return new PTFaceAttr(builder);
        }
        return new PTFaceAttr(new PTFaceAttr.Builder());
    }

    public static LightFaceData ptFaceAttrToLightFaceData(PTFaceAttr pTFaceAttr) {
        if (pTFaceAttr == null || pTFaceAttr.getAllFacePoints94() == null) {
            return null;
        }
        LightFaceData lightFaceData = new LightFaceData();
        int size = pTFaceAttr.getAllFacePoints94().size();
        for (int i3 = 0; i3 < size; i3++) {
            List<PointF> list = pTFaceAttr.getAllFacePoints94().get(i3);
            if (list == null) {
                break;
            }
            for (PointF pointF : list) {
                pointF.x /= (float) pTFaceAttr.getFaceDetectScale();
                pointF.y /= (float) pTFaceAttr.getFaceDetectScale();
            }
            float[] fArr = pTFaceAttr.getAllFaceAngles().get(i3);
            LightFaceFeature lightFaceFeature = new LightFaceFeature();
            lightFaceFeature.facePoints = ConvertPointListToFloatArray(list);
            lightFaceFeature.facePoint83 = ConvertPointListToFloatArray(YoutuPointsUtil.transform90PointsTo83(ConvertPointListToFloatArray(list)));
            Arrays.fill(lightFaceFeature.facePointsVisible, 1.0f);
            Arrays.fill(lightFaceFeature.facePoint83Visibility, 1.0f);
            if (fArr != null) {
                lightFaceFeature.pitch = fArr[0];
                lightFaceFeature.yaw = fArr[1];
                lightFaceFeature.roll = fArr[2];
            }
            lightFaceData.mLightFaceFeatureList.add(lightFaceFeature);
        }
        return lightFaceData;
    }
}
