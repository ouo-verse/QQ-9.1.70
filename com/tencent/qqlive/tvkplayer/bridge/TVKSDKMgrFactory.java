package com.tencent.qqlive.tvkplayer.bridge;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKSDKMgrFactory implements ITVKSDKMgrFactory {
    private static final String TAG = "TVKPlayer[TVKSDKMgrFactory]";

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f345786a = 0;
    private static TVKSDKMgrFactory mInstance;

    TVKSDKMgrFactory() {
    }

    public static synchronized ITVKSDKMgrFactory getSDKMgrFactoryInstance() {
        TVKSDKMgrFactory tVKSDKMgrFactory;
        synchronized (TVKSDKMgrFactory.class) {
            if (mInstance == null) {
                mInstance = new TVKSDKMgrFactory();
            }
            tVKSDKMgrFactory = mInstance;
        }
        return tVKSDKMgrFactory;
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKMgrFactory
    public ITVKSDKInitBridge getSdkMgrInstance() {
        return TVKSDKMgrWrapper.getSdkMgrWrapperInstance();
    }
}
