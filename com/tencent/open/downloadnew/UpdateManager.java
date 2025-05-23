package com.tencent.open.downloadnew;

import com.tencent.apkupdate.ApkUpdateListener;
import com.tencent.apkupdate.ApkUpdateParam;
import com.tencent.apkupdate.ApkUpdateSDK;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes22.dex */
public class UpdateManager implements ApkUpdateListener {

    /* renamed from: b, reason: collision with root package name */
    protected static UpdateManager f341420b = null;

    /* renamed from: c, reason: collision with root package name */
    protected static final String f341421c = "com.tencent.open.downloadnew.UpdateManager";

    /* renamed from: a, reason: collision with root package name */
    protected ConcurrentLinkedQueue<a> f341422a = new ConcurrentLinkedQueue<>();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void a(String str);

        void onResult(ArrayList<ApkUpdateDetail> arrayList);
    }

    protected UpdateManager() {
        ApkUpdateSDK.getInstance().init(com.tencent.open.adapter.a.f().e());
        ApkUpdateSDK.getInstance().addListener(this);
    }

    public static UpdateManager d() {
        UpdateManager updateManager;
        synchronized (UpdateManager.class) {
            if (f341420b == null) {
                f341420b = new UpdateManager();
            }
            updateManager = f341420b;
        }
        return updateManager;
    }

    public static synchronized boolean e() {
        boolean z16;
        synchronized (UpdateManager.class) {
            if (f341420b != null) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    public void a(List<String> list) {
        com.tencent.open.base.f.e(f341421c, "checkUpdate>>> list size:" + list.size());
        ApkUpdateSDK.getInstance().checkUpdate(list);
    }

    public void b(List<ApkUpdateParam> list) {
        com.tencent.open.base.f.e(f341421c, "checkUpdate>>> list size:" + list.size());
        ApkUpdateSDK.getInstance().checkUpdateList(list);
    }

    public synchronized void c() {
        try {
            ApkUpdateSDK.getInstance().removeListener(this);
            ApkUpdateSDK.getInstance().destory();
        } catch (Exception e16) {
            com.tencent.open.base.f.b(f341421c, "onDestroy>>>", e16);
        }
        synchronized (UpdateManager.class) {
            f341420b = null;
        }
    }

    public void f(final DownloadInfo downloadInfo) {
        String str = downloadInfo.f341189h;
        String str2 = downloadInfo.L;
        String absolutePath = com.tencent.open.adapter.a.f().e().getFilesDir().getAbsolutePath();
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        final String str3 = absolutePath + "/" + str + ".newGen.apk";
        String str4 = f341421c;
        com.tencent.open.base.f.e(str4, "patchNewApk>>>>>packageName=" + str + ", patchPath=" + str2 + ", newApkPath=" + str3);
        int patchNewApk = ApkUpdateSDK.getInstance().patchNewApk(str, str2, str3);
        if (patchNewApk == 0) {
            com.tencent.open.base.f.e(str4, HardCodeUtil.qqStr(R.string.uue));
            downloadInfo.L = str3;
            if ("com.tencent.mobileqq".equals(downloadInfo.f341189h) && ConfigHandler.e3((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime())) {
                downloadInfo.T = false;
            }
            if ("com.tencent.mobileqq".equals(downloadInfo.f341189h) && DownloadManager.C().J()) {
                int p06 = DownloadManager.C().p0(downloadInfo);
                downloadInfo.f341179a0 = p06;
                if (p06 != 0) {
                    com.tencent.open.base.f.i(str4, "updateManager patchNewApk write code fail......");
                    downloadInfo.k(-2);
                    DownloadManager.C().e(downloadInfo);
                    DownloadManager.C().M(downloadInfo, downloadInfo.f341179a0, null);
                    return;
                }
                downloadInfo.k(4);
                DownloadManager.C().e(downloadInfo);
                com.tencent.open.base.f.a(str4, "info.path = " + downloadInfo.L);
                DownloadManager.C().K(4, downloadInfo);
                if (downloadInfo.T) {
                    DownloadManager.C().I(downloadInfo);
                }
                com.tencent.open.business.base.e.h(IndividuationPlugin.Business_Font, downloadInfo.C, downloadInfo.f341184e, downloadInfo.f341181c0);
                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.UpdateManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            File file2 = new File(str3);
                            if (file2.exists()) {
                                DownloadManager.C().Z(downloadInfo, file2.length());
                            } else {
                                com.tencent.open.base.f.a(UpdateManager.f341421c, "patchNewApk report file not exists");
                            }
                        } catch (Exception e16) {
                            com.tencent.open.base.f.d(UpdateManager.f341421c, "patchNewApk report>>>", e16);
                        }
                    }
                });
                return;
            }
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.UpdateManager.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        File file2 = new File(str3);
                        if (file2.exists()) {
                            downloadInfo.f341180b0 = file2.length();
                            DownloadManager.C().P(downloadInfo);
                        } else {
                            com.tencent.open.base.f.a(UpdateManager.f341421c, "patchNewApk file not exists");
                        }
                    } catch (Exception e16) {
                        com.tencent.open.base.f.d(UpdateManager.f341421c, "patchNewApk>>>", e16);
                    }
                }
            });
            return;
        }
        com.tencent.open.base.f.c(str4, HardCodeUtil.qqStr(R.string.uuf) + patchNewApk);
        DownloadManager.C().K(-24, downloadInfo);
    }

    public synchronized void g(a aVar) {
        this.f341422a.add(aVar);
    }

    public synchronized void h(a aVar) {
        this.f341422a.remove(aVar);
    }

    @Override // com.tencent.apkupdate.ApkUpdateListener
    public void onCheckUpdateFailed(String str) {
        com.tencent.open.base.f.a(f341421c, "onCheckUpdateFailed>>>errMsg=" + str);
        Iterator<a> it = this.f341422a.iterator();
        while (it.hasNext()) {
            it.next().a(str);
        }
    }

    @Override // com.tencent.apkupdate.ApkUpdateListener
    public void onCheckUpdateSucceed(ArrayList arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<a> it = this.f341422a.iterator();
            while (it.hasNext()) {
                it.next().onResult(arrayList);
            }
        }
    }
}
