package com.tencent.imsdk.offlinePush;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.manager.BaseManager;

/* loaded from: classes7.dex */
public class OfflinePushManager {

    /* loaded from: classes7.dex */
    private static class OfflinePushManagerHolder {
        private static final OfflinePushManager offlinePushManager = new OfflinePushManager();

        OfflinePushManagerHolder() {
        }
    }

    public static OfflinePushManager getInstance() {
        return OfflinePushManagerHolder.offlinePushManager;
    }

    public void doEnterBackground(EnterBackgroundParam enterBackgroundParam, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeDoEnterBackground(enterBackgroundParam, iMCallback);
    }

    public void doEnterForeground(EnterForegroundParam enterForegroundParam, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeDoEnterForeground(enterForegroundParam, iMCallback);
    }

    public void getOfflinePushConfig(IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeGetOfflinePushConfig(iMCallback);
    }

    protected native void nativeDoEnterBackground(EnterBackgroundParam enterBackgroundParam, IMCallback iMCallback);

    protected native void nativeDoEnterForeground(EnterForegroundParam enterForegroundParam, IMCallback iMCallback);

    protected native void nativeGetOfflinePushConfig(IMCallback iMCallback);

    protected native void nativeSetOfflinePushConfig(OfflinePushConfig offlinePushConfig, IMCallback iMCallback);

    protected native void nativeSetOfflinePushToken(OfflinePushToken offlinePushToken, IMCallback iMCallback);

    public void setOfflinePushConfig(OfflinePushConfig offlinePushConfig, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeSetOfflinePushConfig(offlinePushConfig, iMCallback);
    }

    public void setOfflinePushToken(OfflinePushToken offlinePushToken, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeSetOfflinePushToken(offlinePushToken, iMCallback);
    }
}
