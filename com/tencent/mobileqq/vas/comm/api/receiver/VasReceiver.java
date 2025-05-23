package com.tencent.mobileqq.vas.comm.api.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.gamecenter.wadl.api.IQQGameDLService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.api.IMetaFarmWidgetApi;
import com.tencent.mobileqq.minigame.metafarm.data.MetaFarmConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.comm.api.IWadlApkInstaller;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasReceiver extends BroadcastReceiver {
    /* JADX INFO: Access modifiers changed from: private */
    public static void b() {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vas.comm.api.receiver.VasReceiver.5
            @Override // java.lang.Runnable
            public void run() {
                ((IMetaFarmWidgetApi) QRoute.api(IMetaFarmWidgetApi.class)).updateWidgetData(3);
            }
        }, 16, null, false, 5000L);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        QLog.i("VasReceiver", 1, "onReceive action=" + action);
        if ("com.gamedownload.install".equals(action)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.comm.api.receiver.VasReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    ((IWadlApkInstaller) QRoute.api(IWadlApkInstaller.class)).receiveGameDownloadInstall(context, intent);
                }
            }, 16, null, false);
            return;
        }
        if (WadlProxyConsts.ACTION_GAME_CENTER_ACTION.equals(action)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.comm.api.receiver.VasReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    WadlProxyServiceUtil.getProxyService().receiveGameCenterAction(intent);
                }
            }, 16, null, false);
        } else if (WadlProxyConsts.ACTION_VM_ACTION.equals(action)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.comm.api.receiver.VasReceiver.3
                @Override // java.lang.Runnable
                public void run() {
                    IQQGameDLService iQQGameDLService;
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime != null) {
                        iQQGameDLService = (IQQGameDLService) peekAppRuntime.getRuntimeService(IQQGameDLService.class, ProcessConstant.MULTI);
                    } else {
                        iQQGameDLService = null;
                    }
                    if (iQQGameDLService != null) {
                        iQQGameDLService.receiveVMAction(intent);
                    }
                }
            }, 16, null, false);
        } else if (MetaFarmConstants.UPDATE_WIDGET_RECEIVER_ACTION.equals(action)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.comm.api.receiver.VasReceiver.4
                @Override // java.lang.Runnable
                public void run() {
                    ((IMetaFarmWidgetApi) QRoute.api(IMetaFarmWidgetApi.class)).updateWidgetData(3);
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime == null || !peekAppRuntime.isLogin()) {
                        QLog.i("VasReceiver", 1, "is not login, check update delay!");
                        VasReceiver.b();
                    }
                }
            }, 16, null, false);
        }
    }
}
