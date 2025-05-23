package eu3;

import android.content.Context;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsListener;

/* compiled from: P */
/* loaded from: classes23.dex */
public class p implements TbsListener {

    /* renamed from: a */
    private Context f397165a;

    /* renamed from: c */
    private final Runnable f397167c = new Runnable() { // from class: eu3.k
        @Override // java.lang.Runnable
        public final void run() {
            p.this.h();
        }
    };

    /* renamed from: b */
    private Handler f397166b = ThreadManager.getUIHandler();

    public p(Context context) {
        this.f397165a = context;
    }

    public /* synthetic */ void g(boolean z16, int i3) {
        if (z16) {
            QMLog.i("Mini-X5Updater", "startDownload, version: " + i3);
            this.f397166b.postDelayed(this.f397167c, 15000L);
            QbSdk.setTbsListener(this);
            TbsDownloader.startDownload(this.f397165a, true);
            return;
        }
        this.f397166b.post(new l(this));
    }

    public /* synthetic */ void h() {
        TbsDownloader.needDownload(this.f397165a, false, true, true, new TbsDownloader.TbsDownloaderCallback() { // from class: eu3.m
            @Override // com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback
            public final void onNeedDownloadFinish(boolean z16, int i3) {
                p.this.i(z16, i3);
            }
        });
    }

    public /* synthetic */ void i(boolean z16, int i3) {
        if (z16) {
            this.f397166b.post(new Runnable() { // from class: eu3.n
                @Override // java.lang.Runnable
                public final void run() {
                    p.this.j();
                }
            });
        } else {
            this.f397166b.post(new l(this));
        }
    }

    public void j() {
        QMLog.i("Mini-X5Updater", "x5 update failed.");
    }

    public void k() {
        QMLog.i("Mini-X5Updater", "x5 already up to date.");
    }

    public void f() {
        QMLog.i("Mini-X5Updater", "checkUpdate");
        TbsDownloader.needDownload(this.f397165a, false, true, true, new TbsDownloader.TbsDownloaderCallback() { // from class: eu3.o
            @Override // com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback
            public final void onNeedDownloadFinish(boolean z16, int i3) {
                p.this.g(z16, i3);
            }
        });
    }

    @Override // com.tencent.smtt.sdk.TbsListener
    public void onDownloadFinish(int i3) {
        if (i3 == 100) {
            this.f397166b.removeCallbacks(this.f397167c);
            QMLog.i("Mini-X5Updater", "x5 has been downloaded");
        }
    }

    @Override // com.tencent.smtt.sdk.TbsListener
    public void onInstallFinish(int i3) {
        if (i3 == 200) {
            this.f397166b.removeCallbacks(this.f397167c);
            this.f397166b.post(new l(this));
        }
    }

    @Override // com.tencent.smtt.sdk.TbsListener
    public void onDownloadProgress(int i3) {
    }
}
