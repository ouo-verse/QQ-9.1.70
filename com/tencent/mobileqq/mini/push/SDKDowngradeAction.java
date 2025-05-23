package com.tencent.mobileqq.mini.push;

import android.content.Intent;
import android.os.Process;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.aq;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SDKDowngradeAction implements PushAction {
    public static final String KEY_DOWNGRADE = "downgrade";
    public static final String TAG = "SDKDowngradeAction";

    @Override // com.tencent.mobileqq.mini.push.PushAction
    public void exec(MiniAppControlInfo miniAppControlInfo) {
        if (miniAppControlInfo.data.containsKey(KEY_DOWNGRADE)) {
            int parseInt = Integer.parseInt(miniAppControlInfo.data.get(KEY_DOWNGRADE));
            Boolean valueOf = Boolean.valueOf(parseInt == 1);
            QLog.d(TAG, 1, "SDKDowngradeAction downgrade:" + parseInt);
            if (aq.k() != valueOf.booleanValue()) {
                QLog.d(TAG, 1, "SDKDowngradeAction do downgrade:" + parseInt);
                Intent intent = new Intent(MiniAppInterface.ACTION_MINI_PROCESS_EXIT);
                intent.setPackage(MobileQQ.PACKAGE_NAME);
                BaseApplication.getContext().sendBroadcast(intent);
                aq.m(valueOf.booleanValue());
                ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.push.SDKDowngradeAction.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SystemMethodProxy.killProcess(Process.myPid());
                    }
                }, 3000L);
                return;
            }
            QLog.d(TAG, 1, "SDKDowngradeAction not do downgrade:" + parseInt);
            return;
        }
        QLog.d(TAG, 1, "UploadLogAction has no appid parameter! " + miniAppControlInfo);
    }
}
