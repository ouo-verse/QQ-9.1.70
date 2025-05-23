package com.tencent.av.camera.api.impl;

import android.content.Context;
import com.tencent.av.camera.AVCameraManagerImpl;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.camera.api.ICameraUtilsStaticApi;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CameraUtilsStaticApiImpl implements ICameraUtilsStaticApi {
    private static volatile ICameraManagerApi sInstance;

    @Override // com.tencent.av.camera.api.ICameraUtilsStaticApi
    public ICameraManagerApi getInstance(Context context) {
        if (sInstance == null) {
            synchronized (CameraUtilsStaticApiImpl.class) {
                if (sInstance == null) {
                    sInstance = new AVCameraManagerImpl();
                    sInstance.setUp(context);
                }
            }
        }
        return sInstance;
    }
}
