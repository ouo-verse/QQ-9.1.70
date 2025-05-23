package com.tencent.thumbplayer.core.utils;

import android.graphics.SurfaceTexture;
import com.tencent.thumbplayer.common.log.TPLogUtil;

/* loaded from: classes26.dex */
public class TPOnFrameAvailableListener implements SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "TPOnFrameAvailableListener";

    @TPFieldCalledByNative
    private long mOnFrameAvailableListenerContext;

    private native void native_onFrameAvailable();

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        try {
            native_onFrameAvailable();
        } catch (UnsatisfiedLinkError unused) {
            TPLogUtil.e(TAG, "cannot find method native_onFrameAvailable");
        }
    }
}
