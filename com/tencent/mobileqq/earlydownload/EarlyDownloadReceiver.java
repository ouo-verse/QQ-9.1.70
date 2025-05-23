package com.tencent.mobileqq.earlydownload;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.QQBroadcastReceiver;

/* compiled from: P */
/* loaded from: classes5.dex */
public class EarlyDownloadReceiver extends QQBroadcastReceiver {
    static IPatchRedirector $redirector_;

    public EarlyDownloadReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.QQBroadcastReceiver
    public void onReceive(AppRuntime appRuntime, Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, context, intent);
            return;
        }
        if (MobileQQ.sProcessId == 1) {
            if (appRuntime.isLogin()) {
                ((IEarlyDownloadService) appRuntime.getRuntimeService(IEarlyDownloadService.class, "")).handleBroadcastReq(intent);
                return;
            }
            Intent intent2 = new Intent(intent.getAction().replace("req.", "resp."));
            intent2.putExtra("strResName", intent.getStringExtra("strResName"));
            intent2.putExtra("strPkgName", intent.getStringExtra("strPkgName"));
            intent2.putExtra("reqResult", false);
            intent2.putExtra("resultReason", "app is not login.");
            context.sendBroadcast(intent2);
        }
    }
}
