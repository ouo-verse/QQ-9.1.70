package com.tencent.ttpic.openapi.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.gyailib.library.FaceDetector;
import com.gyailib.library.FaceDetectorFeature;
import com.gyailib.library.GYAIFace;
import com.gyailib.library.SDKDeviceConfig;
import com.gyailib.library.SDKModelConfig;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.TransformUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.light.bean.LightFaceData;
import org.light.bean.LightFaceFeature;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AEStaticDetector {
    private static final String TAG = "AEStaticDetector";
    private static String faceModelPath = "";

    public static PTFaceAttr detectFace(Bitmap bitmap) {
        if (TextUtils.isEmpty(faceModelPath)) {
            LogUtils.e(TAG, "face detect not init model path empty.");
            return null;
        }
        GYAIFace gYAIFace = new GYAIFace();
        int initFaceDetect = initFaceDetect(gYAIFace);
        if (initFaceDetect != 0) {
            LogUtils.e(TAG, "init face error code: " + initFaceDetect);
            return null;
        }
        FaceDetector faceDetector = new FaceDetector();
        LogUtils.d(TAG, "detect face code: " + gYAIFace.forwardDetect(bitmap, faceDetector, 0));
        if (faceDetector.faces == null) {
            return null;
        }
        LogUtils.d(TAG, "face cnt " + faceDetector.faces.length);
        int i3 = 2;
        int[] iArr = {bitmap.getWidth(), bitmap.getHeight()};
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byteArrayOutputStream.toByteArray();
        LightFaceData lightFaceData = new LightFaceData(iArr, iArr, iArr);
        ArrayList arrayList = new ArrayList();
        FaceDetectorFeature[] faceDetectorFeatureArr = faceDetector.faces;
        int length = faceDetectorFeatureArr.length;
        int i16 = 0;
        while (i16 < length) {
            FaceDetectorFeature faceDetectorFeature = faceDetectorFeatureArr[i16];
            float[] fArr = new float[94];
            float[] fArr2 = faceDetectorFeature.pointsVisibility;
            System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
            float[] fArr3 = new float[180];
            float[] fArr4 = new float[90];
            System.arraycopy(YoutuPointsUtil.transform83PointsTo90(faceDetectorFeature.fFeatures), 0, fArr3, 0, 180);
            System.arraycopy(fArr, 0, fArr4, 0, 90);
            float[] fArr5 = new float[i3];
            fArr5[0] = faceDetectorFeature.imageWidth;
            fArr5[1] = faceDetectorFeature.imageHeight;
            float[] fArr6 = new float[4];
            fArr6[0] = faceDetectorFeature.boundsX;
            fArr6[1] = faceDetectorFeature.boundsY;
            fArr6[i3] = faceDetectorFeature.boundsW;
            fArr6[3] = faceDetectorFeature.boundsH;
            float[] fArr7 = new float[4];
            fArr7[0] = faceDetectorFeature.leBoundsX;
            fArr7[1] = faceDetectorFeature.leBoundsY;
            fArr7[i3] = faceDetectorFeature.leBoundsW;
            fArr7[3] = faceDetectorFeature.leBoundsH;
            float[] fArr8 = new float[4];
            fArr8[0] = faceDetectorFeature.reBoundsX;
            fArr8[1] = faceDetectorFeature.reBoundsY;
            fArr8[i3] = faceDetectorFeature.reBoundsW;
            fArr8[3] = faceDetectorFeature.reBoundsH;
            float[] fArr9 = new float[4];
            fArr9[0] = faceDetectorFeature.mouthBoundsX;
            fArr9[1] = faceDetectorFeature.mouthBoundsY;
            fArr9[i3] = faceDetectorFeature.mouthBoundsW;
            fArr9[3] = faceDetectorFeature.mouthBoundsH;
            arrayList.add(new LightFaceFeature(fArr5, fArr6, fArr7, fArr8, fArr9, faceDetectorFeature.pitch, faceDetectorFeature.yaw, faceDetectorFeature.roll, true, "", new float[188], fArr, null, null, fArr3, fArr4, null, null, null, null, null));
            i16++;
            i3 = 2;
        }
        lightFaceData.mLightFaceFeatureList = arrayList;
        gYAIFace.cleanupModelData();
        return TransformUtils.lightFaceToPTFaceAttr(lightFaceData);
    }

    public static boolean hasFaceData(PTFaceAttr pTFaceAttr) {
        if (pTFaceAttr != null && pTFaceAttr.getFaceCount() > 0) {
            return true;
        }
        return false;
    }

    public static void initDetector(String str) {
        faceModelPath = str;
    }

    private static int initFaceDetect(GYAIFace gYAIFace) {
        SDKDeviceConfig sDKDeviceConfig = new SDKDeviceConfig();
        sDKDeviceConfig.setDevice(PreDownloadConstants.RPORT_KEY_CPU);
        int initInstance = gYAIFace.initInstance(sDKDeviceConfig);
        if (initInstance != 0) {
            LogUtils.e(TAG, "init face detect error code: " + initInstance);
            return initInstance;
        }
        SDKModelConfig sDKModelConfig = new SDKModelConfig();
        HashMap hashMap = new HashMap();
        sDKModelConfig.modelPaths = hashMap;
        hashMap.put("root-path", faceModelPath);
        return gYAIFace.setupWithModel(sDKModelConfig);
    }

    private static void pointToRect(float[] fArr, int i3, int i16, int i17, int i18) {
        fArr[0] = i3;
        fArr[1] = i16;
        fArr[2] = i17;
        fArr[3] = i18;
    }
}
