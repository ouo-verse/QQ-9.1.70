package com.tencent.open.downloadnew.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.base.f;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;

/* loaded from: classes22.dex */
public class PackageInstallReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    protected final String f341451a = PackageInstallReceiver.class.getName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        f.a(this.f341451a, "onReceive >> " + intent.getAction());
        final String dataString = intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            f.c(this.f341451a, "onReceive intentPkgNameString == null ");
            return;
        }
        String[] split = dataString.split(":");
        if (split.length == 2) {
            final String str = split[1];
            if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.open.downloadnew.common.PackageInstallReceiver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        f.a(PackageInstallReceiver.this.f341451a, "ACTION_PACKAGE_REMOVED >> " + dataString);
                        if (!TextUtils.isEmpty(str) && str.equals(com.tencent.open.downloadnew.e.f341509r)) {
                            DownloadManager.C().h(true);
                            MyAppApi.z().f0();
                        }
                        DownloadManager.C().K(9, new DownloadInfo("", str));
                    }
                }, 5, null, true);
                return;
            } else if (intent.getAction().equals("android.intent.action.PACKAGE_REPLACED")) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.open.downloadnew.common.PackageInstallReceiver.2
                    @Override // java.lang.Runnable
                    public void run() {
                        f.a(PackageInstallReceiver.this.f341451a, "ACTION_PACKAGE_REPLACED >> " + dataString);
                        DownloadManager.C().K(13, new DownloadInfo("", str));
                    }
                }, 5, null, true);
                return;
            } else {
                if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
                    ThreadManagerV2.post(new Runnable() { // from class: com.tencent.open.downloadnew.common.PackageInstallReceiver.3
                        @Override // java.lang.Runnable
                        public void run() {
                            f.a(PackageInstallReceiver.this.f341451a, "ACTION_PACKAGE_ADDED >> " + dataString);
                            DownloadInfo f16 = b.g().f(str);
                            if (f16 != null) {
                                f.a(PackageInstallReceiver.this.f341451a, "ACTION_PACKAGE_ADDED info != null>> " + f16.toString() + " " + f16.f341184e + " " + f16.f341189h);
                                DownloadManager.C().N(f16);
                                np3.a.g().i(101, f16);
                            } else {
                                f16 = new DownloadInfo("", str);
                                f.a(PackageInstallReceiver.this.f341451a, "ACTION_PACKAGE_ADDED info == null>> " + f16.toString());
                            }
                            DownloadManager.C().K(6, f16);
                        }
                    }, 5, null, true);
                    return;
                }
                return;
            }
        }
        f.c(this.f341451a, "onReceive packageName == null " + intent.getDataString());
    }
}
