package com.tencent.mobileqq.vas.comm.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IWadlApkInstaller extends QRouteApi {
    void receiveGameDownloadInstall(Context context, Intent intent);
}
