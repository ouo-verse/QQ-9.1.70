package com.tencent.open.appstore.notice;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f implements DownloadListener {

    /* renamed from: b, reason: collision with root package name */
    protected static f f340922b;

    /* renamed from: a, reason: collision with root package name */
    protected e f340923a;

    public static synchronized f d() {
        f fVar;
        synchronized (f.class) {
            if (f340922b == null) {
                f340922b = new f();
            }
            fVar = f340922b;
        }
        return fVar;
    }

    protected boolean e(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.J == 1 || downloadInfo.N == 1) {
            return true;
        }
        return false;
    }

    protected void f(Message message) {
        if (this.f340923a == null) {
            this.f340923a = new e();
        }
        this.f340923a.sendMessage(message);
    }

    public void g(Looper looper) {
        this.f340923a = new e(looper);
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void installSucceed(String str, String str2) {
        com.tencent.open.base.f.h("NoticeListener", "onInstallSucceed ,appId" + str);
        DownloadInfo x16 = DownloadManager.C().x(str2);
        if (x16 != null && x16.N != 1) {
            Message obtainMessage = this.f340923a.obtainMessage();
            obtainMessage.what = 6;
            Bundle bundle = new Bundle();
            bundle.putString(com.tencent.open.downloadnew.e.f341492a, x16.f341182d);
            obtainMessage.setData(bundle);
            f(obtainMessage);
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadError(DownloadInfo downloadInfo, int i3, String str, int i16) {
        com.tencent.open.base.f.h("NoticeListener", "onDownloadError ,downloadInfo" + downloadInfo);
        if (e(downloadInfo) || downloadInfo.U) {
            return;
        }
        Message obtainMessage = this.f340923a.obtainMessage();
        obtainMessage.what = -2;
        Bundle bundle = new Bundle();
        bundle.putString(com.tencent.open.downloadnew.e.f341492a, downloadInfo.f341182d);
        obtainMessage.setData(bundle);
        obtainMessage.obj = str;
        obtainMessage.arg2 = i16;
        f(obtainMessage);
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadFinish(DownloadInfo downloadInfo) {
        com.tencent.open.base.f.h("NoticeListener", "onDownloadFinish ");
        if (e(downloadInfo) || downloadInfo.U) {
            return;
        }
        Message obtainMessage = this.f340923a.obtainMessage();
        obtainMessage.what = 4;
        Bundle bundle = new Bundle();
        bundle.putString(com.tencent.open.downloadnew.e.f341492a, downloadInfo.f341182d);
        obtainMessage.setData(bundle);
        f(obtainMessage);
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadPause(DownloadInfo downloadInfo) {
        if (e(downloadInfo) || downloadInfo.U) {
            return;
        }
        Message obtainMessage = this.f340923a.obtainMessage();
        obtainMessage.what = 3;
        Bundle bundle = new Bundle();
        bundle.putString(com.tencent.open.downloadnew.e.f341492a, downloadInfo.f341182d);
        obtainMessage.setData(bundle);
        f(obtainMessage);
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadUpdate(List<DownloadInfo> list) {
        com.tencent.open.base.f.h("NoticeListener", "onDownloadUpdate notify enter infos=" + list.size());
        for (DownloadInfo downloadInfo : list) {
            com.tencent.open.base.f.c("NoticeListener", "update,notificationStyle" + downloadInfo.N);
            if (!e(downloadInfo)) {
                if (downloadInfo.U) {
                    return;
                }
                Message obtainMessage = this.f340923a.obtainMessage();
                obtainMessage.what = 2;
                Bundle bundle = new Bundle();
                bundle.putString(com.tencent.open.downloadnew.e.f341492a, downloadInfo.f341182d);
                obtainMessage.setData(bundle);
                f(obtainMessage);
            }
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadWait(DownloadInfo downloadInfo) {
        if (e(downloadInfo) || downloadInfo.U) {
            return;
        }
        com.tencent.open.base.f.h("NoticeListener", "onDownloadWait notify enter info.id=" + downloadInfo.f341184e);
        Message obtainMessage = this.f340923a.obtainMessage();
        obtainMessage.what = 20;
        Bundle bundle = new Bundle();
        bundle.putString(com.tencent.open.downloadnew.e.f341492a, downloadInfo.f341182d);
        obtainMessage.setData(bundle);
        f(obtainMessage);
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadCancel(DownloadInfo downloadInfo) {
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void packageReplaced(String str, String str2) {
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void uninstallSucceed(String str, String str2) {
    }
}
