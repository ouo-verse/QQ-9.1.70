package com.tencent.thumbplayer.core.drm;

import com.tencent.thumbplayer.core.utils.TPNativeLog;

/* loaded from: classes26.dex */
public final class TPDrmInterruptCallbackProxy implements ITPDrmInterruptCallback {
    private long mNativeContext;

    TPDrmInterruptCallbackProxy() {
    }

    private native boolean native_isInterrupted();

    @Override // com.tencent.thumbplayer.core.drm.ITPDrmInterruptCallback
    public boolean isInterrupted() {
        try {
            return native_isInterrupted();
        } catch (Throwable th5) {
            TPNativeLog.printLog(0, th5.getMessage());
            return false;
        }
    }
}
