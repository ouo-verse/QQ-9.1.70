package com.yolo.esports.download.common;

import android.text.TextUtils;
import com.tencent.hlyyb.HalleyAgent;
import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import com.tencent.hlyyb.downloader.DownloaderTaskPriority;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.w;
import com.tencent.timi.game.utils.x;
import com.yolo.esports.download.cb.TaskCallbackCenter;
import com.yolo.esports.download.cb.b;
import com.yolo.esports.download.util.SpaceUtils;
import g05.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes28.dex */
public class HalleyDownloaderProxy {

    /* renamed from: g, reason: collision with root package name */
    private static volatile HalleyDownloaderProxy f390019g;

    /* renamed from: a, reason: collision with root package name */
    private d f390020a;

    /* renamed from: c, reason: collision with root package name */
    Downloader f390022c;

    /* renamed from: d, reason: collision with root package name */
    private b f390023d;

    /* renamed from: b, reason: collision with root package name */
    private com.yolo.esports.download.common.a f390021b = new com.yolo.esports.download.common.a();

    /* renamed from: e, reason: collision with root package name */
    private List<DownloaderTask> f390024e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private INetInfoHandler f390025f = new a();

    HalleyDownloaderProxy() {
    }

    private boolean d(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.M == 4) {
            l.i("HalleyDownloaderProxy_", ">alreadySuccCheck \u72b6\u6001\u4e3a\u4e0b\u8f7d\u5b8c\u6210" + downloadInfo);
            if (downloadInfo.v()) {
                return true;
            }
            l.i("HalleyDownloaderProxy_", ">alreadySuccCheck \u6587\u4ef6\u5f02\u5e38\u5220\u9664\u4efb\u52a1" + downloadInfo);
            e(downloadInfo.s(), false);
            downloadInfo.x();
        }
        return false;
    }

    private void f(DownloadInfo downloadInfo) {
        DownloaderTask i3 = i(downloadInfo.f390014e);
        if (i3 != null) {
            l.i("HalleyDownloaderProxy_", "deleteTask");
            this.f390022c.deleteTask(i3, true);
        }
        if (i3 == null) {
            try {
                this.f390022c.deleteTask(this.f390022c.createNewTask(downloadInfo.f390014e, downloadInfo.f390016h, downloadInfo.f390015f, this.f390023d), true);
                l.i("HalleyDownloaderProxy_", ">deleteTask succ");
            } catch (Throwable unused) {
                l.e("HalleyDownloaderProxy_", ">deleteTask error");
            }
        }
    }

    public static HalleyDownloaderProxy h() {
        if (f390019g == null) {
            synchronized (HalleyDownloaderProxy.class) {
                if (f390019g == null) {
                    f390019g = new HalleyDownloaderProxy();
                }
            }
        }
        return f390019g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        List<DownloadInfo> c16 = this.f390020a.c();
        if (c16 == null) {
            return;
        }
        try {
            Collections.sort(c16);
            for (DownloadInfo downloadInfo : c16) {
                d(downloadInfo);
                if (downloadInfo.M == 2) {
                    downloadInfo.M = 3;
                }
                q(downloadInfo);
            }
        } catch (Exception e16) {
            l.e("HalleyDownloaderProxy_", "initCache error:" + e16.getMessage());
        }
    }

    private void l() {
        final x a16 = x.b().a();
        m();
        a16.c("initHalleySDK finish");
        n();
        a16.c("initHalleyTasks finish");
        ThreadManagerV2.excute(new Runnable() { // from class: com.yolo.esports.download.common.HalleyDownloaderProxy.2
            @Override // java.lang.Runnable
            public void run() {
                a16.c("initCache start");
                HalleyDownloaderProxy.this.k();
                a16.c("initCache finish");
            }
        }, 32, null, true);
    }

    private void m() {
        HalleyAgent.init(BaseApplication.getContext(), "", "");
        Downloader downloader = HalleyAgent.getDownloader();
        this.f390022c = downloader;
        downloader.setTaskNumForCategory(DownloaderTaskCategory.Cate_DefaultMass, 3);
        this.f390022c.setNotNetworkWaitMillis(5000);
    }

    private void p() {
        boolean z16;
        int i3;
        for (DownloadInfo downloadInfo : new ArrayList(this.f390021b.f390029a.values())) {
            l.i("HalleyDownloaderProxy_", "restartCurrentTaskOnNetworkBack state=" + downloadInfo.M + ", errorCode = " + downloadInfo.H);
            int i16 = downloadInfo.M;
            boolean z17 = true;
            if (i16 == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && (i16 != 5 || ((i3 = downloadInfo.H) != -16 && i3 != -15 && i3 != -77))) {
                z17 = false;
            }
            if (z17) {
                l.i("HalleyDownloaderProxy_", "needRestart " + downloadInfo);
                s(downloadInfo, false);
            }
        }
    }

    private DownloaderTaskPriority t(int i3) {
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return DownloaderTaskPriority.NORMAL;
                }
                return DownloaderTaskPriority.URGENT;
            }
            return DownloaderTaskPriority.HIGH;
        }
        return DownloaderTaskPriority.LOW;
    }

    public boolean c(DownloadInfo downloadInfo) {
        l.b("HalleyDownloaderProxy_", "info=" + downloadInfo.hashCode() + ", " + downloadInfo);
        if (!this.f390021b.a(downloadInfo.s())) {
            this.f390021b.c(downloadInfo.s(), downloadInfo);
            return true;
        }
        if (this.f390021b.b(downloadInfo.s()) != downloadInfo) {
            this.f390021b.c(downloadInfo.s(), downloadInfo);
        }
        return false;
    }

    public DownloadInfo e(String str, boolean z16) {
        try {
            if (!TextUtils.isEmpty(str)) {
                DownloadInfo d16 = this.f390021b.d(str);
                if (d16 != null) {
                    this.f390020a.a(d16);
                    f(d16);
                    if (!TextUtils.isEmpty(d16.f390017i)) {
                        File file = new File(d16.f390017i);
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                    d16.M = 6;
                    d16.F = 0L;
                    d16.G = 0L;
                    if (z16) {
                        TaskCallbackCenter.f().l(d16.s(), d16);
                    }
                }
                return d16;
            }
            return null;
        } catch (Throwable th5) {
            l.f("HalleyDownloaderProxy_", "delete error", th5);
            return null;
        }
    }

    public DownloadInfo g(String str) {
        l.i("HalleyDownloaderProxy_", "[getDownloadInfo] = " + str);
        if (!TextUtils.isEmpty(str)) {
            DownloadInfo b16 = this.f390021b.b(str);
            d(b16);
            if (b16 != null && !b16.j()) {
                e(b16.f390013d, false);
            }
            return b16;
        }
        return null;
    }

    public DownloaderTask i(String str) {
        this.f390024e = this.f390022c.getAllTasks();
        l.i("HalleyDownloaderProxy_", "[getTaskFromHalleySDK] mAllHalleyTasks = " + this.f390024e);
        for (DownloaderTask downloaderTask : this.f390024e) {
            if (downloaderTask.getUrl().equals(str)) {
                return downloaderTask;
            }
        }
        return null;
    }

    public void j() {
        this.f390020a = d.b();
        this.f390023d = b.b();
        l();
    }

    public void o() {
        l.i("HalleyDownloaderProxy_", "networkConnected ");
        p();
    }

    public void q(final DownloadInfo downloadInfo) {
        l.i("HalleyDownloaderProxy_", "[saveDownloadInfo] = " + downloadInfo);
        if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.s())) {
            this.f390021b.c(downloadInfo.s(), downloadInfo);
            w.a(new Runnable() { // from class: com.yolo.esports.download.common.HalleyDownloaderProxy.3
                @Override // java.lang.Runnable
                public void run() {
                    HalleyDownloaderProxy.this.f390020a.d(downloadInfo);
                    downloadInfo.Q = System.currentTimeMillis();
                }
            });
        }
    }

    public void r(DownloadInfo downloadInfo) {
        if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.s())) {
            this.f390021b.c(downloadInfo.s(), downloadInfo);
        }
    }

    public int s(DownloadInfo downloadInfo, boolean z16) {
        try {
            l.i("HalleyDownloaderProxy_", "<startDownload> info:" + downloadInfo);
            if (d(downloadInfo)) {
                q(downloadInfo);
                TaskCallbackCenter.f().l(downloadInfo.s(), downloadInfo);
                return -102;
            }
            float a16 = (float) SpaceUtils.a(downloadInfo.f390016h);
            l.i("HalleyDownloaderProxy_", "[startDownload]rootDir=" + downloadInfo.f390016h + ",availableSpace=" + a16);
            float f16 = ((float) downloadInfo.f390018m) * 1.5f;
            if (a16 < 0.0f) {
                l.e("HalleyDownloaderProxy_", "[startDownload]ERROR: availableSpace < 0 \u53ef\u80fd\u4e0b\u8f7d\u5931\u8d25\uff0c\u5ffd\u7565\u672c\u6b21\u4e0b\u8f7d\u4efb\u52a1\uff0cinfo=" + downloadInfo);
            } else if (a16 < f16) {
                l.e("HalleyDownloaderProxy_", "[startDownload]ERROR: availableSpace < minRequestSpace \u53ef\u80fd\u4e0b\u8f7d\u5931\u8d25\uff0c\u5ffd\u7565\u672c\u6b21\u4e0b\u8f7d\u4efb\u52a1\uff0cinfo=" + downloadInfo);
            }
            if (TextUtils.isEmpty(downloadInfo.f390015f)) {
                downloadInfo.f390015f = i05.a.b(downloadInfo.f390014e);
            } else {
                downloadInfo.f390015f = i05.a.a(downloadInfo.f390015f);
            }
            if (z16) {
                l.i("HalleyDownloaderProxy_", ">startDownload onlyCreateInfo is true");
            } else {
                DownloaderTask i3 = i(downloadInfo.f390014e);
                l.i("HalleyDownloaderProxy_", "[startDownload] getTaskFromHalleySDK \uff1a" + i3);
                l.b("PERF_LOG", "NF.HalleyDownloader-Timi downloadUrl=" + downloadInfo.f390014e);
                if (i3 == null) {
                    String str = downloadInfo.f390015f;
                    if (!TextUtils.isEmpty(downloadInfo.U)) {
                        str = downloadInfo.f390015f + "." + downloadInfo.U;
                    }
                    DownloaderTask createNewTask = this.f390022c.createNewTask(downloadInfo.f390014e, downloadInfo.f390016h, str, this.f390023d);
                    createNewTask.setCategory(DownloaderTaskCategory.Cate_DefaultMass);
                    String s16 = downloadInfo.s();
                    createNewTask.setTag(s16);
                    l.i("HalleyDownloaderProxy_", "<startDownload>set tag:" + s16);
                    createNewTask.setPauseTaskOnMobile(downloadInfo.L);
                    createNewTask.setPriority(t(downloadInfo.J));
                    this.f390022c.addNewTask(createNewTask);
                } else {
                    i3.setPauseTaskOnMobile(downloadInfo.L);
                    i3.setPriority(t(downloadInfo.J));
                    i3.addListener(this.f390023d);
                    i3.resume();
                }
            }
            c(downloadInfo);
            q(downloadInfo);
            return 0;
        } catch (Throwable th5) {
            l.e("HalleyDownloaderProxy_", th5.getMessage());
            return -99;
        }
    }

    /* loaded from: classes28.dex */
    class a implements INetInfoHandler {
        a() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
            l.i("HalleyDownloaderProxy_", "onNetNone2Mobile " + str);
            HalleyDownloaderProxy.this.o();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
            l.i("HalleyDownloaderProxy_", "onNetNone2Wifi " + str);
            HalleyDownloaderProxy.this.o();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
        }
    }

    private void n() {
    }
}
