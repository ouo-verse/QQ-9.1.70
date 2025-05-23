package com.tencent.gamecenter.wadl.sdk.ipc;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGamePCDNApi;
import com.tencent.gamecenter.wadl.api.WadlRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.g;
import com.tencent.gamecenter.wadl.sdk.dlapt.WadlAgentV2Adapter;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTask;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlRemoteHandler implements INetEventHandler {
    private static final byte[] LOCK = new byte[0];
    private static final String TAG = "Wadl_WadlRemoteHandler";
    private static volatile WadlRemoteHandler instance;
    private boolean isCreate;
    private long lastRefNetTime = 0;
    private int oneSecond = 1000;
    private int halfSecond = 500;

    WadlRemoteHandler() {
        QLog.d(TAG, 1, "new Instance,init begin");
        long currentTimeMillis = System.currentTimeMillis();
        g gVar = (g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
        gVar = gVar == null ? new g(IQQGameConfigService.KEY_CONF_COMM) : gVar;
        QLog.d(TAG, 1, "WadlConfigCenter init");
        QLog.d(TAG, 1, " parseDPC isAppointDownload=" + gVar.f106807t + ",isDelayDownload=" + gVar.f106806s + ",isUpdateDownload=" + gVar.f106808u + ",isResApkDownload=" + gVar.f106809v + ",isResDefDownload=" + gVar.f106810w);
        try {
            AppNetConnInfo.registerNetChangeReceiver(MobileQQ.sMobileQQ, this);
            QLog.d(TAG, 1, "registerNetChangeReceiver");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "init exception", th5);
        }
        ABTestController.getInstance().doInit1505SubProc();
        ((IQQGamePCDNApi) QRoute.api(IQQGamePCDNApi.class)).checkAndLoadSoAsync();
        QLog.d(TAG, 1, "new Instance,init end, cost=" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public static WadlRemoteHandler getInstance() {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = new WadlRemoteHandler();
                }
            }
        }
        return instance;
    }

    public void handleRemoteActionNotify(WadlRequest wadlRequest) {
        int i3 = 1;
        QLog.d(TAG, 1, "handleRemoteActionNotify wadlRequest=" + wadlRequest);
        if (wadlRequest != null && !TextUtils.isEmpty(wadlRequest.f106594e)) {
            int i16 = wadlRequest.f106593d;
            if (Integer.MAX_VALUE == i16) {
                if (WadlProxyConsts.REMOTE_CMD_APP_DELETE_ALL_ACTION.equals(wadlRequest.f106594e)) {
                    while (i3 <= 3) {
                        WadlHandlerInterface businessHandler = WadlHandlerFactory.getBusinessHandler(i3);
                        if (businessHandler != null) {
                            businessHandler.clearAllTask();
                        }
                        i3++;
                    }
                    String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(GameCenterUtil.DIR_PRE);
                    if (new File(sDKPrivatePath).exists()) {
                        FileUtils.deleteDirectory(sDKPrivatePath);
                    }
                    WadlAgentV2Adapter.getInstance().deleteAllTask();
                    return;
                }
                while (i3 <= 3) {
                    WadlHandlerInterface businessHandler2 = WadlHandlerFactory.getBusinessHandler(i3);
                    if (businessHandler2 != null) {
                        businessHandler2.handleRemoteActionNotify(wadlRequest);
                    }
                    i3++;
                }
                return;
            }
            WadlHandlerInterface businessHandler3 = WadlHandlerFactory.getBusinessHandler(i16);
            if (businessHandler3 != null) {
                businessHandler3.handleRemoteActionNotify(wadlRequest);
            } else {
                QLog.w(TAG, 1, "handleRemoteActionNotify UnKnow businessId");
            }
        }
    }

    public boolean isAnyTaskActive(boolean z16) {
        for (int i3 = 1; i3 <= 3; i3++) {
            WadlHandlerInterface businessHandler = WadlHandlerFactory.getBusinessHandler(i3);
            if (businessHandler != null && businessHandler.isActive(z16)) {
                return true;
            }
        }
        return false;
    }

    public void notifyEventObserver(int i3, int i16, boolean z16, WadlTask wadlTask) {
        WadlHandlerInterface businessHandler = WadlHandlerFactory.getBusinessHandler(i3);
        if (businessHandler != null) {
            businessHandler.notifyEventObserver(i16, z16, wadlTask);
        }
    }

    public void onCreate() {
        QLog.d(TAG, 1, "onCreate isCreate=" + this.isCreate);
        if (this.isCreate) {
            return;
        }
        this.isCreate = true;
        for (int i3 = 1; i3 <= 3; i3++) {
            WadlHandlerInterface businessHandler = WadlHandlerFactory.getBusinessHandler(i3);
            if (businessHandler != null) {
                businessHandler.onCreate();
            }
        }
    }

    public void onDestroy() {
        QLog.d(TAG, 1, "onDestroy...");
        AppNetConnInfo.unregisterNetEventHandler(this);
        WadlHandlerFactory.destroy();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
    public void onNetChangeEvent(boolean z16) {
        QLog.d(TAG, 1, "onNetChangeEvent:" + z16);
        long currentTimeMillis = System.currentTimeMillis();
        if (AppNetConnInfo.isWifiConn()) {
            QLog.d(TAG, 1, "wifi connect");
            if (currentTimeMillis - this.lastRefNetTime > this.halfSecond) {
                this.lastRefNetTime = currentTimeMillis;
                for (int i3 = 1; i3 <= 3; i3++) {
                    WadlHandlerInterface businessHandler = WadlHandlerFactory.getBusinessHandler(i3);
                    if (businessHandler != null) {
                        businessHandler.resumeAllDownloadTask();
                    }
                }
                return;
            }
            return;
        }
        QLog.d(TAG, 1, "isMobileConn=" + AppNetConnInfo.isMobileConn());
        if (currentTimeMillis - this.lastRefNetTime > this.oneSecond) {
            this.lastRefNetTime = currentTimeMillis;
            for (int i16 = 1; i16 <= 3; i16++) {
                WadlHandlerInterface businessHandler2 = WadlHandlerFactory.getBusinessHandler(i16);
                if (businessHandler2 != null) {
                    businessHandler2.pauseAllDownloadTask(true);
                }
            }
        }
    }
}
