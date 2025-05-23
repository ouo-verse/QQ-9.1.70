package com.tencent.open.downloadnew.common;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.base.f;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d implements DownloadListener {

    /* renamed from: b, reason: collision with root package name */
    protected static d f341488b;

    /* renamed from: a, reason: collision with root package name */
    protected e f341489a;

    public static synchronized d d() {
        d dVar;
        synchronized (d.class) {
            if (f341488b == null) {
                f341488b = new d();
            }
            dVar = f341488b;
        }
        return dVar;
    }

    protected boolean e(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.J == 1 || downloadInfo.N == 1) {
            return true;
        }
        return false;
    }

    protected void f(Message message) {
        if (this.f341489a == null) {
            this.f341489a = new e();
        }
        this.f341489a.sendMessage(message);
    }

    public void g(Looper looper) {
        this.f341489a = new e(looper);
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void installSucceed(String str, String str2) {
        f.h("NoticeDownloadListener", "onInstallSucceed ,appId" + str);
        DownloadInfo x16 = DownloadManager.C().x(str2);
        if (x16 != null && x16.N != 1) {
            Message obtainMessage = this.f341489a.obtainMessage();
            obtainMessage.what = 6;
            Bundle bundle = new Bundle();
            bundle.putString(com.tencent.open.downloadnew.e.f341493b, x16.f341184e);
            obtainMessage.setData(bundle);
            f(obtainMessage);
        }
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadError(DownloadInfo downloadInfo, int i3, String str, int i16) {
        f.h("NoticeDownloadListener", "onDownloadError ,downloadInfo" + downloadInfo);
        if (e(downloadInfo) || downloadInfo.U) {
            return;
        }
        Message obtainMessage = this.f341489a.obtainMessage();
        obtainMessage.what = -2;
        Bundle bundle = new Bundle();
        bundle.putString("appId", downloadInfo.f341184e);
        obtainMessage.setData(bundle);
        obtainMessage.obj = str;
        obtainMessage.arg2 = i16;
        f(obtainMessage);
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadFinish(DownloadInfo downloadInfo) {
        f.h("NoticeDownloadListener", "onDownloadFinish ");
        if (e(downloadInfo) || downloadInfo.U) {
            return;
        }
        Message obtainMessage = this.f341489a.obtainMessage();
        obtainMessage.what = 4;
        Bundle bundle = new Bundle();
        bundle.putString("appId", downloadInfo.f341184e);
        obtainMessage.setData(bundle);
        f(obtainMessage);
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadPause(DownloadInfo downloadInfo) {
        if (e(downloadInfo) || downloadInfo.U) {
            return;
        }
        Message obtainMessage = this.f341489a.obtainMessage();
        obtainMessage.what = 3;
        Bundle bundle = new Bundle();
        bundle.putString("appId", downloadInfo.f341184e);
        obtainMessage.setData(bundle);
        f(obtainMessage);
    }

    @Override // com.tencent.open.downloadnew.DownloadListener
    public void onDownloadUpdate(List<DownloadInfo> list) {
        f.h("NoticeDownloadListener", "onDownloadUpdate notify enter infos=" + list.size());
        for (DownloadInfo downloadInfo : list) {
            if (!e(downloadInfo)) {
                if (downloadInfo.U) {
                    return;
                }
                Message obtainMessage = this.f341489a.obtainMessage();
                obtainMessage.what = 2;
                Bundle bundle = new Bundle();
                bundle.putString("appId", downloadInfo.f341184e);
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
        f.h("NoticeDownloadListener", "onDownloadWait notify enter info.id=" + downloadInfo.f341184e);
        Message obtainMessage = this.f341489a.obtainMessage();
        obtainMessage.what = 20;
        Bundle bundle = new Bundle();
        bundle.putString("appId", downloadInfo.f341184e);
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
