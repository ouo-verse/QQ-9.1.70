package com.tencent.hippy.qq.utils;

import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyNetworkUtils {
    private static NetworkState networkState = NetworkState.NORMAL;
    private static IWeakNetStatusHandler weakNetStatusHandler = new IWeakNetStatusHandler() { // from class: com.tencent.hippy.qq.utils.HippyNetworkUtils.1
        @Override // com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler
        public void onNormalToWeakNet(int i3) {
            if (QLog.isColorLevel()) {
                QLog.d(HippyQQConstants.HIPPY_TAG, 1, "onNormalToWeakNet reason:", Integer.valueOf(i3));
            }
            HippyNetworkUtils.networkState = NetworkState.WEAK;
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler
        public void onWeakNetToNormal(int i3) {
            if (QLog.isColorLevel()) {
                QLog.d(HippyQQConstants.HIPPY_TAG, 1, "onWeakNetToNormal reason:", Integer.valueOf(i3));
            }
            HippyNetworkUtils.networkState = NetworkState.NORMAL;
        }
    };

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum NetworkState {
        NORMAL,
        INVALID,
        WEAK
    }

    public static NetworkState getNetworkState() {
        if (!AppNetConnInfo.isNetSupport()) {
            return NetworkState.INVALID;
        }
        return networkState;
    }

    public static void registerWeakNetworkObserver() {
        AppNetConnInfo.registerWeakNetStatusHandler(BaseApplication.getContext(), weakNetStatusHandler);
    }

    public static void unregisterWeakNetworkObserver() {
        AppNetConnInfo.unRegisterWeakNetStatusHandler(weakNetStatusHandler);
        networkState = NetworkState.NORMAL;
    }
}
