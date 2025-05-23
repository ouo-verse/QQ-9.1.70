package org.light.detector;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.gyailib.library.FaceDetector;
import com.gyailib.library.FaceDetectorFeature;
import com.gyailib.library.GYAIFace;
import com.gyailib.library.SDKDeviceConfig;
import com.gyailib.library.SDKModelConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.light.bean.LightFaceFeature;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightFaceDetector {
    private static final String DEVICE_CPU = "CPU";
    private static final String MODEL_KEY_ROOT = "face-root";
    private static final String TAG = "LightFaceDetector";
    private static String modelDir = "/sdcard/Android/data/com.tencent.effectmaster/light_assets/models/LightFaceModel.bundle";
    private GYAIFace gyaiFace = new GYAIFace();

    private List<LightFaceFeature> buildFaceList(FaceDetector faceDetector) {
        FaceDetectorFeature[] faceDetectorFeatureArr = faceDetector.faces;
        if (faceDetectorFeatureArr != null && faceDetectorFeatureArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (FaceDetectorFeature faceDetectorFeature : faceDetector.faces) {
                LightFaceFeature lightFaceFeature = new LightFaceFeature();
                float[] fArr = lightFaceFeature.faceBoundsRect;
                fArr[0] = faceDetectorFeature.boundsX;
                fArr[1] = faceDetectorFeature.boundsY;
                fArr[2] = faceDetectorFeature.boundsW;
                fArr[3] = faceDetectorFeature.boundsH;
                lightFaceFeature.yaw = faceDetectorFeature.yaw;
                lightFaceFeature.roll = faceDetectorFeature.roll;
                lightFaceFeature.pitch = faceDetectorFeature.pitch;
                System.arraycopy(faceDetectorFeature.fFeatures256, 0, lightFaceFeature.faceFeature256Points, 0, 512);
                arrayList.add(lightFaceFeature);
            }
            return arrayList;
        }
        return null;
    }

    private SDKModelConfig buildModelConfig() {
        SDKModelConfig sDKModelConfig = new SDKModelConfig();
        HashMap hashMap = new HashMap();
        sDKModelConfig.modelPaths = hashMap;
        hashMap.put(MODEL_KEY_ROOT, modelDir);
        return sDKModelConfig;
    }

    private int initDevice() {
        SDKDeviceConfig sDKDeviceConfig = new SDKDeviceConfig();
        sDKDeviceConfig.setDevice("CPU");
        return this.gyaiFace.initInstance(sDKDeviceConfig);
    }

    private int initModel() {
        return this.gyaiFace.setupWithModel(buildModelConfig());
    }

    public static void updateModelPath(String str) {
        if (!TextUtils.isEmpty(str)) {
            modelDir = str;
        }
    }

    public int clear() {
        GYAIFace gYAIFace = this.gyaiFace;
        if (gYAIFace != null) {
            int cleanupModelData = gYAIFace.cleanupModelData();
            Log.i(TAG, "clear ret:" + cleanupModelData);
            return cleanupModelData;
        }
        return 0;
    }

    public List<LightFaceFeature> detect(Bitmap bitmap, int i3) {
        if (this.gyaiFace != null) {
            FaceDetector faceDetector = new FaceDetector();
            this.gyaiFace.forwardDetect(bitmap, faceDetector, i3);
            return buildFaceList(faceDetector);
        }
        return null;
    }

    public int init() {
        this.gyaiFace = new GYAIFace();
        int initDevice = initDevice();
        if (initDevice != 0) {
            Log.e(TAG, "initDevice ret:" + initDevice);
            return initDevice;
        }
        int initModel = initModel();
        Log.i(TAG, "initModel ret:" + initModel);
        return initModel;
    }
}
