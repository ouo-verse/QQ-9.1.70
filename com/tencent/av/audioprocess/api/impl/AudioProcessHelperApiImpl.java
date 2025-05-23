package com.tencent.av.audioprocess.api.impl;

import au.f;
import com.tencent.av.audioprocess.api.IAudioProcessApi;
import com.tencent.av.audioprocess.api.IAudioProcessHelperApi;
import com.tencent.avcore.engine.common.IAVEngineCommon;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qav.log.a;

/* loaded from: classes32.dex */
public class AudioProcessHelperApiImpl implements IAudioProcessHelperApi {
    private static final String TAG = "AudioProcessHelperImplApi";
    private static volatile IAVEngineCommon sEngineCommon;
    private static volatile IAudioProcessApi sInstance;
    private static volatile f sSetAudioFrameCallback;

    @Override // com.tencent.av.audioprocess.api.IAudioProcessHelperApi
    public IAudioProcessApi createInstance(IAVEngineCommon iAVEngineCommon, f fVar) {
        if (hasInstance() && sEngineCommon == null) {
            a.g(TAG, "destroyInstance when sEngineCommon == null.");
            destroyInstance();
        }
        synchronized (AudioProcessHelperApiImpl.class) {
            sEngineCommon = iAVEngineCommon;
            sSetAudioFrameCallback = fVar;
            a.e(TAG, "createInstance. sEngineCommon = " + sEngineCommon, new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
        }
        return getInstance();
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessHelperApi
    public void destroyInstance() {
        if (sInstance != null) {
            synchronized (AudioProcessHelperApiImpl.class) {
                if (sInstance != null) {
                    sInstance.unInit();
                }
                sSetAudioFrameCallback = null;
                sEngineCommon = null;
                sInstance = null;
                a.e(TAG, "destroyInstance. sEngineCommon = " + sEngineCommon, new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
            }
        }
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessHelperApi
    public IAudioProcessApi getInstance() {
        if (sInstance == null) {
            synchronized (AudioProcessHelperApiImpl.class) {
                if (sInstance == null) {
                    sInstance = (IAudioProcessApi) QRoute.api(IAudioProcessApi.class);
                    sInstance.init(sEngineCommon, sSetAudioFrameCallback);
                }
            }
        }
        return sInstance;
    }

    @Override // com.tencent.av.audioprocess.api.IAudioProcessHelperApi
    public boolean hasInstance() {
        return sInstance != null;
    }
}
