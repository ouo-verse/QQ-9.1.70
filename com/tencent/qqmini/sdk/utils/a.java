package com.tencent.qqmini.sdk.utils;

import android.app.Activity;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a {
    public static void a(Activity activity, BaseRuntime baseRuntime, boolean z16, boolean z17, boolean z18) {
        boolean z19;
        QMLog.w("MiniGameUtils", "handleMiniExit finishActivity: " + z16 + ", killProcess:" + z17 + ", moveToBack:" + z18);
        if (z16 && !ViewUtils.isActivityInvalid(activity)) {
            activity.finish();
        }
        if (z17) {
            ProcessUtil.exitProcess(activity);
        }
        if (z18) {
            boolean z26 = false;
            if (baseRuntime != null && baseRuntime.isMiniGame()) {
                z19 = true;
            } else {
                z19 = false;
            }
            try {
                z26 = activity.moveTaskToBack(z19);
            } catch (Throwable unused) {
            }
            if (!z26) {
                QMLog.e("MiniGameUtils", "moveTaskToBack failed, finish the activity.");
                if (!ViewUtils.isActivityInvalid(activity)) {
                    activity.finish();
                }
            }
        }
        QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
        if (qQCustomizedProxy != null) {
            qQCustomizedProxy.handleMiniExit(activity, baseRuntime, z16, z17, z18);
        }
    }

    public static void b(IMiniAppContext iMiniAppContext, MiniAppConst.RuntimeCloseType runtimeCloseType) {
        AppStateEvent.obtain(72, runtimeCloseType).notifyRuntime(iMiniAppContext);
    }
}
