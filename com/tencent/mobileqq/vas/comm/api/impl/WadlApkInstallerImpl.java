package com.tencent.mobileqq.vas.comm.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.vas.comm.api.IWadlApkInstaller;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WadlApkInstallerImpl implements IWadlApkInstaller {
    public static final String TAG = "Installer_WadlApkInstallerImpl";

    @Override // com.tencent.mobileqq.vas.comm.api.IWadlApkInstaller
    public void receiveGameDownloadInstall(Context context, Intent intent) {
        Intent intent2 = new Intent(WadlProxyConsts.ACTION_GAME_CENTER_CUSTOM_INSTALL_ACTION);
        intent2.setPackage(MobileQQ.sMobileQQ.getPackageName());
        intent2.putExtra("key_broadcast_intent", intent);
        MobileQQ.sMobileQQ.sendBroadcast(intent2);
    }
}
