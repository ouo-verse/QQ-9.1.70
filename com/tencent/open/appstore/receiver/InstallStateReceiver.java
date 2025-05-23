package com.tencent.open.appstore.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.base.f;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.e;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class InstallStateReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    protected final String f340924a = "InstallStateReceiver";

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i3) {
        List<DownloadInfo> P = DownloadManagerV2.V().P(str, 4);
        if (P.size() == 0) {
            P = DownloadManagerV2.V().Q(str, 4);
        }
        f.a("InstallStateReceiver", ">notifyInstalled " + str + ", info:" + P);
        for (DownloadInfo downloadInfo : P) {
            if (downloadInfo != null && downloadInfo.f() == 4) {
                f.a("InstallStateReceiver", ">notifyInstalled " + downloadInfo);
                if (1 == i3) {
                    DownloadManagerV2.V().i0(downloadInfo);
                } else if (2 == i3) {
                    DownloadManagerV2.V().j0(downloadInfo);
                } else {
                    f.c("InstallStateReceiver", ">notifyInstalled bad notifyType:" + i3);
                }
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        f.a("InstallStateReceiver", "[onReceive] action=" + intent.getAction());
        final String dataString = intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            f.c("InstallStateReceiver", "[onReceive] intentPkgNameString == null ");
            return;
        }
        String[] split = dataString.split(":");
        if (split.length == 2) {
            final String str = split[1];
            String action = intent.getAction();
            if (TextUtils.equals(action, "android.intent.action.PACKAGE_REMOVED")) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.appstore.receiver.InstallStateReceiver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        f.a("InstallStateReceiver", "[onReceive] ACTION_PACKAGE_REMOVED >> " + dataString);
                        if (!TextUtils.isEmpty(str) && str.equals(e.f341509r)) {
                            DownloadManagerV2.V().y(true);
                            MyAppApi.z().f0();
                        }
                        DownloadManagerV2.V().k0(DownloadManagerV2.V().O(str));
                    }
                }, 16, null, true);
                return;
            }
            if (TextUtils.equals(action, "android.intent.action.PACKAGE_REPLACED")) {
                AppCenterReporter.l(str, true);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.appstore.receiver.InstallStateReceiver.2
                    @Override // java.lang.Runnable
                    public void run() {
                        f.a("InstallStateReceiver", "[onReceive] ACTION_PACKAGE_REPLACED >> " + dataString);
                        InstallStateReceiver.this.b(str, 2);
                    }
                }, 16, null, true);
                return;
            } else {
                if (TextUtils.equals(action, "android.intent.action.PACKAGE_ADDED")) {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.appstore.receiver.InstallStateReceiver.3
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z16;
                            if (intent.hasExtra("android.intent.extra.REPLACING")) {
                                z16 = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                            } else {
                                z16 = false;
                            }
                            f.a("InstallStateReceiver", "[onReceive] ACTION_PACKAGE_ADDED >> " + dataString + ",isReplacing:" + z16);
                            if (z16) {
                                return;
                            }
                            AppCenterReporter.l(str, false);
                            InstallStateReceiver.this.b(str, 1);
                        }
                    }, 16, null, true);
                    return;
                }
                return;
            }
        }
        f.c("InstallStateReceiver", "[onReceive] packageName == null " + intent.getDataString());
    }
}
