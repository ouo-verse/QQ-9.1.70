package com.qq.e.comm.plugin.ipc;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.SystemUtil;

/* loaded from: classes3.dex */
public final class IPCUtil {
    public static boolean isIPCValid() {
        return false;
    }

    public static boolean isMainProcess(Context context) {
        if (!isIPCValid() || context == null || SDKStatus.getSDKVersionCode() < 220) {
            return true;
        }
        String ipcServerProcessName = GDTADManager.getIpcServerProcessName();
        GDTLogger.d("isMainProcess getMainProcessName:" + ipcServerProcessName);
        if (ipcServerProcessName == null) {
            return true;
        }
        return TextUtils.equals(ipcServerProcessName, SystemUtil.getProcessName(context));
    }

    public static boolean isWebProcess(Context context) {
        if (!isIPCValid() || context == null || context.getApplicationContext() == null || SDKStatus.getSDKVersionCode() < 220) {
            return false;
        }
        String str = context.getApplicationContext().getPackageName() + ":tangramweb";
        GDTLogger.d("isWebProcess webProcessName:" + str);
        return TextUtils.equals(str, SystemUtil.getProcessName(context));
    }
}
