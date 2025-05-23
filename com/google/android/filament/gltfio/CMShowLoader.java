package com.google.android.filament.gltfio;

import com.tencent.autotemplate.extra.PreDetect;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class CMShowLoader {
    private String[] keyList = {PreDetect.FACE_DETECT, "eyebrow", "eyelash", "mouth", "tongue", "tooth_up", "tooth_down", "eyes_l", "eyes_r"};
    private long mNativeObject;

    public CMShowLoader() {
        long nCreateLoader = nCreateLoader();
        this.mNativeObject = nCreateLoader;
        if (nCreateLoader != 0) {
        } else {
            throw new IllegalStateException("Unable to parse glTF asset.");
        }
    }

    private static native long nCreateLoader();

    private static native void nDestroy(long j3);

    private static native float[] nGetVerticesData(long j3, String str);

    private static native void nReset(long j3);

    private static native void nSetAnimationPath(long j3, String str);

    private static native void nSetFaceJsonPath(long j3, String str);

    private static native void nSetFaceStr(long j3, String str);

    private static native void nSetMorphData(long j3, String str, String[] strArr, float[][] fArr);

    private static native void nSetupKapuModels(long j3, String[] strArr, String[] strArr2);

    public void destroy() {
        nDestroy(this.mNativeObject);
    }

    public HashMap<String, float[]> getBaseData() {
        HashMap<String, float[]> hashMap = new HashMap<>();
        for (String str : this.keyList) {
            float[] verticesData = getVerticesData(str);
            if (verticesData != null) {
                hashMap.put(str, verticesData);
            }
        }
        return hashMap;
    }

    public long getNativeObject() {
        return this.mNativeObject;
    }

    public float[] getVerticesData(String str) {
        return nGetVerticesData(this.mNativeObject, str);
    }

    public void reset() {
        nReset(this.mNativeObject);
    }

    public void setAnimationPath(String str) {
        nSetAnimationPath(this.mNativeObject, str);
    }

    public void setFaceJsonPath(String str) {
        nSetFaceJsonPath(this.mNativeObject, str);
    }

    public void setFaceStr(String str) {
        nSetFaceStr(this.mNativeObject, str);
    }

    public void setKapuModels(Map<String, String> map) {
        nSetupKapuModels(this.mNativeObject, (String[]) map.keySet().toArray(new String[0]), (String[]) map.values().toArray(new String[0]));
    }

    public void setMorphData(String str, Map<String, float[]> map) {
        nSetMorphData(this.mNativeObject, str, (String[]) map.keySet().toArray(new String[0]), (float[][]) map.values().toArray(new float[0]));
    }
}
