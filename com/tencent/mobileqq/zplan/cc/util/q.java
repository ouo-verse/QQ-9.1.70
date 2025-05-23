package com.tencent.mobileqq.zplan.cc.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.gyailib.library.FaceDetector;
import com.gyailib.library.FaceDetectorFeature;
import com.gyailib.library.GYAIFace;
import com.gyailib.library.GYAIValidFace;
import com.gyailib.library.SDKDeviceConfig;
import com.gyailib.library.SDKModelConfig;
import com.gyailib.library.ValidFacePhotoQuality;
import com.gyailib.librarytest.GYAIFaceAuth;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import uv4.bl;
import uv4.bm;

/* compiled from: P */
/* loaded from: classes35.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static GYAIValidFace f332572a = null;

    /* renamed from: b, reason: collision with root package name */
    private static GYAIFace f332573b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f332574c = false;

    /* renamed from: d, reason: collision with root package name */
    private static Bitmap f332575d;

    /* renamed from: e, reason: collision with root package name */
    private static float[] f332576e;

    private static String a() {
        Map<String, String> lightBundleMap = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleMap();
        if (lightBundleMap != null) {
            return lightBundleMap.get(AEResInfo.LIGHT_RES_BUNDLE_3DMM.agentType);
        }
        return null;
    }

    private static String b() {
        Map<String, String> lightBundleMap = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleMap();
        if (lightBundleMap != null) {
            return lightBundleMap.get(AEResInfo.LIGHT_RES_BUNDLE_FACE.agentType);
        }
        return null;
    }

    public static p c() {
        if (!f332574c) {
            return null;
        }
        p pVar = new p();
        pVar.f332570a = f332575d;
        pVar.f332571b = f332576e;
        return pVar;
    }

    public static ValidFacePhotoQuality d(Bitmap bitmap, float[] fArr) {
        if (!f332574c) {
            return null;
        }
        ValidFacePhotoQuality validFacePhotoQuality = new ValidFacePhotoQuality();
        f332572a.validatePhotoQuality(bitmap, fArr, validFacePhotoQuality, 0);
        Log.d("tag", String.format("test result: %d %d %d %d \n", Integer.valueOf(validFacePhotoQuality.poseValid), Integer.valueOf(validFacePhotoQuality.expressionValid), Integer.valueOf(validFacePhotoQuality.lightingUnderExposure), Integer.valueOf(validFacePhotoQuality.lightingOverExposure)));
        return validFacePhotoQuality;
    }

    public static boolean e(Bitmap bitmap) {
        if (!f332574c) {
            return false;
        }
        ValidFacePhotoQuality validFacePhotoQuality = new ValidFacePhotoQuality();
        FaceDetector faceDetector = new FaceDetector();
        f332573b.forwardDetect(bitmap, faceDetector, 0);
        FaceDetectorFeature[] faceDetectorFeatureArr = faceDetector.faces;
        int length = faceDetectorFeatureArr == null ? 0 : faceDetectorFeatureArr.length;
        int i3 = -1;
        float f16 = 0.0f;
        for (int i16 = 0; i16 < length; i16++) {
            FaceDetectorFeature faceDetectorFeature = faceDetector.faces[i16];
            float f17 = faceDetectorFeature.boundsW * faceDetectorFeature.boundsH;
            if (f17 > f16) {
                i3 = i16;
                f16 = f17;
            }
        }
        if (i3 >= 0) {
            float[] fArr = faceDetector.faces[i3].fFeatures256;
            f332572a.validatePhotoQuality(bitmap, fArr, validFacePhotoQuality, 0);
            if (validFacePhotoQuality.poseValid == 1 && validFacePhotoQuality.expressionValid == 1 && validFacePhotoQuality.lightingUnderExposure == 0 && validFacePhotoQuality.lightingOverExposure == 0) {
                Bitmap bitmap2 = f332575d;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                }
                f332575d = f332572a.falignImageWithPoints(bitmap, fArr, 0);
                f332576e = fArr;
                return true;
            }
        }
        return false;
    }

    public static int f(SDKDeviceConfig sDKDeviceConfig) {
        String b16 = b();
        if (TextUtils.isEmpty(b16)) {
            QLog.i("ZPlanCamera", 1, "face bundle not exist");
            return -1000;
        }
        f332572a = new GYAIValidFace();
        f332573b = new GYAIFace();
        new GYAIFaceAuth();
        SDKDeviceConfig sDKDeviceConfig2 = new SDKDeviceConfig();
        sDKDeviceConfig2.setDevice(PreDownloadConstants.RPORT_KEY_CPU);
        int initInstance = f332573b.initInstance(sDKDeviceConfig2);
        if (initInstance != 0) {
            QLog.i("ZPlanCamera", 1, "libface device config init failed");
            return initInstance;
        }
        SDKModelConfig sDKModelConfig = new SDKModelConfig();
        HashMap hashMap = new HashMap();
        sDKModelConfig.modelPaths = hashMap;
        hashMap.put("root-path", b16);
        int i3 = f332573b.setupWithModel(sDKModelConfig);
        if (i3 != 0) {
            QLog.i("ZPlanCamera", 1, "libface face model init failed");
            return i3;
        }
        int initInstance2 = f332572a.initInstance(sDKDeviceConfig2);
        if (initInstance2 != 0) {
            QLog.i("ZPlanCamera", 1, "libvalidface device init failed");
            return initInstance2;
        }
        SDKModelConfig sDKModelConfig2 = new SDKModelConfig();
        String a16 = a();
        HashMap hashMap2 = new HashMap();
        sDKModelConfig2.modelPaths = hashMap2;
        hashMap2.put("bundle-path", a16 + "/");
        int i16 = f332572a.setupWithModel(sDKModelConfig2);
        if (i16 != 0) {
            QLog.i("ZPlanCamera", 1, "libvalidface bundle path init failed");
            return i16;
        }
        f332574c = true;
        return 0;
    }

    public static void g(int i3, String str, com.tencent.mobileqq.zootopia.api.e<bm> eVar) {
        bl blVar = new bl();
        blVar.f440371c = i3;
        blVar.f440370b = str;
        com.tencent.sqshow.zootopia.nativeui.data.k.f371036a.c(blVar, eVar, 0);
    }
}
