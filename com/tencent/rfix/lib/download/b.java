package com.tencent.rfix.lib.download;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rfix.lib.RFix;
import com.tencent.rfix.lib.config.PatchConfig;
import com.tencent.rfix.lib.event.DownloadEvent;
import com.tencent.rfix.lib.reporter.f;
import com.tencent.rfix.loader.entity.RFixPatchInfo;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.track.TimeTrackType;
import com.tencent.rfix.loader.track.TimeTracker;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Context f364967a;

    /* renamed from: b, reason: collision with root package name */
    private final ExecutorService f364968b;

    /* renamed from: c, reason: collision with root package name */
    private PatchConfig f364969c;

    /* renamed from: d, reason: collision with root package name */
    private int f364970d;

    public b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f364967a = context;
            this.f364968b = ProxyExecutors.newSingleThreadExecutor();
        }
    }

    @Override // com.tencent.rfix.lib.download.a
    public void a(PatchConfig patchConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) patchConfig);
            return;
        }
        RFixLog.d("RFix.PatchDownloader", String.format("downloadPatch config=%s", patchConfig));
        this.f364969c = patchConfig;
        this.f364970d = 0;
        this.f364968b.submit(new PatchDownloadTask(this.f364967a, patchConfig, this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(boolean z16, int i3, String str, PatchConfig patchConfig) {
        boolean z17;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, patchConfig);
            return;
        }
        if (patchConfig != this.f364969c) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            RFixLog.d("RFix.PatchDownloader", "onPatchDownload config changed, ignore this.");
            return;
        }
        if (!z16 && (i16 = this.f364970d) < 2) {
            int i17 = i16 + 1;
            this.f364970d = i17;
            RFixLog.d("RFix.PatchDownloader", String.format("onPatchDownload retry curRetryCount=%s", Integer.valueOf(i17)));
            this.f364968b.submit(new PatchDownloadTask(this.f364967a, patchConfig, this));
            return;
        }
        RFixPatchInfo rFixPatchInfo = new RFixPatchInfo(this.f364967a);
        rFixPatchInfo.lastDownloadResult = i3;
        rFixPatchInfo.saveStoreInfo();
        c(z16, i3, patchConfig);
        if (z16) {
            RFix.getInstance().getPatchEngine().b(str, patchConfig);
        }
        DownloadEvent downloadEvent = new DownloadEvent();
        downloadEvent.resultCode = i3;
        downloadEvent.filePath = str;
        downloadEvent.config = patchConfig;
        RFix.getInstance().getEventDispatcher().d(downloadEvent.isSuccess(), downloadEvent.resultCode, downloadEvent);
    }

    protected void c(boolean z16, int i3, PatchConfig patchConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), patchConfig);
        } else {
            f.h(this.f364967a, String.valueOf(patchConfig.configId), null, null, null, "Download", z16, String.valueOf(i3), null, TimeTracker.getTrackTimeMillis(TimeTrackType.PATCH_DOWNLOAD_TOTAL));
        }
    }
}
