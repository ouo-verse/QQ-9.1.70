package org.light.detector;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import com.gyailib.library.GYAIFaceClassify;
import com.gyailib.library.GYDetectCommonItemParams;
import com.gyailib.library.GYDetectCommonResultStruct;
import com.gyailib.library.SDKDeviceConfig;
import com.gyailib.library.SDKModelConfig;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightFaceClassifier {
    private static final String DEVICE_ARM = "ARM";
    private static final String MODEL_KEY = "root-path";
    private static final String TAG = "LightFaceClassifier";
    private static String modelDir = "/sdcard/Android/data/com.tencent.effectmaster/light_assets/models/LightFaceClassify.bundle";
    private GYAIFaceClassify mFaceClassify;

    private SDKModelConfig buildModelConfig() {
        SDKModelConfig sDKModelConfig = new SDKModelConfig();
        HashMap hashMap = new HashMap();
        sDKModelConfig.modelPaths = hashMap;
        hashMap.put(MODEL_KEY, modelDir);
        return sDKModelConfig;
    }

    private int initDevice() {
        SDKDeviceConfig sDKDeviceConfig = new SDKDeviceConfig();
        sDKDeviceConfig.setDevice(DEVICE_ARM);
        return this.mFaceClassify.initInstance(sDKDeviceConfig);
    }

    private int initModel() {
        return this.mFaceClassify.setupWithModel(buildModelConfig());
    }

    public static void setModelDir(String str) {
        modelDir = str;
    }

    public int clear() {
        GYAIFaceClassify gYAIFaceClassify = this.mFaceClassify;
        if (gYAIFaceClassify != null) {
            int cleanupModelData = gYAIFaceClassify.cleanupModelData();
            Log.i(TAG, "clear ret:" + cleanupModelData);
            return cleanupModelData;
        }
        return 0;
    }

    public boolean detect(Bitmap bitmap, Rect rect, float[] fArr, int i3) {
        GYDetectCommonItemParams gYDetectCommonItemParams;
        if (this.mFaceClassify != null) {
            GYDetectCommonResultStruct gYDetectCommonResultStruct = new GYDetectCommonResultStruct();
            this.mFaceClassify.forwardDetect(bitmap, rect, fArr, gYDetectCommonResultStruct, i3);
            GYDetectCommonItemParams[] gYDetectCommonItemParamsArr = gYDetectCommonResultStruct.items;
            if (gYDetectCommonItemParamsArr != null && gYDetectCommonItemParamsArr.length > 0 && (gYDetectCommonItemParams = gYDetectCommonItemParamsArr[0]) != null && gYDetectCommonItemParams.index == 1) {
                return true;
            }
        }
        return false;
    }

    public int init() {
        this.mFaceClassify = new GYAIFaceClassify();
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
