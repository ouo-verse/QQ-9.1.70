package com.tencent.mobileqq.teamwork;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DownloadReceiver4Offline extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        QLog.i("DownloadReceiver4Offline", 1, "DownloadReceiver4Offline onReceive");
        ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).checkAndExecuteDownloadTasks();
    }
}
