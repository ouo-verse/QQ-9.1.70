package com.tencent.hippy.qq.ipc;

import android.os.Bundle;
import com.tencent.hippy.qq.api.IHippyIPC;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.statemachine.MainStateManager;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyIpcModule extends QIPCModule {
    public static final String IPC_BUNDLE_KEY_BUNDLE_NAME = "bundle_name";
    public static final String IPC_BUNDLE_KEY_BUNDLE_VERSION = "bundle_version";
    public static HippyIpcModule mInstance;

    public HippyIpcModule() {
        super(IHippyIPC.NAME);
    }

    public static synchronized HippyIpcModule getInstance() {
        HippyIpcModule hippyIpcModule;
        synchronized (HippyIpcModule.class) {
            if (mInstance == null) {
                synchronized (HippyIpcModule.class) {
                    if (mInstance == null) {
                        mInstance = new HippyIpcModule();
                    }
                }
            }
            hippyIpcModule = mInstance;
        }
        return hippyIpcModule;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(IHippyIPC.NAME, 2, "action = " + str + ", params = " + bundle + ",callbackId=" + i3);
        }
        if (IHippyIPC.ACTION_PRELOAD_HIPPY.equals(str)) {
            HippyAccessHelper.checkAndPreloadHippyPage(new OpenHippyInfo(bundle.getBundle(IHippyIPC.BUNDLE_HIPPY_INFO)));
            callbackResult(i3, EIPCResult.createResult(0, new Bundle()));
            return null;
        }
        if (IHippyIPC.ACTION_REMOVE_PRELOADED_HIPPY.equals(str)) {
            HippyAccessHelper.checkAndDestroyPreloadHippy(new OpenHippyInfo(bundle.getBundle(IHippyIPC.BUNDLE_HIPPY_INFO)));
            callbackResult(i3, EIPCResult.createResult(0, new Bundle()));
            return null;
        }
        if (IHippyIPC.ACTION_GET_MAIN_STATE.equals(str)) {
            String currentState = MainStateManager.getInstance().getCurrentState();
            Bundle bundle2 = new Bundle();
            bundle2.putString(IHippyIPC.KEY_CURRENT_MAIN_STATE, currentState);
            return EIPCResult.createSuccessResult(bundle2);
        }
        if (IHippyIPC.ACTION_IS_CLEARING_HIPPY_CACHE.equals(str)) {
            Bundle bundle3 = new Bundle();
            bundle3.putBoolean(IHippyIPC.KEY_IS_CLEAR_HIPPY_CACHE, ((IHippySetting) QRoute.api(IHippySetting.class)).isClearingCache());
            return EIPCResult.createSuccessResult(bundle3);
        }
        return null;
    }
}
