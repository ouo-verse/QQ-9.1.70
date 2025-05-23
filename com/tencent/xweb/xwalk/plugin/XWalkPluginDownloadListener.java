package com.tencent.xweb.xwalk.plugin;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import com.tencent.luggage.wxa.ar.j0;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.wq.l;
import com.tencent.xweb.XWebDownloadListener;
import com.tencent.xweb.XWebDownloader;

@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes27.dex */
public class XWalkPluginDownloadListener implements XWebDownloadListener {
    public static final int RETCODE_CANCELLED = -3;
    public static final int RETCODE_DOWNLOAD_FAILED = -1;
    public static final int RETCODE_INSTALL_FAILED = -2;
    public static final int RETCODE_SUCCESS = 0;

    /* renamed from: a, reason: collision with root package name */
    public final XWalkPluginUpdaterChecker f385147a;

    /* renamed from: b, reason: collision with root package name */
    public final XWalkPlugin f385148b;

    /* renamed from: c, reason: collision with root package name */
    public final j0 f385149c;

    /* renamed from: d, reason: collision with root package name */
    public final l.b f385150d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f385151e;

    public XWalkPluginDownloadListener(XWalkPluginUpdaterChecker xWalkPluginUpdaterChecker, XWalkPlugin xWalkPlugin, j0 j0Var, l.a aVar) {
        int i3;
        l.b bVar = new l.b();
        this.f385150d = bVar;
        this.f385147a = xWalkPluginUpdaterChecker;
        this.f385148b = xWalkPlugin;
        this.f385149c = j0Var;
        bVar.f144375g = aVar;
        if (xWalkPlugin != null) {
            bVar.f144370b = xWalkPlugin.getPluginName();
            bVar.f144371c = xWalkPlugin.getAvailableVersion();
        }
        if (j0Var != null) {
            bVar.f144372d = j0Var.f121684l;
            boolean z16 = j0Var.f121678f;
            if (z16) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            bVar.f144373e = i3;
            bVar.f144374f = j0Var.f121680h;
            this.f385151e = z16;
            return;
        }
        this.f385151e = false;
    }

    @Override // com.tencent.xweb.XWebDownloadListener
    public void onDownloadCancelled() {
        this.f385147a.onNotifyResult(this.f385148b.getPluginName(), -3);
        n0.d(this.f385148b.getPluginName(), this.f385151e);
        XFileSchedulerFactory.getScheduler(this.f385148b.getPluginName()).saveSchedulerConfig(null);
    }

    @Override // com.tencent.xweb.XWebDownloadListener
    public void onDownloadCompleted(XWebDownloader.DownloadInfo downloadInfo) {
        l.b bVar = this.f385150d;
        bVar.f144376h = downloadInfo;
        if (downloadInfo != null && downloadInfo.mStartTimestamp > 0) {
            bVar.f144377i = System.currentTimeMillis() - downloadInfo.mStartTimestamp;
        }
        n0.e(this.f385148b.getPluginName(), this.f385151e);
        XFileSchedulerFactory.getScheduler(this.f385148b.getPluginName()).saveSchedulerConfig(null);
        new AsyncTask<Void, Void, Integer>() { // from class: com.tencent.xweb.xwalk.plugin.XWalkPluginDownloadListener.1
            @Override // android.os.AsyncTask
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer doInBackground(Void... voidArr) {
                XWalkPluginDownloadListener.this.f385150d.f144379k = System.currentTimeMillis();
                if (XWalkPluginDownloadListener.this.f385148b != null && XWalkPluginDownloadListener.this.f385149c != null) {
                    return Integer.valueOf(XWalkPluginDownloadListener.this.f385148b.performInstall(XWalkPluginDownloadListener.this.f385149c));
                }
                return -1;
            }

            @Override // android.os.AsyncTask
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Integer num) {
                XWalkPluginDownloadListener.this.f385150d.f144380l = System.currentTimeMillis();
                XWalkPluginDownloadListener.this.f385150d.f144378j = num.intValue();
                if (num.intValue() == 0) {
                    XWalkPluginDownloadListener.this.f385150d.f144369a = 0;
                    l.a(XWalkPluginDownloadListener.this.f385150d);
                    XWalkPluginDownloadListener.this.f385147a.onNotifyResult(XWalkPluginDownloadListener.this.f385148b.getPluginName(), 0);
                } else {
                    XWalkPluginDownloadListener.this.f385150d.f144369a = -3;
                    l.a(XWalkPluginDownloadListener.this.f385150d);
                    XWalkPluginDownloadListener.this.f385147a.onNotifyResult(XWalkPluginDownloadListener.this.f385148b.getPluginName(), -2);
                }
            }
        }.execute(new Void[0]);
    }

    @Override // com.tencent.xweb.XWebDownloadListener
    public void onDownloadFailed(XWebDownloader.DownloadInfo downloadInfo) {
        this.f385147a.onNotifyResult(this.f385148b.getPluginName(), -1);
        l.b bVar = this.f385150d;
        bVar.f144376h = downloadInfo;
        if (downloadInfo != null && downloadInfo.mStartTimestamp > 0) {
            bVar.f144377i = System.currentTimeMillis() - downloadInfo.mStartTimestamp;
        }
        l.b bVar2 = this.f385150d;
        bVar2.f144369a = -2;
        l.a(bVar2);
        n0.d(this.f385148b.getPluginName(), this.f385151e);
        XFileSchedulerFactory.getScheduler(this.f385148b.getPluginName()).saveSchedulerConfig(null);
    }

    @Override // com.tencent.xweb.XWebDownloadListener
    public void onDownloadStarted(int i3) {
        n0.c(this.f385148b.getPluginName(), this.f385151e);
    }

    @Override // com.tencent.xweb.XWebDownloadListener
    public void onDownloadUpdated(int i3) {
        this.f385147a.onNotifyProgress(this.f385148b.getPluginName(), i3);
    }
}
