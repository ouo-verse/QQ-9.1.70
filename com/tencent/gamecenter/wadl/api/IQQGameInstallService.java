package com.tencent.gamecenter.wadl.api;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.ApkParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import nl0.b;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IQQGameInstallService extends QRouteApi {
    public static final String K_ABTEST_WHITE_APPIDS = "white_appids";
    public static final int STATUS_ABORT = 2;
    public static final int STATUS_SEND_CONFIRM = 1;

    void addInstallListener(b bVar);

    void checkInstallModel(WadlParams wadlParams, String str, long j3);

    boolean execInstallCommand(PackageInstaller packageInstaller, int i3, ApkParams apkParams);

    boolean isInstallModelChecked(String str);

    void onReceiveCustomInstallBroadcast(Context context, Intent intent);

    void removeInstallListener(b bVar);

    void saveInstallModelChecked(String str);

    void selectInstaller(Bundle bundle);
}
