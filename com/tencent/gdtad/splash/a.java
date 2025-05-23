package com.tencent.gdtad.splash;

import com.qq.e.comm.pi.SrcDownloadPermissionListener;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.impl.GdtAPIImpl;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a implements SrcDownloadPermissionListener {
    private int a(boolean z16, boolean z17) {
        if (!z16 && !((IGdtAPI) QRoute.api(IGdtAPI.class)).getAmsPredownloadNonvideoBackgroundenable()) {
            return 1;
        }
        if (!z17 && ((IGdtAPI) QRoute.api(IGdtAPI.class)).getAmsPredownloadNonvideoNettype() != 1) {
            return 2;
        }
        if (((IGdtAPI) QRoute.api(IGdtAPI.class)).isAmsPredownloadNonVideoDownloadTimeLimit()) {
            return 3;
        }
        ((IGdtAPI) QRoute.api(IGdtAPI.class)).updateAmsPredownloadNonVideo();
        return 0;
    }

    private int b(boolean z16, boolean z17) {
        if (!z16 && !((IGdtAPI) QRoute.api(IGdtAPI.class)).getAmsPredownloadVideoBackgroundEnable()) {
            return 1;
        }
        if (!z17 && ((IGdtAPI) QRoute.api(IGdtAPI.class)).getAmsPredownloadVideoNettype() != 1) {
            return 2;
        }
        if (((IGdtAPI) QRoute.api(IGdtAPI.class)).isAmsPredownloadVideoDownloadTimeLimit()) {
            return 3;
        }
        ((IGdtAPI) QRoute.api(IGdtAPI.class)).updateAmsPredownloadVideo();
        return 0;
    }

    @Override // com.qq.e.comm.pi.SrcDownloadPermissionListener
    public int canDownload(String str, String str2, int i3) {
        boolean z16;
        boolean isApplicationForeground = GuardManager.sInstance.isApplicationForeground();
        boolean isWifiConn = AppNetConnInfo.isWifiConn();
        if (i3 == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d(GdtAPIImpl.TAG, 1, "canDownload isForGround " + isApplicationForeground + " is wifi " + isWifiConn + " is video " + z16);
        if (z16) {
            return b(isApplicationForeground, isWifiConn);
        }
        return a(isApplicationForeground, isWifiConn);
    }
}
