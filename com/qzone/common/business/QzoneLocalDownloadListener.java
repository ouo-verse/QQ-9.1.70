package com.qzone.common.business;

import android.text.TextUtils;
import com.qzone.canvasui.gdtui.prenster.DownloadImmediatelyContract;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.cl;
import com.tencent.open.base.f;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneLocalDownloadListener implements DownloadListener {

    /* renamed from: b, reason: collision with root package name */
    protected static QzoneLocalDownloadListener f45583b;

    /* renamed from: a, reason: collision with root package name */
    private List<DownloadImmediatelyContract.Presenter> f45584a = new CopyOnWriteArrayList();

    QzoneLocalDownloadListener() {
    }

    public static synchronized QzoneLocalDownloadListener d() {
        QzoneLocalDownloadListener qzoneLocalDownloadListener;
        synchronized (QzoneLocalDownloadListener.class) {
            if (f45583b == null) {
                f45583b = new QzoneLocalDownloadListener();
            }
            qzoneLocalDownloadListener = f45583b;
        }
        return qzoneLocalDownloadListener;
    }

    private void f(String str) {
        DownloadImmediatelyContract.Presenter presenter;
        try {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            copyOnWriteArrayList.addAll(this.f45584a);
            Iterator it = copyOnWriteArrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    presenter = null;
                    break;
                }
                presenter = (DownloadImmediatelyContract.Presenter) it.next();
                if (presenter != null && !TextUtils.isEmpty(presenter.getAppId()) && !TextUtils.isEmpty(str) && presenter.getAppId().equals(str)) {
                    presenter.updateDownloadStatus(presenter.getDownloadStatus(), 0);
                    break;
                }
            }
            if (presenter != null) {
                copyOnWriteArrayList.remove(presenter);
            }
            this.f45584a = copyOnWriteArrayList;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void g(DownloadImmediatelyContract.Presenter presenter) {
        if (this.f45584a.size() != 0 && this.f45584a.contains(presenter)) {
            this.f45584a.remove(presenter);
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void installSucceed(String str, String str2) {
        f.h("QzoneLocalDownloadListener", "onInstallSucceed ,appId =" + str);
        f(str);
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadFinish(DownloadInfo downloadInfo) {
        f.h("QzoneLocalDownloadListener", "onDownloadFinish ");
        if (downloadInfo == null || downloadInfo.J == 1) {
            return;
        }
        if (!TextUtils.isEmpty(downloadInfo.f341184e) && !TextUtils.isEmpty(downloadInfo.L)) {
            cl.j(BaseApplication.getContext(), downloadInfo.f341184e, downloadInfo.L);
        }
        e(downloadInfo);
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void uninstallSucceed(String str, String str2) {
        f.h("QzoneLocalDownloadListener", "uninstallSucceed ,appId=" + str);
        f(str);
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadError(DownloadInfo downloadInfo, int i3, String str, int i16) {
        if (downloadInfo == null || downloadInfo.J == 1) {
            return;
        }
        if (i3 == -24) {
            cl.g(BaseApplication.getContext(), downloadInfo.f341184e);
        }
        f.h("QzoneLocalDownloadListener", "onDownloadError ,downloadInfo" + downloadInfo);
        e(downloadInfo);
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadWait(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.J == 1) {
            return;
        }
        f.h("QzoneLocalDownloadListener", "onDownloadWait info appId = " + downloadInfo.f341184e + "packageName =" + downloadInfo.f341189h + "via = " + downloadInfo.C + "apkId =" + downloadInfo.H);
        e(downloadInfo);
    }

    private void e(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        for (final DownloadImmediatelyContract.Presenter presenter : this.f45584a) {
            if (presenter != null && !TextUtils.isEmpty(presenter.getAppId()) && !TextUtils.isEmpty(downloadInfo.f341184e) && presenter.getAppId().equals(downloadInfo.f341184e)) {
                final int a16 = com.qzone.common.business.service.a.a(downloadInfo.f());
                final int i3 = downloadInfo.Q;
                ThreadManager.getUIHandler().postAtFrontOfQueue(new Runnable() { // from class: com.qzone.common.business.QzoneLocalDownloadListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i16 = a16;
                        if (i16 == 1 && i3 == 0) {
                            return;
                        }
                        presenter.updateDownloadStatus(i16, i3);
                    }
                });
            }
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadCancel(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        f.h("QzoneLocalDownloadListener", "onDownloadCancel ,appId =" + downloadInfo.f341184e);
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadPause(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        f.h("QzoneLocalDownloadListener", "onDownloadPause " + downloadInfo.f341184e);
        if (downloadInfo.J == 1) {
            return;
        }
        e(downloadInfo);
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadUpdate(List<DownloadInfo> list) {
        if (list == null) {
            return;
        }
        f.h("QzoneLocalDownloadListener", "onDownloadUpdate notify enter infos=" + list.size());
        for (DownloadInfo downloadInfo : list) {
            if (downloadInfo != null && downloadInfo.J != 1) {
                f.h("QzoneLocalDownloadListener", "onDownloadUpdate info appId = " + downloadInfo.f341184e + "packageName =" + downloadInfo.f341189h + "via = " + downloadInfo.C + "apkId =" + downloadInfo.H);
                e(downloadInfo);
            }
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void packageReplaced(String str, String str2) {
    }
}
